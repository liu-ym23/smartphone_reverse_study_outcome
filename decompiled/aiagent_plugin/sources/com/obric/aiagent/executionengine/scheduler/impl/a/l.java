package com.obric.aiagent.executionengine.scheduler.impl.a;

import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.CommonViewEntitiesParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LarkScheduleParamsCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f18143a = null;

    static {
        f18143a = new l();
    }

    private l() {
    }

    public final Parcelable a(String r13, String r14, Parcelable r15) {
        Parcelable r12 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r15, Parcelable.class, "com.obric.aiagent.plugin");
        o.e(r13, "targetPackage");
        o.e(r14, "intentName");
        o.e(r12, "params");
        if (o.a(r13, "com.ss.android.lark") == true) goto L5;
        return r12;
    L5:
        if (o.a(r14, "Common_ViewEntities") == true) goto L7;
        return r12;
    L7:
        if (ZeusTransformUtils.instanceOf(r12, CommonViewEntitiesParams.class) == false) goto L75;
        AppEntity[] r16 = ((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r12, CommonViewEntitiesParams.class, "com.obric.aiagent.plugin")).getEntities();
        if (r16 != null) goto L12;
        return r12;
    L12:
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r16.length), Collection.class, "com.obric.aiagent.plugin");
        int r18 = r16.length;
        int r2 = 0;
        boolean r3 = false;
    L14:
        if (r2 >= r18) goto L52;
        AppEntity r5 = r16[r2];
        if (ZeusTransformUtils.instanceOf(r5, ScheduleEntity.class) == false) goto L51;
        List<ExtraEntity> r6 = r5.getExtras();
        if (r6 == null) goto L37;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L22;
    L24:
        Iterator r8 = r7.iterator();
    L26:
        if (r8.hasNext() == false) goto L23;
        ExtraEntity r9 = (ExtraEntity) ZeusTransformUtils.preCheckCast(r8.next(), ExtraEntity.class, "com.obric.aiagent.plugin");
        if (o.a(r9.getKey(), "extra1") == true) goto L30;
    L32:
        boolean r10 = false;
    L33:
        if (r10 == false) goto L26;
        boolean r11 = true;
    L35:
        if (r11 != true) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == false) goto L51;
        ScheduleEntity r4 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.c().fromJson(EntityExtKt.c().toJson(r5), ScheduleEntity.class), ScheduleEntity.class, "com.obric.aiagent.plugin");
        r4.setExtra(r5.getExtra());
        List<ExtraEntity> r20 = r4.getExtras();
        if (r20 == null) goto L50;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L44:
        if (r21.hasNext() == false) goto L50;
        ExtraEntity r22 = (ExtraEntity) ZeusTransformUtils.preCheckCast(r21.next(), ExtraEntity.class, "com.obric.aiagent.plugin");
        Object r23 = r22.getValue();
        if (o.a(r22.getKey(), "extra1") == false) goto L44;
        if (ZeusTransformUtils.instanceOf(r23, String.class) == false) goto L44;
        r22.setValue(ao.c(new d.m[]{s.a("data_type", String.class.getName()), s.a("value", r23)}));
    L50:
        r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.aiagent.plugin");
        r3 = true;
        goto L51
    L30:
        if (ZeusTransformUtils.instanceOf(r9.getValue(), String.class) == false) goto L32;
        r10 = true;
    L23:
        r11 = false;
        goto L35
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L24;
    L37:
        r19 = false;
    L51:
        r17.add(r5);
        r2 = r2 + 1;
        goto L14
    L52:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
        if (r3 == true) goto L55;
        return r12;
    L55:
        return (Parcelable) ZeusTransformUtils.preCheckCast(CommonViewEntitiesParams.copy$default((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r12, CommonViewEntitiesParams.class, "com.obric.aiagent.plugin"), null, (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.aiagent.plugin"), 1, null), Parcelable.class, "com.obric.aiagent.plugin");
    L75:
        return r12;
    }
}
