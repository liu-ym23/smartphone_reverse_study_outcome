package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.common.Utils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.http.HTTPHeader;
import com.byted.cast.linkcommon.cybergarage.upnp.device.MAN;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NT;
import com.byted.cast.linkcommon.cybergarage.upnp.device.NTS;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.byted.cast.linkcommon.cybergarage.upnp.device.USN;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPPacket implements Parcelable {
    public static final Parcelable.Creator<SSDPPacket> CREATOR = null;
    private static final String TAG = "SSDPPacket";
    private DatagramPacket dgmPacket;
    private String localAddr;
    public byte[] packetBytes;
    private String remoteAddr;
    private int remotePort;
    private long timeStamp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public byte[] getData() {
        byte[] r100 = this.packetBytes;
        if (r100 == null) goto L5;
        return r100;
    L5:
        DatagramPacket r101 = getDatagramPacket();
        if (r101 == null) goto L8;
        int r102 = r101.getLength();
        byte[] r103 = Utils.newString(r101.getData(), 0, r102).getBytes();
        this.packetBytes = r103;
        return r103;
    L8:
        return this.packetBytes;
    }

    public String toString() {
        return new String(getData());
    }

    public String getCacheControl() {
        return HTTPHeader.getValue(getData(), HTTP.CACHE_CONTROL);
    }

    public String getCustomizedService() {
        return HTTPHeader.getValue(getData(), HTTP.PRIVATE_SERVICE);
    }

    public String getHost() {
        return HTTPHeader.getValue(getData(), HTTP.HOST);
    }

    public InetAddress getHostInetAddress() {
        String r100 = getHost();
        int r101 = r100.lastIndexOf(":");
        if (r101 < 0) goto L10;
        String r102 = r100.substring(0, r101);
        if (r102.charAt(0) != '[') goto L8;
        r102 = r102.substring(1, r102.length());
    L8:
        if (r102.charAt(r102.length() - 1) != ']') goto L12;
        r102 = r102.substring(0, r102.length() - 1);
    L12:
        return new InetSocketAddress(r102, 0).getAddress();
    L10:
        r102 = "127.0.0.1";
        goto L12
    }

    public int getLeaseTime() {
        return SSDP.getLeaseTime(getCacheControl());
    }

    public String getLocation() {
        return HTTPHeader.getValue(getData(), HTTP.LOCATION);
    }

    public String getMAN() {
        byte[] r100 = getData();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length != 0) goto L8;
        return "";
    L8:
        return HTTPHeader.getValue(getData(), HTTP.MAN);
    }

    public int getMX() {
        return HTTPHeader.getIntegerValue(getData(), HTTP.MX);
    }

    public String getNT() {
        return HTTPHeader.getValue(getData(), HTTP.NT);
    }

    public String getNTS() {
        return HTTPHeader.getValue(getData(), HTTP.NTS);
    }

    public String getRemoteAddress() {
        if (getDatagramPacket().getAddress() == null) goto L5;
        this.remoteAddr = getDatagramPacket().getAddress().getHostAddress();
        return getDatagramPacket().getAddress().getHostAddress();
    L5:
        return this.remoteAddr;
    }

    public InetAddress getRemoteInetAddress() {
        return getDatagramPacket().getAddress();
    }

    public int getRemotePort() {
        if (getDatagramPacket().getPort() == 0) goto L5;
        int r100 = getDatagramPacket().getPort();
        this.remotePort = r100;
        return r100;
    L5:
        return this.remotePort;
    }

    public String getST() {
        return HTTPHeader.getValue(getData(), "ST");
    }

    public String getServer() {
        return HTTPHeader.getValue(getData(), HTTP.SERVER);
    }

    public String getUSN() {
        return HTTPHeader.getValue(getData(), HTTP.USN);
    }

    public boolean hasAvTransportService() {
        if (ST.hasAvtransportService(getST()) == false) goto L6;
        return true;
    L6:
        if (ST.hasAvtransportService(getUSN()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isAlive() {
        return NTS.isAlive(getNTS());
    }

    public boolean isByeBye() {
        return NTS.isByeBye(getNTS());
    }

    public boolean isDIALDevice() {
        return ST.isDIALDevice(getST());
    }

    public boolean isDiscover() {
        return MAN.isDiscover(getMAN());
    }

    public boolean isMediaRenderDevice() {
        if (ST.isMediaRenderDevice(getST()) == false) goto L6;
        return true;
    L6:
        if (ST.isMediaRenderDevice(getUSN()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isRootDevice() {
        if (NT.isRootDevice(getNT()) != true) goto L6;
        return true;
    L6:
        if (ST.isRootDevice(getST()) != true) goto L9;
        return true;
    L9:
        return USN.isRootDevice(getUSN());
    }

    public DatagramPacket getDatagramPacket() {
        return this.dgmPacket;
    }

    public String getLocalAddress() {
        return this.localAddr;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public SSDPPacket(Parcel r100) {
        this.dgmPacket = null;
        this.localAddr = "";
        this.remoteAddr = "";
        this.remotePort = 0;
        this.packetBytes = null;
        this.remoteAddr = r100.readString();
        this.localAddr = r100.readString();
        this.timeStamp = r100.readLong();
        this.remotePort = r100.readInt();
        this.packetBytes = r100.createByteArray();
    }

    public void readFromParcel(Parcel r100) {
        this.remoteAddr = r100.readString();
        this.localAddr = r100.readString();
        this.timeStamp = r100.readLong();
        this.remotePort = r100.readInt();
        this.packetBytes = r100.createByteArray();
    }

    public void setLocalAddress(String r100) {
        this.localAddr = r100;
    }

    public void setRemotePort(int r100) {
        this.remotePort = r100;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }

    public SSDPPacket(byte[] r100, int r101) {
        this.dgmPacket = null;
        this.localAddr = "";
        this.remoteAddr = "";
        this.remotePort = 0;
        this.packetBytes = null;
        this.dgmPacket = new DatagramPacket(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.remoteAddr);
        r100.writeString(this.localAddr);
        r100.writeLong(this.timeStamp);
        r100.writeInt(this.remotePort);
        r100.writeByteArray(this.packetBytes);
    }
}
