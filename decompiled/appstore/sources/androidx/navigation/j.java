package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import com.bytedance.apm.constant.CommonKey;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f3866c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f3867d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f3869b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final n a(TypedValue r10, n r11, n r12, String r13, String r14) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            kotlin.jvm.internal.q.g(r12, "expectedNavType");
            kotlin.jvm.internal.q.g(r14, "foundType");
            if (r11 == null) goto L8;
            if (r11 == r12) goto L8;
            throw new XmlPullParserException("Type is " + r13 + " but found " + r14 + ": " + r10.data);
        L8:
            if (r11 == null) goto L10;
            return r11;
        L10:
            return r12;
        }

        public a() {
        }
    }

    static {
        f3866c = new a(null);
        f3867d = new ThreadLocal();
    }

    public j(Context r10, o r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "navigatorProvider");
        this.f3868a = r10;
        this.f3869b = r11;
    }

    public final NavDestination a(Resources r10, XmlResourceParser r11, AttributeSet r12, int r13) {
        o r14 = this.f3869b;
        String r15 = r11.getName();
        kotlin.jvm.internal.q.f(r15, "parser.name");
        NavDestination r16 = r14.d(r15).a();
        r16.n(this.f3868a, r12);
        int r17 = r11.getDepth() + 1;
    L3:
        int r18 = r11.next();
        if (r18 == 1) goto L31;
        int r19 = r11.getDepth();
        if (r19 >= r17) goto L10;
        if (r18 == 3) goto L31;
    L10:
        if (r18 != 2) goto L3;
        if (r19 > r17) goto L3;
        String r20 = r11.getName();
        if (kotlin.jvm.internal.q.b("argument", r20) == true) goto L16;
        if (kotlin.jvm.internal.q.b("deepLink", r20) == true) goto L19;
        if (kotlin.jvm.internal.q.b("action", r20) == true) goto L22;
        if (kotlin.jvm.internal.q.b("include", r20) == false) goto L29;
        if ((r16 instanceof NavGraph) == false) goto L29;
        TypedArray r21 = r10.obtainAttributes(r12, R$styleable.NavInclude);
        kotlin.jvm.internal.q.f(r21, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
        ((NavGraph) r16).t(b(r21.getResourceId(R$styleable.NavInclude_graph, 0)));
        Unit r22 = Unit.f21064a;
        r21.recycle();
    L29:
        if ((r16 instanceof NavGraph) == false) goto L3;
        ((NavGraph) r16).t(a(r10, r11, r12, r13));
        goto L3
    L22:
        c(r10, r16, r12, r11, r13);
        goto L3
    L19:
        g(r10, r16, r12);
        goto L3
    L16:
        f(r10, r16, r12, r13);
    L31:
        return r16;
    }

    public final NavGraph b(int r10) {
        Resources r11 = this.f3868a.getResources();
        XmlResourceParser r12 = r11.getXml(r10);
        kotlin.jvm.internal.q.f(r12, "res.getXml(graphResId)");
        AttributeSet r13 = Xml.asAttributeSet(r12);
    L25:
        int r14 = r12.next();     // Catch: Throwable -> L13 Exception -> L15
        if (r14 == 2) goto L7;
        if (r14 != 1) goto L25;
    L7:
        if (r14 != 2) goto L20;
        String r15 = r12.getName();     // Catch: Throwable -> L13 Exception -> L15
        kotlin.jvm.internal.q.f(r11, "res");     // Catch: Throwable -> L13 Exception -> L15
        kotlin.jvm.internal.q.f(r13, "attrs");     // Catch: Throwable -> L13 Exception -> L15
        NavDestination r16 = a(r11, r12, r13, r10);     // Catch: Throwable -> L13 Exception -> L15
        if ((r16 instanceof NavGraph) == false) goto L18;
        NavGraph r17 = (NavGraph) r16;     // Catch: Throwable -> L13 Exception -> L15
        r12.close();
        return r17;
    L18:
        throw new IllegalArgumentException(("Root element <" + r15 + "> did not inflate into a NavGraph").toString());     // Catch: Throwable -> L13 Exception -> L15
    L20:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L13 Exception -> L15
    L15:
        e = move-exception;
        throw new RuntimeException("Exception inflating " + r11.getResourceName(r10) + " line " + r12.getLineNumber(), e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r12.close();
        throw th;
    }

    public final void c(Resources r11, NavDestination r12, AttributeSet r13, XmlResourceParser r14, int r15) {
        Context r10 = this.f3868a;
        int[] r16 = androidx.navigation.common.R$styleable.NavAction;
        kotlin.jvm.internal.q.f(r16, "NavAction");
        TypedArray r17 = r10.obtainStyledAttributes(r13, r16, 0, 0);
        int r18 = r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_android_id, 0);
        b r19 = new b(r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_destination, 0), null, null, 6, null);
        k.a r20 = new k.a();
        r20.d(r17.getBoolean(androidx.navigation.common.R$styleable.NavAction_launchSingleTop, false));
        r20.j(r17.getBoolean(androidx.navigation.common.R$styleable.NavAction_restoreState, false));
        r20.g(r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_popUpTo, -1), r17.getBoolean(androidx.navigation.common.R$styleable.NavAction_popUpToInclusive, false), r17.getBoolean(androidx.navigation.common.R$styleable.NavAction_popUpToSaveState, false));
        r20.b(r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_enterAnim, -1));
        r20.c(r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_exitAnim, -1));
        r20.e(r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_popEnterAnim, -1));
        r20.f(r17.getResourceId(androidx.navigation.common.R$styleable.NavAction_popExitAnim, -1));
        r19.e(r20.a());
        Bundle r21 = new Bundle();
        int r22 = r14.getDepth() + 1;
    L3:
        int r23 = r14.next();
        if (r23 == 1) goto L18;
        int r24 = r14.getDepth();
        if (r24 >= r22) goto L10;
        if (r23 == 3) goto L18;
    L10:
        if (r23 != 2) goto L3;
        if (r24 > r22) goto L3;
        if (kotlin.jvm.internal.q.b("argument", r14.getName()) == false) goto L3;
        e(r11, r21, r13, r15);
    L18:
        if (r21.isEmpty() == true) goto L20;
        r19.d(r21);
    L20:
        r12.o(r18, r19);
        r17.recycle();
    }

    public final c d(TypedArray r10, Resources r11, int r12) {
        c.a r13 = new c.a();
        boolean r14 = false;
        int r15 = 0;
        r13.c(r10.getBoolean(androidx.navigation.common.R$styleable.NavArgument_nullable, false));
        ThreadLocal r16 = f3867d;
        TypedValue r17 = (TypedValue) r16.get();
        if (r17 != null) goto L5;
        r17 = new TypedValue();
        r16.set(r17);
    L5:
        String r18 = r10.getString(androidx.navigation.common.R$styleable.NavArgument_argType);
        Object r19 = null;
        if (r18 == null) goto L8;
        n r20 = n.f3897c.a(r18, r11.getResourcePackageName(r12));
    L9:
        int r110 = androidx.navigation.common.R$styleable.NavArgument_android_defaultValue;
        if (r10.getValue(r110, r17) == false) goto L59;
        n r21 = n.f3899e;
        if (r20 != r21) goto L23;
        int r111 = r17.resourceId;
        if (r111 == 0) goto L17;
        r15 = r111;
    L20:
        r19 = Integer.valueOf(r15);
        goto L59
    L17:
        if (r17.type != 16) goto L22;
        if (r17.data == 0) goto L20;
    L22:
        throw new XmlPullParserException("unsupported value '" + r17.string + "' for " + r20.b() + ". Must be a reference to a resource.");
    L23:
        int r22 = r17.resourceId;
        if (r22 == 0) goto L30;
        if (r20 != null) goto L28;
        r20 = r21;
        r19 = Integer.valueOf(r22);
        goto L59
    L28:
        throw new XmlPullParserException("unsupported value '" + r17.string + "' for " + r20.b() + ". You must use a \"" + r21.b() + "\" type to reference other resources.");
    L30:
        if (r20 != n.f3907m) goto L32;
        r19 = r10.getString(r110);
        goto L59
    L32:
        int r112 = r17.type;
        if (r112 != 3) goto L35;
        String r113 = r17.string.toString();
        if (r20 != null) goto L58;
        r20 = n.f3897c.b(r113);
    L58:
        r19 = r20.e(r113);
        goto L59
    L35:
        if (r112 != 4) goto L37;
        r20 = f3866c.a(r17, r20, n.f3903i, r18, "float");
        r19 = Float.valueOf(r17.getFloat());
        goto L59
    L37:
        if (r112 != 5) goto L39;
        r20 = f3866c.a(r17, r20, n.f3898d, r18, "dimension");
        r19 = Integer.valueOf((int) r17.getDimension(r11.getDisplayMetrics()));
        goto L59
    L39:
        if (r112 == 18) goto L49;
        if (r112 < 16) goto L48;
        if (r112 > 31) goto L48;
        n r23 = n.f3903i;
        if (r20 != r23) goto L46;
        r20 = f3866c.a(r17, r20, r23, r18, "float");
        r19 = Float.valueOf(r17.data);
        goto L59
    L46:
        r20 = f3866c.a(r17, r20, n.f3898d, r18, "integer");
        r19 = Integer.valueOf(r17.data);
    L48:
        throw new XmlPullParserException("unsupported argument type " + r17.type);
    L49:
        r20 = f3866c.a(r17, r20, n.f3905k, r18, "boolean");
        if (r17.data == 0) goto L52;
        r14 = true;
    L52:
        r19 = Boolean.valueOf(r14);
    L59:
        if (r19 == null) goto L61;
        r13.b(r19);
    L61:
        if (r20 == null) goto L64;
        r13.d(r20);
    L64:
        return r13.a();
    L8:
        r20 = null;
        goto L9
    }

    public final void e(Resources r10, Bundle r11, AttributeSet r12, int r13) {
        TypedArray r14 = r10.obtainAttributes(r12, androidx.navigation.common.R$styleable.NavArgument);
        kotlin.jvm.internal.q.f(r14, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String r15 = r14.getString(androidx.navigation.common.R$styleable.NavArgument_android_name);
        if (r15 == null) goto L10;
        kotlin.jvm.internal.q.f(r15, "array.getString(R.stylea…uments must have a name\")");
        c r16 = d(r14, r10, r13);
        if (r16.b() == false) goto L7;
        r16.d(r15, r11);
    L7:
        Unit r17 = Unit.f21064a;
        r14.recycle();
        return;
    L10:
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void f(Resources r10, NavDestination r11, AttributeSet r12, int r13) {
        TypedArray r14 = r10.obtainAttributes(r12, androidx.navigation.common.R$styleable.NavArgument);
        kotlin.jvm.internal.q.f(r14, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String r15 = r14.getString(androidx.navigation.common.R$styleable.NavArgument_android_name);
        if (r15 == null) goto L7;
        kotlin.jvm.internal.q.f(r15, "array.getString(R.stylea…uments must have a name\")");
        r11.a(r15, d(r14, r10, r13));
        Unit r16 = Unit.f21064a;
        r14.recycle();
        return;
    L7:
        throw new XmlPullParserException("Arguments must have a name");
    }

    public final void g(Resources r11, NavDestination r12, AttributeSet r13) {
        TypedArray r14 = r11.obtainAttributes(r13, androidx.navigation.common.R$styleable.NavDeepLink);
        kotlin.jvm.internal.q.f(r14, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String r10 = r14.getString(androidx.navigation.common.R$styleable.NavDeepLink_uri);
        String r15 = r14.getString(androidx.navigation.common.R$styleable.NavDeepLink_action);
        String r16 = r14.getString(androidx.navigation.common.R$styleable.NavDeepLink_mimeType);
        if (r10 != null) goto L5;
    L6:
        if (r15 != null) goto L8;
    L9:
        if (r16 == null) goto L25;
        if (r16.length() == 0) goto L25;
    L12:
        NavDeepLink.a r17 = new NavDeepLink.a();
        if (r10 == null) goto L15;
        String r18 = this.f3868a.getPackageName();
        kotlin.jvm.internal.q.f(r18, "context.packageName");
        r17.d(kotlin.text.o.x(r10, "${applicationId}", r18, false, 4, null));
    L15:
        if (r15 != null) goto L17;
    L20:
        if (r16 == null) goto L22;
        String r19 = this.f3868a.getPackageName();
        kotlin.jvm.internal.q.f(r19, "context.packageName");
        r17.c(kotlin.text.o.x(r16, "${applicationId}", r19, false, 4, null));
    L22:
        r12.b(r17.a());
        Unit r110 = Unit.f21064a;
        r14.recycle();
        return;
    L17:
        if (r15.length() == 0) goto L20;
        String r20 = this.f3868a.getPackageName();
        kotlin.jvm.internal.q.f(r20, "context.packageName");
        r17.b(kotlin.text.o.x(r15, "${applicationId}", r20, false, 4, null));
    L25:
        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
    L8:
        if (r15.length() != 0) goto L12;
    L5:
        if (r10.length() != 0) goto L12;
        goto L6
    }
}
