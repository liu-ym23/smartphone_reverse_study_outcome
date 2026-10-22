package com.fasterxml.jackson.databind.node;

import b8.z;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class NodeSerialization implements Serializable, Externalizable {
    protected static final int LONGEST_EAGER_ALLOC = 100000;
    private static final long serialVersionUID = 1;
    public byte[] json;

    public NodeSerialization(byte[] bArr) {
        this.json = bArr;
    }

    private byte[] _read(ObjectInput objectInput, int i) throws IOException {
        if (i <= LONGEST_EAGER_ALLOC) {
            byte[] bArr = new byte[i];
            objectInput.readFully(bArr, 0, i);
            return bArr;
        }
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(LONGEST_EAGER_ALLOC);
        try {
            byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
            while (true) {
                int i3 = 0;
                do {
                    int iMin = Math.min(bArrResetAndGetFirstSegment.length - i3, i);
                    objectInput.readFully(bArrResetAndGetFirstSegment, 0, iMin);
                    i -= iMin;
                    i3 += iMin;
                    if (i == 0) {
                        byte[] bArrCompleteAndCoalesce = byteArrayBuilder.completeAndCoalesce(i3);
                        byteArrayBuilder.close();
                        return bArrCompleteAndCoalesce;
                    }
                } while (i3 != bArrResetAndGetFirstSegment.length);
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
        } catch (IOException e10) {
            z.r("Failed to JDK serialize `", obj.getClass().getSimpleName(), "` value: ", e10.getMessage(), e10);
            return null;
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        this.json = _read(objectInput, objectInput.readInt());
    }

    public Object readResolve() {
        try {
            return InternalNodeMapper.bytesToNode(this.json);
        } catch (IOException e10) {
            throw new IllegalArgumentException("Failed to JDK deserialize `JsonNode` value: " + e10.getMessage(), e10);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.json.length);
        objectOutput.write(this.json);
    }

    public NodeSerialization() {
    }
}
