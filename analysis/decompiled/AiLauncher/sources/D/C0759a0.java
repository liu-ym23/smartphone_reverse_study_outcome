package D;

import Z8.C1173v;
import androidx.camera.core.UseCase;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"LD/a0;", "LD/o0;", "", "Landroidx/camera/core/UseCase;", "useCases", "LD/E0;", "viewPort", "LD/i;", "effects", "<init>", "(Ljava/util/List;LD/E0;Ljava/util/List;)V", "", "l", "Z", "p", "()Z", "isLegacy", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "requireNonEmptyUseCases", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: D.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0759a0 extends o0 {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final boolean isLegacy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final boolean requireNonEmptyUseCases;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0759a0(List<? extends UseCase> useCases, E0 e02, List<? extends AbstractC0772i> effects) {
        super(useCases, e02, effects, null, null, null, 56, null);
        kotlin.jvm.internal.p.i(useCases, "useCases");
        kotlin.jvm.internal.p.i(effects, "effects");
        this.isLegacy = true;
    }

    @Override // D.o0
    /* renamed from: i, reason: from getter */
    public boolean getRequireNonEmptyUseCases() {
        return this.requireNonEmptyUseCases;
    }

    @Override // D.o0
    /* renamed from: p, reason: from getter */
    public boolean getIsLegacy() {
        return this.isLegacy;
    }

    public /* synthetic */ C0759a0(List list, E0 e02, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this(list, (i10 & 2) != 0 ? null : e02, (i10 & 4) != 0 ? C1173v.m() : list2);
    }
}
