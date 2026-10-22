package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity mActivity;
    private final Context mContext;
    final FragmentManager mFragmentManager;
    private final Handler mHandler;
    private final int mWindowAnimations;

    public void onDump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    public View onFindViewById(int r1) {
        return null;
    }

    public abstract E onGetHost();

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    @Deprecated
    public void onRequestPermissionsFromFragment(Fragment r1, String[] r2, int r3) {
    }

    public boolean onShouldSaveFragmentState(Fragment r1) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String r1) {
        return false;
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public FragmentHostCallback(Context r2, Handler r3, int r4) {
        if ((r2 instanceof Activity) == false) goto L5;
        Activity r0 = (Activity) r2;
    L6:
        this(r0, r2, r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    FragmentHostCallback(FragmentActivity r3) {
        this(r3, r3, new Handler(), 0);
    }

    FragmentHostCallback(Activity r2, Context r3, Handler r4, int r5) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = r2;
        this.mContext = (Context) Preconditions.checkNotNull(r3, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(r4, "handler == null");
        this.mWindowAnimations = r5;
    }

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public void onStartActivityFromFragment(Fragment r2, Intent r3, int r4) {
        onStartActivityFromFragment(r2, r3, r4, null);
    }

    public void onStartActivityFromFragment(Fragment r1, Intent r2, int r3, Bundle r4) {
        if (r3 != (-1)) goto L7;
        ContextCompat.startActivity(this.mContext, r2, r4);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void onStartIntentSenderFromFragment(Fragment r10, IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) throws IntentSender.SendIntentException {
        if (r12 != (-1)) goto L7;
        ActivityCompat.startIntentSenderForResult(this.mActivity, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    Activity getActivity() {
        return this.mActivity;
    }

    Context getContext() {
        return this.mContext;
    }

    public Handler getHandler() {
        return this.mHandler;
    }
}
