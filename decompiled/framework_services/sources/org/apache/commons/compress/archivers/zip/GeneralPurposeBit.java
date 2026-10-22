package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes3.dex */
public final class GeneralPurposeBit implements Cloneable {
    private static final int DATA_DESCRIPTOR_FLAG = 8;
    private static final int ENCRYPTION_FLAG = 1;
    private static final int NUMBER_OF_SHANNON_FANO_TREES_FLAG = 4;
    private static final int SLIDING_DICTIONARY_SIZE_FLAG = 2;
    private static final int STRONG_ENCRYPTION_FLAG = 64;
    public static final int UFT8_NAMES_FLAG = 2048;
    private boolean dataDescriptorFlag;
    private boolean encryptionFlag;
    private boolean languageEncodingFlag;
    private int numberOfShannonFanoTrees;
    private int slidingDictionarySize;
    private boolean strongEncryptionFlag;

    public GeneralPurposeBit() {
        this.languageEncodingFlag = false;
        this.dataDescriptorFlag = false;
        this.encryptionFlag = false;
        this.strongEncryptionFlag = false;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }

    public void useUTF8ForNames(boolean b) {
        this.languageEncodingFlag = b;
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public void useDataDescriptor(boolean b) {
        this.dataDescriptorFlag = b;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public void useEncryption(boolean b) {
        this.encryptionFlag = b;
    }

    public boolean usesStrongEncryption() {
        if (this.encryptionFlag == true) goto L5;
    L7:
        return false;
    L5:
        if (this.strongEncryptionFlag == false) goto L7;
        return true;
    }

    public void useStrongEncryption(boolean b) {
        this.strongEncryptionFlag = b;
        if (b == false) goto L6;
        useEncryption(true);
        return;
    }

    int getSlidingDictionarySize() {
        return this.slidingDictionarySize;
    }

    int getNumberOfShannonFanoTrees() {
        return this.numberOfShannonFanoTrees;
    }

    public byte[] encode() {
        byte[] result = new byte[2];
        encode(result, 0);
        return result;
    }

    public void encode(byte[] r4, int r5) {
        int r1 = 0;
        if (this.dataDescriptorFlag == false) goto L5;
        int r0 = 8;
    L7:
        if (this.languageEncodingFlag == false) goto L9;
        int r2 = 2048;
    L10:
        int r3 = (r0 | r2) | (this.encryptionFlag ? 1 : 0);
        if (this.strongEncryptionFlag == false) goto L13;
        r1 = 64;
    L13:
        ZipShort.putShort(r3 | r1, r4, r5);
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L7
    }

    public static GeneralPurposeBit parse(byte[] data, int offset) {
        int generalPurposeFlag = ZipShort.getValue(data, offset);
        GeneralPurposeBit b = new GeneralPurposeBit();
        boolean r3 = false;
        if ((generalPurposeFlag & 8) == 0) goto L5;
        boolean r2 = true;
    L6:
        b.useDataDescriptor(r2);
        if ((generalPurposeFlag & 2048) == 0) goto L9;
        boolean r4 = true;
    L10:
        b.useUTF8ForNames(r4);
        if ((generalPurposeFlag & 64) == 0) goto L13;
        boolean r5 = true;
    L14:
        b.useStrongEncryption(r5);
        if ((generalPurposeFlag & 1) == 0) goto L17;
        r3 = true;
    L17:
        b.useEncryption(r3);
        if ((generalPurposeFlag & 2) == 0) goto L20;
        int r6 = 8192;
    L21:
        b.slidingDictionarySize = r6;
        if ((generalPurposeFlag & 4) == 0) goto L24;
        int r7 = 3;
    L25:
        b.numberOfShannonFanoTrees = r7;
        return b;
    L24:
        r7 = 2;
        goto L25
    L20:
        r6 = 4096;
        goto L21
    L13:
        r5 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * 17) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public boolean equals(Object o) {
        if ((o instanceof GeneralPurposeBit) == true) goto L5;
        return false;
    L5:
        GeneralPurposeBit g = (GeneralPurposeBit) o;
        if (g.encryptionFlag == this.encryptionFlag) goto L8;
        return false;
    L8:
        if (g.strongEncryptionFlag == this.strongEncryptionFlag) goto L10;
        return false;
    L10:
        if (g.languageEncodingFlag == this.languageEncodingFlag) goto L12;
        return false;
    L12:
        if (g.dataDescriptorFlag != this.dataDescriptorFlag) goto L18;
        return true;
    L18:
        return false;
    }

    public Object clone() {
        return super.clone();
    L4:
        ex = move-exception;
        throw new RuntimeException("GeneralPurposeBit is not Cloneable?", ex);
    }
}
