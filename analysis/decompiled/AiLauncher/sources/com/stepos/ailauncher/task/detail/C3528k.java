package com.stepos.ailauncher.task.detail;

import android.content.Context;
import com.stepos.ailauncher.contract.api.artifact.IArtifactDetailPageProvider;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/task/detail/k;", "Lcom/stepos/ailauncher/contract/api/artifact/IArtifactDetailPageProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "", "source", "LY8/t;", "open", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.detail.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3528k implements IArtifactDetailPageProvider {
    @Override // com.stepos.ailauncher.contract.api.artifact.IArtifactDetailPageProvider
    public /* bridge */ void open(Context context, SessionArtifact sessionArtifact) {
        super.open(context, sessionArtifact);
    }

    @Override // com.stepos.ailauncher.contract.api.artifact.IArtifactDetailPageProvider
    public void open(Context context, SessionArtifact artifact, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(artifact, "artifact");
        kotlin.jvm.internal.p.i(source, "source");
        ArtifactDetailActivity.INSTANCE.a(context, artifact, source);
    }
}
