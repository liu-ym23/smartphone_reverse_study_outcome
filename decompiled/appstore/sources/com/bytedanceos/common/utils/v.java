package com.bytedanceos.common.utils;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements ValueFlow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10226b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10227a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(boolean r10) {
            WifiUpdateSettingKt.a().tryEmit(Boolean.valueOf(r10));
        }

        public a() {
        }
    }

    static {
        f10226b = new a(null);
    }

    public v(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.f10227a = r10;
    }

    public static final void a(boolean r10) {
        f10226b.a(r10);
    }

    @Override // com.bytedanceos.common.utils.ValueFlow
    public Flow values() {
        return WifiUpdateSettingKt.a();
    }
}
