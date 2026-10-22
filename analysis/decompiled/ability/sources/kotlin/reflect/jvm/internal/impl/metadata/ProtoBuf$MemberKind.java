package kotlin.reflect.jvm.internal.impl.metadata;

/* loaded from: classes4.dex */
public enum ProtoBuf$MemberKind implements H8.m {
    /* JADX INFO: Fake field, exist only in values array */
    DECLARATION(0),
    /* JADX INFO: Fake field, exist only in values array */
    FAKE_OVERRIDE(1),
    /* JADX INFO: Fake field, exist only in values array */
    DELEGATION(2),
    /* JADX INFO: Fake field, exist only in values array */
    SYNTHESIZED(3);


    /* renamed from: a, reason: collision with root package name */
    public final int f5053a;

    ProtoBuf$MemberKind(int i) {
        this.f5053a = i;
    }

    @Override // H8.m
    public final int getNumber() {
        return this.f5053a;
    }
}
