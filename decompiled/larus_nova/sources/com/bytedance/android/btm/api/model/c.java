package com.bytedance.android.btm.api.model;

import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f42012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f42014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PageFinder f42015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f42016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f42017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f42018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f42019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, Object> f42020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f42021k;

    public final boolean a() {
        Boolean r100 = this.f42012b;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final String toString() {
        return "BtmItem(btm='" + this.f42011a + "', _enterPage=" + this.f42012b + ", enterPageTimes=" + this.f42013c + ", targetPagesBtm=" + this.f42014d + ", content=" + this.f42020j + ", useTopPageWhenNotFindPage= " + this.f42021k + ')';
    }

    public c() {
        this.f42011a = "";
        this.f42013c = 1;
        this.f42014d = new ArrayList();
        this.f42015e = new PageFinder();
        this.f42017g = -1;
        this.f42019i = 10;
        this.f42020j = new LinkedHashMap();
    }
}
