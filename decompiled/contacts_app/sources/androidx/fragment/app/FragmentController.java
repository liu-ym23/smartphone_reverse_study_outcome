package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    @Deprecated
    public void dispatchReallyStop() {
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean r1) {
    }

    @Deprecated
    public void dumpLoaders(String r1, FileDescriptor r2, PrintWriter r3, String[] r4) {
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> r1) {
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    public static FragmentController createController(FragmentHostCallback<?> r2) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(r2, "callbacks == null"));
    }

    private FragmentController(FragmentHostCallback<?> r1) {
        this.mHost = r1;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public Fragment findFragmentByWho(String r1) {
        return this.mHost.mFragmentManager.findFragmentByWho(r1);
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    public List<Fragment> getActiveFragments(List<Fragment> r1) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public void attachHost(Fragment r2) {
        FragmentManager r0 = this.mHost.mFragmentManager;
        FragmentHostCallback<?> r1 = this.mHost;
        r0.attachController(r1, r1, r2);
    }

    public View onCreateView(View r1, String r2, Context r3, AttributeSet r4) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(r1, r2, r3, r4);
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    @Deprecated
    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }

    @Deprecated
    public void restoreAllState(Parcelable r3, List<Fragment> r4) {
        this.mHost.mFragmentManager.restoreAllState(r3, new FragmentManagerNonConfig(r4, null, null));
    }

    @Deprecated
    public void restoreAllState(Parcelable r1, FragmentManagerNonConfig r2) {
        this.mHost.mFragmentManager.restoreAllState(r1, r2);
    }

    @Deprecated
    public void restoreSaveState(Parcelable r2) {
        FragmentHostCallback<?> r1 = this.mHost;
        if ((r1 instanceof ViewModelStoreOwner) == false) goto L7;
        r1.mFragmentManager.restoreSaveState(r2);
        return;
    L7:
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig r1 = this.mHost.mFragmentManager.retainNonConfig();
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.getFragments() == null) goto L7;
        return new ArrayList(r1.getFragments());
    }

    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    @Deprecated
    public void dispatchMultiWindowModeChanged(boolean r2) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(r2, true);
    }

    @Deprecated
    public void dispatchPictureInPictureModeChanged(boolean r2) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(r2, true);
    }

    @Deprecated
    public void dispatchConfigurationChanged(Configuration r2) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(r2, true);
    }

    @Deprecated
    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory(true);
    }

    @Deprecated
    public boolean dispatchCreateOptionsMenu(Menu r1, MenuInflater r2) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(r1, r2);
    }

    @Deprecated
    public boolean dispatchPrepareOptionsMenu(Menu r1) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(r1);
    }

    @Deprecated
    public boolean dispatchOptionsItemSelected(MenuItem r1) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(r1);
    }

    public boolean dispatchContextItemSelected(MenuItem r1) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(r1);
    }

    @Deprecated
    public void dispatchOptionsMenuClosed(Menu r1) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(r1);
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }
}
