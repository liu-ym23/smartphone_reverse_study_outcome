package com.stepos.datacenter.vector;

import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.StorageDType;
import h9.InterfaceC4149a;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlinx.serialization.KSerializer;
import lb.l;
import p9.InterfaceC5063a;
import pb.I;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/datacenter/vector/StorageDType;", "", "", "bytesPerElement", "<init>", "(Ljava/lang/String;II)V", "I", "getBytesPerElement", "()I", "Companion", Const.INTENT_KEY_APIKEY, "FP32", "FP16", "INT8", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final class StorageDType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ StorageDType[] $VALUES;
    private static final h<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int bytesPerElement;
    public static final StorageDType FP32 = new StorageDType("FP32", 0, 4);
    public static final StorageDType FP16 = new StorageDType("FP16", 1, 2);
    public static final StorageDType INT8 = new StorageDType("INT8", 2, 1);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/vector/StorageDType$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/StorageDType;", "serializer", "()Lkotlinx/serialization/KSerializer;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.StorageDType$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) StorageDType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<StorageDType> serializer() {
            return a();
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }
    }

    private static final /* synthetic */ StorageDType[] $values() {
        return new StorageDType[]{FP32, FP16, INT8};
    }

    static {
        StorageDType[] storageDTypeArr$values = $values();
        $VALUES = storageDTypeArr$values;
        $ENTRIES = a.a(storageDTypeArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: e7.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StorageDType._init_$_anonymous_();
            }
        });
    }

    private StorageDType(String str, int i10, int i11) {
        this.bytesPerElement = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return I.a("com.stepos.datacenter.vector.StorageDType", values());
    }

    public static InterfaceC4149a<StorageDType> getEntries() {
        return $ENTRIES;
    }

    public static StorageDType valueOf(String str) {
        return (StorageDType) Enum.valueOf(StorageDType.class, str);
    }

    public static StorageDType[] values() {
        return (StorageDType[]) $VALUES.clone();
    }

    public final int getBytesPerElement() {
        return this.bytesPerElement;
    }
}
