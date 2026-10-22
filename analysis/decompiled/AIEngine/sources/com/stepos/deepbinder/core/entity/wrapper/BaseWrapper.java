package com.stepos.deepbinder.core.entity.wrapper;

import f.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public abstract class BaseWrapper {
    private String name = "";

    public final String getName() {
        return this.name;
    }

    public abstract void recycle();

    public final void setName(String str) {
        g.f(str, "<set-?>");
        this.name = str;
    }
}
