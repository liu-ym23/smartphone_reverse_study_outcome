package com.bytedance.android.livesdk.interactivity.api.expression;

import android.view.View;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseEmoji f133209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f133210b;

    public e(BaseEmoji r100, Function0 r101) {
        this.f133209a = r100;
        this.f133210b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r101 = EmojiLocalRecentManager.f140846a;
        EmojiLocalRecentManager.d(this.f133209a);
        Function0 r102 = this.f133210b;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }
}
