package com.bytedance.android.shopping.store.recommend.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/recommend/widget/PriceTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "price", "", "setPrice", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceTagView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbsoluteSizeSpan f185773a = null;

    public static final class a {
    }

    static {
        f185773a = new AbsoluteSizeSpan(13, true);
    }

    public final void setPrice(long r100) {
        long r101 = 100;
        if ((r100 % r101) != 0) goto L6;
        String r102 = String.valueOf(r100 / r101);
    L9:
        setText(r102);
        return;
    L6:
        if ((r100 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r102 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 100.0f)}, 1));
        goto L9
    L8:
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r102 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / 100.0f)}, 1));
        goto L9
    }

    public PriceTagView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        setTextSize(1, 11.0f);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        float r104 = r103 * 1.5f;
        if (r102 >= r103) goto L5;
        r100 = View.MeasureSpec.makeMeasureSpec((int) r104, View.MeasureSpec.getMode(r100));
    L5:
        super.onMeasure(r100, r101);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r110) {
        if (r100 != null) goto L5;
        super.setText(r100, r110);
        return;
    L5:
        String r101 = "¥" + r100;
        int r102 = StringsKt.indexOf$default(r101, ".", 0, false, 6, null);
        if (r102 >= 0) goto L8;
        r102 = r101.length();
    L8:
        SpannableString r103 = new SpannableString(r101);
        r103.setSpan(f185773a, 1, r102, 33);
        super.setText(r103, r110);
    }
}
