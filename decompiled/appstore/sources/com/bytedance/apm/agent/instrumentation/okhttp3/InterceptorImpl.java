package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import fg.j;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Source;

/* JADX INFO: loaded from: classes.dex */
public class InterceptorImpl implements Interceptor {
    private static final String TAG = "InterceptorImpl";

    public class ResponseBodyWrapper extends ResponseBody {
        private BufferedSource bufferedSource;
        private final Response response;
        private final ResponseBody responseBody;
        final /* synthetic */ InterceptorImpl this$0;
        private long totalBytesRead;
        private final TransactionState transactionState;

        public ResponseBodyWrapper(InterceptorImpl r10, Response r11, TransactionState r12) {
            this.this$0 = r10;
            this.totalBytesRead = 0;
            this.response = r11;
            this.responseBody = r11.a();
            this.transactionState = r12;
        }

        public static /* synthetic */ long access$000(ResponseBodyWrapper r10) {
            return r10.totalBytesRead;
        }

        public static /* synthetic */ long access$002(ResponseBodyWrapper r10, long r11) {
            r10.totalBytesRead = r11;
            return r11;
        }

        public static /* synthetic */ void access$100(ResponseBodyWrapper r10) {
            r10.end();
        }

        private void end() {
            if (this.transactionState.isComplete() == false) goto L5;
            return;
        L5:
            this.transactionState.setBytesReceived(this.totalBytesRead);
            MonitorRecorder.reportMonitorData(this.transactionState, this.response);
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.responseBody.close();
            end();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.responseBody.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            if (this.bufferedSource != null) goto L6;
            this.bufferedSource = j.d(source(this.responseBody.source()));
        L6:
            return this.bufferedSource;
        }

        private Source source(final Source r10) {
            return new AnonymousClass1(this, r10);
        }
    }

    public InterceptorImpl() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) throws IOException {
        Request r11 = r10.request();
        String r12 = r11.c("User-Agent");
        if (r12 != null) goto L5;
    L8:
        TransactionState r13 = new TransactionState();
        MonitorRecorder.recordRequest(r11, r13);
        Response r14 = r10.proceed(r11);     // Catch: IOException -> L18
        MonitorRecorder.recordResponse(r14, r13);
        if (r13.getReceivedBytes() < 0) goto L13;
    L16:
        MonitorRecorder.reportMonitorData(r13, r14);
        return r14;
    L13:
        if (TextUtils.isEmpty(r14.f("Transfer-Encoding")) == true) goto L16;
        r13.addAssistData("Transfer-Encoding", r14.f("Transfer-Encoding"));
        return r14.n().b(new ResponseBodyWrapper(this, r14, r13)).c();
    L18:
        e = move-exception;
        MonitorRecorder.reportExceptionMonitor(r13, e);
        throw e;
    L5:
        if (r12.contains("tt") == false) goto L8;
        return r10.proceed(r11);
    }
}
