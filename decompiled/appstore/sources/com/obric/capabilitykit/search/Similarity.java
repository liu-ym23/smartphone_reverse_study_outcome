package com.obric.capabilitykit.search;

import androidx.annotation.Keep;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/search/Similarity;", "", "photo", "", "Lcom/obric/capabilitykit/search/PhotoScore;", ServerElements.VIDEO, "Lcom/obric/capabilitykit/search/VideoScore;", "(Ljava/util/List;Ljava/util/List;)V", "getPhoto", "()Ljava/util/List;", "getVideo", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Similarity {

    @NotNull
    private final List<PhotoScore> photo;

    @NotNull
    private final List<VideoScore> video;

    /* JADX WARN: Multi-variable type inference failed */
    public Similarity(@NotNull List<? extends PhotoScore> r10, @NotNull List<VideoScore> r11) {
        q.g(r10, "photo");
        q.g(r11, ServerElements.VIDEO);
        this.photo = r10;
        this.video = r11;
    }

    @NotNull
    public final List<PhotoScore> getPhoto() {
        return this.photo;
    }

    @NotNull
    public final List<VideoScore> getVideo() {
        return this.video;
    }
}
