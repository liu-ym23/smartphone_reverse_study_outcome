package T8;

import H8.AbstractC0241b;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;

/* loaded from: classes4.dex */
public final class s implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1232a;
    public final v b;
    public final AbstractC0241b c;
    public final AnnotatedCallableKind d;

    public /* synthetic */ s(v vVar, AbstractC0241b abstractC0241b, AnnotatedCallableKind annotatedCallableKind, int i) {
        this.f1232a = i;
        this.b = vVar;
        this.c = abstractC0241b;
        this.d = annotatedCallableKind;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1232a) {
            case 0:
                v vVar = this.b;
                m mVar = vVar.f1235a;
                J5.b bVarA = vVar.a(mVar.c);
                List listF1 = bVarA != null ? D7.v.f1(mVar.f1228a.e.s0(bVarA, this.c, this.d)) : null;
                if (listF1 == null) {
                    break;
                }
                break;
            default:
                v vVar2 = this.b;
                m mVar2 = vVar2.f1235a;
                J5.b bVarA2 = vVar2.a(mVar2.c);
                List listG = bVarA2 != null ? mVar2.f1228a.e.G(bVarA2, this.c, this.d) : null;
                if (listG == null) {
                    break;
                }
                break;
        }
        return EmptyList.f4893a;
    }
}
