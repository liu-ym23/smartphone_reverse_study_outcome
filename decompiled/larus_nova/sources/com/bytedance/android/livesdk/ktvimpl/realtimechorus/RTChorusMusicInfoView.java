package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.livesdkapi.depend.message.BackgroundMaterial;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RTChorusMusicInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lpy/k;", "getMusicInfoBgModel", "", "getCurShowMode", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTChorusMusicInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MidiSkinDressInfo f146224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f146225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f146226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f146227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f146228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintLayout f146229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f146230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f146231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConstraintLayout f146232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f146233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f146234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f146235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f146236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f146237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c f146238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final NextLiveData<Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a>> f146239p;

    public static final class a {
    }

    public static final class b implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RTChorusMusicInfoView f146241b;

        public b(ConstraintLayout r100, RTChorusMusicInfoView r101) {
            this.f146240a = r100;
            this.f146241b = r101;
        }

        @Override // fd0.b
        public final void onStop() {
            UtilityKotlinExtentionsKt.w(this.f146240a);
            RTChorusMusicInfoView r100 = this.f146241b;
            if (r100.getVisibility() == 0) goto L6;
            UtilityKotlinExtentionsKt.w(r100);
            return;
        }
    }

    public static final class c implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RTChorusMusicInfoView f146243b;

        public c(ConstraintLayout r100, RTChorusMusicInfoView r101) {
            this.f146242a = r100;
            this.f146243b = r101;
        }

        @Override // fd0.b
        public final void onStop() {
            UtilityKotlinExtentionsKt.w(this.f146242a);
            RTChorusMusicInfoView r100 = this.f146243b;
            if (r100.getVisibility() == 0) goto L6;
            UtilityKotlinExtentionsKt.w(r100);
            return;
        }
    }

    public static final class d implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RTChorusMusicInfoView f146245b;

        public d(ConstraintLayout r100, RTChorusMusicInfoView r101) {
            this.f146244a = r100;
            this.f146245b = r101;
        }

        @Override // fd0.b
        public final void onStop() {
            UtilityKotlinExtentionsKt.w(this.f146244a);
            RTChorusMusicInfoView r100 = this.f146245b;
            if (r100.getVisibility() == 0) goto L6;
            UtilityKotlinExtentionsKt.w(r100);
            return;
        }
    }

    public static final class e implements fd0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146246a;

        public e(ConstraintLayout r100) {
            this.f146246a = r100;
        }

        @Override // fd0.a
        public final void onStart() {
            UtilityKotlinExtentionsKt.w(this.f146246a);
            this.f146246a.setAlpha(0.0f);
        }
    }

    public static final class f implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146248b;

        public f(ConstraintLayout r100, ConstraintLayout r101) {
            this.f146247a = r100;
            this.f146248b = r101;
        }

        @Override // fd0.b
        public final void onStop() {
            UtilityKotlinExtentionsKt.t(this.f146247a);
            UtilityKotlinExtentionsKt.t(this.f146248b);
        }
    }

    public static final class g implements fd0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146249a;

        public g(ConstraintLayout r100) {
            this.f146249a = r100;
        }

        @Override // fd0.a
        public final void onStart() {
            UtilityKotlinExtentionsKt.w(this.f146249a);
            this.f146249a.setAlpha(0.0f);
        }
    }

    public static final class h implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146251b;

        public h(ConstraintLayout r100, ConstraintLayout r101) {
            this.f146250a = r100;
            this.f146251b = r101;
        }

        @Override // fd0.b
        public final void onStop() {
            UtilityKotlinExtentionsKt.t(this.f146250a);
            UtilityKotlinExtentionsKt.t(this.f146251b);
        }
    }

    public static final class i implements fd0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146252a;

        public i(ConstraintLayout r100) {
            this.f146252a = r100;
        }

        @Override // fd0.a
        public final void onStart() {
            UtilityKotlinExtentionsKt.w(this.f146252a);
            this.f146252a.setAlpha(0.0f);
        }
    }

    public static final class j implements fd0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f146254b;

        public j(ConstraintLayout r100, ConstraintLayout r101) {
            this.f146253a = r100;
            this.f146254b = r101;
        }

        @Override // fd0.b
        public final void onStop() {
            UtilityKotlinExtentionsKt.t(this.f146253a);
            UtilityKotlinExtentionsKt.t(this.f146254b);
        }
    }

    static {
    }

    public RTChorusMusicInfoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RTChorusMusicInfoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final py.k getMusicInfoBgModel() {
        MidiSkinDressInfo r100 = this.f146224a;
        if (r100 == null) goto L5;
        String r101 = r100.getDressId();
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        MidiSkinDressInfo r102 = this.f146224a;
        if (r102 == null) goto L11;
        String r103 = r102.getDressId();
    L12:
        boolean r104 = true;
        if ((!Intrinsics.areEqual(r103, "0")) == false) goto L15;
    L16:
        if (r104 == false) goto L24;
        MidiSkinDressInfo r105 = this.f146224a;
        if (r105 == null) goto L26;
        MidiSkinMaterial r106 = r105.getMaterial();
        if (r106 == null) goto L27;
        BackgroundMaterial r107 = r106.getBg();
        if (r107 != null) goto L29;
        return null;
    L29:
        return r107.getSongTitleBgImage();
    L27:
        return null;
    L26:
        return null;
    L24:
        int r108 = qy.a.f535172a;
        return qy.a.a(com.bytedance.android.live.ktv.common.midi.j.f69857d);
    L11:
        r103 = null;
    L15:
        r104 = false;
        goto L16
    L5:
        r101 = null;
        goto L7
    }

    public final void R5() {
        Disposable r100 = this.f146236m;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        r100.dispose();
        return;
    }

    public final int getCurShowMode() {
        return this.f146235l;
    }

    public final void S5(int r110) {
        if (this.f146235l != r110) goto L5;
        return;
    L5:
        ALogger.i("RTChorusMusicInfoView", "switchMode " + r110);
        this.f146235l = r110;
        if (r110 == 0) goto L31;
        if (r110 == 1) goto L25;
        if (r110 != 2) goto L10;
        ConstraintLayout r111 = this.f146232i;
        ConstraintLayout r100 = this.f146226c;
        ConstraintLayout r101 = this.f146229f;
        if (r111 == null) goto L38;
        if (r100 == null) goto L39;
        if (r101 == null) goto L40;
        fd0.f r102 = LiveAnimator.a(new View[]{r100});
        r102.a();
        LiveAnimator r103 = r102.f476453a;
        r103.f71418b = 200;
        r103.f71424h = new i(r100);
        r103.f71425i = new d(r100, this);
        r102.e();
        fd0.f r104 = LiveAnimator.a(new View[]{r111, r101});
        r104.b();
        LiveAnimator r105 = r104.f476453a;
        r105.f71418b = 200;
        r105.f71425i = new j(r111, r101);
        r104.e();
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L10:
        if (r110 != 3) goto L46;
        ConstraintLayout r112 = this.f146232i;
        ConstraintLayout r106 = this.f146226c;
        ConstraintLayout r107 = this.f146229f;
        if (r112 == null) goto L19;
        if (r106 == null) goto L19;
        if (r107 == null) goto L19;
        r112.clearAnimation();
        r106.clearAnimation();
        r107.clearAnimation();
        if (getVisibility() == 4) goto L19;
        UtilityKotlinExtentionsKt.u(this);
    L19:
        R5();
        return;
    L46:
        return;
    L25:
        ConstraintLayout r113 = this.f146232i;
        ConstraintLayout r108 = this.f146226c;
        ConstraintLayout r109 = this.f146229f;
        if (r113 == null) goto L30;
        if (r108 == null) goto L30;
        if (r109 == null) goto L30;
        fd0.f r114 = LiveAnimator.a(new View[]{r109});
        r114.a();
        LiveAnimator r115 = r114.f476453a;
        r115.f71418b = 200;
        r115.f71424h = new g(r109);
        r115.f71425i = new c(r109, this);
        r114.e();
        fd0.f r116 = LiveAnimator.a(new View[]{r113, r108});
        r116.b();
        LiveAnimator r117 = r116.f476453a;
        r117.f71418b = 200;
        r117.f71425i = new h(r113, r108);
        r116.e();
    L30:
        R5();
        return;
    L31:
        ConstraintLayout r118 = this.f146232i;
        ConstraintLayout r119 = this.f146226c;
        ConstraintLayout r120 = this.f146229f;
        if (r118 == null) goto L43;
        if (r119 == null) goto L44;
        if (r120 == null) goto L45;
        fd0.f r121 = LiveAnimator.a(new View[]{r118});
        r121.a();
        LiveAnimator r122 = r121.f476453a;
        r122.f71418b = 200;
        r122.f71424h = new e(r118);
        r122.f71425i = new b(r118, this);
        r121.e();
        fd0.f r123 = LiveAnimator.a(new View[]{r119, r120});
        r123.b();
        LiveAnimator r124 = r123.f476453a;
        r124.f71418b = 200;
        r124.f71425i = new f(r119, r120);
        r123.e();
        return;
    L45:
        return;
    L44:
        return;
    }

    public final void T5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "musicTitle");
        TextView r101 = this.f146230g;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        TextView r102 = this.f146227d;
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    }

    public final void U5(long r100) {
        if (r100 < 1000) goto L17;
        long r101 = 999;
        long r102 = -999;
        long r103 = this.f146234k - r100;
        if (r102 <= r103) goto L8;
    L10:
        this.f146234k = r100;
        String r104 = new SimpleDateFormat("mm:ss", Locale.US).format(Long.valueOf(r100));
        TextView r105 = this.f146228e;
        if (r105 == null) goto L13;
        r105.setText(r104);
    L13:
        TextView r106 = this.f146231h;
        if (r106 == null) goto L18;
        r106.setText(r104);
        return;
    L18:
        return;
    L8:
        if (r101 < r103) goto L10;
        return;
    }

    public final void y(MidiSkinDressInfo r100) {
        this.f146224a = r100;
        com.bytedance.android.livesdk.chatroom.utils.a1.o(this.f146225b, getMusicInfoBgModel(), ImageView.ScaleType.FIT_XY);
    }

    public RTChorusMusicInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f146234k = Long.MAX_VALUE;
        this.f146235l = -1;
        this.f146237n = new CompositeDisposable();
        this.f146239p = new NextLiveData();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_rt_chorus_music_info_layout, this);
        this.f146226c = (ConstraintLayout) findViewById(R.id.guest_music_info_cl);
        HSImageView r103 = (HSImageView) findViewById(R.id.music_info_bg);
        this.f146225b = r103;
        com.bytedance.android.livesdk.chatroom.utils.a1.o(r103, getMusicInfoBgModel(), ImageView.ScaleType.FIT_XY);
        ImageView r104 = (ImageView) findViewById(R.id.guest_singing_icon);
        this.f146227d = (TextView) findViewById(R.id.guest_music_name);
        this.f146228e = (TextView) findViewById(R.id.guest_music_time);
        this.f146229f = (ConstraintLayout) findViewById(R.id.audience_music_info_cl);
        ImageView r105 = (ImageView) findViewById(R.id.audience_singing_icon);
        TextView r106 = (TextView) findViewById(R.id.audience_music_name);
        this.f146230g = r106;
        if (r106 == null) goto L5;
        r106.setMaxWidth(s1.t() - s1.f(170.0f));
    L5:
        this.f146231h = (TextView) findViewById(R.id.audience_music_time);
        this.f146232i = (ConstraintLayout) findViewById(R.id.non_sing_cl);
        this.f146233j = (TextView) findViewById(R.id.non_sing_tv);
        S5(0);
    }

    public /* synthetic */ RTChorusMusicInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
