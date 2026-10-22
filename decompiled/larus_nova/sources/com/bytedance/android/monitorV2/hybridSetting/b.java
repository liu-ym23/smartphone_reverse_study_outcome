package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f163062e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BidInfo f163063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Integer> f163064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f163065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CheckFilter f163066d;

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final HybridSettingInitConfig getInitConfig() {
        return null;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final void init(Context r100) {
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final List<lz2.a> a() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final CheckFilter b() {
        if (this.f163066d != null) goto L6;
        this.f163066d = new CheckFilter();
    L6:
        return this.f163066d;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final Map<String, Integer> c() {
        if (this.f163064b != null) goto L6;
        this.f163064b = new HashMap();
    L6:
        return this.f163064b;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final BidInfo d() {
        if (this.f163063a != null) goto L6;
        this.f163063a = new BidInfo();
    L6:
        return this.f163063a;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final Set<String> e() {
        if (this.f163065c != null) goto L6;
        this.f163065c = new HashSet();
    L6:
        return this.f163065c;
    }

    public b() {
    }
}
