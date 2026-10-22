package com.obric.autogui.database.impl;

import com.obric.autogui.database.AutoActionDatabase;
import com.obric.autogui.database.service.EventTaskService;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTaskResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.c.a.b;
import d.c.b.a.d;
import d.f;
import d.g;
import d.o;
import java.util.List;

/* JADX INFO: compiled from: EventTaskServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EventTaskServiceImpl implements EventTaskService {
    private final f autoActionDatabase$delegate;

    /* JADX INFO: compiled from: EventTaskServiceImpl.kt */
    @d.c.b.a.f(b = "EventTaskServiceImpl.kt", c = {20, 22}, d = "removeEventTask", e = "com.obric.autogui.database.impl.EventTaskServiceImpl")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskServiceImpl f29049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29050e;

        a(EventTaskServiceImpl r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29049d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29048c = r3;
            this.f29050e |= Integer.MIN_VALUE;
            return this.f29049d.removeEventTask(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ com.obric.autogui.database.a lambda$xo_Tw10QyKb737xkDZfwK7BrjtE() {
        return autoActionDatabase_delegate$lambda$0();
    }

    public EventTaskServiceImpl() {
        this.autoActionDatabase$delegate = g.a($$Lambda$EventTaskServiceImpl$xo_Tw10QyKb737xkDZfwK7BrjtE.INSTANCE);
    }

    private final com.obric.autogui.database.a getAutoActionDatabase() {
        return (com.obric.autogui.database.a) ZeusTransformUtils.preCheckCast(this.autoActionDatabase$delegate.b(), com.obric.autogui.database.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.database.a autoActionDatabase_delegate$lambda$0() {
        return new com.obric.autogui.database.a(AutoActionDatabase.f29019e.a());
    }

    @Override // com.obric.autogui.database.service.EventTaskService
    public Object removeEventTask(String[] r9, d.c.d<? super EventTaskResult> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if ((r0.f29050e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29050e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f29048c;
        Object r2 = b.a();
        int r3 = r0.f29050e;
        boolean r6 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        EventTaskResult r8 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r0.f29046a, EventTaskResult.class, "com.obric.aiagent.plugin");
        o.a(r12);
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (String[]) ZeusTransformUtils.preCheckCast(r0.f29047b, String[].class, "com.obric.aiagent.plugin");
        EventTaskServiceImpl this = (EventTaskServiceImpl) ZeusTransformUtils.preCheckCast(r0.f29046a, EventTaskServiceImpl.class, "com.obric.aiagent.plugin");
        o.a(r12);
    L21:
        String[] r7 = r9;
        EventTaskServiceImpl r13 = this;
        EventTaskResult r14 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r12, EventTaskResult.class, "com.obric.aiagent.plugin");
        String[] r15 = r7;
    L24:
        if (r14 != null) goto L26;
    L28:
        r6 = false;
    L29:
        if (r6 == false) goto L34;
        com.obric.autogui.database.a r16 = r13.getAutoActionDatabase();
        List<String> r17 = i.g(r15);
        r0.f29046a = r14;
        r0.f29047b = null;
        r0.f29050e = 2;
        if (r16.b(r17, r0) != r2) goto L35;
        return r2;
    L35:
        return r14;
    L34:
        return r14;
    L26:
        if (r14.getCode() != 0) goto L28;
    L16:
        o.a(r12);
        IEventTaskApi r18 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L22;
        r0.f29046a = this;
        r0.f29047b = r9;
        r0.f29050e = 1;
        r12 = r18.removeEventTask(r9, r0);
        if (r12 != r2) goto L21;
        return r2;
    L22:
        r15 = r9;
        r13 = this;
        r14 = null;
    L7:
        r0 = new a(this, r11);
        goto L8
    }
}
