package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductCardAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SimilarProductFeedbackView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFeedbackView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f182536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f182537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimilarProductCardAdapter f182538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f182539d;

    public SimilarProductFeedbackView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimilarProductFeedbackView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f182537b = -1;
        RecyclerView r101 = this.f182539d;
        if (r101 == null) goto L5;
        this.f182537b = r101.getChildAdapterPosition(r100);
    L5:
        HashSet<String> r102 = l63.a.f507661a;
        int r103 = l63.a.f507662b;
        SimilarProductCardAdapter r104 = this.f182538c;
        if (r104 != null) goto L8;
        return;
    L8:
        if (r103 == this.f182537b) goto L15;
        if (r103 >= 0) goto L11;
        return;
    L11:
        if (r103 >= r104.getItemCount()) goto L17;
        r104.notifyItemChanged(r103, 1);
        return;
    L17:
        return;
    }

    public final void b(boolean r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        if (r100 == false) goto L5;
        setVisibility(0);
        a(r101);
        HashSet<String> r102 = l63.a.f507661a;
        l63.a.f507662b = this.f182537b;
        return;
    L5:
        setVisibility(8);
    }

    public SimilarProductFeedbackView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f182537b = -1;
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_similar_product_feedback_view, this);
        this.f182536a = (LinearLayout) findViewById(R.id.ec_similar_product_feedback_container);
    }

    public /* synthetic */ SimilarProductFeedbackView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
