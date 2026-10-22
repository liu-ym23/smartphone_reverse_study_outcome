package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    private Options(ByteString[] r1, int[] r2) {
        this.byteStrings = r1;
        this.trie = r2;
    }

    public static Options of(ByteString... r10) {
        int r1 = 0;
        if (r10.length == 0) goto L5;
        ArrayList r6 = new ArrayList(Arrays.asList(r10));
        Collections.sort(r6);
        ArrayList r9 = new ArrayList();
        int r0 = 0;
    L8:
        if (r0 >= r6.size()) goto L10;
        r9.add(-1);
        r0 = r0 + 1;
        goto L8
    L10:
        int r2 = 0;
    L12:
        if (r2 >= r6.size()) goto L15;
        r9.set(Collections.binarySearch(r6, r10[r2]), Integer.valueOf(r2));
        r2 = r2 + 1;
        goto L12
    L15:
        if (((ByteString) r6.get(0)).size() == 0) goto L44;
        int r3 = 0;
    L18:
        if (r3 >= r6.size()) goto L34;
        ByteString r4 = (ByteString) r6.get(r3);
        int r5 = r3 + 1;
        int r7 = r5;
    L21:
        if (r7 >= r6.size()) goto L33;
        ByteString r8 = (ByteString) r6.get(r7);
        if (r8.startsWith(r4) == false) goto L33;
        if (r8.size() == r4.size()) goto L32;
        if (((Integer) r9.get(r7)).intValue() > ((Integer) r9.get(r3)).intValue()) goto L29;
        r7 = r7 + 1;
        goto L21
    L29:
        r6.remove(r7);
        r9.remove(r7);
        goto L21
    L32:
        throw new IllegalArgumentException("duplicate option: " + r8);
    L33:
        r3 = r5;
        goto L18
    L34:
        Buffer r11 = new Buffer();
        buildTrieRecursive(0, r11, 0, r6, 0, r6.size(), r9);
        int r12 = intCount(r11);
        int[] r13 = new int[r12];
    L35:
        if (r1 >= r12) goto L38;
        r13[r1] = r11.readInt();
        r1 = r1 + 1;
        goto L35
    L38:
        if (r11.exhausted() == false) goto L42;
        return new Options((ByteString[]) r10.clone(), r13);
    L42:
        throw new AssertionError();
    L44:
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    L5:
        return new Options(new ByteString[0], new int[]{0, -1});
    }

    private static void buildTrieRecursive(long r18, Buffer r20, int r21, List<ByteString> r22, int r23, int r24, List<Integer> r25) {
        if (r23 >= r24) goto L66;
        int r3 = r23;
    L5:
        if (r3 >= r24) goto L11;
        if (r22.get(r3).size() < r21) goto L10;
        r3 = r3 + 1;
        goto L5
    L10:
        throw new AssertionError();
    L11:
        ByteString r4 = r22.get(r23);
        ByteString r5 = r22.get(r24 - 1);
        if (r21 != r4.size()) goto L14;
        int r6 = r25.get(r23).intValue();
        int r2 = r23 + 1;
        int r7 = r2;
        int r8 = r6;
        r4 = r22.get(r2);
    L16:
        if (r4.getByte(r21) == r5.getByte(r21)) goto L47;
        int r9 = r7 + 1;
        int r10 = 1;
    L18:
        if (r9 >= r24) goto L23;
        if (r22.get(r9 - 1).getByte(r21) == r22.get(r9).getByte(r21)) goto L22;
        r10 = r10 + 1;
    L22:
        r9 = r9 + 1;
        goto L18
    L23:
        long r13 = ((r18 + ((long) intCount(r20))) + 2) + ((long) (r10 * 2));
        r20.writeInt(r10);
        r20.writeInt(r8);
        int r11 = r7;
    L24:
        if (r11 >= r24) goto L31;
        byte r12 = r22.get(r11).getByte(r21);
        if (r11 != r7) goto L28;
    L29:
        r20.writeInt(r12 & 255);
    L30:
        r11 = r11 + 1;
        goto L24
    L28:
        if (r12 == r22.get(r11 - 1).getByte(r21)) goto L30;
    L31:
        Buffer r14 = new Buffer();
        int r15 = r7;
    L32:
        if (r15 >= r24) goto L46;
        byte r16 = r22.get(r15).getByte(r21);
        int r17 = r15 + 1;
        int r19 = r17;
    L34:
        if (r19 >= r24) goto L39;
        if (r16 != r22.get(r19).getByte(r21)) goto L37;
        r19 = r19 + 1;
        goto L34
    L37:
        int r26 = r19;
    L40:
        if (r17 == r26) goto L42;
    L44:
        r20.writeInt((int) ((((long) intCount(r14)) + r13) * (-1)));
        buildTrieRecursive(r13, r14, r21 + 1, r22, r15, r26, r25);
    L45:
        r14 = r14;
        r15 = r26;
        goto L32
    L42:
        if ((r21 + 1) != r22.get(r15).size()) goto L44;
        r20.writeInt(r25.get(r15).intValue());
        goto L45
    L39:
        r26 = r24;
        goto L40
    L46:
        Buffer r110 = r14;
        r20.write(r110, r110.size());
        return;
    L47:
        int r27 = Math.min(r4.size(), r5.size());
        int r28 = 0;
        int r111 = r21;
    L48:
        if (r111 >= r27) goto L52;
        if (r4.getByte(r111) != r5.getByte(r111)) goto L52;
        r28 = r28 + 1;
        r111 = r111 + 1;
    L52:
        long r29 = 1 + (((r18 + ((long) intCount(r20))) + 2) + ((long) r28));
        r20.writeInt(-r28);
        r20.writeInt(r8);
        int r30 = r21;
    L53:
        int r31 = r21 + r28;
        if (r30 >= r31) goto L57;
        r20.writeInt(r4.getByte(r30) & 255);
        r30 = r30 + 1;
        goto L53
    L57:
        if ((r7 + 1) == r24) goto L59;
        Buffer r112 = new Buffer();
        r20.writeInt((int) ((((long) intCount(r112)) + r29) * (-1)));
        buildTrieRecursive(r29, r112, r31, r22, r7, r24, r25);
        r20.write(r112, r112.size());
        return;
    L59:
        if (r31 != r22.get(r7).size()) goto L62;
        r20.writeInt(r25.get(r7).intValue());
        return;
    L62:
        throw new AssertionError();
    L14:
        r8 = -1;
        r7 = r23;
        goto L16
    L66:
        throw new AssertionError();
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int r1) {
        return this.byteStrings[r1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer r4) {
        return (int) (r4.size() / 4);
    }
}
