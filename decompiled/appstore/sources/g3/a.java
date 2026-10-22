package g3;

import android.text.TextUtils;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import r3.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile a f19900i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f19901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f19902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f19903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f19905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u3.a f19906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IConfigManager f19907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u3.a f19908h;

    /* JADX INFO: renamed from: g3.a$a, reason: collision with other inner class name */
    public class C0256a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f19909d;

        public C0256a(a r10, long r11, long r12) {
            this.f19909d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(d3.a.n()) == false) goto L7;
            s3.a.a(ConfigConstants.LOG_TAG, "DeviceId not ready. try again later.");
            return;
        L7:
            if (a.a(this.f19909d) != null) goto L13;
            if (r3.a.c() == false) goto L11;
            s3.a.a(ConfigConstants.LOG_TAG, "DeviceId ready. initConfig with device_id=" + d3.a.n());
        L11:
            a.b(this.f19909d);
        L15:
            u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(a.c(this.f19909d));
            return;
        L13:
            if (r3.a.c() == false) goto L15;
            s3.a.a(ConfigConstants.LOG_TAG, "config is ready");
            goto L15
        }
    }

    public class b implements IConfigListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f19910a;

        /* JADX INFO: renamed from: g3.a$b$a, reason: collision with other inner class name */
        public class C0257a extends u3.a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f19911d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f19912e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f19913f;

            public C0257a(b r10, JSONObject r11, boolean r12) {
                this.f19913f = r10;
                this.f19911d = r11;
                this.f19912e = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(a.d(this.f19913f.f19910a));     // Catch: Exception -> L7
                a.e(this.f19913f.f19910a, null);     // Catch: Exception -> L7
                a.f(this.f19913f.f19910a, this.f19911d, this.f19912e);     // Catch: Exception -> L7
                if (r3.a.c() == false) goto L12;
                s3.a.a(ConfigConstants.LOG_TAG, "updateCurrentConfig:" + this.f19911d);     // Catch: Exception -> L7
                return;
            L12:
                return;
            L7:
                e = move-exception;
                s3.a.c(ConfigConstants.LOG_TAG, "onConfigChanged", e);
            }
        }

        public b(a r10) {
            this.f19910a = r10;
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public void onReady() {
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public void onRefresh(JSONObject r10, boolean r11) {
            if (r10 != null) goto L16;
            return;
        L16:
            if (r3.a.c() == false) goto L8;
            s3.a.a(ConfigConstants.LOG_TAG, "onRefresh:" + r11 + " " + r10);     // Catch: Exception -> L15
        L8:
            if (d3.a.A() == true) goto L10;
        L13:
            a.e(this.f19910a, new C0257a(this, new JSONObject(r10.toString()), r11));     // Catch: Exception -> L15
            u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(a.d(this.f19910a));     // Catch: Exception -> L15
            return;
        L10:
            if (a.a(this.f19910a) == null) goto L13;
            if (r11 == false) goto L13;
            return;
        }
    }

    public a() {
        this.f19901a = false;
    }

    public static /* synthetic */ JSONObject a(a r10) {
        return r10.f19903c;
    }

    public static /* synthetic */ void b(a r10) {
        r10.i();
    }

    public static /* synthetic */ u3.a c(a r10) {
        return r10.f19906f;
    }

    public static /* synthetic */ u3.a d(a r10) {
        return r10.f19908h;
    }

    public static /* synthetic */ u3.a e(a r10, u3.a r11) {
        r10.f19908h = r11;
        return r11;
    }

    public static /* synthetic */ void f(a r10, JSONObject r11, boolean r12) {
        r10.m(r11, r12);
    }

    public static a g() {
        if (f19900i != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19900i != null) goto L11;
        f19900i = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19900i;
    }

    public synchronized void h() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f19901a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f19901a = true;     // Catch: Throwable -> L11
        if (d3.a.A() == false) goto L13;
        this.f19906f = new C0256a(this, 500, 1000);     // Catch: Throwable -> L11
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f19906f);     // Catch: Throwable -> L11
    L13:
        IConfigManager r10 = (IConfigManager) n5.b.a(IConfigManager.class);     // Catch: Throwable -> L11
        this.f19907g = r10;     // Catch: Throwable -> L11
        r10.registerConfigListener(new b(this));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void i() {
        if (this.f19907g != null) goto L5;
        this.f19907g = (IConfigManager) n5.b.a(IConfigManager.class);
    L5:
        IConfigManager r10 = this.f19907g;
        if (r10 != null) goto L8;
        return;
    L8:
        String r11 = r10.queryConfig();
        if (r3.a.c() == false) goto L16;
        s3.a.a(ConfigConstants.LOG_TAG, "initConfig:" + r11);
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        m(new JSONObject(r11), true);     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    public final void j(JSONObject r10, boolean r11) {
        this.f19905e = true;
        List r12 = this.f19902b;
        if (r12 == null) goto L10;
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L17;
        ((IConfigChangeListener) r13.next()).onConfigChanged(r10, r11);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    public void k(IConfigChangeListener r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f19902b != null) goto L8;
        this.f19902b = new CopyOnWriteArrayList();
    L8:
        if (this.f19902b.contains(r10) == true) goto L11;
        this.f19902b.add(r10);
    L11:
        if (this.f19905e == false) goto L14;
        r10.onConfigChanged(this.f19903c, this.f19904d);
        return;
    }

    public void l(IConfigChangeListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List r11 = this.f19902b;
        if (r11 == null) goto L8;
        r11.remove(r10);
        return;
    }

    public final void m(JSONObject r10, boolean r11) {
        if (e.d(r10) == false) goto L5;
        return;
    L5:
        this.f19903c = r10;
        this.f19904d = r11;
        j(r10, r11);
    }
}
