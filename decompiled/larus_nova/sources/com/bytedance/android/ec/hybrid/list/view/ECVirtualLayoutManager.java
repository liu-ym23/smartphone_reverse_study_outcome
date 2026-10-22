package com.bytedance.android.ec.hybrid.list.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/view/ECVirtualLayoutManager;", "Lcom/bytedance/android/ec/vlayout/VirtualLayoutManager;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVirtualLayoutManager extends VirtualLayoutManager {
    public final List<a> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f47418J;

    public interface a {
        void a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int findFirstCompletelyVisibleItemPosition() {
        return ((Number) kk.d.a(0, new C98451(this))).intValue();
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public final int findFirstVisibleItemPosition() {
        return ((Number) kk.d.a(0, new C98461(this))).intValue();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int findLastCompletelyVisibleItemPosition() {
        return ((Number) kk.d.a(0, new C98471(this))).intValue();
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public final int findLastVisibleItemPosition() {
        return ((Number) kk.d.a(0, new C98481(this))).intValue();
    }

    @Override // com.bytedance.android.ec.vlayout.VirtualLayoutManager
    public final List<View> Q() {
        return (List) kk.d.a(new ArrayList(), new ECVirtualLayoutManager$getFixedViews$1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return this.f47418J;
    }

    public ECVirtualLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 0);
        this.I = new ArrayList();
        new Rect();
        this.f47418J = true;
    }

    public static final /* synthetic */ int Z(ECVirtualLayoutManager r100) {
        return super.findFirstCompletelyVisibleItemPosition();
    }

    public static final /* synthetic */ int a0(ECVirtualLayoutManager r100) {
        return super.findFirstVisibleItemPosition();
    }

    public static final /* synthetic */ int b0(ECVirtualLayoutManager r100) {
        return super.findLastCompletelyVisibleItemPosition();
    }

    public static final /* synthetic */ int c0(ECVirtualLayoutManager r100) {
        return super.findLastVisibleItemPosition();
    }

    public static final /* synthetic */ List d0(ECVirtualLayoutManager r100) {
        return super.Q();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(final RecyclerView.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return ((Number) kk.d.a(0, new AnonymousClass1(this, r100))).intValue();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(final RecyclerView.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return ((Number) kk.d.a(0, new C98441(this, r100))).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.bytedance.android.ec.vlayout.b
    public final int getPosition(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return ((Number) kk.d.a(0, new C98491(this, r100))).intValue();
    }

    public static final /* synthetic */ int X(ECVirtualLayoutManager r100, RecyclerView.State r101) {
        return super.computeHorizontalScrollOffset(r101);
    }

    public static final /* synthetic */ int Y(ECVirtualLayoutManager r100, RecyclerView.State r101) {
        return super.computeVerticalScrollOffset(r101);
    }

    public static final /* synthetic */ int e0(ECVirtualLayoutManager r100, View r101) {
        return super.getPosition(r101);
    }

    @Override // com.bytedance.android.ec.vlayout.VirtualLayoutManager, com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        RecyclerView r102 = this.f49081s;     // Catch: Exception -> L5
        RecyclerView.ItemAnimator r103 = null;
        if (r102 == null) goto L7;
        RecyclerView.ItemAnimator r104 = r102.getItemAnimator();     // Catch: Exception -> L5
    L9:
        if ((r104 instanceof SimpleItemAnimator) == false) goto L12;
        r103 = r104;
    L12:
        SimpleItemAnimator r105 = (SimpleItemAnimator) r103;     // Catch: Exception -> L5
        if (r105 == null) goto L15;
        r105.setSupportsChangeAnimations(false);     // Catch: Exception -> L5
    L15:
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L5
        return;
    L7:
        r104 = null;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "ECVirtualLayoutManager#onLayoutChildren");
    }

    @Override // com.bytedance.android.ec.vlayout.VirtualLayoutManager, com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public final int F(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.F(r100, r101, r102);
    L4:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "ECVirtualLayoutManager#scrollInternalBy");
        return 0;
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Iterator r103 = ((ArrayList) this.I).iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        ((a) r103.next()).a();
        goto L4
    L7:
        return super.scrollVerticallyBy(r100, r101, r102);
    }
}
