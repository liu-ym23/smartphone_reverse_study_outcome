package V2;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.chip.Chip;
import com.stepos.ability.R;
import java.util.List;

/* loaded from: classes3.dex */
public final class b extends ExploreByTouchHelper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f1303a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Chip chip, Chip chip2) {
        super(chip2);
        this.f1303a = chip;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int getVirtualViewAt(float f, float f7) {
        Rect rect = Chip.f2389s;
        Chip chip = this.f1303a;
        return (chip.d() && chip.getCloseIconTouchBounds().contains(f, f7)) ? 1 : 0;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void getVisibleVirtualViews(List list) {
        d dVar;
        list.add(0);
        Rect rect = Chip.f2389s;
        Chip chip = this.f1303a;
        if (!chip.d() || (dVar = chip.f2391a) == null || !dVar.f1336Y || chip.d == null) {
            return;
        }
        list.add(1);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean onPerformActionForVirtualView(int i, int i6, Bundle bundle) {
        boolean z10 = false;
        if (i6 == 16) {
            Chip chip = this.f1303a;
            if (i == 0) {
                return chip.performClick();
            }
            if (i == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.d;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z10 = true;
                }
                if (chip.o) {
                    chip.n.sendEventForVirtualView(1, 1);
                }
            }
        }
        return z10;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Chip chip = this.f1303a;
        d dVar = chip.f2391a;
        accessibilityNodeInfoCompat.setCheckable(dVar != null && dVar.f1341e0);
        accessibilityNodeInfoCompat.setClickable(chip.isClickable());
        accessibilityNodeInfoCompat.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfoCompat.setText(chip.getText());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i != 1) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.f2389s);
            return;
        }
        Chip chip = this.f1303a;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfoCompat.setContentDescription(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfoCompat.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        accessibilityNodeInfoCompat.setEnabled(chip.isEnabled());
        accessibilityNodeInfoCompat.setClassName(Button.class.getName());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onVirtualViewKeyboardFocusChanged(int i, boolean z10) {
        Chip chip = this.f1303a;
        if (i == 1) {
            chip.i = z10;
        }
        d dVar = chip.f2391a;
        boolean z11 = chip.i;
        boolean zY = false;
        if (dVar.f1337Z != null) {
            zY = dVar.Y(z11 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : d.f1304T0);
        }
        if (zY) {
            chip.refreshDrawableState();
        }
    }
}
