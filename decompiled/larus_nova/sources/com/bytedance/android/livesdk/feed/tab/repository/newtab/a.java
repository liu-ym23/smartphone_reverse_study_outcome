package com.bytedance.android.livesdk.feed.tab.repository.newtab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements xw1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f124513a;

    @Override // xw1.b
    public final String a() {
        return "new_extra_key_" + this.f124513a;
    }

    @Override // xw1.b
    public final String b() {
        return "new_tab_key_" + this.f124513a;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entrace");
        this.f124513a = r100;
    }
}
