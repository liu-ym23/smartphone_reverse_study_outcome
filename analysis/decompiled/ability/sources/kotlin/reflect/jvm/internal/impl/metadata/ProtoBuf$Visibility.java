package kotlin.reflect.jvm.internal.impl.metadata;

/* loaded from: classes4.dex */
public enum ProtoBuf$Visibility implements H8.m {
    /* JADX INFO: Fake field, exist only in values array */
    INTERNAL(0),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE(1),
    /* JADX INFO: Fake field, exist only in values array */
    PROTECTED(2),
    /* JADX INFO: Fake field, exist only in values array */
    PUBLIC(3),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE_TO_THIS(4),
    /* JADX INFO: Fake field, exist only in values array */
    LOCAL(5);


    /* renamed from: a, reason: collision with root package name */
    public final int f5084a;

    ProtoBuf$Visibility(int i) {
        this.f5084a = i;
    }

    @Override // H8.m
    public final int getNumber() {
        return this.f5084a;
    }
}
