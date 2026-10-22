package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/tokens/CircularProgressIndicatorTokens;", "", "<init>", "()V", "ActiveThickness", "Landroidx/compose/ui/unit/Dp;", "getActiveThickness-D9Ej5fM", "()F", FaceService.girlLabel, "ActiveWaveAmplitude", "getActiveWaveAmplitude-D9Ej5fM", "ActiveWaveWavelength", "getActiveWaveWavelength-D9Ej5fM", "Size", "getSize-D9Ej5fM", "TrackActiveSpace", "getTrackActiveSpace-D9Ej5fM", "TrackThickness", "getTrackThickness-D9Ej5fM", "WaveSize", "getWaveSize-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CircularProgressIndicatorTokens {
    public static final int $stable = 0;
    private static final float ActiveThickness = 0.0f;
    private static final float ActiveWaveAmplitude = 0.0f;
    private static final float ActiveWaveWavelength = 0.0f;
    public static final CircularProgressIndicatorTokens INSTANCE = null;
    private static final float Size = 0.0f;
    private static final float TrackActiveSpace = 0.0f;
    private static final float TrackThickness = 0.0f;
    private static final float WaveSize = 0.0f;

    private CircularProgressIndicatorTokens() {
    }

    static {
        INSTANCE = new CircularProgressIndicatorTokens();
        float r100 = (float) 4.0d;
        ActiveThickness = Dp.m7544constructorimpl(r100);
        ActiveWaveAmplitude = Dp.m7544constructorimpl((float) 1.6d);
        ActiveWaveWavelength = Dp.m7544constructorimpl((float) 15.0d);
        Size = Dp.m7544constructorimpl((float) 40.0d);
        TrackActiveSpace = Dp.m7544constructorimpl(r100);
        TrackThickness = Dp.m7544constructorimpl(r100);
        WaveSize = Dp.m7544constructorimpl((float) 48.0d);
    }

    /* JADX INFO: renamed from: getActiveThickness-D9Ej5fM, reason: not valid java name */
    public final float m3341getActiveThicknessD9Ej5fM() {
        return ActiveThickness;
    }

    /* JADX INFO: renamed from: getActiveWaveAmplitude-D9Ej5fM, reason: not valid java name */
    public final float m3342getActiveWaveAmplitudeD9Ej5fM() {
        return ActiveWaveAmplitude;
    }

    /* JADX INFO: renamed from: getActiveWaveWavelength-D9Ej5fM, reason: not valid java name */
    public final float m3343getActiveWaveWavelengthD9Ej5fM() {
        return ActiveWaveWavelength;
    }

    /* JADX INFO: renamed from: getSize-D9Ej5fM, reason: not valid java name */
    public final float m3344getSizeD9Ej5fM() {
        return Size;
    }

    /* JADX INFO: renamed from: getTrackActiveSpace-D9Ej5fM, reason: not valid java name */
    public final float m3345getTrackActiveSpaceD9Ej5fM() {
        return TrackActiveSpace;
    }

    /* JADX INFO: renamed from: getTrackThickness-D9Ej5fM, reason: not valid java name */
    public final float m3346getTrackThicknessD9Ej5fM() {
        return TrackThickness;
    }

    /* JADX INFO: renamed from: getWaveSize-D9Ej5fM, reason: not valid java name */
    public final float m3347getWaveSizeD9Ej5fM() {
        return WaveSize;
    }
}
