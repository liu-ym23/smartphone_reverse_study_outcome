package com.networknt.schema.regex;

import org.graalvm.polyglot.Context;

/* loaded from: classes2.dex */
public class GraalJSContextFactory {

    public static class Holder {
        private static final Context INSTANCE = Context.newBuilder(new String[]{"js"}).option("engine.WarnInterpreterOnly", "false").build();

        private Holder() {
        }
    }

    public static Context getInstance() {
        return Holder.INSTANCE;
    }
}
