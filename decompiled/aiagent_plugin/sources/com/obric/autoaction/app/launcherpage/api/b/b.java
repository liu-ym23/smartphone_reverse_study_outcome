package com.obric.autoaction.app.launcherpage.api.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.eventkit.ITaskManagerApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.m;
import d.n;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SystemInfoUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f22887b = null;

    /* JADX INFO: compiled from: SystemInfoUtil.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22890c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22888a, r6.f22888a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f22889b, r6.f22889b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f22890c, r6.f22890c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f22888a.hashCode() * 31) + this.f22889b.hashCode()) * 31) + this.f22890c.hashCode();
        }

        public String toString() {
            return "BondedBluetoothDeviceInfo(name=" + this.f22888a + ", type=" + this.f22889b + ", address=" + this.f22890c + ')';
        }

        public a(String r2, String r3, String r4) {
            o.e(r2, "name");
            o.e(r3, "type");
            o.e(r4, SensitiveType.ADDRESS);
            this.f22888a = r2;
            this.f22889b = r3;
            this.f22890c = r4;
        }

        public final String a() {
            return this.f22888a;
        }

        public final String getType() {
            return this.f22889b;
        }

        public final String b() {
            return this.f22890c;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.api.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SystemInfoUtil.kt */
    public static final class C0492b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22892b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0492b.class) == true) goto L8;
            return false;
        L8:
            C0492b r6 = (C0492b) ZeusTransformUtils.preCheckCast(r5, C0492b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22891a, r6.f22891a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f22892b, r6.f22892b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f22891a.hashCode() * 31) + this.f22892b.hashCode();
        }

        public String toString() {
            return "ConfiguredWifiInfo(ssid=" + this.f22891a + ", bssid=" + this.f22892b + ')';
        }

        public C0492b(String r2, String r3) {
            o.e(r2, "ssid");
            o.e(r3, "bssid");
            this.f22891a = r2;
            this.f22892b = r3;
        }

        public final String a() {
            return this.f22891a;
        }

        public final String b() {
            return this.f22892b;
        }
    }

    public static /* synthetic */ x lambda$BunU1Tz7SQ4ryDrQJummsAlKmAE(DialogInterface r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ x lambda$MqavUi1lEU3LLgu6FKMMZdwOS9I(Context r0, DialogInterface r1, int r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$czuEaU3GGBKlU2W_1ax46bs2cUE(Context r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$eKoLAk65_SqD2eCQ4CZGAEcZ2CQ(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    private b() {
    }

    public final List<C0492b> a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (h(r4) == true) goto L7;
        return null;
    L7:
        return b(r4);
    }

    public final List<C0492b> b(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Object r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("wifi");
        if (ZeusTransformUtils.instanceOf(r8, WifiManager.class) == false) goto L5;
        WifiManager r9 = (WifiManager) ZeusTransformUtils.preCheckCast(r8, WifiManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r9 == null) goto L8;
        List<WifiConfiguration> r10 = r9.getConfiguredNetworks();
        if (r10 == null) goto L12;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L15:
        if (r13.hasNext() == false) goto L39;
        WifiConfiguration r2 = (WifiConfiguration) ZeusTransformUtils.preCheckCast(r13.next(), WifiConfiguration.class, "com.obric.aiagent.plugin");
        String r3 = r2.SSID;
        if (r3 == null) goto L36;
        String r4 = d.o.o.c(r3, (CharSequence) ZeusTransformUtils.preCheckCast("\"", CharSequence.class, "com.obric.aiagent.plugin"));
        if (r4 == null) goto L36;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L27;
        r4 = null;
    L27:
        if (r4 == null) goto L36;
        String r14 = r2.BSSID;
        if (r14 == null) goto L32;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L33:
        if (r15 != null) goto L35;
        r15 = "";
    L35:
        C0492b r16 = new C0492b(r4, r15);
    L37:
        if (r16 == null) goto L15;
        r12.add(r16);
        goto L15
    L32:
        r15 = null;
        goto L33
    L23:
        r5 = false;
    L36:
        r16 = null;
        goto L37
    L39:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        HashSet r18 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r19 = r17.iterator();
    L41:
        if (r19.hasNext() == false) goto L46;
        Object r20 = r19.next();
        C0492b r21 = (C0492b) ZeusTransformUtils.preCheckCast(r20, C0492b.class, "com.obric.aiagent.plugin");
        if (r18.add(new m(r21.a(), r21.b())) == false) goto L41;
        r1.add(r20);
        goto L41
    L46:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L12:
        return p.b();
    L8:
        return p.b();
    L5:
        r9 = null;
        goto L6
    }

    public final boolean c(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        if (androidx.core.content.a.b(r3, "android.permission.ACCESS_WIFI_STATE") != 0) goto L5;
        boolean r5 = true;
    L7:
        if (androidx.core.content.a.b(r3, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r5 == false) goto L14;
        if (r6 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    private final boolean h(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (c(r4) == false) goto L5;
        return true;
    L5:
        i(r4);
        return false;
    }

    private final void i(Context r7) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.dialog.v2.alert.a r8 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a(r6).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(R.string.obric_wifi_permission_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_wifi_permission_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(R.string.obric_wifi_permission_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_wifi_permission_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = r6.getString(ZeusTransformUtils.mapRes(R.string.obric_permission_go_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_permission_go_settings"));
        o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r9 = r8.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$b$czuEaU3GGBKlU2W_1ax46bs2cUE(r6));
        String r10 = r6.getString(ZeusTransformUtils.mapRes(R.string.obric_permission_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_permission_cancel"));
        o.c(r10, "getString(...)");
        r9.b((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$b$eKoLAk65_SqD2eCQ4CZGAEcZ2CQ.INSTANCE).h();
    }

    private static final x a(Context r1, DialogInterface r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "dialog");
        r5.dismiss();
        f22886a.l(r4);
        return x.f38692a;
    }

    private static final x a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    public final List<a> d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (j(r4) == true) goto L7;
        return null;
    L7:
        return f(r4);
    }

    public final boolean e(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        Object r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("bluetooth");
        if (ZeusTransformUtils.instanceOf(r3, BluetoothManager.class) == false) goto L5;
        BluetoothManager r4 = (BluetoothManager) ZeusTransformUtils.preCheckCast(r3, BluetoothManager.class, "com.obric.aiagent.plugin");
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        BluetoothAdapter r5 = r4.getAdapter();
        if (r5 != null) goto L13;
        return false;
    L13:
        return r5.isEnabled();
    L5:
        r4 = null;
        goto L7
    }

    public final List<a> f(Context r9) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        Object r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("bluetooth");
        if (ZeusTransformUtils.instanceOf(r10, BluetoothManager.class) == false) goto L5;
        BluetoothManager r11 = (BluetoothManager) ZeusTransformUtils.preCheckCast(r10, BluetoothManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L8;
        BluetoothAdapter r12 = r11.getAdapter();
        if (r12 == null) goto L12;
        Set<BluetoothDevice> r13 = r12.getBondedDevices();
        if (r13 == null) goto L16;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L32;
        BluetoothDevice r3 = (BluetoothDevice) ZeusTransformUtils.preCheckCast(r15.next(), BluetoothDevice.class, "com.obric.aiagent.plugin");
        String r5 = r3.getName();
        if (r5 != null) goto L23;
        r5 = r8.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_device_unknown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_device_unknown"));
        o.c(r5, "getString(...)");
    L23:
        b r6 = f22886a;
        BluetoothClass r7 = r3.getBluetoothClass();
        if (r7 == null) goto L26;
        Integer r16 = Integer.valueOf(r7.getMajorDeviceClass());
    L27:
        String r17 = r6.a(r8, r16);
        String r4 = r3.getAddress();
        if (r4 != null) goto L30;
        r4 = "";
    L30:
        r1.add(new a(r5, r17, r4));
        goto L19
    L26:
        r16 = null;
        goto L27
    L32:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L16:
        return p.b();
    L12:
        return p.b();
    L8:
        return p.b();
    L5:
        r11 = null;
        goto L6
    }

    private final boolean j(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (g(r4) == false) goto L5;
        return true;
    L5:
        k(r4);
        return false;
    }

    public final boolean g(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        String r3 = "android.permission.BLUETOOTH_CONNECT";
    L7:
        if (androidx.core.content.a.b(r1, r3) != 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = "android.permission.BLUETOOTH";
        goto L7
    }

    private final void k(Context r7) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.dialog.v2.alert.a r8 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a(r6).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(R.string.obric_bluetooth_permission_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bluetooth_permission_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r6.getString(ZeusTransformUtils.mapRes(R.string.obric_bluetooth_permission_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bluetooth_permission_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = r6.getString(ZeusTransformUtils.mapRes(R.string.obric_permission_go_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_permission_go_settings"));
        o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r9 = r8.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$b$MqavUi1lEU3LLgu6FKMMZdwOS9I(r6));
        String r10 = r6.getString(ZeusTransformUtils.mapRes(R.string.obric_permission_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_permission_cancel"));
        o.c(r10, "getString(...)");
        r9.b((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$b$BunU1Tz7SQ4ryDrQJummsAlKmAE.INSTANCE).h();
    }

    private static final x b(Context r1, DialogInterface r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "dialog");
        r5.dismiss();
        f22886a.l(r4);
        return x.f38692a;
    }

    private static final x b(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    private final void l(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        b r5 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Intent r8 = new Intent("android.intent.action.MANAGE_APP_PERMISSIONS");     // Catch: Throwable -> L5
        r8.putExtra("android.intent.extra.PACKAGE_NAME", r7.getPackageName());     // Catch: Throwable -> L5
        r8.addFlags(268435456);     // Catch: Throwable -> L5
        ZeusTransformUtils.startActivity(r7, r8, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        n.f(d.o.a(th));
        n.a r9 = n.f38560a;     // Catch: Throwable -> L9
        Intent r10 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Throwable -> L9
        r10.setData(Uri.fromParts("package", r7.getPackageName(), null));     // Catch: Throwable -> L9
        r10.addFlags(268435456);     // Catch: Throwable -> L9
        ZeusTransformUtils.startActivity(r7, r10, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        n.f(x.f38692a);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        n.a r11 = n.f38560a;
        n.f(d.o.a(th));
    }

    private final String a(Context r5, Integer r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        String r7 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_unknown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_unknown"));
        o.c(r7, "getString(...)");
        return r7;
    L7:
        if (r6.intValue() != 512) goto L10;
        String r8 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_phone, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_phone"));
        o.c(r8, "getString(...)");
        return r8;
    L10:
        if (r6.intValue() != 256) goto L13;
        String r9 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_computer, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_computer"));
        o.c(r9, "getString(...)");
        return r9;
    L13:
        if (r6.intValue() != 1024) goto L16;
        String r10 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_audio, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_audio"));
        o.c(r10, "getString(...)");
        return r10;
    L16:
        if (r6.intValue() != 1280) goto L19;
        String r11 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_peripheral, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_peripheral"));
        o.c(r11, "getString(...)");
        return r11;
    L19:
        if (r6.intValue() != 1792) goto L22;
        String r12 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_wearable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_wearable"));
        o.c(r12, "getString(...)");
        return r12;
    L22:
        if (r6.intValue() != 1536) goto L25;
        String r13 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_imaging, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_imaging"));
        o.c(r13, "getString(...)");
        return r13;
    L25:
        if (r6.intValue() != 2304) goto L28;
        String r14 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_health, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_health"));
        o.c(r14, "getString(...)");
        return r14;
    L28:
        if (r6.intValue() != 768) goto L31;
        String r15 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_network, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_network"));
        o.c(r15, "getString(...)");
        return r15;
    L31:
        if (r6.intValue() != 7936) goto L33;
        String r16 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_uncategorized, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_uncategorized"));
        o.c(r16, "getString(...)");
        return r16;
    L33:
        String r17 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_bt_type_unknown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_bt_type_unknown"));
        o.c(r17, "getString(...)");
        return r17;
    }

    static {
        f22886a = new b();
        f22887b = p.b(new String[]{"otp_code", "parcel_pickup", "repay_due", "balance_tx"});
    }

    public final List<String> a() {
        ITaskManagerApi r5 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        List<String> r6 = r5.getSmsConditionTypeList();
    L6:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        r6 = f22887b;
    L15:
        Map<String, String> r2 = com.obric.autoaction.app.launcherpage.api.b.a.f22885a.a();
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, String>> r4 = r2.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r6.contains(r7.getKey()) == false) goto L17;
        r3.put(r7.getKey(), r7.getValue());
        goto L17
    L21:
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r3.size()), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r3.entrySet().iterator();
    L23:
        if (r9.hasNext() == false) goto L26;
        r8.add((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L23
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public final String a(String r5) {
        o.e(r5, "categoryName");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.api.b.a.f22885a.a().entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r4, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        m r3 = s.a(r2.getValue(), r2.getKey());
        r0.put(r3.a(), r3.b());
        goto L4
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.aiagent.plugin");
    }
}
