package z0;

import android.content.Context;
import android.content.IntentFilter;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: z0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0993a extends AbstractC0996d {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f16392g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0993a(Context context, E0.a taskExecutor, int i4) {
        super(context, taskExecutor);
        this.f16392g = i4;
        if (i4 == 1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
            super(context, taskExecutor);
        } else if (i4 != 2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
            super(context, taskExecutor);
        }
    }

    @Override // z0.AbstractC0998f
    public final /* bridge */ /* synthetic */ Object a() {
        switch (this.f16392g) {
        }
        return f();
    }

    @Override // z0.AbstractC0996d
    public final IntentFilter e() {
        switch (this.f16392g) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.CHARGING");
                intentFilter.addAction("android.os.action.DISCHARGING");
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean f() {
        /*
            r9 = this;
            int r0 = r9.f16392g
            r1 = -1
            java.lang.String r2 = "status"
            java.lang.String r3 = "getInitialState - null intent received"
            java.lang.String r4 = "android.intent.action.BATTERY_CHANGED"
            r5 = 0
            r6 = 1
            r7 = 0
            android.content.Context r8 = r9.f16398b
            switch(r0) {
                case 0: goto L86;
                case 1: goto L4d;
                default: goto L11;
            }
        L11:
            android.content.IntentFilter r9 = r9.e()
            android.content.Intent r9 = r8.registerReceiver(r7, r9)
            if (r9 == 0) goto L40
            java.lang.String r0 = r9.getAction()
            if (r0 != 0) goto L22
            goto L40
        L22:
            java.lang.String r9 = r9.getAction()
            if (r9 == 0) goto L48
            int r0 = r9.hashCode()
            r1 = -1181163412(0xffffffffb998e06c, float:-2.9158907E-4)
            if (r0 == r1) goto L42
            r1 = -730838620(0xffffffffd47049a4, float:-4.1281105E12)
            if (r0 == r1) goto L37
            goto L48
        L37:
            java.lang.String r0 = "android.intent.action.DEVICE_STORAGE_OK"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L40
            goto L48
        L40:
            r5 = r6
            goto L48
        L42:
            java.lang.String r0 = "android.intent.action.DEVICE_STORAGE_LOW"
            boolean r9 = r9.equals(r0)
        L48:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L4d:
            android.content.IntentFilter r9 = new android.content.IntentFilter
            r9.<init>(r4)
            android.content.Intent r9 = r8.registerReceiver(r7, r9)
            if (r9 != 0) goto L64
            s0.t r9 = s0.t.d()
            java.lang.String r0 = z0.AbstractC0995c.f16394a
            r9.b(r0, r3)
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L85
        L64:
            int r0 = r9.getIntExtra(r2, r1)
            java.lang.String r2 = "level"
            int r2 = r9.getIntExtra(r2, r1)
            java.lang.String r3 = "scale"
            int r9 = r9.getIntExtra(r3, r1)
            float r1 = (float) r2
            float r9 = (float) r9
            float r1 = r1 / r9
            if (r0 == r6) goto L80
            r9 = 1041865114(0x3e19999a, float:0.15)
            int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r9 <= 0) goto L81
        L80:
            r5 = r6
        L81:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
        L85:
            return r9
        L86:
            android.content.IntentFilter r9 = new android.content.IntentFilter
            r9.<init>(r4)
            android.content.Intent r9 = r8.registerReceiver(r7, r9)
            if (r9 != 0) goto L9d
            s0.t r9 = s0.t.d()
            java.lang.String r0 = z0.AbstractC0994b.f16393a
            r9.b(r0, r3)
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto Lac
        L9d:
            int r9 = r9.getIntExtra(r2, r1)
            r0 = 2
            if (r9 == r0) goto La7
            r0 = 5
            if (r9 != r0) goto La8
        La7:
            r5 = r6
        La8:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
        Lac:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.C0993a.f():java.lang.Boolean");
    }
}
