package androidx.navigation;

import androidx.core.app.NotificationCompat;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u000b*\u00020\f2\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {NotificationCompat.CATEGORY_NAVIGATION, "", "Landroidx/navigation/NavGraphBuilder;", "id", "", "startDestination", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "", CloudControlInf.ROUTE, "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphBuilderKt {
    public static final void navigation(NavGraphBuilder r100, String r101, String r102, Function1<? super NavGraphBuilder, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "startDestination");
        Intrinsics.checkNotNullParameter(r102, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r103, "builder");
        NavGraphBuilder r104 = new NavGraphBuilder(r100.getProvider(), r101, r102);
        r103.invoke(r104);
        r100.destination(r104);
    }

    public static final NavGraph navigation(NavigatorProvider r100, String r101, String r102, Function1<? super NavGraphBuilder, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "startDestination");
        Intrinsics.checkNotNullParameter(r103, "builder");
        NavGraphBuilder r104 = new NavGraphBuilder(r100, r101, r102);
        r103.invoke(r104);
        return r104.build();
    }

    @Deprecated(message = "Use routes to build your nested NavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void navigation(NavGraphBuilder r100, int r101, int r102, Function1<? super NavGraphBuilder, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "builder");
        NavGraphBuilder r104 = new NavGraphBuilder(r100.getProvider(), r101, r102);
        r103.invoke(r104);
        r100.destination(r104);
    }

    @Deprecated(message = "Use routes to build your NavGraph instead", replaceWith = @ReplaceWith(expression = "navigation(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph navigation(NavigatorProvider r100, int r101, int r102, Function1<? super NavGraphBuilder, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "builder");
        NavGraphBuilder r104 = new NavGraphBuilder(r100, r101, r102);
        r103.invoke(r104);
        return r104.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider r100, String r101, String r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "startDestination");
        Intrinsics.checkNotNullParameter(r103, "builder");
        NavGraphBuilder r106 = new NavGraphBuilder(r100, r101, r102);
        r103.invoke(r106);
        return r106.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider r100, int r101, int r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "builder");
        NavGraphBuilder r106 = new NavGraphBuilder(r100, r101, r102);
        r103.invoke(r106);
        return r106.build();
    }
}
