package n6;

import a4.a0;
import a4.b0;
import a4.q;
import a4.z;
import ad.d;
import ad.e0;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import c6.g;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.statsapp.v3.SdkVer;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.h;
import ed.j;
import ie.v;
import ie.w0;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import ma.e;
import p5.m;
import s.f;
import t.o;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a implements q, g, d {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f8775g;

    /* renamed from: c, reason: collision with root package name */
    public Object f8776c;

    /* renamed from: f, reason: collision with root package name */
    public Object f8777f;

    public a(Window window) {
        this.f8776c = window.getInsetsController();
        this.f8777f = window;
    }

    public static void k(AgentSafetyApplication agentSafetyApplication) {
        File externalFilesDir;
        char[] cArr;
        if (f8775g) {
            return;
        }
        int i = 1;
        f8775g = true;
        f.c(1);
        if (TextUtils.isEmpty("20013638")) {
            g5.f.s("appId is null!");
            return;
        }
        a aVar = da.a.f3298a;
        aVar.f8776c = agentSafetyApplication;
        aVar.f8777f = "20013638";
        if (c.f14288c && (externalFilesDir = agentSafetyApplication.getExternalFilesDir(null)) != null) {
            String absolutePath = externalFilesDir.getAbsolutePath();
            d1.f fVar = new d1.f();
            fVar.f2968b = absolutePath;
            File file = new File(absolutePath);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            fVar.f2969c = new File(absolutePath, "usage_logs_v2.txt");
            ua.a aVar2 = new ua.a();
            aVar2.f14281c = 0;
            aVar2.f14279a = new char[64];
            aVar2.f14281c = "copyright".charAt(0) % '\r';
            int i3 = 0;
            while (true) {
                char[] cArr2 = ua.a.f14275d;
                cArr = aVar2.f14279a;
                if (i3 >= 64) {
                    break;
                }
                cArr[i3] = cArr2[(aVar2.f14281c + i3) % 64];
                i3++;
            }
            aVar2.f14280b = cArr;
            fVar.f2970d = aVar2;
            fVar.f2971e = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            fVar.f2967a = Process.myPid();
            c.f14286a = fVar;
        }
        e eVar = ma.d.f8538a;
        AgentSafetyApplication agentSafetyApplication2 = (AgentSafetyApplication) aVar.f8776c;
        String str = (String) aVar.f8777f;
        StringBuilder sbO = androidx.activity.b.o("SDKInstanceImpl, pkgType: 0, appId: ", str, ", channel: StepOS, initConfig: ");
        sbO.append(new f7.f(23));
        sbO.append(", sdkVersion: ");
        sbO.append(SdkVer.verName);
        c.d("SDKInstanceImpl", sbO.toString());
        eVar.f8539a = agentSafetyApplication2;
        eVar.f8540b = str;
        eVar.f8541c = "StepOS";
        h.f2869g = "6KAIUyh8oTuWsB0JiE9";
        h.f2865c = "https://uxip.stepaos.com/api/v3/event/";
        h.f2866d = "https://uxip-config.stepaos.com/api/v3/umid/privacy";
        h.f2867e = "https://uxip-res.stepaos.com/resource/v3/config/";
        h.f2868f = "https://uxip-res.stepaos.com/resource/v3/config/rpk/";
        ma.a aVar3 = new ma.a();
        aVar3.f8532a = false;
        aVar3.f8533b = str;
        VarHandle.storeStoreFence();
        eVar.f8543e = aVar3;
        ha.c cVar = new ha.c();
        cVar.f5430a = new ArrayList();
        VarHandle.storeStoreFence();
        eVar.f8545g = cVar;
        m mVar = new m(15);
        HandlerThread handlerThread = new HandlerThread("com.stepos.statsapp.v3.SessionControllerWorker", 5);
        handlerThread.start();
        mVar.f9742g = new com.stepos.statsrpk.e(mVar, handlerThread.getLooper(), 3);
        oa.a aVar4 = (oa.a) mVar.f9743h;
        if (aVar4 != null) {
            agentSafetyApplication2.unregisterActivityLifecycleCallbacks(aVar4);
            mVar.f9743h = null;
        }
        oa.a aVar5 = new oa.a();
        aVar5.f9350h = mVar;
        aVar5.f9348f = 0L;
        aVar5.f9347e = 0L;
        aVar5.f9346d = 0L;
        aVar5.f9345c = 0L;
        aVar5.f9343a = System.currentTimeMillis();
        aVar5.f9344b = SystemClock.elapsedRealtime();
        aVar5.f9349g = new com.stepos.statsrpk.e(aVar5, Looper.getMainLooper(), 2);
        VarHandle.storeStoreFence();
        mVar.f9743h = aVar5;
        agentSafetyApplication2.registerActivityLifecycleCallbacks(aVar5);
        c.a("SessionController", "registerApplicationLifeCycle");
        c.a("SessionController", "SessionController init");
        VarHandle.storeStoreFence();
        eVar.f8544f = mVar;
        new LinkedList();
        c.a("PageController", "PageController init");
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.a aVar6 = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.a(i);
        aVar6.f2822g = eVar;
        aVar6.f2821f = true;
        VarHandle.storeStoreFence();
        sa.c.f(aVar6);
        c.a("UsageStatsProxy3", "UsageStatsProxy3 init complete");
    }

    @Override // ad.d
    public void a(j jVar, IOException iOException) {
        try {
            ((ie.f) this.f8776c).t((v) this.f8777f, iOException);
        } catch (Throwable th) {
            w0.r(th);
            th.printStackTrace();
        }
    }

    @Override // a4.q
    public boolean b(CharSequence charSequence, int i, int i3, z zVar) {
        if ((zVar.f219c & 4) > 0) {
            return true;
        }
        if (((b0) this.f8776c) == null) {
            this.f8776c = new b0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((f7.f) this.f8777f).getClass();
        a0 a0Var = new a0();
        a0Var.f155c = new Paint.FontMetricsInt();
        a0Var.f157g = (short) -1;
        a0Var.f158h = 1.0f;
        a0Var.f156f = zVar;
        VarHandle.storeStoreFence();
        ((b0) this.f8776c).setSpan(a0Var, i, i3, 33);
        return true;
    }

    public synchronized ArrayList c(String str) {
        ArrayList arrayList;
        ArrayList arrayListF;
        arrayList = new ArrayList();
        String str2 = "appKey='" + str + "'";
        synchronized (this) {
            arrayListF = f(str2, "eventId ASC LIMIT 200");
        }
        return arrayList;
        int size = arrayListF.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListF.get(i);
            i++;
            ga.c cVar = (ga.c) obj;
            long j10 = cVar.f4670a;
            TrackerPayload trackerPayloadB = ga.c.b(cVar);
            if (trackerPayloadB != null) {
                ga.a aVar = new ga.a();
                aVar.f4664a = j10;
                aVar.f4665b = trackerPayloadB;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // c6.g
    public void d(c6.a aVar, Bitmap bitmap, Map map) {
        int i;
        int iZ = a.a.z(bitmap);
        c6.e eVar = (c6.e) this.f8777f;
        synchronized (eVar.f9604c) {
            i = eVar.f9602a;
        }
        c6.e eVar2 = (c6.e) this.f8777f;
        if (iZ > i) {
            eVar2.d(aVar);
            ((wd.a) this.f8776c).i(aVar, bitmap, map, iZ);
            return;
        }
        c6.d dVar = new c6.d();
        dVar.f2213a = bitmap;
        dVar.f2214b = map;
        dVar.f2215c = iZ;
        VarHandle.storeStoreFence();
        eVar2.c(aVar, dVar);
    }

    @Override // ad.d
    public void e(e0 e0Var) {
        ie.f fVar = (ie.f) this.f8776c;
        v vVar = (v) this.f8777f;
        try {
            try {
                fVar.l(vVar, vVar.c(e0Var));
            } catch (Throwable th) {
                w0.r(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            w0.r(th2);
            try {
                fVar.t(vVar, th2);
            } catch (Throwable th3) {
                w0.r(th3);
                th3.printStackTrace();
            }
        }
    }

    public synchronized ArrayList f(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!j()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = ((SQLiteDatabase) this.f8776c).query("events", null, str, null, null, null, str2);
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    ga.c cVar = new ga.c();
                    if (cursorQuery.getColumnIndex("eventId") >= 0) {
                        cVar.f4670a = cursorQuery.getInt(r12);
                    }
                    int columnIndex = cursorQuery.getColumnIndex("eventSessionId");
                    if (columnIndex >= 0) {
                        cVar.f4672c = cursorQuery.getString(columnIndex);
                    }
                    int columnIndex2 = cursorQuery.getColumnIndex("encrypt");
                    if (columnIndex2 >= 0) {
                        cVar.f4671b = cursorQuery.getInt(columnIndex2);
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex("eventData");
                    if (columnIndex2 >= 0) {
                        cVar.f4674e = cursorQuery.getString(columnIndex3);
                    }
                    int columnIndex4 = cursorQuery.getColumnIndex("dateCreated");
                    if (columnIndex4 >= 0) {
                        cursorQuery.getString(columnIndex4);
                    }
                    arrayList.add(cVar);
                    cursorQuery.moveToNext();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                o.e(cursorQuery);
                return arrayList;
            } finally {
                o.e(cursorQuery);
            }
        }
    }

    public synchronized void g() {
        if (j()) {
            try {
                synchronized (this) {
                    long jQueryNumEntries = DatabaseUtils.queryNumEntries((SQLiteDatabase) this.f8776c, "events", null);
                    if (jQueryNumEntries > 10000) {
                        c.a("a", "clear old events, amount of events currently in the database: " + jQueryNumEntries);
                        ((SQLiteDatabase) this.f8776c).execSQL("delete from events where (eventId not in (select eventId from events order by eventId desc limit 1000))");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // a4.q
    public Object getResult() {
        return (b0) this.f8776c;
    }

    public synchronized ArrayList h() {
        ArrayList arrayList = new ArrayList();
        if (!j()) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = ((SQLiteDatabase) this.f8776c).query(true, "events", new String[]{"appKey"}, null, null, null, null, null, null);
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                arrayList.add(cursorQuery.getString(0));
                cursorQuery.moveToNext();
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return arrayList;
            } finally {
                o.e(cursorQuery);
            }
        }
    }

    @Override // c6.g
    public c6.b i(c6.a aVar) {
        c6.d dVar = (c6.d) ((c6.e) this.f8777f).b(aVar);
        if (dVar != null) {
            return new c6.b(dVar.f2213a, dVar.f2214b);
        }
        return null;
    }

    public boolean j() {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f8776c;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }

    public void l(int i, int i3, boolean z10) {
        Window window = (Window) this.f8777f;
        if (window == null) {
            WindowInsetsController windowInsetsController = (WindowInsetsController) this.f8776c;
            if (z10) {
                windowInsetsController.setSystemBarsAppearance(i3, i3);
                return;
            } else {
                windowInsetsController.setSystemBarsAppearance(0, i3);
                return;
            }
        }
        if (z10) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        } else {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility((~i) & decorView2.getSystemUiVisibility());
        }
    }

    public void m(boolean z10) {
        l(16, 16, z10);
    }

    public void n(boolean z10) {
        l(8192, 8, z10);
    }

    @Override // c6.g
    public void q(int i) {
        int i3;
        if (i >= 40) {
            ((c6.e) this.f8777f).g(-1);
            return;
        }
        if (10 > i || i >= 20) {
            return;
        }
        c6.e eVar = (c6.e) this.f8777f;
        synchronized (eVar.f9604c) {
            i3 = eVar.f9605d;
        }
        eVar.g(i3 / 2);
    }

    public a() {
        List list = Collections.EMPTY_LIST;
        this.f8776c = list;
        this.f8777f = list;
    }
}
