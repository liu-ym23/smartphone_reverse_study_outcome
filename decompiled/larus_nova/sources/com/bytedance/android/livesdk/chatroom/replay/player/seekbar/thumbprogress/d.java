package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, DownloadTask> f109769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, DownloadTask> f109770b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a
    public final boolean b() {
        return this.f109770b.isEmpty();
    }

    public d() {
        this.f109769a = new LinkedHashMap();
        this.f109770b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress.a
    public final void a(String r100, String r101, String r102, f.c r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_DIR);
        Intrinsics.checkNotNullParameter(r102, "filename");
        Intrinsics.checkNotNullParameter(r103, "callback");
        DownloadTask r104 = (DownloadTask) ((LinkedHashMap) this.f109770b).get(r102);
        if (r104 != null) goto L5;
        r104 = Downloader.with(s1.getContext()).url(r100).name(r102).savePath(r101).monitorScene("live_replay_thumb").subThreadListener(new e(this, r103, r102));
        r104.download();
    L6:
        this.f109769a.put(r102, r104);
        return;
    L5:
        Downloader.getInstance(s1.getContext()).resume(r104.getDownloadId());
        goto L6
    }
}
