package com.stepos.ailauncher.chat.sheet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatEntry;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import h8.C4148a;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/BringLauncherTaskFrontActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BringLauncherTaskFrontActivity extends Activity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_ENTRY = "bring_entry";
    public static final String EXTRA_HEIGHT_MODE = "bring_height_mode";
    public static final String EXTRA_SESSION_ID = "bring_session_id";
    public static final String EXTRA_TASK_ID = "launcher_task_id";
    private static final String TAG = "BringLauncherFront";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/BringLauncherTaskFrontActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "launcherTaskId", "Lcom/stepos/ailauncher/chat/activity/ChatEntry;", "entry", "", "sessionId", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "heightMode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;ILcom/stepos/ailauncher/chat/activity/ChatEntry;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;)V", "TAG", "Ljava/lang/String;", "EXTRA_TASK_ID", "EXTRA_ENTRY", "EXTRA_SESSION_ID", "EXTRA_HEIGHT_MODE", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.sheet.BringLauncherTaskFrontActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, int i10, ChatEntry chatEntry, String str, SheetHeightMode sheetHeightMode, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                chatEntry = ChatEntry.SESSION_CENTER;
            }
            ChatEntry chatEntry2 = chatEntry;
            if ((i11 & 8) != 0) {
                str = null;
            }
            String str2 = str;
            if ((i11 & 16) != 0) {
                sheetHeightMode = SheetHeightMode.HALF_EXPANDABLE;
            }
            companion.a(context, i10, chatEntry2, str2, sheetHeightMode);
        }

        public final void a(Context context, int launcherTaskId, ChatEntry entry, String sessionId, SheetHeightMode heightMode) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(entry, "entry");
            kotlin.jvm.internal.p.i(heightMode, "heightMode");
            Intent intent = new Intent(context, (Class<?>) BringLauncherTaskFrontActivity.class);
            intent.putExtra(BringLauncherTaskFrontActivity.EXTRA_TASK_ID, launcherTaskId);
            intent.putExtra(BringLauncherTaskFrontActivity.EXTRA_ENTRY, entry.getWireValue());
            if (sessionId != null && sessionId.length() != 0) {
                intent.putExtra(BringLauncherTaskFrontActivity.EXTRA_SESSION_ID, sessionId);
            }
            intent.putExtra(BringLauncherTaskFrontActivity.EXTRA_HEIGHT_MODE, heightMode.getWireValue());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(8388608);
            intent.addFlags(65536);
            context.getApplicationContext().startActivity(intent);
            C4148a.k(BringLauncherTaskFrontActivity.TAG, "startOpenDesktop launcherTaskId=" + launcherTaskId + " entry=" + entry, false, 4, null);
        }

        public Companion() {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C2740k c2740k = C2740k.INSTANCE;
        if (c2740k.b() == null) {
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            c2740k.e(new i0(applicationContext, null, 2, null));
        }
        Integer numValueOf = Integer.valueOf(getIntent().getIntExtra(EXTRA_TASK_ID, -1));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : c2740k.a();
        ChatEntry chatEntryB = ChatEntry.INSTANCE.b(getIntent().getStringExtra(EXTRA_ENTRY));
        String stringExtra = getIntent().getStringExtra(EXTRA_SESSION_ID);
        String str = (stringExtra == null || stringExtra.length() <= 0) ? null : stringExtra;
        SheetHeightMode sheetHeightModeA = SheetHeightMode.INSTANCE.a(getIntent().getIntExtra(EXTRA_HEIGHT_MODE, SheetHeightMode.HALF_EXPANDABLE.getWireValue()));
        C4148a.k(TAG, "onCreate openDesktop taskId=" + iIntValue + " entry=" + chatEntryB + " height=" + sheetHeightModeA, false, 4, null);
        C2739j.l(this, chatEntryB, str, sheetHeightModeA, false, iIntValue, false, false, 208, null);
        if (iIntValue > 0) {
            e0 e0Var = e0.INSTANCE;
            Context applicationContext2 = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext2, "getApplicationContext(...)");
            e0Var.b(applicationContext2, iIntValue, false, true);
        } else {
            e0 e0Var2 = e0.INSTANCE;
            Context applicationContext3 = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext3, "getApplicationContext(...)");
            e0Var2.i(applicationContext3, false);
        }
        finish();
    }
}
