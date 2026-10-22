package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.io.CInputStream;
import com.bytedance.apm.agent.instrumentation.io.CountingOutputStream;
import com.bytedance.apm.agent.instrumentation.okhttp3.MonitorRecorder;
import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class HttpURLConnectionExtension extends HttpURLConnection {
    private static final AgentLog log = null;
    private HttpURLConnection impl;
    private TxState transactionState;

    private TxState getTransactionState() {
        if (this.transactionState != null) goto L6;
        TxState r100 = new TxState();
        this.transactionState = r100;
        TransactionStateUtil.inspectAndInstrument(r100, this.impl);
    L6:
        return this.transactionState;
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        TxState r100 = this.transactionState;
        if (r100 != null) goto L5;
    L7:
        this.impl.disconnect();
        return;
    L5:
        if (r100.isComplete() == true) goto L7;
        addTransactionAndErrorData(this.transactionState);
        goto L7
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.impl.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.impl.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.impl.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.impl.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.impl.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.impl.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.impl.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.impl.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.impl.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.impl.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.impl.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.impl.getUseCaches();
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.impl.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.impl.usingProxy();
    }

    static {
        log = AgentLogManager.getAgentLog();
    }

    private void checkResponse() {
        if (getTransactionState().isComplete() == true) goto L6;
        TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), this.impl);
        return;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getTransactionState();
        this.impl.connect();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        getTransactionState();
        Object r100 = this.impl.getContent();     // Catch: IOException -> L10
        int r101 = this.impl.getContentLength();
        if (r101 < 0) goto L9;
        TxState r102 = getTransactionState();
        if (r102.isComplete() == true) goto L9;
        r102.setBytesReceived(r101);
        addTransactionAndErrorData(r102);
    L9:
        return r100;
    L10:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        getTransactionState();
        String r100 = this.impl.getContentEncoding();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        getTransactionState();
        int r100 = this.impl.getContentLength();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        getTransactionState();
        String r100 = this.impl.getContentType();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        getTransactionState();
        long r100 = this.impl.getDate();
        checkResponse();
        return r100;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getTransactionState();
        return new CInputStream(this.impl.getErrorStream(), true);
    L5:
        e = move-exception;
        log.error(e.toString());
        return this.impl.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        getTransactionState();
        long r100 = this.impl.getExpiration();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getTransactionState();
        Map<String, List<String>> r100 = this.impl.getHeaderFields();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        getTransactionState();
        long r100 = this.impl.getIfModifiedSince();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        final TxState r100 = getTransactionState();
        CInputStream r101 = new CInputStream(this.impl.getInputStream());     // Catch: IOException -> L6
        TransactionStateUtil.inspectAndInstrumentResponse(r100, this.impl);     // Catch: IOException -> L6
        r101.addStreamCompleteListener(new AnonymousClass1(this, r100));
        return r101;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        getTransactionState();
        long r100 = this.impl.getLastModified();
        checkResponse();
        return r100;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        final TxState r100 = getTransactionState();
        CountingOutputStream r101 = new CountingOutputStream(this.impl.getOutputStream());     // Catch: IOException -> L6
        r101.addStreamCompleteListener(new AnonymousClass2(this, r100));
        return r101;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        getTransactionState();
        int r100 = this.impl.getResponseCode();     // Catch: IOException -> L6
        checkResponse();
        return r100;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        getTransactionState();
        String r100 = this.impl.getResponseMessage();     // Catch: IOException -> L6
        checkResponse();
        return r100;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    public HttpURLConnectionExtension(HttpURLConnection r100) {
        super(r100.getURL());
        this.impl = r100;
    }

    public static /* synthetic */ HttpURLConnection access$100(HttpURLConnectionExtension r100) {
        return r100.impl;
    }

    private void addTransactionAndErrorData(TxState r100) {
        MonitorRecorder.reportMonitorData(r100, "httpurlconnection");
    }

    private void error(Exception r100) {
        TxState r101 = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(r101, r100);
        if (r101.isComplete() == true) goto L6;
        TransactionStateUtil.inspectAndInstrumentResponse(r101, this.impl);
        MonitorRecorder.reportMonitorData(r101, "httpurlconnection");
        return;
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] r100) throws IOException {
        getTransactionState();
        Object r101 = this.impl.getContent(r100);     // Catch: IOException -> L6
        checkResponse();
        return r101;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int r100) {
        getTransactionState();
        String r101 = this.impl.getHeaderField(r100);
        checkResponse();
        return r101;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int r100) {
        getTransactionState();
        String r101 = this.impl.getHeaderFieldKey(r100);
        checkResponse();
        return r101;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r100) {
        return this.impl.getRequestProperty(r100);
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean r100) {
        this.impl.setAllowUserInteraction(r100);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int r100) {
        this.impl.setChunkedStreamingMode(r100);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r100) {
        this.impl.setConnectTimeout(r100);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean r100) {
        this.impl.setDefaultUseCaches(r100);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean r100) {
        this.impl.setDoInput(r100);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean r100) {
        this.impl.setDoOutput(r100);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int r100) {
        this.impl.setFixedLengthStreamingMode(r100);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long r100) {
        this.impl.setIfModifiedSince(r100);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean r100) {
        this.impl.setInstanceFollowRedirects(r100);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int r100) {
        this.impl.setReadTimeout(r100);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r100) throws ProtocolException {
        getTransactionState();
        this.impl.setRequestMethod(r100);     // Catch: ProtocolException -> L5
        return;
    L5:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean r100) {
        this.impl.setUseCaches(r100);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String r100) {
        getTransactionState();
        String r101 = this.impl.getHeaderField(r100);
        checkResponse();
        return r101;
    }

    public static /* synthetic */ void access$000(HttpURLConnectionExtension r100, Exception r101) {
        r100.error(r101);
    }

    public static /* synthetic */ void access$200(HttpURLConnectionExtension r100, TxState r101) {
        r100.addTransactionAndErrorData(r101);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String r100, String r101) {
        this.impl.addRequestProperty(r100, r101);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String r100, long r101) {
        getTransactionState();
        long r102 = this.impl.getHeaderFieldDate(r100, r101);
        checkResponse();
        return r102;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String r100, int r101) {
        getTransactionState();
        int r102 = this.impl.getHeaderFieldInt(r100, r101);
        checkResponse();
        return r102;
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String r100, String r101) {
        this.impl.setRequestProperty(r100, r101);
    }
}
