package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.fragment.app.C0279a;
import androidx.fragment.app.T;
import androidx.fragment.app.Y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.alphame.R;
import e.EnumC0546d;
import f0.HandlerC0555a;

/* loaded from: classes.dex */
public abstract class y extends androidx.fragment.app.D implements G, E, F, InterfaceC0330b {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private H mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final w mDividerDecoration = new w(this);
    private int mLayoutResId = R.layout.preference_list_fragment;
    private final Handler mHandler = new HandlerC0555a(this, Looper.getMainLooper(), 1);
    private final Runnable mRequestFocus = new u(0, this);

    public void addPreferencesFromResource(@XmlRes int i4) {
        H h4 = this.mPreferenceManager;
        if (h4 == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        setPreferenceScreen(h4.c(requireContext(), i4, getPreferenceScreen()));
    }

    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.j();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.InterfaceC0330b
    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        PreferenceScreen preferenceScreen;
        H h4 = this.mPreferenceManager;
        if (h4 == null || (preferenceScreen = h4.f4028g) == null) {
            return null;
        }
        return (T) preferenceScreen.z(charSequence);
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public androidx.fragment.app.D getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public H getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.f4028g;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void onBindPreferences() {
    }

    @Override // androidx.fragment.app.D
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i4 = typedValue.resourceId;
        if (i4 == 0) {
            i4 = R.style.PreferenceThemeOverlay;
        }
        requireContext().getTheme().applyStyle(i4, false);
        H h4 = new H(requireContext());
        this.mPreferenceManager = h4;
        h4.f4031j = this;
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString(ARG_PREFERENCE_ROOT) : null);
    }

    public RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new C(preferenceScreen);
    }

    @NonNull
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new J(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.D
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = requireContext().obtainStyledAttributes(null, L.f4048h, R.attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(0, this.mLayoutResId);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(3, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(requireContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewOnCreateRecyclerView = onCreateRecyclerView(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewOnCreateRecyclerView == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.mList = recyclerViewOnCreateRecyclerView;
        recyclerViewOnCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
        setDivider(drawable);
        if (dimensionPixelSize != -1) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mDividerDecoration.f4170c = z4;
        if (this.mList.getParent() == null) {
            viewGroup2.addView(this.mList);
        }
        this.mHandler.post(this.mRequestFocus);
        return viewInflate;
    }

    @Override // androidx.fragment.app.D
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            getListView().setAdapter(null);
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                preferenceScreen.n();
            }
            onUnbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.E
    public void onDisplayPreferenceDialog(@NonNull Preference preference) {
        androidx.fragment.app.r c0340l;
        getCallbackFragment();
        for (androidx.fragment.app.D parentFragment = this; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
        }
        getContext();
        a();
        if (getParentFragmentManager().B(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            String str = preference.f4088l;
            c0340l = new C0333e();
            Bundle bundle = new Bundle(1);
            bundle.putString(Action.KEY_ATTRIBUTE, str);
            c0340l.setArguments(bundle);
        } else if (preference instanceof ListPreference) {
            String str2 = preference.f4088l;
            c0340l = new C0337i();
            Bundle bundle2 = new Bundle(1);
            bundle2.putString(Action.KEY_ATTRIBUTE, str2);
            c0340l.setArguments(bundle2);
        } else {
            if (!(preference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            String str3 = preference.f4088l;
            c0340l = new C0340l();
            Bundle bundle3 = new Bundle(1);
            bundle3.putString(Action.KEY_ATTRIBUTE, str3);
            c0340l.setArguments(bundle3);
        }
        c0340l.setTargetFragment(this, 0);
        Y parentFragmentManager = getParentFragmentManager();
        c0340l.f3822n = false;
        c0340l.f3823o = true;
        parentFragmentManager.getClass();
        C0279a c0279a = new C0279a(parentFragmentManager);
        c0279a.f3703p = true;
        c0279a.e(0, c0340l, DIALOG_FRAGMENT_TAG, 1);
        c0279a.d(false);
    }

    @Override // androidx.preference.F
    public void onNavigateToScreen(@NonNull PreferenceScreen preferenceScreen) {
        getCallbackFragment();
        for (androidx.fragment.app.D parentFragment = this; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
        }
        getContext();
        a();
    }

    @Override // androidx.preference.G
    public boolean onPreferenceTreeClick(@NonNull Preference preference) {
        if (preference.f4090n == null) {
            return false;
        }
        getCallbackFragment();
        for (androidx.fragment.app.D parentFragment = this; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
        }
        getContext();
        a();
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        Y parentFragmentManager = getParentFragmentManager();
        if (preference.f4091o == null) {
            preference.f4091o = new Bundle();
        }
        Bundle bundle = preference.f4091o;
        T tD = parentFragmentManager.D();
        requireActivity().getClassLoader();
        androidx.fragment.app.D dA = tD.a(preference.f4090n);
        dA.setArguments(bundle);
        dA.setTargetFragment(this, 0);
        C0279a c0279a = new C0279a(parentFragmentManager);
        c0279a.g(dA, ((View) requireView().getParent()).getId());
        if (!c0279a.f3695h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        c0279a.f3694g = true;
        c0279a.f3696i = null;
        c0279a.d(false);
        return true;
    }

    @Override // androidx.fragment.app.D
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.c(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.D
    public void onStart() {
        super.onStart();
        H h4 = this.mPreferenceManager;
        h4.f4029h = this;
        h4.f4030i = this;
    }

    @Override // androidx.fragment.app.D
    public void onStop() {
        super.onStop();
        H h4 = this.mPreferenceManager;
        h4.f4029h = null;
        h4.f4030i = null;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void onUnbindPreferences() {
    }

    @Override // androidx.fragment.app.D
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.b(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(@NonNull Preference preference) {
        v vVar = new v(this, preference, null);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = vVar;
        } else {
            vVar.run();
        }
    }

    public void setDivider(@Nullable Drawable drawable) {
        w wVar = this.mDividerDecoration;
        if (drawable != null) {
            wVar.getClass();
            wVar.f4169b = drawable.getIntrinsicHeight();
        } else {
            wVar.f4169b = 0;
        }
        wVar.f4168a = drawable;
        wVar.f4171d.mList.invalidateItemDecorations();
    }

    public void setDividerHeight(int i4) {
        w wVar = this.mDividerDecoration;
        wVar.f4169b = i4;
        wVar.f4171d.mList.invalidateItemDecorations();
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        H h4 = this.mPreferenceManager;
        PreferenceScreen preferenceScreen2 = h4.f4028g;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.n();
            }
            h4.f4028g = preferenceScreen;
            if (preferenceScreen != null) {
                onUnbindPreferences();
                this.mHavePrefs = true;
                if (!this.mInitDone || this.mHandler.hasMessages(1)) {
                    return;
                }
                this.mHandler.obtainMessage(1).sendToTarget();
            }
        }
    }

    public void setPreferencesFromResource(@XmlRes int i4, @Nullable String str) {
        H h4 = this.mPreferenceManager;
        if (h4 == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        PreferenceScreen preferenceScreenC = h4.c(requireContext(), i4, null);
        PreferenceScreen preferenceScreen = preferenceScreenC;
        if (str != null) {
            Preference preferenceZ = preferenceScreenC.z(str);
            boolean z4 = preferenceZ instanceof PreferenceScreen;
            preferenceScreen = preferenceZ;
            if (!z4) {
                throw new IllegalArgumentException(B0.g.n("Preference object with key ", str, " is not a PreferenceScreen"));
            }
        }
        setPreferenceScreen(preferenceScreen);
    }

    public void scrollToPreference(@NonNull String str) {
        v vVar = new v(this, null, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = vVar;
        } else {
            vVar.run();
        }
    }
}
