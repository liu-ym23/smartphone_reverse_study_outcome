package q8;

import android.util.SparseArray;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.network.FetchDataCallBack;

/* JADX INFO: loaded from: classes2.dex */
public class b implements FetchDataCallBack {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f23565c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f23566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f23567b;

    static {
    }

    public b() {
        this.f23567b = new Object();
        this.f23566a = new SparseArray();
    }

    public static synchronized b c() {
        monitor-enter(b.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f23565c != null) goto L9;
        f23565c = new b();     // Catch: Throwable -> L7
    L9:
        b r10 = f23565c;     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r10;
    }

    public void a(int r10, APresenter r11) {
        Object r12 = this.f23567b;
        monitor-enter(r12);
        if (r11 == null) goto L13;
        if (this.f23566a.get(r10) != null) goto L10;
        this.f23566a.put(r10, r11);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L13:
        throw new NullPointerException();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void b(int r10) {
        Object r11 = this.f23567b;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f23566a.get(r10) == null) goto L9;
        this.f23566a.delete(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public synchronized void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
        monitor-enter(this);
        Object r14 = this.f23567b;     // Catch: Throwable -> L15
        monitor-enter(r14);     // Catch: Throwable -> L15
        APresenter r15 = (APresenter) this.f23566a.get(r10);     // Catch: Throwable -> L8
        if (r15 == null) goto L10;
        r15.onFetchDataFailed(r10, r11, r12, r13);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r14);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
        Object r15 = this.f23567b;
        monitor-enter(r15);
        APresenter r16 = (APresenter) this.f23566a.get(r10);     // Catch: Throwable -> L7
        if (r16 == null) goto L9;
        r16.onFetchDataSuccess(r10, r11, r12, r13, r14);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r15);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
