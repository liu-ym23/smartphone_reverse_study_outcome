package com.alipay.sdk.m.r;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;

/* JADX INFO: loaded from: classes28.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f25731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25732c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f25733d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f25734e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25735f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f25736g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ a[] f25737h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25738a;

    static {
        a r100 = new a("None", 0, "none");
        f25731b = r100;
        a r101 = new a("WapPay", 1, "js://wappay");
        f25732c = r101;
        a r102 = new a(UserChangedCallback.CHANGE_TYPE_UPDATE, 2, "js://update");
        f25733d = r102;
        a r103 = new a("OpenWeb", 3, "loc:openweb");
        f25734e = r103;
        a r104 = new a("SetResult", 4, "loc:setResult");
        f25735f = r104;
        a r105 = new a("Exit", 5, "loc:exit");
        f25736g = r105;
        f25737h = new a[]{r100, r101, r102, r103, r104, r105};
    }

    public static a[] values() {
        return (a[]) f25737h.clone();
    }

    public static a a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        a r101 = f25731b;
        a[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L15;
        a r105 = r102[r104];
        if (r100.startsWith(r105.f25738a) == true) goto L12;
        r104 = r104 + 1;
        goto L7
    L12:
        return r105;
    L15:
        return r101;
    L5:
        return f25731b;
    }

    public static a valueOf(String r100) {
        return (a) r27.a.a(a.class, r100);
    }

    public a(String r100, int r101, String r102) {
        super(r100, r101);
        this.f25738a = r102;
    }
}
