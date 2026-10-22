package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/module/ListItemBottomCarryNewView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListItemBottomCarryNewView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lazy<? extends i> f150101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ll.a f150102b;

    public ListItemBottomCarryNewView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ListItemBottomCarryNewView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        Lazy<? extends i> r100 = this.f150101a;
        if (r100 != null) goto L5;
    L11:
        setVisibility(8);
        return;
    L5:
        if (r100.isInitialized() != true) goto L11;
        Lazy<? extends i> r101 = this.f150101a;
        if (r101 == null) goto L11;
        i r102 = r101.getValue();
        if (r102 == null) goto L11;
        r102.b(this);
        goto L11
    }

    public final void b() {
        Lazy<? extends i> r100 = this.f150101a;
        if (r100 != null) goto L5;
    L11:
        setVisibility(8);
        return;
    L5:
        if (r100.isInitialized() != true) goto L11;
        Lazy<? extends i> r101 = this.f150101a;
        if (r101 == null) goto L11;
        i r102 = r101.getValue();
        if (r102 == null) goto L11;
        r102.d(this);
        goto L11
    }

    public ListItemBottomCarryNewView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ListItemBottomCarryNewView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
