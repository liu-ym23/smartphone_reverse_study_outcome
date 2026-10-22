package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAvatarQueueViewV2WithClip extends View {
    private com.obric.oui.avatar.a inParam;
    private List<Bitmap> mAvatarBitmapQueue;
    private final Paint mPaint;

    /* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33995a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f34001b.ordinal()] = 1;
            r0[b.f34000a.ordinal()] = 2;
            f33995a = r0;
        }
    }

    public OAvatarQueueViewV2WithClip(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "ctx");
        this(r1, null, 0, 6, null);
    }

    public OAvatarQueueViewV2WithClip(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "ctx");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OAvatarQueueViewV2WithClip(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OAvatarQueueViewV2WithClip(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "ctx");
        super(r6, r7, r5);
        Paint r8 = new Paint();
        r8.setAntiAlias(true);
        this.mPaint = r8;
        this.mAvatarBitmapQueue = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public void init(com.obric.oui.avatar.a r9) {
        o.e(r9, AutoTestConstant.PARAM);
        this.inParam = r9;
        if (r9 != null) goto L6;
        o.c("inParam");
        r9 = null;
    L6:
        if (r9.c().isEmpty() == false) goto L8;
        return;
    L8:
        recycleAvatarQueueBitmap();
        int r10 = 0;
        com.obric.oui.avatar.a r2 = this.inParam;
        if (r2 != null) goto L11;
        o.c("inParam");
        r2 = null;
    L11:
        int r3 = r2.c().size();
    L12:
        if (r10 >= r3) goto L33;
        int r4 = r10 + 1;
        if (r10 != 0) goto L22;
        List<Bitmap> r6 = this.mAvatarBitmapQueue;
        com.obric.oui.avatar.a r7 = this.inParam;
        if (r7 != null) goto L18;
        o.c("inParam");
        r7 = null;
    L18:
        Bitmap r8 = r7.c().get(r10);
        o.c(r8, "inParam.avatarBitmapQueue[i]");
        Bitmap r5 = (Bitmap) ZeusTransformUtils.preCheckCast(r8, Bitmap.class, "com.obric.aiagent.plugin");
        View r11 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.avatar.a r12 = this.inParam;
        if (r12 != null) goto L21;
        o.c("inParam");
        r12 = null;
    L21:
        r6.add(r10, toCircle(r5, g.a(r11, r12.a().a())));
    L32:
        r10 = r4;
        goto L12
    L22:
        List<Bitmap> r13 = this.mAvatarBitmapQueue;
        com.obric.oui.avatar.a r14 = this.inParam;
        if (r14 != null) goto L25;
        o.c("inParam");
        r14 = null;
    L25:
        Bitmap r15 = r14.c().get(r10);
        o.c(r15, "inParam.avatarBitmapQueue[i]");
        Bitmap r16 = (Bitmap) ZeusTransformUtils.preCheckCast(r15, Bitmap.class, "com.obric.aiagent.plugin");
        View r17 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.avatar.a r18 = this.inParam;
        if (r18 != null) goto L28;
        o.c("inParam");
        r18 = null;
    L28:
        int r19 = g.a(r17, r18.a().a());
        com.obric.oui.avatar.a r20 = this.inParam;
        if (r20 != null) goto L31;
        o.c("inParam");
        r20 = null;
    L31:
        r13.add(r10, clip(r16, r19, r20.b()));
        goto L32
    L33:
        invalidate();
    }

    private final void recycleAvatarQueueBitmap() {
    L14:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
        x r5 = x.f38692a;
        return;
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.mAvatarBitmapQueue, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L12;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.mAvatarBitmapQueue, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L14
    L7:
        if (r1.hasNext() == false) goto L11;
        Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r1.next(), Bitmap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (r2.isRecycled() == true) goto L7;
        r2.recycle();     // Catch: Exception -> L14
        goto L7
    L11:
        this.mAvatarBitmapQueue.clear();     // Catch: Exception -> L14
    L12:
        x r6 = x.f38692a;     // Catch: Exception -> L14
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        o.e(r12, "canvas");
        super.onDraw(r12);
        if (this.inParam != null) goto L6;
        return;
    L6:
        if (this.mAvatarBitmapQueue.size() > 0) goto L8;
        return;
    L8:
        com.obric.oui.avatar.a r0 = this.inParam;
        if (r0 != null) goto L11;
        o.c("inParam");
        r0 = null;
    L11:
        int r1 = a.f33995a[r0.b().ordinal()];
        int r3 = 0;
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L47;
        com.obric.oui.avatar.a r2 = this.inParam;
        if (r2 != null) goto L18;
        o.c("inParam");
        r2 = null;
    L18:
        int r4 = r2.c().size();
    L19:
        if (r3 >= r4) goto L54;
        int r5 = r3 + 1;
        if (r3 != 0) goto L23;
        r12.drawBitmap((Bitmap) ZeusTransformUtils.preCheckCast(this.mAvatarBitmapQueue.get(r3), Bitmap.class, "com.obric.aiagent.plugin"), 0.0f, 0.0f, this.mPaint);
    L30:
        r3 = r5;
        goto L19
    L23:
        Bitmap r6 = (Bitmap) ZeusTransformUtils.preCheckCast(this.mAvatarBitmapQueue.get(r3), Bitmap.class, "com.obric.aiagent.plugin");
        View r8 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.avatar.a r9 = this.inParam;
        if (r9 != null) goto L26;
        o.c("inParam");
        r9 = null;
    L26:
        float r10 = g.b(r8, r9.a().a());
        View r11 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.avatar.a r13 = this.inParam;
        if (r13 != null) goto L29;
        o.c("inParam");
        r13 = null;
    L29:
        r12.drawBitmap(r6, (r10 - g.b(r11, r13.d())) * r3, 0.0f, this.mPaint);
        goto L30
    L54:
        return;
    L47:
        return;
    L31:
        com.obric.oui.avatar.a r7 = this.inParam;
        if (r7 != null) goto L34;
        o.c("inParam");
        r7 = null;
    L34:
        int r14 = r7.c().size();
    L35:
        if (r3 >= r14) goto L55;
        int r15 = r3 + 1;
        if (r3 != 0) goto L42;
        Bitmap r16 = (Bitmap) ZeusTransformUtils.preCheckCast(this.mAvatarBitmapQueue.get(r3), Bitmap.class, "com.obric.aiagent.plugin");
        View r17 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.avatar.a r18 = this.inParam;
        if (r18 != null) goto L41;
        o.c("inParam");
        r18 = null;
    L41:
        r12.drawBitmap(r16, 0.0f, (g.b(r17, r18.a().a()) / 2) - 1, this.mPaint);
    L46:
        r3 = r15;
        goto L35
    L42:
        Bitmap r19 = (Bitmap) ZeusTransformUtils.preCheckCast(this.mAvatarBitmapQueue.get(r3), Bitmap.class, "com.obric.aiagent.plugin");
        View r20 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        com.obric.oui.avatar.a r110 = this.inParam;
        if (r110 != null) goto L45;
        o.c("inParam");
        r110 = null;
    L45:
        r12.drawBitmap(r19, (g.b(r20, r110.a().a()) / 2) - 1, 0.0f, this.mPaint);
        goto L46
    }

    static /* synthetic */ Bitmap convertBitmapWithTransBorder$default(OAvatarQueueViewV2WithClip r6, int r7, int r8, Bitmap r9, int r10, b r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = 0;
    L5:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L9;
        r11 = b.f34000a;
    L9:
        return r6.convertBitmapWithTransBorder(r7, r8, r9, r4, r11);
    }

    private final Bitmap convertBitmapWithTransBorder(int r1, int r2, Bitmap r3, int r4, b r5) {
        if (r1 != 0) goto L6;
        return convertBitmap2Circle(r2, r3);
    L6:
        return convertBitmap2CircleClip(r2, convertBitmap2Circle(r2, r3), r4, r5);
    }

    private final Bitmap convertBitmap2Circle(int r11, Bitmap r12) {
        if (r12.getWidth() != 0) goto L5;
    L9:
        return r12;
    L5:
        if (r12.getHeight() == 0) goto L9;
        Bitmap r10 = Bitmap.createBitmap(r11, r11, Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r10);
        Paint r1 = new Paint(1);
        Matrix r8 = new Matrix();
        float r13 = r11;
        r8.postScale(r13 / r12.getWidth(), r13 / r12.getHeight());
        r1.setShader((Shader) ZeusTransformUtils.preCheckCast(new BitmapShader(Bitmap.createBitmap(r12, 0, 0, r12.getWidth(), r12.getHeight(), r8, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
        float r14 = r13 / 2;
        r0.drawCircle(r14, r14, r14, r1);
        o.c(r10, "result");
        return r10;
    }

    private final Bitmap toCircle(Bitmap r9, int r10) {
        return convertBitmapWithTransBorder$default(this, 0, r10, r9, 0, null, 24, null);
    }

    private final Bitmap clip(Bitmap r8, int r9, b r10) {
        com.obric.oui.avatar.a r0 = this.inParam;
        if (r0 != null) goto L6;
        o.c("inParam");
        r0 = null;
    L6:
        return convertBitmapWithTransBorder(1, r9, r8, r0.d(), r10);
    }

    private final Bitmap convertBitmap2CircleClip(int r9, Bitmap r10, int r11, b r12) {
        Bitmap r0 = Bitmap.createBitmap(r9, r9, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        float r13 = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r11);
        Paint r2 = new Paint();
        r2.setShader((Shader) ZeusTransformUtils.preCheckCast(new BitmapShader(r10, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
        float r14 = r9;
        float r4 = r14 / 2;
        r1.drawCircle(r4, r4, r4, r2);
        r2.reset();
        r2.setAntiAlias(true);
        r2.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT), Xfermode.class, "com.obric.aiagent.plugin"));
        int r15 = a.f33995a[r12.ordinal()];
        if (r15 == 1) goto L7;
        if (r15 != 2) goto L8;
        r1.drawCircle(r13 - r4, r4, g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2) + r4, r2);
    L8:
        o.c(r0, "result");
        return r0;
    L7:
        r1.drawCircle(0.0f, r14, r4 + g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2), r2);
        goto L8
    }
}
