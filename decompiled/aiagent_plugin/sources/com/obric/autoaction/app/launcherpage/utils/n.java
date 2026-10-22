package com.obric.autoaction.app.launcherpage.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TextToBitMapUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f24525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24526e;
    private final float f;
    private final float g;
    private final int h;
    private final Integer i;
    private final int j;
    private final float k;

    /* JADX INFO: compiled from: TextToBitMapUtil.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ Bitmap a(a r0, n r1) {
            return r0.a(r1);
        }

        private final Bitmap a(n r19) {
            Paint r0 = new Paint(193);
            r0.setTextSize(r19.b() * r19.d());
            r0.setColor(r19.c());
            r0.setTypeface(Typeface.DEFAULT);
            r0.setFakeBoldText(true);
            r0.setSubpixelText(true);
            r0.setTextAlign(Paint.Align.LEFT);
            List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            int r3 = 0;
            int r5 = 0;
        L4:
            if (r5 >= r19.a().length()) goto L12;
            int r6 = Math.min(r19.h() + r5, r19.a().length());
            if ((r6 - r5) == 1) goto L8;
        L10:
            r2.add(l.a(r19.a(), r5, r6));
        L11:
            r5 = r6;
            goto L4
        L8:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L10;
            r2.add(((String) ZeusTransformUtils.preCheckCast(d.a.p.g(r2), String.class, "com.obric.aiagent.plugin")) + d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r19.a(), CharSequence.class, "com.obric.aiagent.plugin")));
            goto L11
        L12:
            Paint.FontMetrics r7 = r0.getFontMetrics();
            float r8 = r7.descent - r7.ascent;
            float r9 = (r19.i() - 1) * r8;
            float r10 = (r2.size() * r8) + ((r2.size() - 1) * r9);
            List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            float r13 = 0.0f;
        L14:
            if (r12.hasNext() == false) goto L16;
            float r14 = r0.measureText((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin"));
            r11.add(Float.valueOf(r14));
            r13 = Math.max(r13, r14);
            goto L14
        L16:
            List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L18:
            if (r16.hasNext() == false) goto L20;
            r15.add(Float.valueOf((r13 - ((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.aiagent.plugin")).floatValue()) / 2));
            goto L18
        L20:
            float r17 = Math.max(r13, r10);
            float r18 = 2;
            float r110 = Math.max((r10 - r13) / r18, 0.0f);
            float r20 = Math.max((r13 - r10) / r18, 0.0f);
            Bitmap r21 = Bitmap.createBitmap((int) ((r19.e() * r19.d()) + r17), (int) (r17 + (r19.e() * r19.d())), Bitmap.Config.ARGB_8888);
            d.h.b.o.c(r21, "createBitmap(...)");
            if (r19.g() == null) goto L25;
            Drawable r111 = androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r19.g().intValue());
            if (r111 == null) goto L25;
            Bitmap r112 = com.obric.oui.common.util.c.a(r111);
        L26:
            Canvas r113 = new Canvas(r21);
            if (r112 == null) goto L29;
            int r1 = r113.save();
            r113.drawBitmap(r112, null, new Rect(0, 0, r113.getWidth(), r113.getHeight()), null);
            r113.restoreToCount(r1);
        L30:
            r113.setDensity(0);
            float r22 = (r20 + ((r19.d() * r19.e()) / r18)) - r7.ascent;
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L32:
            if (r4.hasNext() == false) goto L38;
            Object r23 = r4.next();
            int r24 = r3 + 1;
            if (r3 >= 0) goto L36;
            d.a.p.c();
        L36:
            r113.drawText((String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.aiagent.plugin"), (((Number) ZeusTransformUtils.preCheckCast(r15.get(r3), Number.class, "com.obric.aiagent.plugin")).floatValue() + r110) + ((r19.d() * r19.e()) / r18), r22, r0);
            r22 = r22 + (r8 + r9);
            r3 = r24;
            goto L32
        L38:
            if (r19.d() <= 1.0f) goto L41;
            Bitmap r25 = Bitmap.createScaledBitmap(r21, (int) (r21.getWidth() / r19.d()), (int) (r21.getHeight() / r19.d()), true);
            d.h.b.o.a(r25);
            return r25;
        L41:
            return r21;
        L29:
            r113.drawColor(r19.f());
        L25:
            r112 = null;
            goto L26
        }
    }

    static {
        f24522a = new a(null);
    }

    public n(Context r3, String r4, float r5, int r6, float r7, float r8, int r9, Integer r10, int r11, float r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        d.h.b.o.e(r4, "text");
        this.f24523b = ZeusTransformUtils.wrapperContext(r13, "com.obric.aiagent.plugin");
        this.f24524c = r4;
        this.f24525d = r5;
        this.f24526e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public /* synthetic */ n(Context r14, String r15, float r16, int r17, float r18, float r19, int r20, Integer r21, int r22, float r23, int r24, d.h.b.h r25) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        if ((r24 & 4) == 0) goto L5;
        float r5 = 80.0f;
    L7:
        if ((r24 & 8) == 0) goto L9;
        int r6 = -16777216;
    L11:
        if ((r24 & 16) == 0) goto L13;
        float r7 = 4.0f;
    L15:
        if ((r24 & 32) == 0) goto L17;
        float r8 = 60.0f;
    L19:
        if ((r24 & 64) == 0) goto L21;
        int r9 = -16711936;
    L23:
        if ((r24 & 128) == 0) goto L25;
        Integer r10 = null;
    L27:
        if ((r24 & 256) == 0) goto L29;
        int r11 = 2;
    L31:
        if ((r24 & 512) == 0) goto L33;
        float r12 = 1.0f;
    L34:
        this(r3, r15, r5, r6, r7, r8, r9, r10, r11, r12);
        return;
    L33:
        r12 = r23;
        goto L34
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    public final Context getContext() {
        return this.f24523b;
    }

    public final String a() {
        return this.f24524c;
    }

    public final float b() {
        return this.f24525d;
    }

    public final int c() {
        return this.f24526e;
    }

    public final float d() {
        return this.f;
    }

    public final float e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final Integer g() {
        return this.i;
    }

    public final int h() {
        return this.j;
    }

    public final float i() {
        return this.k;
    }

    public final Bitmap j() {
        return a.a(f24522a, this);
    }
}
