package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;

/* loaded from: classes.dex */
public class E<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<K, V> f13438a;

    /* renamed from: b, reason: collision with root package name */
    public final K f13439b;

    /* renamed from: c, reason: collision with root package name */
    public final V f13440c;

    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f13441a;

        /* renamed from: b, reason: collision with root package name */
        public final K f13442b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f13443c;

        /* renamed from: d, reason: collision with root package name */
        public final V f13444d;

        public a(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
            this.f13441a = fieldType;
            this.f13442b = k10;
            this.f13443c = fieldType2;
            this.f13444d = v10;
        }
    }

    public E(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        this.f13438a = new a<>(fieldType, k10, fieldType2, v10);
        this.f13439b = k10;
        this.f13440c = v10;
    }

    public static <K, V> int b(a<K, V> aVar, K k10, V v10) {
        return C1355s.d(aVar.f13441a, 1, k10) + C1355s.d(aVar.f13443c, 2, v10);
    }

    public static <K, V> E<K, V> d(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        return new E<>(fieldType, k10, fieldType2, v10);
    }

    public static <K, V> void e(CodedOutputStream codedOutputStream, a<K, V> aVar, K k10, V v10) throws IOException {
        C1355s.z(codedOutputStream, aVar.f13441a, 1, k10);
        C1355s.z(codedOutputStream, aVar.f13443c, 2, v10);
    }

    public int a(int i10, K k10, V v10) {
        return CodedOutputStream.V(i10) + CodedOutputStream.C(b(this.f13438a, k10, v10));
    }

    public a<K, V> c() {
        return this.f13438a;
    }
}
