package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
interface FieldTrialList$Natives {
    boolean createFieldTrial(String r10, String r11);

    String findFullName(String r10);

    String getVariationParameter(String r10, String r11);

    void logActiveTrials();

    boolean trialExists(String r10);
}
