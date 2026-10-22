package android.os.collector.base;

import android.util.ArrayMap;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class WireReader {
    private final byte[] mBuf;
    private final int mEnd;
    private int mPos;

    public static final class ParseException extends RuntimeException {
        public ParseException(String msg) {
            super(msg);
        }
    }

    public WireReader(byte[] buffer, int offset) {
        if (buffer == null) {
            throw new ParseException("WireReader: null buffer");
        }
        if (offset < 0 || offset > buffer.length) {
            throw new ParseException("WireReader: offset " + offset + " out of buffer length " + buffer.length);
        }
        this.mBuf = buffer;
        this.mEnd = buffer.length;
        this.mPos = offset;
    }

    public int position() {
        return this.mPos;
    }

    public int remaining() {
        return this.mEnd - this.mPos;
    }

    private void requireBytes(int n, String what) {
        if (n < 0 || this.mPos + n > this.mEnd) {
            throw new ParseException(what + " at pos=" + this.mPos + " needs " + n + " bytes, only " + (this.mEnd - this.mPos) + " available");
        }
    }

    public int readUByte(String what) {
        requireBytes(1, what);
        byte[] bArr = this.mBuf;
        int i = this.mPos;
        this.mPos = i + 1;
        return bArr[i] & 255;
    }

    public void expectMarker(byte expected, String what) {
        int actual = readUByte(what);
        if (actual != (expected & 255)) {
            throw new ParseException(what + ": expected marker 0x" + Integer.toHexString(expected & 255) + ", got 0x" + Integer.toHexString(actual));
        }
    }

    public void skipByte(String what) {
        requireBytes(1, what);
        this.mPos++;
    }

    public void skip(int n, String what) {
        requireBytes(n, what);
        this.mPos += n;
    }

    public boolean readBool(String what) {
        requireBytes(1, what);
        byte[] bArr = this.mBuf;
        int i = this.mPos;
        this.mPos = i + 1;
        return bArr[i] != 0;
    }

    public int readInt(String what) {
        requireBytes(4, what);
        int v = ((this.mBuf[this.mPos + 3] & 255) << 24) | ((this.mBuf[this.mPos + 2] & 255) << 16) | ((this.mBuf[this.mPos + 1] & 255) << 8) | (this.mBuf[this.mPos] & 255);
        this.mPos += 4;
        return v;
    }

    public long readLong(String what) {
        requireBytes(8, what);
        long v = ((this.mBuf[this.mPos + 7] & 255) << 56) | ((this.mBuf[this.mPos + 6] & 255) << 48) | ((this.mBuf[this.mPos + 5] & 255) << 40) | ((this.mBuf[this.mPos + 4] & 255) << 32) | ((this.mBuf[this.mPos + 3] & 255) << 24) | ((this.mBuf[this.mPos + 2] & 255) << 16) | ((this.mBuf[this.mPos + 1] & 255) << 8) | (this.mBuf[this.mPos] & 255);
        this.mPos += 8;
        return v;
    }

    public float readFloat(String what) {
        return Float.intBitsToFloat(readInt(what));
    }

    public double readDouble(String what) {
        return Double.longBitsToDouble(readLong(what));
    }

    public String readString(String what) {
        int len = readInt(what + ".len");
        if (len < 0) {
            throw new ParseException(what + ": negative string length " + len);
        }
        requireBytes(len, what + ".body");
        String string = new String(this.mBuf, this.mPos, len, StandardCharsets.UTF_8);
        this.mPos += len;
        return string;
    }

    public int readListHeader(byte expectedElemType, String what) {
        expectMarker((byte) 3, what + ".type_list");
        int count = readUByte(what + ".count");
        expectMarker(expectedElemType, what + ".elem_type");
        if (count > 127) {
            throw new ParseException(what + ": list count " + count + " exceeds MAX_NUM_ELEMENTS=127");
        }
        return count;
    }

    public boolean[] readBoolArray(String what) {
        int n = readListHeader((byte) 5, what);
        requireBytes(n, what + ".body");
        boolean[] booleans = new boolean[n];
        for (int i = 0; i < n; i++) {
            byte[] bArr = this.mBuf;
            int i2 = this.mPos;
            this.mPos = i2 + 1;
            booleans[i] = bArr[i2] != 0;
        }
        return booleans;
    }

    public int[] readIntArray(String what) {
        int n = readListHeader((byte) 0, what);
        requireBytes(n * 4, what + ".body");
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = readInt(what + "[" + i + "]");
        }
        return ints;
    }

    public long[] readLongArray(String what) {
        int n = readListHeader((byte) 1, what);
        requireBytes(n * 8, what + ".body");
        long[] longs = new long[n];
        for (int i = 0; i < n; i++) {
            longs[i] = readLong(what + "[" + i + "]");
        }
        return longs;
    }

    public float[] readFloatArray(String what) {
        int n = readListHeader((byte) 4, what);
        requireBytes(n * 4, what + ".body");
        float[] floats = new float[n];
        for (int i = 0; i < n; i++) {
            floats[i] = readFloat(what + "[" + i + "]");
        }
        return floats;
    }

    public String[] readStringArray(String what) {
        int n = readListHeader((byte) 2, what);
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = readString(what + "[" + i + "]");
        }
        return strings;
    }

    public ArrayMap<String, Object> readArrayMap(String what) {
        Object value;
        expectMarker((byte) 10, what + ".type_map");
        int size = readUByte(what + ".size");
        ArrayMap<String, Object> map = new ArrayMap<>(size);
        for (int i = 0; i < size; i++) {
            expectMarker((byte) 2, what + "[" + i + "].key_type");
            String key = readString(what + "[" + i + "].key");
            int valueType = readUByte(what + "[" + i + "].value_type");
            if (valueType == 0) {
                value = Integer.valueOf(readInt(what + "[" + i + "].value"));
            } else if (valueType == 1) {
                value = Long.valueOf(readLong(what + "[" + i + "].value"));
            } else if (valueType == 5) {
                value = Boolean.valueOf(readBool(what + "[" + i + "].value"));
            } else if (valueType == 2) {
                value = readString(what + "[" + i + "].value");
            } else if (valueType == 4) {
                value = Float.valueOf(readFloat(what + "[" + i + "].value"));
            } else {
                throw new ParseException(what + "[" + i + "]: invalid map value type 0x" + Integer.toHexString(valueType));
            }
            map.put(key, value);
        }
        return map;
    }
}
