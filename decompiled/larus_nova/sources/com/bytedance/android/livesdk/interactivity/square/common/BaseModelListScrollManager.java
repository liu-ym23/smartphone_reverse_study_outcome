package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import com.bytedance.android.livesdk.utils.x0;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class BaseModelListScrollManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollState f141113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScrollState f141114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f141115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f141116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SmoothLinearLayoutManager f141117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnonymousClass3 f141118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f141119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IModelListDataManager f141120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f141121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RecyclerView f141122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f141123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f141124l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/common/BaseModelListScrollManager$ScrollState;", "", "AutoScroll", "Focus", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState AutoScroll = null;
        public static final ScrollState Focus = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollState[] f141127a = null;

        static {
            ScrollState r100 = new ScrollState("AutoScroll", 0);
            AutoScroll = r100;
            ScrollState r101 = new ScrollState("Focus", 1);
            Focus = r101;
            f141127a = new ScrollState[]{r100, r101};
        }

        public static ScrollState valueOf(String r100) {
            return (ScrollState) r27.a.a(ScrollState.class, r100);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) f141127a.clone();
        }

        public ScrollState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.f141122j.canScrollVertically(1) == true) goto L5;
        return;
    L5:
        RecyclerView.Adapter r100 = this.f141122j.getAdapter();
        if (r100 == null) goto L9;
        int r101 = r100.getItemCount() - 1;
        this.f141122j.scrollToPosition(r101);
        b(r101);
        return;
    }

    public static final void a(BaseModelListScrollManager r100) {
        int r101 = r100.f141117e.findLastVisibleItemPosition();
        if (r101 <= r100.f141115c) goto L11;
        IModelListDataManager r102 = r100.f141120h;
        if (r102 == null) goto L9;
        m52.e r103 = r102.c();
        if (r103 == null) goto L9;
        r103.a(Math.max(r103.f512104a - (r101 - r100.f141115c), 0));
    L9:
        r100.b(r101);
        return;
    }

    public final void b(int r100) {
        this.f141115c = Math.max(r100, 0);
    }

    public final void d(ScrollState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = b.f141129a[r100.ordinal()];
        if (r101 != 1) goto L5;
        IModelListDataManager r102 = this.f141120h;
        if (r102 == null) goto L17;
        m52.e r103 = r102.c();
        if (r103 == null) goto L17;
        r103.f512106c = false;
        r103.a(0);
    L17:
        c();
    L18:
        this.f141113a = r100;
        return;
    L5:
        if (r101 != 2) goto L18;
        IModelListDataManager r104 = this.f141120h;
        if (r104 == null) goto L18;
        m52.e r105 = r104.c();
        if (r105 == null) goto L18;
        r105.f512106c = true;
        goto L18
    }

    public final void onEvent(IModelListDataManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IModelListDataManager.ModelChangeType r101 = r100.getType();
        int r102 = b.f141130b[r101.ordinal()];
        if (r102 != 1) goto L5;
        int r103 = r100.f133738b;
        int r104 = this.f141115c;
        if (r103 > r104) goto L20;
        b(r104 + 1);
        return;
    L20:
        return;
    L5:
        if (r102 != 2) goto L21;
        int r105 = this.f141115c;
        int r106 = r100.f133740d;
        if (r105 < r106) goto L10;
        b(r105 - (r106 - r100.f133739c));
        return;
    L10:
        int r107 = r100.f133739c;
        if (r105 < r107) goto L18;
        b(r107);
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.bytedance.android.livesdk.interactivity.square.common.BaseModelListScrollManager$3] */
    public BaseModelListScrollManager(RecyclerView r100, View r101, NoMoreSpaceTextView r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "hintLayout");
        Intrinsics.checkNotNullParameter(r102, "hintTextView");
        this.f141122j = r100;
        this.f141123k = r101;
        this.f141124l = r102;
        ScrollState r104 = ScrollState.AutoScroll;
        this.f141113a = r104;
        this.f141114b = r104;
        this.f141121i = true;
        r101.setOnClickListener(x0.a(new AnonymousClass1(this)));
        SmoothLinearLayoutManager r105 = new SmoothLinearLayoutManager(r100.getContext());
        r105.p(r103);
        Unit r106 = Unit.INSTANCE;
        this.f141117e = r105;
        ?? r107 = new AnonymousClass3(this);
        this.f141118f = r107;
        RecyclerView.OnFlingListener r108 = new AnonymousClass4(this);
        com.bytedance.android.livesdk.interactivity.square.common.a r109 = new com.bytedance.android.livesdk.interactivity.square.common.a(this);
        r100.setItemAnimator(null);
        r100.setLayoutManager(r105);
        r100.addOnScrollListener(r107);
        r100.setOnFlingListener(r108);
        r100.setOnTouchListener(r109);
    }
}
