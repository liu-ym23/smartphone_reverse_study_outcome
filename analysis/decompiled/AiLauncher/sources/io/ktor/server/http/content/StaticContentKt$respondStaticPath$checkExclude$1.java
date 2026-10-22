package io.ktor.server.http.content;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentKt", f = "StaticContent.kt", l = {810}, m = "respondStaticPath$checkExclude$9")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StaticContentKt$respondStaticPath$checkExclude$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public StaticContentKt$respondStaticPath$checkExclude$1(InterfaceC4014c<? super StaticContentKt$respondStaticPath$checkExclude$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StaticContentKt.respondStaticPath$checkExclude$9(null, null, null, this);
    }
}
