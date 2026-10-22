package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class NewInstanceSchemaLite implements NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object r2) {
        return ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.aiagent.plugin")).newMutableInstance();
    }
}
