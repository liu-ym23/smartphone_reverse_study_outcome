package com.bytedance.ai.bridge.method.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.ss.android.lark.utils.statistics.PerfLog;
import fna.g;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t3.i;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, C0687a> f35439b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile i f35440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Set<String> f35441d;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.device.a$a, reason: collision with other inner class name */
    public static final class C0687a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f35446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35447f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0687a) == true) goto L8;
            return false;
        L8:
            C0687a r101 = (C0687a) r100;
            if (Intrinsics.areEqual(this.f35442a, r101.f35442a) == true) goto L12;
            return false;
        L12:
            if (this.f35443b == r101.f35443b) goto L15;
            return false;
        L15:
            if (this.f35444c == r101.f35444c) goto L18;
            return false;
        L18:
            if (this.f35445d == r101.f35445d) goto L21;
            return false;
        L21:
            if (Double.compare(this.f35446e, r101.f35446e) == 0) goto L24;
            return false;
        L24:
            if (this.f35447f == r101.f35447f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f35442a.hashCode() * 31) + this.f35443b) * 31) + this.f35444c) * 31) + this.f35445d) * 31;
            long r101 = Double.doubleToLongBits(this.f35446e);
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f35447f;
        }

        public final String toString() {
            return "BeaconSnapshot(uuid=" + this.f35442a + ", major=" + this.f35443b + ", minor=" + this.f35444c + ", proximity=" + this.f35445d + ", accuracy=" + this.f35446e + ", rssi=" + this.f35447f + ')';
        }

        public C0687a(String r100, int r101, int r102, int r103, double r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            this.f35442a = r100;
            this.f35443b = r101;
            this.f35444c = r102;
            this.f35445d = r103;
            this.f35446e = r104;
            this.f35447f = r105;
        }
    }

    public a() {
    }

    static {
        f35438a = new a();
        new Handler(Looper.getMainLooper());
        f35439b = new ConcurrentHashMap();
        f35441d = SetsKt.emptySet();
    }

    public static Object b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("bluetooth");
        if ((r101 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r102 = (BluetoothManager) r101;
    L6:
        if (r102 == null) goto L8;
        BluetoothAdapter r103 = r102.getAdapter();
    L9:
        if (r103 == null) goto L11;
        BluetoothLeScanner r104 = r103.getBluetoothLeScanner();
    L12:
        i r105 = f35440c;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L22
        if (r104 == null) goto L20;
        if (r105 == null) goto L20;
        if (g.d() == true) goto L19;
        r104.stopScan(r105);     // Catch: Throwable -> L22
        goto L20
    L19:
        r104.stopScan(r105);     // Catch: Throwable -> L22
        ina.a.c(r105.hashCode());     // Catch: Throwable -> L22
    L20:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        f35440c = null;
        return r107;
    L22:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public static final void a(a r210, ScanResult r211) {
        r210.getClass();
        ScanRecord r100 = r211.getScanRecord();
        if (r100 == null) goto L38;
        byte[] r101 = r100.getManufacturerSpecificData(76);
        if (r101 == null) goto L38;
        if (r101.length < 23) goto L38;
        if (r101[0] != 2) goto L38;
        if (r101[1] != 21) goto L38;
        ByteBuffer r102 = ByteBuffer.wrap(ArraysKt.copyOfRange(r101, 2, 18));
        String r110 = new UUID(r102.getLong(), r102.getLong()).toString();
        if ((!f35441d.isEmpty()) == true) goto L17;
    L19:
        int r111 = (r101[19] & UByte.MAX_VALUE) | ((r101[18] & UByte.MAX_VALUE) << 8);
        int r112 = (r101[21] & UByte.MAX_VALUE) | ((r101[20] & UByte.MAX_VALUE) << 8);
        byte r103 = r101[22];
        int r104 = r211.getRssi();
        if (r104 != 0) goto L23;
        double r105 = -1.0d;
    L22:
        double r113 = r105;
        if (r113 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        int r114 = 0;
    L37:
        C0687a r106 = new C0687a(r110, r111, r112, r114, r113, r211.getRssi());
    L39:
        if (r106 == null) goto L43;
        f35439b.put(r106.f35442a + '-' + r106.f35443b + '-' + r106.f35444c, r106);
        return;
    L43:
        return;
    L31:
        if (r113 >= 0.5d) goto L34;
        r114 = 1;
        goto L37
    L34:
        if (r113 >= 3.0d) goto L36;
        r114 = 2;
        goto L37
    L36:
        r114 = 3;
        goto L37
    L23:
        double r107 = (((double) r104) * 1.0d) / ((double) r103);
        if (r107 >= 1.0d) goto L26;
        r105 = Math.pow(r107, 10.0d);
        goto L22
    L26:
        r105 = (Math.pow(r107, 7.7095d) * 0.89976d) + 0.111d;
        goto L22
    L17:
        if (f35441d.contains(r110.toLowerCase(Locale.ROOT)) == true) goto L19;
    L38:
        r106 = null;
        goto L39
    }
}
