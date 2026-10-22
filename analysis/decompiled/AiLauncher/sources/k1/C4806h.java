package k1;

import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import j1.InterfaceC4757d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lk1/h;", "Lj1/d$c;", "<init>", "()V", "Lj1/d$b;", "configuration", "Lj1/d;", "create", "(Lj1/d$b;)Lj1/d;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: k1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4806h implements InterfaceC4757d.c {
    @Override // j1.InterfaceC4757d.c
    public InterfaceC4757d create(InterfaceC4757d.b configuration) {
        p.i(configuration, "configuration");
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory, configuration.allowDataLossOnRecovery);
    }
}
