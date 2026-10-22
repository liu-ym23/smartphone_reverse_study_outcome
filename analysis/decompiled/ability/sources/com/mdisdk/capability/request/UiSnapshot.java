package com.mdisdk.capability.request;

import D7.A;
import D7.w;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.ViewNode;
import com.mdisdk.capability.model.WindowStateInfo;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u0011\u001a\u00020\u00102\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00022\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00022\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010%J\u0015\u0010&\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\u001d\u0010+\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b/\u00100J \u00101\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b5\u0010.J\u001a\u00108\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010:\u001a\u0004\b;\u00100R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028F¢\u0006\u0006\u001a\u0004\b<\u00100R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0\u00028F¢\u0006\u0006\u001a\u0004\b>\u00100¨\u0006@"}, d2 = {"Lcom/mdisdk/capability/request/UiSnapshot;", "Landroid/os/Parcelable;", "", "Lcom/mdisdk/capability/request/DisplaySnapshot;", "displays", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lcom/mdisdk/capability/model/ViewNode;", "node", "", "indent", "", "fullDump", "LC7/r;", "appendViewNode", "(Ljava/lang/StringBuilder;Lcom/mdisdk/capability/model/ViewNode;Ljava/lang/String;Z)V", "", WindowStateInfo.KEY_DISPLAY_ID, "Lcom/mdisdk/capability/model/WindowStateInfo;", "getWindowsOnDisplay", "(I)Ljava/util/List;", "getApplicationWindowsOnDisplay", "packageName", "containsPackage", "(Ljava/lang/String;)Z", "pkg", "findWindowsByPackage", "(Ljava/lang/String;)Ljava/util/List;", "screenshotPath", "updateScreenshotPath", "(ILjava/lang/String;)Lcom/mdisdk/capability/request/UiSnapshot;", "getScreenshotPath", "(I)Ljava/lang/String;", "window", "(Lcom/mdisdk/capability/model/WindowStateInfo;)Ljava/lang/String;", "dump", "(Z)Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lcom/mdisdk/capability/request/UiSnapshot;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getDisplays", "getAllWindows", "allWindows", "getAllRootNodes", "allRootNodes", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiSnapshot implements Parcelable {
    public static final Parcelable.Creator<UiSnapshot> CREATOR = new Creator();
    private final List<DisplaySnapshot> displays;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UiSnapshot> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UiSnapshot createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i6 = 0; i6 != i; i6++) {
                arrayList.add(DisplaySnapshot.CREATOR.createFromParcel(parcel));
            }
            return new UiSnapshot(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UiSnapshot[] newArray(int i) {
            return new UiSnapshot[i];
        }
    }

    public UiSnapshot() {
        this(null, 1, null);
    }

    private final void appendViewNode(StringBuilder sb, ViewNode node, String indent, boolean fullDump) {
        StringBuilder sbX = a.x(indent, "└── className: ");
        String className = node.getClassName();
        if (className == null) {
            className = "null";
        }
        sbX.append(className);
        sbX.append('\n');
        sb.append(sbX.toString());
        if (fullDump) {
            StringBuilder sbX2 = a.x(indent, "    viewId: ");
            String viewId = node.getViewId();
            if (viewId == null) {
                viewId = "null";
            }
            sbX2.append(viewId);
            sbX2.append('\n');
            sb.append(sbX2.toString());
        }
        StringBuilder sbX3 = a.x(indent, "    text: ");
        String text = node.getText();
        sbX3.append(text != null ? t.c0(m.N0(100, text), "\n", "\\n") : "null");
        sbX3.append('\n');
        sb.append(sbX3.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(indent);
        sb2.append("    contentDescription: ");
        String contentDescription = node.getContentDescription();
        sb2.append(contentDescription != null ? contentDescription : "null");
        sb2.append('\n');
        sb.append(sb2.toString());
        sb.append(indent + "    bounds: " + node.getBounds() + '\n');
        if (fullDump) {
            StringBuilder sbX4 = a.x(indent, "    isVisible: ");
            sbX4.append(node.isVisible());
            sbX4.append('\n');
            sb.append(sbX4.toString());
            sb.append(indent + "    isClickable: " + node.isClickable() + '\n');
            sb.append(indent + "    isEnabled: " + node.isEnabled() + '\n');
            sb.append(indent + "    isCheckable: " + node.isCheckable() + '\n');
            sb.append(indent + "    isFocused: " + node.isFocused() + '\n');
            sb.append(indent + "    isTextEditor: " + node.isTextEditor() + '\n');
            sb.append(indent + "    horizontalScrollable: " + node.isHorizontalScrollable() + '\n');
            sb.append(indent + "    verticalScrollable: " + node.isVerticalScrollable() + '\n');
            String className2 = node.getClassName();
            if (className2 != null && m.h0(className2, "SeekBar", true)) {
                StringBuilder sbX5 = a.x(indent, "    progress: ");
                sbX5.append(node.getProgress());
                sbX5.append(" [");
                sbX5.append(node.getProgressMin());
                sbX5.append("..");
                sbX5.append(node.getProgressMax());
                sbX5.append("]\n");
                sb.append(sbX5.toString());
            }
            StringBuilder sbX6 = a.x(indent, "    children count: ");
            sbX6.append(node.getChildren().size());
            sbX6.append('\n');
            sb.append(sbX6.toString());
        }
        List<ViewNode> children = node.getChildren();
        k.e(children, "getChildren(...)");
        if (children.isEmpty()) {
            return;
        }
        sb.append(indent + "    children: [\n");
        for (ViewNode viewNode : node.getChildren()) {
            k.c(viewNode);
            appendViewNode(sb, viewNode, indent + "        ", fullDump);
        }
        sb.append(indent + "    ]\n");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UiSnapshot copy$default(UiSnapshot uiSnapshot, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = uiSnapshot.displays;
        }
        return uiSnapshot.copy(list);
    }

    public final List<DisplaySnapshot> component1() {
        return this.displays;
    }

    public final boolean containsPackage(String packageName) {
        k.f(packageName, "packageName");
        if (packageName.length() == 0) {
            return false;
        }
        List<DisplaySnapshot> list = this.displays;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<WindowStateInfo> allWindows = ((DisplaySnapshot) it.next()).getAllWindows();
            if (!(allWindows instanceof Collection) || !allWindows.isEmpty()) {
                Iterator<T> it2 = allWindows.iterator();
                while (it2.hasNext()) {
                    if (k.b(((WindowStateInfo) it2.next()).getPackageName(), packageName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final UiSnapshot copy(List<DisplaySnapshot> displays) {
        k.f(displays, "displays");
        return new UiSnapshot(displays);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String dump(boolean fullDump) {
        StringBuilder sbV = b.v("GlobalUiSnapshot {\n");
        if (this.displays.isEmpty()) {
            sbV.append("  (no displays)\n");
        } else {
            int i = 0;
            for (DisplaySnapshot displaySnapshot : this.displays) {
                int i6 = i + 1;
                sbV.append(i == this.displays.size() + (-1) ? "└── " : "├── ");
                sbV.append("Display #" + displaySnapshot.getDisplayId() + " {\n");
                if (displaySnapshot.getAllWindows().isEmpty()) {
                    sbV.append("    (no windows)\n");
                } else {
                    int i10 = 0;
                    for (WindowStateInfo windowStateInfo : displaySnapshot.getAllWindows()) {
                        int i11 = i10 + 1;
                        sbV.append(i10 == displaySnapshot.getAllWindows().size() + (-1) ? "    └── " : "    ├── ");
                        sbV.append("Window {\n");
                        sbV.append("      packageName: " + windowStateInfo.getPackageName() + '\n');
                        sbV.append("      windowType: " + windowStateInfo.getWindowType() + '\n');
                        StringBuilder sb = new StringBuilder("      title: ");
                        String windowTitle = windowStateInfo.getWindowTitle();
                        if (windowTitle == null) {
                            windowTitle = "null";
                        }
                        sb.append(windowTitle);
                        sb.append('\n');
                        sbV.append(sb.toString());
                        ViewNode rootNode = windowStateInfo.getRootNode();
                        if (rootNode != null) {
                            sbV.append("      rootView:\n");
                            appendViewNode(sbV, rootNode, "        ", fullDump);
                        } else {
                            sbV.append("      rootView: null\n");
                        }
                        displaySnapshot.getAllWindows().size();
                        sbV.append("    }\n");
                        i10 = i11;
                    }
                }
                this.displays.size();
                sbV.append("}\n");
                i = i6;
            }
        }
        sbV.append("}");
        String string = sbV.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UiSnapshot) && k.b(this.displays, ((UiSnapshot) other).displays);
    }

    public final List<WindowStateInfo> findWindowsByPackage(String pkg) {
        k.f(pkg, "pkg");
        List<DisplaySnapshot> list = this.displays;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<WindowStateInfo> allWindows = ((DisplaySnapshot) it.next()).getAllWindows();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allWindows) {
                if (k.b(((WindowStateInfo) obj).getPackageName(), pkg)) {
                    arrayList2.add(obj);
                }
            }
            A.e0(arrayList2, arrayList);
        }
        return arrayList;
    }

    public final List<ViewNode> getAllRootNodes() {
        List<WindowStateInfo> allWindows = getAllWindows();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = allWindows.iterator();
        while (it.hasNext()) {
            ViewNode rootNode = ((WindowStateInfo) it.next()).getRootNode();
            if (rootNode != null) {
                arrayList.add(rootNode);
            }
        }
        return arrayList;
    }

    public final List<WindowStateInfo> getAllWindows() {
        List<DisplaySnapshot> list = this.displays;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            A.e0(((DisplaySnapshot) it.next()).getAllWindows(), arrayList);
        }
        return arrayList;
    }

    public final List<WindowStateInfo> getApplicationWindowsOnDisplay(int displayId) {
        List<WindowStateInfo> windowsOnDisplay = getWindowsOnDisplay(displayId);
        ArrayList arrayList = new ArrayList();
        for (Object obj : windowsOnDisplay) {
            if (((WindowStateInfo) obj).getWindowType() == 2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<DisplaySnapshot> getDisplays() {
        return this.displays;
    }

    public final String getScreenshotPath(int displayId) {
        Object next;
        Iterator<T> it = this.displays.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DisplaySnapshot) next).getDisplayId() == displayId) {
                break;
            }
        }
        DisplaySnapshot displaySnapshot = (DisplaySnapshot) next;
        if (displaySnapshot != null) {
            return displaySnapshot.getScreenshotPath();
        }
        return null;
    }

    public final List<WindowStateInfo> getWindowsOnDisplay(int displayId) {
        Object next;
        List<WindowStateInfo> allWindows;
        Iterator<T> it = this.displays.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DisplaySnapshot) next).getDisplayId() == displayId) {
                break;
            }
        }
        DisplaySnapshot displaySnapshot = (DisplaySnapshot) next;
        return (displaySnapshot == null || (allWindows = displaySnapshot.getAllWindows()) == null) ? EmptyList.f4893a : allWindows;
    }

    public int hashCode() {
        return this.displays.hashCode();
    }

    public String toString() {
        return B7.a.r(new StringBuilder("UiSnapshot(displays="), this.displays, ')');
    }

    public final UiSnapshot updateScreenshotPath(int displayId, String screenshotPath) {
        String str;
        k.f(screenshotPath, "screenshotPath");
        List<DisplaySnapshot> list = this.displays;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        for (DisplaySnapshot displaySnapshotCopy$default : list) {
            if (displaySnapshotCopy$default.getDisplayId() == displayId) {
                str = screenshotPath;
                displaySnapshotCopy$default = DisplaySnapshot.copy$default(displaySnapshotCopy$default, 0, false, null, null, null, str, 31, null);
            } else {
                str = screenshotPath;
            }
            arrayList.add(displaySnapshotCopy$default);
            screenshotPath = str;
        }
        return copy(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        List<DisplaySnapshot> list = this.displays;
        dest.writeInt(list.size());
        Iterator<DisplaySnapshot> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    public UiSnapshot(List<DisplaySnapshot> displays) {
        k.f(displays, "displays");
        this.displays = displays;
    }

    public UiSnapshot(List list, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : list);
    }

    public final String getScreenshotPath(WindowStateInfo window) {
        Object next;
        k.f(window, "window");
        Iterator<T> it = this.displays.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DisplaySnapshot) next).getAllWindows().contains(window)) {
                break;
            }
        }
        DisplaySnapshot displaySnapshot = (DisplaySnapshot) next;
        if (displaySnapshot != null) {
            return displaySnapshot.getScreenshotPath();
        }
        return null;
    }
}
