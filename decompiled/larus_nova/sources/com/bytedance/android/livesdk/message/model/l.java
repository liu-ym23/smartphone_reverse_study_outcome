package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.AnchorBoostMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/o;", "Lcom/bytedance/android/livesdk/message/model/l$a;", "_boostData", "Lcom/bytedance/android/livesdk/message/model/l$a;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdk/message/model/l$a;", "set_boostData", "(Lcom/bytedance/android/livesdk/message/model/l$a;)V", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "_publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "get_publicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "set_publicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l extends o0 implements com.bytedance.android.live.base.model.message.o, vh7.h {

    @SerializedName("data")
    protected a _boostData;

    @SerializedName("public_area_common")
    protected PublicAreaCommon _publicAreaCommon;

    @ProtoMessage("webcast.im.AnchorBoost")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l$a;", "", "", "_eventName", "I", "get_eventName", "()I", "set_eventName", "(I)V", "_anchorId", "get_anchorId", "set_anchorId", "_liveId", "get_liveId", "set_liveId", "_eventType", "b", "set_eventType", "", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("anchor_id")
        protected int _anchorId;

        @SerializedName("content")
        protected String _content;

        @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
        protected int _eventName;

        @SerializedName("event_type")
        protected int _eventType;

        @SerializedName("live_id")
        protected int _liveId;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.message.model.l$a$a, reason: collision with other inner class name */
        public static final class C2365a {
        }

        static {
        }

        public a() {
        }

        public final String a() {
            return this._content;
        }

        public final int b() {
            return this._eventType;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this._eventName = (int) r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this._anchorId = (int) r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this._liveId = r100.i();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this._eventType = r100.i();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this._content = am3.h.c(r100);
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
        }
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IBaseUser getUserInMessage() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean canText() {
        a r100 = this._boostData;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (StringUtils.isEmpty(r100._content) == true) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this._publicAreaCommon != null) goto L6;
        this._publicAreaCommon = new PublicAreaCommon();
    L6:
        return this._publicAreaCommon;
    }

    public l() {
        this.type = MessageType.ANCHOR_BOOST_MESSAGE;
    }

    public final a E() {
        return this._boostData;
    }

    @Override // com.bytedance.android.live.base.model.message.o
    public final a J() {
        return this._boostData;
    }

    public l(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._boostData = new a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._publicAreaCommon = new PublicAreaCommon(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.ANCHOR_BOOST_MESSAGE;
    }
}
