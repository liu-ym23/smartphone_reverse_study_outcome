package com.bytedance.android.anniex.salamander;

import android.app.Activity;
import androidx.camera.video.AudioStats;
import com.bytedance.android.anniex.container.ui.j;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.salamander.anniex.AnnieXStatusFontMode;
import com.bytedance.salamander.anniex.f3;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f41064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f41065b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41066a = null;

        static {
            int[] r100 = new int[AnnieXStatusFontMode.values().length];
            r100[AnnieXStatusFontMode.LIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnnieXStatusFontMode.DARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnnieXStatusFontMode.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f41066a = r100;
        }
    }

    @Override // com.bytedance.salamander.anniex.f3
    public final double a() {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.salamander.anniex.f3
    public final double getContainerWidth() {
        return 300.0d;
    }

    @Override // com.bytedance.salamander.anniex.f3
    public final double l() {
        return 600.0d;
    }

    @Override // com.bytedance.salamander.anniex.h3
    public final double b() {
        List<String> r100 = i16.a.f487988a;
        j r101 = this.f41064a;
        Activity r102 = this.f41065b;
        r101.getClass();
        return i16.a.m(j.b(r102), this.f41065b);
    }

    @Override // com.bytedance.salamander.anniex.f3
    public final void close() {
        this.f41065b.finish();
    }

    public b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f41065b = r100;
        j r101 = new j(r100.getWindow());
        this.f41064a = r101;
        r101.d();
    }

    @Override // com.bytedance.salamander.anniex.h3
    public final void c(boolean r100) {
        this.f41064a.f(!r100);
    }

    @Override // com.bytedance.salamander.anniex.h3
    public final void d(AnnieXStatusFontMode r100) {
        Intrinsics.checkNotNullParameter(r100, "fontMode");
        j r101 = this.f41064a;
        int r102 = a.f41066a[r100.ordinal()];
        if (r102 != 1) goto L5;
        StatusFontMode r103 = StatusFontMode.LIGHT;
    L13:
        r101.c(r103);
        return;
    L5:
        if (r102 != 2) goto L7;
        r103 = StatusFontMode.DARK;
        goto L13
    L7:
        if (r102 != 3) goto L10;
        r103 = StatusFontMode.DEFAULT;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
