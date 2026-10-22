package com.stepos.widget.tabbar;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import f.C4027a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b3\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\r*\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001e\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u0013J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b$\u0010\"J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\bJ\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010)\u001a\u00020\u0006H\u0001¢\u0006\u0004\b(\u0010\bJ\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010+R.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028A@AX\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0005R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0018\u00108\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00104R\u0016\u00109\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010:R$\u0010<\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010\u0011\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010I\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\bH\u0010GR\u0013\u0010K\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bJ\u0010ER\u0011\u0010L\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bN\u0010MR\u0011\u0010O\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bO\u0010MR\u0011\u0010Q\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bP\u0010C¨\u0006R"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "", "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;", "tabBar", "<init>", "(Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;)V", "LY8/t;", "notifyChanged", "()V", "", "operation", "requireTabBar", "(Ljava/lang/String;)Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;", "Landroid/graphics/drawable/Drawable;", "copyFor", "(Landroid/graphics/drawable/Drawable;Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;)Landroid/graphics/drawable/Drawable;", "", "itemId", "setItemId", "(I)Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "", "title", "setTitle", "(Ljava/lang/CharSequence;)Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "resId", "icon", "setIcon", "(Landroid/graphics/drawable/Drawable;)Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", "setSelectedIcon", "text", "setContentDescription", "", "visible", "setVisible", "(Z)Lcom/stepos/widget/tabbar/StepOSCollapsibleTab;", x5.d.EXTRA_ENABLED, "setEnabled", M5.c.ACTION_SELECT, "attachTo$StepOSWidget_release", "attachTo", "detach$StepOSWidget_release", "detach", "toString", "()Ljava/lang/String;", UxipConstants.f30680s, "Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;", "getTabBar$StepOSWidget_release", "()Lcom/stepos/widget/tabbar/StepOSCollapsibleTabBar;", "setTabBar$StepOSWidget_release", "itemIdValue", "I", "titleValue", "Ljava/lang/CharSequence;", "iconValue", "Landroid/graphics/drawable/Drawable;", "selectedIconValue", "contentDescriptionValue", "visibleValue", "Z", "enabledValue", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getItemId", "()I", "getTitle", "()Ljava/lang/CharSequence;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getSelectedIcon", "selectedIcon", "getContentDescription", "contentDescription", "isVisible", "()Z", "isEnabled", "isSelected", "getPosition", "position", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSCollapsibleTab {
    private CharSequence contentDescriptionValue;

    /* renamed from: enabledValue, reason: from kotlin metadata and from toString */
    private boolean enabled;
    private Drawable iconValue;

    /* renamed from: itemIdValue, reason: from kotlin metadata and from toString */
    private int itemId;
    private Drawable selectedIconValue;
    private StepOSCollapsibleTabBar tabBar;
    private Object tag;

    /* renamed from: titleValue, reason: from kotlin metadata and from toString */
    private CharSequence title;

    /* renamed from: visibleValue, reason: from kotlin metadata and from toString */
    private boolean visible;

    public StepOSCollapsibleTab(StepOSCollapsibleTabBar tabBar) {
        kotlin.jvm.internal.p.i(tabBar, "tabBar");
        this.tabBar = tabBar;
        this.visible = true;
        this.enabled = true;
    }

    private final Drawable copyFor(Drawable drawable, StepOSCollapsibleTabBar stepOSCollapsibleTabBar) {
        Drawable drawableMutate;
        Drawable drawableNewDrawable = null;
        Resources resources = stepOSCollapsibleTabBar != null ? stepOSCollapsibleTabBar.getResources() : null;
        if (resources != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawableNewDrawable = constantState.newDrawable(resources);
            }
        } else {
            Drawable.ConstantState constantState2 = drawable.getConstantState();
            if (constantState2 != null) {
                drawableNewDrawable = constantState2.newDrawable();
            }
        }
        if (drawableNewDrawable != null && (drawableMutate = drawableNewDrawable.mutate()) != null) {
            return drawableMutate;
        }
        Drawable drawableMutate2 = drawable.mutate();
        kotlin.jvm.internal.p.h(drawableMutate2, "mutate(...)");
        return drawableMutate2;
    }

    private final void notifyChanged() {
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar != null) {
            stepOSCollapsibleTabBar.onTabChanged$StepOSWidget_release(this);
        }
    }

    private final StepOSCollapsibleTabBar requireTabBar(String operation) {
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar != null) {
            return stepOSCollapsibleTabBar;
        }
        throw new IllegalStateException(("StepOSCollapsibleTab 已从 StepOSCollapsibleTabBar 摘除，无法执行 " + operation + "。需要恢复完整能力请先 addTab(tab) 把它加回去").toString());
    }

    public final void attachTo$StepOSWidget_release(StepOSCollapsibleTabBar tabBar) {
        kotlin.jvm.internal.p.i(tabBar, "tabBar");
        this.tabBar = tabBar;
    }

    public final void detach$StepOSWidget_release() {
        this.tabBar = null;
    }

    public final CharSequence getContentDescription() {
        CharSequence charSequence = this.contentDescriptionValue;
        return charSequence == null ? this.title : charSequence;
    }

    /* renamed from: getIcon, reason: from getter */
    public final Drawable getIconValue() {
        return this.iconValue;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final int getPosition() {
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar != null) {
            return stepOSCollapsibleTabBar.indexOfTab$StepOSWidget_release(this);
        }
        return -1;
    }

    /* renamed from: getSelectedIcon, reason: from getter */
    public final Drawable getSelectedIconValue() {
        return this.selectedIconValue;
    }

    /* renamed from: getTabBar$StepOSWidget_release, reason: from getter */
    public final StepOSCollapsibleTabBar getTabBar() {
        return this.tabBar;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean isSelected() {
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar == null) {
            return false;
        }
        int selectedItemIdValue = stepOSCollapsibleTabBar.getSelectedItemIdValue();
        int i10 = this.itemId;
        return selectedItemIdValue == i10 && i10 != 0;
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    public final void select() {
        requireTabBar("select()").setSelectedItemId(this.itemId);
    }

    public final StepOSCollapsibleTab setContentDescription(CharSequence text) {
        if (kotlin.jvm.internal.p.d(this.contentDescriptionValue, text)) {
            return this;
        }
        this.contentDescriptionValue = text;
        notifyChanged();
        return this;
    }

    public final StepOSCollapsibleTab setEnabled(boolean enabled) {
        if (this.enabled == enabled) {
            return this;
        }
        this.enabled = enabled;
        notifyChanged();
        return this;
    }

    public final StepOSCollapsibleTab setIcon(Drawable icon) {
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar != null) {
            stepOSCollapsibleTabBar.validateIconChange$StepOSWidget_release(this, icon);
        }
        if (this.iconValue == icon) {
            return this;
        }
        this.iconValue = icon != null ? copyFor(icon, this.tabBar) : null;
        notifyChanged();
        return this;
    }

    public final StepOSCollapsibleTab setItemId(int itemId) {
        if (itemId == 0) {
            throw new IllegalArgumentException("itemId 不能为 StepOSCollapsibleTabBar.NO_ID；请传一个唯一的 @id 资源");
        }
        if (this.itemId != itemId) {
            StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
            if (stepOSCollapsibleTabBar != null) {
                stepOSCollapsibleTabBar.validateItemIdChange$StepOSWidget_release(this, itemId);
            }
            int i10 = this.itemId;
            this.itemId = itemId;
            StepOSCollapsibleTabBar stepOSCollapsibleTabBar2 = this.tabBar;
            if (stepOSCollapsibleTabBar2 != null) {
                stepOSCollapsibleTabBar2.onTabItemIdChanged$StepOSWidget_release(this, i10);
            }
        }
        return this;
    }

    public final StepOSCollapsibleTab setSelectedIcon(Drawable icon) {
        if (this.selectedIconValue == icon) {
            return this;
        }
        this.selectedIconValue = icon != null ? copyFor(icon, this.tabBar) : null;
        notifyChanged();
        return this;
    }

    public final void setTabBar$StepOSWidget_release(StepOSCollapsibleTabBar stepOSCollapsibleTabBar) {
        this.tabBar = stepOSCollapsibleTabBar;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final StepOSCollapsibleTab setTitle(CharSequence title) {
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar != null) {
            stepOSCollapsibleTabBar.validateTitleChange$StepOSWidget_release(this, title);
        }
        if (kotlin.jvm.internal.p.d(this.title, title)) {
            return this;
        }
        this.title = title;
        notifyChanged();
        return this;
    }

    public final StepOSCollapsibleTab setVisible(boolean visible) {
        if (this.visible == visible) {
            return this;
        }
        StepOSCollapsibleTabBar stepOSCollapsibleTabBar = this.tabBar;
        if (stepOSCollapsibleTabBar != null) {
            stepOSCollapsibleTabBar.validateVisibilityChange$StepOSWidget_release(this, visible);
        }
        this.visible = visible;
        notifyChanged();
        return this;
    }

    public String toString() {
        String hexString = Integer.toHexString(this.itemId);
        CharSequence charSequence = this.title;
        return "StepOSCollapsibleTab(itemId=0x" + hexString + ", title=" + ((Object) charSequence) + ", position=" + getPosition() + ", visible=" + this.visible + ", enabled=" + this.enabled + ")";
    }

    public final StepOSCollapsibleTab setContentDescription(int resId) {
        if (resId != 0) {
            return setContentDescription(requireTabBar("setContentDescription(@StringRes)").getResources().getText(resId));
        }
        throw new IllegalArgumentException("resId 不能为 0，请传一个有效的 @string 资源 id");
    }

    public final StepOSCollapsibleTab setSelectedIcon(int resId) {
        if (resId != 0) {
            return setSelectedIcon(C4027a.b(requireTabBar("setSelectedIcon(@DrawableRes)").getContext(), resId));
        }
        throw new IllegalArgumentException("resId 不能为 0，请传一个有效的 @drawable 资源 id");
    }

    public final StepOSCollapsibleTab setIcon(int resId) {
        if (resId != 0) {
            return setIcon(C4027a.b(requireTabBar("setIcon(@DrawableRes)").getContext(), resId));
        }
        throw new IllegalArgumentException("resId 不能为 0，请传一个有效的 @drawable 资源 id");
    }

    public final StepOSCollapsibleTab setTitle(int resId) {
        if (resId != 0) {
            return setTitle(requireTabBar("setTitle(@StringRes)").getResources().getText(resId));
        }
        throw new IllegalArgumentException("resId 不能为 0，请传一个有效的 @string 资源 id");
    }
}
