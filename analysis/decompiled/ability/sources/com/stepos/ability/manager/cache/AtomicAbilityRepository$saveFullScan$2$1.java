package com.stepos.ability.manager.cache;

import C7.r;
import S7.k;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$2$1", f = "AtomicAbilityRepository.kt", l = {63, ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL, 70, 74}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$saveFullScan$2$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public List f3123a;
    public a b;
    public Iterator c;
    public int d;
    public int e;
    public final /* synthetic */ List f;
    public final /* synthetic */ a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$saveFullScan$2$1(List list, a aVar, H7.c cVar) {
        super(1, cVar);
        this.f = list;
        this.g = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new AtomicAbilityRepository$saveFullScan$2$1(this.f, this.g, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((AtomicAbilityRepository$saveFullScan$2$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
    
        if (r2 == r3) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
