package com.obric.memorydata.sdk.awareness;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.provider.FontsContractCompat;
import com.obric.memorydata.sdk.MemoryResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PersistentAwarenessContract.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f33829a = null;

    static {
        f33829a = new f();
    }

    private f() {
    }

    public final Bundle a(int r2, String r3) {
        Bundle r1 = new Bundle();
        r1.putInt(FontsContractCompat.Columns.RESULT_CODE, r2);
        r1.putString("result_message", r3);
        return r1;
    }

    public final Bundle a() {
        return a(0, "success");
    }

    public final MemoryResponse<Void> a(Bundle r13) {
        if (r13 != null) goto L6;
        return new MemoryResponse(400, "provider returns null", null, 4, null);
    L6:
        return new MemoryResponse(r13.getInt(FontsContractCompat.Columns.RESULT_CODE, 400), r13.getString("result_message"), null, 4, null);
    }

    public final <T extends Parcelable> T a(Bundle r3, String r4, Class<T> r5) {
        o.e(r3, "<this>");
        o.e(r4, "key");
        o.e(r5, "clazz");
        r3.setClassLoader(r5.getClassLoader());
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Parcelable r6 = (Parcelable) ZeusTransformUtils.preCheckCast(r3.getParcelable(r4, r5), Parcelable.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L10
    L9:
        return (T) r6;
    L6:
        r6 = r3.getParcelable(r4);     // Catch: RuntimeException -> L10
        if (ZeusTransformUtils.instanceOf(r6, Parcelable.class) == true) goto L9;
        return null;
    L13:
        return null;
    }
}
