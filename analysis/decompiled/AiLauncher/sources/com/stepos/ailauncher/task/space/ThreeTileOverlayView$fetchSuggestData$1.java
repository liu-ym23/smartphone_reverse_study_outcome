package com.stepos.ailauncher.task.space;

import com.stepos.ailauncher.network.model.RecommendCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.ThreeTileOverlayView$fetchSuggestData$1", f = "ThreeTileOverlayView.kt", l = {4023, 4026}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ThreeTileOverlayView$fetchSuggestData$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ThreeTileOverlayView this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.space.ThreeTileOverlayView$fetchSuggestData$1$1", f = "ThreeTileOverlayView.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.space.ThreeTileOverlayView$fetchSuggestData$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<RecommendCard> $cards;
        int label;
        final /* synthetic */ ThreeTileOverlayView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ThreeTileOverlayView threeTileOverlayView, List<RecommendCard> list, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = threeTileOverlayView;
            this.$cards = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$cards, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.J2(this.$cards);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreeTileOverlayView$fetchSuggestData$1(ThreeTileOverlayView threeTileOverlayView, InterfaceC4014c<? super ThreeTileOverlayView$fetchSuggestData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = threeTileOverlayView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThreeTileOverlayView$fetchSuggestData$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThreeTileOverlayView$fetchSuggestData$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0083, code lost:
    
        if (Ua.C1056g.j(r1, r3, r7) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r7 = r7.L$0
            java.util.List r7 = (java.util.List) r7
            kotlin.C4849c.b(r8)
            goto L86
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            kotlin.C4849c.b(r8)
            goto L37
        L22:
            kotlin.C4849c.b(r8)
            com.stepos.ailauncher.network.repository.RecommendRepository$Companion r8 = com.stepos.ailauncher.network.repository.RecommendRepository.INSTANCE
            com.stepos.ailauncher.network.repository.RecommendRepository r8 = r8.create()
            r7.label = r3
            java.lang.String r1 = "default"
            r3 = 3
            java.lang.Object r8 = r8.getRecommendCards(r1, r3, r7)
            if (r8 != r0) goto L37
            goto L85
        L37:
            java.util.List r8 = (java.util.List) r8
            int r1 = r8.size()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fetchSuggestData: count="
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " cards="
            r3.append(r1)
            r3.append(r8)
            java.lang.String r1 = " (下发原序，展示会按文案长度重排)"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 0
            r4 = 4
            java.lang.String r5 = "ThreeTileOverlayView"
            r6 = 0
            h8.C4148a.k(r5, r1, r3, r4, r6)
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L86
            Ua.A0 r1 = Ua.Y.c()
            com.stepos.ailauncher.task.space.ThreeTileOverlayView$fetchSuggestData$1$1 r3 = new com.stepos.ailauncher.task.space.ThreeTileOverlayView$fetchSuggestData$1$1
            com.stepos.ailauncher.task.space.ThreeTileOverlayView r4 = r7.this$0
            r3.<init>(r4, r8, r6)
            java.lang.Object r8 = g9.h.a(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r7 = Ua.C1056g.j(r1, r3, r7)
            if (r7 != r0) goto L86
        L85:
            return r0
        L86:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.ThreeTileOverlayView$fetchSuggestData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
