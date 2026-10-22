package com.obric.oui.constraintlayout.core.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    private static class CLObjectIterator implements Iterator<CLKey> {
        int mIndex;
        CLObject mObject;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ CLKey next() {
            return next();
        }

        CLObjectIterator(CLObject r2) {
            this.mIndex = 0;
            this.mObject = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mIndex >= this.mObject.size()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CLKey next() {
            CLKey r0 = (CLKey) this.mObject.mElements.get(this.mIndex);
            this.mIndex++;
            return r0;
        }
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLContainer, com.obric.oui.constraintlayout.core.parser.CLElement
    public /* bridge */ /* synthetic */ CLContainer clone() {
        return clone();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLContainer, com.obric.oui.constraintlayout.core.parser.CLElement
    public /* bridge */ /* synthetic */ CLElement clone() {
        return clone();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLContainer, com.obric.oui.constraintlayout.core.parser.CLElement
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo442clone() throws CloneNotSupportedException {
        return clone();
    }

    public CLObject(char[] r1) {
        super(r1);
    }

    public static CLObject allocate(char[] r1) {
        return new CLObject(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder r0 = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> r4 = this.mElements.iterator();
        boolean r1 = true;
    L4:
        if (r4.hasNext() == false) goto L10;
        CLElement r2 = r4.next();
        if (r1 == true) goto L8;
        r0.append(", ");
    L9:
        r0.append(r2.toJSON());
        goto L4
    L8:
        r1 = false;
        goto L9
    L10:
        r0.append(" }");
        return r0.toString();
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int r8, int r9) {
        StringBuilder r0 = new StringBuilder(getDebugName());
        r0.append("{\n");
        Iterator<CLElement> r1 = this.mElements.iterator();
        boolean r3 = true;
    L4:
        if (r1.hasNext() == false) goto L10;
        CLElement r4 = r1.next();
        if (r3 == true) goto L8;
        r0.append(",\n");
    L9:
        r0.append(r4.toFormattedJSON(sBaseIndent + r8, r9 - 1));
        goto L4
    L8:
        r3 = false;
        goto L9
    L10:
        r0.append("\n");
        addIndent(r0, r8);
        r0.append("}");
        return r0.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLContainer, com.obric.oui.constraintlayout.core.parser.CLElement
    public CLObject clone() {
        return (CLObject) super.clone();
    }
}
