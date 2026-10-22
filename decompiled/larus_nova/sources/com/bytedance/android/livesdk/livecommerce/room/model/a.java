package com.bytedance.android.livesdk.livecommerce.room.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends ql.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f151863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f151864b;

    @Override // ql.a
    public final String getCover() {
        String r100 = this.f151863a;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // ql.a
    /* JADX INFO: renamed from: getTitle */
    public final String mo8154getTitle() {
        return this.f151864b;
    }

    @Override // ql.a
    public final void setCover(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cover");
        this.f151863a = r100;
    }

    @Override // ql.a
    public final void setTitle(String r100) {
        this.f151864b = r100;
    }

    public a(String r100, String r101) {
        this.f151863a = r100;
        this.f151864b = r101;
    }
}
