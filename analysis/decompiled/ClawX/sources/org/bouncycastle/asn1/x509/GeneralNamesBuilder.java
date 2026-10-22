package org.bouncycastle.asn1.x509;

import java.util.Vector;

/* loaded from: classes.dex */
public class GeneralNamesBuilder {
    private Vector names = new Vector();

    public GeneralNamesBuilder addName(GeneralName generalName) {
        this.names.addElement(generalName);
        return this;
    }

    public GeneralNamesBuilder addNames(GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i8 = 0; i8 != names.length; i8++) {
            this.names.addElement(names[i8]);
        }
        return this;
    }

    public GeneralNames build() {
        int size = this.names.size();
        GeneralName[] generalNameArr = new GeneralName[size];
        for (int i8 = 0; i8 != size; i8++) {
            generalNameArr[i8] = (GeneralName) this.names.elementAt(i8);
        }
        return new GeneralNames(generalNameArr);
    }
}
