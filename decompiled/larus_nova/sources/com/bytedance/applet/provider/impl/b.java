package com.bytedance.applet.provider.impl;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.utils.f;
import jw3.d;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f192181a = null;

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f192182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f192183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f192184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f192185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f192186e;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            r100.f("questionId", this.f192182a);
            r100.f("botId", this.f192183b);
            r100.f("conversationId", this.f192184c);
            r100.g("isHistory", this.f192185d);
            r100.g("success", this.f192186e);
        }

        public a(String r100, String r101, String r102, boolean r103, boolean r104) {
            this.f192182a = r100;
            this.f192183b = r101;
            this.f192184c = r102;
            this.f192185d = r103;
            this.f192186e = r104;
        }
    }

    static {
        f192181a = new b();
    }

    public b() {
    }

    @Override // jw3.d
    public final void trace(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f.j(r100);
    }

    @Override // jw3.d
    public final void a(String r100, String r101, String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "questionId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        com.bytedance.ai.monitor.b.d("applet_save_bot_reply", new a(r100, r101, r110, r111, r112));
    }
}
