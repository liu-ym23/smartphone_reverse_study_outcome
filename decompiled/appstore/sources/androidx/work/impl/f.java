package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f5560c = null;

    static {
        f5560c = new f();
    }

    public f() {
        super(12, 13);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
        r10.execSQL("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
    }
}
