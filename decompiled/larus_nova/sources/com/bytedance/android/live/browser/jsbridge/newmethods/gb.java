package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastAlertModal")
public final class gb extends com.bytedance.ies.web.jsbridge2.f<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.c9 f63404a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/gb$b;", "", "", "base64Img", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setBase64Img", "(Ljava/lang/String;)V", "title", "e", com.alipay.sdk.m.x.d.f25925o, "message", "d", "setMessage", "confirmText", "c", "setConfirmText", "cancelText", "b", "setCancelText", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("img")
        private String base64Img;

        @SerializedName("cancelText")
        private String cancelText;

        @SerializedName("confirmText")
        private String confirmText;

        @SerializedName("message")
        private String message;

        @SerializedName("title")
        private String title;

        public b() {
        }

        public final String a() {
            return this.base64Img;
        }

        public final String b() {
            return this.cancelText;
        }

        public final String c() {
            return this.confirmText;
        }

        public final String d() {
            return this.message;
        }

        public final String e() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/gb$c;", "", "", "click", "Ljava/lang/String;", "getClick", "()Ljava/lang/String;", "setClick", "(Ljava/lang/String;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("clicked")
        private String click;

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.click = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        com.bytedance.android.livesdk.chatroom.ui.c9 r100 = this.f63404a;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f63404a = null;
    }

    public gb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b r100, CallContext r101) {
        b r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (TextUtils.isEmpty(r102.c()) == false) goto L5;
        int r103 = 1;
    L6:
        Context r104 = r101.getContext();
        com.bytedance.android.livesdk.chatroom.ui.c9.b r105 = new com.bytedance.android.livesdk.chatroom.ui.c9.b();
        r105.f112681a = r104;
        r105.f112682b = r103;
        r105.f112683c = R.layout.ttlive_dialog_room_center_jsb_layout;
        r105.f112696p = false;
        if (TextUtils.isEmpty(r102.a()) == false) goto L43;
        r105.f112684d = com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_ic_notice);
    L13:
        if (TextUtils.isEmpty(r102.e()) == true) goto L16;
        r105.f112685e = r102.e();
    L16:
        if (TextUtils.isEmpty(r102.d()) == true) goto L19;
        r105.f112686f = r102.d();
    L19:
        if (r103 != 1) goto L26;
        if (TextUtils.isEmpty(r102.b()) == false) goto L23;
        String r106 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_cancel);
    L24:
        hb r107 = new hb(this);
        r105.f112688h = r106;
        r105.f112689i = r107;
    L34:
        com.bytedance.android.livesdk.chatroom.ui.c9 r108 = new com.bytedance.android.livesdk.chatroom.ui.c9(r105.f112681a, r105);
        this.f63404a = r108;
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r108);
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L38:
        DialogLancet.beforeDialogShow(r108);
        r108.show();
        DialogLancet.afterDialogShow(r108);
        return;
    L23:
        r106 = r102.b();
        goto L24
    L26:
        if (TextUtils.isEmpty(r102.b()) == false) goto L28;
        String r109 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_cancel);
    L29:
        ib r110 = new ib(this);
        r105.f112690j = r109;
        r105.f112691k = r110;
        if (TextUtils.isEmpty(r102.c()) == false) goto L32;
        String r111 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_ok);
    L33:
        jb r112 = new jb(this);
        r105.f112692l = r111;
        r105.f112693m = r112;
        r105.f112699s = R.style.ttlive_live_notice_dialog_confirm_button;
        goto L34
    L32:
        r111 = r102.c();
        goto L33
    L28:
        r109 = r102.b();
        goto L29
    L43:
        byte[] r113 = Base64.decode(r102.a(), 0);     // Catch: Exception -> L10
        Bitmap r114 = BitmapFactory.decodeByteArray(r113, 0, r113.length);     // Catch: Exception -> L10
        r105.f112684d = new BitmapDrawable(r101.getContext().getResources(), r114);     // Catch: Exception -> L10
    L10:
        r105.f112684d = null;
        goto L13
    L5:
        r103 = 2;
        goto L6
    }
}
