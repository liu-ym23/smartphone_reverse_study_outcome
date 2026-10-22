package com.obric.oui.popover.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.android.vcard.VCardConstants;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopoverMenuLinearLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001.B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\nH\u0017R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RL\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "forceDark", "getForceDark", "()Z", "setForceDark", "(Z)V", "indexPos", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;)V", "notifyPressedCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pressed", "pressedColor", "", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "pressedCornerRadius", "", "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "stateBackground", "Landroid/graphics/drawable/GradientDrawable;", "getStateBackground", "()Landroid/graphics/drawable/GradientDrawable;", "setStateBackground", "(Landroid/graphics/drawable/GradientDrawable;)V", "setPressed", "Index", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PopoverMenuLinearLayout extends LinearLayout {
    private boolean forceDark;
    private Index indexPos;
    private Function2<? super Boolean, ? super Integer, Unit> notifyPressedCallback;
    private int pressedColor;
    private float pressedCornerRadius;
    private GradientDrawable stateBackground;

    /* JADX INFO: compiled from: PopoverMenuLinearLayout.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "", "(Ljava/lang/String;I)V", "FIRST", "LAST", VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER, "ONLY_ONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Index extends Enum<Index> {
        private static final /* synthetic */ Index[] $VALUES = null;
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        private static final /* synthetic */ Index[] $values() {
            return new Index[]{FIRST, LAST, OTHER, ONLY_ONE};
        }

        public static Index valueOf(String r1) {
            return (Index) Enum.valueOf(Index.class, r1);
        }

        public static Index[] values() {
            return (Index[]) $VALUES.clone();
        }

        private Index(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FIRST = new Index("FIRST", 0);
            LAST = new Index("LAST", 1);
            OTHER = new Index(VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER, 2);
            ONLY_ONE = new Index("ONLY_ONE", 3);
            $VALUES = $values();
        }
    }

    public PopoverMenuLinearLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public PopoverMenuLinearLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public PopoverMenuLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.pressedCornerRadius = OUnitExtensionKt.vdpFloat(this, 20);
        this.indexPos = Index.OTHER;
        this.pressedColor = ContextCompat.getColor(r2, R.color.oui_state_overlay_pressed);
    }

    public final float getPressedCornerRadius() {
        return this.pressedCornerRadius;
    }

    public final void setPressedCornerRadius(float r1) {
        this.pressedCornerRadius = r1;
    }

    public final Index getIndexPos() {
        return this.indexPos;
    }

    public final void setIndexPos(Index r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.indexPos = r2;
    }

    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.notifyPressedCallback;
    }

    public final void setNotifyPressedCallback(Function2<? super Boolean, ? super Integer, Unit> r1) {
        this.notifyPressedCallback = r1;
    }

    public final GradientDrawable getStateBackground() {
        return this.stateBackground;
    }

    public final void setStateBackground(GradientDrawable r1) {
        this.stateBackground = r1;
    }

    public final boolean getForceDark() {
        return this.forceDark;
    }

    public final void setForceDark(boolean r4) {
        GradientDrawable r0 = null;
        if (r4 == false) goto L8;
        this.pressedColor = Color.parseColor("#1affffff");
        Drawable r1 = ContextCompat.getDrawable(getContext(), R.drawable.o_pop_list_item_dark);
        if ((r1 instanceof GradientDrawable) == false) goto L7;
        r0 = (GradientDrawable) r1;
    L7:
        this.stateBackground = r0;
    L12:
        GradientDrawable r2 = this.stateBackground;
        if (r2 == null) goto L16;
        setBackground(r2);
    L16:
        this.forceDark = r4;
        return;
    L8:
        this.pressedColor = ContextCompat.getColor(getContext(), R.color.oui_state_overlay_pressed);
        Drawable r3 = ContextCompat.getDrawable(getContext(), R.drawable.o_pop_list_item);
        if ((r3 instanceof GradientDrawable) == false) goto L11;
        r0 = (GradientDrawable) r3;
    L11:
        this.stateBackground = r0;
        goto L12
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        Function2<? super Boolean, ? super Integer, Unit> r0 = this.notifyPressedCallback;
        if (r0 == null) goto L7;
        r0.invoke(Boolean.valueOf(r2), Integer.valueOf(this.pressedColor));
        return;
    }
}
