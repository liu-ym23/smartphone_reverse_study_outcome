package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: classes3.dex */
class NodeSerialization implements Serializable, Externalizable {
    protected static final int LONGEST_EAGER_ALLOC = 100000;
    private static final long serialVersionUID = 1;
    public byte[] json;

    public NodeSerialization() {
    }

    private byte[] _read(ObjectInput objectInput, int i) throws IOException {
        if (i <= 100000) {
            byte[] bArr = new byte[i];
            objectInput.readFully(bArr, 0, i);
            return bArr;
        }
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(100000);
        try {
            byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
            while (true) {
                int i6 = 0;
                do {
                    int iMin = Math.min(bArrResetAndGetFirstSegment.length - i6, i);
                    objectInput.readFully(bArrResetAndGetFirstSegment, 0, iMin);
                    i -= iMin;
                    i6 += iMin;
                    if (i == 0) {
                        byte[] bArrCompleteAndCoalesce = byteArrayBuilder.completeAndCoalesce(i6);
                        byteArrayBuilder.close();
                        return bArrCompleteAndCoalesce;
                    }
                } while (i6 != bArrResetAndGetFirstSegment.length);
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    byteArrayBuilder.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static NodeSerialization from(Object obj) {
        try {
            return new NodeSerialization(InternalNodeMapper.valueToBytes(obj));
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to JDK serialize `" + obj.getClass().getSimpleName() + "` value: " + e.getMessage(), e);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        this.json = _read(objectInput, objectInput.readInt());
    }

    public Object readResolve() {
        try {
            return InternalNodeMapper.bytesToNode(this.json);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to JDK deserialize `JsonNode` value: " + e.getMessage(), e);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.json.length);
        objectOutput.write(this.json);
    }

    public NodeSerialization(byte[] bArr) {
        this.json = bArr;
    }
}
