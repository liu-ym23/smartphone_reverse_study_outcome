package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Operation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class v extends androidx.work.k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f5883j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f5884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f5886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f5888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f5889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f5890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Operation f5892i;

    static {
        f5883j = androidx.work.i.i("WorkContinuationImpl");
    }

    public v(c0 r10, List r11) {
        this(r10, null, ExistingWorkPolicy.KEEP, r11, null);
    }

    public static boolean i(v r10, Set r11) {
        r11.addAll(r10.c());
        Set r12 = l(r10);
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        if (r12.contains((String) r13.next()) == false) goto L4;
        return true;
    L8:
        List r14 = r10.e();
        if (r14 != null) goto L11;
    L18:
        r11.removeAll(r10.c());
        return false;
    L11:
        if (r14.isEmpty() == true) goto L18;
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        if (i((v) r15.next(), r11) == false) goto L14;
        return true;
    }

    public static Set l(v r10) {
        HashSet r11 = new HashSet();
        List r12 = r10.e();
        if (r12 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r12.isEmpty() == true) goto L10;
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r11.addAll(((v) r13.next()).c());
        goto L8
    }

    public Operation a() {
        if (this.f5891h == true) goto L5;
        androidx.work.impl.utils.c r10 = new androidx.work.impl.utils.c(this);
        this.f5884a.r().executeOnTaskThread(r10);
        this.f5892i = r10.d();
    L7:
        return this.f5892i;
    L5:
        androidx.work.i.e().k(f5883j, "Already enqueued work ids (" + TextUtils.join(", ", this.f5888e) + ")");
        goto L7
    }

    public ExistingWorkPolicy b() {
        return this.f5886c;
    }

    public List c() {
        return this.f5888e;
    }

    public String d() {
        return this.f5885b;
    }

    public List e() {
        return this.f5890g;
    }

    public List f() {
        return this.f5887d;
    }

    public c0 g() {
        return this.f5884a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f5891h;
    }

    public void k() {
        this.f5891h = true;
    }

    public v(c0 r10, String r11, ExistingWorkPolicy r12, List r13) {
        this(r10, r11, r12, r13, null);
    }

    public v(c0 r10, String r11, ExistingWorkPolicy r12, List r13, List r14) {
        this.f5884a = r10;
        this.f5885b = r11;
        this.f5886c = r12;
        this.f5887d = r13;
        this.f5890g = r14;
        this.f5888e = new ArrayList(r13.size());
        this.f5889f = new ArrayList();
        if (r14 == null) goto L8;
        Iterator r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        v r16 = (v) r15.next();
        this.f5889f.addAll(r16.f5889f);
    L8:
        int r17 = 0;
    L10:
        if (r17 >= r13.size()) goto L12;
        String r18 = ((androidx.work.l) r13.get(r17)).b();
        this.f5888e.add(r18);
        this.f5889f.add(r18);
        r17 = r17 + 1;
        goto L10
    }
}
