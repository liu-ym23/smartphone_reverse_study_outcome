package com.smt.obric.appstore.domain.sysapp.autoupdate;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18118a;

    public a(List r10) {
        this.f18118a = r10;
    }

    public final List a() {
        return this.f18118a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L9;
        return false;
    L9:
        if (q.b(this.f18118a, ((a) r10).f18118a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List r10 = this.f18118a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public String toString() {
        return "AppStoreSettings(sysappAutoupdateWhitelist=" + this.f18118a + ')';
    }

    public /* synthetic */ a(List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
