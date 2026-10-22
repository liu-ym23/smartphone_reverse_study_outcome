package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 implements d, p0, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Spannable f133372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f133373b;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return null;
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
    public final o1 getLandscapeAreaCommon() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.x3
    public final a5 getRichText() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.x3
    public final j4 getSelfFakeRichContent() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.x3
    public final void setSelfFakeRichContent(j4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.f
    public final long c() {
        return this.f133373b.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        Spannable r100 = this.f133372a;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final String getDefaultContent() {
        String r100 = this.f133373b.getDefaultContent();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.f133373b.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.f
    public final long getPriorityScore() {
        m0 r100 = this.f133373b.getBaseMessage();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getPriorityScore();
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final a5 getRichTextContent() {
        return this.f133373b.getEmojiContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.f133373b.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.f133373b.isInsert();
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
        return this.f133373b;
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final Spannable getRenderSpan() {
        return this.f133372a;
    }

    public a0(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "emojiChatMessage");
        this.f133373b = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final void setRenderSpan(Spannable r100) {
        this.f133372a = r100;
    }
}
