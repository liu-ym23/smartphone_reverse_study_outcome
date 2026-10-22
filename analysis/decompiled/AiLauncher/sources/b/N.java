package b;

import android.content.res.Resources;
import b.N;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0010B5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0014R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016¨\u0006\u0018"}, d2 = {"Lb/N;", "", "", "lightScrim", "darkScrim", "nightMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", "<init>", "(IIILp9/l;)V", "isDark", "c", "(Z)I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "getDarkScrim$activity_release", "()I", "Lp9/l;", "()Lp9/l;", "e", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class N {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int lightScrim;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int darkScrim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int nightMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Resources, Boolean> detectDarkMode;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lb/N$a;", "", "<init>", "()V", "", "lightScrim", "darkScrim", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", "Lb/N;", Const.INTENT_KEY_PKGNAME, "(IILp9/l;)Lb/N;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: b.N$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ N c(Companion companion, int i10, int i11, InterfaceC5074l interfaceC5074l, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                interfaceC5074l = new InterfaceC5074l() { // from class: b.M
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(N.Companion.d((Resources) obj2));
                    }
                };
            }
            return companion.b(i10, i11, interfaceC5074l);
        }

        public static final boolean d(Resources resources) {
            kotlin.jvm.internal.p.i(resources, "resources");
            return (resources.getConfiguration().uiMode & 48) == 32;
        }

        public final N b(int lightScrim, int darkScrim, InterfaceC5074l<? super Resources, Boolean> detectDarkMode) {
            kotlin.jvm.internal.p.i(detectDarkMode, "detectDarkMode");
            return new N(lightScrim, darkScrim, 0, detectDarkMode, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ N(int i10, int i11, int i12, InterfaceC5074l interfaceC5074l, kotlin.jvm.internal.i iVar) {
        this(i10, i11, i12, interfaceC5074l);
    }

    public final InterfaceC5074l<Resources, Boolean> a() {
        return this.detectDarkMode;
    }

    /* renamed from: b, reason: from getter */
    public final int getNightMode() {
        return this.nightMode;
    }

    public final int c(boolean isDark) {
        return isDark ? this.darkScrim : this.lightScrim;
    }

    public final int d(boolean isDark) {
        if (this.nightMode == 0) {
            return 0;
        }
        return isDark ? this.darkScrim : this.lightScrim;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public N(int i10, int i11, int i12, InterfaceC5074l<? super Resources, Boolean> interfaceC5074l) {
        this.lightScrim = i10;
        this.darkScrim = i11;
        this.nightMode = i12;
        this.detectDarkMode = interfaceC5074l;
    }
}
