package H8;

import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType;

/* loaded from: classes4.dex */
public final class k implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f775a;
    public final WireFormat$FieldType b;
    public final boolean c;

    public k(int i, WireFormat$FieldType wireFormat$FieldType, boolean z10) {
        this.f775a = i;
        this.b = wireFormat$FieldType;
        this.c = z10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f775a - ((k) obj).f775a;
    }
}
