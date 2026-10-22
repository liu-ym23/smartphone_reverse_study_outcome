package Za;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "LUa/I;", "", "name", Const.INTENT_KEY_PKGNAME, "(LUa/I;Ljava/lang/String;)LUa/I;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1192l {
    public static final void a(int i10) {
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i10).toString());
    }

    public static final Ua.I b(Ua.I i10, String str) {
        return str != null ? new u(i10, str) : i10;
    }
}
