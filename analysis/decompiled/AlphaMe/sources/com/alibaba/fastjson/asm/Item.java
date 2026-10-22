package com.alibaba.fastjson.asm;

/* loaded from: classes.dex */
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

    public boolean isEqualTo(Item item) {
        int i4 = this.type;
        if (i4 != 1) {
            if (i4 != 15) {
                if (i4 == 12) {
                    return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2);
                }
                if (i4 != 13) {
                    switch (i4) {
                        case 3:
                        case 4:
                            if (item.intVal != this.intVal) {
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            if (!item.strVal1.equals(this.strVal1) || !item.strVal2.equals(this.strVal2) || !item.strVal3.equals(this.strVal3)) {
                                break;
                            }
                            break;
                    }
                    return false;
                }
            }
            return item.longVal == this.longVal;
        }
        return item.strVal1.equals(this.strVal1);
    }

    public void set(int i4, String str, String str2, String str3) {
        this.type = i4;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (i4 != 1 && i4 != 7 && i4 != 8) {
            if (i4 == 12) {
                this.hashCode = ((str2.hashCode() * str.hashCode()) + i4) & Integer.MAX_VALUE;
                return;
            } else if (i4 != 13) {
                this.hashCode = ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i4) & Integer.MAX_VALUE;
                return;
            }
        }
        this.hashCode = (str.hashCode() + i4) & Integer.MAX_VALUE;
    }

    public Item(int i4, Item item) {
        this.index = i4;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    public void set(int i4) {
        this.type = 3;
        this.intVal = i4;
        this.hashCode = (3 + i4) & Integer.MAX_VALUE;
    }
}
