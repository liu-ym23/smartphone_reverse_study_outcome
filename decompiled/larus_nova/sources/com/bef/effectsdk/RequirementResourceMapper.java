package com.bef.effectsdk;

/* JADX INFO: loaded from: classes3.dex */
public final class RequirementResourceMapper {
    private RequirementResourceMapper() {
    }

    private static native String[] nativePeekResourcesNeededByRequirements(String[] r100);

    public static String[] peekResourcesNeededByRequirements(String[] r100) {
        return nativePeekResourcesNeededByRequirements(r100);
    }
}
