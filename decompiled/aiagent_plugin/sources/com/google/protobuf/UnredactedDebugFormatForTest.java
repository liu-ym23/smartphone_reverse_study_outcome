package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class UnredactedDebugFormatForTest {
    private UnredactedDebugFormatForTest() {
    }

    public static String unredactedMultilineString(MessageOrBuilder r2) {
        MessageOrBuilder r3 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, MessageOrBuilder.class, "com.obric.aiagent.plugin");
        return TextFormat.printer().printToString(r3, TextFormat.Printer.FieldReporterLevel.TEXT_GENERATOR);
    }

    public static String unredactedMultilineString(UnknownFieldSet r1) {
        return TextFormat.printer().printToString(r1);
    }

    public static String unredactedSingleLineString(MessageOrBuilder r2) {
        MessageOrBuilder r3 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r2, MessageOrBuilder.class, "com.obric.aiagent.plugin");
        return TextFormat.printer().emittingSingleLine(true).printToString(r3, TextFormat.Printer.FieldReporterLevel.TEXT_GENERATOR);
    }

    public static String unredactedSingleLineString(UnknownFieldSet r2) {
        return TextFormat.printer().emittingSingleLine(true).printToString(r2);
    }

    public static String unredactedToString(Object r0) {
        return LegacyUnredactedTextFormat.legacyUnredactedToString(r0);
    }

    public static String unredactedStringValueOf(Object r0) {
        return LegacyUnredactedTextFormat.legacyUnredactedStringValueOf(r0);
    }
}
