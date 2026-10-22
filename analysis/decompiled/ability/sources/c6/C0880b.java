package c6;

import com.stepos.taskrobot.logger.LogAdapter;
import l6.C1662a;

/* renamed from: c6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0880b implements LogAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final C1662a f2091a;

    public C0880b(C1662a c1662a) {
        this.f2091a = c1662a;
    }

    @Override // com.stepos.taskrobot.logger.LogAdapter
    public final boolean isLoggable(int i, String str) {
        return true;
    }

    @Override // com.stepos.taskrobot.logger.LogAdapter
    public final void log(int i, String str, String str2) {
        this.f2091a.log(i, str, str2);
    }
}
