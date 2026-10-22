package u1;

import Z8.Y;
import coil.decode.ExifOrientationPolicy;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.ai.selector.compress.Checker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0018\u0010\r\u001a\u00020\u0003*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\u000e\u001a\u00020\u0003*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\f¨\u0006\u000f"}, d2 = {"Lcoil/decode/ExifOrientationPolicy;", "", "mimeType", "", "c", "(Lcoil/decode/ExifOrientationPolicy;Ljava/lang/String;)Z", "", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "RESPECT_PERFORMANCE_MIME_TYPES", "Lu1/d;", Const.INTENT_KEY_PKGNAME, "(Lu1/d;)Z", "isSwapped", "isRotated", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f42413a = Y.j("image/jpeg", "image/webp", Checker.MIME_TYPE_HEIC, "image/heif");

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42414a;

        static {
            int[] iArr = new int[ExifOrientationPolicy.values().length];
            try {
                iArr[ExifOrientationPolicy.RESPECT_PERFORMANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExifOrientationPolicy.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExifOrientationPolicy.RESPECT_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f42414a = iArr;
        }
    }

    public static final boolean a(d dVar) {
        return dVar.getRotationDegrees() > 0;
    }

    public static final boolean b(d dVar) {
        return dVar.getRotationDegrees() == 90 || dVar.getRotationDegrees() == 270;
    }

    public static final boolean c(ExifOrientationPolicy exifOrientationPolicy, String str) {
        int i10 = a.f42414a[exifOrientationPolicy.ordinal()];
        if (i10 == 1) {
            return str != null && f42413a.contains(str);
        }
        if (i10 == 2) {
            return false;
        }
        if (i10 == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
