package com.stepos.ailauncher.chat.view;

import com.stepos.ailauncher.chat.voice.longpress.RecordingExitResult;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class BaseInputView$recordingExitCoordinator$2$2 extends FunctionReferenceImpl implements InterfaceC5074l<InterfaceC5074l<? super RecordingExitResult, ? extends Y8.t>, Y8.t> {
    public BaseInputView$recordingExitCoordinator$2$2(Object obj) {
        super(1, obj, com.stepos.ailauncher.chat.voice.longpress.Q.class, "requestFullScreenExit", "requestFullScreenExit(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(InterfaceC5074l<? super RecordingExitResult, ? extends Y8.t> interfaceC5074l) {
        l(interfaceC5074l);
        return Y8.t.f7040a;
    }

    public final void l(InterfaceC5074l<? super RecordingExitResult, Y8.t> p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((com.stepos.ailauncher.chat.voice.longpress.Q) this.receiver).s(p02);
    }
}
