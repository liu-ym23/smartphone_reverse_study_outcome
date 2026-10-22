package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.d90;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/NormalCardBtn;", "Landroid/widget/FrameLayout;", "", "text", "", "setDesText", "setInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalCardBtn extends FrameLayout {
    public NormalCardBtn(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NormalCardBtn(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setDesText(String r100) {
        TextView r101 = new TextView(getContext());
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r100 = s1.B(R.string.ttlive_miniapp_card_btn_details);
    L11:
        r101.setText(r100);
        r101.setGravity(17);
        if (d90.f120014a.getValue().a() != 1) goto L14;
        r101.setTextSize(14.0f);
    L15:
        r101.setTypeface(Typeface.defaultFromStyle(1));
        r101.setTextColor(ContextCompat.getColor(getContext(), R.color.commonui_white));
        removeAllViews();
        addView(r101, new LinearLayout.LayoutParams(-1, -1));
        return;
    L14:
        r101.setTextSize(12.0f);
        goto L15
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void setInfo(String r100) {
        Integer r101 = Integer.valueOf(Color.parseColor(CJPayColorConstants.CJ_PAY_RED));     // Catch: IllegalArgumentException -> L4
    L5:
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
        float r103 = 2;
        float[] r104 = {UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103), UtilityKotlinExtentionsKt.h(r103)};
        ShapeDrawable r105 = new ShapeDrawable(new RoundRectShape(r104, new RectF(0.0f, 0.0f, 0.0f, 0.0f), r104));
        r105.getPaint().setColor(r102);
        r105.setBounds(new Rect(0, 0, getHeight(), getBottom()));
        setBackground(r105);
    L7:
        setDesText(r100);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public NormalCardBtn(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ NormalCardBtn(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
