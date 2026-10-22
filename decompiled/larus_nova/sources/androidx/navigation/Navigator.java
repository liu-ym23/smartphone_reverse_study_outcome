package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import com.larus.bmhome.music.applet.MusicAppletPage;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002%&B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fJ5\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00028\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J*\u0010\u0010\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0006H\u0017J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0013H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Landroidx/navigation/Navigator;", "D", "Landroidx/navigation/NavDestination;", "", "()V", "_state", "Landroidx/navigation/NavigatorState;", "<set-?>", "", "isAttached", "()Z", "state", "getState", "()Landroidx/navigation/NavigatorState;", "createDestination", "()Landroidx/navigation/NavDestination;", MusicAppletPage.ROUTE_MODE_NAVIGATION, com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "", "entries", "", "Landroidx/navigation/NavBackStackEntry;", "onAttach", "onLaunchSingleTop", "backStackEntry", "onRestoreState", "savedState", "onSaveState", "popBackStack", "popUpTo", "Extras", "Name", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Navigator<D extends NavDestination> {
    private NavigatorState _state;
    private boolean isAttached;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/navigation/Navigator$Extras;", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Extras {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/Navigator$Name;", "", "value", "", "()Ljava/lang/String;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface Name {
        String value();
    }

    public Navigator() {
    }

    public abstract D createDestination();

    public NavDestination navigate(D r100, Bundle r101, NavOptions r102, Extras r103) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        return r100;
    }

    public void onRestoreState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "savedState");
    }

    public Bundle onSaveState() {
        return null;
    }

    public boolean popBackStack() {
        return true;
    }

    public final NavigatorState getState() {
        NavigatorState r100 = this._state;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public void onAttach(NavigatorState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this._state = r100;
        this.isAttached = true;
    }

    public void onLaunchSingleTop(NavBackStackEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "backStackEntry");
        NavDestination r101 = r100.getDestination();
        if ((r101 instanceof NavDestination) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        navigate(r101, null, NavOptionsBuilderKt.navOptions(C87971.INSTANCE), null);
        getState().onLaunchSingleTop(r100);
    }

    public void popBackStack(NavBackStackEntry r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "popUpTo");
        List<NavBackStackEntry> r102 = getState().getBackStack().getValue();
        if (r102.contains(r100) == false) goto L14;
        ListIterator<NavBackStackEntry> r103 = r102.listIterator(r102.size());
        NavBackStackEntry r104 = null;
    L6:
        if (popBackStack() == false) goto L10;
        r104 = r103.previous();
        if (Intrinsics.areEqual(r104, r100) == false) goto L6;
    L10:
        if (r104 == null) goto L18;
        getState().pop(r104, r101);
        return;
    L18:
        return;
    L14:
        throw new IllegalStateException(("popBackStack was called with " + r100 + " which does not exist in back stack " + r102).toString());
    }

    public void navigate(List<NavBackStackEntry> r100, final NavOptions r101, final Extras r102) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        Iterator r103 = SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(r100), new AnonymousClass1(this, r101, r102))).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        NavBackStackEntry r104 = (NavBackStackEntry) r103.next();
        getState().push(r104);
        goto L4
    }
}
