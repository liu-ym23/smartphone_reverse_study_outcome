package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.message.model.q6;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface q2 extends com.bytedance.android.scope.o {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f131691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f131692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f131693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f131694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f131695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f131696f;

        public a(String r100, String r101, int r102, boolean r103, int r104, String r105, int r106) {
            if ((r106 & 4) == 0) goto L6;
            r102 = 0;
        L6:
            if ((r106 & 8) == 0) goto L9;
            r103 = false;
        L9:
            if ((r106 & 16) == 0) goto L12;
            r104 = 0;
        L12:
            if ((r106 & 32) == 0) goto L14;
            r105 = "";
        L14:
            Intrinsics.checkNotNullParameter(r105, "eventSessionId");
            this.f131691a = r100;
            this.f131692b = r101;
            this.f131693c = r102;
            this.f131694d = r103;
            this.f131695e = r104;
            this.f131696f = r105;
        }
    }

    PublishSubject<a> K5();

    PublishSubject<String> X4();

    q6 Y9();

    PublishSubject<a> bh();

    com.bytedance.android.livesdk.gift.model.x1 getGiftPanelTopBar();

    String getScene();

    PublishSubject rj();

    PublishSubject<Unit> w5();
}
