package com.bytedance.android.livesdk.chatroom.detail;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f105652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f105653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f105654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f105655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f105656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f105657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f105658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f105659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f105660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f105661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f105662k;

    public final String toString() {
        return "roomId: " + this.f105660i + ", enterFromMerge: " + this.f105661j + ", enterMethod: " + this.f105662k + ", duration: " + this.f105653b + ", canReport: " + this.f105655d + ", storeParams: " + this.f105659h;
    }

    public e0(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        this.f105660i = r100;
        this.f105661j = r101;
        this.f105662k = r102;
        this.f105652a = "";
        this.f105654c = "";
        this.f105657f = "0";
        this.f105658g = "android_killapp";
        this.f105659h = new LinkedHashMap();
    }
}
