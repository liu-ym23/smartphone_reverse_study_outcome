package com.obric.oui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OImageStyleHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "OImageStyleHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.oui.image.a f35294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f35295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f35296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f35297e;
    private boolean f;

    /* JADX INFO: compiled from: OImageStyleHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ b a(a r1, Context r2, AttributeSet r3, int r4, int r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
            if ((r6 & 4) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = 0;
        L9:
            return r1.a(r8, r9, r4, r5);
        }

        public final b a(Context r16, AttributeSet r17, int r18, int r19) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            n.a r6 = n.f38560a;     // Catch: Throwable -> L22
            a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
            if (r5 != null) goto L6;
            b r0 = new b(null, false, null, null, false, 31, null);     // Catch: Throwable -> L22
        L18:
            Object r1 = n.f(r0);     // Catch: Throwable -> L22
        L24:
            Throwable r2 = n.c(r1);
            if (r2 == null) goto L29;
            a(b.TAG, "Failed to parse OImage attrs, fallback to defaults", r2);
            r1 = new b(null, false, null, null, false, 31, null);
        L29:
            return (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        L6:
            TypedArray r8 = r3.obtainStyledAttributes(r5, R.styleable.OImage, r18, r19);     // Catch: Throwable -> L22
            int r9 = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageShape, "styleable", "OImage_oui_imageShape"), com.obric.oui.image.a.f35289b.a());     // Catch: Throwable -> L19
            com.obric.oui.image.a r10 = com.obric.oui.image.a.f35288a.a(r9);     // Catch: Throwable -> L19
            boolean r11 = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageStrokeEnabled, "styleable", "OImage_oui_imageStrokeEnabled"), true);     // Catch: Throwable -> L19
            if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageBackgroundColor, "styleable", "OImage_oui_imageBackgroundColor")) == false) goto L10;
            Integer r4 = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageBackgroundColor, "styleable", "OImage_oui_imageBackgroundColor"), 0));     // Catch: Throwable -> L19
        L11:
            Integer r12 = r4;
            if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageStrokeColor, "styleable", "OImage_oui_imageStrokeColor")) == false) goto L15;
            int r13 = r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageStrokeColor, "styleable", "OImage_oui_imageStrokeColor"), androidx.core.content.a.c(r3, ZeusTransformUtils.mapRes(R.color.oui_line_1, "color", "oui_line_1")));     // Catch: Throwable -> L19
        L16:
            b r14 = new b(r10, r11, r12, Integer.valueOf(r13), r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_clipToMask, "styleable", "OImage_oui_clipToMask"), false));     // Catch: Throwable -> L19
            r8.recycle();     // Catch: Throwable -> L22
            r0 = r14;
            goto L18
        L15:
            r13 = androidx.core.content.a.c(r3, ZeusTransformUtils.mapRes(R.color.oui_line_1, "color", "oui_line_1"));     // Catch: Throwable -> L19
            goto L16
        L10:
            r4 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r8.recycle();     // Catch: Throwable -> L22
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            n.a r15 = n.f38560a;
            r1 = n.f(d.o.a(th));
            goto L24
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }
    }

    static {
        f35293a = new a(null);
    }

    public b() {
        this(null, false, null, null, false, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f35294b == r6.f35294b) goto L12;
        return false;
    L12:
        if (this.f35295c == r6.f35295c) goto L15;
        return false;
    L15:
        if (o.a(this.f35296d, r6.f35296d) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f35297e, r6.f35297e) == true) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.f35294b.hashCode() * 31;
        boolean r1 = this.f35295c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.f35296d;
        int r6 = 0;
        if (r5 != null) goto L8;
        int r7 = 0;
    L9:
        int r8 = (r4 + r7) * 31;
        Integer r9 = this.f35297e;
        if (r9 == null) goto L13;
        r6 = r9.hashCode();
    L13:
        int r10 = (r8 + r6) * 31;
        boolean r11 = this.f;
        if (r11 == true) goto L18;
        r2 = r11;
    L18:
        return r10 + r2;
    L8:
        r7 = r5.hashCode();
        goto L9
    }

    public String toString() {
        return "OImageStyleConfig(shape=" + this.f35294b + ", strokeEnabled=" + this.f35295c + ", backgroundColor=" + this.f35296d + ", strokeColor=" + this.f35297e + ", clipToMask=" + this.f + ')';
    }

    public b(com.obric.oui.image.a r2, boolean r3, Integer r4, Integer r5, boolean r6) {
        o.e(r2, "shape");
        this.f35294b = r2;
        this.f35295c = r3;
        this.f35296d = r4;
        this.f35297e = r5;
        this.f = r6;
    }

    public /* synthetic */ b(com.obric.oui.image.a r4, boolean r5, Integer r6, Integer r7, boolean r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = com.obric.oui.image.a.f35289b;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = true;
    L8:
        boolean r11 = r5;
        Integer r0 = null;
        if ((r9 & 4) == 0) goto L11;
        Integer r1 = null;
    L13:
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = false;
    L19:
        this(r4, r11, r1, r0, r8);
        return;
    L11:
        r1 = r6;
        goto L13
    }

    public final com.obric.oui.image.a a() {
        return this.f35294b;
    }

    public final boolean b() {
        return this.f35295c;
    }

    public final void a(Integer r1) {
        this.f35296d = r1;
    }

    public final Integer c() {
        return this.f35296d;
    }

    public final void b(Integer r1) {
        this.f35297e = r1;
    }

    public final Integer d() {
        return this.f35297e;
    }

    public final void a(boolean r1) {
        this.f = r1;
    }

    public final boolean e() {
        return this.f;
    }
}
