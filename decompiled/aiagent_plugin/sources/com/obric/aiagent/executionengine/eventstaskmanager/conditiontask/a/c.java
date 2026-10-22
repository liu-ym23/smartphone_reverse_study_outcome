package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;

/* JADX INFO: compiled from: EveryOffDayTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public c() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public boolean a(TimeCondition r1, PeriodicPolicy r2) {
        o.e(r1, "condition");
        o.e(r2, "policy");
        return r2.getEveryOffDay();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object, java.time.LocalDateTime] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public ZonedDateTime a(h r6) {
        o.e(r6, AutoTestConstant.PARAM);
        ZonedDateTime r5 = a(r6.d(), r6);
        if (r6.a().isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5, ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L8;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a r0 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a.f16880a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        LocalDate r3 = r5.toLocalDate();
        o.c(r3, "toLocalDate(...)");
        if (r0.a(r1, r3).a() == false) goto L8;
        return r5;
    L8:
        if (r6.a().toLocalDate().compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6.d().toLocalDate(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) >= 0) goto L10;
        ZonedDateTime r7 = r6.d();
    L11:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a r2 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a.f16880a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ?? r8 = r7.toLocalDateTime();
        o.c(r8, "toLocalDateTime(...)");
        LocalDate r9 = r2.a(r4, r8);
        if (r9 != null) goto L16;
        return null;
    L16:
        return ZonedDateTime.of(r9, r6.e(), r6.d().getZone());
    L10:
        r7 = r6.a().plusDays(1);
        goto L11
    }
}
