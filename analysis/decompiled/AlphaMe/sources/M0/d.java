package M0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.airbnb.lottie.v;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: v, reason: collision with root package name */
    public final Paint f1389v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f1390w;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f1391x;

    /* renamed from: y, reason: collision with root package name */
    public H0.j f1392y;

    public d(v vVar, e eVar) {
        super(vVar, eVar);
        this.f1389v = new Paint(3);
        this.f1390w = new Rect();
        this.f1391x = new Rect();
    }

    @Override // M0.b, J0.f
    public final void f(Object obj, Q0.b bVar) {
        super.f(obj, bVar);
        if (obj == z.f4607t) {
            if (bVar == null) {
                this.f1392y = null;
            } else {
                this.f1392y = new H0.j(bVar);
            }
        }
    }

    @Override // M0.b, G0.e
    public final void h(RectF rectF, Matrix matrix) {
        super.h(rectF, matrix);
        if (p() != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, r6.getWidth()), Math.min(rectF.bottom, r6.getHeight()));
            this.f1373l.mapRect(rectF);
        }
    }

    @Override // M0.b
    public final void k(Canvas canvas, Matrix matrix, int i4) {
        Bitmap bitmapP = p();
        if (bitmapP == null || bitmapP.isRecycled()) {
            return;
        }
        float fC = P0.c.c();
        Paint paint = this.f1389v;
        paint.setAlpha(i4);
        H0.j jVar = this.f1392y;
        if (jVar != null) {
            paint.setColorFilter((ColorFilter) jVar.e());
        }
        canvas.save();
        canvas.concat(matrix);
        int width = bitmapP.getWidth();
        int height = bitmapP.getHeight();
        Rect rect = this.f1390w;
        rect.set(0, 0, width, height);
        Rect rect2 = this.f1391x;
        rect2.set(0, 0, (int) (bitmapP.getWidth() * fC), (int) (bitmapP.getHeight() * fC));
        canvas.drawBitmap(bitmapP, rect, rect2, paint);
        canvas.restore();
    }

    public final Bitmap p() {
        String str = this.f1375n.f1399g;
        I0.a aVarD = this.f1374m.d();
        if (aVarD == null) {
            return null;
        }
        String str2 = aVarD.f833b;
        w wVar = (w) aVarD.f834c.get(str);
        if (wVar == null) {
            return null;
        }
        Bitmap bitmap = wVar.f4587b;
        if (bitmap != null) {
            return bitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        String str3 = wVar.f4586a;
        if (str3.startsWith("data:") && str3.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(str3.substring(str3.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                aVarD.a(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e4) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e4);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(aVarD.f832a.getAssets().open(str2 + str3), null, options);
            aVarD.a(str, bitmapDecodeStream);
            return bitmapDecodeStream;
        } catch (IOException e5) {
            Log.w("LOTTIE", "Unable to open asset.", e5);
            return null;
        }
    }
}
