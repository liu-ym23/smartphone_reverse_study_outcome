package androidx.navigation;

import androidx.navigation.NavDestination;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@NavDestinationDsl
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B!\b\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB+\b\u0000\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%¢\u0006\u0002\b'H\u0007J'\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\n2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\"0%¢\u0006\u0002\b'J\r\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\"2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\"0%¢\u0006\u0002\b'J\u000e\u0010.\u001a\u00020\"2\u0006\u00101\u001a\u00020\nR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "D", "Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "id", "", "(Landroidx/navigation/Navigator;I)V", CloudControlInf.ROUTE, "", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", SlcCommonAction.KEY_ACTIONS, "", "Landroidx/navigation/NavAction;", "arguments", "Landroidx/navigation/NavArgument;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "getId", "()I", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "getRoute", "()Ljava/lang/String;", "action", "", "actionId", "actionBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavActionBuilder;", "Lkotlin/ExtensionFunctionType;", "argument", "name", "argumentBuilder", "Landroidx/navigation/NavArgumentBuilder;", "build", "()Landroidx/navigation/NavDestination;", "deepLink", "navDeepLink", "Landroidx/navigation/NavDeepLinkDslBuilder;", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f15585id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;
    private final String route;

    public D build() {
        D r100 = (D) this.navigator.createDestination();
        if (getRoute() == null) goto L6;
        r100.setRoute(getRoute());
    L6:
        if (getId() == (-1)) goto L8;
        r100.setId(getId());
    L8:
        r100.setLabel(getLabel());
        Iterator<Map.Entry<String, NavArgument>> r101 = this.arguments.entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<String, NavArgument> r102 = r101.next();
        r100.addArgument(r102.getKey(), r102.getValue());
        goto L10
    L12:
        Iterator<T> r103 = this.deepLinks.iterator();
    L14:
        if (r103.hasNext() == false) goto L16;
        r100.addDeepLink((NavDeepLink) r103.next());
        goto L14
    L16:
        Iterator<Map.Entry<Integer, NavAction>> r104 = this.actions.entrySet().iterator();
    L18:
        if (r104.hasNext() == false) goto L20;
        Map.Entry<Integer, NavAction> r105 = r104.next();
        r100.putAction(r105.getKey().intValue(), r105.getValue());
        goto L18
    L20:
        return r100;
    }

    public final int getId() {
        return this.f15585id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    public final String getRoute() {
        return this.route;
    }

    public final void deepLink(Function1<? super NavDeepLinkDslBuilder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "navDeepLink");
        List<NavDeepLink> r101 = this.deepLinks;
        NavDeepLinkDslBuilder r102 = new NavDeepLinkDslBuilder();
        r100.invoke(r102);
        r101.add(r102.build$navigation_common_release());
    }

    public final void setLabel(CharSequence r100) {
        this.label = r100;
    }

    public final void deepLink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uriPattern");
        this.deepLinks.add(new NavDeepLink(r100));
    }

    @Deprecated(message = "Use routes to build your NavDestination instead", replaceWith = @ReplaceWith(expression = "NavDestinationBuilder(navigator, route = id.toString())", imports = {}))
    public NavDestinationBuilder(Navigator<? extends D> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        this(r100, r101, null);
    }

    @Deprecated(message = "Building NavDestinations using IDs with the Kotlin DSL has been deprecated in favor of using routes. When using routes there is no need for actions.")
    public final void action(int r100, Function1<? super NavActionBuilder, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "actionBuilder");
        Map<Integer, NavAction> r102 = this.actions;
        Integer r103 = Integer.valueOf(r100);
        NavActionBuilder r104 = new NavActionBuilder();
        r101.invoke(r104);
        r102.put(r103, r104.build$navigation_common_release());
    }

    public final void argument(String r100, Function1<? super NavArgumentBuilder, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "argumentBuilder");
        Map<String, NavArgument> r102 = this.arguments;
        NavArgumentBuilder r103 = new NavArgumentBuilder();
        r101.invoke(r103);
        r102.put(r100, r103.build());
    }

    public NavDestinationBuilder(Navigator<? extends D> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        this(r100, -1, r101);
    }

    public NavDestinationBuilder(Navigator<? extends D> r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        this.navigator = r100;
        this.f15585id = r101;
        this.route = r102;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }
}
