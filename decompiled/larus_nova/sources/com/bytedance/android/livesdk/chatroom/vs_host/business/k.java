package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.SendReplayTextEvent;
import com.bytedance.android.livesdk.event.ISendCommentEvent;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f118266a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f118267b = null;

    static {
        int[] r100 = new int[SendReplayTextEvent.Sender.values().length];
        f118266a = r100;
        r100[SendReplayTextEvent.Sender.CommentWidget.ordinal()] = 1;
        r100[SendReplayTextEvent.Sender.Lottery.ordinal()] = 2;
        r100[SendReplayTextEvent.Sender.VsPlusOne.ordinal()] = 3;
        r100[SendReplayTextEvent.Sender.Unknown.ordinal()] = 4;
        int[] r101 = new int[ISendCommentEvent.Sender.values().length];
        f118267b = r101;
        r101[ISendCommentEvent.Sender.CommentWidget.ordinal()] = 1;
        r101[ISendCommentEvent.Sender.Lottery.ordinal()] = 2;
        r101[ISendCommentEvent.Sender.VsPlusOne.ordinal()] = 3;
        r101[ISendCommentEvent.Sender.Unknown.ordinal()] = 4;
    }
}
