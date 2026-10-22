package ad8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import com.larus.bmhome.chat.layout.widget.ChatRetry;
import com.larus.bmhome.chat.layout.widget.ChatRetryWithText;
import com.larus.bmhome.chat.layout.widget.MessageSourceView;
import com.larus.bmhome.utils.c;
import com.larus.nova.R;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f3032b = null;

    /* JADX INFO: renamed from: ad8.a$a, reason: collision with other inner class name */
    public static final class C0056a {
    }

    public static final class b implements com.bytedance.nita.view.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3033a;

        public b() {
            this.f3033a = "";
        }

        @Override // com.bytedance.nita.view.b
        public final View c(Context r100, ViewGroup r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "parent");
            if (r102 != (-5)) goto L5;
            this.f3033a = "CHAT_MESSAGE_BOTTOM_SOURCE_VIEW";     // Catch: Throwable -> L20
            return new MessageSourceView(r100);
        L5:
            if (r102 != (-3)) goto L7;
            this.f3033a = "CHAT_RETRY";     // Catch: Throwable -> L20
            return new ChatRetry(r100);
        L7:
            if (r102 != (-2)) goto L9;
            this.f3033a = "CHAT_CHECK_BOX";     // Catch: Throwable -> L20
            return new ChatCheckBox(r100);
        L9:
            if (r102 == (-1)) goto L12;
            this.f3033a = "else";     // Catch: Throwable -> L20
            return LayoutInflater.from(r100).inflate(r102, r101, false);
        L12:
            this.f3033a = "CHAT_RETRY_WITH_TXT_VIEW";     // Catch: Throwable -> L20
            return new ChatRetryWithText(r100);
        L20:
            th = move-exception;
            FLogger.f375446a.e("SlotCellNitaView", " msg=" + th.getMessage());
            JSONObject r103 = new JSONObject();
            r103.put("tag", "chat_slot_cell_nita");
            r103.put(LocationMonitorConst.ERR_MSG, String.valueOf(th.getMessage()));
            r103.put("err_view", this.f3033a);
            o.f365780a.reportEvent("nita_preload_monitor", r103);
            c.a("nita_preload_monitor", r103, true);
            return new View(r100);
        }
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final String h() {
        return "chat_slot_cell_nita";
    }

    @Override // com.bytedance.nita.api.c
    public final int theme() {
        return R.style.Theme_OApp;
    }

    static {
        f3032b = CollectionsKt.mutableListOf(new Integer[]{-1, -2, -3, -5});
    }

    @Override // com.bytedance.nita.api.c
    public final int[] b() {
        return CollectionsKt.toIntArray(f3032b);
    }

    @Override // com.bytedance.nita.api.AbsNitaView, com.bytedance.nita.api.c
    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public a() {
    }

    @Override // com.bytedance.nita.api.c
    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
