package com.bytedance.android.livesdk.broadcast;

import com.bytedance.android.livesdk.utils.v3;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f104369a;

    public b(Function1 r100) {
        this.f104369a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        int r102 = v3.f159190a;
        JSONObject r103 = null;
        if (r101 != null) goto L10;
    L7:
        this.f104369a.invoke(r103);
        return;
    L10:
        r103 = new JSONObject(r101);     // Catch: Throwable -> L9
        goto L7
    }
}
