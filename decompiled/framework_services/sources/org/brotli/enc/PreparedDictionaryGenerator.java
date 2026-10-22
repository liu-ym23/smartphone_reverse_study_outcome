package org.brotli.enc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class PreparedDictionaryGenerator {
    private static final long HASH_MULTIPLIER = 2297779722762296275L;
    private static final int MAGIC = -558043680;

    private static class PreparedDictionaryImpl implements PreparedDictionary {
        private final ByteBuffer data;

        /* synthetic */ PreparedDictionaryImpl(ByteBuffer r1, PreparedDictionaryGeneratorIA r2) {
            this(r1);
        }

        private PreparedDictionaryImpl(ByteBuffer data) {
            this.data = data;
        }

        @Override // org.brotli.enc.PreparedDictionary
        public ByteBuffer getData() {
            return this.data;
        }
    }

    private PreparedDictionaryGenerator() {
    }

    public static PreparedDictionary generate(ByteBuffer src) {
        return generate(src, 17, 3, 40, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v12, types: [short] */
    /* JADX WARN: Type inference failed for: r9v13, types: [int] */
    /* JADX WARN: Type inference failed for: r9v15 */
    public static PreparedDictionary generate(ByteBuffer r38, int r39, int r40, int r41, int r42) {
        r38.clear();
        if (r42 > 12) goto L64;
        if (r39 >= 24) goto L62;
        if ((r39 - r40) >= 16) goto L60;
        int r6 = 1 << r42;
        int r7 = 1 << r39;
        int r8 = 1 << r40;
        int r9 = r8 - 1;
        int r10 = 64 - r39;
        long r11 = (-1) >>> (64 - r41);
        int r13 = r38.capacity();
        if (r13 < 8) goto L58;
        short[] r15 = new short[r7];
        int[] r14 = new int[r7];
        int[] r5 = new int[r13];
        long r18 = 0;
        int r4 = 0;
    L11:
        int[] r22 = r5;
        if (r4 >= 7) goto L14;
        int r23 = r4;
        r18 = r18 | ((((long) r38.get(r4)) & 255) << (r23 * 8));
        r4 = r23 + 1;
        r5 = r22;
        goto L11
    L14:
        long r12 = r18 << 8;
        int r19 = 0;
    L15:
        long r24 = r12;
        if ((r19 + 7) >= r13) goto L25;
        int r110 = r6;
        long r16 = (r24 >>> 8) | ((((long) r38.get(r19 + 7)) & 255) << 56);
        int r17 = (int) (((r16 & r11) * HASH_MULTIPLIER) >>> r10);
        short r20 = r15[r17];
        if (r20 != 0) goto L20;
        int r27 = -1;
    L21:
        r22[r19] = r27;
        r14[r17] = r19;
        int r21 = r20 + 1;
        r6 = r110;
        if (r21 <= r6) goto L24;
        r21 = r6;
    L24:
        r15[r17] = (short) r21;
        r19 = r19 + 1;
        r12 = r16;
        goto L15
    L20:
        r27 = r14[r17];
        goto L21
    L25:
        int[] r25 = new int[r8];
        int[] r26 = new int[r8];
        int r28 = 0;
        int r29 = 0;
    L26:
        if (r29 >= r8) goto L40;
        r25[r29] = r6;
    L28:
        boolean r111 = false;
        int r210 = r29;
        int r30 = r25[r210];
        int r211 = r6;
        int r31 = 0;
        int r212 = r9;
        int r32 = r210;
    L29:
        if (r32 >= r7) goto L36;
        int r213 = r32;
        short r33 = r15[r213];
        int r214 = r10;
        if (r31 >= 65535) goto L32;
        if (r33 <= r30) goto L35;
        r33 = r30;
    L35:
        r31 = r31 + r33;
        r32 = r213 + r8;
        r10 = r214;
        goto L29
    L32:
        r111 = true;
    L37:
        if (r111 == false) goto L38;
        r25[r210] = r25[r210] - 1;
        r29 = r210;
        r9 = r212;
        r6 = r211;
        r10 = r214;
        goto L28
    L38:
        r26[r210] = r31;
        r28 = r28 + r31;
        r29 = r210 + 1;
        r9 = r212;
        r6 = r211;
        r10 = r214;
        goto L26
    L36:
        r214 = r10;
        goto L37
    L40:
        int r215 = r9;
        int r34 = r8 * 4;
        int r35 = r7 * 2;
        int r112 = r28 * 4;
        ByteBuffer r36 = ByteBuffer.allocateDirect((((24 + r34) + r35) + r112) + r13);
        ByteBuffer r37 = r36.slice();
        r37.order(ByteOrder.nativeOrder());
        IntBuffer r43 = r37.asIntBuffer();
        r37.position(r37.position() + 24);
        IntBuffer r113 = r37.asIntBuffer();
        r37.position(r37.position() + r34);
        ShortBuffer r114 = r37.asShortBuffer();
        r37.position(r37.position() + r35);
        IntBuffer r115 = r37.asIntBuffer();
        r37.position(r37.position() + r112);
        ByteBuffer r116 = r37.slice();
        r43.put(0, MAGIC);
        r43.put(1, r28);
        r43.put(2, r13);
        r43.put(3, r41);
        r43.put(4, r39);
        r43.put(5, r40);
        int r44 = 0;
        int r45 = 0;
    L41:
        if (r45 >= r8) goto L43;
        r113.put(r45, r44);
        r44 = r44 + r26[r45];
        r26[r45] = 0;
        r45 = r45 + 1;
        goto L41
    L43:
        int r46 = 0;
    L44:
        if (r46 >= r7) goto L55;
        int r117 = r46 & r215;
        short r1 = r15[r46];
        int r2 = r1;
        if (r1 <= r25[r117]) goto L48;
        r2 = r25[r117];
    L48:
        if (r2 != 0) goto L50;
        r114.put(r46, -1);
    L54:
        r46 = r46 + 1;
        r44 = r44;
        goto L44
    L50:
        int r3 = r26[r117];
        r114.put(r46, (short) r3);
        int r47 = r3 + r113.get(r117);
        r26[r117] = r26[r117] + r2;
        int r48 = r14[r46];
        int r49 = 0;
    L51:
        if (r49 >= r2) goto L53;
        r115.put(r47, r48);
        r48 = r22[r48];
        r49 = r49 + 1;
        r47 = r47 + 1;
        goto L51
    L53:
        int r50 = r47 - 1;
        r115.put(r50, r115.get(r50) | Integer.MIN_VALUE);
        goto L54
    L55:
        r116.put(r38);
        return new PreparedDictionaryImpl(r36, null);
    L58:
        throw new IllegalArgumentException("src is too short");
    L60:
        throw new IllegalArgumentException("slotBits is too small");
    L62:
        throw new IllegalArgumentException("bucketBits is too big");
    L64:
        throw new IllegalArgumentException("blockBits is too big");
    }
}
