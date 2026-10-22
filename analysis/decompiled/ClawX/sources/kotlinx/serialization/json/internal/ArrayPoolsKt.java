package kotlinx.serialization.json.internal;

import b5.h;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"MAX_CHARS_IN_POOL", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object objO;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            objO = property != null ? u.d1(property) : null;
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        Integer num = (Integer) (objO instanceof h ? null : objO);
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
