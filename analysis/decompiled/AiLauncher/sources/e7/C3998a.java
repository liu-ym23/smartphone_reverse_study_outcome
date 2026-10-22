package e7;

import La.C;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.vector.CollectionDescriptor;
import com.stepos.datacenter.vector.IndexType;
import com.zyql.ai.selector.config.PictureConfig;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Le7/a;", "", "<init>", "()V", "", "vectorCount", "threshold", "Lcom/stepos/datacenter/vector/IndexType;", "c", "(II)Lcom/stepos/datacenter/vector/IndexType;", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "descriptor", Const.INTENT_KEY_UMID, "(Lcom/stepos/datacenter/vector/CollectionDescriptor;I)Lcom/stepos/datacenter/vector/IndexType;", "current", "upgradeThreshold", "downgradeThreshold", "Le7/a$a;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/datacenter/vector/IndexType;III)Le7/a$a;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/datacenter/vector/CollectionDescriptor;Lcom/stepos/datacenter/vector/IndexType;I)Le7/a$a;", "rawDim", "dtypeBytes", "budgetMb", "e", "(III)I", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3998a {

    /* renamed from: a, reason: collision with root package name */
    public static final C3998a f32294a = new C3998a();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0014\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Le7/a$a;", "", "Lcom/stepos/datacenter/vector/IndexType;", "current", "recommended", "", "shouldSwitch", "", "upgradeThreshold", "downgradeThreshold", "<init>", "(Lcom/stepos/datacenter/vector/IndexType;Lcom/stepos/datacenter/vector/IndexType;ZII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/vector/IndexType;", "getCurrent", "()Lcom/stepos/datacenter/vector/IndexType;", Const.INTENT_KEY_PKGNAME, "getRecommended", "c", "Z", "()Z", Const.INTENT_KEY_UMID, "I", "getUpgradeThreshold", "e", "getDowngradeThreshold", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class SwitchDecision {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final IndexType current;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final IndexType recommended;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean shouldSwitch;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final int upgradeThreshold;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final int downgradeThreshold;

        public SwitchDecision(IndexType current, IndexType recommended, boolean z10, int i10, int i11) {
            kotlin.jvm.internal.p.i(current, "current");
            kotlin.jvm.internal.p.i(recommended, "recommended");
            this.current = current;
            this.recommended = recommended;
            this.shouldSwitch = z10;
            this.upgradeThreshold = i10;
            this.downgradeThreshold = i11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShouldSwitch() {
            return this.shouldSwitch;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SwitchDecision)) {
                return false;
            }
            SwitchDecision switchDecision = (SwitchDecision) other;
            return this.current == switchDecision.current && this.recommended == switchDecision.recommended && this.shouldSwitch == switchDecision.shouldSwitch && this.upgradeThreshold == switchDecision.upgradeThreshold && this.downgradeThreshold == switchDecision.downgradeThreshold;
        }

        public int hashCode() {
            return (((((((this.current.hashCode() * 31) + this.recommended.hashCode()) * 31) + Boolean.hashCode(this.shouldSwitch)) * 31) + Integer.hashCode(this.upgradeThreshold)) * 31) + Integer.hashCode(this.downgradeThreshold);
        }

        public String toString() {
            return "SwitchDecision(current=" + this.current + ", recommended=" + this.recommended + ", shouldSwitch=" + this.shouldSwitch + ", upgradeThreshold=" + this.upgradeThreshold + ", downgradeThreshold=" + this.downgradeThreshold + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e7.a$b */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32300a;

        static {
            int[] iArr = new int[IndexType.values().length];
            try {
                iArr[IndexType.HNSW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexType.IVF_FLAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexType.IVF_SQ8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexType.IVF_PQ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f32300a = iArr;
        }
    }

    public static /* synthetic */ int f(C3998a c3998a, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 2;
        }
        if ((i13 & 4) != 0) {
            i12 = 200;
        }
        return c3998a.e(i10, i11, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e7.C3998a.SwitchDecision a(com.stepos.datacenter.vector.IndexType r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            if (r9 > 0) goto L5
            r9 = 80000(0x13880, float:1.12104E-40)
        L5:
            r4 = r9
            if (r10 > 0) goto Lb
            r10 = 64000(0xfa00, float:8.9683E-41)
        Lb:
            int r5 = v9.C5685n.j(r10, r4)
            if (r7 != 0) goto L13
            com.stepos.datacenter.vector.IndexType r7 = com.stepos.datacenter.vector.IndexType.HNSW
        L13:
            r1 = r7
            int[] r6 = e7.C3998a.b.f32300a
            int r7 = r1.ordinal()
            r6 = r6[r7]
            r7 = 1
            if (r6 == r7) goto L3b
            r9 = 2
            if (r6 == r9) goto L33
            r9 = 3
            if (r6 == r9) goto L31
            r9 = 4
            if (r6 == r9) goto L31
            if (r8 >= r4) goto L2e
            com.stepos.datacenter.vector.IndexType r6 = com.stepos.datacenter.vector.IndexType.HNSW
        L2c:
            r2 = r6
            goto L43
        L2e:
            com.stepos.datacenter.vector.IndexType r6 = com.stepos.datacenter.vector.IndexType.IVF_FLAT
            goto L2c
        L31:
            r2 = r1
            goto L43
        L33:
            if (r8 > r5) goto L38
            com.stepos.datacenter.vector.IndexType r6 = com.stepos.datacenter.vector.IndexType.HNSW
            goto L2c
        L38:
            com.stepos.datacenter.vector.IndexType r6 = com.stepos.datacenter.vector.IndexType.IVF_FLAT
            goto L2c
        L3b:
            if (r8 < r4) goto L40
            com.stepos.datacenter.vector.IndexType r6 = com.stepos.datacenter.vector.IndexType.IVF_FLAT
            goto L2c
        L40:
            com.stepos.datacenter.vector.IndexType r6 = com.stepos.datacenter.vector.IndexType.HNSW
            goto L2c
        L43:
            r6 = 0
            if (r1 != r2) goto L48
        L46:
            r3 = r6
            goto L52
        L48:
            com.stepos.datacenter.vector.IndexType r8 = com.stepos.datacenter.vector.IndexType.IVF_SQ8
            if (r1 == r8) goto L46
            com.stepos.datacenter.vector.IndexType r8 = com.stepos.datacenter.vector.IndexType.IVF_PQ
            if (r1 != r8) goto L51
            goto L46
        L51:
            r3 = r7
        L52:
            e7.a$a r0 = new e7.a$a
            r0.<init>(r1, r2, r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e7.C3998a.a(com.stepos.datacenter.vector.IndexType, int, int, int):e7.a$a");
    }

    public final SwitchDecision b(CollectionDescriptor descriptor, IndexType current, int vectorCount) {
        Integer numW;
        C3998a c3998a;
        int iF;
        Integer numW2;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        String str = descriptor.getExtra().get("algorithm_upgrade_threshold");
        if (str == null || (numW = C.w(str)) == null) {
            String str2 = descriptor.getExtra().get("algorithm_threshold");
            numW = str2 != null ? C.w(str2) : null;
        }
        String str3 = descriptor.getExtra().get("algorithm_budget_mb");
        int iIntValue = (str3 == null || (numW2 = C.w(str3)) == null) ? 200 : numW2.intValue();
        if (numW != null) {
            iF = numW.intValue();
            c3998a = this;
        } else {
            c3998a = this;
            iF = f(c3998a, descriptor.getRawDim(), 0, iIntValue, 2, null);
        }
        String str4 = descriptor.getExtra().get("algorithm_downgrade_threshold");
        Integer numW3 = str4 != null ? C.w(str4) : null;
        return c3998a.a(current, vectorCount, iF, numW3 != null ? numW3.intValue() : (int) C5685n.k((iF * 4) / 5, 2147483647L));
    }

    public final IndexType c(int vectorCount, int threshold) {
        if (threshold <= 0) {
            threshold = 80000;
        }
        return vectorCount < threshold ? IndexType.HNSW : IndexType.IVF_FLAT;
    }

    public final IndexType d(CollectionDescriptor descriptor, int vectorCount) {
        int iIntValue;
        Integer numW;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        String str = descriptor.getExtra().get("algorithm_threshold");
        if (str == null || (numW = C.w(str)) == null) {
            String str2 = descriptor.getExtra().get("algorithm_upgrade_threshold");
            Integer numW2 = str2 != null ? C.w(str2) : null;
            iIntValue = numW2 != null ? numW2.intValue() : 80000;
        } else {
            iIntValue = numW.intValue();
        }
        return c(vectorCount, iIntValue);
    }

    public final int e(int rawDim, int dtypeBytes, int budgetMb) {
        if (rawDim <= 0 || dtypeBytes <= 0 || budgetMb <= 0) {
            return 80000;
        }
        return (int) C5685n.k(C5685n.g((budgetMb * PictureConfig.MB) / ((rawDim * dtypeBytes) + 200), 1000L), 2147483647L);
    }
}
