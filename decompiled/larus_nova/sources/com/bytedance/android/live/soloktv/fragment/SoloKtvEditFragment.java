package com.bytedance.android.live.soloktv.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.soloktv.SoloKtvActivity;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.view.SoloKtvAlignVoiceView;
import com.bytedance.android.live.soloktv.view.SoloKtvEditTuningEffectAdapter;
import com.bytedance.android.live.soloktv.viewmodel.SoloKtvEditViewModel;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/soloktv/fragment/SoloKtvEditFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvEditFragment extends Fragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f101149u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f101150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f101151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SoloKtvAlignVoiceView f101152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SeekBarWithProgress f101153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SeekBarWithProgress f101154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f101155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f101156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f101157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f101158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SoloKtvEditTuningEffectAdapter f101159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SoloKtvEditViewModel f101160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.model.bean.h f101161o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f101162p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f101163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f101164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f101165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f101166t;

    public static final class a {
    }

    static {
    }

    public SoloKtvEditFragment() {
        this.f101163q = "";
        this.f101164r = "";
        this.f101165s = "";
        this.f101166t = "";
    }

    public static final void S90(SoloKtvEditFragment r110) {
        SoloKtvEditViewModel r100 = r110.f101160n;
        if (r100 == null) goto L5;
        r100.doAction(com.bytedance.android.live.soloktv.viewmodel.f.m.f101902a);
    L5:
        SoloKtvEditViewModel r101 = r110.f101160n;
        if (r101 == null) goto L8;
        r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.i.f101896a);
    L8:
        cb1.a r102 = cb1.a.f22994a;
        long r103 = r110.f101162p;
        String r104 = r110.f101163q;
        String r105 = r110.f101164r;
        SoloKtvEditViewModel r106 = r110.f101160n;
        if (r106 == null) goto L15;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r107 = r106.getUIState();
        if (r107 == null) goto L15;
        com.bytedance.android.live.soloktv.viewmodel.g r108 = r107.getValue();
        if (r108 == null) goto L15;
        int r109 = r108.f101908a;
    L16:
        SoloKtvEditViewModel r111 = r110.f101160n;
        if (r111 == null) goto L23;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r112 = r111.getUIState();
        if (r112 == null) goto L23;
        com.bytedance.android.live.soloktv.viewmodel.g r113 = r112.getValue();
        if (r113 == null) goto L23;
        int r114 = r113.f101909b;
    L24:
        SoloKtvEditViewModel r115 = r110.f101160n;
        if (r115 == null) goto L31;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r116 = r115.getUIState();
        if (r116 == null) goto L31;
        com.bytedance.android.live.soloktv.viewmodel.g r117 = r116.getValue();
        if (r117 == null) goto L31;
        int r118 = r117.f101910c;
    L32:
        Integer r119 = Integer.valueOf(r118);
        cb1.a.U(r103, r104, r105, "video_edit_page", r109, r114, null, r119, 64);
        FragmentActivity r120 = r110.getActivity();
        if (r120 == null) goto L35;
        r120.finish();
    L35:
        r110.startActivity(new Intent(r110.getContext(), SoloKtvActivity.class));
        return;
    L31:
        r118 = 0;
    L23:
        r114 = 50;
    L15:
        r109 = 50;
        goto L16
    }

    public static final void T90(SoloKtvEditFragment r100) {
        r100.getClass();
        com.bytedance.android.live.soloktv.util.l.b r101 = com.bytedance.android.live.soloktv.util.l.f101621d;
        if ((r101 instanceof com.bytedance.android.live.soloktv.util.l.b.a) == false) goto L5;
    L8:
        f2.b(R.string.ttlive_solo_ktv_in_save_window_publish, 0);
        return;
    L5:
        if ((r101 instanceof com.bytedance.android.live.soloktv.util.l.b.c) == true) goto L8;
        f2.b(R.string.ttlive_solo_ktv_in_save_window_save_draft, 0);
    }

    public final void U90(com.bytedance.android.live.ktv.common.model.bean.h r100, Boolean r101) {
        if (r100 == null) goto L20;
        SoloKtvEditTuningEffectAdapter r102 = this.f101159m;
        if (r102 == null) goto L6;
        int r103 = r102.y2(r100);
    L7:
        if (r103 >= 0) goto L9;
        return;
    L9:
        if (r100.f69999a == false) goto L16;
        if (r103 <= 0) goto L12;
    L13:
        RecyclerView r104 = this.f101158l;
        if (r104 == null) goto L16;
        r104.smoothScrollToPosition(r103);
        goto L16
    L12:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L13;
    L16:
        SoloKtvEditTuningEffectAdapter r105 = this.f101159m;
        if (r105 == null) goto L22;
        r105.notifyItemRangeChanged(r103, 1);
        return;
    L22:
        return;
    L6:
        r103 = -1;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        SoloKtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<MusicPanel> r112 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r112 == null) goto L7;
        MusicPanel r113 = r112.getValue();
        if (r113 == null) goto L7;
        KtvMusic r114 = r113.f153577a;
    L8:
        if (r114 == null) goto L10;
        long r100 = r114.getMId();
    L11:
        this.f101162p = r100;
        String r101 = "";
        if (r114 == null) goto L15;
        String r102 = r114.getMTitle();
        if (r102 == null) goto L15;
    L16:
        this.f101163q = r102;
        if (r114 == null) goto L20;
        String r115 = r114.getMAuthor();
        if (r115 == null) goto L20;
    L21:
        this.f101165s = r115;
        com.bytedance.live.datacontext.n<MusicPanel> r116 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r116 == null) goto L27;
        MusicPanel r117 = r116.getValue();
        if (r117 == null) goto L27;
        String r118 = r117.f153580d;
        if (r118 == null) goto L27;
    L28:
        this.f101166t = r118;
        String r119 = SoloKtvContext.a.a().getFromSource();
        if (r119 == null) goto L32;
        r101 = r119;
    L32:
        this.f101164r = r101;
        this.f101150d = r110.findViewById(R.id.voice_delay_btn);
        this.f101151e = r110.findViewById(R.id.voice_advance_btn);
        View r120 = this.f101150d;
        if (r120 == null) goto L35;
        r120.post(new s(this));
    L35:
        View r121 = this.f101151e;
        if (r121 == null) goto L38;
        r121.post(new t(this));
    L38:
        View r122 = this.f101150d;
        if (r122 == null) goto L41;
        r122.setOnClickListener(new u(this));
    L41:
        View r123 = this.f101151e;
        if (r123 == null) goto L44;
        r123.setOnClickListener(new v(this));
    L44:
        this.f101155i = (TextView) r110.findViewById(R.id.tv_voice_align_desc);
        SoloKtvAlignVoiceView r124 = (SoloKtvAlignVoiceView) r110.findViewById(R.id.voice_align_seek_bar);
        this.f101152f = r124;
        if (r124 == null) goto L47;
        r124.setAlignChangedCallback(new SoloKtvEditFragment$initView$5(this));
    L47:
        SeekBarWithProgress r125 = (SeekBarWithProgress) r110.findViewById(R.id.voice_volume_seek_bar);
        this.f101153g = r125;
        if (r125 == null) goto L50;
        r125.setProgressBarDrawable(s1.m(R.drawable.solo_ktv_edit_seek_bar_bg));
    L50:
        SeekBarWithProgress r126 = this.f101153g;
        if (r126 == null) goto L53;
        r126.setOnSeekBarChangeListener(new w(this));
    L53:
        SeekBarWithProgress r127 = (SeekBarWithProgress) r110.findViewById(R.id.music_volume_seek_bar);
        this.f101154h = r127;
        if (r127 == null) goto L56;
        r127.setProgressBarDrawable(s1.m(R.drawable.solo_ktv_edit_seek_bar_bg));
    L56:
        SeekBarWithProgress r128 = this.f101154h;
        if (r128 == null) goto L59;
        r128.setOnSeekBarChangeListener(new x(this));
    L59:
        this.f101158l = (RecyclerView) r110.findViewById(R.id.tuning_effect_list);
        this.f101157k = (LiveDoubleColorBallAnimationView) r110.findViewById(R.id.loading_tuning_effect_view);
        this.f101156j = (FrameLayout) r110.findViewById(R.id.loading_tuning_effect_view_container);
        this.f101159m = new SoloKtvEditTuningEffectAdapter();
        RecyclerView r129 = this.f101158l;
        int r103 = 0;
        if (r129 == null) goto L62;
        r129.setLayoutManager(new SSLinearLayoutManager(getContext(), 0));
    L62:
        RecyclerView r130 = this.f101158l;
        if (r130 == null) goto L65;
        r130.setItemViewCacheSize(8);
    L65:
        SoloKtvEditTuningEffectAdapter r131 = this.f101159m;
        if (r131 == null) goto L68;
        r131.f101771b = new SoloKtvEditFragment$initView$8(this);
    L68:
        RecyclerView r132 = this.f101158l;
        if (r132 == null) goto L71;
        r132.setAdapter(this.f101159m);
    L71:
        View r133 = r110.findViewById(R.id.save_draft_btn);
        if (r133 == null) goto L74;
        r133.setOnClickListener(new y(this));
    L74:
        View r134 = r110.findViewById(R.id.publish_btn);
        if (r134 == null) goto L77;
        r134.setOnClickListener(new r(this));
    L77:
        SoloKtvEditViewModel r135 = this.f101160n;
        if (r135 == null) goto L82;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r136 = r135.getUIState();
        if (r136 == null) goto L82;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r136, this, SoloKtvEditFragment$initViewModel$1.INSTANCE, new b0(this));
    L82:
        SoloKtvEditViewModel r137 = this.f101160n;
        if (r137 == null) goto L87;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r138 = r137.getUIState();
        if (r138 == null) goto L87;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r138, this, SoloKtvEditFragment$initViewModel$3.INSTANCE, new c0(this));
    L87:
        SoloKtvEditViewModel r139 = this.f101160n;
        if (r139 == null) goto L92;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r140 = r139.getUIState();
        if (r140 == null) goto L92;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r140, this, SoloKtvEditFragment$initViewModel$5.INSTANCE, new d0(this));
    L92:
        SoloKtvEditViewModel r141 = this.f101160n;
        if (r141 == null) goto L97;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r142 = r141.getUIState();
        if (r142 == null) goto L97;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r142, this, SoloKtvEditFragment$initViewModel$7.INSTANCE, new e0(this));
    L97:
        SoloKtvEditViewModel r143 = this.f101160n;
        if (r143 == null) goto L102;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r144 = r143.getUIState();
        if (r144 == null) goto L102;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r144, this, SoloKtvEditFragment$initViewModel$9.INSTANCE, new z(this));
    L102:
        SoloKtvEditViewModel r145 = this.f101160n;
        if (r145 == null) goto L107;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r146 = r145.getUIState();
        if (r146 == null) goto L107;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r146, this, SoloKtvEditFragment$initViewModel$11.INSTANCE, new a0(this));
    L107:
        cb1.a r147 = cb1.a.f22994a;
        long r104 = this.f101162p;
        String r105 = this.f101163q;
        String r106 = this.f101164r;
        SoloKtvEditViewModel r148 = this.f101160n;
        if (r148 == null) goto L114;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r149 = r148.getUIState();
        if (r149 == null) goto L114;
        com.bytedance.android.live.soloktv.viewmodel.g r150 = r149.getValue();
        if (r150 == null) goto L114;
        int r107 = r150.f101908a;
    L115:
        SoloKtvEditViewModel r151 = this.f101160n;
        if (r151 == null) goto L122;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r152 = r151.getUIState();
        if (r152 == null) goto L122;
        com.bytedance.android.live.soloktv.viewmodel.g r153 = r152.getValue();
        if (r153 == null) goto L122;
        int r108 = r153.f101909b;
    L123:
        SoloKtvEditViewModel r154 = this.f101160n;
        if (r154 == null) goto L130;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r155 = r154.getUIState();
        if (r155 == null) goto L130;
        com.bytedance.android.live.soloktv.viewmodel.g r156 = r155.getValue();
        if (r156 == null) goto L130;
        r103 = r156.f101910c;
    L130:
        cb1.a.V(r104, r105, r106, "video_edit_page", r107, r108, null, Integer.valueOf(r103), 64);
        return;
    L122:
        r108 = 50;
    L114:
        r107 = 50;
    L27:
        r118 = "";
    L20:
        r115 = "";
    L15:
        r102 = "";
        goto L16
    L10:
        r100 = 0;
    L7:
        r114 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.solo_ktv_fragment_edit_layout, r101, false);
    }
}
