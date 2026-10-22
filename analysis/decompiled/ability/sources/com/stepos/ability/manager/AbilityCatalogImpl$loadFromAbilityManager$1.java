package com.stepos.ability.manager;

import J7.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.AbilityCatalogImpl", f = "AbilityCatalogImpl.kt", l = {45, 49, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "loadFromAbilityManager", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityCatalogImpl$loadFromAbilityManager$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Collection f3102a;
    public Object b;
    public Iterator c;
    public int d;
    public int e;
    public int f;
    public /* synthetic */ Object g;
    public final /* synthetic */ a h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityCatalogImpl$loadFromAbilityManager$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.a(null, this);
    }
}
