package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CycleActivityView41 f177683a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r110) {
        CycleActivityView41 r111 = this.f177683a;
        long r100 = r111.f177669g;
        if (r100 <= 0) goto L5;
        r111.f177664b.setText((CharSequence) ListProtector.get(CycleActivityView41.f177662l, 0));
        TextView r112 = this.f177683a.f177667e;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        long r102 = 60;
        r112.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r100 % r102)}, 1)));
        this.f177683a.f177666d.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf((r100 / r102) % r102)}, 1)));
        this.f177683a.f177665c.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r100 / ((long) AnnouncementViewModel.HOUR_DURATION))}, 1)));
    L8:
        this.f177683a.f177669g--;
        return;
    L5:
        r111.f177664b.setText((CharSequence) ListProtector.get(CycleActivityView41.f177662l, 1));
        this.f177683a.f177667e.setText(CustomAlbumViewModel.DEFAULT_TAB_ID);
        this.f177683a.f177666d.setText(CustomAlbumViewModel.DEFAULT_TAB_ID);
        this.f177683a.f177665c.setText(CustomAlbumViewModel.DEFAULT_TAB_ID);
        b r113 = this.f177683a.f177672j;
        if (r113 == null) goto L8;
        r113.cancel();
        goto L8
    }

    public b(CycleActivityView41 r100, long r101, long r102) {
        this.f177683a = r100;
        super(r101, r102);
    }
}
