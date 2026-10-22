package com.bytedance.android.monitorV2.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/e;", "", "", "enableVirtualAid", "Z", "d", "()Z", "setEnableVirtualAid", "(Z)V", "enableHandlePerfMix", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableHandlePerfMix", "enableKernelBlankLog", "b", "setEnableKernelBlankLog", "enableLynxNavigationFix", "c", "setEnableLynxNavigationFix", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("is_enable_handle_perfmix")
    private boolean enableHandlePerfMix;

    @SerializedName("is_enable_kernel_blank_log")
    private boolean enableKernelBlankLog;

    @SerializedName("is_enable_lynx_navigation_fix")
    private boolean enableLynxNavigationFix;

    @SerializedName("is_enable_virtual_aid")
    private boolean enableVirtualAid;

    public static final class a {
    }

    static {
        new e();
    }

    public e() {
        this.enableVirtualAid = true;
        this.enableHandlePerfMix = true;
        this.enableKernelBlankLog = true;
        this.enableLynxNavigationFix = true;
    }

    public final boolean a() {
        return this.enableHandlePerfMix;
    }

    public final boolean b() {
        return this.enableKernelBlankLog;
    }

    public final boolean c() {
        return this.enableLynxNavigationFix;
    }

    public final boolean d() {
        return this.enableVirtualAid;
    }
}
