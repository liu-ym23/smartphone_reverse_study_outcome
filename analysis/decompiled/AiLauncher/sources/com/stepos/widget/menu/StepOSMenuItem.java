package com.stepos.widget.menu;

import Z8.C1173v;
import android.graphics.drawable.Drawable;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 -2\u00020\u0001:\u0003+,-B\u009d\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015B\u009f\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0014\u0010\u0019B\u009b\u0001\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0014\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u00020\u00058G¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\"R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\"R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\"R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\"R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0013\u001a\u00020\u00058G¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 ¨\u0006."}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuItem;", "", "title", "", "iconRes", "", "id", "isEnabled", "", "isCheckable", "isPressed", "subtitle", "textStyle", "isExpandable", "isExpanded", "children", "", "trailing", "tagText", "trailingIconRes", "<init>", "(Ljava/lang/CharSequence;IIZZZLjava/lang/CharSequence;IZZLjava/util/List;ILjava/lang/CharSequence;I)V", "icon", "Landroid/graphics/drawable/Drawable;", "trailingIcon", "(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;IZZZLjava/lang/CharSequence;IZZLjava/util/List;ILjava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)V", "(Ljava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;IZZZLjava/lang/CharSequence;IZZLjava/util/List;ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;)V", "getTitle", "()Ljava/lang/CharSequence;", "getIconRes", "()I", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getId", "()Z", "getSubtitle", "getTextStyle", "getChildren", "()Ljava/util/List;", "getTrailing", "getTagText", "getTrailingIconRes", "getTrailingIcon", "TextStyle", "Trailing", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSMenuItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TEXT_STYLE_DEFAULT = 0;
    public static final int TEXT_STYLE_SELECTED = 1;
    public static final int TEXT_STYLE_WARNING = 2;
    public static final int TRAILING_BADGE = 1;
    public static final int TRAILING_ICON = 3;
    public static final int TRAILING_NONE = 0;
    public static final int TRAILING_TAG = 2;
    private final List<StepOSMenuItem> children;
    private final Drawable icon;
    private final int iconRes;
    private final int id;
    private final boolean isCheckable;
    private final boolean isEnabled;
    private final boolean isExpandable;
    private final boolean isExpanded;
    private final boolean isPressed;
    private final CharSequence subtitle;
    private final CharSequence tagText;
    private final int textStyle;
    private final CharSequence title;
    private final int trailing;
    private final Drawable trailingIcon;
    private final int trailingIconRes;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J.\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuItem$Companion;", "", "<init>", "()V", "TEXT_STYLE_DEFAULT", "", "TEXT_STYLE_SELECTED", "TEXT_STYLE_WARNING", "TRAILING_NONE", "TRAILING_BADGE", "TRAILING_TAG", "TRAILING_ICON", "requireTextStyle", UxipConstants.f30680s, "requireTrailing", "trailing", "tagText", "", "trailingIconRes", "trailingIcon", "Landroid/graphics/drawable/Drawable;", "copyChildren", "", "Lcom/stepos/widget/menu/StepOSMenuItem;", "children", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<StepOSMenuItem> copyChildren(List<StepOSMenuItem> children) {
            List<StepOSMenuItem> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(children));
            p.h(listUnmodifiableList, "unmodifiableList(...)");
            return listUnmodifiableList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int requireTextStyle(int value) {
            if (value == 0 || value == 1 || value == 2) {
                return value;
            }
            throw new IllegalArgumentException(("textStyle must be TEXT_STYLE_DEFAULT, TEXT_STYLE_SELECTED, or TEXT_STYLE_WARNING but was " + value).toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int requireTrailing(int trailing, CharSequence tagText, int trailingIconRes, Drawable trailingIcon) {
            boolean z10 = true;
            if (trailing != 0 && trailing != 1 && trailing != 2 && trailing != 3) {
                throw new IllegalArgumentException(("trailing must be TRAILING_NONE, TRAILING_BADGE, TRAILING_TAG, or TRAILING_ICON but was " + trailing).toString());
            }
            if (trailing == 2) {
                if (tagText != null && tagText.length() != 0) {
                    z10 = false;
                }
                if (z10) {
                    throw new IllegalArgumentException("trailing TAG requires a non-empty tagText");
                }
            }
            if (trailing == 3 && trailingIcon == null && trailingIconRes == 0) {
                throw new IllegalArgumentException("trailing ICON requires trailingIcon or a non-zero trailingIconRes");
            }
            return trailing;
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuItem$TextStyle;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface TextStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/menu/StepOSMenuItem$Trailing;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface Trailing {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title) {
        this(title, 0, 0, false, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16382, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    public final List<StepOSMenuItem> getChildren() {
        return this.children;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getId() {
        return this.id;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final CharSequence getTagText() {
        return this.tagText;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTrailing() {
        return this.trailing;
    }

    public final Drawable getTrailingIcon() {
        return this.trailingIcon;
    }

    public final int getTrailingIconRes() {
        return this.trailingIconRes;
    }

    /* renamed from: isCheckable, reason: from getter */
    public final boolean getIsCheckable() {
        return this.isCheckable;
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: isExpandable, reason: from getter */
    public final boolean getIsExpandable() {
        return this.isExpandable;
    }

    /* renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    /* renamed from: isPressed, reason: from getter */
    public final boolean getIsPressed() {
        return this.isPressed;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10) {
        this(title, i10, 0, false, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16380, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11) {
        this(title, i10, i11, false, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16376, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10) {
        this(title, i10, i11, z10, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16368, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11) {
        this(title, i10, i11, z10, z11, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16352, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12) {
        this(title, i10, i11, z10, z11, z12, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16320, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence) {
        this(title, i10, i11, z10, z11, z12, charSequence, 0, false, false, (List) null, 0, (CharSequence) null, 0, 16256, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12) {
        this(title, i10, i11, z10, z11, z12, charSequence, i12, false, false, (List) null, 0, (CharSequence) null, 0, 16128, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12, boolean z13) {
        this(title, i10, i11, z10, z11, z12, charSequence, i12, z13, false, (List) null, 0, (CharSequence) null, 0, 15872, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12, boolean z13, boolean z14) {
        this(title, i10, i11, z10, z11, z12, charSequence, i12, z13, z14, (List) null, 0, (CharSequence) null, 0, 15360, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12, boolean z13, boolean z14, List<StepOSMenuItem> children) {
        this(title, i10, i11, z10, z11, z12, charSequence, i12, z13, z14, children, 0, (CharSequence) null, 0, 14336, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12, boolean z13, boolean z14, List<StepOSMenuItem> children, int i13) {
        this(title, i10, i11, z10, z11, z12, charSequence, i12, z13, z14, children, i13, (CharSequence) null, 0, 12288, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12, boolean z13, boolean z14, List<StepOSMenuItem> children, int i13, CharSequence charSequence2) {
        this(title, i10, i11, z10, z11, z12, charSequence, i12, z13, z14, children, i13, charSequence2, 0, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable) {
        this(title, drawable, 0, false, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16380, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10) {
        this(title, drawable, i10, false, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16376, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10) {
        this(title, drawable, i10, z10, false, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16368, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11) {
        this(title, drawable, i10, z10, z11, false, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16352, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12) {
        this(title, drawable, i10, z10, z11, z12, (CharSequence) null, 0, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16320, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence) {
        this(title, drawable, i10, z10, z11, z12, charSequence, 0, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16256, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11) {
        this(title, drawable, i10, z10, z11, z12, charSequence, i11, false, false, (List) null, 0, (CharSequence) null, (Drawable) null, 16128, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11, boolean z13) {
        this(title, drawable, i10, z10, z11, z12, charSequence, i11, z13, false, (List) null, 0, (CharSequence) null, (Drawable) null, 15872, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11, boolean z13, boolean z14) {
        this(title, drawable, i10, z10, z11, z12, charSequence, i11, z13, z14, (List) null, 0, (CharSequence) null, (Drawable) null, 15360, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11, boolean z13, boolean z14, List<StepOSMenuItem> children) {
        this(title, drawable, i10, z10, z11, z12, charSequence, i11, z13, z14, children, 0, (CharSequence) null, (Drawable) null, 14336, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11, boolean z13, boolean z14, List<StepOSMenuItem> children, int i12) {
        this(title, drawable, i10, z10, z11, z12, charSequence, i11, z13, z14, children, i12, (CharSequence) null, (Drawable) null, 12288, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11, boolean z13, boolean z14, List<StepOSMenuItem> children, int i12, CharSequence charSequence2) {
        this(title, drawable, i10, z10, z11, z12, charSequence, i11, z13, z14, children, i12, charSequence2, (Drawable) null, com.stepos.agentframework.chatui.longtext.b.THRESHOLD, (kotlin.jvm.internal.i) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    public /* synthetic */ StepOSMenuItem(CharSequence charSequence, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence2, int i12, boolean z13, boolean z14, List list, int i13, CharSequence charSequence3, int i14, int i15, kotlin.jvm.internal.i iVar) {
        this(charSequence, (i15 & 2) != 0 ? 0 : i10, (i15 & 4) != 0 ? 0 : i11, (i15 & 8) != 0 ? true : z10, (i15 & 16) != 0 ? false : z11, (i15 & 32) != 0 ? false : z12, (i15 & 64) != 0 ? null : charSequence2, (i15 & 128) != 0 ? 0 : i12, (i15 & 256) != 0 ? false : z13, (i15 & 512) != 0 ? false : z14, (List<StepOSMenuItem>) ((i15 & 1024) != 0 ? C1173v.m() : list), (i15 & 2048) != 0 ? 0 : i13, (i15 & 4096) == 0 ? charSequence3 : null, (i15 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 0 : i14);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, int i10, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i12, boolean z13, boolean z14, List<StepOSMenuItem> children, int i13, CharSequence charSequence2, int i14) {
        this(title, i10, (Drawable) null, i11, z10, z11, z12, charSequence, i12, z13, z14, children, i13, charSequence2, i14, (Drawable) null);
        p.i(title, "title");
        p.i(children, "children");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ StepOSMenuItem(java.lang.CharSequence r19, android.graphics.drawable.Drawable r20, int r21, boolean r22, boolean r23, boolean r24, java.lang.CharSequence r25, int r26, boolean r27, boolean r28, java.util.List r29, int r30, java.lang.CharSequence r31, android.graphics.drawable.Drawable r32, int r33, kotlin.jvm.internal.i r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L9
            r6 = r2
            goto Lb
        L9:
            r6 = r21
        Lb:
            r1 = r0 & 8
            if (r1 == 0) goto L12
            r1 = 1
            r7 = r1
            goto L14
        L12:
            r7 = r22
        L14:
            r1 = r0 & 16
            if (r1 == 0) goto L1a
            r8 = r2
            goto L1c
        L1a:
            r8 = r23
        L1c:
            r1 = r0 & 32
            if (r1 == 0) goto L22
            r9 = r2
            goto L24
        L22:
            r9 = r24
        L24:
            r1 = r0 & 64
            r3 = 0
            if (r1 == 0) goto L2b
            r10 = r3
            goto L2d
        L2b:
            r10 = r25
        L2d:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L33
            r11 = r2
            goto L35
        L33:
            r11 = r26
        L35:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L3b
            r12 = r2
            goto L3d
        L3b:
            r12 = r27
        L3d:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L43
            r13 = r2
            goto L45
        L43:
            r13 = r28
        L45:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L4f
            java.util.List r1 = Z8.C1173v.m()
            r14 = r1
            goto L51
        L4f:
            r14 = r29
        L51:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L57
            r15 = r2
            goto L59
        L57:
            r15 = r30
        L59:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L60
            r16 = r3
            goto L62
        L60:
            r16 = r31
        L62:
            r0 = r0 & 8192(0x2000, float:1.148E-41)
            if (r0 == 0) goto L6f
            r17 = r3
            r4 = r19
            r5 = r20
            r3 = r18
            goto L77
        L6f:
            r17 = r32
            r3 = r18
            r4 = r19
            r5 = r20
        L77:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.menu.StepOSMenuItem.<init>(java.lang.CharSequence, android.graphics.drawable.Drawable, int, boolean, boolean, boolean, java.lang.CharSequence, int, boolean, boolean, java.util.List, int, java.lang.CharSequence, android.graphics.drawable.Drawable, int, kotlin.jvm.internal.i):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSMenuItem(CharSequence title, Drawable drawable, int i10, boolean z10, boolean z11, boolean z12, CharSequence charSequence, int i11, boolean z13, boolean z14, List<StepOSMenuItem> children, int i12, CharSequence charSequence2, Drawable drawable2) {
        this(title, 0, drawable, i10, z10, z11, z12, charSequence, i11, z13, z14, children, i12, charSequence2, 0, drawable2);
        p.i(title, "title");
        p.i(children, "children");
    }

    private StepOSMenuItem(CharSequence charSequence, int i10, Drawable drawable, int i11, boolean z10, boolean z11, boolean z12, CharSequence charSequence2, int i12, boolean z13, boolean z14, List<StepOSMenuItem> list, int i13, CharSequence charSequence3, int i14, Drawable drawable2) {
        this.title = charSequence;
        this.iconRes = i10;
        this.icon = drawable;
        this.id = i11;
        this.isEnabled = z10;
        this.isCheckable = z11;
        this.isPressed = z12;
        this.subtitle = charSequence2;
        Companion companion = INSTANCE;
        this.textStyle = companion.requireTextStyle(i12);
        this.isExpandable = z13;
        this.isExpanded = z14;
        this.children = companion.copyChildren(list);
        this.trailing = companion.requireTrailing(i13, charSequence3, i14, drawable2);
        this.tagText = charSequence3;
        this.trailingIconRes = i14;
        this.trailingIcon = drawable2;
    }
}
