package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class z implements d, e, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f133720a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.data.k getContentExt() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        q1 r100 = this.f133720a.getLandscapeAreaCommon();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getColorList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long c() {
        return this.f133720a.getEventTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        String r100 = this.f133720a.getChatContent();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.f133720a.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.f133720a.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.f
    public final long getPriorityScore() {
        m0 r100 = this.f133720a.getBaseMessage();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getPriorityScore();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long getReceiveTime() {
        return this.f133720a.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        m0 r100 = this.f133720a.getBaseMessage();
        if (r100 == null) goto L5;
        long r101 = r100.getPriorityScore();
    L7:
        return (int) (r101 % ((long) 100));
    L5:
        r101 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.f133720a.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public boolean i() {
        return this.f133720a.isHotChat();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.f133720a.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSendReview() {
        return this.f133720a.isSendReview();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final String j() {
        return this.f133720a.getChatContent();
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
        return this.f133720a;
    }

    public z(k0 r100) {
        Intrinsics.checkNotNullParameter(r100, "chatMessage");
        this.f133720a = r100;
    }
}
