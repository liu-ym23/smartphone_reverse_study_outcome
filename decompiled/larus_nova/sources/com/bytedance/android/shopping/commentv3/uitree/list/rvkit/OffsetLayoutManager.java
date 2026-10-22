package com.bytedance.android.shopping.commentv3.uitree.list.rvkit;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.comment.WrapContentGridLayoutManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/OffsetLayoutManager;", "Lcom/bytedance/android/shopping/anchorv3/comment/WrapContentGridLayoutManager;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffsetLayoutManager extends WrapContentGridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f172841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f172842b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        if (getChildCount() != 0) goto L53;
        return 0;
    L53:
        int r111 = findFirstVisibleItemPosition();     // Catch: Exception -> L50
        View r100 = findViewByPosition(r111);     // Catch: Exception -> L50
        if (r100 == null) goto L8;
        float r101 = r100.getY();     // Catch: Exception -> L50
    L9:
        float r102 = -r101;
        int r103 = 0;
    L10:
        if (r103 >= r111) goto L49;
        Integer r104 = (Integer) ((HashMap) this.f172841a.getValue()).get(Integer.valueOf(r103));     // Catch: Exception -> L50
        if (r104 != null) goto L14;
        r104 = 0;     // Catch: Exception -> L50
    L14:
        r102 = r102 + r104.intValue();     // Catch: Exception -> L50
        RecyclerView.Adapter r105 = this.f172842b.getAdapter();     // Catch: Exception -> L50
        if (r105 == null) goto L17;
        int r106 = r105.getItemViewType(r103);     // Catch: Exception -> L50
    L18:
        boolean r112 = true;
        if (r106 == 5) goto L27;
        if (r106 == 51) goto L27;
        if (r106 == 8) goto L27;
        if (r106 == Integer.MIN_VALUE) goto L27;
        if (r106 == 2) goto L27;
        if (r106 == 21) goto L27;
        boolean r107 = false;
    L28:
        if (r107 == true) goto L47;
        int r108 = r103 + 1;     // Catch: Exception -> L50
        if (r108 > r111) goto L34;
        RecyclerView.Adapter r113 = this.f172842b.getAdapter();     // Catch: Exception -> L50
        if (r113 == null) goto L34;
        int r109 = r113.getItemViewType(r108);     // Catch: Exception -> L50
    L35:
        if (r109 == 0) goto L47;
        if (r109 == 5) goto L44;
        if (r109 == 51) goto L44;
        if (r109 == 8) goto L44;
        if (r109 == Integer.MIN_VALUE) goto L44;
        if (r109 == 2) goto L44;
        if (r109 == 21) goto L44;
        r112 = false;
    L44:
        if (r112 == true) goto L47;
        r102 = r102 + com.bytedance.android.shopping.extensions.b.b(8);
    L34:
        r109 = 0;
    L47:
        r103 = r103 + 1;
    L27:
        r107 = true;
        goto L28
    L17:
        r106 = 0;
        goto L18
    L49:
        return (int) r102;
    L8:
        r101 = 0.0f;
    L50:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return 0;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        int r101 = getChildCount();
        if (r101 > 0) goto L5;
        return;
    L5:
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L10;
        int r104 = getPosition(r103);
        ((HashMap) this.f172841a.getValue()).put(Integer.valueOf(r104), Integer.valueOf(r103.getHeight()));
    L10:
        r102 = r102 + 1;
        goto L6
    }

    public OffsetLayoutManager(RecyclerView r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "hostRv");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101);
        this.f172842b = r100;
        this.f172841a = LazyKt.lazy(OffsetLayoutManager$heightMap$2.INSTANCE);
    }
}
