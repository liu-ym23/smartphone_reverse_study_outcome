package com.networknt.schema.regex;

import org.graalvm.polyglot.Context;

/* loaded from: classes2.dex */
public class GraalJSRegularExpressionFactory implements RegularExpressionFactory {
    private final GraalJSRegularExpressionContext context;

    public static class Holder {
        private static final GraalJSRegularExpressionFactory INSTANCE = new GraalJSRegularExpressionFactory();

        private Holder() {
        }
    }

    public GraalJSRegularExpressionFactory() {
        this(GraalJSContextFactory.getInstance());
    }

    public static GraalJSRegularExpressionFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.regex.RegularExpressionFactory
    public RegularExpression getRegularExpression(String str) {
        return new GraalJSRegularExpression(str, this.context);
    }

    public GraalJSRegularExpressionFactory(Context context) {
        this.context = new GraalJSRegularExpressionContext(context);
    }
}
