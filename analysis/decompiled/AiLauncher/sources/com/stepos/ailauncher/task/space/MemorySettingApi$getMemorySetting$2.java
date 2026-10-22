package com.stepos.ailauncher.task.space;

import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONObject;
import tb.AbstractC5529B;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/task/space/t0;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/task/space/t0;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemorySettingApi$getMemorySetting$2", f = "MemorySettingApi.kt", l = {344}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MemorySettingApi$getMemorySetting$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super MemorySettingState>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public MemorySettingApi$getMemorySetting$2(InterfaceC4014c<? super MemorySettingApi$getMemorySetting$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MemorySettingApi$getMemorySetting$2(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super MemorySettingState> interfaceC4014c) {
        return ((MemorySettingApi$getMemorySetting$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC3667s0 interfaceC3667s0 = (InterfaceC3667s0) HttpManager.INSTANCE.create(InterfaceC3667s0.class, ContentSafetyApi.BASE_URL_KEY);
                String strH = MemorySettingApi.INSTANCE.H();
                AbstractC5529B.Companion companion = AbstractC5529B.INSTANCE;
                String string = new JSONObject().toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                AbstractC5529B abstractC5529BB = companion.b(string, MemorySettingApi.JSON_MEDIA_TYPE);
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("getSetting hasToken=%b", Arrays.copyOf(new Object[]{C4109a.a(strH.length() > 0)}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d("AILauncher-MemorySetting", str, false, 4, null);
                this.L$0 = g9.h.a(interfaceC3667s0);
                this.L$1 = g9.h.a(strH);
                this.L$2 = g9.h.a(abstractC5529BB);
                this.label = 1;
                obj = interfaceC3667s0.c(strH, abstractC5529BB, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            MemorySettingResponse memorySettingResponse = (MemorySettingResponse) obj;
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
            String status = memorySettingResponse.getStatus();
            String user_id = memorySettingResponse.getUser_id();
            String str2 = "";
            if (user_id == null) {
                user_id = "";
            }
            String device_id = memorySettingResponse.getDevice_id();
            if (device_id != null) {
                str2 = device_id;
            }
            Boolean memory_share_enabled = memorySettingResponse.getMemory_share_enabled();
            Integer version = memorySettingResponse.getVersion();
            String str3 = String.format("getMemorySetting response: status=%s, user_id=%s, device_id=%s, memory_share_enabled=%s, version=%d", Arrays.copyOf(new Object[]{status, user_id, str2, memory_share_enabled, C4109a.f(version != null ? version.intValue() : -1)}, 5));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.d("AILauncher-MemorySetting", str3, false, 4, null);
            if (!memorySettingResponse.f()) {
                C4148a.d("AILauncher-MemorySetting", "getSetting failed", false, 4, null);
                return null;
            }
            Boolean memory_share_enabled2 = memorySettingResponse.getMemory_share_enabled();
            boolean zBooleanValue = memory_share_enabled2 != null ? memory_share_enabled2.booleanValue() : true;
            Integer version2 = memorySettingResponse.getVersion();
            MemorySettingState memorySettingState = new MemorySettingState(zBooleanValue, version2 != null ? version2.intValue() : -1);
            MemorySettingApi.INSTANCE.y(memorySettingState);
            return memorySettingState;
        } catch (Exception e10) {
            C4148a.g("AILauncher-MemorySetting", "getSetting exception", e10, false, 8, null);
            return null;
        }
    }
}
