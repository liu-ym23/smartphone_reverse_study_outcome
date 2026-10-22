package com.android.server.wm;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.server.notification.NotificationShellCmd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DisplayAreaPolicy {
    static final boolean USE_DISPLAY_AREA_FOR_FULLSCREEN_MAGNIFICATION = false;
    protected final RootDisplayArea mRoot;
    protected final WindowManagerService mWmService;

    static final class DefaultProvider implements Provider {
        DefaultProvider() {
        }

        @Override // com.android.server.wm.DisplayAreaPolicy.Provider
        public DisplayAreaPolicy instantiate(WindowManagerService wmService, DisplayContent content, RootDisplayArea root, DisplayArea.Tokens imeContainer) {
            TaskDisplayArea defaultTaskDisplayArea = new TaskDisplayArea(content, wmService, "DefaultTaskDisplayArea", 1);
            List<TaskDisplayArea> tdaList = new ArrayList();
            tdaList.add(defaultTaskDisplayArea);
            DisplayAreaPolicyBuilder.HierarchyBuilder rootHierarchy = new DisplayAreaPolicyBuilder.HierarchyBuilder(root);
            rootHierarchy.setImeContainer(imeContainer).setTaskDisplayAreas(tdaList);
            if (content.isTrusted() == false) goto L6;
            configureTrustedHierarchyBuilder(rootHierarchy, wmService, content);
        L6:
            return new DisplayAreaPolicyBuilder().setRootHierarchy(rootHierarchy).build(wmService);
        }

        private void configureTrustedHierarchyBuilder(DisplayAreaPolicyBuilder.HierarchyBuilder rootHierarchy, WindowManagerService wmService, DisplayContent content) {
            rootHierarchy.addFeature(new DisplayAreaPolicyBuilder.Feature.Builder(wmService.mPolicy, "WindowedMagnification", 4).upTo(2039).except(new int[]{2039}).setNewDisplayAreaSupplier(new DisplayAreaPolicy$DefaultProvider$$ExternalSyntheticLambda0()).build());
            if (content.isDefaultDisplay == false) goto L5;
            rootHierarchy.addFeature(new DisplayAreaPolicyBuilder.Feature.Builder(wmService.mPolicy, "HideDisplayCutout", 6).all().except(new int[]{2019, 2024, 2000, 2040}).build()).addFeature(new DisplayAreaPolicyBuilder.Feature.Builder(wmService.mPolicy, "OneHanded", 3).all().except(new int[]{2019, 2024, 2015}).build()).addFeature(new DisplayAreaPolicyBuilder.Feature.Builder(wmService.mPolicy, "AppZoomOut", 10).all().except(new int[]{2019, 2024, 2000, 2040, 2009, 2013, NotificationShellCmd.NOTIFICATION_ID}).build());
        L5:
            rootHierarchy.addFeature(new DisplayAreaPolicyBuilder.Feature.Builder(wmService.mPolicy, "ImePlaceholder", 7).and(new int[]{2011, 2012}).build());
        }
    }

    public interface Provider {
        DisplayAreaPolicy instantiate(WindowManagerService r1, DisplayContent r2, RootDisplayArea r3, DisplayArea.Tokens r4);

        static Provider fromResources(Resources res) {
            String name = res.getString(R.string.config_misprovisionedDeviceModel);
            if (TextUtils.isEmpty(name) == true) goto L5;
            return (Provider) Class.forName(name).newInstance();
        L8:
            e = move-exception;
            throw new IllegalStateException("Couldn't instantiate class " + name + " for config_deviceSpecificDisplayAreaPolicyProvider: make sure it has a public zero-argument constructor and implements DisplayAreaPolicy.Provider", e);
        L5:
            return new DefaultProvider();
        }
    }

    public abstract void addWindow(WindowToken r1);

    public abstract DisplayArea.Tokens findAreaForWindowType(int r1, Bundle r2, boolean r3, boolean r4);

    public abstract TaskDisplayArea getDefaultTaskDisplayArea();

    public abstract List<DisplayArea<? extends WindowContainer>> getDisplayAreas(int r1);

    public abstract TaskDisplayArea getTaskDisplayArea(Bundle r1);

    public abstract DisplayArea<? extends WindowContainer> getWindowingArea();

    protected DisplayAreaPolicy(WindowManagerService wmService, RootDisplayArea root) {
        this.mWmService = wmService;
        this.mRoot = root;
    }
}
