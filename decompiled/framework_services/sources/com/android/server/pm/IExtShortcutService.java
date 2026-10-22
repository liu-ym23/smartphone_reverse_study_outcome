package com.android.server.pm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtShortcutService extends IExtBase {
    default boolean allowModifyShortcut(int callingUid) {
        return false;
    }
}
