package com.networknt.schema.regex;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class JDKRegularExpression implements RegularExpression {
    private final Pattern pattern;

    public JDKRegularExpression(String str) {
        this.pattern = Pattern.compile(RegularExpressions.replaceLongformCharacterProperties(RegularExpressions.replaceDollarAnchors(str)));
    }

    @Override // com.networknt.schema.regex.RegularExpression
    public boolean matches(String str) {
        return this.pattern.matcher(str).find();
    }
}
