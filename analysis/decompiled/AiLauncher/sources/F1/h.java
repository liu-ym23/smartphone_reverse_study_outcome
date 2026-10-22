package F1;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import coil.size.Precision;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\r\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"LA1/g;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "resId", "default", "c", "(LA1/g;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "LA1/b;", Const.INTENT_KEY_APIKEY, "LA1/b;", Const.INTENT_KEY_PKGNAME, "()LA1/b;", "DEFAULT_REQUEST_OPTIONS", "", "(LA1/g;)Z", "allowInexactSize", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final A1.b f2546a = new A1.b(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2547a;

        static {
            int[] iArr = new int[Precision.values().length];
            try {
                iArr[Precision.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Precision.INEXACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Precision.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2547a = iArr;
        }
    }

    public static final boolean a(A1.g gVar) {
        int i10 = a.f2547a[gVar.getPrecision().ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            return true;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (gVar.getDefined().getSizeResolver() == null && (gVar.getSizeResolver() instanceof B1.d)) {
            return true;
        }
        return (gVar.getTarget() instanceof C1.d) && (gVar.getSizeResolver() instanceof B1.j) && (((C1.d) gVar.getTarget()).getView() instanceof ImageView) && ((C1.d) gVar.getTarget()).getView() == ((B1.j) gVar.getSizeResolver()).getView();
    }

    public static final A1.b b() {
        return f2546a;
    }

    public static final Drawable c(A1.g gVar, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return d.a(gVar.getContext(), num.intValue());
    }
}
