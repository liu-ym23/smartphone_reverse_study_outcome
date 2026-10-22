package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
public final class FieldWriter {
    private final int access;
    private final int desc;
    private final int name;
    FieldWriter next;

    public int getSize() {
        return 8;
    }

    public void visitEnd() {
    }

    public void put(ByteVector r100) {
        r100.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        r100.putShort(0);
    }

    public FieldWriter(ClassWriter r100, int r101, String r102, String r103) {
        if (r100.firstField != null) goto L5;
        r100.firstField = this;
    L6:
        r100.lastField = this;
        this.access = r101;
        this.name = r100.newUTF8(r102);
        this.desc = r100.newUTF8(r103);
        return;
    L5:
        r100.lastField.next = this;
        goto L6
    }
}
