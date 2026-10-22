package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.a;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import g.b;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialAlertDialogBuilder extends a.C0006a {

    @AttrRes
    private static final int DEF_STYLE_ATTR = 0;

    @StyleRes
    private static final int DEF_STYLE_RES = 0;

    @AttrRes
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = 0;

    @Nullable
    private Drawable background;

    @NonNull
    @Dimension
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_ATTR = R.attr.alertDialogStyle;
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
        MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    }

    public MaterialAlertDialogBuilder(@NonNull Context r10) {
        this(r10, 0);
    }

    private static Context createMaterialAlertDialogThemedContext(@NonNull Context r10) {
        int r11 = getMaterialAlertDialogThemeOverlay(r10);
        Context r12 = MaterialThemeOverlay.wrap(r10, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        if (r11 != 0) goto L6;
        return r12;
    L6:
        return new b(r12, r11);
    }

    private static int getMaterialAlertDialogThemeOverlay(@NonNull Context r10) {
        TypedValue r11 = MaterialAttributes.resolve(r10, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.data;
    }

    private static int getOverridingThemeResId(@NonNull Context r10, int r11) {
        if (r11 == 0) goto L4;
        return r11;
    L4:
        return getMaterialAlertDialogThemeOverlay(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public a create() {
        a r10 = super.create();
        Window r11 = r10.getWindow();
        View r12 = r11.getDecorView();
        Drawable r13 = this.background;
        if ((r13 instanceof MaterialShapeDrawable) == false) goto L5;
        ((MaterialShapeDrawable) r13).setElevation(ViewCompat.v(r12));
    L5:
        r11.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        r12.setOnTouchListener(new InsetDialogOnTouchListener(r10, this.backgroundInsets));
        return r10;
    }

    @Nullable
    public Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setAdapter(@Nullable ListAdapter r10, @Nullable DialogInterface.OnClickListener r11) {
        return setAdapter(r10, r11);
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable r10) {
        this.background = r10;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int r10) {
        this.backgroundInsets.bottom = r10;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int r10) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
        this.backgroundInsets.left = r10;
    L6:
        return this;
    L5:
        this.backgroundInsets.right = r10;
        goto L6
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int r10) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
        this.backgroundInsets.right = r10;
    L6:
        return this;
    L5:
        this.backgroundInsets.left = r10;
        goto L6
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int r10) {
        this.backgroundInsets.top = r10;
        return this;
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setCancelable(boolean r10) {
        return setCancelable(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setCursor(@Nullable Cursor r10, @Nullable DialogInterface.OnClickListener r11, @NonNull String r12) {
        return setCursor(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setCustomTitle(@Nullable View r10) {
        return setCustomTitle(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setIcon(@DrawableRes int r10) {
        return setIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setIconAttribute(@AttrRes int r10) {
        return setIconAttribute(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setItems(@ArrayRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setItems(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setMessage(@StringRes int r10) {
        return setMessage(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setMultiChoiceItems(@ArrayRes int r10, @Nullable boolean[] r11, @Nullable DialogInterface.OnMultiChoiceClickListener r12) {
        return setMultiChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setNegativeButton(@StringRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setNegativeButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setNegativeButtonIcon(@Nullable Drawable r10) {
        return setNegativeButtonIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setNeutralButton(@StringRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setNeutralButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setNeutralButtonIcon(@Nullable Drawable r10) {
        return setNeutralButtonIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setOnCancelListener(@Nullable DialogInterface.OnCancelListener r10) {
        return setOnCancelListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setOnDismissListener(@Nullable DialogInterface.OnDismissListener r10) {
        return setOnDismissListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r10) {
        return setOnItemSelectedListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setOnKeyListener(@Nullable DialogInterface.OnKeyListener r10) {
        return setOnKeyListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setPositiveButton(@StringRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setPositiveButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setPositiveButtonIcon(@Nullable Drawable r10) {
        return setPositiveButtonIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setSingleChoiceItems(@ArrayRes int r10, int r11, @Nullable DialogInterface.OnClickListener r12) {
        return setSingleChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setTitle(@StringRes int r10) {
        return setTitle(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setView(int r10) {
        return setView(r10);
    }

    public MaterialAlertDialogBuilder(@NonNull Context r10, int r11) {
        super(createMaterialAlertDialogThemedContext(r10), getOverridingThemeResId(r10, r11));
        Context r12 = getContext();
        Resources.Theme r13 = r12.getTheme();
        int r14 = DEF_STYLE_ATTR;
        int r15 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(r12, r14, r15);
        int r16 = MaterialColors.getColor(r12, R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable r17 = new MaterialShapeDrawable(r12, null, r14, r15);
        r17.initializeElevationOverlay(r12);
        r17.setFillColor(ColorStateList.valueOf(r16));
        TypedValue r18 = new TypedValue();
        r13.resolveAttribute(android.R.attr.dialogCornerRadius, r18, true);
        float r19 = r18.getDimension(getContext().getResources().getDisplayMetrics());
        if (r18.type == 5) goto L5;
    L7:
        this.background = r17;
        return;
    L5:
        if (r19 < 0.0f) goto L7;
        r17.setCornerSize(r19);
        goto L7
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setAdapter(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setCancelable(boolean r10) {
        return (MaterialAlertDialogBuilder) super.setCancelable(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor r10, @Nullable DialogInterface.OnClickListener r11, @NonNull String r12) {
        return (MaterialAlertDialogBuilder) super.setCursor(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View r10) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setIcon(@Nullable Drawable r10) {
        return setIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int r10) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setItems(@Nullable CharSequence[] r10, @Nullable DialogInterface.OnClickListener r11) {
        return setItems(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setMessage(@Nullable CharSequence r10) {
        return setMessage(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setMultiChoiceItems(@Nullable Cursor r10, @NonNull String r11, @NonNull String r12, @Nullable DialogInterface.OnMultiChoiceClickListener r13) {
        return setMultiChoiceItems(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setNegativeButton(@Nullable CharSequence r10, @Nullable DialogInterface.OnClickListener r11) {
        return setNegativeButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable r10) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setNeutralButton(@Nullable CharSequence r10, @Nullable DialogInterface.OnClickListener r11) {
        return setNeutralButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable r10) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener r10) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener r10) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r10) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener r10) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setPositiveButton(@Nullable CharSequence r10, @Nullable DialogInterface.OnClickListener r11) {
        return setPositiveButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable r10) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setSingleChoiceItems(@Nullable Cursor r10, int r11, @NonNull String r12, @Nullable DialogInterface.OnClickListener r13) {
        return setSingleChoiceItems(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setTitle(@Nullable CharSequence r10) {
        return setTitle(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setView(@Nullable View r10) {
        return setView(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int r10) {
        return (MaterialAlertDialogBuilder) super.setIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setItems(@ArrayRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setItems(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@StringRes int r10) {
        return (MaterialAlertDialogBuilder) super.setMessage(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setMultiChoiceItems(@Nullable CharSequence[] r10, @Nullable boolean[] r11, @Nullable DialogInterface.OnMultiChoiceClickListener r12) {
        return setMultiChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setSingleChoiceItems(@Nullable ListAdapter r10, int r11, @Nullable DialogInterface.OnClickListener r12) {
        return setSingleChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@StringRes int r10) {
        return (MaterialAlertDialogBuilder) super.setTitle(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setView(int r10) {
        return (MaterialAlertDialogBuilder) super.setView(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable r10) {
        return (MaterialAlertDialogBuilder) super.setIcon(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setItems(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence r10) {
        return (MaterialAlertDialogBuilder) super.setMessage(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int r10, @Nullable boolean[] r11, @Nullable DialogInterface.OnMultiChoiceClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(r10, r11);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public /* bridge */ /* synthetic */ a.C0006a setSingleChoiceItems(@Nullable CharSequence[] r10, int r11, @Nullable DialogInterface.OnClickListener r12) {
        return setSingleChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence r10) {
        return (MaterialAlertDialogBuilder) super.setTitle(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setView(@Nullable View r10) {
        return (MaterialAlertDialogBuilder) super.setView(r10);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] r10, @Nullable boolean[] r11, @Nullable DialogInterface.OnMultiChoiceClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int r10, int r11, @Nullable DialogInterface.OnClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor r10, @NonNull String r11, @NonNull String r12, @Nullable DialogInterface.OnMultiChoiceClickListener r13) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor r10, int r11, @NonNull String r12, @Nullable DialogInterface.OnClickListener r13) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] r10, int r11, @Nullable DialogInterface.OnClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r10, r11, r12);
    }

    @Override // androidx.appcompat.app.a.C0006a
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter r10, int r11, @Nullable DialogInterface.OnClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r10, r11, r12);
    }
}
