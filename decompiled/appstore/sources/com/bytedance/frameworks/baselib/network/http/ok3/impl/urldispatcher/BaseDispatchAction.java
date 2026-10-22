package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.channels.Channel;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDispatchAction {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7456n = "BaseDispatchAction";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f7457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f7458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f7459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f7460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f7461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f7462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f7469m;

    public static final enum DispatchResultEnum extends Enum<DispatchResultEnum> {
        private static final /* synthetic */ DispatchResultEnum[] $VALUES = null;
        public static final DispatchResultEnum DISPATCH_DELAY = null;
        public static final DispatchResultEnum DISPATCH_DROP = null;
        public static final DispatchResultEnum DISPATCH_HIT = null;
        public static final DispatchResultEnum DISPATCH_NONE = null;

        static {
            DispatchResultEnum r10 = new DispatchResultEnum("DISPATCH_NONE", 0);
            DISPATCH_NONE = r10;
            DispatchResultEnum r11 = new DispatchResultEnum("DISPATCH_HIT", 1);
            DISPATCH_HIT = r11;
            DispatchResultEnum r12 = new DispatchResultEnum("DISPATCH_DROP", 2);
            DISPATCH_DROP = r12;
            DispatchResultEnum r13 = new DispatchResultEnum("DISPATCH_DELAY", 3);
            DISPATCH_DELAY = r13;
            $VALUES = new DispatchResultEnum[]{r10, r11, r12, r13};
        }

        private DispatchResultEnum(String r10, int r11) {
            super(r10, r11);
        }

        public static DispatchResultEnum valueOf(String r10) {
            return (DispatchResultEnum) Enum.valueOf(DispatchResultEnum.class, r10);
        }

        public static DispatchResultEnum[] values() {
            return (DispatchResultEnum[]) $VALUES.clone();
        }
    }

    static {
    }

    public BaseDispatchAction() {
        this.f7457a = new ArrayList();
        this.f7458b = new ArrayList();
        this.f7459c = new ArrayList();
        this.f7460d = new ArrayList();
        this.f7461e = new ArrayList();
        this.f7462f = new ArrayList();
        this.f7469m = new ArrayList();
    }

    public static BaseDispatchAction a(String r10, JSONObject r11, int r12, long r13, long r14, long r15, String r16, long r17, List r19, int r20) {
        if (r10.equals("tc") == false) goto L5;
        BaseDispatchAction r18 = new e();
    L7:
        if (r10.equals("dispatch") == false) goto L10;
        r18 = new c();
    L10:
        if (r10.equals("delay") == false) goto L12;
        r18 = new b();
    L12:
        if (r18 != null) goto L14;
        return null;
    L14:
        r18.m(r12);
        r18.l(r13, r14);
        r18.n(r15);
        r18.p(r19);
        r18.o(r20);
        if (r18.e(r11, r16, r17) == false) goto L17;
        return r18;
    L17:
        return null;
    L5:
        r18 = null;
        goto L7
    }

    public int b() {
        return this.f7465i;
    }

    public long c() {
        return this.f7466j;
    }

    public String d() {
        return this.f7467k;
    }

    public abstract boolean e(JSONObject r10, String r11, long r12);

    public boolean f(u4.c r10) {
        if (r10.a() <= this.f7465i) goto L7;
        Logger.d(f7456n, "jump action: " + this.f7467k + ", dispatchPriority: " + r10.a() + ", actionPriority: " + this.f7465i);
        return false;
    L7:
        if (this.f7469m.isEmpty() == true) goto L15;
        if (TextUtils.isEmpty(r10.b()) == true) goto L15;
        if (this.f7469m.contains(r10.b()) == true) goto L15;
        Logger.d(f7456n, "request method not support: " + r10.b());
        return false;
    L15:
        return h();
    }

    public boolean g() {
        return h();
    }

    public final boolean h() {
        long r10 = this.f7463g;
        if (r10 != 0) goto L8;
        if (this.f7464h != 0) goto L8;
        return true;
    L8:
        if (r10 != (-1)) goto L10;
    L18:
        return false;
    L10:
        if (this.f7464h == (-1)) goto L18;
        long r11 = System.currentTimeMillis();
        if (r11 > this.f7463g) goto L15;
    L17:
        Logger.d(f7456n, "current time is out action lifecycle");
        goto L18
    L15:
        if (r11 >= this.f7464h) goto L17;
        return true;
    }

    public boolean i(Uri r10) {
        if (this.f7457a.isEmpty() == true) goto L10;
        Iterator r11 = this.f7457a.iterator();
    L7:
        if (r11.hasNext() == false) goto L58;
        if (i.i(r10.getHost(), (String) r11.next()) == false) goto L7;
    L58:
        Logger.d(f7456n, "host group is not match");
        return false;
    L10:
        String r12 = r10.getPath();
        if (r12 == null) goto L49;
        if (this.f7458b.isEmpty() == true) goto L22;
        Iterator r13 = this.f7458b.iterator();
    L16:
        if (r13.hasNext() == false) goto L22;
        String r14 = (String) r13.next();
        if (r12.equals(r14) == false) goto L16;
        Logger.d(f7456n, "path equal hit: " + r14);
        return true;
    L22:
        if (this.f7459c.isEmpty() == true) goto L31;
        Iterator r15 = this.f7459c.iterator();
    L25:
        if (r15.hasNext() == false) goto L31;
        String r16 = (String) r15.next();
        if (r12.startsWith(r16) == false) goto L25;
        Logger.d(f7456n, "path prefix hit: " + r16);
        return true;
    L31:
        if (this.f7460d.isEmpty() == true) goto L40;
        Iterator r17 = this.f7460d.iterator();
    L34:
        if (r17.hasNext() == false) goto L40;
        String r18 = (String) r17.next();
        if (r12.contains(r18) == false) goto L34;
        Logger.d(f7456n, "path contain hit: " + r18);
        return true;
    L40:
        if (this.f7461e.isEmpty() == true) goto L49;
        Iterator r19 = this.f7461e.iterator();
    L43:
        if (r19.hasNext() == false) goto L49;
        String r20 = (String) r19.next();
        if (r12.matches(r20) == false) goto L43;
        Logger.d(f7456n, "path pattern hit: " + r20);
        return true;
    L49:
        if (this.f7462f.isEmpty() == true) goto L57;
        Iterator r21 = this.f7462f.iterator();
    L52:
        if (r21.hasNext() == false) goto L57;
        String r22 = (String) r21.next();
        if (r10.toString().matches(r22) == false) goto L52;
        Logger.d(f7456n, "full url hit: " + r22);
        return true;
    L57:
        return false;
    }

    public void j(JSONObject r10) {
        k(r10, "host_group", this.f7457a);
        k(r10, "equal_group", this.f7458b);
        k(r10, "prefixes_group", this.f7459c);
        k(r10, "contain_group", this.f7460d);
        k(r10, "pattern_group", this.f7461e);
        k(r10, "url_group", this.f7462f);
    }

    public final void k(JSONObject r10, String r11, List r12) {
        JSONArray r13 = r10.optJSONArray(r11);
        if (r13 == null) goto L11;
        int r14 = 0;
    L6:
        if (r14 >= r13.length()) goto L15;
        String r15 = r13.optString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        r12.add(r15);
    L10:
        r14 = r14 + 1;
        goto L6
    L15:
        return;
    }

    public final void l(long r10, long r11) {
        this.f7463g = r10;
        this.f7464h = r11;
    }

    public final void m(int r10) {
        this.f7465i = r10;
    }

    public final void n(long r10) {
        this.f7466j = r10;
    }

    public final void o(int r10) {
        if (r10 >= 0) goto L4;
        this.f7468l = Channel.UNLIMITED;
        return;
    L4:
        this.f7468l = r10;
    }

    public final void p(List r10) {
        this.f7469m = r10;
    }
}
