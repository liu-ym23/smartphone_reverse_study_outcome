package rb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4952e;
import nb.AbstractC4959l;
import p9.InterfaceC5074l;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a3\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\"\u0018\u0010\r\u001a\u00020\n*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lqb/a;", "json", UxipConstants.f30680s, "Llb/m;", "serializer", "Lqb/i;", Const.INTENT_KEY_UMID, "(Lqb/a;Ljava/lang/Object;Llb/m;)Lqb/i;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "requiresTopLevelTag", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class S {
    public static final boolean c(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.getKind() instanceof AbstractC4952e) || serialDescriptor.getKind() == AbstractC4959l.b.f37292a;
    }

    public static final <T> qb.i d(AbstractC5171a json, T t10, lb.m<? super T> serializer) {
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        new C5248C(json, new InterfaceC5074l() { // from class: rb.Q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return S.e(ref$ObjectRef, (qb.i) obj);
            }
        }).e(serializer, t10);
        T t11 = ref$ObjectRef.f34820a;
        if (t11 != null) {
            return (qb.i) t11;
        }
        kotlin.jvm.internal.p.A("result");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Y8.t e(Ref$ObjectRef ref$ObjectRef, qb.i it) {
        kotlin.jvm.internal.p.i(it, "it");
        ref$ObjectRef.f34820a = it;
        return Y8.t.f7040a;
    }
}
