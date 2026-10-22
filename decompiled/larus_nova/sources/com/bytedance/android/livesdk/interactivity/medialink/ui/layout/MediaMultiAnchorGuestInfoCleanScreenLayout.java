package com.bytedance.android.livesdk.interactivity.medialink.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/layout/MediaMultiAnchorGuestInfoCleanScreenLayout;", "Landroid/widget/FrameLayout;", "", "isPad", "", "setIsPad", "", "windowCount", "setWindowCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorGuestInfoCleanScreenLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f138288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f138289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f138290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f138291d;

    public MediaMultiAnchorGuestInfoCleanScreenLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MediaMultiAnchorGuestInfoCleanScreenLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setIsPad(boolean r100) {
        if (this.f138290c != r100) goto L5;
        return;
    L5:
        this.f138290c = r100;
        if (r100 == false) goto L8;
    L11:
        boolean r101 = true;
    L12:
        UtilityKotlinExtentionsKt.z(this.f138288a, r101);
        return;
    L8:
        if (this.f138291d <= 2) goto L11;
        r101 = false;
        goto L12
    }

    public final void setWindowCount(int r100) {
        if (this.f138291d != r100) goto L5;
        return;
    L5:
        this.f138291d = r100;
        if (this.f138290c == false) goto L8;
    L11:
        boolean r101 = true;
    L12:
        UtilityKotlinExtentionsKt.z(this.f138288a, r101);
        return;
    L8:
        if (r100 <= 2) goto L11;
        r101 = false;
        goto L12
    }

    public MediaMultiAnchorGuestInfoCleanScreenLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_media_multi_anchor_guest_info_clean_screen_layout, null, false);
        addView(r103);
        this.f138288a = (HSImageView) r103.findViewById(R.id.head_clear_screen);
        this.f138289b = (TextView) r103.findViewById(R.id.name_clear_screen);
    }

    public /* synthetic */ MediaMultiAnchorGuestInfoCleanScreenLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
