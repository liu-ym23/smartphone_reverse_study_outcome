package com.android.server.input;

import android.app.assist.AssistStructure;
import android.hardware.display.DisplayManagerInternal;
import android.view.InputEvent;
import com.android.internal.view.IObricInputManager;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricInputManagerService extends IObricBase {
    IObricInputManager getIObricExt();

    int injectInputEvent(InputEvent r1, boolean r2, int r3, int r4, DisplayManagerInternal r5, NativeInputManagerService r6);

    void onInputEventInjectedForRobots(InputEvent r1);

    default void pushAssistStructure(AssistStructure structure, int eventId, String clickClassification) {
    }
}
