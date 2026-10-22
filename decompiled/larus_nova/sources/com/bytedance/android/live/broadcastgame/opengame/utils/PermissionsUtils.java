package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class PermissionsUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f61144a = null;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f61145a;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.utils.PermissionsUtils$a$a, reason: collision with other inner class name */
        public static final class RunnableC1013a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f61146a;

            public RunnableC1013a(String[] r100) {
                this.f61146a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Arrays.fill(new int[this.f61146a.length], 0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a() {
            this.f61145a = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.PermissionsUtils.c
        public void requestPermissions(Activity r100, String[] r101, b r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            this.f61145a.post(new RunnableC1013a(r101));
        }
    }

    public interface b {
    }

    public interface c {
        void requestPermissions(Activity r100, String[] r101, b r102);
    }

    public static final class d implements c {
        public d() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.PermissionsUtils.c
        public void requestPermissions(Activity r100, String[] r101, b r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            Fragment r103 = r100.getFragmentManager().findFragmentByTag(ComplianceResult.JsonKey.PERMISSIONS);
            if (r103 == null) goto L7;
            PermissionFragment r104 = (PermissionFragment) r103;
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.utils.PermissionFragment");
        }
    }

    static {
        f61144a = LazyKt.lazy(PermissionsUtils$IMPL$2.INSTANCE);
    }

    public final void requestPermissions(Activity r100, String[] r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        ((c) f61144a.getValue()).requestPermissions(r100, r101, r102);
    }
}
