package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@NavDestinationDsl
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u001f\u0010\u000e\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0017R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavActionBuilder;", "", "()V", "defaultArguments", "", "", "getDefaultArguments", "()Ljava/util/Map;", "destinationId", "", "getDestinationId", "()I", "setDestinationId", "(I)V", "navOptions", "Landroidx/navigation/NavOptions;", "build", "Landroidx/navigation/NavAction;", "build$navigation_common_release", "", "optionsBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavActionBuilder {
    private final Map<String, Object> defaultArguments;
    private int destinationId;
    private NavOptions navOptions;

    public final NavAction build$navigation_common_release() {
        int r100 = this.destinationId;
        NavOptions r101 = this.navOptions;
        if (this.defaultArguments.isEmpty() == false) goto L5;
        Bundle r102 = null;
    L9:
        return new NavAction(r100, r101, r102);
    L5:
        Object[] r103 = MapsKt.toList(this.defaultArguments).toArray(new Pair[0]);
        if (r103 == null) goto L11;
        Pair[] r104 = (Pair[]) r103;
        r102 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r104, r104.length));
        goto L9
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public NavActionBuilder() {
        this.defaultArguments = new LinkedHashMap();
    }

    public final Map<String, Object> getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void navOptions(Function1<? super NavOptionsBuilder, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "optionsBuilder");
        NavOptionsBuilder r101 = new NavOptionsBuilder();
        r100.invoke(r101);
        this.navOptions = r101.build$navigation_common_release();
    }

    public final void setDestinationId(int r100) {
        this.destinationId = r100;
    }
}
