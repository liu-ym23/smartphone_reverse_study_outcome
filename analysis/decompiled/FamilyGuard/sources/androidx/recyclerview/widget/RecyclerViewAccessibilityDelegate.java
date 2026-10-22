package androidx.recyclerview.widget;

import E.c;
import E.d;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends C0456a {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends C0456a {
        private Map<View, C0456a> mOriginalItemDelegates = new WeakHashMap();
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
        }

        @Override // androidx.core.view.C0456a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            return c0456a != null ? c0456a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0456a
        public d getAccessibilityNodeProvider(View view) {
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            return c0456a != null ? c0456a.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        C0456a getAndRemoveOriginalDelegateForItem(View view) {
            return this.mOriginalItemDelegates.remove(view);
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            if (c0456a != null) {
                c0456a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                return;
            }
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, cVar);
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            if (c0456a != null) {
                c0456a.onInitializeAccessibilityNodeInfo(view, cVar);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
            }
        }

        @Override // androidx.core.view.C0456a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            if (c0456a != null) {
                c0456a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0456a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0456a c0456a = this.mOriginalItemDelegates.get(viewGroup);
            return c0456a != null ? c0456a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0456a
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i5, bundle);
            }
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            if (c0456a != null) {
                if (c0456a.performAccessibilityAction(view, i5, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i5, bundle)) {
                return true;
            }
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i5, bundle);
        }

        void saveOriginalDelegate(View view) {
            C0456a c0456aK = H.k(view);
            if (c0456aK == null || c0456aK == this) {
                return;
            }
            this.mOriginalItemDelegates.put(view, c0456aK);
        }

        @Override // androidx.core.view.C0456a
        public void sendAccessibilityEvent(View view, int i5) {
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            if (c0456a != null) {
                c0456a.sendAccessibilityEvent(view, i5);
            } else {
                super.sendAccessibilityEvent(view, i5);
            }
        }

        @Override // androidx.core.view.C0456a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            C0456a c0456a = this.mOriginalItemDelegates.get(view);
            if (c0456a != null) {
                c0456a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        C0456a itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof ItemDelegate)) {
            this.mItemDelegate = new ItemDelegate(this);
        } else {
            this.mItemDelegate = (ItemDelegate) itemDelegate;
        }
    }

    public C0456a getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.C0456a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.C0456a
    public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(cVar);
    }

    @Override // androidx.core.view.C0456a
    public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
        if (super.performAccessibilityAction(view, i5, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i5, bundle);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
