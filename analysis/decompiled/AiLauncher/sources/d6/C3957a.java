package d6;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ld6/a;", "", "<init>", "()V", "raw", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Z", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: d6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3957a {
    public static final C3957a INSTANCE = new C3957a();

    public final boolean a(Object raw) {
        return raw instanceof Boolean ? ((Boolean) raw).booleanValue() : raw instanceof String ? D.L((String) raw, "true", true) : (raw instanceof Number) && ((Number) raw).intValue() != 0;
    }
}
