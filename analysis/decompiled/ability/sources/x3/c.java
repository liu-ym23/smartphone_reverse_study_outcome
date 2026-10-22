package x3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f6874a = Pattern.compile("^(?:P\\d+W)|(?:P(?:\\d+Y)?(?:\\d+M)?(?:\\d+D)?(?:T(?:\\d+H)?(?:\\d+M)?(?:\\d+S)?)?)$", 2);
    public static final Pattern b = Pattern.compile("^(?:[-+]?)P(?:[-+]?[0-9]+Y)?(?:[-+]?[0-9]+M)?(?:[-+]?[0-9]+W)?(?:[-+]?[0-9]+D)?(?:T(?:[-+]?[0-9]+H)?(?:[-+]?[0-9]+M)?(?:[-+]?[0-9]+(?:[.,][0-9]{0,9})?S)?)?$", 2);

    @Override // x3.d
    public final String a() {
        return "format.duration";
    }

    @Override // x3.d
    public final boolean b(u3.f fVar, G6.c cVar, String str) {
        if (str == null) {
            return true;
        }
        if (str.endsWith("P") || str.endsWith(ExifInterface.GPS_DIRECTION_TRUE)) {
            return false;
        }
        return (((u3.k) cVar.d).g.c(TypedValues.TransitionType.S_DURATION, Boolean.TRUE) ? f6874a : b).matcher(str).matches();
    }

    @Override // x3.d
    public final String getName() {
        return TypedValues.TransitionType.S_DURATION;
    }
}
