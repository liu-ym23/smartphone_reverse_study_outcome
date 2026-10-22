package com.stepos.core.ota.domain;

import dc.h;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class OtaState {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Activating extends OtaState {
        public static final Activating INSTANCE = new Activating();

        private Activating() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Checking extends OtaState {
        public static final Checking INSTANCE = new Checking();

        private Checking() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Downloading extends OtaState {
        private final long downloadedBytes;
        private final long totalBytes;

        public Downloading(long j10, long j11) {
            super(null);
            this.downloadedBytes = j10;
            this.totalBytes = j11;
        }

        public static /* synthetic */ Downloading copy$default(Downloading downloading, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = downloading.downloadedBytes;
            }
            if ((i10 & 2) != 0) {
                j11 = downloading.totalBytes;
            }
            return downloading.copy(j10, j11);
        }

        public final long component1() {
            return this.downloadedBytes;
        }

        public final long component2() {
            return this.totalBytes;
        }

        public final Downloading copy(long j10, long j11) {
            return new Downloading(j10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Downloading)) {
                return false;
            }
            Downloading downloading = (Downloading) obj;
            return this.downloadedBytes == downloading.downloadedBytes && this.totalBytes == downloading.totalBytes;
        }

        public final long getDownloadedBytes() {
            return this.downloadedBytes;
        }

        public final int getProgress() {
            long j10 = this.totalBytes;
            if (j10 <= 0) {
                return 0;
            }
            return h.a0((int) ((this.downloadedBytes * 100) / j10), 0, 100);
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.totalBytes) + (Long.hashCode(this.downloadedBytes) * 31);
        }

        public String toString() {
            long j10 = this.downloadedBytes;
            return ai.onnxruntime.a.m(ai.onnxruntime.a.q(j10, "Downloading(downloadedBytes=", ", totalBytes="), this.totalBytes, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Failed extends OtaState {
        private final OtaError error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(OtaError error) {
            super(null);
            g.f(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, OtaError otaError, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                otaError = failed.error;
            }
            return failed.copy(otaError);
        }

        public final OtaError component1() {
            return this.error;
        }

        public final Failed copy(OtaError error) {
            g.f(error, "error");
            return new Failed(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && g.b(this.error, ((Failed) obj).error);
        }

        public final OtaError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Idle extends OtaState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Installed extends OtaState {
        private final int version;

        public Installed(int i10) {
            super(null);
            this.version = i10;
        }

        public static /* synthetic */ Installed copy$default(Installed installed, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = installed.version;
            }
            return installed.copy(i10);
        }

        public final int component1() {
            return this.version;
        }

        public final Installed copy(int i10) {
            return new Installed(i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Installed) && this.version == ((Installed) obj).version;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return Integer.hashCode(this.version);
        }

        public String toString() {
            return ai.onnxruntime.a.g(this.version, "Installed(version=", ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Installing extends OtaState {
        public static final Installing INSTANCE = new Installing();

        private Installing() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Paused extends OtaState {
        private final int progress;
        private final PauseReason reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paused(PauseReason reason, int i10) {
            super(null);
            g.f(reason, "reason");
            this.reason = reason;
            this.progress = i10;
        }

        public static /* synthetic */ Paused copy$default(Paused paused, PauseReason pauseReason, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                pauseReason = paused.reason;
            }
            if ((i11 & 2) != 0) {
                i10 = paused.progress;
            }
            return paused.copy(pauseReason, i10);
        }

        public final PauseReason component1() {
            return this.reason;
        }

        public final int component2() {
            return this.progress;
        }

        public final Paused copy(PauseReason reason, int i10) {
            g.f(reason, "reason");
            return new Paused(reason, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Paused)) {
                return false;
            }
            Paused paused = (Paused) obj;
            return this.reason == paused.reason && this.progress == paused.progress;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final PauseReason getReason() {
            return this.reason;
        }

        public int hashCode() {
            return Integer.hashCode(this.progress) + (this.reason.hashCode() * 31);
        }

        public String toString() {
            return "Paused(reason=" + this.reason + ", progress=" + this.progress + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Queued extends OtaState {
        public static final Queued INSTANCE = new Queued();

        private Queued() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Removed extends OtaState {
        public static final Removed INSTANCE = new Removed();

        private Removed() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Verifying extends OtaState {
        public static final Verifying INSTANCE = new Verifying();

        private Verifying() {
            super(null);
        }
    }

    public /* synthetic */ OtaState(e eVar) {
        this();
    }

    public final boolean isActive() {
        return (this instanceof Queued) || (this instanceof Checking) || (this instanceof Downloading) || (this instanceof Verifying) || (this instanceof Installing) || (this instanceof Activating);
    }

    private OtaState() {
    }
}
