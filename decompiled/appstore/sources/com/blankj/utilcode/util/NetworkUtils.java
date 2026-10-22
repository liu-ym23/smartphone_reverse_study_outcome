package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkUtils {

    public static final class NetworkChangedReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkType f6188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set f6189b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OnNetworkStatusChangedListener f6190a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NetworkChangedReceiver f6191b;

            public a(NetworkChangedReceiver r10, OnNetworkStatusChangedListener r11) {
                this.f6191b = r10;
                this.f6190a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                int r10 = NetworkChangedReceiver.b(this.f6191b).size();
                NetworkChangedReceiver.b(this.f6191b).add(this.f6190a);
                if (r10 == 0) goto L5;
                return;
            L5:
                if (NetworkChangedReceiver.b(this.f6191b).size() != 1) goto L9;
                NetworkChangedReceiver.d(this.f6191b, NetworkUtils.b());
                IntentFilter r11 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                Utils.c().registerReceiver(NetworkChangedReceiver.a(), r11);
                return;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OnNetworkStatusChangedListener f6192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NetworkChangedReceiver f6193b;

            public b(NetworkChangedReceiver r10, OnNetworkStatusChangedListener r11) {
                this.f6193b = r10;
                this.f6192a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                int r10 = NetworkChangedReceiver.b(this.f6193b).size();
                NetworkChangedReceiver.b(this.f6193b).remove(this.f6192a);
                if (r10 == 1) goto L5;
                return;
            L5:
                if (NetworkChangedReceiver.b(this.f6193b).size() != 0) goto L9;
                Utils.c().unregisterReceiver(NetworkChangedReceiver.a());
                return;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NetworkChangedReceiver f6194a;

            public c(NetworkChangedReceiver r10) {
                this.f6194a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkType r10 = NetworkUtils.b();
                if (NetworkChangedReceiver.c(this.f6194a) != r10) goto L5;
                return;
            L5:
                LogUtils.l(new Object[]{r10});
                NetworkChangedReceiver.d(this.f6194a, r10);
                if (r10 != NetworkType.NETWORK_NO) goto L11;
                Iterator r11 = NetworkChangedReceiver.b(this.f6194a).iterator();
            L9:
                if (r11.hasNext() == false) goto L15;
                ((OnNetworkStatusChangedListener) r11.next()).onDisconnected();
                goto L9
            L15:
                return;
            L11:
                Iterator r12 = NetworkChangedReceiver.b(this.f6194a).iterator();
            L13:
                if (r12.hasNext() == false) goto L18;
                ((OnNetworkStatusChangedListener) r12.next()).onConnected(r10);
                goto L13
            }
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NetworkChangedReceiver f6195a = null;

            static {
                f6195a = new NetworkChangedReceiver();
            }

            public static /* synthetic */ NetworkChangedReceiver a() {
                return f6195a;
            }
        }

        public NetworkChangedReceiver() {
            this.f6189b = new HashSet();
        }

        public static /* synthetic */ NetworkChangedReceiver a() {
            return e();
        }

        public static /* synthetic */ Set b(NetworkChangedReceiver r10) {
            return r10.f6189b;
        }

        public static /* synthetic */ NetworkType c(NetworkChangedReceiver r10) {
            return r10.f6188a;
        }

        public static /* synthetic */ NetworkType d(NetworkChangedReceiver r10, NetworkType r11) {
            r10.f6188a = r11;
            return r11;
        }

        public static NetworkChangedReceiver e() {
            return d.a();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == false) goto L6;
            Utils.m(new c(this), 1000);
            return;
        }

        public void registerListener(OnNetworkStatusChangedListener r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            Utils.l(new a(this, r10));
        }

        public void unregisterListener(OnNetworkStatusChangedListener r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            Utils.l(new b(this, r10));
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType NETWORK_2G = null;
        public static final NetworkType NETWORK_3G = null;
        public static final NetworkType NETWORK_4G = null;
        public static final NetworkType NETWORK_ETHERNET = null;
        public static final NetworkType NETWORK_NO = null;
        public static final NetworkType NETWORK_UNKNOWN = null;
        public static final NetworkType NETWORK_WIFI = null;

        static {
            NetworkType r10 = new NetworkType("NETWORK_ETHERNET", 0);
            NETWORK_ETHERNET = r10;
            NetworkType r11 = new NetworkType("NETWORK_WIFI", 1);
            NETWORK_WIFI = r11;
            NetworkType r12 = new NetworkType("NETWORK_4G", 2);
            NETWORK_4G = r12;
            NetworkType r13 = new NetworkType("NETWORK_3G", 3);
            NETWORK_3G = r13;
            NetworkType r14 = new NetworkType("NETWORK_2G", 4);
            NETWORK_2G = r14;
            NetworkType r15 = new NetworkType("NETWORK_UNKNOWN", 5);
            NETWORK_UNKNOWN = r15;
            NetworkType r16 = new NetworkType("NETWORK_NO", 6);
            NETWORK_NO = r16;
            $VALUES = new NetworkType[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private NetworkType(String r10, int r11) {
            super(r10, r11);
        }

        public static NetworkType valueOf(String r10) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r10);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }
    }

    public interface OnNetworkStatusChangedListener {
        void onConnected(NetworkType r10);

        void onDisconnected();
    }

    public static NetworkInfo a() {
        ConnectivityManager r10 = (ConnectivityManager) Utils.c().getSystemService("connectivity");
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getActiveNetworkInfo();
    }

    public static NetworkType b() {
        if (c() == true) goto L5;
        NetworkInfo r10 = a();
        if (r10 == null) goto L38;
        if (r10.isAvailable() == false) goto L38;
        if (r10.getType() != 1) goto L15;
        return NetworkType.NETWORK_WIFI;
    L15:
        if (r10.getType() != 0) goto L36;
        switch(r10.getSubtype()) {
            case 1: goto L34;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L34;
            case 8: goto L32;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L34;
            case 12: goto L32;
            case 13: goto L30;
            case 14: goto L32;
            case 15: goto L32;
            case 16: goto L34;
            case 17: goto L32;
            case 18: goto L30;
            default: goto L18;
        };
    L18:
        String r11 = r10.getSubtypeName();
        if (r11.equalsIgnoreCase("TD-SCDMA") == true) goto L28;
        if (r11.equalsIgnoreCase("WCDMA") == true) goto L28;
        if (r11.equalsIgnoreCase("CDMA2000") == true) goto L28;
        return NetworkType.NETWORK_UNKNOWN;
    L28:
        return NetworkType.NETWORK_3G;
    L30:
        return NetworkType.NETWORK_4G;
    L32:
        return NetworkType.NETWORK_3G;
    L34:
        return NetworkType.NETWORK_2G;
    L36:
        return NetworkType.NETWORK_UNKNOWN;
    L38:
        return NetworkType.NETWORK_NO;
    L5:
        return NetworkType.NETWORK_ETHERNET;
    }

    public static boolean c() {
        ConnectivityManager r10 = (ConnectivityManager) Utils.c().getSystemService("connectivity");
        if (r10 != null) goto L5;
        return false;
    L5:
        NetworkInfo r11 = r10.getNetworkInfo(9);
        if (r11 != null) goto L8;
        return false;
    L8:
        NetworkInfo.State r12 = r11.getState();
        if (r12 != null) goto L12;
        return false;
    L12:
        if (r12 != NetworkInfo.State.CONNECTED) goto L14;
    L15:
        return true;
    L14:
        if (r12 == NetworkInfo.State.CONNECTING) goto L15;
        return false;
    }

    public static void registerNetworkStatusChangedListener(OnNetworkStatusChangedListener r10) {
        NetworkChangedReceiver.a().registerListener(r10);
    }

    public static void unregisterNetworkStatusChangedListener(OnNetworkStatusChangedListener r10) {
        NetworkChangedReceiver.a().unregisterListener(r10);
    }
}
