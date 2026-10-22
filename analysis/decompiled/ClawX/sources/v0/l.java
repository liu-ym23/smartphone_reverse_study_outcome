package v0;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f5873e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    public static final m.d f5874f = new m.d(3);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f5875a;

    /* renamed from: b, reason: collision with root package name */
    public long f5876b;

    /* renamed from: c, reason: collision with root package name */
    public long f5877c;
    public ArrayList d;

    public final void a(RecyclerView recyclerView, int i8, int i9) {
        if (recyclerView.f781p && this.f5876b == 0) {
            this.f5876b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        p1.m mVar = recyclerView.W;
        mVar.f4724a = i8;
        mVar.f4725b = i9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
    
        r7 = r3.f758a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        r3.w();
        r7.i(r6, r4);
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
    
        if (r4.e() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        if (r4.f() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bf, code lost:
    
        r7.g(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c6, code lost:
    
        r7.a(null, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c9, code lost:
    
        r3.x(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00da, code lost:
    
        r3.x(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
    
        throw r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r12) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.l.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f5875a;
        try {
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i8 = 0; i8 < size; i8++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i8);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f5877c);
                }
            }
        } finally {
            this.f5876b = 0L;
            Trace.endSection();
        }
    }
}
