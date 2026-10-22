package com.obric.capabilitykit.search;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/search/VideoScore;", "", "entityId", "", "frameList", "", "Lcom/obric/capabilitykit/search/FrameScore;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getFrameList", "()Ljava/util/List;", "setFrameList", "(Ljava/util/List;)V", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VideoScore {

    @NotNull
    private String entityId;

    @NotNull
    private List<FrameScore> frameList;

    public VideoScore(@NotNull String r10, @NotNull List<FrameScore> r11) {
        q.g(r10, "entityId");
        q.g(r11, "frameList");
        this.entityId = r10;
        this.frameList = r11;
    }

    @NotNull
    public final String getEntityId() {
        return this.entityId;
    }

    @NotNull
    public final List<FrameScore> getFrameList() {
        return this.frameList;
    }

    public final void setEntityId(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.entityId = r10;
    }

    public final void setFrameList(@NotNull List<FrameScore> r10) {
        q.g(r10, "<set-?>");
        this.frameList = r10;
    }
}
