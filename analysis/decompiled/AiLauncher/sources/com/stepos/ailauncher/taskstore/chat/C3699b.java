package com.stepos.ailauncher.taskstore.chat;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/b;", "", "<init>", "()V", "", "taskId", "Lcom/stepos/ailauncher/taskstore/widget/TaskInfoCardMediumView;", "view", "LY8/t;", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/widget/TaskInfoCardMediumView;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/widget/TaskInfoCardMediumView;", Const.INTENT_KEY_UMID, "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "taskCardViewList", "Ljava/util/HashMap;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3699b {
    public static final C3699b INSTANCE = new C3699b();
    private static final HashMap<String, WeakReference<TaskInfoCardMediumView>> taskCardViewList = new HashMap<>();

    public final TaskInfoCardMediumView a(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        HashMap<String, WeakReference<TaskInfoCardMediumView>> map = taskCardViewList;
        WeakReference<TaskInfoCardMediumView> weakReference = map.get(taskId);
        TaskInfoCardMediumView taskInfoCardMediumView = weakReference != null ? weakReference.get() : null;
        if (taskInfoCardMediumView == null) {
            map.remove(taskId);
        }
        return taskInfoCardMediumView;
    }

    public final List<TaskInfoCardMediumView> b() {
        HashMap<String, WeakReference<TaskInfoCardMediumView>> map = taskCardViewList;
        ArrayList arrayList = new ArrayList(map.size());
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, WeakReference<TaskInfoCardMediumView>> entry : map.entrySet()) {
            String key = entry.getKey();
            TaskInfoCardMediumView taskInfoCardMediumView = entry.getValue().get();
            if (taskInfoCardMediumView != null) {
                arrayList.add(taskInfoCardMediumView);
            } else {
                arrayList2.add(key);
            }
        }
        HashMap<String, WeakReference<TaskInfoCardMediumView>> map2 = taskCardViewList;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            map2.remove((String) it.next());
        }
        return arrayList;
    }

    public final void c(String taskId, TaskInfoCardMediumView view) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(view, "view");
        taskCardViewList.put(taskId, new WeakReference<>(view));
    }

    public final TaskInfoCardMediumView d(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        WeakReference<TaskInfoCardMediumView> weakReferenceRemove = taskCardViewList.remove(taskId);
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
