package com.stepos.ailauncher.foundation.sprite.event;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.v;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/g;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "task", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)V", "c", Const.INTENT_KEY_UMID, "", "action", "", "e", "(Ljava/lang/String;)Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g extends d {
    public static final g INSTANCE = new g();

    public final void b(UiTask task) {
        p.i(task, "task");
        String str = (task.getStatus() == 6 || task.getStatus() == 5) ? SpriteEventAction.TASK_ERROR : task.getStatus() == 4 ? SpriteEventAction.TASK_SUCCESS : task.getStatus() == 7 ? SpriteEventAction.TASK_WAIT : task.getStatus() == 3 ? SpriteEventAction.TASK_INTERRUPTED : SpriteEventAction.TASK_RUNNING;
        Boolean boolValueOf = e(str) ? Boolean.valueOf(TaskReadEventCollector.INSTANCE.f(task)) : null;
        a(new SpriteEvent(SpriteEventType.TASK, str, System.currentTimeMillis(), task.getStatus() == 6 ? Boolean.TRUE : boolValueOf));
        if (boolValueOf != null) {
            TaskReadEventCollector.INSTANCE.i(task, str, boolValueOf.booleanValue());
        }
    }

    public final void c() {
        a(new SpriteEvent(SpriteEventType.TASK, SpriteEventAction.TASK_INTERRUPTED, System.currentTimeMillis(), Boolean.valueOf(v.INSTANCE.k())));
    }

    public final void d() {
    }

    public final boolean e(String action) {
        return p.d(action, SpriteEventAction.TASK_SUCCESS) || p.d(action, SpriteEventAction.TASK_ERROR) || p.d(action, SpriteEventAction.TASK_INTERRUPTED) || p.d(action, SpriteEventAction.TASK_WAIT) || p.d(action, SpriteEventAction.TASK_WAIT_SAFE);
    }
}
