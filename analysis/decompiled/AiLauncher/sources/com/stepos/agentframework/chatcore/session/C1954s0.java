package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\n\u0010\u000bRT\u0010\u000f\u001aB\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/s0;", "", "<init>", "()V", "", "sessionId", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", AuthSessionDto.STATUS_PENDING, "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.s0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1954s0 {
    public static final C1954s0 INSTANCE = new C1954s0();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> pending = ConcurrentHashMap.newKeySet();

    public final List<String> a() {
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = pending;
        if (keySetView.isEmpty()) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(keySetView.size());
        Iterator<String> it = keySetView.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            arrayList.add(it.next());
            it.remove();
        }
        return arrayList;
    }

    public final void b(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String string = La.H.D1(sessionId).toString();
        if (string.length() > 0) {
            pending.add(string);
        }
    }
}
