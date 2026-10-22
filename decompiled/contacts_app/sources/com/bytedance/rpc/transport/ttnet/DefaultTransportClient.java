package com.bytedance.rpc.transport.ttnet;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.rpc.RpcContext;
import com.bytedance.rpc.RpcDataBuilder;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.log.Logger;
import com.bytedance.rpc.serialize.ByteType;
import com.bytedance.rpc.transport.StreamClosedCallback;
import com.bytedance.rpc.transport.TransportCallback;
import com.bytedance.rpc.transport.TransportClient;
import com.bytedance.rpc.transport.TransportRequest;
import com.bytedance.rpc.transport.TransportResponse;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultTransportClient implements TransportClient {
    private static volatile List<Interceptor> sOkInterceptor;
    private Map<String, WeakReference<RetrofitApi>> mApiMap;
    private Map<Integer, WeakReference<Call<TypedInput>>> mCalls;

    static {
    }

    static /* synthetic */ TransportResponse access$000(DefaultTransportClient r0, Call r1, SsResponse r2) {
        return r0.convert(r1, r2);
    }

    static /* synthetic */ void access$100(DefaultTransportClient r0, Call r1, Throwable r2) {
        r0.reportError(r1, r2);
    }

    static /* synthetic */ Map access$200(DefaultTransportClient r0) {
        return r0.mCalls;
    }

    static /* synthetic */ void access$300(DefaultTransportClient r0, Call r1, Response r2, long r3) {
        r0.reportOK(r1, r2, r3);
    }

    public static void addOkInterceptor(Interceptor r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (sOkInterceptor != null) goto L16;
        monitor-enter(DefaultTransportClient.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (sOkInterceptor != null) goto L10;
        sOkInterceptor = Collections.synchronizedList(new ArrayList(2));     // Catch: Throwable -> L12
    L10:
        monitor-exit(DefaultTransportClient.class);     // Catch: Throwable -> L12
    L16:
        if (sOkInterceptor.contains(r3) == true) goto L22;
        sOkInterceptor.add(r3);
        return;
    }

    public static void removeOkInterceptor(Interceptor r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (sOkInterceptor == null) goto L8;
        sOkInterceptor.remove(r1);
        return;
    }

    public DefaultTransportClient(RpcContext r2) {
        this.mApiMap = new ConcurrentHashMap(4);
        this.mCalls = new ConcurrentHashMap(4);
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public void transport(TransportRequest r3, final TransportCallback r4) throws Exception {
        final int r0 = r3.getRequestId();
        visitApi(r3).enqueue(new AnonymousClass1(this, r4, r0));
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public TransportResponse transport(TransportRequest r3) throws Exception {
        Call<TypedInput> r0 = visitApi(r3);     // Catch: Throwable -> L8
        TransportResponse r1 = convert(r0, r0.execute());     // Catch: Throwable -> L6
        this.mCalls.remove(Integer.valueOf(r3.getRequestId()));
        return r1;
    L6:
        th = th;
    L15:
        reportError(r0, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mCalls.remove(Integer.valueOf(r3.getRequestId()));
        throw th;
    L8:
        th = th;
        r0 = null;
        goto L15
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public void cancel(int r3) {
        WeakReference<Call<TypedInput>> r0 = this.mCalls.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
    L9:
        this.mCalls.remove(Integer.valueOf(r3));
        return;
    L5:
        if (r0.get() == null) goto L9;
        if (r0.get().isCanceled() == true) goto L9;
        r0.get().cancel();
        goto L9
    }

    @Override // com.bytedance.rpc.transport.TransportClient
    public void destroy() {
        this.mApiMap.clear();
        this.mCalls.clear();
    }

    private Call<TypedInput> visitApi(TransportRequest r12) throws Exception {
        int r0 = r12.getRequestId();
        String r1 = r12.getUrl();
        boolean r3 = r12.isParamsNeed();
        RpcDataBuilder.SerializerData r2 = r12.getRequestData();
        LinkedList r7 = new LinkedList();
        LinkedHashMap r5 = new LinkedHashMap(r2.getQueries());
        RequestContext r8 = new RequestContext();
        r8.timeout_connect = r12.getConnectTimeout();
        r8.timeout_read = r12.getReadTimeout();
        r8.timeout_write = r12.getWriteTimeout();
        Iterator<Map.Entry<String, String>> r4 = r2.getHeaders().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, String> r6 = r4.next();
        String r9 = r6.getKey();
        String r10 = r6.getValue();
        if (r9 == null) goto L4;
        if (r10 == null) goto L4;
        r7.add(new Header(r9, r10));
        goto L4
    L9:
        Pair<String, String> r11 = UrlUtils.parseUrl(r1, r5);
        String r13 = (String) r11.first;
        String r14 = (String) r11.second;
        RetrofitApi r15 = getApi(r13);
        if (r12.isPostMethod() == true) goto L12;
        Call<TypedInput> r16 = r15.get(r3, r14, r5, r7, r8);
    L16:
        this.mCalls.put(Integer.valueOf(r0), new WeakReference(r16));
        return r16;
    L12:
        if (r2.isFormData() == false) goto L14;
        r16 = r15.form(r3, r14, r5, new LinkedHashMap(r2.getFields()), r7, r8);
        goto L16
    L14:
        r16 = r15.post(r3, r14, r5, createTypedOutput(r2), r7, r8);
        goto L16
    }

    private TypedOutput createTypedOutput(RpcDataBuilder.SerializerData r8) {
        if (r8.isMutiData() == false) goto L25;
        MultipartTypedOutput r7 = new MultipartTypedOutput();
        Iterator<Map.Entry<String, String>> r2 = r8.getFields().entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, String> r3 = r2.next();
        String r4 = r3.getKey();
        String r5 = r3.getValue();
        if (RpcUtils.isVisible(r4) == false) goto L6;
        if (RpcUtils.isVisible(r5) == false) goto L6;
        r7.addPart(r4, new TypedString(r5));
        goto L6
    L12:
        Iterator<Map.Entry<String, File>> r6 = r8.getFiles().entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L21;
        Map.Entry<String, File> r9 = r6.next();
        String r10 = r9.getKey();
        File r11 = r9.getValue();
        if (r11 == null) goto L14;
        if (RpcUtils.isInvisible(r10) == false) goto L20;
        r10 = r11.getName();
    L20:
        r7.addPart(r10, new TypedFile(null, r11));
        goto L14
    L21:
        Iterator<ByteType> r12 = r8.getData().iterator();
    L23:
        if (r12.hasNext() == false) goto L44;
        ByteType r0 = r12.next();
        r7.addPart(r0.getName(), new TypedByteArray(r0.getContentType(), r0.getData(), new String[]{r0.getFileName()}));
        goto L23
    L44:
        return r7;
    L25:
        List<ByteType> r13 = r8.getData();
        if (r13.size() != 0) goto L29;
        return new TypedByteArray(null, RpcUtils.EMPTY_BYTE_ARR, new String[0]);
    L29:
        return new TypedByteArray(r13.get(0).getContentType(), r13.get(0).getData(), new String[0]);
    }

    private TransportResponse convert(final Call<TypedInput> r11, SsResponse<TypedInput> r12) {
        final long r4 = System.currentTimeMillis();
        final Response r6 = r12.raw();
        TypedInput r7 = r12.body();
        LinkedHashMap r8 = new LinkedHashMap();
        StreamClosedCallback r9 = new AnonymousClass2(this, r11, r6, r4);
        if (r7 != null) goto L5;
        DefaultTransportInput r10 = null;
    L7:
        if (r6.getHeaders() == null) goto L12;
        Iterator<Header> r13 = r6.getHeaders().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        Header r0 = r13.next();
        r8.put(r0.getName(), r0.getValue());
    L12:
        String r14 = r12.raw().getReason();
        if (TextUtils.isEmpty(r14) == true) goto L15;
    L17:
        int r15 = r12.code();
        if (r10 != null) goto L21;
        r9.onClosed();
    L21:
        return TransportResponse.newBuilder(r15).setHttpMsg(r14).setHeaders(r8).setBody(r10).build();
    L15:
        if (r12.isSuccessful() == true) goto L17;
        r14 = (String) r8.get("Reason-Phrase");
        goto L17
    L5:
        r10 = new DefaultTransportInput(r7, r9);
        goto L7
    }

    private void reportError(Call<TypedInput> r8, Throwable r9) {
        reportInner(r8, null, System.currentTimeMillis(), false, r9);
    }

    private void reportOK(Call<TypedInput> r8, Response r9, long r10) {
        reportInner(r8, r9, r10, true, null);
    }

    private void reportInner(Call<TypedInput> r14, Response r15, long r16, boolean r18, Throwable r19) {
        long r1 = System.currentTimeMillis();
        if ((r14 instanceof IMetricsCollect) == false) goto L5;
        ((IMetricsCollect) r14).doCollect();
    L5:
        HttpRequestInfo r3 = null;
        if (r15 == null) goto L8;
        Object r4 = r15.getExtraInfo();
    L10:
        if ((r4 instanceof HttpRequestInfo) == false) goto L12;
        r3 = (HttpRequestInfo) r4;
        Logger.d(r3.requestLog);
    L12:
        HttpRequestInfo r11 = r3;
        if (r11 == null) goto L18;
        r11.completeReadResponse = r16;
        r11.requestEnd = r1;
        long r7 = r11.requestStart;
        long r5 = r11.requestEnd - r7;
        String r9 = r15.getUrl();
        String r10 = RetrofitUtils.getHeaderValueIgnoreCase(r15.getHeaders(), "X-TT-LOGID");
        if (r18 == false) goto L17;
        NetworkParams.monitorApiSample(r5, r7, r9, r10, r11);
        goto L18
    L17:
        NetworkParams.monitorApiError(r5, r7, r9, r10, r11, r19);
    L18:
        if (r14 != null) goto L20;
        return;
    L20:
        if (r14.isCanceled() == true) goto L24;
        r14.cancel();
        return;
    L24:
        return;
    L8:
        r4 = null;
        goto L10
    }

    private RetrofitApi getApi(String r3) {
        WeakReference<RetrofitApi> r0 = this.mApiMap.get(r3);
        if (r0 != null) goto L5;
        RetrofitApi r1 = null;
    L6:
        if (r1 != null) goto L9;
        RetrofitApi r2 = (RetrofitApi) RetrofitUtils.createSsRetrofit(r3, sOkInterceptor, null).create(RetrofitApi.class);
        this.mApiMap.put(r3, new WeakReference(r2));
        return r2;
    L9:
        return r1;
    L5:
        r1 = r0.get();
        goto L6
    }
}
