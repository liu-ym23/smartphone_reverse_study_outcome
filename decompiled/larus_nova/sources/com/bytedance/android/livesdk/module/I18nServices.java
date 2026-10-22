package com.bytedance.android.livesdk.module;

import com.bytedance.android.live.i18n.I18nService;

/* JADX INFO: loaded from: classes11.dex */
public class I18nServices implements I18nService {
    public I18nServices() {
    }

    @Override // com.bytedance.android.live.i18n.I18nService
    public String getI18nString(String r100) {
        return com.bytedance.android.live.core.i18n.a.b().a(r100);
    }
}
