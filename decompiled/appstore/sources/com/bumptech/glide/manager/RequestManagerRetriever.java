package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = null;
    private static final String FRAGMENT_INDEX_KEY = "key";

    @VisibleForTesting
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final Handler handler;

    @VisibleForTesting
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments;

    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments;
    private final Bundle tempBundle;
    private final ArrayMap tempViewToFragment;
    private final ArrayMap tempViewToSupportFragment;

    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide r10, @NonNull Lifecycle r11, @NonNull RequestManagerTreeNode r12, @NonNull Context r13);
    }

    static {
        DEFAULT_FACTORY = new AnonymousClass1();
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory r10) {
        this.pendingRequestManagerFragments = new HashMap();
        this.pendingSupportRequestManagerFragments = new HashMap();
        this.tempViewToSupportFragment = new ArrayMap();
        this.tempViewToFragment = new ArrayMap();
        this.tempBundle = new Bundle();
        if (r10 != null) goto L6;
        r10 = DEFAULT_FACTORY;
    L6:
        this.factory = r10;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void assertNotDestroyed(@NonNull Activity r10) {
        if (r10.isDestroyed() == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @Nullable
    private Activity findActivity(@NonNull Context r10) {
        if ((r10 instanceof Activity) == false) goto L7;
        return (Activity) r10;
    L7:
        if ((r10 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return findActivity(((ContextWrapper) r10).getBaseContext());
    }

    @TargetApi(26)
    @Deprecated
    private void findAllFragmentsWithViews(@NonNull FragmentManager r10, @NonNull ArrayMap r11) {
        Iterator<Fragment> r12 = r10.getFragments().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Fragment r13 = r12.next();
        if (r13.getView() == null) goto L4;
        r11.put(r13.getView(), r13);
        findAllFragmentsWithViews(r13.getChildFragmentManager(), r11);
        goto L4
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(@NonNull FragmentManager r10, @NonNull ArrayMap r11) {
        int r12 = 0;
    L3:
        int r13 = r12 + 1;
        this.tempBundle.putInt(FRAGMENT_INDEX_KEY, r12);
        Fragment r14 = r10.getFragment(this.tempBundle, FRAGMENT_INDEX_KEY);     // Catch: Exception -> L6
    L7:
        if (r14 == null) goto L8;
        if (r14.getView() == null) goto L12;
        r11.put(r14.getView(), r14);
        findAllFragmentsWithViews(r14.getChildFragmentManager(), r11);
    L12:
        r12 = r13;
        goto L3
    L8:
        return;
    L6:
        r14 = null;
        goto L7
    }

    private static void findAllSupportFragmentsWithViews(@Nullable Collection<androidx.fragment.app.Fragment> r10, @NonNull Map<View, androidx.fragment.app.Fragment> r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<androidx.fragment.app.Fragment> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        androidx.fragment.app.Fragment r13 = r12.next();
        if (r13 == null) goto L6;
        if (r13.getView() == null) goto L6;
        r11.put(r13.getView(), r13);
        findAllSupportFragmentsWithViews(r13.getChildFragmentManager().x0(), r11);
        goto L6
    }

    @Nullable
    @Deprecated
    private Fragment findFragment(@NonNull View r10, @NonNull Activity r11) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(r11.getFragmentManager(), this.tempViewToFragment);
        View r12 = r11.findViewById(R.id.content);
        Fragment r13 = null;
    L4:
        if (r10.equals(r12) == true) goto L11;
        r13 = (Fragment) this.tempViewToFragment.get(r10);
        if (r13 != null) goto L11;
        if ((r10.getParent() instanceof View) == false) goto L11;
        r10 = (View) r10.getParent();
    L11:
        this.tempViewToFragment.clear();
        return r13;
    }

    @Nullable
    private androidx.fragment.app.Fragment findSupportFragment(@NonNull View r10, @NonNull FragmentActivity r11) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(r11.getSupportFragmentManager().x0(), this.tempViewToSupportFragment);
        View r12 = r11.findViewById(R.id.content);
        androidx.fragment.app.Fragment r13 = null;
    L4:
        if (r10.equals(r12) == true) goto L11;
        r13 = (androidx.fragment.app.Fragment) this.tempViewToSupportFragment.get(r10);
        if (r13 != null) goto L11;
        if ((r10.getParent() instanceof View) == false) goto L11;
        r10 = (View) r10.getParent();
    L11:
        this.tempViewToSupportFragment.clear();
        return r13;
    }

    @NonNull
    @Deprecated
    private RequestManager fragmentGet(@NonNull Context r10, @NonNull FragmentManager r11, @Nullable Fragment r12, boolean r13) {
        RequestManagerFragment r14 = getRequestManagerFragment(r11, r12, r13);
        RequestManager r15 = r14.getRequestManager();
        if (r15 != null) goto L6;
        Glide r16 = Glide.get(r10);
        RequestManager r17 = this.factory.build(r16, r14.getGlideLifecycle(), r14.getRequestManagerTreeNode(), r10);
        r14.setRequestManager(r17);
        return r17;
    L6:
        return r15;
    }

    @NonNull
    private RequestManager getApplicationManager(@NonNull Context r10) {
        if (this.applicationManager != null) goto L15;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.applicationManager != null) goto L10;
        Glide r11 = Glide.get(r10.getApplicationContext());     // Catch: Throwable -> L8
        this.applicationManager = this.factory.build(r11, new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), r10.getApplicationContext());     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    L15:
        return this.applicationManager;
    }

    private static boolean isActivityVisible(Activity r10) {
        return !r10.isFinishing();
    }

    @NonNull
    private RequestManager supportFragmentGet(@NonNull Context r10, @NonNull androidx.fragment.app.FragmentManager r11, @Nullable androidx.fragment.app.Fragment r12, boolean r13) {
        SupportRequestManagerFragment r14 = getSupportRequestManagerFragment(r11, r12, r13);
        RequestManager r15 = r14.getRequestManager();
        if (r15 != null) goto L6;
        Glide r16 = Glide.get(r10);
        RequestManager r17 = this.factory.build(r16, r14.getGlideLifecycle(), r14.getRequestManagerTreeNode(), r10);
        r14.setRequestManager(r17);
        return r17;
    L6:
        return r15;
    }

    @NonNull
    public RequestManager get(@NonNull Context r10) {
        if (r10 == null) goto L22;
        if (Util.isOnMainThread() == false) goto L20;
        if ((r10 instanceof Application) == true) goto L20;
        if ((r10 instanceof FragmentActivity) == false) goto L12;
        return get((FragmentActivity) r10);
    L12:
        if ((r10 instanceof Activity) == false) goto L16;
        return get((Activity) r10);
    L16:
        if ((r10 instanceof ContextWrapper) == false) goto L20;
        return get(((ContextWrapper) r10).getBaseContext());
    L20:
        return getApplicationManager(r10);
    L22:
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    @Deprecated
    public RequestManagerFragment getRequestManagerFragment(Activity r10) {
        return getRequestManagerFragment(r10.getFragmentManager(), null, isActivityVisible(r10));
    }

    @NonNull
    public SupportRequestManagerFragment getSupportRequestManagerFragment(FragmentActivity r10) {
        return getSupportRequestManagerFragment(r10.getSupportFragmentManager(), null, isActivityVisible(r10));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        int r11 = r10.what;
        boolean r12 = true;
        if (r11 != 1) goto L5;
        Object r13 = (FragmentManager) r10.obj;
        ComponentCallbacks r14 = this.pendingRequestManagerFragments.remove(r13);
    L9:
        if (r12 == false) goto L14;
        if (r14 != null) goto L14;
        if (Log.isLoggable(TAG, 5) == false) goto L14;
        Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + r13);
    L14:
        return r12;
    L5:
        if (r11 == 2) goto L7;
        r14 = null;
        r12 = false;
        r13 = null;
        goto L9
    L7:
        r13 = (androidx.fragment.app.FragmentManager) r10.obj;
        r14 = this.pendingSupportRequestManagerFragments.remove(r13);
        goto L9
    }

    @NonNull
    private RequestManagerFragment getRequestManagerFragment(@NonNull FragmentManager r10, @Nullable Fragment r11, boolean r12) {
        RequestManagerFragment r13 = (RequestManagerFragment) r10.findFragmentByTag(FRAGMENT_TAG);
        if (r13 != null) goto L10;
        r13 = this.pendingRequestManagerFragments.get(r10);
        if (r13 != null) goto L10;
        r13 = new RequestManagerFragment();
        r13.setParentFragmentHint(r11);
        if (r12 == false) goto L9;
        r13.getGlideLifecycle().onStart();
    L9:
        this.pendingRequestManagerFragments.put(r10, r13);
        r10.beginTransaction().add(r13, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, r10).sendToTarget();
    L10:
        return r13;
    }

    @NonNull
    private SupportRequestManagerFragment getSupportRequestManagerFragment(@NonNull androidx.fragment.app.FragmentManager r10, @Nullable androidx.fragment.app.Fragment r11, boolean r12) {
        SupportRequestManagerFragment r13 = (SupportRequestManagerFragment) r10.i0(FRAGMENT_TAG);
        if (r13 != null) goto L10;
        r13 = this.pendingSupportRequestManagerFragments.get(r10);
        if (r13 != null) goto L10;
        r13 = new SupportRequestManagerFragment();
        r13.setParentFragmentHint(r11);
        if (r12 == false) goto L9;
        r13.getGlideLifecycle().onStart();
    L9:
        this.pendingSupportRequestManagerFragments.put(r10, r13);
        r10.o().e(r13, FRAGMENT_TAG).k();
        this.handler.obtainMessage(2, r10).sendToTarget();
    L10:
        return r13;
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity r10) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        assertNotDestroyed(r10);
        return supportFragmentGet(r10, r10.getSupportFragmentManager(), null, isActivityVisible(r10));
    L5:
        return get(r10.getApplicationContext());
    }

    @NonNull
    public RequestManager get(@NonNull androidx.fragment.app.Fragment r10) {
        Preconditions.checkNotNull(r10.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread() == true) goto L5;
        androidx.fragment.app.FragmentManager r11 = r10.getChildFragmentManager();
        return supportFragmentGet(r10.getActivity(), r11, r10, r10.isVisible());
    L5:
        return get(r10.getActivity().getApplicationContext());
    }

    @NonNull
    public RequestManager get(@NonNull Activity r10) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        assertNotDestroyed(r10);
        return fragmentGet(r10, r10.getFragmentManager(), null, isActivityVisible(r10));
    L5:
        return get(r10.getApplicationContext());
    }

    @NonNull
    public RequestManager get(@NonNull View r10) {
        if (Util.isOnBackgroundThread() == true) goto L5;
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r10.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity r11 = findActivity(r10.getContext());
        if (r11 != null) goto L11;
        return get(r10.getContext().getApplicationContext());
    L11:
        if ((r11 instanceof FragmentActivity) == false) goto L17;
        androidx.fragment.app.Fragment r12 = findSupportFragment(r10, (FragmentActivity) r11);
        if (r12 == null) goto L16;
        return get(r12);
    L16:
        return get(r11);
    L17:
        Fragment r13 = findFragment(r10, r11);
        if (r13 != null) goto L22;
        return get(r11);
    L22:
        return get(r13);
    L5:
        return get(r10.getContext().getApplicationContext());
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager get(@NonNull Fragment r10) {
        if (r10.getActivity() == null) goto L11;
        if (Util.isOnBackgroundThread() == true) goto L9;
        FragmentManager r11 = r10.getChildFragmentManager();
        return fragmentGet(r10.getActivity(), r11, r10, r10.isVisible());
    L9:
        return get(r10.getActivity().getApplicationContext());
    L11:
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
