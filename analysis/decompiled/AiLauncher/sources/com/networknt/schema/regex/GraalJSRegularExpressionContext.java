package com.networknt.schema.regex;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

/* loaded from: classes2.dex */
public class GraalJSRegularExpressionContext {
    private static final String SOURCE = "pattern => {\n    const regex = new RegExp(pattern, 'u');\n    return text => text.match(regex)\n};";
    private final Context context;
    private final Value regExpBuilder;

    public GraalJSRegularExpressionContext(Context context) {
        this.context = context;
        synchronized (context) {
            this.regExpBuilder = context.eval("js", SOURCE);
        }
    }

    public Context getContext() {
        return this.context;
    }

    public Value getRegExpBuilder() {
        return this.regExpBuilder;
    }
}
