package com.stepos.ability.manager.discovery;

import J7.c;
import android.content.Context;
import com.stepos.ability.commoninternal.AppInfoUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor", f = "AbilityDiscoveryProcessor.kt", l = {182}, m = "buildDeviceAppRequest", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityDiscoveryProcessor$buildDeviceAppRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f3136a;
    public Map b;
    public Map c;
    public Map d;
    public Map e;
    public Map f;
    public List g;
    public Iterator h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public AppInfoUtils.AppInfo f3137j;
    public /* synthetic */ Object k;
    public final /* synthetic */ a l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityDiscoveryProcessor$buildDeviceAppRequest$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.l = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.k = obj;
        this.m |= Integer.MIN_VALUE;
        return this.l.a(null, null, null, null, null, null, this);
    }
}
