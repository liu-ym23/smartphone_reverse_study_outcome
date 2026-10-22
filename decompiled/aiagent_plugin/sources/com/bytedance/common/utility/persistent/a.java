package com.bytedance.common.utility.persistent;

import android.content.SharedPreferences;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SharedPrefsEditorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f6744a = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.persistent.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SharedPrefsEditorCompat.java */
    static class C0151a implements b {
        C0151a() {
        }

        @Override // com.bytedance.common.utility.persistent.a.b
        public void a(SharedPreferences.Editor r2) {
            ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.aiagent.plugin")).commit();
        }
    }

    /* JADX INFO: compiled from: SharedPrefsEditorCompat.java */
    interface b {
        void a(SharedPreferences.Editor r1);
    }

    /* JADX INFO: compiled from: SharedPrefsEditorCompat.java */
    static class c implements b {
        c() {
        }

        @Override // com.bytedance.common.utility.persistent.a.b
        public void a(SharedPreferences.Editor r2) {
            ((SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.aiagent.plugin")).apply();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 9) goto L5;
        f6744a = new c();
        return;
    L5:
        f6744a = new C0151a();
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        f6744a.a(r3);
    }
}
