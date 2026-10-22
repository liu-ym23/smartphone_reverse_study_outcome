package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.PrivacyItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacySheetAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySheetAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/obric/oui/privacy/PrivacyItem;", "(Ljava/util/List;)V", "switchItemCount", "", "getSwitchItemCount", "()I", "switchItemCount$delegate", "Lkotlin/Lazy;", "switchStartIndex", "getSwitchStartIndex", "switchStartIndex$delegate", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacySheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    public static final int TYPE_PERMISSION = 1;
    public static final int TYPE_SWITCH = 0;
    private final List<PrivacyItem> items;
    private final Lazy switchItemCount$delegate;
    private final Lazy switchStartIndex$delegate;

    /* JADX INFO: compiled from: PrivacySheetAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacySheetAdapter$Companion;", "", "()V", "TYPE_PERMISSION", "", "TYPE_SWITCH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ List access$getItems$p(PrivacySheetAdapter r0) {
        return r0.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacySheetAdapter(List<? extends PrivacyItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items = r2;
        this.switchItemCount$delegate = LazyKt.lazy(new PrivacySheetAdapter$switchItemCount$2(this));
        this.switchStartIndex$delegate = LazyKt.lazy(new PrivacySheetAdapter$switchStartIndex$2(this));
    }

    private final int getSwitchItemCount() {
        return ((Number) this.switchItemCount$delegate.getValue()).intValue();
    }

    private final int getSwitchStartIndex() {
        return ((Number) this.switchStartIndex$delegate.getValue()).intValue();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        PrivacyItem r0 = this.items.get(r1);
        if ((r0 instanceof PrivacyItem.SwitchItem) == false) goto L6;
        return 0;
    L6:
        if ((r0 instanceof PrivacyItem.PermissionItem) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != 0) goto L5;
        PrivacySwitchViewHolder.Companion r4 = PrivacySwitchViewHolder.Companion;
        Context r5 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "parent.context");
        return r4.create(r5);
    L5:
        if (r3 != 1) goto L8;
        PrivacyPermissionViewHolder.Companion r6 = PrivacyPermissionViewHolder.Companion;
        Context r7 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "parent.context");
        return r6.create(r7);
    L8:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown viewType: ", Integer.valueOf(r3)));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof PrivacySwitchViewHolder) == false) goto L6;
        PrivacySwitchViewHolder r5 = (PrivacySwitchViewHolder) r3;
        r5.bind((PrivacyItem.SwitchItem) this.items.get(r4), r4, getSwitchItemCount(), getSwitchStartIndex());
        return;
    L6:
        if ((r3 instanceof PrivacyPermissionViewHolder) == false) goto L10;
        PrivacyPermissionViewHolder r6 = (PrivacyPermissionViewHolder) r3;
        r6.bind((PrivacyItem.PermissionItem) this.items.get(r4));
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
