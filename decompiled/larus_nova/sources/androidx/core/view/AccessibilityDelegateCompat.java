package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = null;
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat r100) {
            this.mCompat = r100;
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r100) {
            AccessibilityNodeProviderCompat r101 = this.mCompat.getAccessibilityNodeProvider(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) r101.getProvider();
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(r100, r101);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            this.mCompat.onInitializeAccessibilityEvent(r100, r101);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101) {
            AccessibilityNodeInfoCompat r102 = AccessibilityNodeInfoCompat.wrap(r101);
            r102.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(r100));
            r102.setHeading(ViewCompat.isAccessibilityHeading(r100));
            r102.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(r100));
            r102.setStateDescription(ViewCompat.getStateDescription(r100));
            this.mCompat.onInitializeAccessibilityNodeInfo(r100, r102);
            r102.addSpansToExtras(r101.getText(), r100);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r103 = AccessibilityDelegateCompat.getActionList(r100);
            int r104 = 0;
        L4:
            if (r104 >= r103.size()) goto L6;
            r102.addAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat) ListProtector.get(r103, r104));
            r104 = r104 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            this.mCompat.onPopulateAccessibilityEvent(r100, r101);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r100, int r101) {
            this.mCompat.sendAccessibilityEvent(r100, r101);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r100, AccessibilityEvent r101) {
            this.mCompat.sendAccessibilityEventUnchecked(r100, r101);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
            return this.mCompat.onRequestSendAccessibilityEvent(r100, r101, r102);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            return this.mCompat.performAccessibilityAction(r100, r101, r102);
        }
    }

    static {
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate r100) {
        this.mOriginalDelegate = r100;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r100) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r101 = (List) r100.getTag(R.id.tag_accessibility_actions);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Collections.emptyList();
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r100) {
        AccessibilityNodeProvider r101 = this.mOriginalDelegate.getAccessibilityNodeProvider(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return new AccessibilityNodeProviderCompat(r101);
    }

    private boolean isSpanStillValid(ClickableSpan r100, View r101) {
        if (r100 == null) goto L13;
        ClickableSpan[] r102 = AccessibilityNodeInfoCompat.getClickableSpans(r101.createAccessibilityNodeInfo().getText());
        int r103 = 0;
    L5:
        if (r102 == null) goto L13;
        if (r103 >= r102.length) goto L13;
        if (r100.equals(r102[r103]) == true) goto L10;
        r103 = r103 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    private boolean performClickableSpanAction(int r100, View r101) {
        SparseArray r102 = (SparseArray) r101.getTag(R.id.tag_accessibility_clickable_spans);
        if (r102 == null) goto L10;
        WeakReference r103 = (WeakReference) r102.get(r100);
        if (r103 == null) goto L12;
        ClickableSpan r104 = (ClickableSpan) r103.get();
        if (isSpanStillValid(r104, r101) == false) goto L13;
        r104.onClick(r101);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(r100, r101);
    }

    public void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(r100, r101);
    }

    public void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(r100, r101.unwrap());
    }

    public void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(r100, r101);
    }

    public void sendAccessibilityEvent(View r100, int r101) {
        this.mOriginalDelegate.sendAccessibilityEvent(r100, r101);
    }

    public void sendAccessibilityEventUnchecked(View r100, AccessibilityEvent r101) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(r100, r101);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(r100, r101, r102);
    }

    public boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r103 = getActionList(r100);
        boolean r104 = false;
        int r105 = 0;
    L4:
        if (r105 >= r103.size()) goto L9;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r106 = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) ListProtector.get(r103, r105);
        if (r106.getId() == r101) goto L7;
        r105 = r105 + 1;
        goto L4
    L7:
        r104 = r106.perform(r100, r102);
    L9:
        if (r104 == true) goto L11;
        r104 = this.mOriginalDelegate.performAccessibilityAction(r100, r101, r102);
    L11:
        if (r104 == false) goto L13;
        return r104;
    L13:
        if (r101 != R.id.accessibility_action_clickable_span) goto L20;
        if (r102 != null) goto L16;
        return r104;
    L16:
        return performClickableSpanAction(r102.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), r100);
    L20:
        return r104;
    }
}
