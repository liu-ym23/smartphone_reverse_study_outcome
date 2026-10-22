package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0004\u001a'\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u000f\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"", "x", "c", Const.INTENT_KEY_UMID, "(FFF)F", "visualPull", "Lcom/stepos/ailauncher/sheet/W;", "config", Const.INTENT_KEY_PKGNAME, "(FLcom/stepos/ailauncher/sheet/W;)F", "rawPull", "rawVelocity", "Lcom/stepos/ailauncher/sheet/Y;", Const.INTENT_KEY_APIKEY, "(FFLcom/stepos/ailauncher/sheet/W;)Lcom/stepos/ailauncher/sheet/Y;", "RUBBER_BAND_COEFFICIENT", "F", "RUBBER_BAND_DIMENSION_PX", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X {
    public static final float RUBBER_BAND_COEFFICIENT = 0.85f;
    public static final float RUBBER_BAND_DIMENSION_PX = 2466.0f;

    public static final RubberBandState a(float f10, float f11, RubberBandConfig config) {
        kotlin.jvm.internal.p.i(config, "config");
        float fMax = Math.max(0.0f, f10);
        float startA = config.getStartA();
        float commitB = config.getCommitB();
        float coefficient = config.getCoefficient();
        float dimension = config.getDimension();
        if (fMax <= startA) {
            return new RubberBandState(fMax, config.getWidthA(), 0.0f, f11, 0.0f, false);
        }
        float fC = c(commitB - startA, coefficient, dimension);
        float fMin = Math.min(fMax, commitB) - startA;
        float fC2 = c(fMin, coefficient, dimension);
        float fM = C5685n.m(fC2 / fC, 0.0f, 1.0f);
        float fD = d(fMin, coefficient, dimension) * f11;
        return new RubberBandState(startA + fC2, config.getWidthA() + ((config.getWidthB() - config.getWidthA()) * fM), fM, fD, (config.getWidthB() - config.getWidthA()) * (fD / fC), fMax >= commitB);
    }

    public static final float b(float f10, RubberBandConfig config) {
        kotlin.jvm.internal.p.i(config, "config");
        float startA = config.getStartA();
        float fMax = Math.max(0.0f, f10);
        if (fMax <= startA) {
            return fMax;
        }
        float f11 = fMax - startA;
        float coefficient = config.getCoefficient();
        float dimension = config.getDimension();
        return f11 >= dimension ? config.getCommitB() : C5685n.i(startA + ((f11 * dimension) / (coefficient * (dimension - f11))), config.getCommitB());
    }

    public static final float c(float f10, float f11, float f12) {
        float fMax = Math.max(0.0f, f10) * f11;
        return (fMax * f12) / (f12 + fMax);
    }

    public static final float d(float f10, float f11, float f12) {
        float fMax = ((Math.max(0.0f, f10) * f11) / f12) + 1.0f;
        return f11 / (fMax * fMax);
    }
}
