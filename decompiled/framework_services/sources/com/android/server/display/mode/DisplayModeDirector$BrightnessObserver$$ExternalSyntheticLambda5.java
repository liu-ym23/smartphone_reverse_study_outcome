package com.android.server.display.mode;

import com.android.server.display.utils.DeviceConfigParsingUtils;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda5 implements Function {
    public /* synthetic */ DisplayModeDirector$BrightnessObserver$$ExternalSyntheticLambda5() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return DeviceConfigParsingUtils.ambientBrightnessThresholdsIntToFloat((int[]) r1);
    }
}
