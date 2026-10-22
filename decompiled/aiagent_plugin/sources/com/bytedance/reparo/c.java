package com.bytedance.reparo;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: Configuration.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f9103a;

    public c(Application r3) {
        this.f9103a = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
    }

    public File a() {
        return new File(this.f9103a.getFilesDir(), "reparo-root");
    }

    public File a(String r2) {
        return new File(a(), r2);
    }

    public File a(String r3, String r4) {
        return new File(a(r3), "download" + File.separator + r4);
    }
}
