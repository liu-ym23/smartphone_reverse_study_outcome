package com.alibaba.fastjson.asm;

import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes28.dex */
public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code;

    /* JADX INFO: renamed from: cw, reason: collision with root package name */
    final ClassWriter f24932cw;
    private final int desc;
    int exceptionCount;
    int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    MethodWriter next;

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }

    public final int getSize() {
        if (this.code.length <= 0) goto L5;
        this.f24932cw.newUTF8("Code");
        int r100 = ((this.code.length + 18) + 0) + 8;
    L7:
        if (this.exceptionCount <= 0) goto L10;
        this.f24932cw.newUTF8("Exceptions");
        return r100 + ((this.exceptionCount * 2) + 8);
    L10:
        return r100;
    L5:
        r100 = 8;
        goto L7
    }

    public final void put(ByteVector r100) {
        r100.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int r101 = 0;
        if (this.code.length <= 0) goto L5;
        int r102 = 1;
    L7:
        if (this.exceptionCount <= 0) goto L9;
        r102 = r102 + 1;
    L9:
        r100.putShort(r102);
        int r103 = this.code.length;
        if (r103 <= 0) goto L13;
        ByteVector r104 = r100.putShort(this.f24932cw.newUTF8("Code"));
        r104.putInt((r103 + 12) + 0);
        r100.putShort(this.maxStack).putShort(this.maxLocals);
        ByteVector r105 = r100.putInt(this.code.length);
        ByteVector r106 = this.code;
        r105.putByteArray(r106.data, 0, r106.length);
        r100.putShort(0);
        r100.putShort(0);
    L13:
        if (this.exceptionCount <= 0) goto L18;
        r100.putShort(this.f24932cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
        r100.putShort(this.exceptionCount);
    L16:
        if (r101 >= this.exceptionCount) goto L20;
        r100.putShort(this.exceptions[r101]);
        r101 = r101 + 1;
        goto L16
    L20:
        return;
    L18:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int r100) {
        this.code.putByte(r100);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label r100) {
        ByteVector r101 = this.code;
        r100.resolve(this, r101.length, r101.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object r100) {
        Item r101 = this.f24932cw.newConstItem(r100);
        int r102 = r101.index;
        int r103 = r101.type;
        if (r103 != 5) goto L5;
    L11:
        this.code.put12(20, r102);
        return;
    L5:
        if (r103 == 6) goto L11;
        if (r102 < 256) goto L10;
        this.code.put12(19, r102);
        return;
    L10:
        this.code.put11(18, r102);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int r100, int r101) {
        this.code.putByte(132).put11(r100, r101);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int r100, int r101) {
        this.code.put11(r100, r101);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int r100, Label r101) {
        if ((r101.status & 2) != 0) goto L5;
    L9:
        this.code.putByte(r100);
        ByteVector r102 = this.code;
        boolean r103 = true;
        int r104 = r102.length - 1;
        if (r100 == 200) goto L13;
        r103 = false;
    L13:
        r101.put(this, r102, r104, r103);
        return;
    L5:
        if ((r101.position - this.code.length) >= (-32768)) goto L9;
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int r100, int r101) {
        this.maxStack = r100;
        this.maxLocals = r101;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int r100, String r101) {
        Item r102 = this.f24932cw.newClassItem(r101);
        this.code.put12(r100, r102.index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int r100, int r101) {
        if (r101 >= 4) goto L12;
        if (r100 == 169) goto L12;
        if (r100 >= 54) goto L9;
        int r102 = ((r100 - 21) << 2) + 26;
    L10:
        this.code.putByte(r102 + r101);
        return;
    L9:
        r102 = ((r100 - 54) << 2) + 59;
    L12:
        if (r101 < 256) goto L14;
        this.code.putByte(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE).put12(r100, r101);
        return;
    L14:
        this.code.put11(r100, r101);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int r100, String r101, String r102, String r103) {
        Item r104 = this.f24932cw.newFieldItem(r101, r102, r103);
        this.code.put12(r100, r104.index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int r100, String r101, String r102, String r103) {
        if (r100 != 185) goto L5;
        boolean r104 = true;
    L6:
        Item r105 = this.f24932cw.newMethodItem(r101, r102, r103, r104);
        int r106 = r105.intVal;
        if (r104 == false) goto L11;
        if (r106 != 0) goto L10;
        r106 = Type.getArgumentsAndReturnSizes(r103);
        r105.intVal = r106;
    L10:
        this.code.put12(185, r105.index).put11(r106 >> 2, 0);
        return;
    L11:
        this.code.put12(r100, r105.index);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public MethodWriter(ClassWriter r100, int r101, String r102, String r103, String r104, String[] r105) {
        this.code = new ByteVector();
        if (r100.firstMethod != null) goto L5;
        r100.firstMethod = this;
    L6:
        r100.lastMethod = this;
        this.f24932cw = r100;
        this.access = r101;
        this.name = r100.newUTF8(r102);
        this.desc = r100.newUTF8(r103);
        if (r105 != null) goto L9;
        return;
    L9:
        if (r105.length <= 0) goto L16;
        int r106 = r105.length;
        this.exceptionCount = r106;
        this.exceptions = new int[r106];
        int r107 = 0;
    L12:
        if (r107 >= this.exceptionCount) goto L17;
        this.exceptions[r107] = r100.newClassItem(r105[r107]).index;
        r107 = r107 + 1;
        goto L12
    L17:
        return;
    L16:
        return;
    L5:
        r100.lastMethod.next = this;
        goto L6
    }
}
