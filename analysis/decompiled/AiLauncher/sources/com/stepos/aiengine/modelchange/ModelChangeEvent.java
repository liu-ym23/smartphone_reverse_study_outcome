package com.stepos.aiengine.modelchange;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/modelchange/ModelChangeEvent;", "", "<init>", "()V", "abilityId", "", "getAbilityId", "()Ljava/lang/String;", "timestamp", "", "getTimestamp", "()J", "Changed", "Rollback", "Lcom/stepos/aiengine/modelchange/ModelChangeEvent$Changed;", "Lcom/stepos/aiengine/modelchange/ModelChangeEvent$Rollback;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ModelChangeEvent {
    public /* synthetic */ ModelChangeEvent(i iVar) {
        this();
    }

    public abstract String getAbilityId();

    public abstract long getTimestamp();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010\rR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lcom/stepos/aiengine/modelchange/ModelChangeEvent$Changed;", "Lcom/stepos/aiengine/modelchange/ModelChangeEvent;", "", "abilityId", "", "oldVersion", "newVersion", "installer", "", "timestamp", "<init>", "(Ljava/lang/String;IILjava/lang/String;J)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "component5", "()J", ChatTracker.CLICK_COPY, "(Ljava/lang/String;IILjava/lang/String;J)Lcom/stepos/aiengine/modelchange/ModelChangeEvent$Changed;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getAbilityId", Const.INTENT_KEY_PKGNAME, "I", "getOldVersion", "c", "getNewVersion", Const.INTENT_KEY_UMID, "getInstaller", "e", "J", "getTimestamp", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Changed extends ModelChangeEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String abilityId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int oldVersion;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int newVersion;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String installer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final long timestamp;

        public /* synthetic */ Changed(String str, int i10, int i11, String str2, long j10, int i12, i iVar) {
            this(str, i10, i11, str2, (i12 & 16) != 0 ? SystemClock.elapsedRealtime() : j10);
        }

        public static /* synthetic */ Changed copy$default(Changed changed, String str, int i10, int i11, String str2, long j10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = changed.abilityId;
            }
            if ((i12 & 2) != 0) {
                i10 = changed.oldVersion;
            }
            if ((i12 & 4) != 0) {
                i11 = changed.newVersion;
            }
            if ((i12 & 8) != 0) {
                str2 = changed.installer;
            }
            if ((i12 & 16) != 0) {
                j10 = changed.timestamp;
            }
            long j11 = j10;
            return changed.copy(str, i10, i11, str2, j11);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAbilityId() {
            return this.abilityId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getOldVersion() {
            return this.oldVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNewVersion() {
            return this.newVersion;
        }

        /* renamed from: component4, reason: from getter */
        public final String getInstaller() {
            return this.installer;
        }

        /* renamed from: component5, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Changed copy(String abilityId, int oldVersion, int newVersion, String installer, long timestamp) {
            p.i(abilityId, "abilityId");
            p.i(installer, "installer");
            return new Changed(abilityId, oldVersion, newVersion, installer, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Changed)) {
                return false;
            }
            Changed changed = (Changed) other;
            return p.d(this.abilityId, changed.abilityId) && this.oldVersion == changed.oldVersion && this.newVersion == changed.newVersion && p.d(this.installer, changed.installer) && this.timestamp == changed.timestamp;
        }

        @Override // com.stepos.aiengine.modelchange.ModelChangeEvent
        public String getAbilityId() {
            return this.abilityId;
        }

        public final String getInstaller() {
            return this.installer;
        }

        public final int getNewVersion() {
            return this.newVersion;
        }

        public final int getOldVersion() {
            return this.oldVersion;
        }

        @Override // com.stepos.aiengine.modelchange.ModelChangeEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (((((((this.abilityId.hashCode() * 31) + Integer.hashCode(this.oldVersion)) * 31) + Integer.hashCode(this.newVersion)) * 31) + this.installer.hashCode()) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Changed(abilityId=" + this.abilityId + ", oldVersion=" + this.oldVersion + ", newVersion=" + this.newVersion + ", installer=" + this.installer + ", timestamp=" + this.timestamp + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Changed(String abilityId, int i10, int i11, String installer, long j10) {
            super(null);
            p.i(abilityId, "abilityId");
            p.i(installer, "installer");
            this.abilityId = abilityId;
            this.oldVersion = i10;
            this.newVersion = i11;
            this.installer = installer;
            this.timestamp = j10;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010\rR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lcom/stepos/aiengine/modelchange/ModelChangeEvent$Rollback;", "Lcom/stepos/aiengine/modelchange/ModelChangeEvent;", "", "abilityId", "", "fromVersion", "toVersion", "reason", "", "timestamp", "<init>", "(Ljava/lang/String;IILjava/lang/String;J)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "component5", "()J", ChatTracker.CLICK_COPY, "(Ljava/lang/String;IILjava/lang/String;J)Lcom/stepos/aiengine/modelchange/ModelChangeEvent$Rollback;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getAbilityId", Const.INTENT_KEY_PKGNAME, "I", "getFromVersion", "c", "getToVersion", Const.INTENT_KEY_UMID, "getReason", "e", "J", "getTimestamp", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Rollback extends ModelChangeEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String abilityId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int fromVersion;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int toVersion;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String reason;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final long timestamp;

        public /* synthetic */ Rollback(String str, int i10, int i11, String str2, long j10, int i12, i iVar) {
            this(str, i10, i11, str2, (i12 & 16) != 0 ? SystemClock.elapsedRealtime() : j10);
        }

        public static /* synthetic */ Rollback copy$default(Rollback rollback, String str, int i10, int i11, String str2, long j10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = rollback.abilityId;
            }
            if ((i12 & 2) != 0) {
                i10 = rollback.fromVersion;
            }
            if ((i12 & 4) != 0) {
                i11 = rollback.toVersion;
            }
            if ((i12 & 8) != 0) {
                str2 = rollback.reason;
            }
            if ((i12 & 16) != 0) {
                j10 = rollback.timestamp;
            }
            long j11 = j10;
            return rollback.copy(str, i10, i11, str2, j11);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAbilityId() {
            return this.abilityId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getFromVersion() {
            return this.fromVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final int getToVersion() {
            return this.toVersion;
        }

        /* renamed from: component4, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component5, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Rollback copy(String abilityId, int fromVersion, int toVersion, String reason, long timestamp) {
            p.i(abilityId, "abilityId");
            p.i(reason, "reason");
            return new Rollback(abilityId, fromVersion, toVersion, reason, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rollback)) {
                return false;
            }
            Rollback rollback = (Rollback) other;
            return p.d(this.abilityId, rollback.abilityId) && this.fromVersion == rollback.fromVersion && this.toVersion == rollback.toVersion && p.d(this.reason, rollback.reason) && this.timestamp == rollback.timestamp;
        }

        @Override // com.stepos.aiengine.modelchange.ModelChangeEvent
        public String getAbilityId() {
            return this.abilityId;
        }

        public final int getFromVersion() {
            return this.fromVersion;
        }

        public final String getReason() {
            return this.reason;
        }

        @Override // com.stepos.aiengine.modelchange.ModelChangeEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        public final int getToVersion() {
            return this.toVersion;
        }

        public int hashCode() {
            return (((((((this.abilityId.hashCode() * 31) + Integer.hashCode(this.fromVersion)) * 31) + Integer.hashCode(this.toVersion)) * 31) + this.reason.hashCode()) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "Rollback(abilityId=" + this.abilityId + ", fromVersion=" + this.fromVersion + ", toVersion=" + this.toVersion + ", reason=" + this.reason + ", timestamp=" + this.timestamp + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rollback(String abilityId, int i10, int i11, String reason, long j10) {
            super(null);
            p.i(abilityId, "abilityId");
            p.i(reason, "reason");
            this.abilityId = abilityId;
            this.fromVersion = i10;
            this.toVersion = i11;
            this.reason = reason;
            this.timestamp = j10;
        }
    }

    public ModelChangeEvent() {
    }
}
