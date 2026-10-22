package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.shopping.searchsimilar.model.SortRuleInfo;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f182501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<SortRuleInfo> f182502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TabLayout f182503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimilarProductVM f182504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f182505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f182506f;

    public static final class a {
    }

    static {
    }

    public h() {
        this.f182501a = true;
        this.f182502b = new ArrayList();
        this.f182505e = -1;
        this.f182506f = 1;
    }

    public final List<Integer> a(int r100) {
        SortRuleInfo r101 = (SortRuleInfo) CollectionsKt.getOrNull(this.f182502b, r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSubSortType();
    }
}
