package com.stepos.ailauncher.taskstore.provider;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/taskstore/provider/TaskCreatedSideEffects;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/provider/b;", "handler", "LY8/t;", "c", "(Lcom/stepos/ailauncher/taskstore/provider/b;)V", "", "taskId", "type", "Landroid/os/Bundle;", "extras", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "handlers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "LUa/M;", "scope", "LUa/M;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskCreatedSideEffects {
    public static final TaskCreatedSideEffects INSTANCE = new TaskCreatedSideEffects();
    private static final CopyOnWriteArrayList<b> handlers = new CopyOnWriteArrayList<>();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));

    public static final void c(b handler) {
        p.i(handler, "handler");
        CopyOnWriteArrayList<b> copyOnWriteArrayList = handlers;
        if (copyOnWriteArrayList.contains(handler)) {
            return;
        }
        copyOnWriteArrayList.add(handler);
    }

    public final void b(String taskId, String type, Bundle extras) {
        p.i(taskId, "taskId");
        p.i(type, "type");
        if (handlers.isEmpty()) {
            return;
        }
        C1060i.d(scope, null, null, new TaskCreatedSideEffects$dispatch$1(taskId, type, extras != null ? new Bundle(extras) : null, null), 3, null);
    }
}
