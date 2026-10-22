package com.bytedance.bdinstall.h;

import android.accounts.Account;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StorageSettings.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f6288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Account f6291e;
    private String f;
    private boolean g;
    private an h;

    public k() {
        this.g = false;
    }

    String a() {
        return this.f6287a;
    }

    public void a(String r1) {
        this.f6287a = r1;
    }

    public SharedPreferences b() {
        return this.f6288b;
    }

    public void a(SharedPreferences r3) {
        this.f6288b = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.aiagent.plugin");
    }

    boolean c() {
        return this.f6289c;
    }

    public void a(boolean r1) {
        this.f6289c = r1;
    }

    public boolean d() {
        return this.f6290d;
    }

    void b(boolean r1) {
        this.f6290d = r1;
    }

    public Account e() {
        return this.f6291e;
    }

    public void a(Account r1, String r2) {
        this.f6291e = r1;
        this.f = r2;
    }

    String f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public void c(boolean r1) {
        this.g = r1;
    }

    public void a(an r1) {
        this.h = r1;
    }

    public an h() {
        return this.h;
    }
}
