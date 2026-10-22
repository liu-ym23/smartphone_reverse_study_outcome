package com.bytedance.android.btm.impl.page.model;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.btm.impl.util.f<Object> f42365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PageInfo f42366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Flag f42367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42368d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("pageInfo", String.valueOf(this.f42366b));     // Catch: Throwable -> L6
        r100.put(ForwardDependency$ForwardLocation.FLAG, this.f42367c.toString());     // Catch: Throwable -> L6
        r100.put("sentEvent", this.f42368d);     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    public i() {
        this.f42367c = Flag.NOT_SURE;
    }
}
