package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.profit.dress.config.DressResource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class w<T extends DressResource> {

    public static final class a extends w<DressResource> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResourceLoadErrorType f87096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f87097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f87098c;

        public a(String r100, ResourceLoadErrorType r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "dressId");
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f87096a = r101;
            this.f87097b = r102;
            this.f87098c = null;
        }
    }

    public static final class b<T extends DressResource> extends w<T> {
        public b(String r100, DressResource r101) {
            Intrinsics.checkNotNullParameter(r100, "dressId");
            Intrinsics.checkNotNullParameter(r101, "resource");
        }
    }

    public static final class c<T extends DressResource> extends w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DressResource f87099a;

        public c(String r100, DressResource r101) {
            Intrinsics.checkNotNullParameter(r100, "dressId");
            Intrinsics.checkNotNullParameter(r101, "resource");
            this.f87099a = r101;
        }
    }

    public w() {
    }
}
