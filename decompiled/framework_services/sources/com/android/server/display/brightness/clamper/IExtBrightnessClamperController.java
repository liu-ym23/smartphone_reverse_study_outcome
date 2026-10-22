package com.android.server.display.brightness.clamper;

import android.pico.utils.IExtBase;
import com.android.server.display.IExtDisplayPowerController;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtBrightnessClamperController extends IExtBase {
    boolean isHdrExitMode();

    boolean isHdrMode();

    void setDisplayPowerController(IExtDisplayPowerController r1);

    void setHdrMode(HdrBrightnessModifier.Mode r1);

    void setModifiers(List<BrightnessStateModifier> r1);
}
