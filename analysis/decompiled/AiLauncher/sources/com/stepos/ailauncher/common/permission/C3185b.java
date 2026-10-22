package com.stepos.ailauncher.common.permission;

import Z8.C1173v;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import com.blankj.utilcode.util.PermissionUtils;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/common/permission/b;", "", "<init>", "()V", "", "permission", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "LY8/t;", "onResult", Const.INTENT_KEY_PKGNAME, "(Lp9/l;)V", "", "Lcom/stepos/ailauncher/common/permission/J;", "permissionRequestList", "Ljava/util/List;", "getPermissionRequestList", "()Ljava/util/List;", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.permission.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3185b {
    public static final C3185b INSTANCE = new C3185b();
    private static final List<PermissionRequest> permissionRequestList = C1173v.p(new PermissionRequest("android.permission.BIND_ACCESSIBILITY_SERVICE", R$drawable.ic_accessibility, "无障碍权限", "获取界面信息协助您进行操作", false, 16, null), new PermissionRequest("android.permission.SYSTEM_ALERT_WINDOW", R$drawable.ic_draw_overlay, "悬浮窗权限", "用于帮助任务顺利执行", false, 16, null), new PermissionRequest(PolicySdkPermissionManifestUtils.RECORD_AUDIO, R$drawable.ic_microphone, "麦克风权限", "请选择允许一直使用", false, 16, null));

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/common/permission/b$a", "Lcom/blankj/utilcode/util/PermissionUtils$b;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.permission.b$a */
    public static final class a implements PermissionUtils.b {
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
            this.$onResult = interfaceC5074l;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            this.$onResult.invoke(Boolean.TRUE);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void b() {
            this.$onResult.invoke(Boolean.FALSE);
        }
    }

    public final boolean a(String permission) {
        kotlin.jvm.internal.p.i(permission, "permission");
        return kotlin.jvm.internal.p.d(permission, "android.permission.SYSTEM_ALERT_WINDOW") ? Settings.canDrawOverlays(com.blankj.utilcode.util.p.a()) : PermissionUtils.s(permission);
    }

    public final void b(InterfaceC5074l<? super Boolean, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(onResult, "onResult");
        PermissionUtils.x(PolicySdkPermissionManifestUtils.RECORD_AUDIO).m(new a(onResult)).y();
    }
}
