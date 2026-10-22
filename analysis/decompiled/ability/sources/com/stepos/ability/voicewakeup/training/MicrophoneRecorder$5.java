package com.stepos.ability.voicewakeup.training;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class MicrophoneRecorder$5 extends FunctionReferenceImpl implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public static final MicrophoneRecorder$5 f3349a = new MicrophoneRecorder$5();

    public MicrophoneRecorder$5() {
        super(0, System.class, "nanoTime", "nanoTime()J", 0);
    }

    @Override // S7.a
    public final Object invoke() {
        return Long.valueOf(System.nanoTime());
    }
}
