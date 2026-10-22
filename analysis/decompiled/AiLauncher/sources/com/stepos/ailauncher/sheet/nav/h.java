package com.stepos.ailauncher.sheet.nav;

import Y8.t;
import Z8.C1165m;
import Z8.Y;
import android.os.Bundle;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.W;
import androidx.core.view.D;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.K;
import androidx.fragment.app.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\r*\u0001[\u0018\u0000 d2\u00020\u0001:\u0002efB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"JE\u0010(\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0010¢\u0006\u0004\b*\u0010\u0019J\u001f\u0010,\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010+\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0010¢\u0006\u0004\b.\u0010\u0019J\u0017\u0010/\u001a\u0004\u0018\u00010\u00142\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\r2\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0015\u00107\u001a\u00020\r2\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\r2\u0006\u00109\u001a\u000205¢\u0006\u0004\b:\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010;R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR2\u0010F\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010E8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\b<\u0010PR\u0016\u0010Q\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020&0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010RR\u0016\u0010W\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010RR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0013\u0010`\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0011\u0010c\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006g"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/h;", "", "Landroidx/fragment/app/r;", "activity", "", "containerId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/r;ILandroidx/fragment/app/FragmentManager;)V", "", "Landroid/view/View;", "keep", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/Set;)V", "", "visible", "q", "(Z)V", "Landroidx/fragment/app/Fragment;", "f", "z", "(Landroidx/fragment/app/Fragment;)Z", "p", "()Z", "Landroidx/lifecycle/LifecycleOwner;", "owner", "n", "(Landroidx/lifecycle/LifecycleOwner;)V", "fragment", "", "tag", "L", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/os/Bundle;", "args", "name", "Lcom/stepos/ailauncher/sheet/nav/b;", "anim", "F", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/nav/b;)V", "B", "inclusive", "D", "(Ljava/lang/String;Z)Z", ExifInterface.LONGITUDE_EAST, "u", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "t", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "", "fraction", "s", "(F)V", "progress", "r", "Landroidx/fragment/app/r;", "I", "Landroidx/fragment/app/FragmentManager;", "Lcom/stepos/ailauncher/sheet/nav/h$b;", "listener", "Lcom/stepos/ailauncher/sheet/nav/h$b;", "x", "()Lcom/stepos/ailauncher/sheet/nav/h$b;", "J", "(Lcom/stepos/ailauncher/sheet/nav/h$b;)V", "Lkotlin/Function1;", "onTopPageChanged", "Lp9/l;", "y", "()Lp9/l;", "K", "(Lp9/l;)V", "defaultAnim", "Lcom/stepos/ailauncher/sheet/nav/b;", "getDefaultAnim", "()Lcom/stepos/ailauncher/sheet/nav/b;", "(Lcom/stepos/ailauncher/sheet/nav/b;)V", "lifecycleAttached", "Z", "LZ8/m;", "pushAnimStack", "LZ8/m;", "popAnimating", "pushAnimating", "Ljava/lang/Runnable;", "pushGuardFallback", "Ljava/lang/Runnable;", "com/stepos/ailauncher/sheet/nav/h$d", "fragmentLifecycleCallbacks", "Lcom/stepos/ailauncher/sheet/nav/h$d;", "w", "()Landroidx/fragment/app/Fragment;", "current", "v", "()I", "backStackEntryCount", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    public static final String DEFAULT_ROOT_TAG = "sheet_root";
    private static final long PUSH_GUARD_FALLBACK_MS = 800;
    private final r activity;
    private final int containerId;
    private SheetFragmentAnim defaultAnim;
    private final d fragmentLifecycleCallbacks;
    private final FragmentManager fragmentManager;
    private boolean lifecycleAttached;
    private b listener;
    private InterfaceC5074l<? super Fragment, t> onTopPageChanged;
    private boolean popAnimating;
    private final C1165m<SheetFragmentAnim> pushAnimStack;
    private boolean pushAnimating;
    private Runnable pushGuardFallback;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/h$b;", "", "", "entryCount", "Landroidx/fragment/app/Fragment;", "current", "LY8/t;", "c", "(ILandroidx/fragment/app/Fragment;)V", "fragment", Const.INTENT_KEY_UMID, "(Landroidx/fragment/app/Fragment;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        default void a(Fragment fragment) {
            kotlin.jvm.internal.p.i(fragment, "fragment");
        }

        default void b(Fragment fragment) {
            kotlin.jvm.internal.p.i(fragment, "fragment");
        }

        default void c(int entryCount, Fragment current) {
        }

        default void d(Fragment fragment) {
            kotlin.jvm.internal.p.i(fragment, "fragment");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sheet/nav/h$c", "Landroidx/lifecycle/e;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "LY8/t;", UxipConstants.f30640D, "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "onDestroy", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC1387e {
        public c() {
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
            super.b(lifecycleOwner);
        }

        @Override // android.view.InterfaceC1387e
        public void onDestroy(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            h.this.fragmentManager.C1(h.this.fragmentLifecycleCallbacks);
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
            super.onPause(lifecycleOwner);
        }

        @Override // android.view.InterfaceC1387e
        public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
            super.onResume(lifecycleOwner);
        }

        @Override // android.view.InterfaceC1387e
        public void onStart(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            h.this.q(true);
        }

        @Override // android.view.InterfaceC1387e
        public void onStop(LifecycleOwner owner) {
            kotlin.jvm.internal.p.i(owner, "owner");
            h.this.q(false);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"com/stepos/ailauncher/sheet/nav/h$d", "Landroidx/fragment/app/FragmentManager$k;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;)V", "n", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends FragmentManager.k {
        public d() {
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public void f(FragmentManager fm, Fragment f10) {
            b listener;
            kotlin.jvm.internal.p.i(fm, "fm");
            kotlin.jvm.internal.p.i(f10, "f");
            if (h.this.z(f10) && (listener = h.this.getListener()) != null) {
                listener.a(f10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.fragment.app.FragmentManager.k
        public void i(FragmentManager fm, Fragment f10) {
            kotlin.jvm.internal.p.i(fm, "fm");
            kotlin.jvm.internal.p.i(f10, "f");
            if (h.this.z(f10) && !f10.isHidden()) {
                b listener = h.this.getListener();
                if (listener != null) {
                    listener.d(f10);
                }
                InterfaceC5074l<Fragment, t> interfaceC5074lY = h.this.y();
                if (interfaceC5074lY != null) {
                    interfaceC5074lY.invoke(f10);
                }
                if (f10 instanceof com.stepos.ailauncher.sheet.nav.d) {
                    ((com.stepos.ailauncher.sheet.nav.d) f10).g(h.this.activity.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED));
                }
            }
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public void n(FragmentManager fm, Fragment f10) {
            b listener;
            kotlin.jvm.internal.p.i(fm, "fm");
            kotlin.jvm.internal.p.i(f10, "f");
            if (h.this.z(f10) && (listener = h.this.getListener()) != null) {
                listener.b(f10);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC5074l<View, t> {
        public static final e INSTANCE = new e();

        public final void a(View old) {
            kotlin.jvm.internal.p.i(old, "old");
            old.setVisibility(8);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(View view) {
            a(view);
            return t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class f implements InterfaceC5063a<t> {
        final /* synthetic */ View $decor;
        final /* synthetic */ Runnable $fallback;
        final /* synthetic */ h this$0;

        public f(View view, Runnable runnable, h hVar) {
            this.$decor = view;
            this.$fallback = runnable;
            this.this$0 = hVar;
        }

        public final void a() {
            this.$decor.removeCallbacks(this.$fallback);
            if (this.this$0.pushGuardFallback == this.$fallback) {
                this.this$0.pushGuardFallback = null;
            }
            this.this$0.pushAnimating = false;
        }

        @Override // p9.InterfaceC5063a
        public /* bridge */ /* synthetic */ t invoke() {
            a();
            return t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class g implements Runnable {
        final /* synthetic */ View $decor$inlined;
        final /* synthetic */ Runnable $fallback$inlined;
        final /* synthetic */ View $oldView$inlined;
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ h this$0;

        public g(View view, h hVar, View view2, Runnable runnable, View view3) {
            this.$this_doOnPreDraw = view;
            this.this$0 = hVar;
            this.$decor$inlined = view2;
            this.$fallback$inlined = runnable;
            this.$oldView$inlined = view3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this.$this_doOnPreDraw;
            if (!this.this$0.popAnimating) {
                this.this$0.A(Y.l(this.$oldView$inlined, view));
                p.INSTANCE.n(this.$oldView$inlined, view, view.getWidth(), e.INSTANCE, new f(this.$decor$inlined, this.$fallback$inlined, this.this$0));
            } else {
                this.$decor$inlined.removeCallbacks(this.$fallback$inlined);
                if (this.this$0.pushGuardFallback == this.$fallback$inlined) {
                    this.this$0.pushGuardFallback = null;
                }
                this.this$0.pushAnimating = false;
            }
        }
    }

    public h(r activity, int i10, FragmentManager fragmentManager) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(fragmentManager, "fragmentManager");
        this.activity = activity;
        this.containerId = i10;
        this.fragmentManager = fragmentManager;
        this.defaultAnim = com.stepos.ailauncher.sheet.nav.c.INSTANCE.a();
        this.pushAnimStack = new C1165m<>();
        this.fragmentLifecycleCallbacks = new d();
    }

    public static final t C(h hVar) {
        hVar.popAnimating = false;
        if (!hVar.fragmentManager.U0()) {
            hVar.fragmentManager.d1();
        }
        return t.f7040a;
    }

    public static /* synthetic */ void G(h hVar, Fragment fragment, String str, Bundle bundle, String str2, SheetFragmentAnim sheetFragmentAnim, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            bundle = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            sheetFragmentAnim = null;
        }
        hVar.F(fragment, str, bundle, str2, sheetFragmentAnim);
    }

    public static final void H(h hVar) {
        hVar.pushAnimating = false;
    }

    public static final void o(h hVar, LifecycleOwner lifecycleOwner) {
        while (hVar.pushAnimStack.size() > hVar.v()) {
            hVar.pushAnimStack.removeLast();
        }
        b bVar = hVar.listener;
        if (bVar != null) {
            bVar.c(hVar.v(), hVar.w());
        }
        InterfaceC5074l<? super Fragment, t> interfaceC5074l = hVar.onTopPageChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(hVar.w());
        }
        hVar.q(lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED));
    }

    public final void A(Set<? extends View> keep) {
        View view;
        List<Fragment> listZ0 = this.fragmentManager.z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        for (Fragment fragment : listZ0) {
            if (fragment.isAdded() && fragment.getId() == this.containerId && fragment.isHidden() && (view = fragment.getView()) != null && !keep.contains(view)) {
                view.setTranslationX(0.0f);
                view.setVisibility(8);
            }
        }
    }

    public final boolean B() {
        Fragment fragmentPrevious;
        if (!p() || this.fragmentManager.U0()) {
            return false;
        }
        if (this.popAnimating) {
            return true;
        }
        SheetFragmentAnim sheetFragmentAnimL = this.pushAnimStack.l();
        if (sheetFragmentAnimL == null) {
            sheetFragmentAnimL = this.defaultAnim;
        }
        if (kotlin.jvm.internal.p.d(sheetFragmentAnimL, com.stepos.ailauncher.sheet.nav.c.INSTANCE.b())) {
            Fragment fragmentW = w();
            View view = fragmentW != null ? fragmentW.getView() : null;
            List<Fragment> listZ0 = this.fragmentManager.z0();
            kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
            ListIterator<Fragment> listIterator = listZ0.listIterator(listZ0.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    fragmentPrevious = null;
                    break;
                }
                fragmentPrevious = listIterator.previous();
                Fragment fragment = fragmentPrevious;
                if (fragment.isAdded() && fragment.isHidden() && fragment.getId() == this.containerId) {
                    break;
                }
            }
            Fragment fragment2 = fragmentPrevious;
            View view2 = fragment2 != null ? fragment2.getView() : null;
            if (view != null && view2 != null) {
                this.popAnimating = true;
                p.INSTANCE.j(view, view2, view.getWidth(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.e
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return h.C(this.f28173a);
                    }
                });
                return true;
            }
        }
        return this.fragmentManager.d1();
    }

    public final boolean D(String name, boolean inclusive) {
        kotlin.jvm.internal.p.i(name, "name");
        if (this.fragmentManager.U0()) {
            return false;
        }
        return this.fragmentManager.f1(name, inclusive ? 1 : 0);
    }

    public final boolean E() {
        if (!p() || this.fragmentManager.U0()) {
            return false;
        }
        return this.fragmentManager.f1(null, 1);
    }

    public final void F(Fragment fragment, String tag, Bundle args, String name, SheetFragmentAnim anim) {
        View view;
        kotlin.jvm.internal.p.i(fragment, "fragment");
        if (this.fragmentManager.U0() || this.pushAnimating) {
            return;
        }
        if (this.popAnimating) {
            this.popAnimating = false;
            p.INSTANCE.h();
            this.fragmentManager.d1();
            Fragment fragmentW = w();
            if (fragmentW != null && (view = fragmentW.getView()) != null) {
                view.setTranslationX(0.0f);
            }
            A(Y.e());
        }
        if (args != null && fragment.getArguments() == null) {
            fragment.setArguments(args);
        }
        if (tag == null) {
            tag = fragment.getClass().getSimpleName() + "_" + (v() + 1);
        }
        if (name == null) {
            name = tag;
        }
        Fragment fragmentW2 = w();
        if (fragmentW2 == null || !kotlin.jvm.internal.p.d(fragmentW2.getTag(), tag)) {
            if (anim == null) {
                anim = this.defaultAnim;
            }
            boolean zD = kotlin.jvm.internal.p.d(anim, com.stepos.ailauncher.sheet.nav.c.INSTANCE.b());
            View view2 = fragmentW2 != null ? fragmentW2.getView() : null;
            InterfaceC5074l<? super Fragment, t> interfaceC5074l = this.onTopPageChanged;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(fragment);
            }
            K kQ = this.fragmentManager.q();
            kQ.v(true);
            if (!zD) {
                kQ.t(anim.getEnter(), anim.getExit(), anim.getPopEnter(), anim.getPopExit());
            }
            if (fragmentW2 != null) {
                kQ.m(fragmentW2);
            }
            kQ.b(this.containerId, fragment, tag);
            kQ.f(name);
            kQ.g();
            this.pushAnimStack.addLast(anim);
            if (zD) {
                this.pushAnimating = true;
                View decorView = this.activity.getWindow().getDecorView();
                kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
                Runnable runnable = this.pushGuardFallback;
                if (runnable != null) {
                    decorView.removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.sheet.nav.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.H(this.f28174a);
                    }
                };
                this.pushGuardFallback = runnable2;
                decorView.postDelayed(runnable2, 800L);
                this.fragmentManager.h0();
                View view3 = fragment.getView();
                if (view3 != null) {
                    D.a(view3, new g(view3, this, decorView, runnable2, view2));
                }
            }
        }
    }

    public final void I(SheetFragmentAnim sheetFragmentAnim) {
        kotlin.jvm.internal.p.i(sheetFragmentAnim, "<set-?>");
        this.defaultAnim = sheetFragmentAnim;
    }

    public final void J(b bVar) {
        this.listener = bVar;
    }

    public final void K(InterfaceC5074l<? super Fragment, t> interfaceC5074l) {
        this.onTopPageChanged = interfaceC5074l;
    }

    public final void L(Fragment fragment, String tag) {
        kotlin.jvm.internal.p.i(fragment, "fragment");
        kotlin.jvm.internal.p.i(tag, "tag");
        if (this.fragmentManager.U0()) {
            return;
        }
        if (this.fragmentManager.s0() > 0) {
            this.fragmentManager.f1(null, 1);
        }
        K kQ = this.fragmentManager.q();
        kQ.v(true);
        kQ.q(this.containerId, fragment, tag);
        kQ.g();
    }

    public final void n(final LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        if (this.lifecycleAttached) {
            return;
        }
        this.lifecycleAttached = true;
        this.fragmentManager.l1(this.fragmentLifecycleCallbacks, false);
        this.fragmentManager.l(new FragmentManager.l() { // from class: com.stepos.ailauncher.sheet.nav.g
            @Override // androidx.fragment.app.FragmentManager.l
            public final void onBackStackChanged() {
                h.o(this.f28175a, owner);
            }
        });
        owner.getLifecycle().a(new c());
    }

    public final boolean p() {
        return v() > 0;
    }

    public final void q(boolean visible) {
        W w10 = w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        if (dVar != null) {
            dVar.g(visible);
        }
    }

    public final void r(float progress) {
        W w10 = w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        if (dVar != null) {
            dVar.f(progress);
        }
    }

    public final void s(float fraction) {
        W w10 = w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        if (dVar != null) {
            dVar.d(fraction);
        }
    }

    public final void t(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        W w10 = w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        if (dVar != null) {
            dVar.k(state);
        }
    }

    public final Fragment u(String tag) {
        kotlin.jvm.internal.p.i(tag, "tag");
        return this.fragmentManager.l0(tag);
    }

    public final int v() {
        return this.fragmentManager.s0();
    }

    public final Fragment w() {
        Fragment fragmentPrevious;
        List<Fragment> listZ0 = this.fragmentManager.z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        ListIterator<Fragment> listIterator = listZ0.listIterator(listZ0.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                fragmentPrevious = null;
                break;
            }
            fragmentPrevious = listIterator.previous();
            Fragment fragment = fragmentPrevious;
            if (fragment.isAdded() && !fragment.isHidden() && fragment.getId() == this.containerId) {
                break;
            }
        }
        return fragmentPrevious;
    }

    /* renamed from: x, reason: from getter */
    public final b getListener() {
        return this.listener;
    }

    public final InterfaceC5074l<Fragment, t> y() {
        return this.onTopPageChanged;
    }

    public final boolean z(Fragment f10) {
        return !(f10 instanceof DialogInterfaceOnCancelListenerC1374l) && f10.getParentFragment() == null && (f10.getId() == this.containerId || f10.getTag() != null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ h(r rVar, int i10, FragmentManager fragmentManager, int i11, kotlin.jvm.internal.i iVar) {
        if ((i11 & 4) != 0) {
            fragmentManager = rVar.getSupportFragmentManager();
            kotlin.jvm.internal.p.h(fragmentManager, "getSupportFragmentManager(...)");
        }
        this(rVar, i10, fragmentManager);
    }
}
