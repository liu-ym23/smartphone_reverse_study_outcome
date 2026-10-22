package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/browser/webview/fragment/HybridDebugConsoleDialog$HybridDebugConsoleViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridDebugConsoleDialog$HybridDebugConsoleViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f64340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f64341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f64342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f64343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f64344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RelativeLayout f64345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f64346g;

    public HybridDebugConsoleDialog$HybridDebugConsoleViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f64340a = (TextView) r100.findViewById(R.id.msg_time);
        this.f64341b = (TextView) r100.findViewById(R.id.msg_title);
        this.f64342c = (TextView) r100.findViewById(R.id.msg_subTitle);
        this.f64343d = (TextView) r100.findViewById(R.id.msg_content1);
        this.f64344e = (TextView) r100.findViewById(R.id.msg_content2);
        this.f64345f = (RelativeLayout) r100.findViewById(R.id.msg_rl);
        this.f64346g = (LinearLayout) r100.findViewById(R.id.msg_ll);
    }
}
