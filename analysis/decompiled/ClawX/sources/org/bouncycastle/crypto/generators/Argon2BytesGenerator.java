package org.bouncycastle.crypto.generators;

import a8.b;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Argon2BytesGenerator {
    private static final int ARGON2_ADDRESSES_IN_BLOCK = 128;
    private static final int ARGON2_BLOCK_SIZE = 1024;
    private static final int ARGON2_PREHASH_DIGEST_LENGTH = 64;
    private static final int ARGON2_PREHASH_SEED_LENGTH = 72;
    private static final int ARGON2_QWORDS_IN_BLOCK = 128;
    private static final int ARGON2_SYNC_POINTS = 4;
    private static final long M32L = 4294967295L;
    private static final int MAX_PARALLELISM = 16777215;
    private static final int MIN_ITERATIONS = 1;
    private static final int MIN_OUTLEN = 4;
    private static final int MIN_PARALLELISM = 1;
    private static final byte[] ZERO_BYTES = new byte[4];
    private int laneLength;
    private Block[] memory;
    private Argon2Parameters parameters;
    private int segmentLength;

    public static class Block {
        private static final int SIZE = 128;

        /* renamed from: v, reason: collision with root package name */
        private final long[] f4480v;

        private Block() {
            this.f4480v = new long[128];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyBlock(Block block) {
            System.arraycopy(block.f4480v, 0, this.f4480v, 0, 128);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xor(Block block, Block block2) {
            long[] jArr = this.f4480v;
            long[] jArr2 = block.f4480v;
            long[] jArr3 = block2.f4480v;
            for (int i8 = 0; i8 < 128; i8++) {
                jArr[i8] = jArr2[i8] ^ jArr3[i8];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xorWith(Block block) {
            long[] jArr = this.f4480v;
            long[] jArr2 = block.f4480v;
            for (int i8 = 0; i8 < 128; i8++) {
                jArr[i8] = jArr[i8] ^ jArr2[i8];
            }
        }

        public Block clear() {
            Arrays.fill(this.f4480v, 0L);
            return this;
        }

        public void fromBytes(byte[] bArr) {
            if (bArr.length < 1024) {
                throw new IllegalArgumentException("input shorter than blocksize");
            }
            Pack.littleEndianToLong(bArr, 0, this.f4480v);
        }

        public void toBytes(byte[] bArr) {
            if (bArr.length < 1024) {
                throw new IllegalArgumentException("output shorter than blocksize");
            }
            Pack.longToLittleEndian(this.f4480v, bArr, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xorWith(Block block, Block block2) {
            long[] jArr = this.f4480v;
            long[] jArr2 = block.f4480v;
            long[] jArr3 = block2.f4480v;
            for (int i8 = 0; i8 < 128; i8++) {
                jArr[i8] = jArr[i8] ^ (jArr2[i8] ^ jArr3[i8]);
            }
        }
    }

    public static class FillBlock {
        Block R;
        Block Z;
        Block addressBlock;
        Block inputBlock;

        private FillBlock() {
            this.R = new Block();
            this.Z = new Block();
            this.addressBlock = new Block();
            this.inputBlock = new Block();
        }

        private void applyBlake() {
            for (int i8 = 0; i8 < 8; i8++) {
                int i9 = i8 * 16;
                Argon2BytesGenerator.roundFunction(this.Z, i9, i9 + 1, i9 + 2, i9 + 3, i9 + 4, i9 + 5, i9 + 6, i9 + 7, i9 + 8, i9 + 9, i9 + 10, i9 + 11, i9 + 12, i9 + 13, i9 + 14, i9 + 15);
            }
            for (int i10 = 0; i10 < 8; i10++) {
                int i11 = i10 * 2;
                Argon2BytesGenerator.roundFunction(this.Z, i11, i11 + 1, i11 + 16, i11 + 17, i11 + 32, i11 + 33, i11 + 48, i11 + 49, i11 + 64, i11 + 65, i11 + 80, i11 + 81, i11 + 96, i11 + 97, i11 + 112, i11 + 113);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillBlock(Block block, Block block2) {
            this.Z.copyBlock(block);
            applyBlake();
            block2.xor(block, this.Z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillBlockWithXor(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xorWith(this.R, this.Z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillBlock(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xor(this.R, this.Z);
        }
    }

    public static class Position {
        int lane;
        int pass;
        int slice;
    }

    private static void F(long[] jArr, int i8, int i9, int i10, int i11) {
        quarterRound(jArr, i8, i9, i11, 32);
        quarterRound(jArr, i10, i11, i9, 24);
        quarterRound(jArr, i8, i9, i11, 16);
        quarterRound(jArr, i10, i11, i9, 63);
    }

    private static void addByteString(byte[] bArr, Digest digest, byte[] bArr2) {
        if (bArr2 == null) {
            digest.update(ZERO_BYTES, 0, 4);
            return;
        }
        Pack.intToLittleEndian(bArr2.length, bArr, 0);
        digest.update(bArr, 0, 4);
        digest.update(bArr2, 0, bArr2.length);
    }

    private void digest(byte[] bArr, byte[] bArr2, int i8, int i9) {
        Block block = this.memory[this.laneLength - 1];
        for (int i10 = 1; i10 < this.parameters.getLanes(); i10++) {
            int i11 = this.laneLength;
            block.xorWith(this.memory[(i11 - 1) + (i10 * i11)]);
        }
        block.toBytes(bArr);
        hash(bArr, bArr2, i8, i9);
    }

    private void fillFirstBlocks(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[ARGON2_PREHASH_SEED_LENGTH];
        System.arraycopy(bArr2, 0, bArr3, 0, 64);
        bArr3[64] = 1;
        for (int i8 = 0; i8 < this.parameters.getLanes(); i8++) {
            Pack.intToLittleEndian(i8, bArr2, 68);
            Pack.intToLittleEndian(i8, bArr3, 68);
            hash(bArr2, bArr, 0, 1024);
            this.memory[this.laneLength * i8].fromBytes(bArr);
            hash(bArr3, bArr, 0, 1024);
            this.memory[(this.laneLength * i8) + 1].fromBytes(bArr);
        }
    }

    private void fillMemoryBlocks() {
        FillBlock fillBlock = new FillBlock();
        Position position = new Position();
        for (int i8 = 0; i8 < this.parameters.getIterations(); i8++) {
            position.pass = i8;
            for (int i9 = 0; i9 < 4; i9++) {
                position.slice = i9;
                for (int i10 = 0; i10 < this.parameters.getLanes(); i10++) {
                    position.lane = i10;
                    fillSegment(fillBlock, position);
                }
            }
        }
    }

    private void fillSegment(FillBlock fillBlock, Position position) {
        Block blockClear;
        Block blockClear2;
        FillBlock fillBlock2 = fillBlock;
        Position position2 = position;
        boolean zIsDataIndependentAddressing = isDataIndependentAddressing(position2);
        int startingIndex = getStartingIndex(position2);
        int i8 = (position2.slice * this.segmentLength) + (position2.lane * this.laneLength) + startingIndex;
        int prevOffset = getPrevOffset(i8);
        if (zIsDataIndependentAddressing) {
            blockClear = fillBlock2.addressBlock.clear();
            blockClear2 = fillBlock2.inputBlock.clear();
            initAddressBlocks(fillBlock2, position2, blockClear2, blockClear);
        } else {
            blockClear = null;
            blockClear2 = null;
        }
        boolean zIsWithXor = isWithXor(position2);
        while (true) {
            int i9 = i8;
            if (startingIndex >= this.segmentLength) {
                return;
            }
            Block block = blockClear;
            int i10 = prevOffset;
            Block block2 = blockClear2;
            long pseudoRandom = getPseudoRandom(fillBlock2, startingIndex, block, block2, i10, zIsDataIndependentAddressing);
            boolean z = zIsDataIndependentAddressing;
            FillBlock fillBlock3 = fillBlock2;
            int refLane = getRefLane(position2, pseudoRandom);
            int refColumn = getRefColumn(position2, startingIndex, pseudoRandom, refLane == position2.lane);
            Block[] blockArr = this.memory;
            Block block3 = blockArr[i10];
            Block block4 = blockArr[(this.laneLength * refLane) + refColumn];
            Block block5 = blockArr[i9];
            if (zIsWithXor) {
                fillBlock3.fillBlockWithXor(block3, block4, block5);
            } else {
                fillBlock3.fillBlock(block3, block4, block5);
            }
            i8 = i9 + 1;
            startingIndex++;
            position2 = position;
            fillBlock2 = fillBlock3;
            zIsDataIndependentAddressing = z;
            prevOffset = i9;
            blockClear = block;
            blockClear2 = block2;
        }
    }

    private int getPrevOffset(int i8) {
        return i8 % this.laneLength == 0 ? (i8 + r1) - 1 : i8 - 1;
    }

    private long getPseudoRandom(FillBlock fillBlock, int i8, Block block, Block block2, int i9, boolean z) {
        if (!z) {
            return this.memory[i9].f4480v[0];
        }
        int i10 = i8 % 128;
        if (i10 == 0) {
            nextAddresses(fillBlock, block2, block);
        }
        return block.f4480v[i10];
    }

    private int getRefColumn(Position position, int i8, long j4, boolean z) {
        int i9;
        int i10;
        int i11 = position.pass;
        int i12 = 0;
        int i13 = position.slice;
        if (i11 != 0) {
            int i14 = this.segmentLength;
            int i15 = this.laneLength;
            int i16 = ((i13 + 1) * i14) % i15;
            int i17 = i15 - i14;
            if (z) {
                i9 = (i17 + i8) - 1;
            } else {
                i9 = i17 + (i8 != 0 ? 0 : -1);
            }
            i12 = i16;
            i10 = i9;
        } else if (z) {
            i10 = ((i13 * this.segmentLength) + i8) - 1;
        } else {
            i10 = (i13 * this.segmentLength) + (i8 != 0 ? 0 : -1);
        }
        long j8 = j4 & M32L;
        return ((int) (i12 + ((i10 - 1) - ((i10 * ((j8 * j8) >>> 32)) >>> 32)))) % this.laneLength;
    }

    private int getRefLane(Position position, long j4) {
        int lanes = (int) ((j4 >>> 32) % this.parameters.getLanes());
        return (position.pass == 0 && position.slice == 0) ? position.lane : lanes;
    }

    private static int getStartingIndex(Position position) {
        return (position.pass == 0 && position.slice == 0) ? 2 : 0;
    }

    private void hash(byte[] bArr, byte[] bArr2, int i8, int i9) {
        byte[] bArr3 = new byte[4];
        Pack.intToLittleEndian(i9, bArr3, 0);
        if (i9 <= 64) {
            Blake2bDigest blake2bDigest = new Blake2bDigest(i9 * 8);
            blake2bDigest.update(bArr3, 0, 4);
            blake2bDigest.update(bArr, 0, bArr.length);
            blake2bDigest.doFinal(bArr2, i8);
            return;
        }
        Blake2bDigest blake2bDigest2 = new Blake2bDigest(512);
        byte[] bArr4 = new byte[64];
        blake2bDigest2.update(bArr3, 0, 4);
        blake2bDigest2.update(bArr, 0, bArr.length);
        blake2bDigest2.doFinal(bArr4, 0);
        System.arraycopy(bArr4, 0, bArr2, i8, 32);
        int i10 = i8 + 32;
        int i11 = 2;
        int i12 = ((i9 + 31) / 32) - 2;
        while (i11 <= i12) {
            blake2bDigest2.update(bArr4, 0, 64);
            blake2bDigest2.doFinal(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i10, 32);
            i11++;
            i10 += 32;
        }
        Blake2bDigest blake2bDigest3 = new Blake2bDigest((i9 - (i12 * 32)) * 8);
        blake2bDigest3.update(bArr4, 0, 64);
        blake2bDigest3.doFinal(bArr2, i10);
    }

    private void initAddressBlocks(FillBlock fillBlock, Position position, Block block, Block block2) {
        block.f4480v[0] = intToLong(position.pass);
        block.f4480v[1] = intToLong(position.lane);
        block.f4480v[2] = intToLong(position.slice);
        block.f4480v[3] = intToLong(this.memory.length);
        block.f4480v[4] = intToLong(this.parameters.getIterations());
        block.f4480v[5] = intToLong(this.parameters.getType());
        if (position.pass == 0 && position.slice == 0) {
            nextAddresses(fillBlock, block, block2);
        }
    }

    private void initialize(byte[] bArr, byte[] bArr2, int i8) {
        Blake2bDigest blake2bDigest = new Blake2bDigest(512);
        Pack.intToLittleEndian(new int[]{this.parameters.getLanes(), i8, this.parameters.getMemory(), this.parameters.getIterations(), this.parameters.getVersion(), this.parameters.getType()}, bArr, 0);
        blake2bDigest.update(bArr, 0, 24);
        addByteString(bArr, blake2bDigest, bArr2);
        addByteString(bArr, blake2bDigest, this.parameters.getSalt());
        addByteString(bArr, blake2bDigest, this.parameters.getSecret());
        addByteString(bArr, blake2bDigest, this.parameters.getAdditional());
        byte[] bArr3 = new byte[ARGON2_PREHASH_SEED_LENGTH];
        blake2bDigest.doFinal(bArr3, 0);
        fillFirstBlocks(bArr, bArr3);
    }

    private long intToLong(int i8) {
        return i8 & M32L;
    }

    private boolean isDataIndependentAddressing(Position position) {
        return this.parameters.getType() == 1 || (this.parameters.getType() == 2 && position.pass == 0 && position.slice < 2);
    }

    private boolean isWithXor(Position position) {
        return (position.pass == 0 || this.parameters.getVersion() == 16) ? false : true;
    }

    private void nextAddresses(FillBlock fillBlock, Block block, Block block2) {
        long[] jArr = block.f4480v;
        jArr[6] = jArr[6] + 1;
        fillBlock.fillBlock(block, block2);
        fillBlock.fillBlock(block2, block2);
    }

    private static void quarterRound(long[] jArr, int i8, int i9, int i10, int i11) {
        long j4 = jArr[i8];
        long j8 = jArr[i9];
        long j9 = jArr[i10];
        long jH = b.h((j4 & M32L) * 2, M32L & j8, j8, j4);
        long jRotateRight = Longs.rotateRight(j9 ^ jH, i11);
        jArr[i8] = jH;
        jArr[i10] = jRotateRight;
    }

    private void reset() {
        if (this.memory == null) {
            return;
        }
        int i8 = 0;
        while (true) {
            Block[] blockArr = this.memory;
            if (i8 >= blockArr.length) {
                return;
            }
            Block block = blockArr[i8];
            if (block != null) {
                block.clear();
            }
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void roundFunction(Block block, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23) {
        long[] jArr = block.f4480v;
        F(jArr, i8, i12, i16, i20);
        F(jArr, i9, i13, i17, i21);
        F(jArr, i10, i14, i18, i22);
        F(jArr, i11, i15, i19, i23);
        F(jArr, i8, i13, i18, i23);
        F(jArr, i9, i14, i19, i20);
        F(jArr, i10, i15, i16, i21);
        F(jArr, i11, i12, i17, i22);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2) {
        return generateBytes(bArr, bArr2, 0, bArr2.length);
    }

    public void init(Argon2Parameters argon2Parameters) {
        if (argon2Parameters.getVersion() != 16 && argon2Parameters.getVersion() != 19) {
            throw new UnsupportedOperationException("unknown Argon2 version");
        }
        if (argon2Parameters.getType() != 0 && argon2Parameters.getType() != 1 && argon2Parameters.getType() != 2) {
            throw new UnsupportedOperationException("unknown Argon2 type");
        }
        if (argon2Parameters.getLanes() < 1) {
            throw new IllegalStateException("lanes must be at least 1");
        }
        if (argon2Parameters.getLanes() > MAX_PARALLELISM) {
            throw new IllegalStateException("lanes must be at most 16777215");
        }
        if (argon2Parameters.getIterations() < 1) {
            throw new IllegalStateException("iterations is less than: 1");
        }
        this.parameters = argon2Parameters;
        int iMax = Math.max(argon2Parameters.getMemory(), argon2Parameters.getLanes() * 8) / (argon2Parameters.getLanes() * 4);
        this.segmentLength = iMax;
        this.laneLength = iMax * 4;
        this.memory = new Block[argon2Parameters.getLanes() * this.laneLength];
        int i8 = 0;
        while (true) {
            Block[] blockArr = this.memory;
            if (i8 >= blockArr.length) {
                return;
            }
            blockArr[i8] = new Block();
            i8++;
        }
    }

    public int generateBytes(byte[] bArr, byte[] bArr2, int i8, int i9) {
        if (i9 < 4) {
            throw new IllegalStateException("output length less than 4");
        }
        byte[] bArr3 = new byte[1024];
        initialize(bArr3, bArr, i9);
        fillMemoryBlocks();
        digest(bArr3, bArr2, i8, i9);
        reset();
        return i9;
    }

    public int generateBytes(char[] cArr, byte[] bArr) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr);
    }

    public int generateBytes(char[] cArr, byte[] bArr, int i8, int i9) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr, i8, i9);
    }
}
