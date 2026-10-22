package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseDispatchAction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    private static final String TAG = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<String> f8425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<String> f8426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<String> f8427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<String> f8428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<String> f8429e;
    protected List<String> f;
    protected List<String> g;
    protected String h;
    protected int i;
    private long j;
    private long k;
    private int l;
    private long m;
    private List<String> n;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseDispatchAction.java */
    public static final enum EnumC0191a extends Enum<EnumC0191a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0191a f8430a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0191a f8431b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0191a f8432c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0191a f8433d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ EnumC0191a[] f8434e = null;

        static {
            EnumC0191a r0 = new EnumC0191a("DISPATCH_NONE", 0);
            f8430a = r0;
            EnumC0191a r1 = new EnumC0191a("DISPATCH_HIT", 1);
            f8431b = r1;
            EnumC0191a r3 = new EnumC0191a("DISPATCH_DROP", 2);
            f8432c = r3;
            EnumC0191a r5 = new EnumC0191a("DISPATCH_DELAY", 3);
            f8433d = r5;
            f8434e = new EnumC0191a[]{r0, r1, r3, r5};
        }

        private EnumC0191a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0191a valueOf(String r2) {
            return (EnumC0191a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0191a.class, r2), EnumC0191a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0191a[] values() {
            return (EnumC0191a[]) ZeusTransformUtils.preCheckCast(f8434e.clone(), EnumC0191a[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
    }

    public abstract boolean a(JSONObject r1, String r2, long r3);

    public a() {
        this.f8425a = new ArrayList();
        this.f8426b = new ArrayList();
        this.f8427c = new ArrayList();
        this.f8428d = new ArrayList();
        this.f8429e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.n = new ArrayList();
    }

    public static a a(String r8, JSONObject r9, int r10, long r11, long r13, long r15, String r17, long r18, List<String> r20, int r21) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if (r8.equals("tc") == false) goto L5;
        a r2 = new j();
    L7:
        if (r8.equals("dispatch") == false) goto L10;
        r2 = new g();
    L10:
        if (r8.equals("delay") == false) goto L12;
        r2 = new c();
    L12:
        if (r2 != null) goto L14;
        return null;
    L14:
        r2.a(r10);
        r2.a(r11, r13);
        r2.a(r15);
        r2.a(r1);
        r2.b(r21);
        if (r2.a(r9, r17, r18) == false) goto L17;
        return r2;
    L17:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    private void a(int r1) {
        this.l = r1;
    }

    private void a(long r1, long r3) {
        this.j = r1;
        this.k = r3;
    }

    private void a(long r1) {
        this.m = r1;
    }

    private void a(List<String> r3) {
        this.n = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    private void b(int r1) {
        if (r1 >= 0) goto L4;
        this.i = Integer.MAX_VALUE;
        return;
    L4:
        this.i = r1;
    }

    public int a() {
        return this.l;
    }

    public long b() {
        return this.m;
    }

    public String c() {
        return this.h;
    }

    public boolean a(m r5) {
        if (r5.c() <= this.l) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "jump action: " + this.h + ", dispatchPriority: " + r5.c() + ", actionPriority: " + this.l);
    L7:
        return false;
    L9:
        if (this.n.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r5.a()) == true) goto L19;
        if (this.n.contains(r5.a()) == true) goto L19;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "request method not support: " + r5.a());
    L17:
        return false;
    L19:
        return e();
    }

    public boolean d() {
        return e();
    }

    private boolean e() {
        long r0 = this.j;
        if (r0 != 0) goto L8;
        if (this.k != 0) goto L8;
        return true;
    L8:
        if (r0 != (-1)) goto L10;
    L20:
        return false;
    L10:
        if (this.k == (-1)) goto L20;
        long r2 = System.currentTimeMillis();
        if (r2 <= this.j) goto L18;
        if (r2 >= this.k) goto L18;
        return true;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "current time is out action lifecycle");
        goto L20
    }

    public void a(JSONObject r5) {
        a(r5, "host_group", this.f8425a, false);
        a(r5, "equal_group", this.f8426b, false);
        a(r5, "prefixes_group", this.f8427c, false);
        a(r5, "contain_group", this.f8428d, false);
        a(r5, "pattern_group", this.f8429e, true);
        a(r5, "url_group", this.f, true);
        a(r5, "path_contain", this.g, false);
    }

    public boolean a(Uri r8) {
        if (this.f8425a.isEmpty() == false) goto L5;
    L4:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        String r1 = r8.getPath();
        if (TextUtils.isEmpty(r1) == false) goto L21;
        return false;
    L21:
        if (this.f8426b.isEmpty() == true) goto L32;
        Iterator<String> r4 = this.f8426b.iterator();
    L24:
        if (r4.hasNext() == false) goto L32;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        if (r1.equals(r5) == false) goto L24;
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "path equal hit: " + r5);
    L30:
        return true;
    L32:
        if (this.f8427c.isEmpty() == true) goto L43;
        Iterator<String> r6 = this.f8427c.iterator();
    L35:
        if (r6.hasNext() == false) goto L43;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        if (r1.startsWith(r7) == false) goto L35;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "path prefix hit: " + r7);
    L41:
        return true;
    L43:
        if (this.f8428d.isEmpty() == true) goto L54;
        Iterator<String> r9 = this.f8428d.iterator();
    L46:
        if (r9.hasNext() == false) goto L54;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
        if (r1.contains(r10) == false) goto L46;
        if (Logger.debug() == false) goto L52;
        Logger.d(TAG, "path contain hit: " + r10);
    L52:
        return true;
    L54:
        if (this.f8429e.isEmpty() == true) goto L65;
        Iterator<String> r11 = this.f8429e.iterator();
    L57:
        if (r11.hasNext() == false) goto L65;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        if (r1.matches(r12) == false) goto L57;
        if (Logger.debug() == false) goto L63;
        Logger.d(TAG, "path pattern hit: " + r12);
    L63:
        return true;
    L65:
        if (this.f.isEmpty() == false) goto L67;
    L86:
        return false;
    L67:
        if (this.g.isEmpty() == true) goto L77;
        Iterator<String> r13 = this.g.iterator();
    L70:
        if (r13.hasNext() == false) goto L74;
        if (r1.contains((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L70;
        boolean r2 = true;
    L75:
        if (r2 == true) goto L77;
        return false;
    L74:
        r2 = false;
    L77:
        Iterator<String> r14 = this.f.iterator();
    L79:
        if (r14.hasNext() == false) goto L86;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        if (r8.toString().matches(r3) == false) goto L79;
        if (Logger.debug() == false) goto L85;
        Logger.d(TAG, "full url hit: " + r3);
    L85:
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "host group is not match");
    L16:
        return false;
    L5:
        Iterator<String> r15 = this.f8425a.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        if (com.bytedance.frameworks.baselib.network.http.i.l.a(r8.getHost(), (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L7;
    L11:
        r0 = false;
        goto L12
    }

    private void a(JSONObject r2, String r3, List<String> r4, boolean r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        JSONArray r6 = r2.optJSONArray(r3);
        if (r6 == null) goto L15;
        int r7 = 0;
    L6:
        if (r7 >= r6.length()) goto L21;
        String r8 = r6.optString(r7);
        if (TextUtils.isEmpty(r8) == true) goto L14;
        if (r5 == true) goto L11;
        r1.add(r8);
        goto L14
    L11:
        if (a(r8) == false) goto L14;
        r1.add(r8);
    L14:
        r7 = r7 + 1;
        goto L6
    L21:
        return;
    }

    public static boolean a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return false;
    L9:
        Pattern.compile(r2);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }
}
