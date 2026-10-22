package com.networknt.schema.regex;

/* loaded from: classes2.dex */
public class JDKRegularExpressionFactory implements RegularExpressionFactory {
    private static final JDKRegularExpressionFactory INSTANCE = new JDKRegularExpressionFactory();

    public static JDKRegularExpressionFactory getInstance() {
        return INSTANCE;
    }

    @Override // com.networknt.schema.regex.RegularExpressionFactory
    public RegularExpression getRegularExpression(String str) {
        return new JDKRegularExpression(str);
    }
}
