package com.stepos.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes.dex */
public class StepOSSocketInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSSocketInfo> CREATOR = new Parcelable.Creator<StepOSSocketInfo>() { // from class: com.stepos.net.StepOSSocketInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSSocketInfo createFromParcel(Parcel in) {
            return new StepOSSocketInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSSocketInfo[] newArray(int size) {
            return new StepOSSocketInfo[size];
        }
    };
    public final byte backoff;
    public final byte caState;
    public final long cookie;
    public final int fwmark;
    public final int ipFamily;
    public final int lastDataSent;
    public final int rto;
    public final int rtt;
    public final int segsIn;
    public final int segsLost;
    public final int segsOut;
    public final int segsRet;
    public final int uid;
    public final int unAcked;

    public StepOSSocketInfo(int uid, int fwmark, long cookie, int ipFamily, int segsIn, int segsOut, int segsRet, int segsLost, byte backoff, byte caState, int lastDataSent, int rto, int rtt, int unAcked) {
        this.uid = uid;
        this.fwmark = fwmark;
        this.cookie = cookie;
        this.ipFamily = ipFamily;
        this.segsIn = segsIn;
        this.segsOut = segsOut;
        this.segsRet = segsRet;
        this.segsLost = segsLost;
        this.backoff = backoff;
        this.caState = caState;
        this.lastDataSent = lastDataSent;
        this.rto = rto;
        this.rtt = rtt;
        this.unAcked = unAcked;
    }

    protected StepOSSocketInfo(Parcel in) {
        this.uid = in.readInt();
        this.fwmark = in.readInt();
        this.cookie = in.readLong();
        this.ipFamily = in.readInt();
        this.segsIn = in.readInt();
        this.segsOut = in.readInt();
        this.segsRet = in.readInt();
        this.segsLost = in.readInt();
        this.backoff = in.readByte();
        this.caState = in.readByte();
        this.lastDataSent = in.readInt();
        this.rto = in.readInt();
        this.rtt = in.readInt();
        this.unAcked = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.uid);
        dest.writeInt(this.fwmark);
        dest.writeLong(this.cookie);
        dest.writeInt(this.ipFamily);
        dest.writeInt(this.segsIn);
        dest.writeInt(this.segsOut);
        dest.writeInt(this.segsRet);
        dest.writeInt(this.segsLost);
        dest.writeByte(this.backoff);
        dest.writeByte(this.caState);
        dest.writeInt(this.lastDataSent);
        dest.writeInt(this.rto);
        dest.writeInt(this.rtt);
        dest.writeInt(this.unAcked);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIpFamilyName() {
        switch (this.ipFamily) {
            case 2:
                return "IPv4";
            case 10:
                return "IPv6";
            default:
                return "Unknown(" + this.ipFamily + ")";
        }
    }

    public String getCaStateName() {
        switch (this.caState) {
            case 0:
                return "Open";
            case 1:
                return "Disorder";
            case 2:
                return "CWR";
            case 3:
                return "Recovery";
            case 4:
                return "Loss";
            default:
                return "Unknown(" + ((int) this.caState) + ")";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepOSSocketInfo)) {
            return false;
        }
        StepOSSocketInfo other = (StepOSSocketInfo) obj;
        return this.uid == other.uid && this.fwmark == other.fwmark && this.cookie == other.cookie && this.ipFamily == other.ipFamily && this.segsIn == other.segsIn && this.segsOut == other.segsOut && this.segsRet == other.segsRet && this.segsLost == other.segsLost && this.backoff == other.backoff && this.caState == other.caState && this.lastDataSent == other.lastDataSent && this.rto == other.rto && this.rtt == other.rtt && this.unAcked == other.unAcked;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.uid), Integer.valueOf(this.fwmark), Long.valueOf(this.cookie), Integer.valueOf(this.ipFamily), Integer.valueOf(this.segsIn), Integer.valueOf(this.segsOut), Integer.valueOf(this.segsRet), Integer.valueOf(this.segsLost), Byte.valueOf(this.backoff), Byte.valueOf(this.caState), Integer.valueOf(this.lastDataSent), Integer.valueOf(this.rto), Integer.valueOf(this.rtt), Integer.valueOf(this.unAcked));
    }

    public String toString() {
        return "StepOSSocketInfo{uid=" + this.uid + ", fwmark=0x" + Integer.toHexString(this.fwmark) + ", cookie=" + this.cookie + ", ipFamily=" + getIpFamilyName() + ", segsIn=" + this.segsIn + ", segsOut=" + this.segsOut + ", segsRet=" + this.segsRet + ", segsLost=" + this.segsLost + ", backoff=" + ((int) this.backoff) + ", caState=" + getCaStateName() + ", lastDataSent=" + this.lastDataSent + "ms, rto=" + this.rto + "us, rtt=" + this.rtt + "us, unAcked=" + this.unAcked + '}';
    }

    public static class Builder {
        private byte backoff;
        private byte caState;
        private long cookie;
        private int fwmark;
        private int ipFamily;
        private int lastDataSent;
        private int rto;
        private int rtt;
        private int segsIn;
        private int segsLost;
        private int segsOut;
        private int segsRet;
        private int uid;
        private int unAcked;

        public Builder setUid(int uid) {
            this.uid = uid;
            return this;
        }

        public Builder setFwmark(int fwmark) {
            this.fwmark = fwmark;
            return this;
        }

        public Builder setCookie(long cookie) {
            this.cookie = cookie;
            return this;
        }

        public Builder setIpFamily(int ipFamily) {
            this.ipFamily = ipFamily;
            return this;
        }

        public Builder setSegsIn(int segsIn) {
            this.segsIn = segsIn;
            return this;
        }

        public Builder setSegsOut(int segsOut) {
            this.segsOut = segsOut;
            return this;
        }

        public Builder setSegsRet(int segsRet) {
            this.segsRet = segsRet;
            return this;
        }

        public Builder setSegsLost(int segsLost) {
            this.segsLost = segsLost;
            return this;
        }

        public Builder setBackoff(byte backoff) {
            this.backoff = backoff;
            return this;
        }

        public Builder setCaState(byte caState) {
            this.caState = caState;
            return this;
        }

        public Builder setLastDataSent(int lastDataSent) {
            this.lastDataSent = lastDataSent;
            return this;
        }

        public Builder setRto(int rto) {
            this.rto = rto;
            return this;
        }

        public Builder setRtt(int rtt) {
            this.rtt = rtt;
            return this;
        }

        public Builder setUnAcked(int unAcked) {
            this.unAcked = unAcked;
            return this;
        }

        public StepOSSocketInfo build() {
            return new StepOSSocketInfo(this.uid, this.fwmark, this.cookie, this.ipFamily, this.segsIn, this.segsOut, this.segsRet, this.segsLost, this.backoff, this.caState, this.lastDataSent, this.rto, this.rtt, this.unAcked);
        }
    }
}
