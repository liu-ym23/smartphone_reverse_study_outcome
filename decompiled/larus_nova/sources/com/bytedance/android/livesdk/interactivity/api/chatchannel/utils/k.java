package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.logsdk.format.Spm;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133003a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(s22.a r100) {
        return "{channelId: " + r100.getChannelId() + ", channelName:" + ((String) r100.getChannelName().f64752a) + ", isOwner: " + ((Boolean) r100.v().f64752a).booleanValue() + ", count: " + ((Number) r100.d0().f64752a).longValue() + ", linkState: " + ((Boolean) r100.d().f64752a).booleanValue() + ", inviteState: " + ((Boolean) r100.z().f64752a).booleanValue() + com.alipay.sdk.m.u.i.f25855d;
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a314.a999").addArg("info", r100), "ChatChannelTracer");
    }

    @JvmStatic
    public static final void e(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        b("create success, channelInfo is " + a(r100));
    }

    @JvmStatic
    public static final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "inviteId");
        b("parse inviteId error,inviteId:" + r100);
    }

    @JvmStatic
    public static final void j(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        b("join success, channelInfo is " + a(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void k(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatChannel");
        b("update owner, channelId is " + r100.getChannelId() + ", isOwner is " + ((Boolean) r100.v().f64752a).booleanValue() + ", ownerId is " + ((User) r100.getOwner().f64752a).getIdStr());
    }

    @JvmStatic
    public static final void f(s22.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "source");
        b("dissolve success, channelId is " + r100.getChannelId() + ", source is " + r101);
    }

    @JvmStatic
    public static final void i(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        b("add item failed, channelId is " + r100 + ", reason is " + r101);
    }

    @JvmStatic
    public static final void l(s22.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "source");
        b("quit success, channelId is " + r100.getChannelId() + ", source is " + r101);
    }

    @JvmStatic
    public static final void g(long r100, boolean r101, String r102) {
        b("enable state is " + r101 + ", reason is " + r102 + ", room is " + r100);
    }

    @JvmStatic
    public static final void d(long r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r103, "emojiName");
        b("send chat success, channelId is " + r100 + ", content is " + r101 + ", emojiId is " + r102 + ", emojiName is " + r103);
    }

    @JvmStatic
    public static final void c(long r100, String r101, long r102, String r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r103, "emojiName");
        b("send chat failed, channelId is " + r100 + ", content is " + r101 + ", emojiId is " + r102 + ", emojiName is " + r103 + ", reason=" + l.a(r104));
    }
}
