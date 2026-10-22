package kotlin.reflect.jvm.internal.impl.metadata;

/* loaded from: classes4.dex */
public enum ProtoBuf$Modality implements H8.m {
    /* JADX INFO: Fake field, exist only in values array */
    FINAL(0),
    /* JADX INFO: Fake field, exist only in values array */
    OPEN(1),
    /* JADX INFO: Fake field, exist only in values array */
    ABSTRACT(2),
    /* JADX INFO: Fake field, exist only in values array */
    SEALED(3);


    /* renamed from: a, reason: collision with root package name */
    public final int f5054a;

    ProtoBuf$Modality(int i) {
        this.f5054a = i;
    }

    @Override // H8.m
    public final int getNumber() {
        return this.f5054a;
    }
}
