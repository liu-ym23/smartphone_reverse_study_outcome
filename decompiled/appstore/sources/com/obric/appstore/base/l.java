package com.obric.appstore.base;

import com.tmall.wireless.tangram.dataparser.concrete.Card;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f10576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Job f10577b;

    public l(j r10, Job r11) {
        q.g(r10, Card.KEY_API_LOAD_PARAMS);
        q.g(r11, "job");
        this.f10576a = r10;
        this.f10577b = r11;
    }

    public final void a() {
        Job.a.b(this.f10577b, null, 1, null);
    }

    public final Job b() {
        return this.f10577b;
    }

    public final j c() {
        return this.f10576a;
    }
}
