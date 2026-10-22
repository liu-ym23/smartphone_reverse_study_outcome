package com.bytedanceos.appstore.buss.widget.recyclerbanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.appstore.R$styleable;
import com.bytedanceos.appstore.buss.utilities.j;
import com.bytedanceos.appstore.buss.widget.recyclerview.SnapRecyclerView;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerBannerView extends SnapRecyclerView {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f9305w = "RecyclerBannerView";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BaseRecyclerBannerAdapter f9306n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayoutManager f9307o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9308p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9309q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9310r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9311s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9312t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9313u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Handler f9314v;

    public interface OnBannerItemClickListener {
        void onItemClick(int r10);
    }

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerBannerView f9315a;

        public a(RecyclerBannerView r10) {
            this.f9315a = r10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r10) {
            if (r10.what != 1000) goto L8;
            RecyclerBannerView r11 = this.f9315a;
            RecyclerBannerView.R(r11, RecyclerBannerView.S(r11));
            RecyclerBannerView r12 = this.f9315a;
            r12.smoothScrollToPosition(RecyclerBannerView.P(r12));
            RecyclerBannerView r13 = this.f9315a;
            r13.f9314v.sendEmptyMessageDelayed(1000, RecyclerBannerView.T(r13));
            return false;
        L8:
            return false;
        }
    }

    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerBannerView f9316a;

        public b(RecyclerBannerView r10) {
            this.f9316a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            if (r11 != 0) goto L5;
            RecyclerBannerView r12 = this.f9316a;
            RecyclerBannerView.Q(r12, RecyclerBannerView.U(r12).findFirstVisibleItemPosition());
            this.f9316a.setPlay(true);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r10, int r11, int r12) {
            if (r11 == 0) goto L5;
            this.f9316a.setPlay(false);
            return;
        }
    }

    static {
    }

    public RecyclerBannerView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int P(RecyclerBannerView r10) {
        return r10.f9311s;
    }

    public static /* synthetic */ int Q(RecyclerBannerView r10, int r11) {
        r10.f9311s = r11;
        return r11;
    }

    public static /* synthetic */ int R(RecyclerBannerView r10, int r11) {
        int r12 = r10.f9311s + r11;
        r10.f9311s = r12;
        return r12;
    }

    public static /* synthetic */ int S(RecyclerBannerView r10) {
        return r10.f9308p;
    }

    public static /* synthetic */ int T(RecyclerBannerView r10) {
        return r10.f9309q;
    }

    public static /* synthetic */ LinearLayoutManager U(RecyclerBannerView r10) {
        return r10.f9307o;
    }

    private int getStartPosition() {
        if (this.f9306n.a() != 0) goto L6;
        return 0;
    L6:
        int r10 = this.f9306n.getItemCount() / 2;
        if ((r10 % this.f9306n.a()) != 0) goto L10;
        return r10;
    L10:
        if ((r10 % this.f9306n.a()) == 0) goto L12;
        r10 = r10 + 1;
        goto L10
    L12:
        return r10;
    }

    public void V(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.RecyclerBannerView);
        this.f9309q = r12.getInt(1, AnimationConstants.DURATION_6000);
        this.f9313u = r12.getBoolean(0, true);
        this.f9308p = r12.getInt(2, 1);
        r12.recycle();
        LinearLayoutManager r13 = new LinearLayoutManager(r10, 0, false);
        this.f9307o = r13;
        setLayoutManager(r13);
        addOnScrollListener(new b(this));
    }

    public void W(boolean r10, boolean r11) {
        this.f9313u = r10;
        if (r11 == false) goto L6;
        setPlay(r10);
        return;
    }

    public void X() {
        BaseRecyclerBannerAdapter r10 = this.f9306n;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.b() == true) goto L8;
    L10:
        this.f9311s = 0;
        return;
    L8:
        if (this.f9306n.getItemCount() <= 0) goto L10;
        this.f9311s = getStartPosition();
        j.d(f9305w, "start play position = " + this.f9311s);
        scrollToPosition(this.f9311s);
        setPlay(true);
    }

    @Override // com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        setPlay(false);
    L16:
        return super.dispatchTouchEvent(r10);
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        if (r11 != 1) goto L7;
    L9:
        setPlay(true);
        goto L16
    L7:
        if (r11 == 3) goto L9;
        goto L9
    }

    public BaseRecyclerBannerAdapter getBannerAdapter() {
        return this.f9306n;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        j.d(f9305w, "onWindowVisibilityChanged = " + r10);
        super.onWindowVisibilityChanged(r10);
        if (r10 != 0) goto L5;
        setPlay(true);
        return;
    L5:
        scrollToPosition(this.f9307o.findFirstCompletelyVisibleItemPosition());
        setPlay(false);
        Handler r11 = this.f9314v;
        if (r11 == null) goto L10;
        r11.removeMessages(1000);
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

    public void setBannerAdapter(BaseRecyclerBannerAdapter r10) {
        setPlay(false);
        this.f9310r = false;
        this.f9306n = r10;
        if (this.f9308p >= r10.a()) goto L5;
        boolean r11 = true;
    L6:
        this.f9306n.e(r11);
        W(r11, false);
        super.setAdapter(r10);
        X();
        this.f9310r = true;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setInterval(int r10) {
        this.f9309q = r10;
    }

    public synchronized void setPlay(boolean r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f9313u == true) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.f9310r == false) goto L16;
        boolean r11 = this.f9312t;     // Catch: Throwable -> L11
        if (r11 == true) goto L13;
        if (r10 == false) goto L13;
        this.f9314v.removeMessages(1000);     // Catch: Throwable -> L11
        this.f9314v.sendEmptyMessageDelayed(1000, this.f9309q);     // Catch: Throwable -> L11
        this.f9312t = true;     // Catch: Throwable -> L11
    L13:
        if (r11 == false) goto L16;
        if (r10 == true) goto L16;
        this.f9314v.removeMessages(1000);     // Catch: Throwable -> L11
        this.f9312t = false;     // Catch: Throwable -> L11
        goto L16
    }

    public void setSpansPerPage(int r10) {
        this.f9308p = r10;
    }

    public RecyclerBannerView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.recyclerViewStyle);
    }

    public RecyclerBannerView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12, R.style.snap_recyclerview_pager_style);
        this.f9308p = 1;
        this.f9314v = new Handler(new a(this));
        V(r10, r11);
    }
}
