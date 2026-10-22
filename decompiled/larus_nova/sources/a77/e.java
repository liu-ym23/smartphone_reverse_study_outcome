package a77;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import z67.i;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public static void a() {
        f.b("PushMultiProcessMonitor", "reportEvent now");
        c r100 = c.c(AppProvider.getApp());
        List r101 = r100.b();
        f.b("PushMultiProcessMonitor", "events len is :" + ((ArrayList) r101).size());
    L4:
        if (r101.isEmpty() == true) goto L49;
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L48;
        b r103 = (b) r102.next();
        f.b("PushMultiProcessMonitor", "report:" + r103.f2033b);
        String r104 = r103.f2033b;
        JSONObject r105 = null;
        JSONObject r106 = new JSONObject(r103.f2034c);     // Catch: Throwable -> L11
    L66:
        JSONObject r107 = new JSONObject(r103.f2035d);     // Catch: Throwable -> L14
    L62:
        r105 = new JSONObject(r103.f2036e);     // Catch: Throwable -> L55
    L17:
        i.a(r104, r106, r107, r105);
        long r108 = r103.f2032a;
        monitor-enter(r100);
        boolean r109 = false;
        SQLiteDatabase r110 = r100.e();     // Catch: Throwable -> L37
        if (r110 != null) goto L23;
    L31:
        f.i("MultiProcessMonitorDBHelper", "[deleteEvent] db not establish and open");     // Catch: Throwable -> L37
        r100.a();     // Catch: Throwable -> L35
        monitor-exit(r100);
    L41:
        if (r109 == true) goto L7;
        f.i("PushMultiProcessMonitor", "error when delete monitor event,break now");
        goto L48
    L23:
        if (r110.isOpen() == false) goto L31;
        if (r110.delete("event", "_id = ?", new String[]{String.valueOf(r108)}) <= 0) goto L56;
        r109 = true;
    L56:
        r100.a();     // Catch: Throwable -> L35
        monitor-exit(r100);
        goto L41
    L37:
        th = move-exception;
        f.f("MultiProcessMonitorDBHelper", "[deleteEvent] error when delete monitor event ", th);     // Catch: Throwable -> L43
        r100.a();     // Catch: Throwable -> L35
        goto L41
    L43:
        th = move-exception;
        r100.a();     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L14:
        r107 = null;
    L11:
        r106 = null;
    L48:
        r101 = r100.b();
        goto L4
    L49:
        WeakHandler r111 = PushThreadHandlerManager.inst().getHandler();
        if (ActivityLifecycleObserver.getIns().isBackGround() == false) goto L52;
        long r112 = 600000;
    L53:
        r111.sendEmptyMessageDelayed(4171758, r112);
        return;
    L52:
        r112 = 60000;
        goto L53
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e() {
    }
}
