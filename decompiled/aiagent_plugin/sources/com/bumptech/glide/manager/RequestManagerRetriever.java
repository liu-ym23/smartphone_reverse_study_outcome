package com.bumptech.glide.manager;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final a DEFAULT_FACTORY = null;
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final a factory;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments;
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments;
    private final Bundle tempBundle;
    private final androidx.b.a<View, Fragment> tempViewToFragment;
    private final androidx.b.a<View, androidx.fragment.app.Fragment> tempViewToSupportFragment;

    public interface a {
        RequestManager a(Glide r1, h r2, k r3, Context r4);
    }

    public static /* synthetic */ boolean access$000(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public RequestManagerRetriever(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        this.pendingRequestManagerFragments = new HashMap();
        this.pendingSupportRequestManagerFragments = new HashMap();
        this.tempViewToSupportFragment = new androidx.b.a();
        this.tempViewToFragment = new androidx.b.a();
        this.tempBundle = new Bundle();
        if (r4 != null) goto L6;
        r4 = DEFAULT_FACTORY;
    L6:
        this.factory = r4;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    private RequestManager getApplicationManager(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (this.applicationManager != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.applicationManager != null) goto L8;
        Glide r0 = Glide.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
        this.applicationManager = this.factory.a(r0, new b(), new g(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.applicationManager;
    }

    public RequestManager get(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L25;
        if (com.bumptech.glide.f.k.c() == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r5, Application.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r5, FragmentActivity.class) == false) goto L13;
        return get((FragmentActivity) ZeusTransformUtils.preCheckCast(r5, FragmentActivity.class, "com.obric.aiagent.plugin"));
    L13:
        if (ZeusTransformUtils.instanceOf(r5, Activity.class) == false) goto L17;
        return get((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.aiagent.plugin"));
    L17:
        if (ZeusTransformUtils.instanceOf(r5, ContextWrapper.class) == false) goto L23;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r5, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L23;
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r5, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L23:
        return getApplicationManager(r5);
    L25:
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Activity, android.content.Context, androidx.fragment.app.FragmentActivity] */
    public RequestManager get(FragmentActivity r4) {
        ?? r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.aiagent.plugin");
        if (com.bumptech.glide.f.k.d() == true) goto L5;
        assertNotDestroyed(r5);
        return supportFragmentGet(r5, r5.getSupportFragmentManager(), null, isActivityVisible(r5));
    L5:
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public RequestManager get(androidx.fragment.app.Fragment r5) {
        com.bumptech.glide.f.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.f.k.d() == true) goto L5;
        androidx.fragment.app.FragmentManager r0 = r5.getChildFragmentManager();
        return supportFragmentGet((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r5, r5.isVisible());
    L5:
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public RequestManager get(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        if (com.bumptech.glide.f.k.d() == true) goto L5;
        assertNotDestroyed(r5);
        return fragmentGet(r5, r5.getFragmentManager(), null, isActivityVisible(r5));
    L5:
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public RequestManager get(View r4) {
        if (com.bumptech.glide.f.k.d() == true) goto L5;
        com.bumptech.glide.f.j.a(r4);
        com.bumptech.glide.f.j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "Unable to obtain a request manager for a view without a Context");
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(findActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r0, FragmentActivity.class) == false) goto L17;
        androidx.fragment.app.Fragment r5 = findSupportFragment(r4, (FragmentActivity) ZeusTransformUtils.preCheckCast(r0, FragmentActivity.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L16;
        return get(r5);
    L16:
        return get((FragmentActivity) ZeusTransformUtils.preCheckCast(r0, FragmentActivity.class, "com.obric.aiagent.plugin"));
    L17:
        Fragment r6 = findFragment(r4, r0);
        if (r6 != null) goto L22;
        return get(r0);
    L22:
        return get(r6);
    L5:
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private static void findAllSupportFragmentsWithViews(Collection<androidx.fragment.app.Fragment> r3, Map<View, androidx.fragment.app.Fragment> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) ZeusTransformUtils.preCheckCast(r7.next(), androidx.fragment.app.Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        if (r0.getView() == null) goto L7;
        r6.put(r0.getView(), r0);
        findAllSupportFragmentsWithViews(r0.getChildFragmentManager().f(), r6);
        goto L7
    }

    private androidx.fragment.app.Fragment findSupportFragment(View r5, FragmentActivity r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r6, FragmentActivity.class, "com.obric.aiagent.plugin");
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(r7.getSupportFragmentManager().f(), this.tempViewToSupportFragment);
        View r8 = r7.findViewById(R.id.content);
        androidx.fragment.app.Fragment r0 = null;
    L4:
        if (r5.equals(r8) == true) goto L11;
        r0 = (androidx.fragment.app.Fragment) ZeusTransformUtils.preCheckCast(this.tempViewToSupportFragment.get(r5), androidx.fragment.app.Fragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        if (ZeusTransformUtils.instanceOf(r5.getParent(), View.class) == false) goto L11;
        r5 = (View) ZeusTransformUtils.preCheckCast(r5.getParent(), View.class, "com.obric.aiagent.plugin");
    L11:
        this.tempViewToSupportFragment.clear();
        return r0;
    }

    @Deprecated
    private Fragment findFragment(View r5, Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(r7.getFragmentManager(), this.tempViewToFragment);
        View r8 = r7.findViewById(R.id.content);
        Fragment r0 = null;
    L4:
        if (r5.equals(r8) == true) goto L11;
        r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.tempViewToFragment.get(r5), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        if (ZeusTransformUtils.instanceOf(r5.getParent(), View.class) == false) goto L11;
        r5 = (View) ZeusTransformUtils.preCheckCast(r5.getParent(), View.class, "com.obric.aiagent.plugin");
    L11:
        this.tempViewToFragment.clear();
        return r0;
    }

    @Deprecated
    private void findAllFragmentsWithViews(FragmentManager r4, androidx.b.a<View, Fragment> r5) {
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Iterator<Fragment> r6 = r4.getFragments().iterator();
    L6:
        if (r6.hasNext() == false) goto L17;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r6.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0.getView() == null) goto L6;
        r5.put(r0.getView(), r0);
        findAllFragmentsWithViews(r0.getChildFragmentManager(), r5);
        goto L6
    L17:
        return;
    L10:
        findAllFragmentsWithViewsPreO(r4, r5);
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(FragmentManager r5, androidx.b.a<View, Fragment> r6) {
        int r0 = 0;
    L3:
        int r2 = r0 + 1;
        this.tempBundle.putInt(FRAGMENT_INDEX_KEY, r0);
        Fragment r1 = null;
        r1 = r5.getFragment(this.tempBundle, FRAGMENT_INDEX_KEY);     // Catch: Exception -> L13
    L5:
        if (r1 == null) goto L6;
        if (r1.getView() == null) goto L12;
        r6.put(r1.getView(), r1);
        if (Build.VERSION.SDK_INT < 17) goto L12;
        findAllFragmentsWithViews(r1.getChildFragmentManager(), r6);
    L12:
        r0 = r2;
        goto L3
    }

    private static Activity findActivity(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L7;
        return (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == true) goto L9;
        return null;
    L9:
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(findActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    }

    private static void assertNotDestroyed(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return;
    L5:
        if (r3.isDestroyed() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @Deprecated
    public RequestManager get(Fragment r4) {
        if (ZeusTransformUtils.getActivity(r4, "com.obric.aiagent.plugin") == null) goto L14;
        if (com.bumptech.glide.f.k.d() == true) goto L12;
        if (Build.VERSION.SDK_INT < 17) goto L12;
        FragmentManager r1 = r4.getChildFragmentManager();
        return fragmentGet(ZeusTransformUtils.getActivity(r4, "com.obric.aiagent.plugin"), r1, r4, r4.isVisible());
    L12:
        return get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ZeusTransformUtils.getActivity(r4, "com.obric.aiagent.plugin").getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @Deprecated
    RequestManagerFragment getRequestManagerFragment(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        return getRequestManagerFragment(r4.getFragmentManager(), null, isActivityVisible(r4));
    }

    private RequestManagerFragment getRequestManagerFragment(FragmentManager r5, Fragment r6, boolean r7) {
        RequestManagerFragment r1 = (RequestManagerFragment) ZeusTransformUtils.preCheckCast(r5.findFragmentByTag(FRAGMENT_TAG), RequestManagerFragment.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        r1 = (RequestManagerFragment) ZeusTransformUtils.preCheckCast(this.pendingRequestManagerFragments.get(r5), RequestManagerFragment.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        r1 = new RequestManagerFragment();
        r1.setParentFragmentHint(r6);
        if (r7 == false) goto L9;
        r1.getGlideLifecycle().a();
    L9:
        this.pendingRequestManagerFragments.put(r5, r1);
        r5.beginTransaction().add(r1, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, r5).sendToTarget();
    L10:
        return r1;
    }

    @Deprecated
    private RequestManager fragmentGet(Context r3, FragmentManager r4, Fragment r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        RequestManagerFragment r8 = getRequestManagerFragment(r4, r5, r6);
        RequestManager r9 = r8.getRequestManager();
        if (r9 != null) goto L6;
        Glide r10 = Glide.get(r7);
        RequestManager r11 = this.factory.a(r10, r8.getGlideLifecycle(), r8.getRequestManagerTreeNode(), r7);
        r8.setRequestManager(r11);
        return r11;
    L6:
        return r9;
    }

    SupportRequestManagerFragment getSupportRequestManagerFragment(Context r3, androidx.fragment.app.FragmentManager r4) {
        return getSupportRequestManagerFragment(r4, null, isActivityVisible((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")));
    }

    private static boolean isActivityVisible(Context r2) {
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(findActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isFinishing() == false) goto L8;
        return false;
    }

    private SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager r5, androidx.fragment.app.Fragment r6, boolean r7) {
        SupportRequestManagerFragment r1 = (SupportRequestManagerFragment) ZeusTransformUtils.preCheckCast(r5.b(FRAGMENT_TAG), SupportRequestManagerFragment.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        r1 = (SupportRequestManagerFragment) ZeusTransformUtils.preCheckCast(this.pendingSupportRequestManagerFragments.get(r5), SupportRequestManagerFragment.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        r1 = new SupportRequestManagerFragment();
        r1.setParentFragmentHint(r6);
        if (r7 == false) goto L9;
        r1.getGlideLifecycle().a();
    L9:
        this.pendingSupportRequestManagerFragments.put(r5, r1);
        r5.a().a(r1, FRAGMENT_TAG).c();
        this.handler.obtainMessage(2, r5).sendToTarget();
    L10:
        return r1;
    }

    private RequestManager supportFragmentGet(Context r3, androidx.fragment.app.FragmentManager r4, androidx.fragment.app.Fragment r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SupportRequestManagerFragment r8 = getSupportRequestManagerFragment(r4, r5, r6);
        RequestManager r9 = r8.getRequestManager();
        if (r9 != null) goto L6;
        Glide r10 = Glide.get(r7);
        RequestManager r11 = this.factory.a(r10, r8.getGlideLifecycle(), r8.getRequestManagerTreeNode(), r7);
        r8.setRequestManager(r11);
        return r11;
    L6:
        return r9;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r7) {
        int r0 = r7.what;
        Object r2 = null;
        boolean r3 = true;
        if (r0 != 1) goto L5;
        Object r4 = (FragmentManager) ZeusTransformUtils.preCheckCast(r7.obj, FragmentManager.class, "com.obric.aiagent.plugin");
        Object r6 = this.pendingRequestManagerFragments.remove(r4);
    L9:
        Object r5 = r4;
        r2 = r6;
        Object r8 = r5;
    L10:
        if (r3 == false) goto L15;
        if (r2 != null) goto L15;
        if (INVOKESTATIC_com_bumptech_glide_manager_RequestManagerRetriever_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 5) == false) goto L15;
        INVOKESTATIC_com_bumptech_glide_manager_RequestManagerRetriever_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to remove expected request manager fragment, manager: " + r8);
    L15:
        return r3;
    L5:
        if (r0 == 2) goto L7;
        r3 = false;
        r8 = null;
        goto L10
    L7:
        r4 = (androidx.fragment.app.FragmentManager) ZeusTransformUtils.preCheckCast(r7.obj, androidx.fragment.app.FragmentManager.class, "com.obric.aiagent.plugin");
        r6 = this.pendingSupportRequestManagerFragments.remove(r4);
        goto L9
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_com_bumptech_glide_manager_RequestManagerRetriever_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bumptech_glide_manager_RequestManagerRetriever_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
