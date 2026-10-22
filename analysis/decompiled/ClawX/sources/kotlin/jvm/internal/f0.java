package kotlin.jvm.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlinx.serialization.internal.CollectionDescriptorsKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f0 implements v5.i {

    /* renamed from: a, reason: collision with root package name */
    public final v5.d f3670a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3671b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3672c;

    public f0(v5.d classifier, List arguments, int i8) {
        p.e(classifier, "classifier");
        p.e(arguments, "arguments");
        this.f3670a = classifier;
        this.f3671b = arguments;
        this.f3672c = i8;
    }

    public final String a(boolean z) {
        v5.d dVar = this.f3670a;
        v5.c cVar = dVar instanceof v5.c ? (v5.c) dVar : null;
        Class clsI = cVar != null ? k4.v.I(cVar) : null;
        String string = clsI == null ? dVar.toString() : (this.f3672c & 4) != 0 ? "kotlin.Nothing" : clsI.isArray() ? clsI.equals(boolean[].class) ? "kotlin.BooleanArray" : clsI.equals(char[].class) ? "kotlin.CharArray" : clsI.equals(byte[].class) ? "kotlin.ByteArray" : clsI.equals(short[].class) ? "kotlin.ShortArray" : clsI.equals(int[].class) ? "kotlin.IntArray" : clsI.equals(float[].class) ? "kotlin.FloatArray" : clsI.equals(long[].class) ? "kotlin.LongArray" : clsI.equals(double[].class) ? "kotlin.DoubleArray" : CollectionDescriptorsKt.ARRAY_NAME : (z && clsI.isPrimitive()) ? k4.v.J((v5.c) dVar).getName() : clsI.getName();
        boolean zIsEmpty = this.f3671b.isEmpty();
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        String strA0 = zIsEmpty ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : c5.m.A0(this.f3671b, ", ", "<", ">", new c5.a(9, this), 24);
        if (isMarkedNullable()) {
            str = "?";
        }
        return a8.b.o(string, strA0, str);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return p.a(this.f3670a, f0Var.f3670a) && p.a(this.f3671b, f0Var.f3671b) && this.f3672c == f0Var.f3672c;
    }

    @Override // v5.a
    public final List getAnnotations() {
        return c5.s.f1092a;
    }

    @Override // v5.i
    public final List getArguments() {
        return this.f3671b;
    }

    @Override // v5.i
    public final v5.d getClassifier() {
        return this.f3670a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3672c) + ((this.f3671b.hashCode() + (this.f3670a.hashCode() * 31)) * 31);
    }

    @Override // v5.i
    public final boolean isMarkedNullable() {
        return (this.f3672c & 1) != 0;
    }

    public final String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }
}
