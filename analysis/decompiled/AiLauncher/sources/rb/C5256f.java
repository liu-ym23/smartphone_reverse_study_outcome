package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"", Const.INTENT_KEY_APIKEY, "I", "MAX_CHARS_IN_POOL", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5256f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f38982a;

    static {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            objB = Result.b(property != null ? La.C.w(property) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Integer num = (Integer) (Result.g(objB) ? null : objB);
        f38982a = num != null ? num.intValue() : 2097152;
    }
}
