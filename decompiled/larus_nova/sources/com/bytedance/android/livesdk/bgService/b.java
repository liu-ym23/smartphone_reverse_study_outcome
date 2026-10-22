package com.bytedance.android.livesdk.bgService;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSessionCompat f104309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f104310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f104311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f104312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f104313e;

    public interface a {
        void onPause();

        void onPlay();
    }

    public b(Context r100, LiveMediaSessionService.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callbacks");
        this.f104312d = r100;
        this.f104313e = r101;
        MediaSessionCompat r102 = new MediaSessionCompat(r100, "LiveBgMediaSession");
        r102.setFlags(3);
        r102.setCallback(new com.bytedance.android.livesdk.bgService.a(this));
        Unit r103 = Unit.INSTANCE;
        this.f104309a = r102;
        this.f104310b = "LiveMediaSession";
    }

    public final void update(boolean r100, boolean r101, Bitmap r102) {
        ALogger.i(this.f104310b, "LiveMediaSessionController### update start, this.playing:" + this.f104311c + ", isPlaying:" + r100 + ", ignoreCheck:" + r101 + ",bitmap:" + r102);
        if (df1.a.d() == false) goto L5;
        return;
    L5:
        Boolean r103 = this.f104311c;
        if (r103 != null) goto L8;
    L11:
        ALogger.i(this.f104310b, "LiveMediaSessionController### update success");
        this.f104311c = Boolean.valueOf(r100);
        if (r100 == false) goto L14;
        int r104 = 3;
    L15:
        if (r100 == false) goto L17;
        float r105 = 1.0f;
    L18:
        this.f104309a.setActive(true);
        this.f104309a.setPlaybackState(new PlaybackStateCompat.Builder().setActions(6).setState(r104, -1, r105).build());
        ALogger.i(this.f104310b, "LiveMediaSessionController### applySessionMetadata");
        IRoomService r106 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r106 == null) goto L41;
        Room r107 = r106.getCurrentRoom();
        if (r107 == null) goto L42;
        MediaMetadataCompat.Builder r108 = new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_TITLE, df1.a.c(this.f104312d, r107)).putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, df1.a.c(this.f104312d, r107));
        User r109 = r107.mo8271getOwner();
        if (r109 == null) goto L27;
        String r110 = r109.getNickName();
        if (r110 == null) goto L27;
    L28:
        MediaMetadataCompat.Builder r111 = r108.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, r110);
        if (r102 != null) goto L31;
    L38:
        this.f104309a.setMetadata(r111.build());     // Catch: Exception -> L35
        ALogger.i(this.f104310b, "LiveMediaSessionController### applySessionMetadata success");     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        ALogger.i(this.f104310b, "LiveMediaSessionController### applySessionMetadata error : " + e.getMessage());
        return;
    L31:
        if (r102.isRecycled() == true) goto L38;
        r111.putBitmap(MediaMetadataCompat.METADATA_KEY_ART, r102);
    L27:
        r110 = "";
        goto L28
    L42:
        return;
    L41:
        return;
    L17:
        r105 = 0.0f;
        goto L18
    L14:
        r104 = 2;
        goto L15
    L8:
        if ((!Intrinsics.areEqual(r103, Boolean.valueOf(r100))) == true) goto L11;
        if (r101 == true) goto L11;
        if (r102 != null) goto L11;
    }
}
