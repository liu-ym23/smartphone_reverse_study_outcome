package x6;

import com.bytedance.watson.assist.file.FileStatInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements FileStatInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f25467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f25468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f25469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f25471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f25472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f25473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f25474h;

    public e() {
        this.f25467a = new ArrayList();
        this.f25468b = new ArrayList();
        this.f25469c = new ArrayList();
        this.f25470d = false;
        this.f25472f = 0;
        this.f25473g = 0;
        this.f25474h = 0;
    }

    public void a(LinkedHashMap r10) {
        if (r10 == null) goto L5;
        this.f25467a.add(r10);
        return;
    }

    public List b() {
        return this.f25468b;
    }

    public List c() {
        return this.f25469c;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r12) {
        if (r12 != null) goto L5;
        this.f25468b.addAll(this.f25467a);
        return;
    L5:
        List r13 = ((e) r12).d();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f25467a.size() == r13.size()) goto L12;
        a7.a.h("calculate proc freqTime delta size error");
        return;
    L12:
        this.f25468b.clear();
        int r10 = 0;
    L14:
        if (r10 >= this.f25467a.size()) goto L23;
        LinkedHashMap r11 = (LinkedHashMap) this.f25467a.get(r10);
        LinkedHashMap r14 = (LinkedHashMap) r13.get(r10);
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r16 = r11.entrySet().iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        Map.Entry r17 = (Map.Entry) r16.next();
        Long r18 = (Long) r17.getKey();
        Long r19 = (Long) r17.getValue();
        Long r20 = (Long) r14.get(r18);
        if (r20 != null) goto L20;
        a7.a.c("calculate proc freqTime delta not found " + r18);
        goto L17
    L20:
        r15.put(r18, Long.valueOf(r19.longValue() - r20.longValue()));
        goto L17
    L22:
        this.f25468b.add(r15);
        r10 = r10 + 1;
        goto L14
    }

    public List d() {
        return this.f25467a;
    }

    public long e() {
        if (this.f25472f != 0) goto L6;
        this.f25472f = h(this.f25467a);
    L6:
        return this.f25472f;
    }

    public long f() {
        if (this.f25473g != 0) goto L6;
        this.f25473g = h(this.f25468b);
    L6:
        return this.f25473g;
    }

    public long g() {
        if (this.f25474h != 0) goto L6;
        this.f25474h = h(this.f25469c);
    L6:
        return this.f25474h;
    }

    public final long h(List r10) {
        if (this.f25470d == true) goto L5;
        this.f25471e = com.bytedance.watson.assist.utils.a.b();
        this.f25470d = true;
    L5:
        long r11 = 0;
        if (r10 != null) goto L8;
    L18:
        return r11;
    L8:
        if (r10.isEmpty() == true) goto L18;
        int r12 = r10.size();
        if (r12 != this.f25471e.size()) goto L18;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L18;
        Iterator r14 = ((LinkedHashMap) r10.get(r13)).entrySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        r11 = r11 + ((Long) ((Map.Entry) r14.next()).getValue()).longValue();
        goto L15
    L17:
        r13 = r13 + 1;
        goto L12
    }

    public void i() {
        this.f25467a.clear();
        this.f25468b.clear();
        this.f25469c.clear();
        this.f25472f = 0;
        this.f25473g = 0;
        this.f25474h = 0;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        e r15 = (e) r14;
        List r10 = r15.d();
        List r16 = r15.b();
        if (r16.isEmpty() == true) goto L9;
        r10 = r16;
    L9:
        if (this.f25469c.isEmpty() == false) goto L12;
        this.f25469c.addAll(r10);
        return;
    L12:
        int r17 = this.f25469c.size();
        if (r17 == r10.size()) goto L16;
        a7.a.h("merge freqTime size error");
        return;
    L16:
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L17:
        if (r12 >= r17) goto L26;
        LinkedHashMap r13 = (LinkedHashMap) this.f25469c.get(r12);
        LinkedHashMap r18 = (LinkedHashMap) r10.get(r12);
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r13.entrySet().iterator();
    L20:
        if (r20.hasNext() == false) goto L25;
        Map.Entry r21 = (Map.Entry) r20.next();
        Long r22 = (Long) r21.getKey();
        Long r23 = (Long) r21.getValue();
        Long r24 = (Long) r18.get(r22);
        if (r24 != null) goto L23;
        a7.a.h("merge freqTimeDetla freq not found " + r22);
        goto L20
    L23:
        r19.put(r22, Long.valueOf(r23.longValue() + r24.longValue()));
        goto L20
    L25:
        r11.add(r19);
        r12 = r12 + 1;
        goto L17
    L26:
        this.f25469c = r11;
    }

    public String toString() {
        return "ProcTimeInStateInfo{freqTimeMapList=" + this.f25467a + ", freqDeltaTimeMapList=" + this.f25468b + ", totalCpuTime=" + e() + ", totalDeltaCpuTime=" + f() + ", totalMergeCpuTime=" + g() + '}';
    }
}
