package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinderV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureSearchFragmentV3;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureSearchFragmentV3 extends BaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f61554s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f61555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f61556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f61557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f61558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f61559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f61560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f61561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f61562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EditText f61563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AbsOpenFeaturePanelViewModel f61564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f61565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f61566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c20.a f61567p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OpenFeatureTabListAdapter f61568q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MultiTypeAdapter f61569r;

    public static final class a implements SearchHistoryViewBinder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTypeAdapter f61570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 f61571b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            LiveOpenFeatureSearchFragmentV3 r101 = this.f61571b;
            EditText r102 = r101.f61563l;
            if (r102 == null) goto L5;
            r102.setText(r100);
        L5:
            EditText r103 = r101.f61563l;
            if (r103 == null) goto L8;
            r103.setSelection(r100.length());
        L8:
            r101.T90();
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "keyWord");
            List<?> r101 = this.f61570a.f513437a;
            if (r101 == null) goto L12;
            TypeIntrinsics.asMutableCollection(r101).remove(r100);
            if (this.f61570a.f513437a.size() >= 1) goto L9;
            TextView r102 = this.f61571b.f61555d;
            if (r102 == null) goto L9;
            UtilityKotlinExtentionsKt.t(r102);
        L9:
            this.f61570a.notifyDataSetChanged();
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }

        public a(MultiTypeAdapter r100, LiveOpenFeatureSearchFragmentV3 r101) {
            this.f61570a = r100;
            this.f61571b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void T90() {
        EditText r100 = this.f61563l;
        List<f10.f> r101 = null;
        if (r100 == null) goto L5;
        Editable r102 = r100.getText();
    L6:
        String r103 = StringsKt.trim(String.valueOf(r102)).toString();
        if (TextUtils.isEmpty(r103) == true) goto L28;
        U90(false);
        TextView r104 = this.f61555d;
        if (r104 == null) goto L11;
        r104.setVisibility(8);
    L11:
        int r105 = com.bytedance.android.live.broadcastgame.opengame.utils.l.f61174a;
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(getContext(), this.f61563l);
        LiveDoubleColorBallAnimationView r106 = this.f61556e;
        if (r106 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r106);
    L14:
        AbsOpenFeaturePanelViewModel r107 = this.f61564m;
        if (r107 == null) goto L22;
        a20.l r108 = r107.getFeatureSearchHandler();
        if (r108 == null) goto L22;
        long r109 = this.f61565n;
        Long r110 = this.f61566o;
        c20.a r111 = this.f61567p;
        if (r111 == null) goto L21;
        r101 = r111.f22120b;
    L21:
        r108.g(r109, r110, r103, r101);
    L22:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r112 = AnchorGameContext.a.a();
        if (r112 == null) goto L29;
        com.bytedance.live.datacontext.m<String> r113 = r112.getSearchWord();
        if (r113 == null) goto L30;
        r113.setValue(r103);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public LiveOpenFeatureSearchFragmentV3() {
        this.f61565n = 2;
        MultiTypeAdapter r100 = new MultiTypeAdapter();
        r100.z2(String.class, new SearchHistoryViewBinderV3(new a(r100, this)));
        Unit r101 = Unit.INSTANCE;
        this.f61569r = r100;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        int r100 = com.bytedance.android.live.broadcastgame.opengame.utils.l.f61174a;
        Context r101 = getContext();
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L11;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L11;
        View r104 = r103.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L12:
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(r101, r104);
        return;
    L11:
        r104 = null;
        goto L12
    }

    public final void U90(boolean r100) {
        if (r100 == false) goto L11;
        RecyclerView r101 = this.f61557f;
        if (r101 == null) goto L8;
        RecyclerView.Adapter r102 = r101.getAdapter();
        if (r102 == null) goto L8;
        r102.notifyDataSetChanged();
    L8:
        RecyclerView r103 = this.f61557f;
        if (r103 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r103);
        return;
    L15:
        return;
    L11:
        RecyclerView r104 = this.f61557f;
        if (r104 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Long r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L9;
        Room r104 = r103.getValue();
        if (r104 == null) goto L9;
        r101 = Long.valueOf(r104.getRoomId());
    L9:
        this.f61566o = r101;
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.f61564m = AbsOpenFeaturePanelViewModel.a.a(true, this);
    }

    public static final void S90(LiveOpenFeatureSearchFragmentV3 r100, List r101) {
        EditText r102 = r100.f61563l;
        if (r102 == null) goto L5;
        Editable r103 = r102.getText();
    L7:
        if (String.valueOf(r103).length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L41;
        if (r101 != null) goto L14;
    L28:
        LinearLayout r105 = r100.f61559h;
        if (r105 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r105);
    L31:
        LiveDoubleColorBallAnimationView r106 = r100.f61556e;
        if (r106 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r106);
    L34:
        RecyclerView r107 = r100.f61558g;
        if (r107 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r107);
        return;
    L40:
        return;
    L14:
        if (r101.isEmpty() == true) goto L28;
        LiveDoubleColorBallAnimationView r108 = r100.f61556e;
        if (r108 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r108);
    L19:
        r100.f61569r.notifyDataSetChanged();
        RecyclerView r109 = r100.f61558g;
        if (r109 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r109);
    L22:
        LinearLayout r110 = r100.f61559h;
        if (r110 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r110);
    L25:
        OpenFeatureTabListAdapter r111 = r100.f61568q;
        if (r111 == null) goto L38;
        r111.setData(r101);
        return;
    L38:
        return;
    L41:
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        this.f61555d = (TextView) r100.findViewById(R.id.clear_all_histories);
        this.f61556e = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.loading_view);
        this.f61557f = (RecyclerView) r100.findViewById(R.id.recycler_search_history);
        this.f61558g = (RecyclerView) r100.findViewById(R.id.recycler_search_result);
        this.f61559h = (LinearLayout) r100.findViewById(R.id.search_empty);
        this.f61560i = (HSImageView) r100.findViewById(R.id.search_result_empty);
        this.f61561j = (TextView) r100.findViewById(R.id.cancel_search);
        this.f61562k = (ImageView) r100.findViewById(R.id.clear_search_input);
        this.f61563l = (EditText) r100.findViewById(R.id.search_edit);
        AbsOpenFeaturePanelViewModel r101 = this.f61564m;
        ViewGroup.LayoutParams r111 = null;
        if (r101 == null) goto L5;
        a20.d r102 = r101.getFeatureIconBehaviorController();
    L7:
        if ((r102 instanceof a20.e) == true) goto L9;
        r102 = null;
    L9:
        ArrayList r103 = new ArrayList();
        r103.add(new g20.c(r102, OpenFeatureIconCallbackFrom.TAB_LIST));
        r103.add(new g20.e(r102, OpenFeatureIconCallbackFrom.SEARCH, LiveOpenFeatureSearchFragmentV3$initAdapter$1.INSTANCE));
        this.f61568q = new OpenFeatureTabListAdapter(CollectionsKt.emptyList(), r103, null);
        MultiTypeAdapter r104 = this.f61569r;
        AbsOpenFeaturePanelViewModel r105 = this.f61564m;
        if (r105 == null) goto L16;
        a20.l r106 = r105.getFeatureSearchHandler();
        if (r106 == null) goto L16;
        List<?> r107 = r106.a();
        if (r107 == null) goto L16;
    L17:
        r104.f513437a = r107;
        AbsOpenFeaturePanelViewModel r108 = this.f61564m;
        if (r108 == null) goto L22;
        LiveData<List<f10.f>> r109 = r108.getOpenFeatureSearchResult();
        if (r109 == null) goto L22;
        r109.observe(this, new n(this));
    L22:
        int r112 = 0;
        if (ft0.f120230a.getValue().f() == false) goto L49;
        AbsOpenFeaturePanelViewModel r113 = this.f61564m;
        if (r113 == null) goto L43;
        LiveData<c20.c> r114 = r113.getOpenFeatureTabListData();
        if (r114 == null) goto L43;
        c20.c r115 = r114.getValue();
        if (r115 == null) goto L43;
        List<c20.a> r116 = r115.f22131c;
        if (r116 == null) goto L43;
        Iterator<T> r117 = r116.iterator();
    L34:
        if (r117.hasNext() == false) goto L41;
        Object r118 = r117.next();
        if (((c20.a) r118).f22119a != 6) goto L38;
        boolean r119 = true;
    L39:
        if (r119 == false) goto L34;
    L42:
        c20.a r120 = (c20.a) r118;
    L44:
        this.f61567p = r120;
        AbsOpenFeaturePanelViewModel r121 = this.f61564m;
        if (r121 == null) goto L49;
        LiveData<c20.c> r122 = r121.getOpenFeatureTabListData();
        if (r122 == null) goto L49;
        r122.observe(this, new o(this));
        goto L49
    L38:
        r119 = false;
        goto L39
    L41:
        r118 = null;
    L43:
        r120 = null;
    L49:
        LinearLayout r123 = this.f61559h;
        if (r123 == null) goto L52;
        r123.setVisibility(8);
    L52:
        RecyclerView r124 = this.f61558g;
        if (r124 == null) goto L55;
        r124.setVisibility(8);
    L55:
        LiveDoubleColorBallAnimationView r125 = this.f61556e;
        if (r125 == null) goto L58;
        UtilityKotlinExtentionsKt.t(r125);
    L58:
        LinearLayout r126 = this.f61559h;
        if (r126 == null) goto L61;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
    L63:
        if ((r127 instanceof ConstraintLayout.LayoutParams) == true) goto L65;
        r127 = null;
    L65:
        ConstraintLayout.LayoutParams r128 = (ConstraintLayout.LayoutParams) r127;
        if (r128 == null) goto L68;
        ((ViewGroup.MarginLayoutParams) r128).topMargin = s1.f(114.0f);
    L68:
        HSImageView r129 = this.f61560i;
        if (r129 == null) goto L71;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
    L73:
        if ((r130 instanceof LinearLayout.LayoutParams) == false) goto L76;
        r111 = r130;
    L76:
        LinearLayout.LayoutParams r131 = (LinearLayout.LayoutParams) r111;
        if (r131 == null) goto L79;
        r131.width = s1.f(180.0f);
        r131.height = s1.f(120.0f);
    L79:
        ImageLoader.bindImage(this.f61560i, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/img_empty_search.png");
        TextView r132 = this.f61561j;
        if (r132 == null) goto L82;
        r132.setOnClickListener(new p(this));
    L82:
        TextView r133 = this.f61561j;
        if (r133 == null) goto L85;
        r133.setVisibility(0);
    L85:
        EditText r134 = this.f61563l;
        if (r134 == null) goto L88;
        r134.setImeOptions(3);
    L88:
        EditText r135 = this.f61563l;
        if (r135 == null) goto L91;
        r135.setSingleLine(true);
    L91:
        EditText r136 = this.f61563l;
        if (r136 == null) goto L94;
        r136.setInputType(1);
    L94:
        EditText r137 = this.f61563l;
        if (r137 == null) goto L97;
        r137.setOnEditorActionListener(new q(this));
    L97:
        EditText r138 = this.f61563l;
        if (r138 == null) goto L100;
        r138.addTextChangedListener(new r(this));
    L100:
        EditText r139 = this.f61563l;
        if (r139 == null) goto L103;
        r139.setOnFocusChangeListener(new s(this));
    L103:
        ImageView r140 = this.f61562k;
        if (r140 == null) goto L106;
        r140.setOnClickListener(new t(this));
    L106:
        ImageView r141 = this.f61562k;
        if (r141 == null) goto L109;
        r141.setVisibility(4);
    L109:
        TextView r142 = this.f61555d;
        if (r142 == null) goto L112;
        r142.setOnClickListener(new u(this));
    L112:
        RecyclerView r143 = this.f61557f;
        if (r143 == null) goto L115;
        LinearLayoutManager r144 = new LinearLayoutManager(getContext());
        r144.setStackFromEnd(true);
        r144.setReverseLayout(true);
        Unit r145 = Unit.INSTANCE;
        r143.setLayoutManager(r144);
    L115:
        RecyclerView r146 = this.f61557f;
        if (r146 == null) goto L118;
        r146.setAdapter(this.f61569r);
    L118:
        EditText r147 = this.f61563l;
        if (r147 == null) goto L121;
        r147.setFocusable(true);
    L121:
        EditText r148 = this.f61563l;
        if (r148 == null) goto L124;
        r148.setFocusableInTouchMode(true);
    L124:
        EditText r149 = this.f61563l;
        if (r149 == null) goto L127;
        r149.requestFocus();
    L127:
        int r150 = com.bytedance.android.live.broadcastgame.opengame.utils.l.f61174a;
        Context r151 = getContext();
        EditText r152 = this.f61563l;
        if (r151 == null) goto L139;
        if (r152 == null) goto L139;
        r152.requestFocus();     // Catch: Exception -> L137
        Object r153 = r151.getSystemService("input_method");     // Catch: Exception -> L137
        if (r153 == null) goto L136;
        ((InputMethodManager) r153).showSoftInput(r152, 2);     // Catch: Exception -> L137
        goto L139
    L136:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L137
    L137:
        e = move-exception;
        e.printStackTrace();
    L139:
        RecyclerView r154 = this.f61557f;
        if (r154 != null) goto L142;
    L152:
        TextView r155 = this.f61555d;
        if (r155 == null) goto L155;
        UtilityKotlinExtentionsKt.t(r155);
    L155:
        RecyclerView r156 = this.f61558g;
        if (r156 == null) goto L158;
        r156.setVisibility(8);
    L158:
        RecyclerView r157 = this.f61558g;
        if (r157 == null) goto L161;
        r157.setOverScrollMode(2);
    L161:
        RecyclerView r158 = this.f61558g;
        if (r158 == null) goto L164;
        r158.setLayoutManager(new LinearLayoutManager(getContext()));
    L164:
        RecyclerView r159 = this.f61558g;
        if (r159 == null) goto L174;
        r159.setAdapter(this.f61568q);
        return;
    L174:
        return;
    L142:
        if (r154.getVisibility() != 0) goto L152;
        RecyclerView r160 = this.f61557f;
        if (r160 == null) goto L148;
        RecyclerView.Adapter r161 = r160.getAdapter();
        if (r161 == null) goto L148;
        r112 = r161.getItemCount();
    L148:
        if (r112 < 1) goto L152;
        TextView r162 = this.f61555d;
        if (r162 == null) goto L155;
        UtilityKotlinExtentionsKt.w(r162);
        goto L155
    L71:
        r130 = null;
        goto L73
    L61:
        r127 = null;
    L16:
        r107 = CollectionsKt.emptyList();
        goto L17
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_open_feature_search_fragment_v3, r101, false);
    }
}
