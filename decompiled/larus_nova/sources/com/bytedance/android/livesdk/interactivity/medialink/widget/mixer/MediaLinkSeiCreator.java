package com.bytedance.android.livesdk.interactivity.medialink.widget.mixer;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.pd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import ti6.f;

/* JADX INFO: loaded from: classes9.dex */
public final class MediaLinkSeiCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f138541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f138542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<f> f138543c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegionComparePolicy {
    }

    public interface a {
        boolean a(f r100, f r101);
    }

    public static class b implements a {
        public b() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.MediaLinkSeiCreator.a
        public final boolean a(f r100, f r101) {
            if (r100 == null) goto L24;
            if (r101 != null) goto L7;
            return false;
        L7:
            if (TextUtils.equals(r100.f546160b, r101.f546160b) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(r100.f546161c, r101.f546161c) == true) goto L11;
            return false;
        L11:
            if (r100.f546162d == r101.f546162d) goto L13;
            return false;
        L13:
            if (r100.f546163e == r101.f546163e) goto L15;
            return false;
        L15:
            if (r100.f546164f == r101.f546164f) goto L17;
            return false;
        L17:
            if (r100.f546165g == r101.f546165g) goto L19;
            return false;
        L19:
            if (r100.f546167i == r101.f546167i) goto L21;
            return false;
        L21:
            if (r100.f546171m != r101.f546171m) goto L32;
            return true;
        L32:
            return false;
        L24:
            return false;
        }
    }

    static {
        pd1.f120971a.getValue().floatValue();
    }

    public MediaLinkSeiCreator() {
        this.f138542b = 0;
        this.f138543c = new ArrayList();
        this.f138541a = new b();
    }
}
