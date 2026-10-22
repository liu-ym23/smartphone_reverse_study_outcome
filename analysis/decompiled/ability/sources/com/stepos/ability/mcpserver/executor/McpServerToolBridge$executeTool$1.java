package com.stepos.ability.mcpserver.executor;

import J7.c;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataResult;
import com.stepos.ability.beaninternal.ability.AiActivityWidgetInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.mcpserver.executor.McpServerToolBridge", f = "McpServerToolBridge.kt", l = {31, 41, 47, 78}, m = "executeTool", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class McpServerToolBridge$executeTool$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3187a;
    public Map b;
    public String c;
    public String d;
    public String e;
    public AbilityMetaDataResult f;
    public String g;
    public AiActivityWidgetInfo h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b f3188j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McpServerToolBridge$executeTool$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3188j = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= Integer.MIN_VALUE;
        return this.f3188j.a(null, null, null, null, null, this);
    }
}
