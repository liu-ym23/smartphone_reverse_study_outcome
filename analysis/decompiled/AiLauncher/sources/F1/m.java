package F1;

import B1.Size;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import r9.C5227b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LF1/m;", "", "<init>", "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap$Config;", "config", "LB1/g;", ContentDisposition.Parameters.Size, "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "", "allowInexactSize", "Landroid/graphics/Bitmap;", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Bitmap$Config;LB1/g;Lcoil/size/Scale;Z)Landroid/graphics/Bitmap;", "bitmap", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$Config;)Z", "c", "(ZLandroid/graphics/Bitmap;LB1/g;Lcoil/size/Scale;)Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f2558a = new m();

    public final Bitmap a(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean allowInexactSize) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (b(bitmap, config) && c(allowInexactSize, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int iP = j.p(drawableMutate);
        if (iP <= 0) {
            iP = 512;
        }
        int i10 = j.i(drawableMutate);
        int i11 = i10 > 0 ? i10 : 512;
        double dC = u1.c.c(iP, i11, B1.b.a(size) ? iP : j.A(size.d(), scale), B1.b.a(size) ? i11 : j.A(size.c(), scale), scale);
        int iA = C5227b.a(iP * dC);
        int iA2 = C5227b.a(dC * i11);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, iA2, a.e(config));
        Rect bounds = drawableMutate.getBounds();
        int i12 = bounds.left;
        int i13 = bounds.top;
        int i14 = bounds.right;
        int i15 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iA, iA2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i12, i13, i14, i15);
        return bitmapCreateBitmap;
    }

    public final boolean b(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == a.e(config);
    }

    public final boolean c(boolean allowInexactSize, Bitmap bitmap, Size size, Scale scale) {
        if (allowInexactSize) {
            return true;
        }
        return u1.c.c(bitmap.getWidth(), bitmap.getHeight(), B1.b.a(size) ? bitmap.getWidth() : j.A(size.d(), scale), B1.b.a(size) ? bitmap.getHeight() : j.A(size.c(), scale), scale) == 1.0d;
    }
}
