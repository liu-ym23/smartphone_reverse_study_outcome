package com.stepos.datacenter.vector;

import Y8.h;
import Y8.j;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.IndexLifecycle;
import h9.InterfaceC4149a;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import lb.l;
import p9.InterfaceC5063a;
import pb.I;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/datacenter/vector/IndexLifecycle;", "", "<init>", "(Ljava/lang/String;I)V", "next", "", "canTransitionTo", "(Lcom/stepos/datacenter/vector/IndexLifecycle;)Z", "isTerminal", "()Z", "isServingReads", "isServingWrites", "Companion", Const.INTENT_KEY_APIKEY, "CREATED", "TRAINING", "CATCHING_UP", "READY", "PRIMARY", "DEPRECATED", "FAILED", "DELETED", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final class IndexLifecycle {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ IndexLifecycle[] $VALUES;
    private static final h<KSerializer<Object>> $cachedSerializer$delegate;
    public static final IndexLifecycle CATCHING_UP;
    public static final IndexLifecycle CREATED;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final IndexLifecycle DELETED;
    public static final IndexLifecycle DEPRECATED;
    public static final IndexLifecycle FAILED;
    public static final IndexLifecycle PRIMARY;
    public static final IndexLifecycle READY;
    public static final IndexLifecycle TRAINING;
    private static final Map<IndexLifecycle, Set<IndexLifecycle>> validTransitions;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/datacenter/vector/IndexLifecycle$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/IndexLifecycle;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "", "validTransitions", "Ljava/util/Map;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.IndexLifecycle$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) IndexLifecycle.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<IndexLifecycle> serializer() {
            return a();
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ IndexLifecycle[] $values() {
        return new IndexLifecycle[]{CREATED, TRAINING, CATCHING_UP, READY, PRIMARY, DEPRECATED, FAILED, DELETED};
    }

    static {
        IndexLifecycle indexLifecycle = new IndexLifecycle("CREATED", 0);
        CREATED = indexLifecycle;
        IndexLifecycle indexLifecycle2 = new IndexLifecycle("TRAINING", 1);
        TRAINING = indexLifecycle2;
        IndexLifecycle indexLifecycle3 = new IndexLifecycle("CATCHING_UP", 2);
        CATCHING_UP = indexLifecycle3;
        IndexLifecycle indexLifecycle4 = new IndexLifecycle("READY", 3);
        READY = indexLifecycle4;
        IndexLifecycle indexLifecycle5 = new IndexLifecycle("PRIMARY", 4);
        PRIMARY = indexLifecycle5;
        IndexLifecycle indexLifecycle6 = new IndexLifecycle("DEPRECATED", 5);
        DEPRECATED = indexLifecycle6;
        IndexLifecycle indexLifecycle7 = new IndexLifecycle("FAILED", 6);
        FAILED = indexLifecycle7;
        IndexLifecycle indexLifecycle8 = new IndexLifecycle("DELETED", 7);
        DELETED = indexLifecycle8;
        IndexLifecycle[] indexLifecycleArr$values = $values();
        $VALUES = indexLifecycleArr$values;
        $ENTRIES = a.a(indexLifecycleArr$values);
        INSTANCE = new Companion(null);
        validTransitions = kotlin.collections.a.m(j.a(indexLifecycle, Y.j(indexLifecycle2, indexLifecycle7, indexLifecycle8)), j.a(indexLifecycle2, Y.j(indexLifecycle3, indexLifecycle4, indexLifecycle7)), j.a(indexLifecycle3, Y.j(indexLifecycle4, indexLifecycle7)), j.a(indexLifecycle4, Y.j(indexLifecycle5, indexLifecycle6, indexLifecycle7, indexLifecycle8)), j.a(indexLifecycle5, Y.j(indexLifecycle6, indexLifecycle7)), j.a(indexLifecycle6, Y.j(indexLifecycle5, indexLifecycle8)), j.a(indexLifecycle7, Y.j(indexLifecycle2, indexLifecycle8)), j.a(indexLifecycle8, Y.e()));
        $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: e7.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return IndexLifecycle._init_$_anonymous_();
            }
        });
    }

    private IndexLifecycle(String str, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return I.a("com.stepos.datacenter.vector.IndexLifecycle", values());
    }

    public static InterfaceC4149a<IndexLifecycle> getEntries() {
        return $ENTRIES;
    }

    public static IndexLifecycle valueOf(String str) {
        return (IndexLifecycle) Enum.valueOf(IndexLifecycle.class, str);
    }

    public static IndexLifecycle[] values() {
        return (IndexLifecycle[]) $VALUES.clone();
    }

    public final boolean canTransitionTo(IndexLifecycle next) {
        p.i(next, "next");
        return ((Set) kotlin.collections.a.j(validTransitions, this)).contains(next);
    }

    public final boolean isServingReads() {
        return this == PRIMARY || this == DEPRECATED;
    }

    public final boolean isServingWrites() {
        return this == PRIMARY || this == DEPRECATED || this == CATCHING_UP;
    }

    public final boolean isTerminal() {
        return this == DELETED;
    }
}
