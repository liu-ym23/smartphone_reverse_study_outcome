package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import g5.f;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@CheckReturnValue
/* loaded from: classes.dex */
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i, boolean z10, V v10, MapEntryLite.Metadata<Boolean, V> metadata) {
        this.output.writeTag(i, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z10), v10));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z10), v10);
    }

    private <V> void writeDeterministicIntegerMap(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        Arrays.sort(iArr);
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = iArr[i10];
            V v10 = map.get(Integer.valueOf(i11));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i11), v10));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i11), v10);
        }
    }

    private <V> void writeDeterministicLongMap(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            jArr[i3] = it.next().longValue();
            i3++;
        }
        Arrays.sort(jArr);
        for (int i10 = 0; i10 < size; i10++) {
            long j10 = jArr[i10];
            V v10 = map.get(Long.valueOf(j10));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j10), v10));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j10), v10);
        }
    }

    private <K, V> void writeDeterministicMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v10 = map.get(Boolean.FALSE);
                if (v10 != null) {
                    writeDeterministicBooleanMapEntry(i, false, v10, metadata);
                }
                V v11 = map.get(Boolean.TRUE);
                if (v11 != null) {
                    writeDeterministicBooleanMapEntry(i, true, v11, metadata);
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i, metadata, map);
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i, metadata, map);
                break;
            case 12:
                writeDeterministicStringMap(i, metadata, map);
                break;
            default:
                f.f(metadata.keyType, "does not support key type: ");
                break;
        }
    }

    private <V> void writeDeterministicStringMap(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            strArr[i3] = it.next();
            i3++;
        }
        Arrays.sort(strArr);
        for (int i10 = 0; i10 < size; i10++) {
            String str = strArr[i10];
            V v10 = map.get(str);
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v10));
            MapEntryLite.writeTo(this.output, metadata, str, v10);
        }
    }

    private void writeLazyString(int i, Object obj) {
        boolean z10 = obj instanceof String;
        CodedOutputStream codedOutputStream = this.output;
        if (z10) {
            codedOutputStream.writeString(i, (String) obj);
        } else {
            codedOutputStream.writeBytes(i, (ByteString) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBool(int i, boolean z10) {
        this.output.writeBool(i, z10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBoolList(int i, List<Boolean> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeBool(i, list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i10).booleanValue());
        }
        this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeBoolNoTag(list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBytes(int i, ByteString byteString) {
        this.output.writeBytes(i, byteString);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeBytesList(int i, List<ByteString> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.output.writeBytes(i, list.get(i3));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeDouble(int i, double d7) {
        this.output.writeDouble(i, d7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeDoubleList(int i, List<Double> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeDouble(i, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i10).doubleValue());
        }
        this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeDoubleNoTag(list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i) {
        this.output.writeTag(i, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEnum(int i, int i3) {
        this.output.writeEnum(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeEnumList(int i, List<Integer> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeEnum(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeEnumNoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed32(int i, int i3) {
        this.output.writeFixed32(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed32List(int i, List<Integer> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeFixed32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeFixed32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed64(int i, long j10) {
        this.output.writeFixed64(i, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFixed64List(int i, List<Long> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeFixed64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeFixed64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFloat(int i, float f5) {
        this.output.writeFloat(i, f5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeFloatList(int i, List<Float> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeFloat(i, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i10).floatValue());
        }
        this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i3 < list.size()) {
            this.output.writeFloatNoTag(list.get(i3).floatValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeGroup(int i, Object obj) {
        this.output.writeGroup(i, (MessageLite) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i, List<?> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeGroup(i, list.get(i3));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt32(int i, int i3) {
        this.output.writeInt32(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt32List(int i, List<Integer> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeInt32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeInt32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt64(int i, long j10) {
        this.output.writeInt64(i, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeInt64List(int i, List<Long> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeInt64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeInt64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessage(int i, Object obj) {
        this.output.writeMessage(i, (MessageLite) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageList(int i, List<?> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeMessage(i, list.get(i3));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageSetItem(int i, Object obj) {
        boolean z10 = obj instanceof ByteString;
        CodedOutputStream codedOutputStream = this.output;
        if (z10) {
            codedOutputStream.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            codedOutputStream.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed32(int i, int i3) {
        this.output.writeSFixed32(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed32List(int i, List<Integer> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeSFixed32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSFixed32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed64(int i, long j10) {
        this.output.writeSFixed64(i, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSFixed64List(int i, List<Long> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeSFixed64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSFixed64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt32(int i, int i3) {
        this.output.writeSInt32(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt32List(int i, List<Integer> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeSInt32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSInt32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt64(int i, long j10) {
        this.output.writeSInt64(i, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeSInt64List(int i, List<Long> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeSInt64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeSInt64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i) {
        this.output.writeTag(i, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeString(int i, String str) {
        this.output.writeString(i, str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeStringList(int i, List<String> list) {
        int i3 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i3 < list.size()) {
                this.output.writeString(i, list.get(i3));
                i3++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i3 < list.size()) {
                writeLazyString(i, lazyStringList.getRaw(i3));
                i3++;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt32(int i, int i3) {
        this.output.writeUInt32(i, i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt32List(int i, List<Integer> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeUInt32(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeUInt32NoTag(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt64(int i, long j10) {
        this.output.writeUInt64(i, j10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeUInt64List(int i, List<Long> list, boolean z10) {
        int i3 = 0;
        if (!z10) {
            while (i3 < list.size()) {
                this.output.writeUInt64(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.output.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i3 < list.size()) {
            this.output.writeUInt64NoTag(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroup(int i, Object obj, Schema schema) {
        this.output.writeGroup(i, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessage(int i, Object obj, Schema schema) {
        this.output.writeMessage(i, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeGroupList(int i, List<?> list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeGroup(i, list.get(i3), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void writeMessageList(int i, List<?> list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeMessage(i, list.get(i3), schema);
        }
    }
}
