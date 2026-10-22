package d5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.framwork.core.sdklib.net.ILogSendImpl;
import com.bytedance.framwork.core.sdklog.LogHandler;
import com.bytedance.framwork.core.sdkmonitor.i;
import java.net.URL;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements ILogSendImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LogHandler f19073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f19075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f19078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f19079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f19081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f19082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f19083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19084l;

    /* JADX INFO: renamed from: d5.a$a, reason: collision with other inner class name */
    public class C0233a extends LogHandler.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f19086b;

        public C0233a(a r10, String r11) {
            this.f19086b = r10;
            this.f19085a = r11;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public List getChannels() {
            return b5.b.g(this.f19085a, "sdk_monitor");
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public String getLogType() {
            return this.f19085a + "sdk_monitor";
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public int getMaxRetryCount() {
            return b5.b.d(this.f19085a);
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public String getRedirectUrl() {
            if (TextUtils.isEmpty(this.f19086b.f19083k) == true) goto L11;
            List r10 = getChannels();
            if (r10 != null) goto L7;
            return null;
        L7:
            if (r10.size() > 0) goto L14;
            return null;
        L14:
            return "https://" + this.f19086b.f19083k + new URL((String) r10.get(0)).getPath();
        L18:
            return null;
        L11:
            return null;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public long getRetryInterval() {
            return b5.b.c(this.f19085a);
        }
    }

    public class b implements LogHandler.IResponseConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f19088b;

        public b(a r10, String r11) {
            this.f19088b = r10;
            this.f19087a = r11;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IResponseConfig
        public boolean getMoreChannelSwitch() {
            return this.f19088b.f19076d;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IResponseConfig
        public boolean getRemoveSwitch() {
            return b5.b.a(this.f19087a);
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IResponseConfig
        public int getStatusCode() {
            return this.f19088b.f19074b;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IResponseConfig
        public long getStopInterval() {
            return a.a(this.f19088b);
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IResponseConfig
        public long getStopMoreChannelInterval() {
            return b5.b.h(this.f19087a);
        }
    }

    public class c extends LogHandler {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f19089g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f19090h;

        public c(a r10, Context r11, LogHandler.IConfig r12, LogHandler.IResponseConfig r13, String r14) {
            this.f19090h = r10;
            this.f19089g = r14;
            super(r11, r12, r13);
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler
        public boolean h(String r10, byte[] r11) {
            if (d5.b.a(this.f19089g) == null) goto L40;
            d5.c r12 = d5.b.a(this.f19089g).sendLog(r10, r11);
            a.b(this.f19090h, null);
            if (r12 == null) goto L39;
            int r13 = r12.f19093a;
            if (r13 <= 0) goto L39;
            a r14 = this.f19090h;
            r14.f19076d = false;
            if (r13 != 200) goto L34;
            JSONObject r15 = r12.f19094b;
            if (r15 == null) goto L34;
            if ("success".equals(r15.opt("message")) == false) goto L21;
            a.c(this.f19090h);
            String r16 = r12.f19094b.optString("redirect");
            long r17 = r12.f19094b.optLong("delay");
            if (TextUtils.isEmpty(r16) == true) goto L18;
            a.b(this.f19090h, r16);
        L18:
            if (r17 <= 0) goto L20;
            a.d(this.f19090h, r17);
        L20:
            return true;
        L21:
            boolean r18 = "drop data".equals(r12.f19094b.opt("message"));
            boolean r19 = "drop all data".equals(r12.f19094b.opt("message"));
            String r20 = r12.f19094b.optString("redirect");
            long r21 = r12.f19094b.optLong("delay");
            if (TextUtils.isEmpty(r20) == true) goto L25;
            a.b(this.f19090h, r20);
        L25:
            if (r21 <= 0) goto L27;
            a.d(this.f19090h, r21);
        L27:
            if (r18 == false) goto L29;
            a.e(this.f19090h);
        L30:
            if (r19 == false) goto L32;
            a.g(this.f19090h);
        L32:
            return false;
        L29:
            a.f(this.f19090h);
        L34:
            if (500 > r13) goto L40;
            if (r13 > 600) goto L40;
            a.h(r14);
            return false;
        L39:
            a.i(this.f19090h);
            this.f19090h.f19076d = true;
        L40:
            return false;
        }
    }

    public a(Context r10, String r11) {
        this.f19084l = true;
        this.f19079g = r11;
        this.f19078f = r10;
        C0233a r12 = new C0233a(this, r11);
        b r13 = new b(this, r11);
        this.f19073a = new c(this, r10.getApplicationContext(), r12, r13, r11);
    }

    public static /* synthetic */ long a(a r10) {
        return r10.n();
    }

    public static /* synthetic */ void b(a r10, String r11) {
        r10.j(r11);
    }

    public static /* synthetic */ void c(a r10) {
        r10.q();
    }

    public static /* synthetic */ void d(a r10, long r11) {
        r10.k(r11);
    }

    public static /* synthetic */ void e(a r10) {
        r10.m();
    }

    public static /* synthetic */ void f(a r10) {
        r10.p();
    }

    public static /* synthetic */ void g(a r10) {
        r10.l();
    }

    public static /* synthetic */ void h(a r10) {
        r10.o();
    }

    public static /* synthetic */ void i(a r10) {
        r10.s();
    }

    public final void j(String r10) {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        this.f19083k = r10;
    }

    public final void k(long r10) {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        this.f19082j = r10 * 1000;
        i.b(this.f19079g).P(this.f19082j);
    }

    public final void l() {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        o();
        i.b(this.f19079g).Q(true);
        i.b(this.f19079g).n();
        i.b(this.f19079g).o();
    }

    @Override // com.bytedance.framwork.core.sdklib.net.ILogSendImpl
    public boolean logStopCollectSwitch() {
        return false;
    }

    public final void m() {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        o();
        i.b(this.f19079g).Q(true);
    }

    public final long n() {
        if (this.f19084l == true) goto L7;
        return 0;
    L7:
        if (this.f19075c <= this.f19081i) goto L9;
        long r10 = this.f19075c;
    L11:
        if (r10 <= this.f19082j) goto L14;
        return r10;
    L14:
        return this.f19082j;
    L9:
        r10 = this.f19081i;
        goto L11
    }

    public final void o() {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        int r10 = this.f19077e;
        if (r10 != 0) goto L8;
        this.f19075c = 300000;
        this.f19077e++;
    L14:
        i.b(this.f19079g).P(this.f19075c);
        return;
    L8:
        if (r10 != 1) goto L11;
        this.f19075c = 900000;
        this.f19077e++;
        goto L14
    L11:
        if (r10 != 2) goto L13;
        this.f19075c = 1800000;
        this.f19077e++;
        goto L14
    L13:
        this.f19075c = 1800000;
        this.f19077e++;
        goto L14
    }

    public final void p() {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        i.b(this.f19079g).Q(false);
    }

    public final void q() {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        i.b(this.f19079g).O();
        i.b(this.f19079g).Q(false);
        this.f19077e = 0;
        this.f19075c = 0;
        this.f19080h = 0;
        this.f19081i = 0;
        this.f19082j = 0;
    }

    public void r(String r10) {
        this.f19073a.j(r10);
    }

    public final void s() {
        if (this.f19084l == true) goto L5;
        return;
    L5:
        int r10 = this.f19080h;
        if (r10 != 0) goto L8;
        this.f19081i = PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
        this.f19080h++;
    L17:
        i.b(this.f19079g).P(this.f19081i);
        return;
    L8:
        if (r10 != 1) goto L11;
        this.f19081i = 60000;
        this.f19080h++;
        goto L17
    L11:
        if (r10 != 2) goto L14;
        this.f19081i = 120000;
        this.f19080h++;
        goto L17
    L14:
        if (r10 != 3) goto L16;
        this.f19081i = 240000;
        this.f19080h++;
        goto L17
    L16:
        this.f19081i = 300000;
        this.f19080h++;
        goto L17
    }

    @Override // com.bytedance.framwork.core.sdklib.net.ILogSendImpl
    public boolean send(String r10) {
        return this.f19073a.a(r10);
    }
}
