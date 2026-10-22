package com.monitor.cloudmessage.agent;

import java.io.File;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class CustomResult {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f3001a;
    public File b;

    public CustomResult(HashMap<String, String> map, File file) {
        this.f3001a = map;
        this.b = file;
    }

    public HashMap<String, String> getCustomInfo() {
        return this.f3001a;
    }

    public File getFile() {
        return this.b;
    }
}
