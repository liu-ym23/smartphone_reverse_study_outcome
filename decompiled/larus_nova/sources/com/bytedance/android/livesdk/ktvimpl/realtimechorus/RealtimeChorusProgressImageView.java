package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealtimeChorusProgressImageView;", "Landroid/widget/FrameLayout;", "", "text", "", "setText", "", "color", "setTextColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealtimeChorusProgressImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoundCornerProgressBar f146452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f146453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f146454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f146455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f146456e;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.core.utils.q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeChorusProgressImageView f146457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ py.k f146458b;

        @Override // com.bytedance.android.live.core.utils.q0, com.bytedance.android.live.core.utils.p0
        public final void d(ImageInfo r100) {
            if ((r100 instanceof CloseableStaticBitmap) == false) goto L13;
            Bitmap r101 = ((CloseableStaticBitmap) r100).getUnderlyingBitmap();
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.isRecycled() == true) goto L15;
            Bitmap.Config r102 = r101.getConfig();
            if (r102 != null) goto L11;
            r102 = Bitmap.Config.ARGB_8888;
        L11:
            Bitmap r103 = r101.copy(r102, true);
            RealtimeChorusProgressImageView r104 = this.f146457a;
            r104.f146455d = new BitmapDrawable(s1.getResources(), r103);
            return;
        L15:
            return;
        }

        public b(RealtimeChorusProgressImageView r100, py.k r101) {
            this.f146457a = r100;
            this.f146458b = r101;
        }
    }

    static {
    }

    public RealtimeChorusProgressImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealtimeChorusProgressImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(py.k r100) {
        HSImageView r101 = this.f146454c;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r101);
        com.bytedance.android.live.ui.k.d(r101, r100, this.f146455d, ImageView.ScaleType.FIT_XY, 0, new b(this, r100));
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f146453b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTextColor(int r100) {
        TextView r101 = this.f146453b;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public RealtimeChorusProgressImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ RealtimeChorusProgressImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
