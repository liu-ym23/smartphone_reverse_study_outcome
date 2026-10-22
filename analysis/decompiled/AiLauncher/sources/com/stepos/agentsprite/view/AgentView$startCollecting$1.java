package com.stepos.agentsprite.view;

import L4.AgentEmotion;
import L4.AgentPlace;
import L4.AgentSkin;
import L4.e;
import L4.l;
import M4.c;
import M4.g;
import Ua.M;
import Xa.b;
import Xa.d;
import Y8.j;
import Y8.t;
import com.stepos.agentsprite.view.AgentView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "com.stepos.agentsprite.view.AgentView$startCollecting$1", f = "AgentView.kt", l = {436}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AgentView$startCollecting$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f23461a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f23462b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AgentView f23463c;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"LL4/l;", "s", "LL4/c;", "e", "LL4/h;", "k", "LL4/e;", "n", "LL4/f;", "p", "Lcom/stepos/agentsprite/view/AgentView$b;", "<anonymous>", "(LL4/l;LL4/c;LL4/h;LL4/e;LL4/f;)Lcom/stepos/agentsprite/view/AgentView$b;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "com.stepos.agentsprite.view.AgentView$startCollecting$1$1", f = "AgentView.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.agentsprite.view.AgentView$startCollecting$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.t<l, AgentEmotion, AgentSkin, e, AgentPlace, InterfaceC4014c<? super AgentView.BodyDimensionSnapshot>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f23464a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f23465b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f23466c;

        /* renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f23467d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f23468e;

        /* renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f23469f;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(6, interfaceC4014c);
        }

        @Override // p9.t
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object m(l lVar, AgentEmotion agentEmotion, AgentSkin agentSkin, e eVar, AgentPlace agentPlace, InterfaceC4014c<? super AgentView.BodyDimensionSnapshot> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.f23465b = lVar;
            anonymousClass1.f23466c = agentEmotion;
            anonymousClass1.f23467d = agentSkin;
            anonymousClass1.f23468e = eVar;
            anonymousClass1.f23469f = agentPlace;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f23464a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return new AgentView.BodyDimensionSnapshot((l) this.f23465b, (AgentEmotion) this.f23466c, (AgentSkin) this.f23467d, (e) this.f23468e, (AgentPlace) this.f23469f);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/stepos/agentsprite/view/AgentView$b;", "dims", "", "pkg", "Lkotlin/Pair;", "<anonymous>", "(Lcom/stepos/agentsprite/view/AgentView$b;Ljava/lang/String;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "com.stepos.agentsprite.view.AgentView$startCollecting$1$2", f = "AgentView.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.agentsprite.view.AgentView$startCollecting$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements q<AgentView.BodyDimensionSnapshot, String, InterfaceC4014c<? super Pair<? extends AgentView.BodyDimensionSnapshot, ? extends String>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f23470a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f23471b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f23472c;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AgentView.BodyDimensionSnapshot bodyDimensionSnapshot, String str, InterfaceC4014c<? super Pair<AgentView.BodyDimensionSnapshot, String>> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c);
            anonymousClass2.f23471b = bodyDimensionSnapshot;
            anonymousClass2.f23472c = str;
            return anonymousClass2.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f23470a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return j.a((AgentView.BodyDimensionSnapshot) this.f23471b, (String) this.f23472c);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/stepos/agentsprite/view/AgentView$b;", "", "<destruct>", "LL4/a;", "ratio", "Lcom/stepos/agentsprite/view/AgentView$a;", "<anonymous>", "(Lkotlin/Pair;LL4/a;)Lcom/stepos/agentsprite/view/AgentView$a;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "com.stepos.agentsprite.view.AgentView$startCollecting$1$3", f = "AgentView.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.agentsprite.view.AgentView$startCollecting$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements q<Pair<? extends AgentView.BodyDimensionSnapshot, ? extends String>, L4.a, InterfaceC4014c<? super AgentView.AssetSnapshot>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f23473a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f23474b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f23475c;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Pair<AgentView.BodyDimensionSnapshot, String> pair, L4.a aVar, InterfaceC4014c<? super AgentView.AssetSnapshot> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(interfaceC4014c);
            anonymousClass3.f23474b = pair;
            anonymousClass3.f23475c = aVar;
            return anonymousClass3.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f23473a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            Pair pair = (Pair) this.f23474b;
            L4.a aVar = (L4.a) this.f23475c;
            AgentView.BodyDimensionSnapshot bodyDimensionSnapshot = (AgentView.BodyDimensionSnapshot) pair.a();
            return new AgentView.AssetSnapshot(bodyDimensionSnapshot.getState(), bodyDimensionSnapshot.getEmotion(), bodyDimensionSnapshot.getSkin(), bodyDimensionSnapshot.getNightMode(), bodyDimensionSnapshot.getPlace(), (String) pair.b(), aVar);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> implements Xa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AgentView f23476a;

        public a(AgentView agentView) {
            this.f23476a = agentView;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(AgentView.AssetSnapshot assetSnapshot, InterfaceC4014c<? super t> interfaceC4014c) {
            g resolver;
            c cVar = this.f23476a.controller;
            if (cVar == null || (resolver = cVar.getResolver()) == null) {
                return t.f7040a;
            }
            this.f23476a.resolver = resolver;
            boolean zD = kotlin.jvm.internal.p.d(this.f23476a.currentBackgroundRatio, assetSnapshot.getBackgroundRatio());
            this.f23476a.currentBackgroundRatio = assetSnapshot.getBackgroundRatio();
            this.f23476a.q(assetSnapshot, resolver);
            if (!zD && this.f23476a.currentBodyMode == AgentView.BodyMode.PAG) {
                this.f23476a.G();
            }
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentView$startCollecting$1(c cVar, AgentView agentView, InterfaceC4014c<? super AgentView$startCollecting$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f23462b = cVar;
        this.f23463c = agentView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentView$startCollecting$1(this.f23462b, this.f23463c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentView$startCollecting$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f23461a;
        if (i10 == 0) {
            C4849c.b(obj);
            b bVarQ = d.q(d.C(d.C(d.k(this.f23462b.o(), this.f23462b.j(), this.f23462b.n(), this.f23462b.k(), this.f23462b.l(), new AnonymousClass1(null)), this.f23462b.h(), new AnonymousClass2(null)), this.f23462b.i(), new AnonymousClass3(null)));
            a aVar = new a(this.f23463c);
            this.f23461a = 1;
            if (bVarQ.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
