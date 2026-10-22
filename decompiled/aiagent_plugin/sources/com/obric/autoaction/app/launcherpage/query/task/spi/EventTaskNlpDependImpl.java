package com.obric.autoaction.app.launcherpage.query.task.spi;

import android.content.Context;
import com.obric.autoaction.app.launcherpage.detail.base.a.c;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.event.task.nlp.api.i;
import com.obric.event.task.nlp.spi.IEventTaskNlpDepend;
import com.obric.eventkit.task.model.ConditionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.k;
import d.o;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskNlpDependImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EventTaskNlpDependImpl implements IEventTaskNlpDepend {
    private final c taskValidator;

    /* JADX INFO: compiled from: EventTaskNlpDependImpl.kt */
    @f(b = "EventTaskNlpDependImpl.kt", c = {51}, d = "checkQuery", e = "com.obric.autoaction.app.launcherpage.query.task.spi.EventTaskNlpDependImpl")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f24365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EventTaskNlpDependImpl f24366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24367c;

        a(EventTaskNlpDependImpl r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24366b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f24365a = r3;
            this.f24367c |= Integer.MIN_VALUE;
            return this.f24366b.checkQuery(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public EventTaskNlpDependImpl() {
        this.taskValidator = new c();
    }

    @Override // com.obric.event.task.nlp.spi.IEventTaskNlpDepend
    public Object appendTaskExtForCard(Map<String, String> r2, String r3, d.c.d<? super Map<String, String>> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super Map<String, String>> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autoaction.app.launcherpage.query.task.a.f24297a.a(r1, r3, r5);
    }

    @Override // com.obric.event.task.nlp.spi.IEventTaskNlpDepend
    public Object showTaskCard(ConditionTask r2, String r3, d.c.d<? super x> r4) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r5 = com.obric.autoaction.app.launcherpage.query.task.a.f24297a.a(r2, r3, r1);
        if (r5 != b.a()) goto L6;
        return r5;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.event.task.nlp.spi.IEventTaskNlpDepend
    public Object handleLocationConditionCandidate(String r2, i r3, Context r4, d.c.d<? super com.obric.event.task.nlp.api.d<i>> r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.event.task.nlp.api.d<i>> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autoaction.app.launcherpage.query.task.b.f24338a.a(r2, r3, r1, r6);
    }

    @Override // com.obric.event.task.nlp.spi.IEventTaskNlpDepend
    public Object checkQuery(String r15, String r16, String r17, d.c.d<? super com.obric.event.task.nlp.api.d<Boolean>> r18) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.f24367c & Integer.MIN_VALUE) == 0) goto L7;
        r3.f24367c -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f24365a;
        Object r4 = b.a();
        int r5 = r3.f24367c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        o.a(r2);
    L17:
        com.obric.autoaction.app.launcherpage.detail.base.a.d r0 = (com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autoaction.app.launcherpage.detail.base.a.d.b.class) == false) goto L21;
        return new com.obric.event.task.nlp.api.d(d.c.b.a.b.a(true), null, 0, null, 10, null);
    L21:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autoaction.app.launcherpage.detail.base.a.d.a.class) == false) goto L25;
        return new com.obric.event.task.nlp.api.d(d.c.b.a.b.a(false), ((com.obric.autoaction.app.launcherpage.detail.base.a.d.a) ZeusTransformUtils.preCheckCast(r0, com.obric.autoaction.app.launcherpage.detail.base.a.d.a.class, "com.obric.aiagent.plugin")).b(), ErrorCode.EventTask.INSTRUCTION_ILLEGAL, null, 8, null);
    L25:
        throw new k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        c r6 = this.taskValidator;
        r3.f24367c = 1;
        r2 = r6.a(r15, r16, r17, r3);
        if (r2 != r4) goto L17;
        return r4;
    L7:
        r3 = new a(this, r1);
        goto L8
    }

    @Override // com.obric.event.task.nlp.spi.IEventTaskNlpDepend
    public int getMaxTaskCount() {
        return com.obric.autoaction.app.launcherpage.detail.condition.b.a();
    }
}
