package com.autonavi.aps.protocol.aps.request.model.a;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.protocol.aps.common.enums.Version;
import com.autonavi.aps.protocol.aps.request.model.fields.GpsMocking;
import com.autonavi.aps.protocol.aps.request.model.fields.GpsType;
import com.autonavi.aps.protocol.aps.request.model.fields.HisLocCtxs;
import com.autonavi.aps.protocol.aps.request.model.fields.InfType;
import com.autonavi.aps.protocol.aps.request.model.fields.b;
import com.autonavi.aps.protocol.aps.request.model.fields.bluetooth.Bluetooths;
import com.autonavi.aps.protocol.aps.request.model.fields.cell.GsmNbCells;
import com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells;
import com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells;
import com.autonavi.aps.protocol.aps.request.model.fields.context.TrackPoints;
import com.autonavi.aps.protocol.aps.request.model.fields.context.c;
import com.autonavi.aps.protocol.aps.request.model.fields.wifi.NbWifis;
import com.autonavi.aps.protocol.aps.request.model.message.a;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.sse.ServerSentEventKt;

/* loaded from: classes.dex */
public class a {

    /* renamed from: Q, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.request.model.fields.a.a f18893Q;

    /* renamed from: a, reason: collision with root package name */
    private a.C0215a f18894a = new a.C0215a();

    /* renamed from: b, reason: collision with root package name */
    private a.b f18895b = new a.b();

    /* renamed from: c, reason: collision with root package name */
    private b f18896c = new b();

    /* renamed from: d, reason: collision with root package name */
    private String f18897d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f18898e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f18899f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f18900g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f18901h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f18902i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f18903j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f18904k = null;

    /* renamed from: l, reason: collision with root package name */
    private String f18905l = null;

    /* renamed from: m, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.request.model.fields.wifi.a f18906m = null;

    /* renamed from: n, reason: collision with root package name */
    private String f18907n = null;

    /* renamed from: o, reason: collision with root package name */
    private String f18908o = null;

    /* renamed from: p, reason: collision with root package name */
    private String f18909p = null;

    /* renamed from: q, reason: collision with root package name */
    private String f18910q = null;

    /* renamed from: r, reason: collision with root package name */
    private String f18911r = null;

    /* renamed from: s, reason: collision with root package name */
    private InfType f18912s = InfType.Unknown;

    /* renamed from: t, reason: collision with root package name */
    private GpsType f18913t = GpsType.Hardware;

    /* renamed from: u, reason: collision with root package name */
    private GpsMocking f18914u = GpsMocking.Real;

    /* renamed from: v, reason: collision with root package name */
    private double f18915v = 0.0d;

    /* renamed from: w, reason: collision with root package name */
    private double f18916w = 0.0d;

    /* renamed from: x, reason: collision with root package name */
    private short f18917x = 0;

    /* renamed from: y, reason: collision with root package name */
    private short f18918y = 0;

    /* renamed from: z, reason: collision with root package name */
    private short f18919z = 0;

    /* renamed from: A, reason: collision with root package name */
    private short f18877A = 0;

    /* renamed from: B, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.request.model.fields.cell.b f18878B = null;

    /* renamed from: C, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.request.model.fields.cell.a f18879C = null;

    /* renamed from: D, reason: collision with root package name */
    private String f18880D = null;

    /* renamed from: E, reason: collision with root package name */
    private NewApiCells f18881E = null;

    /* renamed from: F, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.request.model.fields.wifi.b f18882F = null;

    /* renamed from: G, reason: collision with root package name */
    private NbWifis f18883G = null;

    /* renamed from: H, reason: collision with root package name */
    private TrackPoints f18884H = null;

    /* renamed from: I, reason: collision with root package name */
    private com.autonavi.aps.protocol.aps.request.model.fields.context.b f18885I = null;

    /* renamed from: J, reason: collision with root package name */
    private Bluetooths f18886J = null;

    /* renamed from: K, reason: collision with root package name */
    private c f18887K = null;

    /* renamed from: L, reason: collision with root package name */
    private byte[] f18888L = null;

    /* renamed from: M, reason: collision with root package name */
    private HistoryCells f18889M = null;

    /* renamed from: N, reason: collision with root package name */
    private String f18890N = null;

    /* renamed from: O, reason: collision with root package name */
    private HisLocCtxs f18891O = null;

    /* renamed from: P, reason: collision with root package name */
    private String f18892P = null;

    public double A() {
        return this.f18916w;
    }

    public short B() {
        return this.f18917x;
    }

    public short C() {
        return this.f18918y;
    }

    public short D() {
        return this.f18919z;
    }

    public short E() {
        return this.f18877A;
    }

    public com.autonavi.aps.protocol.aps.request.model.fields.cell.b F() {
        return this.f18878B;
    }

    public com.autonavi.aps.protocol.aps.request.model.fields.cell.a G() {
        return this.f18879C;
    }

    public GsmNbCells H() {
        return null;
    }

    public NewApiCells I() {
        return this.f18881E;
    }

    public com.autonavi.aps.protocol.aps.request.model.fields.wifi.b J() {
        return this.f18882F;
    }

    public NbWifis K() {
        return this.f18883G;
    }

    public TrackPoints L() {
        return this.f18884H;
    }

    public com.autonavi.aps.protocol.aps.request.model.fields.context.b M() {
        return this.f18885I;
    }

    public Bluetooths N() {
        return this.f18886J;
    }

    public c O() {
        return this.f18887K;
    }

    public byte[] P() {
        return this.f18888L;
    }

    public HistoryCells Q() {
        return this.f18889M;
    }

    public HisLocCtxs R() {
        return this.f18891O;
    }

    public com.autonavi.aps.protocol.aps.request.model.fields.a.a S() {
        return this.f18893Q;
    }

    public byte[] T() {
        return null;
    }

    public Version a() {
        return this.f18895b.a();
    }

    public a.C0215a b() {
        return this.f18894a;
    }

    public a.b c() {
        return this.f18895b;
    }

    public b d() {
        return this.f18896c;
    }

    public String e() {
        String str = this.f18897d;
        String strA = this.f18895b.a("src");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String f() {
        String str = this.f18898e;
        String strA = this.f18895b.a("license");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public void g(String str) {
    }

    public String h() {
        String str = this.f18900g;
        String strA = this.f18895b.a("serverIp");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String i() {
        String str = this.f18901h;
        String strA = this.f18895b.a(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL);
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String j() {
        String str = this.f18902i;
        String strA = this.f18895b.a(Parameters.OS);
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String k() {
        String str = this.f18903j;
        String strA = this.f18895b.a("appName");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String l() {
        String str = this.f18904k;
        String strA = this.f18895b.a("imeiId");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String m() {
        String str = this.f18905l;
        String strA = this.f18895b.a("imsi");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String n() {
        String str = this.f18910q;
        String strA = this.f18895b.a("adiu");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public com.autonavi.aps.protocol.aps.request.model.fields.wifi.a o() {
        String strA = this.f18895b.a(Const.STR_PREF_KEY_SMAC);
        return (com.autonavi.aps.protocol.aps.common.e.a.b(strA) && strA.length() == 17 && strA.split(ServerSentEventKt.COLON).length == 6) ? new com.autonavi.aps.protocol.aps.request.model.fields.wifi.a(strA) : this.f18906m;
    }

    public String p() {
        String str = this.f18907n;
        String strA = this.f18895b.a("sdkVer");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String q() {
        String str = this.f18908o;
        String strA = this.f18895b.a("colVer");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String r() {
        String str = this.f18909p;
        String strA = this.f18895b.a("utdId");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public void s(String str) {
    }

    public String t() {
        String str = this.f18892P;
        String strA = this.f18895b.a(Parameters.OAID);
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String u() {
        String str = this.f18880D;
        String strA = this.f18895b.a("networkOperator");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String v() {
        return this.f18911r;
    }

    public InfType w() {
        return this.f18912s;
    }

    public GpsType x() {
        return this.f18913t;
    }

    public GpsMocking y() {
        return this.f18914u;
    }

    public double z() {
        return this.f18915v;
    }

    public void a(a.C0215a c0215a) {
        this.f18894a = c0215a;
    }

    public void b(String str) {
        this.f18898e = str;
    }

    public void c(String str) {
        this.f18899f = str;
    }

    public void d(String str) {
        this.f18900g = str;
    }

    public String g() {
        String str = this.f18899f;
        String strA = this.f18895b.a("key");
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public String s() {
        String str = this.f18890N;
        String strA = this.f18895b.a(Parameters.SN);
        return com.autonavi.aps.protocol.aps.common.e.a.b(strA) ? strA : str;
    }

    public void a(a.b bVar) {
        this.f18895b = bVar;
    }

    public void b(double d10) {
        this.f18916w = d10;
    }

    public void c(short s10) {
        this.f18919z = s10;
    }

    public void d(short s10) {
        this.f18877A = s10;
    }

    public void a(b bVar) {
        this.f18896c = bVar;
    }

    public void b(short s10) {
        this.f18918y = s10;
    }

    public void e(String str) {
        this.f18901h = str;
    }

    public void f(String str) {
        this.f18902i = str;
    }

    public void h(String str) {
        this.f18903j = str;
    }

    public void i(String str) {
        this.f18904k = str;
    }

    public void j(String str) {
        this.f18905l = str;
    }

    public void k(String str) {
        this.f18910q = str;
    }

    public void l(String str) {
        this.f18907n = str;
    }

    public void m(String str) {
        this.f18908o = str;
    }

    public void n(String str) {
        this.f18909p = str;
    }

    public void p(String str) {
        this.f18892P = str;
    }

    public void q(String str) {
        this.f18880D = str;
    }

    public void r(String str) {
        this.f18911r = str;
    }

    public void a(String str) {
        this.f18897d = str;
    }

    public void o(String str) {
        this.f18890N = str;
    }

    public void a(com.autonavi.aps.protocol.aps.request.model.fields.wifi.a aVar) {
        this.f18906m = aVar;
    }

    public void a(InfType infType) {
        this.f18912s = infType;
    }

    public void a(GpsType gpsType) {
        this.f18913t = gpsType;
    }

    public void a(GpsMocking gpsMocking) {
        this.f18914u = gpsMocking;
    }

    public void a(double d10) {
        this.f18915v = d10;
    }

    public void a(short s10) {
        this.f18917x = s10;
    }

    public void a(com.autonavi.aps.protocol.aps.request.model.fields.cell.b bVar) {
        this.f18878B = bVar;
    }

    public void a(com.autonavi.aps.protocol.aps.request.model.fields.cell.a aVar) {
        this.f18879C = aVar;
    }

    public void a(NewApiCells newApiCells) {
        this.f18881E = newApiCells;
    }

    public void a(com.autonavi.aps.protocol.aps.request.model.fields.wifi.b bVar) {
        this.f18882F = bVar;
    }

    public void a(NbWifis nbWifis) {
        this.f18883G = nbWifis;
    }

    public void a(TrackPoints trackPoints) {
        this.f18884H = trackPoints;
    }

    public void a(com.autonavi.aps.protocol.aps.request.model.fields.context.b bVar) {
        this.f18885I = bVar;
    }

    public void a(Bluetooths bluetooths) {
        this.f18886J = bluetooths;
    }

    public void a(c cVar) {
        this.f18887K = cVar;
    }

    public void a(byte[] bArr) {
        this.f18888L = bArr;
    }

    public void a(HistoryCells historyCells) {
        this.f18889M = historyCells;
    }

    public void a(HisLocCtxs hisLocCtxs) {
        this.f18891O = hisLocCtxs;
    }

    public void a(Version version) {
        this.f18895b.a(version);
    }

    public void a(com.autonavi.aps.protocol.aps.request.model.fields.a.a aVar) {
        this.f18893Q = aVar;
    }
}
