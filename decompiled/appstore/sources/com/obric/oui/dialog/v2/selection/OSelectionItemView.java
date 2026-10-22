package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$drawable;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getCheckMark", "()Landroid/view/View;", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "style", "", "setCheckStyle", "(Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;)V", "", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "(Z)V", "i", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionItemView extends ODialogListItemView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f14501i = null;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/selection/OSelectionItemView$Companion$CheckStyle;", "", "(Ljava/lang/String;I)V", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum CheckStyle extends Enum<CheckStyle> {
            private static final /* synthetic */ CheckStyle[] $VALUES = null;
            public static final CheckStyle CHECKBOX = null;
            public static final CheckStyle ICON = null;
            public static final CheckStyle NONE = null;

            private static final /* synthetic */ CheckStyle[] $values() {
                return new CheckStyle[]{NONE, ICON, CHECKBOX};
            }

            static {
                NONE = new CheckStyle("NONE", 0);
                ICON = new CheckStyle("ICON", 1);
                CHECKBOX = new CheckStyle("CHECKBOX", 2);
                $VALUES = $values();
            }

            private CheckStyle(String r10, int r11) {
                super(r10, r11);
            }

            public static CheckStyle valueOf(String r10) {
                return (CheckStyle) Enum.valueOf(CheckStyle.class, r10);
            }

            public static CheckStyle[] values() {
                return (CheckStyle[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public Companion() {
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14502a = null;

        static {
            int[] r10 = new int[Companion.CheckStyle.values().length];
            r10[Companion.CheckStyle.ICON.ordinal()] = 1;
            r10[Companion.CheckStyle.CHECKBOX.ordinal()] = 2;
            r10[Companion.CheckStyle.NONE.ordinal()] = 3;
            f14502a = r10;
        }
    }

    static {
        f14501i = new Companion(null);
    }

    public OSelectionItemView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(Companion.CheckStyle.NONE);
        d(true);
    }

    private final View getCheckMark() {
        c r10 = c.f24796a;
        View r11 = getTrailingContainer().getChildAt(0);
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        ViewGroup r12 = (ViewGroup) r11;
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.getChildAt(0);
    L6:
        if ((r11 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    public final void setCheckStyle(@NotNull Companion.CheckStyle r10) {
        q.g(r10, "style");
        int r11 = a.f14502a[r10.ordinal()];
        ImageView r12 = null;
        if (r11 != 1) goto L5;
        ImageView r13 = new ImageView(getContext());
        r13.setImageDrawable(androidx.core.content.res.a.f(r13.getContext().getResources(), R$drawable.oui_select_list_item_checker, null));
        r12 = r13;
    L13:
        if (r12 == null) goto L15;
        FrameLayout r14 = new FrameLayout(getContext());
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 17;
        r14.addView(r12, r15);
        c(r14, new ViewGroup.LayoutParams(f.r(this, 32), -2));
        return;
    L15:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r11 != 2) goto L7;
        Context r16 = getContext();
        q.f(r16, "context");
        r12 = new OCheckBox(r16);
        goto L13
    L7:
        if (r11 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final void setChecked(boolean r10) {
        View r11 = getCheckMark();
        if ((r11 instanceof OCheckBox) == false) goto L6;
        ((OCheckBox) r11).setChecked(r10);
        return;
    L6:
        if ((r11 instanceof ImageView) == false) goto L12;
        ImageView r12 = (ImageView) r11;
        if (r10 == false) goto L10;
        int r13 = 0;
    L11:
        r12.setVisibility(r13);
        return;
    L10:
        r13 = 4;
        goto L11
    L12:
        L.a("OSelectionItemView", "checkMark is not OCheckBox or ImageView");
    }
}
