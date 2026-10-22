package com.bytedance.android.livesdk.revenue.sti;

import android.view.View;
import com.bytedance.android.livesdk.revenue.service.sti.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xr2.h;

/* JADX INFO: loaded from: classes11.dex */
public interface IRevIconModel<STATE> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/sti/IRevIconModel$EntryEvent;", "", "Start", "End", "Skip", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EntryEvent extends Enum<EntryEvent> {
        public static final EntryEvent End = null;
        public static final EntryEvent Skip = null;
        public static final EntryEvent Start = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntryEvent[] f157512a = null;

        static {
            EntryEvent r100 = new EntryEvent("Start", 0);
            Start = r100;
            EntryEvent r101 = new EntryEvent("End", 1);
            End = r101;
            EntryEvent r102 = new EntryEvent("Skip", 2);
            Skip = r102;
            f157512a = new EntryEvent[]{r100, r101, r102};
        }

        public static EntryEvent valueOf(String r100) {
            return (EntryEvent) r27.a.a(EntryEvent.class, r100);
        }

        public static EntryEvent[] values() {
            return (EntryEvent[]) f157512a.clone();
        }

        public EntryEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f157513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f157514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f157515c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f157513a, r101.f157513a) == true) goto L8;
            return false;
        L8:
            if (this.f157514b == r101.f157514b) goto L10;
            return false;
        L10:
            if (this.f157515c == r101.f157515c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            View r100 = this.f157513a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            long r102 = this.f157514b;
            int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            boolean r104 = this.f157515c;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "EntryView(view=" + this.f157513a + ", displayDuration=" + this.f157514b + ", clipToBounds=" + this.f157515c + ")";
        }

        public /* synthetic */ a(View r100, long r101, int r102) {
            if ((r102 & 2) == 0) goto L6;
            r101 = 1000;
        L6:
            if ((r102 & 4) == 0) goto L8;
            boolean r103 = true;
        L9:
            this(r100, r101, r103);
            return;
        L8:
            r103 = false;
            goto L9
        }

        public a(View r100, long r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f157513a = r100;
            this.f157514b = r101;
            this.f157515c = r102;
        }
    }

    void a(a r100, EntryEvent r101);

    void c(STATE r100, STATE r101, h r102);

    void d(d r100);

    a getEntryViewForState(STATE r100, STATE r101);

    int getIconHeight();

    int getIconWidth();

    STATE getInitialState();

    int getTypeId();

    h getViewForState(STATE r100);

    void onAppear();

    void onClick();

    void onDestroy();

    void onHideTempState();

    void onShowTempState(int r100);

    void setIconHeight(int r100);

    void setIconWidth(int r100);
}
