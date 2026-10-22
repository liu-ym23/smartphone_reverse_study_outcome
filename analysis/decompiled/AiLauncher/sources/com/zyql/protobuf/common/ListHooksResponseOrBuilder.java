package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes4.dex */
public interface ListHooksResponseOrBuilder extends MessageLiteOrBuilder {
    String getError();

    ByteString getErrorBytes();

    HookDefinition getHooks(int i10);

    int getHooksCount();

    List<HookDefinition> getHooksList();
}
