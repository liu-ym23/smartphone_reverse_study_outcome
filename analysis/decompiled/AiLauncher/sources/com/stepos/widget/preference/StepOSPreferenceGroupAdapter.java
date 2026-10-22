package com.stepos.widget.preference;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.h;
import androidx.preference.l;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.list.StepOSCardPosition;
import com.stepos.widget.list.StepOSListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0017\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\nJ\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001f\u0010\u001eR*\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R,\u0010'\u001a\u00020\u00102\b\b\u0001\u0010 \u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceGroupAdapter;", "Landroidx/preference/h;", "Landroidx/preference/PreferenceGroup;", "preferenceGroup", "<init>", "(Landroidx/preference/PreferenceGroup;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "LY8/t;", "applyListHorizontalInsets", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroid/view/View;", "itemView", "Lcom/stepos/widget/list/StepOSListItem;", "findListItem", "(Landroid/view/View;)Lcom/stepos/widget/list/StepOSListItem;", "", "position", "Landroidx/preference/Preference;", "itemOrNull", "(I)Landroidx/preference/Preference;", "other", "self", "", "isSameCard", "(Landroidx/preference/Preference;Landroidx/preference/Preference;)Z", "onAttachedToRecyclerView", "Landroidx/preference/l;", "holder", "onBindViewHolder", "(Landroidx/preference/l;I)V", "bindCardChrome", UxipConstants.f30680s, "itemDividersEnabled", "Z", "getItemDividersEnabled", "()Z", "setItemDividersEnabled", "(Z)V", "listHorizontalInsetPx", "I", "getListHorizontalInsetPx", "()I", "setListHorizontalInsetPx", "(I)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public class StepOSPreferenceGroupAdapter extends h {
    public static final int LIST_HORIZONTAL_INSET_DEFAULT = -1;
    private boolean itemDividersEnabled;
    private int listHorizontalInsetPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSPreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        super(preferenceGroup);
        p.i(preferenceGroup, "preferenceGroup");
        this.itemDividersEnabled = true;
        this.listHorizontalInsetPx = -1;
    }

    private final void applyListHorizontalInsets(RecyclerView recyclerView) throws Resources.NotFoundException {
        int dimensionPixelSize = this.listHorizontalInsetPx;
        if (dimensionPixelSize == -1) {
            dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.stepos_list_group_margin_horizontal);
        }
        if (dimensionPixelSize == 0 && recyclerView.getPaddingStart() == 0 && recyclerView.getPaddingEnd() == 0) {
            return;
        }
        recyclerView.setPaddingRelative(dimensionPixelSize, recyclerView.getPaddingTop(), dimensionPixelSize, recyclerView.getPaddingBottom());
        recyclerView.setClipToPadding(false);
    }

    private final StepOSListItem findListItem(View itemView) {
        StepOSListItem stepOSListItem = itemView instanceof StepOSListItem ? (StepOSListItem) itemView : null;
        return stepOSListItem == null ? (StepOSListItem) itemView.findViewById(R.id.stepos_preference_bridge_row) : stepOSListItem;
    }

    private final boolean isSameCard(Preference other, Preference self) {
        return (other == null || (other instanceof PreferenceGroup) || other.getParent() != self.getParent()) ? false : true;
    }

    private final Preference itemOrNull(int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }
        return getItem(position);
    }

    public void bindCardChrome(l holder, int position) throws Resources.NotFoundException {
        p.i(holder, "holder");
        Preference item = getItem(position);
        if (item == null || (item instanceof PreferenceGroup)) {
            return;
        }
        boolean zIsSameCard = isSameCard(itemOrNull(position - 1), item);
        boolean zIsSameCard2 = isSameCard(itemOrNull(position + 1), item);
        StepOSCardPosition.Companion companion = StepOSCardPosition.INSTANCE;
        StepOSCardPosition stepOSCardPositionOf = companion.of(zIsSameCard, zIsSameCard2);
        float dimension = holder.itemView.getResources().getDimension(R.dimen.stepos_list_group_corner_radius);
        View itemView = holder.itemView;
        p.h(itemView, "itemView");
        StepOSListItem stepOSListItemFindListItem = findListItem(itemView);
        if (stepOSListItemFindListItem != null) {
            int dimensionPixelSize = stepOSListItemFindListItem.getResources().getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical);
            StepOSListItem.applyCardChrome$default(stepOSListItemFindListItem, stepOSCardPositionOf.cornerRadii(dimension), 0, this.itemDividersEnabled && stepOSCardPositionOf.showsDivider(), stepOSCardPositionOf.hasTopOutset() ? dimensionPixelSize : 0, stepOSCardPositionOf.hasBottomOutset() ? dimensionPixelSize : 0, 2, null);
        } else {
            View itemView2 = holder.itemView;
            p.h(itemView2, "itemView");
            StepOSCardPosition.Companion.applyCardBackground$default(companion, itemView2, stepOSCardPositionOf, dimension, 0, 8, null);
        }
    }

    public final boolean getItemDividersEnabled() {
        return this.itemDividersEnabled;
    }

    public final int getListHorizontalInsetPx() {
        return this.listHorizontalInsetPx;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) throws Resources.NotFoundException {
        p.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        applyListHorizontalInsets(recyclerView);
    }

    public final void setItemDividersEnabled(boolean z10) {
        if (this.itemDividersEnabled == z10) {
            return;
        }
        this.itemDividersEnabled = z10;
        notifyDataSetChanged();
    }

    public final void setListHorizontalInsetPx(int i10) {
        if (i10 == -1 || i10 >= 0) {
            this.listHorizontalInsetPx = i10;
            return;
        }
        throw new IllegalArgumentException(("listHorizontalInsetPx must be LIST_HORIZONTAL_INSET_DEFAULT or >= 0 but was " + i10).toString());
    }

    @Override // androidx.preference.h, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(l holder, int position) throws Resources.NotFoundException {
        p.i(holder, "holder");
        super.onBindViewHolder(holder, position);
        bindCardChrome(holder, position);
    }
}
