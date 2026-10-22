package com.obric.autogui.common.api.platform.system;

import android.view.WindowManager;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: IAutoActionSystemApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionSystemApi {

    /* JADX INFO: compiled from: IAutoActionSystemApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object dumpViewHierarchy$default(IAutoActionSystemApi r2, int r3, boolean r4, d r5, int r6, Object r7) {
            IAutoActionSystemApi r8 = (IAutoActionSystemApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionSystemApi.class, "com.obric.aiagent.plugin");
            d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = true;
        L8:
            return r8.dumpViewHierarchy(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dumpViewHierarchy");
        }
    }

    Object dumpViewHierarchy(int r1, boolean r2, d<? super com.obric.autogui.common.d<List<ViewHierarchyDump>>> r3);

    String getRomKeyType();

    String getSystemVersion();

    IAutoActionThermalStateApi getThermalManager();

    boolean isSupported();

    boolean isSystemDebuggable();

    void setTrustedOverlay(WindowManager.LayoutParams r1);
}
