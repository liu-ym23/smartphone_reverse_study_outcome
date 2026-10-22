package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECFlashMaterialWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/a;", "", "getCurrentContentDescription", "getType", "()Ljava/lang/String;", "type", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlashMaterialWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f150606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f150607b;

    public static final class a {
    }

    static {
    }

    public ECFlashMaterialWidget(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECFlashMaterialWidget(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "flash_material_info";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f150607b;
        if (r100 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r100);
    }

    public final TextView a(String r100, int r101) {
        TextView r102 = new TextView(getContext());
        StringBuilder r103 = this.f150607b;
        if (r103 == null) goto L5;
        r103.append(r100);
    L5:
        r102.setTag("text");
        r102.setText(r100);
        r102.setMaxLines(1);
        r102.setTextSize(1, 12.0f);
        r102.setTextColor(th.a.a(r102.getContext(), R.color.shopping_std_text_black_2));
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        if (r101 <= 0) goto L8;
        r104.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L8:
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutParams(r104);
        return r102;
    }

    public ECFlashMaterialWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setGravity(GravityCompat.START);
    }

    public /* synthetic */ ECFlashMaterialWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getChildCount() - 1;
    L3:
        if (r105 < 0) goto L19;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() == 8) goto L12;
        if ((r106.getLeft() + r106.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        r106.layout(r101, r102, r101, r104);
        goto L12
    L10:
        if (Intrinsics.areEqual(r106.getTag(), ItemStyle.ITEM_STYLE_DIVIDER) == false) goto L13;
        r106.layout(r101, r102, r101, r104);
        return;
    L13:
        return;
    L12:
        r105 = r105 - 1;
        goto L3
    }
}
