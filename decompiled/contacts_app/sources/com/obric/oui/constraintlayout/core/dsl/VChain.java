package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public class VChain extends Chain {
    private VAnchor mBaseline;
    private VAnchor mBottom;
    private VAnchor mTop;

    public class VAnchor extends Chain.Anchor {
        final /* synthetic */ VChain this$0;

        VAnchor(VChain r1, Constraint.VSide r2) {
            this.this$0 = r1;
            super(r1, Constraint.Side.valueOf(r2.name()));
        }
    }

    public VChain(String r3) {
        super(r3);
        this.mTop = new VAnchor(this, Constraint.VSide.TOP);
        this.mBottom = new VAnchor(this, Constraint.VSide.BOTTOM);
        this.mBaseline = new VAnchor(this, Constraint.VSide.BASELINE);
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.VERTICAL_CHAIN));
    }

    public VChain(String r2, String r3) {
        super(r2);
        this.mTop = new VAnchor(this, Constraint.VSide.TOP);
        this.mBottom = new VAnchor(this, Constraint.VSide.BOTTOM);
        this.mBaseline = new VAnchor(this, Constraint.VSide.BASELINE);
        this.config = r3;
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.VERTICAL_CHAIN));
        this.configMap = convertConfigToMap();
        if (this.configMap.containsKey("contains") == false) goto L6;
        Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        return;
    }

    public VAnchor getTop() {
        return this.mTop;
    }

    public void linkToTop(Constraint.VAnchor r2) {
        linkToTop(r2, 0);
    }

    public void linkToTop(Constraint.VAnchor r2, int r3) {
        linkToTop(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToTop(Constraint.VAnchor r2, int r3, int r4) {
        this.mTop.mConnection = r2;
        this.mTop.mMargin = r3;
        this.mTop.mGoneMargin = r4;
        this.configMap.put("top", this.mTop.toString());
    }

    public VAnchor getBottom() {
        return this.mBottom;
    }

    public void linkToBottom(Constraint.VAnchor r2) {
        linkToBottom(r2, 0);
    }

    public void linkToBottom(Constraint.VAnchor r2, int r3) {
        linkToBottom(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToBottom(Constraint.VAnchor r2, int r3, int r4) {
        this.mBottom.mConnection = r2;
        this.mBottom.mMargin = r3;
        this.mBottom.mGoneMargin = r4;
        this.configMap.put("bottom", this.mBottom.toString());
    }

    public VAnchor getBaseline() {
        return this.mBaseline;
    }

    public void linkToBaseline(Constraint.VAnchor r2) {
        linkToBaseline(r2, 0);
    }

    public void linkToBaseline(Constraint.VAnchor r2, int r3) {
        linkToBaseline(r2, r3, Integer.MIN_VALUE);
    }

    public void linkToBaseline(Constraint.VAnchor r2, int r3, int r4) {
        this.mBaseline.mConnection = r2;
        this.mBaseline.mMargin = r3;
        this.mBaseline.mGoneMargin = r4;
        this.configMap.put("baseline", this.mBaseline.toString());
    }
}
