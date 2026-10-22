package com.stepos.stepclaw.memory;

import a6.f0;
import a6.i0;
import b5.a0;
import com.stepos.stepclaw.gateway.GatewayReconnectDiagnostics;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1", f = "MemoryDumpCommandHandler.kt", l = {378}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1 extends h5.i implements p5.p {
    final /* synthetic */ LightMemClient $c;
    final /* synthetic */ String $uid;
    int label;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1$1", f = "MemoryDumpCommandHandler.kt", l = {379}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.i implements p5.p {
        final /* synthetic */ LightMemClient $c;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LightMemClient lightMemClient, String str, f5.c cVar) {
            super(2, cVar);
            this.$c = lightMemClient;
            this.$uid = str;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass1(this.$c, this.$uid, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
                return obj;
            }
            a.a.c0(obj);
            LightMemClient lightMemClient = this.$c;
            String str = this.$uid;
            this.label = 1;
            Object objOfflineUpdatePoll = lightMemClient.offlineUpdatePoll(str, this);
            return objOfflineUpdatePoll == aVar ? aVar : objOfflineUpdatePoll;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1(LightMemClient lightMemClient, String str, f5.c cVar) {
        super(2, cVar);
        this.$c = lightMemClient;
        this.$uid = str;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1(this.$c, this.$uid, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$c, this.$uid, null);
        this.label = 1;
        Object objB = i0.B(GatewayReconnectDiagnostics.AUTO_START_COOLDOWN_MS, anonymousClass1, this);
        return objB == aVar ? aVar : objB;
    }
}
