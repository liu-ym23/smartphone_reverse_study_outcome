package androidx.profileinstaller;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
class ProfileTranscoder {
    private static final int FIRST_FLAG = 1;
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    private static final int LAST_FLAG = 4;
    static final byte[] MAGIC_PROF = null;
    static final byte[] MAGIC_PROFM = null;
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    static {
        MAGIC_PROF = new byte[]{112, 114, 111, 0};
        MAGIC_PROFM = new byte[]{112, 114, 109, 0};
    }

    private static int roundUpToByte(int r100) {
        return ((r100 + 8) - 1) & (-8);
    }

    private ProfileTranscoder() {
    }

    private static int computeMethodFlags(DexProfileData r100) {
        Iterator<Map.Entry<Integer, Integer>> r101 = r100.methods.entrySet().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 | r101.next().getValue().intValue();
        goto L4
    L6:
        return r102;
    }

    private static WritableFileSection createCompressibleClassSection(DexProfileData[] r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 0;
        int r103 = 0;
    L19:
    L13:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        if (r102 >= r100.length) goto L6;
        DexProfileData r104 = r100[r102];     // Catch: Throwable -> L13
        Encoding.writeUInt16(r101, r102);     // Catch: Throwable -> L13
        Encoding.writeUInt16(r101, r104.classSetSize);     // Catch: Throwable -> L13
        r103 = ((r103 + 2) + 2) + (r104.classSetSize * 2);     // Catch: Throwable -> L13
        writeClasses(r101, r104);     // Catch: Throwable -> L13
        r102 = r102 + 1;     // Catch: Throwable -> L13
        goto L19
    L6:
        byte[] r105 = r101.toByteArray();     // Catch: Throwable -> L13
        if (r103 != r105.length) goto L12;
        WritableFileSection r106 = new WritableFileSection(FileSectionType.CLASSES, r103, r105, true);     // Catch: Throwable -> L13
        r101.close();
        return r106;
    L12:
        throw Encoding.error("Expected size " + r103 + ", does not match actual size " + r105.length);     // Catch: Throwable -> L13
    }

    private static WritableFileSection createCompressibleMethodsSection(DexProfileData[] r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 0;
        int r103 = 0;
    L19:
    L13:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        if (r102 >= r100.length) goto L6;
        DexProfileData r104 = r100[r102];     // Catch: Throwable -> L13
        int r105 = computeMethodFlags(r104);     // Catch: Throwable -> L13
        byte[] r106 = createMethodBitmapRegionForS(r105, r104);     // Catch: Throwable -> L13
        byte[] r107 = createMethodsWithInlineCaches(r104);     // Catch: Throwable -> L13
        Encoding.writeUInt16(r101, r102);     // Catch: Throwable -> L13
        int r108 = (r106.length + 2) + r107.length;     // Catch: Throwable -> L13
        Encoding.writeUInt32(r101, r108);     // Catch: Throwable -> L13
        Encoding.writeUInt16(r101, r105);     // Catch: Throwable -> L13
        r101.write(r106);     // Catch: Throwable -> L13
        r101.write(r107);     // Catch: Throwable -> L13
        r103 = ((r103 + 2) + 4) + r108;     // Catch: Throwable -> L13
        r102 = r102 + 1;     // Catch: Throwable -> L13
        goto L19
    L6:
        byte[] r109 = r101.toByteArray();     // Catch: Throwable -> L13
        if (r103 != r109.length) goto L12;
        WritableFileSection r110 = new WritableFileSection(FileSectionType.METHODS, r103, r109, true);     // Catch: Throwable -> L13
        r101.close();
        return r110;
    L12:
        throw Encoding.error("Expected size " + r103 + ", does not match actual size " + r109.length);     // Catch: Throwable -> L13
    }

    private static byte[] createMethodsWithInlineCaches(DexProfileData r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        writeMethodsWithInlineCaches(r101, r100);     // Catch: Throwable -> L6
        byte[] r102 = r101.toByteArray();     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static String extractKey(String r100) {
        int r101 = r100.indexOf("!");
        if (r101 >= 0) goto L5;
        r101 = r100.indexOf(":");
    L5:
        if (r101 > 0) goto L7;
        return r100;
    L7:
        return r100.substring(r101 + 1);
    }

    private static int getMethodBitmapStorageSize(int r100) {
        return roundUpToByte(r100 * 2) / 8;
    }

    private static void skipInlineCache(InputStream r100) throws IOException {
        Encoding.readUInt16(r100);
        int r101 = Encoding.readUInt8(r100);
        if (r101 != 6) goto L6;
        return;
    L6:
        if (r101 != 7) goto L8;
        return;
    L8:
        if (r101 <= 0) goto L13;
        Encoding.readUInt8(r100);
        int r102 = Encoding.readUInt8(r100);
    L10:
        if (r102 <= 0) goto L12;
        Encoding.readUInt16(r100);
        r102 = r102 - 1;
        goto L10
    L12:
        r101 = r101 - 1;
        goto L8
    }

    private static WritableFileSection writeDexFileSection(DexProfileData[] r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        Encoding.writeUInt16(r101, r100.length);     // Catch: Throwable -> L14
        int r102 = 0;
        int r103 = 2;
    L5:
        if (r102 >= r100.length) goto L7;
        DexProfileData r104 = r100[r102];     // Catch: Throwable -> L14
        Encoding.writeUInt32(r101, r104.dexChecksum);     // Catch: Throwable -> L14
        Encoding.writeUInt32(r101, r104.mTypeIdCount);     // Catch: Throwable -> L14
        Encoding.writeUInt32(r101, r104.numMethodIds);     // Catch: Throwable -> L14
        String r105 = generateDexKey(r104.apkName, r104.dexName, ProfileVersion.V015_S);     // Catch: Throwable -> L14
        int r106 = Encoding.utf8Length(r105);     // Catch: Throwable -> L14
        Encoding.writeUInt16(r101, r106);     // Catch: Throwable -> L14
        r103 = ((((r103 + 4) + 4) + 4) + 2) + (r106 * 1);     // Catch: Throwable -> L14
        Encoding.writeString(r101, r105);     // Catch: Throwable -> L14
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L5
    L7:
        byte[] r107 = r101.toByteArray();     // Catch: Throwable -> L14
        if (r103 != r107.length) goto L13;
        WritableFileSection r108 = new WritableFileSection(FileSectionType.DEX_FILES, r103, r107, false);     // Catch: Throwable -> L14
        r101.close();
        return r108;
    L13:
        throw Encoding.error("Expected size " + r103 + ", does not match actual size " + r107.length);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    private static byte[] createCompressibleBody(DexProfileData[] r100, byte[] r101) throws IOException {
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L5;
        DexProfileData r106 = r100[r104];
        r105 = r105 + ((((Encoding.utf8Length(generateDexKey(r106.apkName, r106.dexName, r101)) + 16) + (r106.classSetSize * 2)) + r106.hotMethodRegionSize) + getMethodBitmapStorageSize(r106.numMethodIds));
        r104 = r104 + 1;
        goto L3
    L5:
        ByteArrayOutputStream r107 = new ByteArrayOutputStream(r105);
        if (Arrays.equals(r101, ProfileVersion.V009_O_MR1) == false) goto L10;
        int r108 = r100.length;
    L8:
        if (r103 >= r108) goto L17;
        DexProfileData r109 = r100[r103];
        writeLineHeader(r107, r109, generateDexKey(r109.apkName, r109.dexName, r101));
        writeLineData(r107, r109);
        r103 = r103 + 1;
    L17:
        if (r107.size() != r105) goto L21;
        return r107.toByteArray();
    L21:
        throw Encoding.error("The bytes saved do not match expectation. actual=" + r107.size() + " expected=" + r105);
    L10:
        int r110 = r100.length;
        int r111 = 0;
    L11:
        if (r111 >= r110) goto L13;
        DexProfileData r112 = r100[r111];
        writeLineHeader(r107, r112, generateDexKey(r112.apkName, r112.dexName, r101));
        r111 = r111 + 1;
        goto L11
    L13:
        int r113 = r100.length;
    L14:
        if (r103 >= r113) goto L17;
        writeLineData(r107, r100[r103]);
        r103 = r103 + 1;
        goto L14
    }

    private static byte[] createMethodBitmapRegionForS(int r100, DexProfileData r101) throws IOException {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        writeMethodBitmapForS(r102, r100, r101);     // Catch: Throwable -> L6
        byte[] r103 = r102.toByteArray();     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static String enforceSeparator(String r100, String r101) {
        if ("!".equals(r101) == false) goto L7;
        return r100.replace(":", "!");
    L7:
        if (":".equals(r101) == true) goto L9;
        return r100;
    L9:
        return r100.replace("!", ":");
    }

    private static DexProfileData findByDexName(DexProfileData[] r100, String r101) {
        if (r100.length > 0) goto L5;
        return null;
    L5:
        String r102 = extractKey(r101);
        int r103 = 0;
    L7:
        if (r103 >= r100.length) goto L13;
        if (r100[r103].dexName.equals(r102) == true) goto L11;
        r103 = r103 + 1;
        goto L7
    L11:
        return r100[r103];
    L13:
        return null;
    }

    private static int getMethodBitmapStorageSizeForS(int r100, int r101) {
        return roundUpToByte(Integer.bitCount(r100 & (-2)) * r101) / 8;
    }

    private static int[] readClasses(InputStream r100, int r101) throws IOException {
        int[] r102 = new int[r101];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r104 = r104 + Encoding.readUInt16(r100);
        r102[r103] = r104;
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static byte[] readHeader(InputStream r100, byte[] r101) throws IOException {
        if (Arrays.equals(r101, Encoding.read(r100, r101.length)) == false) goto L7;
        return Encoding.read(r100, ProfileVersion.V010_P.length);
    L7:
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(InputStream r100, DexProfileData r101) throws IOException {
        int r102 = r100.available() - r101.hotMethodRegionSize;
        int r103 = 0;
    L4:
        if (r100.available() <= r102) goto L9;
        r103 = r103 + Encoding.readUInt16(r100);
        r101.methods.put(Integer.valueOf(r103), 1);
        int r104 = Encoding.readUInt16(r100);
    L6:
        if (r104 <= 0) goto L4;
        skipInlineCache(r100);
        r104 = r104 - 1;
        goto L6
    L9:
        if (r100.available() != r102) goto L12;
        return;
    L12:
        throw Encoding.error("Read too much data during profile line parse");
    }

    private static void readMethodBitmap(InputStream r100, DexProfileData r101) throws IOException {
        BitSet r102 = BitSet.valueOf(Encoding.read(r100, Encoding.bitsToBytes(r101.numMethodIds * 2)));
        int r103 = 0;
    L3:
        int r104 = r101.numMethodIds;
        if (r103 >= r104) goto L12;
        int r105 = readFlagsFromBitmap(r102, r103, r104);
        if (r105 == 0) goto L11;
        Integer r106 = r101.methods.get(Integer.valueOf(r103));
        if (r106 != null) goto L10;
        r106 = 0;
    L10:
        r101.methods.put(Integer.valueOf(r103), Integer.valueOf(r105 | r106.intValue()));
    L11:
        r103 = r103 + 1;
        goto L3
    }

    private static void writeClasses(OutputStream r100, DexProfileData r101) throws IOException {
        int[] r102 = r101.classes;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Integer r106 = Integer.valueOf(r102[r104]);
        Encoding.writeUInt16(r100, r106.intValue() - r105);
        r105 = r106.intValue();
        r104 = r104 + 1;
        goto L3
    }

    public static void writeHeader(OutputStream r100, byte[] r101) throws IOException {
        r100.write(MAGIC_PROF);
        r100.write(r101);
    }

    private static void writeLineData(OutputStream r100, DexProfileData r101) throws IOException {
        writeMethodsWithInlineCaches(r100, r101);
        writeClasses(r100, r101);
        writeMethodBitmap(r100, r101);
    }

    private static void writeMethodBitmap(OutputStream r100, DexProfileData r101) throws IOException {
        byte[] r102 = new byte[getMethodBitmapStorageSize(r101.numMethodIds)];
        Iterator<Map.Entry<Integer, Integer>> r103 = r101.methods.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<Integer, Integer> r104 = r103.next();
        int r105 = r104.getKey().intValue();
        int r106 = r104.getValue().intValue();
        if ((r106 & 2) == 0) goto L9;
        setMethodBitmapBit(r102, 2, r105, r101);
    L9:
        if ((r106 & 4) == 0) goto L4;
        setMethodBitmapBit(r102, 4, r105, r101);
        goto L4
    L11:
        r100.write(r102);
    }

    private static void writeMethodsWithInlineCaches(OutputStream r100, DexProfileData r101) throws IOException {
        Iterator<Map.Entry<Integer, Integer>> r102 = r101.methods.entrySet().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<Integer, Integer> r104 = r102.next();
        int r105 = r104.getKey().intValue();
        if ((r104.getValue().intValue() & 1) == 0) goto L4;
        Encoding.writeUInt16(r100, r105 - r103);
        Encoding.writeUInt16(r100, 0);
        r103 = r105;
        goto L4
    }

    private static void writeProfileForN(OutputStream r100, DexProfileData[] r101) throws IOException {
        Encoding.writeUInt16(r100, r101.length);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        DexProfileData r104 = r101[r103];
        String r105 = generateDexKey(r104.apkName, r104.dexName, ProfileVersion.V001_N);
        Encoding.writeUInt16(r100, Encoding.utf8Length(r105));
        Encoding.writeUInt16(r100, r104.methods.size());
        Encoding.writeUInt16(r100, r104.classes.length);
        Encoding.writeUInt32(r100, r104.dexChecksum);
        Encoding.writeString(r100, r105);
        Iterator<Integer> r106 = r104.methods.keySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        Encoding.writeUInt16(r100, r106.next().intValue());
        goto L6
    L8:
        int[] r107 = r104.classes;
        int r108 = r107.length;
        int r109 = 0;
    L9:
        if (r109 >= r108) goto L11;
        Encoding.writeUInt16(r100, r107[r109]);
        r109 = r109 + 1;
        goto L9
    L11:
        r103 = r103 + 1;
        goto L3
    }

    private static void writeProfileForO(OutputStream r100, DexProfileData[] r101) throws IOException {
        Encoding.writeUInt8(r100, r101.length);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        DexProfileData r104 = r101[r103];
        int r105 = r104.methods.size() * 4;
        String r106 = generateDexKey(r104.apkName, r104.dexName, ProfileVersion.V005_O);
        Encoding.writeUInt16(r100, Encoding.utf8Length(r106));
        Encoding.writeUInt16(r100, r104.classes.length);
        Encoding.writeUInt32(r100, r105);
        Encoding.writeUInt32(r100, r104.dexChecksum);
        Encoding.writeString(r100, r106);
        Iterator<Integer> r107 = r104.methods.keySet().iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        Encoding.writeUInt16(r100, r107.next().intValue());
        Encoding.writeUInt16(r100, 0);
        goto L6
    L8:
        int[] r108 = r104.classes;
        int r109 = r108.length;
        int r110 = 0;
    L9:
        if (r110 >= r109) goto L11;
        Encoding.writeUInt16(r100, r108[r110]);
        r110 = r110 + 1;
        goto L9
    L11:
        r103 = r103 + 1;
        goto L3
    }

    private static void writeProfileForO_MR1(OutputStream r100, DexProfileData[] r101) throws IOException {
        byte[] r102 = createCompressibleBody(r101, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(r100, r101.length);
        Encoding.writeCompressed(r100, r102);
    }

    private static void writeProfileForP(OutputStream r100, DexProfileData[] r101) throws IOException {
        byte[] r102 = createCompressibleBody(r101, ProfileVersion.V010_P);
        Encoding.writeUInt8(r100, r101.length);
        Encoding.writeCompressed(r100, r102);
    }

    private static void writeProfileForS(OutputStream r100, DexProfileData[] r101) throws IOException {
        writeProfileSections(r100, r101);
    }

    private static void writeProfileSections(OutputStream r110, DexProfileData[] r111) throws IOException {
        ArrayList r100 = new ArrayList(3);
        ArrayList r101 = new ArrayList(3);
        r100.add(writeDexFileSection(r111));
        r100.add(createCompressibleClassSection(r111));
        r100.add(createCompressibleMethodsSection(r111));
        long r102 = ((((long) ProfileVersion.V015_S.length) + ((long) MAGIC_PROF.length)) + 4) + ((long) (r100.size() * 16));
        Encoding.writeUInt32(r110, r100.size());
        int r112 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r100.size()) goto L11;
        WritableFileSection r104 = (WritableFileSection) ListProtector.get(r100, r103);
        Encoding.writeUInt32(r110, r104.mType.getValue());
        Encoding.writeUInt32(r110, r102);
        if (r104.mNeedsCompression == false) goto L8;
        byte[] r105 = r104.mContents;
        long r106 = r105.length;
        byte[] r107 = Encoding.compress(r105);
        r101.add(r107);
        Encoding.writeUInt32(r110, r107.length);
        Encoding.writeUInt32(r110, r106);
        int r108 = r107.length;
    L9:
        r102 = r102 + ((long) r108);
        r103 = r103 + 1;
        goto L4
    L8:
        r101.add(r104.mContents);
        Encoding.writeUInt32(r110, r104.mContents.length);
        Encoding.writeUInt32(r110, 0);
        r108 = r104.mContents.length;
    L11:
        if (r112 >= r101.size()) goto L13;
        r110.write((byte[]) ListProtector.get(r101, r112));
        r112 = r112 + 1;
        goto L11
    }

    private static String generateDexKey(String r100, String r101, byte[] r102) {
        String r103 = ProfileVersion.dexKeySeparator(r102);
        if (r100.length() > 0) goto L7;
        return enforceSeparator(r101, r103);
    L7:
        if (r101.equals("classes.dex") == false) goto L10;
        return r100;
    L10:
        if (r101.contains("!") == true) goto L20;
        if (r101.contains(":") == true) goto L20;
        if (r101.endsWith(".apk") == false) goto L18;
        return r101;
    L18:
        return r100 + ProfileVersion.dexKeySeparator(r102) + r101;
    L20:
        return enforceSeparator(r101, r103);
    }

    private static int methodFlagBitmapIndex(int r100, int r101, int r102) {
        if (r100 == 1) goto L14;
        if (r100 != 2) goto L7;
        return r101;
    L7:
        if (r100 != 4) goto L11;
        return r101 + r102;
    L11:
        throw Encoding.error("Unexpected flag: " + r100);
    L14:
        throw Encoding.error("HOT methods are not stored in the bitmap");
    }

    private static int readFlagsFromBitmap(BitSet r100, int r101, int r102) {
        int r103 = 2;
        if (r100.get(methodFlagBitmapIndex(2, r101, r102)) == true) goto L7;
        r103 = 0;
    L7:
        if (r100.get(methodFlagBitmapIndex(4, r101, r102)) == true) goto L9;
        return r103;
    L9:
        return r103 | 4;
    }

    public static DexProfileData[] readMetadata001(InputStream r100, byte[] r101, DexProfileData[] r102) throws IOException {
        if (Arrays.equals(r101, ProfileVersion.METADATA_V001_N) == false) goto L19;
        int r103 = Encoding.readUInt8(r100);
        long r104 = Encoding.readUInt32(r100);
        byte[] r105 = Encoding.readCompressed(r100, (int) Encoding.readUInt32(r100), (int) r104);
        if (r100.read() > 0) goto L17;
        ByteArrayInputStream r106 = new ByteArrayInputStream(r105);
        DexProfileData[] r107 = readMetadataForNBody(r106, r103, r102);     // Catch: Throwable -> L10
        r106.close();
        return r107;
    L10:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw Encoding.error("Content found after the end of file");
    L19:
        throw Encoding.error("Unsupported meta version");
    }

    private static DexProfileData[] readMetadataForNBody(InputStream r100, int r101, DexProfileData[] r102) throws IOException {
        int r103 = 0;
        if (r100.available() != 0) goto L7;
        return new DexProfileData[0];
    L7:
        if (r101 != r102.length) goto L19;
        String[] r104 = new String[r101];
        int[] r105 = new int[r101];
        int r106 = 0;
    L9:
        if (r106 >= r101) goto L11;
        int r107 = Encoding.readUInt16(r100);
        r105[r106] = Encoding.readUInt16(r100);
        r104[r106] = Encoding.readString(r100, r107);
        r106 = r106 + 1;
    L11:
        if (r103 >= r101) goto L17;
        DexProfileData r108 = r102[r103];
        if (r108.dexName.equals(r104[r103]) == false) goto L16;
        int r109 = r105[r103];
        r108.classSetSize = r109;
        r108.classes = readClasses(r100, r109);
        r103 = r103 + 1;
        goto L11
    L16:
        throw Encoding.error("Order of dexfiles in metadata did not match baseline");
    L17:
        return r102;
    L19:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    public static DexProfileData[] readMetadataV002(InputStream r100, byte[] r101, DexProfileData[] r102) throws IOException {
        int r103 = Encoding.readUInt16(r100);
        long r104 = Encoding.readUInt32(r100);
        byte[] r105 = Encoding.readCompressed(r100, (int) Encoding.readUInt32(r100), (int) r104);
        if (r100.read() > 0) goto L15;
        ByteArrayInputStream r106 = new ByteArrayInputStream(r105);
        DexProfileData[] r107 = readMetadataV002Body(r106, r101, r103, r102);     // Catch: Throwable -> L8
        r106.close();
        return r107;
    L8:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    L15:
        throw Encoding.error("Content found after the end of file");
    }

    public static DexProfileData[] readProfile(InputStream r100, byte[] r101, String r102) throws IOException {
        if (Arrays.equals(r101, ProfileVersion.V010_P) == false) goto L19;
        int r103 = Encoding.readUInt8(r100);
        long r104 = Encoding.readUInt32(r100);
        byte[] r105 = Encoding.readCompressed(r100, (int) Encoding.readUInt32(r100), (int) r104);
        if (r100.read() > 0) goto L17;
        ByteArrayInputStream r106 = new ByteArrayInputStream(r105);
        DexProfileData[] r107 = readUncompressedBody(r106, r102, r103);     // Catch: Throwable -> L10
        r106.close();
        return r107;
    L10:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw Encoding.error("Content found after the end of file");
    L19:
        throw Encoding.error("Unsupported version");
    }

    private static DexProfileData[] readUncompressedBody(InputStream r210, String r211, int r212) throws IOException {
        int r100 = 0;
        if (r210.available() == 0) goto L5;
        DexProfileData[] r101 = new DexProfileData[r212];
        int r102 = 0;
    L7:
        if (r102 >= r212) goto L9;
        int r103 = Encoding.readUInt16(r210);
        int r110 = Encoding.readUInt16(r210);
        long r104 = Encoding.readUInt32(r210);
        long r105 = Encoding.readUInt32(r210);
        long r111 = Encoding.readUInt32(r210);
        r101[r102] = new DexProfileData(r211, Encoding.readString(r210, r103), r105, 0, r110, (int) r104, (int) r111, new int[r110], new TreeMap());
        r102 = r102 + 1;
    L9:
        if (r100 >= r212) goto L11;
        DexProfileData r106 = r101[r100];
        readHotMethodRegion(r210, r106);
        r106.classes = readClasses(r210, r106.classSetSize);
        readMethodBitmap(r210, r106);
        r100 = r100 + 1;
        goto L9
    L11:
        return r101;
    L5:
        return new DexProfileData[0];
    }

    public static boolean transcodeAndWriteBody(OutputStream r100, byte[] r101, DexProfileData[] r102) throws IOException {
        if (Arrays.equals(r101, ProfileVersion.V015_S) == false) goto L7;
        writeProfileForS(r100, r102);
        return true;
    L7:
        if (Arrays.equals(r101, ProfileVersion.V010_P) == false) goto L11;
        writeProfileForP(r100, r102);
        return true;
    L11:
        if (Arrays.equals(r101, ProfileVersion.V005_O) == false) goto L15;
        writeProfileForO(r100, r102);
        return true;
    L15:
        if (Arrays.equals(r101, ProfileVersion.V009_O_MR1) == false) goto L19;
        writeProfileForO_MR1(r100, r102);
        return true;
    L19:
        if (Arrays.equals(r101, ProfileVersion.V001_N) == false) goto L22;
        writeProfileForN(r100, r102);
        return true;
    L22:
        return false;
    }

    private static void writeLineHeader(OutputStream r100, DexProfileData r101, String r102) throws IOException {
        Encoding.writeUInt16(r100, Encoding.utf8Length(r102));
        Encoding.writeUInt16(r100, r101.classSetSize);
        Encoding.writeUInt32(r100, r101.hotMethodRegionSize);
        Encoding.writeUInt32(r100, r101.dexChecksum);
        Encoding.writeUInt32(r100, r101.numMethodIds);
        Encoding.writeString(r100, r102);
    }

    private static void writeMethodBitmapForS(OutputStream r110, int r111, DexProfileData r112) throws IOException {
        byte[] r100 = new byte[getMethodBitmapStorageSizeForS(r111, r112.numMethodIds)];
        Iterator<Map.Entry<Integer, Integer>> r101 = r112.methods.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        Map.Entry<Integer, Integer> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        int r104 = r102.getValue().intValue();
        int r105 = 0;
        int r106 = 1;
    L7:
        if (r106 > 4) goto L4;
        if (r106 == 1) goto L9;
        if ((r106 & r111) == 0) goto L9;
        if ((r106 & r104) != r106) goto L16;
        int r107 = (r112.numMethodIds * r105) + r103;
        int r108 = r107 / 8;
        int r109 = 1 << (r107 % 8);
        r100[r108] = (byte) (r109 | r100[r108]);
    L16:
        r105 = r105 + 1;
    L9:
        r106 = r106 << 1;
        goto L7
    L17:
        r110.write(r100);
    }

    public static DexProfileData[] readMeta(InputStream r100, byte[] r101, byte[] r102, DexProfileData[] r103) throws IOException {
        if (Arrays.equals(r101, ProfileVersion.METADATA_V001_N) == false) goto L11;
        if (Arrays.equals(ProfileVersion.V015_S, r102) == true) goto L9;
        return readMetadata001(r100, r101, r103);
    L9:
        throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
    L11:
        if (Arrays.equals(r101, ProfileVersion.METADATA_V002) == false) goto L15;
        return readMetadataV002(r100, r102, r103);
    L15:
        throw Encoding.error("Unsupported meta version");
    }

    private static DexProfileData[] readMetadataV002Body(InputStream r100, byte[] r101, int r102, DexProfileData[] r103) throws IOException {
        int r104 = 0;
        if (r100.available() != 0) goto L7;
        return new DexProfileData[0];
    L7:
        if (r102 != r103.length) goto L19;
    L8:
        if (r104 >= r102) goto L17;
        Encoding.readUInt16(r100);
        String r105 = Encoding.readString(r100, Encoding.readUInt16(r100));
        long r106 = Encoding.readUInt32(r100);
        int r107 = Encoding.readUInt16(r100);
        DexProfileData r108 = findByDexName(r103, r105);
        if (r108 == null) goto L16;
        r108.mTypeIdCount = r106;
        int[] r109 = readClasses(r100, r107);
        if (Arrays.equals(r101, ProfileVersion.V001_N) == false) goto L14;
        r108.classSetSize = r107;
        r108.classes = r109;
    L14:
        r104 = r104 + 1;
        goto L8
    L16:
        throw Encoding.error("Missing profile key: " + r105);
    L17:
        return r103;
    L19:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void setMethodBitmapBit(byte[] r100, int r101, int r102, DexProfileData r103) {
        int r104 = methodFlagBitmapIndex(r101, r102, r103.numMethodIds);
        int r105 = r104 / 8;
        int r106 = 1 << (r104 % 8);
        r100[r105] = (byte) (r106 | r100[r105]);
    }
}
