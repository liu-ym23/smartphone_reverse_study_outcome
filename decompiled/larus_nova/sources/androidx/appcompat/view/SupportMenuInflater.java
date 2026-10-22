package androidx.appcompat.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = null;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = null;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r100) {
        L8:
            e = move-exception;
            throw new RuntimeException(e);
        L3:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L5;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r100});     // Catch: Exception -> L8
            return true;
        L5:
            return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{r100})).booleanValue();
        }

        public InflatedOnMenuItemClickListener(Object r100, String r101) {
            this.mRealOwner = r100;
            Class<?> r102 = r100.getClass();
            this.mMethod = r102.getMethod(r101, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            InflateException r103 = new InflateException("Couldn't resolve menu item onClick handler " + r101 + " in class " + r102.getName());
            r103.initCause(e);
            throw r103;
        }
    }

    public class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList;
        private PorterDuff.Mode itemIconTintMode;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;
        final /* synthetic */ SupportMenuInflater this$0;

        public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            return Class.forName(r100, r101, r102);
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu r100 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(r100.getItem());
            return r100;
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private char getShortcut(String r100) {
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.charAt(0);
        }

        private void setItem(MenuItem r100) {
            MenuItem r101 = r100.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean r102 = false;
            if (this.itemCheckable < 1) goto L5;
            boolean r103 = true;
        L6:
            r101.setCheckable(r103).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r104 = this.itemShowAsAction;
            if (r104 < 0) goto L10;
            r100.setShowAsAction(r104);
        L10:
            if (this.itemListenerMethodName == null) goto L17;
            if (this.this$0.mContext.isRestricted() == true) goto L15;
            r100.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.itemCheckable < 2) goto L25;
            if ((r100 instanceof MenuItemImpl) == false) goto L22;
            ((MenuItemImpl) r100).setExclusiveCheckable(true);
            goto L25
        L22:
            if ((r100 instanceof MenuItemWrapperICS) == false) goto L25;
            ((MenuItemWrapperICS) r100).setExclusiveCheckable(true);
        L25:
            if (this.itemActionViewClassName == null) goto L27;
            r100.setActionView((View) newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            r102 = true;
        L27:
            int r105 = this.itemActionViewLayout;
            if (r105 <= 0) goto L31;
            if (r102 == true) goto L31;
            r100.setActionView(r105);
        L31:
            ActionProvider r106 = this.itemActionProvider;
            if (r106 == null) goto L34;
            MenuItemCompat.setActionProvider(r100, r106);
        L34:
            MenuItemCompat.setContentDescription(r100, this.itemContentDescription);
            MenuItemCompat.setTooltipText(r100, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(r100, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(r100, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff.Mode r107 = this.itemIconTintMode;
            if (r107 == null) goto L37;
            MenuItemCompat.setIconTintMode(r100, r107);
        L37:
            ColorStateList r108 = this.itemIconTintList;
            if (r108 == null) goto L41;
            MenuItemCompat.setIconTintList(r100, r108);
            return;
        L41:
            return;
        L5:
            r103 = false;
            goto L6
        }

        public void readGroup(AttributeSet r100) {
            TypedArray r101 = this.this$0.mContext.obtainStyledAttributes(r100, new int[]{R.attr.enabled, R.attr.id, R.attr.visible, R.attr.menuCategory, R.attr.orderInCategory, R.attr.checkableBehavior});
            this.groupId = r101.getResourceId(1, 0);
            this.groupCategory = r101.getInt(3, 0);
            this.groupOrder = r101.getInt(4, 0);
            this.groupCheckable = r101.getInt(5, 0);
            this.groupVisible = r101.getBoolean(2, true);
            this.groupEnabled = r101.getBoolean(0, true);
            r101.recycle();
        }

        public void readItem(AttributeSet r100) {
            TintTypedArray r101 = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, r100, new int[]{R.attr.icon, R.attr.enabled, R.attr.id, R.attr.checked, R.attr.visible, R.attr.menuCategory, R.attr.orderInCategory, R.attr.title, R.attr.titleCondensed, R.attr.alphabeticShortcut, R.attr.numericShortcut, R.attr.checkable, R.attr.onClick, com.larus.nova.R.attr.actionLayout, com.larus.nova.R.attr.actionProviderClass, com.larus.nova.R.attr.actionViewClass, com.larus.nova.R.attr.alphabeticModifiers, com.larus.nova.R.attr.contentDescription, com.larus.nova.R.attr.iconTint, com.larus.nova.R.attr.iconTintMode, com.larus.nova.R.attr.numericModifiers, com.larus.nova.R.attr.showAsAction, com.larus.nova.R.attr.tooltipText});
            this.itemId = r101.getResourceId(2, 0);
            int r102 = r101.getInt(5, this.groupCategory);
            this.itemCategoryOrder = (r102 & (-65536)) | (r101.getInt(6, this.groupOrder) & 65535);
            this.itemTitle = r101.getText(7);
            this.itemTitleCondensed = r101.getText(8);
            this.itemIconResId = r101.getResourceId(0, 0);
            this.itemAlphabeticShortcut = getShortcut(r101.getString(9));
            this.itemAlphabeticModifiers = r101.getInt(16, 4096);
            this.itemNumericShortcut = getShortcut(r101.getString(10));
            this.itemNumericModifiers = r101.getInt(20, 4096);
            if (r101.hasValue(11) == false) goto L5;
            this.itemCheckable = r101.getBoolean(11, false) ? 1 : 0;
        L6:
            this.itemChecked = r101.getBoolean(3, false);
            this.itemVisible = r101.getBoolean(4, this.groupVisible);
            boolean r103 = true;
            this.itemEnabled = r101.getBoolean(1, this.groupEnabled);
            this.itemShowAsAction = r101.getInt(21, -1);
            this.itemListenerMethodName = r101.getString(12);
            this.itemActionViewLayout = r101.getResourceId(13, 0);
            this.itemActionViewClassName = r101.getString(15);
            String r104 = r101.getString(14);
            this.itemActionProviderClassName = r104;
            if (r104 != null) goto L11;
            r103 = false;
        L11:
            if (r103 == true) goto L13;
        L17:
            this.itemActionProvider = null;
        L18:
            this.itemContentDescription = r101.getText(17);
            this.itemTooltipText = r101.getText(22);
            if (r101.hasValue(19) == false) goto L21;
            this.itemIconTintMode = DrawableUtils.parseTintMode(r101.getInt(19, -1), this.itemIconTintMode);
        L23:
            if (r101.hasValue(18) == false) goto L25;
            this.itemIconTintList = r101.getColorStateList(18);
        L26:
            r101.recycle();
            this.itemAdded = false;
            return;
        L25:
            this.itemIconTintList = null;
            goto L26
        L21:
            this.itemIconTintMode = null;
            goto L23
        L13:
            if (this.itemActionViewLayout != 0) goto L17;
            if (this.itemActionViewClassName != null) goto L17;
            this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
            goto L18
        L5:
            this.itemCheckable = this.groupCheckable;
            goto L6
        }

        public MenuState(SupportMenuInflater r100, Menu r101) {
            this.this$0 = r100;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = r101;
            resetGroup();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_appcompat_view_SupportMenuInflater$MenuState_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r105;
        L8:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r106;
        L17:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        private <T> T newInstance(String r100, Class<?>[] r101, Object[] r102) {
            Constructor<T> r103 = INVOKESTATIC_androidx_appcompat_view_SupportMenuInflater$MenuState_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, false, this.this$0.mContext.getClassLoader()).getConstructor(r101);     // Catch: Exception -> L4
            r103.setAccessible(true);     // Catch: Exception -> L4
            return r103.newInstance(r102);
        L5:
            return null;
        }
    }

    static {
        Class<?>[] r100 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r100;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r100;
    }

    public Object getRealOwner() {
        if (this.mRealOwner != null) goto L6;
        this.mRealOwner = findRealOwner(this.mContext);
    L6:
        return this.mRealOwner;
    }

    public SupportMenuInflater(Context r100) {
        super(r100);
        this.mContext = r100;
        Object[] r101 = {r100};
        this.mActionViewConstructorArguments = r101;
        this.mActionProviderConstructorArguments = r101;
    }

    private Object findRealOwner(Object r100) {
        if ((r100 instanceof Activity) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return r100;
    L8:
        return findRealOwner(((ContextWrapper) r100).getBaseContext());
    }

    @Override // android.view.MenuInflater
    public void inflate(int r100, Menu r101) {
        if ((r101 instanceof SupportMenu) == true) goto L6;
        super.inflate(r100, r101);
        return;
    L6:
        XmlResourceParser r102 = null;
        r102 = this.mContext.getResources().getLayout(r100);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        parseMenu(r102, Xml.asAttributeSet(r102), r101);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        if (r102 == null) goto L24;
        r102.close();
        return;
    L24:
        return;
    L11:
        th = move-exception;
        if (r102 == null) goto L21;
        r102.close();
    L21:
        throw th;
    L16:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }

    private void parseMenu(XmlPullParser r110, AttributeSet r111, Menu r112) throws XmlPullParserException, IOException {
        MenuState r100 = new MenuState(this, r112);
        int r113 = r110.getEventType();
    L4:
        if (r113 == 2) goto L5;
        r113 = r110.next();
        if (r113 != 1) goto L4;
    L12:
        String r101 = null;
        boolean r102 = false;
        boolean r103 = false;
    L13:
        if (r102 == true) goto L56;
        if (r113 == 1) goto L55;
        if (r113 != 2) goto L18;
        if (r103 == true) goto L53;
        String r114 = r110.getName();
        if (r114.equals("group") == false) goto L47;
        r100.readGroup(r111);
        goto L53
    L47:
        if (r114.equals("item") == false) goto L50;
        r100.readItem(r111);
        goto L53
    L50:
        if (r114.equals("menu") == false) goto L52;
        parseMenu(r110, r111, r100.addSubMenuItem());
        goto L53
    L52:
        r101 = r114;
        r103 = true;
    L53:
        r113 = r110.next();
        goto L13
    L18:
        if (r113 != 3) goto L53;
        String r115 = r110.getName();
        if (r103 == false) goto L26;
        if (r115.equals(r101) == false) goto L26;
        r101 = null;
        r103 = false;
    L26:
        if (r115.equals("group") == false) goto L29;
        r100.resetGroup();
        goto L53
    L29:
        if (r115.equals("item") == false) goto L39;
        if (r100.hasAddedItem() == true) goto L53;
        ActionProvider r116 = r100.itemActionProvider;
        if (r116 != null) goto L35;
    L37:
        r100.addItem();
        goto L53
    L35:
        if (r116.hasSubMenu() == false) goto L37;
        r100.addSubMenuItem();
        goto L53
    L39:
        if (r115.equals("menu") == false) goto L53;
        r102 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r117 = r110.getName();
        if (r117.equals("menu") == false) goto L9;
        r113 = r110.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got ".concat(r117));
    }
}
