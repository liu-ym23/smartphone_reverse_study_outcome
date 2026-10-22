package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.eventkit.task.model.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: EventTaskTypeConverters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f16690a = null;

    static {
        Gson r0 = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Condition.class, Type.class, "com.obric.aiagent.plugin"), new a()).registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Condition.class, Type.class, "com.obric.aiagent.plugin"), new b()).create();
        o.c(r0, "create(...)");
        f16690a = r0;
    }

    public static final Gson a() {
        return f16690a;
    }
}
