package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int r100, String r101, String r102, String r103);

    void visitIincInsn(int r100, int r101);

    void visitInsn(int r100);

    void visitIntInsn(int r100, int r101);

    void visitJumpInsn(int r100, Label r101);

    void visitLabel(Label r100);

    void visitLdcInsn(Object r100);

    void visitMaxs(int r100, int r101);

    void visitMethodInsn(int r100, String r101, String r102, String r103);

    void visitTypeInsn(int r100, String r101);

    void visitVarInsn(int r100, int r101);
}
