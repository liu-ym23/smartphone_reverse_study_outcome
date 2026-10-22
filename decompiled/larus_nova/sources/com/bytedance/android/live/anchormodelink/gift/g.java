package com.bytedance.android.live.anchormodelink.gift;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f58649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58650b;

    public g(Function2 r100, String r101) {
        this.f58649a = r100;
        this.f58650b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        JsonObject r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L17;
        this.f58649a.invoke(Boolean.FALSE, null);
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#file empty:" + this.f58650b);
        return;
    L17:
        r102 = (JsonObject) GsonHelper.get().fromJson(r101, JsonObject.class);     // Catch: Throwable -> L7
    L9:
        if (r102 == null) goto L15;
        LruCache<String, JsonObject> r103 = j.f58655a;
        String r104 = this.f58650b;
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (TextUtils.isEmpty(r104) == true) goto L14;
        j.f58655a.put(r104, r102);
    L14:
        this.f58649a.invoke(Boolean.TRUE, r102);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse success:" + this.f58650b + ",data:" + r102);
        return;
    L15:
        this.f58649a.invoke(Boolean.FALSE, r102);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse failed:" + this.f58650b);
        return;
    L7:
        th = move-exception;
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse error:" + th);
        goto L9
    }
}
