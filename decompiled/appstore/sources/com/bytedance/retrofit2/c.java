package com.bytedance.retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class c extends CallAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f7949a;

    public class a implements CallAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f7950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f7951b;

        public a(c r10, Type r11) {
            this.f7951b = r10;
            this.f7950a = r11;
        }

        public Call a(Call r10) {
            return new b(this.f7951b.f7949a, r10);
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r10) {
            return a(r10);
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public Type responseType() {
            return this.f7950a;
        }
    }

    public static final class b implements Call, IMetricsCollect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f7952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Call f7953b;

        public class a implements ExpandCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callback f7954a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f7955b;

            /* JADX INFO: renamed from: com.bytedance.retrofit2.c$b$a$a, reason: collision with other inner class name */
            public class RunnableC0100a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f6.f f7956a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f7957b;

                public RunnableC0100a(a r10, f6.f r11) {
                    this.f7957b = r10;
                    this.f7956a = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f7957b.f7955b.f7953b.isCanceled() == false) goto L5;
                    a r10 = this.f7957b;
                    r10.f7954a.onFailure(r10.f7955b, new IOException("Canceled"));
                    return;
                L5:
                    a r11 = this.f7957b;
                    r11.f7954a.onResponse(r11.f7955b, this.f7956a);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.retrofit2.c$b$a$b, reason: collision with other inner class name */
            public class RunnableC0101b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f7958a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f7959b;

                public RunnableC0101b(a r10, Throwable r11) {
                    this.f7959b = r10;
                    this.f7958a = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a r10 = this.f7959b;
                    r10.f7954a.onFailure(r10.f7955b, this.f7958a);
                }
            }

            public a(b r10, Callback r11) {
                this.f7955b = r10;
                this.f7954a = r11;
            }

            @Override // com.bytedance.retrofit2.ExpandCallback
            public void onAsyncPreRequest(f6.d r10) {
                Callback r11 = this.f7954a;
                if ((r11 instanceof ExpandCallback) == false) goto L6;
                ((ExpandCallback) r11).onAsyncPreRequest(r10);
                return;
            }

            @Override // com.bytedance.retrofit2.ExpandCallback
            public void onAsyncResponse(Call r10, f6.f r11) {
                Callback r12 = this.f7954a;
                if ((r12 instanceof ExpandCallback) == false) goto L6;
                ((ExpandCallback) r12).onAsyncResponse(r10, r11);
                return;
            }

            @Override // com.bytedance.retrofit2.Callback
            public void onFailure(Call r10, Throwable r11) {
                this.f7955b.f7952a.execute(new RunnableC0101b(this, r11));
            }

            @Override // com.bytedance.retrofit2.Callback
            public void onResponse(Call r10, f6.f r11) {
                this.f7955b.f7952a.execute(new RunnableC0100a(this, r11));
            }
        }

        public b(Executor r10, Call r11) {
            this.f7952a = r10;
            this.f7953b = r11;
        }

        @Override // com.bytedance.retrofit2.Call
        public void cancel() {
            this.f7953b.cancel();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8clone() {
            return clone();
        }

        @Override // com.bytedance.retrofit2.IMetricsCollect
        public void doCollect() {
            Call r10 = this.f7953b;
            if ((r10 instanceof IMetricsCollect) == false) goto L6;
            ((IMetricsCollect) r10).doCollect();
            return;
        }

        @Override // com.bytedance.retrofit2.Call
        public void enqueue(Callback r10) {
            if (r10 == null) goto L6;
            this.f7953b.enqueue(new a(this, r10));
            return;
        L6:
            throw new NullPointerException("callback == null");
        }

        @Override // com.bytedance.retrofit2.Call
        public f6.f execute() {
            return this.f7953b.execute();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isCanceled() {
            return this.f7953b.isCanceled();
        }

        @Override // com.bytedance.retrofit2.Call
        public boolean isExecuted() {
            return this.f7953b.isExecuted();
        }

        @Override // com.bytedance.retrofit2.Call
        public g6.b request() {
            return this.f7953b.request();
        }

        @Override // com.bytedance.retrofit2.Call
        public Call clone() {
            return new b(this.f7952a, this.f7953b.clone());
        }
    }

    public c(Executor r10) {
        this.f7949a = r10;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.a
    public CallAdapter a(Type r10, Annotation[] r11, f r12) {
        if (CallAdapter.a.b(r10) == Call.class) goto L7;
        return null;
    L7:
        return new a(this, f6.g.g(r10));
    }
}
