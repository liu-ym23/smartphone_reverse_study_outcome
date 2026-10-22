package com.android.contacts.detail.item;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbsContactItemCard.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/android/contacts/detail/item/AbsContactItemCard;", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initData", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbsContactItemCard extends ContactsCommonListItem {
    public abstract void initData();

    public AbsContactItemCard(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        setShowCardBg(true);
        initData();
    }

    public /* synthetic */ AbsContactItemCard(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
