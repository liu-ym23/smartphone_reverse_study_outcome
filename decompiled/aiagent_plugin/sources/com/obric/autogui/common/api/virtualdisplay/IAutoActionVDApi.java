package com.obric.autogui.common.api.virtualdisplay;

import android.content.ComponentName;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.d;
import com.obric.autogui.common.e;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: IAutoActionVDApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionVDApi {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IAutoActionVDApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Set<String> mNotTrackingApp = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            mNotTrackingApp = ax.a(new String[]{"com.android.launcher3", "com.miui.home", IslandImpl.LIVE_CARD_HOST});
        }

        public final boolean isWaivedTrackingPackage(String r1) {
            if (r1 != null) goto L6;
            return true;
        L6:
            return mNotTrackingApp.contains(r1);
        }
    }

    /* JADX INFO: compiled from: IAutoActionVDApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Collection fetchMdTopAppInfo$default(IAutoActionVDApi r2, int r3, boolean r4, int r5, Object r6) {
            IAutoActionVDApi r7 = (IAutoActionVDApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionVDApi.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = 2;
        L8:
            if ((r5 & 2) == 0) goto L11;
            r4 = true;
        L11:
            return r7.fetchMdTopAppInfo(r3, r4);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchMdTopAppInfo");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    e bringMdAppToVd(int r1);

    e bringTaskToMdFront(int r1);

    Collection<DisplayedAppInfo> fetchMdTopAppInfo(int r1, boolean r2);

    DisplayedAppInfo fetchVdTopAppInfo();

    d<ComponentName> getMDTopComponent();

    int getOperatingDisplayId();

    d<VDTrackingApp> getVdOperatingApp();

    d<ComponentName> getVdTopComponent();

    boolean isAppVisibleInMd(String r1);

    e openAppInVd(String r1);
}
