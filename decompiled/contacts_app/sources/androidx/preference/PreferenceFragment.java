package androidx.preference;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class PreferenceFragment extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {

    @Deprecated
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private final DividerDecoration mDividerDecoration;
    private final Handler mHandler;
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayoutResId;
    RecyclerView mList;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus;
    private Runnable mSelectPreferenceRunnable;
    private Context mStyledContext;

    private class DividerDecoration extends RecyclerView.ItemDecoration {
        private boolean mAllowDividerAfterLastItem;
        private Drawable mDivider;
        private int mDividerHeight;
        final /* synthetic */ PreferenceFragment this$0;

        DividerDecoration(PreferenceFragment r1) {
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
        boolean onPreferenceDisplayDialog(PreferenceFragment r1, Preference r2);
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragment r1, Preference r2);
    }

    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(PreferenceFragment r1, PreferenceScreen r2);
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

    @Deprecated
    public abstract void onCreatePreferences(Bundle r1, String r2);

    protected void onUnbindPreferences() {
    }

    public PreferenceFragment() {
        this.mDividerDecoration = new DividerDecoration(this);
        this.mLayoutResId = R.layout.preference_list_fragment;
        this.mHandler = new AnonymousClass1(this);
        this.mRequestFocus = new AnonymousClass2(this);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        TypedValue r0 = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, r0, true);
        int r1 = r0.resourceId;
        if (r1 != 0) goto L5;
        r1 = R.style.PreferenceThemeOverlay;
    L5:
        this.mStyledContext = new ContextThemeWrapper(getActivity(), r1);
        PreferenceManager r2 = new PreferenceManager(this.mStyledContext);
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

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        TypedArray r0 = this.mStyledContext.obtainStyledAttributes(null, R.styleable.PreferenceFragment, TypedArrayUtils.getAttr(this.mStyledContext, R.attr.preferenceFragmentStyle, android.R.attr.preferenceFragmentStyle), 0);
        this.mLayoutResId = r0.getResourceId(R.styleable.PreferenceFragment_android_layout, this.mLayoutResId);
        Drawable r1 = r0.getDrawable(R.styleable.PreferenceFragment_android_divider);
        int r2 = r0.getDimensionPixelSize(R.styleable.PreferenceFragment_android_dividerHeight, -1);
        boolean r5 = r0.getBoolean(R.styleable.PreferenceFragment_allowDividerAfterLastItem, true);
        r0.recycle();
        LayoutInflater r11 = r8.cloneInContext(this.mStyledContext);
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
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    @Deprecated
    public void setDivider(Drawable r1) {
        this.mDividerDecoration.setDivider(r1);
    }

    @Deprecated
    public void setDividerHeight(int r1) {
        this.mDividerDecoration.setDividerHeight(r1);
    }

    @Override // android.app.Fragment
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

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(this);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(null);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(null);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs == false) goto L5;
        unbindPreferences();
    L5:
        this.mList = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        PreferenceScreen r1 = getPreferenceScreen();
        if (r1 == null) goto L6;
        Bundle r0 = new Bundle();
        r1.saveHierarchyState(r0);
        r2.putBundle(PREFERENCES_TAG, r0);
        return;
    }

    @Deprecated
    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    @Deprecated
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

    @Deprecated
    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.getPreferenceScreen();
    }

    @Deprecated
    public void addPreferencesFromResource(int r4) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(this.mStyledContext, r4, getPreferenceScreen()));
    }

    @Deprecated
    public void setPreferencesFromResource(int r4, String r5) {
        requirePreferenceManager();
        PreferenceScreen r6 = this.mPreferenceManager.inflateFromResource(this.mStyledContext, r4, null);
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
    @Deprecated
    public boolean onPreferenceTreeClick(Preference r3) {
        boolean r1 = false;
        if (r3.getFragment() != null) goto L5;
        return false;
    L5:
        if ((getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) == false) goto L7;
        r1 = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, r3);
    L7:
        if (r1 == false) goto L9;
        return r1;
    L9:
        if ((getActivity() instanceof OnPreferenceStartFragmentCallback) == true) goto L11;
        return r1;
    L11:
        return ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, r3);
    }

    @Override // androidx.preference.PreferenceManager.OnNavigateToScreenListener
    @Deprecated
    public void onNavigateToScreen(PreferenceScreen r2) {
        if ((getCallbackFragment() instanceof OnPreferenceStartScreenCallback) == false) goto L5;
        boolean r0 = ((OnPreferenceStartScreenCallback) getCallbackFragment()).onPreferenceStartScreen(this, r2);
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if ((getActivity() instanceof OnPreferenceStartScreenCallback) == false) goto L12;
        ((OnPreferenceStartScreenCallback) getActivity()).onPreferenceStartScreen(this, r2);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    @Deprecated
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
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        r0.onDetached();
    L5:
        onUnbindPreferences();
    }

    @Deprecated
    public final RecyclerView getListView() {
        return this.mList;
    }

    @Deprecated
    public RecyclerView onCreateRecyclerView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (this.mStyledContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L7;
        RecyclerView r5 = (RecyclerView) r3.findViewById(R.id.recycler_view);
        if (r5 == null) goto L7;
        return r5;
    L7:
        RecyclerView r6 = (RecyclerView) r2.inflate(R.layout.preference_recyclerview, r3, false);
        r6.setLayoutManager(onCreateLayoutManager());
        r6.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(r6));
        return r6;
    }

    @Deprecated
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Deprecated
    protected RecyclerView.Adapter onCreateAdapter(PreferenceScreen r1) {
        return new PreferenceGroupAdapter(r1);
    }

    @Override // androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    @Deprecated
    public void onDisplayPreferenceDialog(Preference r4) {
        if ((getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback) == false) goto L5;
        boolean r0 = ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).onPreferenceDisplayDialog(this, r4);
    L6:
        if (r0 == false) goto L8;
    L10:
        if (r0 == false) goto L13;
        return;
    L13:
        if (getFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) goto L16;
        return;
    L16:
        if ((r4 instanceof EditTextPreference) == false) goto L19;
        DialogFragment r5 = EditTextPreferenceDialogFragment.newInstance(r4.getKey());
    L24:
        r5.setTargetFragment(this, 0);
        r5.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
        return;
    L19:
        if ((r4 instanceof ListPreference) == false) goto L22;
        r5 = ListPreferenceDialogFragment.newInstance(r4.getKey());
        goto L24
    L22:
        if ((r4 instanceof MultiSelectListPreference) == false) goto L27;
        r5 = MultiSelectListPreferenceDialogFragment.newInstance(r4.getKey());
        goto L24
    L27:
        throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
    L8:
        if ((getActivity() instanceof OnPreferenceDisplayDialogCallback) == false) goto L10;
        r0 = ((OnPreferenceDisplayDialogCallback) getActivity()).onPreferenceDisplayDialog(this, r4);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated
    public void scrollToPreference(String r2) {
        scrollToPreferenceInternal(null, r2);
    }

    @Deprecated
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
