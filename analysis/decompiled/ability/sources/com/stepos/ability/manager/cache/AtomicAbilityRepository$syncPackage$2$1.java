package com.stepos.ability.manager.cache;

import C7.r;
import S7.k;
import android.util.Log;
import com.stepos.ability.net.biz.model.AppItem;
import com.stepos.ability.net.biz.model.ToolItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$2$1", f = "AtomicAbilityRepository.kt", l = {93}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$syncPackage$2$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f3125a;
    public final /* synthetic */ a b;
    public final /* synthetic */ AppItem c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$syncPackage$2$1(a aVar, AppItem appItem, String str, H7.c cVar) {
        super(1, cVar);
        this.b = aVar;
        this.c = appItem;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new AtomicAbilityRepository$syncPackage$2$1(this.b, this.c, this.d, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((AtomicAbilityRepository$syncPackage$2$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3125a;
        AppItem appItem = this.c;
        if (i == 0) {
            kotlin.b.b(obj);
            this.f3125a = 1;
            if (a.a(this.b, appItem, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        List<ToolItem> tools = appItem.getTools();
        return new Integer(Log.i("AtomicAbilityRepository", "syncPackage: package=" + this.d + " tools=" + (tools != null ? tools.size() : 0)));
    }
}
