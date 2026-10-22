package com.bytedance.android.anniex.monitor;

import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f40995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f40996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f40997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f40998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f40999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f41000g;

    public b() {
        this.f40996c = "init";
        this.f40997d = "new";
        this.f40998e = GearStrategyConsts.EV_SELECT_BEGIN;
        this.f40999f = "unknown";
        this.f41000g = UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain();
    }
}
