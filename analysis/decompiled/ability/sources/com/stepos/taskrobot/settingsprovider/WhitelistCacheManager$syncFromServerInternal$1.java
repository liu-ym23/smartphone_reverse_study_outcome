package com.stepos.taskrobot.settingsprovider;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.settingsprovider.WhitelistCacheManager", f = "WhitelistCacheManager.kt", l = {185}, m = "syncFromServerInternal$settingsprovider_release", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WhitelistCacheManager$syncFromServerInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WhitelistCacheManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WhitelistCacheManager$syncFromServerInternal$1(WhitelistCacheManager whitelistCacheManager, H7.c<? super WhitelistCacheManager$syncFromServerInternal$1> cVar) {
        super(cVar);
        this.this$0 = whitelistCacheManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.syncFromServerInternal$settingsprovider_release(this);
    }
}
