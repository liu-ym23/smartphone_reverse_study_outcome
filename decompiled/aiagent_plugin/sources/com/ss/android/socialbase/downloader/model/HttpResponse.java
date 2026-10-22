package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class HttpResponse {
    public final IDownloadHeadHttpConnection connection;
    private long contentLength;
    public final int responseCode;
    private long totalLength;
    public final String url;

    public HttpResponse(String r3, IDownloadHeadHttpConnection r4) {
        IDownloadHeadHttpConnection r5 = (IDownloadHeadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadHeadHttpConnection.class, "com.obric.aiagent.plugin");
        this.url = r3;
        this.responseCode = r5.getResponseCode();
        this.connection = r5;
    }

    public HttpResponse(String r3, IDownloadHeadHttpConnection r4, int r5) {
        IDownloadHeadHttpConnection r6 = (IDownloadHeadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadHeadHttpConnection.class, "com.obric.aiagent.plugin");
        this.url = r3;
        this.responseCode = r5;
        this.connection = r6;
    }

    public boolean isResponseDataFromBegin() {
        return DownloadHelper.isResponseDataFromBegin(this.responseCode);
    }

    public boolean acceptPartial() {
        return DownloadHelper.canAcceptPartial(this.responseCode, this.connection.getResponseHeaderField(DownloadHelper.ACCEPT_RANGES));
    }

    public String getEtag() {
        return this.connection.getResponseHeaderField(DownloadHelper.ETAG);
    }

    public String getContentType() {
        return this.connection.getResponseHeaderField(DownloadHelper.CONTENT_TYPE);
    }

    public String getContentRange() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadUtils.CONTENT_RANGE);
    }

    public String getLastModified() {
        String r0 = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "last-modified");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadHelper.LAST_MODIFIED_CASE);
    }

    public String getCacheControl() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadHelper.CACHE_CONTROL);
    }

    public long getContentLength() {
        if (this.contentLength > 0) goto L6;
        this.contentLength = DownloadUtils.getContentLength(this.connection);
    L6:
        return this.contentLength;
    }

    public boolean isChunked() {
        return DownloadHelper.isChunkedTask(this.connection);
    }

    public long getXContentLength() {
        String r2 = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadHelper.X_CONTENT_LENGTH);
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L6:
        return -1;
    L9:
        return Long.parseLong(r2);
    }

    public long getTotalLength() {
        if (this.totalLength > 0) goto L11;
        if (isChunked() == true) goto L9;
        String r0 = getContentRange();
        if (TextUtils.isEmpty(r0) == true) goto L11;
        this.totalLength = DownloadHelper.parseContentRangeOfInstanceLength(r0);
        goto L11
    L9:
        this.totalLength = -1;
    L11:
        return this.totalLength;
    }

    public long getMaxAge() {
        return DownloadHelper.parserMaxAge(getCacheControl());
    }

    public String getContentEncoding() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadHelper.CONTENT_ENCODING);
    }
}
