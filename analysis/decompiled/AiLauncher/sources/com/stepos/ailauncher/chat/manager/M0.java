package com.stepos.ailauncher.chat.manager;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/M0;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "handler", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)V", "", "sessionId", "c", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "allowInterrupted", Const.INTENT_KEY_APIKEY, "(ZLjava/lang/String;)Ljava/lang/Object;", "handoff", "Ljava/lang/Object;", "Lkotlin/Pair;", com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED, "Lkotlin/Pair;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M0<T> {
    private T handoff;
    private Pair<String, ? extends T> interrupted;

    public final T a(boolean allowInterrupted, String sessionId) {
        T t10 = this.handoff;
        if (t10 != null) {
            this.handoff = null;
            return t10;
        }
        Pair<String, ? extends T> pair = this.interrupted;
        if (pair == null || !allowInterrupted || (sessionId != null && !kotlin.jvm.internal.p.d(sessionId, pair.e()))) {
            return null;
        }
        this.interrupted = null;
        return pair.f();
    }

    public final void b(T handler) {
        this.handoff = handler;
        if (handler == null) {
            this.interrupted = null;
        }
    }

    public final void c(String sessionId, T handler) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        this.interrupted = Y8.j.a(sessionId, handler);
    }
}
