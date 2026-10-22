package com.bytedance.services.apm.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: WidgetParams.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f11181a;

    public m() {
    }

    public List<String> a() {
        return this.f11181a;
    }

    public void a(List<String> r3) {
        this.f11181a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
