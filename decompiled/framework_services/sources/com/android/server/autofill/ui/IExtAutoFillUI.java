package com.android.server.autofill.ui;

import android.content.ComponentName;
import android.content.Context;
import android.metrics.LogMaker;
import android.pico.utils.IExtBase;
import android.service.autofill.SaveInfo;
import android.service.autofill.ValueFinder;
import com.android.server.UiModeManagerInternal;
import com.android.server.autofill.SaveEventLogger;

/* JADX INFO: loaded from: classes.dex */
public interface IExtAutoFillUI extends IExtBase {
    void deletePkgFromXml(String r1);

    boolean isInTestProcess(String r1);

    SaveUi newSavePasswdUi(Context r1, PendingUi r2, CharSequence r3, String r4, ComponentName r5, SaveInfo r6, ValueFinder r7, OverlayControl r8, AutoFillUI.AutoFillUiCallback r9, SaveEventLogger r10, UiModeManagerInternal r11, boolean r12, boolean r13, boolean r14, LogMaker r15);

    SaveUi newUpdatePasswdUi(Context r1, PendingUi r2, CharSequence r3, String r4, ComponentName r5, SaveInfo r6, ValueFinder r7, OverlayControl r8, AutoFillUI.AutoFillUiCallback r9, SaveEventLogger r10, UiModeManagerInternal r11, boolean r12, boolean r13, boolean r14, LogMaker r15);

    void onNoMoreNotify(String r1);
}
