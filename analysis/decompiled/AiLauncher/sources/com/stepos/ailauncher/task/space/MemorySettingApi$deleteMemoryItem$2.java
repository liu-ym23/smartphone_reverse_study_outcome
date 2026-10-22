package com.stepos.ailauncher.task.space;

import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONObject;
import tb.AbstractC5529B;
import tb.AbstractC5531D;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "", "<anonymous>", "(LUa/M;)Ljava/util/Set;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemorySettingApi$deleteMemoryItem$2", f = "MemorySettingApi.kt", l = {605}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MemorySettingApi$deleteMemoryItem$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Set<? extends String>>, Object> {
    final /* synthetic */ List<String> $memoryIds;
    final /* synthetic */ String $memoryName;
    final /* synthetic */ String $tabType;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemorySettingApi$deleteMemoryItem$2(String str, List<String> list, String str2, InterfaceC4014c<? super MemorySettingApi$deleteMemoryItem$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$tabType = str;
        this.$memoryIds = list;
        this.$memoryName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MemorySettingApi$deleteMemoryItem$2(this.$tabType, this.$memoryIds, this.$memoryName, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        return ((MemorySettingApi$deleteMemoryItem$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objIngestMemory;
        List list;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                if (!C1173v.p("about_me", "communication", "memo").contains(this.$tabType)) {
                    return null;
                }
                List<String> list2 = this.$memoryIds;
                ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(La.H.D1((String) it.next()).toString());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (((String) obj2).length() > 0) {
                        arrayList2.add(obj2);
                    }
                }
                List listG0 = Z8.F.g0(arrayList2);
                if (listG0.isEmpty()) {
                    return null;
                }
                MemoryItemParsed memoryItemParsed = new MemoryItemParsed("", "", (String) Z8.F.q0(listG0), this.$memoryName, 0L, false, listG0);
                InterfaceC3667s0 interfaceC3667s0 = (InterfaceC3667s0) HttpManager.INSTANCE.create(InterfaceC3667s0.class, ContentSafetyApi.BASE_URL_KEY);
                String strH = MemorySettingApi.INSTANCE.H();
                AbstractC5529B.Companion companion = AbstractC5529B.INSTANCE;
                String string = J.a(C1172u.e(memoryItemParsed)).toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                AbstractC5529B abstractC5529BB = companion.b(string, MemorySettingApi.JSON_MEDIA_TYPE);
                this.L$0 = listG0;
                this.L$1 = g9.h.a(memoryItemParsed);
                this.L$2 = g9.h.a(interfaceC3667s0);
                this.L$3 = g9.h.a(strH);
                this.L$4 = g9.h.a(abstractC5529BB);
                this.label = 1;
                objIngestMemory = interfaceC3667s0.ingestMemory(strH, abstractC5529BB, this);
                if (objIngestMemory == objG) {
                    return objG;
                }
                list = listG0;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                C4849c.b(obj);
                objIngestMemory = obj;
            }
            JSONObject jSONObject = new JSONObject(((AbstractC5531D) objIngestMemory).A());
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("deleteMemoryItem(ingest): tab=%s, count=%d, status=%s", Arrays.copyOf(new Object[]{this.$tabType, C4109a.f(list.size()), jSONObject.optString("status")}, 3));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d("AILauncher-MemorySetting", str, false, 4, null);
            if (!kotlin.jvm.internal.p.d(jSONObject.optString("status"), "success")) {
                return null;
            }
            MemorySettingApi.INSTANCE.v(this.$tabType, Z8.F.r1(list));
            return Z8.F.r1(list);
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            C4148a.g("AILauncher-MemorySetting", "deleteMemoryItem exception", e11, false, 8, null);
            return null;
        }
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Set<? extends String>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Set<String>>) interfaceC4014c);
    }
}
