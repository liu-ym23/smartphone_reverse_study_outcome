package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    final transient Map<String, CallbackAndContract<?>> mKeyToCallback;
    private final Map<String, LifecycleContainer> mKeyToLifecycleContainers;
    final Map<String, Integer> mKeyToRc;
    ArrayList<String> mLaunchedKeys;
    final Map<String, Object> mParsedPendingResults;
    final Bundle mPendingResults;
    private final Map<Integer, String> mRcToKey;

    public static class CallbackAndContract<O> {
        final ActivityResultCallback<O> mCallback;
        final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultCallback<O> r100, ActivityResultContract<?, O> r101) {
            this.mCallback = r100;
            this.mContract = r101;
        }
    }

    public static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList<LifecycleEventObserver> mObservers;

        public void clearObservers() {
            Iterator<LifecycleEventObserver> r100 = this.mObservers.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            LifecycleEventObserver r101 = r100.next();
            this.mLifecycle.removeObserver(r101);
            goto L4
        L6:
            this.mObservers.clear();
        }

        public LifecycleContainer(Lifecycle r100) {
            this.mLifecycle = r100;
            this.mObservers = new ArrayList();
        }

        public void addObserver(LifecycleEventObserver r100) {
            this.mLifecycle.addObserver(r100);
            this.mObservers.add(r100);
        }
    }

    public abstract <I, O> void onLaunch(int r100, ActivityResultContract<I, O> r101, I r102, ActivityOptionsCompat r103);

    private int generateRandomNumber() {
        int r100 = Random.Default.nextInt(2147418112);
    L3:
        int r101 = r100 + 65536;
        if (this.mRcToKey.containsKey(Integer.valueOf(r101)) == false) goto L6;
        r100 = Random.Default.nextInt(2147418112);
        goto L3
    L6:
        return r101;
    }

    public ActivityResultRegistry() {
        this.mRcToKey = new HashMap();
        this.mKeyToRc = new HashMap();
        this.mKeyToLifecycleContainers = new HashMap();
        this.mLaunchedKeys = new ArrayList();
        this.mKeyToCallback = new HashMap();
        this.mParsedPendingResults = new HashMap();
        this.mPendingResults = new Bundle();
    }

    private void registerKey(String r100) {
        if (this.mKeyToRc.get(r100) == null) goto L5;
        return;
    L5:
        bindRcKey(generateRandomNumber(), r100);
    }

    public final void onRestoreInstanceState(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r101 = r100.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> r102 = r100.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (r102 == null) goto L17;
        if (r101 == null) goto L22;
        this.mLaunchedKeys = r100.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mPendingResults.putAll(r100.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        int r103 = 0;
    L10:
        if (r103 >= r102.size()) goto L23;
        String r104 = (String) ListProtector.get(r102, r103);
        if (this.mKeyToRc.containsKey(r104) == false) goto L16;
        Integer r105 = this.mKeyToRc.remove(r104);
        if (this.mPendingResults.containsKey(r104) == true) goto L16;
        this.mRcToKey.remove(r105);
    L16:
        bindRcKey(((Integer) ListProtector.get(r101, r103)).intValue(), (String) ListProtector.get(r102, r103));
        r103 = r103 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final void onSaveInstanceState(Bundle r100) {
        r100.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.mKeyToRc.values()));
        r100.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.mKeyToRc.keySet()));
        r100.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.mLaunchedKeys));
        r100.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
    }

    public final void unregister(String r100) {
        if (this.mLaunchedKeys.contains(r100) == true) goto L7;
        Integer r101 = this.mKeyToRc.remove(r100);
        if (r101 == null) goto L7;
        this.mRcToKey.remove(r101);
    L7:
        this.mKeyToCallback.remove(r100);
        if (this.mParsedPendingResults.containsKey(r100) == false) goto L11;
        Objects.toString(this.mParsedPendingResults.get(r100));
        this.mParsedPendingResults.remove(r100);
    L11:
        if (this.mPendingResults.containsKey(r100) == false) goto L13;
        Objects.toString(this.mPendingResults.getParcelable(r100));
        this.mPendingResults.remove(r100);
    L13:
        LifecycleContainer r102 = this.mKeyToLifecycleContainers.get(r100);
        if (r102 == null) goto L17;
        r102.clearObservers();
        this.mKeyToLifecycleContainers.remove(r100);
        return;
    }

    private void bindRcKey(int r100, String r101) {
        this.mRcToKey.put(Integer.valueOf(r100), r101);
        this.mKeyToRc.put(r101, Integer.valueOf(r100));
    }

    public final <O> boolean dispatchResult(int r100, O r101) {
        String r102 = this.mRcToKey.get(Integer.valueOf(r100));
        if (r102 != null) goto L6;
        return false;
    L6:
        CallbackAndContract<?> r103 = this.mKeyToCallback.get(r102);
        if (r103 == null) goto L14;
        ActivityResultCallback<?> r104 = r103.mCallback;
        if (r104 == null) goto L14;
        if (this.mLaunchedKeys.remove(r102) == false) goto L17;
        r104.onActivityResult(r101);
        return true;
    L17:
        return true;
    L14:
        this.mPendingResults.remove(r102);
        this.mParsedPendingResults.put(r102, r101);
        return true;
    }

    public final boolean dispatchResult(int r100, int r101, Intent r102) {
        String r103 = this.mRcToKey.get(Integer.valueOf(r100));
        if (r103 != null) goto L6;
        return false;
    L6:
        doDispatch(r103, r101, r102, this.mKeyToCallback.get(r103));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> ActivityResultLauncher<I> register(final String r100, final ActivityResultContract<I, O> r101, ActivityResultCallback<O> r102) {
        registerKey(r100);
        this.mKeyToCallback.put(r100, new CallbackAndContract(r102, r101));
        if (this.mParsedPendingResults.containsKey(r100) == false) goto L5;
        Object r103 = this.mParsedPendingResults.get(r100);
        this.mParsedPendingResults.remove(r100);
        r102.onActivityResult(r103);
    L5:
        ActivityResult r104 = (ActivityResult) this.mPendingResults.getParcelable(r100);
        if (r104 == null) goto L9;
        this.mPendingResults.remove(r100);
        r102.onActivityResult(r101.parseResult(r104.getResultCode(), r104.getData()));
    L9:
        return new AnonymousClass3(this, r100, r101);
    }

    private <O> void doDispatch(String r100, int r101, Intent r102, CallbackAndContract<O> r103) {
        if (r103 != null) goto L4;
    L8:
        this.mParsedPendingResults.remove(r100);
        this.mPendingResults.putParcelable(r100, new ActivityResult(r101, r102));
        return;
    L4:
        if (r103.mCallback == null) goto L8;
        if (this.mLaunchedKeys.contains(r100) == false) goto L8;
        r103.mCallback.onActivityResult(r103.mContract.parseResult(r101, r102));
        this.mLaunchedKeys.remove(r100);
    }

    public final <I, O> ActivityResultLauncher<I> register(final String r100, LifecycleOwner r101, final ActivityResultContract<I, O> r102, final ActivityResultCallback<O> r103) {
        Lifecycle r104 = r101.getLifecycle();
        if (r104.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        registerKey(r100);
        LifecycleContainer r105 = this.mKeyToLifecycleContainers.get(r100);
        if (r105 != null) goto L7;
        r105 = new LifecycleContainer(r104);
    L7:
        r105.addObserver(new AnonymousClass1(this, r100, r103, r102));
        this.mKeyToLifecycleContainers.put(r100, r105);
        return new AnonymousClass2(this, r100, r102);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r101 + " is attempting to register while current state is " + r104.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }
}
