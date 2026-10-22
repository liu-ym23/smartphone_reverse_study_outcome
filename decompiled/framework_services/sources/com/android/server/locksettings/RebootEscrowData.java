package com.android.server.locksettings;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
class RebootEscrowData {
    private static final int CURRENT_VERSION = 2;
    private static final int LEGACY_SINGLE_ENCRYPTED_VERSION = 1;
    private final byte[] mBlob;
    private final RebootEscrowKey mKey;
    private final byte mSpVersion;
    private final byte[] mSyntheticPassword;

    private RebootEscrowData(byte spVersion, byte[] syntheticPassword, byte[] blob, RebootEscrowKey key) {
        this.mSpVersion = spVersion;
        this.mSyntheticPassword = syntheticPassword;
        this.mBlob = blob;
        this.mKey = key;
    }

    public byte getSpVersion() {
        return this.mSpVersion;
    }

    public byte[] getSyntheticPassword() {
        return this.mSyntheticPassword;
    }

    public byte[] getBlob() {
        return this.mBlob;
    }

    public RebootEscrowKey getKey() {
        return this.mKey;
    }

    private static byte[] decryptBlobCurrentVersion(SecretKey kk, RebootEscrowKey ks, DataInputStream dis) throws IOException {
        if (kk == null) goto L6;
        byte[] ksEncryptedBlob = AesEncryptionUtil.decrypt(kk, dis);
        return AesEncryptionUtil.decrypt(ks.getKey(), ksEncryptedBlob);
    L6:
        throw new IOException("Failed to find wrapper key in keystore, cannot decrypt the escrow data");
    }

    static RebootEscrowData fromEncryptedData(RebootEscrowKey ks, byte[] blob, SecretKey kk) throws IOException {
        ks.getClass();
        blob.getClass();
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(blob));
        int version = dis.readInt();
        byte spVersion = dis.readByte();
        switch(version) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        byte[] syntheticPassword = decryptBlobCurrentVersion(kk, ks, dis);
        return new RebootEscrowData(spVersion, syntheticPassword, blob, ks);
    L8:
        byte[] syntheticPassword2 = AesEncryptionUtil.decrypt(ks.getKey(), dis);
        return new RebootEscrowData(spVersion, syntheticPassword2, blob, ks);
    L5:
        throw new IOException("Unsupported version " + version);
    }

    static RebootEscrowData fromSyntheticPassword(RebootEscrowKey ks, byte spVersion, byte[] syntheticPassword, SecretKey kk) throws IOException {
        syntheticPassword.getClass();
        byte[] ksEncryptedBlob = AesEncryptionUtil.encrypt(ks.getKey(), syntheticPassword);
        byte[] kkEncryptedBlob = AesEncryptionUtil.encrypt(kk, ksEncryptedBlob);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(2);
        dos.writeByte(spVersion);
        dos.write(kkEncryptedBlob);
        return new RebootEscrowData(spVersion, syntheticPassword, bos.toByteArray(), ks);
    }
}
