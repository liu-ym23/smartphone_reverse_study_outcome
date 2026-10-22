package com.bytedance.android.livesdk.feed.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/feed/ui/FeedTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setBackOnClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedTitleBar extends ConstraintLayout {
    public FeedTitleBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FeedTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setBackOnClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        findViewById(R.id.feed_title_left_right).setOnClickListener(r100);
    }

    public FeedTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewGroup.inflate(getContext(), R.layout.ttlive_view_feed_title, this);
    }

    public final void R5(String r100, Drawable r101, boolean r102) {
        if (r100 != null) goto L5;
    L10:
        View r103 = findViewById(R.id.feed_title_left_right);
        if (r102 == true) goto L13;
        UtilityKotlinExtentionsKt.z(r103, false);
        return;
    L13:
        UtilityKotlinExtentionsKt.z(r103, true);
        if (r101 == null) goto L18;
        r103.setBackground(r101);
        return;
    L18:
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 != true) goto L10;
        ((TextView) findViewById(R.id.feed_title)).setText(r100);
        goto L10
    L7:
        r104 = false;
        goto L8
    }

    public /* synthetic */ FeedTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
