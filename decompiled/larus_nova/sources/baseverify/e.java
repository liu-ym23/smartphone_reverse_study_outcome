package baseverify;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import ws7.o;

/* JADX INFO: loaded from: classes28.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, CopyOnWriteArrayList<APICallback<String>>> f18484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f18485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f18486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicInteger f18487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18490g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f18491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f18492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f18493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ APICallback f18494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f18495e;

        @Override // java.lang.Runnable
        public void run() {
            baseverify_e$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void baseverify_e$a__run$___twin___() {
            e r100 = this.f18495e;
            Context r101 = this.f18491a;
            List r102 = this.f18492b;
            boolean r103 = this.f18493c;
            APICallback<String> r104 = this.f18494d;
            String r105 = r100.f18489f;
            String r106 = r100.f18490g;
            int r107 = 0;
            if (r106 != null) goto L5;
        L7:
            boolean r108 = false;
        L9:
            if (o.d(r101, r105, r108) == null) goto L11;
            boolean r109 = true;
        L12:
            if (r109 == false) goto L16;
            if (r104 == null) goto L77;
            r104.onSuccess("SUCCESS");
            return;
        L77:
            return;
        L16:
            monitor-enter(o.class);
            r100.a();     // Catch: Throwable -> L66
            String r110 = r100.f18489f;     // Catch: Throwable -> L66
            String r111 = r100.f18490g;     // Catch: Throwable -> L66
            if (r111 != null) goto L20;
        L22:
            boolean r112 = false;
        L24:
            if (o.d(r101, r110, r112) == null) goto L29;
            if (r104 == null) goto L27;
            r104.onSuccess("SUCCESS");     // Catch: Throwable -> L66
        L27:
            monitor-exit(o.class);     // Catch: Throwable -> L66
            return;
        L29:
            RecordService r113 = RecordService.getInstance();     // Catch: Throwable -> L66
            String[] r114 = new String[2];     // Catch: Throwable -> L66
            r114[0] = "status";     // Catch: Throwable -> L66
            if (r103 == false) goto L34;
            String r115 = "preload";
        L35:
            r114[1] = r115;     // Catch: Throwable -> L66
            r113.recordEvent(4, "modelDownload", r114);     // Catch: Throwable -> L66
            if (r102 == null) goto L54;
        L38:
            if (r107 >= r102.size()) goto L54;
            String r116 = (String) r102.get(r107);     // Catch: Throwable -> L66
            String r117 = r116.toLowerCase();     // Catch: Throwable -> L66
            if (TextUtils.isEmpty(r116) == true) goto L52;
            if (r117.startsWith("http") == true) goto L46;
            if (r117.startsWith("www") == false) goto L52;
        L46:
            if (r100.f18485b.contains(r116) == true) goto L52;
            if (r100.f18486c.contains(r116) == true) goto L52;
            if (r100.f18488e.equals(r116) == true) goto L52;
            r100.f18485b.add(r116);     // Catch: Throwable -> L66
        L52:
            r107 = r107 + 1;     // Catch: Throwable -> L66
        L54:
            if (r100.f18484a.get(r100.f18489f) == null) goto L59;
            if (r104 == null) goto L57;
            r100.f18484a.get(r100.f18489f).add(r104);     // Catch: Throwable -> L66
        L57:
            monitor-exit(o.class);     // Catch: Throwable -> L66
            return;
        L59:
            CopyOnWriteArrayList<APICallback<String>> r118 = new CopyOnWriteArrayList();     // Catch: Throwable -> L66
            if (r104 == null) goto L62;
            r118.add(r104);     // Catch: Throwable -> L66
        L62:
            r100.f18484a.put(r100.f18489f, r118);     // Catch: Throwable -> L66
            monitor-exit(o.class);     // Catch: Throwable -> L66
            long r119 = System.currentTimeMillis();
            r100.a(r101, r100.f18489f, o.f(r101), r100.f18490g, new f(r100, r119));
            return;
        L34:
            r115 = "backup";
            goto L35
        L20:
            if (r111.contains("_high") == false) goto L22;
            r112 = true;
        L66:
            th = move-exception;
            throw th;
        L11:
            r109 = false;
            goto L12
        L5:
            if (r106.contains("_high") == false) goto L7;
            r108 = true;
            goto L9
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void baseverify_e$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.baseverify_e$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100, Context r101, List r102, boolean r103, APICallback r104) {
            this.f18495e = r100;
            this.f18491a = r101;
            this.f18492b = r102;
            this.f18493c = r103;
            this.f18494d = r104;
        }
    }

    public class b implements APICallback<Pair<File, String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f18496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ APICallback f18497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f18498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f18499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f18500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f18501f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f18502g;

        @Override // com.dtf.face.network.APICallback
        public void onSuccess(Pair<File, String> r110) {
            Pair<File, String> r111 = r110;
            long r100 = System.currentTimeMillis();
            long r101 = r100 - this.f18496a;
            if (r111 != null) goto L5;
            onError("NULL-PARAMS", "Null file", null);
            return;
        L5:
            if (r101 <= 5) goto L23;
            Object r102 = r111.second;
            if (r102 == null) goto L9;
            String r103 = ((String) r102).toLowerCase();
        L11:
            if (r103.startsWith("http") == false) goto L13;
        L18:
            ws7.h.c("faceModelURL", (String) r111.second);
            APICallback r104 = this.f18497b;
            if (r104 == null) goto L22;
            r104.onSuccess(r111.first);
        L21:
            a(1, null, r100);
            return;
        L22:
            onError("MD5-ERROR", "Rename MD5 error", null);
            return;
        L13:
            if (r103.startsWith("www") == true) goto L18;
            APICallback r105 = this.f18497b;
            if (r105 == null) goto L21;
            r105.onSuccess(r111.first);
            goto L21
        L9:
            r103 = "";
            goto L11
        L23:
            AndroidClientConfig r106 = hs7.a.h().c();
            if (r106 == null) goto L32;
            JSONObject r107 = r106.clientExtParams;
            if (r107 == null) goto L32;
            String r108 = r107.getString("UPLOAD_INVALID_MODEL");
            if (TextUtils.isEmpty(r108) == true) goto L32;
            boolean r109 = "1".equals(r108);
        L33:
            if (r109 == false) goto L35;
            ts7.c.c(new g(this, r111));
            return;
        L35:
            Context r112 = this.f18498c;
            String r113 = this.f18499d;
            String r114 = o.f(r112);
            if (TextUtils.isEmpty(r114) == true) goto L38;
            ws7.f.b(new PolarisFileWrapper(r114), r113, null);
        L38:
            onError("INVALID_FILE", "Null file", null);
            return;
        L32:
            r109 = false;
            goto L33
        }

        public void a(int r100, String r101, long r102) {
            long r103 = r102 - this.f18496a;
            RecordService r104 = RecordService.getInstance();
            String[] r105 = new String[10];
            r105[0] = "status";
            r105[1] = "end";
            r105[2] = "url";
            r105[3] = this.f18502g.f18488e;
            r105[4] = "result";
            r105[5] = String.valueOf(r100);
            r105[6] = "msg";
            if (r101 != null) goto L6;
            r101 = "NULL";
        L6:
            r105[7] = r101;
            r105[8] = "totalCost";
            r105[9] = String.valueOf(r103);
            r104.recordEvent(4, "modelDownload", r105);
        }

        @Override // com.dtf.face.network.APICallback
        public void onError(String r100, String r101, String r102) {
            if (r100.equals("INVALID_FILE") == false) goto L5;
            int r103 = -1;
        L6:
            a(r103, r100 + "-" + r101 + "-" + r102, System.currentTimeMillis());
            e r104 = this.f18502g;
            if (r104.f18486c.contains(r104.f18488e) == true) goto L9;
            e r105 = this.f18502g;
            r105.f18486c.add(r105.f18488e);
        L9:
            e r106 = this.f18502g;
            r106.f18488e = "";
            r106.a(this.f18498c, this.f18499d, this.f18500e, this.f18501f, this.f18497b);
            return;
        L5:
            r103 = 0;
            goto L6
        }

        public b(e r100, long r101, APICallback r102, Context r103, String r104, String r105, String r106) {
            this.f18502g = r100;
            this.f18496a = r101;
            this.f18497b = r102;
            this.f18498c = r103;
            this.f18499d = r104;
            this.f18500e = r105;
            this.f18501f = r106;
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f18485b != null) goto L7;
        this.f18485b = new CopyOnWriteArrayList();     // Catch: Throwable -> L17
    L7:
        if (this.f18487d != null) goto L10;
        this.f18487d = new AtomicInteger(0);     // Catch: Throwable -> L17
    L10:
        if (this.f18484a != null) goto L13;
        this.f18484a = new ConcurrentHashMap();     // Catch: Throwable -> L17
    L13:
        if (this.f18486c != null) goto L15;
        this.f18486c = new CopyOnWriteArrayList();     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public e(String r100, String r101) {
        this.f18488e = "";
        this.f18489f = r100;
        this.f18490g = r101;
    }

    public void a(Context r100, List<String> r101, boolean r110, APICallback<String> r111) {
        ts7.c.d(new a(this, r100, r101, r110, r111));
    }

    public final void a(Context r110, String r111, String r112, String r113, APICallback<File> r114) {
        if (this.f18485b.size() != 0) goto L7;
        if (r114 == null) goto L34;
        r114.onError("NO_URL", RecordService.getInstance().getSessionId(), null);
        return;
    L34:
        return;
    L7:
        this.f18487d.incrementAndGet();
        long r100 = System.currentTimeMillis();
        this.f18488e = (String) ListProtector.remove(this.f18485b, 0);
        RecordService.getInstance().recordEvent(4, "modelDownload", new String[]{"status", "start", "url", this.f18488e, "left", String.valueOf(this.f18485b.size())});
        String r115 = this.f18488e;
        b r116 = new b(this, r100, r114, r110, r111, r112, r113);
        Map<String, CopyOnWriteArrayList<APICallback<Pair<File, String>>>> r101 = ws7.e.f561074a;
        if (TextUtils.isEmpty(r115) == true) goto L26;
        if (TextUtils.isEmpty(r112) == true) goto L26;
        monitor-enter(ws7.e.class);
        Map<String, CopyOnWriteArrayList<APICallback<Pair<File, String>>>> r102 = ws7.e.f561074a;     // Catch: Throwable -> L22
        if (((ConcurrentHashMap) r102).get(r115) == null) goto L19;
        ((CopyOnWriteArrayList) ((ConcurrentHashMap) r102).get(r115)).add(r116);     // Catch: Throwable -> L22
        monitor-exit(ws7.e.class);     // Catch: Throwable -> L22
    L31:
        return;
    L19:
        CopyOnWriteArrayList r103 = new CopyOnWriteArrayList();     // Catch: Throwable -> L22
        r103.add(r116);     // Catch: Throwable -> L22
        ((ConcurrentHashMap) r102).put(r115, r103);     // Catch: Throwable -> L22
        monitor-exit(ws7.e.class);     // Catch: Throwable -> L22
        ts7.c.c(new ws7.d(r112, r113, r115, r111));
    L22:
        th = move-exception;
        throw th;
    L26:
        if (TextUtils.isEmpty(r115) == false) goto L28;
        String r104 = "urlPath is null";
    L29:
        r116.onError("NULL-PARAMS", r104, null);
        return;
    L28:
        r104 = "fileSavePath is null";
        goto L29
    }
}
