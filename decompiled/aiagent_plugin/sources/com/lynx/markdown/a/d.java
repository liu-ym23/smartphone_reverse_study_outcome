package com.lynx.markdown.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import com.ttreader.tttext.lite.JavaFontManager;
import com.ttreader.tttext.lite.TTTextDefinition;
import com.ttreader.tttext.lite.TTTextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: JavaCanvasHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Canvas f13869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e f13870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f13871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Paint f13872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f13873e;
    protected boolean f;

    /* JADX INFO: renamed from: com.lynx.markdown.a.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: JavaCanvasHelper.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13874a = null;

        static {
            int[] r0 = new int[TTTextDefinition.CanvasOp.values().length];
            f13874a = r0;
            r0[TTTextDefinition.CanvasOp.kSave.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            f13874a[TTTextDefinition.CanvasOp.kRestore.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            f13874a[TTTextDefinition.CanvasOp.kTranslate.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            f13874a[TTTextDefinition.CanvasOp.kScale.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            f13874a[TTTextDefinition.CanvasOp.kClipRect.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            f13874a[TTTextDefinition.CanvasOp.kDrawLine.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            f13874a[TTTextDefinition.CanvasOp.kDrawRect.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            f13874a[TTTextDefinition.CanvasOp.kDrawText.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            f13874a[TTTextDefinition.CanvasOp.kDrawCircle.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            f13874a[TTTextDefinition.CanvasOp.kDrawRunDelegate.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            f13874a[TTTextDefinition.CanvasOp.kDrawRoundRect.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public d(Canvas r3, e r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        this.f13872d = new Paint();
        this.f13869a = r3;
        this.f13870b = r4;
        this.f13871c = r6;
    }

    public void a(byte[] r2) {
        a r3 = new a(new ByteArrayInputStream(r2));
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r3.available() <= 0) goto L14;
        a(TTTextDefinition.GetCanvasOp(r3.readInt()), r3);     // Catch: IOException -> L7
        goto L10
    }

    public void a(TTTextDefinition.CanvasOp r2, a r3) {
        switch(AnonymousClass1.f13874a[r2.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L27;
        };
    L5:
        h(r3);
        return;
    L6:
        j(r3);
        return;
    L7:
        i(r3);
        return;
    L8:
        b(r3);
        return;
    L9:
        g(r3);
        return;
    L10:
        f(r3);
        return;
    L11:
        e(r3);
        return;
    L12:
        d(r3);
        return;
    L13:
        a(r3);
        return;
    L14:
        b();
        return;
    L15:
        a();
        return;
    }

    public void a() {
        this.f13869a.save();
    }

    public void b() {
        this.f13869a.restore();
    }

    public void a(a r2) {
        float r0 = TTTextUtils.Dp2Px(r2.readFloat());
        float r3 = TTTextUtils.Dp2Px(r2.readFloat());
        this.f13869a.translate(r0, r3);
    }

    private void d(a r2) {
        float r0 = r2.readFloat();
        float r3 = r2.readFloat();
        this.f13869a.scale(r0, r3);
    }

    private void e(a r4) {
        float r0 = TTTextUtils.Dp2Px(r4.readFloat());
        float r1 = TTTextUtils.Dp2Px(r4.readFloat());
        float r2 = TTTextUtils.Dp2Px(r4.readFloat());
        float r5 = TTTextUtils.Dp2Px(r4.readFloat());
        this.f13869a.clipRect(r0, r1, r2, r5);
    }

    private void f(a r8) {
        float r2 = TTTextUtils.Dp2Px(r8.readFloat());
        float r3 = TTTextUtils.Dp2Px(r8.readFloat());
        float r4 = TTTextUtils.Dp2Px(r8.readFloat());
        float r5 = TTTextUtils.Dp2Px(r8.readFloat());
        Paint r6 = c(r8);
        this.f13869a.drawLine(r2, r3, r4, r5, r6);
    }

    private void g(a r8) {
        float r2 = TTTextUtils.Dp2Px(r8.readFloat());
        float r3 = TTTextUtils.Dp2Px(r8.readFloat());
        float r4 = TTTextUtils.Dp2Px(r8.readFloat());
        float r5 = TTTextUtils.Dp2Px(r8.readFloat());
        Paint r6 = c(r8);
        this.f13869a.drawRect(r2, r3, r4, r5, r6);
    }

    private void h(a r10) {
        float r2 = TTTextUtils.Dp2Px(r10.readFloat());
        float r3 = TTTextUtils.Dp2Px(r10.readFloat());
        float r4 = TTTextUtils.Dp2Px(r10.readFloat());
        float r5 = TTTextUtils.Dp2Px(r10.readFloat());
        float r7 = TTTextUtils.Dp2Px(r10.readFloat());
        Paint r11 = c(r10);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.f13869a.drawRoundRect(r2, r3, r4, r5, r7, r7, r11);
        return;
    L5:
        this.f13869a.drawRect(r2, r3, r4, r5, r11);
    }

    private void i(a r4) {
        float r0 = TTTextUtils.Dp2Px(r4.readFloat());
        float r1 = TTTextUtils.Dp2Px(r4.readFloat());
        float r2 = TTTextUtils.Dp2Px(r4.readFloat());
        Paint r5 = c(r4);
        this.f13869a.drawCircle(r0, r1, r2, r5);
    }

    public void b(a r7) {
        long r0 = r7.readLong();
        String r2 = r7.a();
        float r3 = TTTextUtils.Dp2Px(r7.readFloat());
        float r4 = TTTextUtils.Dp2Px(r7.readFloat());
        Paint r8 = c(r7);
        int r1 = (int) r0;
        if (this.f13873e == false) goto L5;
        TTTextDefinition.FontWeight r5 = TTTextDefinition.FontWeight.kBold_700;
    L7:
        if (this.f == false) goto L9;
        TTTextDefinition.FontStyle r6 = TTTextDefinition.FontStyle.kItalic;
    L10:
        JavaFontManager.ApplyFont(r8, r1, r5, r6);
        this.f13869a.drawText(r2, r3, r4, r8);
        return;
    L9:
        r6 = TTTextDefinition.FontStyle.kNormal;
        goto L10
    L5:
        r5 = TTTextDefinition.FontWeight.kNormal_400;
        goto L7
    }

    private void j(a r6) {
        int r0 = r6.readInt();
        float r1 = TTTextUtils.Dp2Px(r6.readFloat());
        float r2 = TTTextUtils.Dp2Px(r6.readFloat());
        float r3 = TTTextUtils.Dp2Px(r6.readFloat());
        float r4 = TTTextUtils.Dp2Px(r6.readFloat());
        c(r6);
        b r7 = this.f13871c;
        if (r7 != null) goto L5;
        return;
    L5:
        r7.drawRunDelegate(this.f13870b.a(r0), new Rect((int) r1, (int) r2, (int) r3, (int) r4));
    }

    public Paint c(a r4) {
        int r0 = r4.readInt();
        boolean r1 = true;
        if (r0 == 0) goto L7;
        if (r0 == 1) goto L6;
        this.f13872d.setStyle(Paint.Style.FILL_AND_STROKE);
    L8:
        this.f13872d.setAntiAlias(true);
        this.f13872d.setStrokeWidth(TTTextUtils.Dp2Px(r4.readFloat()));
        this.f13872d.setColor(r4.readInt());
        this.f13872d.setTextSize(TTTextUtils.Dp2Px(r4.readFloat()));
        if (r4.readInt() == 0) goto L11;
        boolean r2 = true;
    L12:
        this.f13873e = r2;
        if (r4.readInt() != 0) goto L16;
        r1 = false;
    L16:
        this.f = r1;
        r4.readInt();
        return this.f13872d;
    L11:
        r2 = false;
        goto L12
    L6:
        this.f13872d.setStyle(Paint.Style.STROKE);
        goto L8
    L7:
        this.f13872d.setStyle(Paint.Style.FILL);
        goto L8
    }
}
