package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/HorizontalSplitTextViewGroup;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "getServiceView", "Ljava/util/Stack;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Stack;", "getPool", "()Ljava/util/Stack;", "pool", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HorizontalSplitTextViewGroup<T> extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack<TextView> f175875a;

    public HorizontalSplitTextViewGroup(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalSplitTextViewGroup(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final TextView getServiceView() {
        if (this.f175875a.isEmpty() == false) goto L7;
        return new TextView(getContext());
    L7:
        return this.f175875a.pop();
    }

    public final Stack<TextView> getPool() {
        return this.f175875a;
    }

    public void b(List<? extends T> r100) {
        Iterator<T> r101 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        View r102 = (View) r101.next();
        removeView(r102);
        Stack<TextView> r103 = this.f175875a;
        if (r102 == null) goto L9;
        r103.add((TextView) r102);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public HorizontalSplitTextViewGroup(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175875a = new Stack();
        setShowDividers(2);
        setOrientation(0);
    }

    public /* synthetic */ HorizontalSplitTextViewGroup(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
