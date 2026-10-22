package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.widget.CompoundButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabPopoverFilterMenuView.b f61615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f61616b;

    public b(TabPopoverFilterMenuView.b r100, int r101) {
        this.f61615a = r100;
        this.f61616b = r101;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        if (r101 == false) goto L7;
        Function1<? super Integer, Unit> r102 = this.f61615a.f61605c;
        if (r102 == null) goto L8;
        Unit r103 = r102.invoke(Integer.valueOf(this.f61616b));
        return;
    L8:
        return;
    }
}
