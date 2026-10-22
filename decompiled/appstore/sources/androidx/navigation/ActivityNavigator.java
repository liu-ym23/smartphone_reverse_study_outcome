package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.SequencesKt__SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("activity")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "l", "()Landroidx/navigation/ActivityNavigator$b;", "", "k", "()Z", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/k;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Landroidx/navigation/NavDestination;", "m", "(Landroidx/navigation/ActivityNavigator$b;Landroid/os/Bundle;Landroidx/navigation/k;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "hostActivity", "e", "a", "b", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ActivityNavigator extends Navigator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3724e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f3726d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static class b extends NavDestination {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Intent f3727l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f3728m;

        public b(Navigator r10) {
            kotlin.jvm.internal.q.g(r10, "activityNavigator");
            super(r10);
        }

        public final b A(String r10) {
            this.f3728m = r10;
            return this;
        }

        public final b B(String r10) {
            if (this.f3727l != null) goto L5;
            this.f3727l = new Intent();
        L5:
            Intent r11 = this.f3727l;
            kotlin.jvm.internal.q.d(r11);
            r11.setPackage(r10);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object r10) {
            if (r10 != null) goto L5;
            return false;
        L5:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            if (super.equals(r10) == false) goto L22;
            Intent r11 = this.f3727l;
            if (r11 == null) goto L13;
            boolean r12 = r11.filterEquals(((b) r10).f3727l);
        L16:
            if (r12 == true) goto L18;
            return false;
        L18:
            if (kotlin.jvm.internal.q.b(this.f3728m, ((b) r10).f3728m) == true) goto L20;
            return false;
        L20:
            return true;
        L13:
            if (((b) r10).f3727l != null) goto L15;
            r12 = true;
            goto L16
        L15:
            r12 = false;
            goto L16
        L22:
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r10 = super.hashCode() * 31;
            Intent r11 = this.f3727l;
            int r12 = 0;
            if (r11 == null) goto L5;
            int r13 = r11.filterHashCode();
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.f3728m;
            if (r15 == null) goto L10;
            r12 = r15.hashCode();
        L10:
            return r14 + r12;
        L5:
            r13 = 0;
            goto L6
        }

        @Override // androidx.navigation.NavDestination
        public void n(Context r10, AttributeSet r11) {
            kotlin.jvm.internal.q.g(r10, "context");
            kotlin.jvm.internal.q.g(r11, "attrs");
            super.n(r10, r11);
            TypedArray r12 = r10.getResources().obtainAttributes(r11, R$styleable.ActivityNavigator);
            kotlin.jvm.internal.q.f(r12, "context.resources.obtain…tyNavigator\n            )");
            String r13 = r12.getString(R$styleable.ActivityNavigator_targetPackage);
            if (r13 == null) goto L5;
            String r14 = r10.getPackageName();
            kotlin.jvm.internal.q.f(r14, "context.packageName");
            r13 = kotlin.text.o.x(r13, "${applicationId}", r14, false, 4, null);
        L5:
            B(r13);
            String r15 = r12.getString(R$styleable.ActivityNavigator_android_name);
            if (r15 != null) goto L8;
        L11:
            x(r12.getString(R$styleable.ActivityNavigator_action));
            String r16 = r12.getString(R$styleable.ActivityNavigator_data);
            if (r16 == null) goto L14;
            z(Uri.parse(r16));
        L14:
            A(r12.getString(R$styleable.ActivityNavigator_dataPattern));
            r12.recycle();
            return;
        L8:
            if (r15.charAt(0) != '.') goto L10;
            r15 = r10.getPackageName() + r15;
        L10:
            y(new ComponentName(r10, r15));
            goto L11
        }

        @Override // androidx.navigation.NavDestination
        public boolean s() {
            return false;
        }

        public final String t() {
            Intent r10 = this.f3727l;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.getAction();
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName r10 = u();
            StringBuilder r11 = new StringBuilder();
            r11.append(super.toString());
            if (r10 == null) goto L5;
            r11.append(" class=");
            r11.append(r10.getClassName());
        L8:
            String r12 = r11.toString();
            kotlin.jvm.internal.q.f(r12, "sb.toString()");
            return r12;
        L5:
            String r13 = t();
            if (r13 == null) goto L8;
            r11.append(" action=");
            r11.append(r13);
            goto L8
        }

        public final ComponentName u() {
            Intent r10 = this.f3727l;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.getComponent();
        }

        public final String v() {
            return this.f3728m;
        }

        public final Intent w() {
            return this.f3727l;
        }

        public final b x(String r10) {
            if (this.f3727l != null) goto L5;
            this.f3727l = new Intent();
        L5:
            Intent r11 = this.f3727l;
            kotlin.jvm.internal.q.d(r11);
            r11.setAction(r10);
            return this;
        }

        public final b y(ComponentName r10) {
            if (this.f3727l != null) goto L5;
            this.f3727l = new Intent();
        L5:
            Intent r11 = this.f3727l;
            kotlin.jvm.internal.q.d(r11);
            r11.setComponent(r10);
            return this;
        }

        public final b z(Uri r10) {
            if (this.f3727l != null) goto L5;
            this.f3727l = new Intent();
        L5:
            Intent r11 = this.f3727l;
            kotlin.jvm.internal.q.d(r11);
            r11.setData(r10);
            return this;
        }
    }

    static {
        f3724e = new a(null);
    }

    public ActivityNavigator(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.f3725c = r10;
        Iterator r11 = SequencesKt__SequencesKt.f(r10, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((((Context) r12) instanceof Activity) == false) goto L4;
    L9:
        this.f3726d = (Activity) r12;
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination a() {
        return l();
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination d(NavDestination r10, Bundle r11, k r12, Navigator.Extras r13) {
        return m((b) r10, r11, r12, r13);
    }

    @Override // androidx.navigation.Navigator
    public boolean k() {
        Activity r10 = this.f3726d;
        if (r10 == null) goto L6;
        r10.finish();
        return true;
    L6:
        return false;
    }

    public b l() {
        return new b(this);
    }

    public NavDestination m(b r10, Bundle r11, k r12, Navigator.Extras r13) {
        kotlin.jvm.internal.q.g(r10, "destination");
        if (r10.w() == null) goto L63;
        Intent r14 = new Intent(r10.w());
        if (r11 == null) goto L21;
        r14.putExtras(r11);
        String r15 = r10.v();
        if (r15 == null) goto L21;
        if (r15.length() == 0) goto L21;
        StringBuffer r16 = new StringBuffer();
        Matcher r17 = Pattern.compile("\\{(.+?)\\}").matcher(r15);
    L13:
        if (r17.find() == false) goto L19;
        String r18 = r17.group(1);
        if (r11.containsKey(r18) == false) goto L18;
        r17.appendReplacement(r16, "");
        r16.append(Uri.encode(String.valueOf(r11.get(r18))));
        goto L13
    L18:
        throw new IllegalArgumentException("Could not find " + r18 + " in " + r11 + " to fill data pattern " + r15);
    L19:
        r17.appendTail(r16);
        r14.setData(Uri.parse(r16.toString()));
    L21:
        if (this.f3726d != null) goto L23;
        r14.addFlags(268435456);
    L23:
        if (r12 != null) goto L25;
    L27:
        Activity r19 = this.f3726d;
        if (r19 == null) goto L34;
        Intent r20 = r19.getIntent();
        if (r20 == null) goto L34;
        int r21 = r20.getIntExtra("android-support-navigation:ActivityNavigator:current", 0);
        if (r21 == 0) goto L34;
        r14.putExtra("android-support-navigation:ActivityNavigator:source", r21);
    L34:
        r14.putExtra("android-support-navigation:ActivityNavigator:current", r10.i());
        Resources r22 = this.f3725c.getResources();
        if (r12 == null) goto L45;
        int r23 = r12.c();
        int r24 = r12.d();
        if (r23 > 0) goto L39;
    L40:
        if (r24 > 0) goto L42;
    L44:
        r14.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", r23);
        r14.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", r24);
        goto L45
    L42:
        if (kotlin.jvm.internal.q.b(r22.getResourceTypeName(r24), "animator") == false) goto L44;
    L43:
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + r22.getResourceName(r23) + " and popExit resource " + r22.getResourceName(r24) + " when launching " + r10);
        goto L45
    L39:
        if (kotlin.jvm.internal.q.b(r22.getResourceTypeName(r23), "animator") == true) goto L43;
    L45:
        this.f3725c.startActivity(r14);
        if (r12 != null) goto L48;
        return null;
    L48:
        if (this.f3726d == null) goto L67;
        int r110 = r12.a();
        int r111 = r12.b();
        if (r110 > 0) goto L52;
    L53:
        if (r111 > 0) goto L55;
    L57:
        if (r110 >= 0) goto L59;
        if (r111 >= 0) goto L59;
        return null;
    L59:
        this.f3726d.overridePendingTransition(bg.h.d(r110, 0), bg.h.d(r111, 0));
        return null;
    L55:
        if (kotlin.jvm.internal.q.b(r22.getResourceTypeName(r111), "animator") == false) goto L57;
    L56:
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + r22.getResourceName(r110) + " and exit resource " + r22.getResourceName(r111) + "when launching " + r10);
        return null;
    L52:
        if (kotlin.jvm.internal.q.b(r22.getResourceTypeName(r110), "animator") == true) goto L56;
    L67:
        return null;
    L25:
        if (r12.g() == false) goto L27;
        r14.addFlags(536870912);
        goto L27
    L63:
        throw new IllegalStateException(("Destination " + r10.i() + " does not have an Intent set.").toString());
    }
}
