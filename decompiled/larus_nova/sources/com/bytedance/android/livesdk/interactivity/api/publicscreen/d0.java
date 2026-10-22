package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdkapi.message.OfficialCommentConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d0 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q5 f133400a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.data.k getContentExt() {
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
    public final boolean a() {
        return this.f133400a.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return this.f133400a.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        OfficialCommentConfig r100 = this.f133400a.getOfficialCommentConfig();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBackgroundColor();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        VSShowChatMessageCommentRoleConfig r100 = this.f133400a.G0();
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.getCharactorName();
        if (r102 == null) goto L6;
    L7:
        String r103 = this.f133400a.getChatContent();
        if (r103 == null) goto L12;
        r101 = r103;
    L12:
        return r102.concat(r101);
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.f133400a.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final j0 getMedal() {
        return this.f133400a.getMedal();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.f133400a.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.f133400a.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.f133400a.isSelfSendFake();
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
        return this.f133400a;
    }

    public d0(q5 r100) {
        Intrinsics.checkNotNullParameter(r100, "showChatMessage");
        this.f133400a = r100;
    }
}
