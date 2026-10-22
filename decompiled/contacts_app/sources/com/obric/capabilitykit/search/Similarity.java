package com.obric.capabilitykit.search;

import com.android.contacts.util.BlackListQueryHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/search/Similarity;", "", BlackListQueryHandler.KEY_PHOTO, "", "Lcom/obric/capabilitykit/search/PhotoScore;", "video", "Lcom/obric/capabilitykit/search/VideoScore;", "(Ljava/util/List;Ljava/util/List;)V", "getPhoto", "()Ljava/util/List;", "getVideo", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Similarity {
    private final List<PhotoScore> photo;
    private final List<VideoScore> video;

    /* JADX WARN: Multi-variable type inference failed */
    public Similarity(List<? extends PhotoScore> r2, List<VideoScore> r3) {
        Intrinsics.checkNotNullParameter(r2, BlackListQueryHandler.KEY_PHOTO);
        Intrinsics.checkNotNullParameter(r3, "video");
        this.photo = r2;
        this.video = r3;
    }

    public final List<PhotoScore> getPhoto() {
        return this.photo;
    }

    public final List<VideoScore> getVideo() {
        return this.video;
    }
}
