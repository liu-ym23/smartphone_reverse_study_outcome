package com.bytedance.android.livesdk.arch.task;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class RecordTask extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f103865e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/arch/task/RecordTask$Type;", "", "Pending", "Show", "Dismiss", "Wait", "toolbarservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type Dismiss = null;
        public static final Type Pending = null;
        public static final Type Show = null;
        public static final Type Wait = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f103866a = null;

        static {
            Type r100 = new Type("Pending", 0);
            Pending = r100;
            Type r101 = new Type("Show", 1);
            Show = r101;
            Type r102 = new Type("Dismiss", 2);
            Dismiss = r102;
            Type r103 = new Type("Wait", 3);
            Wait = r103;
            f103866a = new Type[]{r100, r101, r102, r103};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f103866a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final Type getType() {
        return this.f103865e;
    }

    public RecordTask(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        super(TaskId.Record);
        this.f103865e = r100;
    }

    @Override // com.bytedance.android.livesdk.arch.task.a
    public final void f(e r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        com.bytedance.android.livesdk.arch.comp.b r101 = r100.d();
        com.bytedance.android.livesdk.arch.comp.h r102 = (com.bytedance.android.livesdk.arch.comp.h) r101;
        com.bytedance.android.livesdk.arch.record.a<com.bytedance.android.livesdk.arch.comp.b> r103 = r100.a().recordManager(r102.p());
        Type r104 = this.f103865e;
        int r105 = k.f103896a[r104.ordinal()];
        if (r105 != 1) goto L5;
        r103.l(r102);
    L15:
        a.d(this);
        return;
    L5:
        if (r105 != 2) goto L7;
        r103.b(r102);
        r103.e(r102);
        r103.d(r102);
        r103.k(r102);
        goto L15
    L7:
        if (r105 != 3) goto L9;
        r103.b(r102);
        r103.e(r102);
        r103.d(r102);
        goto L15
    L9:
        if (r105 != 4) goto L15;
        r103.b(r102);
        r103.d(r102);
        r103.e(r102);
        r103.i(r102);
        goto L15
    }
}
