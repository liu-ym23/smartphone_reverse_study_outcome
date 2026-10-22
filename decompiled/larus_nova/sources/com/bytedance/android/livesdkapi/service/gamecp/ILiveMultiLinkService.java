package com.bytedance.android.livesdkapi.service.gamecp;

import io.reactivex.disposables.Disposable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/ILiveMultiLinkService;", "", "isAudioLinkType", "", "isVideoOrAvatarLinkType", "onAudioData", "", "roomId", "", "buffer", "Ljava/nio/ByteBuffer;", "samples", "", "sampleRate", "channel", "isAnchor", "onAudioRelease", "onMultiLinkAudiencePreInitRtc", "Lio/reactivex/disposables/Disposable;", "block", "Lkotlin/Function0;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMultiLinkService {
    boolean isAudioLinkType();

    boolean isVideoOrAvatarLinkType();

    void onAudioData(String r100, ByteBuffer r101, int r102, int r103, int r104, boolean r105);

    void onAudioRelease(String r100);

    Disposable onMultiLinkAudiencePreInitRtc(Function0<Unit> r100);
}
