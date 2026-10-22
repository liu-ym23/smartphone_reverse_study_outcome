package com.bytedance.crash.l;

import com.bytedance.crash.CrashType;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: ICrashBodyExtensionDumper.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    JSONObject a(CrashType r1);

    void a(File r1);

    void a(JSONObject r1, JSONObject r2, File r3);
}
