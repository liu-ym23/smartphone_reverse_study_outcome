package com.bytedance.retrofit2;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: compiled from: Endpoints.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: compiled from: Endpoints.java */
    private static class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9559b;

        a(String r1, String r2) {
            this.f9558a = r1;
            this.f9559b = r2;
        }

        @Override // com.bytedance.retrofit2.k
        public String a() {
            return this.f9558a;
        }
    }

    public static k a(String r2) {
        return new a(r2, DownloadSettingKeys.BugFix.DEFAULT);
    }
}
