package com.obric.audiocodecsdk.encoder;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncoderFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/audiocodecsdk/encoder/EncoderFactory;", "", "()V", "createEncoder", "Lcom/obric/audiocodecsdk/encoder/AudioEncoder;", "type", "Lcom/obric/audiocodecsdk/encoder/EncoderType;", "sampleRate", "", "channel", "bitrate", "bufferSize", "outputFilePath", "", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EncoderFactory {
    public static final EncoderFactory INSTANCE = null;

    /* JADX INFO: compiled from: EncoderFactory.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EncoderType.values().length];
            r0[EncoderType.WAV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[EncoderType.AAC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[EncoderType.MP3.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EncoderType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new EncoderFactory();
    }

    private EncoderFactory() {
    }

    @JvmStatic
    public static final AudioEncoder createEncoder(EncoderType r6, int r7, int r8, int r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r11, "outputFilePath");
        int r12 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r12 == 1) goto L16;
        if (r12 == 2) goto L19;
        if (r12 == 3) goto L18;
        if (r12 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return new Mp3Encoder(r7, r8, r9, r10, r11);
    L19:
        return new AacEncoder(r7, r8, r9, r10, r11);
    L16:
        return new WavEncoder(r7, r8, r9, r10, r11);
    }
}
