package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
class HGuideline extends Guideline {
    public HGuideline(String r3) {
        super(r3);
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.HORIZONTAL_GUIDELINE));
    }

    public HGuideline(String r2, String r3) {
        super(r2);
        this.config = r3;
        this.type = new Helper.HelperType(typeMap.get(Helper.Type.HORIZONTAL_GUIDELINE));
        this.configMap = convertConfigToMap();
    }
}
