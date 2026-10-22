package com.stepos.agentframework.uikit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v8.C5671a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/uikit/I;", "Lio/noties/markwon/image/k;", "<init>", "()V", "Lu8/g;", "config", "Lu8/r;", "props", "", Const.INTENT_KEY_APIKEY, "(Lu8/g;Lu8/r;)Ljava/lang/Object;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class I extends io.noties.markwon.image.k {
    @Override // io.noties.markwon.image.k, u8.u
    public Object a(u8.g config, u8.r props) {
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(props, "props");
        C5671a c5671aG = config.g();
        kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
        io.noties.markwon.image.a aVar = new io.noties.markwon.image.a(io.noties.markwon.image.g.f34287a.d(props), config.a(), config.c(), io.noties.markwon.image.g.f34289c.a(props));
        Boolean boolB = io.noties.markwon.image.g.f34288b.b(props, Boolean.FALSE);
        kotlin.jvm.internal.p.h(boolB, "get(...)");
        return new C2147v(c5671aG, aVar, 0, boolB.booleanValue());
    }
}
