package com.obric.appstore.buss.rank;

import android.os.SystemClock;
import com.obric.appstore.base.j;
import com.obric.appstore.base.k;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.template.PageType;
import com.obric.appstore.network.g;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
public final class RankVM extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PageType f10797i;

    public RankVM() {
        this.f10797i = PageType.RANK_APP_PAGE;
    }

    @Override // com.obric.appstore.base.ILoadViewModel
    public Object j(j r10, Continuation r11) {
        if ((r11 instanceof RankVM$doLoad$1) == false) goto L7;
        RankVM$doLoad$1 r12 = (RankVM$doLoad$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        kotlin.c.b(r14);
    L33:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Object r17 = r12.L$0;
        kotlin.c.b(r14);
        return r17;
    L17:
        long r18 = r12.J$1;
        long r19 = r12.J$0;
        kotlin.c.b(r14);
    L24:
        Pair r20 = new Pair(tf.a.d(SystemClock.elapsedRealtime() - r18), (g) r14);
        long r21 = ((Number) r20.component1()).longValue();
        Object r22 = r20.component2();
        if (r21 >= r19) goto L34;
        r12.L$0 = r22;
        r12.label = 2;
        if (DelayKt.b(r19 - r21, r12) != r15) goto L35;
        return r15;
    L35:
        return r22;
    L34:
        return r22;
    L18:
        kotlin.c.b(r14);
        if (o() == false) goto L30;
        r18 = SystemClock.elapsedRealtime();
        StoreRepo r110 = StoreRepo.f10831a;
        PageType r23 = this.f10797i;
        r12.J$0 = 500;
        r12.J$1 = r18;
        r12.label = 1;
        r14 = r110.j(r23, r12);
        if (r14 != r15) goto L23;
        return r15;
    L23:
        r19 = 500;
        goto L24
    L30:
        StoreRepo r111 = StoreRepo.f10831a;
        PageType r24 = this.f10797i;
        r12.label = 3;
        r14 = r111.j(r24, r12);
        if (r14 != r15) goto L33;
        return r15;
    L7:
        r12 = new RankVM$doLoad$1(this, r11);
        goto L8
    }

    public final void v(PageType r10) {
        q.g(r10, "<set-?>");
        this.f10797i = r10;
    }
}
