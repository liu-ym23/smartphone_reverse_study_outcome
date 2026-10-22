package com.bytedance.applet.task;

import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes14.dex */
public final class r {
    public static final String a(int r100) {
        int r101 = ContextCompat.getColor(AppHost.f326268a.getApplication(), r100);
        int r102 = ((r101 & 16777215) << 8) | ((r101 >>> 24) & 255);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r102)}, 1));
    }
}
