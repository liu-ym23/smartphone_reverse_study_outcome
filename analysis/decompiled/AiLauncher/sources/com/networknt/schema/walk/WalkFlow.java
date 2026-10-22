package com.networknt.schema.walk;

/* loaded from: classes2.dex */
public enum WalkFlow {
    SKIP("SkipWalk", "Skip only the walk method, but continue invoking the other listeners"),
    ABORT("Abort", "Aborts all the walk listeners and walk method itself"),
    CONTINUE("ContinueToWalk", "continue to invoke the walk method and other listeners");

    private final String description;
    private final String name;

    WalkFlow(String str, String str2) {
        this.name = str;
        this.description = str2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }
}
