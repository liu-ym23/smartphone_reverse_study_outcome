package com.stepos.net;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSSockEntry implements Parcelable {
    public static final Parcelable.Creator<StepOSSockEntry> CREATOR = new Parcelable.Creator<StepOSSockEntry>() { // from class: com.stepos.net.StepOSSockEntry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSSockEntry createFromParcel(Parcel in) {
            return new StepOSSockEntry(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSSockEntry[] newArray(int size) {
            return new StepOSSockEntry[size];
        }
    };
    public final int cookieHigh;
    public final int cookieLow;
    public final int dport;
    public final byte[] dst;
    public final int family;
    public final int ifIndex;
    public final int pid;
    public final int proto;
    public final int sport;
    public final byte[] src;
    public final int state;
    public final int uid;

    public StepOSSockEntry(int pid, int uid, int family, int proto, int state, int sport, int dport, byte[] src, byte[] dst, int ifIndex, int cookieLow, int cookieHigh) {
        this.pid = pid;
        this.uid = uid;
        this.family = family;
        this.proto = proto;
        this.state = state;
        this.sport = sport;
        this.dport = dport;
        this.src = src;
        this.dst = dst;
        this.ifIndex = ifIndex;
        this.cookieLow = cookieLow;
        this.cookieHigh = cookieHigh;
    }

    protected StepOSSockEntry(Parcel in) {
        this.pid = in.readInt();
        this.uid = in.readInt();
        this.family = in.readInt();
        this.proto = in.readInt();
        this.state = in.readInt();
        this.sport = in.readInt();
        this.dport = in.readInt();
        this.src = in.createByteArray();
        this.dst = in.createByteArray();
        this.ifIndex = in.readInt();
        this.cookieLow = in.readInt();
        this.cookieHigh = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.pid);
        dest.writeInt(this.uid);
        dest.writeInt(this.family);
        dest.writeInt(this.proto);
        dest.writeInt(this.state);
        dest.writeInt(this.sport);
        dest.writeInt(this.dport);
        dest.writeByteArray(this.src);
        dest.writeByteArray(this.dst);
        dest.writeInt(this.ifIndex);
        dest.writeInt(this.cookieLow);
        dest.writeInt(this.cookieHigh);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StepOSSockEntry{pid=" + this.pid + ", uid=" + this.uid + ", family=" + this.family + ", proto=" + this.proto + ", state=" + this.state + ", sport=" + this.sport + ", dport=" + this.dport + ", ifIndex=" + this.ifIndex + '}';
    }
}
