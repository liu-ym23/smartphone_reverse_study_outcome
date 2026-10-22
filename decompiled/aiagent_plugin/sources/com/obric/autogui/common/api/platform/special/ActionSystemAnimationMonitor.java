package com.obric.autogui.common.api.platform.special;

import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: ActionSystemAnimationMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ActionSystemAnimationMonitor {
    Object awaitReady(long r1, d<? super SystemAnimationSnapshot> r3);

    String getStepId();

    boolean hasPageSwitchStarted();

    SystemAnimationSnapshot latestPageSwitchSnapshot();

    PageSwitchPhase pageSwitchPhase();

    List<SystemAnimationSnapshot> snapshots();

    boolean unregister();
}
