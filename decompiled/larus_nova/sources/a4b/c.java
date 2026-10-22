package a4b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC4825a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1823a;

    public c(b r100) {
        this.f1823a = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC4825a
    public final void l(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d) == false) goto L6;
        this.f1823a.getClass();
        return;
    }
}
