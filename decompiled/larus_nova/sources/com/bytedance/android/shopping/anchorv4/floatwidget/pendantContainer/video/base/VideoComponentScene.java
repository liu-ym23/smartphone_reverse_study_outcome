package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/video/base/VideoComponentScene;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "HEAD_VIDEO", "HEAD_VIDEO_GALLERY", "HEAD_VIDEO_WINDOW", "HEAD_MORE_VIDEO_WINDOW", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VideoComponentScene extends Enum<VideoComponentScene> {
    public static final VideoComponentScene HEAD_MORE_VIDEO_WINDOW = null;
    public static final VideoComponentScene HEAD_VIDEO = null;
    public static final VideoComponentScene HEAD_VIDEO_GALLERY = null;
    public static final VideoComponentScene HEAD_VIDEO_WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoComponentScene[] f166807a = null;
    private final String scene;

    static {
        VideoComponentScene r100 = new VideoComponentScene("HEAD_VIDEO", 0, "pdp_header");
        HEAD_VIDEO = r100;
        VideoComponentScene r101 = new VideoComponentScene("HEAD_VIDEO_GALLERY", 1, "pdp_gallery");
        HEAD_VIDEO_GALLERY = r101;
        VideoComponentScene r102 = new VideoComponentScene("HEAD_VIDEO_WINDOW", 2, "pdp_header_window");
        HEAD_VIDEO_WINDOW = r102;
        VideoComponentScene r103 = new VideoComponentScene("HEAD_MORE_VIDEO_WINDOW", 3, "pdp_more_video_window");
        HEAD_MORE_VIDEO_WINDOW = r103;
        f166807a = new VideoComponentScene[]{r100, r101, r102, r103};
    }

    public static VideoComponentScene valueOf(String r100) {
        return (VideoComponentScene) a.a(VideoComponentScene.class, r100);
    }

    public static VideoComponentScene[] values() {
        return (VideoComponentScene[]) f166807a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public VideoComponentScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
