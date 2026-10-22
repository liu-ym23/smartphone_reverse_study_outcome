package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.AlphabetMapper;

/* loaded from: classes.dex */
public class BasicAlphabetMapper implements AlphabetMapper {
    private Map<Integer, Character> charMap;
    private Map<Character, Integer> indexMap;

    public BasicAlphabetMapper(String str) {
        this(str.toCharArray());
    }

    @Override // org.bouncycastle.crypto.AlphabetMapper
    public char[] convertToChars(byte[] bArr) {
        int i8 = 0;
        if (this.charMap.size() <= 256) {
            char[] cArr = new char[bArr.length];
            while (i8 != bArr.length) {
                cArr[i8] = this.charMap.get(Integer.valueOf(bArr[i8] & 255)).charValue();
                i8++;
            }
            return cArr;
        }
        if ((bArr.length & 1) != 0) {
            throw new IllegalArgumentException("two byte radix and input string odd length");
        }
        char[] cArr2 = new char[bArr.length / 2];
        while (i8 != bArr.length) {
            cArr2[i8 / 2] = this.charMap.get(Integer.valueOf(((bArr[i8] << 8) & 65280) | (bArr[i8 + 1] & 255))).charValue();
            i8 += 2;
        }
        return cArr2;
    }

    @Override // org.bouncycastle.crypto.AlphabetMapper
    public byte[] convertToIndexes(char[] cArr) {
        int i8 = 0;
        if (this.indexMap.size() <= 256) {
            byte[] bArr = new byte[cArr.length];
            while (i8 != cArr.length) {
                bArr[i8] = this.indexMap.get(Character.valueOf(cArr[i8])).byteValue();
                i8++;
            }
            return bArr;
        }
        byte[] bArr2 = new byte[cArr.length * 2];
        while (i8 != cArr.length) {
            int iIntValue = this.indexMap.get(Character.valueOf(cArr[i8])).intValue();
            int i9 = i8 * 2;
            bArr2[i9] = (byte) ((iIntValue >> 8) & 255);
            bArr2[i9 + 1] = (byte) (iIntValue & 255);
            i8++;
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.AlphabetMapper
    public int getRadix() {
        return this.indexMap.size();
    }

    public BasicAlphabetMapper(char[] cArr) {
        this.indexMap = new HashMap();
        this.charMap = new HashMap();
        for (int i8 = 0; i8 != cArr.length; i8++) {
            if (this.indexMap.containsKey(Character.valueOf(cArr[i8]))) {
                throw new IllegalArgumentException("duplicate key detected in alphabet: " + cArr[i8]);
            }
            this.indexMap.put(Character.valueOf(cArr[i8]), Integer.valueOf(i8));
            this.charMap.put(Integer.valueOf(i8), Character.valueOf(cArr[i8]));
        }
    }
}
