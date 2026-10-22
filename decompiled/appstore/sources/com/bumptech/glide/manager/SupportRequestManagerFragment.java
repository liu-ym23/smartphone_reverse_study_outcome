package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;

    @Nullable
    private Fragment parentFragmentHint;

    @Nullable
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;

    @Nullable
    private SupportRequestManagerFragment rootRequestManagerFragment;

    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        final /* synthetic */ SupportRequestManagerFragment this$0;

        public SupportFragmentRequestManagerTreeNode(SupportRequestManagerFragment r10) {
            this.this$0 = r10;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> r10 = this.this$0.getDescendantRequestManagerFragments();
            HashSet r11 = new HashSet(r10.size());
            Iterator<SupportRequestManagerFragment> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            SupportRequestManagerFragment r13 = r12.next();
            if (r13.getRequestManager() == null) goto L4;
            r11.add(r13.getRequestManager());
            goto L4
        L8:
            return r11;
        }

        public String toString() {
            return super.toString() + "{fragment=" + this.this$0 + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment r10) {
        this.childRequestManagerFragments.add(r10);
    }

    @Nullable
    private Fragment getParentFragmentUsingHint() {
        Fragment r10 = getParentFragment();
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.parentFragmentHint;
    }

    private boolean isDescendant(@NonNull Fragment r10) {
        Fragment r11 = getParentFragmentUsingHint();
    L3:
        Fragment r12 = r10.getParentFragment();
        if (r12 == null) goto L10;
        if (r12.equals(r11) == true) goto L7;
        r10 = r10.getParentFragment();
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    private void registerFragmentWithRoot(@NonNull FragmentActivity r10) {
        unregisterFragmentWithRoot();
        SupportRequestManagerFragment r11 = Glide.get(r10).getRequestManagerRetriever().getSupportRequestManagerFragment(r10);
        this.rootRequestManagerFragment = r11;
        if (equals(r11) == true) goto L6;
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        return;
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment r10) {
        this.childRequestManagerFragments.remove(r10);
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment r10 = this.rootRequestManagerFragment;
        if (r10 == null) goto L6;
        r10.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
        return;
    }

    @NonNull
    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        SupportRequestManagerFragment r10 = this.rootRequestManagerFragment;
        if (r10 != null) goto L7;
        return Collections.emptySet();
    L7:
        if (equals(r10) == true) goto L9;
        HashSet r11 = new HashSet();
        Iterator<SupportRequestManagerFragment> r12 = this.rootRequestManagerFragment.getDescendantRequestManagerFragments().iterator();
    L12:
        if (r12.hasNext() == false) goto L17;
        SupportRequestManagerFragment r13 = r12.next();
        if (isDescendant(r13.getParentFragmentUsingHint()) == false) goto L12;
        r11.add(r13);
        goto L12
    L17:
        return Collections.unmodifiableSet(r11);
    L9:
        return Collections.unmodifiableSet(this.childRequestManagerFragments);
    }

    @NonNull
    public ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r10) {
        super.onAttach(r10);
        registerFragmentWithRoot(getActivity());     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L12;
        Log.w(TAG, "Unable to register fragment with root", e);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
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
        this.lifecycle.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public void setParentFragmentHint(@Nullable Fragment r10) {
        this.parentFragmentHint = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getActivity() == null) goto L9;
        registerFragmentWithRoot(r10.getActivity());
        return;
    }

    public void setRequestManager(@Nullable RequestManager r10) {
        this.requestManager = r10;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle r10) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode(this);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = r10;
    }
}
