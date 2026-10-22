package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import io.reactivex.functions.Action;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f142192a = null;

    public static final class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f142193a = null;

        static {
            f142193a = new a();
        }

        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            long r101 = System.currentTimeMillis() - r100.lastModified();
            if (StringsKt.startsWith$default(r100.getName(), "/vip_broadcast", false, 2, null) == true) goto L5;
            return false;
        L5:
            if (r101 <= TimeUnit.DAYS.toMillis(2)) goto L9;
            return true;
        L9:
            return false;
        }
    }

    static {
        f142192a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        File r100 = (File) AudioRecordHelper.f142188f.getValue();
        int r101 = 0;
        if (r100.exists() == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L20;
        File[] r103 = r100.listFiles(a.f142193a);
        if (r103 == null) goto L24;
        int r104 = r103.length;
    L15:
        if (r101 >= r104) goto L25;
        File r105 = r103[r101];
        if (r105.isFile() == false) goto L19;
        r105.delete();
    L19:
        r101 = r101 + 1;
        goto L15
    L25:
        return;
    L24:
        return;
    L20:
        return;
    L5:
        if (r100.isDirectory() == false) goto L7;
        r102 = true;
        goto L8
    }
}
