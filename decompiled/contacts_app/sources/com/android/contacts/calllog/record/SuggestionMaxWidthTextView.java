package com.android.contacts.calllog.record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SuggestionMaxWidthTextView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/contacts/calllog/record/SuggestionMaxWidthTextView;", "Lcom/obric/oui/text/OTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/graphics/drawable/Drawable;", "endIcon", "getEndIcon", "()Landroid/graphics/drawable/Drawable;", "setEndIcon", "(Landroid/graphics/drawable/Drawable;)V", "endIconDrawable", "icon", "getIcon", "setIcon", "startIconDrawable", "applyDrawables", "", "applyIconBounds", "drawable", "sizeDp", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SuggestionMaxWidthTextView extends OTextView {
    private static final Companion Companion = null;

    @Deprecated
    public static final int END_ICON_SIZE_DP = 22;

    @Deprecated
    public static final int END_TEXT_EXTRA_GAP_DP = 6;

    @Deprecated
    public static final int START_ICON_SIZE_DP = 14;

    @Deprecated
    public static final int START_TEXT_GAP_DP = 6;
    private Drawable endIcon;
    private Drawable endIconDrawable;
    private Drawable icon;
    private Drawable startIconDrawable;

    /* JADX INFO: compiled from: SuggestionMaxWidthTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/contacts/calllog/record/SuggestionMaxWidthTextView$Companion;", "", "()V", "END_ICON_SIZE_DP", "", "END_TEXT_EXTRA_GAP_DP", "START_ICON_SIZE_DP", "START_TEXT_GAP_DP", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SuggestionMaxWidthTextView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public SuggestionMaxWidthTextView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ SuggestionMaxWidthTextView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public SuggestionMaxWidthTextView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        setCompoundDrawablePadding(MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics())));
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable r2) {
        this.icon = r2;
        if (r2 == null) goto L7;
        Drawable r3 = r2.mutate();
        if (r3 == null) goto L7;
        applyIconBounds(r3, 14);
    L8:
        this.startIconDrawable = r3;
        applyDrawables();
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final Drawable getEndIcon() {
        return this.endIcon;
    }

    public final void setEndIcon(Drawable r10) {
        this.endIcon = r10;
        if (r10 == null) goto L5;
        int r0 = MathKt.roundToInt(TypedValue.applyDimension(1, 22, Resources.getSystem().getDisplayMetrics()));
        Drawable r4 = r10.mutate();
        Intrinsics.checkNotNullExpressionValue(r4, "raw.mutate()");
        r4.setBounds(0, 0, r0, r0);
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics()));
        InsetDrawable r2 = new InsetDrawable(r4, r1, 0, 0, 0);
        r2.setBounds(0, 0, r1 + r0, r0);
    L6:
        this.endIconDrawable = r2;
        applyDrawables();
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void applyDrawables() {
        setCompoundDrawablesRelative(this.startIconDrawable, null, this.endIconDrawable, null);
    }

    private final void applyIconBounds(Drawable r2, int r3) {
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics()));
        r2.setBounds(0, 0, r1, r1);
    }
}
