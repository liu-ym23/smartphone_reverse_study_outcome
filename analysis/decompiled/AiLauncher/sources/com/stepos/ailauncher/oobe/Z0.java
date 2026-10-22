package com.stepos.ailauncher.oobe;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\t\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/oobe/Z0;", "", "", "pageCount", "<init>", "(I)V", "position", "LY8/t;", "c", "", Const.INTENT_KEY_PKGNAME, "(I)Z", Const.INTENT_KEY_UMID, "", RobotInfo.STATUS_STARTED, "[Z", UxipConstants.f30680s, "selectedPage", "I", Const.INTENT_KEY_APIKEY, "()I", "Companion", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float DURATION_MS = 2000.0f;
    private int selectedPage;
    private final boolean[] started;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/oobe/Z0$a;", "", "<init>", "()V", "", "sourceDurationMs", Const.INTENT_KEY_APIKEY, "(F)F", "DURATION_MS", "F", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.oobe.Z0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final float a(float sourceDurationMs) {
            return sourceDurationMs / 2000.0f;
        }

        public Companion() {
        }
    }

    public Z0(int i10) {
        this.started = new boolean[i10];
    }

    /* renamed from: a, reason: from getter */
    public final int getSelectedPage() {
        return this.selectedPage;
    }

    public final boolean b(int position) {
        return kotlin.jvm.internal.p.d(Z8.r.g0(this.started, position), Boolean.TRUE);
    }

    public final void c(int position) {
        this.selectedPage = position;
    }

    public final boolean d(int position) {
        if (position < 0) {
            return false;
        }
        boolean[] zArr = this.started;
        if (position >= zArr.length || position != this.selectedPage || zArr[position]) {
            return false;
        }
        zArr[position] = true;
        return true;
    }
}
