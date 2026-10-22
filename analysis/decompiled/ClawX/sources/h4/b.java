package h4;

import androidx.emoji2.text.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends v4.e {

    /* renamed from: g, reason: collision with root package name */
    public static final r f3010g = new r("Before", 2);

    /* renamed from: h, reason: collision with root package name */
    public static final r f3011h = new r("State", 2);

    /* renamed from: i, reason: collision with root package name */
    public static final r f3012i = new r("After", 2);

    /* renamed from: j, reason: collision with root package name */
    public static final r f3013j = new r("Receive", 2);

    /* renamed from: k, reason: collision with root package name */
    public static final r f3014k = new r("Parse", 2);

    /* renamed from: l, reason: collision with root package name */
    public static final r f3015l = new r("Transform", 2);

    /* renamed from: m, reason: collision with root package name */
    public static final r f3016m = new r("State", 2);

    /* renamed from: n, reason: collision with root package name */
    public static final r f3017n = new r("After", 2);

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3018e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3019f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i8) {
        super(f3010g, f3011h, f3012i);
        this.f3018e = i8;
        switch (i8) {
            case 1:
                super(f3013j, f3014k, f3015l, f3016m, f3017n);
                this.f3019f = true;
                break;
            default:
                this.f3019f = true;
                break;
        }
    }

    @Override // v4.e
    public final boolean d() {
        switch (this.f3018e) {
        }
        return this.f3019f;
    }
}
