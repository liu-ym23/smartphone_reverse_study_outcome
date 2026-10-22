package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "halfFullSwitch")
public final class h0 extends com.bytedance.ies.web.jsbridge2.g<b, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridDialog f38657a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/h0$b;", "", "", "enableToFull", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setEnableToFull", "(I)V", "enableToHalf", "b", "setEnableToHalf", "showCloseIcon", "c", "setShowCloseIcon", "annie_release"}, k = 1, mv = {1, 4, 3})
    public final class b {

        @SerializedName("enable_to_full")
        private int enableToFull;

        @SerializedName("enable_to_half")
        private int enableToHalf;

        @SerializedName("show_close_icon")
        private int showCloseIcon;

        public final int a() {
            return this.enableToFull;
        }

        public final int b() {
            return this.enableToHalf;
        }

        public final int c() {
            return this.showCloseIcon;
        }
    }

    static {
    }

    public h0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridDialog r101 = (HybridDialog) r100.c(HybridDialog.class);
        if (r101 == null) goto L6;
        this.f38657a = r101;
        return;
    }

    public h0(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        this.f38657a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(b r100, CallContext r101) {
        b r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        HybridDialog r103 = this.f38657a;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L9:
        HybridDialog r105 = this.f38657a;
        if (r105 != null) goto L12;
    L16:
        HybridDialog r106 = this.f38657a;
        if (r106 != null) goto L19;
        return null;
    L19:
        if (r102.c() != 1) goto L21;
        r104 = true;
    L21:
        r106.Z90(r104);
        return null;
    L12:
        if (r102.a() != 1) goto L14;
        boolean r107 = true;
    L15:
        r105.V90(r107);
        goto L16
    L14:
        r107 = false;
        goto L15
    L5:
        if (r102.b() != 1) goto L7;
        boolean r108 = true;
    L8:
        r103.W90(r108);
        goto L9
    L7:
        r108 = false;
        goto L8
    }
}
