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

/* JADX INFO: loaded from: classes17.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity mActivity;
    private final Context mContext;
    final FragmentManager mFragmentManager;
    private final Handler mHandler;
    private final int mWindowAnimations;

    public void onDump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    public View onFindViewById(int r100) {
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

    public void onRequestPermissionsFromFragment(Fragment r100, String[] r101, int r102) {
    }

    public boolean onShouldSaveFragmentState(Fragment r100) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String r100) {
        return false;
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
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

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    public FragmentHostCallback(FragmentActivity r100) {
        this(r100, r100, new Handler(), 0);
    }

    public FragmentHostCallback(Context r100, Handler r101, int r102) {
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r100;
    L6:
        this(r103, r100, r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void onStartActivityFromFragment(Fragment r100, Intent r101, int r102) {
        onStartActivityFromFragment(r100, r101, r102, null);
    }

    public FragmentHostCallback(Activity r100, Context r101, Handler r102, int r103) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = r100;
        this.mContext = (Context) Preconditions.checkNotNull(r101, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(r102, "handler == null");
        this.mWindowAnimations = r103;
    }

    public void onStartActivityFromFragment(Fragment r100, Intent r101, int r102, Bundle r103) {
        if (r102 != (-1)) goto L7;
        ContextCompat.startActivity(this.mContext, r101, r103);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void onStartIntentSenderFromFragment(Fragment r110, IntentSender r111, int r112, Intent r113, int r114, int r115, int r116, Bundle r117) throws IntentSender.SendIntentException {
        if (r112 != (-1)) goto L7;
        ActivityCompat.startIntentSenderForResult(this.mActivity, r111, r112, r113, r114, r115, r116, r117);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
}
