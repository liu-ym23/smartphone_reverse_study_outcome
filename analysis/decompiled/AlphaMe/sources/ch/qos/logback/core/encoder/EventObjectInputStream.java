package ch.qos.logback.core.encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EventObjectInputStream<E> extends InputStream {
    List<E> buffer = new ArrayList();
    int index = 0;
    NonClosableInputStream ncis;

    public EventObjectInputStream(InputStream inputStream) throws IOException {
        this.ncis = new NonClosableInputStream(inputStream);
    }

    private void internalReset() {
        this.index = 0;
        this.buffer.clear();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.ncis.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ncis.realClose();
    }

    public E getFromBuffer() {
        if (this.index >= this.buffer.size()) {
            return null;
        }
        List<E> list = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        return list.get(i4);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw new UnsupportedOperationException("Only the readEvent method is supported.");
    }

    public E readEvent() throws IOException {
        E fromBuffer = getFromBuffer();
        if (fromBuffer != null) {
            return fromBuffer;
        }
        internalReset();
        int header = readHeader();
        if (header == -1) {
            return null;
        }
        readPayload(header);
        readFooter(header);
        return getFromBuffer();
    }

    public E readEvents(ObjectInputStream objectInputStream) throws IOException {
        E e4;
        try {
            e4 = (E) objectInputStream.readObject();
            try {
                this.buffer.add(e4);
            } catch (ClassNotFoundException e5) {
                e = e5;
                e.printStackTrace();
                return e4;
            }
        } catch (ClassNotFoundException e6) {
            e = e6;
            e4 = null;
        }
        return e4;
    }

    public void readFooter(int i4) throws IOException {
        byte[] bArr = new byte[8];
        this.ncis.read(bArr);
        if (ByteArrayUtil.readInt(bArr, 0) != 640373619) {
            throw new IllegalStateException("Looks like a corrupt stream");
        }
        if (ByteArrayUtil.readInt(bArr, 4) != (i4 ^ ObjectStreamEncoder.STOP_PEBBLE)) {
            throw new IllegalStateException("Invalid checksum");
        }
    }

    public int readHeader() throws IOException {
        byte[] bArr = new byte[16];
        if (this.ncis.read(bArr) == -1) {
            return -1;
        }
        if (ByteArrayUtil.readInt(bArr, 0) != 1853421169) {
            throw new IllegalStateException("Does not look like data created by ObjectStreamEncoder");
        }
        int i4 = ByteArrayUtil.readInt(bArr, 4);
        ByteArrayUtil.readInt(bArr, 8);
        if (ByteArrayUtil.readInt(bArr, 12) == (1853421169 ^ i4)) {
            return i4;
        }
        throw new IllegalStateException("Invalid checksum");
    }

    public void readPayload(int i4) throws IOException {
        ArrayList arrayList = new ArrayList(i4);
        ObjectInputStream objectInputStream = new ObjectInputStream(this.ncis);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(readEvents(objectInputStream));
        }
        objectInputStream.close();
    }
}
