package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f148375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f148376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f148377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f148378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<View, Function0<Unit>, Unit> f148379e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.manager.a$a, reason: collision with other inner class name */
    public static final class C2298a {
    }

    static {
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        int r100 = this.f148375a;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f148376b.hashCode() * 31) + this.f148377c.hashCode()) * 31) + this.f148378d) * 31) + this.f148379e.hashCode()) * 31) + this.f148375a;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AnimationRequest(card = ");
        r100.append(this.f148377c.getClass().getSimpleName());
        r100.append('@');
        r100.append(this.f148377c.hashCode());
        r100.append(", id=");
        r100.append(this.f148376b);
        r100.append(", animType=");
        if (this.f148378d != 0) goto L5;
        String r101 = "show";
    L6:
        r100.append(r101);
        r100.append(')');
        return r100.toString();
    L5:
        r101 = "hide";
        goto L6
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f148376b, r101.f148376b) == true) goto L10;
        return false;
    L10:
        if (this.f148378d != r101.f148378d) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, View r101, int r102, Function2<? super View, ? super Function0<Unit>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, GXTemplateKey.GAIAX_ANIMATION);
        this.f148376b = r100;
        this.f148377c = r101;
        this.f148378d = r102;
        this.f148379e = r103;
    }
}
