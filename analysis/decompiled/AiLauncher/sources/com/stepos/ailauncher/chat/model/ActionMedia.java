package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionMedia;", "", "mediaType", "", "url", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMediaType", "()Ljava/lang/String;", "getUrl", "getTitle", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionMedia {
    private final String mediaType;
    private final String title;
    private final String url;

    public ActionMedia() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ActionMedia copy$default(ActionMedia actionMedia, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionMedia.mediaType;
        }
        if ((i10 & 2) != 0) {
            str2 = actionMedia.url;
        }
        if ((i10 & 4) != 0) {
            str3 = actionMedia.title;
        }
        return actionMedia.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMediaType() {
        return this.mediaType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final ActionMedia copy(String mediaType, String url, String title) {
        return new ActionMedia(mediaType, url, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionMedia)) {
            return false;
        }
        ActionMedia actionMedia = (ActionMedia) other;
        return p.d(this.mediaType, actionMedia.mediaType) && p.d(this.url, actionMedia.url) && p.d(this.title, actionMedia.title);
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.mediaType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ActionMedia(mediaType=" + this.mediaType + ", url=" + this.url + ", title=" + this.title + ")";
    }

    public ActionMedia(String str, String str2, String str3) {
        this.mediaType = str;
        this.url = str2;
        this.title = str3;
    }

    public /* synthetic */ ActionMedia(String str, String str2, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
