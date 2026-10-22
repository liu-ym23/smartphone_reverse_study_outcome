package com.obric.oui.constraintlayout.core.dsl;

import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Barrier extends Helper {
    private Constraint.Side mDirection;
    private int mMargin;
    private ArrayList<Ref> references;

    public Barrier(String r4) {
        super(r4, new Helper.HelperType(typeMap.get(Helper.Type.BARRIER)));
        this.mDirection = null;
        this.mMargin = Integer.MIN_VALUE;
        this.references = new ArrayList();
    }

    public Barrier(String r4, String r5) {
        super(r4, new Helper.HelperType(typeMap.get(Helper.Type.BARRIER)), r5);
        this.mDirection = null;
        this.mMargin = Integer.MIN_VALUE;
        this.references = new ArrayList();
        this.configMap = convertConfigToMap();
        if (this.configMap.containsKey("contains") == false) goto L6;
        Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        return;
    }

    public Constraint.Side getDirection() {
        return this.mDirection;
    }

    public void setDirection(Constraint.Side r2) {
        this.mDirection = r2;
        this.configMap.put(MaterialConfigFormatNames.DIRECTION, sideMap.get(r2));
    }

    public int getMargin() {
        return this.mMargin;
    }

    public void setMargin(int r2) {
        this.mMargin = r2;
        this.configMap.put("margin", String.valueOf(r2));
    }

    public String referencesToString() {
        if (this.references.isEmpty() == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder("[");
        Iterator<Ref> r2 = this.references.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.append(r2.next().toString());
        goto L8
    L10:
        r0.append("]");
        return r0.toString();
    }

    public Barrier addReference(Ref r3) {
        this.references.add(r3);
        this.configMap.put("contains", referencesToString());
        return this;
    }

    public Barrier addReference(String r1) {
        return addReference(Ref.parseStringToRef(r1));
    }
}
