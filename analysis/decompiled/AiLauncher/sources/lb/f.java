package lb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.encoding.Encoder;
import pb.AbstractC5086b;
import pb.C5088c;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/b;", "Lob/c;", "decoder", "", "klassName", "Llb/a;", Const.INTENT_KEY_APIKEY, "(Lpb/b;Lob/c;Ljava/lang/String;)Llb/a;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "Llb/m;", Const.INTENT_KEY_PKGNAME, "(Lpb/b;Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Llb/m;", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f {
    public static final <T> InterfaceC4883a<T> a(AbstractC5086b<T> abstractC5086b, ob.c decoder, String str) {
        kotlin.jvm.internal.p.i(abstractC5086b, "<this>");
        kotlin.jvm.internal.p.i(decoder, "decoder");
        InterfaceC4883a<T> interfaceC4883aD = abstractC5086b.d(decoder, str);
        if (interfaceC4883aD != null) {
            return interfaceC4883aD;
        }
        C5088c.a(str, abstractC5086b.f());
        throw new KotlinNothingValueException();
    }

    public static final <T> m<T> b(AbstractC5086b<T> abstractC5086b, Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(abstractC5086b, "<this>");
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        m<T> mVarE = abstractC5086b.e(encoder, value);
        if (mVarE != null) {
            return mVarE;
        }
        C5088c.b(kotlin.jvm.internal.t.b(value.getClass()), abstractC5086b.f());
        throw new KotlinNothingValueException();
    }
}
