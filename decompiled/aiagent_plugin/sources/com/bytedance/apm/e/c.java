package com.bytedance.apm.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: UploadRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f4593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f4594e;

    public c() {
    }

    public String a() {
        return this.f4590a;
    }

    public void a(String r1) {
        this.f4590a = r1;
    }

    public String b() {
        return this.f4591b;
    }

    public void b(String r1) {
        this.f4591b = r1;
    }

    public String c() {
        return this.f4592c;
    }

    public void c(String r1) {
        this.f4592c = r1;
    }

    public List<String> d() {
        return this.f4593d;
    }

    public void a(List<String> r3) {
        this.f4593d = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public JSONObject e() {
        return this.f4594e;
    }

    public void a(JSONObject r1) {
        this.f4594e = r1;
    }
}
