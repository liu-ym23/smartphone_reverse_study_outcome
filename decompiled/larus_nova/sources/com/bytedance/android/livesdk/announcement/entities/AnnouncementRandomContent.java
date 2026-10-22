package com.bytedance.android.livesdk.announcement.entities;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/entities/AnnouncementRandomContent;", "", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementRandomContent {

    @SerializedName("random_content")
    private final String content;

    public final String getContent() {
        return this.content;
    }

    public AnnouncementRandomContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
    }
}
