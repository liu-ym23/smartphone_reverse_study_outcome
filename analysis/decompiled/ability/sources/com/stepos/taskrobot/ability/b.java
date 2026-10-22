package com.stepos.taskrobot.ability;

import com.stepos.taskrobot.ability.OpenOnDisplayResult;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b implements OpenOnDisplayResult {

    /* renamed from: a, reason: collision with root package name */
    public final OpenOnDisplayResult.Reason f4023a;
    public final String b;

    public b(OpenOnDisplayResult.Reason reason, String str) {
        this.f4023a = reason;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4023a == bVar.f4023a && k.b(this.b, bVar.b);
    }

    public final int hashCode() {
        int iHashCode = this.f4023a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "Failure(reason=" + this.f4023a + ", detail=" + this.b + ")";
    }
}
