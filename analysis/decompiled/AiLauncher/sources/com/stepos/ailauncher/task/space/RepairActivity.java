package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import com.stepos.ailauncher.task.R$drawable;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\"\u0010!¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/task/space/RepairActivity;", "Lcom/stepos/ailauncher/sheet/S;", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "s4", "()Landroidx/fragment/app/Fragment;", "", "z4", "()Ljava/lang/String;", "f4", "", "Z3", "()Z", "L1", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "i1", "j1", "t3", "", "j2", "()I", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "y4", "(Landroid/os/Bundle;)V", "onCreate", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "B4", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RepairActivity extends com.stepos.ailauncher.sheet.S {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG_ROOT = "repair_root";
    private static final String TRACKER_PAGE_ENTRY_EVENT = "repair_room_entry";
    private static final String TRACKER_PAGE_NAME = "repair";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/task/space/RepairActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "", "TAG_ROOT", "Ljava/lang/String;", "TRACKER_PAGE_ENTRY_EVENT", "TRACKER_PAGE_NAME", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.RepairActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            C2739j.C(context, new Intent(context, (Class<?>) RepairActivity.class), null, 4, null);
            kotlin.N.a(RepairActivity.TRACKER_PAGE_ENTRY_EVENT, "repair", kotlin.collections.a.i());
        }

        public Companion() {
        }
    }

    public final void B4(Intent intent) {
        Uri data;
        String path;
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        if (!((kotlin.jvm.internal.p.d(data.getScheme(), "stepos") && kotlin.jvm.internal.p.d(data.getHost(), DidiCardProvider.MARKET_SOURCE)) || (kotlin.jvm.internal.p.d(data.getScheme(), "https") && kotlin.jvm.internal.p.d(data.getHost(), "amoo.stepos.com"))) || (path = data.getPath()) == null) {
            return;
        }
        if (La.D.X(path, "/testspace", false, 2, null)) {
            String queryParameter = data.getQueryParameter("scan_type");
            String str = "agent";
            if (queryParameter == null || (!kotlin.jvm.internal.p.d(queryParameter, "agent") && !kotlin.jvm.internal.p.d(queryParameter, "plugin"))) {
                queryParameter = null;
            }
            if (!kotlin.jvm.internal.p.d(queryParameter, "agent")) {
                if (kotlin.jvm.internal.p.d(queryParameter, "plugin")) {
                    str = C3577a2.TYPE_SKILL;
                } else {
                    String queryParameter2 = data.getQueryParameter("tab");
                    str = (queryParameter2 == null || !(kotlin.jvm.internal.p.d(queryParameter2, C3577a2.TYPE_SKILL) || kotlin.jvm.internal.p.d(queryParameter2, "agent"))) ? null : queryParameter2;
                }
            }
            String queryParameter3 = data.getQueryParameter("scan_source");
            if (queryParameter3 == null || queryParameter3.length() <= 0) {
                queryParameter3 = null;
            }
            String queryParameter4 = data.getQueryParameter("asset_id");
            if (queryParameter4 == null || queryParameter4.length() <= 0) {
                queryParameter4 = null;
            }
            boolean z10 = (queryParameter3 == null || queryParameter == null || queryParameter4 == null) ? false : true;
            C4148a.k(TAG_ROOT, "deeplink: tab=" + str + " scan=(" + queryParameter3 + Const.STR_MART_COMMA + queryParameter + Const.STR_MART_COMMA + queryParameter4 + ") hasScan=" + z10, false, 4, null);
            C3688x1 c3688x1 = C3688x1.INSTANCE;
            if (!z10) {
                queryParameter3 = null;
            }
            if (!z10) {
                queryParameter = null;
            }
            c3688x1.b(str, queryParameter3, queryParameter, z10 ? queryParameter4 : null);
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean L1() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean Z3() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public String f4() {
        String name = RepairActivity.class.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        return name;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean i1() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean j1() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public int j2() {
        if (get_layerIndex() > 1) {
            return 0;
        }
        return super.j2();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        B4(getIntent());
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        B4(intent);
    }

    @Override // com.stepos.ailauncher.sheet.S
    public Fragment s4() {
        return D0.INSTANCE.a();
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean t3() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public SheetExitAnim x1() {
        return SheetExitAnim.SLIDE_DOWN;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void y4(Bundle savedInstanceState) {
        M1().setPadding(0, 0, 0, M1().getPaddingBottom());
        Y1().setBackgroundResource(R$drawable.bg_repair_panel);
    }

    @Override // com.stepos.ailauncher.sheet.S
    public String z4() {
        return TAG_ROOT;
    }
}
