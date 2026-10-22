package com.stepos.ailauncher.chat.activity;

import com.stepos.ailauncher.chat.adapter.VoiceChoiceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class SoundSettingActivity$adapter$1 extends FunctionReferenceImpl implements InterfaceC5074l<VoiceChoiceItem, Y8.t> {
    public SoundSettingActivity$adapter$1(Object obj) {
        super(1, obj, SoundSettingActivity.class, "onVoiceItemClick", "onVoiceItemClick(Lcom/stepos/ailauncher/chat/adapter/VoiceChoiceItem;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(VoiceChoiceItem voiceChoiceItem) throws IllegalArgumentException {
        l(voiceChoiceItem);
        return Y8.t.f7040a;
    }

    public final void l(VoiceChoiceItem p02) throws IllegalArgumentException {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((SoundSettingActivity) this.receiver).K(p02);
    }
}
