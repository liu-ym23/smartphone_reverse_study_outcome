package al7;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class c {

    @SerializedName("entry_items")
    private List<b> entryItems;

    public class a {

        /* JADX INFO: renamed from: bk, reason: collision with root package name */
        @SerializedName("bk")
        private int f4166bk;

        @SerializedName("cycle_id")
        private String cycleId;

        @SerializedName("data")
        private String data;

        @SerializedName("end_time")
        private long endTime;

        @SerializedName("is_disable")
        private boolean isDisable;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private long startTime;

        @SerializedName(InvRouter.VERSION_ID)
        private int version;

        public final int a() {
            return this.f4166bk;
        }

        public final String b() {
            return this.cycleId;
        }

        public final String c() {
            return this.data;
        }

        public final long d() {
            return this.endTime;
        }

        public final String e() {
            return this.resourceId;
        }

        public final long f() {
            return this.startTime;
        }

        public final int g() {
            return this.version;
        }

        public final boolean h() {
            return this.isDisable;
        }

        public final void i(int r100) {
            this.f4166bk = r100;
        }
    }

    public class b {

        @SerializedName("entry_id")
        private String entryId;

        @SerializedName("extra")
        private String extra;

        @SerializedName("resource_items")
        private List<a> resourceItemList;

        public final String a() {
            return this.entryId;
        }

        public final String b() {
            return this.extra;
        }

        public final List<a> c() {
            return this.resourceItemList;
        }
    }

    public c() {
    }

    public final List<b> a() {
        return this.entryItems;
    }
}
