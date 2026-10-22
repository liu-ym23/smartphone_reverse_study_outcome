package com.obric.Intelligentcall.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.android.contacts.R;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.text.OTextView;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentSoundCardItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u0018R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/Intelligentcall/adapter/IntelligentSoundCardItem;", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView$delegate", "Lkotlin/Lazy;", "titleTextView", "Lcom/obric/oui/text/OTextView;", "getTitleTextView", "()Lcom/obric/oui/text/OTextView;", "titleTextView$delegate", "titleView", "Landroid/view/View;", "getTitleView", "()Landroid/view/View;", "titleView$delegate", "playLottie", "", "setItemChecked", "isChecked", "", "setTitleText", "title", "", "stopLottie", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentSoundCardItem extends ContactsCommonListItem {
    private final Lazy lottieAnimationView$delegate;
    private final Lazy titleTextView$delegate;
    private final Lazy titleView$delegate;

    public /* synthetic */ IntelligentSoundCardItem(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public IntelligentSoundCardItem(final Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        this.titleView$delegate = LazyKt.lazy(new IntelligentSoundCardItem$titleView$2(r8));
        this.titleTextView$delegate = LazyKt.lazy(new IntelligentSoundCardItem$titleTextView$2(this));
        this.lottieAnimationView$delegate = LazyKt.lazy(new IntelligentSoundCardItem$lottieAnimationView$2(this));
        getTitleView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setTitleContainer(getTitleView());
        setDefaultCustomEndView(2);
        setBgColor(ResourcesCompat.getColor(r8.getResources(), R.color.oui_advanced_fill_list_item_card, null));
        setCardType(1);
        showDivider(false);
        setShowCardBg(true);
        showSubTitle(true);
        showCustomEnd(true);
    }

    public final View getTitleView() {
        Object r1 = this.titleView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-titleView>(...)");
        return (View) r1;
    }

    public final OTextView getTitleTextView() {
        return (OTextView) this.titleTextView$delegate.getValue();
    }

    public final LottieAnimationView getLottieAnimationView() {
        return (LottieAnimationView) this.lottieAnimationView$delegate.getValue();
    }

    @Override // com.obric.utils.views.commonitemview.ContactsCommonListItem
    public void setTitleText(String r1) {
        OTextView r0 = getTitleTextView();
        if (r0 == null) goto L7;
        r0.setText(r1);
        return;
    }

    public final void playLottie() {
        LottieAnimationView r0 = getLottieAnimationView();
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        LottieAnimationView r2 = getLottieAnimationView();
        if (r2 == null) goto L10;
        r2.playAnimation();
        return;
    }

    public final void stopLottie() {
        LottieAnimationView r0 = getLottieAnimationView();
        if (r0 == null) goto L6;
        r0.setVisibility(4);
    L6:
        LottieAnimationView r2 = getLottieAnimationView();
        if (r2 == null) goto L10;
        r2.pauseAnimation();
        return;
    }

    public final void setItemChecked(boolean r2) {
        OCheckMark r0 = getEndMark();
        if (r0 == null) goto L6;
        r0.setChecked(r2);
    L6:
        if (r2 == false) goto L8;
        playLottie();
        return;
    L8:
        stopLottie();
    }
}
