package com.mdisdk.observer;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u00011BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010 \u001a\u00020\u000eJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rHÆ\u0003J[\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rHÆ\u0001J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\u000eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lcom/mdisdk/observer/VisibleWindowInfo;", "", "windows", "", "Lcom/mdisdk/observer/WindowSnapshot;", "changedWindow", "changeType", "Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;", WindowStateInfo.KEY_DISPLAY_ID, "", "timestamp", "", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "", "", AppAgent.CONSTRUCT, "(Ljava/util/List;Lcom/mdisdk/observer/WindowSnapshot;Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;IJLjava/util/Map;)V", "getWindows", "()Ljava/util/List;", "getChangedWindow", "()Lcom/mdisdk/observer/WindowSnapshot;", "getChangeType", "()Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;", "getDisplayId", "()I", "getTimestamp", "()J", "getExtras", "()Ljava/util/Map;", "getTopApplicationWindow", "getFocusedWindow", "getWindowsByPackage", "packageName", "getApplicationWindows", "getSystemWindows", "hasOverlayWindow", "", "hasInputMethodWindow", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "ChangeType", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VisibleWindowInfo {
    private final ChangeType changeType;
    private final WindowSnapshot changedWindow;
    private final int displayId;
    private final Map<String, Object> extras;
    private final long timestamp;
    private final List<WindowSnapshot> windows;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ADDED", "REMOVED", "UPDATED", "REORDERED", "BATCH_REFRESH", "UNKNOWN", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChangeType {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ ChangeType[] $VALUES;
        public static final ChangeType ADDED = new ChangeType("ADDED", 0);
        public static final ChangeType REMOVED = new ChangeType("REMOVED", 1);
        public static final ChangeType UPDATED = new ChangeType("UPDATED", 2);
        public static final ChangeType REORDERED = new ChangeType("REORDERED", 3);
        public static final ChangeType BATCH_REFRESH = new ChangeType("BATCH_REFRESH", 4);
        public static final ChangeType UNKNOWN = new ChangeType("UNKNOWN", 5);

        private static final /* synthetic */ ChangeType[] $values() {
            return new ChangeType[]{ADDED, REMOVED, UPDATED, REORDERED, BATCH_REFRESH, UNKNOWN};
        }

        static {
            ChangeType[] changeTypeArr$values = $values();
            $VALUES = changeTypeArr$values;
            $ENTRIES = kotlin.enums.a.a(changeTypeArr$values);
        }

        private ChangeType(String str, int i) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static ChangeType valueOf(String str) {
            return (ChangeType) Enum.valueOf(ChangeType.class, str);
        }

        public static ChangeType[] values() {
            return (ChangeType[]) $VALUES.clone();
        }
    }

    public VisibleWindowInfo(List<WindowSnapshot> windows, WindowSnapshot windowSnapshot, ChangeType changeType, int i, long j5, Map<String, ? extends Object> extras) {
        k.f(windows, "windows");
        k.f(changeType, "changeType");
        k.f(extras, "extras");
        this.windows = windows;
        this.changedWindow = windowSnapshot;
        this.changeType = changeType;
        this.displayId = i;
        this.timestamp = j5;
        this.extras = extras;
    }

    public static /* synthetic */ VisibleWindowInfo copy$default(VisibleWindowInfo visibleWindowInfo, List list, WindowSnapshot windowSnapshot, ChangeType changeType, int i, long j5, Map map, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = visibleWindowInfo.windows;
        }
        if ((i6 & 2) != 0) {
            windowSnapshot = visibleWindowInfo.changedWindow;
        }
        if ((i6 & 4) != 0) {
            changeType = visibleWindowInfo.changeType;
        }
        if ((i6 & 8) != 0) {
            i = visibleWindowInfo.displayId;
        }
        if ((i6 & 16) != 0) {
            j5 = visibleWindowInfo.timestamp;
        }
        if ((i6 & 32) != 0) {
            map = visibleWindowInfo.extras;
        }
        Map map2 = map;
        long j6 = j5;
        return visibleWindowInfo.copy(list, windowSnapshot, changeType, i, j6, map2);
    }

    public final List<WindowSnapshot> component1() {
        return this.windows;
    }

    /* renamed from: component2, reason: from getter */
    public final WindowSnapshot getChangedWindow() {
        return this.changedWindow;
    }

    /* renamed from: component3, reason: from getter */
    public final ChangeType getChangeType() {
        return this.changeType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Map<String, Object> component6() {
        return this.extras;
    }

    public final VisibleWindowInfo copy(List<WindowSnapshot> windows, WindowSnapshot changedWindow, ChangeType changeType, int displayId, long timestamp, Map<String, ? extends Object> extras) {
        k.f(windows, "windows");
        k.f(changeType, "changeType");
        k.f(extras, "extras");
        return new VisibleWindowInfo(windows, changedWindow, changeType, displayId, timestamp, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisibleWindowInfo)) {
            return false;
        }
        VisibleWindowInfo visibleWindowInfo = (VisibleWindowInfo) other;
        return k.b(this.windows, visibleWindowInfo.windows) && k.b(this.changedWindow, visibleWindowInfo.changedWindow) && this.changeType == visibleWindowInfo.changeType && this.displayId == visibleWindowInfo.displayId && this.timestamp == visibleWindowInfo.timestamp && k.b(this.extras, visibleWindowInfo.extras);
    }

    public final List<WindowSnapshot> getApplicationWindows() {
        List<WindowSnapshot> list = this.windows;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((WindowSnapshot) obj).isApplicationWindow()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final ChangeType getChangeType() {
        return this.changeType;
    }

    public final WindowSnapshot getChangedWindow() {
        return this.changedWindow;
    }

    public final int getDisplayId() {
        return this.displayId;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final WindowSnapshot getFocusedWindow() {
        Object next;
        Iterator<T> it = this.windows.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((WindowSnapshot) next).isFocused()) {
                break;
            }
        }
        return (WindowSnapshot) next;
    }

    public final List<WindowSnapshot> getSystemWindows() {
        List<WindowSnapshot> list = this.windows;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((WindowSnapshot) obj).isSystemWindow()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final WindowSnapshot getTopApplicationWindow() {
        Object next;
        Iterator<T> it = this.windows.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((WindowSnapshot) next).isApplicationWindow()) {
                break;
            }
        }
        return (WindowSnapshot) next;
    }

    public final List<WindowSnapshot> getWindows() {
        return this.windows;
    }

    public final List<WindowSnapshot> getWindowsByPackage(String packageName) {
        k.f(packageName, "packageName");
        List<WindowSnapshot> list = this.windows;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (k.b(((WindowSnapshot) obj).getPackageName(), packageName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean hasInputMethodWindow() {
        List<WindowSnapshot> list = this.windows;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((WindowSnapshot) it.next()).getWindowType() == 2011) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasOverlayWindow() {
        List<WindowSnapshot> list = this.windows;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((WindowSnapshot) it.next()).isOverlayWindow()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.windows.hashCode() * 31;
        WindowSnapshot windowSnapshot = this.changedWindow;
        return this.extras.hashCode() + androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.displayId, (this.changeType.hashCode() + ((iHashCode + (windowSnapshot == null ? 0 : windowSnapshot.hashCode())) * 31)) * 31, 31), 31, this.timestamp);
    }

    public String toString() {
        return "VisibleWindowInfo(windows=" + this.windows + ", changedWindow=" + this.changedWindow + ", changeType=" + this.changeType + ", displayId=" + this.displayId + ", timestamp=" + this.timestamp + ", extras=" + this.extras + ')';
    }

    public /* synthetic */ VisibleWindowInfo(List list, WindowSnapshot windowSnapshot, ChangeType changeType, int i, long j5, Map map, int i6, e eVar) {
        this(list, (i6 & 2) != 0 ? null : windowSnapshot, (i6 & 4) != 0 ? ChangeType.UNKNOWN : changeType, i, (i6 & 16) != 0 ? System.currentTimeMillis() : j5, (i6 & 32) != 0 ? kotlin.collections.a.M() : map);
    }
}
