package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.a0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.b0;
import com.stepos.statsrpk.service.d;
import g5.j;
import g5.u;
import h5.r;
import id.c;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import ne.b;
import o5.a;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SystemForegroundService extends a0 {
    public static final String i = u.f("SystemFgService");

    /* renamed from: f, reason: collision with root package name */
    public boolean f1679f;

    /* renamed from: g, reason: collision with root package name */
    public a f1680g;

    /* renamed from: h, reason: collision with root package name */
    public NotificationManager f1681h;

    public final void a() {
        this.f1681h = (NotificationManager) getApplicationContext().getSystemService("notification");
        Context applicationContext = getApplicationContext();
        a aVar = new a();
        aVar.f9226g = new Object();
        r rVarB = r.b(applicationContext);
        aVar.f9224c = rVarB;
        aVar.f9225f = rVarB.f5373d;
        aVar.f9227h = null;
        aVar.i = new LinkedHashMap();
        aVar.f9229k = new HashMap();
        aVar.f9228j = new HashMap();
        aVar.f9230l = new b(rVarB.f5378j);
        rVarB.f5375f.a(aVar);
        VarHandle.storeStoreFence();
        this.f1680g = aVar;
        if (aVar.f9231m != null) {
            u.d().b(a.f9223n, "A callback already exists.");
        } else {
            aVar.f9231m = this;
        }
    }

    @Override // androidx.lifecycle.a0, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.a0, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f1680g.c();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        super.onStartCommand(intent, i3, i10);
        boolean z10 = this.f1679f;
        String str = i;
        if (z10) {
            u.d().e(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f1680g.c();
            a();
            this.f1679f = false;
        }
        if (intent == null) {
            return 3;
        }
        a aVar = this.f1680g;
        aVar.getClass();
        String str2 = a.f9223n;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            u.d().e(str2, "Started foreground service " + intent);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            i iVar = aVar.f9225f;
            d dVar = new d(9);
            dVar.f2886g = aVar;
            dVar.f2885f = stringExtra;
            VarHandle.storeStoreFence();
            iVar.q(dVar);
            aVar.b(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            aVar.b(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            u.d().e(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = aVar.f9231m;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.f1679f = true;
            u.d().a(str, "Shutting down.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
        u.d().e(str2, "Stopping foreground work for " + intent);
        String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
            return 3;
        }
        r rVar = aVar.f9224c;
        UUID uuidFromString = UUID.fromString(stringExtra2);
        rVar.getClass();
        uuidFromString.getClass();
        j jVar = rVar.f5371b.f4279m;
        b0 b0Var = (b0) rVar.f5373d.f9730c;
        b0Var.getClass();
        c.x(jVar, "CancelWorkById", b0Var, new a1.b(7, rVar, uuidFromString));
        return 3;
    }

    @Override // android.app.Service
    public final void onTimeout(int i3) {
        if (Build.VERSION.SDK_INT >= 35) {
            return;
        }
        this.f1680g.d(RecyclerView.ItemAnimator.FLAG_MOVED);
    }

    public final void onTimeout(int i3, int i10) {
        this.f1680g.d(i10);
    }
}
