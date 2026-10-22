package com.bytedanceos.appstore.buss.viewmodels.repository;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.GiftMyEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.b;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;
import kotlinx.coroutines.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class MyGiftRepository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9032b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f9033c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f9034a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final MyGiftRepository a() {
            return (MyGiftRepository) MyGiftRepository.a().getValue();
        }

        public a() {
        }
    }

    static {
        f9032b = new a(null);
        f9033c = b.b(MyGiftRepository$Companion$instance$2.INSTANCE);
    }

    public /* synthetic */ MyGiftRepository(DefaultConstructorMarker r10) {
        this();
    }

    public static final /* synthetic */ Lazy a() {
        return f9033c;
    }

    public final void b(GiftMyEntity r10) {
        q.g(r10, "entity");
        List r11 = (List) this.f9034a.e();
        if (r11 != null) goto L5;
        r11 = new ArrayList();
    L5:
        r11.add(0, r10);
        this.f9034a.m(r11);
    }

    public final MutableLiveData c() {
        return this.f9034a;
    }

    public final void d(List r10) {
        MutableLiveData r11 = this.f9034a;
        if (r10 == null) goto L5;
        List r12 = b0.z0(r10);
    L6:
        r11.m(r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void e(String r10) {
        q.g(r10, "id");
        h.d(y0.f21772a, null, null, new MyGiftRepository$removeGiftById$1(this, r10, null), 3, null);
    }

    public MyGiftRepository() {
        this.f9034a = new MutableLiveData();
    }
}
