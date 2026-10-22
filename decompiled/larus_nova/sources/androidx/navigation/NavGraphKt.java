package androidx.navigation;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0086\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0086\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0086\n¨\u0006\u000e"}, d2 = {"contains", "", "Landroidx/navigation/NavGraph;", "id", "", CloudControlInf.ROUTE, "", MonitorConstants.CONNECT_TYPE_GET, "Landroidx/navigation/NavDestination;", "minusAssign", "", "node", "plusAssign", "other", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphKt {
    public static final boolean contains(NavGraph r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
        if (r100.findNode(r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final NavDestination get(NavGraph r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
        NavDestination r102 = r100.findNode(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("No destination for " + r101 + " was found in " + r100);
    }

    public static final void minusAssign(NavGraph r100, NavDestination r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "node");
        r100.remove(r101);
    }

    public static final void plusAssign(NavGraph r100, NavDestination r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "node");
        r100.addDestination(r101);
    }

    public static final boolean contains(NavGraph r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.findNode(r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final NavDestination get(NavGraph r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        NavDestination r102 = r100.findNode(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("No destination for " + r101 + " was found in " + r100);
    }

    public static final void plusAssign(NavGraph r100, NavGraph r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        r100.addAll(r101);
    }
}
