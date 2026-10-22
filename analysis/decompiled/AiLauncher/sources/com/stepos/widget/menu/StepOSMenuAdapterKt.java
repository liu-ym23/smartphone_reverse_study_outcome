package com.stepos.widget.menu;

import Z8.C1173v;
import Z8.F;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.widget.R;
import com.stepos.widget.databinding.SteposMenuItemBinding;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\n\u001a1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a7\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010\"\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001e\u0010#\u001a\u001f\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b(\u0010)\u001a!\u0010,\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00182\b\b\u0001\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-\u001a7\u00100\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b0\u00101\u001a'\u00104\u001a\u0002022\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\t2\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\b4\u00105\u001a7\u00107\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00012\u0006\u00106\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0000¢\u0006\u0004\b7\u00108\u001a'\u0010:\u001a\u00020\u00152\u0006\u0010%\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00012\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"", "Lcom/stepos/widget/menu/StepOSMenuItem;", DidiCardProvider.KEY_ITEMS, "", "", "expandedIndexes", "flattenVisibleMenuItems", "(Ljava/util/List;Ljava/util/Set;)Ljava/util/List;", "item", "", "isMenuItemExpanded", "(Lcom/stepos/widget/menu/StepOSMenuItem;Ljava/util/List;Ljava/util/Set;)Z", "menuCheckBoxVisible", "isMenuItemCheckable", "(Lcom/stepos/widget/menu/StepOSMenuItem;Z)Z", "Landroid/graphics/drawable/LayerDrawable;", "overlay", "position", "itemCount", "horizontalInsetPx", "edgePaddingPx", "LY8/t;", "applyMenuItemOverlayInsets", "(Landroid/graphics/drawable/LayerDrawable;IIII)V", "Landroid/view/View;", "itemView", "applyMenuItemEdgePadding", "(Landroid/view/View;III)V", "Landroid/widget/ImageView;", "iconView", "bindMenuItemIcon", "(Landroid/widget/ImageView;Lcom/stepos/widget/menu/StepOSMenuItem;)V", "Landroid/graphics/drawable/Drawable;", "icon", "iconRes", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;I)V", "Lcom/stepos/widget/databinding/SteposMenuItemBinding;", "binding", "Lcom/stepos/widget/menu/StepOSMenuStyle;", "style", "applyMenuItemStyle", "(Lcom/stepos/widget/databinding/SteposMenuItemBinding;Lcom/stepos/widget/menu/StepOSMenuStyle;)V", "view", ContentDisposition.Parameters.Size, "resizeSquare", "(Landroid/view/View;I)V", "highlighted", "expanded", "bindMenuItemText", "(Lcom/stepos/widget/databinding/SteposMenuItemBinding;Lcom/stepos/widget/menu/StepOSMenuItem;ZZLcom/stepos/widget/menu/StepOSMenuStyle;)V", "", "badgeDescription", "menuItemContentDescription", "(Lcom/stepos/widget/menu/StepOSMenuItem;ZLjava/lang/CharSequence;)Ljava/lang/CharSequence;", "selected", "bindMenuItemAccessories", "(Lcom/stepos/widget/databinding/SteposMenuItemBinding;Lcom/stepos/widget/menu/StepOSMenuItem;ZZZ)V", "showTrailing", "bindMenuItemTrailing", "(Lcom/stepos/widget/databinding/SteposMenuItemBinding;Lcom/stepos/widget/menu/StepOSMenuItem;Z)V", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuAdapterKt {
    public static final void applyMenuItemEdgePadding(View itemView, int i10, int i11, int i12) {
        p.i(itemView, "itemView");
        int i13 = i10 == 0 ? i12 : 0;
        if (i11 <= 0 || i10 != i11 - 1) {
            i12 = 0;
        }
        itemView.setPaddingRelative(0, i13, 0, i12);
    }

    public static final void applyMenuItemOverlayInsets(LayerDrawable overlay, int i10, int i11, int i12, int i13) {
        p.i(overlay, "overlay");
        overlay.setLayerInset(0, i12, i10 == 0 ? i13 : 0, i12, (i11 <= 0 || i10 != i11 + (-1)) ? 0 : i13);
    }

    public static final void applyMenuItemStyle(SteposMenuItemBinding binding, StepOSMenuStyle style) {
        p.i(binding, "binding");
        p.i(style, "style");
        binding.getRoot().setMinimumHeight(style.getItemMinHeight());
        binding.steposMenuItemContent.setMinimumHeight(style.getItemMinHeight());
        binding.steposMenuItemContent.setPaddingRelative(style.getItemPaddingHorizontal(), style.getItemPaddingVertical(), style.getItemPaddingHorizontal(), style.getItemPaddingVertical());
        binding.steposMenuItemTitle.setTextAppearance(style.getItemTextAppearance());
        binding.steposMenuItemSubtitle.setTextAppearance(style.getItemSubtitleTextAppearance());
        ImageView steposMenuItemIcon = binding.steposMenuItemIcon;
        p.h(steposMenuItemIcon, "steposMenuItemIcon");
        resizeSquare(steposMenuItemIcon, style.getItemIconSize());
        ImageView steposMenuItemUnfold = binding.steposMenuItemUnfold;
        p.h(steposMenuItemUnfold, "steposMenuItemUnfold");
        resizeSquare(steposMenuItemUnfold, style.getItemIconSize());
        ImageView steposMenuItemMark = binding.steposMenuItemMark;
        p.h(steposMenuItemMark, "steposMenuItemMark");
        resizeSquare(steposMenuItemMark, style.getItemIconSize());
        ImageView steposMenuItemTrailingIcon = binding.steposMenuItemTrailingIcon;
        p.h(steposMenuItemTrailingIcon, "steposMenuItemTrailingIcon");
        resizeSquare(steposMenuItemTrailingIcon, binding.getRoot().getResources().getDimensionPixelSize(R.dimen.stepos_menu_item_trailing_icon_size));
    }

    public static final void bindMenuItemAccessories(SteposMenuItemBinding binding, StepOSMenuItem item, boolean z10, boolean z11, boolean z12) {
        p.i(binding, "binding");
        p.i(item, "item");
        boolean zIsMenuItemCheckable = isMenuItemCheckable(item, z11);
        binding.steposMenuItemCheckbox.setVisibility(zIsMenuItemCheckable ? 0 : 8);
        binding.steposMenuItemCheckbox.setEnabled(item.getIsEnabled());
        binding.steposMenuItemCheckbox.setSelected(zIsMenuItemCheckable && z10);
        boolean z13 = (!item.getIsExpandable() || z12 || zIsMenuItemCheckable) ? false : true;
        binding.steposMenuItemUnfold.setVisibility(z13 ? 0 : 8);
        boolean z14 = (z13 || item.getTrailing() == 0) ? false : true;
        bindMenuItemTrailing(binding, item, z14);
        binding.steposMenuItemMark.setVisibility((zIsMenuItemCheckable || !z10 || item.getIsExpandable() || z14) ? false : true ? 0 : 8);
    }

    public static final void bindMenuItemIcon(ImageView iconView, StepOSMenuItem item) {
        p.i(iconView, "iconView");
        p.i(item, "item");
        bindMenuItemIcon(iconView, item.getIcon(), item.getIconRes());
    }

    public static final void bindMenuItemText(SteposMenuItemBinding binding, StepOSMenuItem item, boolean z10, boolean z11, StepOSMenuStyle style) {
        p.i(binding, "binding");
        p.i(item, "item");
        p.i(style, "style");
        binding.steposMenuItemTitle.setText(item.getTitle());
        if (item.getTextStyle() == 2) {
            binding.steposMenuItemTitle.setTextColor(style.getItemWarningTextColor());
        } else {
            ColorStateList itemTextColor = style.getItemTextColor();
            if (itemTextColor != null) {
                binding.steposMenuItemTitle.setTextColor(itemTextColor);
            }
        }
        boolean z12 = true;
        binding.steposMenuItemTitle.setSelected(z10 && item.getTextStyle() != 2);
        CharSequence subtitle = item.getSubtitle();
        if (subtitle == null || subtitle.length() == 0 || (item.getIsExpandable() && !z11)) {
            z12 = false;
        }
        binding.steposMenuItemSubtitle.setText(item.getSubtitle());
        ColorStateList itemSubtitleTextColor = style.getItemSubtitleTextColor();
        if (itemSubtitleTextColor != null) {
            binding.steposMenuItemSubtitle.setTextColor(itemSubtitleTextColor);
        }
        binding.steposMenuItemSubtitle.setVisibility(z12 ? 0 : 8);
    }

    private static final void bindMenuItemTrailing(SteposMenuItemBinding steposMenuItemBinding, StepOSMenuItem stepOSMenuItem, boolean z10) {
        boolean z11 = z10 && stepOSMenuItem.getTrailing() == 1;
        boolean z12 = z10 && stepOSMenuItem.getTrailing() == 2;
        boolean z13 = z10 && stepOSMenuItem.getTrailing() == 3;
        steposMenuItemBinding.steposMenuItemBadge.setVisibility(z11 ? 0 : 8);
        steposMenuItemBinding.steposMenuItemTag.setVisibility(z12 ? 0 : 8);
        steposMenuItemBinding.steposMenuItemTrailingIcon.setVisibility(z13 ? 0 : 8);
        float f10 = stepOSMenuItem.getIsEnabled() ? 1.0f : 0.3f;
        steposMenuItemBinding.steposMenuItemBadge.setAlpha(f10);
        steposMenuItemBinding.steposMenuItemTag.setAlpha(f10);
        steposMenuItemBinding.steposMenuItemTrailingIcon.setAlpha(f10);
        if (z12) {
            steposMenuItemBinding.steposMenuItemTag.setText(stepOSMenuItem.getTagText());
        }
        if (!z13) {
            steposMenuItemBinding.steposMenuItemTrailingIcon.setImageDrawable(null);
            return;
        }
        ImageView steposMenuItemTrailingIcon = steposMenuItemBinding.steposMenuItemTrailingIcon;
        p.h(steposMenuItemTrailingIcon, "steposMenuItemTrailingIcon");
        bindMenuItemIcon(steposMenuItemTrailingIcon, stepOSMenuItem.getTrailingIcon(), stepOSMenuItem.getTrailingIconRes());
    }

    public static final List<StepOSMenuItem> flattenVisibleMenuItems(List<StepOSMenuItem> items, Set<Integer> expandedIndexes) {
        p.i(items, "items");
        p.i(expandedIndexes, "expandedIndexes");
        ArrayList arrayList = new ArrayList(items.size());
        int i10 = 0;
        for (Object obj : items) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            StepOSMenuItem stepOSMenuItem = (StepOSMenuItem) obj;
            arrayList.add(stepOSMenuItem);
            if (stepOSMenuItem.getIsExpandable() && expandedIndexes.contains(Integer.valueOf(i10))) {
                arrayList.addAll(stepOSMenuItem.getChildren());
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static final boolean isMenuItemCheckable(StepOSMenuItem item, boolean z10) {
        p.i(item, "item");
        return z10 || item.getIsCheckable();
    }

    public static final boolean isMenuItemExpanded(StepOSMenuItem item, List<StepOSMenuItem> items, Set<Integer> expandedIndexes) {
        p.i(item, "item");
        p.i(items, "items");
        p.i(expandedIndexes, "expandedIndexes");
        int iIndexOf = items.indexOf(item);
        return item.getIsExpandable() && iIndexOf >= 0 && expandedIndexes.contains(Integer.valueOf(iIndexOf));
    }

    public static final CharSequence menuItemContentDescription(StepOSMenuItem item, boolean z10, CharSequence badgeDescription) {
        CharSequence tagText;
        p.i(item, "item");
        p.i(badgeDescription, "badgeDescription");
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(item.getTitle());
        CharSequence subtitle = item.getSubtitle();
        if (subtitle != null && subtitle.length() != 0 && (!item.getIsExpandable() || z10)) {
            arrayList.add(subtitle);
        }
        int trailing = item.getTrailing();
        if (trailing == 1) {
            arrayList.add(badgeDescription);
        } else if (trailing == 2 && (tagText = item.getTagText()) != null) {
            arrayList.add(tagText);
        }
        return arrayList.size() == 1 ? item.getTitle() : F.A0(arrayList, ", ", null, null, 0, null, null, 62, null);
    }

    private static final void resizeSquare(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width == i10 && layoutParams.height == i10) {
            return;
        }
        layoutParams.width = i10;
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public static final void bindMenuItemIcon(ImageView iconView, Drawable drawable, int i10) {
        p.i(iconView, "iconView");
        if (drawable != null) {
            iconView.setImageDrawable(drawable);
            iconView.setVisibility(0);
        } else if (i10 != 0) {
            iconView.setImageResource(i10);
            iconView.setVisibility(0);
        } else {
            iconView.setImageDrawable(null);
            iconView.setVisibility(8);
        }
    }
}
