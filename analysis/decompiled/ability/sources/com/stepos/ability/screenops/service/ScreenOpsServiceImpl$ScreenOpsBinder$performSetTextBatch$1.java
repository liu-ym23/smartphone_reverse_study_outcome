package com.stepos.ability.screenops.service;

import android.os.Bundle;
import com.mdisdk.capability.UiCapabilityManager;
import com.stepos.ability.screenops.service.ScreenOpsServiceImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder", f = "ScreenOpsServiceImpl.kt", l = {176}, m = "performSetTextBatch", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsServiceImpl$ScreenOpsBinder$performSetTextBatch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Bundle f3235a;
    public UiCapabilityManager b;
    public String c;
    public ArrayList d;
    public int e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ ScreenOpsServiceImpl.ScreenOpsBinder h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsServiceImpl$ScreenOpsBinder$performSetTextBatch$1(ScreenOpsServiceImpl.ScreenOpsBinder screenOpsBinder, H7.c cVar) {
        super(cVar);
        this.h = screenOpsBinder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.performSetTextBatch(null, this);
    }
}
