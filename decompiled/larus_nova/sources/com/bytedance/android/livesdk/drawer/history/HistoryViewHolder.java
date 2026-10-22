package com.bytedance.android.livesdk.drawer.history;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.view.LiveCircleView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/history/HistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", RXScreenCaptureService.KEY_INDEX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HistoryViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f122429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveCircleView f122430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f122431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f122432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f122433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.core.view.a f122434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f122435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f122436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f122437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f122438j;

    public final Context getContext() {
        return this.f122437i;
    }

    public HistoryViewHolder(View r100, Context r101, e r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "itemview");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f122436h = r100;
        this.f122437i = r101;
        this.f122438j = r102;
        HSImageView r104 = (HSImageView) this.itemView.findViewById(R.id.history_cover);
        this.f122429a = r104;
        LiveCircleView r105 = (LiveCircleView) r100.findViewById(R.id.history_live_circle);
        this.f122430b = r105;
        this.f122431c = (ImageView) this.itemView.findViewById(R.id.history_icon_tag);
        this.f122432d = (TextView) r100.findViewById(R.id.history_nickname);
        this.f122433e = (TextView) r100.findViewById(R.id.history_title);
        this.f122434f = new com.bytedance.android.live.core.view.a(r104, r105, Boolean.FALSE);
        FrameLayout r106 = (FrameLayout) this.itemView.findViewById(R.id.circle_container);
        this.f122435g = r106;
        LinearLayout r107 = (LinearLayout) this.itemView.findViewById(R.id.history_anchor_info);
        if (r103 == false) goto L13;
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
        if (r108 == null) goto L12;
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
        ((ViewGroup.MarginLayoutParams) r109).leftMargin = s1.f(0.0f);
        r106.setLayoutParams(r109);
        ViewGroup.LayoutParams r110 = r107.getLayoutParams();
        if (r110 == null) goto L10;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        ((ViewGroup.MarginLayoutParams) r111).leftMargin = s1.f(10.0f);
        r107.setLayoutParams(r111);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
