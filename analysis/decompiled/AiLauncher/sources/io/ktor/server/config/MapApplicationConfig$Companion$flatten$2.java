package io.ktor.server.config;

import Ka.l;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LKa/l;", "Lkotlin/Pair;", "", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.config.MapApplicationConfig$Companion$flatten$2", f = "MapApplicationConfig.kt", l = {41, 42, 43, 46}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class MapApplicationConfig$Companion$flatten$2 extends RestrictedSuspendLambda implements p<l<? super Pair<? extends String, ? extends String>>, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $prefix;
    final /* synthetic */ List<Object> $this_flatten;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapApplicationConfig$Companion$flatten$2(List<? extends Object> list, String str, InterfaceC4014c<? super MapApplicationConfig$Companion$flatten$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_flatten = list;
        this.$prefix = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MapApplicationConfig$Companion$flatten$2 mapApplicationConfig$Companion$flatten$2 = new MapApplicationConfig$Companion$flatten$2(this.$this_flatten, this.$prefix, interfaceC4014c);
        mapApplicationConfig$Companion$flatten$2.L$0 = obj;
        return mapApplicationConfig$Companion$flatten$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<? super Pair<String, String>> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((MapApplicationConfig$Companion$flatten$2) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        if (r7.c(r11, r10) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        if (r7.c(r11, r10) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
    
        if (r7.a(r11, r10) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
    
        if (r7.a(r11, r10) == r0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:29:0x009c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:29:0x009c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:29:0x009c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0099 -> B:29:0x009c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2e
            if (r1 == r5) goto L21
            if (r1 == r4) goto L21
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            kotlin.C4849c.b(r11)
            goto Lc0
        L19:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L21:
            int r1 = r10.I$1
            int r6 = r10.I$0
            java.lang.Object r7 = r10.L$0
            Ka.l r7 = (Ka.l) r7
            kotlin.C4849c.b(r11)
            goto L9c
        L2e:
            kotlin.C4849c.b(r11)
            java.lang.Object r11 = r10.L$0
            Ka.l r11 = (Ka.l) r11
            java.util.List<java.lang.Object> r1 = r10.$this_flatten
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r6 = 0
            r7 = r11
        L3f:
            if (r6 >= r1) goto L9e
            java.lang.String r11 = r10.$prefix
            java.lang.String r11 = io.ktor.server.config.MapApplicationConfigKt.access$combine(r11, r6)
            java.util.List<java.lang.Object> r8 = r10.$this_flatten
            java.lang.Object r8 = r8.get(r6)
            if (r8 == 0) goto L9c
            boolean r9 = r8 instanceof java.util.List
            if (r9 == 0) goto L6a
            io.ktor.server.config.MapApplicationConfig$Companion r9 = io.ktor.server.config.MapApplicationConfig.INSTANCE
            java.util.List r8 = (java.util.List) r8
            Ka.j r11 = r9.flatten$ktor_server_core(r8, r11)
            r10.L$0 = r7
            r10.I$0 = r6
            r10.I$1 = r1
            r10.label = r5
            java.lang.Object r11 = r7.c(r11, r10)
            if (r11 != r0) goto L9c
            goto Lbf
        L6a:
            boolean r9 = r8 instanceof java.util.Map
            if (r9 == 0) goto L85
            io.ktor.server.config.MapApplicationConfig$Companion r9 = io.ktor.server.config.MapApplicationConfig.INSTANCE
            java.util.Map r8 = (java.util.Map) r8
            Ka.j r11 = r9.flatten$ktor_server_core(r8, r11)
            r10.L$0 = r7
            r10.I$0 = r6
            r10.I$1 = r1
            r10.label = r4
            java.lang.Object r11 = r7.c(r11, r10)
            if (r11 != r0) goto L9c
            goto Lbf
        L85:
            java.lang.String r8 = r8.toString()
            kotlin.Pair r11 = Y8.j.a(r11, r8)
            r10.L$0 = r7
            r10.I$0 = r6
            r10.I$1 = r1
            r10.label = r3
            java.lang.Object r11 = r7.a(r11, r10)
            if (r11 != r0) goto L9c
            goto Lbf
        L9c:
            int r6 = r6 + r5
            goto L3f
        L9e:
            java.lang.String r11 = r10.$prefix
            java.lang.String r1 = "size"
            java.lang.String r11 = io.ktor.server.config.MapApplicationConfigKt.access$combine(r11, r1)
            java.util.List<java.lang.Object> r1 = r10.$this_flatten
            int r1 = r1.size()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            kotlin.Pair r11 = Y8.j.a(r11, r1)
            r1 = 0
            r10.L$0 = r1
            r10.label = r2
            java.lang.Object r10 = r7.a(r11, r10)
            if (r10 != r0) goto Lc0
        Lbf:
            return r0
        Lc0:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.config.MapApplicationConfig$Companion$flatten$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(l<? super Pair<? extends String, ? extends String>> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke2((l<? super Pair<String, String>>) lVar, interfaceC4014c);
    }
}
