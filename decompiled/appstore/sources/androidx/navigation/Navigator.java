package androidx.navigation;

import android.os.Bundle;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.b0;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class Navigator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f3821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3822b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/navigation/Navigator$Extras;", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Extras {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/Navigator$Name;", "", CommonKey.KEY_VALUE, "", "()Ljava/lang/String;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface Name {
        String value();
    }

    public Navigator() {
    }

    public abstract NavDestination a();

    public final p b() {
        p r10 = this.f3821a;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public final boolean c() {
        return this.f3822b;
    }

    public NavDestination d(NavDestination r10, Bundle r11, k r12, Extras r13) {
        kotlin.jvm.internal.q.g(r10, "destination");
        return r10;
    }

    public void e(List r10, final k r11, final Extras r12) {
        kotlin.jvm.internal.q.g(r10, "entries");
        Iterator r13 = SequencesKt___SequencesKt.l(SequencesKt___SequencesKt.s(b0.Q(r10), new Navigator$navigate$1(this, r11, r12))).iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        NavBackStackEntry r14 = (NavBackStackEntry) r13.next();
        b().h(r14);
        goto L4
    }

    public void f(p r10) {
        kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        this.f3821a = r10;
        this.f3822b = true;
    }

    public void g(NavBackStackEntry r10) {
        kotlin.jvm.internal.q.g(r10, "backStackEntry");
        NavDestination r11 = r10.f();
        if (r11 != null) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        d(r11, null, m.a(Navigator$onLaunchSingleTop$1.INSTANCE), null);
        b().f(r10);
    }

    public void h(Bundle r10) {
        kotlin.jvm.internal.q.g(r10, "savedState");
    }

    public Bundle i() {
        return null;
    }

    public void j(NavBackStackEntry r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "popUpTo");
        List r12 = (List) b().b().getValue();
        if (r12.contains(r10) == false) goto L14;
        ListIterator r13 = r12.listIterator(r12.size());
        NavBackStackEntry r14 = null;
    L6:
        if (k() == false) goto L10;
        r14 = (NavBackStackEntry) r13.previous();
        if (kotlin.jvm.internal.q.b(r14, r10) == false) goto L6;
    L10:
        if (r14 == null) goto L18;
        b().g(r14, r11);
        return;
    L18:
        return;
    L14:
        throw new IllegalStateException(("popBackStack was called with " + r10 + " which does not exist in back stack " + r12).toString());
    }

    public boolean k() {
        return true;
    }
}
