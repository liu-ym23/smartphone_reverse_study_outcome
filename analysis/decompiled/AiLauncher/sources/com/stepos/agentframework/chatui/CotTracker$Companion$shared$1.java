package com.stepos.agentframework.chatui;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class CotTracker$Companion$shared$1 extends FunctionReferenceImpl implements p9.q<String, String, Map<String, ? extends String>, Y8.t> {
    public CotTracker$Companion$shared$1(Object obj) {
        super(3, obj, kotlin.N.class, "onEvent", "onEvent(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", 0);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ Y8.t invoke(String str, String str2, Map<String, ? extends String> map) {
        l(str, str2, map);
        return Y8.t.f7040a;
    }

    public final void l(String p02, String str, Map<String, String> map) {
        kotlin.jvm.internal.p.i(p02, "p0");
        kotlin.N.a(p02, str, map);
    }
}
