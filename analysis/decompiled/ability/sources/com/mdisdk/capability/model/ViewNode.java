package com.mdisdk.capability.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appfunctions.metadata.a;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.mdisdk.capability.utils.A11yBridge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ViewNode implements Parcelable {
    public static final Parcelable.Creator<ViewNode> CREATOR = new Parcelable.Creator<ViewNode>() { // from class: com.mdisdk.capability.model.ViewNode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewNode createFromParcel(Parcel parcel) {
            return new ViewNode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewNode[] newArray(int i) {
            return new ViewNode[i];
        }
    };
    private static final String TAG = "ViewNode";

    @NonNull
    private final Rect bounds;

    @NonNull
    private final List<ViewNode> children;

    @NonNull
    private final String className;

    @Nullable
    private final String contentDescription;

    @Nullable
    private final String hint;
    private final int index;
    private final boolean isCheckable;
    private final boolean isClickable;
    private final boolean isEnabled;
    private final boolean isFocused;
    private final boolean isTextEditor;
    private final boolean isVisible;
    private final boolean mHorizontalScrollable;
    private final boolean mVerticalScrollable;
    private final long nodeId;

    @NonNull
    private final String packageName;
    private final int progress;
    private final int progressMax;
    private final int progressMin;

    @Nullable
    private final String text;

    @Nullable
    private final String viewId;

    public static class BuildResult {

        @NonNull
        private final Map<Long, View> nodeToViewIndex;

        @NonNull
        private final ViewNode rootNode;

        public BuildResult(@NonNull ViewNode viewNode, @NonNull Map<Long, View> map) {
            this.rootNode = viewNode;
            this.nodeToViewIndex = map;
        }

        @Nullable
        public View findView(@NonNull ViewNode viewNode) {
            return this.nodeToViewIndex.get(Long.valueOf(viewNode.getNodeId()));
        }

        @NonNull
        public List<View> findViews(@NonNull List<ViewNode> list) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<ViewNode> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(this.nodeToViewIndex.get(Long.valueOf(it.next().getNodeId())));
            }
            return arrayList;
        }

        @NonNull
        public Map<Long, View> getNodeToViewIndex() {
            return this.nodeToViewIndex;
        }

        @NonNull
        public ViewNode getRootNode() {
            return this.rootNode;
        }

        public boolean isEmpty() {
            return this.nodeToViewIndex.isEmpty();
        }

        public int size() {
            return this.nodeToViewIndex.size();
        }

        @Nullable
        public View findView(long j5) {
            return this.nodeToViewIndex.get(Long.valueOf(j5));
        }
    }

    public ViewNode(long j5, int i, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, boolean z10, boolean z11, boolean z12, @NonNull Rect rect, @NonNull List<ViewNode> list, @Nullable String str5, boolean z13, int i6, int i10, int i11, boolean z14, boolean z15, boolean z16, boolean z17, @Nullable String str6) {
        this.nodeId = j5;
        this.index = i;
        this.className = str;
        this.packageName = str2;
        this.text = str3;
        this.contentDescription = str4;
        this.isClickable = z10;
        this.isEnabled = z11;
        this.isVisible = z12;
        this.bounds = rect;
        this.children = list;
        this.viewId = str5;
        this.isCheckable = z13;
        this.progress = i6;
        this.progressMax = i10;
        this.progressMin = i11;
        this.mHorizontalScrollable = z14;
        this.mVerticalScrollable = z15;
        this.isFocused = z16;
        this.isTextEditor = z17;
        this.hint = str6;
    }

    public static ViewNode build(@NonNull View view) {
        return buildRecursive(view, -1);
    }

    @Nullable
    private static ViewNode buildFromA11y(@NonNull AccessibilityNodeProvider accessibilityNodeProvider, int i, int i6, @NonNull String str, @NonNull View view, @Nullable Map<Long, View> map) {
        int max;
        int i10;
        int min;
        String str2;
        int i11;
        String string = null;
        try {
            AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = accessibilityNodeProvider.createAccessibilityNodeInfo(i);
            if (accessibilityNodeInfoCreateAccessibilityNodeInfo == null) {
                return null;
            }
            CharSequence className = accessibilityNodeInfoCreateAccessibilityNodeInfo.getClassName();
            String string2 = className != null ? className.toString() : AndroidComposeViewAccessibilityDelegateCompat.ClassName;
            CharSequence packageName = accessibilityNodeInfoCreateAccessibilityNodeInfo.getPackageName();
            String string3 = (packageName == null || packageName.length() <= 0) ? str : packageName.toString();
            CharSequence text = accessibilityNodeInfoCreateAccessibilityNodeInfo.getText();
            String string4 = (text == null || text.length() <= 0) ? null : text.toString();
            CharSequence hintText = accessibilityNodeInfoCreateAccessibilityNodeInfo.getHintText();
            String string5 = (hintText == null || hintText.length() <= 0) ? null : hintText.toString();
            CharSequence contentDescription = accessibilityNodeInfoCreateAccessibilityNodeInfo.getContentDescription();
            if (contentDescription != null && contentDescription.length() > 0) {
                string = contentDescription.toString();
            }
            String str3 = string;
            android.graphics.Rect rect = new android.graphics.Rect();
            accessibilityNodeInfoCreateAccessibilityNodeInfo.getBoundsInScreen(rect);
            Rect rect2 = new Rect(rect.left, rect.top, rect.right, rect.bottom);
            boolean zIsVisibleToUser = accessibilityNodeInfoCreateAccessibilityNodeInfo.isVisibleToUser();
            boolean zIsEnabled = accessibilityNodeInfoCreateAccessibilityNodeInfo.isEnabled();
            boolean z10 = accessibilityNodeInfoCreateAccessibilityNodeInfo.isClickable() || accessibilityNodeInfoCreateAccessibilityNodeInfo.isLongClickable();
            boolean zIsCheckable = accessibilityNodeInfoCreateAccessibilityNodeInfo.isCheckable();
            boolean zIsFocused = accessibilityNodeInfoCreateAccessibilityNodeInfo.isFocused();
            boolean zIsEditable = accessibilityNodeInfoCreateAccessibilityNodeInfo.isEditable();
            String viewIdResourceName = accessibilityNodeInfoCreateAccessibilityNodeInfo.getViewIdResourceName();
            int id = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT.getId();
            int id2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT.getId();
            int id3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP.getId();
            int id4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN.getId();
            boolean z11 = hasAction(accessibilityNodeInfoCreateAccessibilityNodeInfo, id) || hasAction(accessibilityNodeInfoCreateAccessibilityNodeInfo, id2);
            boolean z12 = hasAction(accessibilityNodeInfoCreateAccessibilityNodeInfo, id3) || hasAction(accessibilityNodeInfoCreateAccessibilityNodeInfo, id4);
            boolean z13 = (z11 || z12 || !(hasAction(accessibilityNodeInfoCreateAccessibilityNodeInfo, 4096) || hasAction(accessibilityNodeInfoCreateAccessibilityNodeInfo, 8192))) ? z12 : true;
            AccessibilityNodeInfo.RangeInfo rangeInfo = accessibilityNodeInfoCreateAccessibilityNodeInfo.getRangeInfo();
            if (rangeInfo != null) {
                int current = (int) rangeInfo.getCurrent();
                max = (int) rangeInfo.getMax();
                min = (int) rangeInfo.getMin();
                i10 = current;
            } else {
                max = 100;
                i10 = 0;
                min = 0;
            }
            int i12 = max;
            ArrayList arrayList = new ArrayList();
            int childCount = accessibilityNodeInfoCreateAccessibilityNodeInfo.getChildCount();
            int i13 = 0;
            while (i13 < childCount) {
                int iUnpackVirtualId = A11yBridge.unpackVirtualId(A11yBridge.getChildLongId(accessibilityNodeInfoCreateAccessibilityNodeInfo, i13));
                try {
                    if (accessibilityNodeProvider.createAccessibilityNodeInfo(iUnpackVirtualId) == null) {
                        str2 = string3;
                        i11 = childCount;
                    } else {
                        String str4 = string3;
                        i11 = childCount;
                        str2 = str4;
                        ViewNode viewNodeBuildFromA11y = buildFromA11y(accessibilityNodeProvider, iUnpackVirtualId, i13, str2, view, map);
                        if (viewNodeBuildFromA11y != null) {
                            arrayList.add(viewNodeBuildFromA11y);
                        }
                    }
                } catch (Throwable th) {
                    str2 = string3;
                    i11 = childCount;
                    StringBuilder sbS = a.s(i13, "walk virtual child idx=", i, " under vId=", " failed: ");
                    sbS.append(th);
                    Log.w(TAG, sbS.toString());
                }
                i13++;
                childCount = i11;
                string3 = str2;
            }
            String str5 = string3;
            if (map == null) {
                return new ViewNode(i6, string2, str5, string4, str3, z10, zIsEnabled, zIsVisibleToUser, rect2, arrayList, viewIdResourceName, zIsCheckable, i10, i12, min, z11, z13, zIsFocused, zIsEditable, string5);
            }
            long jHashCode = (i & 4294967295L) | (view.hashCode() << 32);
            ViewNode viewNode = new ViewNode(jHashCode, i6, string2, str5, string4, str3, z10, zIsEnabled, zIsVisibleToUser, rect2, arrayList, viewIdResourceName, zIsCheckable, i10, i12, min, z11, z13, zIsFocused, zIsEditable, string5);
            map.put(Long.valueOf(jHashCode), view);
            return viewNode;
        } catch (Throwable th2) {
            Log.w(TAG, "createAccessibilityNodeInfo(" + i + ") failed: " + th2);
            return null;
        }
    }

    private static ViewNode buildRecursive(@NonNull View view, int i) {
        View view2;
        String str;
        String string;
        int max;
        int min;
        int progress;
        int i6;
        boolean z10;
        boolean z11;
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (A11yBridge.isComposeHost(view) && A11yBridge.isReflectionReady() && (accessibilityNodeProvider = view.getAccessibilityNodeProvider()) != null) {
            view2 = view;
            ViewNode viewNodeBuildFromA11y = buildFromA11y(accessibilityNodeProvider, -1, i, view.getContext().getPackageName(), view2, null);
            if (viewNodeBuildFromA11y != null) {
                return viewNodeBuildFromA11y;
            }
        } else {
            view2 = view;
        }
        String packageName = view2.getContext().getPackageName();
        String name = view2.getClass().getName();
        boolean z12 = view2 instanceof TextView;
        String string2 = null;
        if (z12) {
            TextView textView = (TextView) view2;
            CharSequence text = textView.getText();
            String string3 = (text == null || text.length() <= 0) ? null : text.toString();
            CharSequence hint = textView.getHint();
            string = (hint == null || hint.length() <= 0) ? null : hint.toString();
            str = string3;
        } else {
            str = null;
            string = null;
        }
        CharSequence contentDescription = view2.getContentDescription();
        if (contentDescription != null && contentDescription.length() > 0) {
            string2 = contentDescription.toString();
        }
        String str2 = string2;
        boolean z13 = view2.getVisibility() == 0;
        boolean zIsEnabled = view2.isEnabled();
        boolean z14 = view2.isClickable() || view2.isFocusable() || view2.isLongClickable();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        Rect rect = new Rect(i10, iArr[1], view2.getWidth() + i10, view2.getHeight() + iArr[1]);
        ArrayList arrayList = new ArrayList();
        boolean z15 = view2 instanceof ViewGroup;
        if (z15) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int i11 = 0;
            while (i11 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i11);
                boolean z16 = z12;
                if (childAt.getVisibility() != 8) {
                    arrayList.add(buildRecursive(childAt, i11));
                }
                i11++;
                z12 = z16;
            }
        }
        boolean z17 = z12;
        String strExtractId = extractId(view2.toString());
        boolean z18 = view2 instanceof Checkable;
        if (view2 instanceof SeekBar) {
            SeekBar seekBar = (SeekBar) view2;
            progress = seekBar.getProgress();
            max = seekBar.getMax();
            min = seekBar.getMin();
        } else {
            max = 100;
            min = 0;
            progress = 0;
        }
        if (z15) {
            ViewGroup viewGroup2 = (ViewGroup) view2;
            i6 = min;
            z11 = viewGroup2.canScrollVertically(1) || viewGroup2.canScrollVertically(-1);
            z10 = viewGroup2.canScrollHorizontally(1) || viewGroup2.canScrollHorizontally(-1);
        } else {
            i6 = min;
            z10 = false;
            z11 = false;
        }
        return new ViewNode(view2.hashCode(), i, name, packageName, str, str2, z14, zIsEnabled, z13, rect, arrayList, strExtractId, z18, progress, max, i6, z10, z11, view2.isFocused(), (view2 instanceof EditText) || (z17 && view2.onCheckIsTextEditor()), string);
    }

    private static ViewNode buildRecursiveWithIndex(@NonNull View view, int i, @NonNull Map<Long, View> map) {
        View view2;
        Map<Long, View> map2;
        String str;
        String string;
        int max;
        int i6;
        int min;
        boolean z10;
        boolean z11;
        boolean z12;
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (A11yBridge.isComposeHost(view) && A11yBridge.isReflectionReady() && (accessibilityNodeProvider = view.getAccessibilityNodeProvider()) != null) {
            view2 = view;
            ViewNode viewNodeBuildFromA11y = buildFromA11y(accessibilityNodeProvider, -1, i, view.getContext().getPackageName(), view2, map);
            map2 = map;
            if (viewNodeBuildFromA11y != null) {
                return viewNodeBuildFromA11y;
            }
        } else {
            view2 = view;
            map2 = map;
        }
        String packageName = view2.getContext().getPackageName();
        String name = view2.getClass().getName();
        boolean z13 = view2 instanceof TextView;
        String string2 = null;
        if (z13) {
            TextView textView = (TextView) view2;
            CharSequence text = textView.getText();
            String string3 = (text == null || text.length() <= 0) ? null : text.toString();
            CharSequence hint = textView.getHint();
            string = (hint == null || hint.length() <= 0) ? null : hint.toString();
            str = string3;
        } else {
            str = null;
            string = null;
        }
        CharSequence contentDescription = view2.getContentDescription();
        if (contentDescription != null && contentDescription.length() > 0) {
            string2 = contentDescription.toString();
        }
        String str2 = string2;
        boolean z14 = view2.getVisibility() == 0;
        boolean zIsEnabled = view2.isEnabled();
        boolean z15 = view2.isClickable() || view2.isFocusable() || view2.isLongClickable();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        Rect rect = new Rect(i10, iArr[1], view2.getWidth() + i10, view2.getHeight() + iArr[1]);
        ArrayList arrayList = new ArrayList();
        boolean z16 = view2 instanceof ViewGroup;
        if (z16) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int i11 = 0;
            while (i11 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i11);
                boolean z17 = z13;
                boolean z18 = z16;
                if (childAt.getVisibility() != 8) {
                    arrayList.add(buildRecursiveWithIndex(childAt, i11, map2));
                }
                i11++;
                z13 = z17;
                z16 = z18;
            }
        }
        boolean z19 = z13;
        boolean z20 = z16;
        String strExtractId = extractId(view2.toString());
        boolean z21 = view2 instanceof Checkable;
        if (view2 instanceof SeekBar) {
            SeekBar seekBar = (SeekBar) view2;
            int progress = seekBar.getProgress();
            max = seekBar.getMax();
            min = seekBar.getMin();
            i6 = progress;
        } else {
            max = 100;
            i6 = 0;
            min = 0;
        }
        int i12 = max;
        if (z20) {
            ViewGroup viewGroup2 = (ViewGroup) view2;
            boolean z22 = viewGroup2.canScrollVertically(1) || viewGroup2.canScrollVertically(-1);
            z10 = true;
            z11 = viewGroup2.canScrollHorizontally(1) || viewGroup2.canScrollHorizontally(-1);
            z12 = z22;
        } else {
            z10 = true;
            z11 = false;
            z12 = false;
        }
        boolean zIsFocused = view2.isFocused();
        boolean z23 = ((view2 instanceof EditText) || (z19 && view2.onCheckIsTextEditor())) ? z10 : false;
        long jHashCode = view2.hashCode();
        ViewNode viewNode = new ViewNode(jHashCode, i, name, packageName, str, str2, z15, zIsEnabled, z14, rect, arrayList, strExtractId, z21, i6, i12, min, z11, z12, zIsFocused, z23, string);
        map2.put(Long.valueOf(jHashCode), view2);
        return viewNode;
    }

    public static BuildResult buildWithIndex(@NonNull View view) {
        HashMap map = new HashMap();
        return new BuildResult(buildRecursiveWithIndex(view, -1, map), map);
    }

    private static String extractId(String str) {
        Matcher matcher = Pattern.compile("app:id/(\\w+)").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    @Nullable
    public static View findViewByNode(@NonNull ViewNode viewNode, @NonNull Map<Long, View> map) {
        return map.get(Long.valueOf(viewNode.getNodeId()));
    }

    @Nullable
    public static View findViewByNodeId(long j5, @NonNull Map<Long, View> map) {
        return map.get(Long.valueOf(j5));
    }

    @NonNull
    public static List<View> findViewsByNodes(@NonNull List<ViewNode> list, @NonNull Map<Long, View> map) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ViewNode> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(map.get(Long.valueOf(it.next().getNodeId())));
        }
        return arrayList;
    }

    private static boolean hasAction(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList == null) {
            return false;
        }
        for (int i6 = 0; i6 < actionList.size(); i6++) {
            if (actionList.get(i6).getId() == i) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Rect getBounds() {
        return this.bounds;
    }

    @NonNull
    public List<ViewNode> getChildren() {
        return this.children;
    }

    @NonNull
    public String getClassName() {
        return this.className;
    }

    @Nullable
    public String getContentDescription() {
        return this.contentDescription;
    }

    @Nullable
    public String getHint() {
        return this.hint;
    }

    public int getIndex() {
        return this.index;
    }

    public long getNodeId() {
        return this.nodeId;
    }

    @NonNull
    public String getPackageName() {
        return this.packageName;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getProgressMax() {
        return this.progressMax;
    }

    public int getProgressMin() {
        return this.progressMin;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    @Nullable
    public String getViewId() {
        return this.viewId;
    }

    public boolean isCheckable() {
        return this.isCheckable;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean isFocused() {
        return this.isFocused;
    }

    public boolean isHorizontalScrollable() {
        return this.mHorizontalScrollable;
    }

    public boolean isTextEditor() {
        return this.isTextEditor;
    }

    public boolean isVerticalScrollable() {
        return this.mVerticalScrollable;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ViewNode{nodeId=");
        sb.append(this.nodeId);
        sb.append(", index=");
        sb.append(this.index);
        sb.append(", className='");
        sb.append(this.className);
        sb.append("', text='");
        sb.append(this.text);
        sb.append("', isClickable=");
        sb.append(this.isClickable);
        sb.append(", children=");
        sb.append(this.children.size());
        sb.append(", viewId='");
        sb.append(this.viewId);
        sb.append("', isCheckable=");
        sb.append(this.isCheckable);
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", progressMax=");
        sb.append(this.progressMax);
        sb.append(", progressMin=");
        sb.append(this.progressMin);
        sb.append(", mHorizontalScrollable=");
        sb.append(this.mHorizontalScrollable);
        sb.append(", mVerticalScrollable=");
        return a.r(sb, this.mVerticalScrollable, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.nodeId);
        parcel.writeInt(this.index);
        parcel.writeString(this.className);
        parcel.writeString(this.packageName);
        parcel.writeString(this.text);
        parcel.writeString(this.contentDescription);
        parcel.writeByte(this.isClickable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.bounds, i);
        parcel.writeTypedList(this.children);
        parcel.writeString(this.viewId);
        parcel.writeByte(this.isCheckable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.progress);
        parcel.writeInt(this.progressMax);
        parcel.writeInt(this.progressMin);
        parcel.writeByte(this.mHorizontalScrollable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mVerticalScrollable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFocused ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTextEditor ? (byte) 1 : (byte) 0);
        parcel.writeString(this.hint);
    }

    public ViewNode(int i, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, boolean z10, boolean z11, boolean z12, @NonNull Rect rect, @NonNull List<ViewNode> list, @Nullable String str5, boolean z13, int i6, int i10, int i11, boolean z14, boolean z15, boolean z16, boolean z17, @Nullable String str6) {
        this(0L, i, str, str2, str3, str4, z10, z11, z12, rect, list, str5, z13, i6, i10, i11, z14, z15, z16, z17, str6);
    }

    public ViewNode() {
        this(-1, "", "", null, null, false, true, true, new Rect(), Collections.EMPTY_LIST, null, false, 0, 100, 0, false, false, false, false, null);
    }

    public ViewNode(Parcel parcel) {
        this.nodeId = parcel.readLong();
        this.index = parcel.readInt();
        this.className = parcel.readString();
        this.packageName = parcel.readString();
        this.text = parcel.readString();
        this.contentDescription = parcel.readString();
        this.isClickable = parcel.readByte() != 0;
        this.isEnabled = parcel.readByte() != 0;
        this.isVisible = parcel.readByte() != 0;
        this.bounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.children = arrayList;
        parcel.readTypedList(arrayList, CREATOR);
        this.viewId = parcel.readString();
        this.isCheckable = parcel.readByte() != 0;
        this.progress = parcel.readInt();
        this.progressMax = parcel.readInt();
        this.progressMin = parcel.readInt();
        this.mHorizontalScrollable = parcel.readByte() != 0;
        this.mVerticalScrollable = parcel.readByte() != 0;
        this.isFocused = parcel.readByte() != 0;
        this.isTextEditor = parcel.readByte() != 0;
        this.hint = parcel.readString();
    }
}
