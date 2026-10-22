package com.bytedance.android.livesdk.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseFeedRoomPlayComponent implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f123411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseFeedAdapter f123412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BannerSwipeRefreshLayout f123413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f123414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Activity f123415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f123416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zw1.a f123417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f123418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f123419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f123420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f123421k;

    public class a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFeedRoomPlayComponent f123422a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            super.onChanged();
            b(true);
        }

        public a(BaseFeedRoomPlayComponent r100) {
            this.f123422a = r100;
        }

        public final void b(boolean r100) {
            BaseFeedRoomPlayComponent r101 = this.f123422a;
            d r102 = r101.f123416f;
            boolean r103 = false;
            if (r102 != null) goto L5;
        L7:
            boolean r104 = false;
        L9:
            if (r101.f123412b.getItemCount() > 0) goto L11;
            r103 = true;
        L11:
            this.f123422a.getClass();
            if (r104 == false) goto L15;
            if (r103 == false) goto L15;
            this.f123422a.e();
            return;
        L15:
            if (r104 == true) goto L18;
            if (r103 == true) goto L18;
            this.f123422a.d();
            return;
        L18:
            if (r104 == false) goto L24;
            if (r100 == false) goto L25;
            this.f123422a.e();
            this.f123422a.d();
            return;
        L25:
            return;
        L24:
            return;
        L5:
            if (r102.f123425b <= 0) goto L7;
            r104 = true;
            goto L9
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            super.onItemRangeInserted(r100, r101);
            if (r100 > this.f123422a.f123416f.f123424a) goto L5;
            boolean r102 = true;
        L6:
            b(r102);
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            super.onItemRangeRemoved(r100, r101);
            if (r100 > this.f123422a.f123416f.f123424a) goto L5;
            boolean r102 = true;
        L6:
            b(r102);
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            super.onItemRangeMoved(r100, r101, r102);
            int r103 = this.f123422a.f123416f.f123424a;
            if (r100 <= r103) goto L7;
            if (r101 <= r103) goto L7;
            boolean r104 = false;
        L8:
            b(r104);
            return;
        L7:
            r104 = true;
            goto L8
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFeedRoomPlayComponent f123423a;

        public final void a() {
            BaseFeedRoomPlayComponent r100 = this.f123423a;
            if (r100.f123418h == true) goto L5;
            return;
        L5:
            if (r100.f123419i == false) goto L20;
            RecyclerView r101 = r100.f123411a;
            if (r101 != null) goto L9;
            return;
        L9:
            if (r101.getAdapter() != null) goto L11;
            return;
        L11:
            if (this.f123423a.f123411a.getAdapter().getItemCount() != 0) goto L14;
            return;
        L14:
            if (this.f123423a.a() == false) goto L23;
            BaseFeedRoomPlayComponent r102 = this.f123423a;
            d r103 = r102.f123416f;
            if (r103 == null) goto L24;
            r103.onScrollStateChanged(r102.f123411a, 0);
            return;
        L24:
            return;
        L23:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(BaseFeedRoomPlayComponent r100) {
            this.f123423a = r100;
        }
    }

    public interface c {
        FragmentActivity P2();

        zw1.a Q2();

        RecyclerView R2();

        BannerSwipeRefreshLayout S2();

        String T2();

        View U2();

        BaseFeedAdapter adapter();

        Lifecycle lifecycle();
    }

    public abstract class d extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f123424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f123425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedHashMap<Long, Long> f123426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedHashMap<Long, Long> f123427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinkedHashMap<Long, Long> f123428e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ BaseFeedRoomPlayComponent f123429f;

        public int[] k() {
            return new int[]{-1, -1};
        }

        public abstract int l(boolean r100);

        public abstract void n();

        public void o() {
            this.f123424a = -1;
            this.f123425b = -1;
            ViewGroup r100 = this.f123429f.f123414d;
            if (r100 == null) goto L5;
            r100.setVisibility(4);
        L5:
            this.f123429f.b();
        }

        public final Room m() {
            FeedItem r100 = this.f123429f.f123412b.D2(this.f123424a);
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.type == 1) goto L7;
            return null;
        L7:
            return (Room) r100.getItem();
        }

        public d(BaseFeedRoomPlayComponent r100) {
            this.f123429f = r100;
            this.f123424a = -1;
            this.f123425b = -1;
            this.f123426c = new LinkedHashMap();
            this.f123427d = new LinkedHashMap();
            this.f123428e = new LinkedHashMap();
        }

        public void j(int[] r100) {
            BaseFeedRoomPlayComponent r101 = this.f123429f;
            if (r101.f123418h == true) goto L5;
            return;
        L5:
            if (r101.f123419i == false) goto L9;
            int r102 = r100[1];
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            super.onScrollStateChanged(r100, r101);
            if (r101 == 0) goto L5;
            return;
        L5:
            if (this.f123429f.f123418h == false) goto L10;
            Logger.i("RoomPlayComponent", "event_v3 live_show: newPlayPosition--:" + l(true));
            int[] r102 = k();
            Logger.i("RoomPlayComponent", "event_v3 live_show: frogPos--:" + r102);
            j(r102);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r100, int r101, int r102) {
            super.onScrolled(r100, r101, r102);
            ViewGroup r103 = this.f123429f.f123414d;
            if (r103 != null) goto L5;
        L7:
            n();
            return;
        L5:
            if (r103.getVisibility() == 0) goto L7;
        }
    }

    public abstract boolean a();

    public abstract void b();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.f123418h = false;
        if (a() == true) goto L5;
        return;
    L5:
        if (this.f123419i == false) goto L9;
        e();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f123418h = true;
        d();
    }

    public final void e() {
        RecyclerView r100 = this.f123411a;
        if (r100 == null) goto L5;
        r100.removeCallbacks(this.f123421k);
    L5:
        ViewGroup r101 = this.f123414d;
        if (r101 == null) goto L8;
        r101.setVisibility(4);
    L8:
        b();
        d r102 = this.f123416f;
        if (r102 == null) goto L12;
        r102.o();
        return;
    }

    public final void d() {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.f123418h == true) goto L7;
        return;
    L7:
        if (this.f123419i == false) goto L12;
        this.f123411a.removeCallbacks(this.f123421k);
        this.f123411a.postDelayed(this.f123421k, 1000);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.f123415e.isFinishing() == false) goto L9;
        e();
        return;
    }

    public BaseFeedRoomPlayComponent(c r100) {
        this.f123418h = false;
        this.f123419i = false;
        this.f123420j = new a(this);
        this.f123421k = new b(this);
        this.f123414d = (ViewGroup) r100.U2();
        RecyclerView r101 = r100.R2();
        this.f123411a = r101;
        r101.getLayoutManager();
        this.f123412b = r100.adapter();
        this.f123413c = r100.S2();
        this.f123415e = r100.P2();
        r100.T2();
        r100.lifecycle().addObserver(this);
        new WeakReference(r100.lifecycle());
        this.f123417g = r100.Q2();
    }

    public final void c(boolean r100) {
        if (this.f123419i != r100) goto L5;
        return;
    L5:
        this.f123419i = r100;
        if (r100 == false) goto L9;
        d();
        return;
    L9:
        if (a() == true) goto L11;
        return;
    L11:
        if (this.f123418h == false) goto L16;
        e();
        return;
    }
}
