package com.android.contacts.calllog.blocked;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.obric.oui.lisitem.OListItemGeneral;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockListItemView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/android/contacts/calllog/blocked/BlockListItemView;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "simIdIcon", "Landroid/widget/ImageView;", "getSimIdIcon", "()Landroid/widget/ImageView;", "inflateContent", "", "setSimId", "simId", "", "showSimIcon", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockListItemView extends OListItemGeneral {
    private final ImageView simIdIcon;

    public /* synthetic */ BlockListItemView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public BlockListItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.simIdIcon = (ImageView) findViewById(R.id.sim_id_icon);
        if (((ImageView) findViewById(R.id.sim_id_icon)) == null) goto L6;
        DSUtils.isMultiSimEnabled();
        return;
    }

    public final ImageView getSimIdIcon() {
        return this.simIdIcon;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        LayoutInflater.from(getContext()).inflate(R.layout.blocked_list_item, this);
    }

    public final void setSimId(int r3, boolean r4) {
        if (DSUtils.useDSFeature() == true) goto L9;
        if (r4 == true) goto L9;
        ImageView r2 = this.simIdIcon;
        if (r2 == null) goto L21;
        r2.setVisibility(8);
        return;
    L21:
        return;
    L9:
        int r5 = DSUtils.getSimIconResource(r3);
        if (r5 <= 0) goto L17;
        ImageView r6 = this.simIdIcon;
        if (r6 == null) goto L14;
        r6.setVisibility(0);
    L14:
        ImageView r7 = this.simIdIcon;
        if (r7 == null) goto L23;
        r7.setImageResource(r5);
        return;
    L23:
        return;
    L17:
        ImageView r8 = this.simIdIcon;
        if (r8 == null) goto L25;
        r8.setVisibility(8);
        return;
    }
}
