package com.android.ttcjpaysdk.base.framework.container.view.components;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.framework.container.drawable.CJPayStdSweepingDrawable;
import com.android.ttcjpaysdk.base.imageloader.ImageLoaderKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ui.component.pop.CJImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/SweepImageConfig;", "", "resId", "", "url", "", "topMargin", "scaleType", "Landroid/widget/ImageView$ScaleType;", "(Ljava/lang/Integer;Ljava/lang/String;ILandroid/widget/ImageView$ScaleType;)V", "getResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "getTopMargin", "()I", "getUrl", "()Ljava/lang/String;", "createImageView", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isResValid", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SweepImageConfig {
    private final Integer resId;
    private final ImageView.ScaleType scaleType;
    private final int topMargin;
    private final String url;

    public SweepImageConfig() {
        this(null, null, 0, null, 15, null);
    }

    private final boolean isResValid() {
        if (this.resId == null) goto L5;
        return true;
    L5:
        if (this.url.length() <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r100 = false;
        goto L8
    }

    public final Integer getResId() {
        return this.resId;
    }

    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    public final String getUrl() {
        return this.url;
    }

    public final CJImageView createImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (isResValid() == false) goto L11;
        CJImageView r101 = new CJImageView(r100, null, 0, 6, null);
        ViewGroup.MarginLayoutParams r102 = new ViewGroup.MarginLayoutParams(-1, -2);
        r102.setMargins(0, CJPayBasicExtensionKt.dp(this.topMargin), 0, 0);
        r101.setLayoutParams(r102);
        r101.setAdjustViewBounds(true);
        r101.setScaleType(this.scaleType);
        Integer r103 = this.resId;
        if (r103 == null) goto L7;
        r101.setImageResource(r103.intValue());
    L9:
        if (Build.VERSION.SDK_INT <= 23) goto L13;
        r101.setForeground(new CJPayStdSweepingDrawable());
        return r101;
    L13:
        return r101;
    L7:
        ImageLoaderKt.loadImageUrl(r101, this.url);
        goto L9
    L11:
        return null;
    }

    public SweepImageConfig(Integer r100, String r101, int r102, ImageView.ScaleType r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r103, "scaleType");
        this.resId = r100;
        this.url = r101;
        this.topMargin = r102;
        this.scaleType = r103;
    }

    public /* synthetic */ SweepImageConfig(Integer r100, String r101, int r102, ImageView.ScaleType r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = ImageView.ScaleType.FIT_CENTER;
    L14:
        this(r100, r101, r102, r103);
    }
}
