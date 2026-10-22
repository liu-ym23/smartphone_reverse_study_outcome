package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.g2;
import com.bytedance.android.livesdk.interactivity.api.comment.datacontext.CommentContext;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/DigAccessibilityWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Landroidx/core/view/accessibility/AccessibilityManagerCompat$TouchExplorationStateChangeListener;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DigAccessibilityWidget extends RoomRecyclableWidget implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f137466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f137467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MotionEvent f137468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f137469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject<Integer> f137470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f137471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f137472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f137473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f137474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f137475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f137476k;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DigAccessibilityWidget f137477a;

        public a(DigAccessibilityWidget r100) {
            this.f137477a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            DigAccessibilityWidget r111 = this.f137477a;
            if (r111.f137469d == true) goto L5;
            return;
        L5:
            MotionEvent r100 = r111.f137468c;
            DiggContext.a r101 = DiggContext.Companion;
            DataCenter r102 = r111.dataCenter;
            r101.getClass();
            DiggContext r103 = DiggContext.a.a(r102);
            if (r103 == null) goto L10;
            com.bytedance.live.datacontext.n<u32.k> r104 = r103.getDiggWidget();
            if (r104 == null) goto L10;
            u32.k r105 = r104.getValue();
        L11:
            u32.k r112 = r105;
            if (r100 == null) goto L25;
            if (r112 == null) goto L25;
            if (r111.f137467b != 0) goto L19;
            u32.k.a.a(r112, r100, r111.f137475j.longValue(), null, false, false, false, 60);
        L19:
            if (u32.k.a.a(r112, r100, r111.f137475j.longValue(), null, false, false, false, 60) == false) goto L24;
            int r106 = r111.f137467b + 1;
            r111.f137467b = r106;
            r111.f137470e.onNext(Integer.valueOf(r106));
            Disposable r107 = r111.f137471f;
            if (r107 == null) goto L23;
            r107.dispose();
        L23:
            r111.f137471f = ((ObservableSubscribeProxy) Observable.timer(r111.f137475j.longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(r111.autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.like.a(r111), new com.bytedance.android.livesdk.interactivity.like.b(r111));
            return;
        L24:
            r111.xq();
            return;
        L25:
            r111.xq();
            return;
        L10:
            r105 = null;
            goto L11
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DigAccessibilityWidget f137478a;

        public b(DigAccessibilityWidget r100) {
            this.f137478a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            DigAccessibilityWidget r102 = this.f137478a;
            r102.onTouchExplorationStateChanged(r102.f137469d);
        }
    }

    public static final class c<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f137479a = null;

        static {
            f137479a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DigAccessibilityWidget f137480a;

        public d(DigAccessibilityWidget r100) {
            this.f137480a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            ExceptionUtils.handleException(this.f137480a.context, r101);
            return CollectionsKt.emptyList();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DigAccessibilityWidget f137481a;

        public e(DigAccessibilityWidget r100) {
            this.f137481a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.size() == 0) goto L16;
            Context r102 = this.f137481a.context;
            if (r102 != null) goto L10;
            return;
        L10:
            if (r3.l(r102) == false) goto L15;
            r3.q(this.f137481a.context, "点赞" + ((Integer) CollectionsKt.last(r101)) + 27425);
            return;
        L15:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f137482a = null;

        static {
            f137482a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SafetyGuard.a(null, (Throwable) r100, "DigAnnounce Error");
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_dig_accessiblilty;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        r3.o(this.context, this);
        MotionEvent r100 = this.f137468c;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        Disposable r101 = this.f137471f;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f137471f = null;
        Disposable r102 = this.f137472g;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f137472g = null;
        Disposable r103 = this.f137473h;
        if (r103 == null) goto L14;
        r103.dispose();
    L14:
        this.f137473h = null;
        this.f137466a = null;
        xq();
    }

    public final boolean wq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L11;
        Room r101 = com.bytedance.android.live.core.utils.z.o(r100);
        if (r101 == null) goto L11;
        RoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 == null) goto L11;
        if (r102.getEnableDigg() == true) goto L11;
    L18:
        return true;
    L11:
        if (l42.a.f507320g.getValue().booleanValue() == true) goto L15;
        if (com.bytedance.android.livesdk.sharedpref.b.G0.getValue().booleanValue() == true) goto L15;
        return false;
    L15:
        if (isScreenPortrait() == false) goto L17;
        return false;
    L17:
        if (com.bytedance.android.live.core.utils.z.e(this.dataCenter, false) == false) goto L18;
        return false;
    }

    public final void xq() {
        this.f137470e.onNext(Integer.valueOf(this.f137467b));
        this.f137467b = 0;
    }

    public DigAccessibilityWidget() {
        this.f137470e = PublishSubject.create();
        this.f137474i = 1;
        this.f137475j = g2.f120250a.getValue();
        this.f137476k = new a(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        CommentContext.a r101 = CommentContext.Companion;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        CommentContext r103 = CommentContext.a.a(r102);
        Disposable r104 = null;
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.n<FrameLayout> r105 = r103.getInteractionRootView();
        if (r105 == null) goto L9;
        FrameLayout r106 = r105.getValue();
        if (r106 == null) goto L9;
        r106.setImportantForAccessibility(1);
        r106.setFocusable(true);
        r106.setOnClickListener(this.f137476k);
        Unit r107 = Unit.INSTANCE;
    L10:
        this.f137466a = r106;
        RoomContext r108 = getRoomContext();
        if (r108 == null) goto L17;
        com.bytedance.live.datacontext.m<Boolean> r109 = r108.isCleanMode();
        if (r109 == null) goto L17;
        Observable<Boolean> r110 = r109.a();
        if (r110 == null) goto L17;
        r104 = r110.subscribe(new b(this));
    L17:
        this.f137473h = r104;
        UIUtils.setViewVisibility(findViewById(R.id.dig_area), 8);
        onTouchExplorationStateChanged(r3.l(this.context));
        this.f137468c = MotionEvent.obtain(0, 0, 0, s1.y() / 2, s1.w() / 2, 0);
        r3.f(this.context, this);
        Completable r111 = nd1.a.f518752b;
        if (r111 != null) goto L21;
        r111 = Completable.complete();
    L21:
        ((com.bytedance.android.live.core.utils.rxutils.autodispose.u) r111.as(autoDispose())).a(new AnonymousClass3(this));
        onTouchExplorationStateChanged(this.f137469d);
        return;
    L9:
        r106 = null;
        goto L10
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean r100) {
        boolean r101 = true;
        if (r100 == true) goto L5;
    L18:
        View r102 = this.f137466a;
        if (r102 == null) goto L21;
        r102.setImportantForAccessibility(0);
        r102.setFocusable(false);
        r102.setOnClickListener(null);
        r102.clearFocus();
        r102.setClickable(false);
    L21:
        Disposable r103 = this.f137472g;
        if (r103 == null) goto L24;
        r103.dispose();
    L24:
        this.f137472g = null;
    L25:
        if (r100 == true) goto L27;
    L29:
        r101 = false;
    L30:
        this.f137469d = r101;
        return;
    L27:
        if (wq() == true) goto L29;
    L5:
        if (wq() == true) goto L18;
        View r104 = this.f137466a;
        if (r104 == null) goto L17;
        RoomContext r105 = getRoomContext();
        if (r105 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.isCleanMode();
        if (r106 == null) goto L16;
        if (r106.getValue().booleanValue() != true) goto L16;
        r104.setImportantForAccessibility(0);
        r104.setFocusable(false);
        r104.setOnClickListener(null);
        r104.setClickable(false);
        r104.clearFocus();
    L16:
        r104.setImportantForAccessibility(1);
        r104.setFocusable(true);
        r104.setOnClickListener(this.f137476k);
        r104.setClickable(true);
    L17:
        this.f137472g = ((du2.a) this.f137470e.as(new du2.b())).a(this.f137474i, TimeUnit.SECONDS).filter(c.f137479a).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new d(this)).subscribe(new e(this), f.f137482a);
        goto L25
    }
}
