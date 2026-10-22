package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import com.bytedance.android.livesdk.feed.viewmodel.TimeOutRefreshViewModel;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/BaseOpenFeedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/android/livesdk/feed/squarefeed/e;", "<init>", "()V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseOpenFeedFragment extends Fragment implements com.bytedance.android.livesdk.feed.squarefeed.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<Boolean> f124384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f124385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f124386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HorizontalLiveListView f124387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f124388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f124389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f124390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f124391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TimeOutRefreshViewModel f124392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f124393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f124394n;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseOpenFeedFragment f124395a;

        public a(BaseOpenFeedFragment r100) {
            this.f124395a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (this.f124395a.f124386f == true) goto L5;
        L9:
            ViewGroup.LayoutParams r102 = null;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L22;
            InterceptTouchLayout r103 = this.f124395a.T90();
            if (r103 == null) goto L14;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        L16:
            if ((r104 instanceof RelativeLayout.LayoutParams) == false) goto L19;
            r102 = r104;
        L19:
            RelativeLayout.LayoutParams r105 = (RelativeLayout.LayoutParams) r102;
            if (r105 == null) goto L33;
            r105.topMargin = 0;
        L33:
            BaseOpenFeedFragment r106 = this.f124395a;
            boolean r107 = Intrinsics.areEqual(r101, Boolean.FALSE);
            InterceptTouchLayout r108 = r106.T90();
            if (r108 == null) goto L37;
            r108.setInterceptTouchEvent(r107);
            return;
        L37:
            return;
        L14:
            r104 = null;
            goto L16
        L22:
            InterceptTouchLayout r109 = this.f124395a.T90();
            if (r109 == null) goto L25;
            ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        L27:
            if ((r110 instanceof RelativeLayout.LayoutParams) == false) goto L30;
            r102 = r110;
        L30:
            RelativeLayout.LayoutParams r111 = (RelativeLayout.LayoutParams) r102;
            if (r111 == null) goto L33;
            r111.topMargin = this.f124395a.f124394n;
            goto L33
        L25:
            r110 = null;
            goto L27
        L5:
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L9;
            BaseOpenFeedFragment r112 = this.f124395a;
            r112.f124386f = false;
            TextView r113 = r112.W90();
            if (r113 == null) goto L9;
            r113.setVisibility(8);
            goto L9
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseOpenFeedFragment f124396a;

        public b(BaseOpenFeedFragment r100) {
            this.f124396a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L19;
            InterceptTouchLayout r101 = this.f124396a.T90();
            ViewGroup.LayoutParams r102 = null;
            if (r101 == null) goto L7;
            ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        L9:
            if ((r103 instanceof RelativeLayout.LayoutParams) == false) goto L12;
            r102 = r103;
        L12:
            RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r102;
            if (r104 == null) goto L15;
            r104.topMargin = 0;
        L15:
            InterceptTouchLayout r105 = this.f124396a.T90();
            if (r105 == null) goto L20;
            r105.setInterceptTouchEvent(false);
            return;
        L20:
            return;
        L7:
            r103 = null;
            goto L9
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseOpenFeedFragment f124397a;

        public c(BaseOpenFeedFragment r100) {
            this.f124397a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            TextView r102 = this.f124397a.W90();
            if (r102 == null) goto L6;
            r102.setText(LiveResUtil.getString(R.string.ttlive_feed_room_count, new Object[]{String.valueOf(r101)}));
            return;
        }
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseOpenFeedFragment f124399a;

        public d(BaseOpenFeedFragment r100) {
            this.f124399a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            ViewGroup r102 = this.f124399a.V90();
            if (r102 != null) goto L5;
            return false;
        L5:
            if (r102.getVisibility() == 0) goto L7;
            return false;
        L7:
            if (r101.getAction() != 1) goto L46;
            BaseOpenFeedFragment r103 = this.f124399a;
            if (r103.f124389i == false) goto L46;
            ViewGroup r104 = r103.V90();
            if (r104 == null) goto L14;
            int r105 = r104.getMeasuredHeight();
        L15:
            r103.f124388h = r105;
            ValueAnimator r106 = r103.f124390j;
            if (r106 == null) goto L18;
            r106.removeAllUpdateListeners();
        L18:
            ValueAnimator r107 = r103.f124390j;
            if (r107 == null) goto L21;
            r107.removeAllListeners();
        L21:
            ValueAnimator r108 = ValueAnimator.ofInt(new int[]{r103.f124394n, 0}).setDuration(300);
            r103.f124390j = r108;
            if (r108 == null) goto L24;
            r108.addListener(new com.bytedance.android.livesdk.feed.squarefeed.a(r103));
        L24:
            ValueAnimator r109 = r103.f124390j;
            if (r109 == null) goto L27;
            r109.addUpdateListener(new com.bytedance.android.livesdk.feed.squarefeed.b(r103));
        L27:
            ValueAnimator r110 = r103.f124390j;
            if (r110 == null) goto L30;
            r110.start();
        L30:
            TextView r111 = r103.W90();
            if (r111 == null) goto L33;
            r111.setVisibility(0);
        L33:
            TextView r112 = r103.W90();
            if (r112 == null) goto L46;
            ViewPropertyAnimator r113 = r112.animate();
            if (r113 == null) goto L46;
            ViewPropertyAnimator r114 = r113.alpha(1.0f);
            if (r114 == null) goto L46;
            ViewPropertyAnimator r115 = r114.scaleX(1.0f);
            if (r115 == null) goto L46;
            ViewPropertyAnimator r116 = r115.scaleY(1.0f);
            if (r116 == null) goto L46;
            ViewPropertyAnimator r117 = r116.setDuration(300);
            if (r117 == null) goto L46;
            r117.start();
            goto L46
        L14:
            r105 = 0;
        L46:
            return true;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseOpenFeedFragment f124400a;

        public e(BaseOpenFeedFragment r100) {
            this.f124400a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BaseOpenFeedFragment r101 = this.f124400a;
            if (r101.f124389i == true) goto L5;
            return;
        L5:
            if (r101.f124388h == 0) goto L46;
            ViewGroup r102 = r101.V90();
            if (r102 == null) goto L10;
            r102.setVisibility(0);
        L10:
            ValueAnimator r103 = r101.f124390j;
            if (r103 == null) goto L13;
            r103.removeAllUpdateListeners();
        L13:
            ValueAnimator r104 = r101.f124390j;
            if (r104 == null) goto L16;
            r104.removeAllListeners();
        L16:
            ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, r101.f124394n}).setDuration(300);
            r101.f124390j = r105;
            if (r105 == null) goto L19;
            r105.addListener(new com.bytedance.android.livesdk.feed.squarefeed.c(r101));
        L19:
            ValueAnimator r106 = r101.f124390j;
            if (r106 == null) goto L22;
            r106.addUpdateListener(new com.bytedance.android.livesdk.feed.squarefeed.d(r101));
        L22:
            ValueAnimator r107 = r101.f124390j;
            if (r107 == null) goto L25;
            r107.start();
        L25:
            TextView r108 = r101.W90();
            if (r108 == null) goto L40;
            ViewPropertyAnimator r109 = r108.animate();
            if (r109 == null) goto L41;
            ViewPropertyAnimator r110 = r109.alpha(0.0f);
            if (r110 == null) goto L42;
            ViewPropertyAnimator r111 = r110.scaleX(0.01f);
            if (r111 == null) goto L43;
            ViewPropertyAnimator r112 = r111.scaleY(0.01f);
            if (r112 == null) goto L44;
            ViewPropertyAnimator r113 = r112.setDuration(300);
            if (r113 == null) goto L45;
            r113.start();
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L40:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.e
    public final int I9() {
        return 4;
    }

    public void S90() {
    }

    public abstract InterceptTouchLayout T90();

    public abstract String U90();

    public abstract ViewGroup V90();

    public abstract TextView W90();

    public abstract HorFollowListParams X90();

    public abstract int Y90();

    public abstract BannerSwipeRefreshLayout Z90();

    public abstract long aa0();

    public abstract boolean ca0();

    @Override // com.bytedance.android.livesdk.feed.squarefeed.e
    public final int f8() {
        return 10;
    }

    public abstract RecyclerView getRecyclerView();

    public abstract void initView(View r100);

    public BaseOpenFeedFragment() {
        this.f124384d = PublishSubject.create();
        this.f124391k = new CompositeDisposable();
        this.f124393m = "";
        this.f124394n = LiveResUtil.dp2Px(97.0f);
    }

    public final void ba0() {
        TextView r100 = W90();
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        BannerSwipeRefreshLayout r101 = Z90();
        if (r101 == null) goto L9;
        r101.G = getRecyclerView();
    L9:
        if (ca0() == false) goto L25;
        this.f124387g = new HorizontalLiveListView(X90(), requireContext(), null, 0);
        ViewGroup r102 = V90();
        if (r102 == null) goto L13;
        r102.setVisibility(0);
        r102.removeAllViews();
        r102.addView(this.f124387g);
    L13:
        HorizontalLiveListView r103 = this.f124387g;
        if (r103 == null) goto L16;
        r103.f124230j.observe(r103, new a(this));
        r103.f124228h.observe(r103, new b(this));
        r103.f124232l.observe(r103, new c(this));
    L16:
        InterceptTouchLayout r104 = T90();
        if (r104 == null) goto L19;
        r104.setOnTouchListener(new d(this));
    L19:
        TextView r105 = W90();
        if (r105 == null) goto L22;
        r105.setOnClickListener(new e(this));
    L22:
        InterceptTouchLayout r106 = T90();
        if (r106 == null) goto L32;
        r106.setInterceptTouchEvent(true);
        return;
    L32:
        return;
    L25:
        ViewGroup r107 = V90();
        if (r107 == null) goto L28;
        r107.setVisibility(8);
    L28:
        InterceptTouchLayout r108 = T90();
        if (r108 == null) goto L34;
        r108.setInterceptTouchEvent(false);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f124391k.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f124389i = false;
        S90();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TimeOutRefreshViewModel r100 = this.f124392l;
        if (r100 == null) goto L6;
        r100.onReturn();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        TimeOutRefreshViewModel r100 = this.f124392l;
        if (r100 == null) goto L6;
        r100.onLeave();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f124389i = false;
        this.f124392l = (TimeOutRefreshViewModel) ViewModelProviders.of(this).get(TimeOutRefreshViewModel.class);
        HashMap r101 = new HashMap();
        r101.put("event_type", "click");
        r101.put("event_belong", "tab_click");
        r101.put("enter_from_merge", U90());
        kw1.c.d("live_enter", r101);
        if (getUserVisibleHint() == false) goto L6;
        HashMap r102 = new HashMap();
        r102.put("page_name", FeedLiveFragment.class.getName());
        kw1.b.o().b("ttlive_page", r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        aa0();
        this.f124384d.onNext(Boolean.valueOf(r100));
        if (r100 == false) goto L7;
        TimeOutRefreshViewModel r101 = this.f124392l;
        if (r101 == null) goto L11;
        r101.onReturn();
        return;
    L11:
        return;
    L7:
        TimeOutRefreshViewModel r102 = this.f124392l;
        if (r102 == null) goto L13;
        r102.onLeave();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f124389i = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(Y90(), r101, false);
        this.f124385e = r103;
        if (r103 == null) goto L6;
        initView(r103);
    L6:
        return this.f124385e;
    }
}
