package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, AddressItemVO> f43724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f43725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f43726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f43727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f43728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f43729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v f43730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f43731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f43732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wi.a f43733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHashMap<Object, Unit> f43734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, Integer> f43735l;

    public final void a() {
        int r100 = this.f43730g.e().e();
        long r101 = System.currentTimeMillis();
        if (((r101 - this.f43729f) / ((long) 60000)) <= r100) goto L6;
        this.f43729f = r101;
        com.bytedance.android.ec.sdk.helper.d.f48119b.getIECSPService().e("ec_address_dialog_stat_timestamp", this.f43729f);
        this.f43728e = 0;
        return;
    }

    public w() {
        this.f43724a = new LinkedHashMap();
        this.f43725b = new b();
        this.f43726c = new b();
        this.f43727d = new b();
        this.f43730g = new v(true);
        this.f43734k = new WeakHashMap();
    }
}
