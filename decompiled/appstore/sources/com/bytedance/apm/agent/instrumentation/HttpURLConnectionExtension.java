package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.io.CInputStream;
import com.bytedance.apm.agent.instrumentation.io.CountingOutputStream;
import com.bytedance.apm.agent.instrumentation.okhttp3.MonitorRecorder;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.constant.TrafficConsts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpURLConnectionExtension extends HttpURLConnection {
    private static final AgentLog log = null;
    private HttpURLConnection impl;
    private TransactionState transactionState;

    static {
        log = AgentLogManager.getAgentLog();
    }

    public HttpURLConnectionExtension(HttpURLConnection r10) {
        super(r10.getURL());
        this.impl = r10;
    }

    public static /* synthetic */ void access$000(HttpURLConnectionExtension r10, Exception r11) {
        r10.error(r11);
    }

    public static /* synthetic */ HttpURLConnection access$100(HttpURLConnectionExtension r10) {
        return r10.impl;
    }

    public static /* synthetic */ void access$200(HttpURLConnectionExtension r10, TransactionState r11) {
        r10.addTransactionAndErrorData(r11);
    }

    private void addTransactionAndErrorData(TransactionState r10) {
        MonitorRecorder.reportMonitorData(r10, TrafficConsts.NET_CONSUME_TYPE_HTTPURL);
    }

    private void checkResponse() {
        if (getTransactionState().isComplete() == true) goto L6;
        TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), this.impl);
        return;
    }

    private void error(Exception r10) {
        TransactionState r11 = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(r11, r10);
        if (r11.isComplete() == true) goto L6;
        TransactionStateUtil.inspectAndInstrumentResponse(r11, this.impl);
        MonitorRecorder.reportMonitorData(r11, TrafficConsts.NET_CONSUME_TYPE_HTTPURL);
        return;
    }

    private TransactionState getTransactionState() {
        if (this.transactionState != null) goto L6;
        TransactionState r10 = new TransactionState();
        this.transactionState = r10;
        TransactionStateUtil.inspectAndInstrument(r10, this.impl);
    L6:
        return this.transactionState;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String r10, String r11) {
        this.impl.addRequestProperty(r10, r11);
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

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        TransactionState r10 = this.transactionState;
        if (r10 != null) goto L5;
    L7:
        this.impl.disconnect();
        return;
    L5:
        if (r10.isComplete() == true) goto L7;
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
    public Object getContent() throws IOException {
        getTransactionState();
        Object r10 = this.impl.getContent();     // Catch: IOException -> L10
        int r11 = this.impl.getContentLength();
        if (r11 < 0) goto L9;
        TransactionState r12 = getTransactionState();
        if (r12.isComplete() == true) goto L9;
        r12.setBytesReceived(r11);
        addTransactionAndErrorData(r12);
    L9:
        return r10;
    L10:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        getTransactionState();
        String r10 = this.impl.getContentEncoding();
        checkResponse();
        return r10;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        getTransactionState();
        int r10 = this.impl.getContentLength();
        checkResponse();
        return r10;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        getTransactionState();
        String r10 = this.impl.getContentType();
        checkResponse();
        return r10;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        getTransactionState();
        long r10 = this.impl.getDate();
        checkResponse();
        return r10;
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
        long r10 = this.impl.getExpiration();
        checkResponse();
        return r10;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int r10) {
        getTransactionState();
        String r11 = this.impl.getHeaderField(r10);
        checkResponse();
        return r11;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String r10, long r11) {
        getTransactionState();
        long r12 = this.impl.getHeaderFieldDate(r10, r11);
        checkResponse();
        return r12;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String r10, int r11) {
        getTransactionState();
        int r12 = this.impl.getHeaderFieldInt(r10, r11);
        checkResponse();
        return r12;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int r10) {
        getTransactionState();
        String r11 = this.impl.getHeaderFieldKey(r10);
        checkResponse();
        return r11;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getTransactionState();
        Map<String, List<String>> r10 = this.impl.getHeaderFields();
        checkResponse();
        return r10;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        getTransactionState();
        long r10 = this.impl.getIfModifiedSince();
        checkResponse();
        return r10;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        final TransactionState r10 = getTransactionState();
        CInputStream r11 = new CInputStream(this.impl.getInputStream());     // Catch: IOException -> L6
        TransactionStateUtil.inspectAndInstrumentResponse(r10, this.impl);     // Catch: IOException -> L6
        r11.addStreamCompleteListener(new AnonymousClass1(this, r10));
        return r11;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.impl.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        getTransactionState();
        long r10 = this.impl.getLastModified();
        checkResponse();
        return r10;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        final TransactionState r10 = getTransactionState();
        CountingOutputStream r11 = new CountingOutputStream(this.impl.getOutputStream());     // Catch: IOException -> L6
        r11.addStreamCompleteListener(new AnonymousClass2(this, r10));
        return r11;
    L6:
        e = move-exception;
        error(e);
        throw e;
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
    public String getRequestProperty(String r10) {
        return this.impl.getRequestProperty(r10);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        getTransactionState();
        int r10 = this.impl.getResponseCode();     // Catch: IOException -> L6
        checkResponse();
        return r10;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        getTransactionState();
        String r10 = this.impl.getResponseMessage();     // Catch: IOException -> L6
        checkResponse();
        return r10;
    L6:
        e = move-exception;
        error(e);
        throw e;
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
    public void setAllowUserInteraction(boolean r10) {
        this.impl.setAllowUserInteraction(r10);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int r10) {
        this.impl.setChunkedStreamingMode(r10);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r10) {
        this.impl.setConnectTimeout(r10);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean r10) {
        this.impl.setDefaultUseCaches(r10);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean r10) {
        this.impl.setDoInput(r10);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean r10) {
        this.impl.setDoOutput(r10);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int r10) {
        this.impl.setFixedLengthStreamingMode(r10);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long r10) {
        this.impl.setIfModifiedSince(r10);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean r10) {
        this.impl.setInstanceFollowRedirects(r10);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int r10) {
        this.impl.setReadTimeout(r10);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r10) throws ProtocolException {
        getTransactionState();
        this.impl.setRequestMethod(r10);     // Catch: ProtocolException -> L5
        return;
    L5:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String r10, String r11) {
        this.impl.setRequestProperty(r10, r11);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean r10) {
        this.impl.setUseCaches(r10);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.impl.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.impl.usingProxy();
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String r10) {
        getTransactionState();
        String r11 = this.impl.getHeaderField(r10);
        checkResponse();
        return r11;
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] r10) throws IOException {
        getTransactionState();
        Object r11 = this.impl.getContent(r10);     // Catch: IOException -> L6
        checkResponse();
        return r11;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }
}
