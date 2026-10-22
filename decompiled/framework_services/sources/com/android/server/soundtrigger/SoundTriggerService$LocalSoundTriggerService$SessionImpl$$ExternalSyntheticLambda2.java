package com.android.server.soundtrigger;

import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SoundTriggerService$LocalSoundTriggerService$SessionImpl$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ SoundTriggerHelper f$0;

    public /* synthetic */ SoundTriggerService$LocalSoundTriggerService$SessionImpl$$ExternalSyntheticLambda2(SoundTriggerHelper r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r2) {
        this.f$0.onAppOpStateChanged(((Boolean) r2).booleanValue());
    }
}
