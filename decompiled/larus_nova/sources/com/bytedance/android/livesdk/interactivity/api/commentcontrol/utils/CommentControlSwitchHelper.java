package com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.api.CommentControlRetrofitApi;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class CommentControlSwitchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<Long> f133089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e<Long> f133090b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BaseDisplayText f133091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static AdvancedDisplayText f133092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b f133093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Disposable f133094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Disposable f133095g;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/utils/CommentControlSwitchHelper$AdvancedDisplayText;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/a;", "text", "", "updateAdvancedDisplayText", "Landroidx/lifecycle/MutableLiveData;", "_advancedDisplayText", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "getAdvancedDisplayText", "()Landroidx/lifecycle/LiveData;", "advancedDisplayText", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AdvancedDisplayText extends ViewModel {
        private final MutableLiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> _advancedDisplayText;

        public AdvancedDisplayText() {
            this._advancedDisplayText = new MutableLiveData();
        }

        public final LiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> getAdvancedDisplayText() {
            return this._advancedDisplayText;
        }

        public final void updateAdvancedDisplayText(com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this._advancedDisplayText.setValue(r100);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/utils/CommentControlSwitchHelper$BaseDisplayText;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/a;", "text", "", "updateBaseDisplayText", "Landroidx/lifecycle/MutableLiveData;", "_baseDisplayText", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "getBaseDisplayText", "()Landroidx/lifecycle/LiveData;", "baseDisplayText", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BaseDisplayText extends ViewModel {
        private final MutableLiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> _baseDisplayText;

        public BaseDisplayText() {
            this._baseDisplayText = new MutableLiveData();
        }

        public final LiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> getBaseDisplayText() {
            return this._baseDisplayText;
        }

        public final void updateBaseDisplayText(com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this._baseDisplayText.setValue(r100);
        }
    }

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f133096a = null;

        static {
            f133096a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            if (r101 == null) goto L8;
            com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r102 = (com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b) r101.data;
            if (r102 == null) goto L9;
            CommentControlSwitchHelper.f133093e = r102;
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f133097a = null;

        static {
            f133097a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "e");
            CommentControlSwitchHelper.f133093e = null;
            ALogger.w("CommentControlSwitchHelper", "fetchCommentControlStatus error " + r101.getMessage());
        }
    }

    static {
        f133089a = new e("live_comment_control_base_reddot", 0L);
        f133090b = new e("live_comment_control_advanced_reddot", 0L);
        f133093e = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    }

    @JvmStatic
    public static final long b() {
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r100 = f133093e;
        if (r100 != null) goto L6;
        r100 = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    L6:
        return r100.b();
    }

    @JvmStatic
    public static final Long c() {
        long r100 = b();
        if (r100 != 0) goto L6;
        return f133089a.getValue();
    L6:
        if (r100 == 1) goto L11;
        return null;
    L11:
        return f133090b.getValue();
    }

    @JvmStatic
    public static final void d() {
        long r100 = b();
        if (r100 != 0) goto L6;
        e<Long> r101 = f133089a;
        r101.getClass();
        f.d(r101, 1L);
        return;
    L6:
        if (r100 != 1) goto L10;
        e<Long> r102 = f133090b;
        r102.getClass();
        f.d(r102, 1L);
        return;
    }

    public static void a(long r100) {
        f133094f = ((CommentControlRetrofitApi) c.b().e(CommentControlRetrofitApi.class)).getCommentControlStatusRequest(r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(a.f133096a, b.f133097a);
    }
}
