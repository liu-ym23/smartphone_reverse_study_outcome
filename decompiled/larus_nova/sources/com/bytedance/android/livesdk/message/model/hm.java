package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonBubbleConfig;
import com.bytedance.android.livesdkapi.message._CommonBubbleConfig_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.TopLeftBubbleMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/message/CommonBubbleConfig;", "bubbleConfig", "Lcom/bytedance/android/livesdkapi/message/CommonBubbleConfig;", "G", "()Lcom/bytedance/android/livesdkapi/message/CommonBubbleConfig;", "setBubbleConfig", "(Lcom/bytedance/android/livesdkapi/message/CommonBubbleConfig;)V", "", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hm extends o0 implements vh7.h {

    @SerializedName("bubble_config")
    protected CommonBubbleConfig bubbleConfig;

    @SerializedName("extra")
    protected Map<String, String> extra;

    public final boolean E() {
        CommonBubbleConfig r100 = this.bubbleConfig;
        if (r100 == null) goto L13;
        Intrinsics.checkNotNull(r100);
        if (r100.getBackgroundImageModel() == null) goto L13;
        CommonBubbleConfig r101 = this.bubbleConfig;
        Intrinsics.checkNotNull(r101);
        if (ListUtils.isEmpty(r101.getBackgroundImageModel().getUrls()) == true) goto L13;
        CommonBubbleConfig r102 = this.bubbleConfig;
        Intrinsics.checkNotNull(r102);
        if (r102.arrowImage == null) goto L13;
        CommonBubbleConfig r103 = this.bubbleConfig;
        Intrinsics.checkNotNull(r103);
        if (ListUtils.isEmpty(r103.arrowImage.getUrls()) == true) goto L13;
        return true;
    L13:
        return false;
    }

    public hm() {
        setType(MessageType.TOP_LEFT_BUBBLE_MESSAGE);
    }

    public final CommonBubbleConfig G() {
        return this.bubbleConfig;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public hm(am3.g r110) {
        this.extra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.bubbleConfig = _CommonBubbleConfig_ProtoDecoder.decodeStatic(r110);
        goto L3
    L10:
        if (r101 != 3) goto L11;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L13
    L16:
        if (r105 != 2) goto L17;
        r104 = am3.h.c(r110);
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r102);
        Map<String, String> r106 = this.extra;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
        setType(MessageType.TOP_LEFT_BUBBLE_MESSAGE);
    }
}
