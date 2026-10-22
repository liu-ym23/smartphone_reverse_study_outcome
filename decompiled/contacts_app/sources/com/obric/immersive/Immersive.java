package com.obric.immersive;

import android.R;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Immersive.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u000256B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0007J\u0018\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u0013H\u0016J\u0006\u00103\u001a\u000204R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u0004\u0018\u00010!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8F¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u001a\u0010(\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000f¨\u00067"}, d2 = {"Lcom/obric/immersive/Immersive;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "_navigationBarHeight", "Landroidx/lifecycle/MutableLiveData;", "", "_statusBarHeight", "getActivity", "()Landroid/app/Activity;", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "callback", "Lcom/obric/immersive/ImmersiveCallback;", "currInsets", "Landroidx/core/view/WindowInsetsCompat;", "decorFitsSystemWindow", "", "getDecorFitsSystemWindow", "()Z", "setDecorFitsSystemWindow", "(Z)V", "isLightStatusBar", "setLightStatusBar", "navigationBarHeight", "Landroidx/lifecycle/LiveData;", "getNavigationBarHeight", "()Landroidx/lifecycle/LiveData;", "rootContent", "Landroid/view/View;", "getRootContent", "()Landroid/view/View;", "rootContent$delegate", "Lkotlin/Lazy;", "statusBarHeight", "getStatusBarHeight", "systemBarColor", "getSystemBarColor", "setSystemBarColor", "typeMask", "getTypeMask", "setTypeMask", "isVisible", "type", "onApplyWindowInsets", BaseSwitches.V, "insets", "setup", "", "Companion", "DummyLiveData", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Immersive implements OnApplyWindowInsetsListener {
    public static final Companion Companion = null;
    private static final Immersive DEFAULT = null;
    private static final DummyLiveData DUMMY_DATA = null;
    private final MutableLiveData<Integer> _navigationBarHeight;
    private final MutableLiveData<Integer> _statusBarHeight;
    private final Activity activity;
    private int backgroundColor;
    private final ImmersiveCallback callback;
    private WindowInsetsCompat currInsets;
    private boolean decorFitsSystemWindow;
    private boolean isLightStatusBar;
    private final Lazy rootContent$delegate;
    private int systemBarColor;
    private int typeMask;

    /* JADX INFO: compiled from: Immersive.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/immersive/Immersive$Companion;", "", "()V", "DEFAULT", "Lcom/obric/immersive/Immersive;", "DUMMY_DATA", "Lcom/obric/immersive/Immersive$DummyLiveData;", "getImmersive", "activity", "Landroid/app/Activity;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Immersive getImmersive(Activity r1) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            if ((r1 instanceof ImmersiveCallback) == false) goto L5;
            ImmersiveCallback r2 = (ImmersiveCallback) r1;
        L6:
            if (r2 == null) goto L10;
            Immersive r0 = r2.getImmersive();
            if (r0 == null) goto L10;
            return r0;
        L10:
            return Immersive.access$getDEFAULT$cp();
        L5:
            r2 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: Immersive.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/immersive/Immersive$DummyLiveData;", "Landroidx/lifecycle/LiveData;", "", "()V", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeForever", "removeObserver", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DummyLiveData extends LiveData<Integer> {
        @Override // androidx.lifecycle.LiveData
        public void observe(LifecycleOwner r1, Observer<? super Integer> r2) {
            Intrinsics.checkNotNullParameter(r1, "owner");
            Intrinsics.checkNotNullParameter(r2, "observer");
        }

        @Override // androidx.lifecycle.LiveData
        public void observeForever(Observer<? super Integer> r1) {
            Intrinsics.checkNotNullParameter(r1, "observer");
        }

        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer<? super Integer> r1) {
            Intrinsics.checkNotNullParameter(r1, "observer");
        }

        public DummyLiveData() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Immersive(Activity r3) {
        this.activity = r3;
        this.isLightStatusBar = true;
        this.typeMask = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
        if ((r3 instanceof ImmersiveCallback) == false) goto L5;
        ImmersiveCallback r4 = (ImmersiveCallback) r3;
    L6:
        this.callback = r4;
        this._statusBarHeight = new MutableLiveData();
        this._navigationBarHeight = new MutableLiveData();
        this.rootContent$delegate = LazyKt.lazy(new Immersive$rootContent$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ Immersive access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final boolean getDecorFitsSystemWindow() {
        return this.decorFitsSystemWindow;
    }

    public final void setDecorFitsSystemWindow(boolean r1) {
        this.decorFitsSystemWindow = r1;
    }

    public final int getSystemBarColor() {
        return this.systemBarColor;
    }

    public final void setSystemBarColor(int r1) {
        this.systemBarColor = r1;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int r1) {
        this.backgroundColor = r1;
    }

    public final boolean isLightStatusBar() {
        return this.isLightStatusBar;
    }

    public final void setLightStatusBar(boolean r1) {
        this.isLightStatusBar = r1;
    }

    public final int getTypeMask() {
        return this.typeMask;
    }

    public final void setTypeMask(int r1) {
        this.typeMask = r1;
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new Immersive(null);
        DUMMY_DATA = new DummyLiveData();
    }

    public final LiveData<Integer> getStatusBarHeight() {
        if (this.activity != null) goto L5;
        LiveData<Integer> r1 = DUMMY_DATA;
    L7:
        return r1;
    L5:
        r1 = this._statusBarHeight;
        goto L7
    }

    public final LiveData<Integer> getNavigationBarHeight() {
        if (this.activity != null) goto L5;
        LiveData<Integer> r1 = DUMMY_DATA;
    L7:
        return r1;
    L5:
        r1 = this._navigationBarHeight;
        goto L7
    }

    public final View getRootContent() {
        return (View) this.rootContent$delegate.getValue();
    }

    public final void setup() {
        Activity r0 = this.activity;
        if (r0 != null) goto L5;
        return;
    L5:
        Window r1 = r0.getWindow();
        if ((this.activity.getResources().getConfiguration().uiMode & 48) == 32) goto L8;
        boolean r2 = true;
    L9:
        this.isLightStatusBar = r2;
        if (this.decorFitsSystemWindow == true) goto L12;
        WindowCompat.setDecorFitsSystemWindows(r1, false);
    L12:
        r1.addFlags(Integer.MIN_VALUE);
        r1.setNavigationBarContrastEnforced(false);
        int r3 = this.systemBarColor;
        if (r3 == 0) goto L15;
        r1.setStatusBarColor(r3);
        r1.setNavigationBarColor(this.systemBarColor);
    L17:
        if (this.backgroundColor == 0) goto L19;
        r1.setBackgroundDrawable(new ColorDrawable(this.backgroundColor));
        r1.getDecorView().setBackgroundColor(this.backgroundColor);
    L19:
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(r1, r1.getDecorView());
        Intrinsics.checkNotNullExpressionValue(r4, "getInsetsController(this, decorView)");
        r4.setAppearanceLightStatusBars(this.isLightStatusBar);
        r4.setAppearanceLightNavigationBars(this.isLightStatusBar);
        if (this.decorFitsSystemWindow == true) goto L25;
        View r5 = this.activity.findViewById(R.id.content);
        if (r5 == null) goto L26;
        ViewCompat.setOnApplyWindowInsetsListener(r5, this);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r1.setStatusBarColor(0);
        r1.setNavigationBarColor(0);
        goto L17
    L8:
        r2 = false;
        goto L9
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
        Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r4, "insets");
        this.currInsets = r4;
        Insets r5 = r4.getInsets(this.typeMask);
        Integer r0 = this._statusBarHeight.getValue();
        int r1 = r5.top;
        if (r0 != null) goto L6;
    L7:
        ImmersiveCallback r2 = this.callback;
        if (r2 == null) goto L10;
        r2.onStatusBarHeightChanged(r5.top);
    L10:
        this._statusBarHeight.setValue(Integer.valueOf(r5.top));
    L11:
        Integer r6 = this._navigationBarHeight.getValue();
        int r7 = r5.bottom;
        if (r6 != null) goto L15;
    L16:
        ImmersiveCallback r8 = this.callback;
        if (r8 == null) goto L19;
        r8.onNavigationBarHeightChanged(r5.bottom);
    L19:
        this._navigationBarHeight.setValue(Integer.valueOf(r5.bottom));
    L20:
        this.currInsets = null;
        return r4;
    L15:
        if (r6.intValue() == r7) goto L20;
    L6:
        if (r0.intValue() == r1) goto L11;
        goto L7
    }

    public final boolean isVisible(int r1) {
        WindowInsetsCompat r0 = this.currInsets;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVisible(r1);
    }
}
