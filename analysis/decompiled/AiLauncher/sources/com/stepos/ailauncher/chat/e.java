package com.stepos.ailauncher.chat;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\u00020\u000b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R+\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/e;", "", "<init>", "()V", "Lkotlin/Pair;", "", "Landroid/os/Bundle;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lkotlin/Pair;Le9/c;)Ljava/lang/Object;", "", "c", "(Lkotlin/Pair;)Z", "LXa/j;", "_eventFlow", "LXa/j;", "LXa/o;", "eventFlow", "LXa/o;", Const.INTENT_KEY_PKGNAME, "()LXa/o;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final e INSTANCE = new e();
    private static final Xa.j<Pair<String, Bundle>> _eventFlow;
    private static final Xa.o<Pair<String, Bundle>> eventFlow;

    static {
        Xa.j<Pair<String, Bundle>> jVarB = Xa.p.b(0, 8, null, 5, null);
        _eventFlow = jVarB;
        eventFlow = Xa.d.b(jVarB);
    }

    public final Object a(Pair<String, Bundle> pair, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        C4148a.d("PickFileMediatorViewModel", "emitEvent: " + pair, false, 4, null);
        Object objEmit = _eventFlow.emit(pair, interfaceC4014c);
        return objEmit == C4063a.g() ? objEmit : Y8.t.f7040a;
    }

    public final Xa.o<Pair<String, Bundle>> b() {
        return eventFlow;
    }

    public final boolean c(Pair<String, Bundle> event) {
        kotlin.jvm.internal.p.i(event, "event");
        C4148a.d("PickFileMediatorViewModel", "tryEmitEvent: " + event, false, 4, null);
        return _eventFlow.a(event);
    }
}
