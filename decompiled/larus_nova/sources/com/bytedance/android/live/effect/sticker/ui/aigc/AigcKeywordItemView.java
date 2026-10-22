package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcKeywordItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "text", "", "setText", "getText", "", "isSelect", "setSelectStatus", "getSelectStatus", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getTextView", "()Landroid/widget/TextView;", "textView", "", "b", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AigcKeywordItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68493b;

    public AigcKeywordItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AigcKeywordItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getTextView() {
        return (TextView) this.f68492a.getValue();
    }

    public final boolean getSelectStatus() {
        return isSelected();
    }

    public final String getText() {
        TextView r100 = getTextView();
        if (r100 == null) goto L8;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L8;
        String r102 = r101.toString();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public final int getPosition() {
        return this.f68493b;
    }

    public final void setPosition(int r100) {
        this.f68493b = r100;
    }

    public final void setSelectStatus(boolean r100) {
        TextView r101 = getTextView();
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = R.color.ttlive_effect_aigc_keyword_text_color_select;
    L7:
        r101.setTextColor(s1.h(r102));
        goto L8
    L6:
        r102 = R.color.ttlive_effect_aigc_keyword_text_color_unselect;
    L8:
        setSelected(r100);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = getTextView();
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public AigcKeywordItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f68492a = LazyKt.lazy(new AigcKeywordItemView$textView$2(this));
        this.f68493b = -1;
        ViewGroup.inflate(r100, R.layout.ttlive_effect_aigc_keyword_item_view, this);
    }

    public /* synthetic */ AigcKeywordItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
