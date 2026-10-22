package ch.qos.logback.core.joran.spi;

import java.util.List;

/* loaded from: classes.dex */
public class ElementSelector extends ElementPath {
    public ElementSelector() {
    }

    private boolean equalityCheck(String str, String str2) {
        return str.equalsIgnoreCase(str2);
    }

    @Override // ch.qos.logback.core.joran.spi.ElementPath
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ElementSelector)) {
            return false;
        }
        ElementSelector elementSelector = (ElementSelector) obj;
        if (elementSelector.size() != size()) {
            return false;
        }
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!equalityCheck(get(i4), elementSelector.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public boolean fullPathMatch(ElementPath elementPath) {
        if (elementPath.size() != size()) {
            return false;
        }
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!equalityCheck(get(i4), elementPath.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public int getPrefixMatchLength(ElementPath elementPath) {
        if (elementPath == null) {
            return 0;
        }
        int size = this.partList.size();
        int size2 = elementPath.partList.size();
        if (size == 0 || size2 == 0) {
            return 0;
        }
        if (size > size2) {
            size = size2;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size && equalityCheck(this.partList.get(i5), elementPath.partList.get(i5)); i5++) {
            i4++;
        }
        return i4;
    }

    public int getTailMatchLength(ElementPath elementPath) {
        int i4 = 0;
        if (elementPath == null) {
            return 0;
        }
        int size = this.partList.size();
        int size2 = elementPath.partList.size();
        if (size != 0 && size2 != 0) {
            int i5 = size <= size2 ? size : size2;
            for (int i6 = 1; i6 <= i5 && equalityCheck(this.partList.get(size - i6), elementPath.partList.get(size2 - i6)); i6++) {
                i4++;
            }
        }
        return i4;
    }

    public int hashCode() {
        int size = size();
        int iHashCode = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iHashCode ^= get(i4).toLowerCase().hashCode();
        }
        return iHashCode;
    }

    public boolean isContainedIn(ElementPath elementPath) {
        if (elementPath == null) {
            return false;
        }
        return elementPath.toStableString().contains(toStableString());
    }

    public ElementSelector(List<String> list) {
        super(list);
    }

    public ElementSelector(String str) {
        super(str);
    }
}
