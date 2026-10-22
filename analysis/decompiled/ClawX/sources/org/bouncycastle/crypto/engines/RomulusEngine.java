package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.RomulusDigest;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;

/* loaded from: classes.dex */
public class RomulusEngine extends AEADBaseEngine {
    private static final int AD_BLK_LEN_HALF = 16;
    private final byte[] CNT;
    private Instance instance;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f4469k;
    private byte[] npub;
    private static final byte[] sbox_8 = {101, 76, 106, 66, 75, 99, 67, 107, 85, 117, 90, 122, 83, 115, 91, 123, 53, -116, 58, -127, -119, 51, -128, 59, -107, 37, -104, 42, -112, 35, -103, 43, -27, -52, -24, -63, -55, -32, -64, -23, -43, -11, -40, -8, -48, -16, -39, -7, -91, 28, -88, 18, 27, -96, 19, -87, 5, -75, 10, -72, 3, -80, 11, -71, 50, -120, 60, -123, -115, 52, -124, 61, -111, 34, -100, 44, -108, 36, -99, 45, 98, 74, 108, 69, 77, 100, 68, 109, 82, 114, 92, 124, 84, 116, 93, 125, -95, 26, -84, 21, 29, -92, 20, -83, 2, -79, 12, PSSSigner.TRAILER_IMPLICIT, 4, -76, 13, -67, -31, -56, -20, -59, -51, -28, -60, -19, -47, -15, -36, -4, -44, -12, -35, -3, 54, -114, 56, -126, -117, 48, -125, 57, -106, 38, -102, 40, -109, 32, -101, 41, 102, 78, 104, 65, 73, 96, 64, 105, 86, 118, 88, 120, 80, 112, 89, 121, -90, 30, -86, 17, 25, -93, 16, -85, 6, -74, 8, -70, 0, -77, 9, -69, -26, -50, -22, -62, -53, -29, -61, -21, -42, -10, -38, -6, -45, -13, -37, -5, 49, -118, 62, -122, -113, 55, -121, 63, -110, 33, -98, 46, -105, 39, -97, 47, 97, 72, 110, 70, 79, 103, 71, 111, 81, 113, 94, 126, 87, 119, 95, AbstractJsonLexerKt.TC_INVALID, -94, 24, -82, 22, 31, -89, 23, -81, 1, -78, 14, -66, 7, -73, 15, -65, -30, -54, -18, -58, -49, -25, -57, -17, -46, -14, -34, -2, -41, -9, -33, -1};
    private static final byte[] TWEAKEY_P = {9, 15, 8, 13, 10, 14, 12, 11, 0, 1, 2, 3, 4, 5, 6, 7};
    private static final byte[] RC = {1, 3, 7, 15, 31, 62, 61, 59, 55, 47, 30, 60, 57, 51, 39, 14, 29, 58, 53, 43, 22, 44, 24, 48, 33, 2, 5, 11, 23, 46, 28, 56, 49, 35, 6, 13, 27, 54, 45, 26};

    public interface Instance {
        void processBufferAAD(byte[] bArr, int i8);

        void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9);

        void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9);

        void processFinalAAD();

        void processFinalBlock(byte[] bArr, int i8);

        void reset();
    }

    public class RomulusN implements Instance {

        /* renamed from: s, reason: collision with root package name */
        private final byte[] f4471s = new byte[16];
        boolean twist;

        public RomulusN() {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i8) {
            if (this.twist) {
                Bytes.xorTo(16, bArr, i8, this.f4471s);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.block_cipher(this.f4471s, romulusEngine.f4469k, bArr, i8, RomulusEngine.this.CNT, (byte) 8);
            }
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.lfsr_gf56(romulusEngine2.CNT);
            this.twist = !this.twist;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
            RomulusEngine.this.g8A(this.f4471s, bArr2, i9);
            for (int i10 = 0; i10 < 16; i10++) {
                int i11 = i10 + i9;
                byte b9 = (byte) (bArr2[i11] ^ bArr[i10 + i8]);
                bArr2[i11] = b9;
                byte[] bArr3 = this.f4471s;
                bArr3[i10] = (byte) (b9 ^ bArr3[i10]);
            }
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.lfsr_gf56(romulusEngine.CNT);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.f4471s, romulusEngine2.f4469k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 4);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
            RomulusEngine.this.g8A(this.f4471s, bArr2, i9);
            for (int i10 = 0; i10 < 16; i10++) {
                byte[] bArr3 = this.f4471s;
                int i11 = i10 + i8;
                bArr3[i10] = (byte) (bArr3[i10] ^ bArr[i11]);
                int i12 = i10 + i9;
                bArr2[i12] = (byte) (bArr2[i12] ^ bArr[i11]);
            }
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.lfsr_gf56(romulusEngine.CNT);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.f4471s, romulusEngine2.f4469k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 4);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            int i8 = RomulusEngine.this.m_aadPos;
            if (i8 != 0) {
                byte[] bArr = new byte[16];
                int iMin = Math.min(i8, 16);
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.pad(romulusEngine.m_aad, 0, bArr, 16, iMin);
                if (this.twist) {
                    Bytes.xorTo(16, bArr, this.f4471s);
                } else {
                    RomulusEngine romulusEngine2 = RomulusEngine.this;
                    romulusEngine2.block_cipher(this.f4471s, romulusEngine2.f4469k, bArr, 0, RomulusEngine.this.CNT, (byte) 8);
                }
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.lfsr_gf56(romulusEngine3.CNT);
            }
            if (RomulusEngine.this.aadOperator.getLen() == 0) {
                RomulusEngine romulusEngine4 = RomulusEngine.this;
                romulusEngine4.lfsr_gf56(romulusEngine4.CNT);
                RomulusEngine romulusEngine5 = RomulusEngine.this;
                romulusEngine5.block_cipher(this.f4471s, romulusEngine5.f4469k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 26);
            } else {
                RomulusEngine romulusEngine6 = RomulusEngine.this;
                int i9 = romulusEngine6.m_aadPos & 15;
                byte[] bArr2 = this.f4471s;
                byte[] bArr3 = romulusEngine6.f4469k;
                if (i9 != 0) {
                    romulusEngine6.block_cipher(bArr2, bArr3, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 26);
                } else {
                    romulusEngine6.block_cipher(bArr2, bArr3, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 24);
                }
            }
            RomulusEngine romulusEngine7 = RomulusEngine.this;
            romulusEngine7.reset_lfsr_gf56(romulusEngine7.CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i8) {
            int len = RomulusEngine.this.dataOperator.getLen();
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (len - (romulusEngine.forEncryption ? 0 : romulusEngine.MAC_SIZE) == 0) {
                romulusEngine.lfsr_gf56(romulusEngine.CNT);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.block_cipher(this.f4471s, romulusEngine2.f4469k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 21);
            } else {
                int i9 = romulusEngine.m_bufPos;
                if (i9 != 0) {
                    int iMin = Math.min(i9, 16);
                    RomulusEngine romulusEngine3 = RomulusEngine.this;
                    romulusEngine3.rho(romulusEngine3.m_buf, 0, bArr, i8, this.f4471s, iMin);
                    RomulusEngine romulusEngine4 = RomulusEngine.this;
                    romulusEngine4.lfsr_gf56(romulusEngine4.CNT);
                    RomulusEngine romulusEngine5 = RomulusEngine.this;
                    romulusEngine5.block_cipher(this.f4471s, romulusEngine5.f4469k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, RomulusEngine.this.m_bufPos == 16 ? (byte) 20 : (byte) 21);
                }
            }
            RomulusEngine romulusEngine6 = RomulusEngine.this;
            romulusEngine6.g8A(this.f4471s, romulusEngine6.mac, 0);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void reset() {
            Arrays.clear(this.f4471s);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.CNT);
            this.twist = true;
        }
    }

    public static class RomulusParameters {
        public static final int ROMULUS_M = 0;
        public static final int ROMULUS_N = 1;
        public static final int ROMULUS_T = 2;
        public static final RomulusParameters RomulusM = new RomulusParameters(0);
        public static final RomulusParameters RomulusN = new RomulusParameters(1);
        public static final RomulusParameters RomulusT = new RomulusParameters(2);
        private final int ord;

        public RomulusParameters(int i8) {
            this.ord = i8;
        }
    }

    public class RomulusT implements Instance {
        byte[] CNT_Z;
        byte[] LR;
        byte[] S;
        byte[] T;
        byte[] Z;

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f4472g;

        /* renamed from: h, reason: collision with root package name */
        private final byte[] f4473h;

        private RomulusT() {
            this.f4473h = new byte[16];
            this.f4472g = new byte[16];
            this.Z = new byte[16];
            this.CNT_Z = new byte[7];
            this.LR = new byte[32];
            this.T = new byte[16];
            this.S = new byte[16];
        }

        private void processAfterAbsorbCiphertext() {
            RomulusEngine romulusEngine = RomulusEngine.this;
            int i8 = romulusEngine.m_aadPos;
            int i9 = romulusEngine.BlockSize;
            if (i8 == i9) {
                RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, romulusEngine.m_aad, 0);
                RomulusEngine.this.m_aadPos = 0;
            } else {
                romulusEngine.m_aadPos = i9;
            }
            RomulusEngine.this.lfsr_gf56(this.CNT_Z);
        }

        private void processBuffer(byte[] bArr, int i8, byte[] bArr2, int i9) {
            System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.block_cipher(this.S, this.Z, this.T, 0, romulusEngine.CNT, (byte) 64);
            Bytes.xor(16, this.S, bArr, i8, bArr2, i9);
            System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.S, this.Z, this.T, 0, romulusEngine2.CNT, (byte) 65);
            System.arraycopy(this.S, 0, this.Z, 0, 16);
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            romulusEngine3.lfsr_gf56(romulusEngine3.CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i8) {
            RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, bArr, i8);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
            processBuffer(bArr, i8, bArr2, i9);
            RomulusEngine romulusEngine = RomulusEngine.this;
            System.arraycopy(bArr, i8, romulusEngine.m_aad, romulusEngine.m_aadPos, romulusEngine.BlockSize);
            processAfterAbsorbCiphertext();
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
            processBuffer(bArr, i8, bArr2, i9);
            RomulusEngine romulusEngine = RomulusEngine.this;
            System.arraycopy(bArr2, i9, romulusEngine.m_aad, romulusEngine.m_aadPos, romulusEngine.BlockSize);
            processAfterAbsorbCiphertext();
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            RomulusEngine romulusEngine = RomulusEngine.this;
            Arrays.fill(romulusEngine.m_aad, romulusEngine.m_aadPos, romulusEngine.AADBufferSize - 1, (byte) 0);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            int i8 = romulusEngine2.m_aadPos;
            if (i8 >= 16) {
                byte[] bArr = romulusEngine2.m_aad;
                bArr[romulusEngine2.AADBufferSize - 1] = (byte) (i8 & 15);
                RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, bArr, 0);
                RomulusEngine.this.m_aadPos = 0;
                return;
            }
            if (i8 < 0 || romulusEngine2.aadOperator.getLen() == 0) {
                return;
            }
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            byte[] bArr2 = romulusEngine3.m_aad;
            int i9 = romulusEngine3.BlockSize;
            bArr2[i9 - 1] = (byte) (romulusEngine3.m_aadPos & 15);
            romulusEngine3.m_aadPos = i9;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i8) {
            char c3;
            int len = RomulusEngine.this.dataOperator.getLen();
            RomulusEngine romulusEngine = RomulusEngine.this;
            int i9 = len - (romulusEngine.forEncryption ? 0 : romulusEngine.MAC_SIZE);
            int i10 = romulusEngine.m_bufPos;
            if (i10 != 0) {
                int iMin = Math.min(i10, 16);
                System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.block_cipher(this.S, this.Z, this.T, 0, romulusEngine2.CNT, (byte) 64);
                Bytes.xor(iMin, RomulusEngine.this.m_buf, this.S, bArr, i8);
                System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.lfsr_gf56(romulusEngine3.CNT);
                RomulusEngine romulusEngine4 = RomulusEngine.this;
                if (!romulusEngine4.forEncryption) {
                    bArr = romulusEngine4.m_buf;
                    i8 = 0;
                }
                System.arraycopy(bArr, i8, romulusEngine4.m_aad, romulusEngine4.m_aadPos, romulusEngine4.m_bufPos);
                RomulusEngine romulusEngine5 = RomulusEngine.this;
                Arrays.fill(romulusEngine5.m_aad, romulusEngine5.m_aadPos + romulusEngine5.m_bufPos, romulusEngine5.AADBufferSize - 1, (byte) 0);
                RomulusEngine romulusEngine6 = RomulusEngine.this;
                byte[] bArr2 = romulusEngine6.m_aad;
                int i11 = romulusEngine6.m_aadPos;
                bArr2[(romulusEngine6.BlockSize + i11) - 1] = (byte) (romulusEngine6.m_bufPos & 15);
                if (i11 == 0) {
                    byte[] bArr3 = romulusEngine6.npub;
                    RomulusEngine romulusEngine7 = RomulusEngine.this;
                    byte[] bArr4 = romulusEngine7.m_aad;
                    int i12 = romulusEngine7.BlockSize;
                    System.arraycopy(bArr3, 0, bArr4, i12, i12);
                    c3 = 0;
                } else {
                    c3 = 16;
                }
                RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, RomulusEngine.this.m_aad, 0);
                RomulusEngine.this.lfsr_gf56(this.CNT_Z);
            } else if (romulusEngine.m_aadPos != 0) {
                if (i9 > 0) {
                    Arrays.fill(romulusEngine.m_aad, romulusEngine.BlockSize, romulusEngine.AADBufferSize, (byte) 0);
                } else {
                    if (romulusEngine.aadOperator.getLen() != 0) {
                        byte[] bArr5 = RomulusEngine.this.npub;
                        RomulusEngine romulusEngine8 = RomulusEngine.this;
                        System.arraycopy(bArr5, 0, romulusEngine8.m_aad, romulusEngine8.m_aadPos, 16);
                        RomulusEngine.this.m_aadPos = 0;
                        c3 = 0;
                    }
                    RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, RomulusEngine.this.m_aad, 0);
                }
                c3 = 16;
                RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, RomulusEngine.this.m_aad, 0);
            } else if (i9 > 0) {
                Arrays.fill(romulusEngine.m_aad, 0, romulusEngine.BlockSize, (byte) 0);
                byte[] bArr6 = RomulusEngine.this.npub;
                RomulusEngine romulusEngine9 = RomulusEngine.this;
                byte[] bArr7 = romulusEngine9.m_aad;
                int i13 = romulusEngine9.BlockSize;
                System.arraycopy(bArr6, 0, bArr7, i13, i13);
                RomulusEngine.hirose_128_128_256(this.f4473h, this.f4472g, RomulusEngine.this.m_aad, 0);
                c3 = 0;
            } else {
                c3 = 16;
            }
            if (c3 == 16) {
                System.arraycopy(RomulusEngine.this.npub, 0, RomulusEngine.this.m_aad, 0, 16);
                System.arraycopy(RomulusEngine.this.CNT, 0, RomulusEngine.this.m_aad, 16, 7);
                Arrays.fill(RomulusEngine.this.m_aad, 23, 31, (byte) 0);
                RomulusEngine.this.m_aad[31] = 23;
            } else {
                System.arraycopy(this.CNT_Z, 0, RomulusEngine.this.m_aad, 0, 7);
                Arrays.fill(RomulusEngine.this.m_aad, 7, 31, (byte) 0);
                RomulusEngine.this.m_aad[31] = 7;
            }
            byte[] bArr8 = this.f4473h;
            bArr8[0] = (byte) (bArr8[0] ^ 2);
            RomulusEngine.hirose_128_128_256(bArr8, this.f4472g, RomulusEngine.this.m_aad, 0);
            System.arraycopy(this.f4473h, 0, this.LR, 0, 16);
            System.arraycopy(this.f4472g, 0, this.LR, 16, 16);
            Arrays.clear(this.CNT_Z);
            RomulusEngine romulusEngine10 = RomulusEngine.this;
            romulusEngine10.block_cipher(this.LR, romulusEngine10.f4469k, this.LR, 16, this.CNT_Z, (byte) 68);
            byte[] bArr9 = this.LR;
            RomulusEngine romulusEngine11 = RomulusEngine.this;
            System.arraycopy(bArr9, 0, romulusEngine11.mac, 0, romulusEngine11.MAC_SIZE);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void reset() {
            Arrays.clear(this.f4473h);
            Arrays.clear(this.f4472g);
            Arrays.clear(this.LR);
            Arrays.clear(this.T);
            Arrays.clear(this.S);
            Arrays.clear(this.CNT_Z);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.CNT);
            System.arraycopy(RomulusEngine.this.npub, 0, this.Z, 0, RomulusEngine.this.IV_SIZE);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.Z, romulusEngine2.f4469k, this.T, 0, this.CNT_Z, (byte) 66);
            RomulusEngine.this.reset_lfsr_gf56(this.CNT_Z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public RomulusEngine(org.bouncycastle.crypto.engines.RomulusEngine.RomulusParameters r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 16
            r3.AADBufferSize = r0
            r3.BlockSize = r0
            r3.MAC_SIZE = r0
            r3.IV_SIZE = r0
            r3.KEY_SIZE = r0
            r0 = 7
            byte[] r0 = new byte[r0]
            r3.CNT = r0
            int r0 = org.bouncycastle.crypto.engines.RomulusEngine.RomulusParameters.access$000(r4)
            if (r0 == 0) goto L3c
            r1 = 1
            if (r0 == r1) goto L32
            r1 = 2
            if (r0 == r1) goto L21
            goto L46
        L21:
            java.lang.String r0 = "Romulus-T"
            r3.algorithmName = r0
            r0 = 32
            r3.AADBufferSize = r0
            org.bouncycastle.crypto.engines.RomulusEngine$RomulusT r0 = new org.bouncycastle.crypto.engines.RomulusEngine$RomulusT
            r1 = 0
            r0.<init>()
        L2f:
            r3.instance = r0
            goto L46
        L32:
            java.lang.String r0 = "Romulus-N"
            r3.algorithmName = r0
            org.bouncycastle.crypto.engines.RomulusEngine$RomulusN r0 = new org.bouncycastle.crypto.engines.RomulusEngine$RomulusN
            r0.<init>()
            goto L2f
        L3c:
            java.lang.String r0 = "Romulus-M"
            r3.algorithmName = r0
            org.bouncycastle.crypto.engines.RomulusEngine$RomulusM r0 = new org.bouncycastle.crypto.engines.RomulusEngine$RomulusM
            r0.<init>()
            goto L2f
        L46:
            org.bouncycastle.crypto.engines.RomulusEngine$RomulusParameters r0 = org.bouncycastle.crypto.engines.RomulusEngine.RomulusParameters.RomulusN
            if (r4 != r0) goto L4d
            org.bouncycastle.crypto.engines.AEADBaseEngine$ProcessingBufferType r0 = org.bouncycastle.crypto.engines.AEADBaseEngine.ProcessingBufferType.Buffered
            goto L4f
        L4d:
            org.bouncycastle.crypto.engines.AEADBaseEngine$ProcessingBufferType r0 = org.bouncycastle.crypto.engines.AEADBaseEngine.ProcessingBufferType.Immediate
        L4f:
            org.bouncycastle.crypto.engines.AEADBaseEngine$AADOperatorType r1 = org.bouncycastle.crypto.engines.AEADBaseEngine.AADOperatorType.Counter
            org.bouncycastle.crypto.engines.RomulusEngine$RomulusParameters r2 = org.bouncycastle.crypto.engines.RomulusEngine.RomulusParameters.RomulusM
            if (r4 != r2) goto L58
            org.bouncycastle.crypto.engines.AEADBaseEngine$DataOperatorType r4 = org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperatorType.Stream
            goto L5a
        L58:
            org.bouncycastle.crypto.engines.AEADBaseEngine$DataOperatorType r4 = org.bouncycastle.crypto.engines.AEADBaseEngine.DataOperatorType.Counter
        L5a:
            r3.setInnerMembers(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.RomulusEngine.<init>(org.bouncycastle.crypto.engines.RomulusEngine$RomulusParameters):void");
    }

    public static void hirose_128_128_256(RomulusDigest.Friend friend, byte[] bArr, byte[] bArr2, byte[] bArr3, int i8) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by RomulusDigest");
        }
        hirose_128_128_256(bArr, bArr2, bArr3, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset_lfsr_gf56(byte[] bArr) {
        bArr[0] = 1;
        Arrays.fill(bArr, 1, 7, (byte) 0);
    }

    private static void skinny_128_384_plus_enc(byte[] bArr, byte[] bArr2) {
        Class cls = Byte.TYPE;
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) cls, 4, 4);
        byte[][][] bArr4 = (byte[][][]) Array.newInstance((Class<?>) cls, 3, 4, 4);
        byte[][][] bArr5 = (byte[][][]) Array.newInstance((Class<?>) cls, 3, 4, 4);
        for (int i8 = 0; i8 < 4; i8++) {
            int i9 = i8 << 2;
            System.arraycopy(bArr, i9, bArr3[i8], 0, 4);
            System.arraycopy(bArr2, i9, bArr4[0][i8], 0, 4);
            System.arraycopy(bArr2, i9 + 16, bArr4[1][i8], 0, 4);
            System.arraycopy(bArr2, i9 + 32, bArr4[2][i8], 0, 4);
        }
        for (int i10 = 0; i10 < 40; i10++) {
            for (int i11 = 0; i11 < 4; i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    byte[] bArr6 = bArr3[i11];
                    bArr6[i12] = sbox_8[bArr6[i12] & 255];
                }
            }
            byte[] bArr7 = bArr3[0];
            byte b9 = bArr7[0];
            byte[] bArr8 = RC;
            bArr7[0] = (byte) (b9 ^ (bArr8[i10] & 15));
            byte[] bArr9 = bArr3[1];
            bArr9[0] = (byte) (bArr9[0] ^ ((bArr8[i10] >>> 4) & 3));
            byte[] bArr10 = bArr3[2];
            bArr10[0] = (byte) (bArr10[0] ^ 2);
            for (int i13 = 0; i13 <= 1; i13++) {
                for (int i14 = 0; i14 < 4; i14++) {
                    byte[] bArr11 = bArr3[i13];
                    bArr11[i14] = (byte) (bArr11[i14] ^ ((bArr4[0][i13][i14] ^ bArr4[1][i13][i14]) ^ bArr4[2][i13][i14]));
                }
            }
            for (int i15 = 0; i15 < 4; i15++) {
                for (int i16 = 0; i16 < 4; i16++) {
                    byte b10 = TWEAKEY_P[(i15 << 2) + i16];
                    int i17 = b10 >>> 2;
                    int i18 = b10 & 3;
                    bArr5[0][i15][i16] = bArr4[0][i17][i18];
                    bArr5[1][i15][i16] = bArr4[1][i17][i18];
                    bArr5[2][i15][i16] = bArr4[2][i17][i18];
                }
            }
            int i19 = 0;
            while (i19 <= 1) {
                for (int i20 = 0; i20 < 4; i20++) {
                    bArr4[0][i19][i20] = bArr5[0][i19][i20];
                    byte b11 = bArr5[1][i19][i20];
                    bArr4[1][i19][i20] = (byte) (((b11 >>> 5) & 1) ^ (((b11 << 1) & 254) ^ ((b11 >>> 7) & 1)));
                    byte b12 = bArr5[2][i19][i20];
                    bArr4[2][i19][i20] = (byte) (((b12 << 1) & 128) ^ (((b12 >>> 1) & 127) ^ ((b12 << 7) & 128)));
                }
                i19++;
            }
            while (i19 < 4) {
                for (int i21 = 0; i21 < 4; i21++) {
                    bArr4[0][i19][i21] = bArr5[0][i19][i21];
                    bArr4[1][i19][i21] = bArr5[1][i19][i21];
                    bArr4[2][i19][i21] = bArr5[2][i19][i21];
                }
                i19++;
            }
            byte[] bArr12 = bArr3[1];
            byte b13 = bArr12[3];
            bArr12[3] = bArr12[2];
            bArr12[2] = bArr12[1];
            bArr12[1] = bArr12[0];
            bArr12[0] = b13;
            byte[] bArr13 = bArr3[2];
            byte b14 = bArr13[0];
            bArr13[0] = bArr13[2];
            bArr13[2] = b14;
            byte b15 = bArr13[1];
            bArr13[1] = bArr13[3];
            bArr13[3] = b15;
            byte[] bArr14 = bArr3[3];
            byte b16 = bArr14[0];
            bArr14[0] = bArr14[1];
            bArr14[1] = bArr14[2];
            bArr14[2] = bArr14[3];
            bArr14[3] = b16;
            for (int i22 = 0; i22 < 4; i22++) {
                byte[] bArr15 = bArr3[1];
                byte b17 = bArr15[i22];
                byte[] bArr16 = bArr3[2];
                bArr15[i22] = (byte) (b17 ^ bArr16[i22]);
                byte b18 = bArr16[i22];
                byte[] bArr17 = bArr3[0];
                byte b19 = (byte) (b18 ^ bArr17[i22]);
                bArr16[i22] = b19;
                byte[] bArr18 = bArr3[3];
                byte b20 = (byte) (bArr18[i22] ^ b19);
                bArr18[i22] = b20;
                bArr18[i22] = bArr16[i22];
                bArr16[i22] = bArr15[i22];
                bArr15[i22] = bArr17[i22];
                bArr17[i22] = b20;
            }
        }
        for (int i23 = 0; i23 < 16; i23++) {
            bArr[i23] = (byte) (bArr3[i23 >>> 2][i23 & 3] & 255);
        }
    }

    public void block_cipher(byte[] bArr, byte[] bArr2, byte[] bArr3, int i8, byte[] bArr4, byte b9) {
        byte[] bArr5 = new byte[48];
        System.arraycopy(bArr4, 0, bArr5, 0, 7);
        bArr5[7] = b9;
        System.arraycopy(bArr3, i8, bArr5, 16, 16);
        System.arraycopy(bArr2, 0, bArr5, 32, 16);
        skinny_128_384_plus_enc(bArr, bArr5);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD1(state);
    }

    public void g8A(byte[] bArr, byte[] bArr2, int i8) {
        int iMin = Math.min(bArr2.length - i8, 16);
        for (int i9 = 0; i9 < iMin; i9++) {
            byte b9 = bArr[i9];
            bArr2[i9 + i8] = (byte) (((b9 & 1) << 7) ^ (((b9 & 255) >>> 1) ^ (b9 & 128)));
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ byte[] getMac() {
        return super.getMac();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i8) {
        return super.getOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i8) {
        return super.getUpdateOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    public void lfsr_gf56(byte[] bArr) {
        byte b9 = bArr[6];
        byte b10 = (byte) ((b9 & 255) >>> 7);
        byte b11 = bArr[5];
        bArr[6] = (byte) (((b9 & 255) << 1) | ((b11 & 255) >>> 7));
        int i8 = (b11 & 255) << 1;
        byte b12 = bArr[4];
        bArr[5] = (byte) (i8 | ((b12 & 255) >>> 7));
        int i9 = (b12 & 255) << 1;
        byte b13 = bArr[3];
        bArr[4] = (byte) (i9 | ((b13 & 255) >>> 7));
        int i10 = (b13 & 255) << 1;
        byte b14 = bArr[2];
        bArr[3] = (byte) (i10 | ((b14 & 255) >>> 7));
        byte b15 = bArr[1];
        bArr[2] = (byte) (((b14 & 255) << 1) | ((b15 & 255) >>> 7));
        int i11 = (b15 & 255) << 1;
        byte b16 = bArr[0];
        bArr[1] = (byte) (i11 | ((b16 & 255) >>> 7));
        int i12 = (b16 & 255) << 1;
        if (b10 == 1) {
            bArr[0] = (byte) (i12 ^ 149);
        } else {
            bArr[0] = (byte) i12;
        }
    }

    public void pad(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        bArr2[i9 - 1] = (byte) (i10 & 15);
        System.arraycopy(bArr, i8, bArr2, 0, i10);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b9) {
        super.processAADByte(b9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i8, int i9) {
        super.processAADBytes(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i8) {
        this.instance.processBufferAAD(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        this.instance.processBufferDecrypt(bArr, i8, bArr2, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        this.instance.processBufferEncrypt(bArr, i8, bArr2, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b9, byte[] bArr, int i8) {
        return super.processByte(b9, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        return super.processBytes(bArr, i8, i9, bArr2, i10);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalAAD() {
        this.instance.processFinalAAD();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        this.instance.processFinalBlock(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public void rho(byte[] bArr, int i8, byte[] bArr2, int i9, byte[] bArr3, int i10) {
        int i11;
        byte[] bArr4 = new byte[16];
        pad(bArr, i8, bArr4, 16, i10);
        g8A(bArr3, bArr2, i9);
        if (this.forEncryption) {
            for (int i12 = 0; i12 < 16; i12++) {
                bArr3[i12] = (byte) (bArr3[i12] ^ bArr4[i12]);
                int i13 = i12 + i9;
                if (i12 < i10) {
                    bArr2[i13] = (byte) (bArr2[i13] ^ bArr4[i12]);
                } else {
                    bArr2[i13] = 0;
                }
            }
            return;
        }
        for (int i14 = 0; i14 < 16; i14++) {
            byte b9 = (byte) (bArr3[i14] ^ bArr4[i14]);
            bArr3[i14] = b9;
            if (i14 < i10 && (i11 = i14 + i9) < bArr2.length) {
                bArr3[i14] = (byte) (b9 ^ bArr2[i11]);
                bArr2[i11] = (byte) (bArr2[i11] ^ bArr4[i14]);
            }
        }
    }

    public static void hirose_128_128_256(byte[] bArr, byte[] bArr2, byte[] bArr3, int i8) {
        byte[] bArr4 = new byte[48];
        byte[] bArr5 = new byte[16];
        System.arraycopy(bArr2, 0, bArr4, 0, 16);
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 0, bArr5, 0, 16);
        bArr2[0] = (byte) (bArr2[0] ^ 1);
        System.arraycopy(bArr3, i8, bArr4, 16, 32);
        skinny_128_384_plus_enc(bArr, bArr4);
        skinny_128_384_plus_enc(bArr2, bArr4);
        for (int i9 = 0; i9 < 16; i9++) {
            bArr[i9] = (byte) (bArr[i9] ^ bArr5[i9]);
            bArr2[i9] = (byte) (bArr2[i9] ^ bArr5[i9]);
        }
        bArr2[0] = (byte) (bArr2[0] ^ 1);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        this.npub = bArr2;
        this.f4469k = bArr;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        this.instance.reset();
    }

    public class RomulusM implements Instance {
        private int offset;
        private final byte[] mac_s = new byte[16];
        private final byte[] mac_CNT = new byte[7];

        /* renamed from: s, reason: collision with root package name */
        private final byte[] f4470s = new byte[16];
        private boolean twist = true;

        public RomulusM() {
        }

        public int ad_encryption(byte[] bArr, int i8, byte[] bArr2, byte[] bArr3, int i9, byte[] bArr4) {
            byte[] bArr5 = new byte[16];
            byte[] bArr6 = new byte[16];
            int iMin = Math.min(i9, 16);
            int i10 = i9 - iMin;
            RomulusEngine.this.pad(bArr, i8, bArr6, 16, iMin);
            Bytes.xorTo(16, bArr6, bArr2);
            int i11 = i8 + iMin;
            this.offset = i11;
            RomulusEngine.this.lfsr_gf56(bArr4);
            if (i10 == 0) {
                return i10;
            }
            int iMin2 = Math.min(i10, 16);
            int i12 = i10 - iMin2;
            RomulusEngine.this.pad(bArr, i11, bArr5, 16, iMin2);
            this.offset = i11 + iMin2;
            RomulusEngine.this.block_cipher(bArr2, bArr3, bArr5, 0, bArr4, (byte) 44);
            RomulusEngine.this.lfsr_gf56(bArr4);
            return i12;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i8) {
            if (this.twist) {
                Bytes.xorTo(RomulusEngine.this.MAC_SIZE, bArr, i8, this.mac_s);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.block_cipher(this.mac_s, romulusEngine.f4469k, bArr, i8, this.mac_CNT, (byte) 40);
            }
            this.twist = !this.twist;
            RomulusEngine.this.lfsr_gf56(this.mac_CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            if (RomulusEngine.this.aadOperator.getLen() == 0) {
                RomulusEngine.this.lfsr_gf56(this.mac_CNT);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                int i8 = romulusEngine.m_aadPos;
                if (i8 != 0) {
                    Arrays.fill(romulusEngine.m_aad, i8, romulusEngine.BlockSize - 1, (byte) 0);
                    RomulusEngine romulusEngine2 = RomulusEngine.this;
                    byte[] bArr = romulusEngine2.m_aad;
                    int i9 = romulusEngine2.BlockSize;
                    bArr[i9 - 1] = (byte) (romulusEngine2.m_aadPos & 15);
                    if (this.twist) {
                        Bytes.xorTo(i9, bArr, this.mac_s);
                    } else {
                        romulusEngine2.block_cipher(this.mac_s, romulusEngine2.f4469k, RomulusEngine.this.m_aad, 0, this.mac_CNT, (byte) 40);
                    }
                    RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                }
            }
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            romulusEngine3.m_aadPos = 0;
            romulusEngine3.m_bufPos = romulusEngine3.dataOperator.getLen();
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void processFinalBlock(byte[] r31, int r32) {
            /*
                Method dump skipped, instructions count: 501
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.RomulusEngine.RomulusM.processFinalBlock(byte[], int):void");
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void reset() {
            Arrays.clear(this.f4470s);
            Arrays.clear(this.mac_s);
            RomulusEngine.this.reset_lfsr_gf56(this.mac_CNT);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.CNT);
            this.twist = true;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        }
    }
}
