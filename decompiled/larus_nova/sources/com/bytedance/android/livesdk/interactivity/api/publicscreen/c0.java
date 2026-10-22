package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 implements d, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h4 f133398a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return this.f133398a.isOfficialDanmaku();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long c() {
        return this.f133398a.getEventTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        com.bytedance.android.live.base.model.message.v r100 = this.f133398a.getEffect();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBackgroundColor();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        String r100 = this.f133398a.getChatContent();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.data.k getContentExt() {
        return this.f133398a.getContentExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.f133398a.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long getReceiveTime() {
        return this.f133398a.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.f133398a.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSendReview() {
        return this.f133398a.getSendReview();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final String j() {
        return this.f133398a.getChatContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String e() {
        return d.b.a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean f() {
        return d.b.c(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean g() {
        return d.b.d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int k() {
        return d.b.b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.message.t getMessage() {
        return this.f133398a;
    }

    public c0(h4 r100) {
        Intrinsics.checkNotNullParameter(r100, "screenMessage");
        this.f133398a = r100;
    }
}
