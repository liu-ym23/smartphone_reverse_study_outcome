package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LongLinkClient {

    /* renamed from: a, reason: collision with root package name */
    private int f8784a;

    /* renamed from: b, reason: collision with root package name */
    private long f8785b;

    /* renamed from: c, reason: collision with root package name */
    private int f8786c;

    private LongLinkClient(long j4, int i4) {
        this.f8785b = j4;
        this.f8784a = i4;
    }

    public static LongLinkClient create() throws ComInitException {
        long jCreate = NALongLink.create();
        if (jCreate != 0) {
            return new LongLinkClient(jCreate);
        }
        throw new ComInitException("LongLink Component created failed!");
    }

    public synchronized int getRequestId() {
        return this.f8786c;
    }

    public boolean init(String str, String str2) throws InvalidComException {
        if (isValid()) {
            return NALongLink.init(this.f8785b, str, str2);
        }
        throw new InvalidComException();
    }

    public boolean isValid() {
        return this.f8785b != 0;
    }

    public synchronized boolean register(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        return NALongLink.register(this.f8785b, this.f8784a, longLinkDataCallback);
    }

    public int release() {
        if (!isValid() || NALongLink.release(this.f8785b) > 0) {
            return -1;
        }
        this.f8785b = 0L;
        return -1;
    }

    public synchronized ELongLinkStatus sendData(byte[] bArr) throws InvalidComException {
        ELongLinkStatus eLongLinkStatus;
        if (!isValid()) {
            throw new InvalidComException();
        }
        this.f8786c++;
        eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendData(this.f8785b, this.f8784a, this.f8786c, bArr)];
        eLongLinkStatus.setRequestId(this.f8786c);
        return eLongLinkStatus;
    }

    public synchronized ELongLinkStatus sendFileData(String str, ArrayList<LongLinkFileData> arrayList) throws InvalidComException {
        ELongLinkStatus eLongLinkStatus;
        if (!isValid()) {
            throw new InvalidComException();
        }
        this.f8786c++;
        eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendFileData(this.f8785b, this.f8784a, this.f8786c, str, arrayList)];
        eLongLinkStatus.setRequestId(this.f8786c);
        return eLongLinkStatus;
    }

    public void setModuleId(int i4) {
        this.f8784a = i4;
    }

    public boolean start() throws InvalidComException {
        if (isValid()) {
            return NALongLink.start(this.f8785b);
        }
        throw new InvalidComException();
    }

    public void stop() throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        NALongLink.stop(this.f8785b);
    }

    public synchronized boolean unRegister(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        if (!isValid()) {
            throw new InvalidComException();
        }
        return NALongLink.unRegister(this.f8785b, this.f8784a, longLinkDataCallback);
    }

    private LongLinkClient(long j4) {
        this.f8785b = j4;
    }

    public static LongLinkClient create(int i4) throws ComInitException {
        long jCreate = NALongLink.create();
        if (jCreate != 0) {
            return new LongLinkClient(jCreate, i4);
        }
        throw new ComInitException("LongLink Component created failed!");
    }
}
