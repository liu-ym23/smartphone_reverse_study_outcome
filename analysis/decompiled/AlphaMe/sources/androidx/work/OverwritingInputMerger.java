package androidx.work;

import androidx.room.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s0.C0850h;
import s0.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/work/OverwritingInputMerger;", "Ls0/l;", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends l {
    @Override // s0.l
    public final C0850h a(ArrayList inputs) throws Throwable {
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        z zVar = new z(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = inputs.iterator();
        while (it.hasNext()) {
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((C0850h) it.next()).f14201a);
            Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "input.keyValueMap");
            linkedHashMap.putAll(mapUnmodifiableMap);
        }
        zVar.d(linkedHashMap);
        C0850h c0850h = new C0850h(zVar.f4268a);
        C0850h.b(c0850h);
        Intrinsics.checkNotNullExpressionValue(c0850h, "output.build()");
        return c0850h;
    }
}
