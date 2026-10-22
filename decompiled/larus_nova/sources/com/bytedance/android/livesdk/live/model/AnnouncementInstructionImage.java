package com.bytedance.android.livesdk.live.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/model/AnnouncementInstructionImage;", "", "title", "", "content", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;II)V", "getContent", "()Ljava/lang/String;", "getHeight", "()I", "getTitle", "getWidth", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementInstructionImage {
    private final String content;
    private final int height;
    private final String title;
    private final int width;

    public final String getContent() {
        return this.content;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getWidth() {
        return this.width;
    }

    public AnnouncementInstructionImage(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.title = r100;
        this.content = r101;
        this.width = r102;
        this.height = r103;
    }
}
