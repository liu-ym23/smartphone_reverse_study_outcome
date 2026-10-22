package androidx.navigation;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 X2\u00020\u0001:\u0003WXYB\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0014J\u000e\u00104\u001a\u0002012\u0006\u00106\u001a\u00020\u0006J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u000108H\u0007J\u0014\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\u0019H\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020EH\u0017J\u0018\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0017J\u0018\u0010O\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\rJ\u001a\u0010O\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u00192\b\b\u0001\u0010R\u001a\u00020\u0019J\u0010\u0010S\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u0019J\u000e\u0010T\u001a\u0002012\u0006\u00102\u001a\u00020\u0006J\b\u0010U\u001a\u00020>H\u0017J\b\u0010V\u001a\u00020\u0006H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0018\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0007¨\u0006Z"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "navigatorName", "", "(Ljava/lang/String;)V", "_arguments", "", "Landroidx/navigation/NavArgument;", SlcCommonAction.KEY_ACTIONS, "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "getArguments", "()Ljava/util/Map;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "()Ljava/lang/String;", "id", "", "getId", "()I", "setId", "(I)V", "idName", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigatorName", "<set-?>", "Landroidx/navigation/NavGraph;", "parent", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", CloudControlInf.ROUTE, "getRoute", "setRoute", "addArgument", "", "argumentName", "argument", "addDeepLink", "navDeepLink", "uriPattern", "addInDefaultArgs", "Landroid/os/Bundle;", "args", "buildDeepLinkIds", "", "previousDestination", "equals", "", "other", "getAction", "hasDeepLink", "deepLink", "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "hashCode", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "onInflate", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "putAction", "actionId", "action", "destId", "removeAction", "removeArgument", "supportsActions", "toString", "ClassType", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDestination {
    public static final Companion Companion = null;
    private static final Map<String, Class<?>> classes = null;
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f15584id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ClassType {
        Class<?> value();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J:\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0005J:\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "()V", "classes", "", "", "Ljava/lang/Class;", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "createRoute", CloudControlInf.ROUTE, "getDisplayName", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "id", "", "parseClassFromName", "C", "name", "expectedClassType", "parseClassFromNameInternal", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            return Class.forName(r100, r101, r102);
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination r100) {
        }

        public final String createRoute(String r100) {
            if (r100 != null) goto L6;
            return "";
        L6:
            return Intrinsics.stringPlus("android-app://androidx.navigation/", r100);
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return SequencesKt.generateSequence(r100, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        @JvmStatic
        public final String getDisplayName(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r101 <= 16777215) goto L11;
            return r100.getResources().getResourceName(r101);
        L8:
            return String.valueOf(r101);
        L11:
            return String.valueOf(r101);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_navigation_NavDestination$Companion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r105;
        L8:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r106;
        L17:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromName(Context r100, String r101, Class<? extends C> r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "expectedClassType");
            if (r101.charAt(0) != '.') goto L5;
            String r103 = Intrinsics.stringPlus(r100.getPackageName(), r101);
        L6:
            Class<? extends C> r104 = (Class) NavDestination.access$getClasses$cp().get(r103);
            if (r104 == null) goto L18;
        L13:
            Intrinsics.checkNotNull(r104);
            if (r102.isAssignableFrom(r104) == false) goto L17;
            return r104;
        L17:
            throw new IllegalArgumentException((r103 + " must be a subclass of " + r102).toString());
        L18:
            r104 = INVOKESTATIC_androidx_navigation_NavDestination$Companion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r103, true, r100.getClassLoader());     // Catch: ClassNotFoundException -> L10
            NavDestination.access$getClasses$cp().put(r101, r104);     // Catch: ClassNotFoundException -> L10
        L10:
            e = move-exception;
            throw new IllegalArgumentException(e);
        L5:
            r103 = r101;
            goto L6
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(Context r100, String r101, Class<? extends C> r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "expectedClassType");
            return NavDestination.parseClassFromName(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", "", "hasMatchingAction", "mimeTypeMatchLevel", "", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int mimeTypeMatchLevel;

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(DeepLinkMatch r100) {
            Intrinsics.checkNotNullParameter(r100, "other");
            boolean r101 = this.isExactDeepLink;
            if (r101 == false) goto L8;
            if (r100.isExactDeepLink == true) goto L8;
            return 1;
        L8:
            if (r101 == false) goto L10;
        L12:
            Bundle r102 = this.matchingArgs;
            if (r102 != null) goto L15;
        L17:
            if (r102 == null) goto L19;
        L21:
            if (r102 == null) goto L27;
            int r103 = r102.size();
            Bundle r104 = r100.matchingArgs;
            Intrinsics.checkNotNull(r104);
            int r105 = r103 - r104.size();
            if (r105 <= 0) goto L25;
            return 1;
        L25:
            if (r105 >= 0) goto L27;
            return -1;
        L27:
            boolean r106 = this.hasMatchingAction;
            if (r106 == true) goto L30;
        L32:
            if (r106 == true) goto L37;
            if (r100.hasMatchingAction == false) goto L37;
            return -1;
        L37:
            return this.mimeTypeMatchLevel - r100.mimeTypeMatchLevel;
        L30:
            if (r100.hasMatchingAction == true) goto L32;
            return 1;
        L19:
            if (r100.matchingArgs == null) goto L21;
            return -1;
        L15:
            if (r100.matchingArgs != null) goto L17;
            return 1;
        L10:
            if (r100.isExactDeepLink == false) goto L12;
            return -1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(DeepLinkMatch r100) {
            return compareTo2(r100);
        }

        public DeepLinkMatch(NavDestination r100, Bundle r101, boolean r102, boolean r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
            this.destination = r100;
            this.matchingArgs = r101;
            this.isExactDeepLink = r102;
            this.hasMatchingAction = r103;
            this.mimeTypeMatchLevel = r104;
        }
    }

    @JvmStatic
    public static final String getDisplayName(Context r100, int r101) {
        return Companion.getDisplayName(r100, r101);
    }

    public static final Sequence<NavDestination> getHierarchy(NavDestination r100) {
        return Companion.getHierarchy(r100);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromName(Context r100, String r101, Class<? extends C> r102) {
        return Companion.parseClassFromName(r100, r101, r102);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context r100, String r101, Class<? extends C> r102) {
        return Companion.parseClassFromNameInternal(r100, r101, r102);
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    public boolean supportsActions() {
        return true;
    }

    static {
        Companion = new Companion(null);
        classes = new LinkedHashMap();
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt.toMap(this._arguments);
    }

    public String getDisplayName() {
        String r100 = this.idName;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return String.valueOf(this.f15584id);
    }

    public int hashCode() {
        int r100 = this.f15584id * 31;
        String r101 = this.route;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r100 + r102;
        Iterator<T> r104 = this.deepLinks.iterator();
    L8:
        if (r104.hasNext() == false) goto L22;
        NavDeepLink r105 = (NavDeepLink) r104.next();
        int r106 = r103 * 31;
        String r107 = r105.getUriPattern();
        if (r107 != null) goto L12;
        int r108 = 0;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = r105.getAction();
        if (r110 != null) goto L16;
        int r111 = 0;
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = r105.getMimeType();
        if (r113 != null) goto L20;
        int r114 = 0;
    L21:
        r103 = r112 + r114;
        goto L8
    L20:
        r114 = r113.hashCode();
        goto L21
    L16:
        r111 = r110.hashCode();
        goto L17
    L12:
        r108 = r107.hashCode();
        goto L13
    L22:
        Iterator r115 = SparseArrayKt.valueIterator(this.actions);
    L24:
        if (r115.hasNext() == false) goto L43;
        NavAction r116 = (NavAction) r115.next();
        int r117 = ((r103 * 31) + r116.getDestinationId()) * 31;
        NavOptions r118 = r116.getNavOptions();
        if (r118 != null) goto L28;
        int r119 = 0;
    L29:
        r103 = r117 + r119;
        Bundle r120 = r116.getDefaultArguments();
        if (r120 == null) goto L24;
        Set<String> r121 = r120.keySet();
        if (r121 == null) goto L24;
        Iterator<T> r122 = r121.iterator();
    L37:
        if (r122.hasNext() == false) goto L24;
        String r123 = (String) r122.next();
        int r124 = r103 * 31;
        Bundle r125 = r116.getDefaultArguments();
        Intrinsics.checkNotNull(r125);
        Object r126 = r125.get(r123);
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        r103 = r124 + r127;
        goto L37
    L41:
        r127 = r126.hashCode();
        goto L42
    L28:
        r119 = r118.hashCode();
        goto L29
    L43:
        Iterator<T> r128 = getArguments().keySet().iterator();
    L45:
        if (r128.hasNext() == false) goto L51;
        String r129 = (String) r128.next();
        int r130 = ((r103 * 31) + r129.hashCode()) * 31;
        NavArgument r131 = getArguments().get(r129);
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        r103 = r130 + r132;
        goto L45
    L49:
        r132 = r131.hashCode();
        goto L50
    L51:
        return r103;
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(getClass().getSimpleName());
        r100.append("(");
        String r101 = this.idName;
        if (r101 != null) goto L5;
        r100.append("0x");
        r100.append(Integer.toHexString(this.f15584id));
    L6:
        r100.append(")");
        String r102 = this.route;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        r100.append(" route=");
        r100.append(this.route);
    L16:
        if (this.label == null) goto L19;
        r100.append(" label=");
        r100.append(this.label);
    L19:
        return r100.toString();
    L9:
        if (StringsKt.isBlank(r102) == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r100.append(r101);
        goto L6
    }

    public static final /* synthetic */ Map access$getClasses$cp() {
        return classes;
    }

    public final int getId() {
        return this.f15584id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final String getRoute() {
        return this.route;
    }

    public NavDestination(String r100) {
        Intrinsics.checkNotNullParameter(r100, "navigatorName");
        this.navigatorName = r100;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat();
        this._arguments = new LinkedHashMap();
    }

    public final void addDeepLink(NavDeepLink r100) {
        Intrinsics.checkNotNullParameter(r100, "navDeepLink");
        Map<String, NavArgument> r101 = getArguments();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, NavArgument>> r103 = r101.entrySet().iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, NavArgument> r105 = r103.next();
        NavArgument r106 = r105.getValue();
        if (r106.isNullable() == false) goto L8;
    L10:
        r104 = false;
    L11:
        if (r104 == false) goto L3;
        r102.put(r105.getKey(), r105.getValue());
        goto L3
    L8:
        if (r106.isDefaultValuePresent() == true) goto L10;
    L13:
        Set r107 = r102.keySet();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L15:
        if (r109.hasNext() == false) goto L20;
        Object r110 = r109.next();
        if ((!r100.getArgumentsNames$navigation_common_release().contains((String) r110)) == false) goto L15;
        r108.add(r110);
        goto L15
    L20:
        if (r108.isEmpty() == false) goto L24;
        this.deepLinks.add(r100);
        return;
    L24:
        throw new IllegalArgumentException(("Deep link " + r100.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + r108).toString());
    }

    public final Bundle addInDefaultArgs(Bundle r100) {
        if (r100 != null) goto L13;
        Map<String, NavArgument> r101 = this._arguments;
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L6:
        if (r101.isEmpty() == true) goto L9;
        r102 = false;
    L13:
        Bundle r103 = new Bundle();
        Iterator<Map.Entry<String, NavArgument>> r104 = this._arguments.entrySet().iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, NavArgument> r105 = r104.next();
        r105.getValue().putDefaultValue(r105.getKey(), r103);
        goto L15
    L17:
        if (r100 == null) goto L26;
        r103.putAll(r100);
        Iterator<Map.Entry<String, NavArgument>> r106 = this._arguments.entrySet().iterator();
    L20:
        if (r106.hasNext() == false) goto L26;
        Map.Entry<String, NavArgument> r107 = r106.next();
        String r108 = r107.getKey();
        NavArgument r109 = r107.getValue();
        if (r109.verify(r108, r103) == true) goto L20;
        throw new IllegalArgumentException(("Wrong argument type for '" + r108 + "' in argument bundle. " + r109.getType().getName() + " expected.").toString());
    L26:
        return r103;
    }

    public final int[] buildDeepLinkIds(NavDestination r100) {
        ArrayDeque r101 = new ArrayDeque();
        NavDestination r102 = this;
    L3:
        Intrinsics.checkNotNull(r102);
        NavGraph r103 = r102.parent;
        if (r100 != null) goto L6;
        NavGraph r104 = null;
    L7:
        if (r104 == null) goto L11;
        NavGraph r105 = r100.parent;
        Intrinsics.checkNotNull(r105);
        if (r105.findNode(r102.f15584id) != r102) goto L11;
        r101.addFirst(r102);
    L19:
        List r106 = CollectionsKt.toList(r101);
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L21:
        if (r108.hasNext() == false) goto L24;
        r107.add(Integer.valueOf(((NavDestination) r108.next()).getId()));
        goto L21
    L24:
        return CollectionsKt.toIntArray(r107);
    L11:
        if (r103 != null) goto L13;
    L14:
        r101.addFirst(r102);
    L16:
        if (Intrinsics.areEqual(r103, r100) == true) goto L19;
        if (r103 == null) goto L19;
        r102 = r103;
        goto L3
    L13:
        if (r103.getStartDestinationId() == r102.f15584id) goto L16;
    L6:
        r104 = r100.parent;
        goto L7
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof NavDestination) == false) goto L92;
        NavDestination r101 = (NavDestination) r100;
        if (CollectionsKt.intersect(this.deepLinks, r101.deepLinks).size() != this.deepLinks.size()) goto L10;
        boolean r102 = true;
    L12:
        if (this.actions.size() != r101.actions.size()) goto L30;
        Iterator r103 = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.actions)).iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        NavAction r104 = (NavAction) r103.next();
        if (r101.actions.containsValue(r104) == true) goto L15;
        boolean r105 = false;
    L20:
        if (r105 == false) goto L30;
        Iterator r106 = SequencesKt.asSequence(SparseArrayKt.valueIterator(r101.actions)).iterator();
    L23:
        if (r106.hasNext() == false) goto L27;
        NavAction r107 = (NavAction) r106.next();
        if (this.actions.containsValue(r107) == true) goto L23;
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        boolean r109 = true;
    L32:
        if (getArguments().size() != r101.getArguments().size()) goto L60;
        Iterator r110 = MapsKt.asSequence(getArguments()).iterator();
    L35:
        if (r110.hasNext() == false) goto L44;
        Map.Entry r111 = (Map.Entry) r110.next();
        if (r101.getArguments().containsKey(r111.getKey()) == true) goto L39;
    L41:
        boolean r112 = false;
    L42:
        if (r112 == true) goto L35;
        boolean r113 = false;
    L45:
        if (r113 == false) goto L60;
        Iterator r114 = MapsKt.asSequence(r101.getArguments()).iterator();
    L48:
        if (r114.hasNext() == false) goto L57;
        Map.Entry r115 = (Map.Entry) r114.next();
        if (getArguments().containsKey(r115.getKey()) == true) goto L52;
    L54:
        boolean r116 = false;
    L55:
        if (r116 == true) goto L48;
        boolean r117 = false;
    L58:
        if (r117 == false) goto L60;
        boolean r118 = true;
    L62:
        if (this.f15584id == r101.f15584id) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.route, r101.route) == false) goto L88;
        if (r102 == false) goto L89;
        if (r109 == false) goto L90;
        if (r118 == false) goto L91;
        return true;
    L91:
        return false;
    L90:
        return false;
    L89:
        return false;
    L88:
        return false;
    L52:
        if (Intrinsics.areEqual(getArguments().get(r115.getKey()), r115.getValue()) == false) goto L54;
        r116 = true;
        goto L55
    L57:
        r117 = true;
        goto L58
    L39:
        if (Intrinsics.areEqual(r101.getArguments().get(r111.getKey()), r111.getValue()) == false) goto L41;
        r112 = true;
        goto L42
    L44:
        r113 = true;
    L60:
        r118 = false;
        goto L62
    L27:
        r108 = true;
        goto L28
    L19:
        r105 = true;
    L30:
        r109 = false;
        goto L32
    L10:
        r102 = false;
        goto L12
    L92:
        return false;
    }

    public final NavAction getAction(int r100) {
        if (this.actions.isEmpty() == false) goto L5;
        NavAction r101 = null;
    L6:
        if (r101 != null) goto L12;
        NavGraph r102 = this.parent;
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.getAction(r100);
    L12:
        return r101;
    L5:
        r101 = this.actions.get(r100);
        goto L6
    }

    public boolean hasDeepLink(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(r100, null, null));
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest r110) {
        Intrinsics.checkNotNullParameter(r110, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<NavDeepLink> r100 = this.deepLinks.iterator();
        DeepLinkMatch r101 = null;
    L7:
        if (r100.hasNext() == false) goto L30;
        NavDeepLink r102 = r100.next();
        Uri r103 = r110.getUri();
        if (r103 == null) goto L11;
        Bundle r104 = r102.getMatchingArguments(r103, getArguments());
    L12:
        String r105 = r110.getAction();
        if (r105 != null) goto L15;
    L17:
        boolean r106 = false;
    L18:
        String r107 = r110.getMimeType();
        if (r107 == null) goto L21;
        int r111 = r102.getMimeTypeMatchRating(r107);
    L22:
        if (r104 != null) goto L25;
        if (r106 == true) goto L25;
        if (r111 <= (-1)) goto L7;
    L25:
        DeepLinkMatch r108 = new DeepLinkMatch(this, r104, r102.isExactDeepLink(), r106, r111);
        if (r101 == null) goto L29;
        if (r108.compareTo2(r101) <= 0) goto L7;
    L29:
        r101 = r108;
        goto L7
    L21:
        r111 = -1;
        goto L22
    L15:
        if (Intrinsics.areEqual(r105, r102.getAction()) == false) goto L17;
        r106 = true;
        goto L18
    L11:
        r104 = null;
        goto L12
    L30:
        return r101;
    }

    public final void removeAction(int r100) {
        this.actions.remove(r100);
    }

    public final void removeArgument(String r100) {
        Intrinsics.checkNotNullParameter(r100, "argumentName");
        this._arguments.remove(r100);
    }

    public final void setId(int r100) {
        this.f15584id = r100;
        this.idName = null;
    }

    public final void setLabel(CharSequence r100) {
        this.label = r100;
    }

    public final void setParent(NavGraph r100) {
        this.parent = r100;
    }

    public final void setRoute(String r100) {
        if (r100 != null) goto L5;
        setId(0);
    L7:
        List<NavDeepLink> r101 = this.deepLinks;
        List<NavDeepLink> r102 = r101;
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((NavDeepLink) r104).getUriPattern(), Companion.createRoute(this.route)) == false) goto L9;
    L14:
        r102.remove(r104);
        this.route = r100;
        return;
    L13:
        r104 = null;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L17;
        String r105 = Companion.createRoute(r100);
        setId(r105.hashCode());
        addDeepLink(r105);
        goto L7
    L17:
        throw new IllegalArgumentException("Cannot have an empty route".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> r100) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(r100.getClass()));
    }

    public final void addDeepLink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(r100).build());
    }

    public boolean hasDeepLink(NavDeepLinkRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "deepLinkRequest");
        if (matchDeepLink(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void addArgument(String r100, NavArgument r101) {
        Intrinsics.checkNotNullParameter(r100, "argumentName");
        Intrinsics.checkNotNullParameter(r101, "argument");
        this._arguments.put(r100, r101);
    }

    public void onInflate(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        TypedArray r102 = r100.getResources().obtainAttributes(r101, new int[]{R.attr.label, R.attr.id, com.larus.nova.R.attr.route});
        setRoute(r102.getString(2));
        if (r102.hasValue(1) == false) goto L5;
        setId(r102.getResourceId(1, 0));
        this.idName = Companion.getDisplayName(r100, getId());
    L5:
        setLabel(r102.getText(0));
        Unit r103 = Unit.INSTANCE;
        r102.recycle();
    }

    public final void putAction(int r100, NavAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (supportsActions() == false) goto L13;
        if (r100 == 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L11;
        this.actions.put(r100, r101);
        return;
    L11:
        throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
    L6:
        r102 = false;
        goto L7
    L13:
        throw new UnsupportedOperationException("Cannot add action " + r100 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void putAction(int r100, int r101) {
        putAction(r100, new NavAction(r101, null, null, 6, null));
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination r100, NavDestination r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.buildDeepLinkIds(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }
}
