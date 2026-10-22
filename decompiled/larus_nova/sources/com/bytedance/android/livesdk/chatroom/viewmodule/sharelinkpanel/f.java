package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f115492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f115493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f115494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f115495d;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    public f() {
        this.f115492a = "复制链接";
        this.f115493b = R.drawable.ttlive_share_link_panel_default_link;
        this.f115494c = "";
        this.f115495d = "copy";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String b() {
        return this.f115495d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final int c() {
        return this.f115493b;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String d() {
        return this.f115494c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String e() {
        return this.f115492a;
    }
}
