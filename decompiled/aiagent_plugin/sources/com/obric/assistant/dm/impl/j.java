package com.obric.assistant.dm.impl;

import android.app.Application;
import android.content.Context;
import com.obric.agent.IEntityManager;
import com.obric.aiagent.assistant.idl.bean.TextEntity;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f22497a = null;

    static {
        f22497a = new j();
    }

    private j() {
    }

    public final boolean a(String r2) {
        o.e(r2, "type");
        String r1 = r2.toLowerCase(Locale.ROOT);
        o.c(r1, "toLowerCase(...)");
        if (o.a(r1, d.f22483a.a()) == false) goto L5;
    L26:
        return true;
    L5:
        if (o.a(r1, d.f22484b.a()) == true) goto L26;
        if (o.a(r1, d.f22485c.a()) == true) goto L26;
        if (o.a(r1, d.i.a()) == true) goto L26;
        if (o.a(r1, d.f22486d.a()) == true) goto L26;
        if (o.a(r1, d.f22487e.a()) == true) goto L26;
        if (o.a(r1, d.h.a()) == true) goto L26;
        if (o.a(r1, d.l.a()) == true) goto L26;
        if (o.a(r1, d.f.a()) == false) goto L22;
        return false;
    L22:
        if (o.a(r1, d.g.a()) == false) goto L24;
        return false;
    L24:
        if (o.a(r1, d.j.a()) == true) goto L30;
        o.a(r1, d.k.a());
        return false;
    L30:
        return false;
    }

    public final List<AppEntity> a(List<String> r8, String r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "values");
        o.e(r9, "type");
        ArrayList r0 = new ArrayList();
        if (o.a(r9, d.l.a()) == false) goto L9;
        Iterator r7 = r10.iterator();
    L6:
        if (r7.hasNext() == false) goto L51;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        TextEntity r12 = new TextEntity(r11);
        ISecureLogDepend.Companion.i("getEntities", "getTextEntity v:" + r11 + " txtEntity:" + r12);
        r0.add(r12);
    L51:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L9:
        if (o.a(r9, d.m.a()) == false) goto L42;
        Iterator r13 = r10.iterator();
    L12:
        if (r13.hasNext() == false) goto L51;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L16
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        Object r4 = n.f((ContactEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r14, ContactEntity.class), ContactEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L18:
        Throwable r5 = n.c(r4);
        if (r5 != null) goto L54;
    L25:
        Throwable r6 = n.c(r4);
        if (r6 != null) goto L56;
    L32:
        Throwable r15 = n.c(r4);
        if (r15 == null) goto L36;
        ISecureLogDepend.Companion.w("getEntities", "getContactEntity parse failed, skip candidate", r15);
    L36:
        if (n.b(r4) == false) goto L38;
        r4 = null;
    L38:
        ContactEntity r16 = (ContactEntity) ZeusTransformUtils.preCheckCast(r4, ContactEntity.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L12;
        ISecureLogDepend.Companion.i("getEntities", "getContactEntity v:" + r14 + " contactEntity:" + r16);
        r0.add(r16);
        goto L12
    L56:
        n.a r17 = n.f38560a;     // Catch: Throwable -> L30
        ISecureLogDepend.Companion.w("getEntities", "getContactEntity entityKeepTimeStampGson failed, fallback to gson", r6);     // Catch: Throwable -> L30
        r4 = n.f((ContactEntity) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r14, ContactEntity.class), ContactEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        n.a r18 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L32
    L54:
        n.a r19 = n.f38560a;     // Catch: Throwable -> L23
        ISecureLogDepend.Companion.w("getEntities", "getContactEntity entityGson failed, fallback to entityKeepTimeStampGson", r5);     // Catch: Throwable -> L23
        r4 = n.f((ContactEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.c().fromJson(r14, ContactEntity.class), ContactEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        n.a r20 = n.f38560a;
        r4 = n.f(d.o.a(th));
    L16:
        th = move-exception;
        n.a r21 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L18
    L42:
        Iterator r22 = r10.iterator();
    L44:
        if (r22.hasNext() == false) goto L51;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.aiagent.plugin");
        IEntityManager r24 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L44;
        List<AppEntity> r25 = r24.getEntityByEcaId(r23);
        if (r25 == null) goto L44;
        ISecureLogDepend.Companion.i("getEntities", "getEntityByEcaId e:" + r23 + " result:" + r25);
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin"));
        goto L44
    }

    public final String a(int r3) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r4 = r2.getString(r3);
    L6:
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4;
    L5:
        r4 = null;
        goto L6
    }
}
