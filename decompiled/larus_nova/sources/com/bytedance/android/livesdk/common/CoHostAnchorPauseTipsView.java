package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/common/CoHostAnchorPauseTipsView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "getPauseView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CoHostAnchorPauseTipsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f119662a;

    public final AnchorPauseTipsView getPauseView() {
        if (this.f119662a != null) goto L5;
        this.f119662a = new LinkedHashMap();
    L5:
        Map<Integer, View> r100 = this.f119662a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(Integer.valueOf(R.id.pause_view));
        if (r102 != null) goto L12;
        r102 = findViewById(R.id.pause_view);
        if (r102 == null) goto L10;
        this.f119662a.put(Integer.valueOf(R.id.pause_view), r102);
        goto L12
    L10:
        r102 = null;
    L12:
        return (AnchorPauseTipsView) r102;
    }

    public CoHostAnchorPauseTipsView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f119662a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_co_host_anchor_pause_tips, this);
    }

    public CoHostAnchorPauseTipsView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f119662a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_co_host_anchor_pause_tips, this);
    }

    public CoHostAnchorPauseTipsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f119662a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_co_host_anchor_pause_tips, this);
    }
}
