package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f181246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f181247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f181248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f181249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f181250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f181251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f181252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f181253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<View, IAction, Unit> f181254i;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r100, Map<String, ? extends Object> r101, Boolean r102, Function0<Boolean> r103, Function2<? super View, ? super IAction, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "slcContext");
        Intrinsics.checkNotNullParameter(r103, "collectGetter");
        Intrinsics.checkNotNullParameter(r104, "actionExecutor");
        this.f181250e = r100;
        this.f181251f = r101;
        this.f181252g = r102;
        this.f181253h = r103;
        this.f181254i = r104;
    }
}
