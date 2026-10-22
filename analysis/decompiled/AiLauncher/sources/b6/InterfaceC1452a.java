package b6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lb6/a;", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "taskCard", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)V", "", "activeTasks", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;Ljava/util/List;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: b6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC1452a {
    default void a(UiTask taskCard, List<UiTask> activeTasks) {
        p.i(taskCard, "taskCard");
        p.i(activeTasks, "activeTasks");
        b(taskCard);
    }

    void b(UiTask taskCard);
}
