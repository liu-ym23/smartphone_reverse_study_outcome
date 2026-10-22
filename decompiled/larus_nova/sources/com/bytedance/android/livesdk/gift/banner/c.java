package com.bytedance.android.livesdk.gift.banner;

import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f125846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsPanel f125847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l2 f125848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f125849d;

    public c(d r100, AbsPanel r101, l2 r102, String r103) {
        this.f125846a = r100;
        this.f125847b = r101;
        this.f125848c = r102;
        this.f125849d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        d.I(this.f125846a, this.f125847b, this.f125848c, this.f125849d, false);
        this.f125846a.f125850e = false;
    }
}
