package androidx.compose.material3.internal;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0002\u0014\u0017\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001(B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003H\u0016J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001aJ\u000e\u0010'\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR+\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u0003*\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u0003*\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, d2 = {"Landroidx/compose/material3/internal/Listener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "listenToVoiceAccessState", "<init>", "(ZZZ)V", "getListenToSwitchAccessState", "()Z", "getListenToVoiceAccessState", "<set-?>", "accessibilityEnabled", "getAccessibilityEnabled", "setAccessibilityEnabled", "(Z)V", "accessibilityEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "touchExplorationListener", "androidx/compose/material3/internal/Listener$touchExplorationListener$1", "Landroidx/compose/material3/internal/Listener$touchExplorationListener$1;", "otherA11yServicesListener", "androidx/compose/material3/internal/Listener$otherA11yServicesListener$1", "Landroidx/compose/material3/internal/Listener$otherA11yServicesListener$1;", "switchAccessEnabled", "Landroid/view/accessibility/AccessibilityManager;", "getSwitchAccessEnabled", "(Landroid/view/accessibility/AccessibilityManager;)Z", "voiceAccessEnabled", "getVoiceAccessEnabled", "value", "getValue", "()Ljava/lang/Boolean;", "onAccessibilityStateChanged", "", "enabled", MiPushClient.COMMAND_REGISTER, "am", MiPushClient.COMMAND_UNREGISTER, "Api33Impl", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, State<Boolean> {
    private final MutableState accessibilityEnabled$delegate;
    private final boolean listenToSwitchAccessState;
    private final boolean listenToVoiceAccessState;
    private final Listener$otherA11yServicesListener$1 otherA11yServicesListener;
    private final Listener$touchExplorationListener$1 touchExplorationListener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/internal/Listener$Api33Impl;", "", "<init>", "()V", "addAccessibilityServicesStateChangeListener", "", "am", "Landroid/view/accessibility/AccessibilityManager;", "listener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "removeAccessibilityServicesStateChangeListener", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = null;

        static {
            INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
        }

        @JvmStatic
        public static final void addAccessibilityServicesStateChangeListener(AccessibilityManager r100, AccessibilityManager.AccessibilityServicesStateChangeListener r101) {
            r100.addAccessibilityServicesStateChangeListener(r101);
        }

        @JvmStatic
        public static final void removeAccessibilityServicesStateChangeListener(AccessibilityManager r100, AccessibilityManager.AccessibilityServicesStateChangeListener r101) {
            r100.removeAccessibilityServicesStateChangeListener(r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getAccessibilityEnabled() {
        return ((Boolean) this.accessibilityEnabled$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    public Boolean getValue() {
        boolean r100 = false;
        if (getAccessibilityEnabled() == false) goto L31;
        Listener$touchExplorationListener$1 r101 = this.touchExplorationListener;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
    L29:
        r100 = true;
        goto L31
    L12:
        if (this.listenToSwitchAccessState == false) goto L21;
        Listener$otherA11yServicesListener$1 r103 = this.otherA11yServicesListener;
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == true) goto L29;
    L16:
        if (r103.getSwitchAccessEnabled() != true) goto L18;
        r104 = true;
    L21:
        if (this.listenToVoiceAccessState == false) goto L31;
        Listener$otherA11yServicesListener$1 r105 = this.otherA11yServicesListener;
        if (r105 != null) goto L25;
    L27:
        boolean r106 = false;
    L28:
        if (r106 == false) goto L31;
    L25:
        if (r105.getVoiceAccessEnabled() != true) goto L27;
        r106 = true;
        goto L28
    L7:
        if (r101.getEnabled() != true) goto L9;
        r102 = true;
    L31:
        return Boolean.valueOf(r100);
    }

    public final boolean getListenToSwitchAccessState() {
        return this.listenToSwitchAccessState;
    }

    public final boolean getListenToVoiceAccessState() {
        return this.listenToVoiceAccessState;
    }

    @Override // androidx.compose.runtime.State
    public /* bridge */ /* synthetic */ Boolean getValue() {
        return getValue();
    }

    private final boolean getSwitchAccessEnabled(AccessibilityManager r100) {
        List<AccessibilityServiceInfo> r101 = r100.getEnabledAccessibilityServiceList(16);
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L16;
        String r104 = ((AccessibilityServiceInfo) ListProtector.get(r101, r103)).getSettingsActivityName();
        if (r104 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == true) goto L11;
        r103 = r103 + 1;
        goto L3
    L11:
        return true;
    L7:
        if (StringsKt.contains(r104, "SwitchAccess", true) != true) goto L9;
        r105 = true;
        goto L10
    L16:
        return false;
    }

    private final boolean getVoiceAccessEnabled(AccessibilityManager r100) {
        List<AccessibilityServiceInfo> r101 = r100.getEnabledAccessibilityServiceList(16);
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L16;
        String r104 = ((AccessibilityServiceInfo) ListProtector.get(r101, r103)).getSettingsActivityName();
        if (r104 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == true) goto L11;
        r103 = r103 + 1;
        goto L3
    L11:
        return true;
    L7:
        if (StringsKt.contains(r104, "VoiceAccess", true) != true) goto L9;
        r105 = true;
        goto L10
    L16:
        return false;
    }

    private final void setAccessibilityEnabled(boolean r100) {
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(r100));
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean r100) {
        setAccessibilityEnabled(r100);
    }

    public final void register(AccessibilityManager r100) {
        setAccessibilityEnabled(r100.isEnabled());
        r100.addAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 r101 = this.touchExplorationListener;
        if (r101 == null) goto L6;
        r101.setEnabled(r100.isTouchExplorationEnabled());
        r100.addTouchExplorationStateChangeListener(r101);
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Listener$otherA11yServicesListener$1 r102 = this.otherA11yServicesListener;
        if (r102 == null) goto L12;
        r102.setSwitchAccessEnabled(getSwitchAccessEnabled(r100));
        r102.setVoiceAccessEnabled(getVoiceAccessEnabled(r100));
        Api33Impl.addAccessibilityServicesStateChangeListener(r100, r102);
        return;
    L12:
        return;
    }

    public final void unregister(AccessibilityManager r100) {
        r100.removeAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 r101 = this.touchExplorationListener;
        if (r101 == null) goto L6;
        r100.removeTouchExplorationStateChangeListener(r101);
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Listener$otherA11yServicesListener$1 r102 = this.otherA11yServicesListener;
        if (r102 == null) goto L12;
        Api33Impl.removeAccessibilityServicesStateChangeListener(r100, r102);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ boolean access$getSwitchAccessEnabled(Listener r100, AccessibilityManager r101) {
        return r100.getSwitchAccessEnabled(r101);
    }

    public static final /* synthetic */ boolean access$getVoiceAccessEnabled(Listener r100, AccessibilityManager r101) {
        return r100.getVoiceAccessEnabled(r101);
    }

    public Listener(boolean r100, boolean r101, boolean r102) {
        this.listenToSwitchAccessState = r101;
        this.listenToVoiceAccessState = r102;
        Listener$otherA11yServicesListener$1 r103 = null;
        this.accessibilityEnabled$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        if (r100 == false) goto L5;
        Listener$touchExplorationListener$1 r104 = new Listener$touchExplorationListener$1();
    L6:
        this.touchExplorationListener = r104;
        if (r101 == true) goto L10;
        if (r102 == true) goto L10;
    L12:
        this.otherA11yServicesListener = r103;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 33) goto L12;
        r103 = new Listener$otherA11yServicesListener$1(this);
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
