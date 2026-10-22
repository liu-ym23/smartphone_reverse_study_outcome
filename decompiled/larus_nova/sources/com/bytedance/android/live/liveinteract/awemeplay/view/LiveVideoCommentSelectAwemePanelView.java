package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectAwemePanelViewModel;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import gd0.q;
import gd0.r;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectAwemePanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lgd0/q;", "Landroid/view/View$OnClickListener;", "", "getCurrentTabType", "Lgd0/r;", "callback", "", "setCallback", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectAwemePanelView extends ConstraintLayout implements q, View.OnClickListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f71543w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveVideoCommentSelectAwemePanelViewModel f71544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<VideoTab> f71545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TabLayout f71546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabLayout f71547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f71548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f71549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f71550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f71551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f71552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f71553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f71554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Fragment f71555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r f71556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f71557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f71558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f71559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CompositeDisposable f71560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x0 f71561r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f71562s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f71563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f71564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f71565v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoCommentSelectAwemePanelView f71566a;

        public b(LiveVideoCommentSelectAwemePanelView r100) {
            this.f71566a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            k42.d r101 = (k42.d) r100;
            r r102 = this.f71566a.f71556m;
            if (r102 == null) goto L6;
            r102.c();
            return;
        }
    }

    static {
    }

    private final int getCurrentTabType() {
        List<VideoTab> r100 = this.f71545b;
        if (r100 == null) goto L16;
        ViewPager r101 = this.f71549f;
        if (r101 == null) goto L7;
        int r102 = r101.getCurrentItem();
    L8:
        if (r102 >= 0) goto L10;
    L12:
        Integer r103 = 0;
    L13:
        if (r103 != null) goto L15;
        return 0;
    L15:
        return r103.intValue();
    L10:
        if (r102 >= r100.size()) goto L12;
        r103 = ((VideoTab) ListProtector.get(r100, r102)).getType();
        goto L13
    L7:
        r102 = 0;
        goto L8
    L16:
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Disposable r100 = xs2.b.a().b(k42.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.f71560q.add(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f71560q.dispose();
    }

    public static final /* synthetic */ int R5(LiveVideoCommentSelectAwemePanelView r100) {
        return r100.getCurrentTabType();
    }

    public static void T5(String r100) {
        m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L8;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L8;
        String r103 = r102.getOwnerUserIdString();
        if (r103 == null) goto L8;
    L9:
        m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L14;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L14;
        long r106 = r105.getRoomId();
    L15:
        Map<Integer, String> r107 = td0.b.f545501a;
        Intrinsics.checkNotNullParameter(r103, "anchorId");
        Intrinsics.checkNotNullParameter(r100, "action");
        LinkedHashMap r108 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r108);
        r108.put("anchor_id", r103);
        r108.put("room_id", String.valueOf(r106));
        td0.b.b(r108);
        TalkRoomLogUtils.B0(r108, null, null, 6);
        r108.put("action_type", r100);
        j0.l().sendLog("livesdk_video_comment_search_entry", r108, new Object[0]);
        return;
    L14:
        r106 = 0;
    L8:
        r103 = "";
        goto L9
    }

    public final void S5(int r100) {
        List<VideoTab> r101 = this.f71545b;
        if (r101 == null) goto L21;
        boolean r102 = true;
        if ((!r101.isEmpty()) == false) goto L10;
        if (r100 < 0) goto L10;
        if (r100 >= r101.size()) goto L10;
    L11:
        if (r102 == true) goto L14;
        r101 = null;
    L14:
        if (r101 == null) goto L22;
        LiveVideoCommentSelectAwemePanelViewModel r103 = this.f71544a;
        if (r103 == null) goto L23;
        LiveData r104 = r103.getSelectPageTab();
        if (r104 == null) goto L24;
        r104.setValue(ListProtector.get(r101, r100));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r102 = false;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        sd0.a r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.getId());
    L6:
        if (r102 != null) goto L9;
    L13:
        if (r102 == null) goto L30;
        if (r102.intValue() != R.id.switch_or_send_btn) goto L30;
        LiveVideoCommentSelectAwemePanelViewModel r103 = this.f71544a;
        if (r103 == null) goto L22;
        MutableLiveData<sd0.a> r104 = r103.getSelectedAwemeVideo();
        if (r104 == null) goto L22;
        r101 = r104.getValue();
    L22:
        if (r101 == null) goto L26;
        LiveVideoCommentSelectAwemePanelViewModel r105 = this.f71544a;
        if (r105 == null) goto L49;
        r105.doAction(new ud0.c.b(r101, getCurrentTabType()));
        return;
    L49:
        return;
    L26:
        r r106 = this.f71556m;
        if (r106 == null) goto L51;
        r106.d();
        return;
    L51:
        return;
    L30:
        if (r102 != null) goto L33;
    L38:
        if (r102 != null) goto L41;
        return;
    L41:
        if (r102.intValue() != R.id.search_video_btn) goto L54;
        r r107 = this.f71556m;
        if (r107 == null) goto L45;
        r107.b();
    L45:
        T5("click");
        return;
    L54:
        return;
    L33:
        if (r102.intValue() != R.id.search_video_btn2) goto L38;
        r r108 = this.f71556m;
        if (r108 == null) goto L37;
        r108.b();
    L37:
        T5("click");
        return;
    L9:
        if (r102.intValue() != R.id.ttlive_video_comment_panel_reloading_btn) goto L13;
        LiveVideoCommentSelectAwemePanelViewModel r109 = this.f71544a;
        if (r109 == null) goto L47;
        r109.doAction(ud0.c.a.f549712a);
        return;
    L47:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // gd0.q
    public void setCallback(r r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f71556m = r100;
    }

    public LiveVideoCommentSelectAwemePanelView(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        this.f71565v = r101;
        this.f71560q = new CompositeDisposable();
        boolean r102 = true;
        this.f71564u = true;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_aweme_share_select_layout, this);
        setBackgroundResource(R.color.white);
        if (r101 == false) goto L5;
    L8:
        this.f71564u = r102;
        this.f71559p = findViewById(R.id.top_bar_bg);
        if (r101 == false) goto L14;
        this.f71546c = (TabLayout) findViewById(R.id.ttlive_video_comment_panel_tab2);
        this.f71547d = (TabLayout) findViewById(R.id.ttlive_video_comment_panel_tab);
        View r103 = this.f71559p;
        if (r103 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r103);
    L13:
        this.f71557n = (LinearLayout) findViewById(R.id.search_video_btn2);
        this.f71558o = (LinearLayout) findViewById(R.id.search_video_btn);
    L15:
        TabLayout r104 = this.f71547d;
        if (r104 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r104);
    L18:
        LinearLayout r105 = this.f71558o;
        if (r105 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r105);
    L21:
        TabLayout r106 = this.f71546c;
        if (r106 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r106);
    L24:
        LinearLayout r107 = this.f71557n;
        if (r107 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r107);
    L27:
        ViewPager r108 = (ViewPager) findViewById(R.id.ttlive_video_comment_panel_viewpager);
        this.f71549f = r108;
        if (r108 == null) goto L30;
        r108.setOffscreenPageLimit(4);
    L30:
        this.f71550g = findViewById(R.id.ttlive_video_comment_panel_loading_container);
        this.f71553j = (LiveDoubleColorBallAnimationView) findViewById(R.id.ttlive_video_comment_panel_loading_animation_view);
        this.f71551h = findViewById(R.id.ttlive_video_comment_panel_reloading_btn_container);
        this.f71552i = (TextView) findViewById(R.id.ttlive_video_comment_panel_reloading_btn);
        this.f71554k = (ImageView) findViewById(R.id.switch_or_send_btn);
        this.f71548e = (TextView) findViewById(R.id.top_tips_textview);
        TextView r109 = this.f71552i;
        if (r109 == null) goto L33;
        r109.setOnClickListener(this);
    L33:
        ViewPager r110 = this.f71549f;
        if (r110 == null) goto L36;
        r110.addOnPageChangeListener(new LiveVideoCommentSelectAwemePanelView$initView$1(this));
    L36:
        if (r101 == false) goto L43;
        ImageView r111 = this.f71554k;
        if (r111 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r111);
    L40:
        ImageView r112 = this.f71554k;
        if (r112 == null) goto L54;
        r112.setOnClickListener(null);
        return;
    L54:
        return;
    L43:
        if (r102 == false) goto L50;
        ImageView r113 = this.f71554k;
        if (r113 == null) goto L47;
        r113.setBackgroundResource(R.drawable.ttlive_video_comment_panel_key_board_ic);
    L47:
        ImageView r114 = this.f71554k;
        if (r114 == null) goto L56;
        r114.setOnClickListener(new c(this));
        return;
    L56:
        return;
    L50:
        ImageView r115 = this.f71554k;
        if (r115 == null) goto L58;
        r115.setOnClickListener(this);
        return;
    L58:
        return;
    L14:
        this.f71546c = (TabLayout) findViewById(R.id.ttlive_video_comment_panel_tab);
        this.f71547d = (TabLayout) findViewById(R.id.ttlive_video_comment_panel_tab2);
        this.f71557n = (LinearLayout) findViewById(R.id.search_video_btn);
        this.f71558o = (LinearLayout) findViewById(R.id.search_video_btn2);
        goto L15
    L5:
        if (((Boolean) vm2.d.f555963s6.getValue(null, vm2.d.f555776a[380(0x17c, float:5.32E-43)])).booleanValue() == true) goto L8;
        r102 = false;
        goto L8
    }
}
