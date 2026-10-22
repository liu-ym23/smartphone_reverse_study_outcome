package com.obric.oui.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CLKey extends CLContainer {
    private static ArrayList<String> sSections;

    static {
        ArrayList<String> r0 = new ArrayList();
        sSections = r0;
        r0.add("ConstraintSets");
        sSections.add("Variables");
        sSections.add("Generate");
        sSections.add("Transitions");
        sSections.add("KeyFrames");
        sSections.add("KeyAttributes");
        sSections.add("KeyPositions");
        sSections.add("KeyCycles");
    }

    public CLKey(char[] r1) {
        super(r1);
    }

    public static CLElement allocate(char[] r1) {
        return new CLKey(r1);
    }

    public static CLElement allocate(String r3, CLElement r4) {
        CLKey r0 = new CLKey(r3.toCharArray());
        r0.setStart(0);
        r0.setEnd(r3.length() - 1);
        r0.set(r4);
        return r0;
    }

    public String getName() {
        return content();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (this.mElements.size() <= 0) goto L7;
        return getDebugName() + content() + ": " + this.mElements.get(0).toJSON();
    L7:
        return getDebugName() + content() + ": <> ";
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r6, int r7) {
        StringBuilder r0 = new StringBuilder(getDebugName());
        addIndent(r0, r6);
        String r1 = content();
        if (this.mElements.size() <= 0) goto L17;
        r0.append(r1);
        r0.append(": ");
        if (sSections.contains(r1) == false) goto L8;
        r7 = 3;
    L8:
        if (r7 <= 0) goto L10;
        r0.append(this.mElements.get(0).toFormattedJSON(r6, r7 - 1));
    L15:
        return r0.toString();
    L10:
        String r2 = this.mElements.get(0).toJSON();
        if ((r2.length() + r6) >= sMaxLine) goto L13;
        r0.append(r2);
        goto L15
    L13:
        r0.append(this.mElements.get(0).toFormattedJSON(r6, r7 - 1));
        goto L15
    L17:
        return r1 + ": <> ";
    }

    public void set(CLElement r2) {
        if (this.mElements.size() <= 0) goto L5;
        this.mElements.set(0, r2);
        return;
    L5:
        this.mElements.add(r2);
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) goto L5;
        return null;
    L5:
        return this.mElements.get(0);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLContainer, com.obric.oui.constraintlayout.core.parser.CLElement
    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof CLKey) == false) goto L12;
        if (Objects.equals(getName(), ((CLKey) r3).getName()) == true) goto L12;
        return false;
    L12:
        return super.equals(r3);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLContainer, com.obric.oui.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }
}
