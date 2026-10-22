package com.stepos.datacenter.vector;

import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.DistanceMetric;
import h9.InterfaceC4149a;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlinx.serialization.KSerializer;
import lb.l;
import p9.InterfaceC5063a;
import pb.I;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/datacenter/vector/DistanceMetric;", "", "<init>", "(Ljava/lang/String;I)V", "", "toVectorMetricInt", "()I", "Companion", Const.INTENT_KEY_APIKEY, "L2", "IP", "COSINE", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final class DistanceMetric {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DistanceMetric[] $VALUES;
    private static final h<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: L2, reason: collision with root package name */
    public static final DistanceMetric f30107L2 = new DistanceMetric("L2", 0);
    public static final DistanceMetric IP = new DistanceMetric("IP", 1);
    public static final DistanceMetric COSINE = new DistanceMetric("COSINE", 2);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/vector/DistanceMetric$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/DistanceMetric;", "serializer", "()Lkotlinx/serialization/KSerializer;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.DistanceMetric$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) DistanceMetric.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<DistanceMetric> serializer() {
            return a();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30108a;

        static {
            int[] iArr = new int[DistanceMetric.values().length];
            try {
                iArr[DistanceMetric.f30107L2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DistanceMetric.IP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DistanceMetric.COSINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f30108a = iArr;
        }
    }

    private static final /* synthetic */ DistanceMetric[] $values() {
        return new DistanceMetric[]{f30107L2, IP, COSINE};
    }

    static {
        DistanceMetric[] distanceMetricArr$values = $values();
        $VALUES = distanceMetricArr$values;
        $ENTRIES = a.a(distanceMetricArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: e7.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DistanceMetric._init_$_anonymous_();
            }
        });
    }

    private DistanceMetric(String str, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return I.a("com.stepos.datacenter.vector.DistanceMetric", values());
    }

    public static InterfaceC4149a<DistanceMetric> getEntries() {
        return $ENTRIES;
    }

    public static DistanceMetric valueOf(String str) {
        return (DistanceMetric) Enum.valueOf(DistanceMetric.class, str);
    }

    public static DistanceMetric[] values() {
        return (DistanceMetric[]) $VALUES.clone();
    }

    public final int toVectorMetricInt() {
        int i10 = b.f30108a[ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
