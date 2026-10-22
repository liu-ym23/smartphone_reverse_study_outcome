package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class v implements ObservableOnSubscribe<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f149446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f149447b;

    public static final class a implements ak2.f<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f149448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f149449b;

        @Override // ud.a, com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
        public final Object getConfig() {
            Context r100 = this.f149448a.f149447b;
            if (r100 == null) goto L5;
            File r101 = r100.getExternalCacheDir();
        L6:
            if (r101 == null) goto L13;
            PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "/live/ecscreenshot");
            if (r102.exists() == true) goto L16;
            if (r102.mkdirs() == true) goto L16;
            return r101.getAbsolutePath();
        L16:
            return r102.getAbsolutePath();
        L13:
            return "";
        L5:
            r101 = null;
            goto L6
        }

        @Override // ud.a, com.bytedance.android.livesdkapi.room.handler.observe.ConfigObserver
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            this.f149449b.tryOnError(new Exception("screenshotFolderPath is empty"));
            return;
        L11:
            Observable.create(new u(this, r101)).subscribeOn(Schedulers.io()).subscribe();
            return;
        L5:
            if (r101.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        public a(v r100, ObservableEmitter r101) {
            this.f149448a = r100;
            this.f149449b = r101;
        }
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<File> r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        com.bytedance.android.livesdk.livecommerce.room.api.c r101 = this.f149446a.f149425g;
        if (r101 == null) goto L5;
        r101.i(new a(this, r100));
        return;
    L5:
        r100.tryOnError(new IllegalArgumentException("liveRoomProvider is null !!!"));
    }

    public v(b0 r100, Context r101) {
        this.f149446a = r100;
        this.f149447b = r101;
    }
}
