package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "dialogPullDownClose")
public final class q1 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridDialog f38795a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/q1$a;", "", "", "pullDownClose", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setPullDownClose", "(I)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName(AppConstants.BUNDLE_PULL_DOWN_CLOSE)
        private int pullDownClose;

        public a() {
        }

        public final int a() {
            return this.pullDownClose;
        }
    }

    public q1(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridDialog r101 = (HybridDialog) r100.c(HybridDialog.class);
        if (r101 == null) goto L6;
        this.f38795a = r101;
        return;
    }

    public q1(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        this.f38795a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        HybridDialog r103 = this.f38795a;
        if (r103 == null) goto L11;
        boolean r104 = true;
        if (r102.a() == 1) goto L8;
        r104 = false;
    L8:
        r103.Y90(r104);
        return null;
    L11:
        return null;
    }
}
