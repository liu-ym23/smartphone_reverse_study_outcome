package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.BackupSEIMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/BackupSeiMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "backupSeiListStr", "Ljava/lang/String;", "getBackupSeiListStr", "()Ljava/lang/String;", "source", "getSource", "streamId", "getStreamId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BackupSeiMessage extends o0 implements vh7.h {
    public static final a Companion = null;
    public static final String SOURCE_ANDROID = "android";
    public static final String SOURCE_IOS = "ios";
    public static final String SOURCE_PC = "pc";
    public static final String SOURCE_RTC_SERVER = "rtc_server";

    @SerializedName("sei_data")
    protected String backupSeiListStr;

    @SerializedName("source")
    protected String source;

    @SerializedName("stream_id")
    protected String streamId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BackupSeiMessage() {
        this.type = MessageType.BACKUP_SEI_MESSAGE;
    }

    public final String getBackupSeiListStr() {
        return this.backupSeiListStr;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStreamId() {
        return this.streamId;
    }

    public BackupSeiMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.source = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.backupSeiListStr = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5) goto L13;
        this.streamId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.BACKUP_SEI_MESSAGE;
    }
}
