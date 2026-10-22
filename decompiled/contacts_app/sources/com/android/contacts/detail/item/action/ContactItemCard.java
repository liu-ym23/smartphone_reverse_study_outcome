package com.android.contacts.detail.item.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.R;
import com.android.contacts.detail.item.AbsContactItemCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactItemCard.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/android/contacts/detail/item/action/ContactItemCard;", "Lcom/android/contacts/detail/item/AbsContactItemCard;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initData", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactItemCard extends AbsContactItemCard {
    public ContactItemCard(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public /* synthetic */ ContactItemCard(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    @Override // com.android.contacts.detail.item.AbsContactItemCard
    public void initData() {
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.contact_detail_card_item, this, false);
        if (r0 == null) goto L5;
        setCenterContainer(r0);
    L5:
        ViewGroup r1 = getItemTitleContainer();
        if (r1 == null) goto L8;
        r1.setPadding(r1.getPaddingLeft(), 0, r1.getPaddingRight(), 0);
    L8:
        setCardType(0);
    }
}
