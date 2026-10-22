package com.bytedance.android.live.core.permission;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener;
import com.bytedance.android.livesdk.a0;
import com.ss.android.ugc.route_monitor.impl.route_out.control.i;
import java.util.Arrays;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import m60.c;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends DefaultPermissionRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionFragment.b f65123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f65124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f65125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o60.a f65126d;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.permission.a$a, reason: collision with other inner class name */
    public class C1070a implements o60.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f65127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f65128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f65129c;

        @Override // o60.b
        public final void cancel() {
            if (this.f65127a == true) goto L6;
            this.f65127a = true;
            Continuation r100 = this.f65128b;
            Boolean r101 = Boolean.FALSE;
            Intrinsics.checkNotNullParameter(r100, "$this$resumeInJava");
            r100.resumeWith(Result.m9449constructorimpl(r101));
            return;
        }

        @Override // o60.b
        public final void execute() {
            if (this.f65127a == true) goto L33;
            ALogger.i("PermissionFragment", "requestPermissions use ezpermission; beforeGoToAppSetting called");
            this.f65129c.f65123a.b();
            this.f65127a = true;
            String[] r100 = this.f65129c.f65125c;
            int r101 = PermissionFragment.f65109c;
            if (a0.f102991a.getValue().booleanValue() == false) goto L27;
            int r102 = 0;
            if (r100.length != 1) goto L10;
            String r103 = PermissionFragment.a(r100[0]);
        L24:
            if (r103 == null) goto L26;
            i.a(r103);
            goto L27
        L26:
            ALogger.e("PermissionFragment", "当前申请的权限信息无法找到对应的鉴权 id，出错");
            goto L27
        L10:
            if (r100.length != 2) goto L23;
            int r104 = r100.length;
            boolean r105 = false;
            boolean r106 = false;
        L12:
            if (r102 >= r104) goto L20;
            String r107 = r100[r102];
            if ("android.permission.CAMERA".equals(r107) == false) goto L17;
            r105 = true;
        L19:
            r102 = r102 + 1;
            goto L12
        L17:
            if ("android.permission.RECORD_AUDIO".equals(r107) == false) goto L19;
            r106 = true;
            goto L19
        L20:
            if (r105 == false) goto L23;
            if (r106 == false) goto L23;
            r103 = PermissionFragment.a("audio_camera");
        L23:
            r103 = null;
        L27:
            Continuation r108 = this.f65128b;
            Boolean r109 = Boolean.TRUE;
            Intrinsics.checkNotNullParameter(r108, "$this$resumeInJava");
            r108.resumeWith(Result.m9449constructorimpl(r109));
            return;
        }

        public C1070a(a r100, Continuation r101) {
            this.f65129c = r100;
            this.f65128b = r101;
        }
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener, com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public final void beforeRequest() {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; beforeRequest called");
        this.f65123a.a();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener, com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public final void noNeedToRequest() {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; noNeedToRequest called");
        this.f65123a.d(false);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener, com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public final void onPermissionDenied(String[] r100) {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; onPermissionDenied called,grantedList=" + Arrays.toString(r100));
        this.f65123a.c();
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener, com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public final void onPermissionGrant(String[] r100) {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; onPermissionGrant called,grantedList=" + Arrays.toString(r100));
        this.f65123a.d(true);
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener, com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.PermissionRequestListener
    public final void goToAppSetting(Continuation<Boolean> r100, String[] r101) {
        boolean r102 = !c.e(this.f65124b, this.f65125c);
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; goToAppSetting called, go=" + r102);
        if (r102 == false) goto L5;
        this.f65123a.f65116c = c.a(this.f65124b, this.f65125c);
        this.f65126d.a(this.f65124b, new C1070a(this, r100), this.f65123a.f65115b);
        return;
    L5:
        Boolean r103 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r100, "$this$resumeInJava");
        r100.resumeWith(Result.m9449constructorimpl(r103));
    }

    public a(PermissionFragment.b r100, Activity r101, String[] r102, o60.a r103) {
        this.f65123a = r100;
        this.f65124b = r101;
        this.f65125c = r102;
        this.f65126d = r103;
    }
}
