package j6;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0018"}, d2 = {"Lj6/a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "fftSize", "I", "", "fftReal", "[F", "fftImag", "window", "Lorg/apache/commons/math3/transform/FastFourierTransformer;", "fftTransformer", "Lorg/apache/commons/math3/transform/FastFourierTransformer;", "bandEnergies", "smoothedEnergies", "", "attackFactor", "F", "releaseFactor", "Companion", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: j6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4771a {
    public static final int FREQUENCY_BANDS = 24;
    public static final int SAMPLE_RATE = 44100;
    private final int fftSize = 1024;
    private final float[] fftReal = new float[1024];
    private final float[] fftImag = new float[1024];
    private final float[] window = new float[1024];
    private final FastFourierTransformer fftTransformer = new FastFourierTransformer(DftNormalization.STANDARD);
    private final float[] bandEnergies = new float[24];
    private final float[] smoothedEnergies = new float[24];
    private float attackFactor = 0.8f;
    private float releaseFactor = 0.1f;

    public C4771a() {
        a();
    }

    public final void a() {
        int i10 = this.fftSize;
        for (int i11 = 0; i11 < i10; i11++) {
            this.window[i11] = ((float) (1.0f - Math.cos((i11 * 6.283185307179586d) / (this.fftSize - 1)))) * 0.5f;
        }
    }
}
