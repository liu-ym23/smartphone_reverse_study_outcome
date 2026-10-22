package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.y;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.i;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
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

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object r4, String r5) {
            this.mRealOwner = r4;
            Class<?> r6 = r4.getClass();
            this.mMethod = r6.getMethod(r5, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            InflateException r0 = new InflateException("Couldn't resolve menu item onClick handler " + r5 + " in class " + r6.getName());
            r0.initCause(e);
            throw r0;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r6) {
            MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.aiagent.plugin");
        L9:
            e = move-exception;
            throw new RuntimeException(e);
        L4:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L6;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r7});     // Catch: Exception -> L9
            return true;
        L6:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.mMethod.invoke(this.mRealOwner, new Object[]{r7}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }
    }

    private class a {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E;
        private PorterDuff.Mode F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.core.view.a f295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SupportMenuInflater f296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Menu f297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f299e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public a(SupportMenuInflater r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            this.f296b = r3;
            this.E = null;
            this.F = null;
            this.f297c = r5;
            a();
        }

        public void a() {
            this.f298d = 0;
            this.f299e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet r5) {
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
            TypedArray r7 = this.f296b.mContext.obtainStyledAttributes(r6, R.styleable.MenuGroup);
            this.f298d = r7.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_id, "styleable", "MenuGroup_android_id"), 0);
            this.f299e = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_menuCategory, "styleable", "MenuGroup_android_menuCategory"), 0);
            this.f = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_orderInCategory, "styleable", "MenuGroup_android_orderInCategory"), 0);
            this.g = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_checkableBehavior, "styleable", "MenuGroup_android_checkableBehavior"), 0);
            this.h = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_visible, "styleable", "MenuGroup_android_visible"), true);
            this.i = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_enabled, "styleable", "MenuGroup_android_enabled"), true);
            r7.recycle();
        }

        public void b(AttributeSet r9) {
            y r10 = y.a(this.f296b.mContext, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.MenuItem);
            this.k = r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_id, "styleable", "MenuItem_android_id"), 0);
            this.l = (r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_menuCategory, "styleable", "MenuItem_android_menuCategory"), this.f299e) & (-65536)) | (r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_orderInCategory, "styleable", "MenuItem_android_orderInCategory"), this.f) & SupportMenu.USER_MASK);
            this.m = r10.c(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_title, "styleable", "MenuItem_android_title"));
            this.n = r10.c(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_titleCondensed, "styleable", "MenuItem_android_titleCondensed"));
            this.o = r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_icon, "styleable", "MenuItem_android_icon"), 0);
            this.p = a(r10.d(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_alphabeticShortcut, "styleable", "MenuItem_android_alphabeticShortcut")));
            this.q = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_alphabeticModifiers, "styleable", "MenuItem_alphabeticModifiers"), 4096);
            this.r = a(r10.d(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_numericShortcut, "styleable", "MenuItem_android_numericShortcut")));
            this.s = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_numericModifiers, "styleable", "MenuItem_numericModifiers"), 4096);
            if (r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_checkable, "styleable", "MenuItem_android_checkable")) == false) goto L5;
            this.t = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_checkable, "styleable", "MenuItem_android_checkable"), false) ? 1 : 0;
        L6:
            this.u = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_checked, "styleable", "MenuItem_android_checked"), false);
            this.v = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_visible, "styleable", "MenuItem_android_visible"), this.h);
            this.w = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_enabled, "styleable", "MenuItem_android_enabled"), this.i);
            this.x = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_showAsAction, "styleable", "MenuItem_showAsAction"), -1);
            this.B = r10.d(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_onClick, "styleable", "MenuItem_android_onClick"));
            this.y = r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuItem_actionLayout, "styleable", "MenuItem_actionLayout"), 0);
            this.z = r10.d(ZeusTransformUtils.mapRes(R.styleable.MenuItem_actionViewClass, "styleable", "MenuItem_actionViewClass"));
            String r0 = r10.d(ZeusTransformUtils.mapRes(R.styleable.MenuItem_actionProviderClass, "styleable", "MenuItem_actionProviderClass"));
            this.A = r0;
            if (r0 == null) goto L9;
            boolean r5 = true;
        L11:
            if (r5 == true) goto L13;
        L17:
            if (r5 == false) goto L19;
            a(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        L19:
            this.f295a = null;
        L20:
            this.C = r10.c(ZeusTransformUtils.mapRes(R.styleable.MenuItem_contentDescription, "styleable", "MenuItem_contentDescription"));
            this.D = r10.c(ZeusTransformUtils.mapRes(R.styleable.MenuItem_tooltipText, "styleable", "MenuItem_tooltipText"));
            if (r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTintMode, "styleable", "MenuItem_iconTintMode")) == false) goto L23;
            this.F = q.a(r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTintMode, "styleable", "MenuItem_iconTintMode"), -1), this.F);
        L25:
            if (r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTint, "styleable", "MenuItem_iconTint")) == false) goto L27;
            this.E = r10.e(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTint, "styleable", "MenuItem_iconTint"));
        L28:
            r10.b();
            this.j = false;
            return;
        L27:
            this.E = null;
            goto L28
        L23:
            this.F = null;
            goto L25
        L13:
            if (this.y != 0) goto L17;
            if (this.z != null) goto L17;
            this.f295a = (androidx.core.view.a) ZeusTransformUtils.preCheckCast(a(r0, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.f296b.mActionProviderConstructorArguments), androidx.core.view.a.class, "com.obric.aiagent.plugin");
            goto L20
        L9:
            r5 = false;
            goto L11
        L5:
            this.t = this.g;
            goto L6
        }

        private char a(String r1) {
            if (r1 != null) goto L6;
            return 0;
        L6:
            return r1.charAt(0);
        }

        private void a(MenuItem r7) {
            MenuItem r8 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r7, MenuItem.class, "com.obric.aiagent.plugin");
            MenuItem r0 = r8.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
            boolean r3 = false;
            if (this.t < 1) goto L5;
            boolean r2 = true;
        L6:
            r0.setCheckable(r2).setTitleCondensed(this.n).setIcon(this.o);
            int r1 = this.x;
            if (r1 < 0) goto L10;
            r8.setShowAsAction(r1);
        L10:
            if (this.B == null) goto L17;
            if (this.f296b.mContext.isRestricted() == true) goto L15;
            r8.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.f296b.getRealOwner(), this.B));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.t >= 2) goto L19;
        L24:
            String r4 = this.z;
            if (r4 == null) goto L27;
            r8.setActionView((View) ZeusTransformUtils.preCheckCast(a(r4, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.f296b.mActionViewConstructorArguments), View.class, "com.obric.aiagent.plugin"));
            r3 = true;
        L27:
            int r5 = this.y;
            if (r5 <= 0) goto L32;
            if (r3 == true) goto L31;
            r8.setActionView(r5);
            goto L32
        L31:
            a(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L32:
            androidx.core.view.a r6 = this.f295a;
            if (r6 == null) goto L35;
            i.a(r8, r6);
        L35:
            i.a(r8, this.C);
            i.b(r8, this.D);
            i.b(r8, this.p, this.q);
            i.a(r8, this.r, this.s);
            PorterDuff.Mode r9 = this.F;
            if (r9 == null) goto L38;
            i.a(r8, r9);
        L38:
            ColorStateList r10 = this.E;
            if (r10 == null) goto L42;
            i.a(r8, r10);
            return;
        L42:
            return;
        L19:
            if (ZeusTransformUtils.instanceOf(r8, MenuItemImpl.class) == false) goto L22;
            ((MenuItemImpl) ZeusTransformUtils.preCheckCast(r8, MenuItemImpl.class, "com.obric.aiagent.plugin")).setExclusiveCheckable(true);
            goto L24
        L22:
            if (ZeusTransformUtils.instanceOf(r8, MenuItemWrapperICS.class) == false) goto L24;
            ((MenuItemWrapperICS) ZeusTransformUtils.preCheckCast(r8, MenuItemWrapperICS.class, "com.obric.aiagent.plugin")).setExclusiveCheckable(true);
            goto L24
        L5:
            r2 = false;
            goto L6
        }

        public void b() {
            this.j = true;
            a(this.f297c.add(this.f298d, this.k, this.l, this.m));
        }

        public SubMenu c() {
            this.j = true;
            SubMenu r0 = this.f297c.addSubMenu(this.f298d, this.k, this.l, this.m);
            a(r0.getItem());
            return r0;
        }

        public boolean d() {
            return this.j;
        }

        private <T> T a(String r2, Class<?>[] r3, Object[] r4) {
            Constructor<?> r1 = Class.forName(r2, false, this.f296b.mContext.getClassLoader()).getConstructor(r3);     // Catch: Exception -> L5
            r1.setAccessible(true);     // Catch: Exception -> L5
            return (T) r1.newInstance(r4);
        L5:
            e = move-exception;
            a(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + r2, e);
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }
    }

    static {
        Class<?>[] r0 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r0;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r0;
    }

    public SupportMenuInflater(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        Object[] r0 = {r4};
        this.mActionViewConstructorArguments = r0;
        this.mActionProviderConstructorArguments = r0;
    }

    @Override // android.view.MenuInflater
    public void inflate(int r5, Menu r6) {
        Menu r7 = (Menu) ZeusTransformUtils.wrapperContextForParams(r6, Menu.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, SupportMenu.class) == true) goto L6;
        super.inflate(r5, r7);
        return;
    L6:
        XmlResourceParser r1 = null;
        r1 = ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getLayout(r5);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        parseMenu(r1, Xml.asAttributeSet(r1), r7);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        if (r1 == null) goto L24;
        r1.close();
        return;
    L24:
        return;
    L11:
        th = move-exception;
        if (r1 == null) goto L21;
        r1.close();
    L21:
        throw th;
    L16:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }

    private void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) {
        XmlPullParser r16 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        a r0 = new a(this, (Menu) ZeusTransformUtils.wrapperContextForParams(r15, Menu.class, "com.obric.aiagent.plugin"));
        int r18 = r16.getEventType();
    L4:
        if (r18 == 2) goto L5;
        r18 = r16.next();
        if (r18 != 1) goto L4;
    L12:
        String r8 = null;
        boolean r6 = false;
        boolean r7 = false;
    L13:
        if (r6 == true) goto L56;
        if (r18 == 1) goto L55;
        if (r18 != 2) goto L18;
        if (r7 == true) goto L53;
        String r19 = r16.getName();
        if (r19.equals(XML_GROUP) == false) goto L47;
        r0.a(r17);
        goto L53
    L47:
        if (r19.equals(XML_ITEM) == false) goto L50;
        r0.b(r17);
        goto L53
    L50:
        if (r19.equals(XML_MENU) == false) goto L52;
        parseMenu(r16, r17, r0.c());
        goto L53
    L52:
        r8 = r19;
        r7 = true;
    L53:
        r18 = r16.next();
        goto L13
    L18:
        if (r18 != 3) goto L53;
        String r110 = r16.getName();
        if (r7 == false) goto L26;
        if (r110.equals(r8) == false) goto L26;
        r8 = null;
        r7 = false;
    L26:
        if (r110.equals(XML_GROUP) == false) goto L29;
        r0.a();
        goto L53
    L29:
        if (r110.equals(XML_ITEM) == false) goto L39;
        if (r0.d() == true) goto L53;
        if (r0.f295a != null) goto L35;
    L37:
        r0.b();
        goto L53
    L35:
        if (r0.f295a.hasSubMenu() == false) goto L37;
        r0.c();
        goto L53
    L39:
        if (r110.equals(XML_MENU) == false) goto L53;
        r6 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r111 = r16.getName();
        if (r111.equals(XML_MENU) == false) goto L9;
        r18 = r16.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got " + r111);
    }

    Object getRealOwner() {
        if (this.mRealOwner != null) goto L6;
        this.mRealOwner = findRealOwner(this.mContext);
    L6:
        return this.mRealOwner;
    }

    private Object findRealOwner(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L6;
        return r3;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == true) goto L8;
        return r3;
    L8:
        return findRealOwner((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }
}
