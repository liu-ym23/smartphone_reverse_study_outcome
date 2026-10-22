package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AR*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RA\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u0010;\u001a\b\u0012\u0004\u0012\u000204038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/MultiTabRoomViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Llh1/b;", "", "value", "e", "Z", "getEnableSwipeRightIntercept", "()Z", "setEnableSwipeRightIntercept", "(Z)V", "enableSwipeRightIntercept", "f", "getEnableScrollHorizontalIntercept", "setEnableScrollHorizontalIntercept", "enableScrollHorizontalIntercept", ce.f26391f, "getEnableParentNotInterceptVertical", "setEnableParentNotInterceptVertical", "enableParentNotInterceptVertical", "h", "getEnableSwipe", "setEnableSwipe", "enableSwipe", "", ce.f26395j, "Lkotlin/Lazy;", "getScaledTouchSlop", "()I", "scaledTouchSlop", "Landroid/view/GestureDetector$SimpleOnGestureListener;", ce.f26396k, "Landroid/view/GestureDetector$SimpleOnGestureListener;", "getTapListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setTapListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "tapListener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "l", "Lkotlin/jvm/functions/Function1;", "getSwipeRightListener", "()Lkotlin/jvm/functions/Function1;", "setSwipeRightListener", "(Lkotlin/jvm/functions/Function1;)V", "swipeRightListener", "", "Llh1/a;", "m", "Ljava/util/List;", "getTabChildren", "()Ljava/util/List;", "setTabChildren", "(Ljava/util/List;)V", "tabChildren", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTabRoomViewPager extends SSViewPager implements lh1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f159905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f159906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f159907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f159908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f159909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f159910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f159911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f159912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MotionEvent f159913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f159914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f159915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super MotionEvent, Unit> f159916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<lh1.a> f159917m;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTabRoomViewPager f159918a;

        public a(MultiTabRoomViewPager r100) {
            this.f159918a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            GestureDetector.SimpleOnGestureListener r101 = this.f159918a.getTapListener();
            if (r101 == null) goto L6;
            r101.onDoubleTap(r100);
        L6:
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            GestureDetector.SimpleOnGestureListener r101 = this.f159918a.getTapListener();
            if (r101 == null) goto L6;
            r101.onSingleTapUp(r100);
        L6:
            return super.onSingleTapUp(r100);
        }
    }

    private final int getScaledTouchSlop() {
        return ((Number) this.f159914j.getValue()).intValue();
    }

    public final boolean getEnableParentNotInterceptVertical() {
        return this.f159911g;
    }

    public final boolean getEnableScrollHorizontalIntercept() {
        return this.f159910f;
    }

    public final boolean getEnableSwipe() {
        return this.f159912h;
    }

    public final boolean getEnableSwipeRightIntercept() {
        return this.f159909e;
    }

    public final Function1<MotionEvent, Unit> getSwipeRightListener() {
        return this.f159916l;
    }

    public final List<lh1.a> getTabChildren() {
        return this.f159917m;
    }

    public final GestureDetector.SimpleOnGestureListener getTapListener() {
        return this.f159915k;
    }

    public static MotionEvent h(MotionEvent r100) {
        return MotionEvent.obtain(r100.getDownTime(), r100.getEventTime(), r100.getAction(), r100.getRawX(), r100.getRawY(), r100.getMetaState());
    }

    @Override // lh1.b
    public final void b(lh1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "tabChild");
        if (this.f159917m.contains(r100) == true) goto L6;
        this.f159917m.add(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r100.getAction() != 0) goto L5;
        this.f159906b = Float.valueOf(r100.getX());
        this.f159907c = Float.valueOf(r100.getY());
        this.f159913i = h(r100);
        this.f159908d = false;
    L5:
        boolean r101 = super.dispatchTouchEvent(r100);
        if (r101 == false) goto L11;
        if (this.f159911g == false) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        if (r100.getAction() != 3) goto L13;
    L14:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r102 = this.f159913i;
        if (r102 == null) goto L17;
        r102.recycle();
    L17:
        this.f159913i = null;
    L18:
        return r101;
    L13:
        if (r100.getAction() != 1) goto L18;
        goto L14
    }

    @Override // lh1.b
    public final void g(lh1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "tabChild");
        this.f159917m.remove(r100);
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        LocalTestManager.a(new Class[]{wy.a.class});
        if (this.f159912h == true) goto L6;
        return false;
    L6:
        if (this.f159910f == false) goto L47;
        if (r100 == null) goto L47;
        if (r100.getAction() != 2) goto L47;
        if (this.f159906b != null) goto L13;
    L19:
        this.f159906b = Float.valueOf(r100.getX());
        this.f159907c = Float.valueOf(r100.getY());
    L20:
        boolean r101 = false;
    L21:
        if (r101 == false) goto L47;
        Iterator<T> r102 = this.f159917m.iterator();
    L24:
        if (r102.hasNext() == false) goto L28;
        lh1.a r103 = (lh1.a) r102.next();
        if (r103.Ki() == false) goto L24;
        r103.toString();
        boolean r104 = true;
    L29:
        if (r104 == true) goto L47;
        if (this.f159909e == true) goto L33;
    L45:
        super.onInterceptTouchEvent(r100);
    L46:
        return true;
    L33:
        if (this.f159906b == null) goto L45;
        float r105 = r100.getX();
        Float r106 = this.f159906b;
        Intrinsics.checkNotNull(r106);
        if (r105 <= r106.floatValue()) goto L45;
        this.f159908d = true;
        MotionEvent r107 = this.f159913i;
        if (r107 == null) goto L46;
        Objects.toString(r107);
        MotionEvent r108 = h(r107);
        Function1<? super MotionEvent, Unit> r109 = this.f159916l;
        if (r109 == null) goto L41;
        Unit r110 = r109.invoke(r108);
    L41:
        r108.recycle();
        Objects.toString(r100);
        MotionEvent r111 = h(r100);
        Function1<? super MotionEvent, Unit> r112 = this.f159916l;
        if (r112 == null) goto L44;
        Unit r113 = r112.invoke(r111);
    L44:
        r111.recycle();
        goto L46
    L28:
        r104 = false;
        goto L29
    L13:
        if (this.f159907c == null) goto L19;
        float r114 = r100.getX();
        Float r115 = this.f159906b;
        Intrinsics.checkNotNull(r115);
        float r116 = r114 - r115.floatValue();
        float r117 = r100.getY();
        Float r118 = this.f159907c;
        Intrinsics.checkNotNull(r118);
        if (Math.abs(r117 - r118.floatValue()) >= Math.abs(r116)) goto L20;
        if (Math.abs(r116) < getScaledTouchSlop()) goto L20;
        r101 = true;
    L47:
        boolean r119 = super.onInterceptTouchEvent(r100);
        LocalTestManager.a(new Class[]{wy.a.class});
        return r119;
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        LocalTestManager.a(new Class[]{wy.a.class});
        if (this.f159912h == true) goto L6;
        return false;
    L6:
        if (this.f159908d == true) goto L8;
    L31:
        if (r110 == null) goto L34;
        this.f159905a.onTouchEvent(r110);
    L34:
        return super.onTouchEvent(r110);
    L8:
        if (this.f159916l == null) goto L31;
        if (r110 == null) goto L11;
        Integer r100 = Integer.valueOf(r110.getAction());
    L12:
        if (r100 != null) goto L15;
    L17:
        if (r100 != null) goto L20;
    L22:
        if (r100 != null) goto L25;
    L30:
        return true;
    L25:
        if (r100.intValue() != 3) goto L30;
    L26:
        MotionEvent r111 = MotionEvent.obtain(r110.getDownTime(), r110.getEventTime(), r110.getAction(), r110.getRawX(), r110.getRawY(), r110.getMetaState());
        Function1<? super MotionEvent, Unit> r101 = this.f159916l;
        if (r101 == null) goto L29;
        Unit r102 = r101.invoke(r111);
    L29:
        r111.recycle();
        goto L30
    L20:
        if (r100.intValue() != 1) goto L22;
    L15:
        if (r100.intValue() != 2) goto L17;
    L11:
        r100 = null;
        goto L12
    }

    public final void setEnableParentNotInterceptVertical(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.f159911g = r101;
        return;
    L4:
        if (VSSettingKeys.MATCH_ROOM_PARENT_NOT_INTERCEPT_VERTICAL_EVENT.getValue().booleanValue() == false) goto L6;
        r101 = true;
        goto L7
    }

    public final void setEnableScrollHorizontalIntercept(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.f159910f = r101;
        return;
    L4:
        if (VSSettingKeys.MATCH_ROOM_INTERCEPT_CHAT_TAB.getValue().booleanValue() == false) goto L6;
        r101 = true;
        goto L7
    }

    public final void setEnableSwipe(boolean r100) {
        this.f159912h = r100;
    }

    public final void setEnableSwipeRightIntercept(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.f159909e = r101;
        return;
    L4:
        if (VSSettingKeys.MATCH_ROOM_TAB_ENABLE_CLEAR_SCREEN.getValue().booleanValue() == false) goto L6;
        r101 = true;
        goto L7
    }

    public final void setSwipeRightListener(Function1<? super MotionEvent, Unit> r100) {
        this.f159916l = r100;
    }

    public final void setTabChildren(List<lh1.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f159917m = r100;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r100) {
        this.f159915k = r100;
    }

    public MultiTabRoomViewPager(final Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f159905a = new GestureDetector(r100, new a(this));
        this.f159912h = true;
        this.f159914j = LazyKt.lazy(new MultiTabRoomViewPager$scaledTouchSlop$2(r100));
        this.f159917m = new ArrayList();
    }
}
