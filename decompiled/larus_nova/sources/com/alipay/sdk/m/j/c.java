package com.alipay.sdk.m.j;

/* JADX INFO: loaded from: classes28.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f25362c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f25363d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f25364e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f25365f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f25366g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f25367h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f25368i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f25369j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ c[] f25370k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25372b;

    static {
        c r100 = new c("SUCCEEDED", 0, 9000, "处理成功");
        f25362c = r100;
        c r101 = new c("FAILED", 1, 4000, "系统繁忙，请稍后再试");
        f25363d = r101;
        c r102 = new c("CANCELED", 2, 6001, "用户取消");
        f25364e = r102;
        c r103 = new c("NETWORK_ERROR", 3, 6002, "网络连接异常");
        f25365f = r103;
        c r104 = new c("ACTIVITY_NOT_START_EXIT", 4, 6007, "支付未完成");
        f25366g = r104;
        c r105 = new c("PARAMS_ERROR", 5, 4001, "参数错误");
        f25367h = r105;
        c r106 = new c("DOUBLE_REQUEST", 6, 5000, "重复请求");
        f25368i = r106;
        c r110 = new c("PAY_WAITTING", 7, 8000, "支付结果确认中");
        f25369j = r110;
        f25370k = new c[]{r100, r101, r102, r103, r104, r105, r106, r110};
    }

    public static c[] values() {
        return (c[]) f25370k.clone();
    }

    public String a() {
        return this.f25372b;
    }

    public int b() {
        return this.f25371a;
    }

    public static c b(int r100) {
        if (r100 == 4001) goto L27;
        if (r100 == 5000) goto L25;
        if (r100 == 8000) goto L23;
        if (r100 == 9000) goto L21;
        if (r100 == 6001) goto L19;
        if (r100 == 6002) goto L17;
        return f25363d;
    L17:
        return f25365f;
    L19:
        return f25364e;
    L21:
        return f25362c;
    L23:
        return f25369j;
    L25:
        return f25368i;
    L27:
        return f25367h;
    }

    public static c valueOf(String r100) {
        return (c) r27.a.a(c.class, r100);
    }

    public void a(int r100) {
        this.f25371a = r100;
    }

    public void a(String r100) {
        this.f25372b = r100;
    }

    public c(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.f25371a = r102;
        this.f25372b = r103;
    }
}
