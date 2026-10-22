package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f108053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f108054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f108055c;

    public f(d r100, Function2 r101, String r102) {
        this.f108053a = r100;
        this.f108054b = r101;
        this.f108055c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        ALogger.i("FileMetadataUtils", "metadata success = ".concat(r101));
        d.a(this.f108053a, "success");
        this.f108054b.invoke(r101, Boolean.TRUE);
        return;
    L9:
        d.a(this.f108053a, "none");
        ALogger.i("FileMetadataUtils", "no metadata");
        this.f108054b.invoke(this.f108055c, Boolean.FALSE);
        return;
    L5:
        r102 = false;
        goto L7
    }
}
