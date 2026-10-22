package com.stepos.agentframework.adapter.openclaw;

import com.autonavi.aps.amapapi.config.Const;
import d8.InterfaceC3961a;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ)\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/a;", "Ld8/a;", "<init>", "()V", "", "tag", "msg", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "e", "c", "", "throwable", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a implements InterfaceC3961a {
    public static final a INSTANCE = new a();

    @Override // d8.InterfaceC3961a
    public void a(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        C4148a.c(tag, msg, true);
    }

    @Override // d8.InterfaceC3961a
    public void c(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        C4148a.s(tag, msg, true);
    }

    @Override // d8.InterfaceC3961a
    public void d(String tag, String msg, Throwable throwable) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        if (throwable != null) {
            C4148a.e(tag, msg, throwable, true);
        } else {
            C4148a.f(tag, msg, true);
        }
    }

    @Override // d8.InterfaceC3961a
    public void e(String tag, String msg) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        C4148a.j(tag, msg, true);
    }
}
