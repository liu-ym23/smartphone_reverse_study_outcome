package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ProtoSyntax {

    /* renamed from: a, reason: collision with root package name */
    public static final ProtoSyntax f1762a;

    /* renamed from: b, reason: collision with root package name */
    public static final ProtoSyntax f1763b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ProtoSyntax[] f1764c;

    static {
        ProtoSyntax protoSyntax = new ProtoSyntax("PROTO2", 0);
        f1762a = protoSyntax;
        ProtoSyntax protoSyntax2 = new ProtoSyntax("PROTO3", 1);
        f1763b = protoSyntax2;
        f1764c = new ProtoSyntax[]{protoSyntax, protoSyntax2};
    }

    public ProtoSyntax() {
        throw null;
    }

    public static ProtoSyntax valueOf(String str) {
        return (ProtoSyntax) Enum.valueOf(ProtoSyntax.class, str);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) f1764c.clone();
    }
}
