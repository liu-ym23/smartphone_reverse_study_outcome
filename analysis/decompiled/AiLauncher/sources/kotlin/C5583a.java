package kotlin;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s7.AnimationDefinition;
import s7.TrackDefinition;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R&\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017¨\u0006\u0019"}, d2 = {"Lu7/a;", "", "<init>", "()V", "", "name", "", "component", "Lkotlin/Function1;", "Lu7/e;", "LY8/t;", "block", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ILp9/l;)V", "Ls7/a;", Const.INTENT_KEY_APIKEY, "()Ls7/a;", "", "Ls7/u;", "Ljava/util/List;", "tracks", "", "Lkotlin/Function0;", "Ljava/util/Map;", "completionActions", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: u7.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5583a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<TrackDefinition> tracks = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, InterfaceC5063a<t>> completionActions = new LinkedHashMap();

    public static /* synthetic */ void c(C5583a c5583a, String str, int i10, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        c5583a.b(str, i10, interfaceC5074l);
    }

    public final AnimationDefinition a() {
        return new AnimationDefinition(this.tracks, this.completionActions);
    }

    public final void b(String name, int component, InterfaceC5074l<? super C5586e, t> block) {
        p.i(name, "name");
        p.i(block, "block");
        List<TrackDefinition> list = this.tracks;
        C5586e c5586e = new C5586e(name, component);
        block.invoke(c5586e);
        list.add(c5586e.a());
    }
}
