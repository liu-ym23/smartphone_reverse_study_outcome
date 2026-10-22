package com.bytedance.android.live.soloktv.fragment;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.view.CountDownTextView;
import com.bytedance.android.live.soloktv.view.MusicStartButton;
import com.bytedance.android.live.soloktv.view.SegmentSelectResult;
import com.bytedance.android.live.soloktv.viewmodel.PracticeSongViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicInterval;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.kg;
import com.bytedance.android.livesdk.message.model.n8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements CountDownTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f101223a;

    public o(p r100) {
        this.f101223a = r100;
    }

    @Override // com.bytedance.android.live.soloktv.view.CountDownTextView.a
    public final void a(CountDownTextView r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (PracticeSongFragment.Z90(this.f101223a.f101224a).canStartSing() == false) goto L57;
        MusicStartButton r111 = this.f101223a.f101224a.f101125k;
        if (r111 == null) goto L10;
        CountDownTextView r112 = r111.getCountDownTextView();
        if (r112 == null) goto L10;
        if (r112.getVisibility() != 8) goto L10;
        return;
    L10:
        MusicStartButton r113 = this.f101223a.f101224a.f101125k;
        if (r113 == null) goto L15;
        CountDownTextView r114 = r113.getCountDownTextView();
        if (r114 == null) goto L15;
        r114.setVisibility(8);
    L15:
        MusicPanel r115 = this.f101223a.f101224a.fa0();
        Long r100 = null;
        if (r115 != null) goto L18;
    L52:
        PracticeSongFragment.Z90(this.f101223a.f101224a).sendAction(new com.bytedance.android.live.soloktv.controller.l.h(null, false, null, 7));
    L53:
        MusicPanel r116 = this.f101223a.f101224a.fa0();
        if (r116 == null) goto L59;
        cb1.a r101 = cb1.a.f22994a;
        cb1.a.G(r116, true);
        return;
    L59:
        return;
    L18:
        if (kg.a(r115) != true) goto L52;
        MusicPanel r117 = this.f101223a.f101224a.fa0();
        if (r117 == null) goto L26;
        KtvMusic r118 = r117.f153577a;
        if (r118 == null) goto L26;
        MusicInterval r119 = r118.getFirstClimax();
        if (r119 == null) goto L26;
        Long r120 = Long.valueOf(r119.getStartMs());
    L27:
        MusicPanel r102 = this.f101223a.f101224a.fa0();
        if (r102 == null) goto L34;
        KtvMusic r103 = r102.f153577a;
        if (r103 == null) goto L34;
        MusicInterval r104 = r103.getFirstClimax();
        if (r104 == null) goto L34;
        r100 = Long.valueOf(n8.a(r104));
    L34:
        if (r120 == null) goto L40;
        if (r100 == null) goto L40;
        long r105 = r100.longValue();
        long r106 = r120.longValue();
        long r107 = r105 - r106;
        PracticeSongViewModel.Companion.getClass();
        if (r107 <= PracticeSongViewModel.access$getDANGEROUS_COPYRIGHT_SONG_DURATION$cp()) goto L39;
        r105 = ((long) PracticeSongViewModel.access$getDANGEROUS_COPYRIGHT_SONG_DURATION$cp()) + r106;
    L39:
        long r121 = r105;
        long r108 = r106;
    L41:
        SegmentSelectResult r122 = new SegmentSelectResult(0, 0, r108, r121);
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.soloktv.record.c r109 = SoloKtvContext.a.a().getDataStore();
        if (r109 == null) goto L48;
        com.bytedance.android.live.soloktv.model.k r123 = r109.f101453a;
        if (r123 == null) goto L48;
        eb1.f r124 = r123.b();
        if (r124 == null) goto L48;
        r124.t(r122);
    L48:
        PracticeSongFragment r125 = this.f101223a.f101224a;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r122, "segmentSelectResult");
        PracticeSongViewModel r126 = r125.f101122h;
        if (r126 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        r126.selectSegment(r122);
    L40:
        r108 = 0;
        r121 = 0;
    L26:
        r120 = null;
        goto L27
    }

    @Override // com.bytedance.android.live.soloktv.view.CountDownTextView.a
    public final void b(CountDownTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.android.live.soloktv.view.CountDownTextView.a
    public final void c(CountDownTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }
}
