package com.stepos.ability.manager.cache;

import C7.r;
import S7.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;

@J7.c(c = "com.stepos.ability.manager.cache.AtomicAbilityRepository$mergeCloudAbilities$2$1", f = "AtomicAbilityRepository.kt", l = {172, 175}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AtomicAbilityRepository$mergeCloudAbilities$2$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public Ref$IntRef f3120a;
    public Map b;
    public a c;
    public Ref$IntRef d;
    public Ref$IntRef e;
    public Iterator f;
    public int g;
    public int h;
    public final /* synthetic */ List i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f3121j;
    public final /* synthetic */ LinkedHashMap k;
    public final /* synthetic */ a l;
    public final /* synthetic */ Ref$IntRef m;
    public final /* synthetic */ Ref$IntRef n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtomicAbilityRepository$mergeCloudAbilities$2$1(List list, Ref$IntRef ref$IntRef, LinkedHashMap linkedHashMap, a aVar, Ref$IntRef ref$IntRef2, Ref$IntRef ref$IntRef3, H7.c cVar) {
        super(1, cVar);
        this.i = list;
        this.f3121j = ref$IntRef;
        this.k = linkedHashMap;
        this.l = aVar;
        this.m = ref$IntRef2;
        this.n = ref$IntRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new AtomicAbilityRepository$mergeCloudAbilities$2$1(this.i, this.f3121j, this.k, this.l, this.m, this.n, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((AtomicAbilityRepository$mergeCloudAbilities$2$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x039a, code lost:
    
        if (r3.insertOrReplace(r15, r42) != r1) goto L160;
     */
    /* JADX WARN: Path cross not found for [B:134:0x02fb, B:126:0x02e6], limit reached: 154 */
    /* JADX WARN: Path cross not found for [B:141:0x031e, B:145:0x0328], limit reached: 154 */
    /* JADX WARN: Path cross not found for [B:148:0x0331, B:152:0x033f], limit reached: 154 */
    /* JADX WARN: Path cross not found for [B:16:0x008a, B:15:0x0087], limit reached: 154 */
    /* JADX WARN: Path cross not found for [B:65:0x016a, B:56:0x0156], limit reached: 154 */
    /* JADX WARN: Path cross not found for [B:80:0x01b7, B:84:0x01c5], limit reached: 154 */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0264  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x039a -> B:160:0x039d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x03a3 -> B:162:0x03a8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r43) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.AtomicAbilityRepository$mergeCloudAbilities$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
