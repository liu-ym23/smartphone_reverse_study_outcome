package com.obric.capabilitykit.search;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/search/PhotoScore;", "", "entityId", "", "score", "", "(Ljava/lang/String;F)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getScore", "()F", "setScore", "(F)V", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class PhotoScore {

    @NotNull
    private String entityId;
    private float score;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoScore() {
        String r10 = null;
        this(r10, 0.0f, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final String getEntityId() {
        return this.entityId;
    }

    public final float getScore() {
        return this.score;
    }

    public final void setEntityId(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.entityId = r10;
    }

    public final void setScore(float r10) {
        this.score = r10;
    }

    public PhotoScore(@NotNull String r10, float r11) {
        q.g(r10, "entityId");
        this.entityId = r10;
        this.score = r11;
    }

    public /* synthetic */ PhotoScore(String r10, float r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = 0.0f;
    L8:
        this(r10, r11);
    }
}
