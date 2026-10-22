package com.mdisdk.observer;

import H4.o;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.model.WindowType;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/mdisdk/observer/WindowSnapshot;", "", "packageName", "", "activityClassName", "windowTitle", "windowType", "", "windowingMode", "isFocused", "", WindowStateInfo.KEY_LAYER, "bounds", "Lcom/mdisdk/observer/WindowBounds;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZILcom/mdisdk/observer/WindowBounds;)V", "getPackageName", "()Ljava/lang/String;", "getActivityClassName", "getWindowTitle", "getWindowType", "()I", "getWindowingMode", "()Z", "getLayer", "getBounds", "()Lcom/mdisdk/observer/WindowBounds;", "isApplicationWindow", "isSystemWindow", "isOverlayWindow", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WindowSnapshot {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String activityClassName;
    private final WindowBounds bounds;
    private final boolean isFocused;
    private final int layer;
    private final String packageName;
    private final String windowTitle;
    private final int windowType;
    private final int windowingMode;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/mdisdk/observer/WindowSnapshot$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromWindowStateInfo", "Lcom/mdisdk/observer/WindowSnapshot;", "info", "Lcom/mdisdk/capability/model/WindowStateInfo;", WindowStateInfo.KEY_LAYER, "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ WindowSnapshot fromWindowStateInfo$default(Companion companion, WindowStateInfo windowStateInfo, int i, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                i = 0;
            }
            return companion.fromWindowStateInfo(windowStateInfo, i);
        }

        public final WindowSnapshot fromWindowStateInfo(WindowStateInfo info, int layer) {
            Rect bounds;
            k.f(info, "info");
            String packageName = info.getPackageName();
            k.e(packageName, "getPackageName(...)");
            String activityClassName = info.getActivityClassName();
            String windowTitle = info.getWindowTitle();
            k.e(windowTitle, "getWindowTitle(...)");
            int windowType = info.getWindowType();
            int windowingMode = info.getWindowingMode();
            boolean zIsFocused = info.isFocused();
            Region touchRegion = info.getTouchRegion();
            return new WindowSnapshot(packageName, activityClassName, windowTitle, windowType, windowingMode, zIsFocused, layer, (touchRegion == null || (bounds = touchRegion.getBounds()) == null) ? null : new WindowBounds(bounds.left, bounds.top, bounds.right, bounds.bottom));
        }

        private Companion() {
        }
    }

    public WindowSnapshot(String packageName, String str, String windowTitle, int i, int i6, boolean z10, int i10, WindowBounds windowBounds) {
        k.f(packageName, "packageName");
        k.f(windowTitle, "windowTitle");
        this.packageName = packageName;
        this.activityClassName = str;
        this.windowTitle = windowTitle;
        this.windowType = i;
        this.windowingMode = i6;
        this.isFocused = z10;
        this.layer = i10;
        this.bounds = windowBounds;
    }

    public static /* synthetic */ WindowSnapshot copy$default(WindowSnapshot windowSnapshot, String str, String str2, String str3, int i, int i6, boolean z10, int i10, WindowBounds windowBounds, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = windowSnapshot.packageName;
        }
        if ((i11 & 2) != 0) {
            str2 = windowSnapshot.activityClassName;
        }
        if ((i11 & 4) != 0) {
            str3 = windowSnapshot.windowTitle;
        }
        if ((i11 & 8) != 0) {
            i = windowSnapshot.windowType;
        }
        if ((i11 & 16) != 0) {
            i6 = windowSnapshot.windowingMode;
        }
        if ((i11 & 32) != 0) {
            z10 = windowSnapshot.isFocused;
        }
        if ((i11 & 64) != 0) {
            i10 = windowSnapshot.layer;
        }
        if ((i11 & 128) != 0) {
            windowBounds = windowSnapshot.bounds;
        }
        int i12 = i10;
        WindowBounds windowBounds2 = windowBounds;
        int i13 = i6;
        boolean z11 = z10;
        return windowSnapshot.copy(str, str2, str3, i, i13, z11, i12, windowBounds2);
    }

    public static final WindowSnapshot fromWindowStateInfo(WindowStateInfo windowStateInfo, int i) {
        return INSTANCE.fromWindowStateInfo(windowStateInfo, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getActivityClassName() {
        return this.activityClassName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* renamed from: component4, reason: from getter */
    public final int getWindowType() {
        return this.windowType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getWindowingMode() {
        return this.windowingMode;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    /* renamed from: component7, reason: from getter */
    public final int getLayer() {
        return this.layer;
    }

    /* renamed from: component8, reason: from getter */
    public final WindowBounds getBounds() {
        return this.bounds;
    }

    public final WindowSnapshot copy(String packageName, String activityClassName, String windowTitle, int windowType, int windowingMode, boolean isFocused, int layer, WindowBounds bounds) {
        k.f(packageName, "packageName");
        k.f(windowTitle, "windowTitle");
        return new WindowSnapshot(packageName, activityClassName, windowTitle, windowType, windowingMode, isFocused, layer, bounds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WindowSnapshot)) {
            return false;
        }
        WindowSnapshot windowSnapshot = (WindowSnapshot) other;
        return k.b(this.packageName, windowSnapshot.packageName) && k.b(this.activityClassName, windowSnapshot.activityClassName) && k.b(this.windowTitle, windowSnapshot.windowTitle) && this.windowType == windowSnapshot.windowType && this.windowingMode == windowSnapshot.windowingMode && this.isFocused == windowSnapshot.isFocused && this.layer == windowSnapshot.layer && k.b(this.bounds, windowSnapshot.bounds);
    }

    public final String getActivityClassName() {
        return this.activityClassName;
    }

    public final WindowBounds getBounds() {
        return this.bounds;
    }

    public final int getLayer() {
        return this.layer;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final int getWindowType() {
        return this.windowType;
    }

    public final int getWindowingMode() {
        return this.windowingMode;
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode() * 31;
        String str = this.activityClassName;
        int iA = a.a(this.layer, androidx.appfunctions.metadata.a.d(a.a(this.windowingMode, a.a(this.windowType, B7.a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.windowTitle), 31), 31), 31, this.isFocused), 31);
        WindowBounds windowBounds = this.bounds;
        return iA + (windowBounds != null ? windowBounds.hashCode() : 0);
    }

    public final boolean isApplicationWindow() {
        int i = this.windowType;
        return 1 <= i && i < 5;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final boolean isOverlayWindow() {
        return o.N(1000, 1003, Integer.valueOf(WindowType.SYSTEM_ALERT), Integer.valueOf(WindowType.TOAST), Integer.valueOf(WindowType.SYSTEM_OVERLAY), Integer.valueOf(WindowType.SYSTEM_DIALOG), Integer.valueOf(WindowType.APPLICATION_OVERLAY)).contains(Integer.valueOf(this.windowType));
    }

    public final boolean isSystemWindow() {
        return WindowType.INSTANCE.isSystemWindow(this.windowType);
    }

    public String toString() {
        return "WindowSnapshot(packageName=" + this.packageName + ", activityClassName=" + this.activityClassName + ", windowTitle=" + this.windowTitle + ", windowType=" + this.windowType + ", windowingMode=" + this.windowingMode + ", isFocused=" + this.isFocused + ", layer=" + this.layer + ", bounds=" + this.bounds + ')';
    }

    public /* synthetic */ WindowSnapshot(String str, String str2, String str3, int i, int i6, boolean z10, int i10, WindowBounds windowBounds, int i11, e eVar) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? 2 : i, (i11 & 16) != 0 ? 0 : i6, (i11 & 32) != 0 ? false : z10, (i11 & 64) != 0 ? 0 : i10, (i11 & 128) != 0 ? null : windowBounds);
    }
}
