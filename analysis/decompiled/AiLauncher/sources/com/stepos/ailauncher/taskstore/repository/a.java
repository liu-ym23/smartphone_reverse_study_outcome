package com.stepos.ailauncher.taskstore.repository;

import Y8.t;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import e9.InterfaceC4014c;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 @2\u00020\u0001:\u0001$J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H¦@¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH¦@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H¦@¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0010H&¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0019\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H¦@¢\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH¦@¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010 \u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u001eH¦@¢\u0006\u0004\b \u0010!J \u0010$\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H¦@¢\u0006\u0004\b$\u0010%J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H¦@¢\u0006\u0004\b'\u0010\u000bJ \u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH¦@¢\u0006\u0004\b*\u0010\u001dJ&\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H¦@¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\"H¦@¢\u0006\u0004\b0\u0010\u0014J\u0018\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\fH¦@¢\u0006\u0004\b2\u0010\u000fJ\u001e\u00104\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H¦@¢\u0006\u0004\b4\u0010\u000bJ\u0010\u00106\u001a\u000205H¦@¢\u0006\u0004\b6\u0010\u0014J0\u0010:\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\t2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u0007H¦@¢\u0006\u0004\b:\u0010;J.\u0010>\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010<\u001a\u00020\t2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H¦@¢\u0006\u0004\b>\u0010?¨\u0006AÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/repository/a;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "Lcom/stepos/ailauncher/taskstore/repository/b;", "f", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Le9/c;)Ljava/lang/Object;", "", "cards", "", "p", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "taskId", "q", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LXa/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Le9/c;)Ljava/lang/Object;", "t", "()LXa/b;", "", "hidden", "o", "(Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "status", "k", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "questionTexts", "s", "(Ljava/lang/String;Ljava/util/Collection;Le9/c;)Ljava/lang/Object;", "", "readAt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "sessionKeys", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "oldKey", "newKey", "m", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "excludedStatuses", "n", "(Ljava/util/Set;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "uid", "c", "taskIds", "e", "LY8/t;", Const.INTENT_KEY_UMID, "version", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "parts", "r", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "taskVersion", "subTasks", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;ILjava/util/List;Le9/c;)Ljava/lang/Object;", "Companion", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/taskstore/repository/a$a;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "DEFAULT_INACTIVE_STATUSES", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.repository.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<TaskInfoStatus> DEFAULT_INACTIVE_STATUSES = Y.j(TaskInfoStatus.COMPLETED, TaskInfoStatus.FAILED, TaskInfoStatus.CANCELLED);

        public final Set<TaskInfoStatus> a() {
            return DEFAULT_INACTIVE_STATUSES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object l(a aVar, Set set, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActiveCards");
        }
        if ((i10 & 1) != 0) {
            set = INSTANCE.a();
        }
        return aVar.n(set, interfaceC4014c);
    }

    Object a(String str, long j10, InterfaceC4014c<? super Integer> interfaceC4014c);

    Xa.b<TaskInfoCard> b(String taskId);

    Object c(String str, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object d(InterfaceC4014c<? super t> interfaceC4014c);

    Object e(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object f(TaskInfoCard taskInfoCard, InterfaceC4014c<? super TaskInfoCardSaveResult> interfaceC4014c);

    Object g(InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c);

    Object h(InterfaceC4014c<? super Long> interfaceC4014c);

    Object i(List<String> list, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c);

    Object j(String str, int i10, List<TaskInfoCard> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object k(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object m(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object n(Set<? extends TaskInfoStatus> set, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c);

    Object o(String str, boolean z10, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object p(List<TaskInfoCard> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object q(String str, InterfaceC4014c<? super TaskInfoCard> interfaceC4014c);

    Object r(String str, Integer num, List<TaskInfoPart> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object s(String str, Collection<String> collection, InterfaceC4014c<? super Integer> interfaceC4014c);

    Xa.b<List<TaskInfoCard>> t();
}
