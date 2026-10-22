package androidx.navigation.fragment;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Navigator.Name(WidgetService.PARAM_FRAGMENT)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J*\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\"H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "savedIds", "", "", "createDestination", "instantiateFragment", "Landroidx/fragment/app/Fragment;", PushClientConstants.TAG_CLASS_NAME, "args", "Landroid/os/Bundle;", MusicAppletPage.ROUTE_MODE_NAVIGATION, "", "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "entries", "", "onRestoreState", "savedState", "onSaveState", "popBackStack", "popUpTo", "", "Companion", "Destination", "Extras", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = null;
    private static final String KEY_SAVED_IDS = "androidx-nav-fragment:navigator:savedIds";
    private static final String TAG = "FragmentNavigator";
    private final int containerId;
    private final Context context;
    private final FragmentManager fragmentManager;
    private final Set<String> savedIds;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "()V", "KEY_SAVED_IDS", "", "TAG", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\tH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "fragmentNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "_className", "", PushClientConstants.TAG_CLASS_NAME, "getClassName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onInflate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setClassName", "toString", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class Destination extends NavDestination {
        private String _className;

        public final String getClassName() {
            String r100 = this._className;
            if (r100 == null) goto L9;
            if (r100 == null) goto L7;
            return r100;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L9:
            throw new IllegalStateException("Fragment class was not set".toString());
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder r100 = new StringBuilder();
            r100.append(super.toString());
            r100.append(" class=");
            String r101 = this._className;
            if (r101 != null) goto L5;
            r100.append("null");
        L7:
            return r100.toString();
        L5:
            r100.append(r101);
            goto L7
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r100 = super.hashCode() * 31;
            String r101 = this._className;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public Destination(NavigatorProvider r100) {
            Intrinsics.checkNotNullParameter(r100, "navigatorProvider");
            this(r100.getNavigator(FragmentNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            if ((r100 instanceof Destination) == true) goto L8;
            return false;
        L8:
            if (super.equals(r100) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this._className, ((Destination) r100)._className) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public final Destination setClassName(String r100) {
            Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
            this._className = r100;
            return this;
        }

        public Destination(Navigator<? extends Destination> r100) {
            Intrinsics.checkNotNullParameter(r100, "fragmentNavigator");
            super(r100);
        }

        @Override // androidx.navigation.NavDestination
        public void onInflate(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "attrs");
            super.onInflate(r100, r101);
            TypedArray r102 = r100.getResources().obtainAttributes(r101, new int[]{R.attr.name});
            String r103 = r102.getString(0);
            if (r103 == null) goto L5;
            setClassName(r103);
        L5:
            Unit r104 = Unit.INSTANCE;
            r102.recycle();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "sharedElements", "", "Landroid/view/View;", "", "(Ljava/util/Map;)V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getSharedElements", "()Ljava/util/Map;", "Builder", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> _sharedElements;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\rJ\u0006\u0010\u000e\u001a\u00020\u000fR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "()V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "addSharedElement", "sharedElement", "name", "addSharedElements", "sharedElements", "", "build", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private final LinkedHashMap<View, String> _sharedElements;

            public final Extras build() {
                return new Extras(this._sharedElements);
            }

            public Builder() {
                this._sharedElements = new LinkedHashMap();
            }

            public final Builder addSharedElements(Map<View, String> r100) {
                Intrinsics.checkNotNullParameter(r100, "sharedElements");
                Iterator<Map.Entry<View, String>> r101 = r100.entrySet().iterator();
            L4:
                if (r101.hasNext() == false) goto L6;
                Map.Entry<View, String> r102 = r101.next();
                addSharedElement(r102.getKey(), r102.getValue());
                goto L4
            L6:
                return this;
            }

            public final Builder addSharedElement(View r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "sharedElement");
                Intrinsics.checkNotNullParameter(r101, "name");
                this._sharedElements.put(r100, r101);
                return this;
            }
        }

        public final Map<View, String> getSharedElements() {
            return MapsKt.toMap(this._sharedElements);
        }

        public Extras(Map<View, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "sharedElements");
            LinkedHashMap<View, String> r101 = new LinkedHashMap();
            this._sharedElements = r101;
            r101.putAll(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public Bundle onSaveState() {
        if (this.savedIds.isEmpty() == false) goto L7;
        return null;
    L7:
        return BundleKt.bundleOf(new Pair[]{TuplesKt.to(KEY_SAVED_IDS, new ArrayList(this.savedIds))});
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination createDestination() {
        return createDestination();
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "savedState");
        ArrayList<String> r101 = r100.getStringArrayList(KEY_SAVED_IDS);
        if (r101 == null) goto L6;
        this.savedIds.clear();
        CollectionsKt.addAll(this.savedIds, r101);
        return;
    }

    @Override // androidx.navigation.Navigator
    public void popBackStack(NavBackStackEntry r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "popUpTo");
        if (this.fragmentManager.isStateSaved() == false) goto L5;
        return;
    L5:
        if (r101 == false) goto L13;
        List<NavBackStackEntry> r102 = getState().getBackStack().getValue();
        NavBackStackEntry r103 = (NavBackStackEntry) CollectionsKt.first(r102);
        Iterator r104 = CollectionsKt.reversed(r102.subList(r102.indexOf(r100), r102.size())).iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        NavBackStackEntry r105 = (NavBackStackEntry) r104.next();
        if (Intrinsics.areEqual(r105, r103) == true) goto L11;
        this.fragmentManager.saveBackStack(r105.getId());
        this.savedIds.add(r105.getId());
        goto L8
    L11:
        Intrinsics.stringPlus("FragmentManager cannot save the state of the initial destination ", r105);
    L14:
        getState().pop(r100, r101);
        return;
    L13:
        this.fragmentManager.popBackStack(r100.getId(), 1);
        goto L14
    }

    public FragmentNavigator(Context r100, FragmentManager r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        this.context = r100;
        this.fragmentManager = r101;
        this.containerId = r102;
        this.savedIds = new LinkedHashSet();
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_navigation_fragment_FragmentNavigator_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r100, int r101, Fragment r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r101) == false) goto L6;
        return r100;
    L6:
        return r100.replace(r101, r102);
    }

    private final void navigate(NavBackStackEntry r110, NavOptions r111, Navigator.Extras r112) {
        List<NavBackStackEntry> r100 = getState().getBackStack().getValue();
        boolean r101 = r100.isEmpty();
        boolean r102 = false;
        if (r111 == null) goto L10;
        if (r101 == true) goto L10;
        if (r111.shouldRestoreState() == false) goto L10;
        if (this.savedIds.remove(r110.getId()) == false) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        this.fragmentManager.restoreBackStack(r110.getId());
        getState().push(r110);
        return;
    L14:
        Destination r104 = (Destination) r110.getDestination();
        Bundle r105 = r110.getArguments();
        String r106 = r104.getClassName();
        if (r106.charAt(0) != '.') goto L17;
        r106 = Intrinsics.stringPlus(this.context.getPackageName(), r106);
    L17:
        Fragment r107 = this.fragmentManager.getFragmentFactory().instantiate(this.context.getClassLoader(), r106);
        r107.setArguments(r105);
        FragmentTransaction r108 = this.fragmentManager.beginTransaction();
        if (r111 != null) goto L20;
        int r109 = -1;
    L21:
        if (r111 != null) goto L23;
        int r113 = -1;
    L24:
        if (r111 != null) goto L26;
        int r114 = -1;
    L27:
        if (r111 != null) goto L29;
        int r115 = -1;
    L30:
        if (r109 != (-1)) goto L34;
        if (r113 != (-1)) goto L34;
        if (r114 != (-1)) goto L34;
        if (r115 != (-1)) goto L34;
    L47:
        INVOKEVIRTUAL_androidx_navigation_fragment_FragmentNavigator_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r108, this.containerId, r107);
        r108.setPrimaryNavigationFragment(r107);
        int r116 = r104.getId();
        if (r111 == null) goto L55;
        if (r101 == true) goto L55;
        if (r111.shouldLaunchSingleTop() == false) goto L55;
        if (((NavBackStackEntry) CollectionsKt.last(r100)).getDestination().getId() != r116) goto L55;
        boolean r117 = true;
    L56:
        if (r101 == false) goto L58;
    L57:
        r102 = true;
    L64:
        if ((r112 instanceof Extras) == false) goto L69;
        Iterator<Map.Entry<View, String>> r118 = ((Extras) r112).getSharedElements().entrySet().iterator();
    L67:
        if (r118.hasNext() == false) goto L69;
        Map.Entry<View, String> r119 = r118.next();
        r108.addSharedElement(r119.getKey(), r119.getValue());
    L69:
        r108.setReorderingAllowed(true);
        r108.commit();
        if (r102 == false) goto L74;
        getState().push(r110);
        return;
    L74:
        return;
    L58:
        if (r117 == true) goto L60;
        r108.addToBackStack(r110.getId());
        goto L57
    L60:
        if (r100.size() <= 1) goto L64;
        this.fragmentManager.popBackStack(r110.getId(), 1);
        r108.addToBackStack(r110.getId());
    L55:
        r117 = false;
    L34:
        if (r109 != (-1)) goto L37;
        r109 = 0;
    L37:
        if (r113 != (-1)) goto L40;
        r113 = 0;
    L40:
        if (r114 != (-1)) goto L43;
        r114 = 0;
    L43:
        if (r115 != (-1)) goto L46;
        r115 = 0;
    L46:
        r108.setCustomAnimations(r109, r113, r114, r115);
        goto L47
    L29:
        r115 = r111.getPopExitAnim();
        goto L30
    L26:
        r114 = r111.getPopEnterAnim();
        goto L27
    L23:
        r113 = r111.getExitAnim();
        goto L24
    L20:
        r109 = r111.getEnterAnim();
    L10:
        r103 = false;
        goto L11
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> r100, NavOptions r101, Navigator.Extras r102) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        if (this.fragmentManager.isStateSaved() == false) goto L5;
        return;
    L5:
        Iterator<NavBackStackEntry> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        navigate(r103.next(), r101, r102);
        goto L7
    }

    @Deprecated(message = "Set a custom {@link androidx.fragment.app.FragmentFactory} via\n      {@link FragmentManager#setFragmentFactory(FragmentFactory)} to control\n      instantiation of Fragments.")
    public Fragment instantiateFragment(Context r100, FragmentManager r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, PushClientConstants.TAG_CLASS_NAME);
        return r101.getFragmentFactory().instantiate(r100.getClassLoader(), r102);
    }
}
