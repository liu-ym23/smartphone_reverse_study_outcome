package x0;

import android.content.Context;
import com.bytedance.apm.alog.IAlogUploadStrategy;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile IAlogUploadStrategy f25410a;

    public static void a(Context r10, IAlogUploadStrategy r11) {
        if (f25410a != null) goto L6;
        f25410a = r11;
        return;
    }
}
