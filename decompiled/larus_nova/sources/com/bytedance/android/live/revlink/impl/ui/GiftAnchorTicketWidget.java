package com.bytedance.android.live.revlink.impl.ui;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.ui.LinkGuestSendGiftView;
import com.bytedance.android.livesdk.revenue.datacenter.f;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import wq2.e;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/ui/GiftAnchorTicketWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftAnchorTicketWidget extends LiveRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkGuestSendGiftView f97627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f97628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f97629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f97630d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftAnchorTicketWidget f97631a;

        public a(GiftAnchorTicketWidget r100) {
            this.f97631a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GiftAnchorTicketWidget r101 = this.f97631a;
            IRoom r102 = r101.f97628b;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.getOwner() == null) goto L19;
            IRoom r103 = r101.f97628b;
            if (r103 == null) goto L10;
            IBaseUser r104 = r103.getOwner();
        L11:
            IBaseUser r105 = r104;
            if (r103 == null) goto L17;
            if (r105 == null) goto L18;
            ((d) vh6.c.b(d.class)).showLynxGuestContributionRankList(r101.context, r101.dataCenter, r105, r103, new HashMap());
            return;
        L18:
            return;
        L17:
            return;
        L10:
            r104 = null;
            goto L11
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftAnchorTicketWidget f97632a;

        public b(GiftAnchorTicketWidget r100) {
            this.f97632a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            GiftAnchorTicketWidget r101 = this.f97632a;
            r101.wq((List) r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget$onChanged$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(f.class, "bigPartySupportSendGift2Linker", "getBigPartySupportSendGift2Linker()Z", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Boolean.valueOf(((f) r100).c());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget$onLoad$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C99521 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new C99521();
        }

        public C99521() {
            super(f.class, "bigPartySupportSendGift2Linker", "getBigPartySupportSendGift2Linker()Z", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return Boolean.valueOf(((f) r100).c());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget$onLoad$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/ies/sdk/widgets/KVData;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<KVData, Unit> {
        public AnonymousClass2(GiftAnchorTicketWidget r100) {
            super(1, r100, GiftAnchorTicketWidget.class, "onChanged", "onChanged(Lcom/bytedance/ies/sdk/widgets/KVData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KVData r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KVData r100) {
            ((GiftAnchorTicketWidget) this.receiver).onChanged(r100);
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_base_anchor_ticket_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a154";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f97629c.clear();
        ((d) vh6.c.b(d.class)).zm(this.f97630d);
    }

    public GiftAnchorTicketWidget() {
        this.f97629c = new CompositeDisposable();
        this.f97630d = new b(this);
    }

    public final void onChanged(KVData r100) {
        KProperty1<f, ? extends Object> r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r102 = ((wq2.d) vh6.c.b(wq2.d.class)).kb(r101);
        if (r100 == null) goto L5;
        String r103 = r100.getKey();
    L7:
        if (Intrinsics.areEqual(r102, r103) == false) goto L12;
        ox0.a r104 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r104 == null) goto L13;
        r104.a();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f97627a = (LinkGuestSendGiftView) this.containerView.findViewById(R.id.online_fans_ticket_count);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        k r101 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        Observable<KVData> r102 = null;
        if (r101 == null) goto L5;
        IRoom r103 = r101.getRoom();
    L6:
        this.f97628b = r103;
        ox0.a r104 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r104 == null) goto L9;
        r104.a();
    L9:
        LinkGuestSendGiftView r105 = this.f97627a;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L12:
        r105.setAllowSendGift(false);
        boolean r106 = e.b().c();
        LinkGuestSendGiftView r107 = this.f97627a;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L15:
        r107.setAllowSendGift(r106);
        ((d) vh6.c.b(d.class)).wj(this.f97630d);
        KProperty1<f, ? extends Object> r108 = C99521.INSTANCE;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(f.class), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.revenue.datacenter.e.class)) == false) goto L19;
        r102 = ((wq2.d) vh6.c.b(wq2.d.class)).ah().a(r108);
    L21:
        if (r102 == null) goto L25;
        final AnonymousClass2 r109 = new AnonymousClass2(this);
        Disposable r110 = r102.subscribe(new c(r109));
        if (r110 == null) goto L25;
        RxUtilKt.c(r110, this.f97629c);
    L25:
        wq(((d) vh6.c.b(d.class)).getOnlineList());
        this.containerView.setOnClickListener(new a(this));
        return;
    L19:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(f.class), Reflection.getOrCreateKotlinClass(f.class)) == false) goto L21;
        r102 = ((wq2.d) vh6.c.b(wq2.d.class)).m9().a(r108);
        goto L21
    L5:
        r103 = null;
        goto L6
    }

    public final void wq(List<com.bytedance.android.livesdk.revenue.service.interact.a> r100) {
        if (r100.isEmpty() == false) goto L9;
        LinkGuestSendGiftView r101 = this.f97627a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L7:
        r101.setAllowSendGift(false);
        return;
    L9:
        ox0.a r102 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r102 == null) goto L12;
        r102.a();
    L12:
        LinkGuestSendGiftView r103 = this.f97627a;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L15:
        r103.setAllowSendGift(false);
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        onChanged((KVData) r100);
    }
}
