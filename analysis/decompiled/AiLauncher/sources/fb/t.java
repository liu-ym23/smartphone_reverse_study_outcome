package fb;

import com.autonavi.aps.amapapi.config.Const;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lfb/s;", "Ljava/nio/ByteBuffer;", "source", "", Const.INTENT_KEY_APIKEY, "(Lfb/s;Ljava/nio/ByteBuffer;)I", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class t {
    public static final int a(s sVar, ByteBuffer source) {
        kotlin.jvm.internal.p.i(sVar, "<this>");
        kotlin.jvm.internal.p.i(source, "source");
        long jN = sVar.a().n();
        C4075b.d(sVar.a(), source);
        long jN2 = sVar.a().n() - jN;
        sVar.X();
        return (int) jN2;
    }
}
