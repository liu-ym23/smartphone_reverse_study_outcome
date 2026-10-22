package com.bytedance.android.live.room.utils;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes47.dex */
public final class UsbDeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile UsbManager f100393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UsbDeviceUtils f100394b = null;

    public UsbDeviceUtils() {
    }

    static {
        f100394b = new UsbDeviceUtils();
    }

    public static boolean a() {
        if (f100393a != null) goto L5;
        u.l().sendLog("livesdk_live_broadcast_business_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_function", "checkHasUsbDevice"), TuplesKt.to("message", "usbManager is null")}), new Object[]{Room.class});
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UsbDeviceUtils$checkHasUsbDevice$1(null), 3, null);
    L5:
        UsbManager r100 = f100393a;
        if (r100 == null) goto L13;
        HashMap<String, UsbDevice> r101 = r100.getDeviceList();
        if (r101 != null) goto L10;
        return false;
    L10:
        if ((!r101.isEmpty()) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public static List b() {
        if (f100393a != null) goto L5;
        u.l().sendLog("livesdk_live_broadcast_business_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_function", "getConnectedUsbDevices"), TuplesKt.to("message", "usbManager is null")}), new Object[]{Room.class});
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UsbDeviceUtils$getConnectedUsbDevices$1(null), 3, null);
    L5:
        UsbManager r100 = f100393a;
        if (r100 == null) goto L9;
        HashMap<String, UsbDevice> r101 = r100.getDeviceList();
        if (r101 == null) goto L9;
    L10:
        ArrayList r102 = new ArrayList();
        Iterator<UsbDevice> r103 = r101.values().iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        r102.add(c(r103.next()));
        goto L12
    L14:
        return r102;
    L9:
        r101 = new HashMap();
        goto L10
    }

    public static String c(UsbDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "usbDevice");
        return "productId" + r100.getProductId() + "_vendorId:" + r100.getVendorId();
    }

    public final Object d(Continuation<? super UsbManager> r100) {
        if ((r100 instanceof UsbDeviceUtils$initUsbManager$1) == false) goto L7;
        UsbDeviceUtils$initUsbManager$1 r101 = (UsbDeviceUtils$initUsbManager$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        f100393a = (UsbManager) r103;
    L21:
        return f100393a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (f100393a != null) goto L21;
        CoroutineDispatcher r106 = Dispatchers.getIO();
        UsbDeviceUtils$initUsbManager$2 r107 = new UsbDeviceUtils$initUsbManager$2(null);
        r101.label = 1;
        r103 = BuildersKt.withContext(r106, r107, r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new UsbDeviceUtils$initUsbManager$1(this, r100);
        goto L8
    }
}
