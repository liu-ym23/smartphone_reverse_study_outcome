package com.bytedance.android.shopping.anchorv3.comment;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.model.response.r0;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.anchorv3.comment.api.PromotionCommentApi;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.commentv2.api.TabModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class CommentViewModel implements com.bytedance.android.shopping.anchorv3.commentv2.model.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f164486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f164487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f164488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f164489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f164490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv3.comment.data.b f164491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f164492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f164493h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f164494a;

        public b(Function1 r100) {
            this.f164494a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Function1 r101 = this.f164494a;
            if (((r0) r100).a() != 0) goto L5;
            boolean r102 = true;
        L6:
            r101.invoke(Boolean.valueOf(r102));
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f164495a;

        public c(Function1 r100) {
            this.f164495a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f164495a.invoke(Boolean.FALSE);
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv3.commentv2.model.c
    public final CommentParams a() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv3.commentv2.model.c
    public final void b() {
    }

    @Override // com.bytedance.android.shopping.anchorv3.commentv2.model.c
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv3.commentv2.model.c
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv3.commentv2.model.c
    public final void f() {
    }

    public final Context getContext() {
        return null;
    }

    public final RecyclerView.RecycledViewPool h() {
        return (RecyclerView.RecycledViewPool) this.f164492g.getValue();
    }

    public CommentViewModel() {
        this.f164486a = LazyKt.lazy(CommentViewModel$compositeDisposable$2.INSTANCE);
        String r100 = o53.b.f522096a;
        Boolean r101 = Boolean.FALSE;
        MapsKt.hashMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_SHOP_SAME_COMMENT, r101), TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE, r101), TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_SHOP_MODULE, r101), TuplesKt.to("selected_comment", r101)});
        new MutableLiveData();
        this.f164487b = new ArrayList();
        new MutableLiveData();
        new MutableLiveData();
        this.f164488c = new LinkedHashMap();
        new StatTagItem(0, 0, null, null, 0, false, null, 0, 255, null);
        new TabModel();
        this.f164489d = new LinkedHashSet();
        this.f164490e = 10;
        o53.c.a(0);
        this.f164491f = new com.bytedance.android.shopping.anchorv3.comment.data.b(this);
        this.f164492g = LazyKt.lazy(CommentViewModel$mediaViewPool$2.INSTANCE);
        this.f164493h = LazyKt.lazy(CommentViewModel$imageCallerContext$2.INSTANCE);
    }

    public final StatTagItem g() {
        return new StatTagItem(-1, 0, null, null, 0, false, null, 0, 254, null);
    }

    @Override // com.bytedance.android.shopping.anchorv3.commentv2.model.c
    public final void d(long r100, long r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        n53.a r103 = n53.a.f518016a;
        PromotionCommentApi r104 = (PromotionCommentApi) n.f48128a.create(CJPayConstant.TT_CJ_PAY_FOLLOW_HOST, PromotionCommentApi.class);
        if (r104 == null) goto L10;
        Observable<r0> r105 = r104.syncCommentAction(r100, r101);
        if (r105 == null) goto L10;
        Observable<r0> r106 = r105.subscribeOn(Schedulers.io());
        if (r106 == null) goto L10;
        Observable<r0> r107 = r106.observeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L10;
    L11:
        Disposable r108 = r107.subscribe(new b(r102), new c(r102));
        ((CompositeDisposable) this.f164486a.getValue()).add(r108);
        return;
    L10:
        r107 = Observable.error(new Exception("PromotionCommentApi.INSTANCE is null"));
        goto L11
    }
}
