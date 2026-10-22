package com.bytedanceos.appstore.buss.viewmodels.repository;

import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.CommonAppCommentEntity;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonAppCommentsRepository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9017b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f9018c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f9019a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final CommonAppCommentsRepository a() {
            return (CommonAppCommentsRepository) CommonAppCommentsRepository.a().getValue();
        }

        public a() {
        }
    }

    static {
        f9017b = new a(null);
        f9018c = b.b(CommonAppCommentsRepository$Companion$instance$2.INSTANCE);
    }

    public /* synthetic */ CommonAppCommentsRepository(DefaultConstructorMarker r10) {
        this();
    }

    public static final /* synthetic */ Lazy a() {
        return f9018c;
    }

    public final MutableLiveData b() {
        return (MutableLiveData) this.f9019a.getValue();
    }

    public final void c(String r10, Float r11, Integer r12, Integer r13) {
        q.g(r10, "packageName");
        b().m(new CommonAppCommentEntity(r10, r11, r12, r13));
    }

    public CommonAppCommentsRepository() {
        this.f9019a = b.b(CommonAppCommentsRepository$commonAppCommentsLiveData$2.INSTANCE);
    }
}
