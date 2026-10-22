package com.bumptech.glide.manager;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = null;
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments;
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments;
    private final Bundle tempBundle;
    private final ArrayMap<View, Fragment> tempViewToFragment;
    private final ArrayMap<View, androidx.fragment.app.Fragment> tempViewToSupportFragment;

    public interface RequestManagerFactory {
        RequestManager build(Glide r100, Lifecycle r101, RequestManagerTreeNode r102, Context r103);
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }

    public RequestManagerRetriever(RequestManagerFactory r100) {
        this.pendingRequestManagerFragments = new HashMap();
        this.pendingSupportRequestManagerFragments = new HashMap();
        this.tempViewToSupportFragment = new ArrayMap();
        this.tempViewToFragment = new ArrayMap();
        this.tempBundle = new Bundle();
        if (r100 != null) goto L6;
        r100 = DEFAULT_FACTORY;
    L6:
        this.factory = r100;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    private static void assertNotDestroyed(Activity r100) {
        if (r100.isDestroyed() == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    private static Activity findActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return findActivity(((ContextWrapper) r100).getBaseContext());
    }

    private RequestManager getApplicationManager(Context r100) {
        if (this.applicationManager != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.applicationManager != null) goto L8;
        Glide r101 = Glide.get(r100.getApplicationContext());     // Catch: Throwable -> L10
        this.applicationManager = this.factory.build(r101, new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), r100.getApplicationContext());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.applicationManager;
    }

    private static boolean isActivityVisible(Context r100) {
        Activity r101 = findActivity(r100);
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.isFinishing() == false) goto L8;
        return false;
    }

    public RequestManager get(View r100) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r100.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity r101 = findActivity(r100.getContext());
        if (r101 != null) goto L11;
        return get(r100.getContext().getApplicationContext());
    L11:
        if ((r101 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r102 = (FragmentActivity) r101;
        androidx.fragment.app.Fragment r103 = findSupportFragment(r100, r102);
        if (r103 == null) goto L16;
        return get(r103);
    L16:
        return get(r102);
    L17:
        Fragment r104 = findFragment(r100, r101);
        if (r104 != null) goto L22;
        return get(r101);
    L22:
        return get(r104);
    L5:
        return get(r100.getContext().getApplicationContext());
    }

    public RequestManagerFragment getRequestManagerFragment(Activity r100) {
        return getRequestManagerFragment(r100.getFragmentManager(), null, isActivityVisible(r100));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        int r101 = r100.what;
        boolean r102 = true;
        if (r101 != 1) goto L5;
        Object r103 = (FragmentManager) r100.obj;
        ComponentCallbacks r104 = this.pendingRequestManagerFragments.remove(r103);
    L9:
        ComponentCallbacks r105 = r104;
        Object r106 = r103;
        ComponentCallbacks r107 = r105;
    L10:
        if (r102 == false) goto L13;
        if (r107 != null) goto L13;
        GlideLogUtil.w(TAG, "Failed to remove expected request manager fragment, manager: " + r106);
    L13:
        return r102;
    L5:
        if (r101 == 2) goto L7;
        r107 = null;
        r102 = false;
        r106 = null;
        goto L10
    L7:
        r103 = (androidx.fragment.app.FragmentManager) r100.obj;
        r104 = this.pendingSupportRequestManagerFragments.remove(r103);
        goto L9
    }

    public RequestManager get(Context r100) {
        if (r100 == null) goto L24;
        if (Util.isOnMainThread() == false) goto L22;
        if ((r100 instanceof Application) == true) goto L22;
        if ((r100 instanceof FragmentActivity) == false) goto L12;
        return get((FragmentActivity) r100);
    L12:
        if ((r100 instanceof Activity) == false) goto L16;
        return get((Activity) r100);
    L16:
        if ((r100 instanceof ContextWrapper) == false) goto L22;
        ContextWrapper r101 = (ContextWrapper) r100;
        if (r101.getBaseContext().getApplicationContext() == null) goto L22;
        return get(r101.getBaseContext());
    L22:
        return getApplicationManager(r100);
    L24:
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager get(Fragment r100) {
        if (r100.getActivity() == null) goto L11;
        if (Util.isOnBackgroundThread() == true) goto L9;
        FragmentManager r101 = r100.getChildFragmentManager();
        return fragmentGet(r100.getActivity(), r101, r100, r100.isVisible());
    L9:
        return get(r100.getActivity().getApplicationContext());
    L11:
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    public RequestManager get(androidx.fragment.app.Fragment r100) {
        Preconditions.checkNotNull(r100.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread() == true) goto L5;
        androidx.fragment.app.FragmentManager r101 = r100.getChildFragmentManager();
        return supportFragmentGet(r100.getContext(), r101, r100, r100.isVisible());
    L5:
        return get(r100.getContext().getApplicationContext());
    }

    public RequestManager get(Activity r100) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        assertNotDestroyed(r100);
        return fragmentGet(r100, r100.getFragmentManager(), null, isActivityVisible(r100));
    L5:
        return get(r100.getApplicationContext());
    }

    public RequestManager get(FragmentActivity r100) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        assertNotDestroyed(r100);
        return supportFragmentGet(r100, r100.getSupportFragmentManager(), null, isActivityVisible(r100));
    L5:
        return get(r100.getApplicationContext());
    }

    private void findAllFragmentsWithViews(FragmentManager r100, ArrayMap<View, Fragment> r101) {
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Iterator<Fragment> r102 = r100.getFragments().iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Fragment r103 = r102.next();
        if (r103.getView() == null) goto L6;
        r101.put(r103.getView(), r103);
        findAllFragmentsWithViews(r103.getChildFragmentManager(), r101);
        goto L6
    L17:
        return;
    L10:
        findAllFragmentsWithViewsPreO(r100, r101);
    }

    private void findAllFragmentsWithViewsPreO(FragmentManager r100, ArrayMap<View, Fragment> r101) {
        int r102 = 0;
    L3:
        int r103 = r102 + 1;
        this.tempBundle.putInt("key", r102);
        Fragment r104 = r100.getFragment(this.tempBundle, "key");     // Catch: Exception -> L6
    L7:
        if (r104 == null) goto L8;
        if (r104.getView() == null) goto L12;
        r101.put(r104.getView(), r104);
        findAllFragmentsWithViews(r104.getChildFragmentManager(), r101);
    L12:
        r102 = r103;
        goto L3
    L8:
        return;
    L6:
        r104 = null;
        goto L7
    }

    private static void findAllSupportFragmentsWithViews(Collection<androidx.fragment.app.Fragment> r100, Map<View, androidx.fragment.app.Fragment> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<androidx.fragment.app.Fragment> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        androidx.fragment.app.Fragment r103 = r102.next();
        if (r103 == null) goto L6;
        if (r103.getView() == null) goto L6;
        r101.put(r103.getView(), r103);
        findAllSupportFragmentsWithViews(r103.getChildFragmentManager().getFragments(), r101);
        goto L6
    }

    private Fragment findFragment(View r100, Activity r101) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(r101.getFragmentManager(), this.tempViewToFragment);
        View r102 = r101.findViewById(R.id.content);
        Fragment r103 = null;
    L4:
        if (r100.equals(r102) == true) goto L11;
        r103 = this.tempViewToFragment.get(r100);
        if (r103 != null) goto L11;
        if ((r100.getParent() instanceof View) == false) goto L11;
        r100 = (View) r100.getParent();
    L11:
        this.tempViewToFragment.clear();
        return r103;
    }

    private androidx.fragment.app.Fragment findSupportFragment(View r100, FragmentActivity r101) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(r101.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        View r102 = r101.findViewById(R.id.content);
        androidx.fragment.app.Fragment r103 = null;
    L4:
        if (r100.equals(r102) == true) goto L11;
        r103 = this.tempViewToSupportFragment.get(r100);
        if (r103 != null) goto L11;
        if ((r100.getParent() instanceof View) == false) goto L11;
        r100 = (View) r100.getParent();
    L11:
        this.tempViewToSupportFragment.clear();
        return r103;
    }

    public SupportRequestManagerFragment getSupportRequestManagerFragment(Context r100, androidx.fragment.app.FragmentManager r101) {
        return getSupportRequestManagerFragment(r101, null, isActivityVisible(r100));
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bumptech_glide_manager_RequestManagerRetriever_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, androidx.fragment.app.Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    private RequestManagerFragment getRequestManagerFragment(FragmentManager r100, Fragment r101, boolean r102) {
        RequestManagerFragment r103 = (RequestManagerFragment) r100.findFragmentByTag(FRAGMENT_TAG);
        if (r103 != null) goto L10;
        r103 = this.pendingRequestManagerFragments.get(r100);
        if (r103 != null) goto L10;
        r103 = new RequestManagerFragment();
        r103.setParentFragmentHint(r101);
        if (r102 == false) goto L9;
        r103.getGlideLifecycle().onStart();
    L9:
        this.pendingRequestManagerFragments.put(r100, r103);
        r100.beginTransaction().add(r103, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, r100).sendToTarget();
    L10:
        return r103;
    }

    private SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager r100, androidx.fragment.app.Fragment r101, boolean r102) {
        SupportRequestManagerFragment r103 = (SupportRequestManagerFragment) r100.findFragmentByTag(FRAGMENT_TAG);
        if (r103 != null) goto L10;
        r103 = this.pendingSupportRequestManagerFragments.get(r100);
        if (r103 != null) goto L10;
        r103 = new SupportRequestManagerFragment();
        r103.setParentFragmentHint(r101);
        if (r102 == false) goto L9;
        r103.getGlideLifecycle().onStart();
    L9:
        this.pendingSupportRequestManagerFragments.put(r100, r103);
        INVOKEVIRTUAL_com_bumptech_glide_manager_RequestManagerRetriever_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100.beginTransaction(), r103, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(2, r100).sendToTarget();
    L10:
        return r103;
    }

    private RequestManager fragmentGet(Context r100, FragmentManager r101, Fragment r102, boolean r103) {
        RequestManagerFragment r104 = getRequestManagerFragment(r101, r102, r103);
        RequestManager r105 = r104.getRequestManager();
        if (r105 != null) goto L6;
        Glide r106 = Glide.get(r100);
        RequestManager r107 = this.factory.build(r106, r104.getGlideLifecycle(), r104.getRequestManagerTreeNode(), r100);
        r104.setRequestManager(r107);
        return r107;
    L6:
        return r105;
    }

    private RequestManager supportFragmentGet(Context r100, androidx.fragment.app.FragmentManager r101, androidx.fragment.app.Fragment r102, boolean r103) {
        SupportRequestManagerFragment r104 = getSupportRequestManagerFragment(r101, r102, r103);
        RequestManager r105 = r104.getRequestManager();
        if (r105 != null) goto L6;
        Glide r106 = Glide.get(r100);
        RequestManager r107 = this.factory.build(r106, r104.getGlideLifecycle(), r104.getRequestManagerTreeNode(), r100);
        r104.setRequestManager(r107);
        return r107;
    L6:
        return r105;
    }
}
