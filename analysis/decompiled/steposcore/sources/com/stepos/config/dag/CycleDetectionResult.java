package com.stepos.config.dag;

import java.util.List;

/* loaded from: classes.dex */
public class CycleDetectionResult {
    private final List<String> cyclePath;
    private final boolean hasCycle;

    public CycleDetectionResult(boolean hasCycle, List<String> cyclePath) {
        this.hasCycle = hasCycle;
        this.cyclePath = cyclePath;
    }

    public static CycleDetectionResult noCycle() {
        return new CycleDetectionResult(false, null);
    }

    public static CycleDetectionResult withCycle(List<String> path) {
        return new CycleDetectionResult(true, path);
    }

    public boolean hasCycle() {
        return this.hasCycle;
    }

    public List<String> getCyclePath() {
        return this.cyclePath;
    }

    public String toString() {
        return !this.hasCycle ? "No cycle detected" : "Cycle detected: " + String.join(" -> ", this.cyclePath) + " -> " + this.cyclePath.get(0);
    }
}
