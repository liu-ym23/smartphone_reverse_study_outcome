package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.obric.common.oui.R$drawable;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OListItemGeneral;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheetItemView;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getCheckMark", "()Landroid/view/View;", "Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;", "style", "", "setCheckStyle", "(Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;)V", "", "str", "setTitle", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", CommonConfirmDialog.ARGS_CHECKED, "setChecked", "(Z)V", "Landroid/widget/FrameLayout;", "h", "()Landroid/widget/FrameLayout;", "p", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionSheetItemView extends OListItemGeneral {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f16755p = null;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/selection/OSelectionSheetItemView$Companion$CheckStyle;", "", "(Ljava/lang/String;I)V", "NONE", "ICON", "CHECKBOX", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public static final /* synthetic */ int[] f16756a = null;

        static {
            int[] r10 = new int[Companion.CheckStyle.values().length];
            r10[Companion.CheckStyle.ICON.ordinal()] = 1;
            r10[Companion.CheckStyle.CHECKBOX.ordinal()] = 2;
            r10[Companion.CheckStyle.NONE.ordinal()] = 3;
            f16756a = r10;
        }
    }

    static {
        f16755p = new Companion(null);
    }

    public OSelectionSheetItemView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setCheckStyle(Companion.CheckStyle.NONE);
        setShowDivider(true);
        setShowBackground(false);
        setBackground(null);
    }

    private final View getCheckMark() {
        c r10 = c.f24796a;
        View r11 = getMTrailingElement().getChildAt(0);
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

    public final FrameLayout h() {
        FrameLayout r10 = new FrameLayout(getContext());
        r10.setLayoutParams(new FrameLayout.LayoutParams(f.r(r10, 32), f.r(r10, 24)));
        return r10;
    }

    public final void setCheckStyle(@NotNull Companion.CheckStyle r10) {
        q.g(r10, "style");
        int r11 = a.f16756a[r10.ordinal()];
        View r12 = null;
        if (r11 != 1) goto L5;
        ImageView r13 = new ImageView(getContext());
        r13.setImageDrawable(androidx.core.content.res.a.f(r13.getContext().getResources(), R$drawable.o_ic_radio_tick_checked, null));
        r12 = r13;
    L13:
        if (r12 == null) goto L15;
        FrameLayout r14 = h();
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 17;
        r14.addView(r12, r15);
        setTrailingView(r14);
        return;
    L15:
        getMTrailingElement().setVisibility(8);
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
        L.a("OSelectionSheetItemView", "checkMark is not OCheckBox or ImageView");
    }

    public final void setIcon(@Nullable Drawable r10) {
        setContentImage(r10);
    }

    public final void setTitle(@NotNull String r10) {
        q.g(r10, "str");
        setTitleString(r10);
    }
}
