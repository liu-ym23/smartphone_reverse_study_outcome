package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.config.nm0;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class RecommendToFriendsAction extends OptionAction {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f122051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f122052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ActionsManager f122053g;

    public static final class a implements ILiveRecommendToFriendsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendToFriendsAction f122054a;

        @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
        public final void onFailed() {
            f2.b(R.string.ttlive_toast_recommend_to_friends_fail, 0);
        }

        public a(RecommendToFriendsAction r100) {
            this.f122054a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
        public final void onLiveRecommendSuccess(long r100) {
            int r101 = RecommendLiveHelper.f122216a;
            RecommendLiveHelper.l(this.f122054a.f122052f);
            if (RecommendLiveHelper.e() == false) goto L13;
            boolean r102 = !RecommendLiveHelper.f();
            xs2.b r103 = xs2.b.a();
            com.bytedance.android.livesdk.dislike.m r104 = this.f122054a.f122053g.f121950c;
            if (r104 == null) goto L8;
            String r105 = r104.a();
            if (r105 == null) goto L8;
        L9:
            r103.post(new mt1.c(r102, r105));
            if (r102 == false) goto L25;
            RecommendLiveHelper.k();
            return;
        L25:
            return;
        L8:
            r105 = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
            goto L9
        L13:
            if (nm0.f120845a.getValue().booleanValue() == true) goto L15;
            f2.b(R.string.ttlive_toast_recommend_to_friends_success, 0);
            return;
        L15:
            if (RecommendLiveHelper.f() == true) goto L20;
            String r106 = mm0.f120768a.getValue().getFirstRecommendSuccessToast();
            if (r106 == null) goto L19;
            f2.c(r106, 0);
        L19:
            RecommendLiveHelper.k();
            return;
        L20:
            String r107 = mm0.f120768a.getValue().getRecommendSuccessToast();
            if (r107 == null) goto L28;
            f2.c(r107, 0);
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
        public final void onSuccess(long r100) {
            int r101 = RecommendLiveHelper.f122216a;
            RecommendLiveHelper.l(this.f122054a.f122052f);
            f2.b(R.string.ttlive_toast_recommend_to_friends_success, 0);
            long r102 = this.f122054a.f122052f;
            ILiveRecommendToFriendsService r103 = RecommendLiveHelper.d();
            if (r103 == null) goto L6;
            r103.postRecommendEvent(r102, true);
            return;
        }
    }

    public static final class b implements ILiveRecommendToFriendsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendToFriendsAction f122055a;

        @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
        public final void onFailed() {
            f2.b(R.string.ttlive_toast_recommend_to_friends_fail, 0);
        }

        public b(RecommendToFriendsAction r100) {
            this.f122055a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
        public final void onLiveRecommendSuccess(long r100) {
            int r101 = RecommendLiveHelper.f122216a;
            long r102 = this.f122055a.f122052f;
            ILiveRecommendToFriendsService r103 = RecommendLiveHelper.d();
            if (r103 == null) goto L5;
            r103.removeRoomRecommended(r102);
        L5:
            f2.b(R.string.ttlive_toast_recommend_to_friends_cancel, 0);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
        public final void onSuccess(long r100) {
            int r101 = RecommendLiveHelper.f122216a;
            long r102 = this.f122055a.f122052f;
            ILiveRecommendToFriendsService r103 = RecommendLiveHelper.d();
            if (r103 == null) goto L5;
            r103.removeRoomRecommended(r102);
        L5:
            f2.b(R.string.ttlive_toast_recommend_to_friends_cancel, 0);
            long r104 = this.f122055a.f122052f;
            ILiveRecommendToFriendsService r105 = RecommendLiveHelper.d();
            if (r105 == null) goto L9;
            r105.postRecommendEvent(r104, false);
            return;
        }
    }

    public RecommendToFriendsAction(ActionsManager r100) {
        Intrinsics.checkNotNullParameter(r100, "actionsManager");
        super(r100);
        this.f122053g = r100;
        Room r101 = this.f122048b;
        if (r101 == null) goto L5;
        long r102 = r101.getRoomId();
    L6:
        this.f122052f = r102;
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        if (com.bytedance.android.livesdk.config.setting.l.c() == false) goto L5;
        int r111 = RecommendLiveHelper.f122216a;
        this.f122051e = RecommendLiveHelper.g(this.f122052f);
    L5:
        String r100 = "0";
        if (this.f122051e == true) goto L32;
        int r112 = RecommendLiveHelper.f122216a;
        ILiveRecommendToFriendsService r113 = RecommendLiveHelper.d();
        if (r113 == null) goto L10;
        boolean r114 = r113.isFirstRecommend();
    L11:
        if (r114 == false) goto L20;
        xs2.b r115 = xs2.b.a();
        long r101 = this.f122052f;
        com.bytedance.android.livesdk.dislike.m r102 = this.f122053g.f121950c;
        if (r102 == null) goto L16;
        String r103 = r102.a();
        if (r103 == null) goto L16;
    L17:
        r115.post(new mt1.b(r101, r103));
        ILiveRecommendToFriendsService r116 = RecommendLiveHelper.d();
        if (r116 == null) goto L48;
        r116.setIsFirstRecommend();
        return;
    L48:
        return;
    L16:
        r103 = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
        goto L17
    L20:
        Room r117 = this.f122048b;
        com.bytedance.android.livesdk.dislike.m r104 = this.f122053g.f121950c;
        if (r104 == null) goto L23;
        String r105 = r104.a();
    L24:
        RecommendLiveHelper.h(r117, "shared", null, r105, 4);
        long r106 = this.f122052f;
        Room r118 = this.f122048b;
        if (r118 == null) goto L30;
        String r119 = r118.getOwnerUserIdString();
        if (r119 == null) goto L30;
        String r107 = r119;
    L31:
        RecommendLiveHelper.j(r106, r107, new a(this), "RecommendToFriendsAction", RecommendLiveHelper.e(), this.f122053g.f121953f);
        return;
    L30:
        r107 = "0";
        goto L31
    L23:
        r105 = null;
        goto L24
    L10:
        r114 = true;
        goto L11
    L32:
        int r120 = RecommendLiveHelper.f122216a;
        Room r121 = this.f122048b;
        com.bytedance.android.livesdk.dislike.m r108 = this.f122053g.f121950c;
        if (r108 == null) goto L35;
        String r109 = r108.a();
    L36:
        RecommendLiveHelper.h(r121, "not_shared", null, r109, 4);
        Room r122 = this.f122053g.f121951d;
        if (r122 == null) goto L39;
        long r123 = r122.getRoomId();
    L40:
        Room r124 = this.f122048b;
        if (r124 == null) goto L46;
        String r125 = r124.getOwnerUserIdString();
        if (r125 == null) goto L46;
        r100 = r125;
    L46:
        RecommendLiveHelper.a(r123, r100, new b(this), "RecommendToFriendsAction");
        return;
    L39:
        r123 = 0;
        goto L40
    L35:
        r109 = null;
        goto L36
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void d(Function1<? super Map<String, ? extends Object>, Unit> r100) {
        int r101 = RecommendLiveHelper.f122216a;
        Disposable r102 = RecommendLiveHelper.c(this.f122052f, new RecommendToFriendsAction$onShow$1(this, r100), "RecommendToFriendsAction");
        if (r102 == null) goto L5;
        RxUtilKt.c(r102, (CompositeDisposable) this.f122049c.getValue());
    L5:
        Room r103 = this.f122048b;
        if (RecommendLiveHelper.g(this.f122052f) == false) goto L8;
        String r104 = "shared";
    L9:
        RecommendLiveHelper.i(r103, r104, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, null);
        return;
    L8:
        r104 = "not_shared";
        goto L9
    }
}
