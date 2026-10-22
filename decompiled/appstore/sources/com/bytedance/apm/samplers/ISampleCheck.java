package com.bytedance.apm.samplers;

/* JADX INFO: loaded from: classes.dex */
public interface ISampleCheck {
    boolean getLogTypeSwitch(String r10);

    boolean getMetricSwitch(String r10);

    boolean getPerfAllowSwitch(String r10);

    boolean getPerfFpsAllowSwitch(String r10, String r11);

    boolean getPerfSecondStageSwitch(String r10);

    boolean getServiceSwitch(String r10);
}
