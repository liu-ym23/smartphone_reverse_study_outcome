package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import kotlin.Metadata;
import t4.InterfaceC5507a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/t0;", "Lt4/a;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;I)V", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", "c", "(Lcom/stepos/agentframework/chatcore/file/FileInfo;Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.t0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1956t0 implements InterfaceC5507a {
    public static final C1956t0 INSTANCE = new C1956t0();

    @Override // t4.InterfaceC5507a
    public void a(FileInfo fileInfo, int progress) {
        kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
    }

    @Override // t4.InterfaceC5507a
    public void b(FileInfo fileInfo) {
        kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
    }

    @Override // t4.InterfaceC5507a
    public void c(FileInfo fileInfo, AgentError e10) {
        kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
        kotlin.jvm.internal.p.i(e10, "e");
    }
}
