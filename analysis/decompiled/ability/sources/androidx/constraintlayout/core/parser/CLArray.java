package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: classes2.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i6) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i6 > 0 || json.length() + i >= CLElement.sMaxLine) {
            sb.append("[\n");
            Iterator<CLElement> it = this.mElements.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (z10) {
                    z10 = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.sBaseIndent + i);
                sb.append(next.toFormattedJSON(CLElement.sBaseIndent + i, i6 - 1));
            }
            sb.append("\n");
            addIndent(sb, i);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z10 = true;
        for (int i = 0; i < this.mElements.size(); i++) {
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.mElements.get(i).toJSON());
        }
        return ((Object) sb) + "]";
    }
}
