package com.stepos.statsrpk;

import h.RunnableC0583a;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f12370a;

    /* renamed from: b, reason: collision with root package name */
    public d f12371b;

    /* renamed from: c, reason: collision with root package name */
    public String f12372c;

    /* renamed from: d, reason: collision with root package name */
    public RunnableC0583a f12373d;

    public final String a() {
        if (this.f12372c == null) {
            synchronized (this) {
                this.f12372c = UUID.randomUUID().toString();
                T2.d.a("RpkPageController", "generate a sessionId: " + this.f12372c);
            }
        }
        return this.f12372c;
    }
}
