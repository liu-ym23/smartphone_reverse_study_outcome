package com.bytedance.android.livesdk.interactivity.api.comment.event;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/event/DefaultLandingPanel;", "", "", "panel", "Ljava/lang/String;", "getPanel", "()Ljava/lang/String;", "Default", "Emoji", "Video", ServiceType.AUDIO, "Collection", "FastComment", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DefaultLandingPanel extends Enum<DefaultLandingPanel> {
    public static final DefaultLandingPanel Audio = null;
    public static final DefaultLandingPanel Collection = null;
    public static final DefaultLandingPanel Default = null;
    public static final DefaultLandingPanel Emoji = null;
    public static final DefaultLandingPanel FastComment = null;
    public static final DefaultLandingPanel Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultLandingPanel[] f133041a = null;
    private final String panel;

    static {
        DefaultLandingPanel r100 = new DefaultLandingPanel("Default", 0, "default");
        Default = r100;
        DefaultLandingPanel r101 = new DefaultLandingPanel("Emoji", 1, "emoji");
        Emoji = r101;
        DefaultLandingPanel r102 = new DefaultLandingPanel("Video", 2, "video");
        Video = r102;
        DefaultLandingPanel r103 = new DefaultLandingPanel(ServiceType.AUDIO, 3, "audio");
        Audio = r103;
        DefaultLandingPanel r104 = new DefaultLandingPanel("Collection", 4, "collection");
        Collection = r104;
        DefaultLandingPanel r105 = new DefaultLandingPanel("FastComment", 5, "common_comment");
        FastComment = r105;
        f133041a = new DefaultLandingPanel[]{r100, r101, r102, r103, r104, r105};
    }

    public static DefaultLandingPanel valueOf(String r100) {
        return (DefaultLandingPanel) a.a(DefaultLandingPanel.class, r100);
    }

    public static DefaultLandingPanel[] values() {
        return (DefaultLandingPanel[]) f133041a.clone();
    }

    public final String getPanel() {
        return this.panel;
    }

    public DefaultLandingPanel(String r100, int r101, String r102) {
        super(r100, r101);
        this.panel = r102;
    }
}
