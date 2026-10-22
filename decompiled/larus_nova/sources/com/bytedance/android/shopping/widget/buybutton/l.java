package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.model.ButtonTime;
import com.bytedance.android.ec.model.ButtonType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f187328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f187329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f187330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f187331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ButtonTime f187332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ButtonType f187333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f187334g;

    public l() {
        this(null, null, null, null, null, ButtonType.NORMAL, null);
    }

    public l(String r100, String r101, String r102, Boolean r103, ButtonTime r104, ButtonType r105, Integer r106) {
        Intrinsics.checkNotNullParameter(r105, "buttonType");
        this.f187328a = r100;
        this.f187329b = r101;
        this.f187330c = r102;
        this.f187331d = r103;
        this.f187332e = r104;
        this.f187333f = r105;
        this.f187334g = r106;
    }
}
