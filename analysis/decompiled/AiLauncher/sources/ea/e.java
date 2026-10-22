package ea;

import Z8.F;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;

/* loaded from: classes5.dex */
public final class e implements InterfaceC4020d {

    /* renamed from: a, reason: collision with root package name */
    public final ProtoBuf$StringTable f32408a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtoBuf$QualifiedNameTable f32409b;

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32410a;

        static {
            int[] iArr = new int[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f32410a = iArr;
        }
    }

    public e(ProtoBuf$StringTable strings, ProtoBuf$QualifiedNameTable qualifiedNames) {
        p.i(strings, "strings");
        p.i(qualifiedNames, "qualifiedNames");
        this.f32408a = strings;
        this.f32409b = qualifiedNames;
    }

    @Override // ea.InterfaceC4020d
    public boolean a(int i10) {
        return c(i10).f().booleanValue();
    }

    @Override // ea.InterfaceC4020d
    public String b(int i10) {
        Triple<List<String>, List<String>, Boolean> tripleC = c(i10);
        List<String> listA = tripleC.a();
        String strA0 = F.A0(tripleC.b(), ".", null, null, 0, null, null, 62, null);
        if (listA.isEmpty()) {
            return strA0;
        }
        return F.A0(listA, "/", null, null, 0, null, null, 62, null) + JsonPointer.SEPARATOR + strA0;
    }

    public final Triple<List<String>, List<String>, Boolean> c(int i10) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z10 = false;
        while (i10 != -1) {
            ProtoBuf$QualifiedNameTable.QualifiedName qualifiedNameT = this.f32409b.t(i10);
            String strT = this.f32408a.t(qualifiedNameT.x());
            ProtoBuf$QualifiedNameTable.QualifiedName.Kind kindV = qualifiedNameT.v();
            p.f(kindV);
            int i11 = a.f32410a[kindV.ordinal()];
            if (i11 == 1) {
                linkedList2.addFirst(strT);
            } else if (i11 == 2) {
                linkedList.addFirst(strT);
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                linkedList2.addFirst(strT);
                z10 = true;
            }
            i10 = qualifiedNameT.w();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z10));
    }

    @Override // ea.InterfaceC4020d
    public String getString(int i10) {
        String strT = this.f32408a.t(i10);
        p.h(strT, "getString(...)");
        return strT;
    }
}
