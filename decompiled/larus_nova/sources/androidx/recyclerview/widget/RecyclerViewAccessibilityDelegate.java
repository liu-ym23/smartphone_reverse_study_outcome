package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends AccessibilityDelegateCompat {
        private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates;
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate r100) {
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r100) {
            AccessibilityDelegateCompat r101 = this.mOriginalItemDelegates.get(r100);
            if (r101 == null) goto L7;
            return r101.getAccessibilityNodeProvider(r100);
        L7:
            return super.getAccessibilityNodeProvider(r100);
        }

        public AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View r100) {
            return this.mOriginalItemDelegates.remove(r100);
        }

        public void saveOriginalDelegate(View r100) {
            AccessibilityDelegateCompat r101 = ViewCompat.getAccessibilityDelegate(r100);
            if (r101 == null) goto L7;
            if (r101 == this) goto L8;
            this.mOriginalItemDelegates.put(r100, r101);
            return;
        L8:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = this.mOriginalItemDelegates.get(r100);
            if (r102 == null) goto L7;
            return r102.dispatchPopulateAccessibilityEvent(r100, r101);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = this.mOriginalItemDelegates.get(r100);
            if (r102 == null) goto L5;
            r102.onInitializeAccessibilityEvent(r100, r101);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == false) goto L5;
        L10:
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            return;
        L5:
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L10;
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(r100, r101);
            AccessibilityDelegateCompat r102 = this.mOriginalItemDelegates.get(r100);
            if (r102 == null) goto L9;
            r102.onInitializeAccessibilityNodeInfo(r100, r101);
            return;
        L9:
            super.onInitializeAccessibilityNodeInfo(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = this.mOriginalItemDelegates.get(r100);
            if (r102 == null) goto L5;
            r102.onPopulateAccessibilityEvent(r100, r101);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(View r100, int r101) {
            AccessibilityDelegateCompat r102 = this.mOriginalItemDelegates.get(r100);
            if (r102 == null) goto L5;
            r102.sendAccessibilityEvent(r100, r101);
            return;
        L5:
            super.sendAccessibilityEvent(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(View r100, AccessibilityEvent r101) {
            AccessibilityDelegateCompat r102 = this.mOriginalItemDelegates.get(r100);
            if (r102 == null) goto L5;
            r102.sendAccessibilityEventUnchecked(r100, r101);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r100, r101);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
            AccessibilityDelegateCompat r103 = this.mOriginalItemDelegates.get(r100);
            if (r103 == null) goto L7;
            return r103.onRequestSendAccessibilityEvent(r100, r101, r102);
        L7:
            return super.onRequestSendAccessibilityEvent(r100, r101, r102);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == true) goto L17;
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r103 = this.mOriginalItemDelegates.get(r100);
            if (r103 == null) goto L12;
            if (r103.performAccessibilityAction(r100, r101, r102) == false) goto L15;
            return true;
        L15:
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(r100, r101, r102);
        L12:
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L15;
            return true;
        L17:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView r100) {
        this.mRecyclerView = r100;
        AccessibilityDelegateCompat r101 = getItemDelegate();
        if (r101 != null) goto L5;
    L7:
        this.mItemDelegate = new ItemDelegate(this);
        return;
    L5:
        if ((r101 instanceof ItemDelegate) == false) goto L7;
        this.mItemDelegate = (ItemDelegate) r101;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        super.onInitializeAccessibilityEvent(r100, r101);
        if ((r100 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (shouldIgnore() == true) goto L11;
        RecyclerView r102 = (RecyclerView) r100;
        if (r102.getLayoutManager() == null) goto L12;
        r102.getLayoutManager().onInitializeAccessibilityEvent(r101);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        if (shouldIgnore() == false) goto L5;
        return;
    L5:
        if (this.mRecyclerView.getLayoutManager() == null) goto L9;
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(r101);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
        if (super.performAccessibilityAction(r100, r101, r102) == false) goto L7;
        return true;
    L7:
        if (shouldIgnore() == false) goto L9;
        return false;
    L9:
        if (this.mRecyclerView.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(r101, r102);
    }
}
