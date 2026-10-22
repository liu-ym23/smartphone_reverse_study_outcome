package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u0003J\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/T;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "presentation", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;)Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "e", "(Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;)V", UxipConstants.f30680s, "current", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "c", "", "prepared", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class T {
    private RecordingPresentation current = RecordingPresentation.INPUT_BAR;
    private boolean prepared;

    public final RecordingPresentation a() {
        return d(this.current);
    }

    public final void b() {
        this.prepared = false;
    }

    /* renamed from: c, reason: from getter */
    public final RecordingPresentation getCurrent() {
        return this.current;
    }

    public final RecordingPresentation d(RecordingPresentation presentation) {
        kotlin.jvm.internal.p.i(presentation, "presentation");
        if (!this.prepared) {
            this.current = presentation;
        }
        this.prepared = true;
        return this.current;
    }

    public final void e(RecordingPresentation presentation) {
        kotlin.jvm.internal.p.i(presentation, "presentation");
        this.current = presentation;
        this.prepared = false;
    }
}
