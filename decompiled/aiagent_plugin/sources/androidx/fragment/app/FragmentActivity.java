package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.f, ActivityCompat.h {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final androidx.lifecycle.r mFragmentLifecycleRegistry;
    final d mFragments;
    boolean mResumed;
    boolean mStopped;

    class a extends e<FragmentActivity> implements androidx.activity.d, androidx.activity.result.d, i, ap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f1725a;

        @Override // androidx.fragment.app.e
        public /* synthetic */ FragmentActivity e() {
            return (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        }

        public a(FragmentActivity r3) {
            FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
            this.f1725a = r4;
            super(r4);
        }

        @Override // androidx.lifecycle.p
        public androidx.lifecycle.i getLifecycle() {
            return this.f1725a.mFragmentLifecycleRegistry;
        }

        @Override // androidx.lifecycle.ap
        public ao getViewModelStore() {
            return this.f1725a.getViewModelStore();
        }

        @Override // androidx.activity.d
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.f1725a.getOnBackPressedDispatcher();
        }

        @Override // androidx.fragment.app.e
        public void a(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
            this.f1725a.dump(r1, r2, r3, r4);
        }

        @Override // androidx.fragment.app.e
        public boolean a(Fragment r1) {
            return !this.f1725a.isFinishing();
        }

        @Override // androidx.fragment.app.e
        public LayoutInflater b() {
            return this.f1725a.getLayoutInflater().cloneInContext(this.f1725a);
        }

        public FragmentActivity c() {
            return this.f1725a;
        }

        @Override // androidx.fragment.app.e
        public void d() {
            this.f1725a.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.e
        public boolean a(String r1) {
            return ActivityCompat.a(this.f1725a, r1);
        }

        @Override // androidx.fragment.app.i
        public void a(FragmentManager r1, Fragment r2) {
            this.f1725a.onAttachFragment(r2);
        }

        @Override // androidx.fragment.app.e, androidx.fragment.app.c
        public View a(int r1) {
            return this.f1725a.findViewById(r1);
        }

        @Override // androidx.fragment.app.e, androidx.fragment.app.c
        public boolean a() {
            Window r0 = this.f1725a.getWindow();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.peekDecorView() == null) goto L7;
            return true;
        }

        @Override // androidx.activity.result.d
        public androidx.activity.result.c getActivityResultRegistry() {
            return this.f1725a.getActivityResultRegistry();
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment r1) {
    }

    @Override // androidx.core.app.ActivityCompat.h
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r1) {
    }

    public FragmentActivity() {
        this.mFragments = d.a(new a(this));
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.r(this);
        this.mStopped = true;
        init();
    }

    public FragmentActivity(int r1) {
        super(r1);
        this.mFragments = d.a(new a(this));
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.r(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().a(FRAGMENTS_TAG, new AnonymousClass1(this));
        addOnContextAvailableListener(new AnonymousClass2(this));
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mFragments.b();
        super.onActivityResult(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportFinishAfterTransition() {
        ActivityCompat.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnterSharedElementCallback(androidx.core.app.q r1) {
        ActivityCompat.a(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setExitSharedElementCallback(androidx.core.app.q r1) {
        ActivityCompat.b(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportPostponeEnterTransition() {
        ActivityCompat.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportStartPostponedEnterTransition() {
        ActivityCompat.d(this);
    }

    @Override // androidx.activity.ComponentActivity
    public void onMultiWindowModeChanged(boolean r1) {
        this.mFragments.a(r1);
    }

    @Override // androidx.activity.ComponentActivity
    public void onPictureInPictureModeChanged(boolean r1) {
        this.mFragments.b(r1);
    }

    @Override // androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration r2) {
        this.mFragments.b();
        super.onConfigurationChanged(r2);
        this.mFragments.a(r2);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.mFragmentLifecycleRegistry.a(androidx.lifecycle.i.a.ON_CREATE);
        this.mFragments.d();
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onCreatePanelMenu(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L7;
        boolean r6 = super.onCreatePanelMenu(r3, r5);
        return this.mFragments.a(r5, getMenuInflater()) | r6;
    L7:
        return super.onCreatePanelMenu(r3, r5);
    }

    public View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        View r0 = dispatchFragmentsOnCreateView(r3, r4, r7, r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r3, r4, r7, r8);
    }

    public View onCreateView(String r3, Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        View r0 = dispatchFragmentsOnCreateView(null, r3, r6, r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r3, r6, r7);
    }

    final View dispatchFragmentsOnCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        return this.mFragments.a(r3, r4, r7, r8);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.a(androidx.lifecycle.i.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.k();
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        if (super.onMenuItemSelected(r3, r5) == false) goto L6;
        return true;
    L6:
        if (r3 == 0) goto L14;
        if (r3 == 6) goto L12;
        return false;
    L12:
        return this.mFragments.b(r5);
    L14:
        return this.mFragments.a(r5);
    }

    @Override // androidx.activity.ComponentActivity
    public void onPanelClosed(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L5;
        this.mFragments.b(r5);
    L5:
        super.onPanelClosed(r3, r5);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.a(androidx.lifecycle.i.a.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity
    public void onNewIntent(Intent r2) {
        this.mFragments.b();
        super.onNewIntent(r2);
    }

    public void onStateNotSaved() {
        this.mFragments.b();
    }

    public void onResume() {
        this.mFragments.b();
        super.onResume();
        this.mResumed = true;
        this.mFragments.l();
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.a(androidx.lifecycle.i.a.ON_RESUME);
        this.mFragments.g();
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onPreparePanel(int r3, View r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L7;
        boolean r7 = onPrepareOptionsPanel(r4, r6);
        return this.mFragments.a(r6) | r7;
    L7:
        return super.onPreparePanel(r3, r4, r6);
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View r3, Menu r4) {
        return super.onPreparePanel(0, r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin"));
    }

    public void onStart() {
        this.mFragments.b();
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        this.mFragments.e();
    L5:
        this.mFragments.l();
        this.mFragmentLifecycleRegistry.a(androidx.lifecycle.i.a.ON_START);
        this.mFragments.f();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.i();
        this.mFragmentLifecycleRegistry.a(androidx.lifecycle.i.a.ON_STOP);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String r5, FileDescriptor r6, PrintWriter r7, String[] r8) {
        super.dump(r5, r6, r7, r8);
        r7.print(r5);
        r7.print("Local FragmentActivity ");
        r7.print(Integer.toHexString(System.identityHashCode(this)));
        r7.println(" State:");
        String r0 = r5 + "  ";
        r7.print(r0);
        r7.print("mCreated=");
        r7.print(this.mCreated);
        r7.print(" mResumed=");
        r7.print(this.mResumed);
        r7.print(" mStopped=");
        r7.print(this.mStopped);
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")) == null) goto L5;
        androidx.loader.a.a.a(this).a(r0, r6, r7, r8);
    L5:
        this.mFragments.a().a(r5, r6, r7, r8);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.a();
    }

    @Deprecated
    public androidx.loader.a.a getSupportLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.f
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        this.mFragments.b();
        super.onRequestPermissionsResult(r2, r3, r4);
    }

    public void startActivityFromFragment(Fragment r2, Intent r3, int r4) {
        startActivityFromFragment(r2, r3, r4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityFromFragment(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (r4 != (-1)) goto L6;
        ActivityCompat.startActivityForResult(this, r3, -1, r5);
        return;
    L6:
        ZeusTransformUtils.startActivityForResult(r2, r3, r4, r5, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void startIntentSenderFromFragment(Fragment r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        if (r12 != (-1)) goto L6;
        ActivityCompat.a(this, r11, r12, r13, r14, r15, r16, r17);
        return;
    L6:
        r10.startIntentSenderForResult(r11, r12, r13, r14, r15, r16, r17);
    }

    void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), androidx.lifecycle.i.b.f2056c) == true) goto L3;
    }

    private static boolean markState(FragmentManager r5, androidx.lifecycle.i.b r6) {
        Iterator<Fragment> r7 = r5.f().iterator();
        boolean r0 = false;
    L4:
        if (r7.hasNext() == false) goto L19;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(r7.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L4;
        if (r1.getHost() == null) goto L12;
        r0 = r0 | markState(r1.getChildFragmentManager(), r6);
    L12:
        if (r1.mViewLifecycleOwner == null) goto L17;
        if (r1.mViewLifecycleOwner.getLifecycle().b().a(androidx.lifecycle.i.b.f2057d) == false) goto L17;
        r1.mViewLifecycleOwner.a(r6);
        r0 = true;
    L17:
        if (r1.mLifecycleRegistry.b().a(androidx.lifecycle.i.b.f2057d) == false) goto L4;
        r1.mLifecycleRegistry.b(r6);
        r0 = true;
        goto L4
    L19:
        return r0;
    }
}
