package com.stepos.alphame.bluetooth;

import android.os.ParcelUuid;
import androidx.room.AbstractC0351g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class BluetoothUuid {
    public static final ParcelUuid AdvAudioDist;
    public static final ParcelUuid AudioSink;
    public static final ParcelUuid AudioSource;
    public static final ParcelUuid AvrcpController;
    public static final ParcelUuid AvrcpTarget;
    public static final ParcelUuid BASE_UUID;
    public static final ParcelUuid BNEP;
    public static final ParcelUuid DUN;
    public static final ParcelUuid HSP;
    public static final ParcelUuid HSP_AG;
    public static final ParcelUuid Handsfree;
    public static final ParcelUuid Handsfree_AG;
    public static final ParcelUuid Hid;
    public static final ParcelUuid Hogp;
    public static final ParcelUuid MAP;
    public static final ParcelUuid MAS;
    public static final ParcelUuid MNS;
    public static final ParcelUuid NAP;
    public static final ParcelUuid ObexObjectPush;
    public static final ParcelUuid PANU;
    public static final ParcelUuid PBAP_PCE;
    public static final ParcelUuid PBAP_PSE;
    public static final ParcelUuid[] RESERVED_UUIDS;
    public static final ParcelUuid SAP;
    public static final int UUID_BYTES_128_BIT = 16;
    public static final int UUID_BYTES_16_BIT = 2;
    public static final int UUID_BYTES_32_BIT = 4;

    static {
        ParcelUuid parcelUuidFromString = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
        AudioSink = parcelUuidFromString;
        ParcelUuid parcelUuidFromString2 = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
        AudioSource = parcelUuidFromString2;
        ParcelUuid parcelUuidFromString3 = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
        AdvAudioDist = parcelUuidFromString3;
        ParcelUuid parcelUuidFromString4 = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
        HSP = parcelUuidFromString4;
        HSP_AG = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
        ParcelUuid parcelUuidFromString5 = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
        Handsfree = parcelUuidFromString5;
        Handsfree_AG = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
        ParcelUuid parcelUuidFromString6 = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        AvrcpController = parcelUuidFromString6;
        ParcelUuid parcelUuidFromString7 = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
        AvrcpTarget = parcelUuidFromString7;
        ParcelUuid parcelUuidFromString8 = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
        ObexObjectPush = parcelUuidFromString8;
        Hid = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
        Hogp = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
        ParcelUuid parcelUuidFromString9 = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
        PANU = parcelUuidFromString9;
        ParcelUuid parcelUuidFromString10 = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
        NAP = parcelUuidFromString10;
        BNEP = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
        PBAP_PCE = ParcelUuid.fromString("0000112e-0000-1000-8000-00805F9B34FB");
        PBAP_PSE = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
        ParcelUuid parcelUuidFromString11 = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
        MAP = parcelUuidFromString11;
        ParcelUuid parcelUuidFromString12 = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
        MNS = parcelUuidFromString12;
        ParcelUuid parcelUuidFromString13 = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
        MAS = parcelUuidFromString13;
        ParcelUuid parcelUuidFromString14 = ParcelUuid.fromString("0000112D-0000-1000-8000-00805F9B34FB");
        SAP = parcelUuidFromString14;
        ParcelUuid parcelUuidFromString15 = ParcelUuid.fromString("00001103-0000-1000-8000-00805F9B34FB");
        DUN = parcelUuidFromString15;
        BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        RESERVED_UUIDS = new ParcelUuid[]{parcelUuidFromString, parcelUuidFromString2, parcelUuidFromString3, parcelUuidFromString4, parcelUuidFromString5, parcelUuidFromString6, parcelUuidFromString7, parcelUuidFromString8, parcelUuidFromString9, parcelUuidFromString10, parcelUuidFromString11, parcelUuidFromString12, parcelUuidFromString13, parcelUuidFromString14, parcelUuidFromString15};
    }

    public static boolean containsAllUuids(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return parcelUuidArr2.length == 0;
        }
        if (parcelUuidArr2 == null) {
            return true;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (!hashSet.contains(parcelUuid)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsAnyUuid(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return parcelUuidArr2.length == 0;
        }
        if (parcelUuidArr2 == null) {
            return parcelUuidArr.length == 0;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (hashSet.contains(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    public static int getServiceIdentifierFromParcelUuid(ParcelUuid parcelUuid) {
        return (int) ((parcelUuid.getUuid().getMostSignificantBits() & 281470681743360L) >>> 32);
    }

    public static boolean is16BitUuid(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        return uuid.getLeastSignificantBits() == BASE_UUID.getUuid().getLeastSignificantBits() && (uuid.getMostSignificantBits() & (-281470681743361L)) == 4096;
    }

    public static boolean is32BitUuid(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        return uuid.getLeastSignificantBits() == BASE_UUID.getUuid().getLeastSignificantBits() && !is16BitUuid(parcelUuid) && (uuid.getMostSignificantBits() & 4294967295L) == 4096;
    }

    public static boolean isAdvAudioDist(ParcelUuid parcelUuid) {
        return AdvAudioDist.equals(parcelUuid);
    }

    public static boolean isAudioSink(ParcelUuid parcelUuid) {
        return AudioSink.equals(parcelUuid);
    }

    public static boolean isAudioSource(ParcelUuid parcelUuid) {
        return AudioSource.equals(parcelUuid);
    }

    public static boolean isAvrcpController(ParcelUuid parcelUuid) {
        return AvrcpController.equals(parcelUuid);
    }

    public static boolean isAvrcpTarget(ParcelUuid parcelUuid) {
        return AvrcpTarget.equals(parcelUuid);
    }

    public static boolean isBnep(ParcelUuid parcelUuid) {
        return BNEP.equals(parcelUuid);
    }

    public static boolean isDun(ParcelUuid parcelUuid) {
        return DUN.equals(parcelUuid);
    }

    public static boolean isHandsfree(ParcelUuid parcelUuid) {
        return Handsfree.equals(parcelUuid);
    }

    public static boolean isHeadset(ParcelUuid parcelUuid) {
        return HSP.equals(parcelUuid);
    }

    public static boolean isInputDevice(ParcelUuid parcelUuid) {
        return Hid.equals(parcelUuid);
    }

    public static boolean isMap(ParcelUuid parcelUuid) {
        return MAP.equals(parcelUuid);
    }

    public static boolean isMas(ParcelUuid parcelUuid) {
        return MAS.equals(parcelUuid);
    }

    public static boolean isMns(ParcelUuid parcelUuid) {
        return MNS.equals(parcelUuid);
    }

    public static boolean isNap(ParcelUuid parcelUuid) {
        return NAP.equals(parcelUuid);
    }

    public static boolean isPanu(ParcelUuid parcelUuid) {
        return PANU.equals(parcelUuid);
    }

    public static boolean isSap(ParcelUuid parcelUuid) {
        return SAP.equals(parcelUuid);
    }

    public static boolean isUuidPresent(ParcelUuid[] parcelUuidArr, ParcelUuid parcelUuid) {
        if ((parcelUuidArr == null || parcelUuidArr.length == 0) && parcelUuid == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return false;
        }
        for (ParcelUuid parcelUuid2 : parcelUuidArr) {
            if (parcelUuid2.equals(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    public static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j4;
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException(AbstractC0351g.m("uuidBytes length invalid - ", length));
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j4 = (bArr[0] & UByte.MAX_VALUE) + ((bArr[1] & UByte.MAX_VALUE) << 8);
        } else {
            j4 = ((bArr[3] & UByte.MAX_VALUE) << 24) + (bArr[0] & UByte.MAX_VALUE) + ((bArr[1] & UByte.MAX_VALUE) << 8) + ((bArr[2] & UByte.MAX_VALUE) << 16);
        }
        ParcelUuid parcelUuid = BASE_UUID;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j4 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }
}
