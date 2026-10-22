package com.baidu.platform.comapi.longlink;

import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class LongLinkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f32924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32925c;

    public synchronized int getRequestId() {
        monitor-enter(this);
        int r100 = this.f32925c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isValid() {
        if (this.f32924b == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static LongLinkClient create() throws ComInitException {
        long r100 = NALongLink.create();
        if (r100 == 0) goto L7;
        return new LongLinkClient(r100);
    L7:
        throw new ComInitException("LongLink Component created failed!");
    }

    public int release() {
        if (isValid() == true) goto L5;
        return -1;
    L5:
        if (NALongLink.release(this.f32924b) > 0) goto L10;
        this.f32924b = 0;
        return -1;
    L10:
        return -1;
    }

    public boolean start() throws InvalidComException {
        if (isValid() == false) goto L7;
        return NALongLink.start(this.f32924b);
    L7:
        throw new InvalidComException();
    }

    public void stop() throws InvalidComException {
        if (isValid() == false) goto L7;
        NALongLink.stop(this.f32924b);
        return;
    L7:
        throw new InvalidComException();
    }

    private LongLinkClient(long r100) {
        this.f32924b = r100;
    }

    public static LongLinkClient create(int r100) throws ComInitException {
        long r101 = NALongLink.create();
        if (r101 == 0) goto L7;
        return new LongLinkClient(r101, r100);
    L7:
        throw new ComInitException("LongLink Component created failed!");
    }

    public synchronized boolean register(LongLinkDataCallback r100) throws InvalidComException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isValid() == false) goto L9;
        boolean r101 = NALongLink.register(this.f32924b, this.f32923a, r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L9:
        throw new InvalidComException();     // Catch: Throwable -> L10
    }

    public synchronized ELongLinkStatus sendData(byte[] r100) throws InvalidComException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isValid() == false) goto L9;
        this.f32925c++;     // Catch: Throwable -> L10
        ELongLinkStatus r101 = ELongLinkStatus.values()[NALongLink.sendData(this.f32924b, this.f32923a, this.f32925c, r100)];     // Catch: Throwable -> L10
        r101.setRequestId(this.f32925c);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L9:
        throw new InvalidComException();     // Catch: Throwable -> L10
    }

    public void setModuleId(int r100) {
        this.f32923a = r100;
    }

    public synchronized boolean unRegister(LongLinkDataCallback r100) throws InvalidComException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isValid() == false) goto L9;
        boolean r101 = NALongLink.unRegister(this.f32924b, this.f32923a, r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L9:
        throw new InvalidComException();     // Catch: Throwable -> L10
    }

    private LongLinkClient(long r100, int r101) {
        this.f32924b = r100;
        this.f32923a = r101;
    }

    public boolean init(String r100, String r101) throws InvalidComException {
        if (isValid() == false) goto L7;
        return NALongLink.init(this.f32924b, r100, r101);
    L7:
        throw new InvalidComException();
    }

    public synchronized ELongLinkStatus sendFileData(String r100, ArrayList<LongLinkFileData> r101) throws InvalidComException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isValid() == false) goto L9;
        this.f32925c++;     // Catch: Throwable -> L10
        ELongLinkStatus r102 = ELongLinkStatus.values()[NALongLink.sendFileData(this.f32924b, this.f32923a, this.f32925c, r100, r101)];     // Catch: Throwable -> L10
        r102.setRequestId(this.f32925c);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r102;
    L9:
        throw new InvalidComException();     // Catch: Throwable -> L10
    }
}
