package android.net;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class TcpKeepalivePacketDataParcelable implements Parcelable {
    public static final Parcelable.Creator<TcpKeepalivePacketDataParcelable> CREATOR = null;
    public int ack;
    public byte[] dstAddress;
    public int dstPort;
    public int rcvWnd;
    public int rcvWndScale;
    public int seq;
    public byte[] srcAddress;
    public int srcPort;
    public int tos;
    public int ttl;

    public TcpKeepalivePacketDataParcelable() {
        this.srcPort = 0;
        this.dstPort = 0;
        this.seq = 0;
        this.ack = 0;
        this.rcvWnd = 0;
        this.rcvWndScale = 0;
        this.tos = 0;
        this.ttl = 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.writeInt(0);
        _aidl_parcel.writeByteArray(this.srcAddress);
        _aidl_parcel.writeInt(this.srcPort);
        _aidl_parcel.writeByteArray(this.dstAddress);
        _aidl_parcel.writeInt(this.dstPort);
        _aidl_parcel.writeInt(this.seq);
        _aidl_parcel.writeInt(this.ack);
        _aidl_parcel.writeInt(this.rcvWnd);
        _aidl_parcel.writeInt(this.rcvWndScale);
        _aidl_parcel.writeInt(this.tos);
        _aidl_parcel.writeInt(this.ttl);
        int _aidl_end_pos = _aidl_parcel.dataPosition();
        _aidl_parcel.setDataPosition(_aidl_start_pos);
        _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
        _aidl_parcel.setDataPosition(_aidl_end_pos);
    }

    public final void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_start_pos = _aidl_parcel.dataPosition();
        int _aidl_parcelable_size = _aidl_parcel.readInt();
        if (_aidl_parcelable_size < 4) goto L104;
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L8;
        this.srcAddress = _aidl_parcel.createByteArray();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L17;
        this.srcPort = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L26;
        this.dstAddress = _aidl_parcel.createByteArray();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L35;
        this.dstPort = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L44;
        this.seq = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L53;
        this.ack = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L62;
        this.rcvWnd = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L71;
        this.rcvWndScale = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L80;
        this.tos = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if ((_aidl_parcel.dataPosition() - _aidl_start_pos) >= _aidl_parcelable_size) goto L89;
        this.ttl = _aidl_parcel.readInt();     // Catch: Throwable -> L101
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L100;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L100:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L89:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L93;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L93:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L80:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L84;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L84:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L71:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L75;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L75:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L62:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L66;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L66:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L53:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L57;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L57:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L44:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L48;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L48:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L35:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L39;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L39:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L26:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L30;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L30:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L21;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L21:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L12;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L104:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) goto L108;
        _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
        throw th;
    L108:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    public String toString() {
        StringJoiner _aidl_sj = new StringJoiner(", ", "{", "}");
        _aidl_sj.add("srcAddress: " + Arrays.toString(this.srcAddress));
        _aidl_sj.add("srcPort: " + this.srcPort);
        _aidl_sj.add("dstAddress: " + Arrays.toString(this.dstAddress));
        _aidl_sj.add("dstPort: " + this.dstPort);
        _aidl_sj.add("seq: " + this.seq);
        _aidl_sj.add("ack: " + this.ack);
        _aidl_sj.add("rcvWnd: " + this.rcvWnd);
        _aidl_sj.add("rcvWndScale: " + this.rcvWndScale);
        _aidl_sj.add("tos: " + this.tos);
        _aidl_sj.add("ttl: " + this.ttl);
        return "TcpKeepalivePacketDataParcelable" + _aidl_sj.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
