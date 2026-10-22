package com.bytedance.apm6.consumer.slardar.a;

import android.text.TextUtils;
import com.bytedance.apm6.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SlardarHandlerConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f5057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f5058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f5059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5060e;
    private boolean f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    public a() {
        this.f5060e = true;
        this.f = true;
    }

    public void a(int r1) {
        this.k = r1;
    }

    public int a() {
        return this.k;
    }

    public void a(long r1) {
        this.f5056a = r1;
    }

    public void b(long r1) {
        this.g = r1;
    }

    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (f.a(r4) == false) goto L5;
        return;
    L5:
        this.f5057b = r4;
    }

    public List<String> b() {
        return this.f5057b;
    }

    public void a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        this.f5058c = r0;
        r0.add(r2);
    }

    public void b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        this.f5059d = r0;
        r0.add(r2);
    }

    public List<String> c() {
        return this.f5059d;
    }

    public List<String> d() {
        return this.f5058c;
    }

    public void a(boolean r1) {
        this.f5060e = r1;
    }

    public boolean e() {
        return this.f5060e;
    }

    public void b(boolean r1) {
        this.f = r1;
    }

    public long f() {
        return this.f5056a;
    }

    public long g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public void b(int r1) {
        this.h = r1;
    }

    public int i() {
        return this.i;
    }

    public void c(int r1) {
        this.i = r1;
    }

    public int j() {
        return this.j;
    }

    public void d(int r1) {
        this.j = r1;
    }

    public String toString() {
        return "SlardarHandlerConfig{onceReportMaxSizeBytes=" + this.f5056a + ", reportUrlList=" + this.f5057b + ", exceptionUrl=" + this.f5058c + ", traceReportUrl=" + this.f5059d + ", isEncrypt=" + this.f5060e + ", isUploadInternalExcetpion=" + this.f + ", reportInterval=" + this.g + ", maxSizeMB=" + this.h + ", keepDays=" + this.i + ", maxSizeMBToday=" + this.j + '}';
    }
}
