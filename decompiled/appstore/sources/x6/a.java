package x6;

import com.bytedance.watson.assist.file.FileStatInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements FileStatInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f25432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f25433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25436e;

    public a() {
        this.f25432a = new ArrayList();
        this.f25433b = new ArrayList();
        this.f25434c = 0;
        this.f25435d = 0;
        this.f25436e = 0;
    }

    public void a(FileStatInfo r12) {
        if (r12 != null) goto L5;
        this.f25433b.addAll(this.f25432a);
        return;
    L5:
        List r13 = ((a) r12).b();
        if (r13.isEmpty() == false) goto L8;
        return;
    L8:
        int r10 = this.f25432a.size();
        if (r10 == r13.size()) goto L12;
        a7.a.h("calculate cpu idle time delta size error1");
        return;
    L12:
        this.f25433b.clear();
        int r11 = 0;
    L13:
        if (r11 >= r10) goto L32;
        List r14 = (List) this.f25432a.get(r11);
        List r15 = (List) r13.get(r11);
        ArrayList r16 = new ArrayList();
        if (r14 == null) goto L25;
        if (r15 == null) goto L25;
        if (r14.size() != r15.size()) goto L25;
        int r17 = 0;
    L22:
        if (r17 >= r14.size()) goto L24;
        r16.add(Long.valueOf(((Long) r14.get(r17)).longValue() - ((Long) r15.get(r17)).longValue()));
        r17 = r17 + 1;
        goto L22
    L24:
        this.f25433b.add(r16);
        r11 = r11 + 1;
    L25:
        a7.a.h("calculate cpu idle time delta size error2");
        return;
    }

    public List b() {
        return this.f25432a;
    }

    public long c() {
        return this.f25435d;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r11 = e() - ((a) r10).e();
        this.f25435d = r11;
        if (this.f25436e != 0) goto L8;
        this.f25436e = r11;
        return;
    }

    public long d() {
        return this.f25436e;
    }

    public long e() {
        if (this.f25434c != 0) goto L14;
        if (this.f25432a.isEmpty() == true) goto L14;
        Iterator r10 = this.f25432a.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Iterator r11 = ((List) r10.next()).iterator();
    L11:
        if (r11.hasNext() == false) goto L8;
        this.f25434c += ((Long) r11.next()).longValue();
    L14:
        return this.f25434c;
    }

    public void f(List r10) {
        if (r10 == null) goto L5;
        this.f25432a.add(r10);
        return;
    }

    public void g() {
        this.f25432a.clear();
        this.f25433b.clear();
        this.f25434c = 0;
        this.f25435d = 0;
        this.f25436e = 0;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f25436e += ((a) r10).d();
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.f25432a + ", stateDeltaTimeLists=" + this.f25433b + ", totalCpuIdleTime=" + this.f25434c + ", deltaCpuIdleTime=" + this.f25435d + ", mergedDeltaCpuIdleTime=" + this.f25436e + '}';
    }
}
