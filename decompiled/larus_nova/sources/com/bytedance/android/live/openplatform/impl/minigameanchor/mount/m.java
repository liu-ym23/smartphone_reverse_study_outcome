package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.widget.CompoundButton;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f85238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 f85239b;

    public m(TextView r100, LiveMgMountContextService$showStarAtlasAgreementDialog$1 r101) {
        this.f85238a = r100;
        this.f85239b = r101;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f85238a.setTextColor(-1);
        this.f85238a.setBackground(s1.m(R.drawable.ttlive_bg_mg_agree_star_altas_btn));
        this.f85239b.invoke2("tick");
        return;
    L4:
        this.f85238a.setTextColor(ColorProtector.parseColor("#80FFFFFF"));
        this.f85238a.setBackground(s1.m(R.drawable.ttlive_bg_mg_agree_star_altas_disable_btn));
        this.f85239b.invoke2("untick");
    }
}
