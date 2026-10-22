package com.bytedance.android.gamecp.business;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import xr.r;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/GameCpVideoOuterService;", "Lxr/k;", "Lxr/r;", "listener", "", "setGameDetailPageHeightChangeListener", "getGameDetailPageHeightChangeListener", "", "vid", "", "videoItemParams", "setVideoItemParams", "getVideoItemParams", "Ljava/lang/ref/WeakReference;", "listenerRef", "Ljava/lang/ref/WeakReference;", "videoItemParamsRef", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCpVideoOuterService implements xr.k {
    private WeakReference<r> listenerRef;
    private WeakReference<Object> videoItemParamsRef;

    public GameCpVideoOuterService() {
    }

    @Override // xr.k
    public r getGameDetailPageHeightChangeListener() {
        WeakReference<r> r100 = this.listenerRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // xr.k
    public Object getVideoItemParams() {
        WeakReference<Object> r100 = this.videoItemParamsRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public void setGameDetailPageHeightChangeListener(r r100) {
        this.listenerRef = new WeakReference(r100);
    }

    public void setVideoItemParams(String r100, Object r101) {
        this.videoItemParamsRef = new WeakReference(r101);
        aw.a.C0239a r102 = aw.a.f16401a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "vid");
        if (TextUtils.isEmpty(r100) == true) goto L13;
        com.bytedance.android.gamecp.host_api.a.b().getHostVideoPlayerService().isPlaying();
        if (r101 == null) goto L11;
        Pair<Boolean, Object> r103 = aw.a.C0239a.f16402a.put(r100, new Pair(Boolean.FALSE, r101));
    L11:
        Objects.toString(r101);
        return;
    }
}
