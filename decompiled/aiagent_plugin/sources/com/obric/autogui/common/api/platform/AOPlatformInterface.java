package com.obric.autogui.common.api.platform;

/* JADX INFO: compiled from: AOPlatformInterface.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AOPlatformInterface {
    AOPlatformInformation getInformation();

    AOPlatformToolsInterface getTools();

    boolean init();
}
