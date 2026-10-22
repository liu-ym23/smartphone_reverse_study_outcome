package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "dialog")
public final class DialogMethod extends com.bytedance.ies.web.jsbridge2.f<a, b> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/DialogMethod$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "title", com.amap.api.col.s.ce.f26391f, "text", "f", "leftButtonText", "b", "leftButtonTextColor", "c", "rightButtonText", "d", "rightButtonTextColor", "e", "", "cornerRadius", "Ljava/lang/Float;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Float;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("corner_radius")
        private final Float cornerRadius;

        @SerializedName("left_button_text")
        private final String leftButtonText;

        @SerializedName("left_button_text_color")
        private final String leftButtonTextColor;

        @SerializedName("right_button_text")
        private final String rightButtonText;

        @SerializedName("right_button_text_color")
        private final String rightButtonTextColor;

        @SerializedName("text")
        private final String text;

        @SerializedName("title")
        private final String title;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L22;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.leftButtonText, r101.leftButtonText) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.leftButtonTextColor, r101.leftButtonTextColor) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.rightButtonText, r101.rightButtonText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.rightButtonTextColor, r101.rightButtonTextColor) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.cornerRadius, r101.cornerRadius) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.title;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.text;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.leftButtonText;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.leftButtonTextColor;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.rightButtonText;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.rightButtonTextColor;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            Float r122 = this.cornerRadius;
            if (r122 == null) goto L34;
            r101 = r122.hashCode();
        L34:
            return r121 + r101;
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", title=" + this.title + ", text=" + this.text + ", leftButtonText=" + this.leftButtonText + ", leftButtonTextColor=" + this.leftButtonTextColor + ", rightButtonText=" + this.rightButtonText + ", rightButtonTextColor=" + this.rightButtonTextColor + ", cornerRadius=" + this.cornerRadius + ")";
        }

        public final Float a() {
            return this.cornerRadius;
        }

        public final String b() {
            return this.leftButtonText;
        }

        public final String c() {
            return this.leftButtonTextColor;
        }

        public final String d() {
            return this.rightButtonText;
        }

        public final String e() {
            return this.rightButtonTextColor;
        }

        public final String f() {
            return this.text;
        }

        public final String g() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/DialogMethod$b;", "", "", "code", "I", "getCode", "()I", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("action")
        private final String action;

        @SerializedName("code")
        private final int code;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.code == r101.code) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.action, r101.action) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.code * 31;
            String r101 = this.action;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Result(code=" + this.code + ", action=" + this.action + ")";
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.code = 1;
            this.action = r100;
        }
    }

    public final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f63237a;

        public c(Function2 r100) {
            this.f63237a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final /* synthetic */ void onClick(DialogInterface r100, int r101) {
            this.f63237a.invoke(r100, Integer.valueOf(r101));
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public DialogMethod() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();     // Catch: Throwable -> L11
        if (r103.hashCode() == 951117504) goto L7;
    L9:
        finishWithFailure();     // Catch: Throwable -> L11
    L14:
        return;
    L7:
        if (r103.equals("confirm") == false) goto L9;
        k(r102, r101.getContext());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        finishWithFailure(th);
        com.bytedance.android.livesdk.log.b0 r104 = com.bytedance.android.livesdk.log.b0.o();
        StackTraceElement[] r105 = th.getStackTrace();
        r104.getClass();
        com.bytedance.android.live.core.log.g.m(5, r105);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.android.live.browser.jsbridge.newmethods.DialogMethod$showConfirmDialog$dismissFunc$1] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, com.bytedance.android.live.browser.jsbridge.newmethods.DialogMethod$showConfirmDialog$1] */
    public final void k(final a r100, Context r101) {
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = DialogMethod$showConfirmDialog$dismissFunc$1.INSTANCE;
        if (com.bytedance.android.livesdk.h5.f132627a.getValue().booleanValue() == true) goto L5;
    L7:
        com.bytedance.android.livesdk.widget.x0.b r103 = new com.bytedance.android.livesdk.widget.x0.b(r101, 4);
        String r104 = r100.g();
        if (r104 == null) goto L10;
        r103.f162238a.f162244c = r104;
    L10:
        String r105 = r100.f();
        if (r105 == null) goto L13;
        r103.f162238a.f162245d = r105;
    L13:
        Float r106 = r100.a();
        if (r106 == null) goto L16;
        r103.setCornerRadius(r106.floatValue());
    L16:
        r103.f162238a.f162252k = false;
        j(r103, 0, r100.d(), r100.e(), new DialogMethod$showConfirmDialog$$inlined$apply$lambda$1(this, r100, r102));
        j(r103, 1, r100.b(), r100.c(), new DialogMethod$showConfirmDialog$$inlined$apply$lambda$2(this, r100, r102));
        final com.bytedance.android.livesdk.widget.x0 r107 = r103.n();
        r102.element = new DialogMethod$showConfirmDialog$1(r107);
        return;
    L5:
        if ((r101 instanceof Activity) == true) goto L7;
        r101 = com.bytedance.android.live.core.utils.a.d();
        goto L7
    }

    public static void j(com.bytedance.android.livesdk.widget.x0.b r100, int r101, String r102, String r103, Function2 r104) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L14;
        SpannableString r106 = new SpannableString(r102);
        if (r103 == null) goto L11;
        r106.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(r103)), 0, r106.length(), 33);
    L11:
        r100.j(r101, r106, new c(r104));
        return;
    L14:
        return;
    L6:
        r105 = false;
        goto L7
    }
}
