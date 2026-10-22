package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f108056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f108057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f108058c;

    public g(d r100, String r101, Function2 r102) {
        this.f108056a = r100;
        this.f108057b = r101;
        this.f108058c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d.a(this.f108056a, "error");
        ALogger.e("FileMetadataUtils", "metadata error = " + this.f108057b + ' ' + ((Throwable) r100));
        this.f108058c.invoke(this.f108057b, Boolean.FALSE);
    }
}
