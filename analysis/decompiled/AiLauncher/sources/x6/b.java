package x6;

import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx6/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lx6/a;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Lx6/a;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "appContext", "Landroid/content/Context;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    private static volatile Context appContext;
    public static final b INSTANCE = new b();
    private static final CopyOnWriteArrayList<InterfaceC5853a> listeners = new CopyOnWriteArrayList<>();

    public static final void a(TaskInfoCard card) {
        p.i(card, "card");
        Iterator<InterfaceC5853a> it = listeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            InterfaceC5853a next = it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                next.a(card);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public static final void b(Context context, InterfaceC5853a listener) {
        p.i(context, "context");
        p.i(listener, "listener");
        if (appContext == null) {
            appContext = context.getApplicationContext();
        }
        CopyOnWriteArrayList<InterfaceC5853a> copyOnWriteArrayList = listeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }
}
