package gb;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u00032\n\u0010\u0002\u001a\u00020\u0000\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "", SingleFileBundle.KEY_BYTES, "Lgb/a;", Const.INTENT_KEY_APIKEY, "([B)Lgb/a;", "", "c", "(Lgb/a;)Z", "", Const.INTENT_KEY_PKGNAME, "(Lgb/a;)Ljava/lang/String;", "kotlinx-io-bytestring"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c {
    public static final C4114a a(byte... bytes) {
        p.i(bytes, "bytes");
        return bytes.length == 0 ? C4114a.INSTANCE.a() : C4114a.INSTANCE.b(bytes);
    }

    public static final String b(C4114a c4114a) {
        p.i(c4114a, "<this>");
        return D.D(c4114a.getData());
    }

    public static final boolean c(C4114a c4114a) {
        p.i(c4114a, "<this>");
        return c4114a.i() == 0;
    }
}
