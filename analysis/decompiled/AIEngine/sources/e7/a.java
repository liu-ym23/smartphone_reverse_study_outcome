package e7;

import com.stepos.base.protocol.AsrFeedKind;
import kotlinx.coroutines.flow.Flow;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a extends b {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: e7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0076a {
        void onChunk(String str, long j10, long j11);

        void onEnd();

        void onError(int i10, String str);
    }

    boolean feedAudioFrame(c.a aVar, boolean z, InterfaceC0076a interfaceC0076a, AsrFeedKind asrFeedKind);

    Object processAudio(c.a aVar, Object obj, qb.b<? super Flow<? extends v6.d>> bVar);
}
