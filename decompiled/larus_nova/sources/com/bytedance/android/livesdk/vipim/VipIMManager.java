package com.bytedance.android.livesdk.vipim;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import pp1.h;

/* JADX INFO: loaded from: classes11.dex */
public final class VipIMManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f159346f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f159347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f159348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f159349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f159350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f159351e;

    public static final class a {
        public static VipIMManager a() {
            return (VipIMManager) VipIMManager.f159346f.getValue();
        }
    }

    static {
        f159346f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VipIMManager$Companion$INSTANCE$2.INSTANCE);
    }

    public VipIMManager() {
        this.f159348b = "";
        this.f159351e = true;
    }

    public final void a(boolean r100) {
        y3.a().b(ToolbarButton.MORE, new h(r100));
        this.f159347a = r100;
    }
}
