package com.bytedance.android.livesdk.chatroom.end.vip.utils;

import com.bytedance.android.livesdk.message.model.nl;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/vip/utils/EndRoomMessageType;", "", "", "messageIntType", "I", "getMessageIntType", "()I", "", "messageMethod", "Ljava/lang/String;", "getMessageMethod", "()Ljava/lang/String;", "Ljava/lang/Class;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "messageType", "Ljava/lang/Class;", "getMessageType", "()Ljava/lang/Class;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VipEndRoom", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EndRoomMessageType extends Enum<EndRoomMessageType> {
    public static final a Companion = null;
    public static final EndRoomMessageType VipEndRoom = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EndRoomMessageType[] f106161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<ExternalMessageInject.InjectInfo> f106162b = null;
    private final int messageIntType;
    private final String messageMethod;
    private final Class<? extends ExternalBaseMessage> messageType;

    public static final class a {
        public a() {
        }
    }

    static {
        EndRoomMessageType r100 = new EndRoomMessageType(ExternalMessageType.EXTERNAL_END_ROOM.getMin(), nl.class);
        VipEndRoom = r100;
        int r101 = 0;
        f106161a = new EndRoomMessageType[]{r100};
        Companion = new a();
        EndRoomMessageType[] r102 = values();
        ArrayList r103 = new ArrayList(r102.length);
        int r104 = r102.length;
    L3:
        if (r101 >= r104) goto L5;
        EndRoomMessageType r105 = r102[r101];
        r105.getClass();
        r103.add(new ExternalMessageInject.InjectInfo(r105.messageMethod, r105.messageType));
        r101 = r101 + 1;
        goto L3
    L5:
        f106162b = r103;
    }

    public static final List<ExternalMessageInject.InjectInfo> getInjectInfoList() {
        return f106162b;
    }

    public static EndRoomMessageType valueOf(String r100) {
        return (EndRoomMessageType) r27.a.a(EndRoomMessageType.class, r100);
    }

    public static EndRoomMessageType[] values() {
        return (EndRoomMessageType[]) f106161a.clone();
    }

    public static final /* synthetic */ List access$getInjectInfoList$cp() {
        return f106162b;
    }

    public final int getMessageIntType() {
        return this.messageIntType;
    }

    public final String getMessageMethod() {
        return this.messageMethod;
    }

    public final Class<? extends ExternalBaseMessage> getMessageType() {
        return this.messageType;
    }

    public EndRoomMessageType(int r100, Class r101) {
        super("VipEndRoom", 0);
        this.messageIntType = r100;
        this.messageMethod = "WebcastSubscribeVipLiveMessage";
        this.messageType = r101;
    }
}
