package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/ECCacheItemLinearLayout;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECCacheItemLinearLayout<T extends View> extends LinearLayout {

    public interface a<V extends View> {
        void a(V r100, int r101);

        V b();
    }

    public ECCacheItemLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECCacheItemLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(int r100, a<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "itemViewHelper");
        if (r100 != 0) goto L6;
        removeAllViews();     // Catch: Exception -> L28
        setVisibility(8);     // Catch: Exception -> L28
        return;
    L6:
        setVisibility(0);     // Catch: Exception -> L28
        int r102 = getChildCount();     // Catch: Exception -> L28
        int r103 = Math.max(r102, r100);     // Catch: Exception -> L28
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L39;
        if (r104 >= r102) goto L17;
        if (r104 >= r100) goto L17;
        View r105 = getChildAt(r104);     // Catch: Exception -> L28
        if (r105 == null) goto L13;
        r105.setVisibility(0);     // Catch: Exception -> L28
    L13:
        View r106 = getChildAt(r104);     // Catch: Exception -> L28
        if ((r106 instanceof View) == true) goto L16;
        r106 = null;
    L16:
        r101.a(r106, r104);     // Catch: Exception -> L28
    L27:
        r104 = r104 + 1;
    L17:
        if (r100 > r104) goto L23;
        if (r102 <= r104) goto L23;
        View r107 = getChildAt(r104);     // Catch: Exception -> L28
        if (r107 == null) goto L27;
        r107.setVisibility(8);     // Catch: Exception -> L28
    L23:
        if (r102 > r104) goto L27;
        if (r100 <= r104) goto L27;
        View r108 = r101.b();     // Catch: Exception -> L28
        r101.a(r108, r104);     // Catch: Exception -> L28
        addView(r108);     // Catch: Exception -> L28
        goto L27
    L39:
        return;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public ECCacheItemLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECCacheItemLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
