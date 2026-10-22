package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
public final class SeatAnimManager implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, SeatAnimationView> f72201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f72202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends za> f72203c;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/za;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/message/model/za;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    final class AnonymousClass1 extends Lambda implements Function0<za> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final za invoke() {
            IKtvService r100 = (IKtvService) jc1.k.f(IKtvService.class);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.ktvCurrentSingerOrderInfo();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ za invoke() {
            return invoke();
        }
    }

    public SeatAnimManager(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "singerOrderInfoProvider");
        this.f72203c = r100;
        this.f72201a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.e
    public final void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof b) == false) goto L8;
        b r101 = (b) r100;
        if (f(r101.f72215c) == false) goto L9;
        g(r101.f72215c);
        ALogger.d("SeatAnimManager", "#GuestBattleDebug# [onTaskStart] GuestBattle Anim coming, stop Emoji");
        return;
    L9:
        return;
    }

    public final void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        InteractAnimationContext.a r101 = InteractAnimationContext.Companion;
        InteractAnimationController r102 = r101.a();
        if (r102 != null) goto L5;
    L6:
        InteractAnimationController r103 = r101.a();
        if (r103 != null) goto L9;
    L10:
        InteractAnimationController r104 = r101.a();
        if (r104 != null) goto L13;
    L15:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f71316f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r105 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C1150a.a();
        if (r105 != null) goto L18;
    L20:
        String r106 = r100.f72212a.f559921a.getIdString();
        if (TextUtils.isEmpty(r106) == false) goto L23;
        r106 = String.valueOf(r100.f72212a.f559921a.getIdString());
    L23:
        SeatAnimationView r107 = (SeatAnimationView) ((LinkedHashMap) this.f72201a).get(r106);
        if (r107 == null) goto L26;
        SeatAnimTaskState r108 = r107.getTaskState();
    L27:
        if (r108 != null) goto L29;
        return;
    L29:
        if (r108 != SeatAnimTaskState.LINK_SUC_ANIM) goto L31;
        return;
    L31:
        if (r108 != SeatAnimTaskState.REVENUE_DRESS_ANIM) goto L33;
        return;
    L33:
        if (r108 == SeatAnimTaskState.THEMED_COMPETITION_ANIM) goto L48;
        SeatAnimationView r109 = (SeatAnimationView) ((LinkedHashMap) this.f72201a).get(r106);
        if (r109 == null) goto L46;
        Intrinsics.checkNotNullParameter(r100, "event");
        v r110 = r109.f72414a;
        if (r110 == null) goto L47;
        r110.c(r100);
        return;
    L47:
        return;
    L46:
        return;
    L48:
        return;
    L26:
        r108 = null;
        goto L27
    L18:
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r105) != true) goto L20;
        return;
    L13:
        if (r104.k(3) != true) goto L15;
        return;
    L9:
        if (r103.k(2) != true) goto L10;
        return;
    L5:
        if (r102.k(1) != true) goto L6;
    }

    public final void d(za r100) {
        if (r100 != null) goto L8;
        Iterator r101 = ((LinkedHashMap) this.f72201a).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L19;
        ((SeatAnimationView) ((Map.Entry) r101.next()).getValue()).a(new h(false));
        goto L6
    L19:
        return;
    L8:
        Iterator r102 = ((LinkedHashMap) this.f72201a).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L27;
        Map.Entry r103 = (Map.Entry) r102.next();
        Intrinsics.checkNotNullParameter(r100, "$this$topUserFlex");
        b8 r104 = r100.getTopUser();
        if (r104 == null) goto L14;
        String r105 = n8.b(r104);
    L16:
        if (Intrinsics.areEqual(r105, (String) r103.getKey()) == true) goto L17;
        ((SeatAnimationView) r103.getValue()).a(new h(false));
        goto L10
    L17:
        ((SeatAnimationView) r103.getValue()).a(new h(true));
        goto L10
    L14:
        r105 = null;
        goto L16
    }

    public final boolean f(String r100) {
        if (r100 == null) goto L13;
        SeatAnimationView r101 = (SeatAnimationView) ((LinkedHashMap) this.f72201a).get(r100);
        if (r101 == null) goto L11;
        DynamicEmojiView r102 = r101.f72418e;
        if (r102 != null) goto L10;
        return false;
    L10:
        return !(r102.f112133b.f559929a instanceof wj0.c.b);
    L11:
        return false;
    L13:
        return false;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        SeatAnimationView r101 = (SeatAnimationView) ((LinkedHashMap) this.f72201a).get(r100);
        if (r101 == null) goto L10;
        DynamicEmojiView r102 = r101.f72418e;
        if (r102 == null) goto L11;
        wj0.b r103 = r102.f112133b.a();
        if (r103 == null) goto L12;
        r102.f112133b.b(new wj0.a.C8118a(r103));
        return;
    L12:
        return;
    L11:
        return;
    }

    public SeatAnimManager(int r100) {
        this(AnonymousClass2.INSTANCE);
    }

    public final void e(String r100, SeatAnimationView r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f72201a.put(r100.toString(), r101);
        LinkSucAnimationView r102 = r101.f72417d;
        if (r102 == null) goto L5;
        r102.f72391h = false;
    L5:
        r101.setSeatAnimTaskListener(this);
        za r103 = this.f72203c.invoke();
        if (r103 == null) goto L15;
        Intrinsics.checkNotNullParameter(r103, "$this$topUserFlex");
        b8 r104 = r103.getTopUser();
        if (r104 == null) goto L10;
        String r105 = n8.b(r104);
    L12:
        if (Intrinsics.areEqual(r105, r100) == false) goto L16;
        d(r103);
        return;
    L16:
        return;
    L10:
        r105 = null;
        goto L12
    }

    public final void c(a r110, w8 r111, ViewGroup r112, View r113) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "message");
        Intrinsics.checkNotNullParameter(r112, KtvSubElement.CONTAINER);
        InteractAnimationContext.a r100 = InteractAnimationContext.Companion;
        InteractAnimationController r101 = r100.a();
        if (r101 != null) goto L5;
    L6:
        InteractAnimationController r102 = r100.a();
        if (r102 != null) goto L9;
    L10:
        InteractAnimationController r103 = r100.a();
        if (r103 != null) goto L13;
    L15:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f71316f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r104 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C1150a.a();
        if (r104 == null) goto L21;
        if (com.bytedance.android.live.liveinteract.animation.universalwidget.a.b.a(r104) != true) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r110.f72212a.f559921a.getIdString()) == false) goto L23;
        r110.f72212a.f559921a.getIdString();
    L23:
        HSImageView r105 = (HSImageView) r112.findViewWithTag("emoj_animate_view");
        if (r113 == null) goto L35;
        int r106 = r113.getWidth();
        Intrinsics.checkNotNullParameter(r113, "targetView");
        Intrinsics.checkNotNullParameter(r112, "relativeToView");
        int[] r107 = new int[2];
        int[] r108 = new int[2];
        r113.getLocationOnScreen(r107);
        r112.getLocationOnScreen(r108);
        int r109 = r107[0] - r108[0];
        int r114 = r107[1] - r108[1];
        if (r105 != null) goto L29;
        ViewGroup.LayoutParams r115 = new ViewGroup.LayoutParams(r106, r106);
        HSImageView r116 = new HSImageView(r112.getContext());
        r116.setLayoutParams(r115);
        r116.setTag("emoj_animate_view");
        r112.addView(r116, r115);
        r116.measure(View.MeasureSpec.makeMeasureSpec(r106, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        r116.layout(r109, r114, r109 + r106, r106 + r114);
        r116.invalidate();
        r105 = r116;
    L29:
        if (r110.f72212a.f559922b.isRandomEmoji == false) goto L31;
        Intrinsics.checkNotNullParameter(r105, "animateView");
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "message");
        this.f72202b = Observable.create(new SeatAnimManager$handleResultEmoji$1(r105, r110)).doOnNext(new r(r105, r110)).concatMap(new s(r110)).doOnComplete(new t(r105)).doOnError(new u(r105)).subscribe();
        return;
    L31:
        Intrinsics.checkNotNullParameter(r105, "animateView");
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "message");
        r105.post(new q(r105, r110, r111));
        return;
    L35:
        return;
    L13:
        if (r103.k(3) != true) goto L15;
        return;
    L9:
        if (r102.k(2) != true) goto L10;
        return;
    L5:
        if (r101.k(1) != true) goto L6;
    }
}
