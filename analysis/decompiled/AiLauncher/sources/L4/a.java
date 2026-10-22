package L4;

import com.autonavi.aps.amapapi.config.Const;
import com.zyql.ai.selector.config.PictureConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\n\u000eB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0011\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"LL4/a;", "", "", "width", "height", "<init>", "(FF)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "F", "getWidth", "()F", Const.INTENT_KEY_PKGNAME, "getHeight", "", "()Z", PictureConfig.EXTRA_CHANGE_ORIGINAL, "LL4/a$a;", "LL4/a$b;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final float width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final float height;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LL4/a$a;", "LL4/a;", "<init>", "()V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.a$a, reason: collision with other inner class name */
    public static final /* data */ class C0070a extends a {

        /* renamed from: c, reason: collision with root package name */
        public static final C0070a f4301c = new C0070a();

        public C0070a() {
            super(4.0f, 3.0f, null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof C0070a);
        }

        public int hashCode() {
            return 2029462098;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LL4/a$b;", "LL4/a;", "<init>", "()V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class b extends a {

        /* renamed from: c, reason: collision with root package name */
        public static final b f4302c = new b();

        public b() {
            super(2.0f, 1.0f, null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof b);
        }

        public int hashCode() {
            return -965687121;
        }
    }

    public /* synthetic */ a(float f10, float f11, kotlin.jvm.internal.i iVar) {
        this(f10, f11);
    }

    public final boolean a() {
        return kotlin.jvm.internal.p.d(this, C0070a.f4301c);
    }

    public final String toString() {
        if (kotlin.jvm.internal.p.d(this, C0070a.f4301c)) {
            return "AgentBackgroundRatio.ORIGINAL";
        }
        if (kotlin.jvm.internal.p.d(this, b.f4302c)) {
            return "AgentBackgroundRatio.RATIO_2_1";
        }
        throw new NoWhenBranchMatchedException();
    }

    public a(float f10, float f11) {
        this.width = f10;
        this.height = f11;
    }
}
