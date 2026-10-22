package com.obric.oui.popover.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001:\u0001;B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dRT\u0010)\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R*\u0010:\u001a\u00020\n2\u0006\u00104\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u000e¨\u0006<"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "pressed", "", "setPressed", "(Z)V", "", "a", "F", "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "pressedCornerRadius", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "b", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;)V", "indexPos", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pressedColor", "c", "Lkotlin/jvm/functions/Function2;", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "notifyPressedCallback", "Landroid/graphics/drawable/GradientDrawable;", "d", "Landroid/graphics/drawable/GradientDrawable;", "getStateBackground", "()Landroid/graphics/drawable/GradientDrawable;", "setStateBackground", "(Landroid/graphics/drawable/GradientDrawable;)V", "stateBackground", "e", "I", CommonKey.KEY_VALUE, "f", "Z", "getForceDark", "()Z", "setForceDark", "forceDark", "Index", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Index f16199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2 f16200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GradientDrawable f16201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16203f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "", "(Ljava/lang/String;I)V", "FIRST", "LAST", "OTHER", "ONLY_ONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Index extends Enum<Index> {
        private static final /* synthetic */ Index[] $VALUES = null;
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        private static final /* synthetic */ Index[] $values() {
            return new Index[]{FIRST, LAST, OTHER, ONLY_ONE};
        }

        static {
            FIRST = new Index("FIRST", 0);
            LAST = new Index("LAST", 1);
            OTHER = new Index("OTHER", 2);
            ONLY_ONE = new Index("ONLY_ONE", 3);
            $VALUES = $values();
        }

        private Index(String r10, int r11) {
            super(r10, r11);
        }

        public static Index valueOf(String r10) {
            return (Index) Enum.valueOf(Index.class, r10);
        }

        public static Index[] values() {
            return (Index[]) $VALUES.clone();
        }
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final boolean getForceDark() {
        return this.f16203f;
    }

    @NotNull
    public final Index getIndexPos() {
        return this.f16199b;
    }

    @Nullable
    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.f16200c;
    }

    public final float getPressedCornerRadius() {
        return this.f16198a;
    }

    @Nullable
    public final GradientDrawable getStateBackground() {
        return this.f16201d;
    }

    public final void setForceDark(boolean r10) {
        GradientDrawable r11 = null;
        if (r10 == false) goto L8;
        this.f16202e = Color.parseColor("#1affffff");
        Drawable r12 = ContextCompat.d(getContext(), R$drawable.o_pop_list_item_dark);
        if ((r12 instanceof GradientDrawable) == false) goto L7;
        r11 = (GradientDrawable) r12;
    L7:
        this.f16201d = r11;
    L12:
        GradientDrawable r13 = this.f16201d;
        if (r13 == null) goto L16;
        setBackground(r13);
    L16:
        this.f16203f = r10;
        return;
    L8:
        this.f16202e = ContextCompat.b(getContext(), R$color.oui_state_overlay_pressed);
        Drawable r14 = ContextCompat.d(getContext(), R$drawable.o_pop_list_item);
        if ((r14 instanceof GradientDrawable) == false) goto L11;
        r11 = (GradientDrawable) r14;
    L11:
        this.f16201d = r11;
        goto L12
    }

    public final void setIndexPos(@NotNull Index r10) {
        q.g(r10, "<set-?>");
        this.f16199b = r10;
    }

    public final void setNotifyPressedCallback(@Nullable Function2<? super Boolean, ? super Integer, Unit> r10) {
        this.f16200c = r10;
    }

    @Override // android.view.View
    @RequiresApi(29)
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        Function2 r11 = this.f16200c;
        if (r11 == null) goto L7;
        r11.mo0invoke(Boolean.valueOf(r10), Integer.valueOf(this.f16202e));
        return;
    }

    public final void setPressedCornerRadius(float r10) {
        this.f16198a = r10;
    }

    public final void setStateBackground(@Nullable GradientDrawable r10) {
        this.f16201d = r10;
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16198a = f.u(this, 20);
        this.f16199b = Index.OTHER;
        this.f16202e = ContextCompat.b(r10, R$color.oui_state_overlay_pressed);
    }
}
