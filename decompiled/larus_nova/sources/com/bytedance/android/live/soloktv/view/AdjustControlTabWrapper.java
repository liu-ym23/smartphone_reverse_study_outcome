package com.bytedance.android.live.soloktv.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.activity.SoloKtvTemplateActivity;
import com.bytedance.android.live.soloktv.fragment.SoloKtvEditFragment;
import com.bytedance.android.live.soloktv.viewmodel.SoloKtvEditViewModel;
import com.bytedance.android.live.soloktv.viewmodel.SoloTemplateViewModel;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class AdjustControlTabWrapper extends com.bytedance.android.live.soloktv.view.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f101649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f101650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SoloKtvAlignVoiceView f101651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SeekBarWithProgress f101652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SeekBarWithProgress f101653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f101654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f101655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f101656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f101657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SoloKtvEditTuningEffectAdapter f101658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.model.bean.h f101659p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SoloKtvEditViewModel f101660q;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustControlTabWrapper f101661a;

        public a(AdjustControlTabWrapper r100) {
            this.f101661a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f101661a.f101649f;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            com.bytedance.android.live.soloktv.util.k.a r101 = com.bytedance.android.live.soloktv.util.k.f101616b;     // Catch: Throwable -> L6
            ViewGroup r102 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L6
            int r103 = SoloKtvEditFragment.f101149u;     // Catch: Throwable -> L6
            r101.getClass();     // Catch: Throwable -> L6
            com.bytedance.android.live.soloktv.util.k.a.a(r100, r102);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustControlTabWrapper f101662a;

        public b(AdjustControlTabWrapper r100) {
            this.f101662a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f101662a.f101650g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            com.bytedance.android.live.soloktv.util.k.a r101 = com.bytedance.android.live.soloktv.util.k.f101616b;     // Catch: Throwable -> L6
            ViewGroup r102 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L6
            int r103 = SoloKtvEditFragment.f101149u;     // Catch: Throwable -> L6
            r101.getClass();     // Catch: Throwable -> L6
            com.bytedance.android.live.soloktv.util.k.a.a(r100, r102);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustControlTabWrapper f101663a;

        public c(AdjustControlTabWrapper r100) {
            this.f101663a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SoloKtvEditViewModel r101 = this.f101663a.f101660q;
            if (r101 == null) goto L6;
            r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.e.f101886a);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustControlTabWrapper f101664a;

        public d(AdjustControlTabWrapper r100) {
            this.f101664a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SoloKtvEditViewModel r101 = this.f101664a.f101660q;
            if (r101 == null) goto L6;
            r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.c.f101885a);
            return;
        }
    }

    public static final class e implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustControlTabWrapper f101665a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
        }

        public e(AdjustControlTabWrapper r100) {
            this.f101665a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L7;
            SoloKtvEditViewModel r103 = this.f101665a.f101660q;
            if (r103 == null) goto L8;
            r103.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.q(r101));
            return;
        L8:
            return;
        }
    }

    public static final class f implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustControlTabWrapper f101666a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
        }

        public f(AdjustControlTabWrapper r100) {
            this.f101666a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L7;
            SoloKtvEditViewModel r103 = this.f101666a.f101660q;
            if (r103 == null) goto L8;
            r103.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.o(r101));
            return;
        L8:
            return;
        }
    }

    @Override // com.bytedance.android.live.soloktv.view.a
    public final int b() {
        return R.layout.ttliive_solo_adjust_template_container;
    }

    @Override // com.bytedance.android.live.soloktv.view.a
    public final void c() {
        ViewGroup r100 = a();
        this.f101649f = r100.findViewById(R.id.voice_delay_btn);
        this.f101650g = r100.findViewById(R.id.voice_advance_btn);
        View r101 = this.f101649f;
        if (r101 == null) goto L5;
        KtvUtilsKt.a(r101, s1.f(13.0f));
    L5:
        View r102 = this.f101650g;
        if (r102 == null) goto L8;
        KtvUtilsKt.a(r102, s1.f(13.0f));
    L8:
        View r103 = this.f101649f;
        if (r103 == null) goto L11;
        r103.post(new a(this));
    L11:
        View r104 = this.f101650g;
        if (r104 == null) goto L14;
        r104.post(new b(this));
    L14:
        View r105 = this.f101649f;
        if (r105 == null) goto L17;
        r105.setOnClickListener(new c(this));
    L17:
        View r106 = this.f101650g;
        if (r106 == null) goto L20;
        r106.setOnClickListener(new d(this));
    L20:
        this.f101654k = (TextView) r100.findViewById(R.id.tv_voice_align_desc);
        SoloKtvAlignVoiceView r107 = (SoloKtvAlignVoiceView) r100.findViewById(R.id.voice_align_seek_bar);
        this.f101651h = r107;
        if (r107 == null) goto L23;
        r107.setAlignChangedCallback(new AdjustControlTabWrapper$initView$5(this));
    L23:
        SeekBarWithProgress r108 = (SeekBarWithProgress) r100.findViewById(R.id.voice_volume_seek_bar);
        this.f101652i = r108;
        if (r108 == null) goto L26;
        r108.setProgressBarDrawable(s1.m(R.drawable.solo_ktv_edit_seek_bar_bg));
    L26:
        SeekBarWithProgress r109 = this.f101652i;
        if (r109 == null) goto L29;
        r109.setOnSeekBarChangeListener(new e(this));
    L29:
        SeekBarWithProgress r110 = (SeekBarWithProgress) r100.findViewById(R.id.music_volume_seek_bar);
        this.f101653j = r110;
        if (r110 == null) goto L32;
        r110.setProgressBarDrawable(s1.m(R.drawable.solo_ktv_edit_seek_bar_bg));
    L32:
        SeekBarWithProgress r111 = this.f101653j;
        if (r111 == null) goto L35;
        r111.setOnSeekBarChangeListener(new f(this));
    L35:
        this.f101657n = (RecyclerView) r100.findViewById(R.id.tuning_effect_list);
        this.f101656m = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.loading_tuning_effect_view);
        this.f101655l = (FrameLayout) r100.findViewById(R.id.loading_tuning_effect_view_container);
        this.f101658o = new SoloKtvEditTuningEffectAdapter();
        RecyclerView r112 = this.f101657n;
        if (r112 == null) goto L38;
        r112.setLayoutManager(new SSLinearLayoutManager(a().getContext(), 0));
    L38:
        RecyclerView r113 = this.f101657n;
        if (r113 == null) goto L41;
        int r114 = SoloKtvEditFragment.f101149u;
        r113.setItemViewCacheSize(8);
    L41:
        SoloKtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<MusicPanel> r115 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r115 == null) goto L46;
        MusicPanel r116 = r115.getValue();
        if (r116 == null) goto L46;
        KtvMusic r117 = r116.f153577a;
    L47:
        if (r117 == null) goto L49;
        long r118 = r117.getMId();
    L50:
        final long r119 = r118;
        if (r117 == null) goto L56;
        String r120 = r117.getMTitle();
        if (r120 == null) goto L56;
        final String r121 = r120;
    L57:
        String r122 = SoloKtvContext.a.a().getFromSource();
        if (r122 != null) goto L60;
        final String r123 = "";
    L61:
        if (r117 == null) goto L66;
        String r124 = r117.getMAuthor();
        if (r124 == null) goto L66;
        final String r125 = r124;
    L67:
        com.bytedance.live.datacontext.n<MusicPanel> r126 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r126 == null) goto L75;
        MusicPanel r127 = r126.getValue();
        if (r127 == null) goto L75;
        String r128 = r127.f153580d;
        if (r128 == null) goto L75;
        final String r129 = r128;
    L76:
        SoloKtvEditTuningEffectAdapter r130 = this.f101658o;
        if (r130 == null) goto L79;
        r130.f101771b = new AdjustControlTabWrapper$initView$8(this, r119, r121, r125, r129, r123);
    L79:
        RecyclerView r131 = this.f101657n;
        if (r131 == null) goto L83;
        r131.setAdapter(this.f101658o);
        return;
    L83:
        return;
    L75:
        r129 = "";
    L66:
        r125 = "";
        goto L67
    L60:
        r123 = r122;
    L56:
        r121 = "";
        goto L57
    L49:
        r118 = 0;
    L46:
        r117 = null;
        goto L47
    }

    public final void e(com.bytedance.android.live.ktv.common.model.bean.h r100, Boolean r101) {
        if (r100 == null) goto L20;
        SoloKtvEditTuningEffectAdapter r102 = this.f101658o;
        if (r102 == null) goto L6;
        int r103 = r102.y2(r100);
    L7:
        if (r103 >= 0) goto L9;
        return;
    L9:
        if (r100.f69999a == false) goto L16;
        if (r103 <= 0) goto L12;
    L13:
        RecyclerView r104 = this.f101657n;
        if (r104 == null) goto L16;
        r104.smoothScrollToPosition(r103);
        goto L16
    L12:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L13;
    L16:
        SoloKtvEditTuningEffectAdapter r105 = this.f101658o;
        if (r105 == null) goto L22;
        r105.notifyItemRangeChanged(r103, 1);
        return;
    L22:
        return;
    L6:
        r103 = -1;
        goto L7
    }

    public AdjustControlTabWrapper(SoloKtvEditViewModel r100, SoloKtvTemplateActivity r101, ViewGroup r102, SoloTemplateViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, TTVideoEngineInterface.PLAY_API_KEY_AC);
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r103, "vm");
        super(r101, r102, r103);
        this.f101660q = r100;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r100.getUIState(), this.f101822c, AdjustControlTabWrapper$initEditViewModel$1.INSTANCE, new com.bytedance.android.live.soloktv.view.d(this));
        com.bytedance.android.livesdk.ktvapi.util.d.a(r100.getUIState(), this.f101822c, AdjustControlTabWrapper$initEditViewModel$3.INSTANCE, new com.bytedance.android.live.soloktv.view.e(this));
        com.bytedance.android.livesdk.ktvapi.util.d.a(r100.getUIState(), this.f101822c, AdjustControlTabWrapper$initEditViewModel$5.INSTANCE, new com.bytedance.android.live.soloktv.view.f(this));
        com.bytedance.android.livesdk.ktvapi.util.d.a(r100.getUIState(), this.f101822c, AdjustControlTabWrapper$initEditViewModel$7.INSTANCE, new g(this));
        com.bytedance.android.livesdk.ktvapi.util.d.a(r100.getUIState(), this.f101822c, AdjustControlTabWrapper$initEditViewModel$9.INSTANCE, new com.bytedance.android.live.soloktv.view.b(this));
        com.bytedance.android.livesdk.ktvapi.util.d.a(r100.getUIState(), this.f101822c, AdjustControlTabWrapper$initEditViewModel$11.INSTANCE, new com.bytedance.android.live.soloktv.view.c(this));
    }
}
