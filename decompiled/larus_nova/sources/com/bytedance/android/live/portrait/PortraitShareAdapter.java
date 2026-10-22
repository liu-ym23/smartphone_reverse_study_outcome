package com.bytedance.android.live.portrait;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.helper.LiveShareHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.android.livesdk.chatroom.view.f;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.MatchShareBackground;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/portrait/PortraitShareAdapter;", "Lcom/bytedance/android/live/uikit/viewpager/AbsPagerAdapter;", "Landroid/content/Context;", RXScreenCaptureService.KEY_INDEX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitShareAdapter extends AbsPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, f> f85862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Long> f85863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MatchShareParam f85864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f85865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f85866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f85867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f85868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FragmentActivity f85869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f85870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LiveVerticalViewPager f85871j;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f85872a;

        public b(View r100) {
            this.f85872a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            this.f85872a.setAlpha(0.5f);
            return false;
        L5:
            if (r102 != 1) goto L7;
        L9:
            this.f85872a.setAlpha(1.0f);
            return false;
        L7:
            if (r102 == 3) goto L9;
            return false;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f85873a;

        public c(FrameLayout r100) {
            this.f85873a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams r100 = this.f85873a.getLayoutParams();     // Catch: Throwable -> L7
            if (r100 == null) goto L6;
            r100.height = (int) (s1.t() * 0.5625f);     // Catch: Throwable -> L7
            this.f85873a.setLayoutParams(r100);     // Catch: Throwable -> L7
            this.f85873a.requestLayout();     // Catch: Throwable -> L7
            return;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitShareAdapter f85874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f85875b;

        public d(PortraitShareAdapter r100, int r101) {
            this.f85874a = r100;
            this.f85875b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PortraitShareAdapter.f(this.f85874a, this.f85875b);
        }
    }

    public static final class e implements com.bytedance.android.livesdk.chatroom.view.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitShareAdapter f85876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f85877b;

        @Override // com.bytedance.android.livesdk.chatroom.view.c
        public final void a() {
            List<CollectionItem> r100 = this.f85876a.f85864c.f159381d;
            if (r100 == null) goto L8;
            CollectionItem r101 = (CollectionItem) CollectionsKt.getOrNull(r100, this.f85877b);
            if (r101 == null) goto L8;
            String r102 = r101.getCollectionId();
            if (r102 == null) goto L8;
        L9:
            jl0.a.c(r102);
            return;
        L8:
            r102 = "";
            goto L9
        }

        @Override // com.bytedance.android.livesdk.chatroom.view.c
        public final void onPause() {
            List<CollectionItem> r100 = this.f85876a.f85864c.f159381d;
            if (r100 == null) goto L8;
            CollectionItem r101 = (CollectionItem) CollectionsKt.getOrNull(r100, this.f85877b);
            if (r101 == null) goto L8;
            String r102 = r101.getCollectionId();
            if (r102 == null) goto L8;
        L9:
            long r103 = System.currentTimeMillis();
            Long r104 = (Long) ((LinkedHashMap) this.f85876a.f85863b).get(Integer.valueOf(this.f85877b));
            if (r104 == null) goto L12;
            long r105 = r104.longValue();
        L13:
            jl0.a.b(r102, r103 - r105);
            this.f85876a.f85863b.put(Integer.valueOf(this.f85877b), 0L);
            return;
        L12:
            r105 = 0;
        L8:
            r102 = "";
            goto L9
        }

        @Override // com.bytedance.android.livesdk.chatroom.view.c
        public final void onPlay() {
            List<CollectionItem> r100 = this.f85876a.f85864c.f159381d;
            String r101 = "";
            if (r100 == null) goto L8;
            CollectionItem r102 = (CollectionItem) CollectionsKt.getOrNull(r100, this.f85877b);
            if (r102 == null) goto L8;
            String r103 = r102.getCollectionId();
            if (r103 == null) goto L8;
        L9:
            MatchShareParam r104 = this.f85876a.f85864c;
            if (r104 == null) goto L15;
            String r105 = r104.f159378a;
            if (r105 == null) goto L15;
            r101 = r105;
        L15:
            jl0.a.a(r103, r101);
            this.f85876a.f85863b.put(Integer.valueOf(this.f85877b), Long.valueOf(System.currentTimeMillis()));
            return;
        L8:
            r103 = "";
            goto L9
        }

        public e(PortraitShareAdapter r100, int r101) {
            this.f85876a = r100;
            this.f85877b = r101;
        }
    }

    static {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<CollectionItem> r100 = this.f85864c.f159381d;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final Context getContext() {
        return this.f85870i;
    }

    public static final void f(PortraitShareAdapter r100, int r101) {
        MatchShareParam r102 = r100.f85864c;
        if (r102.f159383f == null) goto L5;
    L7:
        HashMap r103 = new HashMap();
        List<CollectionItem> r104 = r100.f85864c.f159381d;
        String r105 = null;
        if (r104 == null) goto L10;
        CollectionItem r106 = (CollectionItem) ListProtector.get(r104, r101);
    L11:
        MatchShareParam r107 = r100.f85864c;
        String r108 = "";
        if (r106 == null) goto L15;
        String r109 = r106.getCollectionId();
        if (r109 == null) goto L15;
    L16:
        r107.f159380c = r109;
        if (r106 == null) goto L20;
        r105 = r106.getCollectionId();
    L20:
        if (TextUtils.isEmpty(r105) == true) goto L27;
        if (r106 == null) goto L26;
        String r110 = r106.getCollectionId();
        if (r110 == null) goto L26;
        r108 = r110;
    L26:
        r103.put("collection_id", r108);
        r103.put("multitab_select_tabid", "4");
    L27:
        LiveShareHelper.b(r100.f85869h, r100.f85864c, r106, r103);
        return;
    L15:
        r109 = "";
        goto L16
    L10:
        r106 = null;
        goto L11
    L5:
        if (r102.f159384g != null) goto L7;
    }

    @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        return Intrinsics.areEqual(r100, r101);
    }

    public PortraitShareAdapter(FragmentActivity r210, Context r211, LiveVerticalViewPager r212) {
        Intrinsics.checkNotNullParameter(r210, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r212, "viewPager");
        super(r211, LayoutInflater.from(r211));
        this.f85869h = r210;
        this.f85870i = r211;
        this.f85871j = r212;
        this.f85862a = new LinkedHashMap();
        this.f85863b = new LinkedHashMap();
        this.f85864c = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
        this.f85865d = -1;
        r212.setOnPageChangeListener(new PortraitShareAdapter$mPageChangeListener$1(this));
        if (s1.d(r211) == false) goto L5;
        int r100 = s1.o();
    L6:
        this.f85868g = r100;
        return;
    L5:
        r100 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        super.destroyItem(r100, r101, r102);
        this.f85862a.remove(Integer.valueOf(r101));
    }

    @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter
    public final View getView(int r110, View r111, ViewGroup r112) {
        if (r111 != null) goto L5;
        r111 = this.mInflater.inflate(R.layout.ttlive_vs_share_portrait_item, r112, false);
    L5:
        TextView r113 = (TextView) r111.findViewById(R.id.ttlive_vs_match_share_portrait_title);
        FrameLayout r100 = (FrameLayout) r111.findViewById(R.id.ttlive_vs_match_share_portrait_container);
        View r101 = r111.findViewById(R.id.ttlive_vs_match_share_btn);
        HSImageView r102 = (HSImageView) r111.findViewById(R.id.ttlive_vs_match_share_portrait_bg);
        TextView r103 = (TextView) r111.findViewById(R.id.ttlive_vs_match_share_btn_text);
        List<CollectionItem> r104 = this.f85864c.f159381d;
        IRoom r105 = null;
        if (r104 == null) goto L8;
        CollectionItem r106 = (CollectionItem) ListProtector.get(r104, r110);
    L9:
        if (r106 == null) goto L11;
        Integer r107 = Integer.valueOf(r106.getCollectionType());
    L12:
        boolean r108 = true;
        if (r107 != null) goto L16;
    L18:
        if (r107 != null) goto L21;
    L23:
        MatchShareParam r109 = this.f85864c;
        if (r109.f159383f != null) goto L28;
        if (r109.f159384g != null) goto L28;
    L30:
        r108 = false;
    L31:
        UtilityKotlinExtentionsKt.A(r101, r108);
        r101.setOnTouchListener(new b(r101));
        ViewGroup.LayoutParams r114 = r101.getLayoutParams();
        if (r114 == null) goto L83;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        r115.bottomMargin = this.f85868g + s1.f(12.0f);
        r101.setLayoutParams(r115);
        if (r100 == null) goto L36;
        r100.post(new c(r100));
    L36:
        if (r106 == null) goto L39;
        String r116 = r106.getTitle();
        if (r116 == null) goto L39;
    L42:
        if (r116 != null) goto L45;
        r116 = "";
    L45:
        r113.setText(r116);
        if (((LinkedHashMap) this.f85862a).get(Integer.valueOf(r110)) != null) goto L48;
        this.f85862a.put(Integer.valueOf(r110), new f(new e(this, r110)));
    L48:
        f r117 = (f) ((LinkedHashMap) this.f85862a).get(Integer.valueOf(r110));
        if (r117 == null) goto L51;
        com.bytedance.android.live.c.b(false, r100, r117, s1.t(), r106);
    L51:
        MatchShareParam r118 = this.f85864c;
        if (r118.f159383f == null) goto L54;
    L56:
        IRoom r119 = this.f85864c.f159383f;
        if ((r119 instanceof Room) == false) goto L60;
        r105 = r119;
    L60:
        Room r120 = (Room) r105;
        if (r120 == null) goto L71;
        EpisodeExtraInfo r121 = r120.getEpisodeExtra2();
        if (r121 == null) goto L71;
        IMatchRoomInfo r122 = r121.getMatchRoomInfo();
        if (r122 == null) goto L71;
        IMatchShareBackground r123 = r122.getMatchShareBackground();
        if (r123 == null) goto L71;
        k r124 = r123.getVerticalBackground();
        if (r124 == null) goto L71;
        ImageUtil.loadImage(r102, r124, 0);
    L71:
        Episode r125 = this.f85864c.f159384g;
        if (r125 == null) goto L80;
        EpisodeBasicInfo r126 = r125.episodeBasicInfo;
        if (r126 == null) goto L80;
        MatchShareBackground r127 = r126.getMatchShareBackground();
        if (r127 == null) goto L80;
        k r128 = r127.getVerticalBackground();
        if (r128 == null) goto L80;
        ImageUtil.loadImage(r102, r128, 0);
    L80:
        r101.setOnClickListener(new d(this, r110));
        return r111;
    L54:
        if (r118.f159384g != null) goto L56;
        UtilityKotlinExtentionsKt.t(r101);
    L39:
        if (r106 == null) goto L41;
        r116 = r106.getLocalPreviewTopTitle();
        goto L42
    L41:
        r116 = null;
        goto L42
    L83:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L28:
        if (r109.f159387j != null) goto L30;
    L21:
        if (r107.intValue() != 2) goto L23;
        r103.setText("分享视频");
        goto L23
    L16:
        if (r107.intValue() != 1) goto L18;
        r103.setText("分享图片");
        goto L23
    L11:
        r107 = null;
        goto L12
    L8:
        r106 = null;
        goto L9
    }
}
