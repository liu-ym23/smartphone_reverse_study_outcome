package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    ListFieldSchemaLite() {
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object r2, long r3) {
        Internal.ProtobufList r1 = getProtobufList(r2, r3);
        if (r1.isModifiable() == true) goto L10;
        int r0 = r1.size();
        if (r0 != 0) goto L7;
        int r4 = 10;
    L8:
        Internal.ProtobufList r5 = r1.mutableCopyWithCapacity(r4);
        UnsafeUtil.putObject(r2, r3, r5);
        return r5;
    L7:
        r4 = r0 * 2;
        goto L8
    L10:
        return r1;
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object r1, long r2) {
        getProtobufList(r1, r2).makeImmutable();
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object r4, Object r5, long r6) {
        Internal.ProtobufList r3 = getProtobufList(r4, r6);
        Internal.ProtobufList r7 = getProtobufList(r5, r6);
        int r0 = r3.size();
        int r1 = r7.size();
        if (r0 <= 0) goto L9;
        if (r1 <= 0) goto L9;
        if (r3.isModifiable() == true) goto L8;
        r3 = r3.mutableCopyWithCapacity(r1 + r0);
    L8:
        r3.addAll(r7);
    L9:
        if (r0 <= 0) goto L11;
        r7 = r3;
    L11:
        UnsafeUtil.putObject(r4, r6, r7);
    }

    static <E> Internal.ProtobufList<E> getProtobufList(Object r0, long r1) {
        return (Internal.ProtobufList) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), Internal.ProtobufList.class, "com.obric.aiagent.plugin");
    }
}
