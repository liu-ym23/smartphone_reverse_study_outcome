package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.p0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b0 extends z implements p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f133395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f133396c;

    @Override // com.bytedance.android.live.base.model.message.x3
    public final a5 getRichText() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final String getDefaultContent() {
        String r100 = this.f133396c.getChatContent();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final a5 getRichTextContent() {
        return this.f133396c.getRichDisplayText();
    }

    @Override // com.bytedance.android.live.base.model.message.x3
    public final j4 getSelfFakeRichContent() {
        return this.f133396c.getSelfFakeRichContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.z, com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return this.f133396c.isHotChat();
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final Spannable getRenderSpan() {
        return this.f133395b;
    }

    public b0(k0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.f133396c = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.p0
    public final void setRenderSpan(Spannable r100) {
        this.f133395b = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.x3
    public final void setSelfFakeRichContent(j4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f133396c.setSelfFakeRichContent(r100);
    }
}
