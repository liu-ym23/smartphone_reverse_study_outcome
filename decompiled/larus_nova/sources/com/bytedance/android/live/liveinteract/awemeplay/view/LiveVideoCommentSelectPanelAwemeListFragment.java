package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectAwemePanelViewModel;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectPanelVideoListViewModel;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectPanelVideoListViewModelFactory;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectPanelAwemeListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/liveinteract/awemeplay/view/l;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelAwemeListFragment extends BaseFragment implements l, View.OnClickListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f71568r = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f71569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveVideoCommentSelectPanelVideoListViewModel f71570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoTab f71571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveVideoCommentSelectAwemePanelViewModel f71572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f71573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f71574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f71575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f71576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f71577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView f71578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MultiTypeAdapter f71579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LoadMoreScrollListener f71580o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f71581p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public VideoTab f71582q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f71583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f71584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f71585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment f71586d;

        public b(String r100, long r101, Integer r102, LiveVideoCommentSelectPanelAwemeListFragment r103) {
            this.f71583a = r100;
            this.f71584b = r101;
            this.f71585c = r102;
            this.f71586d = r103;
        }

        public final void a() {
            RecyclerView r100 = this.f71586d.f71578m;
            List<?> r101 = null;
            if (r100 == null) goto L5;
            RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        L7:
            if ((r102 instanceof GridLayoutManager) == true) goto L9;
            r102 = null;
        L9:
            GridLayoutManager r103 = (GridLayoutManager) r102;
            int r104 = 0;
            if (r103 == null) goto L12;
            int r105 = r103.findFirstVisibleItemPosition();
        L13:
            RecyclerView r106 = this.f71586d.f71578m;
            if (r106 == null) goto L16;
            RecyclerView.LayoutManager r107 = r106.getLayoutManager();
        L18:
            if ((r107 instanceof GridLayoutManager) == true) goto L20;
            r107 = null;
        L20:
            GridLayoutManager r108 = (GridLayoutManager) r107;
            if (r108 == null) goto L23;
            int r109 = r108.findLastVisibleItemPosition();
        L24:
            MultiTypeAdapter r110 = this.f71586d.f71579n;
            if (r110 == null) goto L38;
            List<?> r111 = r110.f513437a;
            if (r111 == null) goto L38;
            if ((!r111.isEmpty()) == false) goto L31;
            r101 = r111;
        L31:
            if (r101 == null) goto L38;
            if (r109 < 0) goto L38;
            if (r109 >= r101.size()) goto L38;
            if ((ListProtector.get(r101, r109) instanceof e) == false) goto L38;
            r109 = r109 - 1;
        L38:
            int r112 = (r109 - r105) + 1;
            if (r112 < 0) goto L41;
            r104 = r112;
        L41:
            Map<Integer, String> r113 = td0.b.f545501a;
            td0.b.a(this.f71583a, this.f71584b, this.f71585c.intValue(), r104);
            return;
        L23:
            r109 = 0;
            goto L24
        L16:
            r107 = null;
            goto L18
        L12:
            r105 = 0;
            goto L13
        L5:
            r102 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f71568r = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_video_comment_empty_list_image.png";
    }

    @Override // com.bytedance.android.live.liveinteract.awemeplay.view.l
    public final sd0.a J9() {
        LiveVideoCommentSelectAwemePanelViewModel r100 = this.f71572g;
        if (r100 == null) goto L7;
        MutableLiveData<sd0.a> r101 = r100.getSelectedAwemeVideo();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    public final void hideLoading() {
        View r100 = this.f71575j;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        LiveDoubleColorBallAnimationView r101 = this.f71576k;
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    public LiveVideoCommentSelectPanelAwemeListFragment() {
    }

    public final void S90(boolean r100) {
        LoadMoreScrollListener r101 = this.f71580o;
        if (r101 == null) goto L5;
        r101.f71601b = 0;
    L5:
        MultiTypeAdapter r102 = this.f71579n;
        if (r102 == null) goto L8;
        List<?> r103 = r102.f513437a;
    L9:
        if (r103 == null) goto L24;
        List r104 = TypeIntrinsics.asMutableList(r103);
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.size() <= 0) goto L25;
        int r105 = r104.size() - 1;
        if ((ListProtector.get(r104, r105) instanceof e) == false) goto L26;
        ListProtector.remove(r104, r105);
        if (r100 == false) goto L27;
        MultiTypeAdapter r106 = this.f71579n;
        if (r106 == null) goto L28;
        r106.notifyItemRemoved(r105);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
    L8:
        r103 = null;
        goto L9
    }

    public final void T90(VideoTab r100) {
        m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L7;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L7;
        String r103 = r102.getOwnerUserIdString();
    L8:
        m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L13;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L13;
        Long r106 = Long.valueOf(r105.getRoomId());
    L14:
        if (r103 == null) goto L38;
        if (r106 == null) goto L38;
        if (r100 == null) goto L38;
        long r107 = r106.longValue();
        Integer r108 = r100.getType();
        if (r108 == null) goto L38;
        Integer r109 = r100.getType();
        VideoTab r110 = this.f71571f;
        if (r110 == null) goto L22;
        Integer r111 = r110.getType();
    L24:
        if (Intrinsics.areEqual(r109, r111) == false) goto L38;
        View r112 = this.f71573h;
        if (r112 != null) goto L28;
    L30:
        View r113 = this.f71577l;
        if (r113 != null) goto L33;
    L35:
        RecyclerView r114 = this.f71578m;
        if (r114 == null) goto L38;
        r114.post(new b(r103, r107, r108, this));
        goto L38
    L33:
        if (r113.getVisibility() != 0) goto L35;
        Map<Integer, String> r115 = td0.b.f545501a;
        td0.b.a(r103, r107, r108.intValue(), 0);
        goto L38
    L28:
        if (r112.getVisibility() != 0) goto L30;
        Map<Integer, String> r116 = td0.b.f545501a;
        td0.b.a(r103, r107, r108.intValue(), 0);
        goto L38
    L22:
        r111 = null;
    L38:
        this.f71582q = null;
        return;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.awemeplay.view.l
    public final void ZZ(sd0.a r100) {
        LiveVideoCommentSelectAwemePanelViewModel r101 = this.f71572g;
        if (r101 == null) goto L8;
        MutableLiveData<sd0.a> r102 = r101.getSelectedAwemeVideo();
        if (r102 == null) goto L9;
        r102.setValue(r100);
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L5:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.intValue() != R.id.ttlive_video_comment_list_reloading_btn) goto L13;
        LiveVideoCommentSelectPanelVideoListViewModel r102 = this.f71570e;
        if (r102 == null) goto L14;
        r102.doAction(new ud0.a.C7860a(true, false));
        return;
    L14:
        return;
    L13:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        Serializable r102 = null;
        if (r101 == null) goto L5;
        Serializable r103 = r101.getSerializable("arg_video_tab");
    L7:
        if ((r103 instanceof VideoTab) == false) goto L10;
        r102 = r103;
    L10:
        this.f71571f = (VideoTab) r102;
        LiveVideoCommentSelectAwemePanelViewModel r104 = this.f71572g;
        if (r104 == null) goto L15;
        MutableLiveData<sd0.a> r105 = r104.getSelectedAwemeVideo();
        if (r105 == null) goto L15;
        r105.observe(this, new f(this));
    L15:
        LiveVideoCommentSelectAwemePanelViewModel r106 = this.f71572g;
        if (r106 == null) goto L20;
        MutableLiveData<VideoTab> r107 = r106.getSelectPageTab();
        if (r107 == null) goto L20;
        r107.observe(this, new g(this));
    L20:
        VideoTab r108 = this.f71571f;
        if (r108 == null) goto L25;
        Integer r109 = r108.getType();
        if (r109 == null) goto L25;
        int r110 = r109.intValue();
    L26:
        LiveVideoCommentSelectPanelVideoListViewModel r111 = (LiveVideoCommentSelectPanelVideoListViewModel) ViewModelProviders.of(this, new LiveVideoCommentSelectPanelVideoListViewModelFactory(r110)).get(LiveVideoCommentSelectPanelVideoListViewModel.class);
        this.f71570e = r111;
        if (r111 == null) goto L32;
        MutableLiveData<ud0.b> r112 = r111.getViewEvent();
        if (r112 == null) goto L33;
        r112.observe(this, new h(this));
        return;
    L33:
        return;
    L32:
        return;
    L25:
        r110 = 0;
        goto L26
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f71573h = r100.findViewById(R.id.ttlive_video_comment_list_empty_container);
        HSImageView r102 = (HSImageView) r100.findViewById(R.id.ttlive_video_comment_list_empty_image);
        this.f71574i = r102;
        ImageLoader.bindImage(r102, f71568r);
        HSImageView r103 = this.f71574i;
        if (r103 == null) goto L7;
        GenericDraweeHierarchy r104 = r103.getHierarchy();
        if (r104 == null) goto L7;
        r104.setPlaceholderImage(R.drawable.ttlive_video_comment_list_empty_placeholder_drawable);
    L7:
        this.f71575j = r100.findViewById(R.id.ttlive_video_comment_list_loading_container);
        this.f71576k = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.ttlive_video_comment_list_loading_animation_view);
        this.f71577l = r100.findViewById(R.id.ttlive_video_comment_list_reloading_btn_container);
        Button r105 = (Button) r100.findViewById(R.id.ttlive_video_comment_list_reloading_btn);
        if (r105 == null) goto L10;
        r105.setOnClickListener(this);
    L10:
        this.f71578m = (RecyclerView) r100.findViewById(R.id.video_pager_rlv);
        MultiTypeAdapter r106 = new MultiTypeAdapter();
        this.f71579n = r106;
        r106.f513437a = new ArrayList();
        MultiTypeAdapter r107 = this.f71579n;
        if (r107 == null) goto L13;
        r107.z2(sd0.a.class, new j(this.f71569d, this));
    L13:
        MultiTypeAdapter r108 = this.f71579n;
        if (r108 == null) goto L16;
        r108.z2(e.class, new i());
    L16:
        GridLayoutManager r109 = new GridLayoutManager(getContext(), 3);
        r109.setSpanSizeLookup(new LiveVideoCommentSelectPanelAwemeListFragment$initView$1(this));
        RecyclerView r110 = this.f71578m;
        if (r110 == null) goto L19;
        r110.setLayoutManager(r109);
    L19:
        RecyclerView r111 = this.f71578m;
        if (r111 == null) goto L22;
        r111.addItemDecoration(new LiveVideoCommentSelectPanelAwemeListFragment$initView$2());
    L22:
        RecyclerView r112 = this.f71578m;
        if (r112 == null) goto L25;
        r112.setAdapter(this.f71579n);
    L25:
        LoadMoreScrollListener r113 = new LoadMoreScrollListener(r109, new LiveVideoCommentSelectPanelAwemeListFragment$initView$3(this));
        this.f71580o = r113;
        RecyclerView r114 = this.f71578m;
        if (r114 == null) goto L28;
        r114.addOnScrollListener(r113);
    L28:
        LiveVideoCommentSelectPanelVideoListViewModel r115 = this.f71570e;
        if (r115 == null) goto L32;
        r115.doAction(new ud0.a.C7860a(true, true));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_video_comment_select_panel_aweme_page_fragment_layout, r101, false);
    }
}
