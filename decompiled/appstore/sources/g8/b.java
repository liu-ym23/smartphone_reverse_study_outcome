package g8;

import android.content.Context;
import android.os.AsyncTask;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AsyncTaskC0259b f20009b;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: g8.b$b, reason: collision with other inner class name */
    public class AsyncTaskC0259b extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20010a;

        public AsyncTaskC0259b(b r10) {
            this.f20010a = r10;
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... r10) {
            j.e("onThreadHandle");
            return this.f20010a.b();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object r10) {
            j.e("onHandleComplete");
            this.f20010a.a(r10);
        }

        public /* synthetic */ AsyncTaskC0259b(b r10, a r11) {
            this(r10);
        }
    }

    public b(Context r10) {
        this.f20008a = r10;
        this.f20009b = new AsyncTaskC0259b(this, null);
    }

    public abstract void a(Object r10);

    public abstract Object b();
}
