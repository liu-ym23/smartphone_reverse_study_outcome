package com.bytedance.android.live.messagewindow.framework.process;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f83131d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public im0.a f83132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y61.b f83133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v61.a f83134c;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.a$a, reason: collision with other inner class name */
    public static final class C1266a {
        public static a a(y61.b r100, v61.a r101) {
            Intrinsics.checkNotNullParameter(r100, "msgWindowCtx");
            Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
            return new a(r100, r101);
        }
    }

    static {
    }

    public a(y61.b r100, v61.a r101) {
        this.f83133b = r100;
        this.f83134c = r101;
    }
}
