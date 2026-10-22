package com.bytedance.android.live.effect.beauty;

import android.view.View;
import com.bytedance.android.live.effect.template.BeautifyTemplate;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBeautifyFragmentNew f67290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BeautifyTemplate.BeautifyContentType f67291b;

    public h(LiveBeautifyFragmentNew r100, BeautifyTemplate.BeautifyContentType r101) {
        this.f67290a = r100;
        this.f67291b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveBeautifyFragmentNew r101 = this.f67290a;
        BeautifyTemplate.BeautifyContentType r102 = this.f67291b;
        Map<BeautifyTemplate.BeautifyContentType, Integer> r103 = LiveBeautifyFragmentNew.A;
        r101.V90(r102);
        this.f67290a.W90();
    }
}
