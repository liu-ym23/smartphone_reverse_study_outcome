package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelfDisciplineTimerView f79725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f79726b;

    public a(SelfDisciplineTimerView r100, String r101) {
        this.f79725a = r100;
        this.f79726b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r100 = (Long) r110;
        Long r101 = this.f79725a.getMDurationHolder().get(this.f79726b);
        if (r101 != null) goto L9;
        ILinkPlayerInfoBridge r102 = this.f79725a.getMPlayerInfo();
        if (r102 == null) goto L7;
        long r103 = r102.getSelfDisciplineDuration();
    L8:
        r101 = Long.valueOf(r103);
        goto L9
    L7:
        r103 = 0;
    L9:
        long r104 = r101.longValue();
        TextView r105 = (TextView) this.f79725a.a(R.id.tv_timer);
        if (r105 == null) goto L12;
        this.f79725a.getClass();
        r105.setText(SelfDisciplineTimerView.d(r104));
    L12:
        SelfDisciplineContext.Companion.getClass();
        int r106 = SelfDisciplineContext.a.a();
        ILinkPlayerInfoBridge r107 = this.f79725a.getMPlayerInfo();
        if (r107 == null) goto L15;
        long r108 = r107.getSelfDisciplineTargetDuration();
    L17:
        if (r106 == 1) goto L19;
    L51:
        this.f79725a.getMDurationHolder().put(this.f79726b, Long.valueOf(r104 + 1));
        return;
    L19:
        if (r108 != 0) goto L26;
        ImageView r109 = (ImageView) this.f79725a.a(R.id.iv_timer);
        if (r109 == null) goto L23;
        r109.setVisibility(8);
    L23:
        LinearLayout r111 = (LinearLayout) this.f79725a.a(R.id.timer_container);
        if (r111 == null) goto L51;
        r111.setBackground(s1.m(R.drawable.ttlive_self_discipline_timer_bg));
        goto L51
    L26:
        long r112 = 3;
        long r113 = r104 - r108;
        if (0 > r113) goto L38;
        if (r112 < r113) goto L38;
        ImageView r114 = (ImageView) this.f79725a.a(R.id.iv_timer);
        if (r114 == null) goto L34;
        r114.setVisibility(0);
    L34:
        LinearLayout r115 = (LinearLayout) this.f79725a.a(R.id.timer_container);
        if (r115 == null) goto L51;
        r115.setBackground(s1.m(R.drawable.ttlive_self_discipline_timer_complete_bg));
    L38:
        if (r104 <= r108) goto L45;
        ImageView r116 = (ImageView) this.f79725a.a(R.id.iv_timer);
        if (r116 == null) goto L42;
        r116.setVisibility(0);
    L42:
        LinearLayout r117 = (LinearLayout) this.f79725a.a(R.id.timer_container);
        if (r117 == null) goto L51;
        r117.setBackground(s1.m(R.drawable.ttlive_self_discipline_timer_bg));
        goto L51
    L45:
        ImageView r118 = (ImageView) this.f79725a.a(R.id.iv_timer);
        if (r118 == null) goto L48;
        r118.setVisibility(8);
    L48:
        LinearLayout r119 = (LinearLayout) this.f79725a.a(R.id.timer_container);
        if (r119 == null) goto L51;
        r119.setBackground(s1.m(R.drawable.ttlive_self_discipline_timer_bg));
        goto L51
    L15:
        r108 = 0;
        goto L17
    }
}
