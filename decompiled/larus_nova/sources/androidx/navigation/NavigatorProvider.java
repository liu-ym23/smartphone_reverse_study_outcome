package androidx.navigation;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006J*\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0017J'\u0010\u000f\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J#\u0010\u000f\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0014R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/navigation/NavigatorProvider;", "", "()V", "_navigators", "", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigators", "", "getNavigators", "()Ljava/util/Map;", "addNavigator", "navigator", "name", "getNavigator", ExifInterface.GPS_DIRECTION_TRUE, "navigatorClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/navigation/Navigator;", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavigatorProvider {
    public static final Companion Companion = null;
    private static final Map<Class<?>, String> annotationNames = null;
    private final Map<String, Navigator<? extends NavDestination>> _navigators;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t0\u0005H\u0001¢\u0006\u0002\b\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u000eR \u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavigatorProvider$Companion;", "", "()V", "annotationNames", "", "Ljava/lang/Class;", "", "getNameForNavigator", "navigatorClass", "Landroidx/navigation/Navigator;", "getNameForNavigator$navigation_common_release", "validateName", "", "name", "validateName$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final String getNameForNavigator$navigation_common_release(Class<? extends Navigator<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "navigatorClass");
            String r101 = (String) NavigatorProvider.access$getAnnotationNames$cp().get(r100);
            if (r101 != null) goto L13;
            Navigator.Name r102 = (Navigator.Name) r100.getAnnotation(Navigator.Name.class);
            if (r102 != null) goto L7;
            r101 = null;
        L9:
            if (validateName$navigation_common_release(r101) == false) goto L12;
            NavigatorProvider.access$getAnnotationNames$cp().put(r100, r101);
            goto L13
        L12:
            throw new IllegalArgumentException(Intrinsics.stringPlus("No @Navigator.Name annotation found for ", r100.getSimpleName()).toString());
        L7:
            r101 = r102.value();
        L13:
            Intrinsics.checkNotNull(r101);
            return r101;
        }

        public final boolean validateName$navigation_common_release(String r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L12;
            return true;
        L12:
            return false;
        L7:
            r101 = false;
            goto L8
        }
    }

    @JvmStatic
    public static final String getNameForNavigator$navigation_common_release(Class<? extends Navigator<?>> r100) {
        return Companion.getNameForNavigator$navigation_common_release(r100);
    }

    static {
        Companion = new Companion(null);
        annotationNames = new LinkedHashMap();
    }

    public final Map<String, Navigator<? extends NavDestination>> getNavigators() {
        return MapsKt.toMap(this._navigators);
    }

    public NavigatorProvider() {
        this._navigators = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getAnnotationNames$cp() {
        return annotationNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Navigator<? extends NavDestination> addNavigator(Navigator<? extends NavDestination> r100) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        return addNavigator(Companion.getNameForNavigator$navigation_common_release(r100.getClass()), r100);
    }

    public <T extends Navigator<?>> T getNavigator(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Companion.validateName$navigation_common_release(r100) == false) goto L10;
        Navigator<? extends NavDestination> r101 = this._navigators.get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalStateException("Could not find Navigator with name \"" + r100 + "\". You must call NavController.addNavigator() for each navigation type.");
    L10:
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }

    public final <T extends Navigator<?>> T getNavigator(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "navigatorClass");
        return (T) getNavigator(Companion.getNameForNavigator$navigation_common_release(r100));
    }

    public Navigator<? extends NavDestination> addNavigator(String r100, Navigator<? extends NavDestination> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "navigator");
        if (Companion.validateName$navigation_common_release(r100) == false) goto L24;
        Navigator<? extends NavDestination> r102 = this._navigators.get(r100);
        if (Intrinsics.areEqual(r102, r101) == false) goto L7;
        return r101;
    L7:
        boolean r103 = false;
        if (r102 == null) goto L14;
        if (r102.isAttached() != true) goto L14;
        r103 = true;
    L14:
        if ((!r103) == false) goto L22;
        if ((!r101.isAttached()) == false) goto L20;
        return this._navigators.put(r100, r101);
    L20:
        throw new IllegalStateException(("Navigator " + r101 + " is already attached to another NavController").toString());
    L22:
        throw new IllegalStateException(("Navigator " + r101 + " is replacing an already attached " + r102).toString());
    L24:
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }
}
