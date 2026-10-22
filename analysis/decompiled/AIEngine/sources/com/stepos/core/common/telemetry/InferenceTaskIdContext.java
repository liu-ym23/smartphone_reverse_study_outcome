package com.stepos.core.common.telemetry;

import kotlin.coroutines.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InferenceTaskIdContext extends kotlin.coroutines.a {
    public static final Key Key = new Key(null);
    private final String taskId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key implements d.b<InferenceTaskIdContext> {
        public /* synthetic */ Key(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Key() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InferenceTaskIdContext(String taskId) {
        super(Key);
        kotlin.jvm.internal.g.f(taskId, "taskId");
        this.taskId = taskId;
    }

    public final String getTaskId() {
        return this.taskId;
    }
}
