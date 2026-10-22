package com.stepos.stepclaw.provider;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.backend.IConfigStore;
import com.stepos.stepclaw.provider.backend.OpenClawProviderBackend;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Z"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.provider.OpenClawProvider$insert$ok$1", f = "OpenClawProvider.kt", l = {151}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class OpenClawProvider$insert$ok$1 extends i implements p {
    int label;

    public OpenClawProvider$insert$ok$1(c cVar) {
        super(2, cVar);
    }

    @Override // h5.a
    public final c create(Object obj, c cVar) {
        return new OpenClawProvider$insert$ok$1(cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, c cVar) {
        return ((OpenClawProvider$insert$ok$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        boolean zBooleanValue;
        IConfigStore config;
        a aVar = a.f2984a;
        int i8 = this.label;
        if (i8 == 0) {
            a.a.c0(obj);
            OpenClawProviderBackend.Backend backend = OpenClawProviderBackend.INSTANCE.get();
            if (backend == null || (config = backend.getConfig()) == null) {
                zBooleanValue = false;
                return Boolean.valueOf(zBooleanValue);
            }
            this.label = 1;
            obj = config.restoreFromBackup(this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
        }
        zBooleanValue = ((Boolean) obj).booleanValue();
        return Boolean.valueOf(zBooleanValue);
    }
}
