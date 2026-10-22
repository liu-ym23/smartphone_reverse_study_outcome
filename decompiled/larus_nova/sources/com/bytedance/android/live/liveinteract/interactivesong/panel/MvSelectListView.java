package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectListView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectListView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMVTab f74107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f74108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f74109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvapi.model.mv.e<i> f74110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvapi.model.mv.i<i> f74111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MvSelectViewModel f74112f;

    public static final class a implements com.bytedance.android.livesdk.ktvapi.model.mv.i<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvSelectListView f74113a;

        public a(MvSelectListView r100) {
            this.f74113a = r100;
        }

        @Override // com.bytedance.android.livesdk.ktvapi.model.mv.i
        public final boolean G70(int r100, i r101) {
            Intrinsics.checkNotNullParameter(r101, "info");
            return false;
        }

        @Override // com.bytedance.android.livesdk.ktvapi.model.mv.i
        public final void G80(int r100, i r101, IMvPreviewViewHolder<i> r102, Function0 r103) {
            i r104 = r101;
            Intrinsics.checkNotNullParameter(r104, "panel");
            Intrinsics.checkNotNullParameter(r102, "vh");
            Intrinsics.checkNotNullParameter(r103, "unSelectedCb");
            com.bytedance.android.livesdk.ktvapi.model.mv.i<i> r105 = this.f74113a.f74111e;
            if (r105 == null) goto L6;
            r105.G80(r100, r104, r102, r103);
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvSelectListView f74114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f74115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f74116c;

        public b(MvSelectListView r100, boolean r101, List r102) {
            this.f74114a = r100;
            this.f74115b = r101;
            this.f74116c = r102;
        }

        public final void a() {
            MvSelectViewModel r100 = this.f74114a.f74112f;
            RecyclerView r101 = null;
            if (r100 == null) goto L5;
            i r102 = r100.getLastMvData();
        L6:
            if (r102 != null) goto L8;
            return;
        L8:
            if (this.f74115b == false) goto L29;
            List r103 = this.f74116c;
            MvSelectViewModel r104 = this.f74114a.f74112f;
            if (r104 == null) goto L12;
            i r105 = r104.getLastMvData();
        L13:
            int r106 = CollectionsKt.indexOf(r103, r105);
            com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r107 = this.f74114a.f74110d;
            if (r107 == null) goto L16;
            RecyclerView r108 = r107.c();
        L18:
            if ((r108 instanceof RecyclerView) == false) goto L21;
            r101 = r108;
        L21:
            if (r101 == null) goto L30;
            RecyclerView.ViewHolder r109 = r101.findViewHolderForAdapterPosition(r106);
            if (r109 == null) goto L31;
            View r110 = r109.itemView;
            if (r110 == null) goto L32;
            r110.performClick();
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L16:
            r108 = null;
            goto L18
        L12:
            r105 = null;
            goto L13
        L29:
            return;
        L5:
            r102 = null;
            goto L6
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
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f74117a;

        public c(Function0 r100) {
            this.f74117a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0 r101 = this.f74117a;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }
    }

    public MvSelectListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MvSelectListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public MvSelectListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f74107a = (IMVTab) vh7.f.c(IMVTab.class);
        com.bytedance.android.live.liveinteract.interactivesong.panel.c r103 = new com.bytedance.android.live.liveinteract.interactivesong.panel.c();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_mv_select_panel_mv_list_view, this);
        this.f74108b = (LinearLayout) findViewById(R.id.empty_view);
        this.f74109c = (FrameLayout) findViewById(R.id.btn_refresh);
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r104 = ((IKtvService) k.n(IKtvService.class)).createMvPreviewList(r100, r103);
        this.f74110d = r104;
        RecyclerView r105 = null;
        if (r104 == null) goto L7;
        RecyclerView r106 = r104.c();
        if (r106 == null) goto L7;
        ViewParent r107 = r106.getParent();
    L8:
        if (r107 == null) goto L23;
        if (r104 == null) goto L13;
        RecyclerView r108 = r104.c();
        if (r108 == null) goto L13;
        ViewParent r109 = r108.getParent();
    L15:
        if ((r109 instanceof ViewGroup) == true) goto L17;
        r109 = null;
    L17:
        ViewGroup r110 = (ViewGroup) r109;
        if (r110 == null) goto L23;
        if (r104 == null) goto L21;
        RecyclerView r111 = r104.c();
    L22:
        r110.removeView(r111);
        goto L23
    L21:
        r111 = null;
    L13:
        r109 = null;
    L23:
        if (r104 == null) goto L25;
        r104.d(r103);
    L25:
        if (r104 == null) goto L27;
        r104.a(new a(this));
    L27:
        if (r104 == null) goto L29;
        RecyclerView r112 = r104.c();
    L31:
        if ((r112 instanceof RecyclerView) == true) goto L33;
        r112 = null;
    L33:
        if (r112 == null) goto L35;
        r112.addOnScrollListener(new AnonymousClass2());
    L35:
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-1, -1);
        if (r104 == null) goto L38;
        r105 = r104.c();
    L38:
        addView(r105, r113);
        return;
    L29:
        r112 = null;
    L7:
        r107 = null;
        goto L8
    }

    public /* synthetic */ MvSelectListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(List<i> r100, String r101, boolean r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "mvList");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        if ((!Intrinsics.areEqual(this.f74107a.getName(), r101)) == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r104 = this.f74110d;
        if (r104 == null) goto L8;
        r104.b(r100);
    L8:
        post(new b(this, r102, r100));
        if (r100.isEmpty() == false) goto L18;
        LinearLayout r105 = this.f74108b;
        if (r105 == null) goto L13;
        r105.setVisibility(0);
    L13:
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r106 = this.f74110d;
        if (r106 == null) goto L26;
        RecyclerView r107 = r106.c();
        if (r107 == null) goto L26;
        r107.setVisibility(8);
    L26:
        FrameLayout r108 = this.f74109c;
        if (r108 == null) goto L30;
        r108.setOnClickListener(new c(r103));
        return;
    L30:
        return;
    L18:
        LinearLayout r109 = this.f74108b;
        if (r109 == null) goto L21;
        r109.setVisibility(8);
    L21:
        com.bytedance.android.livesdk.ktvapi.model.mv.e<i> r110 = this.f74110d;
        if (r110 == null) goto L26;
        RecyclerView r111 = r110.c();
        if (r111 == null) goto L26;
        r111.setVisibility(0);
        goto L26
    }
}
