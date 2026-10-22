package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
abstract class WireFormat$Utf8Validation {

    /* renamed from: a, reason: collision with root package name */
    public static final AnonymousClass1 f2890a;
    public static final AnonymousClass2 b;
    public static final /* synthetic */ WireFormat$Utf8Validation[] c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.protobuf.WireFormat$Utf8Validation$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.WireFormat$Utf8Validation$2] */
    static {
        ?? r02 = new WireFormat$Utf8Validation() { // from class: com.google.protobuf.WireFormat$Utf8Validation.1
            @Override // com.google.protobuf.WireFormat$Utf8Validation
            public final Object a(AbstractC0972o abstractC0972o) {
                return abstractC0972o.B();
            }
        };
        f2890a = r02;
        ?? r1 = new WireFormat$Utf8Validation() { // from class: com.google.protobuf.WireFormat$Utf8Validation.2
            @Override // com.google.protobuf.WireFormat$Utf8Validation
            public final Object a(AbstractC0972o abstractC0972o) {
                return abstractC0972o.C();
            }
        };
        b = r1;
        c = new WireFormat$Utf8Validation[]{r02, r1, new WireFormat$Utf8Validation() { // from class: com.google.protobuf.WireFormat$Utf8Validation.3
            @Override // com.google.protobuf.WireFormat$Utf8Validation
            public final Object a(AbstractC0972o abstractC0972o) {
                return abstractC0972o.l();
            }
        }};
    }

    public static WireFormat$Utf8Validation valueOf(String str) {
        return (WireFormat$Utf8Validation) Enum.valueOf(WireFormat$Utf8Validation.class, str);
    }

    public static WireFormat$Utf8Validation[] values() {
        return (WireFormat$Utf8Validation[]) c.clone();
    }

    public abstract Object a(AbstractC0972o abstractC0972o);
}
