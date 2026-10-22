package com.stepos.taskrobot.settingsprovider;

import C7.r;
import J7.c;
import S7.k;
import com.stepos.taskrobot.dictionary.DictionaryManager;
import com.stepos.taskrobot.dictionary.WhitelistResult;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "com.stepos.taskrobot.settingsprovider.WhitelistCacheManager$Companion$create$1", f = "WhitelistCacheManager.kt", l = {82}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/stepos/taskrobot/dictionary/WhitelistResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WhitelistCacheManager$Companion$create$1 extends SuspendLambda implements k {
    int label;

    public WhitelistCacheManager$Companion$create$1(H7.c<? super WhitelistCacheManager$Companion$create$1> cVar) {
        super(1, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(H7.c<?> cVar) {
        return new WhitelistCacheManager$Companion$create$1(cVar);
    }

    @Override // S7.k
    public final Object invoke(H7.c<? super WhitelistResult> cVar) {
        return ((WhitelistCacheManager$Companion$create$1) create(cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        b.b(obj);
        DictionaryManager dictionaryManager = DictionaryManager.INSTANCE;
        this.label = 1;
        Object whitelist = dictionaryManager.getWhitelist(this);
        return whitelist == coroutineSingletons ? coroutineSingletons : whitelist;
    }
}
