package z7;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.q;
import java.util.regex.Pattern;
import w7.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f16470a = Pattern.compile("^(?:P\\d+W)|(?:P(?:\\d+Y)?(?:\\d+M)?(?:\\d+D)?(?:T(?:\\d+H)?(?:\\d+M)?(?:\\d+S)?)?)$", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f16471b = Pattern.compile("^(?:[-+]?)P(?:[-+]?[0-9]+Y)?(?:[-+]?[0-9]+M)?(?:[-+]?[0-9]+W)?(?:[-+]?[0-9]+D)?(?:T(?:[-+]?[0-9]+H)?(?:[-+]?[0-9]+M)?(?:[-+]?[0-9]+(?:[.,][0-9]{0,9})?S)?)?$", 2);

    @Override // z7.d
    public final String a() {
        return "format.duration";
    }

    @Override // z7.d
    public final boolean b(w7.f fVar, q qVar, String str) {
        if (str == null) {
            return true;
        }
        if (str.endsWith("P") || str.endsWith(ExifInterface.GPS_DIRECTION_TRUE)) {
            return false;
        }
        return (((o) qVar.f1601d).f15349g.b("duration", Boolean.TRUE) ? f16470a : f16471b).matcher(str).matches();
    }

    @Override // z7.d
    public final String getName() {
        return "duration";
    }
}
