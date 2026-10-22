package com.bytedance.android.live.messagewindow.business.card;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends v61.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f82927m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DataCenter f82928n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f82929o;

    public static final class a implements t71.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f82930a;

        @Override // t71.a
        public final Single<Boolean> a() {
            return null;
        }

        @Override // t71.a
        public final Object getIdentity() {
            return null;
        }

        @Override // t71.a
        public final void onIntercept() {
        }

        public a(d r100) {
            this.f82930a = r100;
        }

        @Override // t71.a
        public final boolean b(v61.a r100) {
            Intrinsics.checkNotNullParameter(r100, "msgWindow");
            DataCenter r101 = this.f82930a.f82928n;
            if (r101 == null) goto L11;
            IRoom r102 = a0.n(r101);
            if (r102 == null) goto L11;
            IRoomAuthStatus r103 = r102.getRoomAuthStatus();
            if (r103 == null) goto L11;
            if (r103.enableBanner() == true) goto L11;
            return true;
        L11:
            return false;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f82931a;

        public b(d r100) {
            this.f82931a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            r71.e r101 = (r71.e) r100;
            if (this.f82931a.isShowing() == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r101.f536398a.f553379j, CardTypeAndPriority.AudienceLink.getType()) == true) goto L7;
            return;
        L7:
            if (r101.f536399b != ICardLifecycle$State.Hidden) goto L12;
            this.f82931a.S();
            return;
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // v61.a
    public final void I() {
        t(new am0.a(this));
        i(new a(this));
        S();
        q71.a r100 = ((IMsgWindowService) k.n(IMsgWindowService.class)).cardStateDispatcher(this.f82928n);
        if (r100 == null) goto L9;
        q71.d r101 = r100.a();
        if (r101 == null) goto L9;
        Observable<T> r102 = r101.f531910b;
        if (r102 == 0) goto L9;
        Disposable r103 = r102.subscribe(new b(this));
    L10:
        this.f82927m = r103;
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void S() {
        CardConstraint r100 = this.f553371b;
        r100.getClass();
        CardConstraint r101 = new CardConstraint(r100);
        r101.b(CardConstraint.Position.BottomRight);
        r101.a(new PortraitBottomRightBannerCard$bottomRightConstraint$1(this));
        P(r101);
    }

    public final void T() {
        CardConstraint r100 = this.f553371b;
        r100.getClass();
        CardConstraint r101 = new CardConstraint(r100);
        r101.b(CardConstraint.Position.TopRight);
        r101.a(PortraitBottomRightBannerCard$topRightConstraint$1.INSTANCE);
        P(r101);
    }

    @Override // v61.c
    public final x61.h<?, ?> content() {
        x61.h.f562592a.getClass();
        return x61.a.f562582b;
    }

    @Override // v61.a
    public final void J() {
        super.J();
        Disposable r100 = this.f82927m;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // v61.a
    public final void K() {
        if (v71.a.b() == false) goto L8;
        View r100 = this.f82929o;
        if (r100 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r100);
        return;
    L9:
        return;
    }

    @Override // v61.a
    public final void L() {
        if (v71.a.b() == false) goto L8;
        View r100 = this.f82929o;
        if (r100 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r100);
        return;
    L9:
        return;
    }

    @Override // v61.a, r61.b
    public final DataCenter getDataCenter() {
        return this.f82928n;
    }

    public d(DataCenter r100, View r101, CardTypeAndPriority r102) {
        Intrinsics.checkNotNullParameter(r102, "cardTypeAndPriority");
        super(r100, r102.getType(), r102.getPriority());
        this.f82928n = r100;
        this.f82929o = r101;
    }
}
