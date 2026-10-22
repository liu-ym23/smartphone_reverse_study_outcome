package com.bytedanceos.appstore.buss.widget.recyclerbanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002JKB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b \u0010\u001bJ\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010\u001bJ\u0015\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010\u000eR\u0016\u0010,\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\u0006\u0012\u0002\b\u00030\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020:8\u0002X\u0082D¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010A\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010+R\u0018\u0010D\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006L"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView;", "Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;", "adapter", "", "setBannerAdapter", "(Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;)V", "U", "()V", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;", "listener", "setOnBannerExposeListener", "(Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "visibility", "onWindowVisibilityChanged", "(I)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "spansPerPage", "setSpansPerPage", "position", "scrollToPosition", "smoothScrollToPosition", "isPlay", "setPlay", "(Z)V", "R", "()I", "T", "l", "Z", "isInit", "Lw7/a;", "m", "Lw7/a;", "snapHelper", "n", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;", "bannerAdapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "o", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "p", "I", "", "q", "J", "intervalTime", "r", "currentPosition", "s", "isPlaying", "t", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;", "bannerExposeListener", "Landroid/os/Handler;", "u", "Landroid/os/Handler;", "mHandler", "v", "BannerExposeListener", "b", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BannerPagerRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b f9292v = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w7.a f9294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BaseRecyclerBannerAdapter f9295n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayoutManager f9296o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9297p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f9298q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9299r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9300s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BannerExposeListener f9301t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Handler f9302u;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;", "", "onBannerExpose", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BannerExposeListener {
        void onBannerExpose();
    }

    public static final class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerPagerRecyclerView f9303a;

        public a(BannerPagerRecyclerView r10) {
            this.f9303a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            q.g(r10, "recyclerView");
            if (r11 != 0) goto L8;
            BannerPagerRecyclerView r12 = this.f9303a;
            BannerPagerRecyclerView.Q(r12, BannerPagerRecyclerView.P(r12).findFirstVisibleItemPosition());
            this.f9303a.setPlay(true);
            BannerExposeListener r13 = BannerPagerRecyclerView.O(this.f9303a);
            if (r13 == null) goto L9;
            r13.onBannerExpose();
            return;
        L9:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r10, int r11, int r12) {
            q.g(r10, "recyclerView");
            if (r11 == 0) goto L6;
            this.f9303a.setPlay(false);
            return;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f9292v = new b(null);
    }

    public BannerPagerRecyclerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        LinearLayoutManager r12 = new LinearLayoutManager(r10, 0, false);
        this.f9296o = r12;
        this.f9297p = 1;
        this.f9298q = 6000;
        setLayoutManager(r12);
        addOnScrollListener(new a(this));
        this.f9302u = new Handler(new v7.a(this));
    }

    public static /* synthetic */ boolean N(BannerPagerRecyclerView r10, Message r11) {
        return S(r10, r11);
    }

    public static final /* synthetic */ BannerExposeListener O(BannerPagerRecyclerView r10) {
        return r10.f9301t;
    }

    public static final /* synthetic */ LinearLayoutManager P(BannerPagerRecyclerView r10) {
        return r10.f9296o;
    }

    public static final /* synthetic */ void Q(BannerPagerRecyclerView r10, int r11) {
        r10.f9299r = r11;
    }

    public static final boolean S(BannerPagerRecyclerView r10, Message r11) {
        q.g(r10, "this$0");
        q.g(r11, "msg");
        if (r11.what != 1000) goto L7;
        r10.T();
        return false;
    L7:
        return false;
    }

    private final void U() {
        BaseRecyclerBannerAdapter r10 = this.f9295n;
        BaseRecyclerBannerAdapter r11 = null;
        if (r10 != null) goto L6;
        q.y("bannerAdapter");
        r10 = null;
    L6:
        if (r10.b() == false) goto L14;
        BaseRecyclerBannerAdapter r12 = this.f9295n;
        if (r12 != null) goto L10;
        q.y("bannerAdapter");
    L12:
        if (r11.getItemCount() <= 0) goto L14;
        int r13 = R();
        this.f9299r = r13;
        scrollToPosition(r13);
        setPlay(true);
        return;
    L10:
        r11 = r12;
    L14:
        this.f9299r = 0;
    }

    private final void setBannerAdapter(BaseRecyclerBannerAdapter<?> r10) {
        boolean r11 = false;
        setPlay(false);
        this.f9293l = false;
        this.f9295n = r10;
        if (this.f9297p >= r10.a()) goto L5;
        r11 = true;
    L5:
        BaseRecyclerBannerAdapter r12 = this.f9295n;
        if (r12 != null) goto L8;
        q.y("bannerAdapter");
        r12 = null;
    L8:
        r12.e(r11);
        super.setAdapter(r10);
        U();
        this.f9293l = true;
    }

    public final int R() {
        BaseRecyclerBannerAdapter r10 = this.f9295n;
        if (r10 != null) goto L6;
        q.y("bannerAdapter");
        r10 = null;
    L6:
        if (r10.a() != 0) goto L9;
        return 0;
    L9:
        BaseRecyclerBannerAdapter r11 = this.f9295n;
        if (r11 != null) goto L12;
        q.y("bannerAdapter");
        r11 = null;
    L12:
        int r12 = r11.getItemCount() / 2;
        BaseRecyclerBannerAdapter r13 = this.f9295n;
        if (r13 != null) goto L16;
        q.y("bannerAdapter");
        r13 = null;
    L16:
        if ((r12 % r13.a()) != 0) goto L18;
        return r12;
    L18:
        BaseRecyclerBannerAdapter r14 = this.f9295n;
        if (r14 != null) goto L22;
        q.y("bannerAdapter");
        r14 = null;
    L22:
        if ((r12 % r14.a()) == 0) goto L24;
        r12 = r12 + 1;
        goto L18
    L24:
        return r12;
    }

    public final void T() {
        int r10 = this.f9299r + this.f9297p;
        this.f9299r = r10;
        smoothScrollToPosition(r10);
        this.f9302u.sendEmptyMessageDelayed(1000, this.f9298q);
    }

    @Override // com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getAction());
    L6:
        if (r11 == null) goto L12;
        if (r11.intValue() != 0) goto L12;
        setPlay(false);
    L27:
        return super.dispatchTouchEvent(r10);
    L24:
        e = move-exception;
        e.printStackTrace();
        return false;
    L12:
        if (r11 != null) goto L15;
    L17:
        if (r11 == null) goto L27;
        if (r11.intValue() != 3) goto L27;
        setPlay(true);
        goto L27
    L15:
        if (r11.intValue() != 1) goto L17;
        setPlay(true);
        goto L27
    L4:
        r11 = null;
        goto L6
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        if (r10 != 0) goto L5;
        U();
        return;
    L5:
        scrollToPosition(this.f9296o.findFirstCompletelyVisibleItemPosition());
        setPlay(false);
        this.f9302u.removeMessages(1000);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int r10) {
        w7.a r11 = this.f9294m;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.y(r10) == true) goto L9;
        super.scrollToPosition(r10);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof BaseRecyclerBannerAdapter) == false) goto L9;
        setBannerAdapter((BaseRecyclerBannerAdapter) r10);
        return;
    L9:
        throw new IllegalArgumentException("You need to set a TvRecyclerBannerBaseAdapter for TvRecyclerBannerView!");
    }

    public final void setOnBannerExposeListener(@NotNull BannerExposeListener r10) {
        q.g(r10, "listener");
        this.f9301t = r10;
    }

    public final synchronized void setPlay(boolean r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f9293l == false) goto L14;
        boolean r11 = this.f9300s;     // Catch: Throwable -> L9
        if (r11 == true) goto L11;
        if (r10 == false) goto L11;
        this.f9302u.removeMessages(1000);     // Catch: Throwable -> L9
        this.f9302u.sendEmptyMessageDelayed(1000, this.f9298q);     // Catch: Throwable -> L9
        this.f9300s = true;     // Catch: Throwable -> L9
    L11:
        if (r11 == false) goto L14;
        if (r10 == true) goto L14;
        this.f9302u.removeMessages(1000);     // Catch: Throwable -> L9
        this.f9300s = false;     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
    }

    public final void setSpansPerPage(int r10) {
        this.f9297p = r10;
        w7.a r11 = new w7.a(r10);
        this.f9294m = r11;
        r11.b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int r10) {
        w7.a r11 = this.f9294m;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.z(r10) == true) goto L9;
        super.smoothScrollToPosition(r10);
        return;
    }
}
