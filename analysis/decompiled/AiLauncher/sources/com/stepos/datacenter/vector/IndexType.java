package com.stepos.datacenter.vector;

import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.IndexType;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/datacenter/vector/IndexType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", Const.INTENT_KEY_APIKEY, "FLAT", "IVF_FLAT", "IVF_SQ8", "IVF_PQ", "HNSW", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final class IndexType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ IndexType[] $VALUES;
    private static final h<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final IndexType FLAT = new IndexType("FLAT", 0);
    public static final IndexType IVF_FLAT = new IndexType("IVF_FLAT", 1);
    public static final IndexType IVF_SQ8 = new IndexType("IVF_SQ8", 2);
    public static final IndexType IVF_PQ = new IndexType("IVF_PQ", 3);
    public static final IndexType HNSW = new IndexType("HNSW", 4);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/vector/IndexType$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/IndexType;", "serializer", "()Lkotlinx/serialization/KSerializer;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.IndexType$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) IndexType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<IndexType> serializer() {
            return a();
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }
    }

    private static final /* synthetic */ IndexType[] $values() {
        return new IndexType[]{FLAT, IVF_FLAT, IVF_SQ8, IVF_PQ, HNSW};
    }

    static {
        IndexType[] indexTypeArr$values = $values();
        $VALUES = indexTypeArr$values;
        $ENTRIES = a.a(indexTypeArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: e7.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return IndexType._init_$_anonymous_();
            }
        });
    }

    private IndexType(String str, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return I.a("com.stepos.datacenter.vector.IndexType", values());
    }

    public static InterfaceC4149a<IndexType> getEntries() {
        return $ENTRIES;
    }

    public static IndexType valueOf(String str) {
        return (IndexType) Enum.valueOf(IndexType.class, str);
    }

    public static IndexType[] values() {
        return (IndexType[]) $VALUES.clone();
    }
}
