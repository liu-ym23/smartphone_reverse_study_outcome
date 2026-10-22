package com.bytedance.android.livesdk.vs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/vs/LiveBlurAnimView;", "Landroid/widget/FrameLayout;", "", "getCurrentAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBlurAnimView extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f159363e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f159364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f159365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f159366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f159367d;

    public static final class a {
    }

    static {
    }

    public LiveBlurAnimView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveBlurAnimView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getCurrentAlpha() {
        return this.f159367d;
    }

    public LiveBlurAnimView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f159366c = 15;
        Context r103 = getContext();
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -1);
        r104.gravity = 17;
        HSImageView r105 = new HSImageView(r103);
        r105.setLayoutParams(r104);
        r105.setVisibility(0);
        r105.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f159364a = r105;
        Context r106 = getContext();
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -1);
        r107.gravity = 17;
        HSImageView r108 = new HSImageView(r106);
        r108.setLayoutParams(r107);
        r108.setVisibility(0);
        r108.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f159365b = r108;
        addView(r105);
        addView(r108);
    }

    public /* synthetic */ LiveBlurAnimView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
