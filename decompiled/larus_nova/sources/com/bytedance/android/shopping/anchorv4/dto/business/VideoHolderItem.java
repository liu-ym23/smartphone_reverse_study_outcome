package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/VideoHolderItem;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerViewScene;", "scene", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/b;", "getVideoModel", "localVideoModel", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/b;", "", "tabName", "Ljava/lang/String;", "getTabName", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "video", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoHolderItem implements Serializable {
    private com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b localVideoModel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private final String tabName;

    @SerializedName("video")
    private final VideoModel video;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoHolderItem() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b getVideoModel(PlayerViewScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.localVideoModel != null) goto L8;
        VideoModel r101 = this.video;
        if (r101 == null) goto L8;
        z73.a<String, gj.b> r102 = PlayAbilityUtil.f164933a;
        this.localVideoModel = PlayAbilityUtil.a(r101, null, r100);
    L8:
        return this.localVideoModel;
    }

    public VideoHolderItem(String r100, VideoModel r101) {
        this.tabName = r100;
        this.video = r101;
    }

    public /* synthetic */ VideoHolderItem(String r100, VideoModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
