package com.bytedance.android.shopping.commentfeed.utils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.r0;
import com.bytedance.android.shopping.commentfeed.model.CommentListResponse;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zb3.d;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/utils/CommentListViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "comments", "", "setCommentModel", "Lzb3/d;", "requestParam", "loadCommentList", "Lzb3/b;", "requestParams", "Lkotlin/Function1;", "Lzb3/a;", "resultCallBack", "diggCommentAction", "Landroidx/lifecycle/MutableLiveData;", "commentList", "Landroidx/lifecycle/MutableLiveData;", "getCommentList", "()Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "isRequestSucceed", "", "commentCursor", "J", "getCommentCursor", "()J", "setCommentCursor", "(J)V", "firstEnterCommentIndex", "I", "getFirstEnterCommentIndex", "()I", "setFirstEnterCommentIndex", "(I)V", "hasMoreComment", "Z", "getHasMoreComment", "()Z", "setHasMoreComment", "(Z)V", "isLoadingComment", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListViewModel extends ViewModel {
    public static final a Companion = null;
    private long commentCursor;
    private final MutableLiveData<List<PromotionProductCommentDTO>> commentList;
    private int firstEnterCommentIndex;
    private boolean hasMoreComment;
    private boolean isLoadingComment;
    private final MutableLiveData<Pair<Boolean, Integer>> isRequestSucceed;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Observer<r0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentListViewModel f172332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ zb3.b f172333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f172334c;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
        }

        @Override // io.reactivex.Observer
        public final void onNext(r0 r110) {
            r0 r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "t");
            if (this.f172333b.f571131b != 1) goto L5;
            boolean r100 = true;
        L7:
            if (r111.a() != 0) goto L34;
            zb3.b r112 = this.f172333b;
            if (r100 == false) goto L11;
            long r101 = r112.f571132c + 1;
        L12:
            long r102 = r101;
            Function1 r103 = this.f172334c;
            if (r103 == null) goto L15;
            Unit r113 = (Unit) r103.invoke(new zb3.a(String.valueOf(r112.f571130a), r100, r102, 8));
        L15:
            List<PromotionProductCommentDTO> r114 = this.f172332a.getCommentList().getValue();
            if (r114 == null) goto L33;
            Iterator<T> r115 = r114.iterator();
        L19:
            if (r115.hasNext() == false) goto L29;
            Object r104 = r115.next();
            Long r105 = ((PromotionProductCommentDTO) r104).getId();
            long r106 = this.f172333b.f571130a;
            if (r105 != null) goto L24;
        L26:
            boolean r107 = false;
        L27:
            if (r107 == false) goto L19;
        L30:
            PromotionProductCommentDTO r108 = (PromotionProductCommentDTO) r104;
            if (r108 == null) goto L33;
            r108.setLiked(Boolean.valueOf(r100));
            r108.setLikes(Long.valueOf(r102));
            goto L33
        L24:
            if (r105.longValue() != r106) goto L26;
            r107 = true;
            goto L27
        L29:
            r104 = null;
        L33:
            s0.a(new vb3.a(this.f172333b.f571130a, r100, r102));
            return;
        L11:
            r101 = r112.f571132c - 1;
            goto L12
        L34:
            Function1 r116 = this.f172334c;
            if (r116 == null) goto L44;
            Unit r117 = (Unit) r116.invoke(new zb3.a(String.valueOf(this.f172333b.f571130a), !r100, this.f172333b.f571132c, 8));
            return;
        L44:
            return;
        L5:
            r100 = false;
            goto L7
        }

        public b(CommentListViewModel r100, zb3.b r101, Function1 r102) {
            this.f172332a = r100;
            this.f172333b = r101;
            this.f172334c = r102;
        }
    }

    public static final class c implements Observer<CommentListResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentListViewModel f172335a;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
        }

        public c(CommentListViewModel r100) {
            this.f172335a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            CommentListViewModel.access$setLoadingComment$p(this.f172335a, false);
        }

        @Override // io.reactivex.Observer
        public final void onNext(CommentListResponse r100) {
            CommentListResponse r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            if (r101.getStatusCode() != 0) goto L11;
            xb3.c r102 = xb3.c.f563109e;
            int r103 = r101.getCursor();
            r102.getClass();
            xb3.c.f563108d = r103;
            ArrayList r104 = new ArrayList();
            List<PromotionProductCommentDTO> r105 = this.f172335a.getCommentList().getValue();
            if (r105 == null) goto L7;
            r104.addAll(r105);
        L7:
            List<PromotionProductCommentDTO> r106 = r101.getComments();
            if (r106 == null) goto L10;
            r104.addAll(r106);
        L10:
            this.f172335a.getCommentList().postValue(r104);
            this.f172335a.setHasMoreComment(r101.getHasMore());
            this.f172335a.isRequestSucceed().postValue(new Pair(Boolean.TRUE, Integer.valueOf(r104.size())));
        L12:
            CommentListViewModel.access$setLoadingComment$p(this.f172335a, false);
            return;
        L11:
            this.f172335a.isRequestSucceed().postValue(new Pair(Boolean.FALSE, 0));
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    public CommentListViewModel() {
        this.commentList = new MutableLiveData();
        this.isRequestSucceed = new MutableLiveData();
        this.hasMoreComment = true;
    }

    public final long getCommentCursor() {
        return this.commentCursor;
    }

    public final MutableLiveData<List<PromotionProductCommentDTO>> getCommentList() {
        return this.commentList;
    }

    public final int getFirstEnterCommentIndex() {
        return this.firstEnterCommentIndex;
    }

    public final boolean getHasMoreComment() {
        return this.hasMoreComment;
    }

    public final MutableLiveData<Pair<Boolean, Integer>> isRequestSucceed() {
        return this.isRequestSucceed;
    }

    public static final /* synthetic */ boolean access$isLoadingComment$p(CommentListViewModel r100) {
        return r100.isLoadingComment;
    }

    public final void loadCommentList(d r100) {
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        this.isLoadingComment = true;
        xb3.c.f563109e.getClass();
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        xb3.c.f563106b.a(r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }

    public final void setCommentCursor(long r100) {
        this.commentCursor = r100;
    }

    public final void setCommentModel(List<PromotionProductCommentDTO> r100) {
        Intrinsics.checkNotNullParameter(r100, "comments");
        this.commentList.postValue(r100);
    }

    public final void setFirstEnterCommentIndex(int r100) {
        this.firstEnterCommentIndex = r100;
    }

    public final void setHasMoreComment(boolean r100) {
        this.hasMoreComment = r100;
    }

    public static final /* synthetic */ void access$setLoadingComment$p(CommentListViewModel r100, boolean r101) {
        r100.isLoadingComment = r101;
    }

    public final void diggCommentAction(zb3.b r100, Function1<? super zb3.a, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "requestParams");
        xb3.c.f563109e.getClass();
        xb3.c.a(r100).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void diggCommentAction$default(CommentListViewModel r100, zb3.b r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.diggCommentAction(r101, r102);
    }
}
