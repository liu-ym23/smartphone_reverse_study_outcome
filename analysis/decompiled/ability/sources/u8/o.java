package u8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import m8.C1682b;
import t8.C2024a;
import z8.C2196h;

/* loaded from: classes4.dex */
public final class o implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6731a;
    public final p b;

    public /* synthetic */ o(p pVar, int i) {
        this.f6731a = i;
        this.b = pVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f6731a) {
            case 0:
                p pVar = this.b;
                C2196h c2196h = ((C2024a) pVar.h.f903a).l;
                pVar.e.b();
                c2196h.getClass();
                EmptyList emptyList = EmptyList.f4893a;
                ArrayList arrayList = new ArrayList();
                emptyList.getClass();
                return kotlin.collections.a.X(arrayList);
            case 1:
                this.b.g.getClass();
                return new ArrayList(D7.w.c0(EmptyList.f4893a, 10));
            default:
                HashMap map = new HashMap();
                for (Map.Entry entry : ((Map) S0.b.g1(this.b.i, p.m[0])).entrySet()) {
                    String str = (String) entry.getKey();
                    C1682b c1682b = (C1682b) entry.getValue();
                    O8.b bVarC = O8.b.c(str);
                    A8.a aVar = c1682b.b;
                    KotlinClassHeader$Kind kotlinClassHeader$Kind = (KotlinClassHeader$Kind) aVar.c;
                    int iOrdinal = kotlinClassHeader$Kind.ordinal();
                    if (iOrdinal == 2) {
                        map.put(bVarC, bVarC);
                    } else if (iOrdinal == 5) {
                        String str2 = (String) aVar.h;
                        if (kotlinClassHeader$Kind != KotlinClassHeader$Kind.i) {
                            str2 = null;
                        }
                        if (str2 != null) {
                            map.put(bVarC, O8.b.c(str2));
                        }
                    }
                }
                return map;
        }
    }
}
