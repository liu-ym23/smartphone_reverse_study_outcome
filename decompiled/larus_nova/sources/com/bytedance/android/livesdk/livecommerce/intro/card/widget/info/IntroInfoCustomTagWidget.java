package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoCustomTagWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tagList", "", "setFlashMaterialInfo", "", "getCurrentContentDescription", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getType", "()I", "type", "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoCustomTagWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public oh2.e f148047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public oh2.c f148048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f148049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ECRitTag> f148050e;

    public static final class a {
    }

    static {
    }

    public IntroInfoCustomTagWidget(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IntroInfoCustomTagWidget(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f148049d;
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public oh2.e getArgument() {
        return this.f148047b;
    }

    public oh2.c getContainerAbility() {
        return this.f148048c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public int getType() {
        return this.f148046a;
    }

    private final void setFlashMaterialInfo(List<ECRitTag> r110) {
        if ((!Intrinsics.areEqual(this.f148050e, r110)) == false) goto L29;
        this.f148050e = r110;
        removeAllViews();
        this.f148049d = new StringBuilder();
        Iterator<T> r111 = r110.iterator();
        int r100 = 0;
    L6:
        if (r111.hasNext() == false) goto L21;
        Object r101 = r111.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECRitTag r103 = (ECRitTag) r101;
        List<String> r104 = r103.getText();
        if (r104 == null) goto L19;
        String r105 = (String) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L19;
        ECUIConfig r106 = r103.getUiConfig();
        if (r100 != 0) goto L18;
        addView(b(r105, 0, r106));
        goto L19
    L18:
        View r107 = new View(getContext());
        r107.setTag(ItemStyle.ITEM_STYLE_DIVIDER);
        r107.setBackgroundColor(th.a.a(r107.getContext(), R.color.ec_color_767676));
        setGravity(16);
        Float r108 = Float.valueOf(0.5f);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(r108), UtilityKotlinExtentionsKt.d(Float.valueOf(8.0f)));
        r109.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r109.topMargin = UtilityKotlinExtentionsKt.d(r108);
        Unit r112 = Unit.INSTANCE;
        r107.setLayoutParams(r109);
        addView(r107);
        addView(b(r105, r100, r106));
    L19:
        r100 = r102;
        goto L6
    L21:
        if (getChildCount() <= 0) goto L30;
        addView(new Space(getContext()), new LinearLayout.LayoutParams(1, 0));
        return;
    L30:
        return;
    }

    public final void a(List<ECRitTag> r100) {
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L25;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        ECRitTag r103 = (ECRitTag) r102.next();
        List<String> r104 = r103.getText();
        if (r104 != null) goto L13;
    L15:
        r103 = null;
    L16:
        if (r103 == null) goto L9;
        r101.add(r103);
        goto L9
    L13:
        if (((String) CollectionsKt.firstOrNull(r104)) == null) goto L15;
    L18:
        setFlashMaterialInfo(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r100) {
        this.f148047b = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r100) {
        this.f148048c = r100;
    }

    public IntroInfoCustomTagWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148046a = 6;
        setOrientation(0);
        setGravity(GravityCompat.START);
    }

    public final TextView b(String r100, int r101, ECUIConfig r102) {
        TextView r103 = new TextView(getContext());
        StringBuilder r104 = this.f148049d;
        if (r104 == null) goto L5;
        r104.append(r100);
    L5:
        r103.setTag("text");
        r103.setText(r100);
        r103.setMaxLines(1);
        boolean r105 = false;
        r103.setIncludeFontPadding(false);
        String r106 = null;
        if (r102 == null) goto L15;
        Integer r107 = Integer.valueOf(r102.getTextSize());
        if (r107.intValue() <= 0) goto L10;
        r105 = true;
    L10:
        if (r105 == true) goto L13;
        r107 = null;
    L13:
        if (r107 == null) goto L15;
        float r108 = r107.intValue();
    L16:
        r103.setTextSize(1, r108);
        int r109 = s.f45717a;
        if (r102 == null) goto L19;
        r106 = r102.getTextColor();
    L19:
        r103.setTextColor(s.a(r106, th.a.a(r103.getContext(), R.color.ec_color_FFCCCCCC)));
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        if (r101 <= 0) goto L22;
        r110.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L22:
        Unit r111 = Unit.INSTANCE;
        r103.setLayoutParams(r110);
        return r103;
    L15:
        r108 = 12.0f;
        goto L16
    }

    public /* synthetic */ IntroInfoCustomTagWidget(Context r100, AttributeSet r101, int r102, int r103) {
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
