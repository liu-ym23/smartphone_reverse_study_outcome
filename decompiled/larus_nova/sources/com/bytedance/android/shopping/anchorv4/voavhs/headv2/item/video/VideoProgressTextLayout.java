package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/item/video/VideoProgressTextLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressTextLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f169778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f169779b;

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

    public VideoProgressTextLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TextView r102 = b(-1);
        this.f169778a = r102;
        int r103 = (int) 2164260863L;
        TextView r104 = b(r103);
        this.f169779b = r104;
        addView(r102);
        TextView r105 = b(r103);
        ViewExtensionsKt.h(r105, 12);
        r105.setText(HTTP.URL_DEFAULT);
        Unit r106 = Unit.INSTANCE;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r107.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        addView(r105, r107);
        addView(r104);
        setGravity(17);
        setOrientation(0);
    }
}
