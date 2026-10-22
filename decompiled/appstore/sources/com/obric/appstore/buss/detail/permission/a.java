package com.obric.appstore.buss.detail.permission;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10696b;

    public a(String r10, String r11) {
        q.g(r10, "title");
        q.g(r11, "desc");
        this.f10695a = r10;
        this.f10696b = r11;
    }

    public final String a() {
        return this.f10696b;
    }

    public final String b() {
        return this.f10695a;
    }
}
