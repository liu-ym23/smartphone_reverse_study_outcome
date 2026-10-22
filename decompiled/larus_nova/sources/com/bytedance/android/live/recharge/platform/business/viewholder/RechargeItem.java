package com.bytedance.android.live.recharge.platform.business.viewholder;

import com.bytedance.android.live.recharge.deal.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class RechargeItem {

    public static final class CustomItem extends RechargeItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f90223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f90224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f90225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Mode f90226d;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/viewholder/RechargeItem$CustomItem$Mode;", "", "INPUT", "DIAMOND", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum Mode extends Enum<Mode> {
            public static final Mode DIAMOND = null;
            public static final Mode INPUT = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Mode[] f90227a = null;

            static {
                Mode r100 = new Mode("INPUT", 0);
                INPUT = r100;
                Mode r101 = new Mode("DIAMOND", 1);
                DIAMOND = r101;
                f90227a = new Mode[]{r100, r101};
            }

            public static Mode valueOf(String r100) {
                return (Mode) r27.a.a(Mode.class, r100);
            }

            public static Mode[] values() {
                return (Mode[]) f90227a.clone();
            }

            public Mode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public CustomItem() {
            this(0);
        }

        public CustomItem(int r100) {
            Mode r101 = Mode.INPUT;
            Intrinsics.checkNotNullParameter("", "description");
            Intrinsics.checkNotNullParameter(r101, "mode");
            this.f90223a = 0;
            this.f90224b = 100;
            this.f90225c = "";
            this.f90226d = r101;
        }
    }

    public static final class a extends RechargeItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f90228a;

        public a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "deal");
            this.f90228a = r100;
        }
    }

    public RechargeItem() {
    }
}
