package com.obric.aiagent.apm.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: AlogFileProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AlogFileProvider extends PluginContentProvider {
    public static final a Companion = null;
    public static final String GET_ALOG_FILES = "getALogFiles";
    private static final String TAG = "AlogFileProvider";

    /* JADX INFO: compiled from: AlogFileProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public AlogFileProvider() {
    }

    public Bundle call(String r4, String r5, Bundle r6) {
        o.e(r4, "method");
        ILogDepend.Companion.i(TAG, "call method: " + r4 + ", bundle: " + r6);
        if (o.a(r4, GET_ALOG_FILES) == true) goto L5;
        return null;
    L5:
        if (r6 == null) goto L7;
        long r0 = r6.getLong("start_time");
    L8:
        if (r6 == null) goto L10;
        long r7 = r6.getLong("end_time");
    L11:
        com.ss.android.agilelogger.a.c();
        if (r0 != 0) goto L14;
        return null;
    L14:
        if (r7 != 0) goto L16;
        return null;
    L16:
        if (r0 >= r7) goto L25;
        List<String> r3 = com.ss.android.agilelogger.a.a(r0, r7);
        o.a(r3);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L26;
        Bundle r8 = new Bundle();
        r8.putStringArrayList("alog_files_path", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")));
        return r8;
    L26:
        return null;
    L25:
        return null;
    L10:
        r7 = 0;
        goto L11
    L7:
        r0 = 0;
        goto L8
    }
}
