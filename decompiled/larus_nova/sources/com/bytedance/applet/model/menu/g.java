package com.bytedance.applet.model.menu;

import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.applet.aibridge.menu.WidgetMenuItem;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function7<List<WidgetMenuItem>, com.bytedance.applet.aibridge.menu.b, WidgetContainer, String, String, JSONObject, Function2<? super String, ? super String, Unit>, Unit> f192160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Object, Function0<Unit>, Unit> f192161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Object, Function0<Unit>, Unit> f192162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Object, Function0<Unit>, Unit> f192163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Function2<Object, Function0<Unit>, Unit>> f192164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f192165f;

    public g() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f192160a, r101.f192160a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f192161b, r101.f192161b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f192162c, r101.f192162c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f192163d, r101.f192163d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f192164e, r101.f192164e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f192165f, r101.f192165f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f192160a.hashCode() * 31) + this.f192161b.hashCode()) * 31) + this.f192162c.hashCode()) * 31) + this.f192163d.hashCode()) * 31) + this.f192164e.hashCode()) * 31) + this.f192165f.hashCode();
    }

    public final String toString() {
        return "WidgetMenuConfig(showMenu=" + this.f192160a + ", deleteAction=" + this.f192161b + ", shareAction=" + this.f192162c + ", reportAction=" + this.f192163d + ", systemActionMap=" + this.f192164e + ", onCollectionChanged=" + this.f192165f + ')';
    }

    public g(a r100, b r101, c r102, d r103, e r104) {
        Map<String, Function2<Object, Function0<Unit>, Unit>> r105 = MapsKt.mapOf(new Pair[]{TuplesKt.to(SystemAction.DELETE.getValue(), r101), TuplesKt.to(SystemAction.SHARE.getValue(), r102), TuplesKt.to(SystemAction.REPORT.getValue(), r103)});
        Intrinsics.checkNotNullParameter(r100, "showMenu");
        Intrinsics.checkNotNullParameter(r101, "deleteAction");
        Intrinsics.checkNotNullParameter(r102, "shareAction");
        Intrinsics.checkNotNullParameter(r103, "reportAction");
        Intrinsics.checkNotNullParameter(r105, "systemActionMap");
        Intrinsics.checkNotNullParameter(r104, "onCollectionChanged");
        this.f192160a = r100;
        this.f192161b = r101;
        this.f192162c = r102;
        this.f192163d = r103;
        this.f192164e = r105;
        this.f192165f = r104;
    }
}
