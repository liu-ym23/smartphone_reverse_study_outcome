package com.bytedance.android.bst.api;

import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f41913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f41914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f41915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f41916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f41918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f41919g;

    public final d a() {
        if (this.f41913a.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L8:
        d r101 = new d(this.f41919g);
        r101.f41906a = this.f41913a;
        String r102 = this.f41914b;
        if (r102 == null) goto L17;
        r101.f41907b = r102;
        r101.f41908c = this.f41915c;
        r101.f41909d = this.f41916d;
        r101.f41910e = this.f41917e;
        g r103 = this.f41918f;
        if (r103 == null) goto L15;
        r101.f41911f = r103;
        return r101;
    L15:
        throw new AndroidRuntimeException("reporter is null");
    L17:
        throw new AndroidRuntimeException("event is empty");
    L5:
        r100 = false;
        goto L6
    }

    public e(View r100) {
        this.f41919g = r100;
        this.f41913a = "";
        this.f41917e = -1;
    }
}
