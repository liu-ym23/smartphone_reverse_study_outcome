package i0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.emoji2.text.m;
import com.google.android.material.chip.Chip;
import e0.a0;
import f0.g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f3089b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(6);
        this.f3089b = bVar;
    }

    @Override // androidx.emoji2.text.m
    public final g l(int i8) {
        return new g(AccessibilityNodeInfo.obtain(this.f3089b.n(i8).f2542a));
    }

    @Override // androidx.emoji2.text.m
    public final g m(int i8) {
        b bVar = this.f3089b;
        int i9 = i8 == 2 ? bVar.f3099k : bVar.f3100l;
        if (i9 == Integer.MIN_VALUE) {
            return null;
        }
        return l(i9);
    }

    @Override // androidx.emoji2.text.m
    public final boolean o(int i8, int i9, Bundle bundle) {
        int i10;
        b bVar = this.f3089b;
        Chip chip = bVar.f3097i;
        if (i8 == -1) {
            int[] iArr = a0.f2285a;
            return chip.performAccessibilityAction(i9, bundle);
        }
        if (i9 == 1) {
            return bVar.q(i8);
        }
        if (i9 == 2) {
            return bVar.j(i8);
        }
        boolean z = false;
        if (i9 == 64) {
            AccessibilityManager accessibilityManager = bVar.f3096h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i10 = bVar.f3099k) == i8) {
                return false;
            }
            if (i10 != Integer.MIN_VALUE) {
                bVar.f3099k = Integer.MIN_VALUE;
                chip.invalidate();
                bVar.r(i10, 65536);
            }
            bVar.f3099k = i8;
            chip.invalidate();
            bVar.r(i8, 32768);
            return true;
        }
        if (i9 == 128) {
            if (bVar.f3099k != i8) {
                return false;
            }
            bVar.f3099k = Integer.MIN_VALUE;
            chip.invalidate();
            bVar.r(i8, 65536);
            return true;
        }
        Chip chip2 = ((l1.d) bVar).f3737q;
        if (i9 == 16) {
            if (i8 == 0) {
                return chip2.performClick();
            }
            if (i8 == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.f1294h;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z = true;
                }
                if (chip2.f1305t) {
                    chip2.f1304s.r(1, 1);
                }
            }
        }
        return z;
    }
}
