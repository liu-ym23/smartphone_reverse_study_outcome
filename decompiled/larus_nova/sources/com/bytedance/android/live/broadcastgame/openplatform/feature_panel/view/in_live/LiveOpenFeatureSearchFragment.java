package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.content.Context;
import android.os.Bundle;
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
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureSearchFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureSearchFragment extends BaseFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f61488l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f61489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbsOpenFeaturePanelViewModel f61490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.e f61491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f61492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f61493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c20.a f61494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OpenFeatureTabListAdapter f61495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MultiTypeAdapter f61496k;

    public static final class a implements SearchHistoryViewBinder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTypeAdapter f61497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveOpenFeatureSearchFragment f61498b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            LiveOpenFeatureSearchFragment r101 = this.f61498b;
            int r102 = LiveOpenFeatureSearchFragment.f61488l;
            ((EditText) r101.S90(R.id.search_edit)).setText(r100);
            ((EditText) r101.S90(R.id.search_edit)).setSelection(r100.length());
            r101.V90();
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "keyWord");
            List<?> r101 = this.f61497a.f513437a;
            if (r101 == null) goto L10;
            TypeIntrinsics.asMutableCollection(r101).remove(r100);
            if (this.f61497a.f513437a.size() >= 1) goto L7;
            UtilityKotlinExtentionsKt.t(this.f61498b.S90(R.id.clear_all_histories));
        L7:
            this.f61497a.notifyDataSetChanged();
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }

        public a(MultiTypeAdapter r100, LiveOpenFeatureSearchFragment r101) {
            this.f61497a = r100;
            this.f61498b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public LiveOpenFeatureSearchFragment() {
        this.f61489d = new LinkedHashMap();
        this.f61491f = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.e();
        this.f61492g = 2;
        MultiTypeAdapter r100 = new MultiTypeAdapter();
        r100.z2(String.class, new SearchHistoryViewBinder(new a(r100, this)));
        Unit r101 = Unit.INSTANCE;
        this.f61496k = r100;
    }

    public final void U90() {
        ((LinearLayout) S90(R.id.search_empty)).setVisibility(8);
        ((RecyclerView) S90(R.id.recycler_search_result)).setVisibility(8);
        UtilityKotlinExtentionsKt.t(S90(R.id.loading_view));
    }

    public final void V90() {
        String r100 = ((EditText) S90(R.id.search_edit)).getText().toString();
        if (r100 == null) goto L28;
        String r101 = StringsKt.trim(r100).toString();
        if (TextUtils.isEmpty(r101) == true) goto L29;
        W90(false);
        ((TextView) S90(R.id.clear_all_histories)).setVisibility(8);
        int r102 = com.bytedance.android.live.broadcastgame.opengame.utils.l.f61174a;
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(getContext(), S90(R.id.search_edit));
        UtilityKotlinExtentionsKt.w(S90(R.id.loading_view));
        if (ft0.f120230a.getValue().b() == false) goto L21;
        c20.a r103 = this.f61494i;
        if (r103 == null) goto L21;
        if (r103.f22119a != 6) goto L21;
        AbsOpenFeaturePanelViewModel r104 = this.f61490e;
        if (r104 == null) goto L30;
        a20.l r105 = r104.getFeatureSearchHandler();
        if (r105 == null) goto L31;
        c20.a r106 = this.f61494i;
        if (r106 == null) goto L19;
        List<f10.f> r107 = r106.f22120b;
    L20:
        r105.i(r101, r107);
        return;
    L19:
        r107 = null;
        goto L20
    L31:
        return;
    L30:
        return;
    L21:
        AbsOpenFeaturePanelViewModel r108 = this.f61490e;
        if (r108 == null) goto L33;
        a20.l r109 = r108.getFeatureSearchHandler();
        if (r109 == null) goto L34;
        r109.j(this.f61492g, this.f61493h, r101);
        return;
    L34:
        return;
    L33:
        return;
    L29:
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
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
        ((LinkedHashMap) this.f61489d).clear();
        return;
    L11:
        r104 = null;
        goto L12
    }

    public final View S90(int r100) {
        if (this.f61489d != null) goto L5;
        this.f61489d = new LinkedHashMap();
    L5:
        View r101 = this.f61489d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f61489d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void W90(boolean r100) {
        if (r100 == false) goto L8;
        RecyclerView.Adapter r101 = ((RecyclerView) S90(R.id.recycler_search_history)).getAdapter();
        if (r101 == null) goto L7;
        r101.notifyDataSetChanged();
    L7:
        UtilityKotlinExtentionsKt.w(S90(R.id.recycler_search_history));
        return;
    L8:
        UtilityKotlinExtentionsKt.t(S90(R.id.recycler_search_history));
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
        this.f61493h = r101;
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.f61490e = AbsOpenFeaturePanelViewModel.a.a(true, this);
    }

    public static final void T90(LiveOpenFeatureSearchFragment r100, List r101) {
        String r102 = ((EditText) r100.S90(R.id.search_edit)).getText().toString();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return;
    L12:
        if (r101 != null) goto L14;
    L23:
        UtilityKotlinExtentionsKt.w(r100.S90(R.id.search_empty));
        UtilityKotlinExtentionsKt.t(r100.S90(R.id.loading_view));
        UtilityKotlinExtentionsKt.t(r100.S90(R.id.recycler_search_result));
        return;
    L14:
        if (r101.isEmpty() == true) goto L23;
        r100.f61491f.d();
        Iterator r104 = r101.iterator();
    L18:
        if (r104.hasNext() == false) goto L20;
        f10.f r105 = (f10.f) r104.next();
        r105.f475043u = r100.f61491f.a(r105.f115637s, r105.f475042t);
        goto L18
    L20:
        UtilityKotlinExtentionsKt.t(r100.S90(R.id.loading_view));
        r100.f61496k.notifyDataSetChanged();
        UtilityKotlinExtentionsKt.w(r100.S90(R.id.recycler_search_result));
        UtilityKotlinExtentionsKt.t(r100.S90(R.id.search_empty));
        OpenFeatureTabListAdapter r106 = r100.f61495j;
        if (r106 == null) goto L26;
        r106.setData(r101);
        return;
    L26:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        AbsOpenFeaturePanelViewModel r102 = this.f61490e;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L5;
        a20.d r104 = r102.getFeatureIconBehaviorController();
    L7:
        if ((r104 instanceof a20.e) == true) goto L9;
        r104 = null;
    L9:
        ArrayList r105 = new ArrayList();
        ft0 r106 = ft0.f120230a;
        if (r106.getValue().b() == false) goto L12;
        r105.add(new f20.d(r104));
    L12:
        r105.add(new f20.e(r104));
        this.f61495j = new OpenFeatureTabListAdapter(CollectionsKt.emptyList(), r105, null);
        MultiTypeAdapter r107 = this.f61496k;
        AbsOpenFeaturePanelViewModel r108 = this.f61490e;
        if (r108 == null) goto L19;
        a20.l r109 = r108.getFeatureSearchHandler();
        if (r109 == null) goto L19;
        List<?> r110 = r109.a();
        if (r110 == null) goto L19;
    L20:
        r107.f513437a = r110;
        AbsOpenFeaturePanelViewModel r111 = this.f61490e;
        if (r111 == null) goto L25;
        LiveData<List<f10.f>> r112 = r111.getOpenFeatureSearchResult();
        if (r112 == null) goto L25;
        r112.observe(this, new q(this));
    L25:
        int r113 = 0;
        if (r106.getValue().f() == false) goto L49;
        AbsOpenFeaturePanelViewModel r114 = this.f61490e;
        if (r114 == null) goto L33;
        LiveData<Integer> r115 = r114.getOpenFeatureTabIndexData();
        if (r115 == null) goto L33;
        Integer r116 = r115.getValue();
        if (r116 == null) goto L33;
    L34:
        int r117 = r116.intValue();
        AbsOpenFeaturePanelViewModel r118 = this.f61490e;
        if (r118 == null) goto L43;
        LiveData<c20.c> r119 = r118.getOpenFeatureTabListData();
        if (r119 == null) goto L43;
        c20.c r120 = r119.getValue();
        if (r120 == null) goto L43;
        List<c20.a> r121 = r120.f22131c;
        if (r121 == null) goto L43;
        c20.a r122 = (c20.a) CollectionsKt.getOrNull(r121, r117);
    L44:
        this.f61494i = r122;
        AbsOpenFeaturePanelViewModel r123 = this.f61490e;
        if (r123 == null) goto L49;
        LiveData<c20.c> r124 = r123.getOpenFeatureTabListData();
        if (r124 == null) goto L49;
        r124.observe(this, new r(this));
    L43:
        r122 = null;
    L33:
        r116 = 0;
    L49:
        U90();
        ViewGroup.LayoutParams r125 = ((LinearLayout) S90(R.id.search_empty)).getLayoutParams();
        if ((r125 instanceof ConstraintLayout.LayoutParams) == true) goto L52;
        r125 = null;
    L52:
        ConstraintLayout.LayoutParams r126 = (ConstraintLayout.LayoutParams) r125;
        if (r126 == null) goto L55;
        ((ViewGroup.MarginLayoutParams) r126).topMargin = s1.f(114.0f);
    L55:
        ViewGroup.LayoutParams r127 = ((HSImageView) S90(R.id.search_result_empty)).getLayoutParams();
        if ((r127 instanceof LinearLayout.LayoutParams) == false) goto L59;
        r103 = r127;
    L59:
        LinearLayout.LayoutParams r128 = (LinearLayout.LayoutParams) r103;
        if (r128 == null) goto L62;
        r128.width = s1.f(180.0f);
        r128.height = s1.f(120.0f);
    L62:
        ImageLoader.bindImage((HSImageView) S90(R.id.search_result_empty), "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/img_empty_search.png");
        ((TextView) S90(R.id.cancel_search)).setOnClickListener(new s(this));
        ((TextView) S90(R.id.cancel_search)).setVisibility(0);
        if (r106.getValue().f() == false) goto L69;
        c20.a r129 = this.f61494i;
        if (r129 == null) goto L69;
        if (r129.f22119a != 6) goto L69;
        ((EditText) S90(R.id.search_edit)).setHint("搜索互动工具");
    L70:
        ((EditText) S90(R.id.search_edit)).setImeOptions(3);
        ((EditText) S90(R.id.search_edit)).setSingleLine(true);
        ((EditText) S90(R.id.search_edit)).setInputType(1);
        ((EditText) S90(R.id.search_edit)).setOnEditorActionListener(new t(this));
        ((EditText) S90(R.id.search_edit)).addTextChangedListener(new u(this));
        ((EditText) S90(R.id.search_edit)).setOnFocusChangeListener(new v(this));
        ((ImageView) S90(R.id.clear_search_input)).setOnClickListener(new w(this));
        ((ImageView) S90(R.id.clear_search_input)).setVisibility(4);
        ((TextView) S90(R.id.clear_all_histories)).setOnClickListener(new x(this));
        RecyclerView r130 = (RecyclerView) S90(R.id.recycler_search_history);
        LinearLayoutManager r131 = new LinearLayoutManager(getContext());
        r131.setStackFromEnd(true);
        r131.setReverseLayout(true);
        Unit r132 = Unit.INSTANCE;
        r130.setLayoutManager(r131);
        ((RecyclerView) S90(R.id.recycler_search_history)).setAdapter(this.f61496k);
        ((EditText) S90(R.id.search_edit)).setFocusable(true);
        ((EditText) S90(R.id.search_edit)).setFocusableInTouchMode(true);
        ((EditText) S90(R.id.search_edit)).requestFocus();
        int r133 = com.bytedance.android.live.broadcastgame.opengame.utils.l.f61174a;
        Context r134 = getContext();
        View r135 = S90(R.id.search_edit);
        if (r134 == null) goto L83;
        if (r135 == null) goto L83;
        r135.requestFocus();     // Catch: Exception -> L80
        Object r136 = r134.getSystemService("input_method");     // Catch: Exception -> L80
        if (r136 == null) goto L79;
        ((InputMethodManager) r136).showSoftInput(r135, 2);     // Catch: Exception -> L80
        goto L83
    L79:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L83:
        if (((RecyclerView) S90(R.id.recycler_search_history)).getVisibility() != 0) goto L89;
        RecyclerView.Adapter r137 = ((RecyclerView) S90(R.id.recycler_search_history)).getAdapter();
        if (r137 == null) goto L87;
        r113 = r137.getItemCount();
    L87:
        if (r113 < 1) goto L89;
        UtilityKotlinExtentionsKt.w(S90(R.id.clear_all_histories));
    L90:
        ((RecyclerView) S90(R.id.recycler_search_result)).setVisibility(8);
        ((RecyclerView) S90(R.id.recycler_search_result)).setOverScrollMode(2);
        ((RecyclerView) S90(R.id.recycler_search_result)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) S90(R.id.recycler_search_result)).setAdapter(this.f61495j);
        return;
    L89:
        UtilityKotlinExtentionsKt.t(S90(R.id.clear_all_histories));
    L69:
        ((EditText) S90(R.id.search_edit)).setHint("搜索小程序");
    L19:
        r110 = CollectionsKt.emptyList();
        goto L20
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_open_feature_search_fragment, r101, false);
    }
}
