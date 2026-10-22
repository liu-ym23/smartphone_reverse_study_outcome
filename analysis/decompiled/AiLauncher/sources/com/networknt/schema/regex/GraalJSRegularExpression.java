package com.networknt.schema.regex;

import org.graalvm.polyglot.Value;

/* loaded from: classes2.dex */
class GraalJSRegularExpression implements RegularExpression {
    private final GraalJSRegularExpressionContext context;
    private final Value function;

    public GraalJSRegularExpression(String str, GraalJSRegularExpressionContext graalJSRegularExpressionContext) {
        this.context = graalJSRegularExpressionContext;
        synchronized (graalJSRegularExpressionContext.getContext()) {
            this.function = graalJSRegularExpressionContext.getRegExpBuilder().execute(new Object[]{str});
        }
    }

    @Override // com.networknt.schema.regex.RegularExpression
    public boolean matches(String str) {
        boolean z10;
        synchronized (this.context.getContext()) {
            z10 = !this.function.execute(new Object[]{str}).isNull();
        }
        return z10;
    }
}
