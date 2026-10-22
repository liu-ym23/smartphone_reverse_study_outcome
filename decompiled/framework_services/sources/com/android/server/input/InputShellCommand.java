package com.android.server.input;

import android.hardware.input.InputManagerGlobal;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.Pair;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.android.server.usb.descriptors.UsbACInterface;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public class InputShellCommand extends ShellCommand {
    private static final int DEFAULT_BUTTON_STATE = 0;
    private static final int DEFAULT_DEVICE_ID = 0;
    private static final int DEFAULT_EDGE_FLAGS = 0;
    private static final int DEFAULT_FLAGS = 0;
    private static final int DEFAULT_META_STATE = 0;
    private static final float DEFAULT_PRECISION_X = 1.0f;
    private static final float DEFAULT_PRECISION_Y = 1.0f;
    private static final float DEFAULT_PRESSURE = 1.0f;
    private static final float DEFAULT_SIZE = 1.0f;
    private static final boolean INJECT_ASYNC = true;
    private static final boolean INJECT_SYNC = false;
    private static final String INVALID_ARGUMENTS = "Error: Invalid arguments for command: ";
    private static final String INVALID_DISPLAY_ARGUMENTS = "Error: Invalid arguments for display ID.";
    private static final Map<Integer, Integer> MODIFIER = null;
    private static final float NO_PRESSURE = 0.0f;
    private static final long SECOND_IN_MILLISECONDS = 1000;
    private static final Map<String, Integer> SOURCES = null;
    public static final int SWIPE_EVENT_HZ_DEFAULT = 120;
    private final BiConsumer<InputEvent, Integer> mInputEventInjector;

    public static /* synthetic */ void $r8$lambda$hGxb9MovDr1pEN3Qnb51vH9VzpA(InputEvent r0, Integer r1) {
        injectInputEvent(r0, r1);
    }

    static {
        Map<Integer, Integer> map = new ArrayMap();
        map.put(113, 12288);
        map.put(114, 20480);
        map.put(57, 18);
        map.put(58, 34);
        map.put(59, 65);
        map.put(60, 129);
        map.put(117, 196608);
        map.put(118, 327680);
        MODIFIER = Collections.unmodifiableMap(map);
        Map<String, Integer> map2 = new ArrayMap();
        map2.put("keyboard", 257);
        map2.put("dpad", 513);
        map2.put("gamepad", Integer.valueOf(UsbTerminalTypes.TERMINAL_BIDIR_HANDSET));
        map2.put("touchscreen", Integer.valueOf(UsbACInterface.FORMAT_II_AC3));
        map2.put("mouse", Integer.valueOf(UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1));
        map2.put("stylus", 16386);
        map2.put("trackball", 65540);
        map2.put("touchpad", 1048584);
        map2.put("touchnavigation", 2097152);
        map2.put("joystick", 16777232);
        map2.put("rotaryencoder", 4194304);
        SOURCES = Collections.unmodifiableMap(map2);
    }

    public InputShellCommand() {
        this(new InputShellCommand$$ExternalSyntheticLambda0());
    }

    InputShellCommand(BiConsumer<InputEvent, Integer> inputEventInjector) {
        this.mInputEventInjector = inputEventInjector;
    }

    private static void injectInputEvent(InputEvent event, Integer injectMode) {
        InputManagerGlobal.getInstance().injectInputEvent(event, injectMode.intValue());
    }

    private void injectKeyEvent(KeyEvent event, boolean async) {
        if (async == false) goto L4;
        int injectMode = 0;
    L5:
        this.mInputEventInjector.accept(event, Integer.valueOf(injectMode));
        return;
    L4:
        injectMode = 2;
        goto L5
    }

    private int getInputDeviceId(int inputSource) {
        int[] devIds = InputDevice.getDeviceIds();
        int r1 = devIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int devId = devIds[r3];
        InputDevice inputDev = InputDevice.getDevice(devId);
        if (inputDev.supportsSource(inputSource) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return devId;
    L8:
        return 0;
    }

    private int getDisplayId() {
        String displayArg = getNextArgRequired();
        if ("INVALID_DISPLAY".equalsIgnoreCase(displayArg) == false) goto L6;
        return -1;
    L6:
        if ("DEFAULT_DISPLAY".equalsIgnoreCase(displayArg) == false) goto L16;
        return 0;
    L16:
        int displayId = Integer.parseInt(displayArg);     // Catch: NumberFormatException -> L13
        if (displayId != (-1)) goto L11;
        return -1;
    L11:
        return Math.max(displayId, 0);
    L15:
        throw new IllegalArgumentException(INVALID_DISPLAY_ARGUMENTS);
    }

    private void injectMotionEvent(int inputSource, int action, long downTime, long when, float x, float y, float pressure, int displayId) {
        Map<Integer, Float> axisValues = Map.of(0, Float.valueOf(x), 1, Float.valueOf(y), 2, Float.valueOf(pressure));
        injectMotionEvent(inputSource, action, downTime, when, axisValues, displayId);
    }

    private void injectMotionEvent(int inputSource, int action, long downTime, long when, Map<Integer, Float> axisValues, int displayId) {
        MotionEvent.PointerProperties[] pointerProperties = new MotionEvent.PointerProperties[1];
        int i = 0;
    L3:
        if (i >= 1) goto L5;
        pointerProperties[i] = new MotionEvent.PointerProperties();
        pointerProperties[i].id = i;
        pointerProperties[i].toolType = getToolType(inputSource);
        i = i + 1;
        goto L3
    L5:
        MotionEvent.PointerCoords[] pointerCoords = new MotionEvent.PointerCoords[1];
        int i2 = 0;
    L6:
        if (i2 >= 1) goto L13;
        pointerCoords[i2] = new MotionEvent.PointerCoords();
        pointerCoords[i2].size = 1.0f;
        Iterator<Map.Entry<Integer, Float>> r3 = axisValues.entrySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        Map.Entry<Integer, Float> entry = r3.next();
        pointerCoords[i2].setAxisValue(entry.getKey().intValue(), entry.getValue().floatValue());
        goto L9
    L11:
        i2 = i2 + 1;
        goto L6
    L13:
        if (displayId == (-1)) goto L15;
    L17:
        int displayId2 = displayId;
    L18:
        MotionEvent event = MotionEvent.obtain(downTime, when, action, 1, pointerProperties, pointerCoords, 0, 0, 1.0f, 1.0f, getInputDeviceId(inputSource), 0, inputSource, displayId2, 0);
        this.mInputEventInjector.accept(event, 2);
        return;
    L15:
        if ((inputSource & 2) == 0) goto L17;
        displayId2 = 0;
        goto L18
    }

    private float lerp(float a, float b, float alpha) {
        return ((b - a) * alpha) + a;
    }

    private int getSource(int inputSource, int defaultSource) {
        if (inputSource != 0) goto L5;
        return defaultSource;
    L5:
        return inputSource;
    }

    private int getToolType(int inputSource) {
        switch(inputSource) {
            case 4098: goto L9;
            case 8194: goto L7;
            case 16386: goto L5;
            case 49154: goto L5;
            case 65540: goto L7;
            case 131076: goto L7;
            case 1048584: goto L9;
            case 2097152: goto L9;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 3;
    L9:
        return 1;
    }

    public final int onCommand(String cmd) {
        String arg = cmd;
        int inputSource = 0;
        if (SOURCES.containsKey(arg) == false) goto L5;
        inputSource = SOURCES.get(arg).intValue();
        arg = getNextArgRequired();
    L5:
        int displayId = -1;
        if ("-d".equals(arg) == false) goto L45;
        displayId = getDisplayId();
        arg = getNextArgRequired();
    L45:
        if ("text".equals(arg) == false) goto L14;
        runText(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L14:
        if ("keyevent".equals(arg) == false) goto L17;
        runKeyEvent(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L17:
        if ("tap".equals(arg) == false) goto L20;
        runTap(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L20:
        if ("swipe".equals(arg) == false) goto L23;
        runSwipe(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L23:
        if ("draganddrop".equals(arg) == false) goto L26;
        runDragAndDrop(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L26:
        if ("press".equals(arg) == false) goto L29;
        runPress(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L29:
        if ("roll".equals(arg) == false) goto L32;
        runRoll(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L32:
        if ("scroll".equals(arg) == false) goto L35;
        runScroll(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L35:
        if ("motionevent".equals(arg) == false) goto L38;
        runMotionEvent(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L38:
        if ("keycombination".equals(arg) == false) goto L40;
        runKeyCombination(inputSource, displayId);     // Catch: NumberFormatException -> L11
        return 0;
    L40:
        handleDefaultCommands(arg);     // Catch: NumberFormatException -> L11
        return 0;
    L44:
        throw new IllegalArgumentException(INVALID_ARGUMENTS + arg);
    }

    public final void onHelp() {
        PrintWriter out = getOutPrintWriter();
        out.println("Usage: input [<source>] [-d DISPLAY_ID] <command> [<arg>...]");     // Catch: Throwable -> L7
        out.println();     // Catch: Throwable -> L7
        out.println("The sources are: ");     // Catch: Throwable -> L7
        Iterator<String> r1 = SOURCES.keySet().iterator();     // Catch: Throwable -> L7
    L5:
        if (r1.hasNext() == false) goto L9;
        String src = r1.next();     // Catch: Throwable -> L7
        out.println("      " + src);     // Catch: Throwable -> L7
        goto L5
    L9:
        out.println("[axis_value] represents an option specifying the value of a given axis ");     // Catch: Throwable -> L7
        out.println("      The syntax is as follows: --axis <axis_name>,<axis_value>");     // Catch: Throwable -> L7
        out.println("            where <axis_name> is the name of the axis as defined in ");     // Catch: Throwable -> L7
        out.println("            MotionEvent without the AXIS_ prefix (e.g. SCROLL, X)");     // Catch: Throwable -> L7
        out.println("      Sample [axis_values] entry: `--axis Y,3`, `--axis SCROLL,-2`");     // Catch: Throwable -> L7
        out.println();     // Catch: Throwable -> L7
        out.printf("-d: specify the display ID.\n      (Default: %d for key event, %d for motion event if not specified.)", new Object[]{-1, 0});     // Catch: Throwable -> L7
        out.println();     // Catch: Throwable -> L7
        out.println("The commands and default sources are:");     // Catch: Throwable -> L7
        out.println("      text <string> (Default: keyboard)");     // Catch: Throwable -> L7
        out.println("      keyevent [--longpress|--duration <duration to hold key down in ms>] [--doubletap] [--async] [--delay <duration between keycodes in ms>] <key code number or name> ... (Default: keyboard)");     // Catch: Throwable -> L7
        out.println("      tap <x> <y> (Default: touchscreen)");     // Catch: Throwable -> L7
        out.println("      swipe <x1> <y1> <x2> <y2> [duration(ms)] (Default: touchscreen)");     // Catch: Throwable -> L7
        out.println("      draganddrop <x1> <y1> <x2> <y2> [duration(ms)] (Default: touchscreen)");     // Catch: Throwable -> L7
        out.println("      press (Default: trackball)");     // Catch: Throwable -> L7
        out.println("      roll <dx> <dy> (Default: trackball)");     // Catch: Throwable -> L7
        out.println("      motionevent <DOWN|UP|MOVE|CANCEL> <x> <y> (Default: touchscreen)");     // Catch: Throwable -> L7
        out.println("      scroll (Default: rotaryencoder). Has the following syntax:");     // Catch: Throwable -> L7
        out.println("            scroll <x> <y> [axis_value] (for pointer-based sources)");     // Catch: Throwable -> L7
        out.println("            scroll [axis_value] (for non-pointer-based sources)");     // Catch: Throwable -> L7
        out.println("            Axis options: SCROLL, HSCROLL, VSCROLL");     // Catch: Throwable -> L7
        out.println("            None or one or multiple axis value options can be specified.");     // Catch: Throwable -> L7
        out.println("            To specify multiple axes, use one axis option for per axis.");     // Catch: Throwable -> L7
        out.println("            Example: `scroll --axis VSCROLL,2 --axis SCROLL,-2.4`");     // Catch: Throwable -> L7
        out.println("      keycombination [-t duration(ms)] <key code 1> <key code 2> ... (Default: keyboard, the key order is important here.)");     // Catch: Throwable -> L7
        out.close();
        return;
    L7:
        th = move-exception;
        if (out != null) goto L18;
    L17:
        throw th;
    L18:
        out.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    private void runText(int inputSource, int displayId) {
        sendText(getSource(inputSource, 257), getNextArgRequired(), displayId);
    }

    private void sendText(int source, String text, int displayId) {
        StringBuilder buff = new StringBuilder(text);
        boolean escapeFlag = false;
        int i = 0;
    L4:
        if (i >= buff.length()) goto L13;
        if (escapeFlag == false) goto L10;
        escapeFlag = false;
        if (buff.charAt(i) != 's') goto L10;
        buff.setCharAt(i, ' ');
        i = i - 1;
        buff.deleteCharAt(i);
    L10:
        if (buff.charAt(i) != '%') goto L12;
        escapeFlag = true;
    L12:
        i = i + 1;
        goto L4
    L13:
        char[] chars = buff.toString().toCharArray();
        KeyCharacterMap kcm = KeyCharacterMap.load(-1);
        KeyEvent[] events = kcm.getEvents(chars);
        int i2 = 0;
    L15:
        if (i2 >= events.length) goto L21;
        KeyEvent e = events[i2];
        if (source == e.getSource()) goto L19;
        e.setSource(source);
    L19:
        e.setDisplayId(displayId);
        injectKeyEvent(e, false);
        i2 = i2 + 1;
        goto L15
    }

    private void runKeyEvent(int inputSource, int displayId) {
        InputShellCommand r0 = this;
        boolean longPress = false;
        boolean async = false;
        boolean doubleTap = false;
        long delayMs = 0;
        long durationMs = 0;
        String arg = r0.getNextArgRequired();
    L4:
        if (arg.startsWith("--") == false) goto L5;
        boolean r9 = true;
        if (longPress == false) goto L9;
    L12:
        boolean r11 = true;
    L13:
        longPress = r11;
        if (async == false) goto L16;
    L19:
        boolean r12 = true;
    L20:
        async = r12;
        if (doubleTap == false) goto L23;
    L26:
        doubleTap = r9;
        if (arg.equals("--delay") == false) goto L30;
        delayMs = Long.parseLong(r0.getNextArgRequired());
    L32:
        String r10 = r0.getNextArg();
        arg = r10;
        if (r10 == null) goto L34;
        r0 = this;
        goto L4
    L34:
        boolean longPress2 = longPress;
        boolean doubleTap2 = doubleTap;
        long delayMs2 = delayMs;
        long r15 = durationMs;
        boolean async2 = async;
        long durationMs2 = r15;
    L35:
        long durationMs3 = 0;
        if (durationMs2 <= 0) goto L41;
        if (longPress2 == false) goto L41;
        r0.getErrPrintWriter().println("--duration and --longpress cannot be used at the same time.");
        throw new IllegalArgumentException("keyevent args should only contain either durationMs or longPress");
    L41:
        if (longPress2 == false) goto L43;
        long durationMs4 = ViewConfiguration.getLongPressTimeout();
        long durationMs5 = durationMs4;
    L44:
        boolean firstInput = true;
    L45:
        if (firstInput == false) goto L47;
    L49:
        int keyCode = KeyEvent.keyCodeFromString(arg);
        r0.sendKeyEvent(inputSource, keyCode, durationMs5, displayId, async2);
        if (doubleTap2 == false) goto L53;
        r0.sleep(ViewConfiguration.getDoubleTapMinTime());
        r0.sendKeyEvent(inputSource, keyCode, durationMs5, displayId, async2);
    L53:
        String r1 = getNextArg();
        arg = r1;
        if (r1 == null) goto L55;
        async2 = async2;
        firstInput = false;
        durationMs5 = durationMs5;
        durationMs3 = 0;
        r0 = this;
        goto L45
    L55:
        return;
    L47:
        if (delayMs2 <= durationMs3) goto L49;
        r0.sleep(delayMs2);
        goto L49
    L43:
        durationMs5 = durationMs2;
        goto L44
    L30:
        if (arg.equals("--duration") == false) goto L32;
        durationMs = Long.parseLong(r0.getNextArgRequired());
        goto L32
    L23:
        if (arg.equals("--doubletap") == true) goto L26;
        r9 = false;
        goto L26
    L16:
        if (arg.equals("--async") == true) goto L19;
        r12 = false;
        goto L20
    L9:
        if (arg.equals("--longpress") == true) goto L12;
        r11 = false;
        goto L13
    L5:
        longPress2 = longPress;
        doubleTap2 = doubleTap;
        delayMs2 = delayMs;
        long r16 = durationMs;
        async2 = async;
        durationMs2 = r16;
        goto L35
    }

    private void sendKeyEvent(int inputSource, int keyCode, long durationMs, int displayId, boolean async) {
        long now = SystemClock.uptimeMillis();
        KeyEvent event = new KeyEvent(now, now, 0, keyCode, 0, 0, -1, 0, 0, inputSource);
        event.setDisplayId(displayId);
        injectKeyEvent(event, async);
        long firstSleepDurationMs = Math.min(durationMs, ViewConfiguration.getLongPressTimeout());
        if (firstSleepDurationMs <= 0) goto L9;
        sleep(firstSleepDurationMs);
        if (durationMs < ViewConfiguration.getLongPressTimeout()) goto L9;
        long nextEventTime = ((long) ViewConfiguration.getLongPressTimeout()) + now;
        KeyEvent longPressEvent = KeyEvent.changeTimeRepeat(event, nextEventTime, 1, 128);
        injectKeyEvent(longPressEvent, async);
        long secondSleepDurationMs = durationMs - firstSleepDurationMs;
        if (secondSleepDurationMs <= 0) goto L9;
        sleep(secondSleepDurationMs);
    L9:
        injectKeyEvent(KeyEvent.changeAction(KeyEvent.changeTimeRepeat(event, SystemClock.uptimeMillis(), 0), 1), async);
    }

    private void runTap(int inputSource, int displayId) {
        sendTap(getSource(inputSource, UsbACInterface.FORMAT_II_AC3), Float.parseFloat(getNextArgRequired()), Float.parseFloat(getNextArgRequired()), displayId);
    }

    private void sendTap(int inputSource, float x, float y, int displayId) {
        long now = SystemClock.uptimeMillis();
        injectMotionEvent(inputSource, 0, now, now, x, y, 1.0f, displayId);
        injectMotionEvent(inputSource, 1, now, now, x, y, NO_PRESSURE, displayId);
    }

    private void runPress(int inputSource, int displayId) {
        sendTap(getSource(inputSource, 65540), NO_PRESSURE, NO_PRESSURE, displayId);
    }

    private void runSwipe(int inputSource, int displayId) {
        sendSwipe(getSource(inputSource, UsbACInterface.FORMAT_II_AC3), displayId, false);
    }

    private void sendSwipe(int inputSource, int displayId, boolean isDragDrop) {
        float x1 = Float.parseFloat(getNextArgRequired());
        float y1 = Float.parseFloat(getNextArgRequired());
        float x2 = Float.parseFloat(getNextArgRequired());
        float y2 = Float.parseFloat(getNextArgRequired());
        String durationArg = getNextArg();
        if (durationArg == null) goto L5;
        int duration = Integer.parseInt(durationArg);
    L6:
        if (duration >= 0) goto L8;
        int duration2 = 300;
    L9:
        long down = SystemClock.uptimeMillis();
        InputShellCommand r0 = this;
        r0.injectMotionEvent(inputSource, 0, down, down, x1, y1, 1.0f, displayId);
        float y3 = y1;
        if (isDragDrop == false) goto L12;
        r0.sleep(ViewConfiguration.getLongPressTimeout());
    L12:
        long now = SystemClock.uptimeMillis();
        long endTime = down + ((long) duration2);
        int injected = 1;
    L14:
        if (now >= endTime) goto L24;
        long elapsedTime = now - down;
        long errorMillis = (long) Math.floor((injected * 8.333333f) - elapsedTime);
        if (errorMillis <= 0) goto L22;
        if (errorMillis > (endTime - now)) goto L19;
        r0.sleep(errorMillis);
        goto L22
    L19:
        r0.sleep(endTime - now);
        down = down;
    L22:
        long now2 = SystemClock.uptimeMillis();
        long elapsedTime2 = now2 - down;
        float alpha = elapsedTime2 / duration2;
        down = down;
        r0.injectMotionEvent(inputSource, 2, down, now2, r0.lerp(x1, x2, alpha), r0.lerp(y3, y2, alpha), 1.0f, displayId);
        injected = injected + 1;
        now = SystemClock.uptimeMillis();
        r0 = this;
        y3 = y3;
    L24:
        injectMotionEvent(inputSource, 1, down, now, x2, y2, NO_PRESSURE, displayId);
        return;
    L8:
        duration2 = duration;
        goto L9
    L5:
        duration = -1;
        goto L6
    }

    private void runDragAndDrop(int inputSource, int displayId) {
        sendSwipe(getSource(inputSource, UsbACInterface.FORMAT_II_AC3), displayId, true);
    }

    private void runRoll(int inputSource, int displayId) {
        sendMove(getSource(inputSource, 65540), Float.parseFloat(getNextArgRequired()), Float.parseFloat(getNextArgRequired()), displayId);
    }

    private void runScroll(int inputSource, int displayId) {
        int inputSource2 = getSource(inputSource, 4194304);
        if ((inputSource2 & 2) != 2) goto L5;
        boolean isPointerEvent = true;
    L6:
        Map<Integer, Float> axisValues = new HashMap();
        if (isPointerEvent == false) goto L9;
        axisValues.put(0, Float.valueOf(Float.parseFloat(getNextArgRequired())));
        axisValues.put(1, Float.valueOf(Float.parseFloat(getNextArgRequired())));
    L9:
        Set<Integer> supportedAxes = Set.of(10, 9, 26);
    L10:
        String nextOption = getNextOption();
        if (nextOption == null) goto L23;
        switch(nextOption.hashCode()) {
            case 1332878657: goto L16;
            default: goto L18;
        };
    L18:
        byte r3 = -1;
    L19:
        switch(r3) {
            case 0: goto L22;
            default: goto L21;
        };
    L22:
        Pair<Integer, Float> axisAndValue = readAxisOptionValues(supportedAxes);
        axisValues.put((Integer) axisAndValue.first, (Float) axisAndValue.second);
        goto L10
    L21:
        throw new IllegalArgumentException("Unsupported option: " + nextOption);
    L16:
        if (nextOption.equals("--axis") == false) goto L18;
        r3 = 0;
        goto L19
    L23:
        long now = SystemClock.uptimeMillis();
        injectMotionEvent(inputSource2, 8, now, now, axisValues, displayId);
        return;
    L5:
        isPointerEvent = false;
        goto L6
    }

    private Pair<Integer, Float> readAxisOptionValues(Set<Integer> supportedAxes) {
        String optionValue = getNextArgRequired();
        String[] axisAndValue = optionValue.split(",");
        if (axisAndValue.length != 2) goto L15;
        String axisName = "AXIS_" + axisAndValue[0];
        int axis = MotionEvent.axisFromString(axisName);
        if (axis == (-1)) goto L13;
        if (supportedAxes.contains(Integer.valueOf(axis)) == false) goto L11;
        return Pair.create(Integer.valueOf(axis), Float.valueOf(Float.parseFloat(axisAndValue[1])));
    L11:
        throw new IllegalArgumentException("Unsupported axis: " + axisName);
    L13:
        throw new IllegalArgumentException("Invalid axis name: " + axisName);
    L15:
        throw new IllegalArgumentException("Invalid --axis option value: " + optionValue);
    }

    private void sendMove(int inputSource, float dx, float dy, int displayId) {
        long now = SystemClock.uptimeMillis();
        injectMotionEvent(inputSource, 2, now, now, dx, dy, NO_PRESSURE, displayId);
    }

    private int getAction() {
        String actionString = getNextArgRequired();
        String r1 = actionString.toUpperCase();
        switch(r1.hashCode()) {
            case 2715: goto L15;
            case 2104482: goto L12;
            case 2372561: goto L9;
            case 1980572282: goto L6;
            default: goto L17;
        };
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            default: goto L20;
        };
    L21:
        return 3;
    L22:
        return 2;
    L23:
        return 1;
    L24:
        return 0;
    L20:
        throw new IllegalArgumentException("Unknown action: " + actionString);
    L6:
        if (r1.equals("CANCEL") == false) goto L17;
        r2 = 3;
        goto L18
    L9:
        if (r1.equals("MOVE") == false) goto L17;
        r2 = 2;
        goto L18
    L12:
        if (r1.equals("DOWN") == false) goto L17;
        r2 = 0;
        goto L18
    L15:
        if (r1.equals("UP") == false) goto L17;
        r2 = 1;
        goto L18
    }

    private void runMotionEvent(int inputSource, int displayId) {
        int inputSource2 = getSource(inputSource, UsbACInterface.FORMAT_II_AC3);
        int action = getAction();
        if (action != 0) goto L5;
    L14:
        float x = Float.parseFloat(getNextArgRequired());
        float y = Float.parseFloat(getNextArgRequired());
        float x2 = x;
        float y2 = y;
    L15:
        sendMotionEvent(inputSource2, action, x2, y2, displayId);
        return;
    L5:
        if (action == 2) goto L14;
        if (action == 1) goto L14;
        String xString = getNextArg();
        String yString = getNextArg();
        if (xString == null) goto L13;
        if (yString == null) goto L13;
        float x3 = Float.parseFloat(xString);
        float y3 = Float.parseFloat(yString);
        x2 = x3;
        y2 = y3;
    L13:
        x2 = 0.0f;
        y2 = 0.0f;
        goto L15
    }

    private void sendMotionEvent(int inputSource, int action, float x, float y, int displayId) {
        if (action != 0) goto L5;
    L8:
        float pressure = 1.0f;
    L9:
        long now = SystemClock.uptimeMillis();
        injectMotionEvent(inputSource, action, now, now, x, y, pressure, displayId);
        return;
    L5:
        if (action == 2) goto L8;
        pressure = 0.0f;
        goto L9
    }

    private void runKeyCombination(int inputSource, int displayId) {
        String arg = getNextArgRequired();
        if ("-t".equals(arg) == false) goto L5;
        long duration = Integer.parseInt(getNextArgRequired());
        arg = getNextArgRequired();
        long duration2 = duration;
    L6:
        IntArray keyCodes = new IntArray();
    L7:
        if (arg == null) goto L14;
        int keyCode = KeyEvent.keyCodeFromString(arg);
        if (keyCode == 0) goto L12;
        keyCodes.add(keyCode);
        arg = getNextArg();
        goto L7
    L12:
        throw new IllegalArgumentException("Unknown keycode: " + arg);
    L14:
        if (keyCodes.size() < 2) goto L18;
        sendKeyCombination(inputSource, keyCodes, displayId, duration2);
        return;
    L18:
        throw new IllegalArgumentException("keycombination requires at least 2 keycodes");
    L5:
        duration2 = 0;
        goto L6
    }

    private void sendKeyCombination(int inputSource, IntArray keyCodes, int displayId, long duration) {
        long now = SystemClock.uptimeMillis();
        int count = keyCodes.size();
        KeyEvent[] events = new KeyEvent[count];
        int metaState = 0;
        int metaState2 = 0;
    L4:
        if (metaState2 >= count) goto L6;
        int keyCode = keyCodes.get(metaState2);
        int i = metaState2;
        KeyEvent event = new KeyEvent(now, now, 0, keyCode, 0, metaState, -1, 0, 0, inputSource);
        event.setDisplayId(displayId);
        events[i] = event;
        metaState = metaState | MODIFIER.getOrDefault(Integer.valueOf(keyCode), 0).intValue();
        metaState2 = i + 1;
        goto L4
    L6:
        int i2 = events.length;
        int r5 = 0;
    L7:
        boolean r6 = true;
        if (r5 >= i2) goto L10;
        KeyEvent event2 = events[r5];
        injectKeyEvent(event2, true);
        r5 = r5 + 1;
        goto L7
    L10:
        sleep(duration);
        int r1 = events.length;
        int r7 = 0;
    L11:
        if (r7 >= r1) goto L13;
        KeyEvent event3 = events[r7];
        int keyCode2 = event3.getKeyCode();
        int r8 = r1;
        boolean r10 = r6;
        KeyEvent upEvent = new KeyEvent(now, now, 1, keyCode2, 0, metaState, -1, 0, 0, inputSource);
        injectKeyEvent(upEvent, r10);
        metaState = metaState & (~MODIFIER.getOrDefault(Integer.valueOf(keyCode2), 0).intValue());
        r7 = r7 + 1;
        r6 = r10;
        count = count;
        r1 = r8;
        goto L11
    }

    private void sleep(long milliseconds) {
        Thread.sleep(milliseconds);     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
