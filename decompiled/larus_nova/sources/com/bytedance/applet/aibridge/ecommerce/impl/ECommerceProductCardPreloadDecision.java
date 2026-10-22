package com.bytedance.applet.aibridge.ecommerce.impl;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface ECommerceProductCardPreloadDecision {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/ECommerceProductCardPreloadDecision$Reason;", "", "logValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogValue", "()Ljava/lang/String;", "EXPERIMENT_DISABLED", "INVALID_CONTEXT", "EMPTY_SCHEMA_LIST", "CARD_THROTTLED", "NOT_LATEST_MESSAGE", "NOT_NEW_MESSAGE", "EXPERIMENT_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason CARD_THROTTLED = null;
        public static final Reason EMPTY_SCHEMA_LIST = null;
        public static final Reason EXPERIMENT_CHANGED = null;
        public static final Reason EXPERIMENT_DISABLED = null;
        public static final Reason INVALID_CONTEXT = null;
        public static final Reason NOT_LATEST_MESSAGE = null;
        public static final Reason NOT_NEW_MESSAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f191103a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f191104b = null;
        private final String logValue;

        public static EnumEntries<Reason> getEntries() {
            return f191104b;
        }

        static {
            Reason r100 = new Reason("EXPERIMENT_DISABLED", 0, "experiment_disabled");
            EXPERIMENT_DISABLED = r100;
            Reason r101 = new Reason("INVALID_CONTEXT", 1, "invalid_context");
            INVALID_CONTEXT = r101;
            Reason r102 = new Reason("EMPTY_SCHEMA_LIST", 2, "empty_schema_list");
            EMPTY_SCHEMA_LIST = r102;
            Reason r103 = new Reason("CARD_THROTTLED", 3, "card_throttled");
            CARD_THROTTLED = r103;
            Reason r104 = new Reason("NOT_LATEST_MESSAGE", 4, "not_latest_message");
            NOT_LATEST_MESSAGE = r104;
            Reason r105 = new Reason("NOT_NEW_MESSAGE", 5, "not_new_message");
            NOT_NEW_MESSAGE = r105;
            Reason r110 = new Reason("EXPERIMENT_CHANGED", 6, "experiment_changed");
            EXPERIMENT_CHANGED = r110;
            Reason[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f191103a = r111;
            f191104b = EnumEntriesKt.enumEntries(r111);
        }

        public static Reason[] values() {
            return (Reason[]) f191103a.clone();
        }

        public final String getLogValue() {
            return this.logValue;
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public Reason(String r100, int r101, String r102) {
            super(r100, r101);
            this.logValue = r102;
        }
    }

    public static final class a implements ECommerceProductCardPreloadDecision {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f191105a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f191105a, ((a) r100).f191105a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f191105a.hashCode();
        }

        public final String toString() {
            return "Preloaded(schemaList=" + this.f191105a + ')';
        }

        public a(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "schemaList");
            this.f191105a = r100;
        }
    }

    public static final class b implements ECommerceProductCardPreloadDecision {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reason f191106a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f191106a == ((b) r100).f191106a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f191106a.hashCode();
        }

        public final String toString() {
            return "Skipped(reason=" + this.f191106a + ')';
        }

        public b(Reason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f191106a = r100;
        }
    }
}
