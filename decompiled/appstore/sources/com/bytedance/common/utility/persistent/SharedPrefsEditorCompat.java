package com.bytedance.common.utility.persistent;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public abstract class SharedPrefsEditorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EditorImpl f6863a = null;

    public interface EditorImpl {
        void apply(SharedPreferences.Editor r10);
    }

    public static class a implements EditorImpl {
        public a() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor r10) {
            r10.apply();
        }
    }

    static {
        f6863a = new a();
    }

    public static void a(SharedPreferences.Editor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f6863a.apply(r10);
    }
}
