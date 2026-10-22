package com.stepos.widget.menu;

import Y8.t;
import Z8.F;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.widget.R;
import com.stepos.widget.databinding.SteposMenuItemBinding;
import com.stepos.widget.menu.StepOSMenuAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001.B)\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0015\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00062\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040)j\b\u0012\u0004\u0012\u00020\u0004`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010+R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010,R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/widget/menu/StepOSMenuAdapter$ViewHolder;", "Lkotlin/Function2;", "", "Lcom/stepos/widget/menu/StepOSMenuItem;", "LY8/t;", "onItemClick", "Lcom/stepos/widget/menu/StepOSMenuStyle;", "style", "<init>", "(Lp9/p;Lcom/stepos/widget/menu/StepOSMenuStyle;)V", "rebuildVisible", "()V", "", "newItems", "selectedItemId", "", "checkBoxVisible", "", "expandedIndexes", "submit", "(Ljava/util/List;IZLjava/util/Set;)V", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/stepos/widget/menu/StepOSMenuAdapter$ViewHolder;", "holder", "position", "onBindViewHolder", "(Lcom/stepos/widget/menu/StepOSMenuAdapter$ViewHolder;I)V", "Lp9/p;", "Lcom/stepos/widget/menu/StepOSMenuStyle;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "Ljava/util/ArrayList;", "visible", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "I", "Z", "ViewHolder", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private boolean checkBoxVisible;
    private final HashSet<Integer> expandedIndexes;
    private final ArrayList<StepOSMenuItem> items;
    private final p<Integer, StepOSMenuItem, t> onItemClick;
    private int selectedItemId;
    private final StepOSMenuStyle style;
    private final ArrayList<StepOSMenuItem> visible;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/stepos/widget/databinding/SteposMenuItemBinding;", "binding", "<init>", "(Lcom/stepos/widget/menu/StepOSMenuAdapter;Lcom/stepos/widget/databinding/SteposMenuItemBinding;)V", "Lcom/stepos/widget/menu/StepOSMenuItem;", "item", "", "position", "LY8/t;", "bind", "(Lcom/stepos/widget/menu/StepOSMenuItem;I)V", "Lcom/stepos/widget/databinding/SteposMenuItemBinding;", "Landroid/graphics/drawable/GradientDrawable;", "overlay", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/graphics/drawable/LayerDrawable;", "overlayLayer", "Landroid/graphics/drawable/LayerDrawable;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final SteposMenuItemBinding binding;
        private final GradientDrawable overlay;
        private final LayerDrawable overlayLayer;
        final /* synthetic */ StepOSMenuAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(final StepOSMenuAdapter stepOSMenuAdapter, SteposMenuItemBinding binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.p.i(binding, "binding");
            this.this$0 = stepOSMenuAdapter;
            this.binding = binding;
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.overlay = gradientDrawable;
            LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable});
            this.overlayLayer = layerDrawable;
            binding.steposMenuItemPressOverlay.setBackground(layerDrawable);
            N.r0(binding.steposMenuItemContent, 2);
            N.r0(binding.steposMenuItemCheckbox, 2);
            N.r0(binding.steposMenuItemIcon, 2);
            N.r0(binding.steposMenuItemText, 2);
            N.r0(binding.steposMenuItemTitle, 2);
            N.r0(binding.steposMenuItemSubtitle, 2);
            N.r0(binding.steposMenuItemUnfold, 2);
            N.r0(binding.steposMenuItemBadge, 2);
            N.r0(binding.steposMenuItemTag, 2);
            N.r0(binding.steposMenuItemTrailingIcon, 2);
            N.r0(binding.steposMenuItemMark, 2);
            N.i0(binding.getRoot(), new C1313a() { // from class: com.stepos.widget.menu.StepOSMenuAdapter.ViewHolder.1
                @Override // androidx.core.view.C1313a
                public void onInitializeAccessibilityNodeInfo(View host, C0.c info) {
                    kotlin.jvm.internal.p.i(host, "host");
                    kotlin.jvm.internal.p.i(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    StepOSMenuItem stepOSMenuItem = (StepOSMenuItem) F.t0(stepOSMenuAdapter.visible, ViewHolder.this.getBindingAdapterPosition());
                    if (stepOSMenuItem != null && StepOSMenuAdapterKt.isMenuItemCheckable(stepOSMenuItem, stepOSMenuAdapter.checkBoxVisible)) {
                        info.k0(true);
                        info.l0(stepOSMenuItem.getId() == stepOSMenuAdapter.selectedItemId && stepOSMenuAdapter.selectedItemId != -1);
                    }
                }
            });
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.menu.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepOSMenuAdapter.ViewHolder._init_$lambda$0(this.f31278a, stepOSMenuAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(ViewHolder viewHolder, StepOSMenuAdapter stepOSMenuAdapter, View view) {
            int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition != -1) {
                p pVar = stepOSMenuAdapter.onItemClick;
                Integer numValueOf = Integer.valueOf(bindingAdapterPosition);
                Object obj = stepOSMenuAdapter.visible.get(bindingAdapterPosition);
                kotlin.jvm.internal.p.h(obj, "get(...)");
                pVar.invoke(numValueOf, obj);
            }
        }

        public final void bind(StepOSMenuItem item, int position) throws Resources.NotFoundException {
            kotlin.jvm.internal.p.i(item, "item");
            StepOSMenuAdapterKt.applyMenuItemStyle(this.binding, this.this$0.style);
            this.overlay.setCornerRadius(this.this$0.style.getOverlayRadius());
            ColorStateList itemOverlayColor = this.this$0.style.getItemOverlayColor();
            if (itemOverlayColor != null) {
                this.overlay.setColor(itemOverlayColor);
            }
            androidx.core.widget.e.c(this.binding.steposMenuItemIcon, this.this$0.style.getItemIconTint());
            androidx.core.widget.e.c(this.binding.steposMenuItemMark, this.this$0.style.getItemIconTint());
            androidx.core.widget.e.c(this.binding.steposMenuItemUnfold, this.this$0.style.getItemIconTint());
            androidx.core.widget.e.c(this.binding.steposMenuItemTrailingIcon, this.this$0.style.getItemIconTint());
            boolean z10 = false;
            boolean z11 = item.getId() == this.this$0.selectedItemId && this.this$0.selectedItemId != -1;
            boolean zIsMenuItemCheckable = StepOSMenuAdapterKt.isMenuItemCheckable(item, this.this$0.checkBoxVisible);
            boolean zIsMenuItemExpanded = StepOSMenuAdapterKt.isMenuItemExpanded(item, this.this$0.items, this.this$0.expandedIndexes);
            boolean z12 = (z11 && !zIsMenuItemCheckable) || item.getTextStyle() == 1;
            StepOSMenuAdapterKt.bindMenuItemText(this.binding, item, z12, zIsMenuItemExpanded, this.this$0.style);
            ImageView steposMenuItemIcon = this.binding.steposMenuItemIcon;
            kotlin.jvm.internal.p.h(steposMenuItemIcon, "steposMenuItemIcon");
            StepOSMenuAdapterKt.bindMenuItemIcon(steposMenuItemIcon, item);
            StepOSMenuAdapterKt.bindMenuItemAccessories(this.binding, item, z11, this.this$0.checkBoxVisible, zIsMenuItemExpanded);
            StepOSMenuAdapterKt.applyMenuItemOverlayInsets(this.overlayLayer, position, this.this$0.visible.size(), this.this$0.style.getOverlayInsetHorizontal(), 0);
            FrameLayout root = this.binding.getRoot();
            kotlin.jvm.internal.p.h(root, "getRoot(...)");
            root.setEnabled(item.getIsEnabled());
            root.setClickable(item.getIsEnabled());
            if (z12 && item.getTextStyle() != 2) {
                z10 = true;
            }
            root.setSelected(z10);
            root.setActivated(item.getIsPressed());
            String string = root.getResources().getString(R.string.stepos_menu_item_badge_desc);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            root.setContentDescription(StepOSMenuAdapterKt.menuItemContentDescription(item, zIsMenuItemExpanded, string));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StepOSMenuAdapter(p<? super Integer, ? super StepOSMenuItem, t> onItemClick, StepOSMenuStyle style) {
        kotlin.jvm.internal.p.i(onItemClick, "onItemClick");
        kotlin.jvm.internal.p.i(style, "style");
        this.onItemClick = onItemClick;
        this.style = style;
        this.items = new ArrayList<>();
        this.visible = new ArrayList<>();
        this.expandedIndexes = new HashSet<>();
        this.selectedItemId = -1;
    }

    private final void rebuildVisible() {
        this.visible.clear();
        this.visible.addAll(StepOSMenuAdapterKt.flattenVisibleMenuItems(this.items, this.expandedIndexes));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.visible.size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void submit(List<StepOSMenuItem> newItems, int selectedItemId, boolean checkBoxVisible, Set<Integer> expandedIndexes) {
        kotlin.jvm.internal.p.i(newItems, "newItems");
        kotlin.jvm.internal.p.i(expandedIndexes, "expandedIndexes");
        this.items.clear();
        this.items.addAll(newItems);
        this.selectedItemId = selectedItemId;
        this.checkBoxVisible = checkBoxVisible;
        this.expandedIndexes.clear();
        this.expandedIndexes.addAll(expandedIndexes);
        rebuildVisible();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(holder, "holder");
        StepOSMenuItem stepOSMenuItem = this.visible.get(position);
        kotlin.jvm.internal.p.h(stepOSMenuItem, "get(...)");
        holder.bind(stepOSMenuItem, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        SteposMenuItemBinding steposMenuItemBindingInflate = SteposMenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        kotlin.jvm.internal.p.h(steposMenuItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, steposMenuItemBindingInflate);
    }
}
