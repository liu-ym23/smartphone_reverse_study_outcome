package com.stepos.agentframework.chatcore.search;

import La.D;
import La.H;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.chatcore.session.list.SessionAgentCategory;
import com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStoreKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import v9.C5685n;
import w4.TaskSearchDocumentEntity;

@Metadata(d1 = {"\u00002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\r\u001aC\u0010\u0015\u001a\u00020\u0014*\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"", "Lw4/e;", "titles", "", "", "c", "(Ljava/util/List;)Ljava/util/Map;", "Lcom/stepos/agentframework/chatcore/search/o;", "records", "Lw4/k;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "f", "(Lcom/stepos/agentframework/chatcore/search/o;)Lw4/k;", "query", "agentId", "deviceId", "agentDisplayName", "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "agentCategory", "Lcom/stepos/agentframework/chatcore/search/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/k;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;)Lcom/stepos/agentframework/chatcore/search/n;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class q {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((w4.e) t10).getLastActiveAt()), Long.valueOf(((w4.e) t11).getLastActiveAt()));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public b(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(Long.valueOf(((w4.e) t10).getCreateTime()), Long.valueOf(((w4.e) t11).getCreateTime()));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public c(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(((w4.e) t10).getAgentId(), ((w4.e) t11).getAgentId());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public d(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(((w4.e) t10).getDeviceId(), ((w4.e) t11).getDeviceId());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public e(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(Integer.valueOf(((w4.e) t10).getId()), Integer.valueOf(((w4.e) t11).getId()));
        }
    }

    public static final String a(String str) {
        return D.T(D.T(D.T(str, "\\", "\\\\", false, 4, null), "%", "\\%", false, 4, null), "_", "\\_", false, 4, null);
    }

    public static final List<TaskSearchDocumentEntity> b(List<TaskSearchRecord> records) {
        TaskSearchDocumentEntity taskSearchDocumentEntity;
        kotlin.jvm.internal.p.i(records, "records");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = records.iterator();
        while (it.hasNext()) {
            TaskSearchDocumentEntity taskSearchDocumentEntityF = f((TaskSearchRecord) it.next());
            if (taskSearchDocumentEntityF != null && ((taskSearchDocumentEntity = (TaskSearchDocumentEntity) linkedHashMap.get(taskSearchDocumentEntityF.getTaskId())) == null || taskSearchDocumentEntityF.getUpdatedAt() >= taskSearchDocumentEntity.getUpdatedAt())) {
                linkedHashMap.put(taskSearchDocumentEntityF.getTaskId(), taskSearchDocumentEntityF);
            }
        }
        Collection collectionValues = linkedHashMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        return F.m1(collectionValues);
    }

    public static final Map<String, w4.e> c(List<w4.e> titles) {
        kotlin.jvm.internal.p.i(titles, "titles");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : titles) {
            String strL = SessionListSnapshotStoreKt.l(((w4.e) obj).getSessionId());
            Object arrayList = linkedHashMap.get(strL);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strL, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((String) entry.getKey()).length() > 0) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(Q.e(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            linkedHashMap3.put(entry2.getKey(), (w4.e) F.J0((List) entry2.getValue(), new e(new d(new c(new b(new a()))))));
        }
        return linkedHashMap3;
    }

    public static final String d(String query) {
        kotlin.jvm.internal.p.i(query, "query");
        return "%" + a(query) + "%";
    }

    public static final String e(String query) {
        kotlin.jvm.internal.p.i(query, "query");
        return a(query) + "%";
    }

    public static final TaskSearchDocumentEntity f(TaskSearchRecord taskSearchRecord) {
        String string = H.D1(taskSearchRecord.getTaskId()).toString();
        if (string.length() == 0) {
            return null;
        }
        String string2 = H.D1(taskSearchRecord.getSessionId()).toString();
        String string3 = H.D1(taskSearchRecord.getTitle()).toString();
        String string4 = H.D1(taskSearchRecord.getSearchableText()).toString();
        String strName = taskSearchRecord.getStatus().name();
        long jG = C5685n.g(taskSearchRecord.getUpdatedAt(), 0L);
        Long readAt = taskSearchRecord.getReadAt();
        return new TaskSearchDocumentEntity(string, string2, string3, string4, strName, jG, readAt != null ? Long.valueOf(C5685n.g(readAt.longValue(), 0L)) : null);
    }

    public static final TaskSearchHit g(TaskSearchDocumentEntity taskSearchDocumentEntity, String query, String agentId, String deviceId, String agentDisplayName, SessionAgentCategory agentCategory) {
        Object objB;
        kotlin.jvm.internal.p.i(taskSearchDocumentEntity, "<this>");
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentDisplayName, "agentDisplayName");
        kotlin.jvm.internal.p.i(agentCategory, "agentCategory");
        boolean zE0 = H.e0(taskSearchDocumentEntity.getTitle(), query, true);
        String taskId = taskSearchDocumentEntity.getTaskId();
        String sessionId = taskSearchDocumentEntity.getSessionId();
        String title = taskSearchDocumentEntity.getTitle();
        String title2 = zE0 ? taskSearchDocumentEntity.getTitle() : taskSearchDocumentEntity.getSearchableText();
        TaskSearchMatchedField taskSearchMatchedField = zE0 ? TaskSearchMatchedField.TITLE : TaskSearchMatchedField.DETAIL;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(BusTaskStatus.valueOf(taskSearchDocumentEntity.getStatus()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        BusTaskStatus busTaskStatus = BusTaskStatus.CREATED;
        if (Result.g(objB)) {
            objB = busTaskStatus;
        }
        return new TaskSearchHit(taskId, sessionId, agentId, deviceId, agentDisplayName, agentCategory, title, title2, taskSearchMatchedField, (BusTaskStatus) objB, taskSearchDocumentEntity.getUpdatedAt(), taskSearchDocumentEntity.getReadAt());
    }
}
