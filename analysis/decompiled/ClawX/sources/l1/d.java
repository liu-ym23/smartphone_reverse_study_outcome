package l1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.google.android.material.chip.Chip;
import com.stepos.stepclaw.R;
import com.stepos.stepclaw.SecurePrefs;
import f0.g;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends i0.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Chip f3737q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Chip chip, Chip chip2) {
        super(chip2);
        this.f3737q = chip;
    }

    @Override // i0.b
    public final void l(ArrayList arrayList) {
        f fVar;
        arrayList.add(0);
        Rect rect = Chip.f1290x;
        Chip chip = this.f3737q;
        if (!chip.c() || (fVar = chip.f1291e) == null || !fVar.R || chip.f1294h == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // i0.b
    public final void o(int i8, g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        CharSequence charSequence = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (i8 != 1) {
            accessibilityNodeInfo.setContentDescription(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            accessibilityNodeInfo.setBoundsInParent(Chip.f1290x);
            return;
        }
        Chip chip = this.f3737q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            Context context = chip.getContext();
            if (!TextUtils.isEmpty(text)) {
                charSequence = text;
            }
            accessibilityNodeInfo.setContentDescription(context.getString(R.string.mtrl_chip_close_icon_content_description, charSequence).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        gVar.b(f0.c.f2531e);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
        gVar.h(Button.class.getName());
    }

    @Override // i0.b
    public final void p(int i8, boolean z) {
        Chip chip = this.f3737q;
        if (i8 == 1) {
            chip.f1299n = z;
        }
        f fVar = chip.f1291e;
        boolean z2 = chip.f1299n;
        boolean zQ = false;
        if (fVar.S != null) {
            zQ = fVar.Q(z2 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : f.M0);
        }
        if (zQ) {
            chip.refreshDrawableState();
        }
    }
}
