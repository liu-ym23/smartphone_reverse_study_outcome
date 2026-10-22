package com.google.android.gms.common.api.internal;

import ch.qos.logback.core.joran.action.Action;
import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final C0403a f9677a;

    /* renamed from: b, reason: collision with root package name */
    public final Feature f9678b;

    public /* synthetic */ r(C0403a c0403a, Feature feature) {
        this.f9677a = c0403a;
        this.f9678b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof r)) {
            r rVar = (r) obj;
            if (com.airbnb.lottie.h.m(this.f9677a, rVar.f9677a) && com.airbnb.lottie.h.m(this.f9678b, rVar.f9678b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9677a, this.f9678b});
    }

    public final String toString() {
        B0.e eVar = new B0.e(this);
        eVar.a(this.f9677a, Action.KEY_ATTRIBUTE);
        eVar.a(this.f9678b, "feature");
        return eVar.toString();
    }
}
