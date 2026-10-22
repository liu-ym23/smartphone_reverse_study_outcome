package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$2 f85248a;

    public p(LiveMgMountContextService$showStarAtlasAgreementDialog$2 r100) {
        this.f85248a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f85248a.invoke2("https://www.xingtu.cn/protocol?id=20210530&enable_title=1");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(ColorProtector.parseColor("#04498D"));
        r100.setUnderlineText(false);
    }
}
