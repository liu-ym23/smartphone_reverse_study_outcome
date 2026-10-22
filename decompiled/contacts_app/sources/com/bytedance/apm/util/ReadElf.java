package com.bytedance.apm.util;

import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ReadElf {
    private static final int EI_CLASS = 4;
    private static final int EI_DATA = 5;
    private static final int EI_NIDENT = 16;
    private static final int ELFCLASS32 = 1;
    private static final int ELFCLASS64 = 2;
    private static final int ELFDATA2LSB = 1;
    private static final int ELFDATA2MSB = 2;
    private static final byte[] ELFMAG = null;
    private static final int EM_386 = 3;
    private static final int EM_AARCH64 = 183;
    private static final int EM_ARM = 40;
    private static final int EM_MIPS = 8;
    private static final int EM_QDSP6 = 164;
    private static final int EM_X86_64 = 62;
    private static final int EV_CURRENT = 1;
    private static final long PT_LOAD = 1;
    private static final int SHT_DYNAMIC = 6;
    private static final int SHT_DYNSYM = 11;
    private static final int SHT_STRTAB = 3;
    private static final int SHT_SYMTAB = 2;
    private int mAddrSize;
    private final byte[] mBuffer;
    private long mDynStrOffset;
    private long mDynStrSize;
    private long mDynSymOffset;
    private long mDynSymSize;
    private Map<String, Symbol> mDynamicSymbols;
    private int mEndian;
    private final RandomAccessFile mFile;
    private boolean mIsDynamic;
    private boolean mIsPIE;
    private final String mPath;
    private long mShStrTabOffset;
    private long mShStrTabSize;
    private long mStrTabOffset;
    private long mStrTabSize;
    private long mSymTabOffset;
    private long mSymTabSize;
    private Map<String, Symbol> mSymbols;
    private int mType;

    public static class Symbol {
        public static final int STB_GLOBAL = 1;
        public static final int STB_HIPROC = 15;
        public static final int STB_LOCAL = 0;
        public static final int STB_LOPROC = 13;
        public static final int STB_WEAK = 2;
        public static final int STT_COMMON = 5;
        public static final int STT_FILE = 4;
        public static final int STT_FUNC = 2;
        public static final int STT_NOTYPE = 0;
        public static final int STT_OBJECT = 1;
        public static final int STT_SECTION = 3;
        public static final int STT_TLS = 6;
        public final int bind;
        public final String name;
        public final int type;

        Symbol(String r1, int r2) {
            this.name = r1;
            this.bind = (r2 >> 4) & 15;
            this.type = r2 & 15;
        }

        public String toString() {
            return "Symbol[" + this.name + SimContactsConstants.EMAIL_SEP + toBind() + SimContactsConstants.EMAIL_SEP + toType() + "]";
        }

        private String toBind() {
            int r0 = this.bind;
            if (r0 != 0) goto L5;
            return "LOCAL";
        L5:
            if (r0 != 1) goto L7;
            return "GLOBAL";
        L7:
            if (r0 != 2) goto L9;
            return "WEAK";
        L9:
            return "STB_??? (" + this.bind + ")";
        }

        private String toType() {
            switch(this.type) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            return "TLS";
        L8:
            return "COMMON";
        L10:
            return "FILE";
        L12:
            return "SECTION";
        L14:
            return "FUNC";
        L16:
            return "OBJECT";
        L18:
            return "NOTYPE";
        L5:
            return "STT_??? (" + this.type + ")";
        }
    }

    static {
        ELFMAG = new byte[]{127, 69, 76, 70};
    }

    public static ReadElf read(File r1) throws IOException {
        return new ReadElf(r1);
    }

    private ReadElf(File r5) throws IOException {
        this.mBuffer = new byte[512];
        this.mPath = r5.getPath();
        RandomAccessFile r0 = new RandomAccessFile(r5, "r");
        this.mFile = r0;
        if (r0.length() < 16) goto L7;
        readHeader();
        return;
    L7:
        throw new IllegalArgumentException("Too small to be an ELF file: " + r5);
    }

    public void close() {
        this.mFile.close();     // Catch: IOException -> L4
        return;
    }

    protected void finalize() throws Throwable {
        close();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    private void readHeader() throws IOException {
        this.mFile.seek(0);
        this.mFile.readFully(this.mBuffer, 0, 16);
        byte[] r0 = this.mBuffer;
        byte r1 = r0[0];
        byte[] r2 = ELFMAG;
        if (r1 != r2[0]) goto L54;
        if (r0[1] != r2[1]) goto L54;
        if (r0[2] != r2[2]) goto L54;
        if (r0[3] != r2[3]) goto L54;
        byte r5 = r0[4];
        if (r5 != 1) goto L13;
        this.mAddrSize = 4;
    L15:
        byte r3 = r0[5];
        this.mEndian = r3;
        if (r3 != 1) goto L46;
        this.mType = readHalf();
        int r4 = readHalf();
        if (r4 == 3) goto L27;
        if (r4 == 62) goto L27;
        if (r4 == EM_AARCH64) goto L27;
        if (r4 == 40) goto L27;
        if (r4 == 8) goto L27;
        if (r4 == EM_QDSP6) goto L27;
        throw new IOException("Invalid ELF e_machine: " + r4 + ": " + this.mPath);
    L27:
        if (r4 != 3) goto L29;
        if (r5 == 1) goto L29;
    L39:
        throw new IOException("Invalid e_machine/EI_CLASS ELF combination: " + r4 + LibrarianImpl.Constants.SEPARATOR + r5 + ": " + this.mPath);
    L29:
        if (r4 != 62) goto L31;
        if (r5 != 2) goto L39;
    L31:
        if (r4 != EM_AARCH64) goto L33;
        if (r5 != 2) goto L39;
    L33:
        if (r4 != 40) goto L35;
        if (r5 != 1) goto L39;
    L35:
        if (r4 != EM_QDSP6) goto L40;
        if (r5 != 1) goto L39;
    L40:
        long r6 = readWord();
        if (r6 != 1) goto L45;
        readAddr();
        readOff();
        long r9 = readOff();
        readWord();
        readHalf();
        readHalf();
        readHalf();
        readSectionHeaders(r9, readHalf(), readHalf(), readHalf());
        return;
    L45:
        throw new IOException("Invalid e_version: " + r6 + ": " + this.mPath);
    L46:
        if (r3 != 2) goto L50;
        throw new IOException("Unsupported ELFDATA2MSB file: " + this.mPath);
    L50:
        throw new IOException("Invalid ELF EI_DATA: " + this.mEndian + ": " + this.mPath);
    L13:
        if (r5 != 2) goto L52;
        this.mAddrSize = 8;
        goto L15
    L52:
        throw new IOException("Invalid ELF EI_CLASS: " + r5 + ": " + this.mPath);
    L54:
        throw new IllegalArgumentException("Invalid ELF file: " + this.mPath);
    }

    private void readSectionHeaders(long r17, int r19, int r20, int r21) throws IOException {
        this.mFile.seek(r17 + ((long) (r21 * r20)));
        readWord();
        long r2 = readWord();
        readX(this.mAddrSize);
        readAddr();
        long r4 = readOff();
        long r6 = readX(this.mAddrSize);
        if (r2 != 3) goto L5;
        this.mShStrTabOffset = r4;
        this.mShStrTabSize = r6;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r19) goto L32;
        if (r3 == r21) goto L31;
        this.mFile.seek(r17 + ((long) (r3 * r20)));
        long r5 = readWord();
        long r7 = readWord();
        readX(this.mAddrSize);
        readAddr();
        long r10 = readOff();
        long r12 = readX(this.mAddrSize);
        if (r7 != 2) goto L12;
    L25:
        String r8 = readShStrTabEntry(r5);
        if (".symtab".equals(r8) == false) goto L29;
        this.mSymTabOffset = r10;
        this.mSymTabSize = r12;
        goto L31
    L29:
        if (".dynsym".equals(r8) == false) goto L31;
        this.mDynSymOffset = r10;
        this.mDynSymSize = r12;
        goto L31
    L12:
        if (r7 == 11) goto L25;
        if (r7 != 3) goto L23;
        String r9 = readShStrTabEntry(r5);
        if (".strtab".equals(r9) == false) goto L20;
        this.mStrTabOffset = r10;
        this.mStrTabSize = r12;
        goto L31
    L20:
        if (".dynstr".equals(r9) == false) goto L31;
        this.mDynStrOffset = r10;
        this.mDynStrSize = r12;
        goto L31
    L23:
        if (r7 != 6) goto L31;
        this.mIsDynamic = true;
    L31:
        r3 = r3 + 1;
        goto L6
    }

    private String readShStrTabEntry(long r6) throws IOException {
        long r0 = this.mShStrTabOffset;
        if (r0 != 0) goto L5;
        return null;
    L5:
        if (r6 >= 0) goto L7;
        return null;
    L7:
        if (r6 < this.mShStrTabSize) goto L10;
        return null;
    L10:
        return readString(r0 + r6);
    }

    private String readStrTabEntry(long r4, long r6, long r8) throws IOException {
        if (r4 != 0) goto L5;
        return null;
    L5:
        if (r8 >= 0) goto L7;
        return null;
    L7:
        if (r8 < r6) goto L10;
        return null;
    L10:
        return readString(r4 + r8);
    }

    private int readHalf() throws IOException {
        return (int) readX(2);
    }

    private long readWord() throws IOException {
        return readX(4);
    }

    private long readOff() throws IOException {
        return readX(this.mAddrSize);
    }

    private long readAddr() throws IOException {
        return readX(this.mAddrSize);
    }

    private long readX(int r4) throws IOException {
        int r2 = 0;
        this.mFile.readFully(this.mBuffer, 0, r4);
        if (this.mEndian != 1) goto L7;
        int r5 = r4 - 1;
    L5:
        if (r5 < 0) goto L12;
        r2 = (r2 << 8) | (this.mBuffer[r5] & 255);
        r5 = r5 - 1;
    L12:
        return r2;
    L7:
        int r6 = r4 - 1;
        int r0 = 0;
    L8:
        if (r2 > r6) goto L10;
        r0 = (r0 << 8) | (this.mBuffer[r2] & 255);
        r2 = r2 + 1;
        goto L8
    L10:
        r2 = r0;
        goto L12
    }

    private String readString(long r9) throws IOException {
        long r0 = this.mFile.getFilePointer();
        this.mFile.seek(r9);
        RandomAccessFile r2 = this.mFile;
        byte[] r3 = this.mBuffer;
        r2.readFully(r3, 0, (int) Math.min(r3.length, r2.length() - r9));
        this.mFile.seek(r0);
        int r10 = 0;
    L3:
        byte[] r1 = this.mBuffer;
        if (r10 >= r1.length) goto L10;
        if (r1[r10] == 0) goto L8;
        r10 = r10 + 1;
        goto L3
    L8:
        return new String(this.mBuffer, 0, r10);
    L10:
        return null;
    }

    private int readByte() throws IOException {
        return this.mFile.read() & 255;
    }

    public static boolean hasFuncSymbolInFile(File r4, String r5) throws IOException {
        ReadElf r6 = read(r4);
        if (Math.max(r6.mSymTabSize, r6.mStrTabSize) > 200000) goto L5;
        boolean r7 = r6.hasFuncSymbolQuick(r5);
    L6:
        r6.close();
        return r7;
    L5:
        r7 = r6.hasFuncSymbol(r5);
        goto L6
    }

    private boolean hasFuncSymbol(String r9) throws IOException {
        this.mFile.seek(this.mSymTabOffset);
    L4:
        if (this.mFile.getFilePointer() >= (this.mSymTabOffset + this.mSymTabSize)) goto L18;
        long r6 = readWord();
        if (this.mAddrSize != 8) goto L8;
        int r0 = readByte();
        readByte();
        readHalf();
        readAddr();
        readX(this.mAddrSize);
    L10:
        if (r6 == 0) goto L4;
        String r1 = readStrTabEntry(this.mStrTabOffset, this.mStrTabSize, r6);
        if (TextUtils.equals(r9, r1) == false) goto L4;
        if (new Symbol(r1, r0).type != 2) goto L4;
        return true;
    L8:
        readAddr();
        readWord();
        r0 = readByte();
        readByte();
        readHalf();
        goto L10
    L18:
        return false;
    }

    private boolean hasFuncSymbolQuick(String r13) throws IOException {
        HashSet r0 = new HashSet();
        byte[] r1 = new byte[(int) Math.max(this.mSymTabSize, this.mStrTabSize)];
        this.mFile.seek(this.mSymTabOffset);
        this.mFile.readFully(r1, 0, (int) this.mSymTabSize);
        int r2 = 0;
    L4:
        if (r2 >= this.mSymTabSize) goto L16;
        long r6 = readWord(r1, r2);
        int r3 = r2 + 4;
        int r4 = this.mAddrSize;
        if (r4 != 8) goto L8;
        int r5 = readByte(r1, r3);
        int r7 = this.mAddrSize;
        r2 = (r3 + 1) + ((r7 + 3) + r7);
    L10:
        if (r6 == 0) goto L4;
        if ((r5 & 15) != 2) goto L4;
        r0.add(Long.valueOf(r6));
        goto L4
    L8:
        int r8 = r3 + (r4 + 4);
        r5 = readByte(r1, r8);
        r2 = (r8 + 1) + 3;
        goto L10
    L16:
        this.mFile.seek(this.mStrTabOffset);
        this.mFile.readFully(r1, 0, (int) this.mStrTabSize);
        byte[] r14 = r13.getBytes();
        int r9 = r14.length;
        Iterator r10 = r0.iterator();
    L18:
        if (r10.hasNext() == false) goto L31;
        Long r11 = (Long) r10.next();
        int r12 = 0;
    L20:
        if (r12 >= r9) goto L27;
        int r15 = (int) (((long) r12) + r11.longValue());
        if (r15 >= this.mStrTabSize) goto L27;
        if (r1[r15] != r14[r12]) goto L27;
        r12 = r12 + 1;
    L27:
        if (r12 != r9) goto L18;
        if (r1[(int) (((long) r12) + r11.longValue())] != 0) goto L18;
        return true;
    L31:
        return false;
    }

    private int readByte(byte[] r1, int r2) {
        return r1[r2] & 255;
    }

    private long readWord(byte[] r2, int r3) throws IOException {
        return readX(4, r2, r3);
    }

    private long readX(int r3, byte[] r4, int r5) throws IOException {
        int r0 = 0;
        if (this.mEndian != 1) goto L7;
        int r6 = r3 - 1;
    L5:
        if (r6 < 0) goto L12;
        r0 = (r4[r6 + r5] & 255) | (r0 << 8);
        r6 = r6 - 1;
    L12:
        return r0;
    L7:
        int r7 = r3 - 1;
        int r2 = 0;
    L8:
        if (r0 > r7) goto L10;
        r2 = (r2 << 8) | (r4[r0 + r5] & 255);
        r0 = r0 + 1;
        goto L8
    L10:
        r0 = r2;
        goto L12
    }
}
