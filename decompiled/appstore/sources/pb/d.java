package pb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23426b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f23427a;

    public static final class a {
        public a() {
        }

        public final void a(Path r10, e r11, float r12, float r13, float r14) {
            q.g(r10, "$this$arcTo");
            q.g(r11, "arcCenter");
            r10.arcTo(r11.c() - r12, r11.d() - r12, r11.c() + r12, r11.d() + r12, r13, r14 - r13, false);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f23426b = new a(null);
    }

    public d() {
        this.f23427a = new RectF();
    }

    public static /* synthetic */ void e(d r17, Canvas r18, Paint r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, Object r32) {
        if (r32 != null) goto L23;
        if ((r31 & 512) == 0) goto L7;
        boolean r13 = true;
    L9:
        if ((r31 & 1024) == 0) goto L11;
        boolean r14 = true;
    L13:
        if ((r31 & 2048) == 0) goto L15;
        boolean r15 = true;
    L17:
        if ((r31 & 4096) == 0) goto L19;
        boolean r16 = true;
    L20:
        r17.d(r18, r19, r20, r21, r22, r23, r24, r25, r26, r13, r14, r15, r16);
        return;
    L19:
        r16 = r30;
        goto L20
    L15:
        r15 = r29;
        goto L17
    L11:
        r14 = r28;
        goto L13
    L7:
        r13 = r27;
        goto L9
    L23:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawAndroidRoundRect");
    }

    public abstract Path a(float r10, float r11, float r12, float r13, float r14);

    public final Path b(float r10, float r11, float r12, float r13, float r14) {
        Path r15 = new Path();
        r15.addRoundRect(r10, r11, r12, r13, r14, r14, Path.Direction.CW);
        r15.close();
        return r15;
    }

    public boolean c(float r10, float r11) {
        return true;
    }

    public final void d(Canvas r11, Paint r12, float r13, float r14, float r15, float r16, float r17, float r18, float r19, boolean r20, boolean r21, boolean r22, boolean r23) {
        q.g(r11, "canvas");
        q.g(r12, "paint");
        float r10 = r17 - r15;
        float r24 = r18 - r16;
        this.f23427a.set(r15, r16, r17, r18);
        r11.drawRoundRect(this.f23427a, r19, r19, r12);
        if (r20 == true) goto L5;
        float r25 = 2;
        float r26 = r10 / r25;
        float r27 = r24 / r25;
        r11.drawRect(0.0f, 0.0f, r26, r27, r12);
        Path r28 = new Path();
        r28.moveTo(0.0f, r27);
        r28.lineTo(0.0f, 0.0f);
        r28.lineTo(r26, 0.0f);
        r11.drawPath(r28, r12);
    L5:
        if (r21 == true) goto L7;
        float r29 = 2;
        float r30 = r10 / r29;
        float r31 = r24 / r29;
        r11.drawRect(r30, 0.0f, r10, r31, r12);
        Path r32 = new Path();
        r32.moveTo(r30, 0.0f);
        r32.lineTo(r10, 0.0f);
        r32.lineTo(r10, r31);
        r11.drawPath(r32, r12);
    L7:
        if (r22 == true) goto L9;
        float r33 = 2;
        float r34 = r24 / r33;
        float r35 = r10 / r33;
        r11.drawRect(0.0f, r34, r35, r24, r12);
        Path r36 = new Path();
        r36.moveTo(0.0f, r34);
        r36.lineTo(0.0f, r24);
        r36.lineTo(r35, r24);
        r11.drawPath(r36, r12);
    L9:
        if (r23 == true) goto L12;
        float r37 = 2;
        float r38 = r10 / r37;
        float r39 = r24 / r37;
        r11.drawRect(r38, r39, r10, r24, r12);
        Path r40 = new Path();
        r40.moveTo(r38, r24);
        r40.lineTo(r10, r24);
        r40.lineTo(r10, r39);
        r11.drawPath(r40, r12);
        return;
    }

    public void f(Canvas r10, Paint r11, float r12, float r13, float r14, float r15, float r16) {
        q.g(r10, "canvas");
        q.g(r11, "paint");
        r10.drawPath(a(r12, r13, r14, r15, r16), r11);
    }
}
