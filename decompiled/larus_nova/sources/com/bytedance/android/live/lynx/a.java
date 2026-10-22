package com.bytedance.android.live.lynx;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface a {
    void a(LynxViewBuilder r100, String r101);

    void b(boolean r100);

    List<com.lynx.tasm.behavior.a> c();

    void d(TemplateData r100);

    LynxGroup e(String r100, String[] r101, boolean r102, boolean r103, boolean r104, int r105);

    boolean isEnableDebug();

    void setEnableJSRuntime(LynxViewBuilder r100, boolean r101);
}
