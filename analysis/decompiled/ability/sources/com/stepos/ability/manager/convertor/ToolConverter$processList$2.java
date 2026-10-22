package com.stepos.ability.manager.convertor;

import C7.r;
import D7.v;
import D7.w;
import J7.c;
import S7.n;
import b4.C0825a;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.mcp.sdk.java.ServerExt;
import com.stepos.mcp.sdk.java.ToolExt;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.convertor.ToolConverter$processList$2", f = "ToolConverter.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lb4/a;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class ToolConverter$processList$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServerExt f3135a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolConverter$processList$2(ServerExt serverExt, List list, List list2, String str, H7.c cVar) {
        super(2, cVar);
        this.f3135a = serverExt;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ToolConverter$processList$2(this.f3135a, this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ToolConverter$processList$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map mapM;
        String strValueOf;
        List<ToolExt> toolExts;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        b.b(obj);
        ServerExt serverExt = this.f3135a;
        if (serverExt == null || (toolExts = serverExt.getToolExts()) == null) {
            mapM = kotlin.collections.a.M();
        } else {
            mapM = new LinkedHashMap();
            for (ToolExt toolExt : toolExts) {
                mapM.put(toolExt.getToolName(), toolExt);
            }
        }
        List<McpSchema.Tool> list = this.b;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        for (McpSchema.Tool tool : list) {
            String strName = tool.name();
            k.e(strName, "name(...)");
            ToolExt toolExt2 = (ToolExt) mapM.get(strName);
            Object obj2 = toolExt2 != null ? toolExt2.getExt().get(InjectExperienceResult.REASON_TIMEOUT) : null;
            Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
            int iIntValue = num != null ? num.intValue() : -1;
            String str = this.d;
            if (iIntValue == -1) {
                androidx.constraintlayout.core.dsl.a.x("Mcp server no set timeout, tool: ", tool.name(), " by ", str, "ToolConverter");
            }
            String strName2 = tool.name();
            k.e(strName2, "name(...)");
            ToolExt toolExt3 = (ToolExt) mapM.get(strName2);
            Object obj3 = toolExt3 != null ? toolExt3.getExt().get(SLAScene.SLA_SCENE) : null;
            Integer num2 = obj3 instanceof Integer ? (Integer) obj3 : null;
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue2 != 0) {
                strValueOf = String.valueOf(iIntValue2);
            } else {
                androidx.constraintlayout.core.dsl.a.x("Mcp server no set slaScene, tool: ", tool.name(), " by ", str, "ToolConverter");
                strValueOf = null;
            }
            if (iIntValue <= -1) {
                iIntValue = 150;
            }
            arrayList.add(new C0825a(tool, null, iIntValue, strValueOf));
        }
        return v.Q0(this.c, arrayList);
    }
}
