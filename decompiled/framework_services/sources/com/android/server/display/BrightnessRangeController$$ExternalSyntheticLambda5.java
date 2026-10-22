package com.android.server.display;

import com.android.server.display.brightness.clamper.BrightnessClamperController;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class BrightnessRangeController$$ExternalSyntheticLambda5 implements BrightnessClamperController.ClamperChangeListener {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ BrightnessRangeController$$ExternalSyntheticLambda5(Runnable r1) {
        this.f$0 = r1;
    }

    @Override // com.android.server.display.brightness.clamper.BrightnessClamperController.ClamperChangeListener
    public final void onChanged() {
        this.f$0.run();
    }
}
