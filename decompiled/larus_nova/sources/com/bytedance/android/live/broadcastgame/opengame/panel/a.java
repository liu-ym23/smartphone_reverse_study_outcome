package com.bytedance.android.live.broadcastgame.opengame.panel;

import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f60670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseOpenMethod<R> f60671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<JSONObject, Unit> f60672c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f60670a == r101.f60670a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f60671b, r101.f60671b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f60672c, r101.f60672c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f60670a * 31;
        BaseOpenMethod<R> r101 = this.f60671b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Function1<JSONObject, Unit> r105 = this.f60672c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "DoubleBallLoadingEvent(visibility=" + this.f60670a + ", callMethod=" + this.f60671b + ", returnCallWithResult=" + this.f60672c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, BaseOpenMethod<R> r101, Function1<? super JSONObject, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "callMethod");
        Intrinsics.checkNotNullParameter(r102, "returnCallWithResult");
        this.f60670a = r100;
        this.f60671b = r101;
        this.f60672c = r102;
    }
}
