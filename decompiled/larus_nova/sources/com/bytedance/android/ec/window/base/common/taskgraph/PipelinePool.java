package com.bytedance.android.ec.window.base.common.taskgraph;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class PipelinePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f49173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<PipelineId, b<?>> f49174b = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/taskgraph/PipelinePool$PipelineId;", "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "", "id", "J", "<init>", "(J)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PipelineId implements Serializable {
        public static final a Companion = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final long f49175id;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public int hashCode() {
            long r100 = this.f49175id;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public PipelineId(long r100) {
            this.f49175id = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(PipelineId.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L18;
            if (this.f49175id == ((PipelineId) r100).f49175id) goto L16;
            return false;
        L16:
            return true;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.common.taskgraph.PipelinePool.PipelineId");
        L8:
            r101 = null;
            goto L10
        }
    }

    static {
        f49173a = new AtomicLong(Long.MIN_VALUE);
        f49174b = new ConcurrentHashMap();
    }
}
