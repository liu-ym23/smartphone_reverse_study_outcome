package com.bytedanceos.appstore.buss.viewmodels.repository;

import androidx.lifecycle.MutableLiveData;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class WishAppRepository {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9039c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f9040d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f9041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f9042b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final WishAppRepository a() {
            return (WishAppRepository) WishAppRepository.a().getValue();
        }

        public a() {
        }
    }

    static {
        f9039c = new a(null);
        f9040d = b.b(WishAppRepository$Companion$instance$2.INSTANCE);
    }

    public /* synthetic */ WishAppRepository(DefaultConstructorMarker r10) {
        this();
    }

    public static final /* synthetic */ Lazy a() {
        return f9040d;
    }

    public final MutableLiveData b() {
        return (MutableLiveData) this.f9041a.getValue();
    }

    public final MutableLiveData c() {
        return (MutableLiveData) this.f9042b.getValue();
    }

    public WishAppRepository() {
        this.f9041a = b.b(WishAppRepository$commonGetWishAppLiveData$2.INSTANCE);
        this.f9042b = b.b(WishAppRepository$commonPostWishAppLiveData$2.INSTANCE);
    }
}
