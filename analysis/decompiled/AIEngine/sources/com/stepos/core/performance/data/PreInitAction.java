package com.stepos.core.performance.data;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PreInitAction {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class EvictAll extends PreInitAction {
        private final boolean needsGc;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EvictAll(String reason, boolean z) {
            super(null);
            g.f(reason, "reason");
            this.reason = reason;
            this.needsGc = z;
        }

        public static /* synthetic */ EvictAll copy$default(EvictAll evictAll, String str, boolean z, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = evictAll.reason;
            }
            if ((i10 & 2) != 0) {
                z = evictAll.needsGc;
            }
            return evictAll.copy(str, z);
        }

        public final String component1() {
            return this.reason;
        }

        public final boolean component2() {
            return this.needsGc;
        }

        public final EvictAll copy(String reason, boolean z) {
            g.f(reason, "reason");
            return new EvictAll(reason, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EvictAll)) {
                return false;
            }
            EvictAll evictAll = (EvictAll) obj;
            return g.b(this.reason, evictAll.reason) && this.needsGc == evictAll.needsGc;
        }

        public final boolean getNeedsGc() {
            return this.needsGc;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return Boolean.hashCode(this.needsGc) + (this.reason.hashCode() * 31);
        }

        public String toString() {
            return "EvictAll(reason=" + this.reason + ", needsGc=" + this.needsGc + ")";
        }

        public /* synthetic */ EvictAll(String str, boolean z, int i10, e eVar) {
            this(str, (i10 & 2) != 0 ? false : z);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class EvictCategory extends PreInitAction {
        private final ModelCategory category;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EvictCategory(ModelCategory category, String reason) {
            super(null);
            g.f(category, "category");
            g.f(reason, "reason");
            this.category = category;
            this.reason = reason;
        }

        public static /* synthetic */ EvictCategory copy$default(EvictCategory evictCategory, ModelCategory modelCategory, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                modelCategory = evictCategory.category;
            }
            if ((i10 & 2) != 0) {
                str = evictCategory.reason;
            }
            return evictCategory.copy(modelCategory, str);
        }

        public final ModelCategory component1() {
            return this.category;
        }

        public final String component2() {
            return this.reason;
        }

        public final EvictCategory copy(ModelCategory category, String reason) {
            g.f(category, "category");
            g.f(reason, "reason");
            return new EvictCategory(category, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EvictCategory)) {
                return false;
            }
            EvictCategory evictCategory = (EvictCategory) obj;
            return this.category == evictCategory.category && g.b(this.reason, evictCategory.reason);
        }

        public final ModelCategory getCategory() {
            return this.category;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode() + (this.category.hashCode() * 31);
        }

        public String toString() {
            return "EvictCategory(category=" + this.category + ", reason=" + this.reason + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class EvictToRetain extends PreInitAction {
        private final String reason;
        private final int retainMb;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EvictToRetain(int i10, String reason) {
            super(null);
            g.f(reason, "reason");
            this.retainMb = i10;
            this.reason = reason;
        }

        public static /* synthetic */ EvictToRetain copy$default(EvictToRetain evictToRetain, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = evictToRetain.retainMb;
            }
            if ((i11 & 2) != 0) {
                str = evictToRetain.reason;
            }
            return evictToRetain.copy(i10, str);
        }

        public final int component1() {
            return this.retainMb;
        }

        public final String component2() {
            return this.reason;
        }

        public final EvictToRetain copy(int i10, String reason) {
            g.f(reason, "reason");
            return new EvictToRetain(i10, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EvictToRetain)) {
                return false;
            }
            EvictToRetain evictToRetain = (EvictToRetain) obj;
            return this.retainMb == evictToRetain.retainMb && g.b(this.reason, evictToRetain.reason);
        }

        public final String getReason() {
            return this.reason;
        }

        public final int getRetainMb() {
            return this.retainMb;
        }

        public int hashCode() {
            return this.reason.hashCode() + (Integer.hashCode(this.retainMb) * 31);
        }

        public String toString() {
            return "EvictToRetain(retainMb=" + this.retainMb + ", reason=" + this.reason + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NoOp extends PreInitAction {
        public static final NoOp INSTANCE = new NoOp();

        private NoOp() {
            super(null);
        }
    }

    public /* synthetic */ PreInitAction(e eVar) {
        this();
    }

    private PreInitAction() {
    }
}
