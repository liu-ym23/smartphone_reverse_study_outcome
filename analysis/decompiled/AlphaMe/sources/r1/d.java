package r1;

import L.g;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.google.android.material.chip.Chip;
import com.stepos.alphame.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends Q.b {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Chip f14011n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Chip chip, Chip chip2) {
        super(chip2);
        this.f14011n = chip;
    }

    @Override // Q.b
    public final void c(ArrayList arrayList) {
        boolean z4 = false;
        arrayList.add(0);
        Rect rect = Chip.f10571w;
        Chip chip = this.f14011n;
        if (chip.c()) {
            f fVar = chip.f10574e;
            if (fVar != null && fVar.f14045U) {
                z4 = true;
            }
            if (!z4 || chip.f10577h == null) {
                return;
            }
            arrayList.add(1);
        }
    }

    @Override // Q.b
    public final void f(int i4, g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f1142a;
        if (i4 != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.f10571w);
            return;
        }
        Chip chip = this.f14011n;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            Context context = chip.getContext();
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(text) ? "" : text;
            accessibilityNodeInfo.setContentDescription(context.getString(R.string.mtrl_chip_close_icon_content_description, objArr).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        gVar.b(L.b.f1129e);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
        gVar.g(Button.class.getName());
    }

    @Override // Q.b
    public final void g(int i4, boolean z4) {
        Chip chip = this.f14011n;
        if (i4 == 1) {
            chip.f10582m = z4;
        }
        f fVar = chip.f10574e;
        boolean z5 = chip.f10582m;
        if (fVar.f14047V != null) {
            if (fVar.S(z5 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : f.f14012a1)) {
                chip.refreshDrawableState();
            }
        }
    }
}
