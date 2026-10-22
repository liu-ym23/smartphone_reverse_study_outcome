package v3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.stepos.widget.list.StepOSListItem;
import j4.k;
import l3.C0847e;

/* renamed from: v3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1186c {
    private static final void b(StepOSListItem stepOSListItem, t3.b bVar) throws Resources.NotFoundException {
        if (bVar == t3.b.f22643b) {
            StepOSListItem.M(stepOSListItem, false, 1, null);
            return;
        }
        float dimension = stepOSListItem.getResources().getDimension(C0847e.f18354e);
        int dimensionPixelSize = stepOSListItem.getResources().getDimensionPixelSize(C0847e.f18323D);
        StepOSListItem.K(stepOSListItem, bVar.d(dimension), 0, bVar.h(), bVar.g() ? dimensionPixelSize : 0, bVar.e() ? dimensionPixelSize : 0, 2, null);
    }

    private static final void c(StepOSListItem stepOSListItem, com.stepos.widget.list.b bVar) {
        int iconStyle = stepOSListItem.getIconStyle();
        boolean zN = bVar.n();
        boolean zW = bVar.w();
        if (iconStyle != 1) {
            if ((iconStyle != 2 && iconStyle != 3 && iconStyle != 4 && iconStyle != 5) || zN) {
                return;
            }
        } else if (zN || zW) {
            return;
        }
        stepOSListItem.setIconTint(null);
        stepOSListItem.setIconBackgroundColor(null);
    }

    private static final void d(StepOSListItem stepOSListItem, C1184a c1184a) {
        Integer numF = c1184a.f();
        if (numF != null) {
            stepOSListItem.setIconStyle(numF.intValue());
        }
        Boolean boolK = c1184a.k();
        if (boolK != null) {
            stepOSListItem.setShowBadge(boolK.booleanValue());
        }
        Integer numA = c1184a.a();
        if (numA != null) {
            stepOSListItem.setBadgeStyle(numA.intValue());
        }
        Integer numB = c1184a.b();
        if (numB != null) {
            stepOSListItem.setBadgeTint(Integer.valueOf(numB.intValue()));
        }
        Boolean boolL = c1184a.l();
        if (boolL != null) {
            stepOSListItem.setShowRightBadge(boolL.booleanValue());
        }
        Integer numI = c1184a.i();
        if (numI != null) {
            stepOSListItem.setRightBadgeStyle(numI.intValue());
        }
        Integer numJ = c1184a.j();
        if (numJ != null) {
            stepOSListItem.setRightBadgeTint(Integer.valueOf(numJ.intValue()));
        }
        CharSequence charSequenceO = c1184a.o();
        if (charSequenceO != null) {
            stepOSListItem.setTitleEndText(charSequenceO);
        }
        Integer numH = c1184a.h();
        if (numH != null) {
            stepOSListItem.setLineMode(numH.intValue());
        }
    }

    private static final void e(StepOSListItem stepOSListItem, com.stepos.widget.list.b bVar, final C1184a c1184a, boolean z5) throws Resources.NotFoundException {
        int iS = c1184a.s(bVar);
        if (iS != 4) {
            stepOSListItem.setTrailingView(null);
        }
        stepOSListItem.setTrailingType(iS);
        if (iS == 0) {
            stepOSListItem.setShowAccessory(false);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            if (z5) {
                stepOSListItem.setOnItemClickListener(c1184a.g());
                return;
            }
            return;
        }
        if (iS == 2) {
            stepOSListItem.setShowAccessory(false);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            Boolean boolM = c1184a.m();
            if (boolM != null) {
                stepOSListItem.setSwitchChecked(boolM.booleanValue());
            }
            StepOSListItem.d dVarN = c1184a.n();
            if (dVarN == null) {
                dVarN = new StepOSListItem.d() { // from class: v3.b
                    @Override // com.stepos.widget.list.StepOSListItem.d
                    public final void a(StepOSListItem stepOSListItem2, boolean z6) {
                        C1186c.f(c1184a, stepOSListItem2, z6);
                    }
                };
            }
            stepOSListItem.setOnSwitchCheckedChangeListener(dVarN);
            if (z5) {
                stepOSListItem.setOnItemClickListener(null);
                return;
            }
            return;
        }
        if (iS == 3) {
            stepOSListItem.setShowAccessory(false);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            if (c1184a.d() != null || c1184a.c() != null) {
                stepOSListItem.w0(c1184a.d(), c1184a.c());
            }
            if (z5) {
                stepOSListItem.setOnItemClickListener(null);
                return;
            }
            return;
        }
        if (iS != 4) {
            stepOSListItem.setShowAccessory(true);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            if (z5) {
                stepOSListItem.setOnItemClickListener(c1184a.g());
                return;
            }
            return;
        }
        stepOSListItem.setOnSwitchCheckedChangeListener(null);
        View viewP = c1184a.p();
        if (viewP != null) {
            stepOSListItem.setTrailingView(viewP);
        }
        if (z5) {
            stepOSListItem.setOnItemClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C1184a c1184a, StepOSListItem stepOSListItem, boolean z5) {
        k.g(stepOSListItem, "<unused var>");
        c1184a.t(Boolean.valueOf(z5));
    }

    private static final void g(StepOSListItem stepOSListItem, com.stepos.widget.list.b bVar, C1184a c1184a, CharSequence charSequence, CharSequence charSequence2, Drawable drawable) {
        if (charSequence != null && charSequence.length() != 0) {
            stepOSListItem.setTitle(charSequence);
        }
        if (charSequence2 == null || charSequence2.length() == 0) {
            CharSequence charSequenceL = bVar.L();
            charSequence2 = (charSequenceL == null || charSequenceL.length() == 0) ? null : bVar.L();
        }
        stepOSListItem.setSubtitle(charSequence2);
        stepOSListItem.setValueText(c1184a.r(bVar));
        if (drawable != null) {
            stepOSListItem.setIcon(drawable);
            stepOSListItem.setShowIcon(true);
        } else if (bVar.q() != 0) {
            stepOSListItem.setShowIcon(bVar.x());
        } else {
            stepOSListItem.setIcon((Drawable) null);
            stepOSListItem.setShowIcon(false);
        }
    }

    public static final void h(StepOSListItem stepOSListItem, com.stepos.widget.list.b bVar, C1184a c1184a, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z5, boolean z6) throws Resources.NotFoundException {
        k.g(stepOSListItem, "row");
        k.g(bVar, "bridge");
        k.g(c1184a, "state");
        stepOSListItem.l0();
        stepOSListItem.T(bVar);
        d(stepOSListItem, c1184a);
        c(stepOSListItem, bVar);
        g(stepOSListItem, bVar, c1184a, charSequence, charSequence2, drawable);
        stepOSListItem.z0();
        e(stepOSListItem, bVar, c1184a, z6);
        stepOSListItem.y0();
        stepOSListItem.setEnabled(z5);
        stepOSListItem.setPressScaleEnabled(false);
        b(stepOSListItem, c1184a.e());
        stepOSListItem.setChecked(c1184a.q(bVar));
    }
}
