package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorDelivery implements ResponseDelivery {
    private final Executor mResponsePoster;

    public class ResponseDeliveryRunnable implements Runnable {
        private final Request mRequest;
        private final Response mResponse;
        private final Runnable mRunnable;
        final /* synthetic */ ExecutorDelivery this$0;

        public ResponseDeliveryRunnable(ExecutorDelivery r10, Request r11, Response r12, Runnable r13) {
            this.this$0 = r10;
            this.mRequest = r11;
            this.mResponse = r12;
            this.mRunnable = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled() == false) goto L7;
            this.mRequest.finish("canceled-at-delivery");
            return;
        L7:
            if (this.mResponse.isSuccess() == false) goto L9;
            this.mRequest.deliverResponse(this.mResponse.result);
        L11:
            if (this.mResponse.intermediate == false) goto L13;
            this.mRequest.addMarker("intermediate-response");
        L14:
            Runnable r10 = this.mRunnable;
            if (r10 == null) goto L18;
            r10.run();
            return;
        L18:
            return;
        L13:
            this.mRequest.finish("done");
            goto L14
        L9:
            this.mRequest.deliverError(this.mResponse.error);
            goto L11
        }
    }

    public ExecutorDelivery(final Handler r10) {
        this.mResponsePoster = new AnonymousClass1(this, r10);
    }

    @Override // com.android.volley.ResponseDelivery
    public void postError(Request<?> r10, VolleyError r11) {
        r10.addMarker("post-error");
        Response r12 = Response.error(r11);
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(this, r10, r12, null));
    }

    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> r10, Response<?> r11) {
        postResponse(r10, r11, null);
    }

    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> r10, Response<?> r11, Runnable r12) {
        r10.markDelivered();
        r10.addMarker("post-response");
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(this, r10, r11, r12));
    }

    public ExecutorDelivery(Executor r10) {
        this.mResponsePoster = r10;
    }
}
