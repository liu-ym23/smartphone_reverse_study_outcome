package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.link;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.android.livesdk.gecko.offline.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import th6.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJP\u0010\u000f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/link/GeckoProvider;", "Lth6/c;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "fileName", "Lkotlin/reflect/KClass;", "clazz", "getRes", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "onSuccess", "", "onFail", "getResAsync", "resId", "", "hasRes", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GeckoProvider implements c {
    public GeckoProvider() {
    }

    public <T> T getRes(String r100, KClass<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return null;
    }

    public boolean hasRes(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resId");
        if (f.b(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // th6.c
    public <T> void getResAsync(String r100, final KClass<T> r101, final Function1<? super T, Unit> r102, final Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        boolean r104 = OfflineResourceClient.f125824a;
        OfflineResourceClient.c(r100, new AnonymousClass1(r101, r102, r103));
    }
}
