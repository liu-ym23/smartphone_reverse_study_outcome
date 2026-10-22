package com.bytedance.android.format.model;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.WebcastHistoryResponse.ResponseData")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/format/model/IMProtoMessageFetchResult;", "", "", "Lcom/bytedance/android/livesdk/chatroom/model/n;", "messages", "Ljava/util/List;", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "", EffectConfiguration.KEY_CURSOR, "Ljava/lang/String;", "getCursor", "()Ljava/lang/String;", "setCursor", "(Ljava/lang/String;)V", "", TriggerTiming.NOW, "J", "getNow", "()J", "setNow", "(J)V", "liveCursor", "getLiveCursor", "setLiveCursor", "", "historyNoMore", "Z", "getHistoryNoMore", "()Z", "setHistoryNoMore", "(Z)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMProtoMessageFetchResult implements vh7.h {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    protected String cursor;

    @SerializedName("history_no_more")
    protected boolean historyNoMore;

    @SerializedName("live_cursor")
    protected String liveCursor;

    @SerializedName("messages")
    protected List<com.bytedance.android.livesdk.chatroom.model.n> messages;

    @SerializedName(TriggerTiming.NOW)
    protected long now;

    public IMProtoMessageFetchResult() {
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final boolean getHistoryNoMore() {
        return this.historyNoMore;
    }

    public final String getLiveCursor() {
        return this.liveCursor;
    }

    public final List<com.bytedance.android.livesdk.chatroom.model.n> getMessages() {
        return this.messages;
    }

    public final long getNow() {
        return this.now;
    }

    public IMProtoMessageFetchResult(am3.g r100) {
        this.messages = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.messages.add(new com.bytedance.android.livesdk.chatroom.model.n(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.cursor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.now = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.liveCursor = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.historyNoMore = am3.h.a(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setCursor(String r100) {
        this.cursor = r100;
    }

    public final void setHistoryNoMore(boolean r100) {
        this.historyNoMore = r100;
    }

    public final void setLiveCursor(String r100) {
        this.liveCursor = r100;
    }

    public final void setMessages(List<com.bytedance.android.livesdk.chatroom.model.n> r100) {
        this.messages = r100;
    }

    public final void setNow(long r100) {
        this.now = r100;
    }
}
