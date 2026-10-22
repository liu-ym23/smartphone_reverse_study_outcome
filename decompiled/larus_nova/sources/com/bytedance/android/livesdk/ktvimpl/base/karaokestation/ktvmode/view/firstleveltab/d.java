package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.DialogInterface;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MineFirstLevelTabFragment f142799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f142800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f142801c;

    public d(MineFirstLevelTabFragment r100, List r101, y r102) {
        this.f142799a = r100;
        this.f142800b = r101;
        this.f142801c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r102 = this.f142799a.E;
        if (r102 == null) goto L6;
        r102.orderPlayAllSong(this.f142800b, this.f142801c);
        return;
    }
}
