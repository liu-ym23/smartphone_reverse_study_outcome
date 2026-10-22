package com.bytedance.android.annie.service.resource;

import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40028a = null;

    static {
        f40028a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final List<String> r() {
        return ((f) Annie.getService$default(f.class, null, 2, null)).r();
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final String Z(String r100) {
        return ((f) Annie.getService$default(f.class, null, 2, null)).Z(r100);
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final WebResourceResponse j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == true) goto L5;
        return null;
    L5:
        return ((f) Annie.getService$default(f.class, null, 2, null)).j(r100);
    }
}
