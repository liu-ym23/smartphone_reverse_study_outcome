package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class RequestManagerRetriever implements Handler.Callback {
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_FRAGMENT_MANAGER_REMOVE = 3;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER_REMOVE = 4;
    private final Handler mHandler;
    private final String mNotOnly;
    private final Map<FragmentManager, RequestBarManagerFragment> mPendingFragments;
    private final Map<String, RequestBarManagerFragment> mPendingRemoveFragments;
    private final Map<androidx.fragment.app.FragmentManager, SupportRequestBarManagerFragment> mPendingSupportFragments;
    private final Map<String, SupportRequestBarManagerFragment> mPendingSupportRemoveFragments;
    private final String mTag;

    /* JADX INFO: renamed from: com.gyf.immersionbar.RequestManagerRetriever$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final RequestManagerRetriever f13820a = null;

        static /* synthetic */ RequestManagerRetriever a() {
            return f13820a;
        }

        static {
            f13820a = new RequestManagerRetriever(null);
        }
    }

    /* synthetic */ RequestManagerRetriever(AnonymousClass1 r1) {
        this();
    }

    static RequestManagerRetriever getInstance() {
        return a.a();
    }

    private RequestManagerRetriever() {
        this.mTag = g.class.getName() + ".";
        this.mNotOnly = ".tag.notOnly.";
        this.mPendingFragments = new HashMap();
        this.mPendingSupportFragments = new HashMap();
        this.mPendingRemoveFragments = new HashMap();
        this.mPendingSupportRemoveFragments = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    public g get(Activity r4, boolean r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        checkNotNull(r6, "activity is null");
        String r0 = this.mTag + r6.getClass().getName();
        if (r5 == true) goto L6;
        r0 = r0 + System.identityHashCode(r6) + ".tag.notOnly.";
    L6:
        if (ZeusTransformUtils.instanceOf(r6, FragmentActivity.class) == false) goto L10;
        return getSupportFragment(((FragmentActivity) ZeusTransformUtils.preCheckCast(r6, FragmentActivity.class, "com.obric.aiagent.plugin")).getSupportFragmentManager(), r0).get(r6);
    L10:
        return getFragment(r6.getFragmentManager(), r0).get(r6);
    }

    public g get(Fragment r4, boolean r5) {
        checkNotNull(r4, "fragment is null");
        checkNotNull((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin"), "fragment.getActivity() is null");
        if (ZeusTransformUtils.instanceOf(r4, DialogFragment.class) == false) goto L5;
        checkNotNull(((DialogFragment) ZeusTransformUtils.preCheckCast(r4, DialogFragment.class, "com.obric.aiagent.plugin")).getDialog(), "fragment.getDialog() is null");
    L5:
        String r0 = this.mTag + r4.getClass().getName();
        if (r5 == true) goto L9;
        r0 = r0 + System.identityHashCode(r4) + ".tag.notOnly.";
    L9:
        return getSupportFragment(r4.getChildFragmentManager(), r0).get(r4);
    }

    public g get(android.app.Fragment r4, boolean r5) {
        checkNotNull(r4, "fragment is null");
        checkNotNull(ZeusTransformUtils.getActivity(r4, "com.obric.aiagent.plugin"), "fragment.getActivity() is null");
        if (ZeusTransformUtils.instanceOf(r4, android.app.DialogFragment.class) == false) goto L5;
        checkNotNull(((android.app.DialogFragment) ZeusTransformUtils.preCheckCast(r4, android.app.DialogFragment.class, "com.obric.aiagent.plugin")).getDialog(), "fragment.getDialog() is null");
    L5:
        String r0 = this.mTag + r4.getClass().getName();
        if (r5 == true) goto L9;
        r0 = r0 + System.identityHashCode(r4) + ".tag.notOnly.";
    L9:
        return getFragment(r4.getChildFragmentManager(), r0).get(r4);
    }

    public g get(Activity r4, Dialog r5, boolean r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        checkNotNull(r7, "activity is null");
        checkNotNull(r5, "dialog is null");
        String r0 = this.mTag + r5.getClass().getName();
        if (r6 == true) goto L6;
        r0 = r0 + System.identityHashCode(r5) + ".tag.notOnly.";
    L6:
        if (ZeusTransformUtils.instanceOf(r7, FragmentActivity.class) == false) goto L10;
        return getSupportFragment(((FragmentActivity) ZeusTransformUtils.preCheckCast(r7, FragmentActivity.class, "com.obric.aiagent.plugin")).getSupportFragmentManager(), r0).get(r7, r5);
    L10:
        return getFragment(r7.getFragmentManager(), r0).get(r7, r5);
    }

    public void destroy(Fragment r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r0 = this.mTag + r3.getClass().getName();
        if (r4 == true) goto L7;
        r0 = r0 + System.identityHashCode(r3) + ".tag.notOnly.";
    L7:
        getSupportFragment(r3.getChildFragmentManager(), r0, true);
    }

    public void destroy(android.app.Fragment r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r0 = this.mTag + r3.getClass().getName();
        if (r4 == true) goto L7;
        r0 = r0 + System.identityHashCode(r3) + ".tag.notOnly.";
    L7:
        getFragment(r3.getChildFragmentManager(), r0, true);
    }

    public void destroy(Activity r4, Dialog r5, boolean r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L14;
        if (r5 == null) goto L16;
        String r0 = this.mTag + r5.getClass().getName();
        if (r6 == true) goto L10;
        r0 = r0 + System.identityHashCode(r5) + ".tag.notOnly.";
    L10:
        if (ZeusTransformUtils.instanceOf(r7, FragmentActivity.class) == false) goto L12;
        getSupportFragment(((FragmentActivity) ZeusTransformUtils.preCheckCast(r7, FragmentActivity.class, "com.obric.aiagent.plugin")).getSupportFragmentManager(), r0, true);
        return;
    L12:
        getFragment(r7.getFragmentManager(), r0, true);
        return;
    L16:
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        int r0 = r5.what;
        if (r0 != 1) goto L5;
        FragmentManager r6 = (FragmentManager) ZeusTransformUtils.preCheckCast(r5.obj, FragmentManager.class, "com.obric.aiagent.plugin");
        this.mPendingFragments.remove(r6);
        return true;
    L5:
        if (r0 != 2) goto L7;
        androidx.fragment.app.FragmentManager r7 = (androidx.fragment.app.FragmentManager) ZeusTransformUtils.preCheckCast(r5.obj, androidx.fragment.app.FragmentManager.class, "com.obric.aiagent.plugin");
        this.mPendingSupportFragments.remove(r7);
        return true;
    L7:
        if (r0 != 3) goto L9;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.obj, String.class, "com.obric.aiagent.plugin");
        this.mPendingRemoveFragments.remove(r8);
        return true;
    L9:
        if (r0 == 4) goto L11;
        return false;
    L11:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.obj, String.class, "com.obric.aiagent.plugin");
        this.mPendingSupportRemoveFragments.remove(r9);
        return true;
    }

    private RequestBarManagerFragment getFragment(FragmentManager r2, String r3) {
        return getFragment(r2, r3, false);
    }

    private RequestBarManagerFragment getFragment(FragmentManager r7, String r8, boolean r9) {
        RequestBarManagerFragment r0 = (RequestBarManagerFragment) ZeusTransformUtils.preCheckCast(r7.findFragmentByTag(r8), RequestBarManagerFragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L22;
        r0 = (RequestBarManagerFragment) ZeusTransformUtils.preCheckCast(this.mPendingFragments.get(r7), RequestBarManagerFragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L22;
        if (r9 == false) goto L9;
        return null;
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L21;
        Iterator<android.app.Fragment> r1 = r7.getFragments().iterator();
    L12:
        if (r1.hasNext() == false) goto L21;
        android.app.Fragment r3 = (android.app.Fragment) ZeusTransformUtils.preCheckCast(r1.next(), android.app.Fragment.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, RequestBarManagerFragment.class) == false) goto L12;
        String r4 = r3.getTag();
        if (r4 == null) goto L17;
        if (r4.contains(".tag.notOnly.") == false) goto L12;
        r7.beginTransaction().remove(r3).commitAllowingStateLoss();
        goto L12
    L17:
        r7.beginTransaction().remove(r3).commitAllowingStateLoss();
    L21:
        r0 = new RequestBarManagerFragment();
        this.mPendingFragments.put(r7, r0);
        r7.beginTransaction().add(r0, r8).commitAllowingStateLoss();
        this.mHandler.obtainMessage(1, r7).sendToTarget();
    L22:
        if (r9 == true) goto L24;
        return r0;
    L24:
        if (this.mPendingRemoveFragments.get(r8) != null) goto L26;
        this.mPendingRemoveFragments.put(r8, r0);
        r7.beginTransaction().remove(r0).commitAllowingStateLoss();
        this.mHandler.obtainMessage(3, r8).sendToTarget();
    L26:
        return null;
    }

    private SupportRequestBarManagerFragment getSupportFragment(androidx.fragment.app.FragmentManager r2, String r3) {
        return getSupportFragment(r2, r3, false);
    }

    private SupportRequestBarManagerFragment getSupportFragment(androidx.fragment.app.FragmentManager r7, String r8, boolean r9) {
        SupportRequestBarManagerFragment r0 = (SupportRequestBarManagerFragment) ZeusTransformUtils.preCheckCast(r7.b(r8), SupportRequestBarManagerFragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L20;
        r0 = (SupportRequestBarManagerFragment) ZeusTransformUtils.preCheckCast(this.mPendingSupportFragments.get(r7), SupportRequestBarManagerFragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L20;
        if (r9 == false) goto L8;
        return null;
    L8:
        Iterator<Fragment> r1 = r7.f().iterator();
    L10:
        if (r1.hasNext() == false) goto L19;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r1.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, SupportRequestBarManagerFragment.class) == false) goto L10;
        String r4 = r3.getTag();
        if (r4 == null) goto L15;
        if (r4.contains(".tag.notOnly.") == false) goto L10;
        r7.a().a(r3).c();
        goto L10
    L15:
        r7.a().a(r3).c();
        goto L10
    L19:
        r0 = new SupportRequestBarManagerFragment();
        this.mPendingSupportFragments.put(r7, r0);
        r7.a().a(r0, r8).c();
        this.mHandler.obtainMessage(2, r7).sendToTarget();
    L20:
        if (r9 == true) goto L22;
        return r0;
    L22:
        if (this.mPendingSupportRemoveFragments.get(r8) != null) goto L24;
        this.mPendingSupportRemoveFragments.put(r8, r0);
        r7.a().a(r0).c();
        this.mHandler.obtainMessage(4, r8).sendToTarget();
    L24:
        return null;
    }

    private static <T> void checkNotNull(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
    }
}
