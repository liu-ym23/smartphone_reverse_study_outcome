package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/HotWordFlipperItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HotWordFlipperItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f184625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f184626b;

    public HotWordFlipperItemView(Context r110) {
        super(r110);
        setOrientation(0);
        setGravity(16);
        TextView r100 = new TextView(getContext());
        r100.setEllipsize(null);
        r100.setMaxLines(1);
        r100.setSingleLine();
        r100.setTextColor((int) 2568362019L);
        r100.setGravity(16);
        r100.setTextSize(2, 14.0f);
        Unit r101 = Unit.INSTANCE;
        this.f184625a = r100;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -1);
        r102.setMargins(0, 0, ExtensionsKt.a(4), 0);
        addView(r100, r102);
        ECDraweeView r111 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.f184626b = r111;
        addView(r111, new ViewGroup.LayoutParams(ExtensionsKt.a(14), ExtensionsKt.a(14)));
    }

    public HotWordFlipperItemView(Context r100, AttributeSet r110) {
        super(r100, r110);
        setOrientation(0);
        setGravity(16);
        TextView r101 = new TextView(getContext());
        r101.setEllipsize(null);
        r101.setMaxLines(1);
        r101.setSingleLine();
        r101.setTextColor((int) 2568362019L);
        r101.setGravity(16);
        r101.setTextSize(2, 14.0f);
        Unit r111 = Unit.INSTANCE;
        this.f184625a = r101;
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -1);
        r112.setMargins(0, 0, ExtensionsKt.a(4), 0);
        addView(r101, r112);
        ECDraweeView r102 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.f184626b = r102;
        addView(r102, new ViewGroup.LayoutParams(ExtensionsKt.a(14), ExtensionsKt.a(14)));
    }

    public HotWordFlipperItemView(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        setOrientation(0);
        setGravity(16);
        TextView r111 = new TextView(getContext());
        r111.setEllipsize(null);
        r111.setMaxLines(1);
        r111.setSingleLine();
        r111.setTextColor((int) 2568362019L);
        r111.setGravity(16);
        r111.setTextSize(2, 14.0f);
        Unit r102 = Unit.INSTANCE;
        this.f184625a = r111;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -1);
        r103.setMargins(0, 0, ExtensionsKt.a(4), 0);
        addView(r111, r103);
        ECDraweeView r104 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.f184626b = r104;
        addView(r104, new ViewGroup.LayoutParams(ExtensionsKt.a(14), ExtensionsKt.a(14)));
    }
}
