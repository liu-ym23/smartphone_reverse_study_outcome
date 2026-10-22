package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import bc3.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/CommentIndicatorLayout;", "Landroid/widget/LinearLayout;", "Lbc3/d;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentIndicatorLayout extends LinearLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CommentIndicatorView> f172408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f172409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f172410c;

    public CommentIndicatorLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentIndicatorLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // bc3.d
    public final void onItemSelected(int r100) {
        Iterator r101 = ((ArrayList) this.f172408a).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L19;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CommentIndicatorView r105 = (CommentIndicatorView) r103;
        if (r102 != r100) goto L15;
        int r106 = this.f172410c;
        if (r106 <= 0) goto L14;
        if (r100 >= r106) goto L14;
        r105.setIndicatorSelected(false);
    L18:
        r102 = r104;
    L14:
        r105.setIndicatorSelected(true);
        goto L18
    L15:
        if (r102 >= r100) goto L17;
        r105.setIndicatorSelected(true);
        goto L18
    L17:
        r105.setIndicatorSelected(false);
        goto L18
    }

    public CommentIndicatorLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172408a = new ArrayList();
        setOrientation(0);
    }

    public /* synthetic */ CommentIndicatorLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
