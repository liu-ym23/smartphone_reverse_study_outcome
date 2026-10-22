package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.x0;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.lark.thirdshare.base.export.ShareAnswerType;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import sg2.z;

/* JADX INFO: loaded from: classes10.dex */
public final class StartLivePromotionButton extends ak2.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f152785j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f152786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.a f152787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f152788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f152789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f152790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<wd.f, wd.e, ECExternalViewGroupAction, Unit> f152791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f152792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.api.e f152793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<com.bytedance.android.ec.adapter.api.state.c> f152794i;

    public static final class a extends ObservableProperty<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f152795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StartLivePromotionButton f152796b;

        public a(Object r100, Object r101, StartLivePromotionButton r102) {
            this.f152795a = r100;
            this.f152796b = r102;
            super(r101);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Integer r101, Integer r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            int r103 = r102.intValue();
            r101.intValue();
            StartLivePromotionButton.u(this.f152796b);
            if (r103 <= 0) goto L16;
            com.bytedance.android.livesdk.livecommerce.room.api.a r104 = this.f152796b.f152787b;
            if (r104 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
        L7:
            r104.a(this.f152796b);
            return;
        L16:
            com.bytedance.android.livesdk.livecommerce.room.api.a r105 = this.f152796b.f152787b;     // Catch: Exception -> L13
            if (r105 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");     // Catch: Exception -> L13
        L11:
            r105.b(this.f152796b);     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }
    }

    public static final class b extends ObservableProperty<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f152797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StartLivePromotionButton f152798b;

        public b(Object r100, Object r101, StartLivePromotionButton r102) {
            this.f152797a = r100;
            this.f152798b = r102;
            super(r101);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> r100, Boolean r101, Boolean r102) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            r102.booleanValue();
            r101.booleanValue();
            StartLivePromotionButton.u(this.f152798b);
        }
    }

    public static final class c implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StartLivePromotionButton f152799a;

        public c(StartLivePromotionButton r100) {
            this.f152799a = r100;
        }

        @Override // sg2.z
        public final void a(int r100) {
            StartLivePromotionButton r101 = this.f152799a;
            r101.f152789d.setValue(r101, StartLivePromotionButton.f152785j[0], Integer.valueOf(r100));
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StartLivePromotionButton f152800a;

        public d(StartLivePromotionButton r100) {
            this.f152800a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            StartLivePromotionButton r101 = this.f152800a;
            int r102 = ((wk.d) r100).f560066a;
            r101.f152789d.setValue(r101, StartLivePromotionButton.f152785j[0], Integer.valueOf(r102));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f152801a = null;

        static {
            f152801a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (r101 == null) goto L6;
            r101.getMessage();
            return;
        }
    }

    static {
        f152785j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartLivePromotionButton.class, "selectedCount", "getSelectedCount()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartLivePromotionButton.class, ShareAnswerType.BAN, "getBan()Z", 0))};
    }

    public final View v() {
        return (View) this.f152786a.getValue();
    }

    public final CompositeDisposable w() {
        return (CompositeDisposable) this.f152788c.getValue();
    }

    public final int x() {
        return this.f152789d.getValue(this, f152785j[0]).intValue();
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return v();
    }

    @Override // ak2.b, wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        super.onLoad();
        com.bytedance.android.livesdk.livecommerce.room.api.e r100 = this.f152793h;
        xd.g r101 = xd.g.f563267a;
        this.f152787b = r100.F();
        if (w().isDisposed() == true) goto L5;
        w().clear();
    L5:
        c r102 = new c(this);
        if (this.f152794i.invoke() == null) goto L8;
        com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.d r103 = new com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.d(r102);
        String r104 = vi2.h.f555073a;
        final String r105 = si2.g.f542159i;
        Disposable r106 = vi2.h.e(null, null, r105, new vi2.f(r105)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.e(r103), new f(r103));
        w().add(r106);
    L8:
        w().add(x0.a().f153122a.ofType(wk.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.f152801a));
    }

    @Override // ak2.b, wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        super.onUnload();
        if (w().isDisposed() == true) goto L6;
        w().clear();
        return;
    }

    @Override // ak2.b, wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        super.onViewDetached();
        com.bytedance.android.livesdk.livecommerce.room.api.a r100 = this.f152787b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
    L5:
        r100.d(this.f152791f);
    }

    public static final void u(StartLivePromotionButton r100) {
        if (r100.x() <= 0) goto L10;
        TextView r101 = (TextView) r100.v().findViewById(R.id.tv_commerce_count);
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        TextView r102 = (TextView) r100.v().findViewById(R.id.tv_commerce_count);
        if (r102 == null) goto L14;
        r102.setText(String.valueOf(r100.x()));
    L14:
        if (r100.f152790e.getValue(r100, f152785j[1]).booleanValue() == false) goto L16;
        r100.v().setAlpha(0.5f);
    L17:
        Object r103 = r100.v().getTag();
        if (TypeIntrinsics.isFunctionOfArity(r103, 1) == true) goto L20;
        r103 = null;
    L20:
        Function1 r104 = (Function1) r103;
        if (r104 == null) goto L24;
        Unit r105 = (Unit) r104.invoke(Integer.valueOf(r100.x()));
        return;
    L24:
        return;
    L16:
        r100.v().setAlpha(1.0f);
        goto L17
    L10:
        TextView r106 = (TextView) r100.v().findViewById(R.id.tv_commerce_count);
        if (r106 == null) goto L14;
        r106.setVisibility(8);
        goto L14
    }

    @Override // ak2.b, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        super.onViewAttached(r100);
        ViewGroup.LayoutParams r101 = v().getLayoutParams();
        r101.height = -1;
        r101.width = -1;
        v().setLayoutParams(r101);
        v().requestLayout();
    }

    @Override // ak2.b, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        com.bytedance.android.livesdk.livecommerce.room.api.a r101 = this.f152787b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
    L5:
        r101.c(this.f152791f);
    }

    @Override // ak2.b, wd.e
    public final void onViewAttached(wd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        super.onViewAttached(r100);
        ViewGroup.LayoutParams r101 = v().getLayoutParams();
        r101.height = -1;
        r101.width = -1;
        v().setLayoutParams(r101);
        v().requestLayout();
    }

    @Override // ak2.b, wd.e
    public final void onViewWillAttach(wd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        com.bytedance.android.livesdk.livecommerce.room.api.a r101 = this.f152787b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
    L5:
        r101.c(this.f152791f);
    }

    public StartLivePromotionButton(Context r100, com.bytedance.android.livesdk.livecommerce.room.api.e r101, Function0<com.bytedance.android.ec.adapter.api.state.c> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "param");
        this.f152792g = r100;
        this.f152793h = r101;
        this.f152794i = r102;
        this.f152786a = LazyKt.lazy(new StartLivePromotionButton$buttonView$2(this));
        this.f152788c = LazyKt.lazy(StartLivePromotionButton$disposables$2.INSTANCE);
        int r103 = ECContextContainer.f151896b;
        ECContextContainer.a.b();
        Delegates r104 = Delegates.INSTANCE;
        this.f152789d = new a(0, 0, this);
        Boolean r105 = Boolean.FALSE;
        this.f152790e = new b(r105, r105, this);
        this.f152791f = new StartLivePromotionButton$listenerV1$1(this);
    }
}
