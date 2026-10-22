package com.android.contacts.calllog.blocked;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.obric.oui.text.OTextView;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockListItemCardView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bJ\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockListItemCardView;", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "blockSubTitleView", "Lcom/obric/oui/text/OTextView;", "getBlockSubTitleView", "()Lcom/obric/oui/text/OTextView;", "blockSubTitleView$delegate", "Lkotlin/Lazy;", "blockTitleView", "getBlockTitleView", "blockTitleView$delegate", "simIdIcon", "Landroid/widget/ImageView;", "getSimIdIcon", "()Landroid/widget/ImageView;", "simIdIcon$delegate", "setCustomSubTitleColor", "", "color", "", "setCustomSubTitleText", "subtitleText", "", "setCustomTitleText", "titleText", "setSimId", "simId", "showSimIcon", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockListItemCardView extends ContactsCommonListItem {
    private final Lazy blockSubTitleView$delegate;
    private final Lazy blockTitleView$delegate;
    private final Lazy simIdIcon$delegate;

    public /* synthetic */ BlockListItemCardView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public BlockListItemCardView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        this.simIdIcon$delegate = LazyKt.lazy(new BlockListItemCardView$simIdIcon$2(this));
        this.blockSubTitleView$delegate = LazyKt.lazy(new BlockListItemCardView$blockSubTitleView$2(this));
        this.blockTitleView$delegate = LazyKt.lazy(new BlockListItemCardView$blockTitleView$2(this));
        View r10 = LayoutInflater.from(r8).inflate(R.layout.blocked_list_item_title, this, false);
        if ((r10 instanceof ViewGroup) == false) goto L5;
        ViewGroup r11 = (ViewGroup) r10;
    L6:
        if (r11 == null) goto L8;
        setCenterContainer(r11);
    L8:
        setDefaultCustomEndView(3);
        setShowCardBg(true);
        setBgColor(ResourcesCompat.getColor(r8.getResources(), R.color.oui_advanced_fill_list_item_card, null));
        showDivider(false);
        setCardType(1);
        getCheckBox().setId(R.id.card_check_box);
        showTitle(true);
        showSubTitle(true);
        showCustomEnd(true);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final ImageView getSimIdIcon() {
        return (ImageView) this.simIdIcon$delegate.getValue();
    }

    public final OTextView getBlockSubTitleView() {
        return (OTextView) this.blockSubTitleView$delegate.getValue();
    }

    public final OTextView getBlockTitleView() {
        return (OTextView) this.blockTitleView$delegate.getValue();
    }

    public final void setSimId(int r3, boolean r4) {
        if (DSUtils.useDSFeature() == true) goto L9;
        if (r4 == true) goto L9;
        ImageView r2 = getSimIdIcon();
        if (r2 == null) goto L21;
        r2.setVisibility(8);
        return;
    L21:
        return;
    L9:
        int r5 = DSUtils.getSimIconResource(r3);
        if (r5 <= 0) goto L17;
        ImageView r6 = getSimIdIcon();
        if (r6 == null) goto L14;
        r6.setVisibility(0);
    L14:
        ImageView r7 = getSimIdIcon();
        if (r7 == null) goto L23;
        r7.setImageResource(r5);
        return;
    L23:
        return;
    L17:
        ImageView r8 = getSimIdIcon();
        if (r8 == null) goto L25;
        r8.setVisibility(8);
        return;
    }

    public final void setCustomSubTitleText(String r5) {
        OTextView r0 = getBlockSubTitleView();
        if (r0 == null) goto L17;
        OTextView r1 = r0;
        String r2 = r5;
        int r3 = 0;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if ((!r4) == true) goto L16;
        r3 = 8;
    L16:
        r1.setVisibility(r3);
        goto L17
    L8:
        if (r2.length() == 0) goto L11;
        r4 = false;
    L17:
        OTextView r6 = getBlockSubTitleView();
        if (r6 == null) goto L22;
        r6.setText(r5);
        return;
    }

    public final void setCustomSubTitleColor(int r1) {
        OTextView r0 = getBlockSubTitleView();
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public final void setCustomTitleText(String r5) {
        OTextView r0 = getBlockTitleView();
        if (r0 == null) goto L17;
        OTextView r1 = r0;
        String r2 = r5;
        int r3 = 0;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if ((!r4) == true) goto L16;
        r3 = 8;
    L16:
        r1.setVisibility(r3);
        goto L17
    L8:
        if (r2.length() == 0) goto L11;
        r4 = false;
    L17:
        OTextView r6 = getBlockTitleView();
        if (r6 == null) goto L22;
        r6.setText(r5);
        return;
    }
}
