package com.bytedance.android.shopping.commentv3.uitree.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.CommentAdapter;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.OffsetLayoutManager;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.CommentMediaViewHolder;
import com.larus.nova.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/CommentListUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/b;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/a;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/e;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListUI extends BaseCommentUI<b, com.bytedance.android.shopping.commentv3.uitree.list.a> implements e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f172819o = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f172820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f172821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommentAdapter f172822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f172823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f172824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f172825n;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentListUI f172826a;

        public a(CommentListUI r100) {
            this.f172826a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            b r101 = (b) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f172830a.f508413d != FetchFrom.INIT) goto L14;
            ImageView r102 = this.f172826a.f172821j;
            if (r102 == null) goto L14;
            if (r102.getVisibility() != 0) goto L14;
            ImageView r103 = this.f172826a.f172821j;
            if (r103 == null) goto L14;
            r103.setVisibility(8);
        L14:
            CommentListUI r104 = this.f172826a;
            int r105 = CommentListUI.f172819o;
            com.bytedance.android.shopping.commentv3.data.b r106 = r104.f172664e;
            if (r106 != null) goto L17;
        L19:
            boolean r107 = false;
        L20:
            com.bytedance.android.shopping.commentv3.data.b r108 = this.f172826a.f172664e;
            if (r108 != null) goto L23;
        L28:
            CommentAdapter r109 = this.f172826a.f172822k;
            if (r109 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L31:
            lc3.b r110 = r101.f172830a;
            r109.B2(r110.f508410a, r107, r110.f508413d);
        L33:
            if (r101.f172830a.f508412c == false) goto L38;
            RecyclerView r111 = this.f172826a.f172820i;
            if (r111 == null) goto L39;
            r111.post(new d(this));
            return;
        L39:
            return;
        L38:
            return;
        L23:
            if (r108.c() != true) goto L28;
            CommentAdapter r112 = this.f172826a.f172822k;
            if (r112 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L27:
            lc3.b r113 = r101.f172830a;
            r112.B2(r113.f508411b, r107, r113.f508413d);
            goto L33
        L17:
            if (r106.b() != true) goto L19;
            r107 = true;
            goto L20
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.e
    public final void c() {
        RecyclerView r100 = this.f172820i;
        RecyclerView.LayoutManager r101 = null;
        if (r100 == null) goto L5;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
    L7:
        if ((r102 instanceof LinearLayoutManager) == false) goto L10;
        r101 = r102;
    L10:
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
        if (r103 == null) goto L14;
        r103.scrollToPositionWithOffset(0, 0);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final com.bytedance.android.shopping.commentv3.base.b o() {
        return new b(new lc3.b(null, null, 15));
    }

    public CommentListUI() {
        this.f172823l = new c(this);
        this.f172824m = LazyKt.lazy(CommentListUI$commentScrollListeners$2.INSTANCE);
        this.f172825n = 10;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        View r100 = this.f172662c;
        Drawable r101 = null;
        if (r100 == null) goto L5;
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.comment_list_rv);
    L7:
        if ((r102 instanceof RecyclerView) == true) goto L9;
        r102 = null;
    L9:
        this.f172820i = r102;
        View r103 = this.f172662c;
        if (r103 == null) goto L12;
        ImageView r104 = (ImageView) r103.findViewById(R.id.comment_list_placeholder);
    L14:
        if ((r104 instanceof ImageView) == true) goto L16;
        r104 = null;
    L16:
        this.f172821j = r104;
        Context r105 = getContext();
        if (r105 == null) goto L49;
        int r106 = k1.m(getContext());
        if (r106 < 0) goto L49;
        com.bytedance.android.shopping.commentv3.data.b r107 = this.f172664e;
        if (r107 == null) goto L27;
        boolean r108 = true;
        if (r107.c() != true) goto L27;
    L28:
        if (r108 == false) goto L30;
        int r109 = R.drawable.ec_comment_page_pic_mode_placeholder;
    L31:
        int r110 = g1.f45599a;
        Drawable r111 = g1.a.b(r105, r109);
        if ((r111 instanceof BitmapDrawable) == false) goto L35;
        r101 = r111;
    L35:
        BitmapDrawable r112 = (BitmapDrawable) r101;
        if (r112 == null) goto L49;
        Bitmap r113 = r112.getBitmap();
        if (r113 == null) goto L49;
        ImageView r114 = this.f172821j;
        if (r114 == null) goto L44;
        r114.setImageBitmap(r113);
    L44:
        if (r113.getWidth() <= 0) goto L49;
        float r115 = r106 / r113.getWidth();
        ImageView r116 = this.f172821j;
        if (r116 == null) goto L49;
        Matrix r117 = new Matrix();
        r117.setScale(r115, r115);
        Unit r118 = Unit.INSTANCE;
        r116.setImageMatrix(r117);
        goto L49
    L30:
        r109 = R.drawable.ec_comment_page_list_mode_placeholder;
    L27:
        r108 = false;
    L49:
        final RecyclerView r119 = this.f172820i;
        if (r119 == null) goto L56;
        r119.setLayoutManager(new OffsetLayoutManager(r119, r119.getContext()));
        if (o53.b.a() == false) goto L54;
        jh.b.a r120 = jh.b.f499064c;
        MonitorScenes r121 = MonitorScenes.EC_PRODUCT_COMMENT_PAGE;
        r120.getClass();
        jh.b.a.d(r121).c(r119);
    L55:
        final CommentAdapter r122 = new CommentAdapter(this.f172666g, r119);
        r122.y2();
        r122.f176411r = new CommentListUI$onCreate$$inlined$let$lambda$1(r122, this);
        r122.f176401h = l(44);
        int r123 = l(12);
        int r124 = l(12);
        r122.f176403j = 0;
        r122.f176405l = r123;
        r122.f176404k = 0;
        r122.f176402i = r124;
        Unit r125 = Unit.INSTANCE;
        this.f172822k = r122;
        r119.setAdapter(r122);
        r119.addOnScrollListener(new CommentListUI$onCreate$$inlined$let$lambda$2(r119, this));
        goto L56
    L54:
        jh.b.a r126 = jh.b.f499064c;
        MonitorScenes r127 = MonitorScenes.EC_SHOP_COMMENT_PAGE;
        r126.getClass();
        jh.b.a.d(r127).c(r119);
    L56:
        this.f172669b.observe(this, new a(this));
        ECLiveHybridUtil.m("nps_data_sync", this.f172823l);
        return;
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onDestroy() {
        super.onDestroy();
        List<CommentMediaViewHolder> r100 = CommentMediaViewHolder.f172861j;
        CommentMediaViewHolder.a.a(true);
        ECLiveHybridUtil.p("nps_data_sync", this.f172823l);
        if (o53.b.a() == false) goto L5;
        jh.b.a r101 = jh.b.f499064c;
        String r102 = MonitorScenes.EC_PRODUCT_COMMENT_PAGE.getSceneName();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "sceneName");
        jh.b.f499063b.remove(r102);
        return;
    L5:
        jh.b.a r103 = jh.b.f499064c;
        String r104 = MonitorScenes.EC_SHOP_COMMENT_PAGE.getSceneName();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "sceneName");
        jh.b.f499063b.remove(r104);
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.e
    public final void a(com.bytedance.android.shopping.commentv3.uitree.p008float.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((List) this.f172824m.getValue()).add(r100);
    }
}
