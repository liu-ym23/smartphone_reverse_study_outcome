package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream r1) {
        if (r1.wrapper == null) goto L7;
        return r1.wrapper;
    L7:
        return new CodedOutputStreamWriter(r1);
    }

    private CodedOutputStreamWriter(CodedOutputStream r3) {
        CodedOutputStream r4 = (CodedOutputStream) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3, "output"), CodedOutputStream.class, "com.obric.aiagent.plugin");
        this.output = r4;
        r4.wrapper = this;
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int r1, int r2) {
        this.output.writeSFixed32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int r1, long r2) {
        this.output.writeInt64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int r1, long r2) {
        this.output.writeSFixed64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int r1, float r2) {
        this.output.writeFloat(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int r1, double r2) {
        this.output.writeDouble(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int r1, int r2) {
        this.output.writeEnum(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int r1, long r2) {
        this.output.writeUInt64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int r1, int r2) {
        this.output.writeInt32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int r1, long r2) {
        this.output.writeFixed64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int r1, int r2) {
        this.output.writeFixed32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int r1, boolean r2) {
        this.output.writeBool(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int r1, String r2) {
        this.output.writeString(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int r1, ByteString r2) {
        this.output.writeBytes(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int r1, int r2) {
        this.output.writeUInt32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int r1, int r2) {
        this.output.writeSInt32(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int r1, long r2) {
        this.output.writeSInt64(r1, r2);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int r3, Object r4) {
        this.output.writeMessage(r3, (MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int r3, Object r4, Schema r5) {
        Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.aiagent.plugin");
        this.output.writeMessage(r3, (MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroup(int r3, Object r4) {
        this.output.writeGroup(r3, (MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int r3, Object r4, Schema r5) {
        Schema r6 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.aiagent.plugin");
        this.output.writeGroup(r3, (MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int r2) {
        this.output.writeTag(r2, 3);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int r2) {
        this.output.writeTag(r2, 4);
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ByteString.class) == false) goto L5;
        this.output.writeRawMessageSetExtension(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        this.output.writeMessageSetExtension(r3, (MessageLite) ZeusTransformUtils.preCheckCast(r4, MessageLite.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeInt32ListInternal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeInt32ListInternal(r3, r6, r5);
    }

    private void writeInt32ListInternal(int r3, IntArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeInt32SizeNoTag(r4.getInt(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeInt32NoTag(r4.getInt(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeInt32(r3, r4.getInt(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeInt32ListInternal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeInt32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeInt32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeFixed32ListInternal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeFixed32ListInternal(r3, r6, r5);
    }

    private void writeFixed32ListInternal(int r3, IntArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeFixed32SizeNoTag(r4.getInt(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeFixed32NoTag(r4.getInt(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeFixed32(r3, r4.getInt(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeFixed32ListInternal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeFixed32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeFixed32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeFixed32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeInt64ListInternal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeInt64ListInternal(r3, r6, r5);
    }

    private void writeInt64ListInternal(int r4, LongArrayList r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L13;
        this.output.writeTag(r4, 2);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5.size()) goto L8;
        r8 = r8 + CodedOutputStream.computeInt64SizeNoTag(r5.getLong(r7));
        r7 = r7 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r8);
    L10:
        if (r0 >= r5.size()) goto L15;
        this.output.writeInt64NoTag(r5.getLong(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r5.size()) goto L19;
        this.output.writeInt64(r4, r5.getLong(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeInt64ListInternal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.aiagent.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeInt64NoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeInt64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeUInt64ListInternal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeUInt64ListInternal(r3, r6, r5);
    }

    private void writeUInt64ListInternal(int r4, LongArrayList r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L13;
        this.output.writeTag(r4, 2);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5.size()) goto L8;
        r8 = r8 + CodedOutputStream.computeUInt64SizeNoTag(r5.getLong(r7));
        r7 = r7 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r8);
    L10:
        if (r0 >= r5.size()) goto L15;
        this.output.writeUInt64NoTag(r5.getLong(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r5.size()) goto L19;
        this.output.writeUInt64(r4, r5.getLong(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeUInt64ListInternal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeUInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.aiagent.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeUInt64NoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeUInt64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeFixed64ListInternal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeFixed64ListInternal(r3, r6, r5);
    }

    private void writeFixed64ListInternal(int r4, LongArrayList r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L13;
        this.output.writeTag(r4, 2);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5.size()) goto L8;
        r8 = r8 + CodedOutputStream.computeFixed64SizeNoTag(r5.getLong(r7));
        r7 = r7 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r8);
    L10:
        if (r0 >= r5.size()) goto L15;
        this.output.writeFixed64NoTag(r5.getLong(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r5.size()) goto L19;
        this.output.writeFixed64(r4, r5.getLong(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeFixed64ListInternal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeFixed64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.aiagent.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeFixed64NoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeFixed64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int r3, List<Float> r4, boolean r5) {
        List<Float> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, FloatArrayList.class) == false) goto L5;
        writeFloatListInternal(r3, (FloatArrayList) ZeusTransformUtils.preCheckCast(r6, FloatArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeFloatListInternal(r3, r6, r5);
    }

    private void writeFloatListInternal(int r3, FloatArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeFloatSizeNoTag(r4.getFloat(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeFloatNoTag(r4.getFloat(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeFloat(r3, r4.getFloat(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeFloatListInternal(int r5, List<Float> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeFloatSizeNoTag(((Float) ZeusTransformUtils.preCheckCast(r8.get(r9), Float.class, "com.obric.aiagent.plugin")).floatValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeFloatNoTag(((Float) ZeusTransformUtils.preCheckCast(r8.get(r0), Float.class, "com.obric.aiagent.plugin")).floatValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeFloat(r5, ((Float) ZeusTransformUtils.preCheckCast(r8.get(r0), Float.class, "com.obric.aiagent.plugin")).floatValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int r3, List<Double> r4, boolean r5) {
        List<Double> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, DoubleArrayList.class) == false) goto L5;
        writeDoubleListInternal(r3, (DoubleArrayList) ZeusTransformUtils.preCheckCast(r6, DoubleArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeDoubleListInternal(r3, r6, r5);
    }

    private void writeDoubleListInternal(int r4, DoubleArrayList r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L13;
        this.output.writeTag(r4, 2);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5.size()) goto L8;
        r8 = r8 + CodedOutputStream.computeDoubleSizeNoTag(r5.getDouble(r7));
        r7 = r7 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r8);
    L10:
        if (r0 >= r5.size()) goto L15;
        this.output.writeDoubleNoTag(r5.getDouble(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r5.size()) goto L19;
        this.output.writeDouble(r4, r5.getDouble(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeDoubleListInternal(int r5, List<Double> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeDoubleSizeNoTag(((Double) ZeusTransformUtils.preCheckCast(r8.get(r9), Double.class, "com.obric.aiagent.plugin")).doubleValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeDoubleNoTag(((Double) ZeusTransformUtils.preCheckCast(r8.get(r0), Double.class, "com.obric.aiagent.plugin")).doubleValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeDouble(r5, ((Double) ZeusTransformUtils.preCheckCast(r8.get(r0), Double.class, "com.obric.aiagent.plugin")).doubleValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeEnumListInternal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeEnumListInternal(r3, r6, r5);
    }

    private void writeEnumListInternal(int r3, IntArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeEnumSizeNoTag(r4.getInt(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeEnumNoTag(r4.getInt(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeEnum(r3, r4.getInt(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeEnumListInternal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeEnumSizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeEnumNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeEnum(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int r3, List<Boolean> r4, boolean r5) {
        List<Boolean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BooleanArrayList.class) == false) goto L5;
        writeBoolListInternal(r3, (BooleanArrayList) ZeusTransformUtils.preCheckCast(r6, BooleanArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeBoolListInternal(r3, r6, r5);
    }

    private void writeBoolListInternal(int r3, BooleanArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeBoolSizeNoTag(r4.getBoolean(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeBoolNoTag(r4.getBoolean(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeBool(r3, r4.getBoolean(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeBoolListInternal(int r5, List<Boolean> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeBoolSizeNoTag(((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r9), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeBoolNoTag(((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r0), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeBool(r5, ((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r0), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int r6, List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r8, LazyStringList.class) == false) goto L9;
        LazyStringList r0 = (LazyStringList) ZeusTransformUtils.preCheckCast(r8, LazyStringList.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 >= r8.size()) goto L11;
        writeLazyString(r6, r0.getRaw(r2));
        r2 = r2 + 1;
        goto L6
    L11:
        return;
    L9:
        if (r2 >= r8.size()) goto L14;
        this.output.writeString(r6, (String) ZeusTransformUtils.preCheckCast(r8.get(r2), String.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L9
    }

    private void writeLazyString(int r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L5;
        this.output.writeString(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        this.output.writeBytes(r3, (ByteString) ZeusTransformUtils.preCheckCast(r4, ByteString.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int r6, List<ByteString> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r8.size()) goto L6;
        this.output.writeBytes(r6, (ByteString) ZeusTransformUtils.preCheckCast(r8.get(r0), ByteString.class, "com.obric.aiagent.plugin"));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeUInt32ListInternal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeUInt32ListInternal(r3, r6, r5);
    }

    private void writeUInt32ListInternal(int r3, IntArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeUInt32SizeNoTag(r4.getInt(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeUInt32NoTag(r4.getInt(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeUInt32(r3, r4.getInt(r0));
        r0 = r0 + 1;
        goto L13
    }

    public void writeUInt32ListInternal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeUInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeUInt32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeUInt32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeSFixed32ListInternal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeSFixed32ListInternal(r3, r6, r5);
    }

    private void writeSFixed32ListInternal(int r3, IntArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeSFixed32SizeNoTag(r4.getInt(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeSFixed32NoTag(r4.getInt(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeSFixed32(r3, r4.getInt(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeSFixed32ListInternal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeSFixed32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeSFixed32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeSFixed32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeSFixed64ListInternal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeSFixed64ListInternal(r3, r6, r5);
    }

    private void writeSFixed64ListInternal(int r4, LongArrayList r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L13;
        this.output.writeTag(r4, 2);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5.size()) goto L8;
        r8 = r8 + CodedOutputStream.computeSFixed64SizeNoTag(r5.getLong(r7));
        r7 = r7 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r8);
    L10:
        if (r0 >= r5.size()) goto L15;
        this.output.writeSFixed64NoTag(r5.getLong(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r5.size()) goto L19;
        this.output.writeSFixed64(r4, r5.getLong(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeSFixed64ListInternal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeSFixed64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.aiagent.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeSFixed64NoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeSFixed64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int r3, List<Integer> r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, IntArrayList.class) == false) goto L5;
        writeSInt32ListInternal(r3, (IntArrayList) ZeusTransformUtils.preCheckCast(r6, IntArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeSInt32ListInternal(r3, r6, r5);
    }

    private void writeSInt32ListInternal(int r3, IntArrayList r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L13;
        this.output.writeTag(r3, 2);
        int r6 = 0;
        int r7 = 0;
    L6:
        if (r6 >= r4.size()) goto L8;
        r7 = r7 + CodedOutputStream.computeSInt32SizeNoTag(r4.getInt(r6));
        r6 = r6 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r7);
    L10:
        if (r0 >= r4.size()) goto L15;
        this.output.writeSInt32NoTag(r4.getInt(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r4.size()) goto L19;
        this.output.writeSInt32(r3, r4.getInt(r0));
        r0 = r0 + 1;
        goto L13
    }

    public void writeSInt32ListInternal(int r5, List<Integer> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeSInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r9), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeSInt32NoTag(((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeSInt32(r5, ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r0), Integer.class, "com.obric.aiagent.plugin")).intValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int r3, List<Long> r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, LongArrayList.class) == false) goto L5;
        writeSInt64ListInternal(r3, (LongArrayList) ZeusTransformUtils.preCheckCast(r6, LongArrayList.class, "com.obric.aiagent.plugin"), r5);
        return;
    L5:
        writeSInt64ListInternal(r3, r6, r5);
    }

    private void writeSInt64ListInternal(int r4, LongArrayList r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L13;
        this.output.writeTag(r4, 2);
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r5.size()) goto L8;
        r8 = r8 + CodedOutputStream.computeSInt64SizeNoTag(r5.getLong(r7));
        r7 = r7 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r8);
    L10:
        if (r0 >= r5.size()) goto L15;
        this.output.writeSInt64NoTag(r5.getLong(r0));
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r5.size()) goto L19;
        this.output.writeSInt64(r4, r5.getLong(r0));
        r0 = r0 + 1;
        goto L13
    }

    private void writeSInt64ListInternal(int r5, List<Long> r6, boolean r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        if (r7 == false) goto L13;
        this.output.writeTag(r5, 2);
        int r9 = 0;
        int r10 = 0;
    L6:
        if (r9 >= r8.size()) goto L8;
        r10 = r10 + CodedOutputStream.computeSInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r9), Long.class, "com.obric.aiagent.plugin")).longValue());
        r9 = r9 + 1;
        goto L6
    L8:
        this.output.writeUInt32NoTag(r10);
    L10:
        if (r0 >= r8.size()) goto L15;
        this.output.writeSInt64NoTag(((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L13:
        if (r0 >= r8.size()) goto L19;
        this.output.writeSInt64(r5, ((Long) ZeusTransformUtils.preCheckCast(r8.get(r0), Long.class, "com.obric.aiagent.plugin")).longValue());
        r0 = r0 + 1;
        goto L13
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int r3, List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L6;
        writeMessage(r3, r5.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int r3, List<?> r4, Schema r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L6;
        writeMessage(r3, r6.get(r0), r7);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroupList(int r3, List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L6;
        writeGroup(r3, r5.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int r3, List<?> r4, Schema r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Schema r7 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L4:
        if (r0 >= r6.size()) goto L6;
        writeGroup(r3, r6.get(r0), r7);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int r6, MapEntryLite.Metadata<K, V> r7, Map<K, V> r8) {
        Map<K, V> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        if (this.output.isSerializationDeterministic() == false) goto L6;
        writeDeterministicMap(r6, r7, r9);
        return;
    L6:
        Iterator<Map.Entry<K, V>> r10 = r9.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        this.output.writeTag(r6, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r7, r0.getKey(), r0.getValue()));
        MapEntryLite.writeTo(this.output, r7, r0.getKey(), r0.getValue());
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> void writeDeterministicMap(int r3, MapEntryLite.Metadata<K, V> r4, Map<K, V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r4.keyType.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        writeDeterministicStringMap(r3, r4, r6);
        return;
    L7:
        writeDeterministicLongMap(r3, r4, r6);
        return;
    L8:
        writeDeterministicIntegerMap(r3, r4, r6);
        return;
    L9:
        Object r0 = r6.get(Boolean.FALSE);
        if (r0 == null) goto L12;
        writeDeterministicBooleanMapEntry(r3, false, r0, r4);
    L12:
        Object r7 = r6.get(Boolean.TRUE);
        if (r7 == null) goto L19;
        writeDeterministicBooleanMapEntry(r3, true, r7, r4);
        return;
    L19:
        return;
    L5:
        throw new IllegalArgumentException("does not support key type: " + r4.keyType);
    }

    private <V> void writeDeterministicBooleanMapEntry(int r3, boolean r4, V r5, MapEntryLite.Metadata<Boolean, V> r6) {
        this.output.writeTag(r3, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r6, Boolean.valueOf(r4), r5));
        MapEntryLite.writeTo(this.output, r6, Boolean.valueOf(r4), r5);
    }

    private <V> void writeDeterministicIntegerMap(int r9, MapEntryLite.Metadata<Integer, V> r10, Map<Integer, V> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        int r0 = r12.size();
        int[] r2 = new int[r0];
        Iterator r3 = r12.keySet().iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r2[r5] = ((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r5 = r5 + 1;
        goto L4
    L6:
        Arrays.sort(r2);
    L7:
        if (r4 >= r0) goto L9;
        int r1 = r2[r4];
        Object r6 = r12.get(Integer.valueOf(r1));
        this.output.writeTag(r9, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r10, Integer.valueOf(r1), r6));
        MapEntryLite.writeTo(this.output, r10, Integer.valueOf(r1), r6);
        r4 = r4 + 1;
        goto L7
    }

    private <V> void writeDeterministicLongMap(int r10, MapEntryLite.Metadata<Long, V> r11, Map<Long, V> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        int r0 = r13.size();
        long[] r2 = new long[r0];
        Iterator r3 = r13.keySet().iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r2[r5] = ((Long) ZeusTransformUtils.preCheckCast(r3.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
        r5 = r5 + 1;
        goto L4
    L6:
        Arrays.sort(r2);
    L7:
        if (r4 >= r0) goto L9;
        long r6 = r2[r4];
        Object r1 = r13.get(Long.valueOf(r6));
        this.output.writeTag(r10, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r11, Long.valueOf(r6), r1));
        MapEntryLite.writeTo(this.output, r11, Long.valueOf(r6), r1);
        r4 = r4 + 1;
        goto L7
    }

    private <V> void writeDeterministicStringMap(int r9, MapEntryLite.Metadata<String, V> r10, Map<String, V> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        int r0 = r12.size();
        String[] r2 = new String[r0];
        Iterator r3 = r12.keySet().iterator();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r2[r5] = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        r5 = r5 + 1;
        goto L4
    L6:
        Arrays.sort(r2);
    L7:
        if (r4 >= r0) goto L9;
        String r1 = r2[r4];
        Object r6 = r12.get(r1);
        this.output.writeTag(r9, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(r10, r1, r6));
        MapEntryLite.writeTo(this.output, r10, r1, r6);
        r4 = r4 + 1;
        goto L7
    }
}
