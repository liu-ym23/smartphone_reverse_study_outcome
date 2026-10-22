package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugFormat {
    private final boolean isSingleLine;

    private static class LazyDebugOutput {
        private final UnknownFieldSet fields;
        private final DebugFormat format;
        private final MessageOrBuilder message;

        LazyDebugOutput(MessageOrBuilder r3, DebugFormat r4) {
            this.message = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin");
            this.fields = null;
            this.format = r4;
        }

        LazyDebugOutput(UnknownFieldSet r2, DebugFormat r3) {
            this.message = null;
            this.fields = r2;
            this.format = r3;
        }

        public String toString() {
            MessageOrBuilder r0 = this.message;
            if (r0 == null) goto L7;
            return this.format.toString(r0);
        L7:
            return this.format.toString(this.fields);
        }
    }

    private DebugFormat(boolean r1) {
        this.isSingleLine = r1;
    }

    public static DebugFormat singleLine() {
        return new DebugFormat(true);
    }

    public static DebugFormat multiline() {
        return new DebugFormat(false);
    }

    public String toString(MessageOrBuilder r3) {
        MessageOrBuilder r4 = (MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin");
        if (this.isSingleLine == true) goto L7;
        return TextFormat.debugFormatPrinter().printToString(r4, TextFormat.Printer.FieldReporterLevel.DEBUG_MULTILINE);
    L7:
        return TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine).printToString(r4, TextFormat.Printer.FieldReporterLevel.DEBUG_SINGLE_LINE);
    }

    public String toString(Descriptors.FieldDescriptor r2, Object r3) {
        if (this.isSingleLine == true) goto L7;
        return TextFormat.debugFormatPrinter().printFieldToString(r2, r3);
    L7:
        return TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine).printFieldToString(r2, r3);
    }

    public String toString(UnknownFieldSet r2) {
        if (this.isSingleLine == true) goto L7;
        return TextFormat.debugFormatPrinter().printToString(r2);
    L7:
        return TextFormat.debugFormatPrinter().emittingSingleLine(this.isSingleLine).printToString(r2);
    }

    public Object lazyToString(MessageOrBuilder r3) {
        return new LazyDebugOutput((MessageOrBuilder) ZeusTransformUtils.wrapperContextForParams(r3, MessageOrBuilder.class, "com.obric.aiagent.plugin"), this);
    }

    public Object lazyToString(UnknownFieldSet r2) {
        return new LazyDebugOutput(r2, this);
    }
}
