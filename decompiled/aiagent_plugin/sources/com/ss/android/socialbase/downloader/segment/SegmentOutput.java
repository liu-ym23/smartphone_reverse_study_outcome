package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
class SegmentOutput implements IOutput {
    private final RandomAccessOutputStream output;
    private final Segment segment;
    private final IOutput stub;

    public SegmentOutput(DownloadInfo r1, BufferQueue r2, Segment r3) {
        this.segment = r3;
        this.output = createOutStream(r1, r3);
        this.stub = new OutputStub(r2, this);
    }

    public IOutput getStub() {
        return this.stub;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer r5) {
        this.output.write(r5.data, 0, r5.size);
        this.segment.increaseCurrentOffset(r5.size);
    }

    public void flush() {
        this.output.flush();
    }

    public void sync() {
        this.output.sync();
    }

    public void close() {
        DownloadUtils.safeClose(new Closeable[]{this.output});
    }

    public Segment getSegment() {
        return this.segment;
    }

    private RandomAccessOutputStream createOutStream(DownloadInfo r5, Segment r6) {
        RandomAccessOutputStream r4 = DownloadHelper.createOutputStream(r5, r5.getTempPath(), r5.getTempName(), DownloadSetting.obtain(r5.getId()).optInt(DownloadSettingKeys.FLUSH_BUFFER_SIZE_BYTE, -1), false);
        long r0 = r5.getStartOffset();
        if (r0 >= 0) goto L10;
        r0 = 0;
    L10:
        r4.seek(r6.getCurrentOffsetRead() - r0);     // Catch: IOException -> L7
        return r4;
    L7:
        e = move-exception;
        throw new BaseException(DownloadErrorCode.ERROR_RANDOM_ACCESS_SEEK_IO, e);
    }
}
