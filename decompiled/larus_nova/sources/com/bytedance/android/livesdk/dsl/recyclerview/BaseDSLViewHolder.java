package com.bytedance.android.livesdk.dsl.recyclerview;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dsl/recyclerview/BaseDSLViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseDSLViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f122774a;

    public abstract c T3();

    public abstract void U3(b r100, boolean r101);

    public void V3() {
    }

    public final Context getContext() {
        return T3().getActivity();
    }

    public BaseDSLViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "slcView");
        super(r100);
    }
}
