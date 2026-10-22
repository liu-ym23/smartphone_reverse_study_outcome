package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setLive")
public final class f2 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridDialog f38655a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/f2$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "args", "Lcom/bytedance/android/annie/bridge/method/f2$a$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "setArgs", "(Lcom/bytedance/android/annie/bridge/method/f2$a$a;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("args")
        private C0726a args;

        @SerializedName("type")
        private String type;

        /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.f2$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "", "", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "width", "I", "e", "()I", "setWidth", "(I)V", "height", "b", "setHeight", "radius", "c", "setRadius", "closeByMask", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCloseByMask", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final class C0726a {

            @SerializedName("close_by_mask")
            private int closeByMask;

            @SerializedName("height")
            private int height;

            @SerializedName("radius")
            private int radius;

            @SerializedName("url")
            private String url;

            @SerializedName("width")
            private int width;

            public C0726a() {
            }

            public final int a() {
                return this.closeByMask;
            }

            public final int b() {
                return this.height;
            }

            public final int c() {
                return this.radius;
            }

            public final String d() {
                return this.url;
            }

            public final int e() {
                return this.width;
            }
        }

        public a() {
        }

        public final C0726a a() {
            return this.args;
        }

        public final String getType() {
            return this.type;
        }
    }

    public f2(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridDialog r101 = (HybridDialog) r100.c(HybridDialog.class);
        if (r101 == null) goto L6;
        this.f38655a = r101;
        return;
    }

    public f2(HybridDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        this.f38655a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r110, CallContext r111) {
        a r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r113 = r112.getType();
        if (Intrinsics.areEqual(r113, AppConstants.HOST_WEBVIEW_DIALOG) == false) goto L13;
        a.C0726a r114 = r112.a();
        if (r114 == null) goto L23;
        HybridDialog r115 = this.f38655a;
        if ((r115 instanceof BaseDialogFragment) == false) goto L9;
        BaseDialogFragment r100 = (BaseDialogFragment) r115;
    L10:
        if (r100 == null) goto L23;
        r100.la0(r114.d(), r114.e(), r114.b(), r114.c(), r114.a(), BaseHybridParamVoNew.HybridType.H5);
        goto L23
    L9:
        r100 = null;
    L23:
        return null;
    L13:
        if (Intrinsics.areEqual(r113, "lynxview_popup") == false) goto L22;
        a.C0726a r116 = r112.a();
        if (r116 == null) goto L23;
        HybridDialog r117 = this.f38655a;
        if ((r117 instanceof BaseDialogFragment) == false) goto L19;
        BaseDialogFragment r101 = (BaseDialogFragment) r117;
    L20:
        if (r101 == null) goto L23;
        r101.la0(r116.d(), r116.e(), r116.b(), r116.c(), r116.a(), BaseHybridParamVoNew.HybridType.LYNX);
        goto L23
    L19:
        r101 = null;
        goto L20
    L22:
        terminate();
        goto L23
    }
}
