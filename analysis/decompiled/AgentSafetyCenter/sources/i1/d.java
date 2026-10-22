package i1;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5625a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5626b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5627c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5628d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5629e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5630f;

    /* renamed from: g, reason: collision with root package name */
    public final float f5631g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5632h;
    public final List i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f5633j;

    public d(String str, float f5, float f10, float f11, float f12, float f13, float f14, float f15, List list, int i) {
        str = (i & 1) != 0 ? "" : str;
        f5 = (i & 2) != 0 ? 0.0f : f5;
        f10 = (i & 4) != 0 ? 0.0f : f10;
        f11 = (i & 8) != 0 ? 0.0f : f11;
        f12 = (i & 16) != 0 ? 1.0f : f12;
        f13 = (i & 32) != 0 ? 1.0f : f13;
        f14 = (i & 64) != 0 ? 0.0f : f14;
        f15 = (i & 128) != 0 ? 0.0f : f15;
        if ((i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0) {
            int i3 = h0.f5700a;
            list = kb.s.f7404c;
        }
        ArrayList arrayList = new ArrayList();
        this.f5625a = str;
        this.f5626b = f5;
        this.f5627c = f10;
        this.f5628d = f11;
        this.f5629e = f12;
        this.f5630f = f13;
        this.f5631g = f14;
        this.f5632h = f15;
        this.i = list;
        this.f5633j = arrayList;
    }
}
