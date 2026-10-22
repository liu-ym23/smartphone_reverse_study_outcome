package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.PreferencesProto$Value;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c0<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<K, V> f1794a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat$FieldType f1795a;

        /* renamed from: b, reason: collision with root package name */
        public final WireFormat$FieldType f1796b;

        /* renamed from: c, reason: collision with root package name */
        public final V f1797c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2, Object obj) {
            this.f1795a = wireFormat$FieldType;
            this.f1796b = wireFormat$FieldType2;
            this.f1797c = obj;
        }
    }

    public c0(WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2, PreferencesProto$Value preferencesProto$Value) {
        this.f1794a = new a<>(wireFormat$FieldType, wireFormat$FieldType2, preferencesProto$Value);
    }

    public static <K, V> int a(a<K, V> aVar, K k9, V v3) {
        return q.b(aVar.f1796b, 2, v3) + q.b(aVar.f1795a, 1, k9);
    }

    public static <K, V> void b(CodedOutputStream codedOutputStream, a<K, V> aVar, K k9, V v3) {
        q.j(codedOutputStream, aVar.f1795a, 1, k9);
        q.j(codedOutputStream, aVar.f1796b, 2, v3);
    }
}
