package com.bytedance.android.live.effect.beauty.makeups;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMakeupsBeautyFragment f67343a;

    public c(LiveMakeupsBeautyFragment r100) {
        this.f67343a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        List<String> r101 = LiveEffectContext.f66734h;
        a r102 = LiveEffectContext.a.a(this.f67343a.f67320i).b().f();
        d r103 = (d) r102;
        r103.b(this.f67343a.f67326o);
    }
}
