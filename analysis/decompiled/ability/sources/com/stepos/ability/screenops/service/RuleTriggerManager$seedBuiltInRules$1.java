package com.stepos.ability.screenops.service;

import androidx.appcompat.app.AppCompatDelegate;
import com.uxsense.ruleTrigger.TriggerRule;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import s9.C1923c;

@J7.c(c = "com.stepos.ability.screenops.service.RuleTriggerManager", f = "RuleTriggerManager.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "seedBuiltInRules", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RuleTriggerManager$seedBuiltInRules$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f3230a;
    public TriggerRule b;
    public /* synthetic */ Object c;
    public int d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        C1923c c1923c = c.f3241a;
        return c.a(this);
    }
}
