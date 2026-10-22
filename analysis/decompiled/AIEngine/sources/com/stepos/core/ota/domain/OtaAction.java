package com.stepos.core.ota.domain;

import com.stepos.core.ota.d;
import com.stepos.core.ota.domain.model.ModelManifest;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class OtaAction {
    public static final Companion Companion = new Companion(null);
    public static final String GLOBAL = "*";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Attach extends OtaAction {
        private final String otaId;
        private final TriggerSource source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Attach(String otaId, TriggerSource source) {
            super(null);
            g.f(otaId, "otaId");
            g.f(source, "source");
            this.otaId = otaId;
            this.source = source;
        }

        public static /* synthetic */ Attach copy$default(Attach attach, String str, TriggerSource triggerSource, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = attach.otaId;
            }
            if ((i10 & 2) != 0) {
                triggerSource = attach.source;
            }
            return attach.copy(str, triggerSource);
        }

        public final String component1() {
            return this.otaId;
        }

        public final TriggerSource component2() {
            return this.source;
        }

        public final Attach copy(String otaId, TriggerSource source) {
            g.f(otaId, "otaId");
            g.f(source, "source");
            return new Attach(otaId, source);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Attach)) {
                return false;
            }
            Attach attach = (Attach) obj;
            return g.b(this.otaId, attach.otaId) && this.source == attach.source;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final TriggerSource getSource() {
            return this.source;
        }

        public int hashCode() {
            return this.source.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return "Attach(otaId=" + this.otaId + ", source=" + this.source + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Cancel extends OtaAction {
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancel(String otaId) {
            super(null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
        }

        public static /* synthetic */ Cancel copy$default(Cancel cancel, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = cancel.otaId;
            }
            return cancel.copy(str);
        }

        public final String component1() {
            return this.otaId;
        }

        public final Cancel copy(String otaId) {
            g.f(otaId, "otaId");
            return new Cancel(otaId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Cancel) && g.b(this.otaId, ((Cancel) obj).otaId);
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.otaId.hashCode();
        }

        public String toString() {
            return a0.a.k("Cancel(otaId=", this.otaId, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CheckUpdate extends OtaAction {
        private final boolean checkRemote;
        private final String otaId;
        private final TriggerSource source;

        public /* synthetic */ CheckUpdate(String str, TriggerSource triggerSource, boolean z, int i10, e eVar) {
            this(str, triggerSource, (i10 & 4) != 0 ? true : z);
        }

        public static /* synthetic */ CheckUpdate copy$default(CheckUpdate checkUpdate, String str, TriggerSource triggerSource, boolean z, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = checkUpdate.otaId;
            }
            if ((i10 & 2) != 0) {
                triggerSource = checkUpdate.source;
            }
            if ((i10 & 4) != 0) {
                z = checkUpdate.checkRemote;
            }
            return checkUpdate.copy(str, triggerSource, z);
        }

        public final String component1() {
            return this.otaId;
        }

        public final TriggerSource component2() {
            return this.source;
        }

        public final boolean component3() {
            return this.checkRemote;
        }

        public final CheckUpdate copy(String otaId, TriggerSource source, boolean z) {
            g.f(otaId, "otaId");
            g.f(source, "source");
            return new CheckUpdate(otaId, source, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CheckUpdate)) {
                return false;
            }
            CheckUpdate checkUpdate = (CheckUpdate) obj;
            return g.b(this.otaId, checkUpdate.otaId) && this.source == checkUpdate.source && this.checkRemote == checkUpdate.checkRemote;
        }

        public final boolean getCheckRemote() {
            return this.checkRemote;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final TriggerSource getSource() {
            return this.source;
        }

        public int hashCode() {
            return Boolean.hashCode(this.checkRemote) + ((this.source.hashCode() + (this.otaId.hashCode() * 31)) * 31);
        }

        public String toString() {
            String str = this.otaId;
            TriggerSource triggerSource = this.source;
            boolean z = this.checkRemote;
            StringBuilder sb2 = new StringBuilder("CheckUpdate(otaId=");
            sb2.append(str);
            sb2.append(", source=");
            sb2.append(triggerSource);
            sb2.append(", checkRemote=");
            return a0.a.m(sb2, z, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckUpdate(String otaId, TriggerSource source, boolean z) {
            super(null);
            g.f(otaId, "otaId");
            g.f(source, "source");
            this.otaId = otaId;
            this.source = source;
            this.checkRemote = z;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ConditionsChanged extends OtaAction {
        private final String otaId;

        /* JADX WARN: Multi-variable type inference failed */
        public ConditionsChanged() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ConditionsChanged copy$default(ConditionsChanged conditionsChanged, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = conditionsChanged.otaId;
            }
            return conditionsChanged.copy(str);
        }

        public final String component1() {
            return this.otaId;
        }

        public final ConditionsChanged copy(String otaId) {
            g.f(otaId, "otaId");
            return new ConditionsChanged(otaId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConditionsChanged) && g.b(this.otaId, ((ConditionsChanged) obj).otaId);
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.otaId.hashCode();
        }

        public String toString() {
            return a0.a.k("ConditionsChanged(otaId=", this.otaId, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConditionsChanged(String otaId) {
            super(null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
        }

        public /* synthetic */ ConditionsChanged(String str, int i10, e eVar) {
            this((i10 & 1) != 0 ? OtaAction.GLOBAL : str);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Detach extends OtaAction {
        private final String clientTag;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Detach(String otaId, String clientTag) {
            super(null);
            g.f(otaId, "otaId");
            g.f(clientTag, "clientTag");
            this.otaId = otaId;
            this.clientTag = clientTag;
        }

        public static /* synthetic */ Detach copy$default(Detach detach, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = detach.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = detach.clientTag;
            }
            return detach.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.clientTag;
        }

        public final Detach copy(String otaId, String clientTag) {
            g.f(otaId, "otaId");
            g.f(clientTag, "clientTag");
            return new Detach(otaId, clientTag);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Detach)) {
                return false;
            }
            Detach detach = (Detach) obj;
            return g.b(this.otaId, detach.otaId) && g.b(this.clientTag, detach.clientTag);
        }

        public final String getClientTag() {
            return this.clientTag;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.clientTag.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("Detach(otaId=", this.otaId, ", clientTag=", this.clientTag, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DownloadFailed extends OtaAction {
        private final OtaError error;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadFailed(String otaId, OtaError error) {
            super(null);
            g.f(otaId, "otaId");
            g.f(error, "error");
            this.otaId = otaId;
            this.error = error;
        }

        public static /* synthetic */ DownloadFailed copy$default(DownloadFailed downloadFailed, String str, OtaError otaError, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = downloadFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                otaError = downloadFailed.error;
            }
            return downloadFailed.copy(str, otaError);
        }

        public final String component1() {
            return this.otaId;
        }

        public final OtaError component2() {
            return this.error;
        }

        public final DownloadFailed copy(String otaId, OtaError error) {
            g.f(otaId, "otaId");
            g.f(error, "error");
            return new DownloadFailed(otaId, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DownloadFailed)) {
                return false;
            }
            DownloadFailed downloadFailed = (DownloadFailed) obj;
            return g.b(this.otaId, downloadFailed.otaId) && g.b(this.error, downloadFailed.error);
        }

        public final OtaError getError() {
            return this.error;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.error.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return "DownloadFailed(otaId=" + this.otaId + ", error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DownloadSucceeded extends OtaAction {
        private final String filePath;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadSucceeded(String otaId, String filePath) {
            super(null);
            g.f(otaId, "otaId");
            g.f(filePath, "filePath");
            this.otaId = otaId;
            this.filePath = filePath;
        }

        public static /* synthetic */ DownloadSucceeded copy$default(DownloadSucceeded downloadSucceeded, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = downloadSucceeded.otaId;
            }
            if ((i10 & 2) != 0) {
                str2 = downloadSucceeded.filePath;
            }
            return downloadSucceeded.copy(str, str2);
        }

        public final String component1() {
            return this.otaId;
        }

        public final String component2() {
            return this.filePath;
        }

        public final DownloadSucceeded copy(String otaId, String filePath) {
            g.f(otaId, "otaId");
            g.f(filePath, "filePath");
            return new DownloadSucceeded(otaId, filePath);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DownloadSucceeded)) {
                return false;
            }
            DownloadSucceeded downloadSucceeded = (DownloadSucceeded) obj;
            return g.b(this.otaId, downloadSucceeded.otaId) && g.b(this.filePath, downloadSucceeded.filePath);
        }

        public final String getFilePath() {
            return this.filePath;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.filePath.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return h0.e.c("DownloadSucceeded(otaId=", this.otaId, ", filePath=", this.filePath, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class InstallFailed extends OtaAction {
        private final OtaError error;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InstallFailed(String otaId, OtaError error) {
            super(null);
            g.f(otaId, "otaId");
            g.f(error, "error");
            this.otaId = otaId;
            this.error = error;
        }

        public static /* synthetic */ InstallFailed copy$default(InstallFailed installFailed, String str, OtaError otaError, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = installFailed.otaId;
            }
            if ((i10 & 2) != 0) {
                otaError = installFailed.error;
            }
            return installFailed.copy(str, otaError);
        }

        public final String component1() {
            return this.otaId;
        }

        public final OtaError component2() {
            return this.error;
        }

        public final InstallFailed copy(String otaId, OtaError error) {
            g.f(otaId, "otaId");
            g.f(error, "error");
            return new InstallFailed(otaId, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InstallFailed)) {
                return false;
            }
            InstallFailed installFailed = (InstallFailed) obj;
            return g.b(this.otaId, installFailed.otaId) && g.b(this.error, installFailed.error);
        }

        public final OtaError getError() {
            return this.error;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.error.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return "InstallFailed(otaId=" + this.otaId + ", error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class InstallSucceeded extends OtaAction {
        private final String otaId;
        private final int version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InstallSucceeded(String otaId, int i10) {
            super(null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.version = i10;
        }

        public static /* synthetic */ InstallSucceeded copy$default(InstallSucceeded installSucceeded, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = installSucceeded.otaId;
            }
            if ((i11 & 2) != 0) {
                i10 = installSucceeded.version;
            }
            return installSucceeded.copy(str, i10);
        }

        public final String component1() {
            return this.otaId;
        }

        public final int component2() {
            return this.version;
        }

        public final InstallSucceeded copy(String otaId, int i10) {
            g.f(otaId, "otaId");
            return new InstallSucceeded(otaId, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InstallSucceeded)) {
                return false;
            }
            InstallSucceeded installSucceeded = (InstallSucceeded) obj;
            return g.b(this.otaId, installSucceeded.otaId) && this.version == installSucceeded.version;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            return Integer.hashCode(this.version) + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return ai.onnxruntime.a.i("InstallSucceeded(otaId=", this.version, this.otaId, ", version=", ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ManifestResolved extends OtaAction {
        private final List<ModelManifest> manifests;
        private final String otaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManifestResolved(String otaId, List<ModelManifest> manifests) {
            super(null);
            g.f(otaId, "otaId");
            g.f(manifests, "manifests");
            this.otaId = otaId;
            this.manifests = manifests;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManifestResolved copy$default(ManifestResolved manifestResolved, String str, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = manifestResolved.otaId;
            }
            if ((i10 & 2) != 0) {
                list = manifestResolved.manifests;
            }
            return manifestResolved.copy(str, list);
        }

        public final String component1() {
            return this.otaId;
        }

        public final List<ModelManifest> component2() {
            return this.manifests;
        }

        public final ManifestResolved copy(String otaId, List<ModelManifest> manifests) {
            g.f(otaId, "otaId");
            g.f(manifests, "manifests");
            return new ManifestResolved(otaId, manifests);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ManifestResolved)) {
                return false;
            }
            ManifestResolved manifestResolved = (ManifestResolved) obj;
            return g.b(this.otaId, manifestResolved.otaId) && g.b(this.manifests, manifestResolved.manifests);
        }

        public final List<ModelManifest> getManifests() {
            return this.manifests;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public int hashCode() {
            return this.manifests.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return "ManifestResolved(otaId=" + this.otaId + ", manifests=" + this.manifests + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Pause extends OtaAction {
        private final String otaId;
        private final PauseReason reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pause(String otaId, PauseReason reason) {
            super(null);
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            this.otaId = otaId;
            this.reason = reason;
        }

        public static /* synthetic */ Pause copy$default(Pause pause, String str, PauseReason pauseReason, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = pause.otaId;
            }
            if ((i10 & 2) != 0) {
                pauseReason = pause.reason;
            }
            return pause.copy(str, pauseReason);
        }

        public final String component1() {
            return this.otaId;
        }

        public final PauseReason component2() {
            return this.reason;
        }

        public final Pause copy(String otaId, PauseReason reason) {
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            return new Pause(otaId, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pause)) {
                return false;
            }
            Pause pause = (Pause) obj;
            return g.b(this.otaId, pause.otaId) && this.reason == pause.reason;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final PauseReason getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return "Pause(otaId=" + this.otaId + ", reason=" + this.reason + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ProgressUpdated extends OtaAction {
        private final long downloadedBytes;
        private final String filePath;
        private final String otaId;
        private final long totalBytes;

        public /* synthetic */ ProgressUpdated(String str, long j10, long j11, String str2, int i10, e eVar) {
            this(str, j10, j11, (i10 & 8) != 0 ? null : str2);
        }

        public static /* synthetic */ ProgressUpdated copy$default(ProgressUpdated progressUpdated, String str, long j10, long j11, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = progressUpdated.otaId;
            }
            if ((i10 & 2) != 0) {
                j10 = progressUpdated.downloadedBytes;
            }
            if ((i10 & 4) != 0) {
                j11 = progressUpdated.totalBytes;
            }
            if ((i10 & 8) != 0) {
                str2 = progressUpdated.filePath;
            }
            String str3 = str2;
            return progressUpdated.copy(str, j10, j11, str3);
        }

        public final String component1() {
            return this.otaId;
        }

        public final long component2() {
            return this.downloadedBytes;
        }

        public final long component3() {
            return this.totalBytes;
        }

        public final String component4() {
            return this.filePath;
        }

        public final ProgressUpdated copy(String otaId, long j10, long j11, String str) {
            g.f(otaId, "otaId");
            return new ProgressUpdated(otaId, j10, j11, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProgressUpdated)) {
                return false;
            }
            ProgressUpdated progressUpdated = (ProgressUpdated) obj;
            return g.b(this.otaId, progressUpdated.otaId) && this.downloadedBytes == progressUpdated.downloadedBytes && this.totalBytes == progressUpdated.totalBytes && g.b(this.filePath, progressUpdated.filePath);
        }

        public final long getDownloadedBytes() {
            return this.downloadedBytes;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public int hashCode() {
            int iC = a0.a.c(a0.a.c(this.otaId.hashCode() * 31, this.downloadedBytes, 31), this.totalBytes, 31);
            String str = this.filePath;
            return iC + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.otaId;
            long j10 = this.downloadedBytes;
            long j11 = this.totalBytes;
            String str2 = this.filePath;
            StringBuilder sbL = d.l("ProgressUpdated(otaId=", j10, str, ", downloadedBytes=");
            a0.a.s(j11, ", totalBytes=", ", filePath=", sbL);
            return ai.onnxruntime.a.o(sbL, str2, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressUpdated(String otaId, long j10, long j11, String str) {
            super(null);
            g.f(otaId, "otaId");
            this.otaId = otaId;
            this.downloadedBytes = j10;
            this.totalBytes = j11;
            this.filePath = str;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Resume extends OtaAction {
        private final String otaId;
        private final TriggerSource source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Resume(String otaId, TriggerSource source) {
            super(null);
            g.f(otaId, "otaId");
            g.f(source, "source");
            this.otaId = otaId;
            this.source = source;
        }

        public static /* synthetic */ Resume copy$default(Resume resume, String str, TriggerSource triggerSource, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = resume.otaId;
            }
            if ((i10 & 2) != 0) {
                triggerSource = resume.source;
            }
            return resume.copy(str, triggerSource);
        }

        public final String component1() {
            return this.otaId;
        }

        public final TriggerSource component2() {
            return this.source;
        }

        public final Resume copy(String otaId, TriggerSource source) {
            g.f(otaId, "otaId");
            g.f(source, "source");
            return new Resume(otaId, source);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resume)) {
                return false;
            }
            Resume resume = (Resume) obj;
            return g.b(this.otaId, resume.otaId) && this.source == resume.source;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final TriggerSource getSource() {
            return this.source;
        }

        public int hashCode() {
            return this.source.hashCode() + (this.otaId.hashCode() * 31);
        }

        public String toString() {
            return "Resume(otaId=" + this.otaId + ", source=" + this.source + ")";
        }
    }

    public /* synthetic */ OtaAction(e eVar) {
        this();
    }

    public abstract String getOtaId();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Download extends OtaAction {
        private final boolean cellularAllowed;
        private final String clientTag;
        private final String otaId;
        private final Set<String> plugins;
        private final TriggerSource source;

        public Download(String str, TriggerSource triggerSource, String str2, Set set, boolean z, int i10, e eVar) {
            this(str, triggerSource, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? EmptySet.f10003a : set, (i10 & 16) != 0 ? false : z);
        }

        public static /* synthetic */ Download copy$default(Download download, String str, TriggerSource triggerSource, String str2, Set set, boolean z, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = download.otaId;
            }
            if ((i10 & 2) != 0) {
                triggerSource = download.source;
            }
            if ((i10 & 4) != 0) {
                str2 = download.clientTag;
            }
            if ((i10 & 8) != 0) {
                set = download.plugins;
            }
            if ((i10 & 16) != 0) {
                z = download.cellularAllowed;
            }
            boolean z3 = z;
            String str3 = str2;
            return download.copy(str, triggerSource, str3, set, z3);
        }

        public final String component1() {
            return this.otaId;
        }

        public final TriggerSource component2() {
            return this.source;
        }

        public final String component3() {
            return this.clientTag;
        }

        public final Set<String> component4() {
            return this.plugins;
        }

        public final boolean component5() {
            return this.cellularAllowed;
        }

        public final Download copy(String otaId, TriggerSource source, String str, Set<String> plugins, boolean z) {
            g.f(otaId, "otaId");
            g.f(source, "source");
            g.f(plugins, "plugins");
            return new Download(otaId, source, str, plugins, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Download)) {
                return false;
            }
            Download download = (Download) obj;
            return g.b(this.otaId, download.otaId) && this.source == download.source && g.b(this.clientTag, download.clientTag) && g.b(this.plugins, download.plugins) && this.cellularAllowed == download.cellularAllowed;
        }

        public final boolean getCellularAllowed() {
            return this.cellularAllowed;
        }

        public final String getClientTag() {
            return this.clientTag;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final Set<String> getPlugins() {
            return this.plugins;
        }

        public final TriggerSource getSource() {
            return this.source;
        }

        public int hashCode() {
            int iHashCode = (this.source.hashCode() + (this.otaId.hashCode() * 31)) * 31;
            String str = this.clientTag;
            return Boolean.hashCode(this.cellularAllowed) + ((this.plugins.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31);
        }

        public String toString() {
            String str = this.otaId;
            TriggerSource triggerSource = this.source;
            String str2 = this.clientTag;
            Set<String> set = this.plugins;
            boolean z = this.cellularAllowed;
            StringBuilder sb2 = new StringBuilder("Download(otaId=");
            sb2.append(str);
            sb2.append(", source=");
            sb2.append(triggerSource);
            sb2.append(", clientTag=");
            sb2.append(str2);
            sb2.append(", plugins=");
            sb2.append(set);
            sb2.append(", cellularAllowed=");
            return a0.a.m(sb2, z, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Download(String otaId, TriggerSource source, String str, Set<String> plugins, boolean z) {
            super(null);
            g.f(otaId, "otaId");
            g.f(source, "source");
            g.f(plugins, "plugins");
            this.otaId = otaId;
            this.source = source;
            this.clientTag = str;
            this.plugins = plugins;
            this.cellularAllowed = z;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RestorePaused extends OtaAction {
        private final boolean cellularAllowed;
        private final String otaId;
        private final int progress;
        private final PauseReason reason;
        private final Set<TriggerSource> sources;

        public RestorePaused(String str, PauseReason pauseReason, int i10, Set set, boolean z, int i11, e eVar) {
            this(str, pauseReason, i10, (i11 & 8) != 0 ? EmptySet.f10003a : set, (i11 & 16) != 0 ? false : z);
        }

        public static /* synthetic */ RestorePaused copy$default(RestorePaused restorePaused, String str, PauseReason pauseReason, int i10, Set set, boolean z, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = restorePaused.otaId;
            }
            if ((i11 & 2) != 0) {
                pauseReason = restorePaused.reason;
            }
            if ((i11 & 4) != 0) {
                i10 = restorePaused.progress;
            }
            if ((i11 & 8) != 0) {
                set = restorePaused.sources;
            }
            if ((i11 & 16) != 0) {
                z = restorePaused.cellularAllowed;
            }
            boolean z3 = z;
            int i12 = i10;
            return restorePaused.copy(str, pauseReason, i12, set, z3);
        }

        public final String component1() {
            return this.otaId;
        }

        public final PauseReason component2() {
            return this.reason;
        }

        public final int component3() {
            return this.progress;
        }

        public final Set<TriggerSource> component4() {
            return this.sources;
        }

        public final boolean component5() {
            return this.cellularAllowed;
        }

        public final RestorePaused copy(String otaId, PauseReason reason, int i10, Set<? extends TriggerSource> sources, boolean z) {
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            g.f(sources, "sources");
            return new RestorePaused(otaId, reason, i10, sources, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RestorePaused)) {
                return false;
            }
            RestorePaused restorePaused = (RestorePaused) obj;
            return g.b(this.otaId, restorePaused.otaId) && this.reason == restorePaused.reason && this.progress == restorePaused.progress && g.b(this.sources, restorePaused.sources) && this.cellularAllowed == restorePaused.cellularAllowed;
        }

        public final boolean getCellularAllowed() {
            return this.cellularAllowed;
        }

        @Override // com.stepos.core.ota.domain.OtaAction
        public String getOtaId() {
            return this.otaId;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final PauseReason getReason() {
            return this.reason;
        }

        public final Set<TriggerSource> getSources() {
            return this.sources;
        }

        public int hashCode() {
            return Boolean.hashCode(this.cellularAllowed) + ((this.sources.hashCode() + ai.onnxruntime.a.d(this.progress, (this.reason.hashCode() + (this.otaId.hashCode() * 31)) * 31, 31)) * 31);
        }

        public String toString() {
            String str = this.otaId;
            PauseReason pauseReason = this.reason;
            int i10 = this.progress;
            Set<TriggerSource> set = this.sources;
            boolean z = this.cellularAllowed;
            StringBuilder sb2 = new StringBuilder("RestorePaused(otaId=");
            sb2.append(str);
            sb2.append(", reason=");
            sb2.append(pauseReason);
            sb2.append(", progress=");
            sb2.append(i10);
            sb2.append(", sources=");
            sb2.append(set);
            sb2.append(", cellularAllowed=");
            return a0.a.m(sb2, z, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public RestorePaused(String otaId, PauseReason reason, int i10, Set<? extends TriggerSource> sources, boolean z) {
            super(null);
            g.f(otaId, "otaId");
            g.f(reason, "reason");
            g.f(sources, "sources");
            this.otaId = otaId;
            this.reason = reason;
            this.progress = i10;
            this.sources = sources;
            this.cellularAllowed = z;
        }
    }

    private OtaAction() {
    }
}
