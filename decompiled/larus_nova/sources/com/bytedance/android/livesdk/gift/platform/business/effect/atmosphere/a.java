package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.z3;
import com.bytedance.android.scope.m;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.bytedance.ies.web.jsbridge2.f<C2063a, Object> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/atmosphere/a$a;", "", "", "type", "I", "getType", "()I", "arg1", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "arg2", "b", "", "arg3", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C2063a {

        @SerializedName("arg1")
        private final int arg1;

        @SerializedName("arg2")
        private final int arg2;

        @SerializedName("arg3")
        private final String arg3;

        @SerializedName("message_type")
        private final int type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C2063a) == false) goto L14;
            C2063a r101 = (C2063a) r100;
            if (this.type == r101.type) goto L8;
            return false;
        L8:
            if (this.arg1 == r101.arg1) goto L10;
            return false;
        L10:
            if (this.arg2 == r101.arg2) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.arg3, r101.arg3) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r100 = ((((this.type * 31) + this.arg1) * 31) + this.arg2) * 31;
            String r101 = this.arg3;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Params(type=" + this.type + ", arg1=" + this.arg1 + ", arg2=" + this.arg2 + ", arg3=" + this.arg3 + ")";
        }

        public final int a() {
            return this.arg1;
        }

        public final int b() {
            return this.arg2;
        }

        public final String c() {
            return this.arg3;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(C2063a r100, CallContext r101) {
        C2063a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        i12.e r103 = o.b();
        if (r103 == null) goto L5;
        Object r104 = m.f163449e.d(r103, z3.class);
    L6:
        z3 r105 = (z3) r104;
        if (r105 == null) goto L10;
        r105.d(r102.getType(), r102.a(), r102.b(), r102.c());
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
