package com.bytedance.android.shopping.deepfeed.weights.video;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoProgressTextLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressTextLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f174281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f174282b;

    public VideoProgressTextLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoProgressTextLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static String a(int r100) {
        int r101 = r100 / 60;
        int r102 = r100 % 60;
        StringBuilder r103 = new StringBuilder();
        if (r101 >= 10) goto L5;
        String r104 = "0" + r101;
    L6:
        r103.append(r104);
        r103.append(':');
        if (r102 >= 10) goto L9;
        String r105 = "0" + r102;
    L10:
        r103.append(r105);
        return r103.toString();
    L9:
        r105 = String.valueOf(r102);
        goto L10
    L5:
        r104 = String.valueOf(r101);
        goto L6
    }

    public final TextView b(int r100) {
        TextView r101 = new TextView(getContext());
        ViewExtensionsKt.h(r101, 24);
        r101.setTypeface(Typeface.DEFAULT_BOLD);
        r101.setTextColor(r100);
        r101.setLineSpacing(q.a(8), 1.0f);
        return r101;
    }

    public VideoProgressTextLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = b(-1);
        this.f174281a = r103;
        int r104 = (int) 2164260863L;
        TextView r105 = b(r104);
        this.f174282b = r105;
        addView(r103);
        TextView r106 = b(r104);
        ViewExtensionsKt.h(r106, 12);
        r106.setText(HTTP.URL_DEFAULT);
        Unit r107 = Unit.INSTANCE;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        r108.leftMargin = b.a(12);
        r108.rightMargin = b.a(12);
        addView(r106, r108);
        addView(r105);
        setGravity(17);
        setOrientation(0);
    }

    public /* synthetic */ VideoProgressTextLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
