package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import w4.ArtifactAvailabilityRow;
import w4.TaskResultArtifactEntity;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J}\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\bH'¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH'¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H'¢\u0006\u0004\b!\u0010\"J'\u0010&\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0013H'¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H'¢\u0006\u0004\b*\u0010\u001c¨\u0006+À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/f1;", "", "", "Lw4/j;", "rows", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/util/List;)V", "", "fileId", "sessionId", "messageId", "toolCallId", "taskId", "versionId", "cloudPath", "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "createdAt", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;J)V", "c", "(Ljava/lang/String;)Ljava/util/List;", "sessionIds", "e", "(Ljava/util/List;)Ljava/util/List;", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()V", "", "availability", "checkedAt", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;IJ)V", "fileIds", "Lw4/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.f1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC1883f1 {
    void a();

    void b(String oldSessionId, String newSessionId);

    List<TaskResultArtifactEntity> c(String sessionId);

    default void d(List<TaskResultArtifactEntity> rows) {
        kotlin.jvm.internal.p.i(rows, "rows");
        Iterator<T> it = rows.iterator();
        while (it.hasNext()) {
            C1886g1.a(this, (TaskResultArtifactEntity) it.next());
        }
    }

    List<String> e(List<String> sessionIds);

    void f(String fileId, String sessionId, String messageId, String toolCallId, String taskId, String versionId, String cloudPath, String fileName, String title, String mimeType, Long size, long createdAt);

    List<ArtifactAvailabilityRow> g(List<String> fileIds);

    void h(String fileId, int availability, long checkedAt);
}
