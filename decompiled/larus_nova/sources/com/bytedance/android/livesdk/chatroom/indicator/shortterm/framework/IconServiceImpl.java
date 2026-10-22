package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.DisposableObserverDelegate;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.ShortTermIndicatorUtils;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.TiltedTempIconTemplate;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.k;
import com.bytedance.android.livesdk.config.zr0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.android.livesdkapi.sti.ITempShortTermManager;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature;
import com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IIconService;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.Instantiable;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.CompletableSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
public final class IconServiceImpl<STATE> implements IIconService<STATE>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f106583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableSubject f106584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompletableSubject f106585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f106586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f106587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MiddlewareRoomContext f106588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IShortTermIndicatorManager f106589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f106590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f106591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public STATE f106592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f106593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IconTemplate f106594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IIconModel.EntryView f106595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f106596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f106597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f106598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f106599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f106600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Observable<Long> f106601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Long f106602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final IIconModel<STATE> f106603u;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IconServiceImpl f106604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f106605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f106606c;

        public a(IconServiceImpl r100, Function1 r101, Object r102) {
            this.f106604a = r100;
            this.f106605b = r101;
            this.f106606c = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f106604a.f106602t = r101;
            long r102 = MathKt.roundToLong(r101.longValue() / 1000);
            IconTemplate r103 = this.f106604a.f106594l;
            if ((r103 instanceof ICommonTemplateFeature) == false) goto L6;
            ((ICommonTemplateFeature) r103).setLabel((String) this.f106605b.invoke(Long.valueOf(Math.max(r102, 0))));
        L6:
            if (zr0.f121787a.getValue().booleanValue() == false) goto L12;
            int r104 = this.f106604a.f106603u.getTypeId();
            FrameLayout r105 = this.f106604a.f106590h;
            if (r105 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L10:
            k.a(r104, r105, r102);
        L12:
            if (r101.longValue() != 0) goto L18;
            Object r106 = this.f106606c;
            if (r106 == null) goto L16;
            this.f106604a.moveToState(r106);
            return;
        L16:
            this.f106604a.d(true);
            return;
        }
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final void clearCountDown() {
        d(true);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public final void changeTempWidth() {
        if (this.f106587e == true) goto L5;
        return;
    L5:
        IShortTermIndicatorManager r100 = this.f106589g;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L8:
        ITempShortTermManager r101 = r100.getTempShortTermManager();
        if (r101 == null) goto L15;
        IIconModel<STATE> r102 = this.f106603u;
        FrameLayout r103 = this.f106590h;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L13:
        r101.changeTempWidth(r102, r103);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f106587e == false) goto L8;
        if (isDisposed() == true) goto L8;
        this.f106603u.onDestroy();
    L8:
        if (this.f106587e == false) goto L21;
        ShortTermIcon r100 = e();
        if (r100 == null) goto L15;
        IShortTermIndicatorManager r101 = this.f106589g;
        if (r101 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L14:
        r101.remove(r100);
    L15:
        IShortTermIndicatorManager r102 = this.f106589g;
        if (r102 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L18:
        ITempShortTermManager r103 = r102.getTempShortTermManager();
        if (r103 == null) goto L21;
        r103.onIconDestroy(this.f106603u);
    L21:
        d(false);
        this.f106593k.dispose();
        this.f106586d.dispose();
        this.f106584b.onComplete();
    }

    public final ShortTermIcon e() {
        IShortTermIndicatorManager r100 = this.f106589g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L5:
        Iterator<T> r101 = r100.getIcons().iterator();
    L7:
        if (r101.hasNext() == false) goto L19;
        Object r102 = r101.next();
        ShortTermIcon r103 = (ShortTermIcon) r102;
        if (r103.getTypeId() != this.f106603u.getTypeId()) goto L16;
        View r104 = r103.getView();
        FrameLayout r105 = this.f106590h;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        if (Intrinsics.areEqual(r104, r105) == false) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L7;
    L21:
        return (ShortTermIcon) r102;
    L16:
        r106 = false;
        goto L17
    L19:
        r102 = null;
        goto L21
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public Context getContext() {
        Context r100 = this.f106583a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final Long getCountDownSec() {
        Long r100 = this.f106602t;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(MathKt.roundToLong(r100.longValue() / 1000));
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f106586d.isDisposed();
    }

    public final MiddlewareRoomContext j() {
        MiddlewareRoomContext r100 = this.f106588f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataContext");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public final void showNormalState() {
        if (this.f106587e == true) goto L5;
        return;
    L5:
        IShortTermIndicatorManager r100 = this.f106589g;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L8:
        ITempShortTermManager r101 = r100.getTempShortTermManager();
        if (r101 == null) goto L12;
        r101.showNormalState(this.f106603u);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final void activateIcon() {
        ShortTermIcon r100 = e();
        if (r100 == null) goto L9;
        IShortTermIndicatorManager r101 = this.f106589g;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L7:
        r101.activate(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final /* bridge */ /* synthetic */ ViewModel getDataContext() {
        return j();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final void performClick() {
        ShortTermIcon r100 = e();
        if (r100 != null) goto L5;
    L14:
        this.f106603u.onClick();
        return;
    L5:
        if (r100.isEnhancedTouch() == false) goto L7;
        ShortTermIndicatorUtils.b(r100, "click");
        goto L14
    L7:
        IShortTermIndicatorManager r101 = this.f106589g;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L10:
        int r102 = r101.indexOf(r100);
        Lazy r103 = ShortTermIndicatorUtils.f106541a;
        Intrinsics.checkNotNullParameter(r100, "icon");
        if (r102 < 0) goto L14;
        Map<String, String> r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("icon_name", String.valueOf(r100.getTypeId())), TuplesKt.to("icon_order", String.valueOf(r102)), TuplesKt.to("icon_description", r100.getIconDesc())});
        ShortTermIndicatorUtils.a(r104, r100);
        j0.l().sendLog("icon_click", r104, new Object[]{Room.class, x.class});
        goto L14
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final Long getCountDownMs() {
        return this.f106602t;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final Observable<Long> getCountDownObservable() {
        return this.f106601s;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final STATE getCurrentState() {
        return this.f106592j;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final IconTemplate getCurrentView() {
        return this.f106594l;
    }

    public IconServiceImpl(IIconModel<STATE> r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f106603u = r100;
        CompletableSubject r101 = new CompletableSubject();
        this.f106584b = r101;
        this.f106585c = r101;
        this.f106586d = new CompositeDisposable();
        this.f106592j = r100.getInitialState();
        this.f106593k = new CompositeDisposable();
        this.f106600r = Disposables.disposed();
        this.f106601s = Observable.empty();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final boolean bindModel(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindModel");
        return this.f106586d.add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final boolean bindState(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindState");
        return this.f106593k.add(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final <T extends IconTemplate & Instantiable> T createIconTemplate(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "templateClass");
        if (r100.isAssignableFrom(ICustomIconTemplate.class) == false) goto L6;
        return new CustomIconTemplate(getContext(), null, 6, 0);
    L6:
        if (r100.isAssignableFrom(ITiltedIconTemplate.class) == false) goto L9;
        return new TiltedIconTemplate(getContext(), null, 6, 0);
    L9:
        if (r100.isAssignableFrom(ITiltedTempIconTemplate.class) == false) goto L13;
        return new TiltedTempIconTemplate(getContext(), null, 6, 0);
    L13:
        throw new IllegalArgumentException("templateClass " + r100 + " is not supported");
    }

    public final void d(boolean r100) {
        this.f106600r.dispose();
        this.f106600r = Disposables.disposed();
        this.f106601s = Observable.empty();
        this.f106602t = null;
        if (r100 == false) goto L8;
        IconTemplate r101 = this.f106594l;
        if ((r101 instanceof ICommonTemplateFeature) == false) goto L9;
        ((ICommonTemplateFeature) r101).setLabel(null);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public final long getTempShowTime(int r100) {
        if (this.f106587e == true) goto L5;
        return 0;
    L5:
        IShortTermIndicatorManager r101 = this.f106589g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L8:
        ITempShortTermManager r102 = r101.getTempShortTermManager();
        if (r102 != null) goto L11;
        return 0;
    L11:
        return r102.getTempShortTouchShowTime(this.f106603u, r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final IIconModel.EntryView inflateEntryView(int r110) {
        FrameLayout r100 = j().getAnimationLayer().getValue();
        return new IIconModel.EntryView(LayoutInflater.from(getContext()).inflate(r110, r100, false), 0, false, 6, null);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final void moveToState(STATE r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        d(false);
        STATE r101 = this.f106592j;
        this.f106592j = r100;
        this.f106593k.clear();
        b(r101, r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final boolean unbindModel(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$unbindModel");
        return this.f106586d.delete(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final boolean unbindState(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$unbindState");
        return this.f106593k.delete(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final void updateLabel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        d(false);
        IconTemplate r101 = this.f106594l;
        if ((r101 instanceof ICommonTemplateFeature) == false) goto L6;
        ((ICommonTemplateFeature) r101).setLabel(r100);
        return;
    }

    public static Animator k(View r100, long r101) {
        float r102 = UtilityKotlinExtentionsKt.h(-24);
        r100.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, a1.i(r100)), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, a1.d(r100)));
        int r103 = r100.getMeasuredWidth();
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102 - r103, 0.0f});
        r104.setDuration(300);
        r104.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r105 = com.bytedance.android.live.core.utils.h.c(r100, new float[]{1.0f, 1.05f, 0.0f});
        r105.setStartDelay(r101 + 300);
        r105.setDuration(250);
        r105.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r106 = new AnimatorSet();
        r106.play(r104).with(r105);
        return r106;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(STATE r210, STATE r211) {
        if (isDisposed() == false) goto L5;
        return;
    L5:
        IconTemplate r100 = this.f106594l;
        ShortTermIcon r101 = e();
        IconTemplate r102 = this.f106603u.getViewForState(r211);
        Lazy r103 = ShortTermIndicatorUtils.f106541a;
        Room r104 = j().getRoom().getValue();
        j().getEnterRoomTime().getValue().longValue();
        String r105 = String.valueOf(this.f106603u.getTypeId());
        boolean r106 = j().isPortraitInteraction().getValue().booleanValue();
        Intrinsics.checkNotNullParameter(r105, "typeId");
        boolean r107 = false;
        if (r106 == true) goto L11;
        if (com.bytedance.android.livesdk.utils.landscape.d.b(r104) == false) goto L11;
    L9:
        boolean r108 = true;
    L16:
        if (r108 == false) goto L18;
    L21:
        boolean r109 = true;
    L22:
        this.f106596n = r109;
        ShortTermIcon r110 = null;
        IIconModel.EntryView r111 = null;
        if (r102 == null) goto L43;
        if (this.f106595m != null) goto L27;
        r111 = this.f106603u.getEntryViewForState(r211, r210);
    L27:
        if (r111 != null) goto L32;
        int r112 = this.f106603u.getTypeId();
        FrameLayout r113 = this.f106590h;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        r110 = new ShortTermIcon(r112, r113, 0, this.f106603u.getIconDesc(), this.f106603u.isEnhancedStyleShortTouch(), this.f106603u.getDynamicPriorityShortTouch());
        goto L43
    L32:
        this.f106595m = r111;
        if (this.f106596n == false) goto L38;
        int r114 = this.f106603u.getTypeId();
        FrameLayout r115 = this.f106590h;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L37:
        r110 = new ShortTermIcon(r114, r115, 0, this.f106603u.getIconDesc(), this.f106603u.isEnhancedStyleShortTouch(), this.f106603u.getDynamicPriorityShortTouch());
        goto L43
    L38:
        long r116 = (r111.getDisplayDuration() + 300) + 700;
        int r117 = this.f106603u.getTypeId();
        FrameLayout r118 = this.f106590h;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L41:
        r110 = new ShortTermIcon(r117, r118, r116, this.f106603u.getIconDesc(), this.f106603u.isEnhancedStyleShortTouch(), this.f106603u.getDynamicPriorityShortTouch());
    L43:
        if ((!Intrinsics.areEqual(r102, r100)) == false) goto L57;
        if (r100 == null) goto L49;
        FrameLayout r119 = this.f106590h;
        if (r119 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L48:
        r119.removeView(r100.getView());
    L49:
        if (r102 == null) goto L57;
        FrameLayout r120 = this.f106590h;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L53:
        r120.addView(r102.getView());
        FrameLayout r121 = this.f106590h;
        if (r121 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L56:
        r121.getLayoutParams().width = this.f106603u.getIconWidth();
    L57:
        this.f106594l = r102;
        if (r110 != null) goto L60;
        boolean r122 = true;
    L61:
        if (r101 != null) goto L64;
        r107 = true;
    L64:
        if ((r122 ^ r107) == true) goto L66;
    L92:
        this.f106603u.applyState(r210, r211, r102);
        this.f106591i = true;
        return;
    L66:
        if (r101 == null) goto L76;
        IShortTermIndicatorManager r123 = this.f106589g;
        if (r123 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L70:
        r123.remove(r101);
        IShortTermIndicatorManager r124 = this.f106589g;
        if (r124 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L73:
        ITempShortTermManager r125 = r124.getTempShortTermManager();
        if (r125 == null) goto L76;
        r125.onIconDestroy(this.f106603u);
    L76:
        if (r110 == null) goto L92;
        IShortTermIndicatorManager r126 = this.f106589g;
        if (r126 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L80:
        r126.add(r110);
        IShortTermIndicatorManager r127 = this.f106589g;
        if (r127 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L83:
        ITempShortTermManager r128 = r127.getTempShortTermManager();
        if (r128 == null) goto L87;
        r128.addTempIconModel(this.f106603u);
    L87:
        if (zr0.f121787a.getValue().booleanValue() == false) goto L92;
        int r129 = this.f106603u.getTypeId();
        FrameLayout r130 = this.f106590h;
        if (r130 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L91:
        k.a(r129, r130, -1);
        goto L92
    L60:
        r122 = false;
        goto L61
    L18:
        if (this.f106597o == true) goto L21;
        r109 = false;
    L11:
        if (((Boolean) ShortTermIndicatorUtils.f106541a.getValue()).booleanValue() == true) goto L13;
    L15:
        r108 = false;
        goto L16
    L13:
        if (com.bytedance.android.livesdk.utils.b.a().f158887b == false) goto L15;
        goto L15
    }

    public final ShortTermIndicatorConfig.TempStateStrategy.TempStateStrategyInfo l(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        IShortTermIndicatorManager r102 = this.f106589g;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L6:
        if (r102.getTempShortTermManager() == null) goto L12;
        IShortTermIndicatorManager r103 = this.f106589g;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L10:
        ITempShortTermManager r104 = r103.getTempShortTermManager();
        Intrinsics.checkNotNull(r104);
        return r104.hasStrategyType(r100, r101);
    L12:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ITempShortTouchService
    public final int registerShowTempState(int r100, long r101) {
        if (this.f106587e == true) goto L5;
        return 0;
    L5:
        IShortTermIndicatorManager r102 = this.f106589g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stiManager");
    L8:
        ITempShortTermManager r103 = r102.getTempShortTermManager();
        if (r103 != null) goto L11;
        return 0;
    L11:
        return r103.handleTempShortTerm(this.f106603u, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    @Deprecated(message = "计划删除，请勿新增使用")
    public final ImageView imageViewOf(int r100, float r101, float r102) {
        AppCompatImageView r103 = new AppCompatImageView(getContext());
        r103.setLayoutParams(new FrameLayout.LayoutParams((int) UtilityKotlinExtentionsKt.h(r101), (int) UtilityKotlinExtentionsKt.h(r102)));
        r103.setImageResource(r100);
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IIconService
    public final void startCountDown(long r100, STATE r101, Long r102, Function1<? super Long, String> r103) {
        if (r102 == null) goto L4;
        long r104 = r102.longValue();
    L5:
        if (r103 != null) goto L7;
        r103 = IconServiceImpl$startCountDown$realTransformer$1.INSTANCE;
    L7:
        d(false);
        PublishSubject r105 = PublishSubject.create();
        DisposableObserverDelegate r106 = new DisposableObserverDelegate(r105, new IconServiceImpl$startCountDown$disposableObserver$1(r105));
        bindState(r106);
        this.f106600r = r106;
        bindModel(r105.subscribe(new a(this, r103, r101)));
        this.f106602t = Long.valueOf(r100);
        RxUtilKt.d(r100, r104).observeOn(AndroidSchedulers.mainThread()).subscribe(r106);
        this.f106601s = r105;
        return;
    L4:
        r104 = 500;
        goto L5
    }
}
