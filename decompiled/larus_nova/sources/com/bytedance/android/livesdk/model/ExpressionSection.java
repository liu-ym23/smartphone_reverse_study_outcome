package com.bytedance.android.livesdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ExpressionSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f153912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f153913b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/model/ExpressionSection$EnterType;", "", "CLICK", "DRAW", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EnterType extends Enum<EnterType> {
        public static final EnterType CLICK = null;
        public static final EnterType DRAW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnterType[] f153914a = null;

        static {
            EnterType r100 = new EnterType("CLICK", 0);
            CLICK = r100;
            EnterType r101 = new EnterType("DRAW", 1);
            DRAW = r101;
            f153914a = new EnterType[]{r100, r101};
        }

        public static EnterType valueOf(String r100) {
            return (EnterType) r27.a.a(EnterType.class, r100);
        }

        public static EnterType[] values() {
            return (EnterType[]) f153914a.clone();
        }

        public EnterType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ExpressionSection() {
    }

    public boolean a() {
        return false;
    }

    public abstract int b();

    public CharSequence c() {
        return null;
    }

    public void d() {
    }

    public void e(EnterType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    public final void f(boolean r100) {
        this.f153912a = r100;
        if (r100 == false) goto L7;
        g r101 = this.f153913b;
        if (r101 == null) goto L11;
        r101.show();
        return;
    L11:
        return;
    L7:
        g r102 = this.f153913b;
        if (r102 == null) goto L13;
        r102.hide();
        return;
    }
}
