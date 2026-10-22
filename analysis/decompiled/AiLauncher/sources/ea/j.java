package ea;

import Z8.C1173v;
import Z8.F;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final a f32424b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final j f32425c = new j(C1173v.m());

    /* renamed from: a, reason: collision with root package name */
    public final List<ProtoBuf$VersionRequirement> f32426a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final j a(ProtoBuf$VersionRequirementTable table) {
            p.i(table, "table");
            if (table.t() == 0) {
                return b();
            }
            List<ProtoBuf$VersionRequirement> listU = table.u();
            p.h(listU, "getRequirementList(...)");
            return new j(listU, null);
        }

        public final j b() {
            return j.f32425c;
        }

        public a() {
        }
    }

    public /* synthetic */ j(List list, kotlin.jvm.internal.i iVar) {
        this(list);
    }

    public final ProtoBuf$VersionRequirement b(int i10) {
        return (ProtoBuf$VersionRequirement) F.t0(this.f32426a, i10);
    }

    public j(List<ProtoBuf$VersionRequirement> list) {
        this.f32426a = list;
    }
}
