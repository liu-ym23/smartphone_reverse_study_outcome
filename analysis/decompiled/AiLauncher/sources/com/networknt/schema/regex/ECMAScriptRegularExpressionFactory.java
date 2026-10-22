package com.networknt.schema.regex;

import com.networknt.schema.utils.Classes;

/* loaded from: classes2.dex */
public class ECMAScriptRegularExpressionFactory implements RegularExpressionFactory {
    private static final RegularExpressionFactory DELEGATE;
    private static final boolean GRAALJS_PRESENT;
    public static final ECMAScriptRegularExpressionFactory INSTANCE;
    private static final boolean JONI_PRESENT = Classes.isPresent("org.joni.Regex", ECMAScriptRegularExpressionFactory.class.getClassLoader());

    static {
        boolean zIsPresent = Classes.isPresent("com.oracle.truffle.js.parser.GraalJSEvaluator", ECMAScriptRegularExpressionFactory.class.getClassLoader());
        GRAALJS_PRESENT = zIsPresent;
        DELEGATE = zIsPresent ? GraalJSRegularExpressionFactory.getInstance() : JoniRegularExpressionFactory.getInstance();
        INSTANCE = new ECMAScriptRegularExpressionFactory();
    }

    public static ECMAScriptRegularExpressionFactory getInstance() {
        if (JONI_PRESENT || GRAALJS_PRESENT) {
            return INSTANCE;
        }
        throw new IllegalArgumentException("Either org.jruby.joni:joni or org.graalvm.js:js needs to be present in the classpath");
    }

    @Override // com.networknt.schema.regex.RegularExpressionFactory
    public RegularExpression getRegularExpression(String str) {
        return DELEGATE.getRegularExpression(str);
    }
}
