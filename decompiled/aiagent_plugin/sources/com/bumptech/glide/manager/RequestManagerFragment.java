package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    private static final String TAG = "RMFragment";
    private final Set<RequestManagerFragment> childRequestManagerFragments;
    private final com.bumptech.glide.manager.a lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final k requestManagerTreeNode;
    private RequestManagerFragment rootRequestManagerFragment;

    private class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestManagerFragment f3891a;

        a(RequestManagerFragment r1) {
            this.f3891a = r1;
        }

        @Override // com.bumptech.glide.manager.k
        public Set<RequestManager> a() {
            Set<RequestManagerFragment> r4 = this.f3891a.getDescendantRequestManagerFragments();
            HashSet r0 = new HashSet(r4.size());
            Iterator<RequestManagerFragment> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            RequestManagerFragment r1 = (RequestManagerFragment) ZeusTransformUtils.preCheckCast(r5.next(), RequestManagerFragment.class, "com.obric.aiagent.plugin");
            if (r1.getRequestManager() == null) goto L4;
            r0.add(r1.getRequestManager());
            goto L4
        L8:
            return r0;
        }

        public String toString() {
            return super.toString() + "{fragment=" + this.f3891a + "}";
        }
    }

    public static /* synthetic */ boolean access$000(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    RequestManagerFragment(com.bumptech.glide.manager.a r2) {
        this.requestManagerTreeNode = new a(this);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = r2;
    }

    public void setRequestManager(RequestManager r1) {
        this.requestManager = r1;
    }

    com.bumptech.glide.manager.a getGlideLifecycle() {
        return this.lifecycle;
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public k getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    private void addChildRequestManagerFragment(RequestManagerFragment r1) {
        this.childRequestManagerFragments.add(r1);
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment r1) {
        this.childRequestManagerFragments.remove(r1);
    }

    Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment) == false) goto L7;
        return Collections.unmodifiableSet(this.childRequestManagerFragments);
    L7:
        if (this.rootRequestManagerFragment == null) goto L20;
        if (Build.VERSION.SDK_INT < 17) goto L20;
        HashSet r0 = new HashSet();
        Iterator<RequestManagerFragment> r1 = this.rootRequestManagerFragment.getDescendantRequestManagerFragments().iterator();
    L13:
        if (r1.hasNext() == false) goto L18;
        RequestManagerFragment r2 = (RequestManagerFragment) ZeusTransformUtils.preCheckCast(r1.next(), RequestManagerFragment.class, "com.obric.aiagent.plugin");
        if (isDescendant(r2.getParentFragment()) == false) goto L13;
        r0.add(r2);
        goto L13
    L18:
        return Collections.unmodifiableSet(r0);
    L20:
        return Collections.emptySet();
    }

    void setParentFragmentHint(Fragment r3) {
        this.parentFragmentHint = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.getActivity(r3, "com.obric.aiagent.plugin") == null) goto L9;
        registerFragmentWithRoot(ZeusTransformUtils.getActivity(r3, "com.obric.aiagent.plugin"));
        return;
    }

    private Fragment getParentFragmentUsingHint() {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Fragment r0 = getParentFragment();
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return this.parentFragmentHint;
    L5:
        r0 = null;
        goto L6
    }

    private boolean isDescendant(Fragment r2) {
        Fragment r1 = getParentFragment();
    L3:
        Fragment r0 = r2.getParentFragment();
        if (r0 == null) goto L10;
        if (r0.equals(r1) == true) goto L7;
        r2 = r2.getParentFragment();
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    private void registerFragmentWithRoot(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        unregisterFragmentWithRoot();
        RequestManagerFragment r5 = Glide.get(r4).getRequestManagerRetriever().getRequestManagerFragment(r4);
        this.rootRequestManagerFragment = r5;
        if (equals(r5) == true) goto L6;
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        return;
    }

    private void unregisterFragmentWithRoot() {
        RequestManagerFragment r0 = this.rootRequestManagerFragment;
        if (r0 == null) goto L6;
        r0.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
        return;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        super.onAttach(r4);
        registerFragmentWithRoot(r4);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        if (INVOKESTATIC_com_bumptech_glide_manager_RequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 5) == false) goto L12;
        INVOKESTATIC_com_bumptech_glide_manager_RequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Unable to register fragment with root", e);
        return;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.b();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.c();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_com_bumptech_glide_manager_RequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
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
    public static int INVOKESTATIC_com_bumptech_glide_manager_RequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
