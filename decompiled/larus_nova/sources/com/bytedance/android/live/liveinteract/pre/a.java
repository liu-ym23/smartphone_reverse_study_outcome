package com.bytedance.android.live.liveinteract.pre;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f77865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f77866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f77867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f77868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f77869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f77872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RunnableC1200a f77873i;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.pre.a$a, reason: collision with other inner class name */
    public class RunnableC1200a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f77874a;

        public final void a() {
            HashMap r100 = new HashMap();
            Iterator r101 = ((HashMap) this.f77874a.f77867c).entrySet().iterator();
            int r102 = 0;
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry r103 = (Map.Entry) r101.next();
            r102 = r102 + ((Integer) r103.getValue()).intValue();
            r100.put((String) r103.getKey(), String.valueOf(r103.getValue()));
            goto L4
        L6:
            Map<String, String> r104 = this.f77874a.f77866b;
            HashMap r105 = (HashMap) r104;
            r105.put("load_count_cache", String.valueOf(r102));
            a r106 = this.f77874a;
            Map<String, String> r107 = r106.f77866b;
            HashMap r108 = (HashMap) r107;
            r108.put("load_count_total", String.valueOf(r106.f77872h));
            Map<String, String> r109 = this.f77874a.f77866b;
            HashMap r110 = (HashMap) r109;
            r110.put("load_detail", new JSONObject(r100).toString());
            a r111 = this.f77874a;
            Map<String, String> r112 = r111.f77866b;
            HashMap r113 = (HashMap) r112;
            r113.put(ImageNetworkRequestsMonitor.KEY_IMAGE_LOAD, String.valueOf(r111.f77870f - r111.f77869e));
            j0.l().sendLog("livesdk_vertical_preinflate_count", this.f77874a.f77866b, new Object[0]);
            ((HashMap) this.f77874a.f77866b).clear();
            ((HashMap) this.f77874a.f77867c).clear();
            a r114 = this.f77874a;
            r114.f77872h = 0;
            r114.f77868d.delete(r114.f77871g);
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

        public RunnableC1200a(a r100) {
            this.f77874a = r100;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f77875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f77876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f77877c;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f77876b;     // Catch: Throwable -> L7
            if (r100 == 1) goto L5;
            int r101 = r100 - 1;     // Catch: Throwable -> L7
            this.f77876b = r101;     // Catch: Throwable -> L7
            Handler r102 = this.f77875a;     // Catch: Throwable -> L7
            r102.post(new b(r102, r101, this.f77877c));     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.f77877c.run();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public b(Handler r100, int r101, Runnable r102) {
            this.f77875a = r100;
            this.f77876b = r101;
            this.f77877c = r102;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f77878a = null;

        static {
            f77878a = new a();
        }
    }

    public a() {
        this.f77866b = new HashMap();
        this.f77867c = new HashMap();
        this.f77868d = new SparseBooleanArray();
        this.f77869e = -1;
        this.f77870f = -1;
        this.f77871g = -1;
        this.f77872h = 0;
        this.f77873i = new RunnableC1200a(this);
        this.f77865a = new Handler(Looper.getMainLooper());
    }

    public final void a(int r100, int r101) {
        this.f77868d.put(r100, true);
        this.f77865a.removeCallbacks(this.f77873i);
        if (this.f77868d.get(this.f77871g) == false) goto L5;
        j0.l().sendLog("livesdk_vertical_preinflate_count", this.f77866b, new Object[0]);
        this.f77868d.delete(this.f77871g);
    L5:
        this.f77871g = r100;
        this.f77869e = System.currentTimeMillis();
        ((HashMap) this.f77866b).clear();
        ((HashMap) this.f77867c).clear();
        this.f77872h = 0;
        Map<String, String> r102 = this.f77866b;
        HashMap r103 = (HashMap) r102;
        r103.put("room_sei_local", String.valueOf(r101));
    }

    public final void b(String r100, boolean r101) {
        this.f77872h++;
        if (TextUtils.equals(r100, VerticalNitaInflate.Tag.GuestBattleQuickInteractView.name()) == true) goto L5;
        this.f77870f = System.currentTimeMillis();
    L5:
        if (r101 == false) goto L11;
        Integer r102 = (Integer) ((HashMap) this.f77867c).get(r100);
        if (r102 != null) goto L9;
        ((HashMap) this.f77867c).put(r100, 1);
        return;
    L9:
        ((HashMap) this.f77867c).put(r100, Integer.valueOf(r102.intValue() + 1));
        return;
    }

    public final void c(IRoom r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getLinkMap() != null) goto L6;
        return;
    L6:
        if (r100.getLinkerDetail() == null) goto L20;
        Set<String> r102 = r100.getLinkMap().keySet();
        ((HashMap) this.f77866b).put("cache_type", "load");
        Map<String, String> r103 = this.f77866b;
        if (r101 == false) goto L11;
        String r104 = "1";
    L12:
        ((HashMap) r103).put("cache_scene", r104);
        Map<String, String> r105 = this.f77866b;
        if (r102.size() <= 0) goto L15;
        String r106 = (String) r102.toArray()[0];
    L16:
        ((HashMap) r105).put("room_scene", r106);
        Map<String, String> r107 = this.f77866b;
        HashMap r108 = (HashMap) r107;
        r108.put("room_uilayout", String.valueOf(r100.getLinkerDetail().getUiLayout()));
        return;
    L15:
        r106 = "";
        goto L16
    L11:
        r104 = "2";
        goto L12
    }
}
