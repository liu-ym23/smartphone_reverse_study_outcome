package C2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.stepos.familyguard.ui.widget.RoundedImageView;
import f2.C0702g;

/* loaded from: classes.dex */
public class h {
    public static Bitmap a(Context context, Bitmap bitmap, int i5, int i6) {
        return d(b(P1.a.a(), c(P1.a.a(), bitmap), i5, (int) (bitmap.getWidth() * RoundedImageView.j(context)), i6));
    }

    public static Drawable b(Context context, Drawable drawable, int i5, int i6, int i7) {
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float fMin = Math.min(i7 > 0 ? 1.0f + (i7 / 2.0f) : 1.0f, Math.min(intrinsicWidth, intrinsicHeight) / 4.0f);
        float f5 = intrinsicWidth - fMin;
        float f6 = intrinsicHeight - fMin;
        float fMax = Math.max(0.0f, i6 - fMin);
        Path path = new Path();
        path.addRoundRect(fMin, fMin, f5, f6, fMax, fMax, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(path);
        drawable.setBounds(Math.round(fMin), Math.round(fMin), Math.round(f5), Math.round(f6));
        drawable.draw(canvas);
        canvas.restore();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i7);
        paint.setAntiAlias(true);
        paint.setColor(i5);
        canvas.drawPath(path, paint);
        return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
    }

    public static Drawable c(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Bitmap d(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap e(Drawable drawable, int i5) {
        if (drawable == null || i5 <= 0) {
            return null;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            drawable = constantState.newDrawable().mutate();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, i5, i5);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap f(Bitmap bitmap, int i5) {
        if (bitmap == null) {
            return null;
        }
        int allocationByteCount = bitmap.getAllocationByteCount();
        int i6 = allocationByteCount / 2;
        if (i6 < i5) {
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_4444, false);
            C0702g.y("ImageUtil", "source bitmap size = " + allocationByteCount + " argb4444Bitmap: " + bitmapCopy.getWidth() + " X " + bitmapCopy.getHeight() + " size = " + bitmapCopy.getAllocationByteCount());
            bitmap.recycle();
            return bitmapCopy;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double dSqrt = Math.sqrt(i6 / i5);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width / dSqrt), (int) (height / dSqrt), true);
        Bitmap bitmapCopy2 = bitmapCreateScaledBitmap.copy(Bitmap.Config.ARGB_4444, false);
        C0702g.y("ImageUtil", "source bitmap size = " + allocationByteCount + " scaledBitmap: " + bitmapCopy2.getWidth() + " X " + bitmapCopy2.getHeight() + " size = " + bitmapCopy2.getAllocationByteCount());
        bitmapCreateScaledBitmap.recycle();
        bitmap.recycle();
        return bitmapCopy2;
    }

    public static Bitmap g(Bitmap bitmap, int i5, int i6) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i5, i6, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap h(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        float f5 = iMin / 2.0f;
        canvas.drawCircle(f5, f5, f5, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Rect rect = new Rect(0, 0, width, height);
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap i(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return h(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }
}
