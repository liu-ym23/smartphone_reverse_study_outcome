package com.stepos.stepclaw.chroot;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Idle", "Snapshotting", "ExtractingRootfs", "OverlayingPayload", "RestoringUserData", "Failed", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$ExtractingRootfs;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$Failed;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$Idle;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$OverlayingPayload;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$RestoringUserData;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$Snapshotting;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class UpgradeRunPhase {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$ExtractingRootfs;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", "<init>", "()V", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ExtractingRootfs extends UpgradeRunPhase {
        public static final ExtractingRootfs INSTANCE = new ExtractingRootfs();

        private ExtractingRootfs() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof ExtractingRootfs);
        }

        public int hashCode() {
            return 475603943;
        }

        public String toString() {
            return "ExtractingRootfs";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$Failed;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed extends UpgradeRunPhase {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String message) {
            super(null);
            p.e(message, "message");
            this.message = message;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = failed.message;
            }
            return failed.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Failed copy(String message) {
            p.e(message, "message");
            return new Failed(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && p.a(this.message, ((Failed) other).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return f.d("Failed(message=", this.message, ")");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$Idle;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", "<init>", "()V", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Idle extends UpgradeRunPhase {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Idle);
        }

        public int hashCode() {
            return -1926055445;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$OverlayingPayload;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", "<init>", "()V", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OverlayingPayload extends UpgradeRunPhase {
        public static final OverlayingPayload INSTANCE = new OverlayingPayload();

        private OverlayingPayload() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof OverlayingPayload);
        }

        public int hashCode() {
            return 637379301;
        }

        public String toString() {
            return "OverlayingPayload";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$RestoringUserData;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", "<init>", "()V", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RestoringUserData extends UpgradeRunPhase {
        public static final RestoringUserData INSTANCE = new RestoringUserData();

        private RestoringUserData() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof RestoringUserData);
        }

        public int hashCode() {
            return 1990476361;
        }

        public String toString() {
            return "RestoringUserData";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeRunPhase$Snapshotting;", "Lcom/stepos/stepclaw/chroot/UpgradeRunPhase;", "<init>", "()V", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Snapshotting extends UpgradeRunPhase {
        public static final Snapshotting INSTANCE = new Snapshotting();

        private Snapshotting() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Snapshotting);
        }

        public int hashCode() {
            return -1282008631;
        }

        public String toString() {
            return "Snapshotting";
        }
    }

    public /* synthetic */ UpgradeRunPhase(i iVar) {
        this();
    }

    private UpgradeRunPhase() {
    }
}
