package com.networknt.schema.regex;

/* loaded from: classes2.dex */
public class JoniRegularExpressionFactory implements RegularExpressionFactory {
    private static final JoniRegularExpressionFactory INSTANCE = new JoniRegularExpressionFactory();

    public static JoniRegularExpressionFactory getInstance() {
        return INSTANCE;
    }

    @Override // com.networknt.schema.regex.RegularExpressionFactory
    public RegularExpression getRegularExpression(String str) {
        return new JoniRegularExpression(str);
    }
}
