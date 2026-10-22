package com.bytedance.android.live.lynx.api;

import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes46.dex */
public interface c extends ka0.c {
    LynxView getLynxView();

    @Deprecated(message = "use render instead")
    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateData(Map<String, ? extends Object> r100, boolean r101, String r102);
}
