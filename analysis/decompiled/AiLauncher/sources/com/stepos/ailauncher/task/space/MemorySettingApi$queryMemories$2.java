package com.stepos.ailauncher.task.space;

import Z8.C1173v;
import com.stepos.ailauncher.task.space.C3636k0;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import tb.AbstractC5529B;
import tb.AbstractC5531D;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "", "", "", "Lcom/stepos/ailauncher/task/space/h0;", "<anonymous>", "(LUa/M;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemorySettingApi$queryMemories$2", f = "MemorySettingApi.kt", l = {424}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MemorySettingApi$queryMemories$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Map<String, List<? extends MemoryItemParsed>>>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public MemorySettingApi$queryMemories$2(InterfaceC4014c<? super MemorySettingApi$queryMemories$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    public static final Y8.t h(String str, JSONObject jSONObject) {
        MemorySettingApi.INSTANCE.x(str, jSONObject);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MemorySettingApi$queryMemories$2(interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Map<String, List<MemoryItemParsed>>> interfaceC4014c) {
        return ((MemorySettingApi$queryMemories$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final String str;
        C3636k0.Ticket ticket;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                MemorySettingApi memorySettingApi = MemorySettingApi.INSTANCE;
                String strD = memorySettingApi.D();
                if (strD == null) {
                    return null;
                }
                C3636k0.Ticket ticketA = MemorySettingApi.memoryQueryGuard.a(strD);
                InterfaceC3667s0 interfaceC3667s0 = (InterfaceC3667s0) HttpManager.INSTANCE.create(InterfaceC3667s0.class, ContentSafetyApi.BASE_URL_KEY);
                String strH = memorySettingApi.H();
                AbstractC5529B.Companion companion = AbstractC5529B.INSTANCE;
                String string = new JSONObject().toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                AbstractC5529B abstractC5529BB = companion.b(string, MemorySettingApi.JSON_MEDIA_TYPE);
                this.L$0 = strD;
                this.L$1 = ticketA;
                this.L$2 = g9.h.a(interfaceC3667s0);
                this.L$3 = g9.h.a(strH);
                this.L$4 = g9.h.a(abstractC5529BB);
                this.label = 1;
                obj = interfaceC3667s0.b(strH, abstractC5529BB, this);
                if (obj == objG) {
                    return objG;
                }
                str = strD;
                ticket = ticketA;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ticket = (C3636k0.Ticket) this.L$1;
                str = (String) this.L$0;
                C4849c.b(obj);
            }
            JSONObject jSONObject = new JSONObject(((AbstractC5531D) obj).A());
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str2 = String.format("queryMemories(ux_memory/get) status=%s, found=%s", Arrays.copyOf(new Object[]{jSONObject.optString("status"), C4109a.a(jSONObject.optBoolean("found"))}, 2));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.d("AILauncher-MemorySetting", str2, false, 4, null);
            final JSONObject jSONObjectA = C3640l0.a(jSONObject);
            if (jSONObjectA == null) {
                C4148a.u("AILauncher-MemorySetting", "queryMemories: failed or invalid response", false, 4, null);
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str3 : C1173v.p("about_me", "communication", "memo")) {
                MemorySettingApi memorySettingApi2 = MemorySettingApi.INSTANCE;
                String strK = memorySettingApi2.K(str3);
                linkedHashMap.put(str3, memorySettingApi2.U(jSONObjectA.optJSONArray(strK), memorySettingApi2.Q(str3), memorySettingApi2.P(str3)));
            }
            if (MemorySettingApi.memoryQueryGuard.b(ticket, MemorySettingApi.INSTANCE.D(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.q0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return MemorySettingApi$queryMemories$2.h(str, jSONObjectA);
                }
            })) {
                return linkedHashMap;
            }
            return null;
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            C4148a.g("AILauncher-MemorySetting", "queryMemories exception", e11, false, 8, null);
            return null;
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Map<String, List<? extends MemoryItemParsed>>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Map<String, List<MemoryItemParsed>>>) interfaceC4014c);
    }
}
