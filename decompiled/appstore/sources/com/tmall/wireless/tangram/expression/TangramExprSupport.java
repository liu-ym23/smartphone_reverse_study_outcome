package com.tmall.wireless.tangram.expression;

import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes4.dex */
public final class TangramExprSupport implements ITangramExprParser {
    public static final String TANGRAM = "$tangram";
    public static final String VAR_START = "$";
    private ArrayMap exprParsers;

    public TangramExprSupport() {
        this.exprParsers = new ArrayMap();
    }

    public ITangramExprParser getExprParser(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        return (ITangramExprParser) this.exprParsers.get(r10);
    }

    @Override // com.tmall.wireless.tangram.expression.ITangramExprParser
    public Object getValueBy(TangramExpr r10) {
        if (r10.hasNextFragment() == false) goto L8;
        String r11 = r10.nextFragment();
        ITangramExprParser r12 = (ITangramExprParser) this.exprParsers.get(r11);
        if (r12 == null) goto L8;
        return r12.getValueBy(r10);
    L8:
        return null;
    }

    public void registerExprParser(String r10, ITangramExprParser r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.startsWith(VAR_START) == false) goto L8;
        this.exprParsers.put(r10, r11);
        return;
    }

    public void unregisterExprParser(String r10) {
        if (r10 == null) goto L5;
        this.exprParsers.remove(r10);
        return;
    }
}
