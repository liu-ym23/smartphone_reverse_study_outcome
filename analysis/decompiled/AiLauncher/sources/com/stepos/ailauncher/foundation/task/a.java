package com.stepos.ailauncher.foundation.task;

import La.H;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.v;
import com.stepos.ailauncher.contract.api.artifact.IArtifactDetailPageProvider;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "", "source", "liveSessionId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;)V", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final void a(Context context, SessionArtifact artifact, String source, String str) {
        IArtifactDetailPageProvider iArtifactDetailPageProvider;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        SessionArtifact sessionArtifactCopy$default;
        p.i(context, "context");
        p.i(artifact, "artifact");
        p.i(source, "source");
        IArtifactDetailPageProvider iArtifactDetailPageProvider2 = (IArtifactDetailPageProvider) D5.a.INSTANCE.a(IArtifactDetailPageProvider.class);
        if (iArtifactDetailPageProvider2 == null) {
            C4148a.u(v.OWNER_DETAIL, "IArtifactDetailPageProvider not registered", false, 4, null);
            return;
        }
        String sessionId = artifact.getSessionId();
        if (sessionId == null || H.x0(sessionId)) {
            sessionId = null;
        }
        String str7 = (str == null || H.x0(str)) ? null : str;
        if (str7 == null || p.d(sessionId, str7)) {
            iArtifactDetailPageProvider = iArtifactDetailPageProvider2;
            str2 = v.OWNER_DETAIL;
            str3 = sessionId;
            str4 = " source=";
            str5 = " live=";
            str6 = " seedWas=";
            sessionArtifactCopy$default = artifact;
        } else {
            if (sessionId != null) {
                C4148a.u(v.OWNER_DETAIL, "sessionId conflict: prefer live over seed fileId=" + artifact.getFileId() + " seedWas=" + sessionId + " live=" + str7 + " source=" + source, false, 4, null);
            }
            str4 = " source=";
            iArtifactDetailPageProvider = iArtifactDetailPageProvider2;
            str5 = " live=";
            str6 = " seedWas=";
            str2 = v.OWNER_DETAIL;
            str3 = sessionId;
            sessionArtifactCopy$default = SessionArtifact.copy$default(artifact, null, null, 0, 0L, null, str7, null, null, null, null, null, null, 4063, null);
        }
        C4148a.k(str2, "open fileId=" + sessionArtifactCopy$default.getFileId() + str6 + str3 + str5 + str7 + " final=" + sessionArtifactCopy$default.getSessionId() + str4 + source, false, 4, null);
        iArtifactDetailPageProvider.open(context, sessionArtifactCopy$default, source);
    }

    public static /* synthetic */ void b(Context context, SessionArtifact sessionArtifact, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = "chatview";
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        a(context, sessionArtifact, str, str2);
    }
}
