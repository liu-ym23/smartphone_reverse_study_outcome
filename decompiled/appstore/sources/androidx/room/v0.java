package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class v0 implements SupportSQLiteOpenHelper.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f4704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable f4705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f4706d;

    public v0(String r10, File r11, Callable r12, SupportSQLiteOpenHelper.Factory r13) {
        kotlin.jvm.internal.q.g(r13, "mDelegate");
        this.f4703a = r10;
        this.f4704b = r11;
        this.f4705c = r12;
        this.f4706d = r13;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.b r10) {
        kotlin.jvm.internal.q.g(r10, "configuration");
        return new u0(r10.f4782a, this.f4703a, this.f4704b, this.f4705c, r10.f4784c.f4780a, this.f4706d.create(r10));
    }
}
