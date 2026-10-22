package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
final class Item {
    int hashCode;
    int index;
    int intVal;
    long longVal;
    Item next;
    String strVal1;
    String strVal2;
    String strVal3;
    int type;

    public Item() {
    }

    public boolean isEqualTo(Item r100) {
        int r101 = this.type;
        if (r101 == 1) goto L38;
        if (r101 == 15) goto L33;
        if (r101 == 12) goto L26;
        if (r101 == 13) goto L38;
        switch(r101) {
            case 3: goto L21;
            case 4: goto L21;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L38;
            case 8: goto L38;
            default: goto L12;
        };
    L12:
        if (r100.strVal1.equals(this.strVal1) == true) goto L14;
    L18:
        return false;
    L14:
        if (r100.strVal2.equals(this.strVal2) == false) goto L18;
        if (r100.strVal3.equals(this.strVal3) == false) goto L18;
        return true;
    L21:
        if (r100.intVal == this.intVal) goto L40;
        return false;
    L40:
        return true;
    L26:
        if (r100.strVal1.equals(this.strVal1) == true) goto L28;
    L30:
        return false;
    L28:
        if (r100.strVal2.equals(this.strVal2) == false) goto L30;
        return true;
    L33:
        if (r100.longVal == this.longVal) goto L42;
        return false;
    L42:
        return true;
    L38:
        return r100.strVal1.equals(this.strVal1);
    }

    public void set(int r100) {
        this.type = 3;
        this.intVal = r100;
        this.hashCode = (3 + r100) & Integer.MAX_VALUE;
    }

    public Item(int r100, Item r101) {
        this.index = r100;
        this.type = r101.type;
        this.intVal = r101.intVal;
        this.longVal = r101.longVal;
        this.strVal1 = r101.strVal1;
        this.strVal2 = r101.strVal2;
        this.strVal3 = r101.strVal3;
        this.hashCode = r101.hashCode;
    }

    public void set(int r100, String r101, String r102, String r103) {
        this.type = r100;
        this.strVal1 = r101;
        this.strVal2 = r102;
        this.strVal3 = r103;
        if (r100 != 1) goto L5;
    L16:
        this.hashCode = (r100 + r101.hashCode()) & Integer.MAX_VALUE;
        return;
    L5:
        if (r100 == 7) goto L16;
        if (r100 == 8) goto L16;
        if (r100 != 12) goto L11;
        this.hashCode = (r100 + (r101.hashCode() * r102.hashCode())) & Integer.MAX_VALUE;
        return;
    L11:
        if (r100 == 13) goto L16;
        this.hashCode = (r100 + ((r101.hashCode() * r102.hashCode()) * r103.hashCode())) & Integer.MAX_VALUE;
    }
}
