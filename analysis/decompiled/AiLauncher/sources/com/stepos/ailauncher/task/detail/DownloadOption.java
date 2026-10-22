package com.stepos.ailauncher.task.detail;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/detail/x;", "", "", "label", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "", "asPdfFromPreview", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/SessionArtifact;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.detail.x, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class DownloadOption {
    private final SessionArtifact artifact;
    private final boolean asPdfFromPreview;
    private final String label;

    public DownloadOption(String label, SessionArtifact artifact, boolean z10) {
        kotlin.jvm.internal.p.i(label, "label");
        kotlin.jvm.internal.p.i(artifact, "artifact");
        this.label = label;
        this.artifact = artifact;
        this.asPdfFromPreview = z10;
    }

    /* renamed from: a, reason: from getter */
    public final SessionArtifact getArtifact() {
        return this.artifact;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAsPdfFromPreview() {
        return this.asPdfFromPreview;
    }

    /* renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadOption)) {
            return false;
        }
        DownloadOption downloadOption = (DownloadOption) other;
        return kotlin.jvm.internal.p.d(this.label, downloadOption.label) && kotlin.jvm.internal.p.d(this.artifact, downloadOption.artifact) && this.asPdfFromPreview == downloadOption.asPdfFromPreview;
    }

    public int hashCode() {
        return (((this.label.hashCode() * 31) + this.artifact.hashCode()) * 31) + Boolean.hashCode(this.asPdfFromPreview);
    }

    public String toString() {
        return "DownloadOption(label=" + this.label + ", artifact=" + this.artifact + ", asPdfFromPreview=" + this.asPdfFromPreview + ")";
    }

    public /* synthetic */ DownloadOption(String str, SessionArtifact sessionArtifact, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, sessionArtifact, (i10 & 4) != 0 ? false : z10);
    }
}
