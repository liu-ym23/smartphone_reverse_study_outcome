package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private final DividerDecoration mDividerDecoration;
    private final Handler mHandler;
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId;
    RecyclerView mList;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus;
    private Runnable mSelectPreferenceRunnable;

    private class DividerDecoration extends RecyclerView.ItemDecoration {
        private boolean mAllowDividerAfterLastItem;
        private Drawable mDivider;
        private int mDividerHeight;
        final /* synthetic */ PreferenceFragmentCompat this$0;

        DividerDecoration(PreferenceFragmentCompat r1) {
            this.this$0 = r1;
            this.mAllowDividerAfterLastItem = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas r7, RecyclerView r8, RecyclerView.State r9) {
            if (this.mDivider != null) goto L5;
            return;
        L5:
            int r10 = r8.getChildCount();
            int r0 = r8.getWidth();
            int r2 = 0;
        L6:
            if (r2 >= r10) goto L11;
            View r3 = r8.getChildAt(r2);
            if (shouldDrawDividerBelow(r3, r8) == false) goto L10;
            int r4 = ((int) r3.getY()) + r3.getHeight();
            this.mDivider.setBounds(0, r4, r0, this.mDividerHeight + r4);
            this.mDivider.draw(r7);
        L10:
            r2 = r2 + 1;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
            if (shouldDrawDividerBelow(r2, r3) == false) goto L6;
            r1.bottom = this.mDividerHeight;
            return;
        }

        private boolean shouldDrawDividerBelow(View r5, RecyclerView r6) {
            RecyclerView.ViewHolder r0 = r6.getChildViewHolder(r5);
            boolean r2 = false;
            if ((r0 instanceof PreferenceViewHolder) == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == true) goto L10;
            return false;
        L10:
            boolean r4 = this.mAllowDividerAfterLastItem;
            int r7 = r6.indexOfChild(r5);
            if (r7 >= (r6.getChildCount() - 1)) goto L19;
            RecyclerView.ViewHolder r8 = r6.getChildViewHolder(r6.getChildAt(r7 + 1));
            if ((r8 instanceof PreferenceViewHolder) == false) goto L18;
            if (((PreferenceViewHolder) r8).isDividerAllowedAbove() == false) goto L18;
            r2 = true;
        L18:
            return r2;
        L19:
            return r4;
        L5:
            if (((PreferenceViewHolder) r0).isDividerAllowedBelow() == false) goto L7;
            r1 = true;
            goto L8
        }

        public void setDivider(Drawable r2) {
            if (r2 == null) goto L4;
            this.mDividerHeight = r2.getIntrinsicHeight();
        L5:
            this.mDivider = r2;
            this.this$0.mList.invalidateItemDecorations();
            return;
        L4:
            this.mDividerHeight = 0;
            goto L5
        }

        public void setDividerHeight(int r1) {
            this.mDividerHeight = r1;
            this.this$0.mList.invalidateItemDecorations();
        }

        public void setAllowDividerAfterLastItem(boolean r1) {
            this.mAllowDividerAfterLastItem = r1;
        }
    }

    public interface OnPreferenceDisplayDialogCallback {
        boolean onPreferenceDisplayDialog(PreferenceFragmentCompat r1, Preference r2);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragmentCompat r1, Preference r2);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(PreferenceFragmentCompat r1, PreferenceScreen r2);
    }

    private static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {
        private final RecyclerView.Adapter<?> mAdapter;
        private final String mKey;
        private final RecyclerView mList;
        private final Preference mPreference;

        ScrollToPreferenceObserver(RecyclerView.Adapter<?> r1, RecyclerView r2, Preference r3, String r4) {
            this.mAdapter = r1;
            this.mList = r2;
            this.mPreference = r3;
            this.mKey = r4;
        }

        private void scrollToPreference() {
            this.mAdapter.unregisterAdapterDataObserver(this);
            Preference r0 = this.mPreference;
            if (r0 == null) goto L5;
            int r1 = ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(r0);
        L7:
            if (r1 == (-1)) goto L10;
            this.mList.scrollToPosition(r1);
            return;
        L10:
            return;
        L5:
            r1 = ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(this.mKey);
            goto L7
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r1, int r2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r1, int r2, Object r3) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r1, int r2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r1, int r2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r1, int r2, int r3) {
            scrollToPreference();
        }
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    protected void onBindPreferences() {
    }

    public abstract void onCreatePreferences(Bundle r1, String r2);

    protected void onUnbindPreferences() {
    }

    public PreferenceFragmentCompat() {
        this.mDividerDecoration = new DividerDecoration(this);
        this.mLayoutResId = R.layout.preference_list_fragment;
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mRequestFocus = new AnonymousClass2(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        TypedValue r0 = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.preferenceTheme, r0, true);
        int r1 = r0.resourceId;
        if (r1 != 0) goto L5;
        r1 = R.style.PreferenceThemeOverlay;
    L5:
        requireContext().getTheme().applyStyle(r1, false);
        PreferenceManager r2 = new PreferenceManager(requireContext());
        this.mPreferenceManager = r2;
        r2.setOnNavigateToScreenListener(this);
        if (getArguments() == null) goto L8;
        String r3 = getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
    L9:
        onCreatePreferences(r5, r3);
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        TypedArray r0 = requireContext().obtainStyledAttributes(null, R.styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = r0.getResourceId(R.styleable.PreferenceFragmentCompat_android_layout, this.mLayoutResId);
        Drawable r1 = r0.getDrawable(R.styleable.PreferenceFragmentCompat_android_divider);
        int r2 = r0.getDimensionPixelSize(R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean r5 = r0.getBoolean(R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        r0.recycle();
        LayoutInflater r11 = r8.cloneInContext(requireContext());
        View r12 = r11.inflate(this.mLayoutResId, r9, false);
        View r3 = r12.findViewById(android.R.id.list_container);
        if ((r3 instanceof ViewGroup) == false) goto L17;
        ViewGroup r4 = (ViewGroup) r3;
        RecyclerView r13 = onCreateRecyclerView(r11, r4, r10);
        if (r13 == null) goto L15;
        this.mList = r13;
        r13.addItemDecoration(this.mDividerDecoration);
        setDivider(r1);
        if (r2 == (-1)) goto L9;
        setDividerHeight(r2);
    L9:
        this.mDividerDecoration.setAllowDividerAfterLastItem(r5);
        if (this.mList.getParent() != null) goto L12;
        r4.addView(this.mList);
    L12:
        this.mHandler.post(this.mRequestFocus);
        return r12;
    L15:
        throw new RuntimeException("Could not create RecyclerView");
    L17:
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void setDivider(Drawable r1) {
        this.mDividerDecoration.setDivider(r1);
    }

    public void setDividerHeight(int r1) {
        this.mDividerDecoration.setDividerHeight(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (r2 == null) goto L10;
        Bundle r3 = r2.getBundle(PREFERENCES_TAG);
        if (r3 == null) goto L10;
        PreferenceScreen r4 = getPreferenceScreen();
        if (r4 == null) goto L10;
        r4.restoreHierarchyState(r3);
    L10:
        if (this.mHavePrefs == false) goto L14;
        bindPreferences();
        Runnable r5 = this.mSelectPreferenceRunnable;
        if (r5 == null) goto L14;
        r5.run();
        this.mSelectPreferenceRunnable = null;
    L14:
        this.mInitDone = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(null);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs == false) goto L5;
        unbindPreferences();
    L5:
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        PreferenceScreen r1 = getPreferenceScreen();
        if (r1 == null) goto L6;
        Bundle r0 = new Bundle();
        r1.saveHierarchyState(r0);
        r2.putBundle(PREFERENCES_TAG, r0);
        return;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.getPreferenceScreen();
    }

    public void setPreferenceScreen(PreferenceScreen r2) {
        if (this.mPreferenceManager.setPreferences(r2) == false) goto L9;
        if (r2 == null) goto L10;
        onUnbindPreferences();
        this.mHavePrefs = true;
        if (this.mInitDone == false) goto L11;
        postBindPreferences();
        return;
    L11:
        return;
    L10:
        return;
    }

    public void addPreferencesFromResource(int r4) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(requireContext(), r4, getPreferenceScreen()));
    }

    public void setPreferencesFromResource(int r4, String r5) {
        requirePreferenceManager();
        PreferenceScreen r6 = this.mPreferenceManager.inflateFromResource(requireContext(), r4, null);
        Preference r7 = r6;
        if (r5 == null) goto L9;
        Preference r8 = r6.findPreference(r5);
        boolean r0 = r8 instanceof PreferenceScreen;
        r7 = r8;
        if (r0 == true) goto L9;
        throw new IllegalArgumentException("Preference object with key " + r5 + " is not a PreferenceScreen");
    L9:
        setPreferenceScreen((PreferenceScreen) r7);
    }

    @Override // androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r6) {
        if (r6.getFragment() != null) goto L5;
        return false;
    L5:
        if ((getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) == false) goto L7;
        boolean r0 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, r6);
    L8:
        Fragment r2 = this;
    L9:
        if (r0 == true) goto L15;
        if (r2 == null) goto L15;
        if ((r2 instanceof OnPreferenceStartFragmentCallback) == false) goto L14;
        r0 = ((OnPreferenceStartFragmentCallback) r2).onPreferenceStartFragment(this, r6);
    L14:
        r2 = r2.getParentFragment();
    L15:
        if (r0 == false) goto L17;
    L19:
        if (r0 == false) goto L21;
    L23:
        if (r0 == true) goto L32;
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager r1 = getParentFragmentManager();
        Bundle r3 = r6.getExtras();
        Fragment r7 = r1.getFragmentFactory().instantiate(requireActivity().getClassLoader(), r6.getFragment());
        r7.setArguments(r3);
        r7.setTargetFragment(this, 0);
        r1.beginTransaction().replace(((View) requireView().getParent()).getId(), r7).addToBackStack(null).commit();
        return true;
    L32:
        return true;
    L21:
        if ((getActivity() instanceof OnPreferenceStartFragmentCallback) == false) goto L23;
        r0 = ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, r6);
        goto L23
    L17:
        if ((getContext() instanceof OnPreferenceStartFragmentCallback) == false) goto L19;
        r0 = ((OnPreferenceStartFragmentCallback) getContext()).onPreferenceStartFragment(this, r6);
        goto L19
    L7:
        r0 = false;
        goto L8
    }

    @Override // androidx.preference.PreferenceManager.OnNavigateToScreenListener
    public void onNavigateToScreen(PreferenceScreen r4) {
        if ((getCallbackFragment() instanceof OnPreferenceStartScreenCallback) == false) goto L5;
        boolean r0 = ((OnPreferenceStartScreenCallback) getCallbackFragment()).onPreferenceStartScreen(this, r4);
    L6:
        Fragment r1 = this;
    L7:
        if (r0 == true) goto L13;
        if (r1 == null) goto L13;
        if ((r1 instanceof OnPreferenceStartScreenCallback) == false) goto L12;
        r0 = ((OnPreferenceStartScreenCallback) r1).onPreferenceStartScreen(this, r4);
    L12:
        r1 = r1.getParentFragment();
    L13:
        if (r0 == false) goto L15;
    L17:
        if (r0 == false) goto L19;
        return;
    L19:
        if ((getActivity() instanceof OnPreferenceStartScreenCallback) == false) goto L27;
        ((OnPreferenceStartScreenCallback) getActivity()).onPreferenceStartScreen(this, r4);
        return;
    L27:
        return;
    L15:
        if ((getContext() instanceof OnPreferenceStartScreenCallback) == false) goto L17;
        r0 = ((OnPreferenceStartScreenCallback) getContext()).onPreferenceStartScreen(this, r4);
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    public <T extends Preference> T findPreference(CharSequence r1) {
        PreferenceManager r0 = this.mPreferenceManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findPreference(r1);
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) goto L6;
        return;
    L6:
        throw new RuntimeException("This should be called after super.onCreate.");
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1) == false) goto L5;
        return;
    L5:
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    void bindPreferences() {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        getListView().setAdapter(onCreateAdapter(r0));
        r0.onAttached();
    L5:
        onBindPreferences();
    }

    private void unbindPreferences() {
        getListView().setAdapter(null);
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        r0.onDetached();
    L5:
        onUnbindPreferences();
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public RecyclerView onCreateRecyclerView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L7;
        RecyclerView r5 = (RecyclerView) r3.findViewById(R.id.recycler_view);
        if (r5 == null) goto L7;
        return r5;
    L7:
        RecyclerView r6 = (RecyclerView) r2.inflate(R.layout.preference_recyclerview, r3, false);
        r6.setLayoutManager(onCreateLayoutManager());
        r6.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(r6));
        return r6;
    }

    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

    protected RecyclerView.Adapter onCreateAdapter(PreferenceScreen r1) {
        return new PreferenceGroupAdapter(r1);
    }

    @Override // androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference r5) {
        if ((getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback) == false) goto L5;
        boolean r0 = ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).onPreferenceDisplayDialog(this, r5);
    L6:
        Fragment r2 = this;
    L7:
        if (r0 == true) goto L13;
        if (r2 == null) goto L13;
        if ((r2 instanceof OnPreferenceDisplayDialogCallback) == false) goto L12;
        r0 = ((OnPreferenceDisplayDialogCallback) r2).onPreferenceDisplayDialog(this, r5);
    L12:
        r2 = r2.getParentFragment();
    L13:
        if (r0 == false) goto L15;
    L17:
        if (r0 == false) goto L19;
    L21:
        if (r0 == false) goto L24;
        return;
    L24:
        if (getParentFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) goto L27;
        return;
    L27:
        if ((r5 instanceof EditTextPreference) == false) goto L30;
        DialogFragment r6 = EditTextPreferenceDialogFragmentCompat.newInstance(r5.getKey());
    L35:
        r6.setTargetFragment(this, 0);
        r6.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
        return;
    L30:
        if ((r5 instanceof ListPreference) == false) goto L33;
        r6 = ListPreferenceDialogFragmentCompat.newInstance(r5.getKey());
        goto L35
    L33:
        if ((r5 instanceof MultiSelectListPreference) == false) goto L38;
        r6 = MultiSelectListPreferenceDialogFragmentCompat.newInstance(r5.getKey());
        goto L35
    L38:
        throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + r5.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
    L19:
        if ((getActivity() instanceof OnPreferenceDisplayDialogCallback) == false) goto L21;
        r0 = ((OnPreferenceDisplayDialogCallback) getActivity()).onPreferenceDisplayDialog(this, r5);
        goto L21
    L15:
        if ((getContext() instanceof OnPreferenceDisplayDialogCallback) == false) goto L17;
        r0 = ((OnPreferenceDisplayDialogCallback) getContext()).onPreferenceDisplayDialog(this, r5);
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    public void scrollToPreference(String r2) {
        scrollToPreferenceInternal(null, r2);
    }

    public void scrollToPreference(Preference r2) {
        scrollToPreferenceInternal(r2, null);
    }

    private void scrollToPreferenceInternal(final Preference r2, final String r3) {
        Runnable r0 = new AnonymousClass3(this, r2, r3);
        if (this.mList != null) goto L5;
        this.mSelectPreferenceRunnable = r0;
        return;
    L5:
        r0.run();
    }
}
