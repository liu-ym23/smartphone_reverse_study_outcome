package A;

import android.hardware.camera2.params.MeteringRectangle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.C5713t;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\u0080\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u009a\u0001\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b!\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b*\u00100R\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b%\u0010/\u001a\u0004\b1\u00100R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b2\u00100R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b#\u00105R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b(\u00104\u001a\u0004\b.\u00105R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b2\u00104\u001a\u0004\b3\u00105¨\u00066"}, d2 = {"LA/p;", "", "Lw/a;", "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "Lw/t;", "flashMode", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "", "aeLock", "afLock", "awbLock", "<init>", "(Lw/a;Lw/b;Lw/c;Lw/t;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/internal/i;)V", Const.INTENT_KEY_APIKEY, "(Lw/a;Lw/b;Lw/c;Lw/t;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)LA/p;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lw/a;", "c", "()Lw/a;", Const.INTENT_KEY_PKGNAME, "Lw/b;", "f", "()Lw/b;", "Lw/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lw/c;", Const.INTENT_KEY_UMID, "Lw/t;", "k", "()Lw/t;", "e", "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: A.p, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class State3A {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5695a aeMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5696b afMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5697c awbMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final C5713t flashMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<MeteringRectangle> aeRegions;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<MeteringRectangle> afRegions;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<MeteringRectangle> awbRegions;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final Boolean aeLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final Boolean afLock;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final Boolean awbLock;

    public /* synthetic */ State3A(C5695a c5695a, C5696b c5696b, C5697c c5697c, C5713t c5713t, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, kotlin.jvm.internal.i iVar) {
        this(c5695a, c5696b, c5697c, c5713t, list, list2, list3, bool, bool2, bool3);
    }

    public final State3A a(C5695a aeMode, C5696b afMode, C5697c awbMode, C5713t flashMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Boolean aeLock, Boolean afLock, Boolean awbLock) {
        return new State3A(aeMode, afMode, awbMode, flashMode, aeRegions, afRegions, awbRegions, aeLock, afLock, awbLock, null);
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getAeLock() {
        return this.aeLock;
    }

    /* renamed from: c, reason: from getter */
    public final C5695a getAeMode() {
        return this.aeMode;
    }

    public final List<MeteringRectangle> d() {
        return this.aeRegions;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getAfLock() {
        return this.afLock;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof State3A)) {
            return false;
        }
        State3A state3A = (State3A) other;
        return kotlin.jvm.internal.p.d(this.aeMode, state3A.aeMode) && kotlin.jvm.internal.p.d(this.afMode, state3A.afMode) && kotlin.jvm.internal.p.d(this.awbMode, state3A.awbMode) && kotlin.jvm.internal.p.d(this.flashMode, state3A.flashMode) && kotlin.jvm.internal.p.d(this.aeRegions, state3A.aeRegions) && kotlin.jvm.internal.p.d(this.afRegions, state3A.afRegions) && kotlin.jvm.internal.p.d(this.awbRegions, state3A.awbRegions) && kotlin.jvm.internal.p.d(this.aeLock, state3A.aeLock) && kotlin.jvm.internal.p.d(this.afLock, state3A.afLock) && kotlin.jvm.internal.p.d(this.awbLock, state3A.awbLock);
    }

    /* renamed from: f, reason: from getter */
    public final C5696b getAfMode() {
        return this.afMode;
    }

    public final List<MeteringRectangle> g() {
        return this.afRegions;
    }

    /* renamed from: h, reason: from getter */
    public final Boolean getAwbLock() {
        return this.awbLock;
    }

    public int hashCode() {
        C5695a c5695a = this.aeMode;
        int iH = (c5695a == null ? 0 : C5695a.h(c5695a.getValue())) * 31;
        C5696b c5696b = this.afMode;
        int iE = (iH + (c5696b == null ? 0 : C5696b.e(c5696b.getValue()))) * 31;
        C5697c c5697c = this.awbMode;
        int iE2 = (iE + (c5697c == null ? 0 : C5697c.e(c5697c.getValue()))) * 31;
        C5713t c5713t = this.flashMode;
        int iF = (iE2 + (c5713t == null ? 0 : C5713t.f(c5713t.getValue()))) * 31;
        List<MeteringRectangle> list = this.aeRegions;
        int iHashCode = (iF + (list == null ? 0 : list.hashCode())) * 31;
        List<MeteringRectangle> list2 = this.afRegions;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MeteringRectangle> list3 = this.awbRegions;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool = this.aeLock;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.afLock;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.awbLock;
        return iHashCode5 + (bool3 != null ? bool3.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final C5697c getAwbMode() {
        return this.awbMode;
    }

    public final List<MeteringRectangle> j() {
        return this.awbRegions;
    }

    /* renamed from: k, reason: from getter */
    public final C5713t getFlashMode() {
        return this.flashMode;
    }

    public String toString() {
        return "State3A(aeMode=" + this.aeMode + ", afMode=" + this.afMode + ", awbMode=" + this.awbMode + ", flashMode=" + this.flashMode + ", aeRegions=" + this.aeRegions + ", afRegions=" + this.afRegions + ", awbRegions=" + this.awbRegions + ", aeLock=" + this.aeLock + ", afLock=" + this.afLock + ", awbLock=" + this.awbLock + ')';
    }

    public State3A(C5695a c5695a, C5696b c5696b, C5697c c5697c, C5713t c5713t, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, Boolean bool, Boolean bool2, Boolean bool3) {
        this.aeMode = c5695a;
        this.afMode = c5696b;
        this.awbMode = c5697c;
        this.flashMode = c5713t;
        this.aeRegions = list;
        this.afRegions = list2;
        this.awbRegions = list3;
        this.aeLock = bool;
        this.afLock = bool2;
        this.awbLock = bool3;
    }

    public /* synthetic */ State3A(C5695a c5695a, C5696b c5696b, C5697c c5697c, C5713t c5713t, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : c5695a, (i10 & 2) != 0 ? null : c5696b, (i10 & 4) != 0 ? null : c5697c, (i10 & 8) != 0 ? null : c5713t, (i10 & 16) != 0 ? null : list, (i10 & 32) != 0 ? null : list2, (i10 & 64) != 0 ? null : list3, (i10 & 128) != 0 ? null : bool, (i10 & 256) != 0 ? null : bool2, (i10 & 512) != 0 ? null : bool3, null);
    }
}
