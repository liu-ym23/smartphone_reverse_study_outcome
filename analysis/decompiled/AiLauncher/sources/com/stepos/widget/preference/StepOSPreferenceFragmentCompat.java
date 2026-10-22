package com.stepos.widget.preference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.g;
import androidx.preference.j;
import androidx.preference.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\f\u001a\u00020\u000bH\u0015¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceFragmentCompat;", "Landroidx/preference/g;", "<init>", "()V", "", "preferencesResId", "", "key", "LY8/t;", "setPreferencesFromResource", "(ILjava/lang/String;)V", "Landroidx/preference/PreferenceScreen;", "preferenceScreen", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onCreateAdapter", "(Landroidx/preference/PreferenceScreen;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/recyclerview/widget/RecyclerView;", "preferenceListHorizontalPaddingPx", "()I", "preferenceListBottomPaddingPx", "", "preferenceItemDividersEnabled", "()Z", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class StepOSPreferenceFragmentCompat extends g {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceFragmentCompat$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "resolveItemDividersEnabled", "(Landroid/content/Context;)Z", "Landroidx/preference/g;", "fragment", "", "preferencesResId", "", "key", "LY8/t;", "inflatePreferences", "(Landroidx/preference/g;ILjava/lang/String;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void inflatePreferences(g fragment, int preferencesResId, String key) throws Resources.NotFoundException {
            p.i(fragment, "fragment");
            j preferenceManager = fragment.getPreferenceManager();
            m mVar = m.f14431a;
            Context contextRequireContext = fragment.requireContext();
            p.h(contextRequireContext, "requireContext(...)");
            p.f(preferenceManager);
            PreferenceScreen preferenceScreenA = mVar.a(contextRequireContext, preferenceManager, preferencesResId, fragment.getPreferenceScreen());
            if (key == null) {
                fragment.setPreferenceScreen(preferenceScreenA);
                return;
            }
            if (((Void) preferenceScreenA.findPreference(key)) != null) {
                throw new IllegalArgumentException(("Preference object with key \"" + key + "\" is not a PreferenceScreen").toString());
            }
            throw new IllegalArgumentException("Preference object with key \"" + key + "\" not found");
        }

        public final boolean resolveItemDividersEnabled(Context context) throws Exception {
            p.i(context, "context");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.steposPreferenceItemDividersEnabled});
            try {
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, true);
                C4946a.a(typedArrayObtainStyledAttributes, null);
                return z10;
            } finally {
            }
        }

        private Companion() {
        }
    }

    public static final void inflatePreferences(g gVar, int i10, String str) throws Resources.NotFoundException {
        INSTANCE.inflatePreferences(gVar, i10, str);
    }

    public static final boolean resolveItemDividersEnabled(Context context) {
        return INSTANCE.resolveItemDividersEnabled(context);
    }

    @Override // androidx.preference.g
    @SuppressLint({"RestrictedApi"})
    public RecyclerView.Adapter<?> onCreateAdapter(PreferenceScreen preferenceScreen) {
        p.i(preferenceScreen, "preferenceScreen");
        StepOSPreferenceGroupAdapter stepOSPreferenceGroupAdapter = new StepOSPreferenceGroupAdapter(preferenceScreen);
        stepOSPreferenceGroupAdapter.setItemDividersEnabled(preferenceItemDividersEnabled());
        stepOSPreferenceGroupAdapter.setListHorizontalInsetPx(preferenceListHorizontalPaddingPx());
        return stepOSPreferenceGroupAdapter;
    }

    @Override // androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        p.i(inflater, "inflater");
        p.i(parent, "parent");
        RecyclerView recyclerViewOnCreateRecyclerView = super.onCreateRecyclerView(inflater, parent, savedInstanceState);
        p.h(recyclerViewOnCreateRecyclerView, "onCreateRecyclerView(...)");
        RecyclerView.ItemAnimator itemAnimator = recyclerViewOnCreateRecyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        int iPreferenceListBottomPaddingPx = preferenceListBottomPaddingPx();
        if (iPreferenceListBottomPaddingPx != 0) {
            recyclerViewOnCreateRecyclerView.setPaddingRelative(recyclerViewOnCreateRecyclerView.getPaddingStart(), recyclerViewOnCreateRecyclerView.getPaddingTop(), recyclerViewOnCreateRecyclerView.getPaddingEnd(), iPreferenceListBottomPaddingPx);
            recyclerViewOnCreateRecyclerView.setClipToPadding(false);
        }
        return recyclerViewOnCreateRecyclerView;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setDivider(null);
        setDividerHeight(0);
    }

    public boolean preferenceItemDividersEnabled() {
        Companion companion = INSTANCE;
        Context contextRequireContext = requireContext();
        p.h(contextRequireContext, "requireContext(...)");
        return companion.resolveItemDividersEnabled(contextRequireContext);
    }

    public int preferenceListBottomPaddingPx() {
        return 0;
    }

    public int preferenceListHorizontalPaddingPx() {
        return getResources().getDimensionPixelSize(R.dimen.stepos_list_group_margin_horizontal);
    }

    @Override // androidx.preference.g
    public void setPreferencesFromResource(int preferencesResId, String key) throws Resources.NotFoundException {
        j preferenceManager = getPreferenceManager();
        m mVar = m.f14431a;
        Context contextRequireContext = requireContext();
        p.h(contextRequireContext, "requireContext(...)");
        p.f(preferenceManager);
        PreferenceScreen preferenceScreenA = mVar.a(contextRequireContext, preferenceManager, preferencesResId, getPreferenceScreen());
        if (key == null) {
            setPreferenceScreen(preferenceScreenA);
            return;
        }
        if (((Void) preferenceScreenA.findPreference(key)) != null) {
            throw new IllegalArgumentException(("Preference object with key \"" + key + "\" is not a PreferenceScreen").toString());
        }
        throw new IllegalArgumentException("Preference object with key \"" + key + "\" not found");
    }
}
