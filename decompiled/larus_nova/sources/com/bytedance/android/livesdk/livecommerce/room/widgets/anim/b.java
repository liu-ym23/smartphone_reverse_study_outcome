package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f151990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f151991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f151992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f151993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<View, Function0<Unit>, Unit> f151994e;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final int hashCode() {
        return (((((((this.f151991b.hashCode() * 31) + this.f151992c.hashCode()) * 31) + this.f151993d) * 31) + this.f151994e.hashCode()) * 31) + this.f151990a;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AnimationRequest(card = ");
        r100.append(this.f151992c.getClass().getSimpleName());
        r100.append('@');
        r100.append(this.f151992c.hashCode());
        r100.append(", id=");
        r100.append(this.f151991b);
        r100.append(", animType=");
        if (this.f151993d != 0) goto L5;
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
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f151991b, r101.f151991b) == true) goto L10;
        return false;
    L10:
        if (this.f151993d != r101.f151993d) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, View r101, int r102, Function2<? super View, ? super Function0<Unit>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, GXTemplateKey.GAIAX_ANIMATION);
        this.f151991b = r100;
        this.f151992c = r101;
        this.f151993d = r102;
        this.f151994e = r103;
    }
}
