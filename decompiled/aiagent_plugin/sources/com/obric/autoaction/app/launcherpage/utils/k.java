package com.obric.autoaction.app.launcherpage.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: SemanticTaskIconHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    private static final String TAG = "SemanticTaskIconHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f24509a = null;

    /* JADX INFO: compiled from: SemanticTaskIconHelper.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("color_key")
        private final String f24510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("icon_key")
        private final String f24511b;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f24510a, r6.f24510a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f24511b, r6.f24511b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f24510a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f24511b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SemanticIconResult(colorKey=" + this.f24510a + ", iconKey=" + this.f24511b + ')';
        }

        public a(String r1, String r2) {
            this.f24510a = r1;
            this.f24511b = r2;
        }

        public /* synthetic */ a(String r2, String r3, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final String a() {
            return this.f24510a;
        }

        public final String b() {
            return this.f24511b;
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconHelper.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24513b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f24512a, r6.f24512a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f24513b, r6.f24513b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f24512a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f24513b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Spec(colorKey=" + this.f24512a + ", iconKey=" + this.f24513b + ')';
        }

        public b(String r1, String r2) {
            this.f24512a = r1;
            this.f24513b = r2;
        }

        public final String a() {
            return this.f24512a;
        }

        public final String b() {
            return this.f24513b;
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconHelper.kt */
    @d.c.b.a.f(b = "SemanticTaskIconHelper.kt", c = {74}, d = "requestExt", e = "com.obric.autoaction.app.launcherpage.utils.SemanticTaskIconHelper")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f24517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f24518e;
        int f;

        c(k r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24518e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24517d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f24518e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SemanticTaskIconHelper.kt */
    @d.c.b.a.f(b = "SemanticTaskIconHelper.kt", c = {199}, d = "requestSemanticIcon", e = "com.obric.autoaction.app.launcherpage.utils.SemanticTaskIconHelper")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f24519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f24520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24521c;

        d(k r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24520b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24519a = r3;
            this.f24521c |= Integer.MIN_VALUE;
            return k.a(this.f24520b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f24509a = new k();
    }

    private k() {
    }

    public static final /* synthetic */ Object a(k r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final b a(Map<String, String> r4) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        String r5 = null;
        if (r3 == null) goto L11;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_semantic_icon_color_key"), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L11;
    L12:
        if (r3 == null) goto L19;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_semantic_icon_key"), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L19;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        r5 = r6;
    L18:
        if (r5 == null) goto L19;
    L21:
        return new b(r1, r5);
    L19:
        r5 = "general";
    L11:
        r1 = "gray";
        goto L12
    }

    public static /* synthetic */ void a(k r1, ImageView r2, Map r3, boolean r4, int r5, Object r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r1.a(r2, r7, r4);
    }

    public final void a(ImageView r3, Map<String, String> r4, boolean r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "imageView");
        b r2 = a(r6);
        if (r5 == false) goto L5;
        Integer r7 = null;
    L6:
        com.obric.aiagent.assistant.common.ui.icon.d.a(r3, r2.b(), r2.a(), r7);
        return;
    L5:
        r7 = Integer.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_4, "color", "oui_text_4")));
        goto L6
    }

    public final Object a(String r8, Map<String, String> r9, d.c.d<? super Map<String, String>> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f24517d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (Map) ZeusTransformUtils.preCheckCast(r0.f24516c, Map.class, "com.obric.aiagent.plugin");
        r8 = (String) ZeusTransformUtils.preCheckCast(r0.f24515b, String.class, "com.obric.aiagent.plugin");
        k this = (k) ZeusTransformUtils.preCheckCast(r0.f24514a, k.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L17:
        a r14 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
        String r1 = null;
        if (r14 == null) goto L24;
        String r4 = r14.a();
        if (r4 == null) goto L24;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L24;
    L25:
        if (r14 == null) goto L32;
        String r5 = r14.b();
        if (r5 == null) goto L32;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L32;
        r1 = r5;
    L32:
        if (r4 == null) goto L40;
        if (r1 == null) goto L40;
        if (r11 != null) goto L38;
        r11 = ao.b();
    L38:
        LinkedHashMap r6 = new LinkedHashMap(r11);
        r6.put("o_semantic_icon_color_key", r4);
        r6.put("o_semantic_icon_key", r1);
        Loog.INSTANCE.i(TAG, "requestExt finish, " + this.a(r8) + ", semanticResult=" + this.a(r14) + ", ext=" + this.c((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")));
        return r6;
    L40:
        Loog.INSTANCE.i(TAG, "requestExt skip empty result, " + this.a(r8) + ", semanticResult=" + this.a(r14) + ", ext=" + this.c(r11));
        return r11;
    L24:
        r4 = null;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        Loog.INSTANCE.i(TAG, "requestExt start, " + a(r8) + ", oldExt=" + c(r11));
        r0.f24514a = this;
        r0.f24515b = r8;
        r0.f24516c = r11;
        r0.f = 1;
        r13 = a(r8, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new c(this, r12);
        goto L8
    }

    public final Object a(String r6, String r7, Map<String, String> r8, d.c.d<? super Map<String, String>> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super Map<String, String>> r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r6, r7) == true) goto L5;
    L8:
        Loog.INSTANCE.i(TAG, "requestExt query changed, old=" + a(r6) + ", current=" + a(r7) + ", oldExt=" + c(r10));
        return a(r7, r10, r11);
    L5:
        if (b(r10) == false) goto L8;
        Loog.INSTANCE.i(TAG, "requestExt reuse old ext, old=" + a(r6) + ", current=" + a(r7) + ", ext=" + c(r10));
        return r10;
    }

    public final boolean b(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r6 = null;
        if (r4 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_semantic_icon_color_key"), String.class, "com.obric.aiagent.plugin");
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L26;
        if (r4 == null) goto L16;
        r6 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_semantic_icon_key"), String.class, "com.obric.aiagent.plugin");
    L16:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L25;
        return false;
    L25:
        return true;
    L19:
        if (d.o.o.d(r7) == true) goto L22;
        r8 = false;
        goto L23
    L26:
        return false;
    L9:
        if (d.o.o.d(r2) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final Bitmap a(Context r24, Map<String, String> r25) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        b r4 = a(r3);
        Drawable r5 = androidx.appcompat.a.a.a.b(r1, com.obric.aiagent.assistant.common.ui.icon.d.b(r4.b()));
        if (r5 != null) goto L5;
        return null;
    L5:
        int r2 = d.l.n.c((int) (108 * ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getDisplayMetrics().density), 1);
        Bitmap r7 = Bitmap.createBitmap(r2, r2, Bitmap.Config.ARGB_8888);
        d.h.b.o.c(r7, "createBitmap(...)");
        Canvas r8 = new Canvas(r7);
        float r13 = r2;
        float r17 = r13 / 224.0f;
        int r15 = com.obric.aiagent.assistant.common.ui.icon.a.a(r4.a());
        RectF r6 = new RectF(0.0f, 0.0f, r13, r13);
        float r14 = r17 * 60.0f;
        Paint r12 = new Paint(1);
        r12.setColor(r15);
        r8.drawRoundRect(r6, r14, r14, r12);
        k r9 = f24509a;
        r12.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, 0.0f, 0.0f, r13, r9.a(r15, -1, 0.35f), r15, Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
        r8.drawRoundRect(r6, r14, r14, r12);
        int r10 = d.l.n.c((int) (152.0f * r17), 1);
        int r11 = (r2 - r10) / 2;
        int r16 = r10 + r11;
        Rect r18 = new Rect(r11, r11, r16, r16);
        Drawable r19 = r5.mutate();
        r19.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r19, "apply(...)");
        Bitmap r20 = androidx.core.graphics.drawable.b.a(r19, r18.width(), r18.height(), Bitmap.Config.ARGB_8888);
        int[] r21 = new int[2];
        Paint r22 = new Paint(1);
        float r23 = 9.52375f * r17;
        r22.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r23, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
        Bitmap r26 = r20.extractAlpha(r22, r21);
        d.h.b.o.c(r26, "extractAlpha(...)");
        a(r7, r26, r18.left + r21[0], (int) ((r18.top + r21[1]) + r23));
        Paint r0 = new Paint(1);
        r0.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, r18.top, 0.0f, r18.bottom, -1, r9.a(-1, 0.8f), Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
        int r27 = r8.saveLayer(r18.left, r18.top, r18.right, r18.bottom, null);
        r8.drawRect(new RectF(r18), r0);
        r0.setShader(null);
        r0.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.DST_IN), Xfermode.class, "com.obric.aiagent.plugin"));
        r8.drawBitmap(r20, null, r18, r0);
        r0.setXfermode(null);
        r8.restoreToCount(r27);
        return r7;
    }

    private final Object a(String r14, d.c.d<? super a> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r16, d.class, "com.obric.aiagent.plugin");
        if ((r0.f24521c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f24521c -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f24519a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f24521c;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        d.o.a(r17);     // Catch: Throwable -> L13
    L24:
        Object r13 = d.n.f((a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
    L27:
        Throwable r18 = d.n.c(r13);
        if (r18 == null) goto L34;
        if (ZeusTransformUtils.instanceOf(r18, CancellationException.class) == true) goto L32;
        Loog.INSTANCE.e(TAG, "requestSemanticIcon failed: " + r18.getMessage(), r18);
        goto L34
    L32:
        throw r18;
    L34:
        if (d.n.b(r13) == false) goto L37;
        return null;
    L37:
        return r13;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r17);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
        Loog.INSTANCE.i(TAG, "requestSemanticIcon skip blank query");
        return null;
    L21:
        d.n.a r19 = d.n.f38560a;     // Catch: Throwable -> L13
        k r110 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        com.obric.aiagent.llm.a r111 = new com.obric.aiagent.llm.a.C0392a("ocean.assistant.semantic_icon", null, null, 6, null).a();     // Catch: Throwable -> L13
        r0.f24521c = 1;     // Catch: Throwable -> L13
        r17 = r111.a(r14, a.class, r0);     // Catch: Throwable -> L13
        if (r17 != r2) goto L24;
        return r2;
    L13:
        th = move-exception;
        d.n.a r112 = d.n.f38560a;
        r13 = d.n.f(d.o.a(th));
    L7:
        r0 = new d(this, r16);
        goto L8
    }

    private final String a(String r2) {
        return "query=" + r2;
    }

    private final String c(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        StringBuilder r6 = new StringBuilder().append("color=");
        String r1 = null;
        if (r4 == null) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_semantic_icon_color_key"), String.class, "com.obric.aiagent.plugin");
    L6:
        StringBuilder r7 = r6.append(r2).append(", icon=");
        if (r4 == null) goto L9;
        r1 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_semantic_icon_key"), String.class, "com.obric.aiagent.plugin");
    L9:
        StringBuilder r8 = r7.append(r1).append(", size=");
        if (r4 == null) goto L12;
        int r9 = r4.size();
    L14:
        return r8.append(r9).toString();
    L12:
        r9 = 0;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    private final String a(a r3) {
        StringBuilder r2 = new StringBuilder().append("color=");
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.a();
    L6:
        StringBuilder r4 = r2.append(r1).append(", icon=");
        if (r3 == null) goto L10;
        r0 = r3.b();
    L10:
        return r4.append(r0).toString();
    L5:
        r1 = null;
        goto L6
    }

    private final int a(int r2, float r3) {
        return (16777215 & r2) | (d.l.n.a((int) (255 * r3), 0, 255) << 24);
    }

    private final int a(int r6, int r7, float r8) {
        float r9 = d.l.n.a(r8, 0.0f, 1.0f);
        return Color.argb(Color.alpha(r6), b(Color.red(r6), a(Color.red(r6), Color.red(r7)), r9), b(Color.green(r6), a(Color.green(r6), Color.green(r7)), r9), b(Color.blue(r6), a(Color.blue(r6), Color.blue(r7)), r9));
    }

    private final int a(int r3, int r4) {
        if (r3 >= 128) goto L6;
        return d.l.n.a(((r3 * 2) * r4) / 255, 0, 255);
    L6:
        return d.l.n.a(255 - ((((255 - r3) * 2) * (255 - r4)) / 255), 0, 255);
    }

    private final int b(int r1, int r2, float r3) {
        return d.l.n.a((int) (r1 + ((r2 - r1) * r3)), 0, 255);
    }

    private final void a(Bitmap r16, Bitmap r17, int r18, int r19) {
        int r1 = r17.getHeight();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L28;
        int r4 = r19 + r3;
        if (r4 >= 0) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L27;
        int r7 = r17.getWidth();
        int r8 = 0;
    L13:
        if (r8 >= r7) goto L27;
        int r9 = r18 + r8;
        if (r9 >= 0) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L26;
        int r11 = (int) (Color.alpha(r17.getPixel(r8, r3)) * 0.05f);
        if (r11 <= 0) goto L26;
        int r12 = r16.getPixel(r9, r4);
        r16.setPixel(r9, r4, Color.argb(Color.alpha(r12), d.l.n.c(Color.red(r12) - r11, 0), d.l.n.c(Color.green(r12) - r11, 0), d.l.n.c(Color.blue(r12) - r11, 0)));
    L26:
        r8 = r8 + 1;
        goto L13
    L17:
        if (r9 >= r16.getWidth()) goto L19;
        r10 = true;
    L27:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 >= r16.getHeight()) goto L9;
        r6 = true;
        goto L10
    }
}
