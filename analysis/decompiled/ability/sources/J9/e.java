package J9;

import F9.C0223a;
import F9.t;
import F9.y;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import java.io.IOException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f893a;
    public int b;
    public int c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public Object h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public Object f894j;

    public e(int i, int i6) {
        int i10 = (i * 2) / 5;
        i10 = i10 < 280 ? 280 : i10;
        this.f893a = i10;
        Paint paint = new Paint(1);
        paint.setColor(Color.argb(160, 0, 0, 0));
        this.g = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        Typeface typeface = Typeface.MONOSPACE;
        paint2.setTypeface(typeface);
        paint2.setTextSize(24.0f);
        this.h = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(Color.parseColor("#7FFFD4"));
        paint3.setTypeface(typeface);
        paint3.setTextSize(24.0f);
        this.i = paint3;
        int fontSpacing = (((int) (paint2.getFontSpacing() + 4)) * 8) + 32;
        fontSpacing = fontSpacing < 220 ? 220 : fontSpacing;
        this.b = fontSpacing;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, fontSpacing, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.k.e(bitmapCreateBitmap, "createBitmap(...)");
        this.e = bitmapCreateBitmap;
        this.f = new Canvas(bitmapCreateBitmap);
        this.d = new RectF(1.0f - ((i10 * 2.0f) / i), 1.0f, 1.0f, 1.0f - ((fontSpacing * 2.0f) / i6));
    }

    public void a(String str, String str2, float f) {
        Canvas canvas = (Canvas) this.f;
        String strConcat = str.concat(":");
        Paint paint = (Paint) this.i;
        canvas.drawText(strConcat, 12.0f, f, paint);
        canvas.drawText(str2, paint.measureText(str.concat(": ")) + 12.0f, f, (Paint) this.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r18, java.lang.String r19, float r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.f
            android.graphics.Canvas r2 = (android.graphics.Canvas) r2
            java.lang.String r3 = ":"
            java.lang.String r3 = r1.concat(r3)
            java.lang.Object r4 = r0.i
            android.graphics.Paint r4 = (android.graphics.Paint) r4
            r5 = 1094713344(0x41400000, float:12.0)
            r6 = r20
            r2.drawText(r3, r5, r6, r4)
            java.lang.String r3 = ": "
            java.lang.String r1 = r1.concat(r3)
            float r1 = r4.measureText(r1)
            int r3 = r0.f893a
            float r3 = (float) r3
            r4 = 2
            float r7 = (float) r4
            float r7 = r7 * r5
            float r3 = r3 - r7
            float r7 = r3 - r1
            java.lang.Object r0 = r0.h
            android.graphics.Paint r0 = (android.graphics.Paint) r0
            float r8 = r0.getFontSpacing()
            r9 = 4
            float r9 = (float) r9
            float r8 = r8 + r9
            r9 = 0
            r10 = r6
            r11 = r9
            r6 = r19
        L3c:
            if (r11 >= r4) goto La4
            int r12 = r6.length()
            if (r12 != 0) goto L45
            goto La4
        L45:
            if (r11 != 0) goto L49
            r12 = r7
            goto L4a
        L49:
            r12 = r3
        L4a:
            r13 = 1
            r14 = 0
            int r15 = r0.breakText(r6, r13, r12, r14)
            if (r15 <= 0) goto La4
            java.lang.String r4 = "substring(...)"
            if (r11 != r13) goto L7c
            r16 = r5
            int r5 = r6.length()
            if (r15 >= r5) goto L7e
            java.lang.String r5 = "…"
            float r15 = r0.measureText(r5)
            float r12 = r12 - r15
            int r12 = r0.breakText(r6, r13, r12, r14)
            if (r12 >= 0) goto L6c
            r12 = r9
        L6c:
            java.lang.String r12 = r6.substring(r9, r12)
            kotlin.jvm.internal.k.e(r12, r4)
            java.lang.String r5 = r12.concat(r5)
            int r15 = r6.length()
            goto L85
        L7c:
            r16 = r5
        L7e:
            java.lang.String r5 = r6.substring(r9, r15)
            kotlin.jvm.internal.k.e(r5, r4)
        L85:
            if (r11 != 0) goto L8a
            float r12 = r16 + r1
            goto L8c
        L8a:
            r12 = r16
        L8c:
            r2.drawText(r5, r12, r10, r0)
            int r5 = r6.length()
            if (r15 <= r5) goto L96
            r15 = r5
        L96:
            java.lang.String r6 = r6.substring(r15)
            kotlin.jvm.internal.k.e(r6, r4)
            float r10 = r10 + r8
            int r11 = r11 + 1
            r5 = r16
            r4 = 2
            goto L3c
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J9.e.b(java.lang.String, java.lang.String, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x0316 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.internal.connection.a c(int r15, int r16, int r17, boolean r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 996
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J9.e.c(int, int, int, boolean, boolean):okhttp3.internal.connection.a");
    }

    public boolean d(y url) {
        kotlin.jvm.internal.k.f(url, "url");
        y yVar = ((C0223a) this.e).i;
        return url.e == yVar.e && kotlin.jvm.internal.k.b(url.d, yVar.d);
    }

    public void e(IOException e) {
        kotlin.jvm.internal.k.f(e, "e");
        this.f894j = null;
        if ((e instanceof StreamResetException) && ((StreamResetException) e).f5474a == ErrorCode.REFUSED_STREAM) {
            this.f893a++;
        } else if (e instanceof ConnectionShutdownException) {
            this.b++;
        } else {
            this.c++;
        }
    }

    public e(k connectionPool, C0223a c0223a, i iVar, t eventListener) {
        kotlin.jvm.internal.k.f(connectionPool, "connectionPool");
        kotlin.jvm.internal.k.f(eventListener, "eventListener");
        this.d = connectionPool;
        this.e = c0223a;
        this.f = iVar;
        this.g = eventListener;
    }
}
