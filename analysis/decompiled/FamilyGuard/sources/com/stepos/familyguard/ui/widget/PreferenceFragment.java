package com.stepos.familyguard.ui.widget;

import N1.h;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.g;
import androidx.preference.h;
import androidx.preference.k;
import androidx.preference.l;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import f2.C0702g;
import g2.C0737g;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public abstract class PreferenceFragment extends g {

    /* renamed from: o0, reason: collision with root package name */
    private RecyclerView.ItemAnimator f15190o0;

    private class a extends h implements StepOSRecyclerView.u {

        /* renamed from: g, reason: collision with root package name */
        private StepOSRecyclerView f15191g;

        public a(PreferenceGroup preferenceGroup) {
            super(preferenceGroup);
        }

        private void v(int i5, View view) {
            if (view == null) {
                return;
            }
            Object tag = view.getTag();
            boolean zBooleanValue = false;
            if (tag != null && (tag instanceof Boolean)) {
                zBooleanValue = ((Boolean) tag).booleanValue();
            }
            if (zBooleanValue) {
                return;
            }
            Context context = view.getContext();
            int iB = T1.g.b(context, R.attr.marginSmall);
            int iB2 = T1.g.b(context, R.attr.marginSmall);
            int paddingTop = view.getPaddingTop();
            int paddingStart = view.getPaddingStart();
            int paddingBottom = view.getPaddingBottom();
            int paddingEnd = view.getPaddingEnd();
            if (i5 == 3) {
                view.setPadding(paddingStart, paddingTop + iB, paddingEnd, paddingBottom + iB2);
            } else if (i5 == 0) {
                view.setPadding(paddingStart, paddingTop + iB, paddingEnd, paddingBottom);
            } else if (i5 == 2) {
                view.setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom + iB2);
            }
            view.setTag(Boolean.TRUE);
        }

        public int immersiveItemType(int i5) {
            return PreferenceFragment.this.n2(i5, getItemCount());
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.u
        public boolean isEnabled(int i5) {
            Preference preferenceN = n(i5);
            return preferenceN != null && preferenceN.M();
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.u
        public boolean isSelectable(int i5) {
            Preference preferenceN = n(i5);
            return preferenceN != null && preferenceN.O();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            if (recyclerView instanceof StepOSRecyclerView) {
                this.f15191g = (StepOSRecyclerView) recyclerView;
            }
        }

        @Override // androidx.preference.h, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: q */
        public void onBindViewHolder(l lVar, int i5) throws Resources.NotFoundException {
            super.onBindViewHolder(lVar, i5);
            int iImmersiveItemType = immersiveItemType(i5);
            v(iImmersiveItemType, lVar.itemView);
            StepOSRecyclerView stepOSRecyclerView = this.f15191g;
            if (stepOSRecyclerView != null) {
                stepOSRecyclerView.W0(lVar.itemView, iImmersiveItemType);
            }
            View viewFindViewById = lVar.itemView.findViewById(R.id.row_divider);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility((iImmersiveItemType == 0 || iImmersiveItemType == 1) ? 0 : 8);
            }
        }

        @Override // androidx.preference.h, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: s */
        public l onCreateViewHolder(ViewGroup viewGroup, int i5) {
            return super.onCreateViewHolder(viewGroup, i5);
        }
    }

    public class b extends RecyclerView.ItemDecoration {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            PreferenceFragment.this.l2(childAdapterPosition, adapter == null ? 0 : adapter.getItemCount(), rect, view, recyclerView, state);
        }
    }

    private h.InterfaceC0062h m2() {
        return N1.h.b(this).b("mLayoutResId");
    }

    @Override // androidx.preference.g
    protected RecyclerView.Adapter a2(PreferenceScreen preferenceScreen) {
        return new a(preferenceScreen);
    }

    @Override // androidx.preference.g
    public RecyclerView d2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerViewD2 = (RecyclerView) viewGroup.findViewById(android.R.id.list);
        if (recyclerViewD2 == null) {
            recyclerViewD2 = super.d2(layoutInflater, viewGroup, bundle);
        }
        recyclerViewD2.setLayoutManager(b2());
        recyclerViewD2.setAccessibilityDelegateCompat(new k(recyclerViewD2));
        if (recyclerViewD2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) recyclerViewD2).X0();
        }
        recyclerViewD2.addItemDecoration(new b());
        this.f15190o0 = recyclerViewD2.getItemAnimator();
        recyclerViewD2.setItemAnimator(null);
        return recyclerViewD2;
    }

    public void l2(int i5, int i6, Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
    }

    public int n2(int i5, int i6) {
        return 0;
    }

    protected void o2(int i5) {
        try {
            m2().a(this, i5);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e6) {
            e6.printStackTrace();
        }
    }

    protected void p2(boolean z5) {
        if (z5) {
            X1().setItemAnimator(this.f15190o0);
        } else {
            X1().setItemAnimator(null);
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = A1().obtainStyledAttributes(null, C0737g.f17280H2, R.attr.preferenceFragmentCompatStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != R.layout.us_preferences_fragment) {
            C0702g.p("PreferenceFragment", "onCreateView: error layoutId = " + resourceId);
            o2(R.layout.us_preferences_fragment);
        }
        return super.z0(layoutInflater, viewGroup, bundle);
    }
}
