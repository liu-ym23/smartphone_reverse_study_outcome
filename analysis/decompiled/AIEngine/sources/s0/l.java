package s0;

import android.net.Uri;
import com.stepos.core.ability.speech.AsrCloudWsSession;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f11861a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11862b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11863c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11864d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11865e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11866f;

    @Deprecated
    public l(Uri uri, int i10, int i11, boolean z, int i12) {
        uri.getClass();
        this.f11861a = uri;
        this.f11862b = i10;
        this.f11863c = i11;
        this.f11864d = z;
        this.f11865e = null;
        this.f11866f = i12;
    }

    public l(String str, String str2) {
        this.f11861a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f11862b = 0;
        this.f11863c = AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS;
        this.f11864d = false;
        this.f11865e = str2;
        this.f11866f = 0;
    }
}
