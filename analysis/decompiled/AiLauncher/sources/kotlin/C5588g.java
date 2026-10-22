package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import s7.v;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lu7/g;", "", "", "name", "Ls7/v;", "type", "", "component", "", UxipConstants.f30680s, "", "completeFired", "<init>", "(Ljava/lang/String;Ls7/v;IFZ)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ls7/v;", Const.INTENT_KEY_UMID, "()Ls7/v;", "I", "()I", "F", "e", "()F", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)V", "Z", "()Z", "f", "(Z)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: u7.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5588g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final v type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int component;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float value;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean completeFired;

    public C5588g(String name, v type, int i10, float f10, boolean z10) {
        p.i(name, "name");
        p.i(type, "type");
        this.name = name;
        this.type = type;
        this.component = i10;
        this.value = f10;
        this.completeFired = z10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCompleteFired() {
        return this.completeFired;
    }

    /* renamed from: b, reason: from getter */
    public final int getComponent() {
        return this.component;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final v getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final float getValue() {
        return this.value;
    }

    public final void f(boolean z10) {
        this.completeFired = z10;
    }

    public final void g(float f10) {
        this.value = f10;
    }

    public /* synthetic */ C5588g(String str, v vVar, int i10, float f10, boolean z10, int i11, i iVar) {
        this(str, vVar, (i11 & 4) != 0 ? -1 : i10, (i11 & 8) != 0 ? 0.0f : f10, (i11 & 16) != 0 ? false : z10);
    }
}
