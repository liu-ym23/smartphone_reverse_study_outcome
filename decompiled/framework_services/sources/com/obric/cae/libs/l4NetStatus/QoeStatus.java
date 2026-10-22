package com.obric.cae.libs.l4NetStatus;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class QoeStatus implements Parcelable {
    public static final Parcelable.Creator<QoeStatus> CREATOR = null;
    public String appPackageName;
    public int errBitMap;
    public String ifName;
    public int recvOooPercent;
    public int recvPackets;
    public int recvRate;
    public int rttAve;
    public int sendPackets;
    public int sendRate;
    public int sendRetrans;
    public int statSrcType;
    public int streamNum;
    public int tcpSndCwnd;
    public int tcpSndSsthresh;
    public long totalRecvBytes;
    public long totalRecvPackets;
    public long totalSegsIn;
    public long totalSegsOut;
    public long totalSendBytes;
    public long totalSendPackets;
    public int uid;
    public int unacked;

    public class a implements Parcelable.Creator<QoeStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QoeStatus createFromParcel(Parcel r2) {
            return new QoeStatus(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final QoeStatus[] newArray(int r1) {
            return new QoeStatus[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QoeStatus() {
        this.statSrcType = 0;
        this.appPackageName = "NULL";
        this.ifName = "NULL";
    }

    public void clear() {
        this.statSrcType = 0;
        this.uid = 0;
        this.appPackageName = "NULL";
        this.ifName = "NULL";
        this.streamNum = 0;
        this.rttAve = 0;
        this.totalSendPackets = 0;
        this.totalRecvPackets = 0;
        this.totalSegsOut = 0;
        this.totalSegsIn = 0;
        this.totalSendBytes = 0;
        this.totalRecvBytes = 0;
        this.sendPackets = 0;
        this.recvPackets = 0;
        this.sendRate = 0;
        this.recvRate = 0;
        this.sendRetrans = 0;
        this.recvOooPercent = 0;
        this.unacked = 0;
        this.tcpSndSsthresh = 0;
        this.tcpSndCwnd = 0;
        this.errBitMap = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public int getErrBitMap() {
        return this.errBitMap;
    }

    public String getIfName() {
        return this.ifName;
    }

    public int getRecvOooPercent() {
        return this.recvOooPercent;
    }

    public int getRecvPackets() {
        return this.recvPackets;
    }

    public int getRecvRate() {
        return this.recvRate;
    }

    public int getRttAve() {
        return this.rttAve;
    }

    public int getSendPackets() {
        return this.sendPackets;
    }

    public int getSendRate() {
        return this.sendRate;
    }

    public int getSendRetrans() {
        return this.sendRetrans;
    }

    public int getStatSrcType() {
        return this.statSrcType;
    }

    public int getStreamNum() {
        return this.streamNum;
    }

    public int getTcpSndCwnd() {
        return this.tcpSndCwnd;
    }

    public int getTcpSndSsthresh() {
        return this.tcpSndSsthresh;
    }

    public long getTotalRecvBytes() {
        return this.totalRecvBytes;
    }

    public long getTotalRecvPackets() {
        return this.totalRecvPackets;
    }

    public long getTotalSegsIn() {
        return this.totalSegsIn;
    }

    public long getTotalSegsOut() {
        return this.totalSegsOut;
    }

    public long getTotalSendBytes() {
        return this.totalSendBytes;
    }

    public long getTotalSendPackets() {
        return this.totalSendPackets;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnacked() {
        return this.unacked;
    }

    public void setAppPackageName(String r1) {
        this.appPackageName = r1;
    }

    public void setErrBitMap(int r1) {
        this.errBitMap = r1;
    }

    public void setIfName(String r1) {
        this.ifName = r1;
    }

    public void setRecvOooPercent(int r1) {
        this.recvOooPercent = r1;
    }

    public void setRecvPackets(int r1) {
        this.recvPackets = r1;
    }

    public void setRecvRate(int r1) {
        this.recvRate = r1;
    }

    public void setRttAve(int r1) {
        this.rttAve = r1;
    }

    public void setSendPackets(int r1) {
        this.sendPackets = r1;
    }

    public void setSendRate(int r1) {
        this.sendRate = r1;
    }

    public void setSendRetrans(int r1) {
        this.sendRetrans = r1;
    }

    public void setStatSrcType(int r1) {
        this.statSrcType = r1;
    }

    public void setStreamNum(int r1) {
        this.streamNum = r1;
    }

    public void setTcpSndCwnd(int r1) {
        this.tcpSndCwnd = r1;
    }

    public void setTcpSndSsthresh(int r1) {
        this.tcpSndSsthresh = r1;
    }

    public void setTotalRecvBytes(long r1) {
        this.totalRecvBytes = r1;
    }

    public void setTotalRecvPackets(long r1) {
        this.totalRecvPackets = r1;
    }

    public void setTotalSegsIn(long r1) {
        this.totalSegsIn = r1;
    }

    public void setTotalSegsOut(long r1) {
        this.totalSegsOut = r1;
    }

    public void setTotalSendBytes(long r1) {
        this.totalSendBytes = r1;
    }

    public void setTotalSendPackets(long r1) {
        this.totalSendPackets = r1;
    }

    public void setUid(int r1) {
        this.uid = r1;
    }

    public void setUnacked(int r1) {
        this.unacked = r1;
    }

    public String toString() {
        return "QoeStatus{statSrcType=" + this.statSrcType + ", uid=" + this.uid + ", appPackageName='" + this.appPackageName + "', ifName='" + this.ifName + "', streamNum=" + this.streamNum + ", rttAve=" + this.rttAve + ", totalSendPackets=" + this.totalSendPackets + ", totalRecvPackets=" + this.totalRecvPackets + ", totalSegsOut=" + this.totalSegsOut + ", totalSegsIn=" + this.totalSegsIn + ", totalSendBytes=" + this.totalSendBytes + ", totalRecvBytes=" + this.totalRecvBytes + ", sendPackets=" + this.sendPackets + ", recvPackets=" + this.recvPackets + ", sendRate=" + this.sendRate + ", recvRate=" + this.recvRate + ", sendRetrans=" + this.sendRetrans + ", recvOooPercent=" + this.recvOooPercent + ", unacked=" + this.unacked + ", errBitMap=" + this.errBitMap + ", tcpSndSsthresh=" + this.tcpSndSsthresh + ", tcpSndCwnd=" + this.tcpSndCwnd + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.statSrcType);
        r3.writeInt(this.uid);
        r3.writeString(this.appPackageName);
        r3.writeString(this.ifName);
        r3.writeInt(this.streamNum);
        r3.writeInt(this.rttAve);
        r3.writeLong(this.totalSendPackets);
        r3.writeLong(this.totalRecvPackets);
        r3.writeLong(this.totalSegsOut);
        r3.writeLong(this.totalSegsIn);
        r3.writeLong(this.totalSendBytes);
        r3.writeLong(this.totalRecvBytes);
        r3.writeInt(this.sendPackets);
        r3.writeInt(this.recvPackets);
        r3.writeInt(this.sendRate);
        r3.writeInt(this.recvRate);
        r3.writeInt(this.sendRetrans);
        r3.writeInt(this.recvOooPercent);
        r3.writeInt(this.unacked);
        r3.writeInt(this.tcpSndSsthresh);
        r3.writeInt(this.tcpSndCwnd);
        r3.writeInt(this.errBitMap);
    }

    public QoeStatus(QoeStatus r3) {
        this.statSrcType = r3.statSrcType;
        this.uid = r3.uid;
        this.appPackageName = r3.appPackageName;
        this.ifName = r3.ifName;
        this.streamNum = r3.streamNum;
        this.rttAve = r3.rttAve;
        this.totalSendPackets = r3.totalSendPackets;
        this.totalRecvPackets = r3.totalRecvPackets;
        this.totalSegsOut = r3.totalSegsOut;
        this.totalSegsIn = r3.totalSegsIn;
        this.totalSendBytes = r3.totalSendBytes;
        this.totalRecvBytes = r3.totalRecvBytes;
        this.sendPackets = r3.sendPackets;
        this.recvPackets = r3.recvPackets;
        this.sendRate = r3.sendRate;
        this.recvRate = r3.recvRate;
        this.sendRetrans = r3.sendRetrans;
        this.recvOooPercent = r3.recvOooPercent;
        this.unacked = r3.unacked;
        this.tcpSndSsthresh = r3.tcpSndSsthresh;
        this.tcpSndCwnd = r3.tcpSndCwnd;
        this.errBitMap = r3.errBitMap;
    }

    public QoeStatus(Parcel r3) {
        this.statSrcType = r3.readInt();
        this.uid = r3.readInt();
        this.appPackageName = r3.readString();
        this.ifName = r3.readString();
        this.streamNum = r3.readInt();
        this.rttAve = r3.readInt();
        this.totalSendPackets = r3.readLong();
        this.totalRecvPackets = r3.readLong();
        this.totalSegsOut = r3.readLong();
        this.totalSegsIn = r3.readLong();
        this.totalSendBytes = r3.readLong();
        this.totalRecvBytes = r3.readLong();
        this.sendPackets = r3.readInt();
        this.recvPackets = r3.readInt();
        this.sendRate = r3.readInt();
        this.recvRate = r3.readInt();
        this.sendRetrans = r3.readInt();
        this.recvOooPercent = r3.readInt();
        this.unacked = r3.readInt();
        this.tcpSndSsthresh = r3.readInt();
        this.tcpSndCwnd = r3.readInt();
        this.errBitMap = r3.readInt();
    }
}
