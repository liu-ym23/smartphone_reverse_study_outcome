package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w4.TaskResultArtifactEntity;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/f1;", "Lw4/j;", "row", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/db/f1;Lw4/j;)V", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.g1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1886g1 {
    public static final void a(InterfaceC1883f1 interfaceC1883f1, TaskResultArtifactEntity row) {
        kotlin.jvm.internal.p.i(interfaceC1883f1, "<this>");
        kotlin.jvm.internal.p.i(row, "row");
        interfaceC1883f1.f(row.getFileId(), row.getSessionId(), row.getMessageId(), row.getToolCallId(), row.getTaskId(), row.getVersionId(), row.getCloudPath(), row.getFileName(), row.getTitle(), row.getMimeType(), row.getSize(), row.getCreatedAt());
    }
}
