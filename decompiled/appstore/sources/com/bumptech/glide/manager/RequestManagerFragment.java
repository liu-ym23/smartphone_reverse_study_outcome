package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    private static final String TAG = "RMFragment";
    private final Set<RequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;

    @Nullable
    private Fragment parentFragmentHint;

    @Nullable
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;

    @Nullable
    private RequestManagerFragment rootRequestManagerFragment;

    public class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        final /* synthetic */ RequestManagerFragment this$0;

        public FragmentRequestManagerTreeNode(RequestManagerFragment r10) {
            this.this$0 = r10;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> r10 = this.this$0.getDescendantRequestManagerFragments();
            HashSet r11 = new HashSet(r10.size());
            Iterator<RequestManagerFragment> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            RequestManagerFragment r13 = r12.next();
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

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void addChildRequestManagerFragment(RequestManagerFragment r10) {
        this.childRequestManagerFragments.add(r10);
    }

    @Nullable
    @TargetApi(17)
    private Fragment getParentFragmentUsingHint() {
        Fragment r10 = getParentFragment();
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.parentFragmentHint;
    }

    @TargetApi(17)
    private boolean isDescendant(@NonNull Fragment r10) {
        Fragment r11 = getParentFragment();
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

    private void registerFragmentWithRoot(@NonNull Activity r10) {
        unregisterFragmentWithRoot();
        RequestManagerFragment r11 = Glide.get(r10).getRequestManagerRetriever().getRequestManagerFragment(r10);
        this.rootRequestManagerFragment = r11;
        if (equals(r11) == true) goto L6;
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        return;
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment r10) {
        this.childRequestManagerFragments.remove(r10);
    }

    private void unregisterFragmentWithRoot() {
        RequestManagerFragment r10 = this.rootRequestManagerFragment;
        if (r10 == null) goto L6;
        r10.removeChildRequestManagerFragment(this);
        this.rootRequestManagerFragment = null;
        return;
    }

    @NonNull
    @TargetApi(17)
    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment) == false) goto L7;
        return Collections.unmodifiableSet(this.childRequestManagerFragments);
    L7:
        if (this.rootRequestManagerFragment == null) goto L17;
        HashSet r10 = new HashSet();
        Iterator<RequestManagerFragment> r11 = this.rootRequestManagerFragment.getDescendantRequestManagerFragments().iterator();
    L10:
        if (r11.hasNext() == false) goto L15;
        RequestManagerFragment r12 = r11.next();
        if (isDescendant(r12.getParentFragment()) == false) goto L10;
        r10.add(r12);
        goto L10
    L15:
        return Collections.unmodifiableSet(r10);
    L17:
        return Collections.emptySet();
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

    @Override // android.app.Fragment
    public void onAttach(Activity r10) {
        super.onAttach(r10);
        registerFragmentWithRoot(r10);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L12;
        Log.w(TAG, "Unable to register fragment with root", e);
        return;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    @Override // android.app.Fragment
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

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public RequestManagerFragment(@NonNull ActivityFragmentLifecycle r10) {
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode(this);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = r10;
    }
}
