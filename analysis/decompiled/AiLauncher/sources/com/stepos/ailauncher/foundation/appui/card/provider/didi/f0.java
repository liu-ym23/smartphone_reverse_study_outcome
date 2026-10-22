package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$c;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface f0 {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "Lcom/google/gson/JsonObject;", "snapshot", "", D6.a.KEY_TASK_STATUS, "", "trackStatus", "nextPollAt", "<init>", "(Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/gson/JsonObject;", Const.INTENT_KEY_PKGNAME, "()Lcom/google/gson/JsonObject;", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$a, reason: from toString */
    public static final /* data */ class Ok implements f0 {
        private final String nextPollAt;
        private final JsonObject snapshot;
        private final Integer taskStatus;
        private final String trackStatus;

        public Ok(JsonObject snapshot, Integer num, String str, String str2) {
            kotlin.jvm.internal.p.i(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.taskStatus = num;
            this.trackStatus = str;
            this.nextPollAt = str2;
        }

        /* renamed from: a, reason: from getter */
        public final String getNextPollAt() {
            return this.nextPollAt;
        }

        /* renamed from: b, reason: from getter */
        public final JsonObject getSnapshot() {
            return this.snapshot;
        }

        /* renamed from: c, reason: from getter */
        public final Integer getTaskStatus() {
            return this.taskStatus;
        }

        /* renamed from: d, reason: from getter */
        public final String getTrackStatus() {
            return this.trackStatus;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ok)) {
                return false;
            }
            Ok ok = (Ok) other;
            return kotlin.jvm.internal.p.d(this.snapshot, ok.snapshot) && kotlin.jvm.internal.p.d(this.taskStatus, ok.taskStatus) && kotlin.jvm.internal.p.d(this.trackStatus, ok.trackStatus) && kotlin.jvm.internal.p.d(this.nextPollAt, ok.nextPollAt);
        }

        public int hashCode() {
            int iHashCode = this.snapshot.hashCode() * 31;
            Integer num = this.taskStatus;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.trackStatus;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.nextPollAt;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Ok(snapshot=" + this.snapshot + ", taskStatus=" + this.taskStatus + ", trackStatus=" + this.trackStatus + ", nextPollAt=" + this.nextPollAt + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b, reason: from toString */
    public static final /* data */ class Retry implements f0 {
        private final String reason;

        public Retry(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            this.reason = reason;
        }

        /* renamed from: a, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Retry) && kotlin.jvm.internal.p.d(this.reason, ((Retry) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Retry(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0$c;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c, reason: from toString */
    public static final /* data */ class Stop implements f0 {
        private final String reason;

        public Stop(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            this.reason = reason;
        }

        /* renamed from: a, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Stop) && kotlin.jvm.internal.p.d(this.reason, ((Stop) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Stop(reason=" + this.reason + ")";
        }
    }
}
