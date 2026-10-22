package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Deprecated
/* loaded from: classes3.dex */
public final class Descriptors$FileDescriptor$Syntax {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors$FileDescriptor$Syntax f2825a;
    public static final Descriptors$FileDescriptor$Syntax b;
    public static final Descriptors$FileDescriptor$Syntax c;
    public static final /* synthetic */ Descriptors$FileDescriptor$Syntax[] d;

    /* JADX INFO: Fake field, exist only in values array */
    Descriptors$FileDescriptor$Syntax EF0;

    static {
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax = new Descriptors$FileDescriptor$Syntax("UNKNOWN", 0);
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax2 = new Descriptors$FileDescriptor$Syntax("PROTO2", 1);
        f2825a = descriptors$FileDescriptor$Syntax2;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax3 = new Descriptors$FileDescriptor$Syntax("PROTO3", 2);
        b = descriptors$FileDescriptor$Syntax3;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax4 = new Descriptors$FileDescriptor$Syntax("EDITIONS", 3);
        c = descriptors$FileDescriptor$Syntax4;
        d = new Descriptors$FileDescriptor$Syntax[]{descriptors$FileDescriptor$Syntax, descriptors$FileDescriptor$Syntax2, descriptors$FileDescriptor$Syntax3, descriptors$FileDescriptor$Syntax4};
    }

    public static Descriptors$FileDescriptor$Syntax valueOf(String str) {
        return (Descriptors$FileDescriptor$Syntax) Enum.valueOf(Descriptors$FileDescriptor$Syntax.class, str);
    }

    public static Descriptors$FileDescriptor$Syntax[] values() {
        return (Descriptors$FileDescriptor$Syntax[]) d.clone();
    }
}
