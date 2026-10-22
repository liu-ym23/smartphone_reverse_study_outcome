package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.MatchCollectionMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MatchCollectionMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "collectionItem", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "getCollectionItem", "()Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "setCollectionItem", "(Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchCollectionMessage extends o0 implements h {

    @SerializedName("collection_item")
    protected CollectionItem collectionItem;

    public MatchCollectionMessage() {
        this.type = MessageType.MATCH_COLLECTION_MESSAGE;
    }

    public final CollectionItem getCollectionItem() {
        return this.collectionItem;
    }

    public MatchCollectionMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.collectionItem = new CollectionItem(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.MATCH_COLLECTION_MESSAGE;
    }

    public final void setCollectionItem(CollectionItem r100) {
        this.collectionItem = r100;
    }
}
