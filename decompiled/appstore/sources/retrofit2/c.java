package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends CallAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f24009a;

    public class a implements CallAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f24010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f24011b;

        public a(c r10, Type r11) {
            this.f24011b = r10;
            this.f24010a = r11;
        }

        public Call a(Call r10) {
            return new b(this.f24011b.f24009a, r10);
        }

        @Override // retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r10) {
            return a(r10);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.f24010a;
        }
    }

    public static final class b implements Call {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f24012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Call f24013b;

        public class a implements Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callback f24014a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f24015b;

            /* JADX INFO: renamed from: retrofit2.c$b$a$a, reason: collision with other inner class name */
            public class RunnableC0357a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Response f24016a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f24017b;

                public RunnableC0357a(a r10, Response r11) {
                    this.f24017b = r10;
                    this.f24016a = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f24017b.f24015b.f24013b.isCanceled() == false) goto L5;
                    a r10 = this.f24017b;
                    r10.f24014a.onFailure(r10.f24015b, new IOException("Canceled"));
                    return;
                L5:
                    a r11 = this.f24017b;
                    r11.f24014a.onResponse(r11.f24015b, this.f24016a);
                }
            }

            /* JADX INFO: renamed from: retrofit2.c$b$a$b, reason: collision with other inner class name */
            public class RunnableC0358b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f24018a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ a f24019b;

                public RunnableC0358b(a r10, Throwable r11) {
                    this.f24019b = r10;
                    this.f24018a = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a r10 = this.f24019b;
                    r10.f24014a.onFailure(r10.f24015b, this.f24018a);
                }
            }

            public a(b r10, Callback r11) {
                this.f24015b = r10;
                this.f24014a = r11;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call r10, Throwable r11) {
                this.f24015b.f24012a.execute(new RunnableC0358b(this, r11));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call r10, Response r11) {
                this.f24015b.f24012a.execute(new RunnableC0357a(this, r11));
            }
        }

        public b(Executor r10, Call r11) {
            this.f24012a = r10;
            this.f24013b = r11;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.f24013b.cancel();
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return mo73clone();
        }

        @Override // retrofit2.Call
        public void enqueue(Callback r10) {
            i.b(r10, "callback == null");
            this.f24013b.enqueue(new a(this, r10));
        }

        @Override // retrofit2.Call
        public Response execute() {
            return this.f24013b.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.f24013b.isCanceled();
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.f24013b.isExecuted();
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.f24013b.request();
        }

        @Override // retrofit2.Call
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public Call mo73clone() {
            return new b(this.f24012a, this.f24013b.mo73clone());
        }
    }

    public c(Executor r10) {
        this.f24009a = r10;
    }

    @Override // retrofit2.CallAdapter.a
    public CallAdapter a(Type r10, Annotation[] r11, Retrofit r12) {
        if (CallAdapter.a.c(r10) == Call.class) goto L7;
        return null;
    L7:
        return new a(this, i.g(r10));
    }
}
