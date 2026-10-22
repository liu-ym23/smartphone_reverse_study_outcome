package x6;

import com.bytedance.watson.assist.file.FileStatInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements FileStatInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f25452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f25453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f25457f;

    public c() {
        this.f25452a = new ArrayList();
        this.f25453b = new ArrayList();
        this.f25454c = 0;
        this.f25455d = 0;
        this.f25456e = 0;
        this.f25457f = 0.0d;
    }

    public void a(FileStatInfo r12) {
        if (r12 != null) goto L5;
        this.f25453b.addAll(this.f25452a);
        return;
    L5:
        List r13 = ((c) r12).e();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f25452a.size() == r13.size()) goto L12;
        a7.a.h("calculate cpu freqTime delta size error");
        return;
    L12:
        this.f25453b.clear();
        int r10 = 0;
    L14:
        if (r10 >= this.f25452a.size()) goto L23;
        LinkedHashMap r11 = (LinkedHashMap) this.f25452a.get(r10);
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
        a7.a.c("calculate cpu freqTime delta not found " + r18);
        goto L17
    L20:
        r15.put(r18, Long.valueOf(r19.longValue() - r20.longValue()));
        goto L17
    L22:
        this.f25453b.add(r15);
        r10 = r10 + 1;
        goto L14
    }

    public double b() {
        return this.f25457f;
    }

    public long c() {
        return this.f25455d;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        long r11 = g() - ((c) r10).g();
        this.f25455d = r11;
        if (this.f25456e != 0) goto L8;
        this.f25456e = r11;
        return;
    }

    public List d() {
        return this.f25453b;
    }

    public List e() {
        return this.f25452a;
    }

    public long f() {
        return this.f25456e;
    }

    public long g() {
        if (this.f25454c != 0) goto L14;
        if (this.f25452a.isEmpty() == true) goto L14;
        Iterator r10 = this.f25452a.iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        Iterator r11 = ((LinkedHashMap) r10.next()).entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L8;
        this.f25454c += ((Long) ((Map.Entry) r11.next()).getValue()).longValue();
    L14:
        return this.f25454c;
    }

    public void h(LinkedHashMap r10) {
        this.f25452a.add(r10);
    }

    public void i() {
        this.f25452a.clear();
        this.f25453b.clear();
        this.f25454c = 0;
        this.f25455d = 0;
        this.f25456e = 0;
        this.f25457f = 0.0d;
    }

    public void j(long r10) {
        if (this.f25455d >= 0) goto L5;
        return;
    L5:
        if (this.f25454c <= 0) goto L9;
        this.f25457f = 1.0d - (r10 / c());
        return;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f25456e += ((c) r10).f();
    }

    public String toString() {
        return "cputime:{deltaTime:" + c() + " usage:" + this.f25457f + " totaltime:" + g() + "}";
    }
}
