package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/PdpGalleryVideoButtonView;", "Landroid/widget/FrameLayout;", "", "resId", "", "setImageResource", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpGalleryVideoButtonView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f169440a;

    public PdpGalleryVideoButtonView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PdpGalleryVideoButtonView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setImageResource(int r100) {
        this.f169440a.setImageResource(r100);
    }

    public PdpGalleryVideoButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ImageView r103 = new ImageView(r100);
        this.f169440a = r103;
        r103.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit r104 = Unit.INSTANCE;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(32), com.bytedance.android.shopping.extensions.b.a(32));
        r105.gravity = 17;
        addView(r103, r105);
    }

    public /* synthetic */ PdpGalleryVideoButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
