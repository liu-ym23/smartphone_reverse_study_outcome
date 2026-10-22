package androidx.navigation;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@NavDestinationDsl
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u001e\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u0017*\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0001J\r\u0010\u0019\u001a\u00020\u0014*\u00020\u000eH\u0086\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavGraph;", ShortVideoSegments.KEY_PROP_PROVIDER, "Landroidx/navigation/NavigatorProvider;", "id", "", "startDestination", "(Landroidx/navigation/NavigatorProvider;II)V", "", CloudControlInf.ROUTE, "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;Ljava/lang/String;)V", "destinations", "", "Landroidx/navigation/NavDestination;", "getProvider", "()Landroidx/navigation/NavigatorProvider;", "startDestinationId", "startDestinationRoute", "addDestination", "", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "build", "D", "navDestination", "unaryPlus", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    private final List<NavDestination> destinations;
    private final NavigatorProvider provider;
    private int startDestinationId;
    private String startDestinationRoute;

    @Override // androidx.navigation.NavDestinationBuilder
    public NavGraph build() {
        NavGraph r100 = (NavGraph) super.build();
        r100.addDestinations(this.destinations);
        int r101 = this.startDestinationId;
        if (r101 == 0) goto L5;
    L12:
        String r102 = this.startDestinationRoute;
        if (r102 == null) goto L15;
        Intrinsics.checkNotNull(r102);
        r100.setStartDestination(r102);
    L16:
        return r100;
    L15:
        r100.setStartDestination(r101);
        goto L16
    L5:
        if (this.startDestinationRoute != null) goto L12;
        if (getRoute() == null) goto L11;
        throw new IllegalStateException("You must set a start destination route");
    L11:
        throw new IllegalStateException("You must set a start destination id");
    }

    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public /* bridge */ /* synthetic */ NavDestination build() {
        return build();
    }

    public final void addDestination(NavDestination r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        this.destinations.add(r100);
    }

    public final <D extends NavDestination> void destination(NavDestinationBuilder<? extends D> r100) {
        Intrinsics.checkNotNullParameter(r100, "navDestination");
        this.destinations.add(r100.build());
    }

    public final void unaryPlus(NavDestination r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        addDestination(r100);
    }

    public NavGraphBuilder(NavigatorProvider r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "startDestination");
        super(r100.getNavigator(NavGraphNavigator.class), r102);
        this.destinations = new ArrayList();
        this.provider = r100;
        this.startDestinationRoute = r101;
    }

    @Deprecated(message = "Use routes to build your NavGraph instead", replaceWith = @ReplaceWith(expression = "NavGraphBuilder(provider, startDestination = startDestination.toString(), route = id.toString())", imports = {}))
    public NavGraphBuilder(NavigatorProvider r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100.getNavigator(NavGraphNavigator.class), r101);
        this.destinations = new ArrayList();
        this.provider = r100;
        this.startDestinationId = r102;
    }
}
