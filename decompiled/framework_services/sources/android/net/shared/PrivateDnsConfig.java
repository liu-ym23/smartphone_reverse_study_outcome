package android.net.shared;

import android.net.PrivateDnsConfigParcel;
import android.text.TextUtils;
import com.android.server.slice.SliceClientPermissions;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PrivateDnsConfig {
    public final boolean ddrEnabled;
    public final InetAddress[] dohIps;
    public final String dohName;
    public final String dohPath;
    public final int dohPort;
    public final String hostname;
    public final InetAddress[] ips;
    public final int mode;

    public PrivateDnsConfig() {
        this(false);
    }

    public PrivateDnsConfig(boolean useTls) {
        if (useTls == false) goto L5;
        int r0 = 2;
    L6:
        this(r0, null, null, false, null, null, null, -1);
        return;
    L5:
        r0 = 1;
        goto L6
    }

    public PrivateDnsConfig(String hostname, InetAddress[] ips) {
        if (TextUtils.isEmpty(hostname) == false) goto L5;
        int r2 = 1;
    L6:
        this(r2, hostname, ips, false, null, null, null, -1);
        return;
    L5:
        r2 = 3;
        goto L6
    }

    public PrivateDnsConfig(int mode, String hostname, InetAddress[] ips, boolean ddrEnabled, String dohName, InetAddress[] dohIps, String dohPath, int dohPort) {
        this.mode = mode;
        String r0 = "";
        if (hostname == null) goto L5;
        String r1 = hostname;
    L6:
        this.hostname = r1;
        if (ips == null) goto L9;
        InetAddress[] r2 = (InetAddress[]) ips.clone();
    L10:
        this.ips = r2;
        this.ddrEnabled = ddrEnabled;
        if (dohName == null) goto L13;
        String r3 = dohName;
    L14:
        this.dohName = r3;
        if (dohIps == null) goto L17;
        InetAddress[] r4 = (InetAddress[]) dohIps.clone();
    L18:
        this.dohIps = r4;
        if (dohPath == null) goto L21;
        r0 = dohPath;
    L21:
        this.dohPath = r0;
        this.dohPort = dohPort;
        return;
    L17:
        r4 = new InetAddress[0];
        goto L18
    L13:
        r3 = "";
        goto L14
    L9:
        r2 = new InetAddress[0];
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    public PrivateDnsConfig(PrivateDnsConfig cfg) {
        this.mode = cfg.mode;
        this.hostname = cfg.hostname;
        this.ips = cfg.ips;
        this.ddrEnabled = cfg.ddrEnabled;
        this.dohName = cfg.dohName;
        this.dohIps = cfg.dohIps;
        this.dohPath = cfg.dohPath;
        this.dohPort = cfg.dohPort;
    }

    public boolean inStrictMode() {
        if (this.mode != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean inOpportunisticMode() {
        if (this.mode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean areSettingsSameAs(PrivateDnsConfig other) {
        if (this.mode == other.mode) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.hostname, other.hostname) == false) goto L7;
        return true;
    }

    public String toString() {
        return PrivateDnsConfig.class.getSimpleName() + "{" + modeAsString(this.mode) + ":" + this.hostname + SliceClientPermissions.SliceAuthority.DELIMITER + Arrays.toString(this.ips) + ", dohName=" + this.dohName + ", dohIps=" + Arrays.toString(this.dohIps) + ", dohPath=" + this.dohPath + ", dohPort=" + this.dohPort + "}";
    }

    private static String modeAsString(int mode) {
        switch(mode) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "strict";
    L7:
        return "opportunistic";
    L9:
        return "off";
    }

    public PrivateDnsConfigParcel toParcel() {
        PrivateDnsConfigParcel parcel = new PrivateDnsConfigParcel();
        parcel.hostname = this.hostname;
        parcel.ips = (String[]) ParcelableUtil.toParcelableArray(Arrays.asList(this.ips), new InitialConfiguration$$ExternalSyntheticLambda11(), String.class);
        parcel.privateDnsMode = this.mode;
        parcel.dohName = this.dohName;
        parcel.dohIps = (String[]) ParcelableUtil.toParcelableArray(Arrays.asList(this.dohIps), new InitialConfiguration$$ExternalSyntheticLambda11(), String.class);
        parcel.dohPath = this.dohPath;
        parcel.dohPort = this.dohPort;
        parcel.ddrEnabled = this.ddrEnabled;
        return parcel;
    }

    public static PrivateDnsConfig fromParcel(PrivateDnsConfigParcel parcel) {
        InetAddress[] ips = new InetAddress[parcel.ips.length];
        InetAddress[] ips2 = (InetAddress[]) ParcelableUtil.fromParcelableArray(parcel.ips, new InitialConfiguration$$ExternalSyntheticLambda8()).toArray(ips);
        if (parcel.privateDnsMode == (-1)) goto L5;
        InetAddress[] dohIps = new InetAddress[parcel.dohIps.length];
        InetAddress[] dohIps2 = (InetAddress[]) ParcelableUtil.fromParcelableArray(parcel.dohIps, new InitialConfiguration$$ExternalSyntheticLambda8()).toArray(dohIps);
        return new PrivateDnsConfig(parcel.privateDnsMode, parcel.hostname, ips2, parcel.ddrEnabled, parcel.dohName, dohIps2, parcel.dohPath, parcel.dohPort);
    L5:
        return new PrivateDnsConfig(parcel.hostname, ips2);
    }
}
