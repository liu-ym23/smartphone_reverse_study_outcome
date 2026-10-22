package androidx.recyclerview.widget;

import K.C0067a;
import K.C0069b;
import K.O;
import K.S;
import L.g;
import L.j;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends C0069b {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends C0069b {
        private Map<View, C0069b> mOriginalItemDelegates = new WeakHashMap();
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
        }

        @Override // K.C0069b
        public boolean dispatchPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            return c0069b != null ? c0069b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // K.C0069b
        @Nullable
        public j getAccessibilityNodeProvider(@NonNull View view) {
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            return c0069b != null ? c0069b.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        public C0069b getAndRemoveOriginalDelegateForItem(View view) {
            return this.mOriginalItemDelegates.remove(view);
        }

        @Override // K.C0069b
        public void onInitializeAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            if (c0069b != null) {
                c0069b.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // K.C0069b
        public void onInitializeAccessibilityNodeInfo(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) g gVar) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, gVar);
                return;
            }
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, gVar);
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            if (c0069b != null) {
                c0069b.onInitializeAccessibilityNodeInfo(view, gVar);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, gVar);
            }
        }

        @Override // K.C0069b
        public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            if (c0069b != null) {
                c0069b.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // K.C0069b
        public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            C0069b c0069b = this.mOriginalItemDelegates.get(viewGroup);
            return c0069b != null ? c0069b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // K.C0069b
        public boolean performAccessibilityAction(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, int i4, @Nullable @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i4, bundle);
            }
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            if (c0069b != null) {
                if (c0069b.performAccessibilityAction(view, i4, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i4, bundle)) {
                return true;
            }
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i4, bundle);
        }

        public void saveOriginalDelegate(View view) {
            WeakHashMap weakHashMap = S.f939a;
            View.AccessibilityDelegate accessibilityDelegateA = O.a(view);
            C0069b c0069b = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof C0067a ? ((C0067a) accessibilityDelegateA).f947a : new C0069b(accessibilityDelegateA);
            if (c0069b == null || c0069b == this) {
                return;
            }
            this.mOriginalItemDelegates.put(view, c0069b);
        }

        @Override // K.C0069b
        public void sendAccessibilityEvent(@NonNull View view, int i4) {
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            if (c0069b != null) {
                c0069b.sendAccessibilityEvent(view, i4);
            } else {
                super.sendAccessibilityEvent(view, i4);
            }
        }

        @Override // K.C0069b
        public void sendAccessibilityEventUnchecked(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            C0069b c0069b = this.mOriginalItemDelegates.get(view);
            if (c0069b != null) {
                c0069b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        C0069b itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof ItemDelegate)) {
            this.mItemDelegate = new ItemDelegate(this);
        } else {
            this.mItemDelegate = (ItemDelegate) itemDelegate;
        }
    }

    @NonNull
    public C0069b getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // K.C0069b
    public void onInitializeAccessibilityEvent(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // K.C0069b
    public void onInitializeAccessibilityNodeInfo(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(gVar);
    }

    @Override // K.C0069b
    public boolean performAccessibilityAction(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, int i4, @Nullable @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
        if (super.performAccessibilityAction(view, i4, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i4, bundle);
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
