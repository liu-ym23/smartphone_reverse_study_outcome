package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002ABB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0010J\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u001f¢\u0006\u0004\b%\u0010!J\u0017\u0010&\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\fJ\u0017\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\fJ/\u0010,\u001a\u00020\n2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0002¢\u0006\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00105\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010?¨\u0006C"}, d2 = {"Lcom/obric/oui/avatar/OAvatar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "size", "", "setAvatarSize", "(Lcom/obric/oui/avatar/OAvatar$AvatarSize;)V", "", "inset", "setAvatarInset", "(I)V", "color", "setIconBorderColor", "Landroid/graphics/Bitmap;", "bitmap", "setAvatar", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "Lcom/obric/oui/avatar/OAvatar$IconType;", "iconType", "setIconType", "(Lcom/obric/oui/avatar/OAvatar$IconType;)V", "Lcom/obric/oui/avatar/OCircleImageView;", "getContentImageView", "()Lcom/obric/oui/avatar/OCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackgroundImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "getLogoImageView", "i", "h", "spaceHorizontalMargin", "spaceVerticalMargin", "borderWidth", "contentSize", "g", "(IIII)V", "a", "Lcom/obric/oui/avatar/OCircleImageView;", "ivAvatar", "b", "ivIcon", "c", "Landroidx/appcompat/widget/AppCompatImageView;", "ivBg", "Landroid/widget/Space;", "d", "Landroid/widget/Space;", "spacer", "e", "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "avatarSize", "f", "Lcom/obric/oui/avatar/OAvatar$IconType;", "I", "iconBorderColor", "AvatarSize", "IconType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatar extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCircleImageView f12351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCircleImageView f12352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f12353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Space f12354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AvatarSize f12355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IconType f12356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12357g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "", "dpValue", "", "(Ljava/lang/String;II)V", "getDpValue", "()I", "DP_16", "DP_20", "DP_24", "DP_32", "DP_40", "DP_48", "DP_56", "DP_64", "DP_72", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AvatarSize extends Enum<AvatarSize> {
        private static final /* synthetic */ AvatarSize[] $VALUES = null;
        public static final AvatarSize DP_16 = null;
        public static final AvatarSize DP_20 = null;
        public static final AvatarSize DP_24 = null;
        public static final AvatarSize DP_32 = null;
        public static final AvatarSize DP_40 = null;
        public static final AvatarSize DP_48 = null;
        public static final AvatarSize DP_56 = null;
        public static final AvatarSize DP_64 = null;
        public static final AvatarSize DP_72 = null;
        private final int dpValue;

        private static final /* synthetic */ AvatarSize[] $values() {
            return new AvatarSize[]{DP_16, DP_20, DP_24, DP_32, DP_40, DP_48, DP_56, DP_64, DP_72};
        }

        static {
            DP_16 = new AvatarSize("DP_16", 0, 16);
            DP_20 = new AvatarSize("DP_20", 1, 20);
            DP_24 = new AvatarSize("DP_24", 2, 24);
            DP_32 = new AvatarSize("DP_32", 3, 32);
            DP_40 = new AvatarSize("DP_40", 4, 40);
            DP_48 = new AvatarSize("DP_48", 5, 48);
            DP_56 = new AvatarSize("DP_56", 6, 56);
            DP_64 = new AvatarSize("DP_64", 7, 64);
            DP_72 = new AvatarSize("DP_72", 8, 72);
            $VALUES = $values();
        }

        private AvatarSize(String r10, int r11, int r12) {
            super(r10, r11);
            this.dpValue = r12;
        }

        public static AvatarSize valueOf(String r10) {
            return (AvatarSize) Enum.valueOf(AvatarSize.class, r10);
        }

        public static AvatarSize[] values() {
            return (AvatarSize[]) $VALUES.clone();
        }

        public final int getDpValue() {
            return this.dpValue;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/avatar/OAvatar$IconType;", "", "(Ljava/lang/String;I)V", "ONLINE", "LOGO", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum IconType extends Enum<IconType> {
        private static final /* synthetic */ IconType[] $VALUES = null;
        public static final IconType LOGO = null;
        public static final IconType ONLINE = null;

        private static final /* synthetic */ IconType[] $values() {
            return new IconType[]{ONLINE, LOGO};
        }

        static {
            ONLINE = new IconType("ONLINE", 0);
            LOGO = new IconType("LOGO", 1);
            $VALUES = $values();
        }

        private IconType(String r10, int r11) {
            super(r10, r11);
        }

        public static IconType valueOf(String r10) {
            return (IconType) Enum.valueOf(IconType.class, r10);
        }

        public static IconType[] values() {
            return (IconType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12358a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12359b = null;

        static {
            int[] r10 = new int[AvatarSize.values().length];
            r10[AvatarSize.DP_24.ordinal()] = 1;
            r10[AvatarSize.DP_32.ordinal()] = 2;
            r10[AvatarSize.DP_40.ordinal()] = 3;
            r10[AvatarSize.DP_48.ordinal()] = 4;
            r10[AvatarSize.DP_56.ordinal()] = 5;
            r10[AvatarSize.DP_64.ordinal()] = 6;
            r10[AvatarSize.DP_72.ordinal()] = 7;
            f12358a = r10;
            int[] r11 = new int[IconType.values().length];
            r11[IconType.LOGO.ordinal()] = 1;
            r11[IconType.ONLINE.ordinal()] = 2;
            f12359b = r11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OAvatar(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public final void g(int r10, int r11, int r12, int r13) {
        Space r14 = this.f12354d;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L11;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).rightMargin = r10;
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = r11;
        r14.setLayoutParams(r16);
        setAvatarInset(1);
        this.f12352b.setContentPadding(0);
        this.f12352b.setBorderWidth(r12);
        this.f12352b.setBorderColor(this.f12357g);
        OCircleImageView r17 = this.f12352b;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L9;
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        int r20 = r13 + (r12 * 2);
        ((ViewGroup.MarginLayoutParams) r19).width = r20;
        ((ViewGroup.MarginLayoutParams) r19).height = r20;
        r17.setLayoutParams(r19);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @NotNull
    public final AppCompatImageView getBackgroundImageView() {
        return this.f12353c;
    }

    @NotNull
    public final OCircleImageView getContentImageView() {
        return this.f12351a;
    }

    @NotNull
    public final OCircleImageView getLogoImageView() {
        return this.f12352b;
    }

    public final void h(AvatarSize r10) {
        float r11 = 12.0f;
        float r12 = 16.0f;
        r12 = 20.0f;
        float r13 = 1.5f;
        switch(a.f12358a[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        float r14 = 0.0f;
        float r15 = 0.0f;
        r12 = 0.0f;
        r13 = 0.0f;
    L13:
        g(f.q(this, r14), f.q(this, r15), f.q(this, r13), f.q(this, r12));
        return;
    L5:
        float r16 = (2 * 2.0f) + 20.0f;
        float r17 = r16 - 2.0f;
        float r18 = r16 - 4.0f;
        r15 = r17;
        r13 = 2.0f;
    L6:
        r14 = r18;
        goto L13
    L7:
        float r19 = (2 * 2.0f) + 16.0f;
        float r20 = r19 - 2.0f;
        r18 = r19 - 4.0f;
        r13 = 2.0f;
    L8:
        r15 = r20;
        goto L6
    L9:
        float r21 = (2 * 1.5f) + 16.0f;
        r20 = r21 - 1.5f;
        r18 = r21 - 3.5f;
        goto L8
    L10:
        float r22 = (2 * 1.5f) + 12.0f;
        r15 = r22 - 1.5f;
        r18 = r22 - 3.5f;
    L11:
        r12 = r11;
        goto L6
    L12:
        r13 = 1.0f;
        r11 = 10.0f;
        float r23 = (2 * 1.0f) + 10.0f;
        r15 = r23 - 1.0f;
        r18 = r23 - 3.0f;
        goto L11
    }

    public final void i(AvatarSize r10) {
        float r11 = 1.5f;
        float r12 = 10.0f;
        switch(a.f12358a[r10.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        float r13 = 0.0f;
        r11 = 0.0f;
        r12 = 0.0f;
    L15:
        g(f.q(this, r13), f.q(this, r13), f.q(this, r11), f.q(this, r12));
        return;
    L5:
        r13 = ((2 * 2.0f) + 12.0f) + 2.0f;
    L6:
        r12 = 12.0f;
    L7:
        r11 = 2.0f;
        goto L15
    L8:
        r13 = ((2 * 2.0f) + 12.0f) + 1.0f;
        goto L6
    L9:
        r13 = ((2 * 2.0f) + 10.0f) + 0.5f;
        goto L7
    L10:
        float r14 = ((2 * 1.5f) + 8.0f) + 0.5f;
    L11:
        r12 = 8.0f;
    L12:
        r13 = r14;
        goto L15
    L13:
        r14 = ((2 * 1.5f) + 8.0f) - 0.5f;
        goto L11
    L14:
        r14 = ((2 * 1.0f) + 6.0f) - 1;
        r12 = 6.0f;
        r11 = 1.0f;
        goto L12
    }

    public final void setAvatar(@NotNull Bitmap r10) {
        q.g(r10, "bitmap");
        this.f12351a.setImageBitmap(r10);
    }

    public final void setAvatarInset(int r10) {
        OCircleImageView r11 = this.f12351a;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L7;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        r13.setMargins(r10, r10, r10, r10);
        r11.setLayoutParams(r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setAvatarSize(@NotNull AvatarSize r10) {
        q.g(r10, "size");
        this.f12355e = r10;
        ViewGroup.LayoutParams r11 = getLayoutParams();
        if (r11 == null) goto L16;
        r11.width = f.r(this, r10.getDpValue());
        r11.height = f.r(this, r10.getDpValue());
        setLayoutParams(r11);
        if (this.f12352b.isShown() == true) goto L7;
        return;
    L7:
        if (this.f12352b.getDrawable() == null) goto L18;
        IconType r12 = this.f12356f;
        if (r12 != IconType.ONLINE) goto L12;
        i(r10);
        return;
    L12:
        if (r12 != IconType.LOGO) goto L20;
        h(r10);
        return;
    L20:
        return;
    L18:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setIconBorderColor(@ColorInt int r10) {
        this.f12357g = r10;
    }

    public final void setIconType(@NotNull IconType r10) {
        q.g(r10, "iconType");
        this.f12356f = r10;
    }

    public /* synthetic */ OAvatar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void setAvatar(@Nullable Drawable r10) {
        this.f12351a.setImageDrawable(r10);
    }

    @JvmOverloads
    public OAvatar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f12355e = AvatarSize.DP_24;
        this.f12356f = IconType.LOGO;
        this.f12357g = -1;
        ViewGroup.inflate(r10, R$layout.o_widget_avatar, this);
        View r12 = findViewById(R$id.iv_avatar);
        q.f(r12, "findViewById(R.id.iv_avatar)");
        OCircleImageView r13 = (OCircleImageView) r12;
        this.f12351a = r13;
        View r14 = findViewById(R$id.iv_icon);
        q.f(r14, "findViewById(R.id.iv_icon)");
        this.f12352b = (OCircleImageView) r14;
        View r15 = findViewById(R$id.iv_bg);
        q.f(r15, "findViewById(R.id.iv_bg)");
        this.f12353c = (AppCompatImageView) r15;
        View r16 = findViewById(R$id.spacer);
        q.f(r16, "findViewById(R.id.spacer)");
        this.f12354d = (Space) r16;
        setClipChildren(false);
        r13.setBorderWidth(f.r(this, 1));
        r13.setBorderColor(ContextCompat.b(r10, R$color.LineReverse2));
    }

    public final void setAvatar(int r10) {
        this.f12351a.setImageResource(r10);
    }
}
