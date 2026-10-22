package io.ktor.http.content;

import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.l;
import p9.p;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultipartKt$sam$kotlinx_coroutines_flow_FlowCollector$0 implements Xa.c, l {
    private final /* synthetic */ p function;

    public MultipartKt$sam$kotlinx_coroutines_flow_FlowCollector$0(p function) {
        kotlin.jvm.internal.p.i(function, "function");
        this.function = function;
    }

    @Override // Xa.c
    public final /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
        return this.function.invoke(obj, interfaceC4014c);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Xa.c) && (obj instanceof l)) {
            return kotlin.jvm.internal.p.d(getFunctionDelegate(), ((l) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.l
    public final Y8.e<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
