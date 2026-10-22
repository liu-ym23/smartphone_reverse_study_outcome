package s7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.InterfaceC5677f;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\t\u000b\f\r\u0007B\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u0007\u0010\n\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Ls7/w;", "", "", "name", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, "e", "Ls7/w$a;", "Ls7/w$b;", "Ls7/w$c;", "Ls7/w$d;", "Ls7/w$e;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String label;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0007"}, d2 = {"Ls7/w$a;", "Ls7/w;", "", "c", "I", "()I", "defaultColor", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends w {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int defaultColor;

        /* renamed from: c, reason: from getter */
        public final int getDefaultColor() {
            return this.defaultColor;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0011"}, d2 = {"Ls7/w$b;", "Ls7/w;", "", "name", "", "default", "Lv9/f;", "range", "label", "<init>", "(Ljava/lang/String;FLv9/f;Ljava/lang/String;)V", "c", "F", "()F", Const.INTENT_KEY_UMID, "Lv9/f;", "()Lv9/f;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends w {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final float default;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5677f<Float> range;

        public /* synthetic */ b(String str, float f10, InterfaceC5677f interfaceC5677f, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? 0.0f : f10, (i10 & 4) != 0 ? null : interfaceC5677f, (i10 & 8) != 0 ? null : str2);
        }

        /* renamed from: c, reason: from getter */
        public final float getDefault() {
            return this.default;
        }

        public final InterfaceC5677f<Float> d() {
            return this.range;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String name, float f10, InterfaceC5677f<Float> interfaceC5677f, String str) {
            super(name, str, null);
            kotlin.jvm.internal.p.i(name, "name");
            this.default = f10;
            this.range = interfaceC5677f;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000b\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Ls7/w$c;", "Ls7/w;", "", "name", "", "defaultX", "defaultY", "label", "<init>", "(Ljava/lang/String;FFLjava/lang/String;)V", "c", "F", "()F", Const.INTENT_KEY_UMID, "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends w {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final float defaultX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final float defaultY;

        public /* synthetic */ c(String str, float f10, float f11, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? 0.0f : f10, (i10 & 4) != 0 ? 0.0f : f11, (i10 & 8) != 0 ? null : str2);
        }

        /* renamed from: c, reason: from getter */
        public final float getDefaultX() {
            return this.defaultX;
        }

        /* renamed from: d, reason: from getter */
        public final float getDefaultY() {
            return this.defaultY;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String name, float f10, float f11, String str) {
            super(name, str, null);
            kotlin.jvm.internal.p.i(name, "name");
            this.defaultX = f10;
            this.defaultY = f11;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Ls7/w$d;", "Ls7/w;", "", "name", "", "defaultX", "defaultY", "defaultZ", "label", "<init>", "(Ljava/lang/String;FFFLjava/lang/String;)V", "c", "F", "()F", Const.INTENT_KEY_UMID, "e", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends w {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final float defaultX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final float defaultY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final float defaultZ;

        public /* synthetic */ d(String str, float f10, float f11, float f12, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? 0.0f : f10, (i10 & 4) != 0 ? 0.0f : f11, (i10 & 8) != 0 ? 0.0f : f12, (i10 & 16) != 0 ? null : str2);
        }

        /* renamed from: c, reason: from getter */
        public final float getDefaultX() {
            return this.defaultX;
        }

        /* renamed from: d, reason: from getter */
        public final float getDefaultY() {
            return this.defaultY;
        }

        /* renamed from: e, reason: from getter */
        public final float getDefaultZ() {
            return this.defaultZ;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String name, float f10, float f11, float f12, String str) {
            super(name, str, null);
            kotlin.jvm.internal.p.i(name, "name");
            this.defaultX = f10;
            this.defaultY = f11;
            this.defaultZ = f12;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\f\u0010\u000f¨\u0006\u0012"}, d2 = {"Ls7/w$e;", "Ls7/w;", "", "name", "", "defaultX", "defaultY", "defaultZ", "defaultW", "label", "<init>", "(Ljava/lang/String;FFFFLjava/lang/String;)V", "c", "F", Const.INTENT_KEY_UMID, "()F", "e", "f", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends w {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final float defaultX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final float defaultY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final float defaultZ;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final float defaultW;

        public /* synthetic */ e(String str, float f10, float f11, float f12, float f13, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? 0.0f : f10, (i10 & 4) != 0 ? 0.0f : f11, (i10 & 8) != 0 ? 0.0f : f12, (i10 & 16) != 0 ? 0.0f : f13, (i10 & 32) != 0 ? null : str2);
        }

        /* renamed from: c, reason: from getter */
        public final float getDefaultW() {
            return this.defaultW;
        }

        /* renamed from: d, reason: from getter */
        public final float getDefaultX() {
            return this.defaultX;
        }

        /* renamed from: e, reason: from getter */
        public final float getDefaultY() {
            return this.defaultY;
        }

        /* renamed from: f, reason: from getter */
        public final float getDefaultZ() {
            return this.defaultZ;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String name, float f10, float f11, float f12, float f13, String str) {
            super(name, str, null);
            kotlin.jvm.internal.p.i(name, "name");
            this.defaultX = f10;
            this.defaultY = f11;
            this.defaultZ = f12;
            this.defaultW = f13;
        }
    }

    public /* synthetic */ w(String str, String str2, kotlin.jvm.internal.i iVar) {
        this(str, str2);
    }

    /* renamed from: a, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public w(String str, String str2) {
        this.name = str;
        this.label = str2;
    }
}
