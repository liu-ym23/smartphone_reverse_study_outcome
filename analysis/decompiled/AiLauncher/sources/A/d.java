package A;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import kotlin.Metadata;
import w.C5694F;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a)\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00018\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\b\u001a\u0015\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\n\u0010\b\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\b\u001a\u0015\u0010\f\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\f\u0010\b\u001a\u0015\u0010\r\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\r\u0010\b¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "collection", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Ljava/util/Collection;)Z", "Lw/F;", "c", "(Lw/F;)Z", Const.INTENT_KEY_UMID, "e", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {
    public static final <T> boolean b(T t10, Collection<? extends T> collection) {
        if (t10 != null) {
            return collection.contains(t10);
        }
        return true;
    }

    public static final boolean c(C5694F c5694f) {
        int iB = C5694F.INSTANCE.b();
        if (c5694f == null) {
            return false;
        }
        return C5694F.g(c5694f.getValue(), iB);
    }

    public static final boolean d(C5694F c5694f) {
        int iB = C5694F.INSTANCE.b();
        if (c5694f == null) {
            return false;
        }
        return C5694F.g(c5694f.getValue(), iB);
    }

    public static final boolean e(C5694F c5694f) {
        int iB = C5694F.INSTANCE.b();
        if (c5694f == null) {
            return false;
        }
        return C5694F.g(c5694f.getValue(), iB);
    }

    public static final boolean f(C5694F c5694f) {
        if (c5694f != null) {
            return !C5694F.g(c5694f.getValue(), C5694F.INSTANCE.c());
        }
        return false;
    }

    public static final boolean g(C5694F c5694f) {
        if (c5694f != null) {
            return !C5694F.g(c5694f.getValue(), C5694F.INSTANCE.c());
        }
        return false;
    }

    public static final boolean h(C5694F c5694f) {
        if (c5694f != null) {
            return !C5694F.g(c5694f.getValue(), C5694F.INSTANCE.c());
        }
        return false;
    }
}
