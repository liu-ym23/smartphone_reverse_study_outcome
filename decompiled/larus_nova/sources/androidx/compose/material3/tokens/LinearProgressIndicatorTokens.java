package androidx.compose.material3.tokens;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/tokens/LinearProgressIndicatorTokens;", "", "<init>", "()V", "ActiveThickness", "Landroidx/compose/ui/unit/Dp;", "getActiveThickness-D9Ej5fM", "()F", FaceService.girlLabel, "ActiveWaveAmplitude", "getActiveWaveAmplitude-D9Ej5fM", "ActiveWaveWavelength", "getActiveWaveWavelength-D9Ej5fM", "Height", "getHeight-D9Ej5fM", "IndeterminateActiveWaveWavelength", "getIndeterminateActiveWaveWavelength-D9Ej5fM", "StopSize", "getStopSize-D9Ej5fM", "StopTrailingSpace", "getStopTrailingSpace-D9Ej5fM", "TrackActiveSpace", "getTrackActiveSpace-D9Ej5fM", "TrackThickness", "getTrackThickness-D9Ej5fM", "WaveHeight", "getWaveHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LinearProgressIndicatorTokens {
    public static final int $stable = 0;
    private static final float ActiveThickness = 0.0f;
    private static final float ActiveWaveAmplitude = 0.0f;
    private static final float ActiveWaveWavelength = 0.0f;
    private static final float Height = 0.0f;
    public static final LinearProgressIndicatorTokens INSTANCE = null;
    private static final float IndeterminateActiveWaveWavelength = 0.0f;
    private static final float StopSize = 0.0f;
    private static final float StopTrailingSpace = 0.0f;
    private static final float TrackActiveSpace = 0.0f;
    private static final float TrackThickness = 0.0f;
    private static final float WaveHeight = 0.0f;

    private LinearProgressIndicatorTokens() {
    }

    static {
        INSTANCE = new LinearProgressIndicatorTokens();
        float r100 = (float) 4.0d;
        ActiveThickness = Dp.m7544constructorimpl(r100);
        ActiveWaveAmplitude = Dp.m7544constructorimpl((float) 3.0d);
        ActiveWaveWavelength = Dp.m7544constructorimpl((float) 40.0d);
        Height = Dp.m7544constructorimpl(r100);
        IndeterminateActiveWaveWavelength = Dp.m7544constructorimpl((float) 20.0d);
        StopSize = Dp.m7544constructorimpl(r100);
        StopTrailingSpace = Dp.m7544constructorimpl((float) AudioStats.AUDIO_AMPLITUDE_NONE);
        TrackActiveSpace = Dp.m7544constructorimpl(r100);
        TrackThickness = Dp.m7544constructorimpl(r100);
        WaveHeight = Dp.m7544constructorimpl((float) 10.0d);
    }

    /* JADX INFO: renamed from: getActiveThickness-D9Ej5fM, reason: not valid java name */
    public final float m3632getActiveThicknessD9Ej5fM() {
        return ActiveThickness;
    }

    /* JADX INFO: renamed from: getActiveWaveAmplitude-D9Ej5fM, reason: not valid java name */
    public final float m3633getActiveWaveAmplitudeD9Ej5fM() {
        return ActiveWaveAmplitude;
    }

    /* JADX INFO: renamed from: getActiveWaveWavelength-D9Ej5fM, reason: not valid java name */
    public final float m3634getActiveWaveWavelengthD9Ej5fM() {
        return ActiveWaveWavelength;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3635getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIndeterminateActiveWaveWavelength-D9Ej5fM, reason: not valid java name */
    public final float m3636getIndeterminateActiveWaveWavelengthD9Ej5fM() {
        return IndeterminateActiveWaveWavelength;
    }

    /* JADX INFO: renamed from: getStopSize-D9Ej5fM, reason: not valid java name */
    public final float m3637getStopSizeD9Ej5fM() {
        return StopSize;
    }

    /* JADX INFO: renamed from: getStopTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3638getStopTrailingSpaceD9Ej5fM() {
        return StopTrailingSpace;
    }

    /* JADX INFO: renamed from: getTrackActiveSpace-D9Ej5fM, reason: not valid java name */
    public final float m3639getTrackActiveSpaceD9Ej5fM() {
        return TrackActiveSpace;
    }

    /* JADX INFO: renamed from: getTrackThickness-D9Ej5fM, reason: not valid java name */
    public final float m3640getTrackThicknessD9Ej5fM() {
        return TrackThickness;
    }

    /* JADX INFO: renamed from: getWaveHeight-D9Ej5fM, reason: not valid java name */
    public final float m3641getWaveHeightD9Ej5fM() {
        return WaveHeight;
    }
}
