package com.obric.agent.intents.audio;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.AudioControlSeekToParams;
import com.obric.capabilitykit.common.intent.BaseAudioControlSeekToIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.l.n;
import d.o;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: SeekToIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SeekToIntent extends BaseAudioControlSeekToIntent {
    public static final a Companion = null;
    private static final int DEFAULT_TIME = 30;
    private static final String TAG = "SeekToIntent";

    /* JADX INFO: compiled from: SeekToIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SeekToIntent.kt */
    @f(b = "SeekToIntent.kt", c = {37, 45, 53}, d = "doAction", e = "com.obric.agent.intents.audio.SeekToIntent")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f14673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f14674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f14675e;
        final /* synthetic */ SeekToIntent f;
        int g;

        b(SeekToIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14675e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public SeekToIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlSeekToIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((AudioControlSeekToParams) ZeusTransformUtils.preCheckCast(r6, AudioControlSeekToParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlSeekToIntent
    public Object doAction(AudioControlSeekToParams r27, DispatchContext r28, d.c.d<? super IntentResult<Empty>> r29) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f14675e;
        Object r4 = d.c.a.b.a();
        int r5 = r3.g;
        boolean r11 = true;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        long r6 = r3.f14674d;
        long r7 = r3.f14673c;
        MediaController r0 = (MediaController) ZeusTransformUtils.preCheckCast(r3.f14672b, MediaController.class, "com.obric.aiagent.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r3.f14671a, Integer.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L91:
        MediaController r13 = r0;
        long r10 = r6;
        long r14 = r7;
        Integer r9 = r8;
    L93:
        if (r9 == null) goto L95;
        int r12 = r9.intValue();
    L96:
        r13.getTransportControls().seekTo(n.a(r14 - (((long) r12) * 1000), 0, r10));
    L98:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L95:
        r12 = 30;
        goto L96
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r15 = r3.f14674d;
        long r16 = r3.f14673c;
        MediaController r17 = (MediaController) ZeusTransformUtils.preCheckCast(r3.f14672b, MediaController.class, "com.obric.aiagent.plugin");
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(r3.f14671a, Integer.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L51:
        r13 = r17;
        long r19 = r15;
        r14 = r16;
        r9 = r18;
    L53:
        if (r9 == null) goto L55;
        int r20 = r9.intValue();
    L56:
        r13.getTransportControls().seekTo(n.a(r14 + (((long) r20) * 1000), 0, r19));
        goto L98
    L55:
        r20 = 30;
        goto L56
    L17:
        long r21 = r3.f14673c;
        MediaController r22 = (MediaController) ZeusTransformUtils.preCheckCast(r3.f14672b, MediaController.class, "com.obric.aiagent.plugin");
        Integer r23 = (Integer) ZeusTransformUtils.preCheckCast(r3.f14671a, Integer.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L73:
        r13 = r22;
        long r110 = r21;
        r9 = r23;
    L75:
        r13.getTransportControls().seekTo(n.a(((long) r9.intValue()) * 1000, 0, r110));
        goto L98
    L18:
        o.a(r2);
        String r24 = r27.getValueType();
        r9 = r27.getTime();
        if (r24 == null) goto L101;
        r13 = com.obric.agent.intents.audio.a.f14676a.f();
        if (r13 == null) goto L99;
        PlaybackState r25 = r13.getPlaybackState();
        if (r25 == null) goto L25;
        r14 = r25.getPosition();
    L26:
        MediaMetadata r26 = r13.getMetadata();
        if (r26 == null) goto L29;
        long r30 = r26.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    L30:
        int r31 = r24.hashCode();
        boolean r111 = false;
        if (r31 == (-1880989509)) goto L77;
        if (r31 == (-1784218249)) goto L58;
        if (r31 == 40836773) goto L38;
    L78:
        ILogDepend.Companion.e(TAG, "Unknown valueType " + r24);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L38:
        if (r24.equals("FORWARD") == false) goto L78;
        PlaybackState r32 = r13.getPlaybackState();
        if (r32 != null) goto L43;
    L45:
        r11 = false;
    L46:
        if (r11 == true) goto L52;
        r13.getTransportControls().play();
        r3.f14671a = r9;
        r3.f14672b = r13;
        r3.f14673c = r14;
        r3.f14674d = r30;
        r3.g = 2;
        if (ax.a(100, r3) != r4) goto L50;
        return r4;
    L50:
        r18 = r9;
        r15 = r30;
        r17 = r13;
        r16 = r14;
        goto L51
    L52:
        r19 = r30;
        goto L53
    L43:
        if (r32.isActive() != true) goto L45;
    L58:
        if (r24.equals("ABSOLUTE") == false) goto L78;
        if (r9 != null) goto L63;
        ILogDepend.Companion.e(TAG, "valueType is ABSOLUTE, time must not be null");
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L63:
        PlaybackState r33 = r13.getPlaybackState();
        if (r33 != null) goto L66;
    L68:
        if (r111 == true) goto L74;
        r13.getTransportControls().play();
        r3.f14671a = r9;
        r3.f14672b = r13;
        r3.f14673c = r30;
        r3.g = 1;
        if (ax.a(100, r3) != r4) goto L72;
        return r4;
    L72:
        r23 = r9;
        r21 = r30;
        r22 = r13;
        goto L73
    L74:
        r110 = r30;
        goto L75
    L66:
        if (r33.isActive() != true) goto L68;
        r111 = true;
        goto L68
    L77:
        if (r24.equals("REWIND") == false) goto L78;
        PlaybackState r34 = r13.getPlaybackState();
        if (r34 != null) goto L83;
    L85:
        r11 = false;
    L86:
        if (r11 == true) goto L92;
        r13.getTransportControls().play();
        r3.f14671a = r9;
        r3.f14672b = r13;
        r3.f14673c = r14;
        r3.f14674d = r30;
        r3.g = 3;
        if (ax.a(100, r3) != r4) goto L90;
        return r4;
    L90:
        r8 = r9;
        r6 = r30;
        r0 = r13;
        r7 = r14;
        goto L91
    L92:
        r10 = r30;
        goto L93
    L83:
        if (r34.isActive() != true) goto L85;
    L29:
        r30 = 0;
        goto L30
    L25:
        r14 = 0;
        goto L26
    L99:
        SeekToIntent r35 = (SeekToIntent) ZeusTransformUtils.preCheckCast(this, SeekToIntent.class, "com.obric.aiagent.plugin");
        return new IntentResult(ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L101:
        ILogDepend.Companion.e(TAG, "valueType must no be null");
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L7:
        r3 = new b(this, r1);
        goto L8
    }
}
