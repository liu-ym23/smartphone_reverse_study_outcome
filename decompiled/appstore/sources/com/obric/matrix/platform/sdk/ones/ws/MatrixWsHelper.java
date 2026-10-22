package com.obric.matrix.platform.sdk.ones.ws;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.SendCMDResultCallback;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.SubscribeWsMsgResponse;
import com.obric.matrix.proto.SubscribeWsStatusResponse;
import com.obric.matrix.proto.WsMessageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class MatrixWsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MatrixWsHelper f11959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IWsBridge f11960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f11961c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f11962d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f11963e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f11964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f11965g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final WsStatusReceiver f11966h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Function2 f11967i;

    public static final class a implements SendCMDResultCallback {
        public a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.SendCMDResultCallback
        public void onResult(int r14, Response r15) {
            q.g(r15, "response");
            ResponseBody r13 = r15.body;
            if (r13 == null) goto L10;
            SubscribeWsMsgResponse r16 = r13.subscribeWsMsgResponse;
            if (r16 == null) goto L11;
            ConcurrentHashMap r17 = MatrixWsHelper.a();
            Integer r18 = r16.wsMessageInfo.service;
            q.f(r18, "it.wsMessageInfo.service");
            int r19 = r18.intValue();
            Integer r10 = r16.wsMessageInfo.method;
            q.f(r10, "it.wsMessageInfo.method");
            Function9 r11 = (Function9) r17.get(com.obric.matrix.platform.sdk.ones.ws.a.a(r19, r10.intValue()));
            if (r11 == null) goto L12;
            Integer r12 = r16.wsMessageInfo.channelId;
            q.f(r12, "it.wsMessageInfo.channelId");
            Long r20 = r16.wsMessageInfo.seqId;
            q.f(r20, "it.wsMessageInfo.seqId");
            Long r21 = r16.wsMessageInfo.logId;
            q.f(r21, "it.wsMessageInfo.logId");
            Integer r22 = r16.wsMessageInfo.service;
            q.f(r22, "it.wsMessageInfo.service");
            Integer r23 = r16.wsMessageInfo.method;
            q.f(r23, "it.wsMessageInfo.method");
            WsMessageInfo r110 = r16.wsMessageInfo;
            r11.invoke(r12, r20, r21, r22, r23, r110.payloadEncoding, r110.payloadType, r110.payload.toByteArray(), r16.wsMessageInfo.headers);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements SendCMDResultCallback {
        public b() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.SendCMDResultCallback
        public void onResult(int r10, Response r11) {
            q.g(r11, "response");
            ResponseBody r12 = r11.body;
            if (r12 == null) goto L10;
            SubscribeWsStatusResponse r13 = r12.subscribeWsStatusResponse;
            if (r13 == null) goto L10;
            Log.d("MatrixWsHelper", "wsStatusCallbackFromMatrix # onResult() called with subscribeWsStatusResponse = " + r13);
            MatrixWsHelper r14 = MatrixWsHelper.f11959a;
            Boolean r15 = r13.isConnected;
            q.f(r15, "it.isConnected");
            MatrixWsHelper.d(r15.booleanValue());
            Iterator r16 = MatrixWsHelper.b().iterator();
        L8:
            if (r16.hasNext() == false) goto L10;
            Function4 r17 = (Function4) r16.next();
            Integer r18 = r13.channelType;
            q.f(r18, "it.channelType");
            Integer r19 = r13.connectionState;
            q.f(r19, "it.connectionState");
            Integer r20 = r13.channelId;
            q.f(r20, "it.channelId");
            Boolean r21 = r13.isConnected;
            q.f(r21, "it.isConnected");
            r17.invoke(r18, r19, r20, r21);
        L10:
            Function2 r22 = MatrixWsHelper.c();
            if (r22 == null) goto L22;
            ResponseBody r23 = r11.body;
            if (r23 == null) goto L15;
            SubscribeWsStatusResponse r24 = r23.subscribeWsStatusResponse;
        L16:
            if (r24 == null) goto L18;
            boolean r25 = true;
        L19:
            r22.mo0invoke(Boolean.valueOf(r25), r11);
            MatrixWsHelper.e(null);
            return;
        L18:
            r25 = false;
            goto L19
        L15:
            r24 = null;
            goto L16
        }
    }

    static {
        f11959a = new MatrixWsHelper();
        f11961c = new ArrayList();
        f11962d = new ConcurrentHashMap();
        f11963e = new a();
        f11965g = new b();
        f11966h = new WsStatusReceiver(MatrixWsHelper$wsStatusReceiverFromMatrix$1.INSTANCE);
    }

    public MatrixWsHelper() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f11962d;
    }

    public static final /* synthetic */ List b() {
        return f11961c;
    }

    public static final /* synthetic */ Function2 c() {
        return f11967i;
    }

    public static final /* synthetic */ void d(boolean r10) {
        f11964f = r10;
    }

    public static final /* synthetic */ void e(Function2 r10) {
        f11967i = r10;
    }

    public final void f(int r16, long r17, long r19, int r21, int r22, String r23, String r24, byte[] r25, HashMap r26) {
        hc.b.b("MatrixWsHelper", "onWsMsgReceivedByProvider() called with: channelId = " + r16 + ", seqId = " + r17 + ", logId = " + r19 + ", service = " + r21 + ", method = " + r22 + ", encoding = " + r23 + ", type = " + r24 + ", payload = " + r25 + ", headers = " + r26 + ", wsBridge is " + f11960b, null, 4, null);
        IWsBridge r10 = f11960b;
        if (r10 == null) goto L6;
        r10.onWsMsgReceived(r16, r17, r19, r21, r22, r23, r24, r25, r26);
        return;
    }
}
