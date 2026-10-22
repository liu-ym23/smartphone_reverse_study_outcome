package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f132075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f132076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f132077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f132078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f132079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f132080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f132081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f132082h;

    public h() {
        Intrinsics.checkNotNullParameter("", "msg");
        Intrinsics.checkNotNullParameter("", "extraInfo");
        this.f132079e = "";
        this.f132080f = false;
        this.f132081g = 0;
        this.f132082h = "";
        this.f132075a = "";
        this.f132076b = "";
        this.f132077c = new ArrayList();
    }

    public final String toString() {
        return "s:" + this.f132077c + ",m:" + this.f132079e + ",gid:" + this.f132075a + ",aid:" + this.f132076b + ",bir:" + this.f132080f + ",sc:" + this.f132081g + ",ext:" + this.f132082h + "; ";
    }
}
