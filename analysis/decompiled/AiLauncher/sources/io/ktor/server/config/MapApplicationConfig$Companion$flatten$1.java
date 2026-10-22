package io.ktor.server.config;

import Ka.j;
import Ka.l;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.config.MapApplicationConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LKa/l;", "Lkotlin/Pair;", "", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.config.MapApplicationConfig$Companion$flatten$1", f = "MapApplicationConfig.kt", l = {26, 27, 28}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class MapApplicationConfig$Companion$flatten$1 extends RestrictedSuspendLambda implements p<l<? super Pair<? extends String, ? extends String>>, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $prefix;
    final /* synthetic */ Map<String, Object> $this_flatten;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapApplicationConfig$Companion$flatten$1(Map<String, ? extends Object> map, String str, InterfaceC4014c<? super MapApplicationConfig$Companion$flatten$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_flatten = map;
        this.$prefix = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MapApplicationConfig$Companion$flatten$1 mapApplicationConfig$Companion$flatten$1 = new MapApplicationConfig$Companion$flatten$1(this.$this_flatten, this.$prefix, interfaceC4014c);
        mapApplicationConfig$Companion$flatten$1.L$0 = obj;
        return mapApplicationConfig$Companion$flatten$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<? super Pair<String, String>> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((MapApplicationConfig$Companion$flatten$1) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Iterator<Map.Entry<String, Object>> it;
        l lVar;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            l lVar2 = (l) this.L$0;
            it = this.$this_flatten.entrySet().iterator();
            lVar = lVar2;
        } else {
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            lVar = (l) this.L$0;
            C4849c.b(obj);
        }
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            String strCombine = MapApplicationConfigKt.combine(this.$prefix, key);
            if (value != null) {
                if (value instanceof List) {
                    j<Pair<String, String>> jVarFlatten$ktor_server_core = MapApplicationConfig.INSTANCE.flatten$ktor_server_core((List<? extends Object>) value, strCombine);
                    this.L$0 = lVar;
                    this.L$1 = it;
                    this.label = 1;
                    if (lVar.c(jVarFlatten$ktor_server_core, this) == objG) {
                        return objG;
                    }
                } else if (value instanceof Map) {
                    MapApplicationConfig.Companion companion = MapApplicationConfig.INSTANCE;
                    kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                    j<Pair<String, String>> jVarFlatten$ktor_server_core2 = companion.flatten$ktor_server_core((Map<String, ? extends Object>) value, strCombine);
                    this.L$0 = lVar;
                    this.L$1 = it;
                    this.label = 2;
                    if (lVar.c(jVarFlatten$ktor_server_core2, this) == objG) {
                        return objG;
                    }
                } else {
                    Pair pairA = Y8.j.a(strCombine, value.toString());
                    this.L$0 = lVar;
                    this.L$1 = it;
                    this.label = 3;
                    if (lVar.a(pairA, this) == objG) {
                        return objG;
                    }
                }
            }
        }
        return t.f7040a;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(l<? super Pair<? extends String, ? extends String>> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke2((l<? super Pair<String, String>>) lVar, interfaceC4014c);
    }
}
