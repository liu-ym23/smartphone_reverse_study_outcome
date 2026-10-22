package com.bytedance.ai.applet.base.gson;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonParseException;
import com.google.gson.ToNumberStrategy;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34516a = null;

    public static final class a implements ToNumberStrategy {
        public a() {
        }

        @Override // com.google.gson.ToNumberStrategy
        public final Number readNumber(JsonReader r110) {
            Intrinsics.checkNotNullParameter(r110, "reader");
            String r100 = r110.nextString();
            Intrinsics.checkNotNull(r100);     // Catch: NumberFormatException -> L5
            return Long.valueOf(CastLongProtector.parseLong(r100));
        L5:
            Intrinsics.checkNotNull(r100);
            double r101 = CastDoubleProtector.parseDouble(r100);     // Catch: NumberFormatException -> L22
            if (Double.isInfinite(r101) == true) goto L11;
            if (Double.isNaN(r101) == true) goto L11;
        L12:
            boolean r102 = true;
            if ((r101 % ((double) 1)) == AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
            r102 = false;
        L16:
            if (r102 == false) goto L19;
            return Long.valueOf((long) r101);
        L19:
            return Double.valueOf(r101);
        L11:
            if (r110.isLenient() == true) goto L12;
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + r101 + "; at path " + r110.getPreviousPath());     // Catch: NumberFormatException -> L22
        L22:
            e = move-exception;
            throw new JsonParseException("Cannot parse " + r100 + "; at path " + r110.getPreviousPath(), e);
        }
    }

    static {
        f34516a = new a();
    }
}
