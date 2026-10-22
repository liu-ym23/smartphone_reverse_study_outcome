package com.stepos.stepclaw.provider.impl;

import a6.f0;
import a6.i0;
import a6.r0;
import a6.x1;
import android.content.Context;
import b5.a0;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.chroot.ChrootRootfsInitializer;
import com.stepos.stepclaw.gateway.GatewayAutoStart;
import com.stepos.stepclaw.provider.backend.IGatewayManager;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import h6.d;
import kotlin.Metadata;
import org.bouncycastle.asn1.BERTags;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/stepclaw/provider/impl/GatewayManagerImpl;", "Lcom/stepos/stepclaw/provider/backend/IGatewayManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isReady", "()Z", "restart", "Landroid/content/Context;", "La6/f0;", "restartScope", "La6/f0;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayManagerImpl implements IGatewayManager {
    private final Context context;
    private final f0 restartScope;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.provider.impl.GatewayManagerImpl$restart$1", f = "GatewayManagerImpl.kt", l = {BERTags.GRAPHIC_STRING}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.provider.impl.GatewayManagerImpl$restart$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass1(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            AnonymousClass1 anonymousClass1 = GatewayManagerImpl.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            f0 f0Var = (f0) this.L$0;
            a aVar = a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                ChrootRootfsInitializer chrootRootfsInitializer = new ChrootRootfsInitializer(GatewayManagerImpl.this.context, OpenClawRuntimeConfig.INSTANCE.fromContext(GatewayManagerImpl.this.context), null, null, 12, null);
                this.L$0 = f0Var;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 1;
                obj = chrootRootfsInitializer.initialize(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            a0 a0Var = a0.f883a;
            if (!zBooleanValue) {
                return a0Var;
            }
            GatewayAutoStart.restartGateway$default(GatewayAutoStart.INSTANCE, GatewayManagerImpl.this.context, f0Var, 18789, null, null, null, 56, null);
            return a0Var;
        }
    }

    public GatewayManagerImpl(Context context) {
        kotlin.jvm.internal.p.e(context, "context");
        this.context = context;
        x1 x1VarC = i0.c();
        h6.e eVar = r0.f210a;
        this.restartScope = i0.b(h.I(x1VarC, d.f3059c));
    }

    @Override // com.stepos.stepclaw.provider.backend.IGatewayManager
    public boolean isReady() {
        return GatewayAutoStart.INSTANCE.isStarted();
    }

    @Override // com.stepos.stepclaw.provider.backend.IGatewayManager
    public boolean restart() {
        i0.q(this.restartScope, null, new AnonymousClass1(null), 3);
        return true;
    }
}
