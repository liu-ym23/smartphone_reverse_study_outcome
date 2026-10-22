package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b3\b\u0086\b\u0018\u0000 T2\u00020\u0001:\u0001UBÏ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001cH\u0016¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010\"J\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010)J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010)J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010)J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010)J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010)J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010)J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010)J\u0012\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010)J\u0012\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b5\u0010)J\u0012\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b8\u00109J\u0012\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b:\u0010)J\u001e\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b;\u0010<JØ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b?\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010@\u001a\u0004\bA\u0010)R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010@\u001a\u0004\bB\u0010)R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010@\u001a\u0004\bC\u0010)R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010@\u001a\u0004\bD\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010@\u001a\u0004\bE\u0010)R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010@\u001a\u0004\bF\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010@\u001a\u0004\bG\u0010)R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010@\u001a\u0004\bH\u0010)R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010@\u001a\u0004\bI\u0010)R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010J\u001a\u0004\bK\u00103R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010@\u001a\u0004\bL\u0010)R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010@\u001a\u0004\bM\u0010)R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010N\u001a\u0004\bO\u00107R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010P\u001a\u0004\b\u0013\u00109R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010@\u001a\u0004\bQ\u0010)R%\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010R\u001a\u0004\bS\u0010<¨\u0006V"}, d2 = {"Lcom/zyql/agentfront/bean/MessageContent;", "Landroid/os/Parcelable;", "", "type", "text", "fileId", "uri", "url", "base64", "thumbnailUrl", "coverUrl", "fileName", "", "fileSize", "mimeType", "displayName", "", "data", "", "isEnd", "audioId", "", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;[BZLjava/lang/String;Ljava/util/Map;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "()Ljava/lang/Long;", "component11", "component12", "component13", "()[B", "component14", "()Z", "component15", "component16", "()Ljava/util/Map;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;[BZLjava/lang/String;Ljava/util/Map;)Lcom/zyql/agentfront/bean/MessageContent;", "toString", "Ljava/lang/String;", "getType", "getText", "getFileId", "getUri", "getUrl", "getBase64", "getThumbnailUrl", "getCoverUrl", "getFileName", "Ljava/lang/Long;", "getFileSize", "getMimeType", "getDisplayName", "[B", "getData", "Z", "getAudioId", "Ljava/util/Map;", "getExtra", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MessageContent implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String audioId;
    private final String base64;
    private final String coverUrl;
    private final byte[] data;
    private final String displayName;
    private final Map<String, String> extra;
    private final String fileId;
    private final String fileName;
    private final Long fileSize;
    private final boolean isEnd;
    private final String mimeType;
    private final String text;
    private final String thumbnailUrl;
    private final String type;
    private final String uri;
    private final String url;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/MessageContent$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/MessageContent;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/MessageContent;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/MessageContent;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.MessageContent$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<MessageContent> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new MessageContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageContent[] newArray(int size) {
            return new MessageContent[size];
        }

        public Companion() {
        }
    }

    public MessageContent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component13, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    /* renamed from: component15, reason: from getter */
    public final String getAudioId() {
        return this.audioId;
    }

    public final Map<String, String> component16() {
        return this.extra;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBase64() {
        return this.base64;
    }

    /* renamed from: component7, reason: from getter */
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final MessageContent copy(String type, String text, String fileId, String uri, String url, String base64, String thumbnailUrl, String coverUrl, String fileName, Long fileSize, String mimeType, String displayName, byte[] data, boolean isEnd, String audioId, Map<String, String> extra) {
        p.i(type, "type");
        return new MessageContent(type, text, fileId, uri, url, base64, thumbnailUrl, coverUrl, fileName, fileSize, mimeType, displayName, data, isEnd, audioId, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!p.d(MessageContent.class, other != null ? other.getClass() : null)) {
            return false;
        }
        p.g(other, "null cannot be cast to non-null type com.zyql.agentfront.bean.MessageContent");
        MessageContent messageContent = (MessageContent) other;
        if (!p.d(this.type, messageContent.type) || !p.d(this.text, messageContent.text) || !p.d(this.fileId, messageContent.fileId) || !p.d(this.uri, messageContent.uri) || !p.d(this.url, messageContent.url) || !p.d(this.base64, messageContent.base64) || !p.d(this.thumbnailUrl, messageContent.thumbnailUrl) || !p.d(this.coverUrl, messageContent.coverUrl) || !p.d(this.fileName, messageContent.fileName) || !p.d(this.fileSize, messageContent.fileSize) || !p.d(this.mimeType, messageContent.mimeType) || !p.d(this.displayName, messageContent.displayName)) {
            return false;
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            byte[] bArr2 = messageContent.data;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (messageContent.data != null) {
            return false;
        }
        return this.isEnd == messageContent.isEnd && p.d(this.audioId, messageContent.audioId) && p.d(this.extra, messageContent.extra);
    }

    public final String getAudioId() {
        return this.audioId;
    }

    public final String getBase64() {
        return this.base64;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getText() {
        return this.text;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.text;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fileId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uri;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.base64;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.thumbnailUrl;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.coverUrl;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.fileName;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Long l10 = this.fileSize;
        int iHashCode10 = (iHashCode9 + (l10 != null ? Long.hashCode(l10.longValue()) : 0)) * 31;
        String str9 = this.mimeType;
        int iHashCode11 = (iHashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.displayName;
        int iHashCode12 = (iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        byte[] bArr = this.data;
        int iHashCode13 = (((iHashCode12 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + Boolean.hashCode(this.isEnd)) * 31;
        String str11 = this.audioId;
        int iHashCode14 = (iHashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Map<String, String> map = this.extra;
        return iHashCode14 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isEnd() {
        return this.isEnd;
    }

    public String toString() {
        return "MessageContent(type=" + this.type + ", text=" + this.text + ", fileId=" + this.fileId + ", uri=" + this.uri + ", url=" + this.url + ", base64=" + this.base64 + ", thumbnailUrl=" + this.thumbnailUrl + ", coverUrl=" + this.coverUrl + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + ", displayName=" + this.displayName + ", data=" + Arrays.toString(this.data) + ", isEnd=" + this.isEnd + ", audioId=" + this.audioId + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.text);
        parcel.writeString(this.fileId);
        parcel.writeString(this.uri);
        parcel.writeString(this.url);
        parcel.writeString(this.base64);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.fileName);
        parcel.writeValue(this.fileSize);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.displayName);
        parcel.writeByteArray(this.data);
        parcel.writeByte(this.isEnd ? (byte) 1 : (byte) 0);
        parcel.writeString(this.audioId);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
    }

    public MessageContent(String type, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l10, String str9, String str10, byte[] bArr, boolean z10, String str11, Map<String, String> map) {
        p.i(type, "type");
        this.type = type;
        this.text = str;
        this.fileId = str2;
        this.uri = str3;
        this.url = str4;
        this.base64 = str5;
        this.thumbnailUrl = str6;
        this.coverUrl = str7;
        this.fileName = str8;
        this.fileSize = l10;
        this.mimeType = str9;
        this.displayName = str10;
        this.data = bArr;
        this.isEnd = z10;
        this.audioId = str11;
        this.extra = map;
    }

    public /* synthetic */ MessageContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l10, String str10, String str11, byte[] bArr, boolean z10, String str12, Map map, int i10, i iVar) {
        this((i10 & 1) != 0 ? "text" : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : l10, (i10 & 1024) != 0 ? null : str10, (i10 & 2048) != 0 ? null : str11, (i10 & 4096) != 0 ? null : bArr, (i10 & b.THRESHOLD) != 0 ? false : z10, (i10 & 16384) != 0 ? null : str12, (i10 & 32768) != 0 ? null : map);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MessageContent(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "text" : string;
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        Object value = parcel.readValue(Long.TYPE.getClassLoader());
        Long l10 = value instanceof Long ? (Long) value : null;
        String string10 = parcel.readString();
        String string11 = parcel.readString();
        byte[] bArrCreateByteArray = parcel.createByteArray();
        boolean z10 = parcel.readByte() != 0;
        String string12 = parcel.readString();
        Serializable serializable = parcel.readSerializable();
        this(str, string2, string3, string4, string5, string6, string7, string8, string9, l10, string10, string11, bArrCreateByteArray, z10, string12, serializable instanceof Map ? (Map) serializable : null);
    }
}
