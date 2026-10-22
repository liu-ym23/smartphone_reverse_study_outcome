package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.serialization.encoding.Decoder;
import lb.InterfaceC4883a;
import qb.AbstractC5171a;
import qb.C5168A;
import qb.C5172b;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lqb/a;", "json", "Lqb/i;", "element", "Llb/a;", "deserializer", Const.INTENT_KEY_APIKEY, "(Lqb/a;Lqb/i;Llb/a;)Ljava/lang/Object;", "", "discriminator", "Lqb/D;", Const.INTENT_KEY_PKGNAME, "(Lqb/a;Ljava/lang/String;Lqb/D;Llb/a;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class P {
    public static final <T> T a(AbstractC5171a json, qb.i element, InterfaceC4883a<? extends T> deserializer) {
        Decoder wVar;
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(element, "element");
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        if (element instanceof qb.D) {
            wVar = new C5247B(json, (qb.D) element, null, null, 12, null);
        } else if (element instanceof C5172b) {
            wVar = new C5249D(json, (C5172b) element);
        } else {
            if (!(element instanceof qb.w) && !kotlin.jvm.internal.p.d(element, C5168A.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            wVar = new w(json, (qb.F) element, null, 4, null);
        }
        return (T) wVar.decodeSerializableValue(deserializer);
    }

    public static final <T> T b(AbstractC5171a abstractC5171a, String discriminator, qb.D element, InterfaceC4883a<? extends T> deserializer) {
        kotlin.jvm.internal.p.i(abstractC5171a, "<this>");
        kotlin.jvm.internal.p.i(discriminator, "discriminator");
        kotlin.jvm.internal.p.i(element, "element");
        kotlin.jvm.internal.p.i(deserializer, "deserializer");
        return (T) new C5247B(abstractC5171a, element, discriminator, deserializer.getDescriptor()).decodeSerializableValue(deserializer);
    }
}
