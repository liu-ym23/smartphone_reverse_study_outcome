package ea;

import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final List<ProtoBuf$Type> f32411a;

    public h(ProtoBuf$TypeTable typeTable) {
        p.i(typeTable, "typeTable");
        List<ProtoBuf$Type> listY = typeTable.y();
        if (typeTable.z()) {
            int iV = typeTable.v();
            List<ProtoBuf$Type> listY2 = typeTable.y();
            p.h(listY2, "getTypeList(...)");
            List<ProtoBuf$Type> list = listY2;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                ProtoBuf$Type protoBuf$TypeR = (ProtoBuf$Type) obj;
                if (i10 >= iV) {
                    protoBuf$TypeR = protoBuf$TypeR.toBuilder().K(true).build();
                }
                arrayList.add(protoBuf$TypeR);
                i10 = i11;
            }
            listY = arrayList;
        }
        p.h(listY, "run(...)");
        this.f32411a = listY;
    }

    public final ProtoBuf$Type a(int i10) {
        return this.f32411a.get(i10);
    }
}
