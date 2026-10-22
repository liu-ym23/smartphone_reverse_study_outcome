package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class k extends c implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f149609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f149610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f149611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xi2.k0 f149612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f149613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f149614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f149615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f149616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f149617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<? extends List<String>> f149618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f149619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f149620n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f149621o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f149622p;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final boolean a() {
        if (this.f149571a == false) goto L25;
        int r100 = this.f149617k;
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L15;
        String r101 = this.f149613g;
        if (r101 != null) goto L10;
    L21:
        boolean r102 = false;
    L22:
        if (r102 == true) goto L26;
        return true;
    L26:
        return false;
    L10:
        if (r101.length() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 != true) goto L21;
    L20:
        r102 = true;
        goto L22
    L12:
        r103 = false;
        goto L13
    L15:
        si2.i r104 = s.f149646s;
        if (s.d.e(this.f149613g, 100) <= 0) goto L21;
    L18:
        si2.i r105 = s.f149646s;
        if (s.d.e(this.f149613g, 1) <= 0) goto L21;
    L25:
        return false;
    }

    public final List<String> d() {
        Function0<? extends List<String>> r100 = this.f149618l;
        if (r100 == null) goto L6;
        List<String> r101 = r100.invoke();
        if (r101 == null) goto L6;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return new ArrayList();
    L6:
        xi2.k0 r102 = this.f149612f;
        if (r102 == null) goto L9;
        r101 = r102.b();
        goto L10
    L9:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f149622p == true) goto L6;
        return th.a.h(r100, R.string.ec_live_flash_toast_select, new Object[]{this.f149573b});
    L6:
        return th.a.h(r100, R.string.ec_live_flash_toast_input, new Object[]{this.f149573b});
    }

    public String c(Context r100) {
        if (r100 == null) goto L4;
        String r101 = th.a.h(r100, R.string.ec_live_flash_input_hint, new Object[]{this.f149573b});
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    public k(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "hint");
        super(r100);
        this.f149621o = r101;
        this.f149622p = r102;
        this.f149615i = 20;
        this.f149616j = Integer.MIN_VALUE;
        this.f149617k = 2;
        this.f149620n = CollectionsKt.emptyList();
    }
}
