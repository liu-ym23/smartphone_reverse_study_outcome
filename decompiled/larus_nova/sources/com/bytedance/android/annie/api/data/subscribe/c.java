package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<T> f38406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f38407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonElement f38408c;

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ g c() {
        return f.e(this);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ char d() {
        return '.';
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement f(String r100, JsonElement r101) {
        return f.c(this, r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement h(List r100, JsonElement r101) {
        return f.d(r100, r101);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final String key() {
        return this.f38406a.key();
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final T g() {
        return this.f38407b;
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonElement a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f38408c.isJsonObject() == true) goto L7;
        return this.f38408c;
    L7:
        return f.c(this, r100, this.f38408c);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final JsonElement e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "url");
        return a(r100);
    }

    public c(g<T> r100, T r101, JsonElement r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r102, "jsonElement");
        this.f38406a = r100;
        this.f38407b = r101;
        this.f38408c = r102;
    }
}
