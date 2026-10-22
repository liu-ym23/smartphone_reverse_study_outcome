package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunMode f11466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RepeatMode f11467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f11469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11470e;

    public a(RunMode r10, RepeatMode r11, float r12, float r13, boolean r14) {
        q.g(r10, "runMode");
        q.g(r11, "repeatMode");
        this.f11466a = r10;
        this.f11467b = r11;
        this.f11468c = r12;
        this.f11469d = r13;
        this.f11470e = r14;
    }

    public final boolean a() {
        return this.f11470e;
    }

    public final RepeatMode b() {
        return this.f11467b;
    }

    public final RunMode c() {
        return this.f11466a;
    }

    public final float d() {
        return this.f11468c;
    }

    public final float e() {
        return this.f11469d;
    }
}
