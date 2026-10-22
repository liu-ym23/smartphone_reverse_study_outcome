package com.byted.mgl.merge.service.api.privacy.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyClipboard {
    ClipData getPrimaryClip(ClipboardManager r100, String r101) throws IllegalAccessException;

    void setPrimaryClip(ClipboardManager r100, ClipData r101, String r102) throws IllegalAccessException;
}
