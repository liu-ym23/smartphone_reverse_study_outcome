package androidx.navigation.ui;

import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.navigation.NavGraph;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\n\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"AppBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "topLevelMenu", "Landroid/view/Menu;", "drawerLayout", "Landroidx/customview/widget/Openable;", "fallbackOnNavigateUpListener", "Lkotlin/Function0;", "", "navGraph", "Landroidx/navigation/NavGraph;", "topLevelDestinationIds", "", "", "navigation-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AppBarConfigurationKt {

    /* JADX INFO: renamed from: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    public static final AppBarConfiguration AppBarConfiguration(Menu r100, Openable r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "topLevelMenu");
        Intrinsics.checkNotNullParameter(r102, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r100).setOpenableLayout(r101).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r102)).build();
    }

    public static final AppBarConfiguration AppBarConfiguration(Set<Integer> r100, Openable r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "topLevelDestinationIds");
        Intrinsics.checkNotNullParameter(r102, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r100).setOpenableLayout(r101).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r102)).build();
    }

    public static final AppBarConfiguration AppBarConfiguration(NavGraph r100, Openable r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "navGraph");
        Intrinsics.checkNotNullParameter(r102, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r100).setOpenableLayout(r101).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r102)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu r100, Openable r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = AnonymousClass2.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter(r100, "topLevelMenu");
        Intrinsics.checkNotNullParameter(r102, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r100).setOpenableLayout(r101).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r102)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set r100, Openable r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = AnonymousClass3.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter(r100, "topLevelDestinationIds");
        Intrinsics.checkNotNullParameter(r102, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r100).setOpenableLayout(r101).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r102)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph r100, Openable r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = AnonymousClass1.INSTANCE;
    L8:
        Intrinsics.checkNotNullParameter(r100, "navGraph");
        Intrinsics.checkNotNullParameter(r102, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(r100).setOpenableLayout(r101).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(r102)).build();
    }
}
