package com.android.server.power.stats.wakeups;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.LongSparseArray;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class IrqDeviceMap {
    private static final String ATTR_NAME = "name";
    private static final String TAG_DEVICE = "device";
    private static final String TAG_IRQ_DEVICE_MAP = "irq-device-map";
    private static final String TAG_SUBSYSTEM = "subsystem";
    private static LongSparseArray<IrqDeviceMap> sInstanceMap;
    private final ArrayMap<String, List<String>> mSubsystemsForDevice;

    static {
        sInstanceMap = new LongSparseArray(1);
    }

    private IrqDeviceMap(XmlResourceParser parser) {
        this.mSubsystemsForDevice = new ArrayMap();
        XmlUtils.beginDocument(parser, TAG_IRQ_DEVICE_MAP);     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        String currentDevice = null;
        ArraySet<String> subsystems = new ArraySet();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
    L4:
        int type = parser.getEventType();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
    L6:
        if (type == 1) goto L36;
        if (type == 2) goto L10;
    L18:
        if (currentDevice != null) goto L20;
    L27:
        if (currentDevice == null) goto L34;
        if (type != 2) goto L34;
        if (parser.getName().equals(TAG_SUBSYSTEM) == false) goto L34;
        parser.next();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        if (parser.getEventType() != 4) goto L34;
        subsystems.add(parser.getText());     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
    L34:
        parser.next();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        goto L4
    L20:
        if (type != 3) goto L27;
        if (parser.getName().equals(TAG_DEVICE) == false) goto L27;
        int n = subsystems.size();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        if (n <= 0) goto L26;
        this.mSubsystemsForDevice.put(currentDevice, Collections.unmodifiableList(new ArrayList(subsystems)));     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
    L26:
        subsystems.clear();     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        currentDevice = null;
        goto L27
    L10:
        if (parser.getName().equals(TAG_DEVICE) == false) goto L18;
        currentDevice = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L12 IOException -> L14 XmlPullParserException -> L16
        goto L18
    L36:
        parser.close();
        return;
    L12:
        th = move-exception;
        parser.close();
        throw th;
    L14:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L12
    L16:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L12
    }

    public static IrqDeviceMap getInstance(Context context, int resId) {
        monitor-enter(IrqDeviceMap.class);
        int idx = sInstanceMap.indexOfKey(resId);     // Catch: Throwable -> L9
        if (idx < 0) goto L12;
        IrqDeviceMap r2 = sInstanceMap.valueAt(idx);     // Catch: Throwable -> L9
        monitor-exit(IrqDeviceMap.class);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(IrqDeviceMap.class);     // Catch: Throwable -> L9
        XmlResourceParser parser = context.getResources().getXml(resId);
        IrqDeviceMap irqDeviceMap = new IrqDeviceMap(parser);
        monitor-enter(IrqDeviceMap.class);
        sInstanceMap.put(resId, irqDeviceMap);     // Catch: Throwable -> L18
        monitor-exit(IrqDeviceMap.class);     // Catch: Throwable -> L18
        return irqDeviceMap;
    L18:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }

    List<String> getSubsystemsForDevice(String device) {
        return this.mSubsystemsForDevice.get(device);
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("Irq device map:");
        pw.increaseIndent();
        monitor-enter(IrqDeviceMap.class);
        LongSparseArray<IrqDeviceMap> instanceMap = sInstanceMap;     // Catch: Throwable -> L16
        monitor-exit(IrqDeviceMap.class);     // Catch: Throwable -> L16
        int idx = instanceMap.indexOfValue(this);
        if (idx < 0) goto L9;
        String res = "0x" + Long.toHexString(instanceMap.keyAt(idx));
    L10:
        pw.println("Loaded from xml resource: " + res);
        pw.println("Map:");
        pw.increaseIndent();
        int i = 0;
    L12:
        if (i >= this.mSubsystemsForDevice.size()) goto L14;
        pw.print(this.mSubsystemsForDevice.keyAt(i) + ": ");
        pw.println(this.mSubsystemsForDevice.valueAt(i));
        i = i + 1;
        goto L12
    L14:
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L9:
        res = null;
    L16:
        th = move-exception;
        throw th;
    }
}
