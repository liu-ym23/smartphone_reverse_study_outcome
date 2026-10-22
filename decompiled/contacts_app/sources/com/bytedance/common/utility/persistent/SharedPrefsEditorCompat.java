package com.bytedance.common.utility.persistent;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class SharedPrefsEditorCompat {
    static final EditorImpl IMPL = null;

    static class BaseEditorImpl implements EditorImpl {
        BaseEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor r1) {
            r1.commit();
        }
    }

    interface EditorImpl {
        void apply(SharedPreferences.Editor r1);
    }

    static class GingerbreadEditorImpl implements EditorImpl {
        GingerbreadEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor r1) {
            r1.apply();
        }
    }

    public SharedPrefsEditorCompat() {
    }

    static {
        IMPL = new GingerbreadEditorImpl();
    }

    public static void apply(SharedPreferences.Editor r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        IMPL.apply(r1);
    }
}
