package com.bytedance.ai.model.widgets;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends d3.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f37067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f37068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContainerType f37069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f37070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f37071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f37072f;

    @Override // d3.a0
    public final String getAppId() {
        return this.f37068b;
    }

    @Override // d3.a0
    public final String getAppletId() {
        return this.f37067a;
    }

    @Override // d3.a0
    public final String getContainerId() {
        return this.f37070d;
    }

    @Override // d3.a0
    public final ContainerType getContainerType() {
        return this.f37069c;
    }

    @Override // d3.a0
    public final String getTag() {
        return this.f37072f;
    }

    @Override // d3.a0
    public final String getUrl() {
        return this.f37071e;
    }

    public n(k2.j r100, String r101) {
        this.f37067a = r100.getAppletId();
        this.f37068b = r100.getPageInfo().getPageId();
        this.f37069c = ContainerType.PAGE;
        this.f37070d = r100.getPageID();
        this.f37071e = r100.getPageInfo().getPageUrl();
        this.f37072f = r101;
    }
}
