package com.stepos.ailauncher.chat.media;

import android.media.AudioAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class TtsMediaFocusController$longMediaCounts$1 extends FunctionReferenceImpl implements InterfaceC5074l<AudioAttributes, Boolean> {
    public TtsMediaFocusController$longMediaCounts$1(Object obj) {
        super(1, obj, TtsMediaFocusController.class, "isLongMedia", "isLongMedia(Landroid/media/AudioAttributes;)Z", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(AudioAttributes p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return Boolean.valueOf(((TtsMediaFocusController) this.receiver).O(p02));
    }
}
