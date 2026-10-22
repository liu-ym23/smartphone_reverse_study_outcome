package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import w4.TaskSearchDocumentEntity;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0017¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH'¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH'¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0011H'¢\u0006\u0004\b!\u0010\"¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/q1;", "", "", "taskId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/lang/Long;", "Lw4/k;", "document", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/k;)V", "", "c", "(Lw4/k;)Z", "", "documents", "", "f", "(Ljava/util/List;)I", "e", "taskIds", Const.INTENT_KEY_UMID, "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)I", Const.INTENT_KEY_APIKEY, "()V", "query", "prefixPattern", "containsPattern", "limit", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface q1 {
    void a();

    int b(String oldSessionId, String newSessionId);

    default boolean c(TaskSearchDocumentEntity document) {
        kotlin.jvm.internal.p.i(document, "document");
        Long lI = i(document.getTaskId());
        if (lI != null && lI.longValue() > document.getUpdatedAt()) {
            return false;
        }
        g(document);
        return true;
    }

    int d(List<String> taskIds);

    default int e(List<TaskSearchDocumentEntity> documents) {
        kotlin.jvm.internal.p.i(documents, "documents");
        a();
        Iterator<T> it = documents.iterator();
        while (it.hasNext()) {
            g((TaskSearchDocumentEntity) it.next());
        }
        return documents.size();
    }

    default int f(List<TaskSearchDocumentEntity> documents) {
        kotlin.jvm.internal.p.i(documents, "documents");
        List<TaskSearchDocumentEntity> list = documents;
        int i10 = 0;
        if ((list instanceof Collection) && list.isEmpty()) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (c((TaskSearchDocumentEntity) it.next()) && (i10 = i10 + 1) < 0) {
                C1173v.v();
            }
        }
        return i10;
    }

    void g(TaskSearchDocumentEntity document);

    List<TaskSearchDocumentEntity> h(String query, String prefixPattern, String containsPattern, int limit);

    Long i(String taskId);
}
