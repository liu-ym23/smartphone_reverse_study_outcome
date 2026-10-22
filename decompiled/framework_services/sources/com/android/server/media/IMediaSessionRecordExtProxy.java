package com.android.server.media;

import android.media.MediaMetadata;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.prometheus.ext.core.ExtLoader;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IMediaSessionRecordExtProxy {
    private final List<IMediaSessionRecordExt> mMediaSessionRecordExts;

    public static IMediaSessionRecordExtProxy get(MediaSessionRecord base) {
        return new IMediaSessionRecordExtProxy(base);
    }

    public IMediaSessionRecordExtProxy(Object base) {
        this.mMediaSessionRecordExts = ExtLoader.getAll(IMediaSessionRecordExt.class, base);
    }

    public void init(int uid, int userId, String pkg, String tag) {
        if (this.mMediaSessionRecordExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionRecordExt> r0 = this.mMediaSessionRecordExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionRecordExt ext = r0.next();
        ext.init(uid, userId, pkg, tag);
        goto L7
    }

    public int getSid() {
        if (this.mMediaSessionRecordExts != null) goto L5;
        return 0;
    L5:
        Iterator<IMediaSessionRecordExt> r0 = this.mMediaSessionRecordExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        IMediaSessionRecordExt ext = r0.next();
        int sid = ext.getSid();
        if (sid == 0) goto L7;
        return sid;
    L12:
        return 0;
    }

    public void setMetadata_onEnd(MediaMetadata metadata) {
        if (this.mMediaSessionRecordExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionRecordExt> r0 = this.mMediaSessionRecordExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionRecordExt ext = r0.next();
        ext.setMetadata_onEnd(metadata);
        goto L7
    }

    public void setPlaybackState_onEnd(PlaybackState state) {
        if (this.mMediaSessionRecordExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionRecordExt> r0 = this.mMediaSessionRecordExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionRecordExt ext = r0.next();
        ext.setPlaybackState_onEnd(state);
        goto L7
    }

    public void setExtras_onEnd(Bundle extras) {
        if (this.mMediaSessionRecordExts != null) goto L5;
        return;
    L5:
        Iterator<IMediaSessionRecordExt> r0 = this.mMediaSessionRecordExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IMediaSessionRecordExt ext = r0.next();
        ext.setExtras_onEnd(extras);
        goto L7
    }

    boolean postAdjustLocalVolume_shouldApplyDedicatedStreamType(int stream) {
        if (this.mMediaSessionRecordExts != null) goto L5;
        return false;
    L5:
        Iterator<IMediaSessionRecordExt> r0 = this.mMediaSessionRecordExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        IMediaSessionRecordExt ext = r0.next();
        if (ext.postAdjustLocalVolume_shouldApplyDedicatedStreamType(stream) == false) goto L7;
        return true;
    L13:
        return false;
    }
}
