package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements AdjustPercentBar.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sticker.ComposerConfig f67849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdjustBarListAdapter f67850b;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r100) {
        AdjustBarListAdapter r101 = this.f67850b;
        Sticker r102 = r101.f67801a;
        if (r102 == null) goto L6;
        r101.f67804d.a(r102, this.f67849a);
        return;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r100) {
        AdjustBarListAdapter r101 = this.f67850b;
        Sticker r102 = r101.f67801a;
        if (r102 == null) goto L6;
        r101.f67804d.b(r102, this.f67849a, r100);
        return;
    }

    public c(Sticker.ComposerConfig r100, AdjustBarListAdapter r101) {
        this.f67849a = r100;
        this.f67850b = r101;
    }
}
