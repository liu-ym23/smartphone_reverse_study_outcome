package com.android.contacts.detail.item.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.android.contacts.R;
import com.android.contacts.detail.item.AbsContactItemCard;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactItemButtonCard.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/detail/item/button/ContactItemButtonCard;", "Lcom/android/contacts/detail/item/AbsContactItemCard;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "itemText", "Lcom/obric/oui/text/OTextView;", "getItemText", "()Lcom/obric/oui/text/OTextView;", "setItemText", "(Lcom/obric/oui/text/OTextView;)V", "initData", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactItemButtonCard extends AbsContactItemCard {
    private OTextView itemText;

    public ContactItemButtonCard(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.itemText = (OTextView) findViewById(R.id.btn_text);
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ContactItemButtonCard);
        Intrinsics.checkNotNullExpressionValue(r4, "context.obtainStyledAttr…le.ContactItemButtonCard)");
        boolean r5 = false;
        String r0 = r4.getString(0);
        r4.recycle();
        String r1 = r0;
        if (r1 != null) goto L5;
    L6:
        r5 = true;
    L7:
        if (r5 == true) goto L13;
        OTextView r6 = this.itemText;
        if (r6 == null) goto L14;
        r6.setText(r1);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r1.length() != 0) goto L7;
        goto L6
    }

    public /* synthetic */ ContactItemButtonCard(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final OTextView getItemText() {
        return this.itemText;
    }

    public final void setItemText(OTextView r1) {
        this.itemText = r1;
    }

    @Override // com.android.contacts.detail.item.AbsContactItemCard
    public void initData() {
        setCustomStartView(R.layout.contact_detail_button_card_item);
        setCardType(2);
    }
}
