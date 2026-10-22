package fa;

import Z8.F;
import Z8.Y;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* renamed from: fa.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4068e extends C4069f {

    /* renamed from: h, reason: collision with root package name */
    public final JvmProtoBuf.StringTableTypes f32585h;

    /* JADX WARN: Illegal instructions before constructor call */
    public C4068e(JvmProtoBuf.StringTableTypes types, String[] strings) {
        Set setR1;
        p.i(types, "types");
        p.i(strings, "strings");
        List<Integer> listV = types.v();
        if (listV.isEmpty()) {
            setR1 = Y.e();
        } else {
            p.f(listV);
            setR1 = F.r1(listV);
        }
        List<JvmProtoBuf.StringTableTypes.Record> listW = types.w();
        p.h(listW, "getRecordList(...)");
        super(strings, setR1, C4070g.a(listW));
        this.f32585h = types;
    }
}
