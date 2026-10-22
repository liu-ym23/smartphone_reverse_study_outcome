package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import com.larus.nova.R;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f115472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f115473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f115474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f115475d;

    public a() {
        this.f115472a = Constants.SOURCE_QQ;
        this.f115473b = R.drawable.ttlive_share_link_panel_qq;
        this.f115474c = "com.tencent.mobileqq";
        this.f115475d = "qq";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String b() {
        return this.f115475d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final int c() {
        return this.f115473b;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String d() {
        return this.f115474c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.l
    public final String e() {
        return this.f115472a;
    }
}
