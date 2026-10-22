package g;

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
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.r;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.bytedanceos.common.toolbox.ServerElements;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class c extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class[] f19735e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f19736f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f19737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f19738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f19739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f19740d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class[] f19741c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f19743b;

        static {
            f19741c = new Class[]{MenuItem.class};
        }

        public a(Object r10, String r11) {
            this.f19742a = r10;
            Class<?> r12 = r10.getClass();
            this.f19743b = r12.getMethod(r11, f19741c);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            InflateException r13 = new InflateException("Couldn't resolve menu item onClick handler " + r11 + " in class " + r12.getName());
            r13.initCause(e);
            throw r13;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r10) {
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        L3:
            if (this.f19743b.getReturnType() == Boolean.TYPE) goto L5;
            this.f19743b.invoke(this.f19742a, new Object[]{r10});     // Catch: Exception -> L6
            return true;
        L5:
            return ((Boolean) this.f19743b.invoke(this.f19742a, new Object[]{r10})).booleanValue();
        }
    }

    public class b {
        public ActionProvider A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D;
        public PorterDuff.Mode E;
        public final /* synthetic */ c F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f19744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19751h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19752i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19753j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f19754k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f19755l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19756m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f19757n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f19758o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f19759p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f19760q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f19761r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f19762s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f19763t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f19764u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f19765v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f19766w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f19767x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f19768y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f19769z;

        public b(c r10, Menu r11) {
            this.F = r10;
            this.D = null;
            this.E = null;
            this.f19744a = r11;
            h();
        }

        public void a() {
            this.f19751h = true;
            i(this.f19744a.add(this.f19745b, this.f19752i, this.f19753j, this.f19754k));
        }

        public SubMenu b() {
            this.f19751h = true;
            SubMenu r10 = this.f19744a.addSubMenu(this.f19745b, this.f19752i, this.f19753j, this.f19754k);
            i(r10.getItem());
            return r10;
        }

        public final char c(String r10) {
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.charAt(0);
        }

        public boolean d() {
            return this.f19751h;
        }

        public final Object e(String r10, Class[] r11, Object[] r12) {
            Constructor<?> r13 = Class.forName(r10, false, this.F.f19739c.getClassLoader()).getConstructor(r11);     // Catch: Exception -> L4
            r13.setAccessible(true);     // Catch: Exception -> L4
            return r13.newInstance(r12);
        L4:
            e = move-exception;
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + r10, e);
            return null;
        }

        public void f(AttributeSet r10) {
            TypedArray r11 = this.F.f19739c.obtainStyledAttributes(r10, R$styleable.MenuGroup);
            this.f19745b = r11.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f19746c = r11.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f19747d = r11.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f19748e = r11.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f19749f = r11.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f19750g = r11.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            r11.recycle();
        }

        public void g(AttributeSet r10) {
            b0 r11 = b0.u(this.F.f19739c, r10, R$styleable.MenuItem);
            this.f19752i = r11.n(R$styleable.MenuItem_android_id, 0);
            this.f19753j = (r11.k(R$styleable.MenuItem_android_menuCategory, this.f19746c) & (-65536)) | (r11.k(R$styleable.MenuItem_android_orderInCategory, this.f19747d) & SupportMenu.USER_MASK);
            this.f19754k = r11.p(R$styleable.MenuItem_android_title);
            this.f19755l = r11.p(R$styleable.MenuItem_android_titleCondensed);
            this.f19756m = r11.n(R$styleable.MenuItem_android_icon, 0);
            this.f19757n = c(r11.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f19758o = r11.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f19759p = c(r11.o(R$styleable.MenuItem_android_numericShortcut));
            this.f19760q = r11.k(R$styleable.MenuItem_numericModifiers, 4096);
            int r12 = R$styleable.MenuItem_android_checkable;
            if (r11.s(r12) == false) goto L5;
            this.f19761r = r11.a(r12, false) ? 1 : 0;
        L6:
            this.f19762s = r11.a(R$styleable.MenuItem_android_checked, false);
            this.f19763t = r11.a(R$styleable.MenuItem_android_visible, this.f19749f);
            this.f19764u = r11.a(R$styleable.MenuItem_android_enabled, this.f19750g);
            this.f19765v = r11.k(R$styleable.MenuItem_showAsAction, -1);
            this.f19769z = r11.o(R$styleable.MenuItem_android_onClick);
            this.f19766w = r11.n(R$styleable.MenuItem_actionLayout, 0);
            this.f19767x = r11.o(R$styleable.MenuItem_actionViewClass);
            String r13 = r11.o(R$styleable.MenuItem_actionProviderClass);
            this.f19768y = r13;
            if (r13 == null) goto L9;
            boolean r14 = true;
        L11:
            if (r14 == true) goto L13;
        L17:
            if (r14 == false) goto L19;
            Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        L19:
            this.A = null;
        L20:
            this.B = r11.p(R$styleable.MenuItem_contentDescription);
            this.C = r11.p(R$styleable.MenuItem_tooltipText);
            int r15 = R$styleable.MenuItem_iconTintMode;
            if (r11.s(r15) == false) goto L23;
            this.E = r.e(r11.k(r15, -1), this.E);
        L24:
            int r16 = R$styleable.MenuItem_iconTint;
            if (r11.s(r16) == false) goto L27;
            this.D = r11.c(r16);
        L28:
            r11.w();
            this.f19751h = false;
            return;
        L27:
            this.D = null;
            goto L28
        L23:
            this.E = null;
            goto L24
        L13:
            if (this.f19766w != 0) goto L17;
            if (this.f19767x != null) goto L17;
            this.A = (ActionProvider) e(r13, c.f19736f, this.F.f19738b);
            goto L20
        L9:
            r14 = false;
            goto L11
        L5:
            this.f19761r = this.f19748e;
            goto L6
        }

        public void h() {
            this.f19745b = 0;
            this.f19746c = 0;
            this.f19747d = 0;
            this.f19748e = 0;
            this.f19749f = true;
            this.f19750g = true;
        }

        public final void i(MenuItem r10) {
            MenuItem r11 = r10.setChecked(this.f19762s).setVisible(this.f19763t).setEnabled(this.f19764u);
            boolean r12 = false;
            if (this.f19761r < 1) goto L5;
            boolean r13 = true;
        L6:
            r11.setCheckable(r13).setTitleCondensed(this.f19755l).setIcon(this.f19756m);
            int r14 = this.f19765v;
            if (r14 < 0) goto L10;
            r10.setShowAsAction(r14);
        L10:
            if (this.f19769z == null) goto L17;
            if (this.F.f19739c.isRestricted() == true) goto L15;
            r10.setOnMenuItemClickListener(new a(this.F.getRealOwner(), this.f19769z));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.f19761r >= 2) goto L19;
        L24:
            String r15 = this.f19767x;
            if (r15 == null) goto L27;
            r10.setActionView((View) e(r15, c.f19735e, this.F.f19737a));
            r12 = true;
        L27:
            int r16 = this.f19766w;
            if (r16 <= 0) goto L32;
            if (r12 == true) goto L31;
            r10.setActionView(r16);
            goto L32
        L31:
            Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L32:
            ActionProvider r17 = this.A;
            if (r17 == null) goto L35;
            MenuItemCompat.a(r10, r17);
        L35:
            MenuItemCompat.c(r10, this.B);
            MenuItemCompat.g(r10, this.C);
            MenuItemCompat.b(r10, this.f19757n, this.f19758o);
            MenuItemCompat.f(r10, this.f19759p, this.f19760q);
            PorterDuff.Mode r18 = this.E;
            if (r18 == null) goto L38;
            MenuItemCompat.e(r10, r18);
        L38:
            ColorStateList r19 = this.D;
            if (r19 == null) goto L42;
            MenuItemCompat.d(r10, r19);
            return;
        L42:
            return;
        L19:
            if ((r10 instanceof g) == false) goto L22;
            ((g) r10).q(true);
            goto L24
        L22:
            if ((r10 instanceof h) == false) goto L24;
            ((h) r10).f(true);
            goto L24
        L5:
            r13 = false;
            goto L6
        }
    }

    static {
        Class[] r10 = {Context.class};
        f19735e = r10;
        f19736f = r10;
    }

    public c(Context r10) {
        super(r10);
        this.f19739c = r10;
        Object[] r11 = {r10};
        this.f19737a = r11;
        this.f19738b = r11;
    }

    public final Object findRealOwner(Object r10) {
        if ((r10 instanceof Activity) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ContextWrapper) == true) goto L8;
        return r10;
    L8:
        return findRealOwner(((ContextWrapper) r10).getBaseContext());
    }

    public Object getRealOwner() {
        if (this.f19740d != null) goto L6;
        this.f19740d = findRealOwner(this.f19739c);
    L6:
        return this.f19740d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int r10, Menu r11) {
        if ((r11 instanceof SupportMenu) == true) goto L6;
        super.inflate(r10, r11);
        return;
    L6:
        XmlResourceParser r12 = null;
        r12 = this.f19739c.getResources().getLayout(r10);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L15
        parseMenu(r12, Xml.asAttributeSet(r12), r11);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L15
        if (r12 == null) goto L26;
        r12.close();
        return;
    L26:
        return;
    L11:
        th = move-exception;
        if (r12 == null) goto L23;
        r12.close();
    L23:
        throw th;
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }

    public final void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) {
        b r10 = new b(this, r15);
        int r16 = r13.getEventType();
    L4:
        if (r16 == 2) goto L5;
        r16 = r13.next();
        if (r16 != 1) goto L4;
    L12:
        boolean r11 = false;
        boolean r12 = false;
        String r17 = null;
    L13:
        if (r11 == true) goto L56;
        if (r16 == 1) goto L55;
        if (r16 != 2) goto L18;
        if (r12 == true) goto L53;
        String r18 = r13.getName();
        if (r18.equals(ServerElements.GROUP) == false) goto L47;
        r10.f(r14);
        goto L53
    L47:
        if (r18.equals("item") == false) goto L50;
        r10.g(r14);
        goto L53
    L50:
        if (r18.equals("menu") == false) goto L52;
        parseMenu(r13, r14, r10.b());
        goto L53
    L52:
        r17 = r18;
        r12 = true;
    L53:
        r16 = r13.next();
        goto L13
    L18:
        if (r16 != 3) goto L53;
        String r19 = r13.getName();
        if (r12 == false) goto L26;
        if (r19.equals(r17) == false) goto L26;
        r12 = false;
        r17 = null;
    L26:
        if (r19.equals(ServerElements.GROUP) == false) goto L29;
        r10.h();
        goto L53
    L29:
        if (r19.equals("item") == false) goto L39;
        if (r10.d() == true) goto L53;
        ActionProvider r110 = r10.A;
        if (r110 != null) goto L35;
    L37:
        r10.a();
        goto L53
    L35:
        if (r110.a() == false) goto L37;
        r10.b();
        goto L53
    L39:
        if (r19.equals("menu") == false) goto L53;
        r11 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r111 = r13.getName();
        if (r111.equals("menu") == false) goto L9;
        r16 = r13.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got " + r111);
    }
}
