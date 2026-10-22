package u1;

import Mb.InterfaceC0968f;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import coil.decode.ExifOrientationPolicy;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013¨\u0006\u0015"}, d2 = {"Lu1/f;", "", "<init>", "()V", "", "mimeType", "LMb/f;", "source", "Lcoil/decode/ExifOrientationPolicy;", PolicySdkConstants.policyFileDir, "Lu1/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LMb/f;Lcoil/decode/ExifOrientationPolicy;)Lu1/d;", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/Bitmap;Lu1/d;)Landroid/graphics/Bitmap;", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "PAINT", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f42411a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Paint PAINT = new Paint(3);

    public final d a(String mimeType, InterfaceC0968f source, ExifOrientationPolicy policy) {
        if (!g.c(policy, mimeType)) {
            return d.f42406d;
        }
        ExifInterface exifInterface = new ExifInterface(new e(source.peek().r1()));
        return new d(exifInterface.isFlipped(), exifInterface.getRotationDegrees());
    }

    public final Bitmap b(Bitmap inBitmap, d exifData) {
        if (!exifData.getIsFlipped() && !g.a(exifData)) {
            return inBitmap;
        }
        Matrix matrix = new Matrix();
        float width = inBitmap.getWidth() / 2.0f;
        float height = inBitmap.getHeight() / 2.0f;
        if (exifData.getIsFlipped()) {
            matrix.postScale(-1.0f, 1.0f, width, height);
        }
        if (g.a(exifData)) {
            matrix.postRotate(exifData.getRotationDegrees(), width, height);
        }
        RectF rectF = new RectF(0.0f, 0.0f, inBitmap.getWidth(), inBitmap.getHeight());
        matrix.mapRect(rectF);
        float f10 = rectF.left;
        if (f10 != 0.0f || rectF.top != 0.0f) {
            matrix.postTranslate(-f10, -rectF.top);
        }
        Bitmap bitmapCreateBitmap = g.b(exifData) ? Bitmap.createBitmap(inBitmap.getHeight(), inBitmap.getWidth(), F1.a.c(inBitmap)) : Bitmap.createBitmap(inBitmap.getWidth(), inBitmap.getHeight(), F1.a.c(inBitmap));
        new Canvas(bitmapCreateBitmap).drawBitmap(inBitmap, matrix, PAINT);
        inBitmap.recycle();
        return bitmapCreateBitmap;
    }
}
