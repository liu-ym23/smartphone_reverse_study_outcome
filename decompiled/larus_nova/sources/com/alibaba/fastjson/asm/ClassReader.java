package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class ClassReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f24931b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private boolean readAnnotations;
    private final String[] strings;

    private int getAttributes() {
        int r100 = this.header;
        int r101 = (r100 + 8) + (readUnsignedShort(r100 + 6) * 2);
        int r102 = readUnsignedShort(r101);
    L3:
        if (r102 <= 0) goto L8;
        int r103 = readUnsignedShort(r101 + 8);
    L5:
        if (r103 <= 0) goto L7;
        r101 = r101 + (readInt(r101 + 12) + 6);
        r103 = r103 - 1;
        goto L5
    L7:
        r101 = r101 + 8;
        r102 = r102 - 1;
        goto L3
    L8:
        int r104 = r101 + 2;
        int r105 = readUnsignedShort(r104);
    L9:
        if (r105 <= 0) goto L15;
        int r106 = readUnsignedShort(r104 + 8);
    L11:
        if (r106 <= 0) goto L13;
        r104 = r104 + (readInt(r104 + 12) + 6);
        r106 = r106 - 1;
        goto L11
    L13:
        r104 = r104 + 8;
        r105 = r105 - 1;
        goto L9
    L15:
        return r104 + 2;
    }

    private int readInt(int r100) {
        byte[] r101 = this.f24931b;
        int r102 = (((r101[r100] & UByte.MAX_VALUE) << 24) | ((r101[r100 + 1] & UByte.MAX_VALUE) << 16)) | ((r101[r100 + 2] & UByte.MAX_VALUE) << 8);
        return (r101[r100 + 3] & UByte.MAX_VALUE) | r102;
    }

    private int readUnsignedShort(int r100) {
        byte[] r101 = this.f24931b;
        int r102 = (r101[r100] & UByte.MAX_VALUE) << 8;
        return (r101[r100 + 1] & UByte.MAX_VALUE) | r102;
    }

    public void accept(TypeCollector r100) {
        char[] r101 = new char[this.maxStringLength];
        int r102 = 0;
        if (this.readAnnotations == false) goto L10;
        int r103 = getAttributes();
        int r104 = readUnsignedShort(r103);
    L5:
        if (r104 <= 0) goto L10;
        if ("RuntimeVisibleAnnotations".equals(readUTF8(r103 + 2, r101)) == true) goto L8;
        r103 = r103 + (readInt(r103 + 4) + 6);
        r104 = r104 - 1;
        goto L5
    L8:
        int r105 = r103 + 8;
    L11:
        int r106 = this.header;
        int r107 = readUnsignedShort(r106 + 6);
        int r108 = r106 + 8;
    L12:
        if (r102 >= r107) goto L14;
        r108 = r108 + 2;
        r102 = r102 + 1;
        goto L12
    L14:
        int r109 = readUnsignedShort(r108);
        int r110 = r108 + 2;
        int r111 = r110;
    L15:
        if (r109 <= 0) goto L20;
        int r112 = readUnsignedShort(r111 + 6);
        r111 = r111 + 8;
    L17:
        if (r112 <= 0) goto L19;
        r111 = r111 + (readInt(r111 + 2) + 6);
        r112 = r112 - 1;
        goto L17
    L19:
        r109 = r109 - 1;
        goto L15
    L20:
        int r113 = readUnsignedShort(r111);
        int r114 = r111 + 2;
    L21:
        if (r113 <= 0) goto L26;
        int r115 = readUnsignedShort(r114 + 6);
        r114 = r114 + 8;
    L23:
        if (r115 <= 0) goto L25;
        r114 = r114 + (readInt(r114 + 2) + 6);
        r115 = r115 - 1;
        goto L23
    L25:
        r113 = r113 - 1;
        goto L21
    L26:
        int r116 = readUnsignedShort(r114);
        int r117 = r114 + 2;
    L27:
        if (r116 <= 0) goto L29;
        r117 = r117 + (readInt(r117 + 2) + 6);
        r116 = r116 - 1;
        goto L27
    L29:
        if (r105 == 0) goto L33;
        int r118 = readUnsignedShort(r105);
        int r119 = r105 + 2;
    L31:
        if (r118 <= 0) goto L33;
        r100.visitAnnotation(readUTF8(r119, r101));
        r118 = r118 - 1;
    L33:
        int r120 = readUnsignedShort(r108);
    L34:
        if (r120 <= 0) goto L39;
        int r121 = readUnsignedShort(r110 + 6);
        r110 = r110 + 8;
    L36:
        if (r121 <= 0) goto L38;
        r110 = r110 + (readInt(r110 + 2) + 6);
        r121 = r121 - 1;
        goto L36
    L38:
        r120 = r120 - 1;
        goto L34
    L39:
        int r122 = readUnsignedShort(r110);
        int r123 = r110 + 2;
    L40:
        if (r122 <= 0) goto L42;
        r123 = readMethod(r100, r101, r123);
        r122 = r122 - 1;
        goto L40
    L42:
        return;
    L10:
        r105 = 0;
        goto L11
    }

    public ClassReader(InputStream r100, boolean r110) throws IOException {
        this.readAnnotations = r110;
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();
        byte[] r101 = new byte[1024];
    L3:
        int r102 = r100.read(r101);
        int r103 = 0;
        if (r102 == (-1)) goto L5;
        if (r102 <= 0) goto L3;
        r111.write(r101, 0, r102);
        goto L3
    L5:
        r100.close();
        this.f24931b = r111.toByteArray();
        int[] r104 = new int[readUnsignedShort(8)];
        this.items = r104;
        int r105 = r104.length;
        this.strings = new String[r105];
        int r106 = 10;
        int r107 = 1;
    L6:
        if (r107 >= r105) goto L27;
        int r108 = r106 + 1;
        this.items[r107] = r108;
        byte r109 = this.f24931b[r106];
        int r112 = 3;
        if (r109 != 1) goto L10;
        r112 = 3 + readUnsignedShort(r108);
        if (r112 <= r103) goto L26;
        r103 = r112;
    L26:
        r106 = r106 + r112;
        r107 = r107 + 1;
        goto L6
    L10:
        if (r109 != 15) goto L12;
        r112 = 4;
        goto L26
    L12:
        if (r109 == 18) goto L21;
        if (r109 == 3) goto L21;
        if (r109 == 4) goto L21;
        if (r109 != 5) goto L17;
    L20:
        r107 = r107 + 1;
        r112 = 9;
        goto L26
    L17:
        if (r109 == 6) goto L20;
        switch(r109) {
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L21;
            case 12: goto L21;
            default: goto L26;
        };
    L21:
        r112 = 5;
        goto L26
    L27:
        this.maxStringLength = r103;
        this.header = r106;
    }

    private String readUTF8(int r100, char[] r101) {
        int r102 = readUnsignedShort(r100);
        String[] r103 = this.strings;
        String r104 = r103[r102];
        if (r104 == null) goto L5;
        return r104;
    L5:
        int r105 = this.items[r102];
        String r106 = readUTF(r105 + 2, readUnsignedShort(r105), r101);
        r103[r102] = r106;
        return r106;
    }

    private int readMethod(TypeCollector r110, char[] r111, int r112) {
        int r100 = readUnsignedShort(r112);
        String r101 = readUTF8(r112 + 2, r111);
        String r102 = readUTF8(r112 + 4, r111);
        int r103 = readUnsignedShort(r112 + 6);
        int r113 = r112 + 8;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r103 <= 0) goto L8;
        String r106 = readUTF8(r113, r111);
        int r107 = readInt(r113 + 2);
        int r114 = r113 + 6;
        if (r106.equals("Code") == false) goto L7;
        r105 = r114;
    L7:
        r113 = r114 + r107;
        r103 = r103 - 1;
        goto L3
    L8:
        MethodCollector r115 = r110.visitMethod(r100, r101, r102);
        if (r115 == null) goto L31;
        if (r105 == 0) goto L31;
        int r108 = (r105 + 8) + readInt(r105 + 4);
        int r109 = readUnsignedShort(r108);
        int r116 = r108 + 2;
    L12:
        if (r109 <= 0) goto L14;
        r116 = r116 + 8;
        r109 = r109 - 1;
        goto L12
    L14:
        int r117 = readUnsignedShort(r116);
        int r118 = r116 + 2;
        int r119 = 0;
    L15:
        if (r117 <= 0) goto L23;
        String r120 = readUTF8(r118, r111);
        if (r120.equals("LocalVariableTable") == false) goto L20;
        r104 = r118 + 6;
    L22:
        r118 = r118 + (readInt(r118 + 2) + 6);
        r117 = r117 - 1;
        goto L15
    L20:
        if (r120.equals("LocalVariableTypeTable") == false) goto L22;
        r119 = r118 + 6;
        goto L22
    L23:
        if (r104 == 0) goto L31;
        if (r119 == 0) goto L28;
        int r121 = readUnsignedShort(r119) * 3;
        int r122 = r119 + 2;
        int[] r123 = new int[r121];
    L26:
        if (r121 <= 0) goto L28;
        int r124 = r121 - 1;
        r123[r124] = r122 + 6;
        int r125 = r124 - 1;
        r123[r125] = readUnsignedShort(r122 + 8);
        r121 = r125 - 1;
        r123[r121] = readUnsignedShort(r122);
        r122 = r122 + 10;
    L28:
        int r126 = readUnsignedShort(r104);
        int r127 = r104 + 2;
    L29:
        if (r126 <= 0) goto L31;
        r115.visitLocalVariable(readUTF8(r127 + 4, r111), readUnsignedShort(r127 + 8));
        r127 = r127 + 10;
        r126 = r126 - 1;
    L31:
        return r113;
    }

    private String readUTF(int r110, int r111, char[] r112) {
        int r113 = r111 + r110;
        byte[] r100 = this.f24931b;
        int r101 = 0;
        char r102 = 0;
        char r103 = 0;
    L3:
        if (r110 >= r113) goto L23;
        int r104 = r110 + 1;
        byte r114 = r100[r110];
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L21;
        int r115 = r114 & 63;
        int r116 = r115 | (r103 << 6);
    L10:
        r103 = (char) r116;
        r102 = 1;
    L21:
        r110 = r104;
        goto L3
    L11:
        int r117 = r114 & 63;
        r112[r101] = (char) (r117 | (r103 << 6));
        r101 = r101 + 1;
        r102 = 0;
        goto L21
    L12:
        int r118 = r114 & UByte.MAX_VALUE;
        if (r118 >= 128) goto L16;
        r112[r101] = (char) r118;
        r101 = r101 + 1;
        goto L21
    L16:
        if (r118 < 224) goto L18;
    L20:
        r103 = (char) (r118 & 15);
        r102 = 2;
        goto L21
    L18:
        if (r118 <= 191) goto L20;
        r116 = r118 & 31;
        goto L10
    L23:
        return new String(r112, 0, r101);
    }
}
