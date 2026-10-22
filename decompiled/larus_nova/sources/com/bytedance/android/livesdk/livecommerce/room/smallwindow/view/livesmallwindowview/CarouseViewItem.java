package com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.livesmallwindowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview.CarouselView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yi2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/livesmallwindowview/CarouseViewItem;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/carouseview/CarouselView$b;", "Lyi2/b;", "getData", "Landroid/view/View;", "getView", "", "getRollingInterval", "()Ljava/lang/Long;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarouseViewItem extends FrameLayout implements CarouselView.b {

    public static final class a {
    }

    static {
    }

    public CarouseViewItem(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CarouseViewItem(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final b getData() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview.CarouselView.b
    public Long getRollingInterval() {
        return -1L;
    }

    public CarouseViewItem(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        th.a.c(r100, R.layout.ec_live_small_window_carouse_view_item, this, true);
        ECDraweeView r103 = (ECDraweeView) findViewById(R.id.icon);
        TextView r104 = (TextView) findViewById(R.id.desc);
    }

    public /* synthetic */ CarouseViewItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
