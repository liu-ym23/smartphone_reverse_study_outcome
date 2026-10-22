package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor$ContainerType;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.setting.f5;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommonIconModel$loadHybridComponent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ f.b $callback;
    final /* synthetic */ vo1.i $component;
    final /* synthetic */ String $fallbackUrl;
    final /* synthetic */ String $url;
    final /* synthetic */ f this$0;

    public static final class a extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonIconModel$loadHybridComponent$1 f115509a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1$a$a, reason: collision with other inner class name */
        public static final class RunnableC1710a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f115510a;

            public RunnableC1710a(a r100) {
                this.f115510a = r100;
            }

            public final void a() {
                CommonIconModel$loadHybridComponent$1 r100 = this.f115510a.f115509a;
                f.b(r100.this$0, r100.$fallbackUrl, r100.$callback);
                int r101 = com.bytedance.android.livesdk.chatroom.utils.a.f114391a;
                com.bytedance.android.livesdk.chatroom.utils.a.a(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), Integer.valueOf(this.f115510a.f115509a.this$0.f106634d), String.valueOf(this.f115510a.f115509a.this$0.f115552o), this.f115510a.f115509a.$fallbackUrl);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void a() {
            new Handler().post(new RunnableC1710a(this));
            int r100 = com.bytedance.android.livesdk.chatroom.utils.a.f114391a;
            int r101 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
            ActivityHybridMonitor$ContainerType r102 = ActivityHybridMonitor$ContainerType.LYNX;
            f r103 = this.f115509a.this$0;
            com.bytedance.android.livesdk.chatroom.utils.a.c(r101, "onFallback", r102, r103.f106634d, String.valueOf(r103.f115552o), this.f115509a.$url);
        }

        public a(CommonIconModel$loadHybridComponent$1 r100) {
            this.f115509a = r100;
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void g(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            this.f115509a.$callback.onLoadSuccess();
            f r101 = this.f115509a.this$0;
            int r102 = f.f115541s;
            r101.l(true);
            com.bytedance.android.livesdk.chatroom.monitor.f r103 = this.f115509a.this$0.f115548k;
            if (r103 == null) goto L8;
            r103.d("ON_PAGE_FINISHED");
            if (r103.f107017i != 2) goto L9;
            r103.g();
            return;
        L9:
            return;
        }
    }

    public CommonIconModel$loadHybridComponent$1(f r100, String r101, f.b r102, String r103, vo1.i r104) {
        this.this$0 = r100;
        this.$fallbackUrl = r101;
        this.$callback = r102;
        this.$url = r103;
        this.$component = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.android.livesdk.chatroom.monitor.f r100 = this.this$0.f115548k;
        if (r100 == null) goto L5;
        r100.d("LOAD_URL_START");
    L5:
        a r101 = new a(this);
        if (f5.f65298a.getValue().booleanValue() == false) goto L8;
        vo1.i r102 = this.$component;
        String r103 = this.$url;
        f r104 = this.this$0;
        r102.h(r103, r104.n(r104.f115554q), r101);
    L9:
        com.bytedance.android.livesdk.chatroom.monitor.f r105 = this.this$0.f115548k;
        if (r105 == null) goto L13;
        r105.d("LOAD_URL_END");
        return;
    L13:
        return;
    L8:
        this.$component.b(this.$url, r101);
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
