package com.google.zxing.client.result;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedProductParsedResult extends ParsedResult {
    public static final String KILOGRAM = "KG";
    public static final String POUND = "LB";
    private final String bestBeforeDate;
    private final String expirationDate;
    private final String lotNumber;
    private final String packagingDate;
    private final String price;
    private final String priceCurrency;
    private final String priceIncrement;
    private final String productID;
    private final String productionDate;
    private final String rawText;
    private final String sscc;
    private final Map<String, String> uncommonAIs;
    private final String weight;
    private final String weightIncrement;
    private final String weightType;

    public ExpandedProductParsedResult(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Map<String, String> r17) {
        super(ParsedResultType.PRODUCT);
        this.rawText = r3;
        this.productID = r4;
        this.sscc = r5;
        this.lotNumber = r6;
        this.productionDate = r7;
        this.packagingDate = r8;
        this.bestBeforeDate = r9;
        this.expirationDate = r10;
        this.weight = r11;
        this.weightType = r12;
        this.weightIncrement = r13;
        this.price = r14;
        this.priceIncrement = r15;
        this.priceCurrency = r16;
        this.uncommonAIs = r17;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ExpandedProductParsedResult) == true) goto L5;
        return false;
    L5:
        ExpandedProductParsedResult r5 = (ExpandedProductParsedResult) r4;
        if (equalsOrNull(this.productID, r5.productID) == true) goto L8;
    L33:
        return false;
    L8:
        if (equalsOrNull(this.sscc, r5.sscc) == false) goto L33;
        if (equalsOrNull(this.lotNumber, r5.lotNumber) == false) goto L33;
        if (equalsOrNull(this.productionDate, r5.productionDate) == false) goto L33;
        if (equalsOrNull(this.bestBeforeDate, r5.bestBeforeDate) == false) goto L33;
        if (equalsOrNull(this.expirationDate, r5.expirationDate) == false) goto L33;
        if (equalsOrNull(this.weight, r5.weight) == false) goto L33;
        if (equalsOrNull(this.weightType, r5.weightType) == false) goto L33;
        if (equalsOrNull(this.weightIncrement, r5.weightIncrement) == false) goto L33;
        if (equalsOrNull(this.price, r5.price) == false) goto L33;
        if (equalsOrNull(this.priceIncrement, r5.priceIncrement) == false) goto L33;
        if (equalsOrNull(this.priceCurrency, r5.priceCurrency) == false) goto L33;
        if (equalsOrNull(this.uncommonAIs, r5.uncommonAIs) == false) goto L33;
        return true;
    }

    private static boolean equalsOrNull(Object r0, Object r1) {
        if (r0 != null) goto L9;
        if (r1 != null) goto L6;
        return true;
    L6:
        return false;
    L9:
        return r0.equals(r1);
    }

    public int hashCode() {
        int r0 = (((((((((((hashNotNull(this.productID) ^ 0) ^ hashNotNull(this.sscc)) ^ hashNotNull(this.lotNumber)) ^ hashNotNull(this.productionDate)) ^ hashNotNull(this.bestBeforeDate)) ^ hashNotNull(this.expirationDate)) ^ hashNotNull(this.weight)) ^ hashNotNull(this.weightType)) ^ hashNotNull(this.weightIncrement)) ^ hashNotNull(this.price)) ^ hashNotNull(this.priceIncrement)) ^ hashNotNull(this.priceCurrency);
        return hashNotNull(this.uncommonAIs) ^ r0;
    }

    private static int hashNotNull(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String getRawText() {
        return this.rawText;
    }

    public String getProductID() {
        return this.productID;
    }

    public String getSscc() {
        return this.sscc;
    }

    public String getLotNumber() {
        return this.lotNumber;
    }

    public String getProductionDate() {
        return this.productionDate;
    }

    public String getPackagingDate() {
        return this.packagingDate;
    }

    public String getBestBeforeDate() {
        return this.bestBeforeDate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getWeightType() {
        return this.weightType;
    }

    public String getWeightIncrement() {
        return this.weightIncrement;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPriceIncrement() {
        return this.priceIncrement;
    }

    public String getPriceCurrency() {
        return this.priceCurrency;
    }

    public Map<String, String> getUncommonAIs() {
        return this.uncommonAIs;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return String.valueOf(this.rawText);
    }
}
