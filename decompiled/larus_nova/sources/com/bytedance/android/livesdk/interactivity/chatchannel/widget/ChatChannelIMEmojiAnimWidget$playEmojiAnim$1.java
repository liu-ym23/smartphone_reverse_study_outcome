package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "path", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ChatChannelIMEmojiAnimWidget$playEmojiAnim$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $name;
    final /* synthetic */ ChatChannelIMEmojiAnimWidget this$0;

    public ChatChannelIMEmojiAnimWidget$playEmojiAnim$1(ChatChannelIMEmojiAnimWidget r100, String r101) {
        this.this$0 = r100;
        this.$name = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        ChatChannelIMEmojiAnimWidget r101 = this.this$0;
        String r102 = "play emoji anim name=" + this.$name + " path=" + r100;
        int r103 = ChatChannelIMEmojiAnimWidget.f134522h;
        r101.xq(r102);
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.api.c r104 = this.this$0.f134524b;
        if (r104 == null) goto L9;
        r104.a(new com.bytedance.android.livesdk.interactivity.api.c.a(r100, 2));
        return;
    L9:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
