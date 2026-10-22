package y0;

import B0.r;
import kotlin.jvm.internal.Intrinsics;
import s0.u;
import z0.AbstractC0998f;
import z0.C0993a;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0985a extends d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16163b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16164c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0985a(C0993a tracker) {
        super(tracker);
        this.f16163b = 1;
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f16164c = 5;
    }

    @Override // y0.d
    public final int a() {
        return this.f16164c;
    }

    @Override // y0.d
    public final boolean b(r workSpec) {
        switch (this.f16163b) {
            case 0:
                Intrinsics.checkNotNullParameter(workSpec, "workSpec");
                return workSpec.f176j.f14186b;
            case 1:
                Intrinsics.checkNotNullParameter(workSpec, "workSpec");
                return workSpec.f176j.f14188d;
            case 2:
                Intrinsics.checkNotNullParameter(workSpec, "workSpec");
                return workSpec.f176j.f14185a == u.f14215b;
            case 3:
                Intrinsics.checkNotNullParameter(workSpec, "workSpec");
                u uVar = workSpec.f176j.f14185a;
                return uVar == u.f14216c || uVar == u.f14219f;
            default:
                Intrinsics.checkNotNullParameter(workSpec, "workSpec");
                return workSpec.f176j.f14189e;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0025. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0031. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
    @Override // y0.d
    public final boolean c(Object obj) {
        int i4 = this.f16163b;
        switch (i4) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                switch (i4) {
                }
                return !zBooleanValue;
            case 1:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                switch (i4) {
                }
                return !zBooleanValue2;
            case 2:
                return d((x0.d) obj);
            case 3:
                return d((x0.d) obj);
            default:
                boolean zBooleanValue3 = ((Boolean) obj).booleanValue();
                switch (i4) {
                }
                return !zBooleanValue3;
        }
    }

    public final boolean d(x0.d value) {
        switch (this.f16163b) {
            case 2:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.f15871a && value.f15872b) {
                    break;
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.f15871a && !value.f15873c) {
                    break;
                }
                break;
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0985a(AbstractC0998f tracker, int i4) {
        super(tracker);
        this.f16163b = i4;
        if (i4 == 2) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            super(tracker);
            this.f16164c = 7;
        } else if (i4 == 3) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            super(tracker);
            this.f16164c = 7;
        } else if (i4 != 4) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            this.f16164c = 6;
        } else {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            super(tracker);
            this.f16164c = 9;
        }
    }
}
