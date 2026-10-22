package com.obric.agent.intents.music.netease.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import java.util.List;

/* JADX INFO: compiled from: CMApiPlayList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    private String f14749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("num")
    private Integer f14750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("items")
    private List<b> f14751c;

    public a() {
        this(null, null, null, 7, null);
    }

    public a(String r3, Integer r4, List<b> r5) {
        List<b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f14749a = r3;
        this.f14750b = r4;
        this.f14751c = r6;
    }

    public final Integer a() {
        return this.f14750b;
    }

    public /* synthetic */ a(String r2, Integer r3, List r4, int r5, h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r7 = p.b();
    L11:
        this(r2, r3, r7);
    }

    public final void a(List<b> r3) {
        this.f14751c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<b> b() {
        return this.f14751c;
    }

    public String toString() {
        return "CMApiPlayList(name=" + this.f14749a + ", num=" + this.f14750b + ", items=" + this.f14751c + ')';
    }
}
