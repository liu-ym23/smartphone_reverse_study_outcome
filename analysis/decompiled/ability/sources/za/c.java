package za;

import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f7000a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final long g;
    public final String h;
    public final Map i;

    public c(int i, int i6, int i10, int i11, int i12, float f, long j5, String str, Map map) {
        this.f7000a = i;
        this.b = i6;
        this.c = i10;
        this.d = i11;
        this.e = i12;
        this.f = f;
        this.g = j5;
        this.h = str;
        this.i = map;
    }

    public static c a(c cVar, int i, int i6, int i10, int i11, int i12, float f, long j5, int i13) {
        if ((i13 & 1) != 0) {
            i = cVar.f7000a;
        }
        int i14 = i;
        int i15 = (i13 & 4) != 0 ? cVar.c : i10;
        int i16 = (i13 & 8) != 0 ? cVar.d : i11;
        int i17 = (i13 & 16) != 0 ? cVar.e : i12;
        float f7 = (i13 & 32) != 0 ? cVar.f : f;
        cVar.getClass();
        long j6 = (i13 & 128) != 0 ? cVar.g : j5;
        String currentStepDescription = cVar.h;
        Map metadata = cVar.i;
        cVar.getClass();
        k.f(currentStepDescription, "currentStepDescription");
        k.f(metadata, "metadata");
        return new c(i14, i6, i15, i16, i17, f7, j6, currentStepDescription, metadata);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7000a == cVar.f7000a && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && Float.compare(this.f, cVar.f) == 0 && this.g == cVar.g && k.b(this.h, cVar.h) && k.b(this.i, cVar.i);
    }

    public final int hashCode() {
        return this.i.hashCode() + B7.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.b(this.f, androidx.constraintlayout.core.dsl.a.a(this.e, androidx.constraintlayout.core.dsl.a.a(this.d, androidx.constraintlayout.core.dsl.a.a(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f7000a) * 31, 31), 31), 31), 31), 31), 31, 0L), 31, this.g), 31, this.h);
    }

    public final String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f7000a, "ExecutionProgress(currentStepIndex=", this.b, ", totalSteps=", ", completedSteps=");
        androidx.constraintlayout.core.dsl.a.y(sbS, this.c, ", failedSteps=", this.d, ", skippedSteps=");
        sbS.append(this.e);
        sbS.append(", percentage=");
        sbS.append(this.f);
        sbS.append(", estimatedRemainingTime=0, elapsedTime=");
        sbS.append(this.g);
        sbS.append(", currentStepDescription=");
        sbS.append(this.h);
        sbS.append(", metadata=");
        sbS.append(this.i);
        sbS.append(")");
        return sbS.toString();
    }

    public /* synthetic */ c(int i, int i6, int i10, int i11, long j5) {
        this((i11 & 1) != 0 ? 0 : i, (i11 & 2) != 0 ? 0 : i6, (i11 & 4) != 0 ? 0 : i10, 0, 0, (i11 & 32) != 0 ? 0.0f : 100.0f, (i11 & 128) != 0 ? 0L : j5, "", kotlin.collections.a.M());
    }
}
