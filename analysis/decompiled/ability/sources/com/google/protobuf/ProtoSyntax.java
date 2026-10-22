package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class ProtoSyntax {

    /* renamed from: a, reason: collision with root package name */
    public static final ProtoSyntax f2865a;
    public static final ProtoSyntax b;
    public static final ProtoSyntax c;
    public static final /* synthetic */ ProtoSyntax[] d;

    static {
        ProtoSyntax protoSyntax = new ProtoSyntax("PROTO2", 0);
        f2865a = protoSyntax;
        ProtoSyntax protoSyntax2 = new ProtoSyntax("PROTO3", 1);
        b = protoSyntax2;
        ProtoSyntax protoSyntax3 = new ProtoSyntax("EDITIONS", 2);
        c = protoSyntax3;
        d = new ProtoSyntax[]{protoSyntax, protoSyntax2, protoSyntax3};
    }

    public static ProtoSyntax valueOf(String str) {
        return (ProtoSyntax) Enum.valueOf(ProtoSyntax.class, str);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) d.clone();
    }
}
