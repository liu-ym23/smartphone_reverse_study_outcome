package D5;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LD5/a;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "impl", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/util/concurrent/ConcurrentHashMap;", "services", "Ljava/util/concurrent/ConcurrentHashMap;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final ConcurrentHashMap<Class<?>, Object> services = new ConcurrentHashMap<>();

    public final <T> T a(Class<T> clazz) {
        p.i(clazz, "clazz");
        T t10 = (T) services.get(clazz);
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public final <T> void b(Class<T> clazz, T impl) {
        p.i(clazz, "clazz");
        p.i(impl, "impl");
        services.put(clazz, impl);
    }
}
