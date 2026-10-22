package com.stepos.agentframework.chatcore.send;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.chatcore.file.FileInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/g;", "", "", "messageId", "LY8/t;", "M", "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/send/d;", "ids", "text", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "replyOverride", "H", "(Lcom/stepos/agentframework/chatcore/send/d;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "k", "(Lcom/stepos/agentframework/chatcore/send/d;)V", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/agentframework/chatcore/send/e;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface g {
    void A(SendContext ctx);

    void H(PendingBubbleIds ids, String text, List<FileInfo> images, String replyOverride);

    void M(String messageId);

    void k(PendingBubbleIds ids);
}
