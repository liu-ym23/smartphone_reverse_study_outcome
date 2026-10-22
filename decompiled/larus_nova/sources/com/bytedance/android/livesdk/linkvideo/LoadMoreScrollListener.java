package com.bytedance.android.livesdk.linkvideo;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.dito.data.DitoNode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/LoadMoreScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f147112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f147113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GridLayoutManager f147114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f147115d;

    public static final class a {
    }

    static {
    }

    public LoadMoreScrollListener(GridLayoutManager r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, DitoNode.LOAD_MORE);
        this.f147114c = r100;
        this.f147115d = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L10;
        int r102 = this.f147114c.getItemCount();
        if (this.f147113b == 0) goto L7;
        return;
    L7:
        if (this.f147112a != (r102 - 1)) goto L12;
        this.f147113b = 1;
        this.f147115d.invoke();
        return;
    L12:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        this.f147112a = this.f147114c.findLastVisibleItemPosition();
    }
}
