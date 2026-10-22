package com.bytedance.android.livesdk.chatroom.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.LiveRoomAdminManageListPresenter;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.LiveRoomAdminManageListView;
import com.bytedance.android.livesdk.chatroom.roommanage.manage.LiveRoomManageListView2;
import com.bytedance.android.livesdk.chatroom.roommanage.permission.AnchorModifyAdminPermissionView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0007$B\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "", "setAdapter", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "getMAdapter", "()Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "setMAdapter", "(Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;)V", "mAdapter", "", "c", "Z", "getNeedUpdateHeightOnHorizontal", "()Z", "setNeedUpdateHeightOnHorizontal", "(Z)V", "needUpdateHeightOnHorizontal", "Landroid/animation/ValueAnimator;", "d", "Landroid/animation/ValueAnimator;", "getHeightAnimator", "()Landroid/animation/ValueAnimator;", "setHeightAnimator", "(Landroid/animation/ValueAnimator;)V", "heightAnimator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ProfileManageViewAdapter", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveProfileManageViewPager extends SSViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProfileManageViewAdapter f112305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f112306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f112308d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LiveProfileManageViewPager$ProfileManageViewAdapter;", "Lcom/bytedance/android/live/uikit/viewpager/AbsPagerAdapter;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProfileManageViewAdapter extends AbsPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t7 f112309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final us2.a f112310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q7 f112311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f112312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f112313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AnchorModifyAdminPermissionView f112314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<h80.d<? extends View>> f112315g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Context f112316h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final LiveProfileManageDialogV2.b f112317i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Room f112318j;

        public final View f() {
            List<h80.d<? extends View>> r100 = this.f112315g;
            return (View) ((h80.d) ListProtector.get(r100, CollectionsKt.getLastIndex(r100))).get();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f112315g.size();
        }

        public final Context getContext() {
            return this.f112316h;
        }

        public final void g(Function0<Unit> r100) {
            LiveRoomAdminManageListView r101 = new LiveRoomAdminManageListView(this.f112316h, this.f112318j, this.f112311c, "from_toolbar");
            this.f112313e = r101;
            if (r100 == null) goto L6;
            LiveRoomAdminManageListPresenter r102 = r101.getPresenter();
            r102.f111193h = r100;
            r102.d();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter
        public final void unbindView(View r100) {
            super.unbindView(r100);
            if ((r100 instanceof com.bytedance.android.livesdk.chatroom.roommanage.c) == false) goto L6;
            ((com.bytedance.android.livesdk.chatroom.roommanage.c) r100).unbind();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter
        public final View getView(int r100, View r101, ViewGroup r102) {
            View r103 = (View) ((h80.d) ListProtector.get(this.f112315g, r100)).get();
            if ((r103 instanceof com.bytedance.android.livesdk.chatroom.roommanage.c) == false) goto L5;
            ((com.bytedance.android.livesdk.chatroom.roommanage.c) r103).a();
        L5:
            return r103;
        }

        public ProfileManageViewAdapter(boolean r110, Context r111, LayoutInflater r112, j7 r113, Room r114, User r115, boolean r210, boolean r211, UserProfileEvent r212, Bundle r213) {
            Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r112, "layoutInflater");
            Intrinsics.checkNotNullParameter(r113, "manageClickCallback");
            Intrinsics.checkNotNullParameter(r213, "bundle");
            super(r111, r112);
            this.f112316h = r111;
            this.f112317i = r113;
            this.f112318j = r114;
            t7 r116 = new t7(r110, r111, r115, r210, r211, r212, r213);
            this.f112309a = r116;
            String r100 = null;
            if (r114 == null) goto L5;
            Long r101 = Long.valueOf(r114.f162599id);
        L6:
            if (r114 == null) goto L10;
            User r102 = r114.mo8271getOwner();
            if (r102 == null) goto L10;
            r100 = r102.getIdStr();
        L10:
            us2.a r103 = new us2.a(r111, r101, r100);
            this.f112310b = r103;
            q7 r104 = new q7(this);
            this.f112311c = r104;
            this.f112312d = LazyKt.lazy(new LiveProfileManageViewPager$ProfileManageViewAdapter$emptyView$2(this));
            this.f112313e = new FrameLayout(r111);
            this.f112314f = new AnchorModifyAdminPermissionView(r111, r114, r104, "from_toolbar");
            this.f112315g = CollectionsKt.listOf(new h80.d[]{new m7(this), new n7(this), new o7(this), new p7(this)});
            r116.setClickCallback(r113);
            r103.setClickCallback(r113);
            return;
        L5:
            r101 = null;
            goto L6
        }
    }

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveProfileManageViewPager f112319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f112320b;

        public b(LiveProfileManageViewPager r100, ViewGroup.LayoutParams r101) {
            this.f112319a = r100;
            this.f112320b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup.LayoutParams r101 = this.f112320b;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.height = ((Integer) r102).intValue();
            this.f112319a.setLayoutParams(this.f112320b);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final boolean canScroll(View r100, boolean r101, int r102, int r103, int r104) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        return false;
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public final void h() {
        ProfileManageViewAdapter r100 = this.f112305a;
        if (r100 == null) goto L6;
        r100.f112309a.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r101 = r100.f112309a.getMeasuredHeight();
        ViewGroup.LayoutParams r102 = getLayoutParams();
        r102.height = r101;
        setLayoutParams(r102);
        return;
    }

    public final void j() {
        ProfileManageViewAdapter r100 = this.f112305a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f112313e = new LiveRoomManageListView2(r100.f112316h, r100.f112318j, r100.f112311c);
        setCurrentItem(2, false);
        k(r100.f112313e);
    }

    public final boolean i() {
        if (getContext().getResources() != null) goto L5;
        return false;
    L5:
        if (getContext().getResources().getConfiguration() != null) goto L7;
        return false;
    L7:
        if (getContext().getResources().getConfiguration().orientation != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public final ValueAnimator getHeightAnimator() {
        return this.f112308d;
    }

    public final ProfileManageViewAdapter getMAdapter() {
        return this.f112305a;
    }

    public final boolean getNeedUpdateHeightOnHorizontal() {
        return this.f112307c;
    }

    public LiveProfileManageViewPager(Context r100) {
        this(r100, null);
    }

    public final void k(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (i() == false) goto L6;
    L8:
        this.f112306b = false;
        r100.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r101 = r100.getMeasuredHeight();
        ViewGroup.LayoutParams r102 = getLayoutParams();
        int r103 = getMeasuredHeight();
        ValueAnimator r104 = this.f112308d;
        if (r104 == null) goto L11;
        r104.removeAllUpdateListeners();
        r104.removeAllListeners();
        r104.cancel();
    L11:
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r103, r101});
        this.f112308d = r105;
        if (r105 == null) goto L16;
        r105.addUpdateListener(new b(this, r102));
        r105.setDuration(300).start();
        return;
    L16:
        return;
    L6:
        if (this.f112307c == true) goto L8;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        super.setAdapter(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ProfileManageViewAdapter) == false) goto L9;
        this.f112305a = (ProfileManageViewAdapter) r100;
        return;
    }

    public final void setHeightAnimator(ValueAnimator r100) {
        this.f112308d = r100;
    }

    public final void setMAdapter(ProfileManageViewAdapter r100) {
        this.f112305a = r100;
    }

    public final void setNeedUpdateHeightOnHorizontal(boolean r100) {
        this.f112307c = r100;
    }

    public LiveProfileManageViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f112306b = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (i() == true) goto L9;
        if (this.f112307c == true) goto L9;
        super.onMeasure(r100, r101);
        return;
    L9:
        if (this.f112306b == false) goto L17;
        int r102 = getChildCount();
        int r103 = 9999;
        int r104 = 0;
    L11:
        if (r104 >= r102) goto L16;
        View r105 = getChildAt(r104);
        r105.measure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        if ((r105 instanceof t7) == false) goto L15;
        r103 = ((t7) r105).getMeasuredHeight();
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L17:
        super.onMeasure(r100, r101);
    }
}
