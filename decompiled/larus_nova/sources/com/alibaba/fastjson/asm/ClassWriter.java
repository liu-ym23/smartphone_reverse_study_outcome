package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
public class ClassWriter {
    private int access;
    FieldWriter firstField;
    MethodWriter firstMethod;
    int index;
    private int interfaceCount;
    private int[] interfaces;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int superName;
    String thisName;
    int threshold;
    Item[] typeTable;
    int version;

    public ClassWriter() {
        this(0);
    }

    public byte[] toByteArray() {
        int r100 = (this.interfaceCount * 2) + 24;
        FieldWriter r101 = this.firstField;
        int r102 = 0;
    L3:
        if (r101 == null) goto L5;
        r102 = r102 + 1;
        r100 = r100 + r101.getSize();
        r101 = r101.next;
        goto L3
    L5:
        MethodWriter r103 = this.firstMethod;
        int r104 = 0;
    L6:
        if (r103 == null) goto L8;
        r104 = r104 + 1;
        r100 = r100 + r103.getSize();
        r103 = r103.next;
        goto L6
    L8:
        ByteVector r105 = new ByteVector(r100 + this.pool.length);
        r105.putInt(-889275714).putInt(this.version);
        ByteVector r106 = r105.putShort(this.index);
        ByteVector r107 = this.pool;
        r106.putByteArray(r107.data, 0, r107.length);
        r105.putShort(this.access & (-393217)).putShort(this.name).putShort(this.superName);
        r105.putShort(this.interfaceCount);
        int r108 = 0;
    L10:
        if (r108 >= this.interfaceCount) goto L12;
        r105.putShort(this.interfaces[r108]);
        r108 = r108 + 1;
        goto L10
    L12:
        r105.putShort(r102);
        FieldWriter r109 = this.firstField;
    L13:
        if (r109 == null) goto L15;
        r109.put(r105);
        r109 = r109.next;
        goto L13
    L15:
        r105.putShort(r104);
        MethodWriter r110 = this.firstMethod;
    L16:
        if (r110 == null) goto L18;
        r110.put(r105);
        r110 = r110.next;
        goto L16
    L18:
        r105.putShort(0);
        return r105.data;
    }

    private ClassWriter(int r100) {
        this.index = 1;
        this.pool = new ByteVector();
        Item[] r101 = new Item[256];
        this.items = r101;
        this.threshold = (int) (((double) r101.length) * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }

    private Item get(Item r100) {
        Item[] r101 = this.items;
        Item r102 = r101[r100.hashCode % r101.length];
    L3:
        if (r102 == null) goto L9;
        if (r102.type != r100.type) goto L8;
        if (r100.isEqualTo(r102) == true) goto L9;
    L8:
        r102 = r102.next;
    L9:
        return r102;
    }

    private Item newString(String r100) {
        this.key2.set(8, r100, null, null);
        Item r101 = get(this.key2);
        if (r101 != null) goto L6;
        this.pool.put12(8, newUTF8(r100));
        int r102 = this.index;
        this.index = r102 + 1;
        Item r103 = new Item(r102, this.key2);
        put(r103);
        return r103;
    L6:
        return r101;
    }

    private void put(Item r100) {
        if (this.index <= this.threshold) goto L11;
        int r101 = this.items.length;
        int r102 = (r101 * 2) + 1;
        Item[] r103 = new Item[r102];
        int r104 = r101 - 1;
    L5:
        if (r104 < 0) goto L10;
        Item r105 = this.items[r104];
    L7:
        if (r105 == null) goto L9;
        int r106 = r105.hashCode % r102;
        Item r107 = r105.next;
        r105.next = r103[r106];
        r103[r106] = r105;
        r105 = r107;
        goto L7
    L9:
        r104 = r104 - 1;
        goto L5
    L10:
        this.items = r103;
        this.threshold = (int) (((double) r102) * 0.75d);
    L11:
        int r108 = r100.hashCode;
        Item[] r109 = this.items;
        int r110 = r108 % r109.length;
        r100.next = r109[r110];
        r109[r110] = r100;
    }

    public Item newClassItem(String r100) {
        this.key2.set(7, r100, null, null);
        Item r101 = get(this.key2);
        if (r101 != null) goto L6;
        this.pool.put12(7, newUTF8(r100));
        int r102 = this.index;
        this.index = r102 + 1;
        Item r103 = new Item(r102, this.key2);
        put(r103);
        return r103;
    L6:
        return r101;
    }

    public Item newConstItem(Object r100) {
        if ((r100 instanceof Integer) == false) goto L9;
        int r101 = ((Integer) r100).intValue();
        this.key.set(r101);
        Item r102 = get(this.key);
        if (r102 != null) goto L22;
        this.pool.putByte(3).putInt(r101);
        int r103 = this.index;
        this.index = r103 + 1;
        Item r104 = new Item(r103, this.key);
        put(r104);
        return r104;
    L22:
        return r102;
    L9:
        if ((r100 instanceof String) == false) goto L13;
        return newString((String) r100);
    L13:
        if ((r100 instanceof Type) == false) goto L21;
        Type r105 = (Type) r100;
        if (r105.sort != 10) goto L17;
        String r106 = r105.getInternalName();
    L19:
        return newClassItem(r106);
    L17:
        r106 = r105.getDescriptor();
        goto L19
    L21:
        throw new IllegalArgumentException("value " + r100);
    }

    public int newUTF8(String r100) {
        this.key.set(1, r100, null, null);
        Item r101 = get(this.key);
        if (r101 != null) goto L6;
        this.pool.putByte(1).putUTF8(r100);
        int r102 = this.index;
        this.index = r102 + 1;
        r101 = new Item(r102, this.key);
        put(r101);
    L6:
        return r101.index;
    }

    public Item newNameTypeItem(String r100, String r101) {
        this.key2.set(12, r100, r101, null);
        Item r102 = get(this.key2);
        if (r102 != null) goto L6;
        int r103 = newUTF8(r100);
        int r104 = newUTF8(r101);
        this.pool.put12(12, r103).putShort(r104);
        int r105 = this.index;
        this.index = r105 + 1;
        Item r106 = new Item(r105, this.key2);
        put(r106);
        return r106;
    L6:
        return r102;
    }

    public Item newFieldItem(String r100, String r101, String r102) {
        this.key3.set(9, r100, r101, r102);
        Item r103 = get(this.key3);
        if (r103 != null) goto L6;
        int r104 = newClassItem(r100).index;
        int r105 = newNameTypeItem(r101, r102).index;
        this.pool.put12(9, r104).putShort(r105);
        int r106 = this.index;
        this.index = r106 + 1;
        Item r107 = new Item(r106, this.key3);
        put(r107);
        return r107;
    L6:
        return r103;
    }

    public Item newMethodItem(String r100, String r101, String r102, boolean r103) {
        if (r103 == false) goto L4;
        int r104 = 11;
    L5:
        this.key3.set(r104, r100, r101, r102);
        Item r105 = get(this.key3);
        if (r105 != null) goto L9;
        int r106 = newClassItem(r100).index;
        int r107 = newNameTypeItem(r101, r102).index;
        this.pool.put12(r104, r106).putShort(r107);
        int r108 = this.index;
        this.index = r108 + 1;
        Item r109 = new Item(r108, this.key3);
        put(r109);
        return r109;
    L9:
        return r105;
    L4:
        r104 = 10;
        goto L5
    }

    public void visit(int r100, int r101, String r102, String r103, String[] r104) {
        this.version = r100;
        this.access = r101;
        this.name = newClassItem(r102).index;
        this.thisName = r102;
        int r105 = 0;
        if (r103 != null) goto L5;
        int r106 = 0;
    L6:
        this.superName = r106;
        if (r104 != null) goto L9;
        return;
    L9:
        if (r104.length <= 0) goto L16;
        int r107 = r104.length;
        this.interfaceCount = r107;
        this.interfaces = new int[r107];
    L12:
        if (r105 >= this.interfaceCount) goto L17;
        this.interfaces[r105] = newClassItem(r104[r105]).index;
        r105 = r105 + 1;
        goto L12
    L17:
        return;
    L16:
        return;
    L5:
        r106 = newClassItem(r103).index;
        goto L6
    }
}
