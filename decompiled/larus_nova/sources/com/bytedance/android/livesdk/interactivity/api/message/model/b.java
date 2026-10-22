package com.bytedance.android.livesdk.interactivity.api.message.model;

import am3.g;
import com.bytedance.android.livesdk.interactivity.api.entity.j;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.PlatformAdviseMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/message/model/b;", "Ly32/a;", "Lcom/bytedance/android/livesdk/interactivity/api/entity/j;", "Lcom/bytedance/android/livesdkapi/message/Text;", "adviseText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getAdviseText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setAdviseText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "priority", "getPriority", "setPriority", "", "", "eventTracking", "Ljava/util/Map;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/util/Map;", "setEventTracking", "(Ljava/util/Map;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends y32.a implements j, h {

    @SerializedName("advise_text")
    protected Text adviseText;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("event_tracking")
    protected Map<String, String> eventTracking;

    @SerializedName("priority")
    protected long priority;

    public b() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.PlatformAdvise;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final long getPriority() {
        return this.priority;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final Text l() {
        return this.adviseText;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.j
    public final Map<String, String> n() {
        return this.eventTracking;
    }

    public b(g r110) {
        this.eventTracking = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.adviseText = _Text_ProtoDecoder.decodeStatic(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.duration = r110.j();
        goto L3
    L12:
        if (r101 != 4) goto L14;
        this.priority = r110.j();
        goto L3
    L14:
        if (r101 != 20) goto L15;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L17:
        int r105 = r110.f();
        if (r105 == (-1)) goto L24;
        if (r105 != 1) goto L20;
        r103 = am3.h.c(r110);
        goto L17
    L20:
        if (r105 != 2) goto L21;
        r104 = am3.h.c(r110);
        goto L17
    L21:
        am3.h.e(r110);
        goto L17
    L24:
        r110.d(r102);
        Map<String, String> r106 = this.eventTracking;
        if (r103 == null) goto L31;
        if (r104 == null) goto L29;
        r106.put(r103, r104);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L15:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r100);
    }
}
