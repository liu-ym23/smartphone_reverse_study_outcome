package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SmartBluetoothEvent implements Parcelable {
    public static final Parcelable.Creator<SmartBluetoothEvent> CREATOR = null;
    private static final int PROFILE_PBAP = 6;
    private static final int VERSION = 1;
    private final BluetoothDevice mBluetoothDevice;
    private final int mProfile;
    private final int mState;

    public static final enum A2dpState extends Enum<A2dpState> {
        public static final A2dpState STATE_CONNECTED = null;
        public static final A2dpState STATE_CONNECTING = null;
        public static final A2dpState STATE_DISCONNECTED = null;
        public static final A2dpState STATE_DISCONNECTING = null;
        public static final A2dpState STATE_NOT_PLAYING = null;
        public static final A2dpState STATE_PLAYING = null;
        public static final /* synthetic */ A2dpState[] b = null;
        public final int a;

        static {
            A2dpState r0 = new A2dpState("STATE_DISCONNECTED", 0, 0);
            STATE_DISCONNECTED = r0;
            A2dpState r1 = new A2dpState("STATE_CONNECTING", 1, 1);
            STATE_CONNECTING = r1;
            A2dpState r2 = new A2dpState("STATE_CONNECTED", 2, 2);
            STATE_CONNECTED = r2;
            A2dpState r3 = new A2dpState("STATE_DISCONNECTING", 3, 3);
            STATE_DISCONNECTING = r3;
            A2dpState r4 = new A2dpState("STATE_PLAYING", 4, 10);
            STATE_PLAYING = r4;
            A2dpState r5 = new A2dpState("STATE_NOT_PLAYING", 5, 11);
            STATE_NOT_PLAYING = r5;
            b = new A2dpState[]{r0, r1, r2, r3, r4, r5};
        }

        public A2dpState(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static A2dpState valueOf(String r1) {
            return (A2dpState) Enum.valueOf(A2dpState.class, r1);
        }

        public static A2dpState[] values() {
            return (A2dpState[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum GattState extends Enum<GattState> {
        public static final GattState STATE_CONNECTED = null;
        public static final GattState STATE_DISCONNECTED = null;
        public static final /* synthetic */ GattState[] b = null;
        public final int a;

        static {
            GattState r0 = new GattState("STATE_DISCONNECTED", 0, 0);
            STATE_DISCONNECTED = r0;
            GattState r1 = new GattState("STATE_CONNECTED", 1, 2);
            STATE_CONNECTED = r1;
            b = new GattState[]{r0, r1};
        }

        public GattState(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static GattState valueOf(String r1) {
            return (GattState) Enum.valueOf(GattState.class, r1);
        }

        public static GattState[] values() {
            return (GattState[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum HeadsetState extends Enum<HeadsetState> {
        public static final HeadsetState STATE_AUDIO_CONNECTED = null;
        public static final HeadsetState STATE_AUDIO_CONNECTING = null;
        public static final HeadsetState STATE_AUDIO_DISCONNECTED = null;
        public static final HeadsetState STATE_CONNECTED = null;
        public static final HeadsetState STATE_CONNECTING = null;
        public static final HeadsetState STATE_DISCONNECTED = null;
        public static final HeadsetState STATE_DISCONNECTING = null;
        public static final /* synthetic */ HeadsetState[] b = null;
        public final int a;

        static {
            HeadsetState r0 = new HeadsetState("STATE_DISCONNECTED", 0, 0);
            STATE_DISCONNECTED = r0;
            HeadsetState r1 = new HeadsetState("STATE_CONNECTING", 1, 1);
            STATE_CONNECTING = r1;
            HeadsetState r2 = new HeadsetState("STATE_CONNECTED", 2, 2);
            STATE_CONNECTED = r2;
            HeadsetState r3 = new HeadsetState("STATE_DISCONNECTING", 3, 3);
            STATE_DISCONNECTING = r3;
            HeadsetState r4 = new HeadsetState("STATE_AUDIO_DISCONNECTED", 4, 10);
            STATE_AUDIO_DISCONNECTED = r4;
            HeadsetState r5 = new HeadsetState("STATE_AUDIO_CONNECTING", 5, 11);
            STATE_AUDIO_CONNECTING = r5;
            HeadsetState r6 = new HeadsetState("STATE_AUDIO_CONNECTED", 6, 12);
            STATE_AUDIO_CONNECTED = r6;
            b = new HeadsetState[]{r0, r1, r2, r3, r4, r5, r6};
        }

        public HeadsetState(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static HeadsetState valueOf(String r1) {
            return (HeadsetState) Enum.valueOf(HeadsetState.class, r1);
        }

        public static HeadsetState[] values() {
            return (HeadsetState[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum PbapState extends Enum<PbapState> {
        public static final PbapState STATE_CONNECTED = null;
        public static final PbapState STATE_CONNECTING = null;
        public static final PbapState STATE_DISCONNECTED = null;
        public static final PbapState STATE_DISCONNECTING = null;
        public static final /* synthetic */ PbapState[] b = null;
        public final int a;

        static {
            PbapState r0 = new PbapState("STATE_DISCONNECTED", 0, 0);
            STATE_DISCONNECTED = r0;
            PbapState r1 = new PbapState("STATE_CONNECTING", 1, 1);
            STATE_CONNECTING = r1;
            PbapState r2 = new PbapState("STATE_CONNECTED", 2, 2);
            STATE_CONNECTED = r2;
            PbapState r3 = new PbapState("STATE_DISCONNECTING", 3, 3);
            STATE_DISCONNECTING = r3;
            b = new PbapState[]{r0, r1, r2, r3};
        }

        public PbapState(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static PbapState valueOf(String r1) {
            return (PbapState) Enum.valueOf(PbapState.class, r1);
        }

        public static PbapState[] values() {
            return (PbapState[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public class a implements Parcelable.Creator<SmartBluetoothEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SmartBluetoothEvent createFromParcel(Parcel r2) {
            return new SmartBluetoothEvent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SmartBluetoothEvent[] newArray(int r1) {
            return new SmartBluetoothEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SmartBluetoothEvent(BluetoothDevice r1, int r2, int r3) {
        this.mBluetoothDevice = r1;
        this.mProfile = r2;
        this.mState = r3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L17;
        SmartBluetoothEvent r5 = (SmartBluetoothEvent) r4;
        if (this.mProfile != r5.mProfile) goto L17;
        if (this.mState != r5.mState) goto L17;
        return Objects.equals(this.mBluetoothDevice, r5.mBluetoothDevice);
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public String getProfileName() {
        int r0 = this.mProfile;
        if (r0 != 1) goto L5;
        return "HEADSET";
    L5:
        if (r0 != 2) goto L7;
        return "A2DP";
    L7:
        if (r0 != 6) goto L9;
        return "PBAP";
    L9:
        if (r0 == 7) goto L12;
        return "WAIT_ADAPT";
    L12:
        return "GATT";
    }

    public int getState() {
        return this.mState;
    }

    public String getStateName() {
        int r0 = this.mProfile;
        if (r0 != 1) goto L28;
        int r1 = this.mState;
        if (r1 != HeadsetState.STATE_DISCONNECTED.getValue()) goto L8;
        return "STATE_DISCONNECTED";
    L8:
        if (r1 != HeadsetState.STATE_CONNECTING.getValue()) goto L11;
        return "STATE_CONNECTING";
    L11:
        if (r1 != HeadsetState.STATE_CONNECTED.getValue()) goto L14;
        return "STATE_CONNECTED";
    L14:
        if (r1 != HeadsetState.STATE_DISCONNECTING.getValue()) goto L17;
        return "STATE_DISCONNECTING";
    L17:
        if (r1 != HeadsetState.STATE_AUDIO_DISCONNECTED.getValue()) goto L20;
        return "STATE_AUDIO_DISCONNECTED";
    L20:
        if (r1 != HeadsetState.STATE_AUDIO_CONNECTING.getValue()) goto L23;
        return "STATE_AUDIO_CONNECTING";
    L23:
        if (r1 != HeadsetState.STATE_AUDIO_CONNECTED.getValue()) goto L26;
        return "STATE_AUDIO_CONNECTED";
    L26:
        return "UNKNOWN";
    L28:
        if (r0 != 2) goto L50;
        int r2 = this.mState;
        if (r2 != A2dpState.STATE_DISCONNECTED.getValue()) goto L33;
        return "STATE_DISCONNECTED";
    L33:
        if (r2 != A2dpState.STATE_CONNECTING.getValue()) goto L36;
        return "STATE_CONNECTING";
    L36:
        if (r2 != A2dpState.STATE_CONNECTED.getValue()) goto L39;
        return "STATE_CONNECTED";
    L39:
        if (r2 != A2dpState.STATE_DISCONNECTING.getValue()) goto L42;
        return "STATE_DISCONNECTING";
    L42:
        if (r2 != A2dpState.STATE_PLAYING.getValue()) goto L45;
        return "STATE_PLAYING";
    L45:
        if (r2 != A2dpState.STATE_NOT_PLAYING.getValue()) goto L48;
        return "STATE_NOT_PLAYING";
    L48:
        return "UNKNOWN";
    L50:
        if (r0 != 6) goto L66;
        int r3 = this.mState;
        if (r3 != PbapState.STATE_DISCONNECTED.getValue()) goto L55;
        return "STATE_DISCONNECTED";
    L55:
        if (r3 != PbapState.STATE_CONNECTING.getValue()) goto L58;
        return "STATE_CONNECTING";
    L58:
        if (r3 != PbapState.STATE_CONNECTED.getValue()) goto L61;
        return "STATE_CONNECTED";
    L61:
        if (r3 != PbapState.STATE_DISCONNECTING.getValue()) goto L64;
        return "STATE_DISCONNECTING";
    L64:
        return "UNKNOWN";
    L66:
        if (r0 != 7) goto L75;
        int r4 = this.mState;
        if (r4 != GattState.STATE_DISCONNECTED.getValue()) goto L71;
        return "STATE_DISCONNECTED";
    L71:
        if (r4 == GattState.STATE_CONNECTED.getValue()) goto L94;
        return "UNKNOWN";
    L94:
        return "STATE_CONNECTED";
    L75:
        return "WAIT_ADAPT";
    }

    public String toString() {
        if (this.mBluetoothDevice != null) goto L7;
        return "null";
    L7:
        return "SmartBluetoothEvent[1, " + this.mBluetoothDevice.getName() + ", " + this.mBluetoothDevice.getAddress() + ", " + getProfileName() + ", " + getStateName() + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mBluetoothDevice, 0);
        r2.writeInt(this.mProfile);
        r2.writeInt(this.mState);
    }

    public SmartBluetoothEvent(Parcel r2) {
        this.mBluetoothDevice = (BluetoothDevice) r2.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mProfile = r2.readInt();
        this.mState = r2.readInt();
    }
}
