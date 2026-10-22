package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.common.alphame.Args;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10839a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10839a) {
            case 0:
                int i4 = parcel.readInt();
                ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i4);
                int[] iArr = new int[i4];
                boolean[] zArr = new boolean[i4];
                parcel.readIntArray(iArr);
                parcel.readBooleanArray(zArr);
                for (int i5 = 0; i5 < i4; i5++) {
                    parcelableSparseBooleanArray.put(iArr[i5], zArr[i5]);
                }
                return parcelableSparseBooleanArray;
            case 1:
                int i6 = parcel.readInt();
                ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i6);
                int[] iArr2 = new int[i6];
                int[] iArr3 = new int[i6];
                parcel.readIntArray(iArr2);
                parcel.readIntArray(iArr3);
                for (int i7 = 0; i7 < i6; i7++) {
                    parcelableSparseIntArray.put(iArr2[i7], iArr3[i7]);
                }
                return parcelableSparseIntArray;
            case 2:
                try {
                    Args args = new Args(new Object[0]);
                    args.i(parcel);
                    return args;
                } catch (Exception e4) {
                    Log.e("AlphaMe", "Exception when create Args from parcel : " + e4.getMessage());
                    return null;
                }
            case 3:
                EmitterConfig emitterConfig = new EmitterConfig();
                emitterConfig.f12309a = true;
                emitterConfig.f12311c = true;
                emitterConfig.f12312d = true;
                emitterConfig.f12313e = true;
                emitterConfig.f12314f = VehicleBluetoothManager.FAIL_START_TIMEOUT;
                emitterConfig.f12315g = 50;
                emitterConfig.f12316h = 2097152L;
                emitterConfig.f12317i = 10;
                emitterConfig.f12310b = parcel.readByte() != 0;
                emitterConfig.f12309a = parcel.readByte() != 0;
                emitterConfig.f12311c = parcel.readByte() != 0;
                emitterConfig.f12312d = parcel.readByte() != 0;
                emitterConfig.f12313e = parcel.readByte() != 0;
                emitterConfig.f12314f = parcel.readLong();
                emitterConfig.f12315g = parcel.readInt();
                emitterConfig.f12316h = parcel.readLong();
                emitterConfig.f12318j = parcel.readString();
                emitterConfig.f12319k = parcel.readString();
                return emitterConfig;
            case 4:
                NetResponse netResponse = new NetResponse();
                netResponse.f12341a = parcel.readInt();
                netResponse.f12342b = parcel.readString();
                return netResponse;
            case 5:
                TrackerPayload trackerPayload = new TrackerPayload();
                trackerPayload.f12343a = parcel.readHashMap(HashMap.class.getClassLoader());
                return trackerPayload;
            case 6:
                RpkEvent rpkEvent = new RpkEvent();
                rpkEvent.f12344a = parcel.readString();
                rpkEvent.f12345b = parcel.readString();
                rpkEvent.f12346c = parcel.readString();
                rpkEvent.f12347d = parcel.readHashMap(String.class.getClassLoader());
                rpkEvent.f12348e = parcel.readString();
                return rpkEvent;
            default:
                RpkInfo rpkInfo = new RpkInfo();
                rpkInfo.f12349a = parcel.readString();
                rpkInfo.f12350b = parcel.readString();
                rpkInfo.f12351c = parcel.readInt();
                rpkInfo.f12352d = parcel.readString();
                rpkInfo.f12353e = parcel.readString();
                return rpkInfo;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f10839a) {
            case 0:
                return new ParcelableSparseBooleanArray[i4];
            case 1:
                return new ParcelableSparseIntArray[i4];
            case 2:
                return new Args[i4];
            case 3:
                return new EmitterConfig[i4];
            case 4:
                return new NetResponse[i4];
            case 5:
                return new TrackerPayload[i4];
            case 6:
                return new RpkEvent[i4];
            default:
                return new RpkInfo[i4];
        }
    }
}
