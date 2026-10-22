package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
public class SupportRequestManagerFragment extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    private final com.bumptech.glide.manager.a lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final k requestManagerTreeNode;
    private SupportRequestManagerFragment rootRequestManagerFragment;

    private class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SupportRequestManagerFragment f3892a;

        a(SupportRequestManagerFragment r1) {
            this.f3892a = r1;
        }

        @Override // com.bumptech.glide.manager.k
        public Set<RequestManager> a() {
            Set<SupportRequestManagerFragment> r4 = this.f3892a.getDescendantRequestManagerFragments();
            HashSet r0 = new HashSet(r4.size());
            Iterator<SupportRequestManagerFragment> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            SupportRequestManagerFragment r1 = (SupportRequestManagerFragment) ZeusTransformUtils.preCheckCast(r5.next(), SupportRequestManagerFragment.class, "com.obric.aiagent.plugin");
            if (r1.getRequestManager() == null) goto L4;
            r0.add(r1.getRequestManager());
            goto L4
        L8:
            return r0;
        }

        public String toString() {
            return super.toString() + "{fragment=" + this.f3892a + "}";
        }
    }

    public static /* synthetic */ boolean access$000(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    public SupportRequestManagerFragment(com.bumptech.glide.manager.a r2) {
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

    private void addChildRequestManagerFragment(SupportRequestManagerFragment r1) {
        this.childRequestManagerFragments.add(r1);
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment r1) {
        this.childRequestManagerFragments.remove(r1);
    }

    Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        SupportRequestManagerFragment r0 = this.rootRequestManagerFragment;
        if (r0 != null) goto L7;
        return Collections.emptySet();
    L7:
        if (equals(r0) == true) goto L9;
        HashSet r1 = new HashSet();
        Iterator<SupportRequestManagerFragment> r2 = this.rootRequestManagerFragment.getDescendantRequestManagerFragments().iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        SupportRequestManagerFragment r3 = (SupportRequestManagerFragment) ZeusTransformUtils.preCheckCast(r2.next(), SupportRequestManagerFragment.class, "com.obric.aiagent.plugin");
        if (isDescendant(r3.getParentFragmentUsingHint()) == false) goto L12;
        r1.add(r3);
        goto L12
    L17:
        return Collections.unmodifiableSet(r1);
    L9:
        return Collections.unmodifiableSet(this.childRequestManagerFragments);
    }

    void setParentFragmentHint(Fragment r4) {
        this.parentFragmentHint = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L13;
        FragmentManager r0 = getRootFragmentManager(r4);
        if (r0 != null) goto L10;
        return;
    L10:
        registerFragmentWithRoot((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0);
        return;
    }

    private static FragmentManager getRootFragmentManager(Fragment r1) {
    L3:
        if (r1.getParentFragment() == null) goto L6;
        r1 = r1.getParentFragment();
        goto L3
    L6:
        return r1.getFragmentManager();
    }

    private Fragment getParentFragmentUsingHint() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.parentFragmentHint;
    }

    private boolean isDescendant(Fragment r2) {
        Fragment r1 = getParentFragmentUsingHint();
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

    private void registerFragmentWithRoot(Context r3, FragmentManager r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        unregisterFragmentWithRoot();
        SupportRequestManagerFragment r6 = Glide.get(r5).getRequestManagerRetriever().getSupportRequestManagerFragment(r5, r4);
        this.rootRequestManagerFragment = r6;
        if (equals(r6) == true) goto L6;
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        return;
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment r0 = this.rootRequestManagerFragment;
        if (r0 == null) goto L6;
        r0.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r6) {
        super.onAttach((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"));
        FragmentManager r7 = getRootFragmentManager(this);
        if (r7 == null) goto L5;
        registerFragmentWithRoot((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7);     // Catch: IllegalStateException -> L10
        return;
    L10:
        e = move-exception;
        if (INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 5) == false) goto L18;
        INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Unable to register fragment with root", e);
        return;
    L18:
        return;
    L5:
        if (INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(TAG, 5) == false) goto L17;
        INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Unable to register fragment with root, ancestor detached");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        unregisterFragmentWithRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.c();
        unregisterFragmentWithRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
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
    public static int INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
