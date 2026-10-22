package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/LiveTypeForMultiLink;", "", "Video", ServiceType.AUDIO, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveTypeForMultiLink extends Enum<LiveTypeForMultiLink> {
    public static final LiveTypeForMultiLink Audio = null;
    public static final LiveTypeForMultiLink Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveTypeForMultiLink[] f75895a = null;

    static {
        LiveTypeForMultiLink r100 = new LiveTypeForMultiLink("Video", 0);
        Video = r100;
        LiveTypeForMultiLink r101 = new LiveTypeForMultiLink(ServiceType.AUDIO, 1);
        Audio = r101;
        f75895a = new LiveTypeForMultiLink[]{r100, r101};
    }

    public static LiveTypeForMultiLink valueOf(String r100) {
        return (LiveTypeForMultiLink) r27.a.a(LiveTypeForMultiLink.class, r100);
    }

    public static LiveTypeForMultiLink[] values() {
        return (LiveTypeForMultiLink[]) f75895a.clone();
    }

    public LiveTypeForMultiLink(String r100, int r101) {
        super(r100, r101);
    }
}
