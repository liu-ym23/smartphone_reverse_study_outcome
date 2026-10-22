package com.android.server.input;

import android.content.Context;
import android.hardware.input.InputGestureData;
import android.hardware.input.InputSettings;
import android.os.SystemProperties;
import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.window.DesktopModeFlags;
import com.android.server.usb.descriptors.UsbACInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class InputGestureManager {
    private static final int KEY_GESTURE_META_MASK = 69635;
    private static final String TAG = "InputGestureManager";
    private static final Object mGestureLock = null;
    private final Set<InputGestureData.Trigger> mBlockListedTriggers;
    private final Context mContext;
    private final SparseArray<Map<InputGestureData.Trigger, InputGestureData>> mCustomInputGestures;
    private final Map<InputGestureData.Trigger, InputGestureData> mSystemShortcuts;

    public static /* synthetic */ boolean $r8$lambda$rFyxEpYsnhnRsDQaYg4ACW996zo(InputGestureData.Filter r0, Map.Entry r1) {
        return lambda$removeAllCustomInputGestures$0(r0, r1);
    }

    static {
        mGestureLock = new Object();
    }

    public InputGestureManager(Context context) {
        this.mCustomInputGestures = new SparseArray();
        this.mSystemShortcuts = new HashMap();
        this.mBlockListedTriggers = new HashSet(Set.of(new InputGestureData.Trigger[]{InputGestureData.createKeyTrigger(61, 2), InputGestureData.createKeyTrigger(61, 3), InputGestureData.createKeyTrigger(62, 4096), InputGestureData.createKeyTrigger(62, UsbACInterface.FORMAT_II_MPEG), InputGestureData.createKeyTrigger(54, UsbACInterface.FORMAT_II_AC3), InputGestureData.createKeyTrigger(29, 4096), InputGestureData.createKeyTrigger(31, 4096), InputGestureData.createKeyTrigger(50, 4096), InputGestureData.createKeyTrigger(52, 4096), InputGestureData.createKeyTrigger(54, 4096), InputGestureData.createKeyTrigger(53, 4096)}));
        this.mContext = context;
    }

    public void init(List<InputGestureData> bookmarks) {
        initSystemShortcuts();
        blockListBookmarkedTriggers(bookmarks);
    }

    private void initSystemShortcuts() {
        List<InputGestureData> systemShortcuts = new ArrayList(List.of(new InputGestureData[]{createKeyGesture(29, 65536, 5), createKeyGesture(36, 65536, 1), createKeyGesture(66, 65536, 1), createKeyGesture(37, 65536, 7), createKeyGesture(40, 65536, 32), createKeyGesture(42, 65536, 8), createKeyGesture(47, 65536, 10), createKeyGesture(111, 65536, 3), createKeyGesture(19, 69632, 53), createKeyGesture(20, 69632, 52), createKeyGesture(21, 65536, 3), createKeyGesture(21, 69632, 27), createKeyGesture(22, 69632, 28), createKeyGesture(76, 65536, 12), createKeyGesture(61, 65536, 2)}));
        if ("1".equals(SystemProperties.get("ro.debuggable")) == false) goto L6;
        systemShortcuts.add(createKeyGesture(67, 69632, 31));
    L6:
        if (DesktopModeFlags.ENABLE_TASK_RESIZING_KEYBOARD_SHORTCUTS.isTrue() == false) goto L8;
        systemShortcuts.add(createKeyGesture(71, 65536, 68));
        systemShortcuts.add(createKeyGesture(72, 65536, 69));
        systemShortcuts.add(createKeyGesture(70, 65536, 71));
        systemShortcuts.add(createKeyGesture(69, 65536, 70));
    L8:
        systemShortcuts.add(createKeyGesture(10, 65538, 65));
        if (InputSettings.isAccessibilityMouseKeysFeatureFlagEnabled() == false) goto L11;
        systemShortcuts.add(createKeyGesture(11, 65538, 67));
    L11:
        systemShortcuts.add(createKeyGesture(12, 65538, 64));
        systemShortcuts.add(createKeyGesture(13, 65538, 66));
        Object r1 = mGestureLock;
        monitor-enter(r1);
        Iterator<InputGestureData> r2 = systemShortcuts.iterator();     // Catch: Throwable -> L17
    L15:
        if (r2.hasNext() == false) goto L19;
        InputGestureData systemShortcut = r2.next();     // Catch: Throwable -> L17
        this.mSystemShortcuts.put(systemShortcut.getTrigger(), systemShortcut);     // Catch: Throwable -> L17
        goto L15
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void blockListBookmarkedTriggers(List<InputGestureData> bookmarks) {
        Object r0 = mGestureLock;
        monitor-enter(r0);
        Iterator<InputGestureData> r1 = bookmarks.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        InputGestureData bookmark = r1.next();     // Catch: Throwable -> L8
        this.mBlockListedTriggers.add(bookmark.getTrigger());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public InputGestureData getInputGesture(int userId, InputGestureData.Trigger trigger) {
        Object r0 = mGestureLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mBlockListedTriggers.contains(trigger) == false) goto L12;
        InputGestureData r1 = new InputGestureData.Builder().setTrigger(trigger).setKeyGestureType(-1).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        if ((trigger instanceof InputGestureData.KeyTrigger) == false) goto L20;
        InputGestureData.KeyTrigger keyTrigger = (InputGestureData.KeyTrigger) trigger;     // Catch: Throwable -> L9
        if (KeyEvent.isModifierKey(keyTrigger.getKeycode()) == false) goto L16;
    L17:
        InputGestureData r2 = new InputGestureData.Builder().setTrigger(trigger).setKeyGestureType(-1).build();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L16:
        if (KeyEvent.isSystemKey(keyTrigger.getKeycode()) == true) goto L17;
    L20:
        InputGestureData gestureData = this.mSystemShortcuts.get(trigger);     // Catch: Throwable -> L9
        if (gestureData == null) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return gestureData;
    L25:
        if (this.mCustomInputGestures.contains(userId) == true) goto L29;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L29:
        InputGestureData r3 = this.mCustomInputGestures.get(userId).get(trigger);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    }

    public int addCustomInputGesture(int userId, InputGestureData newGesture) {
        Object r0 = mGestureLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mBlockListedTriggers.contains(newGesture.getTrigger()) == false) goto L7;
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return 4;
    L7:
        if (this.mSystemShortcuts.containsKey(newGesture.getTrigger()) == true) goto L32;
        InputGestureData.KeyTrigger r1 = newGesture.getTrigger();     // Catch: Throwable -> L16
        if ((r1 instanceof InputGestureData.KeyTrigger) == false) goto L21;
        InputGestureData.KeyTrigger keyTrigger = r1;     // Catch: Throwable -> L16
        if (KeyEvent.isModifierKey(keyTrigger.getKeycode()) == false) goto L14;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return 4;
    L14:
        if (KeyEvent.isSystemKey(keyTrigger.getKeycode()) == true) goto L18;
    L21:
        if (this.mCustomInputGestures.contains(userId) == true) goto L23;
        this.mCustomInputGestures.put(userId, new HashMap());     // Catch: Throwable -> L16
    L23:
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.get(userId);     // Catch: Throwable -> L16
        if (customGestures.containsKey(newGesture.getTrigger()) == false) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return 2;
    L28:
        customGestures.put(newGesture.getTrigger(), newGesture);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return 1;
    }

    public int removeCustomInputGesture(int userId, InputGestureData data) {
        Object r0 = mGestureLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCustomInputGestures.contains(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 3;
    L10:
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.get(userId);     // Catch: Throwable -> L8
        InputGestureData customGesture = customGestures.get(data.getTrigger());     // Catch: Throwable -> L8
        if (Objects.equals(data, customGesture) == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 3;
    L14:
        customGestures.remove(data.getTrigger());     // Catch: Throwable -> L8
        if (customGestures.isEmpty() == false) goto L17;
        this.mCustomInputGestures.remove(userId);     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 1;
    }

    public void removeAllCustomInputGestures(int userId, final InputGestureData.Filter filter) {
        Object r0 = mGestureLock;
        monitor-enter(r0);
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.get(userId);     // Catch: Throwable -> L8
        if (customGestures != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (filter != null) goto L14;
        this.mCustomInputGestures.remove(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        customGestures.entrySet().removeIf(new InputGestureManager$$ExternalSyntheticLambda0(filter));     // Catch: Throwable -> L8
        if (customGestures.isEmpty() == false) goto L17;
        this.mCustomInputGestures.remove(userId);     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeAllCustomInputGestures$0(InputGestureData.Filter filter, Map.Entry entry) {
        return filter.matches((InputGestureData) entry.getValue());
    }

    public List<InputGestureData> getCustomInputGestures(int userId, InputGestureData.Filter filter) {
        Object r0 = mGestureLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCustomInputGestures.contains(userId) == true) goto L11;
        List<InputGestureData> r1 = List.of();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.get(userId);     // Catch: Throwable -> L9
        if (filter != null) goto L16;
        ArrayList r2 = new ArrayList(customGestures.values());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L16:
        List<InputGestureData> result = new ArrayList();     // Catch: Throwable -> L9
        Iterator<InputGestureData> r3 = customGestures.values().iterator();     // Catch: Throwable -> L9
    L18:
        if (r3.hasNext() == false) goto L23;
        InputGestureData customGesture = r3.next();     // Catch: Throwable -> L9
        if (filter.matches(customGesture) == false) goto L18;
        result.add(customGesture);     // Catch: Throwable -> L9
        goto L18
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return result;
    }

    public InputGestureData getCustomGestureForKeyEvent(int userId, KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode != 0) goto L5;
        return null;
    L5:
        Object r2 = mGestureLock;
        monitor-enter(r2);
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.get(userId);     // Catch: Throwable -> L11
        if (customGestures != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return null;
    L13:
        int modifierState = event.getMetaState() & KEY_GESTURE_META_MASK;     // Catch: Throwable -> L11
        InputGestureData r4 = customGestures.get(InputGestureData.createKeyTrigger(keyCode, modifierState));     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return r4;
    L11:
        th = move-exception;
        throw th;
    }

    public InputGestureData getCustomGestureForTouchpadGesture(int userId, int touchpadGestureType) {
        if (touchpadGestureType != 0) goto L5;
        return null;
    L5:
        Object r1 = mGestureLock;
        monitor-enter(r1);
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.get(userId);     // Catch: Throwable -> L11
        if (customGestures != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return null;
    L13:
        InputGestureData r0 = customGestures.get(InputGestureData.createTouchpadTrigger(touchpadGestureType));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    public InputGestureData getSystemShortcutForKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode != 0) goto L6;
        return null;
    L6:
        Object r1 = mGestureLock;
        monitor-enter(r1);
        int modifierState = event.getMetaState() & KEY_GESTURE_META_MASK;     // Catch: Throwable -> L11
        InputGestureData r3 = this.mSystemShortcuts.get(InputGestureData.createKeyTrigger(keyCode, modifierState));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    private static InputGestureData createKeyGesture(int keycode, int modifierState, int keyGestureType) {
        return new InputGestureData.Builder().setTrigger(InputGestureData.createKeyTrigger(keycode, modifierState)).setKeyGestureType(keyGestureType).build();
    }

    public void dump(IndentingPrintWriter ipw) {
        ipw.println("InputGestureManager:");
        ipw.increaseIndent();
        Object r0 = mGestureLock;
        monitor-enter(r0);
        ipw.println("System Shortcuts:");     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        Iterator<InputGestureData> r1 = this.mSystemShortcuts.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        InputGestureData systemShortcut = r1.next();     // Catch: Throwable -> L8
        ipw.println(systemShortcut);     // Catch: Throwable -> L8
        goto L6
    L10:
        ipw.decreaseIndent();     // Catch: Throwable -> L8
        ipw.println("Blocklisted Triggers:");     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        Iterator<InputGestureData.Trigger> r2 = this.mBlockListedTriggers.iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        InputGestureData.Trigger blocklistedTrigger = r2.next();     // Catch: Throwable -> L8
        ipw.println(blocklistedTrigger);     // Catch: Throwable -> L8
        goto L12
    L14:
        ipw.decreaseIndent();     // Catch: Throwable -> L8
        ipw.println("Custom Gestures:");     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        int size = this.mCustomInputGestures.size();     // Catch: Throwable -> L8
        int i = 0;
    L15:
        if (i >= size) goto L22;
        Map<InputGestureData.Trigger, InputGestureData> customGestures = this.mCustomInputGestures.valueAt(i);     // Catch: Throwable -> L8
        ipw.println("UserId = " + this.mCustomInputGestures.keyAt(i));     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        Iterator<InputGestureData> r4 = customGestures.values().iterator();     // Catch: Throwable -> L8
    L18:
        if (r4.hasNext() == false) goto L20;
        InputGestureData customGesture = r4.next();     // Catch: Throwable -> L8
        ipw.println(customGesture);     // Catch: Throwable -> L8
        goto L18
    L20:
        ipw.decreaseIndent();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
        ipw.decreaseIndent();
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
