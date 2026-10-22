package com.stepos.ailauncher.contract.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/contract/model/AccountStatus;", "", "<init>", "()V", "Available", "Banned", "Error", "Companion", "Lcom/stepos/ailauncher/contract/model/AccountStatus$Available;", "Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;", "Lcom/stepos/ailauncher/contract/model/AccountStatus$Error;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AccountStatus {
    public static final int ERROR_CODE_NETWORK = -1002;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/contract/model/AccountStatus$Available;", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Available extends AccountStatus {
        public static final Available INSTANCE = new Available();

        private Available() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Available);
        }

        public int hashCode() {
            return -2128988114;
        }

        public String toString() {
            return "Available";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "startMillis", "", "endMillis", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStartMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndMillis", "component1", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;", "equals", "", "other", "", "hashCode", "", "toString", "", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Banned extends AccountStatus {
        private final Long endMillis;
        private final Long startMillis;

        public Banned(Long l10, Long l11) {
            super(null);
            this.startMillis = l10;
            this.endMillis = l11;
        }

        public static /* synthetic */ Banned copy$default(Banned banned, Long l10, Long l11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                l10 = banned.startMillis;
            }
            if ((i10 & 2) != 0) {
                l11 = banned.endMillis;
            }
            return banned.copy(l10, l11);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getStartMillis() {
            return this.startMillis;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getEndMillis() {
            return this.endMillis;
        }

        public final Banned copy(Long startMillis, Long endMillis) {
            return new Banned(startMillis, endMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Banned)) {
                return false;
            }
            Banned banned = (Banned) other;
            return p.d(this.startMillis, banned.startMillis) && p.d(this.endMillis, banned.endMillis);
        }

        public final Long getEndMillis() {
            return this.endMillis;
        }

        public final Long getStartMillis() {
            return this.startMillis;
        }

        public int hashCode() {
            Long l10 = this.startMillis;
            int iHashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
            Long l11 = this.endMillis;
            return iHashCode + (l11 != null ? l11.hashCode() : 0);
        }

        public String toString() {
            return "Banned(startMillis=" + this.startMillis + ", endMillis=" + this.endMillis + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/contract/model/AccountStatus$Error;", "Lcom/stepos/ailauncher/contract/model/AccountStatus;", "code", "", "msg", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends AccountStatus {
        private final int code;
        private final String msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i10, String msg) {
            super(null);
            p.i(msg, "msg");
            this.code = i10;
            this.msg = msg;
        }

        public static /* synthetic */ Error copy$default(Error error, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = error.code;
            }
            if ((i11 & 2) != 0) {
                str = error.msg;
            }
            return error.copy(i10, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        public final Error copy(int code, String msg) {
            p.i(msg, "msg");
            return new Error(code, msg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.code == error.code && p.d(this.msg, error.msg);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.msg.hashCode();
        }

        public String toString() {
            return "Error(code=" + this.code + ", msg=" + this.msg + ")";
        }
    }

    public /* synthetic */ AccountStatus(i iVar) {
        this();
    }

    private AccountStatus() {
    }
}
