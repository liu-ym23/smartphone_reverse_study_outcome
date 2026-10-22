package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.q;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.o;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypesJVMKt {
    public static final /* synthetic */ String a(Type r10) {
        return b(r10);
    }

    public static final String b(Type r10) {
        if ((r10 instanceof Class) == false) goto L10;
        Class r11 = (Class) r10;
        if (r11.isArray() == false) goto L7;
        Sequence r12 = SequencesKt__SequencesKt.f(r10, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        String r13 = ((Class) SequencesKt___SequencesKt.r(r12)).getName() + o.t("[]", SequencesKt___SequencesKt.i(r12));
    L8:
        q.d(r13);
        return r13;
    L7:
        r13 = r11.getName();
        goto L8
    L10:
        return r10.toString();
    }
}
