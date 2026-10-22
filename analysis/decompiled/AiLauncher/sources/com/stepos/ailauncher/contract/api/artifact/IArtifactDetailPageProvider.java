package com.stepos.ailauncher.contract.api.artifact;

import android.content.Context;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/artifact/IArtifactDetailPageProvider;", "", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "", "source", "LY8/t;", "open", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)V", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IArtifactDetailPageProvider {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void open(IArtifactDetailPageProvider iArtifactDetailPageProvider, Context context, SessionArtifact artifact) {
            p.i(context, "context");
            p.i(artifact, "artifact");
            IArtifactDetailPageProvider.super.open(context, artifact);
        }
    }

    default void open(Context context, SessionArtifact artifact) {
        p.i(context, "context");
        p.i(artifact, "artifact");
        open(context, artifact, "chatview");
    }

    void open(Context context, SessionArtifact artifact, String source);
}
