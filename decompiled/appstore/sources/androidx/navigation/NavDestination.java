package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.b0;
import kotlin.collections.k0;
import kotlin.collections.m0;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.y;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class NavDestination {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f3796j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f3797k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NavGraph f3799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f3801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.collection.e f3803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f3804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3806i;

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", CommonKey.KEY_VALUE, "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ClassType {
        Class<?> value();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(String r10) {
            if (r10 != null) goto L6;
            return "";
        L6:
            return "android-app://androidx.navigation/" + r10;
        }

        public final String b(Context r10, int r11) {
            kotlin.jvm.internal.q.g(r10, "context");
            if (r11 <= 16777215) goto L12;
            String r12 = r10.getResources().getResourceName(r11);     // Catch: Resources.NotFoundException -> L7
        L8:
            kotlin.jvm.internal.q.f(r12, "try {\n                co….toString()\n            }");
            return r12;
        L7:
            r12 = String.valueOf(r11);
            goto L8
        L12:
            return String.valueOf(r11);
        }

        public final Sequence c(NavDestination r10) {
            kotlin.jvm.internal.q.g(r10, "<this>");
            return SequencesKt__SequencesKt.f(r10, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        public Companion() {
        }
    }

    public static final class a implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavDestination f3807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f3808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f3810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f3811e;

        public a(NavDestination r10, Bundle r11, boolean r12, boolean r13, int r14) {
            kotlin.jvm.internal.q.g(r10, "destination");
            this.f3807a = r10;
            this.f3808b = r11;
            this.f3809c = r12;
            this.f3810d = r13;
            this.f3811e = r14;
        }

        public int a(a r10) {
            kotlin.jvm.internal.q.g(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
            boolean r11 = this.f3809c;
            if (r11 == false) goto L8;
            if (r10.f3809c == true) goto L8;
            return 1;
        L8:
            if (r11 == false) goto L10;
        L12:
            Bundle r12 = this.f3808b;
            if (r12 != null) goto L15;
        L17:
            if (r12 == null) goto L19;
        L21:
            if (r12 == null) goto L27;
            int r13 = r12.size();
            Bundle r14 = r10.f3808b;
            kotlin.jvm.internal.q.d(r14);
            int r15 = r13 - r14.size();
            if (r15 <= 0) goto L25;
            return 1;
        L25:
            if (r15 >= 0) goto L27;
            return -1;
        L27:
            boolean r16 = this.f3810d;
            if (r16 == true) goto L30;
        L32:
            if (r16 == true) goto L37;
            if (r10.f3810d == false) goto L37;
            return -1;
        L37:
            return this.f3811e - r10.f3811e;
        L30:
            if (r10.f3810d == true) goto L32;
            return 1;
        L19:
            if (r10.f3808b == null) goto L21;
            return -1;
        L15:
            if (r10.f3808b != null) goto L17;
            return 1;
        L10:
            if (r10.f3809c == false) goto L12;
            return -1;
        }

        public final NavDestination b() {
            return this.f3807a;
        }

        public final Bundle c() {
            return this.f3808b;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return a((a) r10);
        }
    }

    static {
        f3796j = new Companion(null);
        f3797k = new LinkedHashMap();
    }

    public NavDestination(String r10) {
        kotlin.jvm.internal.q.g(r10, "navigatorName");
        this.f3798a = r10;
        this.f3802e = new ArrayList();
        this.f3803f = new androidx.collection.e();
        this.f3804g = new LinkedHashMap();
    }

    public static /* synthetic */ int[] f(NavDestination r10, NavDestination r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L7;
        r11 = null;
    L7:
        return r10.e(r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    public final void a(String r10, c r11) {
        kotlin.jvm.internal.q.g(r10, "argumentName");
        kotlin.jvm.internal.q.g(r11, "argument");
        this.f3804g.put(r10, r11);
    }

    public final void b(NavDeepLink r10) {
        kotlin.jvm.internal.q.g(r10, "navDeepLink");
        Map r11 = g();
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        c r15 = (c) r14.getValue();
        if (r15.c() == true) goto L4;
        if (r15.b() == true) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L10:
        Set r16 = r12.keySet();
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L12:
        if (r18.hasNext() == false) goto L17;
        Object r19 = r18.next();
        if (r10.e().contains((String) r19) == true) goto L12;
        r17.add(r19);
        goto L12
    L17:
        if (r17.isEmpty() == false) goto L21;
        this.f3802e.add(r10);
        return;
    L21:
        throw new IllegalArgumentException(("Deep link " + r10.k() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + r17).toString());
    }

    public final void c(String r10) {
        kotlin.jvm.internal.q.g(r10, "uriPattern");
        b(new NavDeepLink.a().d(r10).a());
    }

    public final Bundle d(Bundle r10) {
        if (r10 != null) goto L9;
        Map r11 = this.f3804g;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.isEmpty() == false) goto L9;
        return null;
    L9:
        Bundle r12 = new Bundle();
        Iterator r13 = this.f3804g.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        Map.Entry r14 = (Map.Entry) r13.next();
        ((c) r14.getValue()).d((String) r14.getKey(), r12);
        goto L11
    L13:
        if (r10 == null) goto L22;
        r12.putAll(r10);
        Iterator r15 = this.f3804g.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L22;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        c r18 = (c) r16.getValue();
        if (r18.e(r17, r12) == true) goto L16;
        throw new IllegalArgumentException(("Wrong argument type for '" + r17 + "' in argument bundle. " + r18.a().b() + " expected.").toString());
    L22:
        return r12;
    }

    public final int[] e(NavDestination r10) {
        kotlin.collections.i r11 = new kotlin.collections.i();
    L3:
        kotlin.jvm.internal.q.d(this);
        NavGraph r12 = this.f3799b;
        if (r10 == null) goto L6;
        NavGraph r13 = r10.f3799b;
    L7:
        if (r13 == null) goto L11;
        NavGraph r14 = r10.f3799b;
        kotlin.jvm.internal.q.d(r14);
        if (r14.u(this.f3805h) != this) goto L11;
        r11.addFirst(this);
    L19:
        List r15 = b0.x0(r11);
        ArrayList r16 = new ArrayList(u.r(r15, 10));
        Iterator r17 = r15.iterator();
    L21:
        if (r17.hasNext() == false) goto L24;
        r16.add(Integer.valueOf(((NavDestination) r17.next()).f3805h));
        goto L21
    L24:
        return b0.w0(r16);
    L11:
        if (r12 != null) goto L13;
    L14:
        r11.addFirst(this);
    L16:
        if (kotlin.jvm.internal.q.b(r12, r10) == true) goto L19;
        if (r12 == null) goto L19;
        NavDestination this = r12;
        goto L3
    L13:
        if (r12.A() == this.f3805h) goto L16;
    L6:
        r13 = null;
        goto L7
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if ((r10 instanceof NavDestination) == false) goto L76;
        NavDestination r11 = (NavDestination) r10;
        if (b0.d0(this.f3802e, r11.f3802e).size() != this.f3802e.size()) goto L10;
        boolean r12 = true;
    L12:
        if (this.f3803f.n() != r11.f3803f.n()) goto L26;
        Iterator r13 = SequencesKt__SequencesKt.c(androidx.collection.f.a(this.f3803f)).iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        if (r11.f3803f.d((b) r13.next()) == true) goto L15;
    L19:
        Iterator r14 = SequencesKt__SequencesKt.c(androidx.collection.f.a(r11.f3803f)).iterator();
    L21:
        if (r14.hasNext() == false) goto L25;
        if (this.f3803f.d((b) r14.next()) == true) goto L21;
    L25:
        boolean r15 = true;
    L28:
        if (g().size() != r11.g().size()) goto L46;
        Iterator r16 = m0.v(g()).iterator();
    L31:
        if (r16.hasNext() == false) goto L37;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (r11.g().containsKey(r17.getKey()) == false) goto L46;
        if (kotlin.jvm.internal.q.b(r11.g().get(r17.getKey()), r17.getValue()) == false) goto L46;
    L37:
        Iterator r18 = m0.v(r11.g()).iterator();
    L39:
        if (r18.hasNext() == false) goto L45;
        Map.Entry r19 = (Map.Entry) r18.next();
        if (g().containsKey(r19.getKey()) == false) goto L46;
        if (kotlin.jvm.internal.q.b(g().get(r19.getKey()), r19.getValue()) == false) goto L46;
    L45:
        boolean r20 = true;
    L48:
        if (this.f3805h == r11.f3805h) goto L50;
        return false;
    L50:
        if (kotlin.jvm.internal.q.b(this.f3806i, r11.f3806i) == false) goto L72;
        if (r12 == false) goto L73;
        if (r15 == false) goto L74;
        if (r20 == true) goto L55;
        return false;
    L55:
        return true;
    L74:
        return false;
    L73:
        return false;
    L72:
        return false;
    L46:
        r20 = false;
    L26:
        r15 = false;
        goto L28
    L10:
        r12 = false;
        goto L12
    L76:
        return false;
    }

    public final Map g() {
        return k0.s(this.f3804g);
    }

    public String h() {
        String r10 = this.f3800c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return String.valueOf(this.f3805h);
    }

    public int hashCode() {
        int r10 = this.f3805h * 31;
        String r11 = this.f3806i;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L6:
        int r13 = r10 + r12;
        Iterator r14 = this.f3802e.iterator();
    L8:
        if (r14.hasNext() == false) goto L22;
        NavDeepLink r15 = (NavDeepLink) r14.next();
        int r16 = r13 * 31;
        String r17 = r15.k();
        if (r17 == null) goto L12;
        int r18 = r17.hashCode();
    L13:
        int r19 = (r16 + r18) * 31;
        String r20 = r15.d();
        if (r20 == null) goto L16;
        int r21 = r20.hashCode();
    L17:
        int r22 = (r19 + r21) * 31;
        String r23 = r15.g();
        if (r23 == null) goto L20;
        int r24 = r23.hashCode();
    L21:
        r13 = r22 + r24;
        goto L8
    L20:
        r24 = 0;
        goto L21
    L16:
        r21 = 0;
        goto L17
    L12:
        r18 = 0;
        goto L13
    L22:
        Iterator r25 = androidx.collection.f.a(this.f3803f);
    L24:
        if (r25.hasNext() == false) goto L41;
        b r26 = (b) r25.next();
        int r27 = ((r13 * 31) + r26.b()) * 31;
        k r28 = r26.c();
        if (r28 == null) goto L28;
        int r29 = r28.hashCode();
    L29:
        r13 = r27 + r29;
        Bundle r30 = r26.a();
        if (r30 == null) goto L24;
        Set<String> r31 = r30.keySet();
        if (r31 == null) goto L24;
        kotlin.jvm.internal.q.f(r31, "keySet()");
        Iterator<T> r32 = r31.iterator();
    L35:
        if (r32.hasNext() == false) goto L24;
        String r33 = (String) r32.next();
        int r34 = r13 * 31;
        Bundle r35 = r26.a();
        kotlin.jvm.internal.q.d(r35);
        Object r36 = r35.get(r33);
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        r13 = r34 + r37;
        goto L35
    L39:
        r37 = 0;
        goto L40
    L28:
        r29 = 0;
        goto L29
    L41:
        Iterator r38 = g().keySet().iterator();
    L43:
        if (r38.hasNext() == false) goto L49;
        String r39 = (String) r38.next();
        int r40 = ((r13 * 31) + r39.hashCode()) * 31;
        Object r41 = g().get(r39);
        if (r41 == null) goto L47;
        int r42 = r41.hashCode();
    L48:
        r13 = r40 + r42;
        goto L43
    L47:
        r42 = 0;
        goto L48
    L49:
        return r13;
    L5:
        r12 = 0;
        goto L6
    }

    public final int i() {
        return this.f3805h;
    }

    public final String j() {
        return this.f3798a;
    }

    public final NavGraph k() {
        return this.f3799b;
    }

    public final String l() {
        return this.f3806i;
    }

    public a m(f r12) {
        kotlin.jvm.internal.q.g(r12, "navDeepLinkRequest");
        if (this.f3802e.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator r10 = this.f3802e.iterator();
        a r11 = null;
    L7:
        if (r10.hasNext() == false) goto L31;
        NavDeepLink r13 = (NavDeepLink) r10.next();
        Uri r14 = r12.c();
        if (r14 == null) goto L11;
        Bundle r15 = r13.f(r14, g());
    L12:
        String r16 = r12.a();
        if (r16 != null) goto L15;
    L18:
        boolean r17 = false;
    L17:
        boolean r18 = r17;
        String r19 = r12.b();
        if (r19 == null) goto L22;
        int r110 = r13.h(r19);
    L23:
        if (r15 != null) goto L26;
        if (r18 == true) goto L26;
        if (r110 <= (-1)) goto L7;
    L26:
        a r20 = new a(this, r15, r13.l(), r18, r110);
        if (r11 == null) goto L30;
        if (r20.a(r11) <= 0) goto L7;
    L30:
        r11 = r20;
        goto L7
    L22:
        r110 = -1;
        goto L23
    L15:
        if (kotlin.jvm.internal.q.b(r16, r13.d()) == false) goto L18;
        r17 = true;
        goto L17
    L11:
        r15 = null;
        goto L12
    L31:
        return r11;
    }

    public void n(Context r10, AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "attrs");
        TypedArray r12 = r10.getResources().obtainAttributes(r11, androidx.navigation.common.R$styleable.Navigator);
        kotlin.jvm.internal.q.f(r12, "context.resources.obtain…s, R.styleable.Navigator)");
        r(r12.getString(androidx.navigation.common.R$styleable.Navigator_route));
        int r13 = androidx.navigation.common.R$styleable.Navigator_android_id;
        if (r12.hasValue(r13) == false) goto L5;
        p(r12.getResourceId(r13, 0));
        this.f3800c = f3796j.b(r10, this.f3805h);
    L5:
        this.f3801d = r12.getText(androidx.navigation.common.R$styleable.Navigator_android_label);
        Unit r14 = Unit.f21064a;
        r12.recycle();
    }

    public final void o(int r10, b r11) {
        kotlin.jvm.internal.q.g(r11, "action");
        if (s() == false) goto L10;
        if (r10 == 0) goto L8;
        this.f3803f.k(r10, r11);
        return;
    L8:
        throw new IllegalArgumentException("Cannot have an action with actionId 0");
    L10:
        throw new UnsupportedOperationException("Cannot add action " + r10 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void p(int r10) {
        this.f3805h = r10;
        this.f3800c = null;
    }

    public final void q(NavGraph r10) {
        this.f3799b = r10;
    }

    public final void r(String r10) {
        if (r10 != null) goto L5;
        p(0);
    L7:
        List r11 = this.f3802e;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        Object r13 = r12.next();
        if (kotlin.jvm.internal.q.b(((NavDeepLink) r13).k(), f3796j.a(this.f3806i)) == false) goto L9;
    L14:
        y.a(r11).remove(r13);
        this.f3806i = r10;
        return;
    L13:
        r13 = null;
        goto L14
    L5:
        if (kotlin.text.o.r(r10) == true) goto L17;
        String r14 = f3796j.a(r10);
        p(r14.hashCode());
        c(r14);
        goto L7
    L17:
        throw new IllegalArgumentException("Cannot have an empty route");
    }

    public boolean s() {
        return true;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(getClass().getSimpleName());
        r10.append("(");
        String r11 = this.f3800c;
        if (r11 != null) goto L5;
        r10.append("0x");
        r10.append(Integer.toHexString(this.f3805h));
    L6:
        r10.append(")");
        String r12 = this.f3806i;
        if (r12 == null) goto L13;
        if (kotlin.text.o.r(r12) == true) goto L13;
        r10.append(" route=");
        r10.append(this.f3806i);
    L13:
        if (this.f3801d == null) goto L15;
        r10.append(" label=");
        r10.append(this.f3801d);
    L15:
        String r13 = r10.toString();
        kotlin.jvm.internal.q.f(r13, "sb.toString()");
        return r13;
    L5:
        r10.append(r11);
        goto L6
    }

    public NavDestination(Navigator r10) {
        kotlin.jvm.internal.q.g(r10, "navigator");
        this(o.f3916b.a(r10.getClass()));
    }
}
