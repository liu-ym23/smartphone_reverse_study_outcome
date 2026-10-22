package com.stepos.ailauncher.speech.asr;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/g;", "", "", "sampleRate", "windowMs", "", "targetRms", "maxGain", "noiseRms", "loudPeak", "peakLimit", "<init>", "(IIFFFII)V", "", "frame", Const.INTENT_KEY_UMID, "([B)[B", "I", "F", "", "samplesProcessed", "J", UxipConstants.f30680s, "lastRms", "c", "()F", "lastPeak", Const.INTENT_KEY_PKGNAME, "()I", "lastGain", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    private float lastGain;
    private int lastPeak;
    private float lastRms;
    private final int loudPeak;
    private final float maxGain;
    private final float noiseRms;
    private final int peakLimit;
    private final int sampleRate;
    private long samplesProcessed;
    private final float targetRms;
    private final int windowMs;

    public g(int i10, int i11, float f10, float f11, float f12, int i12, int i13) {
        this.sampleRate = i10;
        this.windowMs = i11;
        this.targetRms = f10;
        this.maxGain = f11;
        this.noiseRms = f12;
        this.loudPeak = i12;
        this.peakLimit = i13;
        this.lastGain = 1.0f;
    }

    /* renamed from: a, reason: from getter */
    public final float getLastGain() {
        return this.lastGain;
    }

    /* renamed from: b, reason: from getter */
    public final int getLastPeak() {
        return this.lastPeak;
    }

    /* renamed from: c, reason: from getter */
    public final float getLastRms() {
        return this.lastRms;
    }

    public final byte[] d(byte[] frame) {
        p.i(frame, "frame");
        int length = frame.length / 2;
        if (length > 0) {
            int i10 = 0;
            double d10 = 0.0d;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = i11 + 1;
                if (i13 >= frame.length) {
                    break;
                }
                short s10 = (short) (((frame[i13] & 255) << 8) | (frame[i11] & 255));
                int i14 = s10 < 0 ? -s10 : s10;
                if (i14 > i12) {
                    i12 = i14;
                }
                double d11 = s10;
                d10 += d11 * d11;
                i11 += 2;
            }
            double dSqrt = Math.sqrt(d10 / length);
            float f10 = (float) dSqrt;
            this.lastRms = f10;
            this.lastPeak = i12;
            this.lastGain = 1.0f;
            if (dSqrt >= this.noiseRms) {
                long j10 = this.samplesProcessed;
                long j11 = (1000 * j10) / this.sampleRate;
                int i15 = this.windowMs;
                if (j11 >= i15) {
                    this.samplesProcessed = j10 + length;
                    return frame;
                }
                this.samplesProcessed = j10 + length;
                if (i12 < this.loudPeak) {
                    float fM = ((C5685n.m(this.targetRms / f10, 1.0f, this.maxGain) - 1.0f) * (1.0f - C5685n.m(j11 / i15, 0.0f, 1.0f))) + 1.0f;
                    if (fM > 1.01f) {
                        float f11 = this.peakLimit / C5685n.f(i12, 1);
                        if (fM > f11) {
                            fM = f11;
                        }
                        if (fM > 1.01f) {
                            this.lastGain = fM;
                            byte[] bArr = new byte[frame.length];
                            while (true) {
                                int i16 = i10 + 1;
                                if (i16 >= frame.length) {
                                    return bArr;
                                }
                                int iN = C5685n.n((int) (((short) ((frame[i10] & 255) | ((frame[i16] & 255) << 8))) * fM), -32768, 32767);
                                bArr[i10] = (byte) (iN & 255);
                                bArr[i16] = (byte) (iN >> 8);
                                i10 += 2;
                            }
                        }
                    }
                }
            }
        }
        return frame;
    }

    public /* synthetic */ g(int i10, int i11, float f10, float f11, float f12, int i12, int i13, int i14, i iVar) {
        this((i14 & 1) != 0 ? 16000 : i10, (i14 & 2) != 0 ? 1500 : i11, (i14 & 4) != 0 ? 1000.0f : f10, (i14 & 8) != 0 ? 12.0f : f11, (i14 & 16) != 0 ? 80.0f : f12, (i14 & 32) != 0 ? 8000 : i12, (i14 & 64) != 0 ? 28000 : i13);
    }
}
