package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.DialogInterface;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderFirstLevelTabFragment f142805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f142806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f142807c;

    public h(OrderFirstLevelTabFragment r100, List r101, y r102) {
        this.f142805a = r100;
        this.f142806b = r101;
        this.f142807c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r102 = this.f142805a.C;
        if (r102 == null) goto L6;
        r102.orderPlayAllSong(this.f142806b, this.f142807c);
        return;
    }
}
