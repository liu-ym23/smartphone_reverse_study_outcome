package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class DiscardUnknownFieldsParser {
    public static final <T extends Message> Parser<T> wrap(Parser<T> r2) {
        final Parser r3 = (Parser) ZeusTransformUtils.wrapperContextForParams(r2, Parser.class, "com.obric.aiagent.plugin");
        return new AnonymousClass1(r3);
    }

    private DiscardUnknownFieldsParser() {
    }
}
